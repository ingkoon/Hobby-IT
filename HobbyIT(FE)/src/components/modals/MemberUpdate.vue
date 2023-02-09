<template>
  <v-card id="memupdate">
    <div style="display: flex; justify-content: space-between; align-items: center; width:100%; margin-top: 5px;">
      <div style="font-size: 24px; margin: 4px 0px 0px 25px;">
        <v-icon icon="mdi-account-edit" size="30" style="margin: -4px 0px 0px 0px; color:#FA8EB6;"></v-icon>
        회원 정보 수정
      </div>
      <v-btn variant="flat" icon="mdi-close" @click="closememupdate"
            style="background-color: rgba(0, 0, 0, 0); color: white; text-align: right; margin: 0px 0px 0px 0px;">
      </v-btn>
    </div>
    <div style="display: flex; width: 100%; margin-top: 20px;">
      <div style="margin-left: 50px;">
        <div
          style="
            width: 200px;
            height: 200px;
            background-color: #0e0f28;
            display: flex;
            align-items: center;
            justify-content: center;
            border-radius: 200px;
            border: 4px solid #fa8eb6;
          "
          @click="uploadimg"
        >
          <!-- <v-icon
            v-if="!isImage"
            icon="mdi-plus-circle-outline"
            style="align-self: center; color: white; z-index: 1"
          ></v-icon> -->
          <img id="realimg" style="width: 185px; height: 185px; object-fit: cover; border-radius: 300px;" />
        </div>
        <div
          style="
          margin-top: 20px;
          width: 200px;
          height:70px;
          border: 4px solid #fa8eb6;
          border-radius: 90px 90px 0px 0px / 50px 50px 0px 0px;
          background: linear-gradient(179.58deg, #2D22B1 5%, rgba(217, 217, 217, 0) 99.64%);
          "
        >
        </div>
        <div>
          <v-text-field
            color="white"
            label="이름"
            model-value="김싸피"
            readonly=true
            variant="outlined"
            style="margin: 20px 10px 0px 0px; width:200px; color: white; background-color: #0e0f28;"
          ></v-text-field>
        </div>
      </div>
      <input id="uploadimg" accept="image/*" required style="display: none" type="file" />

      <v-divider vertical length="370px" style="margin-left: 50px;"></v-divider>

      <div style="display: flex; flex-direction: column; justify-content: center; margin: 0px 0px 0px 50px; text-align: left;">
        <div>
          <v-text-field
            color="white"
            label="닉네임"
            placeholder="Hobby'It에서 활동할 닉네임"
            :model-value="nickname"
            style="margin:0 10px; width:350px;"
            variant="underlined"
          ></v-text-field>
        </div>
        <div>
          <v-textarea
            :model-value="content"
            :rules="rules"
            auto-grow=false
            color="white"
            counter
            placeholder="자기소개 (4줄까지 보여집니다)"
            rows="4"
            max-rows="4"
            no-resize=true
            label="Who am I?"
            style="margin:0 10px; width:350px;"
            variant="outlined"
          ></v-textarea>
        </div>
        <div>
          <v-text-field
            color="white"
            label="비밀번호"
            :model-value="password"
            style="margin:0 10px; width:350px;"
            variant="underlined"
          ></v-text-field>
        </div>
        <div>
          <v-text-field
            color="white"
            label="비밀번호 확인"
            model-value="******"
            style="margin:0 10px; width:350;"
            variant="underlined"
          ></v-text-field>
        </div>
        <div style="display: flex; justify-content: center; align-items: center; text-align: center; margin-left: 270px;">
          <div style="font-size: 16px; margin: 0px 0px 0px 0px; text-align: right;">
            수정하기
          </div>
          <v-btn variant="flat" icon="mdi-pencil-outline" @click="closememupdate"
                style="background-color: rgba(0, 0, 0, 0); color: white; align-self:end; margin: 0px -30px 5px -5px;"></v-btn>
        </div>
      </div>
    </div>




  </v-card>
</template>

<script>
export default {
  data: () => ({
    nickname: '호방맨',
    content: '반갑습니다',
    password: '******',
    uploadfile: { src: '' },
    // temp
    isImage: false,
  }),
  methods: {
    closememupdate() {
      this.$emit('closememupdate')
    },
    uploadimg() {
      const upload = document.getElementById('uploadimg');
      this.isImage = true;

      upload.click();
      upload.addEventListener('change', this.getImageFiles);
    },
    getImageFiles(e) {
      const files = e.currentTarget.files;
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
}
</script>

<style>

#memupdate {
  width:800px;
  height:500px;
  display:flex;
  align-self:center;
  text-align:center;
  /*justify-content:center;*/
  background-color:#0E0F28;
  color:white;
  font-family: linefontbold;
  border: 2px solid #24B1D0;
  border-radius: 20px;
  padding: 5px 20px;
  justify-content: space-evenly;
  align-items: center;
}

div.v-list.v-theme--light.v-list--density-default.v-list--one-line {
  background-color: #0E0F28;
  border: 2px solid #24B1D0;
  text-align: center;
  color: white;
  font-family: linefont;
}


</style>
