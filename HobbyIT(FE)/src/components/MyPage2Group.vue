<template>
  <v-slide-group show-arrows style="margin: 1% 0">
    <MyPageGroupItem v-for="lst in hobbylist" :lst="lst"/>
  </v-slide-group>
</template>

<script>
import CreateGroup from './CreateGroup.vue';
import MyPageGroupItem from './MyPageGroupItem.vue';

export default {
  components: {
    MyPageGroupItem,
    CreateGroup,
  },

  data() {
    return {
      creategroupmodal: false,
    };
  },

  props : {
    hobbylist : Object
  },

  methods: {
    opencreategroup() {
      this.creategroupmodal = true;
    },
    closecreategroup() {
      this.creategroupmodal = false;
    },
  },
};
</script>

<style>
#makegroup {
  position: absolute;
  top: 0;
  left: 45px;
}
#makegroup2 {
  position: absolute;
  top: 60px;
  left: 0;
}
</style>
