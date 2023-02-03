<template>

  <!-- gspa 사용 예제
  <transition appear @before-enter="beforeEnter" @enter="enter" :css="false">
    <div class="card"></div>
  </transition>
  <transition appear @before-enter="beforeEnter" @enter="enter" :css="false">
    <div class="card"></div>
  </transition>
  -->

  <!-- 인트로 화면 넣으면 돼 -->
  <div id="bg">
    <div style="position:relative; display: flex; align-items: center; text-align: center; justify-content: center;
                width: 800px; height: 150px; margin-top: 200px;">
      <p style="height:150px">HOBBY'IT</p>

      <img id="stars" src = "../assets/Fstar.svg" style="position:absolute; top:-100px; z-index:-1">
    </div>

    <div style="width:100%; margin-top:150px;">
      <div style="position:relative; height:330px;">
        <!-- <div style="width:100%; height: 1000px; position:absolute; top:100px;
                  background: linear-gradient(180deg, #000211 0%, #000211 54.37%, #0E0F28 100%);">
        </div> -->
        <div id="back-oval" style="z-index:-1"></div>
        <div id="front-oval">
          <div id="intro">본캐? 부캐?<br>HOBBY'IT : 세상의 모든 취미를 하나로</div>
        </div>
      </div>


      <div style="display:flex; background: linear-gradient(to bottom, #000211 20%, #0E0F28); padding-left:5%; padding-top:70px; margin-top:-3px">
        <div style="min-width:500px">
          <div id="text1">Just Hobby'It</div>
          <div id="text2">그냥, 취미해!</div>
          <div id="text3">
            <span style="font-weight: 700; color: #EBB4FE">Q. </span>
            당신은 어떤 사람인가요<br>회사원? 선생님? 운동선수? 개발자?<br><br>
            <span style="font-weight: 700; color: #EBB4FE">A. 좋아하는 것들 : 취미</span>로 표현할게요<br>
            #음악 #여행 #스포츠 #코딩 etc...<br><br>
            마음에 맞는 동료들과 함께<br>당신의 개성넘치는 부캐라이프,<br>
            <span style="font-weight: 700; color: #EBB4FE">HOBBY'IT : 호빗</span>
            에서 즐기세요!
          </div>
        </div>
        <div id="typo">
          <div class="left">
            <span style="color: #8947E2">#HOBBY’IT</span> #덕질 #cooking #홈트 #party #먹방 <span style="color: #8947E2">#HOBBY’IT</span> #art #GAME #class #공예 #MOVIE <span style="color: #8947E2">#HOBBY’IT</span> #독서 #fashion #여행 #BOARDGAME <span style="color: #8947E2">#HOBBY’IT</span> #스터디 #MUSIC #외국어 #coding
          </div>
          <div class="right">
            <span style="color: #8947E2">#HOBBY’IT</span> #덕질 #cooking #홈트 #party #먹방 <span style="color: #8947E2">#HOBBY’IT</span> #art #GAME #class #공예 #MOVIE <span style="color: #8947E2">#HOBBY’IT</span> #독서 #fashion #여행 #BOARDGAME <span style="color: #8947E2">#HOBBY’IT</span> #스터디 #MUSIC #외국어 #coding
          </div>
          <div class="left">
            <span style="color: #8947E2">#HOBBY’IT</span> #덕질 #cooking #홈트 #party #먹방 <span style="color: #8947E2">#HOBBY’IT</span> #art #GAME #class #공예 #MOVIE <span style="color: #8947E2">#HOBBY’IT</span> #독서 #fashion #여행 #BOARDGAME <span style="color: #8947E2">#HOBBY’IT</span> #스터디 #MUSIC #외국어 #coding
          </div>
          <div class="right">
            <span style="color: #8947E2">#HOBBY’IT</span> #덕질 #cooking #홈트 #party #먹방 <span style="color: #8947E2">#HOBBY’IT</span> #art #GAME #class #공예 #MOVIE <span style="color: #8947E2">#HOBBY’IT</span> #독서 #fashion #여행 #BOARDGAME <span style="color: #8947E2">#HOBBY’IT</span> #스터디 #MUSIC #외국어 #coding
          </div>
          <div class="left">
            <span style="color: #8947E2">#HOBBY’IT</span> #덕질 #cooking #홈트 #party #먹방 <span style="color: #8947E2">#HOBBY’IT</span> #art #GAME #class #공예 #MOVIE <span style="color: #8947E2">#HOBBY’IT</span> #독서 #fashion #여행 #BOARDGAME <span style="color: #8947E2">#HOBBY’IT</span> #스터디 #MUSIC #외국어 #coding
          </div>
          <div class="right">
            <span style="color: #8947E2">#HOBBY’IT</span> #덕질 #cooking #홈트 #party #먹방 <span style="color: #8947E2">#HOBBY’IT</span> #art #GAME #class #공예 #MOVIE <span style="color: #8947E2">#HOBBY’IT</span> #독서 #fashion #여행 #BOARDGAME <span style="color: #8947E2">#HOBBY’IT</span> #스터디 #MUSIC #외국어 #coding
          </div>
          <div class="left">
            <span style="color: #8947E2">#HOBBY’IT</span> #덕질 #cooking #홈트 #party #먹방 <span style="color: #8947E2">#HOBBY’IT</span> #art #GAME #class #공예 #MOVIE <span style="color: #8947E2">#HOBBY’IT</span> #독서 #fashion #여행 #BOARDGAME <span style="color: #8947E2">#HOBBY’IT</span> #스터디 #MUSIC #외국어 #coding
          </div>
          <div class="right">
            <span style="color: #8947E2">#HOBBY’IT</span> #덕질 #cooking #홈트 #party #먹방 <span style="color: #8947E2">#HOBBY’IT</span> #art #GAME #class #공예 #MOVIE <span style="color: #8947E2">#HOBBY’IT</span> #독서 #fashion #여행 #BOARDGAME <span style="color: #8947E2">#HOBBY’IT</span> #스터디 #MUSIC #외국어 #coding
          </div>
          <div class="left">
            <span style="color: #8947E2">#HOBBY’IT</span> #덕질 #cooking #홈트 #party #먹방 <span style="color: #8947E2">#HOBBY’IT</span> #art #GAME #class #공예 #MOVIE <span style="color: #8947E2">#HOBBY’IT</span> #독서 #fashion #여행 #BOARDGAME <span style="color: #8947E2">#HOBBY’IT</span> #스터디 #MUSIC #외국어 #coding
          </div>
        </div>
      </div>

      <!-- <div style="position: absolute; width: 100%; height: 221px; left: 0px; top: 1099px; background: #000211;"></div> -->


      <div style="display:flex; align-items:center; flex-direction:column">
        <div id="box1">
          <h1 style="margin-top: 50px; font-size: 40px; text-shadow: 0 4px 4px rgba(0, 0, 0, 0.25);">@@@하고 싶은데.. 같이 하지 않을래요?</h1>
          <div style="display:flex; align-items:center">
            <img src = "../assets/people.gif" style="width:60%; margin: 10px 20px">
            <h1 style="font-size: 25px;">혼자보단 둘,<br>둘보단 다같이!<br><br>관심있는 모임에 들어가거나,<br>동료들을 구해보는건 어떨까요?<br>다함께 취미생활을 기록하고 공유하세요.<br>혼자보단 분명 더욱 즐거울겁니다!
            <br>What's So Special?<br>호빗만의 장점을 더 알아볼까요?</h1>
          </div>
        </div>

        <div style="display:flex; margin-top:400px">
          <div id="box2">
            <h1 style="color:white; margin-top: 50px; font-size: 50px; text-shadow: 0 4px 4px rgba(0, 0, 0, 0.25);">24/7 즐기는 취미생활</h1>
            <h1 style="color:white; margin-top: 15px; font-size: 20px;"><span style="color: #5204BA; text-shadow: 0 4px 4px rgba(0, 0, 0, 0.25);">사진 공유, 방명록, 화상채팅까지!</span><br>언제 어디서든 추억을 쌓아갈 수 있습니다.<br><br>내가 속한 모임마다 특별한 추억들로<br>채워가보세요 :)</h1>
            <img src = "../assets/nod.gif">
          </div>

          <div>
            <div id="box3">
              <v-icon icon="mdi-lock-open" size="38" style="margin-top:20px"></v-icon>
              <h1 style="color: #0E0F28; margin-top: 10px; font-size: 40px; text-shadow: 0 4px 4px rgba(0, 0, 0, 0.25);">We are Open!</h1>
              <h1 style="color: #0E0F28; margin-top: 20px; font-size: 20px;">유입 환영!<br>아무나 자유롭게 모임 가입이 바로 가능하군요!<br>취향이 맞는 다양한 사람들을 만날 수 있겠어요<br>누구나 welcome!</h1>
            </div>
            <div id="box4">
              <v-icon icon="mdi-lock" size="38" style="margin-top:20px"></v-icon>
              <h1 style="color: #0E0F28; margin-top: 10px; font-size: 40px; text-shadow: 0 4px 4px rgba(0, 0, 0, 0.25);">Friends & Family!</h1>
              <h1 style="color: #0E0F28; margin-top: 20px; font-size: 20px;">좀 더 프라이빗한 모임이었으면 좋겠어요<br>가입신청 인사, 활동 중인 모임 등을<br>확인 후에 신규멤버로 초대해볼까요?<br>우리들만의 아지트가 필요할때도 있는 법이죠</h1>
            </div>
          </div>
        </div>

        <div style="color: #9078B8; margin: 200px; font-size:40px">Your Hobby, Your Style.</div>

        <div style="height:1800px">
          <div style="position:relative">
            <div id="card1">
              <div style="width:300px; height:300px; margin-top:10px;">
                <img src = "../assets/home1.gif" style="width:100%; height:100%">
                <div style="font-size: 40px; margin-left: 10px; background: linear-gradient(180deg, #642EFE 0%, #FA8EB6 100%); -webkit-background-clip: text; -webkit-text-fill-color: transparent;">끝이 없다!</div>
                <div style="font-size: 20px; margin-left: 15px; color: white">하고싶은거 다 해<br>취미엔 끝이 없으니까!</div>
              </div>
            </div>
            <div id="card2">
              <div style="width:500px; height:500px; margin-top:10px;">
                <img src = "../assets/home4.gif" style="width:100%; height:100%">
                <div style="font-size: 40px; margin-right: 10px; background: linear-gradient(180deg, #642EFE 0%, #FA8EB6 100%); -webkit-background-clip: text; -webkit-text-fill-color: transparent;">나 혼자 즐기긴 아깝지</div>
                <div style="font-size: 20px; color: white; margin-top: 50px;  margin-right: 15px;">찍고 올리고, 찍고 올리고<br>기록은 기억보다 선명하니까</div>
              </div>
            </div>
            <div id="card3">
              <div style="width:600px; height:600px; margin-top:10px;">
                <img src = "../assets/home2.gif" style="width:100%; height:100%">
                <div style="font-size: 40px; margin-left: 10px; background: linear-gradient(180deg, #642EFE 0%, #FA8EB6 100%); -webkit-background-clip: text; -webkit-text-fill-color: transparent;">나를 만드는 것은 나자신!</div>
                <div style="font-size: 20px; margin-left: 16px; color: white">텍스트1<br>텍스트2<br>텍스트3<br>텍스트4</div>
              </div>
            </div>
            <div id="card4">
              <div style="width:400px; height:400px; margin-top:10px;">
                <img src = "../assets/home3.gif" style="width:100%; height:100%; object-fit:cover;">
                <div style="font-size: 40px; margin-left: 10px; background: linear-gradient(180deg, #642EFE 0%, #FA8EB6 100%); -webkit-background-clip: text; -webkit-text-fill-color: transparent;">중요한건 즐기는 마음</div>
                <div style="font-size: 20px; margin-left: 15px; color: white"><br>텍스트1<br>텍스트2<br>텍스트3</div>
              </div>
            </div>

            <div
