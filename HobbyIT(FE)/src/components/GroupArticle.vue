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
        <span id="groupname">To. {{ info[2] }}</span>
        <v-icon icon="mdi-close" size="small" @click="closemodal"></v-icon>
      </div>
      <div style="display: flex">
        <div id="realimg" style="width: 500px; height: 500px; background-color: #fa8eb630" @click="uploadimg">
          <v-carousel hide-delimiter-background style="width: 500px">
            <v-carousel-item v-for="(item, i) in imgurl" :key="i" :src="item.src" cover></v-carousel-item>
          </v-carousel>
        </div>

        <div style="background-color: #0e0f28; color: white">
          <div style="margin: 5px 10px; display: flex; justify-content: space-between; ">
            <div>
              <v-icon color="blue-lighten-2" icon="mdi-account-circle" style="margin-right: 10px"></v-icon>
              {{ article.author }}
            </div>
            <div style="text-align: right;">
              <v-icon color="white" icon="mdi-thumb-up" size="small"></v-icon>
              <div>
                좋아요 {{ article.likes }}
              </div>
            </div>
          </div>

          <div style="display:flex; justify-content: space-between;">
            <div>{{ article.title }}</div>
            {{ createAt }}
          </div>
          <hr color="white" style="height: 3px" />

          <div style="word-break: keep-all">
            {{ article.content }}
          </div>

          <div style="text-align: right"><v-icon icon="mdi-eye" size="small"></v-icon> 558</div>

          <hr color="#642EFE" style="height: 3px" />
        </div>
      </div>
    </v-card>
  </div>
</template>

<script>
import { getGroupArticle } from '@/api/hobby'
export default {
  props : {
    info : Object
  },
  data() {
    return {
      article : [],
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
      createAt : '',
    };
  },
  mounted() {

  },
  methods: {
    closemodal() {
      this.$emit('closearticle');
    },
    async getArticle(groupid, articleid){
      try {
        const {data} = await getGroupArticle(groupid, articleid)
        this.article = data
        this.imgurl = []
        for (let i=0;i<data.images.length;i++){
          this.imgurl.push({src : data.images[i]})
        }
        console.log(data)
        this.createAt = data.createdAt.substring(0,10)
      }
      catch(e) {
        console.log(e)
      }
    }
  },
  created(){
    this.getArticle(this.info[0], this.info[1]);
  }
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
