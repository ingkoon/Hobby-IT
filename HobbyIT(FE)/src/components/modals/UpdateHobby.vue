<!--suppress ALL -->

<template>
  <div class='bg' style='align-self: center'>
    <div style='width: 1000px; border-radius: 20px; border: 4px solid #24B1D0; background-color: #0e0f28; padding: 1px'>
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
          <span style='font-size: 20px; font-weight: 700; margin-left: 80px'>HOBBY 정보 수정</span>
          <v-icon icon='mdi-close' size='24' style='margin-right: 10px' @click='closehobupdate'></v-icon>
        </div>
        <div style='display: flex; width:350px; margin-right:0; background-color: #0e0f28;'>
          <div
            style='
              width: 350px;
              height: 500px;
              background-color: #0e0f28;
              border: 4px solid #fa8eb6;
              display: flex;
              justify-content: center;
              align-items: center;
            '
            @click='uploadimg'
          >
            <div style="positon: relative;">
              <img id='realimg' style='width: 340px; height: 493px; object-fit: cover; margin-top: 8px;' />
            </div>

            <div
            style="
            position: absolute;
            width: 80px; height: 80px;
            background: rgba(14, 15, 40, 0.3);
            backdrop-filter: blur(2px);
            border-radius: 10px;
            display: flex;
            text-align: center;
            align-items: center;
            justify-content: center;
          ">
              <v-icon
                icon='mdi-swap-vertical-bold'
                size="45"
                style='color: white; opacity: 0.5;'
              ></v-icon>
            </div>
          </div>
          <input id='uploadimg' accept='image/*' required style='display: none' type='file' />

          <div id='tri1'></div>

          <v-divider vertical length="500px" style="margin:0px 80px 0px 20px; color: white;"></v-divider>

          <div style="display: flex; flex-direction: column; justify-content: center; align-items: center; color: white;">
            <div style="margin: 30px 0 50px 0; font-size: 20px;">
              <v-icon icon="mdi-chat-question"></v-icon>
              "{{ hobbyname }}"에 대해 소개해주세요!
            </div>
            <div>
              <v-textarea
                :model-value="content"
                :rules="rules"
                auto-grow=false
                color=white
                counter
                placeholder="어떤 모임인지 알려주세요"
                rows="10"
                max-rows="10"
                no-resize=true
                label="우리 모임은.."
                style="margin:0 10px; width:400px;"
                variant="outlined"
              ></v-textarea>
            </div>
            <div style="display: flex; justify-content: center; align-items: center;">
              <v-btn
              prepend-icon="mdi-close-octagon"
              width="150px"
              style="background-color: #0E0F28; color: red; margin: 0px 80px 5px 10px; border: 2px solid #FE6464; border-radius: 5px; font-weight: 900;"
              >
              모임 삭제하기
                <v-dialog v-model="delgroup" activator="parent">
                  <del-group @close="close" />
                </v-dialog>
              </v-btn>
              <v-btn
              icon="mdi-check"
              size="36"
              style="background-color: #FA8EB6; color: white; margin: 0px -30px 5px 170px;"
              @click="closehobupdate"
              >
              </v-btn>
            </div>
          </div>
        </div>
      </v-card>
    </div>
  </div>
</template>

<script>
import { createGroup } from '@/api/hobby';
import DelGroup from "./DelGroup.vue";

export default {
  components: {
    DelGroup,
  },
  data() {
    return {
      rules: [v => v.length <= 200 || '최대 200자까지 작성가능합니다.'],
      hobbyname: '우리개는 안물어요',
      content: '애견 정보 공유 / 집사들의 모임',
      file: null,
      // temp
      isImage: false,
      delgroup: false,
    };
  },
  mounted() {
  },
  methods: {
    async handleSubmit(data) {
      const formData = new FormData();
      formData.append('request', new Blob([JSON.stringify(data)], { type: 'application/json' }));
      formData.append('multipartFile', this.file);
      console.log(formData);

      const res = await createGroup(formData);

    },
    closehobupdate() {
      this.$emit('closehobupdate');
    },
    uploadimg() {
      const upload = document.getElementById('uploadimg');
      this.isImage = true;

      upload.click();
      upload.addEventListener('change', this.getImageFiles);
    },
    getImageFiles(e) {
      const files = e.currentTarget.files;
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

    opendelgroup() {
      this.delgroup = true;
    },
    close() {
      this.delgroup = false;
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
