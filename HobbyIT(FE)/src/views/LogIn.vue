<template>
  <div id="background">
    <div id="backtitle">HOBBY'IT</div>
    <div id="signup">
      <img src="/src/assets/gif/main1.gif" style="width:400px; height:580px; margin:10px; border-radius:10px; object-fit:cover">
      <div style="flex-grow:1">
        <div style="font-size:32px;">Just Hobby'<span style="color:#642EFE">It</span>!</div>
        <input
          type="email"
          placeholder="email"
          style="border:2px solid white; border-radius:30px; height:44px; width:270px; padding-left:20px; margin:15px 0px 7px; color:white">
        <div id="checkemail" style="font-size:12px; color:red">! 이미 등록된 이메일입니다.</div>
        <input
          type="password"
          placeholder="password"
          style="border:2px solid white; border-radius:30px; height:44px; width:270px; padding-left:20px; margin:15px 0px 7px; color:white">
        <div id="checkpwd" style="font-size:12px; color:red">! 비밀번호를 입력해주세요.</div>
        
        <v-btn style="width:270px; height:44px; border-radius:20px; color:white; font-size:24px; margin-top:20px" color="#EE49FD80">Log In</v-btn>
        <div style="text-align:right; margin-right:60px; font-family:linefont">비밀번호 찾기</div>

        <div id="divsns" style="font-family:linefont; margin-top:20px">SNS 로그인</div>
        <v-btn style="width:270px; height:44px; font-size:16px; margin-top:0px" color="#F7E600">카카오로 로그인</v-btn>
        <v-btn style="width:270px; height:44px; font-size:16px; margin-top:10px" color="#ffffff">구글로 로그인</v-btn>
        
        <div style="font-size:15px; text-align:right; margin-right:60px; margin-top:5px; font-family:linefont">
          아직 회원이 아니신가요? <span id="gosignin" style="font-family:linefontbold" @click="gosignin">회원가입</span>
        </div>
      
      </div>
    </div>
  </div>
</template>

<script>
export default {
  methods : {
    gosignin(){
      this.$router.push('SignIn')
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

#gosignin {
  color : #FA8EB6;
  font-size : 15px;
  cursor: pointer;
}

#checkemail, #checkpwd, #divsns {
  text-align: start;
  margin-left: 60px;
}

</style>