<template>
  <div v-if='streamManager' class='video-container'>
    <ov-video :stream-manager='streamManager' />
    <p class='video-caption' style='color: white; text-align: center'>{{ clientData }}</p>
  </div>
</template>

<script>
import OvVideo from './OvVideo';

export default {
  name: 'UserVideo',
  components: {
    OvVideo,
  },
  props: {
    streamManager: Object,
  },
  computed: {
    clientData() {
      const { clientData } = this.getConnectionData();
      return clientData;
    },
  },
  methods: {
    getConnectionData() {
      const { connection } = this.streamManager.stream;
      return JSON.parse(connection.data);
    },
  },
};
</script>

<style scoped>
.video-container {
  position: relative;
}

.video-caption {
  position: absolute;
  bottom: 20px;
  left: 0;
  right: 0;
  /*background-color: rgba(0, 0, 0, 0.5);*/
  color: white;
  padding: 10px;
}
</style>
