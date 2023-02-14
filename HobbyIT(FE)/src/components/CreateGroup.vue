<!--suppress ALL -->

<template>
  <div class='bg' style='align-self: center'>
    <div style='width: 1000px; border-radius: 20px; background-color: #20225a; padding: 1px'>
      <v-card id='card' style='margin: 12px'>
        <div
          id='notopa'
          style='
            color: white;
            height: 60px;
            display: flex;
            justify-content: space-between;
            padding: 10px 5px;
            background: linear-gradient(180deg, rgba(14, 15, 40, 0) 0%, #0e0f28 100%);
          '
        >
          <span></span>
          <span style='font-size: 20px; font-weight: 700; margin-left: 80px'>HOBBY 만들기</span>
          <v-icon icon='mdi-close' size='24' style='margin-right: 10px' @click='closecreategroup'></v-icon>
        </div>
        <div style='display: flex; background-color: #0e0f28'>
          <div
            style='
              width: 350px;
              height: 500px;
              background-color: #0e0f28;
              display: flex;
              align-items: center;
              justify-content: center;
              border: 4px solid #fa8eb6;
            '
            @click='uploadimg'
          >
            <v-icon
              v-if='!isImage'
              icon='mdi-plus-circle-outline'
              style='align-self: center; color: white; z-index: 1'
            ></v-icon>
            <img v-else id='realimg' style='width: 350px; height: 500px; object-fit: cover' />
          </div>
          <input id='uploadimg' accept='image/*' required style='display: none' type='file' />
          <div id='tri1' style=''></div>

          <div style='background-color: #0e0f28; flex-grow: 1; color: white'>
            <create-steps @handle-submit='handleSubmit'></create-steps>
          </div>
        </div>
      </v-card>
    </div>
  </div>
</template>

<script>
import CreateSteps from './CreateSteps.vue';
import { createGroup } from '@/api/hobby';

export default {
  components: {
    CreateSteps,
  },
  data() {
    return {
      rules: [v => v.length <= 200 || '최대 200자까지 작성가능합니다.'],
      content: '',
      file: null,
      // temp
      isImage: false,
    };
  },
  mounted() {
  },
  methods: {
    async handleSubmit(data) {
      const formData = new FormData();
      formData.append('request', new Blob([JSON.stringify(data)], { type: 'application/json' }));
      formData.append('multipartFile', this.file);
      this.closecreategroup();
      const res = await createGroup(formData);

    },
    closecreategroup() {
      this.$emit('closecreategroup');
    },
    uploadimg() {
      const upload = document.getElementById('uploadimg');
      this.isImage = true;

      upload.click();
      upload.addEventListener('change', this.getImageFiles);
    },
    getImageFiles(e) {
      const files = e.currentTarget.files;
      console.log(files);
      this.file = files[0];
      console.log(typeof files, files);
      const file = files[0];

      // if (!file.type.match("image/.*")) {
      //     alert('이미지 파일만 업로드가 가능합니다.');
      //     return
      // }
      const reader = new FileReader();
      reader.onload = e => {
        const thumbnail = document.getElementById('realimg');
        thumbnail.setAttribute('src', e.target.result);
        thumbnail.setAttribute('data-file', file.name);
      };
      reader.readAsDataURL(file);
    },
  },
};
</script>

<style scoped>
.bg {
  font-family: 'LINESeedKR-Rg';
}

@font-face {
  font-family: 'LINESeedKR-Rg';
  src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_11-01@1.0/LINESeedKR-Rg.woff2') format('woff2');
  font-weight: 400;
  font-style: normal;
}

#groupname {
  font-size: 20px;
  background: linear-gradient(to bottom, #642efe, #fa8eb6);
  color: transparent;
  -webkit-background-clip: text;
}

#card {
  background-color: rgba(255, 255, 255, 0);
}

#circle {
  width: 194px;
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
  border-top: 60px solid #fa8eb670;
  border-left: 15px solid #fa8eb670;
  border-right: 30px solid transparent;
  align-self: flex-end;
}
</style>
