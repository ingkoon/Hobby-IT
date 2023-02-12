<template>
  <div style='margin: 100px 13% 0'>
    <h3>{{ groupinfo.name }}</h3>
    <div id='group'>
      <!-- 왼쪽 모임 정보 탭 -->
      <div id='groupinfo'>
        <img :src='groupinfo.img' />
        <div id='title'>{{ groupinfo.name }}</div>
        <div id='content'>
          {{ groupinfo.intro }}
          <div style="margin-top:10px">
            #{{ groupinfo.category }}
          </div>
          <div style='margin-top: 20px'>
            <v-icon color='#FA8EB6' icon='mdi-account-multiple' size='small'></v-icon>
            {{ groupinfo.participantsNum }} / {{ groupinfo.maxParticipantsNum }}
          </div>
        </div>

        <div style='display: flex; justify-content: space-around'>
          <!-- 글작성 모달 -->
          <v-btn color='#2B146C' style='color: white; height: 44px; width: 47%'>
            <v-icon icon='mdi-plus-circle-outline'></v-icon>

            <v-dialog v-model='addarticlemodal' activator='parent'>
              <article-add @closeaddarticle='closeaddarticle' />
            </v-dialog>
          </v-btn>
          <!-- 화상채팅 버튼 -->
          <v-btn color='#2B146C' style='color:white; height: 44px; width: 47%' @click='onclickVideoChat'>
            <v-icon icon='mdi-video-account'></v-icon>
          </v-btn>
        </div>

        <div v-if="groupinfo.privilege === 'OWNER'">
          <v-btn @click="openaddnotice" style="width:100%; color:white; background-color: #2b146c;" > 공지 작성 </v-btn>
        </div>

        <v-dialog v-model="addnoticemodal">
            <add-notice @close="closeaddnotice"/>
        </v-dialog>

        <!-- 검색 -->
        <!-- <v-text-field
          clearable
          placeholder='검색'
          prepend-inner-icon='mdi-magnify'
          style='color: white; height: 40px'
          variant='outlined'
        ></v-text-field> -->
      </div>
      <!-- 오른쪽 게시판 탭 -->
      <div id='board' style="position:relative">
        <v-card id='tabcard' style='background-color: #00000000' :style="groupinfo.hobbyMemberId === null ? 'filter: blur(5px); -webkit-filter: blur(5px);' : ''">
          <v-tabs v-model='tab' align-tabs='start' style='color: white; align-items: center; height: 57px'>
            <v-tab value='board'>게시글</v-tab>
            <v-tab value='notice'>공지사항</v-tab>
            <v-tab value='memberlist'>회원목록</v-tab>
            <v-tab v-if="groupinfo.hobbyMemberId!==null" value='memberregi'>가입신청</v-tab>
            <div style='flex-grow: 1'>
              <div style='float: right'>
                <v-icon color='white' icon='mdi-calendar' style='padding: 35px' @click.stop='drawer = !drawer'></v-icon>
              </div>
            </div>
          </v-tabs>
          <hr style='margin-top: 0; border: 2px solid #fa8eb6' />
          <v-card-text>
            <v-window v-model='tab'>
              <!-- 게시글 -->
              <v-window-item id='boarditem' value='board'>
                <v-container>
                  <v-row>
                    <v-col v-for='j in 4' :key='j' cols='12' sm='3'>
                      <article-item
                        v-for='article in filteredArticles(j)'
                        :key='article'
                        :article-data='article'
                        :n='j' @click='openmodal' />
                    </v-col>
                  </v-row>
                </v-container>
              </v-window-item>
              <v-window-item value='notice'>
                <!-- 공지사항 -->
                <group-notice />
              </v-window-item>

              <v-window-item value='memberlist'>
                <!-- 회원목록 -->
                <group-member :groupid="groupid"/>
              </v-window-item>
              <v-window-item value='memberregi'>
                <!-- 가입신청 -->
                <group-regi :groupid="groupid"/>
              </v-window-item>
            </v-window>
          </v-card-text>
        </v-card>

        <v-btn id="registerbtn" v-if="this.groupinfo.hobbyMemberId===null" @click="openregimodal" style="position: absolute; left:37%; top : 100px;">
          가입 신청하기
        </v-btn>
      </div>
      <v-dialog v-model='freemodal'>
        <freeRegi @close="closefreemodal"/>
      </v-dialog>
      <v-dialog v-model='unfreemodal'>
        <unfreeRegi @close="closeunfreemodal"/>
      </v-dialog>
      <v-dialog v-model='articlemodal'>
        <article-modal @closearticle='closearticle' />
      </v-dialog>
    </div>

    <!-- 방명록 사이드바 -->
    <v-navigation-drawer
      v-model='drawer'
      location='right'
      style='width: 30%; background-color: #0e0f28; border-left: 5px solid #fa8eb6; position: fixed; top: 59px'
      temporary
    >
      <div>
        <v-list-item style='color: white'>
          <div style='font-size: 40px; margin: 7px'>방명록</div>
          <span style='font-size: 16px; margin-left: 10px'>오늘 작성된 방명록들은 다음 날부터 열람 가능합니다</span>
        </v-list-item>

        <div style='text-align: center; margin: 20px'>
          <v-date-picker
            v-model='date'
            :attributes='attrs'
            :max-date='today'
            color='purple'
            style='background-color: #fbd3de; padding: 10px; width: 85%'
          />
        </div>

        <div id='canvasdialog' style='text-align: center'>
          <!-- 방명록 생성 모달 -->
          <v-btn color='white'>
            <div style='display: flex; flex-direction: column; align-items: center'>
              <v-icon color='white' icon='mdi-calendar-plus-outline'></v-icon>
              <span style='color: white; margin-top: 10px'>방명록<br />작성하기</span>
            </div>

            <v-dialog v-model='canvasmodal' activator='parent'>
              <CanvasAdd @close='closeAddedModal' :groupid="groupid" />
            </v-dialog>
          </v-btn>
        </div>
      </div>
    </v-navigation-drawer>
    <InfiniteScrollObserver @infinite-scroll-trigger='loadData' />

  </div>
