<template>
  <div class="bg">
    <div
      id="welcome"
      style="
      /* color: #9078b8; */
      color: white;
      width: 1700px;
      text-align: center;
      font-size: 170px;
      display: flex;
      flex-direction: column;
      ">
      <div id="wl">
        Welcome to :
      </div>
      <div id="wr">
        Hobby'It !
      </div>
    </div>
    <div class="beat" style="letter-spacing: 20px;">
      <a href="#blank1">
        아, 오 셨 군 요
      </a>
    </div>

    <div id="blank1" style="height: 100px;"></div>

    <div id="sec1" style="display: flex;">
      <div style="width: 400px; height: 400px; background-color: blanchedalmond; margin: 100px 100px 0px 0px;">

      </div>
      <div style="color: #FA8EB6; font-size: 24px; width: 700px; display: flex; flex-direction: column; justify-content: center; align-items: start; text-align: left;">
        <div style="margin-top: 70px;">
          혼자 노는 것에 지친 당신, 새로운 놀이터에 뛰어들 준비가 되셨나요?<br />
          <span style="color: #167EDF;">HOBBY'IT </span>에서 같이 즐길 사람들을 찾아 개성만점 취미생활을 즐기세요!<br /><br />
          관심가는 다양한 모임에 가입하고 새로운 추억을 쌓아보는건 어떨까요?<br />
        </div>
        <br />
        <div>
          <v-icon class="beat" size="48" icon="mdi-camera-plus" color="#50E868" style="margin-top: -5px; margin-right: 10px;"></v-icon>일상을 공유하거나,
        </div>
        <br />
        <div>
          <v-icon class="beat" size="48" icon="mdi-sticker-emoji" color="#FFC736" style="margin-top: -5px; margin-right: 10px;"></v-icon>매일 방명록을 작성하고,
        </div>
        <br />
        <div>
          <v-icon class="beat" size="48" icon="mdi-message-video" color="#FF00C7" style="margin-top: -5px; margin-right: 10px;"></v-icon>동료들의 얼굴을 보고 싶을 땐 화상으로 만나다보면,
        </div>
        <br />
        <div>
          <v-icon class="beat" size="48" icon="mdi-party-popper" color="#E79638" style="margin-top: -5px; margin-right: 10px;"></v-icon>이곳이 곧 내 새로운 온라인 부캐 라이프!
        </div>
        <div style="align-items: end;">
          <a href="#blank2">
            그거 어떻게 하는건데?
          </a>
        </div>
      </div>
    </div>

    <div id="blank2" style="height: 100px;"></div>
    <div id="sec2" style="display: flex;">
      <div style="color: #FA8EB6; font-size: 24px; width: 700px; display: flex; flex-direction: column; justify-content: center; align-items: start; text-align: left;">
        <div style="margin-top: 0px;">
          <span style="color: #167EDF; font-size: 52px;">1. </span>본격적으로 시작하기 전,<br />우측 상단 버튼을 눌러 <span style="color: #167EDF;">회원가입, 로그인</span>을 진행해 주세요<br /><br />
          <span style="color: #167EDF; font-size: 52px;">2. </span>상단 메뉴에서 <span style="color: #167EDF;">JOIN</span>을 눌러 호빗에서 지금 일어나고 있는<br /> 다양한 활동들을 확인해볼까요?<br /><br />
          #카테고리<br />
        </div>
        <br />
      </div>
      <div style="width: 400px; height: 400px; background-color: blanchedalmond; margin: 100px 100px 0px 0px;">

      </div>
    </div>

  </div>
</template>

<script>

</script>

<style scoped>
.bg{
  display: flex;
  align-items: center;
  flex-direction: column;
  height: 5000px;
}
a{
  text-decoration: none;
}
a:visited{
  text-decoration: none;
  color: #FA8EB6;
}

#wl{
  color: transparent; -webkit-text-stroke: 1px #fff;
}
#wr{
  color: transparent; -webkit-text-stroke: 1px #fff;
}

