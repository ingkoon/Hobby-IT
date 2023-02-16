<template>
  <v-slide-group show-arrows style="margin: 1% 0">
    <v-slide-group-item>
      <v-card class="mx-auto" style="background-color: #ffffff00; padding: 10px" width="250" @click="opencreategroup">
        <v-img>
          <div style="border: 5px solid #fa8eb6; width: 190px; height: 250px; display: flex; justify-content: center">
            <div id="makegroup" style="background-color: #0e0f28; width: 100px; height: 320px"></div>
            <div id="makegroup2" style="background-color: #0e0f28; width: 190px; height: 140px"></div>
            <v-icon icon="mdi-plus" style="align-self: center; color: #fa8eb6"></v-icon>
            <v-dialog v-model="creategroupmodal" activator="parent">
              <create-group @closecreategroup="closecreategroup" @create-success="createSuccess" />
            </v-dialog>
          </div>
        </v-img>

        <v-card-subtitle class="pt-4" style="color: #ffffff; opacity: 1"> Hobby 만들기</v-card-subtitle>
      </v-card>
    </v-slide-group-item>

    <MyPageGroupItem v-for="(lst, index) in hobbylist" :key="index" :lst="lst" />
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

  data() {
    return {
      creategroupmodal: false,
    };
  },

  props: {
    hobbylist: Object,
  },

  methods: {
    createSuccess() {
      this.$emit('createSuccess');
    },
    opencreategroup() {
      this.creategroupmodal = true;
    },
    closecreategroup() {
      this.creategroupmodal = false;
    },
  },
};
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