style="position: absolute; width: 1920px; height: 1080px; left: -900px; top: 200px; width: 1920px; height: 1080px;
            background: radial-gradient(50% 50% at 50% 50%, #D534EF 0%, rgba(36, 39, 75, 0) 100%); filter: blur(100px);">
            </div>
          </div>
        </div>

        <div style="margin-top:200px; position:relative; margin-right:1000px">
          <div id="foot1" style="position: absolute; width: 27px; height: 86px; left: 79px; top: 648px; background: linear-gradient(180deg, #0E0F28 0%, #F7DADA 100%); z-index: 5;"></div>
          <div id="foot2" style="position: absolute; width: 27px; height: 86px; left: 74.57px; top: 823.1px; background: #F7DADA; transform: rotate(12.43deg); z-index: 5;"></div>
          <div id="foot3" style="position: absolute; width: 27px; height: 86px; left: 60.89px; top: 1013.24px; background: #F7DADA; transform: rotate(-15.66deg); z-index: 5;"></div>
          <div id="foot4" style="position: absolute; width: 27px; height: 86px; left: 170.36px; top: 1150px; background: #F7DADA; transform: rotate(-60.3deg); z-index: 5;"></div>
          <div id="foot5" style="position: absolute; width: 27px; height: 86px; left: 350px; top: 1231.79px; background: #F7DADA; transform: rotate(-72.81deg); z-index: 5;"></div>
          <div id="foot6" style="position: absolute; width: 27px; height: 86px; left: 545.59px; top: 1269px; background: #F7DADA; transform: rotate(84.37deg); z-index: 5;"></div>
          <div id="foot7" style="position: absolute; width: 27px; height: 86px; left: 733.99px; top: 1287.05px; background: #F7DADA; transform: rotate(104.17deg); z-index: 5;"></div>
          <div id="foot8" style="position: absolute; width: 27px; height: 86px; left: 871.21px; top: 1343.95px; background: #F7DADA; transform: rotate(-32.82deg); z-index: 5;"></div>
          <div id="foot9" style="position: absolute; width: 27px; height: 86px; left: 876.3px; top: 1481px; background: #F7DADA; transform: rotate(21.34deg); z-index: 5;"></div>
          <div id="foot10" style="position: absolute; width: 27px; height: 86px; left: 763.32px; top: 1595.92px; background: #F7DADA; transform: rotate(57.81deg); z-index: 5;"></div>
          <div id="foot11" style="position: absolute; width: 27px; height: 86px; left: 611.57px; top: 1680px; background: #F7DADA; transform: rotate(53.99deg); z-index: 5;"></div>
          <div id="foot12" style="position: absolute; width: 27px; height: 86px; left: 453.87px; top: 1783px; background: #F7DADA; transform: rotate(38.78deg); z-index: 5;"></div>
          <div id="foot13" style="position: absolute; width: 27px; height: 86px; left: 364px; top: 1948px; background: #F7DADA; z-index: 5;"></div>
          <div id="foot14" style="position: absolute; width: 27px; height: 86px; left: 409.74px; top: 2090.72px; background: linear-gradient(180deg, #F7DADA 0%, #0E0F28 100%); transform: rotate(-38.49deg); z-index: 5;"></div>
          <div id="pst1" style="z-index:6">
            <img src = "../assets/yellowp.svg">
          </div>
          <div id="pst2" style="z-index:6">
            <img src = "../assets/bluep.svg">
          </div>
          <div id="pst3" style="z-index:6">
            <img src = "../assets/greenp.svg">
          </div>
          <div style="position: absolute; width: 100%; height: 1540px; left: -287px; top: 648px;">
            <img src = "../assets/BLOB.svg" style="z-index: 5;">
          </div>
        </div>

      </div>



    </div>


  </div>
</template>

<script>

export default {
  methods: {
    beforeEnter(el) {
      el.style.opactiy = 0
      el.style.transform = 'scale(0,0)'
    },
    enter(el, done){
      gsap.to(el, {
        duration:1,
        opacity: 1,
        scale: 1,
        ease: 'bounce.out',
        onComplete: done
      })
    },

  }
}
</script>

<style scoped>
.card {
  display:block;
  margin: 0 auto 0 auto;
  height:6.5em;
  width: 6.5em;
  border-radius: 1%;
  background-color: #16c0b0 ;
  box-shadow: 0.08em 0.03em 0.4em #ababab;
}
#bg{
  display: flex;
  align-items: center;
  flex-direction: column;
  height: 10000px;
}
p{
  display: flex;
  align-items: center;
  text-align: center;
  font-style: normal;
  font-weight: 400;
  font-size: 124px;
  line-height: 100px;
  background: linear-gradient(180deg, #AD00FF 24.05%, #FA8EB6 72.16%);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  background-clip: text;
}

/* 별 움직이는 동작 */
#stars{
  animation: rotate-image 100s linear infinite;
  transform-origin: 50% 50%;
}

