<template>
  <!-- 인트로 화면 넣으면 돼 -->
  <div id="bg">
    <div style="display: flex; align-items: center; text-align: center; justify-content: center;
                width: 800px; height: 150px; margin-top: 200px; z-index:1;">
      <p>HOBBY'IT</p>
    </div>
    <div style="position: absolute; width: 1021px; height: 1021px; left: 449px; top: 365px;">
      <img src = "../assets/STAR.svg">
    </div>
    <div id="back-oval"></div>
    <div id="front-oval"></div>
    <div id="intro">
      본캐?부캐?<br>HOBBY'IT : 세상의 모든 취미를 하나로
    </div>
    <div style="position: absolute; width: 1920px; height: 1175px; left: 0px; top: 844px;
                background: linear-gradient(180deg, #000211 0%, #000211 54.37%, #0E0F28 100%);"></div>
    <div style="position: absolute; width: 1920px; height: 221px; left: 0px; top: 1099px; background: #000211;"></div>
    <div>
      <h1 id="text1">Just Hobby'It</h1>
      <h1 id="text2">그냥, 취미해!</h1>
      <div id="text3"><span style="font-weight: 700; color: #EBB4FE">Q. </span>당신은 어떤 사람인가요<br>회사원? 선생님? 운동선수? 개발자?<br><br>
        <span style="font-weight: 700; color: #EBB4FE">A. 좋아하는 것들 : 취미</span>로 표현할게요<br>
        #음악 #여행 #스포츠 #코딩 etc...<br><br>
        마음에 맞는 동료들과 함께<br>당신의 개성넘치는 부캐라이프,<br>
        <span style="font-weight: 700; color: #EBB4FE">HOBBY'IT : 호빗</span>에서 즐기세요!
      </div>
      <div id="box1">
        <h1 style="margin-top: 50px; font-size: 60px; text-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);">@@@하고 싶은데.. 같이 하지 않을래요?</h1>
        <h1 style="font-size: 28px; margin-top: 50px; margin-left: 800px;">혼자보단 둘,<br>둘보단 다같이!<br><br>관심있는 모임에 들어가거나,<br>동료들을 구해보는건 어떨까요?<br>다함께 취미생활을 기록하고 공유하세요.<br>혼자보단 분명 더욱 즐거울겁니다!
        <br><br>What's So Special?<br>호빗만의 장점을 더 알아볼까요?</h1>
      </div>
      <div id="box2">
        <h1 style="color:white; margin-top: 50px; font-size: 60px; text-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);">24/7 즐기는 취미생활</h1>
        <h1 style="color:white; margin-top: 50px; font-size: 24px; text-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);">사진 공유, 방명록, 화상채팅까지!<br>언제 어디서든 추억을 쌓아갈 수 있습니다.<br><br>내가 속한 모임마다 특별한 추억들로<br>채워가보세요 :)</h1>
      </div>
      <div id="card1">
        <div style="margin-top: 10px; width:480px; height:480px; background-color:white;"></div>
        <h1 style="color:white; font-size: 40px; margin-top: 20px; margin-left: -50px;
        background: linear-gradient(180deg, #642EFE 0%, #FA8EB6 100%);
        -webkit-background-clip: text;
        -webkit-text-fill-color: transparent;
        background-clip: text;">중요한 것은 즐기는 마음!</h1>
        <h1 style="color:white; font-size: 20px; margin-top: 10px; margin-left: -270px;">가볍게 즐기거나,<br>진지하게 참여하거나<br>부담 ZERO</h1>
      </div>
      <div id="foot1" style="position: absolute; width: 27px; height: 86px; left: 379px; top: 5648px; background: linear-gradient(180deg, #0E0F28 0%, #F7DADA 100%); z-index: 5;"></div>
      <div id="foot2" style="position: absolute; width: 27px; height: 86px; left: 374.57px; top: 5823.1px; background: #F7DADA; transform: rotate(12.43deg); z-index: 5;"></div>
      <div id="foot3" style="position: absolute; width: 27px; height: 86px; left: 360.89px; top: 6013.24px; background: #F7DADA; transform: rotate(-15.66deg); z-index: 5;"></div>
      <div id="foot4" style="position: absolute; width: 27px; height: 86px; left: 470.36px; top: 6150px; background: #F7DADA; transform: rotate(-60.3deg); z-index: 5;"></div>
      <div id="foot5" style="position: absolute; width: 27px; height: 86px; left: 650px; top: 6231.79px; background: #F7DADA; transform: rotate(-72.81deg); z-index: 5;"></div>
      <div id="foot6" style="position: absolute; width: 27px; height: 86px; left: 845.59px; top: 6269px; background: #F7DADA; transform: rotate(84.37deg); z-index: 5;"></div>
      <div id="foot7" style="position: absolute; width: 27px; height: 86px; left: 1033.99px; top: 6287.05px; background: #F7DADA; transform: rotate(104.17deg); z-index: 5;"></div>
      <div id="foot8" style="position: absolute; width: 27px; height: 86px; left: 1171.21px; top: 6343.95px; background: #F7DADA; transform: rotate(-32.82deg); z-index: 5;"></div>
      <div id="foot9" style="position: absolute; width: 27px; height: 86px; left: 1176.3px; top: 6481px; background: #F7DADA; transform: rotate(21.34deg); z-index: 5;"></div>
      <div id="foot10" style="position: absolute; width: 27px; height: 86px; left: 1063.32px; top: 6595.92px; background: #F7DADA; transform: rotate(57.81deg); z-index: 5;"></div>
      <div id="foot11" style="position: absolute; width: 27px; height: 86px; left: 911.57px; top: 6680px; background: #F7DADA; transform: rotate(53.99deg); z-index: 5;"></div>
      <div id="foot12" style="position: absolute; width: 27px; height: 86px; left: 753.87px; top: 6783px; background: #F7DADA; transform: rotate(38.78deg); z-index: 5;"></div>
      <div id="foot13" style="position: absolute; width: 27px; height: 86px; left: 664px; top: 6948px; background: #F7DADA; z-index: 5;"></div>
      <div id="foot14" style="position: absolute; width: 27px; height: 86px; left: 709.74px; top: 7090.72px; background: linear-gradient(180deg, #F7DADA 0%, #0E0F28 100%); transform: rotate(-38.49deg); z-index: 5;"></div>
      <div id="pst1" style="z-index:6">
        <img src = "../assets/yellowp.svg">
      </div>
      <div id="pst2" style="z-index:6">
        <img src = "../assets/bluep.svg">
      </div>
      <div id="pst3" style="z-index:6">
        <img src = "../assets/greenp.svg">
      </div>
      <div style="position: absolute; width: 1947px; height: 1540px; left: -13px; top: 5648px;">
        <img style="z-index: 5;" src = "../assets/BLOB.svg">
      </div>
    </div>
  </div>
</template>

<script setup>

</script>

<style scoped>
#bg{
  display: flex;
  align-items: center;
  flex-direction: column;
  height: 8000px;
}
p{
  display: flex;
  align-items: center;
  text-align: center;
  font-style: normal;
  font-weight: 400;
  font-size: 124px;
  line-height: 100 px;
  background: linear-gradient(180deg, #AD00FF 24.05%, #FA8EB6 72.16%);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  background-clip: text;
}

#back-oval{
  position: absolute; width: 3400px; height: 400px; left: -740px; top: 495px;
  background: radial-gradient(50% 50% at 50% 50%, #D534EF 0%, rgba(36, 39, 75, 0) 100%);
  filter: blur(100px);
}

#front-oval{
  box-sizing: border-box;
  position: absolute; width: 2080px; height: 436px; left: -80px; top: 651px;
  border-radius: 50% / 50%;
  background: #000211;
  border: 5px solid transparent;
  background-image: linear-gradient(#000211, #000211),
  radial-gradient(50.13% 50.13% at 50% 0%, #EBB4FE 0%, rgba(217, 217, 217, 0) 100%);
  background-origin: border-box;
  background-clip: content-box, border-box;
}
#intro{
  position: absolute; width: 700px; height: 120px; left: 610px; top: 718px;
  font-style: normal;
  font-weight: 700;
  font-size: 40px;
  line-height: 70px;
  display: flex;
  align-items: center;
  text-align: center;

  background: linear-gradient(180deg, #E7B2FA -16.3%, #AD00FF 127.17%);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  background-clip: text;
}
#text1{
  position: absolute; width: 1221px; height: 214px; left: 155px; top: 1218px;
  background: linear-gradient(180deg, #642EFE 13.55%, #FFFFFF 63.55%);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  background-clip: text;
  font-style: normal;
  font-weight: 400px;
  font-size: 64px;
  line-height: 64px;
  display: flex;
  align-items: center;
}

#text2{
  z-index: 1;
  color: white;
  position: absolute; width: 853px; height: 214px; left: 155px; top: 1317px;
  font-weight: 700;
  font-size: 96px;
  line-height: 127px;
  display: flex;
  align-items: center;
}

#text3{
  z-index: 2;
  color:#FA8EB6;
  position: absolute; width: 853px; height: 872px; left: 175px; top: 1623px;
  font-style: normal;
  font-weight: 400;
  font-size: 36px;
  line-height: 48px;
  color: #E9D7DD;
}

