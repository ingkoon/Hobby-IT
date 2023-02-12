<template>
  <div class="listWrap">
    <table class="tbList">
      <colgroup>
        <col width="7%" />
        <col width="20%" />
        <col width="*" />
        <col width="20%" />
        <col width="20%" />
      </colgroup>
      <tr>
        <th>no</th>
        <th>닉네임</th>
        <th>인삿말</th>
        <th>신청일자</th>
        <th>수락/거절</th>
      </tr>
      <tr v-for="(row, idx) in list" id="lst" :key="idx">
        <td colspan="5">
          <table>
            <colgroup>
              <col width="7%" />
              <col width="20%" />
              <col width="*" />
              <col width="20%" />
              <col width="20%" />
            </colgroup>
            <tr id="noticetitle">
              <td>{{ row.id }}</td>
              <td>
                <a>{{ row.nickName }}</a>
              </td>
              <td>
                <div v-if="row.privilege === 'OWNER'"> 소유자 </div> 
                <div v-else-if="row.privilege === 'GENERAL'"> 회원 </div> 
                <div v-else> 매니저 </div>
              </td>
              <td> 가입일자 </td>
              <td>
                <v-btn style="background-color: #5278FF90; border : 1px solid #FA8EB6; width: 40px; height: 40px; display: flex; justify-content: center; align-items: center; margin:0 auto">
                  <v-icon icon="mdi-exit-to-app" color="white"></v-icon>
                </v-btn>
                <v-btn style="background-color: #FF052370; border : 1px solid #FA8EB6; width: 40px; height: 40px; display: flex; justify-content: center; align-items: center; margin:0 auto">
                  <v-icon icon="mdi-exit-to-app" color="white"></v-icon>
                </v-btn>
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
</template>

<script>
import { getGroupJoinRequests } from '@/api/hobby';

export default {
  props : {
    groupid : Number,
  },
  data() {
    return {
      list: [],
      tmplist: [
        
      ],
      no: '',
      paging: '', //페이징 데이터
      page: this.$route.query.page ? this.$route.query.page : 1,
      keyword: this.$route.query.keyword,
      
    };
  },
  created() {
    this.getlist(this.groupid);
  },
  methods: {
    async getlist(id) {

      try {
        const { data } = await getGroupJoinRequests(id);
        this.tmplist = data
      }
      catch (e) {
        console.log(e)
      }
      this.list = this.tmplist
      const paging = {
        totalCount: this.tmplist.length,
        total_page: Math.ceil(this.tmplist.length / 10),
        page: this.page,
        start_page: Math.ceil(this.page / 10),
        end_page: Math.ceil(this.page / 10) * 10,
        ipp: 10,
      };
      
    },
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

<style>
  .v-tab--selected .v-tab__slider {
    background-color: #ffffff00;
  }
</style>
