<template>
  <v-slide-group
      show-arrows
      style="margin:1% 0%;"
  >
    <v-slide-group-item>
      <div style="border : 5px solid #FA8EB6; width:180px; margin:10px; align-">
        <div style="background-color:#0E0F28; width:100px; height:320px" id="makegroup">
          
        </div>
        <div style="background-color:#0E0F28; width:180px; height:200px" id="makegroup2">

        </div>
        <v-icon icon="mdi-plus"></v-icon>
      </div>
      
    </v-slide-group-item>   

    <v-slide-group-item
      v-for="n in 7"
      :key="n"
    >
      <mypage-group-item/>
    </v-slide-group-item>
  </v-slide-group>
</template>

<script>
import MypageGroupItem from './MypageGroupItem.vue';

export default {
  components: { MypageGroupItem },

}
</script>



<style>
#makegroup {
  position: absolute;
  top: 10px;
  left: 50px;
}
#makegroup2 {
  position: absolute;
  top: 70px;
  left: 10px;
}
</style>
