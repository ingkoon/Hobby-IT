<template>
  <v-card
    class="mx-auto"
    max-width="265"
    :height=n*(Math.random()*50)+300
    style="background-color:#fbd3de; margin: 5px 0"
    >
    <v-img
      class="align-end text-white"
      src="https://cdn.vuetifyjs.com/images/cards/docks.jpg"
      cover
    >
    </v-img>

    <v-card-subtitle class="pt-4" style="color:black; opacity:1">
      배낭여행 {{n}}일차
    </v-card-subtitle>

    <v-card-text>
      <div style="font-size:16px; font-family:linefont">
        석촌호수에 도착했다. 커플들이 많이 보인다. 파인애플이 듬뿍 올라간 피자가 먹고 싶습니다.
      </div>
      <div style="display:flex; justify-content:space-between; color:#b3b3b3; margin-top:25px">
        <div>
          <v-icon icon="mdi-account-circle" size="small" color="#FA8EB6"></v-icon>
          John
        </div>
        <div>
          <v-icon icon="mdi-thumb-up" size="small" color="#000000"></v-icon>
          10
          <v-icon icon="mdi-message-bulleted" size="small" color="#000000"></v-icon>
          11
        </div>
      </div>
    </v-card-text>
  </v-card>
</template>

<script>
export default {
  data(){
    return {
      
    }
  },
  props : {
    n : Number,
  }
}
</script>

<style>

</style>