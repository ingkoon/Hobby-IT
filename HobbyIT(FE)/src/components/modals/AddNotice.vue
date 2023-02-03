<template>
  <v-card id="groupnotice">
    <v-icon icon="mdi-close" style="align-self:end" @click="close"></v-icon>
    <div style="align-self:start; margin-bottom:10px">
      <v-icon icon="mdi-bullhorn-variant" style=""></v-icon>
      공지사항
    </div>

    <v-text-field
      color="white"
      placeholder="제목"
      style="margin:0 10px; width:100%"
      variant="outlined"

    ></v-text-field>

    <v-textarea
      :model-value="content"
      :rules="rules"
      auto-grow="false"
      color="white"
      counter
      placeholder="본문"
      style="margin:0; width:100%"
      variant="outlined"
    ></v-textarea>

    <div style="align-self:end; font-family:linefont; margin-bottom:5px">
      작성하기
      <v-icon icon="mdi-pencil"></v-icon>
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

#groupnotice {
  width:670px;
  height:auto;
  display:flex;
  align-self:center;
  text-align:center;
  /*justify-content:center;*/
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
