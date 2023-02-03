<template>
  <v-app-bar flat style="background-color:#0E0F28">
    <v-app-bar-title >
      <router-link style="display:flex; align-content:center" to="/main">
        <img src="src\assets\HBLOGO.svg" style="width:30px; margin-right:10px;">
        <span style="font-family:logofont;">HOBBY'</span>
        <span style="color:#8947E2; font-family:logofont">IT</span>
      </router-link>
    </v-app-bar-title>

    <div id="nav">
      <router-link to="/about">이용가이드</router-link>
      <router-link to="/about">참여하기</router-link>
      <router-link to="/about">공지사항</router-link>
    </div>


    <span>
      <v-icon color="blue-lighten-2" icon="mdi-account-circle" style="margin-right:10px" ></v-icon>
      <router-link to="/mypage">
        <span style="font-family:linefontbold">호빗러버</span>
        님, 안녕하세요!
      </router-link>
      <v-btn color="white" rounded="pill" style="background-color:#8947E2">로그아웃</v-btn>
    </span>
  </v-app-bar>
</template>

<script setup>
  //
</script>

<style>
div.v-toolbar__content {
  max-height: 59px;
  /* height: 59px; */
  border-bottom:3px solid #642EFE;
  display: flex;
  color : white;
  /* justify-content: space-between; */
  padding: 0 20px;
  align-items: center;
}

a {
  text-decoration: none;
  color : white;
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
  margin : 5px
}
</style>
