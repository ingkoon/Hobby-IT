<template>
  <h3 style="font-size:36px;">관심 <span>#카테고리</span>를 선택해보세요.</h3>

  <v-slide-group
      show-arrows
      style="margin:1% 0%;"
      selected-class="font-family:linefontbold"
      v-model="selecttag"
    >
    <v-slide-group-item
      v-for="n in category.length-1"
      :key="n"
      v-slot="{ isSelected, toggle }"
    >
      <v-btn
        class="ma-2"
        id = "categorybtn"
        rounded="pill"
        :style="isSelected ? 'border : 4px solid #642EFE; color:#642EFE; font-family:linefontbold;' : 'border : 4px solid #A8456A; font-family:linefont;' "
        @click="toggle"
      >
        <span style="margin:10px">{{category[n]}}</span>
      </v-btn>
    </v-slide-group-item>
  </v-slide-group>

  <v-carousel hide-delimiter-background style="width:100%; height:450px;" id="main-carousel">
    <v-carousel-item cover src="../src/assets/gif/main1.gif" style="font-size:48px; color:white;">
      <div style="background-color:#1D1E4480; width:100%; height:100%; padding:0px 8%; display:flex">
        <div style="align-self:center; width:100%">
          <div>
            부캐 전성시대,<br>
            그 시작은 Hobby'IT에서
          </div>

          <div style="float:right">
            지금이 바로 시작할 때!
          </div>
        </div>
      </div>
    </v-carousel-item>
  </v-carousel>
    
  <h3 id="search">당신이 참여중인 HOBBY
    <span>
      <v-text-field 
        clearable
        variant="outlined"
        prepend-inner-icon="mdi-magnify"
        placeholder="어떤 취미를 찾으시나요?"
        style="color:white; width:334px; height:44"
        ></v-text-field>
    </span>
    
  </h3>
  
  <participate-group/>

  <h3>오늘의 HOBBY 추천</h3>
  <participate-group/>

  <h3>당신만 오면 GO!</h3>
  <participate-group/>

</template>

<script>
  import ParticipateGroup from '@/components/ParticipateGroup.vue'
  export default {
  components: { ParticipateGroup },
    data(){
      return {
        model : "전체",
        category : ["","전체", "#공예", "#스터디", "#운동", "#음악", "#파티", "#게임", "#코딩"]
      }
    },
  }
</script>

<style>
h3 {
  color : #ffffff;
  margin:1% 0% ;
  font-size:48px;
}

#search {
  display: flex;
  justify-content: space-between;
}

h3 span {
  color : #642EFE;
}

#categorybtn {
  height:50px;
  width: 100px;
  font-size: 16px;
}

i {
  color : white
}

button:not(*){
  font-family:linefont;
}

.v-field--variant-outlined .v-field__outline__end.v-locale--is-ltr, .v-locale--is-ltr .v-field--variant-outlined .v-field__outline__end {
    border-radius: 0 200px 200px 0 !important ;
    opacity: 1;
}

.v-field--variant-outlined .v-field__outline__start {
    flex: 1 !important;
}

.v-field--variant-outlined .v-field__outline__start.v-locale--is-ltr, .v-locale--is-ltr .v-field--variant-outlined .v-field__outline__start {
    border-radius: 100px 0 0 100px !important;
    opacity: 1;
}

#main-carousel button{
  background-color: #ffffff00
}
</style>