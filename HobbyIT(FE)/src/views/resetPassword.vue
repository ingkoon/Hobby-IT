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
        <div style='font-size: 32px'>비밀번호 <span style='color: #642efe'>찾기</span></div>
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
          @keyup.enter = 'handleResetPassword'
        />
        <div id='checkemail' style='font-size: 12px; color: red; visibility:hidden'>! 올바른 이메일을 입력해주세요.</div>
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
          @keyup.enter = 'handleResetPassword'
        />
        <div id='checkname' style='font-size: 12px; color: red; visibility:hidden'>! 올바른 이름을 입력해주세요.</div>
        <v-btn
          color='#EE49FD80'
          style='width: 270px; height: 44px; border-radius: 20px; color: white; font-size: 24px; margin-top: 20px'
          @click='handleResetPassword'
        >Send Email
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
import { memberLogin, memberSignup, resetPassword } from '@/api/member';

export default {
  setup() {
    const userStore = useUserStore();

    return { userStore };
  },
  data() {
    return {
      userEmail: '',
      username: '',
    };
  },
  methods: {
    gologin() {
      this.$router.push('LogIn');
    },
    async handleResetPassword() {
      const checkemail = document.getElementById('checkemail')
      const checkname = document.getElementById('checkname')

      if(this.userEmail == '' || this.userEmail == null){
        checkemail.style.visibility = 'visible'
      } else {
        checkemail.style.visibility = 'hidden'
      }
      if(this.username == '' || this.username == null){
        checkname.style.visibility = 'visible'
      } else {
        checkname.style.visibility = 'hidden'
      }

      if(this.userEmail !== '' && this.username !== ''){
        try {
          const resetPasswordData = {
            email: this.userEmail,
            name: this.username,
          }
          const res = await resetPassword(resetPasswordData);
          // this.userStore.afterSignup(resetPasswordData);

          // const loginData = {
          //   email: this.userEmail,
          //   password: this.userPassword,
          // };

          // const { data } = await memberLogin(loginData);
          // console.log(data);
          // this.userStore.setUser(data);

          this.$router.push({name : 'Main'});
        } catch (err) {
          console.log(err);
          if (err.response.data.message == "사용자를 찾을 수 없습니다.") {
            checkemail.innerText = "! 사용자를 찾을 수 없습니다."
            checkemail.style.visibility = 'visible'
          }
          else if (err.response.data.message == undefined) {
            checkemail.innerText = "! 올바른 이메일을 입력해주세요."
            checkemail.style.visibility = 'visible'
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
