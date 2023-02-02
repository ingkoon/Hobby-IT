// Composables
import { createRouter, createWebHistory } from "vue-router";
import VideoChat from "@/views/VideoChat.vue";

const routes = [
  {
    path: "/",
    component: () => import("@/layouts/default/Default.vue"),
    children: [
      {
        path: "",
        name: "Home",
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () =>
          import(/* webpackChunkName: "home" */ "@/views/Home.vue"),
      },
      {
        path: "main/",
        name: "Main",
        component: () => import("@/views/MainView.vue"),
      },
      {
        path: "mypage/",
        name: "MyPage",
        component: () => import("@/views/MypageView.vue"),
      },
      {
        path: "group/",
        name: "Grouppage",
        component: () => import("@/views/GroupView.vue"),
        children: [
          {
            path: "",
            name: "GroupMainPage",
            component: () => import("@/views/GroupPageView.vue"),
          },
          {
            path: "videochat",
            component: () => import("@/views/VideoChat.vue"),
            name: "VideoChat",
          },
        ],
      },
    ],
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
