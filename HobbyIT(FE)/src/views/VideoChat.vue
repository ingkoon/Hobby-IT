<template>
  <div>

    <v-container>
      <v-row>
        <v-col id="background" :style="{height: computedHeight + 'px'}"></v-col>
        <v-col id="leftSidebar" :style="{height: computedHeight + 'px'}">

          <v-icon icon="mdi-microphonea" size="24"></v-icon>
          <v-icon color="white" icon="mdi-microphone" size="24"></v-icon>
          <v-icon color="white" icon="mdi-video" size="24"></v-icon>
          <v-icon color="white" icon="mdi-monitor" size="24"></v-icon>
          <v-icon color="white" icon="mdi-phone-off" size="24"></v-icon>
          <v-icon color="white" icon="mdi-pencil-box" size="24"></v-icon>
          <v-icon color="white" icon="mdi-cog-outline" size="24"></v-icon>
          <v-icon color="white" icon="mdi-creation" size="24"></v-icon>
          <v-icon icon="mdi-microphonea" size="24"></v-icon>
        </v-col>
        <v-row id="circle1"/>
        <v-row id="circle2"/>
        <v-col id="videoList" :style="{height: computedHeight + 'px'}">
          <v-row style="margin: 0; height: 126px">
            <h1 id="title">John, 나 여행가고 싶어</h1>
          </v-row>
          <v-row v-if="one" style="margin:0;height: 100%">

          </v-row>
        </v-col>
        <v-col id="rightSidebar" :style="{height: computedHeight + 'px'}">

        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
export default {
  name: "VideoChat",
  data() {
    return {
      windowHeight: window.innerHeight,
      publisher: undefined,
      subscribers: [],
    };
  },
  mounted() {
    window.onresize = () => {
      this.windowHeight = window.innerHeight;
    };
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
    }
  }
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

</style>
