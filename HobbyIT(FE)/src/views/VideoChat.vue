<template>
  <div>

    <v-container>
      <v-row>
        <v-col id="background" :style="{height: computedHeight + 'px'}"></v-col>
        <v-col id="leftSidebar" :style="{height: computedHeight + 'px'}">

          <v-icon icon="mdi-microphonea" size="36"></v-icon>
          <v-icon color="white" icon="mdi-microphone" size="36"></v-icon>
          <v-icon color="white" icon="mdi-video" size="36"></v-icon>
          <v-icon color="white" icon="mdi-monitor" size="36"></v-icon>
          <v-btn style="background-color: red; color: white"  icon="mdi-phone-off" @click="window.open('','_self').close()"></v-btn>
          <v-icon color="white" icon="mdi-pencil-box" size="36"></v-icon>
          <v-icon color="white" icon="mdi-cog-outline" size="36"></v-icon>
          <v-icon color="white" icon="mdi-creation" size="36"></v-icon>
          <v-icon icon="mdi-microphonea" size="24"></v-icon>
        </v-col>
        <v-row id="circle1"/>
        <v-row id="circle2"/>
        <v-col id="videoList" :style="{height: computedHeight + 'px'}">
          <v-row style="margin: 0; height: 126px">
            <h1 id="title" @click="joinSession()">John, 나 여행가고 싶어</h1>
          </v-row>
          <v-row id="video-container" style="height: 757px; margin: 0; align-items: center; justify-content: center">
            <user-video v-for="sub in subscribers"  :stream-manager="sub">
<!--            추가 바람-->
            </user-video>

          </v-row>
        </v-col>
        <v-col id="rightSidebar" :style="{height: computedHeight + 'px'}">

        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import axios from "axios";
import { OpenVidu } from "openvidu-browser";
import UserVideo from "@/components/UserVideo.vue";
import {useAppStore} from "@/store/app";

axios.defaults.headers.post["Content-Type"] = "application/json";
const APPLICATION_SERVER_URL = process.env.NODE_ENV === 'production' ? '' : 'http://localhost:5000/';
export default {
  setup(){
    const appStore = useAppStore()
    return {appStore}
  },
  name: "VideoChat",
  components: {UserVideo},
  data() {
    return {
      windowHeight: window.innerHeight,
      // for openvidu
      OV: undefined,
      session: undefined,
      mainStreamManager: undefined,
      publisher: undefined,
      subscribers: [],
      // Join form
      mySessionId: "SessionA",
      myUserName: "Participant" + Math.floor(Math.random() * 100),
    };
  },
  mounted() {
    window.onresize = () => {
      this.windowHeight = window.innerHeight;
    };
    this.joinSession()
  },
  computed: {
    computedHeight() {
      console.log(this.windowHeight);
      return this.windowHeight - 59;
    },
    isOne() {
      return (this.subscribers.length === 0);
    },
    isTwo() {
      return (this.subscribers.length === 1);
    },
    isBelowFour() {
      return (2 <= this.subscribers.length) && (this.subscribers.length < 4);
    },
    isBelowEight() {
      return (4 <= this.subscribers.length) && (this.subscribers.length < 8);
    },
    isBelowSixteen() {
      return (8 <= this.subscribers.length) && (this.subscribers.length < 16);
    },
    baseUnit(){
      if(this.isOne){
        return 200
      }else if(this.isTwo || this.isBelowFour){
        return 160
      }else if(this.isBelowEight){
        return 100
      }else{
        return 80
      }
    }
  },
  watch :{
    baseUnit: function (newVal,oldVal){
      this.appStore.baseUnit = newVal;
    }
  },
  methods:{
    joinSession() {
      // --- 1) Get an OpenVidu object ---
      this.OV = new OpenVidu();
      // --- 2) Init a session ---
      this.session = this.OV.initSession();
      // --- 3) Specify the actions when events take place in the session ---
      // On every new Stream received...
      this.session.on("streamCreated", ({ stream }) => {
        const subscriber = this.session.subscribe(stream);
        this.subscribers.push(subscriber);
      });
      // On every Stream destroyed...
      this.session.on("streamDestroyed", ({ stream }) => {
        const index = this.subscribers.indexOf(stream.streamManager, 0);
        if (index >= 0) {
          this.subscribers.splice(index, 1);
        }
      });
      // On every asynchronous exception...
      this.session.on("exception", ({ exception }) => {
        console.warn(exception);
      });
      // --- 4) Connect to the session with a valid user token ---
      // Get a token from the OpenVidu deployment
      this.getToken(this.mySessionId).then((token) => {
        // First param is the token. Second param can be retrieved by every user on event
        // 'streamCreated' (property Stream.connection.data), and will be appended to DOM as the user's nickname
        this.session.connect(token, { clientData: this.myUserName })
          .then(() => {
            // --- 5) Get your own camera stream with the desired properties ---
            // Init a publisher passing undefined as targetElement (we don't want OpenVidu to insert a video
            // element: we will manage it on our own) and with the desired properties
            let publisher = this.OV.initPublisher(undefined, {
              audioSource: undefined, // The source of audio. If undefined default microphone
              videoSource: undefined, // The source of video. If undefined default webcam
              publishAudio: true, // Whether you want to start publishing with your audio unmuted or not
              publishVideo: true, // Whether you want to start publishing with your video enabled or not
              resolution: "600x400", // The resolution of your video
              frameRate: 30, // The frame rate of your video
              insertMode: "APPEND", // How the video is inserted in the target element 'video-container'
              mirror: false, // Whether to mirror your local video or not
            });

            // Set the main video in the page to display our webcam and store our Publisher
            this.mainStreamManager = publisher;
            this.publisher = publisher;
            // --- 6) Publish your stream ---
            this.session.publish(this.publisher);
          })
          .catch((error) => {
            console.log("There was an error connecting to the session:", error.code, error.message);
          });
      });
      window.addEventListener("beforeunload", this.leaveSession);
    },

    leaveSession() {
      // --- 7) Leave the session by calling 'disconnect' method over the Session object ---
      if (this.session) this.session.disconnect();
      // Empty all properties...
      this.session = undefined;
      this.mainStreamManager = undefined;
      this.publisher = undefined;
      this.subscribers = [];
      this.OV = undefined;
      // Remove beforeunload listener
      window.removeEventListener("beforeunload", this.leaveSession);
    },

    updateMainVideoStreamManager(stream) {
      if (this.mainStreamManager === stream) return;
      this.mainStreamManager = stream;
    },

    async getToken(mySessionId) {
      const sessionId = await this.createSession(mySessionId);
      return await this.createToken(sessionId);
    },
    async createSession(sessionId) {
      const response = await axios.post(APPLICATION_SERVER_URL + 'api/sessions', { customSessionId: sessionId }, {
        headers: { 'Content-Type': 'application/json', },
      });
      return response.data; // The sessionId
    },
    async createToken(sessionId) {
      const response = await axios.post(APPLICATION_SERVER_URL + 'api/sessions/' + sessionId + '/connections', {}, {
        headers: { 'Content-Type': 'application/json', },
      });
      return response.data; // The token
    },

  },
};
</script>

