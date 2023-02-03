<template>
  <v-card id="groupnotice">
    <v-icon icon="mdi-close" style="align-self: end" @click="close"></v-icon>
    <div style="margin-bottom: 10px">
      <v-icon id="icon" icon="mdi-trophy" style=""></v-icon>
      Hobbitz
    </div>

    <v-progress-linear
      v-model="gauge"
      bg-color="#642EFE"
      bg-opacity="1"
      color="#fa8eb6"
      height="50px"
      rounded
      rounded-bar
      style="border: 2px solid white; border-radius: 20px; width:80%; margin-right:20%"
    >
      <div style="font-size: 14px; margin: 5px">
        {{ Math.ceil(gauge) }} /100
      </div>
    </v-progress-linear>

    <div style="display:flex; justify-content:space-between; width:80%; padding:10px">
      <div>Lv.0</div>
      <div>Lv.1</div>
    </div>


    <div style="font-size:16px; align-self:start; margin-left:50px; margin-bottom:10px">
      <div align="left" style="font-family:linefont;">
        <v-icon icon="mdi-lightbulb-outline"></v-icon>
        방명록 작성 시 10pts
      </div>
      <div align="left" style="font-family:linefont">
        <v-icon icon="mdi-lightbulb-outline"></v-icon>
        작성한 게시글 당 5pts
      </div>
      <div align="left" style="font-family:linefont">
        <v-icon icon="mdi-lightbulb-outline"></v-icon>
        댓글 작성 시 1pts
      </div>
      <div align="left" style="font-family:linefont">
        <v-icon icon="mdi-lightbulb-outline"></v-icon>
        화상채팅 참여 시간 당 1pts
      </div>
    </div>


    <div>* 획득한 보상은 화상채팅 내 커스터마이징에서 확인할 수 있습니다.</div>
    <div>* 하루 최대 30pts까지 획득 가능합니다.</div>
  </v-card>
</template>

<script>
export default {
  data() {
    return {
      gauge: 70.0,
    };
  },
  methods: {
    close() {
      this.$emit("close");
    },
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
  /*justify-content: center;*/
  background-color: #0e0f28;
  color: white;
  font-family: linefontbold;
  border: 1px solid #24b1d0;
  border-radius: 20px;
  padding: 10px 20px;
  justify-content: space-evenly;
  align-items: center;
}

.v-progress-linear__content{
  justify-content: end;
  padding-right: 10px;
}


</style>