</template>

<script>
import GroupNotice from '../components/GroupNotice.vue';
import GroupMember from '../components/MemberList.vue';
import GroupRegi from '../components/GroupRegi.vue';
import ArticleItem from '../components/ArticleItem.vue';
import ArticleAdd from '../components/AddGroupArticle.vue';
import ArticleModal from '../components/GroupArticle.vue';
import CanvasAdd from '@/components/CanvasAdd.vue';
import InfiniteScrollObserver from '@/components/InfiniteScrollObserver.vue';
import freeRegi from '@/components/modals/GroupFreeRegi.vue'
import unfreeRegi from '@/components/modals/GroupRegister.vue'
import addNotice from '@/components/modals/AddNotice'

import { useUserStore } from '@/store/user'
import { getGroupInfo, requestGroupJoin } from '@/api/hobby';

export default {
  setup(){
    const userStore = useUserStore();
    return {userStore}
  },

  components: {
    InfiniteScrollObserver,
    ArticleItem,
    GroupNotice,
    CanvasAdd,
    ArticleAdd,
    ArticleModal,
    GroupMember,
    GroupRegi,
    freeRegi,
    unfreeRegi,
    addNotice
  },
  data() {
    return {
      tab: null,
      drawer: null,
      today: new Date(),
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
      canvasmodal: false,
      addarticlemodal: false,
      articlemodal: false,
      groupinfo: [],
      articles: [],
      groupid : 0,
      freemodal : false,
      unfreemodal : false,
      addnoticemodal : false,
    };
  },
  computed: {
    filteredArticles() {
      return num => this.articles.filter((element, index) => (index % 4) + 1 === num ? true : false);
      // {
      //   return this.articles.filter((el, i) => {
      //     return (i%4 === num : true ? false)});
      // }}
    },
  },

  created() {
    this.groupid = this.$route.params.id;
    this.getGroupInfo(this.$route.params.id);

  },

  methods: {
    stopFunc(e){
      e.preventDefault();
      e.stopPropagation();
      return false
    },
    onclickVideoChat() {
      const domain_url = import.meta.env.VITE_DOMAIN_URL;
      window.open(`${domain_url}/group/${this.$route.params.id}/videochat`, '_blank');
      // this.$router.push({name:'VideoChat',target:'_blank'})
    },
    closeAddedModal() {
      this.canvasmodal = false;
    },
    closeaddarticle() {
      this.addarticlemodal = false;
    },
    openmodal() {
      this.articlemodal = true;
    },
    closearticle() {
      this.articlemodal = false;
    },
    openaddnotice(){
      this.addnoticemodal = true;
    },
    closeaddnotice(){
      this.addnoticemodal = false
    },
    async getGroupInfo(id) {
      try {
        const { data } = await getGroupInfo(id);
        this.groupinfo = data;
      } catch (e) {
        console.error(e.message);
      }
      
      if(this.groupinfo.hobbyMemberId === null){
      const articleclick = document.querySelectorAll('#tabcard')
      for (let idx in articleclick){
        let el = articleclick[idx]
        if(el.addEventListener) {
          el.addEventListener('click', this.stopFunc, true)
        }
      }
    }
    },
    // only for test
    initArticles() {
      const data = {
        title: '제목',
        content: '사람이 살고있다',
        author: '사람',
      };
      for (let i = 0; i < 10; i++) {
        this.articles.push(data);
      }
    },
    loadData() {
      this.initArticles();
    },
    openregimodal() {
      if (this.groupinfo.freeRegistration === "FREE") {
        this.freemodal = true
        this.freeRegister()
      }
      else {
        this.unfreemodal = true
      }
    },
    closefreemodal() {
      this.freemodal = false
    },
    closeunfreemodal() {
      this.unfreemodal = false
    },
    async freeRegister() {
      try {
        const inputdata = {
          message : ''
        }
        const { data } = await requestGroupJoin(this.groupid, inputdata)
        console.log(data)
      }
      catch (e) {
        console.error(e);
      }
      
    }
  },
};
</script>

<style scoped>
h3 {
  font-size: 48px;
  background: linear-gradient(to bottom, #642efe, #fa8eb6);
  color: transparent;
  -webkit-background-clip: text;
}

#group {
  color: white;
  display: flex;
  flex-direction: row;
}

#groupinfo {
  width: 180px;
}

#groupinfo img {
  width: 180px;
  height: 250px;
  border: 2px solid #fa8eb6;
}

#groupinfo #title {
  font-size: 24px;
  text-align: start;
  margin: 17px 0;
}

#groupinfo #content {
  font-size: 20px;
  font-family: linefont;
  word-break: keep-all;
  margin-bottom: 40px;
}

button {
  margin: 15px 0;
}

#board {
  flex-grow: 1;
  margin-left: 20px;
}

#board button {
  font-size: 24px;
}

.vc-weekday {
  color: #642efe;
}

#canvasdialog button {
  background: linear-gradient(to bottom, #642efe, #0e0f28);
  width: 120px;
  height: 120px;
  border-radius: 150px;
}

.v-tab--selected .v-tab__slider {
    background-color: #ffffff00;
  }

.v-ripple__container {
  background-color: #ffffff00;
}

#registerbtn {
  background: linear-gradient(to bottom, #fa8eb6, #8e92fa80);
  width: 200px;
  height: 200px;
  border-radius: 150px;
  border : 1px solid white;
  color : white;
}
</style>
