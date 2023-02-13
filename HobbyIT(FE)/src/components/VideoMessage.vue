<template>
  <div style="height: 100%; width: 100%;">
    <div style="height:10%; font-size:50px; margin: 10px 20px; display: flex; justify-content: space-between;color:white;">
      <div>Chat</div>
      <v-icon id="message-header-icon" icon="mdi-account-group" size="xs"></v-icon>
    </div>

    <div style="height:80%; overflow-y: auto; overflow-x: hidden;">
      <ChatMessage v-for="(msg, index) in messageStore.message" :key="index" :msg="msg" style="flex-wrap: wrap" />
    </div>

    <div style="height: 10%; color:white">
      <v-text-field
        v-model="message"
        append-inner-icon="mdi-send-outline"
        color="#24B1D0"
        placeholder="type message :)"
        style="width: 80%; align-self: center; font-size: 20px; margin: 0 auto;"
        variant="outlined"
        @click:append-inner="submitMessage"
        @keyup.enter="submitMessage"
      >
      </v-text-field>
    </div>
    
  </div>
</template>

<script>
import ChatMessage from '@/components/ChatMessage.vue';
import { useMessageStore } from '@/store/message';

export default {
  name: 'VideoMessage',
  components: { ChatMessage },
  setup() {
    const messageStore = useMessageStore();
    return { messageStore };
  },
  data() {
    return {
      message: '',
    };
  },
  methods: {
    submitMessage() {
      if(this.message !== ''){
        const msgData = {
          data: this.message,
          from: '',
        };
        this.messageStore.message.push(msgData);
        console.log(this.message);
        this.$emit('handleMessage', this.message);
        this.message = '';
      }
    },
  },
};
</script>

<style scoped>

#message-header {
  color: white;
  padding: 14px 7px 0 43px;
  font-style: normal;
  font-size: 40px;
  max-height: 90px;
  justify-content: center;
  align-items: center;
}


</style>
