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
            <tr id="noticetitle">
              <td>{{ no - idx }}</td>
              <td class="txt_left">
                <a href="javascript:;" @click="godetail(`${row.id}`)">{{ row.title }}</a>
              </td>
              <td>{{ row.created_at.substring(0, 10) }}</td>
              <td>{{ row.user_nickname }}</td>
            </tr>
            <tr :name="`${row.id}`" style="display: none">
              <td id="noticedetail" colspan="4" style="text-align: left; padding: 20px">
                <div style="font-size: 24px; margin-bottom: 20px; display: flex; justify-content: space-between">
                  새해 복 많이 받으세요
                  <div>
                    <v-icon icon="mdi-eye" size="small"></v-icon> 558
                    <v-icon icon="mdi-close" size="small" @click="godetail(`${row.id}`)"></v-icon>
                  </div>
                </div>
                <div style="font-family: linefont">까치까치 설날은 어저께고요 우리우리 설날은 오늘이래요~</div>
                <div style="text-align: right">
                  <v-icon icon="mdi-pencil" size="small"></v-icon>
                  <v-icon icon="mdi-delete" size="small" @click="godetail(`${row.id}`)"></v-icon>
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

  <div v-if="paging.totalCount > 0" class="pagination">
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
export default {
  data() {
    return {
      list: [],
      tmplist: [
        {
          id: 1,
          title: 'Hair each base dark guess garden accept.',
          content:
            'Religious ball another laugh light million. Federal public power another.\nDuring always recent maintain major others bank. Say place address. Wife tough outside system must. Develop road especially.',
          user_nickname: 2,
          created_at: '1995-01-20T07:27:13Z',
          updated_at: '1990-04-21T01:07:51Z',
        },
        {
          id: 2,
          title: 'Sit sign share you.',
          content:
            'Call authority choose discuss yes. Experience century Mrs population company couple million.\nCareer challenge response many throw. Because practice what a allow its consumer.',
          user_nickname: 3,
          created_at: '2013-05-29T15:46:17Z',
          updated_at: '2001-12-09T17:38:01Z',
        },
        {
          id: 3,
          title: 'Hair each base dark guess garden accept.',
          content:
            'Religious ball another laugh light million. Federal public power another.\nDuring always recent maintain major others bank. Say place address. Wife tough outside system must. Develop road especially.',
          user_nickname: 2,
          created_at: '1995-01-20T07:27:13Z',
          updated_at: '1990-04-21T01:07:51Z',
        },
        {
          id: 4,
          title: 'Sit sign share you.',
          content:
            'Call authority choose discuss yes. Experience century Mrs population company couple million.\nCareer challenge response many throw. Because practice what a allow its consumer.',
          user_nickname: 3,
          created_at: '2013-05-29T15:46:17Z',
          updated_at: '2001-12-09T17:38:01Z',
        },
        {
          id: 5,
          title: 'Hair each base dark guess garden accept.',
          content:
            'Religious ball another laugh light million. Federal public power another.\nDuring always recent maintain major others bank. Say place address. Wife tough outside system must. Develop road especially.',
          user_nickname: 2,
          created_at: '1995-01-20T07:27:13Z',
          updated_at: '1990-04-21T01:07:51Z',
        },
      ],
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
    };
  },
  created() {
    this.getlist();
  },
  methods: {
    getlist() {
      this.list = this.tmplist.reverse().slice((this.page - 1) * 10, this.page * 10);
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
    },
    godetail(id) {
      let clickitem = document.getElementsByName(id);
      console.log(clickitem[0].getAttribute('style'));
      if (clickitem[0].getAttribute('style') == 'display: none;') {
        clickitem[0].setAttribute('style', '');
      } else {
        clickitem[0].setAttribute('style', 'display: none;');
      }
    },
  },
};
</script>

<style>
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
  color: #a3e1f4;
}
</style>
