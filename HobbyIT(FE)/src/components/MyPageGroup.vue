<template>
  <v-slide-group
      show-arrows
      style="margin:1% 0;"
  >
    <v-slide-group-item>

      <v-card
        class="mx-auto"
        style="background-color:#ffffff00; padding:10px"
        width="250"
        @click = "opencreategroup"
        >
        <v-img>
          <div style="border : 5px solid #FA8EB6; width:190px; height:250px; display:flex; justify-content:center">
            <div id="makegroup" style="background-color:#0E0F28; width:100px; height:320px">

            </div>
            <div id="makegroup2" style="background-color:#0E0F28; width:190px; height:140px">

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
      <MyPageGroupItem/>
    </v-slide-group-item>
  </v-slide-group>
</template>

<script>
import CreateGroup from './CreateGroup.vue';
import MyPageGroupItem from './MyPageGroupItem.vue';

export default {
  components: {
    MyPageGroupItem,
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
  top: 0;
  left: 45px;
}
#makegroup2 {
  position: absolute;
  top: 60px;
  left: 0;
}
</style>
