<template>
  <v-card id="groupresign">
    <v-icon icon="mdi-close" style="align-self:end" @click="close"></v-icon>
    <v-icon icon="mdi-run" style="align-self:center"></v-icon>
    <div style="font-size:36px">모임을 탈퇴하시겠습니까?</div>
    <div style="font-size:14px; font-family:linefont">탈퇴한 모임은 재가입이 어렵습니다</div>
    <div style="font-size:20px; font-family:linefont">"<span style="font-family:linefontbold">블라블라</span>"에서 떠나시겠습니까?</div>

    <div style="display:flex;">
      <span id="okbtn" style="color: white; margin-right:20px">
        확인
      </span>
      <span id="cancelbtn" style="color: white;" @click="close">
        취소
      </span>
    </div>
  </v-card>
</template>

<script>
export default {
  methods: {
    close() {
      this.$emit('close')
    }
  }
}
</script>

<style>

#groupresign {
  width:670px;
  height:330px; 
  display:flex; 
  align-self:center; 
  text-align:center; 
  justify-content:center; 
  background-color:#0E0F28;
  color:white;
  font-family: linefontbold;
  border: 1px solid #24B1D0;
  border-radius: 20px;
  padding: 5px 20px;
  justify-content: space-evenly;
  align-items: center;
}

#okbtn {
  background: linear-gradient(to bottom, #FF307B, #0e0f28);
  width: 60px;
  height: 60px;
  border-radius: 50%;
  display: flex;
  cursor: pointer;
  justify-content: center;
  align-items: center;
}
#cancelbtn {
  background: linear-gradient(to bottom, #642EFE, #0e0f28);
  width: 60px;
  height: 60px;
  border-radius: 50%;
  display: flex;
  cursor: pointer;
  justify-content: center;
  align-items: center;
}
</style>