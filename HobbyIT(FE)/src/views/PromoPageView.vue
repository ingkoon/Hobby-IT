<template>
  <div id="bg">
    <div id="back-oval">
    </div>
    <div id="front-oval">
      <div
        style="font-size: 64px; font-weight: 700; margin-top: 170px; background: linear-gradient(180deg, #FFFFFF 0%, #642EFE 100%);
        color: transparent;
        -webkit-background-clip: text;">
        What's New?
      </div>
      <div
        style="font-size: 32px; font-weight: 700; margin-top: 30px; background: linear-gradient(180deg, #FFFFFF 0%, #642EFE 100%);
        color: transparent;
        -webkit-background-clip: text;">
        내 모임을 홍보하거나<br>다양한 모임들을 여기서 확인하세요
      </div>
    </div>
    <div>
      <img id="stars" src="assets/Fstar.svg" style="z-index:-1; margin-top: -800px;"/>
    </div>
    <div style="width:1200px; background: rgba(136, 29, 69, 0.5); border-radius: 30px; margin-top: -600px; padding: 50px 0px 50px 0px;">
      <div style="display: flex;">
        <div style="margin: 10px 0px 0px 150px; color: white; font-size: 12px;">
          <v-icon icon="mdi-help-circle-outline"></v-icon>
          모집 : 신규회원을 모집하는 글 / 교류 : 모임+모임(collab) 활동을 찾는 글
        </div>
        <v-btn
          prepend-icon="mdi-bullhorn-variant-outline"
          style="
          border-radius: 50px;
          background-color: #0E0F28;
          border: 2px solid #FA8EB6;
          color: #FA8EB6;
          margin: 0px 0px 20px 400px;"
          @click="checkleader"
          >홍보글 작성
          <v-dialog v-model="addpromo">
            <add-promo :masterlist="masterlist" @closeaddpromo="closeaddpromo" @doneaddpromo="createPromo" />
          </v-dialog>
          <v-dialog v-model="notleader">
            <not-leader @closenotleader="closenotleader" />
          </v-dialog>
        </v-btn>
      </div>

      <!--게시판-->
      <div style="display: flex; flex-direction: column; align-items: center;">
        <table style="width: 928px; height: 48px; background-color: #0E0F28; color: white; z-index: 2; border-bottom: 2px solid #FA8EB6">
          <colgroup>
            <col width="15%" />
            <col width="5%" />
            <col width="50%" />
            <col width="10%" />
            <col width="20%" />
          </colgroup>
          <tr style="font-size: 18px; color:#9DA0FF">
            <th>no</th>
            <th>종류</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
          </tr>
        </table>
        <v-expansion-panels v-model="isPanelExpanded" variant="popout" style="width: 80%;">
          <v-expansion-panel
            v-for="(row, idx) in promolist" id="lst" :key="idx"
            style="background-color: #0E0F28; color: white; padding: 0px;"
          ><v-expansion-panel-title
            expand-icon=none
            collapse-icon="mdi-close"
            style="display: flex;
            align-items: center;
            text-align: center;"
            @click="getarticleinfo(row.id, row.header, row.title, row.content, row.hobbyName)"
          >
            <div style="width:15%; margin-left:-20px; font-weight: 400;">{{ row.id }}</div>
            <div style="width:5%;  margin-left:5px; font-weight: 400;">{{ row.header === 'MEETUP' ? '교류' : '모집' }}</div>
            <div style="width:50%; margin-left:15px;">{{ row.title }}</div>
            <div style="width:10%; margin-left:10px;">{{ row.nickname }}</div>
            <div style="width:20%; margin-right:-120px;">{{ row.regDt.substring(0, 10) }}</div>
          </v-expansion-panel-title>
          <v-expansion-panel-text :style="row.header === 'MEETUP' ? 'background-color: #8A2B6A;' : 'background-color: #2E186B;' ">
            <!-- <div style="text-align: right; margin-left: -150px;  margin-right: 20px;">
              <v-icon icon = "mdi-eye" size="18" style="color: white;"></v-icon>&nbsp;&nbsp;&nbsp;{{row.hit}}
            </div> -->
            <div style="font-size: 24px; margin-top: 10px;">
              from : <span style="color: #EE49FD; font-size: 30px;">{{ row.hobbyName }}</span>
            </div>
            <v-divider></v-divider>
            <br />{{ row.content }}

            <div style="text-align:right;">
              <!--본인글만 수정/삭제가능-->
              <div v-show = "row.nickname === nickname">
                <!--수정버튼-->
                <v-btn variant="flat" icon="mdi-pencil-outline" style="background-color: rgba(0, 0, 0, 0); color: white;">
                  <v-icon icon="mdi-pencil-outline" color="white"></v-icon>
                  <v-dialog v-model="modipromo" activator="parent">
                    <modi-promo :articleinfo="articleinfo" @closemodipromo="closemodipromo" @donemodipromo="updatePromo"/>
                  </v-dialog>
                </v-btn>

                <!--삭제버튼-->
                <v-btn variant="flat" icon="mdi-delete-outline" style="background-color: rgba(0, 0, 0, 0); color: white;">
                  <v-icon icon="mdi-delete-outline" color="white"></v-icon>
                  <v-dialog v-model="delpromo" activator="parent">
                    <del-promo @closedelpromo="closedelpromo"  @deletepromo="deletePromo(`${row.id}`)" />
                  </v-dialog>
                </v-btn>
              </div>

            </div>
          </v-expansion-panel-text>
          </v-expansion-panel>
        </v-expansion-panels>
      </div>

      <!--페이징-->
      <!-- <div v-if="paging.totalCount > 0" class="pagination">
        <a class="first" href="javascript:;" @click="fnPage(1)">&lt;&lt;</a>
        <a
          v-if="paging.start_page > 10"
          class="prev"
          href="javascript:;"
          @click="fnPage(`${paging.start_page - 1}`)"
          >&lt;</a
        >
        <template v-for="(n, index) in paginavigation()">
          <template v-if="paging.page == n">
            <strong :key="index">{{ n }}</strong>
          </template>
          <template v-else>
            <a :key="index" href="javascript:;" @click="fnPage(`${n}`)">{{ n }}</a>
          </template>
        </template>
        <a
          v-if="paging.total_page > paging.end_page"
          class="next"
          href="javascript:;"
          @click="fnPage(`${paging.end_page + 1}`)"
          >&gt;</a
        >
        <a class="last" href="javascript:;" @click="fnPage(`${paging.total_page}`)"
          >&gt;&gt;</a
        >
      </div> -->

    </div>
  </div>
