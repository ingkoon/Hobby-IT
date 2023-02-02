import { defineStore } from "pinia";

export const useAppStore = defineStore("app", {
  id: "app",
  state: () => ({
    baseUnit: 200,
    accessToken: null,
    refreshToken: null,
  }),
});
