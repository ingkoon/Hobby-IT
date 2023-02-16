<template>
  <v-card id='member-update-card'>
    <div style='display: flex; justify-content: space-between; align-items: center; width:100%; margin-top: 5px;'>
      <div style='font-size: 24px; margin: 4px 0px 0px 25px;'>
        <v-icon icon='mdi-account-edit' size='30' style='margin: -4px 0px 0px 0px; color:#FA8EB6;'></v-icon>
        회원 정보 수정
      </div>
      <v-btn
        icon='mdi-close'
        style='background-color: rgba(0, 0, 0, 0); color: white; text-align: right; margin: 0px 0px 0px 0px;'
        variant='flat'
        @click='closeModal'>
      </v-btn>
    </div>
    <div style='display: flex; width: 100%; margin-top: 20px;'>
      <div style='margin-left: 50px;'>
        <div
          style='
            width: 200px;
            height: 200px;
            background-color: #0e0f28;
            display: flex;
            align-items: center;
            justify-content: center;
            border-radius: 200px;
            border: 4px solid #fa8eb6;
          '
          @click='uploadImage'
        >
          <img id='realimg' style='width: 185px; height: 185px; object-fit: cover; border-radius: 300px;' />
        </div>
        <div
          style='
          margin-top: 20px;
          width: 200px;
          height:70px;
          border: 4px solid #fa8eb6;
          border-radius: 90px 90px 0px 0px / 50px 50px 0px 0px;
          background: linear-gradient(179.58deg, #2D22B1 5%, rgba(217, 217, 217, 0) 99.64%);
          '
        >
        </div>
        <div>
          <v-text-field
            color='white'
            label='이름'
            v-model='username'
            :readonly='true'
            style='margin: 20px 10px 0px 0px; width:200px; color: white; background-color: #0e0f28;'
            variant='outlined'
          ></v-text-field>
        </div>
      </div>
      <input id='uploadimg' accept='image/*' required style='display: none' type='file' />

      <v-divider length='370px' style='margin-left: 50px;' vertical></v-divider>

      <div
        style='display: flex; flex-direction: column; justify-content: center; margin: 0px 0px 0px 50px; text-align: left;'>
        <div>
          <v-text-field
            v-model='nickname'
            color='white'
            label='닉네임'
            placeholder="Hobby'It에서 활동할 닉네임"
            style='margin:0 10px; width:350px;'
            variant='underlined'
          ></v-text-field>
          <div id='checknickname' style='font-size: 12px; color: red; visibility:hidden'>! 중복된 닉네임입니다.</div>
        </div>
        <div>
          <v-textarea
            v-model='intro'
            :auto-grow='false'
            color='white'
            counter
            label='Who am I?'
            max-rows='4'
            :no-resize='true'
            placeholder='자기소개 (4줄까지 보여집니다)'
            rows='4'
            style='margin:0 10px; width:350px;'
            variant='outlined'
          ></v-textarea>
        </div>
        <div class="pw">
          <v-text-field
            v-model='password'
            color='white'
            label='변경할 비밀번호'
            style='margin:0 10px; width:350px;'
            type='password'
            variant='underlined'
          ></v-text-field>
        </div>
        <div class="pw">
          <v-text-field
            v-model='checkpassword'
            color='white'
            label='변경할 비밀번호 확인'
            style='margin:0 10px; width:350px;'
            type='password'
            variant='underlined'
          ></v-text-field>
          <div id='checkpwd' style='font-size: 12px; color: red; visibility:hidden'>! 입력한 비밀번호가 일치하지 않습니다.</div>
        </div>
        <div
          style='display: flex; justify-content: center; align-items: center; text-align: center; margin-left: 270px;'>
          <div style='font-size: 16px; margin: 0px 0px 0px 0px; text-align: right;'>
            수정하기
          </div>
          <v-btn
            icon='mdi-pencil-outline'
            style='background-color: rgba(0, 0, 0, 0); color: white; align-self:end; margin: 0px -30px 5px -5px;'
            variant='flat'
            @click='handleSubmit'></v-btn>
        </div>
      </div>
    </div>


  </v-card>
</template>

<script>
import { updateMyPage } from '@/api/member';

export default {
  props: {
    propNickname: {
      type: String,
      default: '',
    },
    propIntro: {
      type: String,
      default: '',
    },
    propUsername:{
      type: String,
      default: '',
    },
  },
  data() {
    return {
      nickname: this.propNickname,
      intro: this.propIntro,
      username: this.propUsername,
      password: '',
      checkpassword: '',
      isImage: false,
      file: null,
    };
  },
  methods: {
    async handleSubmit() {
      const checknickname = document.getElementById('checknickname')
      const checkpwd = document.getElementById('checkpwd')
      if (this.password !== this.checkpassword) {
        checkpwd.style.visibility = 'visible'
      } else {
        checkpwd.style.visibility = 'hidden'
        const data = {
          nickname: this.nickname,
          intro: this.intro,
          password: this.password,
        };
        const formData = new FormData();
        formData.append('request', new Blob([JSON.stringify(data)], { type: 'application/json' }));
        if (this.file) {
          formData.append('multipartFile', this.file);
        } else {
          const emptyFile = new Blob([], { type: 'image/png' });
          formData.append('multipartFile', emptyFile);
        }
        try {
          const res = await updateMyPage(formData);
          this.$emit('updateUserInfo', data);
          this.$emit('afterUpdateSuccess')
        } catch (err) {
          console.error(err);
          if(err.response.data.message == '중복된 닉네임입니다.') {
            checknickname.innerText = "! 중복된 닉네임입니다."
            checknickname.style.visibility = 'visible'
          } else {
            checknickname.style.visibility = 'hidden'
          }
        }
      }
    },
    async uploadImage() {
      const upload = document.getElementById('uploadimg');
      this.isImage = true;
      upload.click();
      upload.addEventListener('change', this.getImageFiles);
    },
    closeModal() {
      this.$emit('closeModal');
    },
    getImageFiles(e) {
      const files = e.currentTarget.files;
      this.file = files[0];
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

<style>

#member-update-card {
  width: 800px;
  height: 500px;
  display: flex;
  align-self: center;
  text-align: center;
  /*justify-content:center;*/
  background-color: #0E0F28;
  color: white;
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

#checknickname, 
#checkpwd {
  text-align: start;
  margin-left: 10px;
  margin-top: -19px;
  margin-bottom: 13px;
}

.pw {
  height: 60px;
}

</style>
