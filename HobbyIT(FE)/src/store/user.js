import { defineStore } from 'pinia';
import { memberSignup } from '@/api/member';

export const useUserStore = defineStore('user', {
  id: 'user',
  state: () => ({
    userNickname: null,
    userEmail: null,
    accessToken: null,
    refreshToken: null,
    userHobbyList: [],
  }),
  actions: {
    updateUserNickname(nickname) {
      this.userNickname = nickname;
    },
    updateUserEmail(email) {
      this.userEmail = email;
    },
    updateAccessToken(token) {
      this.accessToken = token;
    },
    updateRefreshToken(token) {
      this.refreshgToken = token;
    },
    updateUserHobbyList(list) {
      this.userHobbyList = list;
    },
    afterSignup(data) {
      const { email, nickname } = data;
      this.updateUserEmail(email);
      this.updateUserNickname(nickname);
    },
  },
});
