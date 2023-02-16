<template>
  <v-card id="groupnotice">
    <v-icon icon="mdi-close" style="align-self: end" @click="close"></v-icon>
    <div style="align-self: start; margin-bottom: 10px">
      <v-icon icon="mdi-bullhorn-variant" style=""></v-icon>
      공지사항
    </div>

    <v-text-field
      v-model="title"
      color="white"
      placeholder="제목"
      style="margin: 0 10px; width: 100%"
      variant="outlined"
    ></v-text-field>

    <v-textarea
      v-model="content"
      auto-grow="false"
      color="white"
      counter
      placeholder="본문"
      style="margin: 0; width: 100%"
      variant="outlined"
    ></v-textarea>

    <div @click="addnotice" style="align-self: end; font-family: linefont; margin-bottom: 5px">
      수정하기
      <v-icon icon="mdi-pencil"></v-icon>
    </div>
  </v-card>
</template>

<script>
import { updateGroupNotice } from '@/api/hobby'
export default {
  data(){
    return {
      title: '',
      content : '',
      file : undefined,
    }
  },
  props : {
    data : Object, //[groupid, row.id, row.title, row.content]
  },
  created() {
    this.title = this.data[2]
    this.content = this.data[3]
  },
  methods: {
    close() {
      this.$emit('close');
    },
    async addnotice() {
      try {
        const inputdata = {
          title : this.title,
          content : this.content,
        }
        
        const { data } = await updateGroupNotice(this.data[0], this.data[1], JSON.stringify(inputdata))
        console.log(data)
        this.close()
      }
      catch (e){
        console.log(e)
      }
    }
  },
};
</script>

<style>
#groupnotice {
  width: 670px;
  height: auto;
  display: flex;
  align-self: center;
  text-align: center;
  /*justify-content:center;*/
  background-color: #0e0f28;
  color: white;
  font-family: linefontbold;
  border: 1px solid #24b1d0;
  border-radius: 20px;
  padding: 5px 20px;
  justify-content: space-evenly;
  align-items: center;
}
</style>
