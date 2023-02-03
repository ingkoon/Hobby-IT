<template>
  <v-app id="app">
    <default-bar style="position:fixed" />

    <default-view style="" />
  </v-app>
</template>

<script>
  import DefaultBar from './AppBar.vue'
  import DefaultView from './View.vue'
  import { useUserStore } from '@/store/user';
  export default {
    name: "HomeDefault",
    components:{
      DefaultBar,
      DefaultView
    },
    setup(){

      const userStore = useUserStore()
      return { userStore }
    },
    created() {
      //
    }
  }
</script>

<style>
#app {
  font-family: linefontbold;
  background-color:#0E0F28;

}

@font-face {
  font-family: "linefontbold";
  src: url("../src/assets/fonts/LINESeedKR-Bd.ttf");
}
@font-face {
  font-family: "linefont";
  src: url("../src/assets/fonts/LINESeedKR-Rg.ttf");
}

@font-face {
  font-family: "logofont";
  src: url("../src/assets/fonts/FredokaOne-Regular.ttf");
}
</style>
