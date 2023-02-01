<template>
  <div id="background">
    <div id="backtitle">HOBBY'IT</div>
    <div id="signup">
      <img src="/src/assets/gif/main1.gif" style="width:400px; height:580px; margin:10px; border-radius:10px; object-fit:cover">
      <div style="flex-grow:1">
        <div style="font-size:32px;">회원 <span style="color:#642EFE">가입</span></div>
        <input
          type="email"
          placeholder="email"
          style="border:2px solid white; border-radius:30px; height:44px; width:270px; padding-left:20px; margin:7px 0px 7px; color:white">
        <div id="checkemail" style="font-size:12px; color:red">! 이미 등록된 이메일입니다.</div>
        <input
          type="password"
          placeholder="password"
          style="border:2px solid white; border-radius:30px; height:44px; width:270px; padding-left:20px; margin:15px 0px 7px; color:white">
        <div id="checkpwd" style="font-size:12px; color:red">! 비밀번호를 입력해주세요.</div>
        <input
          type="text"
          placeholder="이름"
          style="border:2px solid white; border-radius:30px; height:44px; width:270px; padding-left:20px; margin:15px 0px 7px; color:white">
        <div id="checkname" style="font-size:12px; color:red">! 성명을 입력해주세요.</div>
        <input
          type="text"
          placeholder="활동할 닉네임"
          style="border:2px solid white; border-radius:30px; height:44px; width:270px; padding-left:20px; margin:15px 0px 7px; color:white">
        <div id="checknickname" style="font-size:12px; color:red">! 이미 사용중인 닉네임입니다.</div>
        <v-btn style="width:270px; height:44px; border-radius:20px; color:white; font-size:24px; margin-top:20px" color="#EE49FD80">Sign up</v-btn>
        <div style="font-size:15px; text-align:right; margin-right:60px; margin-top:5px">
          이미 계정이 있으신가요? <span id="gologin" @click="gologin">로그인</span>
        </div>
      
      </div>
    </div>
  </div>
</template>

<script>
export default {
  methods : {
    gologin(){
      this.$router.push('LogIn')
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