<!--suppress ALL -->

<template>
  <div style="align-self: center">
    <v-card style="width: 800px; height: 530px; background-color: #0e0f28">
      <div style="color: white; display: flex; justify-content: space-between; margin: 10px 5px">
        <span id="groupname">To. John, 나 여행가고싶어</span>
        <span>방명록 작성</span>
        <v-icon icon="mdi-close" size="small" @click="closemodal"></v-icon>
      </div>
    
    </v-card>
  </div>
</template>

<script>
import { getGroupVisitorBook } from '@/api/hobby';

export default {
  data() {
    return {
      ctx: '',
      canvas: '',
      date: '',
      senddate : '',
      background: '',
      bglist: ['#F7FDB0', '#ABFAB3', '#BFE0FE', '#FECDCD'],
      bglist2: ['#D3D98F', '#63D382', '#AC94F1', '#DAA6A6'],
    };
  },
  props : {
    data : Object //[date, groupid]
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
      let month = date.getMonth()+1
      if(month < 10){
        month = '0'+ String(month)
      }
      let day = date.getDate()
      if(day < 10){
        day = '0'+String(day)
      }
      const inputdate = year + "-" + month + "-" + day
      try {
        const { data } = await getGroupVisitorBook(id, inputdate)
        console.log(data)
      }
      catch(e) {
        console.log(e)
      }
      
    }
  },
};
</script>

<style scoped>
.new-cursor {
  cursor: url("data:image/svg+xml;urf8,<svg xmlns='http://www.w3.org/2000/svg' width='40' height='48' viewport='0 0 100 100'><text y='50%'>✏️</text></svg>")
      0 25,
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
