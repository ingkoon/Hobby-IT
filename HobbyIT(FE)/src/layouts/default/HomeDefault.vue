<template>
  <v-app id='app'>
    <default-bar style='position: fixed' />

    <router-view />
  </v-app>
</template>

<script>
import DefaultBar from './AppBar.vue';
// import DefaultView from './View.vue';
import { useUserStore } from '@/store/user';
import { reissueRefreshToken } from '@/api/common/interceptors';

export default {
  name: 'HomeDefault',
  components: {
    DefaultBar,
    // DefaultView,
  },
  setup() {
    const userStore = useUserStore();
    return { userStore };
  },
  async created() {
    if (!this.userStore.getAccessToken && this.userStore.getRefreshToken) {
      const data = {
        refreshToken: this.userStore.getRefreshToken,
      };
      const res = await reissueRefreshToken(data);
      await this.userStore.setUser(res.data);
    }
  },
};
</script>

<style>
#app {
  font-family: linefontbold;
  background-color: #0e0f28;
}

@font-face {
  font-family: 'linefontbold';
  src: url('/assets/fonts/LINESeedSansKR-Bold.woff2');
}

@font-face {
  font-family: 'linefont';
  src: url('/assets/fonts/LINESeedSansKR-Regular.woff2');
}

@font-face {
  font-family: 'logofont';
  src: url('/assets/fonts/FredokaOne-Regular.woff2');
}
</style>
