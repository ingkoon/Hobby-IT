<template>
  <div style="align-self: center">
    <v-card id="card" style="width: 800px; height: 560px">
      <div
        id="notopa"
        style="
          color: white;
          height: 60px;
          display: flex;
          justify-content: space-between;
          padding: 10px 5px;
          background-color: #0e0f28;
        "
      >
        <span></span>
        <span id="groupname">To. John, 나 여행가고싶어</span>
        <v-icon icon="mdi-close" size="small" @click="closemodal"></v-icon>
      </div>
      <div style="display: flex">
        <div id="realimg" style="width: 500px; height: 500px; background-color: #fa8eb630" @click="uploadimg">
          <v-carousel style="width: 500px">
            <v-carousel-item v-for="(item, i) in imgurl" :key="i" :src="item.src" cover></v-carousel-item>
          </v-carousel>
        </div>

        <div style="background-color: #0e0f28; color: white">
          <div style="margin: 5px 10px">
            <v-icon color="blue-lighten-2" icon="mdi-account-circle" style="margin-right: 10px"></v-icon>
            다나카
            <div>
              <v-icon color="#000000" icon="mdi-thumb-up" size="small"></v-icon>
              좋아요 19
            </div>
          </div>

          <div>배낭 여행 3일차</div>
          <hr color="white" style="height: 3px" />

          <div style="word-break: keep-all">
            석촌호수에 도착했다. 커플들이 많이 보인다. 이 근처 맛집 추천가능한가요? 파인애플이 듬뿍 올라간 피자가 먹고
            싶습니다<br />
            뜨거운 코트를 가르며~ 너에게 가고있어~
          </div>

          <div style="text-align: right"><v-icon icon="mdi-eye" size="small"></v-icon> 558</div>

          <hr color="#642EFE" style="height: 3px" />
        </div>
      </div>
    </v-card>
  </div>
</template>

<script>
export default {
  data() {
    return {
      content: '',
      imgurl: [
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
      ],
    };
  },
  mounted() {},
  methods: {
    closemodal() {
      this.$emit('closearticle');
    },
  },
};
</script>

<style scoped>
#groupname {
  font-size: 20px;
  background: linear-gradient(to bottom, #642efe, #fa8eb6);
  color: transparent;
  -webkit-background-clip: text;
}

#card {
  background-color: rgba(255, 255, 255, 0);
}
</style>
