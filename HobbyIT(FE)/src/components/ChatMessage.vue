<template>
  <send-message v-if="msg.from === ''" :color='color' :msg='msg' style='width:100%'></send-message>
  <get-message v-else :color='color' :msg='msg' style='width:100%'></get-message>
</template>

<script>
import { onBeforeMount } from 'vue';
import SendMessage from '@/components/VideoChat/SendMessage.vue';
import GetMessage from '@/components/VideoChat/GetMessage.vue';

export default {
  name: 'ChatMessage',
  components: {
    SendMessage,
    GetMessage,
  },
  props: {
    msg: Object,
  },
  computed: {
    color() {
      if (this.msg.from === '') {
        return 'green';
      } else {
        return 'white';
      }
    },
  },
};
</script>

<style scoped>

</style>
