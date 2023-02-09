<template>
  <v-app id="app">
    <default-bar style="position: fixed" />
    <div style="margin: 100px 13% 0" >
      <router-view/>
    </div>
  </v-app>
</template>

<script>
import DefaultBar from './AppBar.vue';
// import DefaultView from './View.vue';
import { useUserStore } from '@/store/user';

export default {
  components : {
    DefaultBar,
  },
  setup() {
    const userStore = useUserStore();
    return { userStore };
  },
  created() {
    if (!this.userStore.getAccessToken) {

    }
  },
}
</script>

<style>
#app {
  font-family: linefontbold;
  background-color: #0e0f28;
}

@font-face {
  font-family: 'linefontbold';
  src: url('/assets/fonts/LINESeedKR-Bd.ttf');
}

@font-face {
  font-family: 'linefont';
  src: url('/assets/fonts/LINESeedKR-Rg.ttf');
}

@font-face {
  font-family: 'logofont';
  src: url('/assets/fonts/FredokaOne-Regular.ttf');
}
</style>
