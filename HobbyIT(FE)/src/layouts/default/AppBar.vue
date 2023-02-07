<template>
  <v-app-bar flat style='background-color: #0e0f28'>
    <v-app-bar-title>
      <router-link style='display: flex; align-content: center' to='/main'>
        <img src='/assets/HBLOGO.svg' style='width: 30px; margin-right: 10px' />
        <span style='font-family: logofont'>HOBBY'</span>
        <span style='color: #8947e2; font-family: logofont'>IT</span>
      </router-link>
    </v-app-bar-title>

    <div id='nav'>
      <router-link to='/about'>이용가이드</router-link>
      <router-link to='/about'>참여하기</router-link>
      <router-link to='/about'>공지사항</router-link>
    </div>

    <span v-if='isLoggedIn'>
      <v-icon color='blue-lighten-2' icon='mdi-account-circle' style='margin-right: 10px'></v-icon>
      <router-link to='/mypage'>
        <span style='font-family: linefontbold'>{{ userStore.userNickname }}</span>
        님, 안녕하세요!
      </router-link>
      <v-btn color='white' rounded='pill' style='background-color: #8947e2' @click='handleLogout'>로그아웃</v-btn>
    </span>
    <div v-else style='min-width: 324px;display:flex;justify-content: flex-end'>

      <v-btn color='white' rounded='pill' style='background-color: #8947e2;display:flex;' @click='handleGoLoginPage'>
        로그인
      </v-btn>
    </div>
  </v-app-bar>
</template>

<script>
import { useUserStore } from '@/store/user';
import { memberLogout } from '@/api/member';

export default {
  setup() {
    const userStore = useUserStore();
    return { userStore };
  },
  data() {
    return {};
  },
  computed: {
    isLoggedIn() {
      return !!this.userStore.getAccessToken;
    },
  },
  methods: {
    handleGoLoginPage() {
      this.$router.push('login');
    },
    async handleLogout() {
      const logoutData = {
        accessToken: this.userStore.getAccessToken,
      };
      const res = await memberLogout(logoutData);
      console.log(res);
    },
  },

};
</script>

<style scoped>
div.v-toolbar__content {
  max-height: 59px;
  /* height: 59px; */
  border-bottom: 3px solid #642efe;
  display: flex;
  color: white;
  /* justify-content: space-between; */
  padding: 0 20px;
  align-items: center;
}

a {
  text-decoration: none;
  color: white;
}

#nav {
  text-align: center;
  display: flex;
  justify-content: space-evenly;
  width: 50%;
  margin-right: 30px;
}

button {
  width: 120px;
  height: 50px;
  /*margin-left:10px; */
  margin: 5px;
}
</style>
