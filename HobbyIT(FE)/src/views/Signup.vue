<template>
  <div id='background'>
    <div id='backtitle'>HOBBY'IT</div>
    <div id='signup'>
      <img
        alt='main'
        src='/assets/gif/main1.gif'
        style='width: 400px; height: 580px; margin: 10px; border-radius: 10px; object-fit: cover'
      />
      <div style='flex-grow: 1'>
        <div style='font-size: 32px'>회원 <span style='color: #642efe'>가입</span></div>
        <input
          v-model='userEmail'
          placeholder='이메일'
          style='
            border: 2px solid white;
            border-radius: 30px;
            height: 44px;
            width: 270px;
            padding-left: 20px;
            margin: 7px 0 7px;
            color: white;
          '
          type='email'
          @keyup.enter = 'handleSignup'
        />
        <div id='checkemail' style='font-size: 12px; color: red; visibility:hidden'>! 이메일을 입력해주세요.</div>
        <input
          v-model='userPassword'
          placeholder='비밀번호'
          style='
            border: 2px solid white;
            border-radius: 30px;
            height: 44px;
            width: 270px;
            padding-left: 20px;
            margin: 15px 0 7px;
            color: white;
          '
          type='password'
          @keyup.enter = 'handleSignup'
        />
        <div id='checkpwd' style='font-size: 12px; color: red; visibility:hidden'>! 비밀번호를 입력해주세요.</div>
        <input
          v-model='username'
          placeholder='이름'
          style='
            border: 2px solid white;
            border-radius: 30px;
            height: 44px;
            width: 270px;
            padding-left: 20px;
            margin: 15px 0 7px;
            color: white;
          '
          type='text'
          @keyup.enter = 'handleSignup'
        />
        <div id='checkname' style='font-size: 12px; color: red; visibility:hidden'>! 이름을 입력해주세요.</div>
        <input
          v-model='userNickname'
          placeholder='활동할 닉네임'
          style='
            border: 2px solid white;
            border-radius: 30px;
            height: 44px;
            width: 270px;
            padding-left: 20px;
            margin: 15px 0 7px;
            color: white;
          '
          type='text'
          @keyup.enter = 'handleSignup'
        />
        <div id='checknickname' style='font-size: 12px; color: red; visibility:hidden'>! 닉네임을 입력해주세요.</div>
        <v-btn
          color='#EE49FD80'
          style='width: 270px; height: 44px; border-radius: 20px; color: white; font-size: 24px; margin-top: 20px'
          @click='handleSignup'
        >Sign up
        </v-btn>
        <div style='font-size: 15px; text-align: right; margin-right: 60px; margin-top: 10px'>
          이미 계정이 있으신가요? <span id='gologin' @click='gologin'>로그인</span>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { useUserStore } from '@/store/user';
import { memberLogin, memberSignup } from '@/api/member';

export default {
  setup() {
    const userStore = useUserStore();

    return { userStore };
  },
  data() {
    return {
      userEmail: '',
      userPassword: '',
      username: '',
      userNickname: '',
    };
  },
  methods: {
    gologin() {
      this.$router.push('LogIn');
    },
    async handleSignup() {
      const checkemail = document.getElementById('checkemail')
      const checkpwd = document.getElementById('checkpwd')
      const checkname = document.getElementById('checkname')
      const checknickname = document.getElementById('checknickname')

      if(this.userEmail == '' || this.userEmail == null){
        checkemail.innerText = "! 이메일을 입력해주세요."
        checkemail.style.visibility = 'visible'
      } else {
        checkemail.style.visibility = 'hidden'
      }
      if(this.userPassword == '' || this.userPassword == null){
        checkpwd.style.visibility = 'visible'
      } else {
        checkpwd.style.visibility = 'hidden'
      }
      if(this.username == '' || this.username == null){
        checkname.style.visibility = 'visible'
      } else {
        checkname.style.visibility = 'hidden'
      }
      if(this.userNickname == '' || this.userNickname == null){
        checknickname.style.visibility = 'visible'
      } else {
        checknickname.style.visibility = 'hidden'
      }

      if(this.userEmail !== null && this.userPassword !== null && this.userName !== null && this.userNickname !== null){
        try {
          const signupData = {
            email: this.userEmail,
            name: this.username,
            nickname: this.userNickname,
            password: this.userPassword,
          }
          const res = await memberSignup(signupData);
          this.userStore.afterSignup(signupData);

          const loginData = {
            email: this.userEmail,
            password: this.userPassword,
          };

          const { data } = await memberLogin(loginData);
          console.log(data);
          this.userStore.setUser(data);

          this.$router.push({name : 'Main'});
        } catch (err) {
          console.log(err);
          if (this.userEmail !== '' && err.response.data.message == undefined) {
            checkemail.innerText = "! 올바른 이메일을 입력해주세요."
            checkemail.style.visibility = 'visible'
          } else if(err.response.data.message == '중복된 이메일입니다.') {
            checkemail.innerText = "! 중복된 이메일입니다."
            checkemail.style.visibility = 'visible'
          } else if(err.response.data.message == '중복된 닉네임입니다.') {
            checknickname.innerText = "! 중복된 닉네임입니다."
            checknickname.style.visibility = 'visible'
          }
        }
      }
    },
  },
};
</script>

<style>
#background {
  width: 100%;
  height: 100%;
  background: linear-gradient(to bottom, #0e0f28, #a8456a);
  color: #fa8eb680;
  text-align: center;
  display: flex;
  align-items: center;
  justify-content: center;
  position: relative;
}

#backtitle {
  font-size: 150px;
  letter-spacing: 0.3em;
  font-family: logofont;
}

#signup {
  background: #0e0f2880;
  position: absolute;
  width: 800px;
  height: 600px;
  box-shadow: 0 4px 100px #ece5ff;
  border-radius: 20px;
  display: flex;
  align-items: center;
  justify-content: center;
  color: white;
}

#gologin {
  color: #fa8eb6;
  font-size: 15px;
  cursor: pointer;
}

#checkemail,
#checkpwd,
#checkname,
#checknickname {
  text-align: start;
  margin-left: 60px;
}
</style>
