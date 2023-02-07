<template>
  <v-slide-group show-arrows style="margin: 1% 0">
    <participate-group-item v-for="lst in hobbylist" :lst="lst"/>
  </v-slide-group>
  
</template>

<script>
import ParticipateGroupItem from '@/components/ParticipateGroupItem.vue';

export default {
  components: { ParticipateGroupItem },
  props : {
    hobbylist : Object,
  },
  methods : {
    
  },
};
</script>

<style>
#makegroup {
  position: absolute;
  top: 0;
  left: 20px;
}
</style>
