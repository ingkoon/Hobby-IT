<template>
  <div id="mypage">
    <!-- 왼쪽 정보 탭 -->
    <div id = "mypageinfo">
      <img src="@\assets\tmpimg.jpeg">
      <div id="title">호빗러버</div>
      <div id="content">
        hobbyit@hobbyit.com
        <div style="margin-top : 20px">
          카테고리 : 여행 <br>
          가입유형 : 신청가입 <br>
          개설일 : 2023.1.1 <br>
          방장 : John
        </div>


        <div style="margin-top : 20px">
          오늘의 획득량 : 20/30
        </div>
        <div style="margin : 10px 0px">
          진척도 보상
        </div>

        <v-progress-linear
          v-model="gauge"
          color="#fa8eb6"
          bg-color="#642efe"
          bg-opacity="1"
          height="20px"
          rounded
          rounded-bar
          style="border:2px solid white; border-radius:20px; width:90%"
        >
          <div style="font-size:14px; margin:5px">
            {{ Math.ceil(gauge) }} %
          </div>
          
        </v-progress-linear>

        <div style="display:flex; justify-content: space-between; margin:5px 5% 0px; ">
          <span>Lv.10</span>
          <span>Lv.11</span>
        </div>
      </div>
      
    </div>
    <!-- 오른쪽 게시판 탭 -->
    <div id="board" style="flex-grow:1; font-size:25px">
      
      Who am I?
      <div style="font-family:linefont;">
        운동, 댄스, 음악, 코딩, 등 다양한 취미생활을 즐기는 MZ 세대 입니다.
        <br>
        insta:@@@@@@
      </div>

      <div style="font-size:36px; margin-top : 20px">MY HOBBY!</div>
      <participate-group/>

      <div style="font-size:36px; margin-top : 20px">가입 대기중인 HOBBY...</div>
      <participate-group/>
      
    </div>
  </div>
</template>

<script>
  import ParticipateGroup from '@/components/ParticipateGroup.vue'
  export default {
    components : {
      ParticipateGroup,
    },
    data() {
      return {
        gauge : 55.0,
      }
    }
  }
</script>

<style>
#mypage {
  color:white;
  display:flex;
  flex-direction:row;
}

#mypageinfo {
  width: 25%;
}

#mypageinfo img {
  width:261px;
  height:261px;
  border:2px solid #fa8eb6;
  border-radius: 70%;
  overflow: hidden;
}

#mypageinfo #title {
  font-size: 24px;
  text-align: start;
  margin: 17px 0px;
}

#mypageinfo #content {
  font-size : 20px;
  font-family: linefont;
  word-break: keep-all;
  margin-bottom: 40px;
}

#board {
  width: 70%;
  margin-left: 40px;
}

.v-progress-linear__content{
  justify-content: end;
}

</style>