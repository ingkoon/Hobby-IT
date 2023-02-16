<template>
  <v-carousel id='main-carousel' hide-delimiter-background style='width: 100%; height: 450px'>
    <v-carousel-item cover src='assets/gif/main1.gif' style='font-size: 48px; color: white'>
      <div style='background-color: #1d1e4480; width: 100%; height: 100%; padding: 0 8%; display: flex'>
        <div style='align-self: center; width: 100%'>
          <div>
            부캐 전성시대,<br />
            그 시작은 HOBBY'IT에서
          </div>

          <div style='float: right'>지금이 바로 시작할 때!</div>
        </div>
      </div>
    </v-carousel-item>
    <v-carousel-item cover src='assets/people.gif' style='font-size: 48px; color: white'>
      <div style='background-color: #1d1e4480; width: 100%; height: 100%; padding: 0 8%; display: flex'>
        <div style='align-self: center; width: 100%'>
          <div>
            관심사는 같은<br />
            다양한 사람들을
          </div>

          <div style='float: right'>HOBBY'IT 에서 만나봐요!</div>
        </div>
      </div>
    </v-carousel-item>
    <v-carousel-item cover src='assets/home1.gif' style='font-size: 48px; color: white'>
      <div style='background-color: #1d1e4480; width: 100%; height: 100%; padding: 0 8%; display: flex'>
        <div style='align-self: center; width: 100%'>
          <div>
            모임을 통해<br />
            매일 쌓이는 추억들을
          </div>

          <div style='float: right'>HOBBY'IT 에서 기록하세요!</div>
        </div>
      </div>
    </v-carousel-item>
  </v-carousel>

  <h3 id='search'>
    관심 <p>#카테고리</p>를 선택해보세요.
    <span>
      <v-text-field
      clearable
      placeholder='어떤 취미를 찾으시나요?'
      prepend-inner-icon='mdi-magnify'
      style='color: white; width: 334px; height: 44px;'
      variant='outlined'
      @keyup.enter="searchName"
      v-model="keyword"
      ></v-text-field>
    </span>
  </h3>
  
  <v-slide-group mandatory='force' selected-class='font-family:linefontbold' v-model='selectCate' show-arrows style='margin: 1% 0;'>
    <v-slide-group-item v-slot='{ isSelected, toggle }'>
      <v-btn
        id='categorybtn'
        :style="
          isSelected
            ? 'border : 4px solid #642EFE; color:#642EFE; font-family:linefontbold;'
            : 'border : 4px solid #A8456A; font-family:linefont;'
        "
        class='ma-2'
        rounded='pill'
        @click='toggle'
      >
        <span style='margin: 10px'>전체</span>
      </v-btn>
    </v-slide-group-item>

    <v-slide-group-item v-for='n in category.length - 1' :key='n' v-slot='{ isSelected, toggle }'>
      <v-btn
        id='categorybtn'
        :style="
          isSelected
            ? 'border : 4px solid #642EFE; color:#642EFE; font-family:linefontbold;'
            : 'border : 4px solid #A8456A; font-family:linefont;'
        "
        class='ma-2'
        rounded='pill'
        @click='toggle'
      >
        <span style='margin: 10px;'>#{{ category[n] }}</span>
      </v-btn>
    </v-slide-group-item>
  </v-slide-group>
  
  <div v-if="searchlist.length > 0 ">
    <h3>검색 결과</h3>
    <participate-group :hobbylist="searchlist"/>
  </div>
  <main4 v-if="searchFlag && searchlist.length == 0 "/>
  
  <div style="height: 30px;"></div>

  <h3>당신이 참여중인 HOBBY</h3>
  
  <!-- <participate-group v-if="searchlist.length > 0" :hobbylist="searchlist"/> -->
  <participate-group v-if="catelist.length > 0" :hobbylist="catelist"/>
  
  <participate-group v-if="hobbylist.length > 0" :hobbylist="hobbylist"/>
  <main1 v-else/>

  <h3>오늘의 HOBBY 추천</h3>
  <participate-group v-if="popularlist.length > 0" :hobbylist="popularlist"/>
  <main2 v-else/>

  <h3>당신만 오면 GO!</h3>
  <participate-group v-if="newlist.length > 0" :hobbylist="newlist"/>
  <main3 v-else/>
