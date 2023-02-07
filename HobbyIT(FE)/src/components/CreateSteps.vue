<!--suppress ALL -->

<template>
  <v-card class='bg mx-auto' style='height: 500px; background-color: #0e0f28; color: white' width='600'>
    <!-- 숫자 -->
    <v-card-title
      class='justify-space-between'
      style='display: flex; align-items: center; text-shadow: 0 4px 4px rgba(0, 0, 0, 0.25)'
    >
      <v-avatar
        id='s1'
        size='52'
        style='border-width: 2px; border-style: solid; border-color: white; color: white; margin-left: 10px'
      >
        <v-icon icon='mdi-numeric-1' size='36'></v-icon
        >
      </v-avatar>
      <hr style='color: white; width: 150px' />
      <v-avatar id='s2' size='52' style='border-width: 2px; border-style: solid; border-color: white; color: white'
      >
        <v-icon icon='mdi-numeric-2' size='36'></v-icon
        >
      </v-avatar>
      <hr style='color: white; width: 150px' />
      <v-avatar
        id='s3'
        size='52'
        style='border-width: 2px; border-style: solid; border-color: white; color: white; margin-right: 20px'
      >
        <v-icon icon='mdi-numeric-3' size='36'></v-icon
        >
      </v-avatar>
    </v-card-title>

    <v-window v-model='step'>
      <!--1단계-->
      <v-window-item :value='1'>
        <!-- 양식 -->
        <v-card-text>
          <h2 style='font-size: 24px; text-align: center; margin: 5px'>
            먼저 모임의 썸네일, 이름, 카테고리를 정해볼까요?
          </h2>
          <div style='display: flex; align-items: center; margin: 30px 0 10px 0'>
            <v-icon color='blue-lighten-2' icon='mdi-at' size='36' style='align-self: center'></v-icon>
            <span style='font-size: 20px; font-weight: 700; margin-left: 10px'>HOBBY 이름</span>
            <span style='font-size: 14px; margin-left: 80px'>! HOBBY이름과 카테고리는 추후 변경이 불가합니다.</span>
          </div>

          <input
            v-model='hobbytitle'
            placeholder='Hobby 이름'
            style='
              border: 2px solid #24b1d0;
              border-radius: 10px;
              height: 40px;
              width: 500px;
              padding-left: 20px;
              margin: 0 0 7px 20px;
              color: white;
              font-size: 16px;
              font-weight: 700;
            '
            type='text'
          />
          <div style='display: flex; align-items: center; margin: 20px 0 0 0'>
            <v-icon color='blue-lighten-2' icon='mdi-bookmark-outline' size='36' style='align-self: center'></v-icon>
            <span style='font-size: 20px; font-weight: 700; margin-left: 10px'>카테고리</span>
          </div>
          <div style='display: flex; align-items: center; text-align: center'>
            <v-item-group v-model='myValue' mandatory='force' selected-class='bg-pink'>
              <v-item v-for='n in 12' :key='n' v-slot='{ selectedClass, toggle }'>
                <v-btn
                  :class='selectedClass'
                  style='
                    width: 70px;
                    height: 45px;
                    justify-content: center;
                    text-align: center;
                    margin: 10px;
                    border: 2px solid #fa8eb6;
                    border-radius: 50px;
                    background-color: #0e0f28;
                    color: white;
                    font-size: 13px;
                    font-weight: 700;
                    text-shadow: 0 4px 4px rgba(0, 0, 0, 0.25);
                  '
                  @click='toggle'
                >
                  #{{ tags[n - 1] }}
                </v-btn>
              </v-item>
            </v-item-group>
          </div>
        </v-card-text>
      </v-window-item>

      <!--2단계-->
      <v-window-item :value='2'>
        <!-- 양식 -->
        <v-card-text>
          <div>
            <h2 style='font-size: 24px; text-align: center; margin: 5px'>"{{ hobbytitle }}"에 대해 소개해주세요!</h2>
          </div>
          <div style='display: flex; align-items: center; margin: 20px 0 10px 0'>
            <v-icon
              color='blue-lighten-2'
              icon='mdi-message-question-outline'
              size='36'
              style='align-self: center'
            ></v-icon>
            <span style='font-size: 20px; font-weight: 700; margin-left: 10px'>HOBBY 소개</span>
          </div>
          <v-textarea v-model='groupIntro' label='어떤 모임인가요' variant='outlined'></v-textarea>
        </v-card-text>
      </v-window-item>

      <!--3단계-->
      <v-window-item :value='3'>
        <!-- 양식 -->
        <v-card-text>
          <div>
            <h2 style='font-size: 24px; text-align: center; margin: 5px 0 -20px 0'>거의 끝났습니다 :)</h2>
          </div>
          <div style='display: flex; align-items: center; margin: 40px 0 0 0'>
            <v-icon
              color='blue-lighten-2'
              icon='mdi-account-multiple-outline'
              size='30'
              style='align-self: center'
            ></v-icon>
            <span style='font-size: 18px; font-weight: 700; margin-left: 10px'>최대 활동 인원</span>
            <span style='font-size: 12px; margin-left: 150px'>! 활동인원과 가입조건은 추후 변경이 불가합니다</span>
          </div>
          <v-item-group v-model='maxCnt' mandatory='force' selected-class='bg-pink' style='display: flex'>
            <v-item v-for='n in 5' :key='n' v-slot='{ selectedClass, toggle }'>
              <div style='display: flex; flex-direction: column; align-items: center; margin: 0 30px 0 -2px'>
                <v-btn
                  :class='selectedClass'
                  size='60'
                  style='
                    justify-content: center;
                    text-align: center;
                    margin: 15px;
                    border: 2px solid white;
                    border-radius: 50px;
                    background-color: #0e0f28;
                    color: white;
                    font-size: 20px;
                    font-weight: 700;
                    text-shadow: 0 4px 4px rgba(0, 0, 0, 0.25);
                  '
                  @click='toggle'
                >
                  {{ people[n - 1] }}
                </v-btn>
                <div
                  style='
                    width: 55px;
                    height: 20px;
                    border: 2px solid white;
                    border-radius: 40px 40px 0 0 / 17px 17px 0 0;
                    margin-top: -10px;
                  '
                ></div>
              </div>
            </v-item>
          </v-item-group>
          <div style='display: flex; align-items: center; margin: 20px 0 5px 0'>
            <v-icon color='blue-lighten-2' icon='mdi-login' size='30' style='align-self: center'></v-icon>
            <span style='font-size: 18px; font-weight: 700; margin-left: 10px'>가입 유형</span>
          </div>
          <v-item-group v-model='isFree' mandatory='force' style='margin-left: 35px'>
            <v-container>
              <v-row>
                <v-item v-slot='{ isSelected, toggle }'>
                  <v-card
                    :color="isSelected ? 'cyan' : ''"
                    class='d-flex align-center'
                    height='100'
                    style='
                      background-color: #0e0f28;
                      border: solid #24b1d0;
                      border-width: 2px 1px 2px 2px;
                      border-radius: 10px 0 0 10px;
                    '
                    width='250'
                    @click='toggle'
                  >
                    <div
                      v-if='isSelected'
                      class='flex-grow-1 text-center'
                      style='
                        color: white;
                        font-size: 24px;
                        font-weight: 700;
                        display: flex;
                        flex-direction: column;
                        align-items: center;
                      '
                    >
                      <v-icon icon='mdi-lock-open-variant-outline' size='16' style='margin: -10px 0 10px 0'></v-icon>
                      자유 가입
                    </div>
                    <div
                      v-if='!isSelected'
                      class='flex-grow-1 text-center'
                      style='color: white; font-size: 20px; font-weight: 700'
                    >
                      자유 가입<br />
                      <v-divider style='margin: 5px'></v-divider
                      >
                      <span style='font-size: 12px; font-weight: 400'
                      >관리자의 별도 승인 없이<br />바로 가입 및 활동이 가능합니다.</span
                      >
                    </div>
                  </v-card>
                </v-item>
                <v-item v-slot='{ isSelected, toggle }'>
                  <v-card
                    :color="isSelected ? 'pink' : ''"
                    class='d-flex align-center'
                    dark
                    height='100'
                    style='
                      background-color: #0e0f28;
                      border: solid #24b1d0;
                      border-width: 2px 2px 2px 1px;
                      border-radius: 0 10px 10px 0;
                    '
                    width='250'
                    @click='toggle'
                  >
                    <div
                      v-if='isSelected'
                      class='flex-grow-1 text-center'
                      style='
                        color: white;
                        font-size: 24px;
                        font-weight: 700;
                        display: flex;
                        flex-direction: column;
                        align-items: center;
                      '
                    >
                      <v-icon icon='mdi-lock-outline' size='16' style='margin: -10px 0 10px 0'></v-icon>
                      신청 가입
                    </div>
                    <div
                      v-if='!isSelected'
                      class='flex-grow-1 text-center'
                      style='color: white; font-size: 20px; font-weight: 700'
                    >
                      신청 가입<br />
                      <v-divider style='margin: 5px'></v-divider
                      >
                      <span style='font-size: 12px; font-weight: 400'
                      >관리자의 가입승인이 있어야<br />활동이 가능합니다.</span
                      >
                    </div>
                  </v-card>
                </v-item>
              </v-row>
            </v-container>
          </v-item-group>
        </v-card-text>
      </v-window-item>
    </v-window>

    <v-divider style='margin-top: -10px'></v-divider>

    <v-card-actions>
      <v-btn
        v-if='step > 1'
        color='white'
        icon='mdi-chevron-left'
        size='48'
        style='background-color: #567cff'
        @click='beforestep'
      >
      </v-btn>
      <v-spacer></v-spacer>
      <v-btn
        v-if='step < 3'
        :disabled='!isButtonAbled'
        color='white'
        icon='mdi-chevron-right'
        size='48'
        style='background-color: #567cff'
        @click='nextstep'
      >
      </v-btn>

      <v-btn
        v-if='step == 3' color='white' icon='mdi-check' size='48' style='background-color: #fa8eb6'
        @click='handleSubmit'></v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