</template>

<script>
import AddPromo from "../components/modals/AddPromo.vue";
import ModiPromo from "../components/modals/ModiPromo.vue";
import DelPromo from "../components/modals/DelPromo.vue";
import NotLeader from "../components/modals/NotLeader.vue";
import { useUserStore } from "@/store/user";

//axios작업
import { getPromotionArticlePage, createPromotionArticle, updatePromotionArticle, deletePromotionArticle, getMasterList} from '@/api/article';

export default {
  components:{
    AddPromo,
    ModiPromo,
    DelPromo,
    NotLeader,
  },
  setup(){
    const userStore = useUserStore();
    return {userStore};
  },
  data() {
    return {
      isPanelExpanded: null,
      pgno: 0,
      list: [],
      addpromo: false,
      delpromo: false,
      modipromo: false,
      notleader: false,
      // no: "",
      // paging: "", //페이징 데이터
      // start_page: "", //시작페이지
      // page: this.$route.query.page ? this.$route.query.page : 1,
      // keyword: this.$route.query.keyword,
      // paginavigation: function () {
      //   //페이징 처리 for문 커스텀
      //   var pageNumber = [];
      //   var start_page = this.paging.start_page;
      //   var end_page = this.paging.end_page;
      //   for (var i = start_page; i <= end_page; i++) pageNumber.push(i);
      //   return pageNumber;
      // },
      promolist:[],
      masterlist: [],
      articleinfo: [],
      saveinfo:[],
      nickname: '',
    };
  },
  mounted() {
    this.getPromoList(this.pgno);
    this.getMasterList();
    this.nickname = this.userStore.getUserNickname;
  },
  methods: {
    opennotleader(){
      this.notleader = true;
    },
    closenotleader(){
      this.notleader = false;
    },
    checkleader(){
      if (this.masterlist.length == 0) {
        this.opennotleader();
        console.log('방장아님'+this.notleader);
      } else {
        this.openaddpromo();
        console.log('글쓰기가능'+this.addpromo);
        console.log('목록'+this.masterlist);
      }
    },
    openaddpromo() {
      this.addpromo = true;
    },
    closeaddpromo() {
      this.addpromo = false;
    },
    opendelpromo() {
      this.delpromo = true;
    },
    closedelpromo() {
      this.delpromo = false;
    },
    openmodipromo() {
      this.modipromo = true;
    },
    closemodipromo() {
      this.modipromo = false;
    },
    afterpost(){
      this.getPromoList(this.pgno);
      console.log('변경완료!')
    },
    getarticleinfo(arid, arheader, artitle, arcontent, arhobbyname){
      this.articleinfo = [arid, arheader, artitle, arcontent, arhobbyname];
      console.log('이거봐라-------'+this.isPanelExpanded);
    },
    // savearticleinfo(){
    //   this.saveinfo = this.articleinfo;
    // },
    getlist() {
      this.list = this.tmplist
        .reverse()
        .slice((this.page - 1) * 10, this.page * 10);
      const paging = {
        totalCount: this.tmplist.length,
        total_page: Math.ceil(this.tmplist.length / 10),
        page: this.page,
        start_page: Math.ceil(this.page / 10),
        end_page: Math.ceil(this.page / 10) * 10,
        ipp: 10,
      };
      if (paging.total_page < paging.end_page) {
        paging.end_page = paging.total_page;
      }
      this.paging = paging;
      this.no = paging.totalCount - (paging.page - 1) * this.paging.ipp;
    },
    fnPage(n) {
      //페이징 이동
      if (this.page != n) {
        this.page = n;
        this.getlist();
      }

      // getPromoList 호출 - backend 통신
    },

    //작업
    async getPromoList(page_no){
      try {
        // const { data } = await getPromotionArticlePage();
        const { data:{content} } = await getPromotionArticlePage(page_no);
        console.log(content);
        this.promolist = content
      } catch (e) {
        console.log("홍보게시판 리스트 불러오기 실패 : ",e.message)
      }
    },
    async getMasterList(){
      try {
        // const res =  await getMasterList();
        // console.log(res);
        const { data:{ownHobbyList} } = await getMasterList();
        this.masterlist = ownHobbyList;

        console.log('방장개수'+this.masterlist.length);
      } catch (e) {
        console.log("방장 리스트 불러오기 실패 : ",e.message)
      }
    },
    async createPromo(data, hobby_id){
      try {
        console.log('createpromo started');
        await createPromotionArticle(data, hobby_id);
        await this.afterpost();
      } catch (e) {
        console.log("홍보게시글 작성 실패 : ",e.message)
      }
    },
    async updatePromo(data, article_id){
      try {
        console.log('updatepromo started');
        await updatePromotionArticle(data, article_id);
        // console.log('here error');
        await this.afterpost();
        this.isPanelExpanded = null;
      } catch (e) {
        console.log("홍보게시글 수정 실패 : ",e.message)
      }
    },
    async deletePromo(article_id){
      try {
        await deletePromotionArticle(article_id);
        await this.afterpost();
      } catch (e) {
        console.log("홍보게시글 삭제 실패 : ",e.message)
      }
    },
  },
}
</script>

