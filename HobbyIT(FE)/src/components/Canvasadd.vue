<template>
  <div style="align-self:center">
    <v-card style="width:800px; height: 500px; background-color:#0E0F28">
      <div style="color:white; display:flex; justify-content:space-between; margin:10px 5px;">
        <span id="groupname">To. John, 나 여행가고싶어</span>
        <span>방명록 작성</span>
        <v-icon icon="mdi-close" size="small" @click="closeaddmodal"></v-icon>
      </div>
      <div style="display:flex">
        <canvas class="new-cursor" id="canvas" width="500" height="500" style="background-color:#f7fdb0"></canvas>
        <div>
          여기 내용들
        </div>
      </div>
    </v-card>
  </div>
</template>

<script>

export default {
  data(){
    return {
      canvasmodal : true,
    }
  },
  methods : {
    closemodal() {
      this.canvasmodal = false
      
    }
  },
  mounted() {

    var pos = {
      drawable: false,
      x: -1,
      y: -1,
    };

    var canvas = document.getElementById('canvas')
    var ctx = canvas.getContext('2d');
    var rect = canvas.getBoundingClientRect();  // 터치 스크린

    canvas.addEventListener("mousedown", listener);
    canvas.addEventListener("mousemove", listener);
    canvas.addEventListener("mouseup", listener);
    canvas.addEventListener("mouseout", listener);

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
</style>