#welcome{
	-webkit-animation: text-flicker-in-glow 4s linear both;
	        animation: text-flicker-in-glow 4s linear both;
}
@-webkit-keyframes text-flicker-in-glow {
  0% {
    opacity: 0;
  }
  10% {
    opacity: 0;
    text-shadow: none;
  }
  10.1% {
    opacity: 1;
    text-shadow: none;
  }
  10.2% {
    opacity: 0;
    text-shadow: none;
  }
  20% {
    opacity: 0;
    text-shadow: none;
  }
  20.1% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(100, 46, 254, 0.25);
  }
  20.6% {
    opacity: 0;
    text-shadow: none;
  }
  30% {
    opacity: 0;
    text-shadow: none;
  }
  30.1% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(100, 46, 254, 0.45), 0 0 60px rgba(100, 46, 254, 0.25);
  }
  30.5% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(100, 46, 254, 0.45), 0 0 60px rgba(100, 46, 254, 0.25);
  }
  30.6% {
    opacity: 0;
    text-shadow: none;
  }
  45% {
    opacity: 0;
    text-shadow: none;
  }
  45.1% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(100, 46, 254, 0.45), 0 0 60px rgba(100, 46, 254, 0.25);
  }
  50% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(100, 46, 254, 0.45), 0 0 60px rgba(100, 46, 254, 0.25);
  }
  55% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(100, 46, 254, 0.45), 0 0 60px rgba(100, 46, 254, 0.25);
  }
  55.1% {
    opacity: 0;
    text-shadow: none;
  }
  57% {
    opacity: 0;
    text-shadow: none;
  }
  57.1% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(100, 46, 254, 0.55), 0 0 60px rgba(100, 46, 254, 0.35);
  }
  60% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(100, 46, 254, 0.55), 0 0 60px rgba(100, 46, 254, 0.35);
  }
  60.1% {
    opacity: 0;
    text-shadow: none;
  }
  65% {
    opacity: 0;
    text-shadow: none;
  }
  65.1% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(100, 46, 254, 0.55), 0 0 60px rgba(100, 46, 254, 0.35), 0 0 100px rgba(100, 46, 254, 0.1);
  }
  75% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(100, 46, 254, 0.55), 0 0 60px rgba(100, 46, 254, 0.35), 0 0 100px rgba(100, 46, 254, 0.1);
  }
  75.1% {
    opacity: 0;
    text-shadow: none;
  }
  77% {
    opacity: 0;
    text-shadow: none;
  }
  77.1% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(100, 46, 254, 0.55), 0 0 60px rgba(100, 46, 254, 0.4), 0 0 110px rgba(100, 46, 254, 0.2), 0 0 100px rgba(100, 46, 254, 0.1);
  }
  85% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(100, 46, 254, 0.55), 0 0 60px rgba(100, 46, 254, 0.4), 0 0 110px rgba(100, 46, 254, 0.2), 0 0 100px rgba(100, 46, 254, 0.1);
  }
  85.1% {
    opacity: 0;
    text-shadow: none;
  }
  86% {
    opacity: 0;
    text-shadow: none;
  }
  86.1% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(100, 46, 254, 0.6), 0 0 60px rgba(100, 46, 254, 0.45), 0 0 110px rgba(100, 46, 254, 0.25), 0 0 100px rgba(100, 46, 254, 0.1);
  }
  100% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(100, 46, 254, 0.6), 0 0 60px rgba(100, 46, 254, 0.45), 0 0 110px rgba(100, 46, 254, 0.25), 0 0 100px rgba(100, 46, 254, 0.1);
  }
}
@keyframes text-flicker-in-glow {
  0% {
    opacity: 0;
  }
  10% {
    opacity: 0;
    text-shadow: none;
  }
  10.1% {
    opacity: 1;
    text-shadow: none;
  }
  10.2% {
    opacity: 0;
    text-shadow: none;
  }
  20% {
    opacity: 0;
    text-shadow: none;
  }
  20.1% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(100, 46, 254, 0.25);
  }
  20.6% {
    opacity: 0;
    text-shadow: none;
  }
  30% {
    opacity: 0;
    text-shadow: none;
  }
  30.1% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(100, 46, 254, 0.45), 0 0 60px rgba(100, 46, 254, 0.25);
  }
  30.5% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(100, 46, 254, 0.45), 0 0 60px rgba(100, 46, 254, 0.25);
  }
  30.6% {
    opacity: 0;
    text-shadow: none;
  }
  45% {
    opacity: 0;
    text-shadow: none;
  }
  45.1% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(100, 46, 254, 0.45), 0 0 60px rgba(100, 46, 254, 0.25);
  }
  50% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(100, 46, 254, 0.45), 0 0 60px rgba(100, 46, 254, 0.25);
  }
  55% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(100, 46, 254, 0.45), 0 0 60px rgba(100, 46, 254, 0.25);
  }
  55.1% {
    opacity: 0;
    text-shadow: none;
  }
  57% {
    opacity: 0;
    text-shadow: none;
  }
  57.1% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(100, 46, 254, 0.55), 0 0 60px rgba(100, 46, 254, 0.35);
  }
  60% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(100, 46, 254, 0.55), 0 0 60px rgba(100, 46, 254, 0.35);
  }
  60.1% {
    opacity: 0;
    text-shadow: none;
  }
  65% {
    opacity: 0;
    text-shadow: none;
  }
  65.1% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(100, 46, 254, 0.55), 0 0 60px rgba(100, 46, 254, 0.35), 0 0 100px rgba(100, 46, 254, 0.1);
  }
  75% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(100, 46, 254, 0.55), 0 0 60px rgba(100, 46, 254, 0.35), 0 0 100px rgba(100, 46, 254, 0.1);
  }
  75.1% {
    opacity: 0;
    text-shadow: none;
  }
  77% {
    opacity: 0;
    text-shadow: none;
  }
  77.1% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(2100, 46, 254, 0.55), 0 0 60px rgba(100, 46, 254, 0.4), 0 0 110px rgba(100, 46, 254, 0.2), 0 0 100px rgba(100, 46, 254, 0.1);
  }
  85% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(100, 46, 254, 0.55), 0 0 60px rgba(100, 46, 254, 0.4), 0 0 110px rgba(100, 46, 254, 0.2), 0 0 100px rgba(100, 46, 254, 0.1);
  }
  85.1% {
    opacity: 0;
    text-shadow: none;
  }
  86% {
    opacity: 0;
    text-shadow: none;
  }
  86.1% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(100, 46, 254, 0.6), 0 0 60px rgba(100, 46, 254, 0.45), 0 0 110px rgba(100, 46, 254, 0.25), 0 0 100px rgba(100, 46, 254, 0.1);
  }
  100% {
    opacity: 1;
    text-shadow: 0 0 30px rgba(100, 46, 254, 0.6), 0 0 60px rgba(100, 46, 254, 0.45), 0 0 110px rgba(100, 46, 254, 0.25), 0 0 100px rgba(100, 46, 254, 0.1);
  }
}

