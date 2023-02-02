<template>
  <v-card id="groupregi">
    <v-icon icon="mdi-close" style="align-self:end" @click="close"></v-icon>
    <v-icon icon="mdi-heart-multiple-outline" style="align-self:center"></v-icon>
    <div style="font-size:36px">Nice to Meet You!</div>
    <div style="font-size:14px; font-family:linefont">본 모임은 관리자의 가입 승인이 필요합니다.</div>
    <div style="font-size:20px; font-family:linefont">자신을 소개할 한마디 적어주세요</div>
    <v-responsive
      max-height="70px"
      style="">
      <v-text-field
        style="width:500px; align-self:center; font-size:20px;"
        variant="outlined"
        color = "#24B1D0"
        placeholder="welcome!"
        append-inner-icon="mdi-send-outline"
        >

      </v-text-field>
    </v-responsive>
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

#groupregi {
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
</style>