<template>
  <v-btn @click="opengroupregi"
    >신청가입
    <v-dialog v-model="groupregimodal">
      <group-register @close="closegroupregi" />
    </v-dialog>
  </v-btn>

  <v-btn @click="openfreegroupregi"
    >자유가입
    <v-dialog v-model="freegroupregimodal">
      <group-free-regi @close="closefreegroupregi" />
    </v-dialog>
  </v-btn>

  <v-btn @click="openbanmem"
    >회원강퇴
    <v-dialog v-model="banmem">
      <ban-mem @close="closebanmem" />
    </v-dialog>
  </v-btn>

  <v-btn @click="openresign"
    >서비스 탈퇴
    <v-dialog v-model="resign">
      <resign @close="closeresign" />
    </v-dialog>
  </v-btn>

  <v-btn @click="opennotice"
    >공지사항 작성
    <v-dialog v-model="notice">
      <add-notice @close="closenotice" />
    </v-dialog>
  </v-btn>

  <v-btn @click="opendelgroup"
    >모임 삭제
    <v-dialog v-model="delgroup">
      <del-group @close="closedelgroup" />
    </v-dialog>
  </v-btn>

  <v-btn @click="opengroupresign"
    >모임 탈퇴
    <v-dialog v-model="groupresign">
      <group-resign @close="closegroupresign" />
    </v-dialog>
  </v-btn>

  <v-btn @click="openmakegroup"
    >모임 생성 완료
    <v-dialog v-model="makegroup">
      <make-group @close="closemakegroup" />
    </v-dialog>
  </v-btn>

  <v-btn @click="openexp"
    >경험치
    <v-dialog v-model="exp">
      <exp @close="closeexp" />
    </v-dialog>
  </v-btn>
</template>

<script>
import GroupRegister from '@/components/modals/GroupRegister.vue';
import GroupFreeRegi from '@/components/modals/GroupFreeRegi.vue';
import BanMem from '@/components/modals/BanMem.vue';
import Resign from '@/components/modals/Resign.vue';
import AddNotice from '@/components/modals/AddNotice.vue';
import DelGroup from '@/components/modals/DelGroup.vue';
import GroupResign from '@/components/modals/GroupResign.vue';
import MakeGroup from '@/components/modals/MakeGroup.vue';
import exp from '@/components/modals/EXP.vue';

export default {
  components: { GroupRegister, GroupFreeRegi, BanMem, Resign, AddNotice, DelGroup, GroupResign, MakeGroup, exp },
  data() {
    return {
      groupregimodal: false,
      freegroupregimodal: false,
      banmem: false,
      resign: false,
      notice: false,
      delgroup: false,
      groupresign: false,
      makegroup: false,
      exp: false,
    };
  },
  methods: {
    closegroupregi() {
      this.groupregimodal = false;
    },
    opengroupregi() {
      this.groupregimodal = true;
    },

    closefreegroupregi() {
      this.freegroupregimodal = false;
    },
    openfreegroupregi() {
      this.freegroupregimodal = true;
    },

    closebanmem() {
      this.banmem = false;
    },
    openbanmem() {
      this.banmem = true;
    },

    closeresign() {
      this.resign = false;
    },
    openresign() {
      this.resign = true;
    },

    closenotice() {
      this.notice = false;
    },
    opennotice() {
      this.notice = true;
    },

    closegroupresign() {
      this.groupresign = false;
    },
    opengroupresign() {
      this.groupresign = true;
    },

    closedelgroup() {
      this.delgroup = false;
    },
    opendelgroup() {
      this.delgroup = true;
    },

    closemakegroup() {
      this.makegroup = false;
    },
    openmakegroup() {
      this.makegroup = true;
    },

    closeexp() {
      this.exp = false;
    },
    openexp() {
      this.exp = true;
    },
  },
};
</script>

<style></style>
