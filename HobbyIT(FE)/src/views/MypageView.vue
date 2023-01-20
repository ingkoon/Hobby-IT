<template>
  <h3>John, 나 여행가고싶어</h3>

  <div id="group">
    <!-- 왼쪽 모임 정보 탭 -->
    <div id = "groupinfo">
      <img src="@\assets\tmpimg.jpeg">
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
    <div id="board">
      <v-card style="background-color:#00000000">
        <v-tabs
          v-model="tab"
          align-tabs="start"
          style="color:white;"
          >
          <v-tab value="board">게시글</v-tab>
          <v-tab value="notice">공지사항</v-tab>
          <v-tab value="memberlist">회원목록</v-tab>
        </v-tabs>
        <hr style="margin-top:10px; border: 2px solid #FA8EB6">
        <v-card-text>
          <v-window v-model="tab">
            <v-window-item value="board" id="boarditem">
                <v-container>
                  <v-row >
                    <v-col
                      v-for="j in 4"
                      :key="j"
                      cols="12"
                      sm="3"
                    >
                      <article-item v-for="i in 4" :key="i" :n=j+i />
                    </v-col>
                  </v-row>
                </v-container>
              
            </v-window-item>
            <v-window-item value="notice">
              공지사항
            </v-window-item>
            <v-window-item value="memberlist">
              회원 목록
            </v-window-item>
          </v-window>
        </v-card-text>
      </v-card>
      
    </div>
  </div>
</template>

<script>
import ArticleItem from "../components/ArticleItem.vue"
export default {
  components : {
    ArticleItem
  },
  data(){
    return {
      tab: null,
    }
  },

};
</script>

<style>
h3 {
  font-size:48px;
  background: linear-gradient(to bottom, #642EFE, #FA8EB6);
  color: transparent;
  -webkit-background-clip: text;
  margin-top:50px
}

#group {
  color:white;
  display:flex;
  flex-direction:row;
}

#groupinfo {
  width: 180px;
}

#groupinfo img {
  width:180px;
  height:250px;
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

#board {
  flex-grow: 1;
  margin-left: 20px;
}

#board button {
  font-size: 24px;
}

</style>
