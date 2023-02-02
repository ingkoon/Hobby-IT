<template>
  <v-slide-group
      show-arrows
      style="margin:1% 0%;"
  >
    <v-slide-group-item>

      <v-card
        class="mx-auto"
        width="250"
        style="background-color:#ffffff00; padding:10px"
        @click = "opencreategroup"
        >
        <v-img>
          <div style="border : 5px solid #FA8EB6; width:190px; height:250px; display:flex; justify-content:center">
            <div style="background-color:#0E0F28; width:100px; height:320px" id="makegroup">

            </div>
            <div style="background-color:#0E0F28; width:190px; height:200px" id="makegroup2">

            </div>
            <v-icon icon="mdi-plus" style="align-self:center; color:#FA8EB6"></v-icon>
            <v-dialog v-model="creategroupmodal" activator="parent">
              <create-group @closecreategroup="closecreategroup"/>
            </v-dialog>
          </div>
        </v-img>

        <v-card-subtitle class="pt-4" style="color:#ffffff; opacity:1">
          Hobby 만들기
        </v-card-subtitle>

      </v-card>
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
import CreateGroup from './CreateGroup.vue';
import MypageGroupItem from './MypageGroupItem.vue';

export default {
  components: {
    MypageGroupItem,
    CreateGroup,
   },

  data(){
    return{
      creategroupmodal: false,
    }
  },

  methods: {
    opencreategroup(){
      this.creategroupmodal = true;
    },
    closecreategroup(){
      this.creategroupmodal = false;
    }
   },

}
</script>



<style>
#makegroup {
  position: absolute;
  top: 0px;
  left: 45px;
}
#makegroup2 {
  position: absolute;
  top: 25px;
  left: 0px;
}
</style>
