<template>
  <h3>John, 나 여행가고싶어</h3>

  <div style="color:white; display:flex">
    <!-- 왼쪽 모임 정보 탭 -->
    <div id = "groupinfo">
      <img src="src\assets\tmpimg.jpeg">
      <div id="title">John, 나 여행가고싶어</div>
      <div id="content">
        따분한 일상에서 벗어나 자유로운 여행을 떠나고 싶은 여행자들의 모임입니다.
        <div style="margin-top : 20px">
          카테고리 : 여행 <br>
          가입유형 : 신청가입 <br>
          개설일 : 2023.1.1
        </div>

        <div style="margin-top : 20px">
          <v-icon icon="mdi-account-multiple" size="small" color="#FA8EB6"></v-icon>
          13/20
        </div>
      </div>
      <v-btn block color="#642EFE" style="color:white; font-size:24px; height:44px">글 작성</v-btn>
      <v-btn block color="#642EFE" style="color:white; font-size:24px; height:44px">화상 채팅</v-btn>

      <v-text-field 
        clearable
        variant="outlined"
        prepend-inner-icon="mdi-magnify"
        placeholder="검색"
        style="color:white; height:40px"
        ></v-text-field>
    </div>
    <!-- 오른쪽 게시판 탭 -->
    <div>
      <v-card>
        <v-tabs
          v-model="tab"
          color="deep-purple-accent-4"
          align-tabs="start"
        >
          <v-tab :value="1">Landscape</v-tab>
          <v-tab :value="2">City</v-tab>
          <v-tab :value="3">Abstract</v-tab>
        </v-tabs>
        <v-window v-model="tab">
          <v-window-item
            v-for="n in 3"
            :key="n"
            :value="n"
          >
            <v-container fluid>
              <v-row>
                <v-col
                  v-for="i in 6"
                  :key="i"
                  cols="12"
                  md="4"
                >
                  <v-img
                    :src="`https://picsum.photos/500/300?image=${i * n * 5 + 10}`"
                    :lazy-src="`https://picsum.photos/10/6?image=${i * n * 5 + 10}`"
                    aspect-ratio="1"
                  ></v-img>
                </v-col>
              </v-row>
            </v-container>
          </v-window-item>
        </v-window>
      </v-card>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style>
h3 {
  font-size:48px;
  background: linear-gradient(to bottom, #642EFE, #FA8EB6);
  color: transparent;
  -webkit-background-clip: text;
  margin-top:50px
}
#groupinfo {
  width: 248px;
}

#groupinfo img {
  width:248px;
  height:342px;
  border:2px solid #fa8eb6
}

#groupinfo #title {
  font-size: 24px;
  text-align: center;
  margin: 17px 0px;
  
}

#groupinfo #content {
  font-size : 20px;
  font-family: linefont;
  word-break: keep-all;
  margin-bottom: 40px;
}

button { 
  margin: 15px 0px;
}
</style>
