<template>
  <div style="height: 100%; width: 100%">
    <v-container
      style="
        height: 100%;
        width: 100%;
        padding: 0px;
        justify-content: space-between;
        flex-direction: column;
        display: flex;
      "
    >
      <v-row id="message-header">
        <p style="vertical-align: middle">Chat</p>
        <v-icon
          id="message-header-icon"
          icon="mdi-account-group"
          size="30px"
        ></v-icon>
      </v-row>

      <v-row style="overflow-y: auto" id="message-content">
        <ChatMessage
          style="flex-wrap: wrap"
          v-for="(msg, index) in messageStore.message"
          :key="index"
          :msg="msg"
        />
      </v-row>

      <v-row id="message-sender">
        <form
          style="width: 100%; align-items: center"
          id="message-sender-form"
          @submit.prevent="submitMessage"
        >
          <div
            style="
              display: flex;
              justify-content: space-evenly;
              align-self: center;
            "
          >
            <input
              style="color: white"
              type="text"
              v-model="message"
              placeholder="type message :)"
            />
            <div id="button-box" style="margin-right: -20px">
              <v-icon color="white">mdi-send mdi-rotate-315 </v-icon>
            </div>
          </div>
        </form>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import ChatMessage from "@/components/ChatMessage.vue";
import { useMessageStore } from "@/store/message";

export default {
  name: "VideoMessage",
  components: { ChatMessage },
  setup() {
    const messageStore = useMessageStore();
    return { messageStore };
  },
  data() {
    return {
      message: "",
    };
  },
  methods: {
    submitMessage() {
      const msgData = {
        data: this.message,
        from: "",
      };
      this.messageStore.message.push(msgData);
      console.log(this.message);
      this.$emit("handleMessage", this.message);
      this.message = "";
    },
  },
};
</script>

<style scoped>
.v-row {
  margin: 0px;
}

#button-box {
  display: flex;
  box-sizing: border-box;
  height: 45px;
  width: 85px;
  background: #0e0f28;
  border: 2px solid #043e4b;
  border-radius: 10px;
  margin-right: 16px;
  justify-content: center;
  align-items: center;
}

#message-header-icon {
  margin-left: auto;
  margin-top: auto;
  margin-bottom: auto;
}

#message-header {
  color: white;
  padding: 14px 7px 0px 43px;
  font-style: normal;
  font-size: 40px;
  max-height: 90px;
  justify-content: center;
  align-items: center;
}

#message-sender {
  box-sizing: border-box;

  margin: 0 33px 27px 23px;
  background: #0e0f28;
  border: 2px solid #043e4b;
  border-radius: 10px;
  justify-content: center;
  align-items: center;
}

#message-content {
  flex-grow: 10;
}
</style>