#box1{
  position: absolute; width: 1400px; height: 700px; left: 260px; top: 2612px;
  background: linear-gradient(180deg, #F4D1D6 0%, #F4D1D6 23.41%, #F5D2D7 68.11%, #FADFDD 86.61%, #F4D1D6 100%);
  box-shadow: inset 0px 4px 50px rgba(0, 0, 0, 0.25);
  border-radius: 20px;
  display: flex;
  align-items: center;
  flex-direction: column;
  text-align: left;
}

#box2{
  position: absolute; width: 837px; height: 700px; left: 260px; top: 3719px;
  background: linear-gradient(180deg, #FA8EB6 0%, #F98CB4 55.18%, #FCA2C3 71.63%, #FCB0CB 81.7%, #FABAD0 96.94%, #FBB7CD 100%);;
  box-shadow: inset 0px 4px 50px rgba(0, 0, 0, 0.25);
  border-radius: 20px;
  display: flex;
  align-items: center;
  flex-direction: column;
  text-align: left;
}

#card1{
  position: absolute; width: 500px; height: 700px; left: 1160px; top: 3719px;
  background: #000211;
  display: flex;
  align-items: center;
  flex-direction: column;
  text-align: left;
}

#pst1{
  position: absolute; width: 200px; height: 200px; left: 1013.82px; top: 6000.74px;
  filter: drop-shadow(0px 4px 30px #000000);
  transform: rotate(-22deg);
}

#pst2{
  position: absolute; width: 200px; height: 200px; left: 620.89px; top: 6280.89px;
  filter: drop-shadow(0px 4px 30px #000000);
  transform: rotate(-5deg);
}

#pst3{
  position: absolute; width: 200px; height: 200px; left: 850.73px; top: 6790px;
  filter: drop-shadow(0px 4px 30px #000000);
  transform: rotate(10deg);
}

</style>