@keyframes rotate-image {
  100%{
      transform: rotate(-360deg);
  }
}

#back-oval{
  position:absolute;
  top:-110px;
  width: 120%; height: 380px;
  background: radial-gradient(50% 50% at 50% 50%, #D534EF 0%, rgba(36, 39, 75, 0) 100%);
  filter: blur(100px);
  left:-10%;
}

#front-oval{
  position: absolute;
  box-sizing: border-box;
  width: 120%;
  left:-10%;
  border-radius: 50% 50% 0 0 / 50% 50% 0 0;
  /* background: linear-gradient(360deg, #000211, #0E0F28); */
  /* background: #000211; */
  border-top: 5px solid transparent;
  background-image: linear-gradient(#000211, #000211),
  radial-gradient(50.13% 50.13% at 50% 0%, #EBB4FE 0%, rgba(217, 217, 217, 0) 100%);
  background-origin: border-box;
  background-clip: content-box, border-box;
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center;
}
#intro{
  margin-top: 50px;
  font-style: normal;
  font-weight: 700;
  font-size: 40px;
  display: flex;
  align-items: center;
  text-align: center;

  background: linear-gradient(180deg, #E7B2FA -16.3%, #AD00FF 127.17%);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  background-clip: text;
  padding-bottom:155px;
}

#typo{
  height: 800px;
  overflow: hidden;
  margin-left:-2300px
}

