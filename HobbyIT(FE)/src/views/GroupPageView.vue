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
          <v-icon icon="mdi-account-multiple" size="small" color="#FA8EB6"></v-icon>
          13/20
        </div>
      </div>

      <div style="display:flex; justify-content:space-around">
        <v-btn color="#2B146C" style="color:white; height:44px; width:47%">
          <v-icon icon="mdi-plus-circle-outline"></v-icon>
        </v-btn>
        <v-btn color="#2B146C" style="color:white; height:44px; width:47%">
          <v-icon icon="mdi-video-account" @click="onclickVideoChat"></v-icon>
        </v-btn>
      </div>


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
      style="width:30%; background-color:#0e0f28; border-left:5px solid #fa8eb6; position:fixed; top:59px;"
    >
    <div>
      <v-list-item
        style="color:white;"
      >
        <div style="font-size:40px; margin:7px">방명록</div>
        <span style="font-size:16px; margin-left:10px">오늘 작성된 방명록들은 다음 날부터 열람 가능합니다</span>
      </v-list-item>

      <div style="text-align:center; margin:20px;">
        <v-date-picker
          v-model="date"
          color="purple"
          :max-date="nowdate"
          style="background-color:#fbd3de; padding:10px; width:85%"
          :attributes="attrs"
        />
      </div>

      <div id="canvasdialog" style="text-align:center;">
        <v-btn color="white" >
          <div style="display:flex; flex-direction:column; align-items:center">
            <v-icon icon="mdi-calendar-plus-outline" color="white"></v-icon>
            <span style="color:white; margin-top:10px">방명록<br>작성하기</span>
          </div>

          <v-dialog v-model="canvasmodal" activator="parent">
            <canvasadd @close="closeaddmodal"/>
          </v-dialog>
        </v-btn>
      </div>
    </div>

  </v-navigation-drawer>


</template>

<script>
import GroupNotice from '../components/GroupNotice.vue';
import ArticleItem from "../components/ArticleItem.vue";
import Canvasadd from '../components/Canvasadd.vue';

export default {
  components : {
    ArticleItem,
    GroupNotice,
    Canvasadd,
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
        {
          key: 'visit',
          dot: true,
          dates: new Date(2023, 0, 18),
        },
        {
          key: 'visit',
          dot: true,
          dates: new Date(2023, 0, 24),
        },
      ],
      canvasmodal : false,
      message : '',

    }
  },

  methods : {
    onclickVideoChat(){
      window.open("http://localhost:3000/group/videochat", "_blank");
      // this.$router.push({name:'VideoChat',target:'_blank'})
    },
    openaddmodal(){
      this.canvasmodal = true
    },
    closeaddmodal(){
      this.canvasmodal = false
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

.v-field--variant-outlined .v-field__outline__end.v-locale--is-ltr, .v-locale--is-ltr .v-field--variant-outlined .v-field__outline__end {
    border-radius: 0 40px 40px 0 !important ;
    opacity: 1;
}

.v-field--variant-outlined .v-field__outline__start {
    flex: 1 !important;
}

.v-field--variant-outlined .v-field__outline__start.v-locale--is-ltr, .v-locale--is-ltr .v-field--variant-outlined .v-field__outline__start {
    border-radius: 40px 0 0 40px !important;
    opacity: 1;
}

#canvasdialog button {
  background: linear-gradient(to bottom, #642EFE, #0E0F28);
  width : 120px;
  height: 120px;
  border-radius: 150px;
}

</style>
