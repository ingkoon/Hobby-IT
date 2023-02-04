<template>
  <v-card class="mx-auto" width="250px" style="background-color: #ffffff00; padding: 10px">
    <div style="display: flex; position: relative">
      <v-img class="align-end text-white" height="250" src="https://cdn.vuetifyjs.com/images/cards/docks.jpg" cover>
      </v-img>
      <div id="tri1"></div>
    </div>

    <v-card-subtitle class="pt-4" style="color: #ffffff; opacity: 1"> Sk8ter Boy </v-card-subtitle>

    <v-card-text style="display: flex; justify-content: space-between; color: #b3b3b3"> </v-card-text>
  </v-card>
</template>

<script>
export default {};
</script>

<style scoped>
img {
  border: 2px solid white;
}

#tri1 {
  width: 0;
  height: 0;
  border-bottom: 20px solid transparent;
  border-top: 20px solid #fa8eb670;
  border-left: 20px solid #fa8eb670;
  border-right: 20px solid transparent;
  align-self: flex-end;
}
</style>
