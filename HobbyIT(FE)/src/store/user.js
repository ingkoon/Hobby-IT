import { defineStore } from 'pinia';

export const useUserStore = defineStore({
  id: 'user',
  state: () => ({
    userNickname: null,
    userEmail: null,
    accessToken: null,
    userHobbyList: [],
  }),
  getters: {
    getRefreshToken(state) {
      return localStorage.getItem('refreshToken');
    },
    getAccessToken(state) {
      return state.accessToken;
    },
    getUserNickname(state) {
      return state.userNickname;
    },
  },
  actions: {
    setUserNickname(nickname) {
      this.userNickname = nickname;
    },
    setUserEmail(email) {
      this.userEmail = email;
    },
    setAccessToken(token) {
      this.accessToken = token;
    },
    setRefreshToken(token) {
      localStorage.setItem('refreshToken', token);
      return;
    },
    setUserHobbyList(list) {
      this.userHobbyList = list;
    },
    clearUserInfo(){
      this.setUserNickname(null)
      this.setUserEmail(null)
      this.setAccessToken(null)
      localStorage.removeItem('refreshToken')
    },
    afterSignup(data) {
      const { email, nickname } = data;
      this.setUserEmail(email);
      this.setUserNickname(nickname);
    },
    async setUser(data) {
      const { nickname, accessToken, refreshToken } = data;
      this.setAccessToken(accessToken);
      this.setRefreshToken(refreshToken);
      this.setUserNickname(nickname);
      // const hobbyList = await getParticipatingGroup(nickname);
    },
  },
});
