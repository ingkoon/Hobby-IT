<template>
  <div id='background'>
    <div id='backtitle'>HOBBY'IT</div>
    <div id='signup'>
      <img
        src='/assets/gif/main1.gif'
        style='width: 400px; height: 580px; margin: 10px; border-radius: 10px; object-fit: cover'
      />
      <div style='flex-grow: 1'>
        <div style='font-size: 32px'>Just Hobby'<span style='color: #642efe'>It</span>!</div>
        <input
          id='emailinput'
          v-model='userEmail'
          placeholder='이메일'
          style='
            border: 2px solid white;
            border-radius: 30px;
            height: 44px;
            width: 270px;
            padding-left: 20px;
            margin: 15px 0 7px;
            color: white;
          '
          type='email'
          @keyup.enter='handleLogin'
        />
        <div id='checkemail' style='font-size: 12px; color: red; visibility: hidden;'>! 올바른 아이디를 입력해주세요. </div>
        <input
          id='pwdinput'
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
          @keyup.enter='handleLogin'
        />
        <div id='checkpwd' style='font-size: 12px; color: red; visibility: hidden;'>! 올바른 비밀번호를 입력해주세요.</div>

        <v-btn
          color='#EE49FD80'
          style='width: 270px; height: 44px; border-radius: 20px; color: white; font-size: 24px; margin-top: 20px'
          @click='handleLogin'
        >Log In
        </v-btn>
        <div style='text-align: right; margin-top:10px; margin-right: 60px; font-family: linefontbold'>
          <span id="findPassword" @click='handleGoResetPassword'>비밀번호 찾기</span>
        </div>

        <!-- <div id='divsns' style='font-family: linefont; margin-top: 20px'>SNS 로그인</div> -->
        <!-- <v-btn @click="kakaologin" color='#F7E600' style='width: 270px; height: 44px; font-size: 16px; margin-top: 20px'
        >카카오로 로그인
        </v-btn
        >
        <v-btn color='#ffffff' style='width: 270px; height: 44px; font-size: 16px; margin-top: 10px'
        >구글로 로그인
        </v-btn
        > -->

        <div style='font-size: 15px; text-align: right; margin-right: 60px; margin-top: 10px; font-family: linefont'>
          아직 회원이 아니신가요?
          <span id='gosignin' style='font-family: linefontbold' @click='handleGoSignup'>회원가입</span>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { memberLogin, getKakao } from '@/api/member';
import { useUserStore } from '@/store/user';

export default {
  setup() {
    const userStore = useUserStore();
    return { userStore };
  },
  data() {
    return {
      userEmail: null,
      userPassword: null,
    };
  },
  methods: {
    handleGoSignup() {
      this.$router.push('signup');
    },
    handleGoResetPassword() {
      this.$router.push('resetPassword');
    },
    async handleLogin() {
      const checkemail = document.getElementById('checkemail')
      const checkpwd = document.getElementById('checkpwd')

      if(this.userEmail == '' || this.userEmail == null) {
        checkemail.style.visibility = 'visible'
      }
      else{
        checkemail.style.visibility = 'hidden'
      }

      if(this.userPassword == '' || this.userPassword == null){
        checkpwd.style.visibility = 'visible'
      }
      else{
        checkpwd.style.visibility = 'hidden'
      }

      if(this.userEmail !== null && this.userEmail !== '' && this.userPassword !== null && this.userPassword !== '') {

        try {
          const loginData = {
            email: this.userEmail,
            password: this.userPassword,
          };
          const { data } = await memberLogin(loginData);
          this.userStore.setUser(data);
          console.log(data)
          this.$router.push({name : 'Main'});
        } catch (e) {
          checkemail.style.visibility = 'visible'
          checkpwd.style.visibility = 'visible'
        }

      }

    },
    kakaologin() {
      window.location.replace("https://kauth.kakao.com/oauth/authorize?client_id=65d9de3ecb31d4f1a02eb1e2affe862f&redirect_uri=http://localhost:8080/api/member/oauth/kakao&response_type=code")
      
    }
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

#findPassword,
#gosignin {
  color: #fa8eb6;
  font-size: 15px;
  cursor: pointer;
}

#checkemail,
#checkpwd,
#divsns {
  text-align: start;
  margin-left: 60px;
}
</style>
