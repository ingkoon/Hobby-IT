<template>
  <div id="background">
    <div id="backtitle">HOBBY'IT</div>
    <div id="signup">
      <img src="/src/assets/gif/main1.gif" style="width:400px; height:580px; margin:10px; border-radius:10px; object-fit:cover">
      <div style="flex-grow:1">
        <div style="font-size:32px;">회원 <span style="color:#642EFE">가입</span></div>
        <input
          v-model='userEmail'
          placeholder="email"
          style="border:2px solid white; border-radius:30px; height:44px; width:270px; padding-left:20px; margin:7px 0px 7px; color:white"
          type="email"
        >
        <div id="checkemail" style="font-size:12px; color:red">! 이미 등록된 이메일입니다.</div>
        <input
          v-model='userPassword'
          placeholder="password"
          style="border:2px solid white; border-radius:30px; height:44px; width:270px; padding-left:20px; margin:15px 0px 7px; color:white"
          type="password">
        <div id="checkpwd" style="font-size:12px; color:red">! 비밀번호를 입력해주세요.</div>
        <input
          v-model='username'
          placeholder="이름"
          style="border:2px solid white; border-radius:30px; height:44px; width:270px; padding-left:20px; margin:15px 0px 7px; color:white"
          type="text">
        <div id="checkname" style="font-size:12px; color:red">! 성명을 입력해주세요.</div>
        <input
          v-model='userNickname'
          placeholder="활동할 닉네임"
          style="border:2px solid white; border-radius:30px; height:44px; width:270px; padding-left:20px; margin:15px 0px 7px; color:white"
          type="text">
        <div id="checknickname" style="font-size:12px; color:red">! 이미 사용중인 닉네임입니다.</div>
        <v-btn color="#EE49FD80" style="width:270px; height:44px; border-radius:20px; color:white; font-size:24px; margin-top:20px" @click='handleSignup'>Sign up</v-btn>
        <div style="font-size:15px; text-align:right; margin-right:60px; margin-top:5px">
          이미 계정이 있으신가요? <span id="gologin" @click="gologin">로그인</span>
        </div>

      </div>
    </div>
  </div>
</template>

<script>
import { useUserStore } from '@/store/user';
import { memberLogin, memberSignup } from '@/api/member';

export default {
  setup(){
    const userStore = useUserStore()

    return {userStore}
  },
  data(){
    return{
      userEmail: '',
      userPassword: '',
      username: '',
      userNickname: '',
    }
  },
  methods : {
    gologin(){
      this.$router.push('LogIn')
    },
    async handleSignup(){
      try {
        const signupData = {
          "email":this.userEmail,
          "name":this.username,
          "nickname":this.userNickname,
          "password":this.userPassword
        }
        const res = await memberSignup(signupData)
        this.userStore.afterSignup(signupData)

        const loginData = {
          "email": this.userEmail,
          "password":this.userPassword,
        }

        const { data } = await memberLogin(loginData);
        console.log(data);
        this.userStore.setUser(data)



        this.$router.push('/')
      }catch (err){
        console.error(err);
      }
    }
  }
}
</script>

<style>
#background {
  width: 100%;
  height: 100%;
  background: linear-gradient(to bottom, #0E0F28, #A8456A);
  color: #FA8EB680;
  text-align: center;
  display: flex;
  align-items: center;
  justify-content: center;
  position: relative;
}

#backtitle {
  font-size:150px;
  letter-spacing: 0.3em;
  font-family: logofont;

}

#signup {
  background: #0E0F2880;
  position: absolute;
  width:800px;
  height: 600px;
  box-shadow: 0px 4px 100px #ECE5FF;
  border-radius: 20px;
  display: flex;
  align-items: center;
  justify-content: center;
  color:white;
}

#gologin {
  color : #FA8EB6;
  font-size : 15px;
  cursor: pointer;
}

#checkemail, #checkpwd, #checkname, #checknickname {
  text-align: start;
  margin-left: 60px;
}

</style>
