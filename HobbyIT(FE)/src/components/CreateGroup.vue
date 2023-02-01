<template>
  <div style="align-self:center;">
    <div style="width:1200px; border-radius: 20px; background-color:#20225A; padding:1px;">
      <v-card id="card" style="margin: 12px;">
        <div id="notopa" style="color:white; height:60px; display:flex; justify-content:space-between; padding:10px 5px; background: linear-gradient(180deg, rgba(14, 15, 40, 0) 0%, #0E0F28 100%);">
          <span></span>
          <span>HOBBY 만들기</span>
          <v-icon icon="mdi-close" size="small" @click="closecreategroup"></v-icon>
        </div>
        <div style="display:flex; background-color:#0E0F28;">
          <div style="width:490px; height:700px; background-color:#0E0F28; display: flex; align-items: center; justify-content: center;
                      border: 4px solid #FA8EB6;" @click="uploadimg">
            <v-icon icon = "mdi-plus-circle-outline" style="align-self: center; color: white; z-index:1;" v-if="!isImage"></v-icon>
            <img style="width:490px; height:700px; object-fit: cover;" id="realimg" v-else>
          </div>
          <input type="file" id="uploadimg" accept="image/*" required style="display:none">
          <div id="tri1" style=""></div>

          <div style="background-color:#0E0F28; flex-grow:1; color:white">
            <create-steps></create-steps>
          </div>

        </div>
      </v-card>
    </div>
  </div>
</template>

<script>
import CreateSteps from './CreateSteps.vue';

export default {
  components: {
    CreateSteps,
  },
  data(){
    return {
      rules: [v => v.length <= 200 || '최대 200자까지 작성가능합니다.'],
      content : "",
      uploadfile : {src:""},
      // temp
      isImage : false,
    }
  },
  methods : {
    closecreategroup() {
      this.$emit('closecreategroup');
    },
    uploadimg(){
      const upload = document.getElementById('uploadimg')
      this.isImage = true

      upload.click()
      upload.addEventListener('change', this.getImageFiles);
    },
    getImageFiles(e){

      const files = e.currentTarget.files
      console.log(typeof files, files)
      const file = files[0]


      // if (!file.type.match("image/.*")) {
      //     alert('이미지 파일만 업로드가 가능합니다.');
      //     return
      // }
      const reader = new FileReader();
      reader.onload = (e) => {

        const thumbnail = document.getElementById("realimg")
        thumbnail.setAttribute('src', e.target.result);
        thumbnail.setAttribute('data-file', file.name);

      }
      reader.readAsDataURL(file);
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

#circle {
  width:194px;
  height: 194px;
  border: 2px solid white;
  border-radius: 50%;
  position: absolute;
  left: 153px;
  bottom: 153px;
}

#tri1 {
  width: 0;
  height: 0;
  border-bottom: 30px solid transparent;
  border-top: 60px solid #FA8EB670;
  border-left: 15px solid #FA8EB670;
  border-right: 30px solid transparent;
  align-self: flex-end;
}
</style>
