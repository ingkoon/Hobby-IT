<template>
  <v-slide-group-item>
    <v-card class="mx-auto" max-width="180" style="background-color: #ffffff00; padding: 10px" @click=goToGroup(lst.id)>
      <v-img class="align-end text-white" height="250" :src="lst.img" cover>
      </v-img>

      <v-card-subtitle class="pt-4" style="color: #ffffff; opacity: 1"> {{ lst.name }} </v-card-subtitle>

      <v-card-text style="display: flex; justify-content: space-between; color: #b3b3b3">
        <div>#{{ lst.category }}</div>
        <div>
          <v-icon icon="mdi-account-multiple" size="small" color="#FA8EB6"></v-icon>
          {{lst.participantsNum}} / {{ lst.maxParticipantsNum }}
        </div>
        
      </v-card-text>
    </v-card>
  </v-slide-group-item>
</template>

<script>
export default {
  props : {
    lst : Object,
  },
  methods:{
    goToGroup(id) {
      console.log(id)
      this.$router.push({name : 'GroupMainPage', params : {id}})
    },
  }
};
</script>

<style></style>