.beat{
  -webkit-animation: heartbeat 1.5s ease-in-out infinite both;
	        animation: heartbeat 1.5s ease-in-out infinite both;
}
@-webkit-keyframes heartbeat {
  from {
    -webkit-transform: scale(1);
            transform: scale(1);
    -webkit-transform-origin: center center;
            transform-origin: center center;
    -webkit-animation-timing-function: ease-out;
            animation-timing-function: ease-out;
  }
  10% {
    -webkit-transform: scale(0.91);
            transform: scale(0.91);
    -webkit-animation-timing-function: ease-in;
            animation-timing-function: ease-in;
  }
  17% {
    -webkit-transform: scale(0.98);
            transform: scale(0.98);
    -webkit-animation-timing-function: ease-out;
            animation-timing-function: ease-out;
  }
  33% {
    -webkit-transform: scale(0.87);
            transform: scale(0.87);
    -webkit-animation-timing-function: ease-in;
            animation-timing-function: ease-in;
  }
  45% {
    -webkit-transform: scale(1);
            transform: scale(1);
    -webkit-animation-timing-function: ease-out;
            animation-timing-function: ease-out;
  }
}
@keyframes heartbeat {
  from {
    -webkit-transform: scale(1);
            transform: scale(1);
    -webkit-transform-origin: center center;
            transform-origin: center center;
    -webkit-animation-timing-function: ease-out;
            animation-timing-function: ease-out;
  }
  10% {
    -webkit-transform: scale(0.91);
            transform: scale(0.91);
    -webkit-animation-timing-function: ease-in;
            animation-timing-function: ease-in;
  }
  17% {
    -webkit-transform: scale(0.98);
            transform: scale(0.98);
    -webkit-animation-timing-function: ease-out;
            animation-timing-function: ease-out;
  }
  33% {
    -webkit-transform: scale(0.87);
            transform: scale(0.87);
    -webkit-animation-timing-function: ease-in;
            animation-timing-function: ease-in;
  }
  45% {
    -webkit-transform: scale(1);
            transform: scale(1);
    -webkit-animation-timing-function: ease-out;
            animation-timing-function: ease-out;
  }
}

</style>
