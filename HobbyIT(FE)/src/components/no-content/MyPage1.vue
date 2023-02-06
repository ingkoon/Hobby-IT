<template>
  <div style="display:flex">

    <v-card class="mx-auto" style="background-color: #ffffff00; margin:0;" width="250px" @click="opencreategroup">
      <v-img>
        <div style="border : 5px solid #FA8EB6; width:190px; height:250px; display:flex; justify-content:center">
          <div id="makegroup" style="background-color:#0E0F28; width:100px; height:320px">
  
          </div>
          <div id="makegroup2" style="background-color:#0E0F28; width:190px; height:140px">
  
          </div>
          <v-icon icon="mdi-plus" style="align-self:center; color:#FA8EB6"></v-icon>
          <v-dialog v-model="creategroupmodal" >
            <create-group @closecreategroup="closecreategroup" />
          </v-dialog>
        </div>
      </v-img>
  
      <v-card-subtitle class="pt-4" style="color: #ffffff; opacity: 1"> Hobby 만들기 </v-card-subtitle>
    </v-card>
    <div style="display:flex; background-color:#1D1E44 ; border-radius: 20px; padding:10px; text-align: center; flex-grow:1; margin-bottom:40px; align-self: center;">
      <img src="assets/gif/keyboard.gif"/>
      <div style="color : #44475E; font-size:25px; flex-grow: 1; align-self: center;">
        Just Hobby'It!
      </div>
    </div>        
  </div>
</template>
<script>
import CreateGroup from '../CreateGroup.vue';

export default {
  components: {
    CreateGroup,
  },
  data(){
    return {
      creategroupmodal: false,
    };
  },
  methods : {
    opencreategroup() {
      this.creategroupmodal = true;
    },
    closecreategroup() {
      this.creategroupmodal = false;
    },
  }
}
</script>
<style scoped>
  img {
    width : 200px;
    height : 200px;
    border-radius: 20px;
  }
</style>