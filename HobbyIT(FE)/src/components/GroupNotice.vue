<template>
  <div class="listWrap">
    <table class="tbList">
      <colgroup>
        <col width="7%" />
        <col width="*" />
        <col width="15%" />
        <col width="10%" />
      </colgroup>
      <tr>
        <th>no</th>
        <th>제목</th>
        <th>작성일</th>
        <th>작성자</th>
      </tr>
      <tr v-for="(row, idx) in list" id="lst" :key="idx">
        <td colspan="4">
          <table>
            <colgroup>
              <col width="7%" />
              <col width="*" />
              <col width="15%" />
              <col width="10%" />
            </colgroup>
            <tr id="noticetitle" @click="godetail(row.id)">
              <td>{{ no - idx }}</td>
              <td class="txt_left">
                <div href="javascript:;" >{{ row.title }}</div>
              </td>
              <td>{{ row.createdAt.substring(0, 10) }}</td>
              <td>{{ row.author }}</td>
            </tr>
            <tr :name="`${row.id}`" style="display: none">
              <td id="noticedetail" colspan="4" style="text-align: left; padding: 20px">
                <div style="font-size: 24px; margin-bottom: 20px; display: flex; justify-content: space-between">
                  <div>
                    {{ row.title }}
                  </div>
                  <div>
                    <!-- <span>
                      <v-icon icon="mdi-eye" size="small"></v-icon> 558
                    </span> -->
                    <v-icon icon="mdi-close" size="small" @click="godetail(`${row.id}`)"></v-icon>
                  </div>
                </div>
                <div style="font-family: linefont">{{ row.content }}</div>
                <div style="text-align: right">
                  <span>
                    <v-icon @click="openmodify" icon="mdi-pencil" size="small" style="margin-right:10px"></v-icon>
                    <v-dialog v-modal="modifymodal" activator="parent">
                      <modiModal @close="closemodify" :data="[groupid, row.id, row.title, row.content]"/>
                    </v-dialog>
                  </span>
                  <v-icon @click="deletearticle(row.id)" icon="mdi-delete" size="small" ></v-icon>
                </div>

              </td>
            </tr>
          </table>
        </td>
      </tr>

      <tr v-if="list.length == 0">
        <td colspan="4">데이터가 없습니다.</td>
      </tr>

    </table>
    
    
  </div>

  <div v-if="paging.totalCount > 0" class="pagination" style="text-align: center; margin-top:20px;">
    <a class="first" href="javascript:;" @click="fnPage(1)">&lt;&lt;</a>
    <a v-if="paging.start_page > 10" class="prev" href="javascript:;" @click="fnPage(`${paging.start_page - 1}`)"
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
    <a class="last" href="javascript:;" @click="fnPage(`${paging.total_page}`)">&gt;&gt;</a>
  </div>
</template>

<script>
import modiModal from '@/components/modals/ModiNotice.vue'

import { getGroupNoticeList, deleteGroupNotice } from '@/api/hobby'

export default {
  components : {
    modiModal,
  },
  props : {
    groupid : String,
  },
  data() {
    return {
      list: [],
      tmplist: [],
      no: '',
      paging: '', //페이징 데이터
      start_page: '', //시작페이지
      page: this.$route.query.page ? this.$route.query.page : 1,
      keyword: this.$route.query.keyword,
      paginavigation: function () {
        //페이징 처리 for문 커스텀
        var pageNumber = [];
        var start_page = this.paging.start_page;
        var end_page = this.paging.end_page;
        for (var i = start_page; i <= end_page; i++) pageNumber.push(i);
        return pageNumber;
      },
      modifymodal : false,
    };
  },
  mounted() {
    this.getlist();
  },
  methods: {
    openmodify(){
      this.modifymodal = true
    },
    closemodify() {
      this.modifymodal = false
      this.getlist()
    },
    async getlist() {
      console.log(this.groupid)
      try {
       const { data } = await getGroupNoticeList(this.groupid)
       this.tmplist = data.content

       const paging = {
         totalCount: data.totalElements,
         total_page: data.totalPages,
         page: this.page,
         start_page: Math.ceil(this.page / 10),
         end_page: Math.ceil(this.page / 10) * 10,
         ipp: 10,
       };

       this.list = this.tmplist.reverse();
       if (paging.total_page < paging.end_page) {
         paging.end_page = paging.total_page;
       }
       this.paging = paging;
       this.no = paging.totalCount - (paging.page - 1) * this.paging.ipp;

      }
      catch(e){
        console.log(e)
      }

    },
    fnPage(n) {
      //페이징 이동
      if (this.page != n) {
        this.page = n;
        this.getlist();
      }
    },
    godetail(id) {
      let clickitem = document.getElementsByName(id);
      if (clickitem[0].getAttribute('style') == 'display: none;') {
        clickitem[0].setAttribute('style', '');
      } else {
        clickitem[0].setAttribute('style', 'display: none;');
      }
    },

    async deletearticle(id) {
      console.log("delete : ", id)
      try {
        const { data } = await deleteGroupNotice(this.groupid, id)
        console.log(data)
        this.getlist()
      }
      catch(e) {
        console.log(e)
      }
    }
  },
};
</script>

<style scoped>
.tbList th {
  border-bottom: 3px solid #642efe;
  padding: 5px 0;
}

.tbList td {
  border-bottom: 1px solid #fa8eb6;
}

.tbList #noticedetail {
  border-bottom: 0;
  padding: 5px 0;
  background-color: #3e1b41;
}

.tbList #noticetitle {
  height: 50px;
}

.tbList td.txt_left {
  text-align: left;
}

table {
  width: 100%;
  border-collapse: collapse;
  color: white;
  text-align: center;
}

strong {
  color: #fa8eb6;
}

a {
  text-decoration: none;
  color : white;
}
</style>
