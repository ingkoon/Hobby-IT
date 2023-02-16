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
                <div @click="goprofile(row.nickName)">{{ row.nickName }}</div>
              </td>
              <td>
                <div style="display:flex; justify-content: center;vertical-align: middle;">
                  <!-- <v-select
                  v-model="select"
                  :items="priItem"
                  density="compact"
                  item-title="state"
                  item-value="abbr"
                  ></v-select> -->
                  <div v-if="row.privilege === 'OWNER'" style="margin: auto 0;"> 소유자
                  </div> 
                  <div v-else-if="row.privilege === 'GENERAL'" style="margin: auto 0;"> 회원 </div> 
                  <div v-else style="margin: auto 0;"> 매니저 </div>
                  <v-btn v-if="privi === 'OWNER' && row.privilege !== 'OWNER'" @click="openprimodal(row.id, row.privilege)" style="margin-left:10px; background-color: #00000000; color:grey">변경</v-btn>
                </div>
              </td>
              <td> {{ row.reg_dt }} </td>
              <td>
                
                <v-btn v-if="privi !== 'GENERAL' && row.privilege !== 'OWNER'" @click="openbanmem(`${row.id}`, `${row.nickName}`)" style="background-color: #FF052370; width: 40px; height: 40px; display: flex; justify-content: center; align-items: center; margin:0 auto">
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

    <v-dialog v-model="privmodal">
      <modi-mem @close="closeprimodal" :data="[groupid, rowid, privilige]"/>
    </v-dialog>
  </div>
</template>

<script>
import { getGroupMemberList } from '@/api/hobby';
import benMember from '@/components/modals/BanMem.vue'
import ModiMem from '@/components/modals/ModiMember.vue'

export default {
  components :{
    benMember,
    ModiMem
  },  
  props : {
    propdata : Object
  },
  data() {
    return {
      groupid : this.propdata[0],
      privi : this.propdata[1],
      privilige : '',
      list: [],
      tmplist: [
        
      ],
      banmemName: '',
      banmemId : '',
      banmodal : false,
      priItem : [
        {state : '소유자', abbr:'OWNER'},
        {state : '매니저', abbr:'MANAGER'},
        {state : '회원', abbr:'GENERAL'},
      ],
      select : {state : '소유자', abbr:'OWNER'},
      privmodal : false,
      rowid : '',
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
      
    },
    openbanmem(id, name) {
      this.banmemName = name
      this.banmemId = id
      this.banmodal = true
    },
    closebanmem() {
      this.banmodal = false
      this.getlist(this.groupid)
    },
    goprofile(nickName){
      this.$router.push({ name: 'MyPage', params: {nickname : nickName } });
    },
    openprimodal(id, pri){
      this.rowid = id
      this.privilige = pri
      this.privmodal = true
    },
    closeprimodal() {
      this.privmodal = false
      this.getlist(this.groupid)
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