<template>
  <v-app id="app">
    <default-bar />

    <default-view style="margin:50px 13% 0px" />
  </v-app>
</template>

<script setup>
  import DefaultBar from './AppBar.vue'
  import DefaultView from './View.vue'
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
