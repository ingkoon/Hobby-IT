<template>
  <v-slide-group
      show-arrows
      style="margin:1% 0%;"
  >
    <v-slide-group-item
      v-for="n in 7"
      :key="n"
    >
      <participate-group-item />
    </v-slide-group-item>
  </v-slide-group>
</template>

<script>
export default {
  components: { ParticipateGroupItem },

}
</script>

<script setup>
import ParticipateGroupItem from '../components/ParticipateGroupItem.vue'
</script>

<style>

</style>