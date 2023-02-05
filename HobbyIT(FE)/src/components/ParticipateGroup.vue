<template>
  <v-slide-group show-arrows style="margin: 1% 0">
    <v-slide-group-item v-for="n in 7" :key="n">
      <participate-group-item />
    </v-slide-group-item>
  </v-slide-group>
</template>

<script>
import ParticipateGroupItem from '@/components/ParticipateGroupItem.vue';

export default {
  components: { ParticipateGroupItem },
};
</script>

<style>
#makegroup {
  position: absolute;
  top: 0;
  left: 20px;
}
</style>