</template>

<script>
import ParticipateGroup from '@/components/ParticipateGroup.vue';
import Main1 from '@/components/no-content/Main1.vue';
import Main2 from '@/components/no-content/Main2.vue';
import Main3 from '@/components/no-content/Main3.vue';
import Main4 from '@/components/no-content/Main4.vue';

import { getHobbyList } from '@/api/hobby';
import { getPopularHobbyList } from '@/api/hobby';
import { getFreshHobbyList, searchHobby, searchNameHobby } from '@/api/hobby';

export default {
  components: { ParticipateGroup, Main1, Main2, Main3, Main4},
  data() {
    return {
      model: '전체',
      category: [
        '',
        '공예',
        '스터디',
        '음악',
        '파티',
        '게임',
        '코딩',
        '스포츠',
        '문화',
        '예술',
        '패션',
        '여행',
        '요리',
      ],
      hobbylist : [],
      popularlist : [],
      newlist : [],
      keyword: '',
      catelist : [],
      selectCate : '',
      searchlist : [],
      tmp : -1,
      searchFlag : false,
    };
  },
  methods : {
    async getHobby() { // 내 모임 리스트 받아오기
      try {
        const { data } = await getHobbyList();
        this.hobbylist = data
      } catch (e) {
        console.log("내 리스트 가져오기 실패 : ", e.message);
      }
    },
    async getPopularHobby() { // 인기 리스트 받아오기
      try {
        const { data } = await getPopularHobbyList();
        this.popularlist = data
      } catch (e) {
        console.log("인기 리스트 가져오기 실패 : ", e.message);
      }
    },
    async getNewHobby() { // 새로운 리스트 받아오기
      try {
        const { data } = await getFreshHobbyList();
        this.newlist = data
      } catch (e) {
        console.log("새로운 리스트 가져오기 실패 : ", e.message);
      }
    },

    // 카테고리 선택 결과
    async categorysearch(keyword) {
      try {
        const { data } = await searchHobby(keyword)
        this.searchlist = data
        this.searchFlag = true;
      }
      catch(e) {
        console.log(e)
      }
    },

    async namesearch(keyword) {
      try {
        const { data } = await searchNameHobby(keyword)
        this.searchlist = data
        this.searchFlag = true;
        console.log(this.searchlist)
      }
      catch(e) {
        console.log(e)
      }
    },

    // 키워드 검색 결과
    searchName(){
      this.namesearch(this.keyword)
    }
  },
  created() {
    this.getHobby()
    this.getPopularHobby()
    this.getNewHobby()
  },
  watch : {
    selectCate(newres, old){
      this.tmp += 1
      if(this.tmp !== 0)
        this.categorysearch(this.category[newres])
    }
  }
};
</script>

<style scoped>
h3 {
  color: #ffffff;
  margin: 1% 0;
  font-size: 37px;
}

#search {
  display: flex;
  justify-content: space-between;
  margin-top: 40px;
}

h3 p {
  color: #642efe;
  display: contents;
}

#categorybtn {
  height: 50px;
  width: 100px;
  font-size: 16px;
}

i {
  color: white;
}

button:not(*) {
  font-family: linefont;
}

.v-field--variant-outlined .v-field__outline__end.v-locale--is-ltr,
.v-locale--is-ltr .v-field--variant-outlined .v-field__outline__end {
  border-radius: 0 200px 200px 0 !important;
  opacity: 1;
}

.v-field--variant-outlined .v-field__outline__start {
  flex: 1 !important;
}

.v-field--variant-outlined .v-field__outline__start.v-locale--is-ltr,
.v-locale--is-ltr .v-field--variant-outlined .v-field__outline__start {
  border-radius: 100px 0 0 100px !important;
  opacity: 1;
}

#main-carousel button {
  background-color: #ffffff00;
}
</style>
