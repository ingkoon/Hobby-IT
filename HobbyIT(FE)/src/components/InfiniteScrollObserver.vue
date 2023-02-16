<template>
  <div id='trigger' ref='trigger'>-</div>
</template>

<script>


export default {
  name: 'InfiniteScrollObserver',
  data() {
    return {
      trigger: null,
      options: {
        root: null,
        threshold: 0.1,
      },
      observer: null,
    };
  },
  mounted() {

    this.trigger = document.querySelector('#trigger');
    try {
      this.observer = new IntersectionObserver((entries) => {
        this.handleIntersect(entries[0]);
      }, this.options);
      this.observer.observe(this.trigger);
    } catch (e) {
      console.error(e);
    }
  },
  beforeunmounted() {
    console.log('disconnected');
    this.observer.value.disconnect();
  },
  methods: {
    handleIntersect(entry) {
      console.log('haha');
      if (entry.isIntersecting) {
        this.$emit('infiniteScrollTrigger');
      }
    },
  },
};
</script>

<style scoped>

</style>
