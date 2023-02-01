import { defineStore } from 'pinia'


export const useUserStore = defineStore('user', {
  id: 'user',
  state: () => ({
    userNickname: null,
    userEmail:null,
    accessToken : null,
    refreshToken : null,
  }),
})
