import { defineStore } from "pinia";

export const useMessageStore = defineStore("message", {
  id: "message",
  state: () => ({
    message: [],
  }),
});