<style scoped>

#leftSidebar {
  background-color: #0e0f28;
  flex-direction: column;
  justify-content: space-evenly;
  align-items: center;
  display: flex;
  position: absolute;
  top: 59px;
  left: 0px;
  width: 126px;
  padding: 0px;
  margin: 0px;
  border-radius: 0 50px 50px 0;
  z-index: 4;
  opacity: 1;
}

#videoList {
  position: absolute;
  top: 59px;
  left: 126px;
  z-index: 5;
  width: 1286px;
  padding: 0px;
  margin: 0px;
}

#rightSidebar {
  position: absolute;
  top: 59px;
  right: 0px;
  background-color: #0e0f28;
  width: 483px;
  padding: 0px;
  margin: 0px;
  border-radius: 50px 0 0 0;
  z-index: 4;
}

#background {
  position: absolute;
  top: 59px;
  right: 0px;
  background-color: black;
  width: 100%;
  padding: 0px;
  margin: 0px;
  z-index: 1;
}

#circle1 {
  position: absolute;
  width: 700px;
  height: 700px;
  left: 21px;
  top: -226px;
  border-radius: 350px;
  z-index: 2;
  box-shadow: 0px 4px 250px #EE49FD, inset 0px 4px 250px #642EFE;
  -webkit-box-shadow: 0px 4px 250px #EE49FD, inset 0px 4px 250px #642EFE;
}

#circle2 {
  position: absolute;
  width: 700px;
  height: 700px;
  left: 839px;
  top: 604px;
  z-index: 2;
  border-radius: 350px;
  background: #000101;
  box-shadow: 0px 4px 250px #FFF16A, inset 0px 4px 250px #FF4066;
}

#title {
  background: linear-gradient(180deg, #FFFFFF 0%, #642EFE 100%);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  background-clip: text;
  text-fill-color: transparent;
  font-style: normal;
  font-weight: 700;
  font-size: 40px;
  line-height: 53px;
  display: flex;
  align-items: center;
  margin-left: 104px;
  z-index: 0;
}
video{
  height: 300px;
  width: 200px`;
}

</style>
