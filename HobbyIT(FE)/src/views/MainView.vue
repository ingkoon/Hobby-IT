<template>
  <h3 style='font-size: 36px'>관심 <span>#카테고리</span>를 선택해보세요.</h3>

  <v-slide-group mandatory='force' selected-class='font-family:linefontbold' show-arrows style='margin: 1% 0'>
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
        <span style='margin: 10px'>#{{ category[n] }}</span>
      </v-btn>
    </v-slide-group-item>
  </v-slide-group>

  <v-carousel id='main-carousel' hide-delimiter-background style='width: 100%; height: 450px'>
    <v-carousel-item cover src='assets/gif/main1.gif' style='font-size: 48px; color: white'>
      <div style='background-color: #1d1e4480; width: 100%; height: 100%; padding: 0 8%; display: flex'>
        <div style='align-self: center; width: 100%'>
          <div>
            부캐 전성시대,<br />
            그 시작은 Hobby'IT에서
          </div>

          <div style='float: right'>지금이 바로 시작할 때!</div>
        </div>
      </div>
    </v-carousel-item>
  </v-carousel>

  <h3 id='search'>
    당신이 참여중인 HOBBY
    <span>
      <v-text-field
        clearable
        placeholder='어떤 취미를 찾으시나요?'
        prepend-inner-icon='mdi-magnify'
        style='color: white; width: 334px; height: 44px'
        variant='outlined'
      ></v-text-field>
    </span>
  </h3>

  <main1/>
  <participate-group />

  <h3>오늘의 HOBBY 추천</h3>
  <participate-group />

  <h3>당신만 오면 GO!</h3>
  <participate-group />
</template>

<script>
import ParticipateGroup from '@/components/ParticipateGroup.vue';
import Main1 from '@/components/no-content/Main1.vue';
export default {
  components: { ParticipateGroup, Main1},
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
    };
  },
};
</script>

<style>
h3 {
  color: #ffffff;
  margin: 1% 0;
  font-size: 48px;
}

#search {
  display: flex;
  justify-content: space-between;
  margin-top: 40px;
}

h3 span {
  color: #642efe;
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
