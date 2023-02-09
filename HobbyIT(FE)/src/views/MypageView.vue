<!--suppress ALL -->
<template>
  <div id="mypage">
    <!-- 왼쪽 정보 탭 -->
    <div id="mypageinfo">
      <div id="profileimg">
        <img id="img" :src="myinfo.imgUrl" cover>
      </div>
      <div id="title">{{ myinfo.nickname }}</div>
      <div id="content">
        hobbyit@hobbyit.com

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
          <div style="font-size: 14px; margin: 5px">{{ Math.ceil(gauge) }} %</div>
        </v-progress-linear>

        <div style="display: flex; justify-content: space-between; margin: 5px 5% 0">
          <span>Lv.10</span>
          <span>Lv.11</span>
        </div>
      </div>
    </div>
    <!-- 오른쪽 게시판 탭 -->
    <div id="board" style="flex-grow: 1; font-size: 25px">
      Who am I?
      <div style="font-family: linefont">
        {{ myinfo.intro }}
      </div>

      <div style="font-size: 36px; margin-top: 20px">MY HOBBY!</div>
      <MyPageGroup v-if="partigroup.length > 0" :hobbylist="partigroup"/>
      <MyPage1 v-else/>

      <div style="font-size: 36px; margin-top: 20px">가입 대기중인 HOBBY...</div>
      <ParticipateGroup v-if="waitgroup.length > 0" :hobbylist="waitgroup"/>
      <MyPage2 v-else/>

    </div>
  </div>
</template>

<script>
import ParticipateGroup from '@/components/ParticipateGroup.vue';
import MyPageGroup from '@/components/MyPageGroup.vue';
import MyPage1 from '@/components/no-content/MyPage1.vue';
import MyPage2 from '@/components/no-content/MyPage2.vue';

import { getOthersMyPage } from '@/api/member';
import { getParticipatingGroup } from '@/api/member';
import { getWaitingGroup } from '@/api/member';

export default {
  components: {
    ParticipateGroup,
    MyPageGroup,
    MyPage1,
  },
  data() {
    return {
      gauge: 55.0,
      myinfo : [], // 회원 정보
      partigroup : [], //참여중인 그룹 리스트
      waitgroup : [], // 승인 대기 그룹 리스트
    };
  },
  methods : {
    async getInfo(nickname) {
      try {
        const {data} = await getOthersMyPage(nickname)
        this.myinfo = data
      }
      catch (err) {
        console.log(err)
      }
    },

    async getParticiGroup(nickname) {
      try{
        console.log(nickname)
        const {data} = await getParticipatingGroup(nickname)
        this.partigroup = data
      }
      catch(err){
        console.log(err)
      }
    },

    async getLoadGroup(){
      try {
        const {data} = await getWaitingGroup()
        this.waitgroup = data
      }
      catch {
        console.log(err)
      }
    }
  },
  created() {
    this.getInfo(this.$route.params.nickname)
    this.getParticiGroup(this.$route.params.nickname)
    this.getLoadGroup()
  }
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

  /* background-image: url('/assets/tmpimg.jpeg'); */
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

  background-image: linear-gradient(#0e0f28, #0e0f28), linear-gradient(to right, #ff005e, #642efe);
  background-origin: border-box;
  background-clip: content-box, border-box;
}
</style>
