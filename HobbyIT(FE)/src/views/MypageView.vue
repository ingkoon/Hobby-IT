<template>
  <div id="mypage">
    <!-- 왼쪽 정보 탭 -->
    <div id="mypageinfo">
      <div id="profileimg">
        <div id="img"></div>
      </div>
      <div id="title">호빗러버</div>
      <div id="content">
        hobbyit@hobbyit.com
        <div style="margin-top: 20px">
          카테고리 : 여행 <br />
          가입유형 : 신청가입 <br />
          개설일 : 2023.1.1 <br />
          방장 : John
        </div>

        <div style="margin-top: 20px">오늘의 획득량 : 20/30</div>
        <div style="margin: 10px 0">진척도 보상</div>

        <v-progress-linear
          v-model="gauge"
          bg-color="#642efe"
          bg-opacity="1"
          color="#fa8eb6"
          height="20px"
          rounded
          rounded-bar
          style="border: 2px solid white; border-radius: 20px; width: 90%"
        >
          <div style="font-size: 14px; margin: 5px">
            {{ Math.ceil(gauge) }} %
          </div>
        </v-progress-linear>

        <div
          style="
            display: flex;
            justify-content: space-between;
            margin: 5px 5% 0;
          "
        >
          <span>Lv.10</span>
          <span>Lv.11</span>
        </div>
      </div>
    </div>
    <!-- 오른쪽 게시판 탭 -->
    <div id="board" style="flex-grow: 1; font-size: 25px">
      Who am I?
      <div style="font-family: linefont">
        운동, 댄스, 음악, 코딩, 등 다양한 취미생활을 즐기는 MZ 세대 입니다.
        <br />
        insta:@@@@@@
      </div>

      <div style="font-size: 36px; margin-top: 20px">MY HOBBY!</div>
      <MyPageGroup />

      <div style="font-size: 36px; margin-top: 20px">
        가입 대기중인 HOBBY...
      </div>
      <MyPageGroup />
    </div>
  </div>
</template>

<script>
import ParticipateGroup from "@/components/ParticipateGroup.vue";
import MyPageGroup from "@/components/MyPageGroup.vue";

export default {
  components: {
    ParticipateGroup,
    MyPageGroup,
  },
  data() {
    return {
      gauge: 55.0,
    };
  },
};
</script>

<style>
#mypage {
  color: white;
  display: flex;
  flex-direction: row;
}

#mypageinfo {
  width: 261px;
}

#mypageinfo #img {
  width: 240px;
  height: 240px;

  background-image: url(..\assets\tmpimg.jpeg);
  background-size: cover;
  border-radius: 50%;
  margin: 2px;
}

#mypageinfo #title {
  font-size: 24px;
  text-align: start;
  margin: 17px 0;
}

#mypageinfo #content {
  font-size: 20px;
  font-family: linefont;
  word-break: keep-all;
  margin-bottom: 40px;
}

#board {
  width: 70%;
  margin-left: 40px;
}

.v-progress-linear__content {
  justify-content: end;
}

#profileimg {
  position: relative;
  width: 260px;
  height: 260px;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #0e0f28;
  border: 4px solid transparent;
  border-radius: 50%;

  background-image: linear-gradient(#0e0f28, #0e0f28),
    linear-gradient(to right, #ff005e, #642efe);
  background-origin: border-box;
  background-clip: content-box, border-box;
}
</style>
