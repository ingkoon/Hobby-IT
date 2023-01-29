<template>
  <div style="align-self:center">
    <v-card id="card" style="width:800px; height: 560px; ">
      <div id="notopa" style="color:white; height:60px; display:flex; justify-content:space-between; padding:10px 5px; background-color:#0E0F28">
        <span id="groupname">To. John, 나 여행가고싶어</span>
        <span>게시글 작성</span>
        <v-icon icon="mdi-close" size="small"></v-icon>
      </div>
      <div style="display:flex;">
        <div style="width:500px; height:500px; background-color:#FA8EB630" @click="uploadimg" id="realimg">            
          <div id="line">
            <div id="line9"></div>
            <div id="line7"></div>
            <div id="line6"></div>
            <div id="line5"></div>
            <div id="line8"></div>
            <div id="line10"></div>
            <div id="circle"></div>
          </div>
        </div>
        <input type="file" id="uploadimg" accept="image/*" required multiple style="display:none">

        <div style="background-color:#0E0F28; flex-grow:1; color:white">
          <div style="margin : 5px 10px">
            <v-icon icon="mdi-account-circle" color="blue-lighten-2" style="margin-right:10px" ></v-icon>
            다나카
          </div>

          <v-text-field
            placeholder="제목"
            color="white"
            style="margin:15px 10px"
          ></v-text-field>

          <v-textarea
            variant="outlined"
            counter
            :rules="rules"
            :model-value="content"
            color="white"
            placeholder="본문"
            style="margin:15px; height:100px"
            auto-grow="false"
          ></v-textarea>
        </div>

      </div>
    </v-card>
  </div>
</template>

<script>
export default {
  data(){
    return {
      rules: [v => v.length <= 200 || '최대 200자까지 작성가능합니다.'],
      content : "",
    }
  },
  methods : {
    uploadimg(){
      function getImageFiles(e){
        const uploadFiles = []
        const files = e.currentTarget.files
        console.log(typeof files, files)

        if([...files].length >= 11) {
          alert('이미지는 10개까지 업로드가 가능합니다')
          return;
        }

        [...files].forEach(file => {
          if ([...files].length < 11){
            uploadFiles.push(file)
          const reader = new FileReader();
          reader.onload = (e) => {
            const preview = createElement(e, file)
            realimg.appendChild(preview)
          }
          reader.readAsDataURL(file);
          }
        })
      }

      function createElement(e, file){
        const img = document.createElement('img')
        img.setAttribute('src', e.target.result);
        img.setAttribute('data-file', file.name);

        const line = document.getElementById('line')
        line.setAttribute('style', 'display:none')
        return img
      }

      const realimg = document.getElementById('realimg')
      const upload = document.getElementById('uploadimg')

      upload.click()
      upload.addEventListener('change', getImageFiles);
    },
    
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

#line9 {
  width: 2px;
  height: 500px;
  background-color :white;
  position: absolute;
  left: 250px;
}
#line7 {
  width: 2px;
  height: 500px;
  background-color :white;
  position: absolute;
  left: 470px;
}
#line6 {
  width: 2px;
  height: 500px;
  background-color :white;
  position: absolute;
  left: 30px;
}
#line10 {
  height: 2px;
  width: 500px;
  background-color :white;
  position: absolute;
  bottom: 250px;
}
#line5 {
  height: 2px;
  width: 500px;
  background-color :white;
  position: absolute;
  bottom: 470px;
}
#line8 {
  height: 2px;
  width: 500px;
  background-color :white;
  position: absolute;
  bottom: 30px;
}
#circle {
  width:194px;
  height: 194px;
  border: 2px solid white;
  border-radius: 50%;
  position: absolute;
  left: 153px;
  bottom: 153px;
}
</style>