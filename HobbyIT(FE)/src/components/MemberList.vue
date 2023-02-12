<template>
  <div class="listWrap">
    <table class="tbList">
      <colgroup>
        <col width="7%" />
        <col width="*" />
        <col width="25%" />
        <col width="20%" />
        <col width="20%" />
      </colgroup>
      <tr>
        <th>no</th>
        <th>닉네임</th>
        <th>역할</th>
        <th>가입일자</th>
        <th>강퇴</th>
      </tr>
      <tr v-for="(row, idx) in list" id="lst" :key="idx">
        <td colspan="5">
          <table>
            <colgroup>
              <col width="7%" />
              <col width="*" />
              <col width="25%" />
              <col width="20%" />
              <col width="20%" />
            </colgroup>
            <tr id="noticetitle">
              <td>{{ idx+1 }}</td>
              <td>
                <a>{{ row.nickName }}</a>
              </td>
              <td>
                <!-- <v-select
                v-model="select"
                :items="priItem"
                density="compact"
                item-title="state"
                item-value="abbr"
                ></v-select> -->
                <div v-if="row.privilege === 'OWNER'"> 소유자
                </div> 
                <div v-else-if="row.privilege === 'GENERAL'"> 회원 </div> 
                <div v-else> 매니저 </div>
              </td>
              <td> {{ row.reg_dt }} </td>
              <td>
                
                <v-btn @click="openbanmem(`${row.id}`, `${row.nickName}`)" style="background-color: #FF052370; width: 40px; height: 40px; display: flex; justify-content: center; align-items: center; margin:0 auto">
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

    <v-dialog v-model="banmodal">
      <ben-member :memberName="[banmemName,banmemId,groupid]" @close="closebanmem"/>
    </v-dialog>
  </div>
</template>

<script>
import { getGroupMemberList } from '@/api/hobby';
import benMember from '@/components/modals/BanMem.vue'

export default {
  components :{
    benMember
  },  
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
      banmemName: '',
      banmemId : '',
      banmodal : false,
      priItem : [
        {state : '소유자', abbr:'OWNER'},
        {state : '매니저', abbr:'MANAGER'},
        {state : '회원', abbr:'GENERAL'},
      ],
      select : {state : '소유자', abbr:'OWNER'},
    };
  },
  created() {
    this.getlist(this.groupid);
  },
  methods: {
    async getlist(id) {

      try {
        const { data } = await getGroupMemberList(id);
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
    openbanmem(id, name) {
      this.banmemName = name
      this.banmemId = id
      this.banmodal = true
    },
    closebanmem() {
      this.banmodal = false
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