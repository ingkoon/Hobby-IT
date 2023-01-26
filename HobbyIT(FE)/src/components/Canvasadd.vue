<template>
  <div style="align-self:center">
    <v-card style="width:800px; height: 500px; background-color:#0E0F28">
      <div style="color:white; display:flex; justify-content:space-between; margin:10px 5px;">
        <span id="groupname">To. John, 나 여행가고싶어</span>
        <span>방명록 작성</span>
        <v-icon icon="mdi-close" size="small" @click="closemodal"></v-icon>
      </div>
      <div style="display:flex">
        <canvas class="new-cursor" id="canvas" width="500" height="500" style="background-color:#f7fdb0"></canvas>
        <div style="margin-left:20px">
          <div style="display:flex; flex-direction:column">
            <div style="color:white; margin-bottom:5px">굵기 :
              <input id="input" type="number" min="1" max="100" color="white" style="color:white; border: 1px solid white"/>
            </div>
            <button @click="colorChange('#ff0000')" style="background-color: red; width: 50px; height: 50px; border: solid 1px white; border-radius:50px; margin:5px"></button>
            <button @click="colorChange('#000AFF')" style="background-color: blue; width: 50px; height: 50px; border: solid 1px white; border-radius:50px; margin:5px"></button>
            <button @click="colorChange('#EE49FD')" style="background-color: #EE49FD; width: 50px; height: 50px; border: solid 1px white; border-radius:50px; margin:5px"></button>
            <button @click="colorChange('#000000')" style="background-color: black; width: 50px; height: 50px; border: solid 1px white; border-radius:50px; margin:5px"></button>
            <button id="eraser"></button>
          </div>
        </div>
      </div>
    </v-card>
  </div>
</template>

<script>
export default {
  data(){
    return {
      ctx : "",
      canvas : "",
    }
  },
  methods : {
    closemodal() {
      this.$emit('close')
    },
    colorChange(color) {
      console.log(color)
      this.ctx.strokeStyle = color;
    },
    clearAll() {
      this.ctx.clearRect(0, 0, canvas.width, canvas.height);
    },
  },
  mounted() {

    var pos = {
      drawable: false,
      x: -1,
      y: -1,
    };

    var canvas = document.getElementById('canvas')
    var ctx = canvas.getContext('2d');
    this.ctx = ctx;
    this.canvas = canvas;
    var rect = canvas.getBoundingClientRect();  // 터치 스크린

    var eraser = document.getElementById('eraser')

    eraser.addEventListener("mousedown", mouseclick);
    eraser.addEventListener("dblclick", mousedouble);

    canvas.addEventListener("mousedown", listener);
    canvas.addEventListener("mousemove", listener);
    canvas.addEventListener("mouseup", listener);
    canvas.addEventListener("mouseout", listener);

    input.oninput = function(){
      ctx.lineWidth = input.value;
    }
    ctx.lineCap = 'round'
    ctx.lineJoin = 'round'    

    function listener(e){
      switch(e.type){
          case "mousedown":
              drawStart(e);
              break;
          case "mousemove":
              if(pos.drawable)
                  draw(e);
              break;
          case "mouseout":
          case "mouseup":
              drawEnd();
              break;
          case "touchstart":
              touchStart(e);
              break;
          case "touchmove":
              if(pos.drawable)
                  touch(e);
              break;
          case "touchend":
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
      ctx.strokeStyle = '#f7fdb0';
    };

    function mousedouble() {
      ctx.clearRect(0, 0, canvas.width, canvas.height);
    }

  },
};
</script>

<style scoped>
.new-cursor {
  cursor : url("data:image/svg+xml;urf8,<svg xmlns='http://www.w3.org/2000/svg' width='40' height='48' viewport='0 0 100 100'><text y='50%'>✏️</text></svg>") 0 25 , auto
}

#groupname {
  font-size:20px;
  background: linear-gradient(to bottom, #642EFE, #FA8EB6);
  color: transparent;
  -webkit-background-clip: text;
}

#eraser {
  background: url( "../assets/eraser.png" ) no-repeat;
  width: 60px;
  height: 107px;
  background-size:cover;
  margin-top: 10px;
}
</style>
