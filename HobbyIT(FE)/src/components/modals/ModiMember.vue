<template>
  <v-card id="groupbanmem">
    <v-icon icon="mdi-close" style="align-self: end" @click="close"></v-icon>
    <v-icon icon="mdi-account-convert" style="align-self: center"></v-icon>
    <div style="font-size: 36px">선택한 회원의 모임 내 권한을 변경합니다</div>
    <!-- <div style="font-size: 14px; font-family: linefont">강퇴한 회원은 다시 불러올 수 없습니다.</div> -->
    <!-- <div style="font-size: 20px; font-family: linefont">
      "<span style="font-family: linefontbold">{{ memberName[0] }}</span>"님을 강퇴하시겠습니까
    </div> -->

    <div style="display:flex;">
      <div v-if="state" @click="change" id='managerno' style="border:2px solid #6DF562; border-radius: 20px; padding:10px; margin : 10px; width:250px; display: unset;">
        <div>매니저</div>
        <div style="word-break: keep-all;">
          공지사항 작성, 가입신청 관리 및 게시글 관리가 가능합니다.
        </div>
      </div>
      <div v-else id='managerselect' @click="change" style="border:2px solid #6DF562; border-radius: 20px; background-color: #6DF562; padding:10px; margin : 10px; width:250px; display:flex; justify-content: center;align-items: center; flex-direction: column;">
        <v-icon icon="mdi-badge-account"></v-icon>
        <div>매니저</div>
      </div>
      <!-- <v-icon icon="mdi-"></v-icon> -->
      <div v-if="!state" id='generalno' @click="change" style="border:2px solid #FA8EB6; border-radius: 20px; padding:10px; margin : 10px; width:250px; display: unset;">
        <div>일반 회원</div>
        <div style="word-break: keep-all;">
          모임 관리 기능을 제외한 일반적인 활동이 가능합니다.
        </div>
      </div>
      <div v-else id='generalselect' @click="change" style="border:2px solid #FA8EB6; border-radius: 20px; background-color: #FA8EB6; padding:10px; margin : 10px; width:250px; display:flex; justify-content: center;align-items: center; flex-direction: column;">
        <v-icon icon="mdi-badge-account-outline"></v-icon>
        <div>일반 회원</div>
      </div>
    </div>
    <div style="display: flex">
      <span id="okbtn" @click="updateMem" style="color: white; margin-right: 20px"> 확인 </span>
      <span id="cancelbtn" style="color: white" @click="close"> 취소 </span>
    </div>
  </v-card>
</template>

<script>
import { updateGroupMemberPrivilege } from '@/api/hobby';

export default {
  data(){
    return {
      state : false
    }
  },
  props:{
    data : Object
  },
  methods: {
    close() {
      this.$emit('close');
    },
    async updateMem(){
      try {
        let input = 'GENERAL'
        if (!this.state) {
          input = 'MANAGER'
        }

        const inputdata = {
          privilege : input
        }
        const { data } = await updateGroupMemberPrivilege(this.data[0], this.data[1], inputdata)
        console.log(data)
        this.close()
      }
      catch(e) {
        console.log(e)
      }
    },
    change(){
      this.state = !this.state
    }
  },
  created(){
    console.log(this.data)
    if(this.data[2] === 'MANAGER'){
      this.state == false
    }
    else {
      this.state = true
    }
  }
}
</script>

<style>
#groupbanmem {
  width: 670px;
  height: 330px;
  display: flex;
  align-self: center;
  text-align: center;
  /*justify-content:center; */
  background-color: #0e0f28;
  color: white;
  font-family: linefontbold;
  border: 1px solid #24b1d0;
  border-radius: 20px;
  padding: 5px 20px;
  justify-content: space-evenly;
  align-items: center;
}

#okbtn {
  background: linear-gradient(to bottom, #ff307b, #0e0f28);
  width: 60px;
  height: 60px;
  border-radius: 50%;
  display: flex;
  cursor: pointer;
  justify-content: center;
  align-items: center;
}
#cancelbtn {
  background: linear-gradient(to bottom, #642efe, #0e0f28);
  width: 60px;
  height: 60px;
  border-radius: 50%;
  display: flex;
  cursor: pointer;
  justify-content: center;
  align-items: center;
}

</style>
