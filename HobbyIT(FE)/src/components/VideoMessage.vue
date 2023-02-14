<template>
  <div style='height: 100%; width: 100%;'>
    <div
      style='height:10%; font-size:50px; margin: 10px 20px; display: flex; justify-content: space-between;color:white;'>
      <div>Chat</div>
      <v-icon id='message-header-icon' icon='mdi-account-group' size='xs'></v-icon>
    </div>
    <div ref='chatContainer' style='height:80%; overflow-y: auto; overflow-x: hidden;'>
      <DynamicScroller :items='messages' :min-item-size='10'>
        <template #default='{ item, index, active }'>
          <DynamicScrollerItem
            :active='active'
            :data-index='index'
            :item='item'
            :size-dependencies='[
          item,
        ]'
          >
            <ChatMessage :key='index' :msg='item' style='flex-wrap: wrap' />
          </DynamicScrollerItem>
        </template>
        <!--        <ChatMessage v-for='(msg, index) in messageStore.message' :key='index' :msg='msg' style='flex-wrap: wrap' />-->
      </DynamicScroller>
    </div>

    <div style='height: 10%; color:white'>
      <v-text-field
        v-model='message'
        append-inner-icon='mdi-send-outline'
        color='#24B1D0'
        placeholder='type message :)'
        style='width: 80%; align-self: center; font-size: 20px; margin: 0 auto;'
        variant='outlined'
        @click:append-inner='submitMessage'
        @keyup.enter='submitMessage'
      >
      </v-text-field>
    </div>

  </div>
</template>

<script>
import ChatMessage from '@/components/ChatMessage.vue';
import { useMessageStore } from '@/store/message';
import { DynamicScroller, DynamicScrollerItem } from 'vue-virtual-scroller';

export default {
  name: 'VideoMessage',
  components: { DynamicScroller, ChatMessage, DynamicScrollerItem },
  setup() {
    const messageStore = useMessageStore();

    return { messageStore };
  },
  data() {
    return {
      message: '',
    };
  },
  computed: {
    messages() {
      return this.messageStore.message;
    },
  },
  watch: {
    messages(newVal, oldVal) {
      this.$nextTick(() => {
        this.$refs.chatContainer.scrollTop = this.$refs.chatContainer.scrollHeight;
      });
      return false;
    },
  }
  ,
  mounted() {
    this.messageStore.$subscribe((mutation, state) => {
      this.$nextTick(() => {
        this.$refs.chatContainer.scrollTop = this.$refs.chatContainer.scrollHeight;
      });
    });
  },
  methods: {
    submitMessage() {
      if (this.message !== '') {
        const msgData = {
          data: this.message,
          from: '',
          id: this.messageStore.message.length,
        };
        this.messageStore.message.push(msgData);
        this.$emit('handleMessage', this.message);
        this.message = '';
      }
    },
  }
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
