<template>
  <v-card id="delpromo">
    <v-icon icon="mdi-close" style="align-self: end" @click="closedelpromo"></v-icon>
    <v-icon icon="mdi-trash-can" style="align-self: center; margin-top: -20px;"></v-icon>
    <div style="font-size: 36px">홍보글을 삭제하시겠습니까?</div>
    <div style="font-size: 20px; font-family: linefont">작성한 홍보글이 삭제됩니다.</div>

    <div style="display: flex">
      <span @click="deletepromo" id="okbtn" style="color: white; margin-right: 20px"> 확인 </span>
      <span id="cancelbtn" style="color: white" @click="closedelpromo"> 취소 </span>
    </div>
  </v-card>
</template>

<script>
export default {
  methods: {
    closedelpromo() {
      this.$emit('closedelpromo')
    },
    deletepromo() {
      this.$emit('deletepromo')
      this.$emit('closedelpromo')
    }
  },
};
</script>

<style>
#delpromo {
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
  background: linear-gradient(to bottom, #642efe, #0e0f28);
  width: 60px;
  height: 60px;
  border-radius: 50%;
  display: flex;
  cursor: pointer;
  justify-content: center;
  align-items: center;
}
#cancelbtn {
  background: linear-gradient(to bottom, #ff307b, #0e0f28);
  width: 60px;
  height: 60px;
  border-radius: 50%;
  display: flex;
  cursor: pointer;
  justify-content: center;
  align-items: center;
}
</style>