<style scoped>

#bg{
  /* font-family: 'LINESeedKR-Rg'; */
  display: flex;
  align-items: center;
  flex-direction: column;
  height: 3000px;
  font-weight: 100;
}
/* @font-face {
    font-family: 'LINESeedKR-Rg';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_11-01@1.0/LINESeedKR-Rg.woff2') format('woff2');
    font-weight: 400;
    font-style: normal;
} */

#front-oval{
  box-sizing: border-box;
  width: 2080px; height: 436px;
  border-radius: 0 0 50% 50% / 0 0 50% 50%;
  margin-top: -600px;
  background: linear-gradient(180deg, #000211 0%, #0E0F28 38.48%);
  border: 5px solid transparent;
  background-image: linear-gradient(#000211, #000211),
  radial-gradient(100% 100% at 50% 0%, rgba(217, 217, 217, 0) 90%, #EBB4FE 100%);
  background-origin: border-box;
  background-clip: content-box, border-box;
  display: flex; flex-direction: column; align-items: center; text-align: center;
  z-index: 1;
}

#back-oval{
  width: 3400px; height: 400px;
  background: radial-gradient(50% 50% at 50% 50%, #D534EF 0%, rgba(36, 39, 75, 0) 100%);
  filter: blur(100px);
}

/* 별 움직이는 동작 */
#stars{
  animation: rotate-image 100s linear infinite;
  transform-origin: 50% 50%;
}

@keyframes rotate-image {
  100%{
      transform: rotate(-360deg);
  }
}

</style>
