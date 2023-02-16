<template>
  <v-card id="makegroup">
    <!-- <v-icon icon="mdi-close" style="align-self:end" @click="close"></v-icon> -->
    <div>
      <v-icon color="#567CFF" icon="mdi-human" style="align-self: center"></v-icon>
      <v-icon color="white" icon="mdi-human" style="align-self: center"></v-icon>
      <v-icon color="#FA8EB6" icon="mdi-human" style="align-self: center"></v-icon>
    </div>
    <div style="font-size: 36px">HOBBY'IT!</div>
    <div style="font-size: 14px; font-family: linefont">"블라블라" 모임이 생성되었습니다!</div>
    <div style="font-size: 20px; font-family: linefont">함께할 사람들을 찾아볼까요?</div>

    <span id="okbtn" style="color: white"> 확인 </span>
  </v-card>
</template>

<script>
export default {
  methods: {},
};
</script>

<style>
#makegroup {
  width: 670px;
  height: 330px;
  display: flex;
  align-self: center;
  text-align: center;
  /*justify-content:center; */
  background-color: #0e0f28;
  color: white;
  font-family: linefontbold;
  border: 1px solid #24b1d0;
  border-radius: 20px;
  padding: 5px 20px;
  justify-content: space-evenly;
  align-items: center;
}

#okbtn {
  background: linear-gradient(to bottom, #ee49fd, #0e0f28);
  width: 60px;
  height: 60px;
  border-radius: 50%;
  display: flex;
  cursor: pointer;
  justify-content: center;
  align-items: center;
}
</style>
