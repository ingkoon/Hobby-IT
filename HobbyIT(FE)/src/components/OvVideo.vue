<template>
  <video
    :style="{
      height: appStore.baseUnit * 2 + 'px',
      width: appStore.baseUnit * 3 + 'px',
    }"
    autoplay
  />
</template>

<script>
import { useAppStore } from "@/store/app";

export default {
  setup() {
    const appStore = useAppStore();
    return { appStore };
  },
  name: "OvVideo",
  props: {
    streamManager: Object,
  },
  mounted() {
    this.streamManager.addVideoElement(this.$el);
  },
};
</script>
<style scoped>
video {
  margin: 12px 36px;
}
</style>
