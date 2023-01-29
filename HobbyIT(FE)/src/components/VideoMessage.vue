<template>
  <div style="height: 100%; width: 100%">
    <v-container
      style="height: 100%; width: 100%; padding: 0px; justify-content: space-between;flex-direction: column;display: flex">
      <v-row id="message-header">
        <p style="vertical-align: middle">Chat</p>
        <v-icon id="message-header-icon" icon="mdi-account-group" size="30px"></v-icon>
      </v-row>
      <v-row id="message-content">huhu</v-row>
      <v-row id="message-sender">
        <form id="message-sender-form" @submit.prevent="submitMessage">
          <input v-model="message" placeholder="type message :)"/>
          <div id="button-box">
            <v-icon color="white">mdi-send
              mdi-rotate-315
            </v-icon>
          </div>
          <button></button>
        </form>

      </v-row>
    </v-container>
  </div>
</template>

<script>
export default {
  name: "VideoMessage",
  data() {
    return {
      message: '',
    };
  },
  methods: {
    submitMessage() {
      console.log(this.message);
      this.$emit("handleMessage", this.message);
      this.message = '';
    }
  }
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
  background: #0E0F28;
  border: 2px solid #043E4B;
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
  background: #0E0F28;
  border: 2px solid #043E4B;
  border-radius: 10px;
  justify-content: center;
  align-items: center;
}

#message-content {
  flex-grow: 10;
}
</style>