#typo .right{
  transform: rotate(-60deg);
  color:white;
  font-size: 60px;
  display:inline-block;
  white-space:nowrap;
  margin-top:70px;
}

#typo .left{
  transform: rotate(-60deg);
  color:white;
  font-size: 60px;
  display:inline-block;
  white-space:nowrap;
  margin-top:70px;
}

#text1{
  background-clip: text;
  align-items: center;
  background: linear-gradient(180deg, #642EFE 13.55%, #FFFFFF 63.55%);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  font-size: 40px;
}

#text2{
  color: white;
  font-weight: 700;
  font-size: 96px;
  line-height: 127px;
  display: flex;
  align-items: center;
}

#text3{
  /*color:#FA8EB6;*/
  font-size: 26px;
  line-height: 48px;
  color: #E9D7DD;
  margin-top:60px;
}

#box1{
  width: 80%;
  background: linear-gradient(180deg, #F4D1D6 0%, #F4D1D6 23.41%, #F5D2D7 68.11%, #FADFDD 86.61%, #F4D1D6 100%);
  box-shadow: inset 0 4px 50px rgba(0, 0, 0, 0.25);
  border-radius: 20px;
  display: flex;
  align-items: center;
  flex-direction: column;
  text-align: left;
  margin-top : 100px;
  padding-bottom : 10px;
}

