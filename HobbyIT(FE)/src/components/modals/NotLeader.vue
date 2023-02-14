<template>
  <v-card id="notleader">
    <v-icon icon="mdi-close" style="align-self: end" @click="closenotleader"></v-icon>
    <v-icon icon="mdi-face-agent" style="align-self: center; margin-top: -20px;"></v-icon>
    <div style="font-size: 36px">방장 권한이 없습니다</div>
    <div style="font-size: 14px; font-family: linefont">이런! 현재 가입한 모임 중 방장으로 활동 중인 모임이 없는 것 같습니다.</div>
    <div style="font-size: 20px; font-family: linefont">홍보게시판은 모임 방장만 글 작성이 가능합니다.</div>

    <span id="okbtn" style="color: white" @click="closenotleader"> 확인 </span>
  </v-card>
</template>

<script>
export default {
  methods: {
    closenotleader() {
      this.$emit('closenotleader');
    },
  },
};
</script>

<style>
#notleader {
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
