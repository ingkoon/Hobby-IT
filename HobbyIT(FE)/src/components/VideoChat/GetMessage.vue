<template>
  <div style='position:relative; display:flex; margin:10px;'>
    <div id='lefttri' :style='`border-right: 15px solid ${color}; border-bottom: 15px solid ${color}; `'></div>
    <div id='text' :style='`background-color: ${color}`'>
      <div style='font-family: linefont;'>{{ msg.from }}</div>
      {{ msg.data }}
    </div>
  </div>
</template>

<script>
export default {
  props : {
    msg : String,
    color: String
  }
}
</script>

<style scoped>
  #lefttri {
    position: absolute;
    bottom: 0;
    width: 0;
    height: 0;
    border-top : 15px solid transparent;
    border-left: 15px solid transparent;
  }

  #text {
    background-color: white;
    border-radius: 5px 5px 5px 0;
    text-overflow: ellipsis;
    width: 70%;
    font-size : 20px;
    margin-left: 28px;
    padding : 8px;
    word-break: break-all;
    vertical-align: middle;
  }
</style>