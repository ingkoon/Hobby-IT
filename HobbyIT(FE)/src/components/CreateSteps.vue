<template>
  <v-card
    class="mx-auto"
    max-width="600"
    style="height:700px; background-color:#0E0F28; color: white;"
  >
    <!-- 숫자 -->
        <v-card-title class="text-h6 font-weight-regular justify-space-between" style="display: flex; align-items: center;">
          <v-avatar
            size="64"
            style="border-width: 2px; border-style: solid; border-color: white; color: white; margin-left:10px;"
            id="s1"
          >1</v-avatar>
          <hr style="color:white; width:150px;">
          <v-avatar
            size="64"
            style="border-width: 2px; border-style: solid; border-color: white; color: white;"
            id="s2"
          >2</v-avatar>
          <hr style="color:white; width:150px;">
          <v-avatar
            size="64"
            style="border-width: 2px; border-style: solid; border-color: white; color: white; margin-right: 20px;"
            id="s3"
          >3</v-avatar>
        </v-card-title>

    <v-window v-model="step">
      <!--1단계-->
      <v-window-item :value="1">

        <!-- 양식 -->
        <v-card-text>
          <h2 style="font-size:20px; text-align:center; margin: 5px;">먼저 모임의 썸네일, 이름, 카테고리를 정해볼까요?</h2>
          <div style="display: flex; align-items:center; margin: 20px 0px 10px 0px;">
            <v-icon icon="mdi-at" size="36" color="blue-lighten-2" style="align-self: center;"></v-icon>
            <span style="font-size:26px; font-weight: 700; margin-left: 10px;">HOBBY 이름</span>
            <span style="font-size:12px; margin-left: 80px;">!HOBBY이름과 카테고리는 추후 변경이 불가합니다.</span>
          </div>

          <input
          type="text"
          v-model="hobbytitle"
          placeholder="Hobby 이름"
          style="border:2px solid #24B1D0; border-radius:10px; height:60px; width:550px; padding-left:20px; margin:15px 0px 7px;
          color:white; font-size: 26px; font-weight: 700;"
          >
          <div style="display: flex; align-items:center; margin: 20px 0px 10px 0px;">
            <v-icon icon="mdi-bookmark-outline" size="36" color="blue-lighten-2" style="align-self: center;"></v-icon>
            <span style="font-size:26px; font-weight: 700; margin-left: 10px;">카테고리</span>
          </div>
          <div style="display: flex; align-items: center; text-align: center;">
            <v-item-group mandatory selected-class="bg-purple" v-model="myValue">
              <v-item
                v-for="n in 12"
                :key="n"
                v-slot="{ selectedClass, toggle }"
              >
                <v-chip
                  :class="selectedClass"
                  style="width:120px; height:60px; justify-content:center; text-align: center; margin: 10px; border: 4px solid #FA8EB6;
                   background-color: white; color: black; font-size: 20px; font-weight: 700; text-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);"
                  @click="toggle"
                >
                  {{ tags[n-1] }}
                </v-chip>
              </v-item>
            </v-item-group>
          </div>
        </v-card-text>
      </v-window-item>

      <!--2단계-->
      <v-window-item :value="2">
        <!-- 양식 -->
        <v-card-text>
          <div>
            <h2 style="font-size:24px; text-align:center; margin: 5px;">"{{hobbytitle}}"에 대해 소개해주세요!</h2>
          </div>
          <div style="display: flex; align-items:center; margin: 20px 0px 10px 0px;">
            <v-icon icon="mdi-message-question-outline" size="36" color="blue-lighten-2" style="align-self: center;"></v-icon>
            <span style="font-size:20px; font-weight: 700; margin-left: 10px;">HOBBY 소개</span>
          </div>
          <v-textarea label="intro" variant="outlined"></v-textarea>
        </v-card-text>
      </v-window-item>

      <!--3단계-->
      <v-window-item :value="3">
        <!-- 양식 -->
        <v-card-text>
          <div style="display: flex; align-items:center; margin: 20px 0px 10px 0px;">
            <v-icon icon="mdi-account-multiple-outline" size="36" color="blue-lighten-2" style="align-self: center;"></v-icon>
            <span style="font-size:26px; font-weight: 700; margin-left: 10px;">최대 활동 인원</span>
            <span style="font-size:12px; margin-left: 80px;">!활동인원과 가입조건은 추후 변경이 불가합니다</span>
          </div>
          <div style="display: flex; align-items:center; margin: 20px 0px 10px 0px;">
            <v-icon icon="mdi-login" size="36" color="blue-lighten-2" style="align-self: center;"></v-icon>
            <span style="font-size:20px; font-weight: 700; margin-left: 10px;">가입 조건</span>
          </div>
          <v-textarea label="intro" variant="outlined"></v-textarea>
        </v-card-text>
      </v-window-item>
    </v-window>

    <v-divider></v-divider>

    <v-card-actions>
      <v-btn
        v-if="step > 1"
        color="white"
        @click="beforestep"
        style="background-color: #567CFF;"
        icon="mdi-chevron-left"
      >
      </v-btn>
      <v-spacer></v-spacer>
      <v-btn
        v-if="step < 3"
        color="white"
        @click="nextstep"
        :disabled="!isButtonAbled"
        style="background-color: #567CFF;"
        icon="mdi-chevron-right"
      >
      </v-btn>

      <v-btn
        v-if="step == 3"
        color="white"
        style="background-color: #FA8EB6;"
        icon="mdi-check-bold"
      >
      </v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
  export default {
      data: () => ({
        step: 1,
        tags: ["#게임", "#스터디", "#공예", "#코딩", "#스포츠", "#문화", "#예술", "#음악", "#패션", "#여행", "#요리", "#파티"],
        hobbytitle : '',
        myValue: undefined,
      }),

      computed: {
        currentTitle () {
          switch (this.step) {
            case 1: return 'Sign-up'
            case 2: return 'Create a password'
            default: return 'Account created'
          }
        },
        isButtonAbled(){
          if(this.step === 1){
            return !!this.hobbytitle &&  Number.isInteger(this.myValue)
          }else if(this.step === 2){
            return true
          }
          return true
        }
      },

      methods: {
        beforestep(){
          const s1 = document.getElementById("s1")
          const s2 = document.getElementById("s2")
          const s3 = document.getElementById("s3")
          this.step--
          if(this.step == 1){
            s1.setAttribute("style","background-color: #FA8EB6")
            s2.setAttribute("style","background-color: #567CFF")
          }else if(this.step == 2){
            s2.setAttribute("style","background-color: #FA8EB6")
            s3.setAttribute("style","background-color: #567CFF")
          }
        },
        nextstep(){
          const s1 = document.getElementById("s1")
          const s2 = document.getElementById("s2")
          const s3 = document.getElementById("s3")
          this.step++
          if(this.step == 2){
            console.log("dd")
            s1.setAttribute("style","background-color:#567CFF;")
            s2.setAttribute("style","background-color: #FA8EB6")
          }else if(this.step == 3){
            s2.setAttribute("style","background-color: #567CFF")
            s3.setAttribute("style","background-color: #FA8EB6")
          }
        },

      },

      // mounted(){
      //   console.log("init")
      //   const s1 = document.getElementById("s1")
      //   const s2 = document.getElementById("s2")
      //   const s3 = document.getElementById("s3")
      //   s1.setAttribute("style","background-color:#FA8EB6;")
      //   s2.setAttribute("style","background-color:#567CFF")
      //   s3.setAttribute("style","background-color:#567CFF;")
      // }
    }
</script>

<style>
#s1 {
  background-color : #FA8EB6
}
#s2 {
  background-color :#567CFF
}
#s3 {
  background-color :#567CFF
}
</style>
