<template>
  <v-card
    :height=' (Math.random() * 100) + 350'
    class='mx-auto'
    max-width='265'
    style='background-color: #fbd3de; margin: 5px 0; border-radius: 0'
  >
    <v-img class='align-end text-white' cover src='https://cdn.vuetifyjs.com/images/cards/docks.jpg'></v-img>

    <v-card-subtitle class='pt-4' style='color: black; opacity: 1'> 배낭여행 {{ n }}일차</v-card-subtitle>

    <v-card-text>
      <div style='font-size: 16px; font-family: linefont'>
        석촌호수에 도착했다. 커플들이 많이 보인다. 파인애플이 듬뿍 올라간 피자가 먹고 싶습니다.
      </div>
      <div style='display: flex; justify-content: space-between; color: #b3b3b3; margin-top: 25px'>
        <div>
          <v-icon color='#FA8EB6' icon='mdi-account-circle' size='small'></v-icon>
          John
        </div>
        <div>
          <v-icon color='#000000' icon='mdi-thumb-up' size='small'></v-icon>
          10
          <v-icon color='#000000' icon='mdi-message-bulleted' size='small'></v-icon>
          11
        </div>
      </div>
    </v-card-text>
  </v-card>
</template>

<script>
export default {
  props: {
    n: Number,
  },
  data() {
    return {};
  },
};
</script>

<style></style>
