<template>
  <h3>이름 들어갈 곳</h3>

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
          개설일 : 2023.1.1 <br>
          방장 : John
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
          style="color:white;align-items:center; height:57px;"
          >
          <v-tab value="board">게시글</v-tab>
          <v-tab value="notice">공지사항</v-tab>
          <v-tab value="memberlist">회원목록</v-tab>
          <div style="flex-grow:1;">
            <div style="float:right;">
              <v-icon icon="mdi-calendar" color="white" style="padding:35px" @click.stop="drawer = !drawer"></v-icon>
            </div>
          </div>
        </v-tabs>
        <hr style="margin-top:0px; border: 2px solid #FA8EB6">
        <v-card-text>
          <v-window v-model="tab">
            <!-- 게시글 -->
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
              <!-- 공지사항 -->
              <group-notice/>
            </v-window-item>

            <v-window-item value="memberlist">
              회원 목록
            </v-window-item>
          </v-window>
        </v-card-text>
      </v-card>
      
    </div>
  </div>

  <!-- 방명록 사이드바 -->
  <v-navigation-drawer
      v-model="drawer"
      temporary
      location="right"
      style="width:30%;background-color:#0e0f28; border-left:5px solid #fa8eb6"
    >
    <v-list-item
      title="방명록"
      style="color:white;"
    >오늘 작성된 방명록들은 다음 날부터 열람 가능합니다</v-list-item>

    <div style="text-align:center; margin:20px">
      <v-date-picker
        v-model="date"
        color="purple"
        :max-date="nowdate"
        style="background-color:#fbd3de; padding:10px"
        :attributes="attrs"
      />
    </div>
    
  </v-navigation-drawer>
</template>

<script>
import GroupNotice from '../components/GroupNotice.vue';
import ArticleItem from "../components/ArticleItem.vue";

export default {
  components : {
    ArticleItem,
    GroupNotice,
  },
  data(){
    return {
      tab: null,
      drawer : null,
      nowdate: new Date(),
      date: new Date(),
      attrs: [
        {
          key: 'today',
          highlight: {
            color: 'purple',
            fillMode: 'solid',
          },
          dates: new Date(),
        },
        {
          key: 'visit',
          dot: true,
          dates: new Date(2023, 0, 20),
        },
      ],
    }
  },

  methods : {
    
  },
  

};
</script>

<style>
h3 {
  font-size:48px;
  background: linear-gradient(to bottom, #642EFE, #FA8EB6);
  color: transparent;
  -webkit-background-clip: text;
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
  text-align: start;
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

.vc-weekday {
  color: #642efe
}

</style>