export default {
  data: () => ({
    step: 1,
    tags: ['게임', '스터디', '공예', '코딩', '스포츠', '문화', '예술', '음악', '패션', '여행', '요리', '파티'],
    people: [12, 13, 14, 15, 16],
    hobbytitle: '',
    myValue: undefined,
    groupIntro: '',
    maxCnt: undefined,
    isFree: undefined,
  }),

  computed: {
    currentTitle() {
      switch (this.step) {
        case 1:
          return 'Sign-up';
        case 2:
          return 'Create a password';
        default:
          return 'Account created';
      }
    },
    isButtonAbled() {
      if (this.step === 1) {
        return !!this.hobbytitle && Number.isInteger(this.myValue);
      } else if (this.step === 2) {
        return true;
      }
      return true;
    },
  },

  methods: {
    handleSubmit() {
      const data = {
        maxMemberCnt: this.maxCnt + 12,
        name: this.hobbytitle,
        intro: this.groupIntro,
        category: this.tags[this.myValue],
        free: this.isFree === 0 ? 'FREE' : 'NOT FREE',
      };
      this.$emit('handleSubmit', data);
    },
    beforestep() {
      const s1 = document.getElementById('s1');
      const s2 = document.getElementById('s2');
      const s3 = document.getElementById('s3');
      this.step--;
      if (this.step == 1) {
        s1.setAttribute('style', 'background-color: #FA8EB6; font-weight: 700;');
        s2.setAttribute('style', 'background-color: #567CFF; font-weight: 400;');
      } else if (this.step == 2) {
        s2.setAttribute('style', 'background-color: #FA8EB6; font-weight: 700;');
        s3.setAttribute('style', 'background-color: #567CFF; font-weight: 400;');
      }
    },
    nextstep() {
      const s1 = document.getElementById('s1');
      const s2 = document.getElementById('s2');
      const s3 = document.getElementById('s3');
      this.step++;
      if (this.step == 2) {
        console.log('dd');
        s1.setAttribute('style', 'background-color: #567CFF; font-weight: 400;');
        s2.setAttribute('style', 'background-color: #FA8EB6; font-weight: 700;');
      } else if (this.step == 3) {
        s2.setAttribute('style', 'background-color: #567CFF; font-weight: 400;');
        s3.setAttribute('style', 'background-color: #FA8EB6; font-weight: 700;');
      }
    },
  },
};
</script>

<style>
.bg {
  font-family: 'LINESeedKR-Rg';
}

@font-face {
  font-family: 'LINESeedKR-Rg';
  src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_11-01@1.0/LINESeedKR-Rg.woff2') format('woff2');
  font-weight: 400;
  font-style: normal;
}

#s1 {
  background-color: #fa8eb6;
}

#s2 {
  background-color: #567cff;
}

#s3 {
  background-color: #567cff;
}
</style>
