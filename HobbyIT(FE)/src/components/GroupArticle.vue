<template>
  <div style="align-self:center">
    <v-card id="card" style="width:800px; height: 560px; ">
      <div id="notopa" style="color:white; height:60px; display:flex; justify-content:space-between; padding:10px 5px; background-color:#0E0F28">
        <span></span>
        <span id="groupname">To. John, 나 여행가고싶어</span>
        <v-icon icon="mdi-close" size="small" @click="closemodal"></v-icon>
      </div>
      <div style="display:flex;">
        <div style="width:500px; height:500px; background-color:#FA8EB630" @click="uploadimg" id="realimg">            
          <v-carousel style="width:500px;">
            <v-carousel-item cover v-for="(item,i) in imgurl" :key="i" :src="item.src"></v-carousel-item>
          </v-carousel>
        </div>

        <div style="background-color:#0E0F28; color:white">
          <div style="margin : 5px 10px">
            <v-icon icon="mdi-account-circle" color="blue-lighten-2" style="margin-right:10px" ></v-icon>
            다나카
            <div>
              <v-icon icon="mdi-thumb-up" size="small" color="#000000"></v-icon>
              좋아요 19
            </div>
          </div>

          <div>배낭 여행 3일차</div>
          <hr style="height:3px;" color="white">

          <div style="word-break: keep-all;">
            석촌호수에 도착했다. 커플들이 많이 보인다. 이 근처 맛집 추천가능한가요? 파인애플이 듬뿍 올라간 피자가 먹고 싶습니다<br>
            뜨거운 코트를 가르며~ 너에게 가고있어~
          </div>

          <div style="text-align:right">
            <v-icon icon="mdi-eye" size="small"></v-icon> 558
          </div>

          <hr style="height:3px;" color="#642EFE">

        </div>

      </div>
    </v-card>
  </div>
</template>

<script>
export default {
  data(){
    return {
      content : "",
      imgurl : [
        {
          src: 'https://cdn.vuetifyjs.com/images/carousel/squirrel.jpg',
        },
        {
          src: 'https://cdn.vuetifyjs.com/images/carousel/sky.jpg',
        },
        {
          src: 'https://cdn.vuetifyjs.com/images/carousel/bird.jpg',
        },
        {
          src: 'https://cdn.vuetifyjs.com/images/carousel/planet.jpg',
        },
      ]
    }
  },
  methods : {
    closemodal(){
      this.$emit('closearticle')
    }
    
  },
  mounted() {
    
  }
}
</script>

<style scoped>
#groupname {
  font-size:20px;
  background: linear-gradient(to bottom, #642EFE, #FA8EB6);
  color: transparent;
  -webkit-background-clip: text;
}

#card {
  background-color:rgba(255, 255, 255, 0);
}


</style>