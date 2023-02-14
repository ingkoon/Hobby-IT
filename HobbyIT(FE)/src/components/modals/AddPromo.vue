<template>
  <v-card id="promo">
    <div style="display: flex; align-items: center;">
      <div style="font-size: 18px; margin-top: 20px;">
        <v-icon icon="mdi-sprout-outline" size="24" style="margin: -3px 10px 0px 0px; color:#FA8EB6;"></v-icon>
        홍보글 작성
      </div>
      <v-btn
        variant="flat" icon="mdi-close" style="background-color: rgba(0, 0, 0, 0); color: white; align-self:end; margin: 0px -30px 0px 460px;"
        @click="closeaddpromo">
      </v-btn>
    </div>

    <div style="display: flex; margin: 20px 0px 0px 12px;">
      <v-select
      id="head"
      v-model="type"
      :items="types"
      style="width: 100px; margin-right: 10px;"
      ></v-select>

      <v-select
      id="head"
      v-model="mine"
      :items="myhobbies"
      label="Hobby"
      style="width: 150px;"
      ></v-select>

      <v-text-field
        color="white"
        placeholder="제목"
        style="margin:0 10px; width:350px"
        variant="outlined"

      ></v-text-field>
    </div>

    <v-textarea
      :model-value="content"
      auto-grow="false"
      color="white"
      counter
      placeholder="본문"
      style="margin:0; width:100%"
      variant="outlined"
    ></v-textarea>

    <div style="display: flex; align-items: center;">
      <div style="font-size: 14px; margin: 0px 0px 0px 520px; text-align: right;">
        작성하기
      </div>
      <v-btn
        variant="flat" icon="mdi-pencil-outline" style="background-color: rgba(0, 0, 0, 0); color: white; align-self:end; margin: 0px -30px 5px -5px;"
        @click="closeaddpromo">
      </v-btn>
    </div>

  </v-card>
</template>

<script>
export default {
  data: () => ({
      types: ["모집", "교류"],
      type: "모집",
      myhobbies: [],
      mine: "",
  }),
  methods: {
    closeaddpromo() {
      this.$emit('closeaddpromo')
    }
  }
}
</script>

<style>

#promo {
  width:670px;
  height:auto;
  display:flex;
  align-self:center;
  text-align:center;
  /*justify-content:center;*/
  background-color:#0E0F28;
  color:white;
  font-family: linefontbold;
  border: 2px solid #24B1D0;
  border-radius: 20px;
  padding: 5px 20px;
  justify-content: space-evenly;
  align-items: center;
}

div.v-list.v-theme--light.v-list--density-default.v-list--one-line {
  background-color: #0E0F28;
  border: 2px solid #24B1D0;
  text-align: center;
  color: white;
  font-family: linefont;
}


</style>
