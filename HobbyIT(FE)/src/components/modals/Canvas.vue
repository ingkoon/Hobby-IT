<template>
  <div style='align-self: center'>
    <v-card style='width: 800px; height: 600px; background-color: #0e0f28'>
      <div style='color: white; display: flex; justify-content: space-between; margin: 10px 5px'>
        <span id='groupname'>To. {{ this.data[2] }}</span>
        <span>방명록</span>
        <v-icon icon='mdi-close' size='small' @click='closemodal'></v-icon>
      </div>
      
      <v-row v-if="canvaslist.length > 0" style="width:100%; height: 90%; margin : auto; overflow-y:auto ;">
        <v-col
          v-for='n in canvaslist.length'
          :key='n'
          class='d-flex child-flex'
          cols='4'
          style=''
        >
          <v-img
            :src='canvaslist[n]'
            aspect-ratio='1'
            cover
          >
          </v-img>
        </v-col>
      </v-row>

    </v-card>
  </div>
</template>

<script>
import { getGroupVisitorBook } from '@/api/hobby';

export default {
  data() {
    return {
      canvaslist: [],
    };
  },
  props: {
    data: Object //[date, groupid, groupname]
  },
  mounted() {
    this.getcanvas(this.data[1], this.data[0])
  },

  created() {

  },
  methods: {
    closemodal() {
      this.$emit('close');
    },
    async getcanvas(id, date) {
      const year = date.getFullYear()
      let month = date.getMonth() + 1
      if (month < 10) {
        month = '0' + String(month)
      }
      let day = date.getDate()
      if (day < 10) {
        day = '0' + String(day)
      }
      const inputdate = year + "-" + month + "-" + day
      try {
        const { data } = await getGroupVisitorBook(id, inputdate)
        console.log(data)
        for (let i = 0; i < data.length; i++) {
          this.canvaslist.push(data[i].imgUrl)
        }
      } catch (e) {
        console.log(e)
      }

    }
  },
};
</script>

<style scoped>
.new-cursor {
  cursor: url("data:image/svg+xml;urf8,<svg xmlns='http://www.w3.org/2000/svg' width='40' height='48' viewport='0 0 100 100'><text y='50%'>✏️</text></svg>") 0 25,
  auto;
}

#groupname {
  font-size: 20px;
  background: linear-gradient(to bottom, #642efe, #fa8eb6);
  color: transparent;
  -webkit-background-clip: text;
}

#eraser {
  background: url('../../public/assets/eraser.png') no-repeat;
  width: 60px;
  height: 107px;
  background-size: cover;
  margin-top: 10px;
  /* cursor : url("../src/assets/eraser.png"), auto; */
}

#tri2 {
  width: 0;
  height: 0;
  border-bottom: 50px solid #0e0f28;
  border-top: 50px solid transparent;
  border-left: 50px solid transparent;
  border-right: 50px solid #0e0f28;
  position: absolute;
  left: 401px;
  bottom: 0;
}

#tri1 {
  width: 0;
  height: 0;
  border-bottom: 50px solid transparent;
  border-top: 50px solid white;
  border-left: 50px solid white;
  border-right: 50px solid transparent;
  position: absolute;
  left: 400px;
  bottom: 0;
}
</style>