#box2{
  width: auto;
  background: linear-gradient(180deg, #FA8EB6 0%, #F98CB4 55.18%, #FCA2C3 71.63%, #FCB0CB 81.7%, #FABAD0 96.94%, #FBB7CD 100%);;
  box-shadow: inset 0 4px 50px rgba(0, 0, 0, 0.25);
  border-radius: 20px;
  display: flex;
  align-items: center;
  flex-direction: column;
  text-align: left;
  padding: 15px;
}

#box3{
  width: 100%;
  height: 320px;
  background: #DEFFBE;
  box-shadow: inset 0 4px 50px rgba(0, 0, 0, 0.25);
  border-radius: 20px;
  display: flex;
  align-items: center;
  flex-direction: column;
  text-align: left;
  margin:15px;
}

#box4{
  width: 100%;
  height: 320px;
  background: #69FCE1;
  box-shadow: inset 0 4px 50px rgba(0, 0, 0, 0.25);
  border-radius: 20px;
  display: flex;
  align-items: center;
  flex-direction: column;
  text-align: right;
  margin:15px;
}

#pst1{
  position: absolute; width: 200px; height: 200px; left: 713.82px; top: 1000.74px;
  filter: drop-shadow(0px 4px 30px #000000);
  transform: rotate(-22deg);
}

#pst2{
  position: absolute; width: 200px; height: 200px; left: 320.89px; top: 1280.89px;
  filter: drop-shadow(0px 4px 30px #000000);
  transform: rotate(-5deg);
}

#pst3{
  position: absolute; width: 200px; height: 200px; left: 550.73px; top: 1790px;
  filter: drop-shadow(0px 4px 30px #000000);
  transform: rotate(10deg);
}

#card1{
  position: absolute;
  width: 320px;
  height: 524px;
  left: -400px;
  top: 0;
  z-index: 2;
  background-color: #000211;
  display: flex;
  align-items: center;
  flex-direction: column;
  text-align: left;
}

#card2{
  position: absolute;
  width: 520px;
  height: 813px;
  left: 0;
  top: 0;
  z-index: 3;
  background-color: #000211;
  display: flex;
  align-items: center;
  flex-direction: column;
  text-align: right;
}

#card3{
  position: absolute;
  width: 620px;
  height: 986px;
  left: -500px;
  top: 700px;
  z-index: 4;
  background-color: #000211;
  display: flex;
  align-items: center;
  flex-direction: column;
  text-align: left;
}

#card4{
  position: absolute;
  width: 420px;
  height: 697px;
  left: 150px;
  top: 900px;
  z-index: 5;
  background-color: #000211;
  display: flex;
  align-items: center;
  flex-direction: column;
  text-align: left;
}
</style>
