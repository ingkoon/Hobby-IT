<template>
  <v-card id="mpromo">
    <div style="display: flex; align-items: center;">
      <div style="font-size: 18px; margin-top: 20px;">
        <v-icon icon="mdi-sprout-outline" size="24" style="margin: -3px 10px 0px 0px; color:#FA8EB6;"></v-icon>
        홍보글 수정
      </div>
      <v-btn
        variant="flat" icon="mdi-close" style="background-color: rgba(0, 0, 0, 0); color: white; align-self:end; margin: 0px -30px 0px 460px;"
        @click="closemodipromo">
      </v-btn>
    </div>

    <div style="display: flex; margin: 20px 0px 0px 12px;">
      <v-select
      id="head"
      v-model="displaytype"
      :items="types"
      label="말머리"
      style="width: 100px; margin-right: 10px;"
      ></v-select>

      <v-select
      id="head"
      v-model="mine"
      :disabled="true"
      label="Hobby"
      style="width: 150px;"
      ></v-select>

      <v-text-field
        v-model="modititle"
        color="white"
        label="제목"
        style="margin:0 10px; width:350px"
        variant="outlined"
      ></v-text-field>
    </div>

    <v-textarea
      v-model="modicontent"
      :auto-grow="false"
      color="white"
      label="본문"
      style="margin:0; width:100%"
      variant="outlined"
    ></v-textarea>

    <div style="display: flex; align-items: center;">
      <div style="font-size: 14px; margin: 0px 0px 0px 520px; text-align: right;">
        수정하기
      </div>
      <v-btn
        variant="flat" icon="mdi-pencil-outline" style="background-color: rgba(0, 0, 0, 0); color: white; align-self:end; margin: 0px -30px 5px -5px;"
        @click="donemodipromo">
      </v-btn>
    </div>

  </v-card>
</template>

<script>
export default {
  props:{
    articleinfo:{
      type: Array,
      required: true
    },
  },
  data(){
    return{
      types: ["모집", "교류"],
      seltype: this.articleinfo[1],
      displaytype: this.articleinfo[1] === 'MEETUP' ? '교류' : '모집',
      mine: this.articleinfo[4],
      modititle: this.articleinfo[2],
      modicontent: this.articleinfo[3],
    };
  },
  computed:{
    // getnames(){
    //   return this.masterlist.map(item => item.name);
    // },
  },
  methods: {
    closemodipromo(){
      console.log('가져온배열값'+this.articleinfo);
      this.$emit('closemodipromo');
    },
    donemodipromo() {
      const modidata = {
        header: this.getseltype(),
        title: this.modititle,
        content: this.modicontent,
      };

      // console.log(this.getseltype());
      console.log('수정한데이터'+modidata);
      console.log('글id:'+this.articleinfo[0]);
      this.$emit('donemodipromo', modidata, this.articleinfo[0]);
      this.$emit('closemodipromo');
    },
    // gethobbyid(){
    //   for (let index = 0; index < this.types.length; index++) {
    //     if (this.mine === this.masterlist[index].name) {
    //       return this.masterlist[index].id;
    //     }
    //   }
    // },
    getseltype(){
      if (this.seltype === "모집") {
        return "RECRUITMENT";
      } else {
        return "MEETUP"
      }
    },
  },
}
</script>

<style scoped>

#mpromo {
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

v-textarea::-webkit-scrollbar {
    width: 10px;
    background: none;
    }
v-textarea::-webkit-scrollbar-track {
    background-color: #0E0F28;
    /* border-radius: 100px; */
}
v-textarea::-webkit-scrollbar-thumb {
    background-color: #FA8EB6;
    border-radius: 100px;
}

</style>
