<template>
  <div>
    <p :style="{ color: color }">{{ msg }}</p>
  </div>
</template>

<script>
import { onBeforeMount } from "vue";

export default {
  name: "ChatMessage",
  props: {
    msg: Object,
  },
  computed: {
    color() {
      if (this.msg.from === "") {
        return "green";
      } else {
        return "white";
      }
    },
  },
};
</script>

<style scoped></style>
