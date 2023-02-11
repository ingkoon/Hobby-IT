<!--suppress ALL -->

<template>
  <div style="align-self: center">
    <v-card style="width: 800px; height: 530px; background-color: #0e0f28">
      <div style="color: white; display: flex; justify-content: space-between; margin: 10px 5px">
        <span id="groupname">To. John, 나 여행가고싶어</span>
        <span>방명록 작성</span>
        <v-icon icon="mdi-close" size="small" @click="closemodal"></v-icon>
      </div>
      <div style="display: flex">
        <canvas id="canvas" class="new-cursor" height="500" style="" width="500"> </canvas>
        <div style="margin-left: 20px; display: flex">
          <div style="display: flex; flex-direction: column">
            <div style="color: white; margin-bottom: 5px">
              굵기 :
              <input
                id="input"
                color="white"
                max="100"
                min="1"
                style="color: white; border: 1px solid white"
                type="number"
              />
            </div>
            <button
              style="
                background-color: red;
                width: 50px;
                height: 50px;
                border: solid 1px white;
                border-radius: 50px;
                margin: 5px;
              "
              @click="colorChange('#ff0000')"
            ></button>
            <button
              style="
                background-color: blue;
                width: 50px;
                height: 50px;
                border: solid 1px white;
                border-radius: 50px;
                margin: 5px;
              "
              @click="colorChange('#000AFF')"
            ></button>
            <button
              style="
                background-color: #ee49fd;
                width: 50px;
                height: 50px;
                border: solid 1px white;
                border-radius: 50px;
                margin: 5px;
              "
              @click="colorChange('#EE49FD')"
            ></button>
            <button
              style="
                background-color: black;
                width: 50px;
                height: 50px;
                border: solid 1px white;
                border-radius: 50px;
                margin: 5px;
              "
              @click="colorChange('#000000')"
            ></button>
            <button id="eraser"></button>
          </div>

          <div
            style="
              color: white;
              display: flex;
              flex-direction: column;
              justify-content: space-evenly;
              margin-right: 10px;
            "
          >
            <div style="text-align: end">
              today
              <div style="font-size: 35px">{{ date }}</div>
            </div>
            <div style="font-size: 35px; text-align: end; line-height: 42px">Something<br />on your<br />mind?</div>
            <div style="text-align: end">
              <v-btn @click="sendcanvas" icon="mdi-send-outline" style="background-color: pink; transform: rotate(-45deg)"></v-btn>
            </div>
          </div>
        </div>

        <div id="tri1"></div>
        <div id="tri2"></div>
      </div>
    </v-card>
  </div>
</template>

<script>
import {postGroupVisitorBook} from '@/api/hobby';

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
    groupid : Number,
  },
  mounted() {
    var pos = {
      drawable: false,
      x: -1,
      y: -1,
    };

    var canvas = document.getElementById('canvas');
    var randomnum = Math.floor(Math.random() * 4);
    this.background = this.bglist[randomnum];

    var triangle = document.getElementById('tri1');
    triangle.setAttribute('style', 'border-color:' + this.bglist2[randomnum] + ';');
    canvas.setAttribute('style', 'background-color:' + this.background + ';');
    var background = this.background;
    var ctx = canvas.getContext('2d');
    this.ctx = ctx;
    this.canvas = canvas;
    var rect = canvas.getBoundingClientRect(); // 터치 스크린

    var eraser = document.getElementById('eraser');

    eraser.addEventListener('mousedown', mouseclick);
    eraser.addEventListener('dblclick', mousedouble);

    canvas.addEventListener('mousedown', listener);
    canvas.addEventListener('mousemove', listener);
    canvas.addEventListener('mouseup', listener);
    canvas.addEventListener('mouseout', listener);

    input.value = 3;
    ctx.lineWidth = 3;

    input.oninput = function () {
      ctx.lineWidth = input.value;
    };
    ctx.lineCap = 'round';
    ctx.lineJoin = 'round';

    function listener(e) {
      switch (e.type) {
        case 'mousedown':
          drawStart(e);
          break;
        case 'mousemove':
          if (pos.drawable) draw(e);
          break;
        case 'mouseout':
        case 'mouseup':
          drawEnd();
          break;
        case 'touchstart':
          touchStart(e);
          break;
        case 'touchmove':
          if (pos.drawable) touch(e);
          break;
        case 'touchend':
          drawEnd();
          break;
        default:
      }
    }

    function drawStart(e) {
      pos.drawable = true;
      ctx.beginPath();
      pos.x = e.offsetX;
      pos.y = e.offsetY;
      ctx.moveTo(pos.x, pos.y);
    }
    function touchStart(e) {
      pos.drawable = true;
      ctx.beginPath();
      pos.x = e.touches[0].pageX - rect.left;
      pos.y = e.touches[0].pageY - rect.top;
      ctx.moveTo(pos.x, pos.y);
    }
    function draw(e) {
      ctx.lineTo(e.offsetX, e.offsetY);
      pos.x = e.offsetX;
      pos.y = e.offsetY;
      ctx.stroke();
    }
    function touch(e) {
      ctx.lineTo(e.touches[0].pageX - rect.left, e.touches[0].pageY - rect.top);
      pos.x = e.touches[0].pageX - rect.left;
      pos.y = e.touches[0].pageY - rect.top;
      ctx.stroke();
    }
    function drawEnd() {
      pos.drawable = false;
      pos.x = -1;
      pos.y = -1;
    }

    function mouseclick() {
      ctx.strokeStyle = background;
      canvas.setAttribute(
        'style',
        'cursor : url("../src/assets/eraser.png"), auto; background-color:' + background + ';',
      );
    }

    function mousedouble() {
      ctx.clearRect(0, 0, canvas.width, canvas.height);
    }
  },

  created() {
    var today = new Date();
    var year = today.getFullYear();
    var month = ('0' + (today.getMonth() + 1)).slice(-2);
    var day = ('0' + today.getDate()).slice(-2);

    this.date = year + '.' + month + '.' + day;
    this.senddate = year + '-' + month + '-' + day;
  },
  methods: {
    closemodal() {
      this.$emit('close');
    },
    colorChange(color) {
      this.ctx.strokeStyle = color;
      this.canvas.setAttribute(
        'style',
        'cursor : url("data:image/svg+xml;urf8,<svg xmlns="http://www.w3.org/2000/svg" width="40" height="48" viewport="0 0 100 100"><text y="50%">✏️</text></svg>") 0 25 , auto; background-color:' +
          this.background +
          ';',
      );
    },
    clearAll() {
      this.ctx.clearRect(0, 0, canvas.width, canvas.height);
    },
    // 방명록 전송
    sendcanvas() {
      let dataUrl = this.canvas.toDataURL('image/png');
      let byteString = window.atob(dataUrl.split(',')[1])
      var array = [];
      for( let i=0; i< byteString.length; i++){
        array.push(byteString.charCodeAt(i))
      }
      
      var myBlob = new Blob([new Uint8Array(array)], {type:'image/png'})
      console.log(myBlob);
      
      // Blob -> File 처리
      let file = new File([myBlob], this.date + ".png")

      let formData = new FormData()
      formData.append("file", file)

      console.log(formData.get('file'))

      this.send(file)
    },

    async send(file){
      try {
        const inputdata = {
          multipartFile : file
        }
        const { data } = await postGroupVisitorBook(this.groupid, this.senddate, inputdata)
        console.log(data)
      }
      catch(e){
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
