// Composables
import { createRouter, createWebHistory } from 'vue-router'
import VideoChat from "@/views/VideoChat.vue";

const routes = [
  {
    path: '/',
    component: () => import('@/layouts/default/HomeDefault.vue'),
    children: [
      {
        path: '',
        name: 'Home',
        component: () => import('@/views/Home.vue'),
      },
    ]
  },
  {
    path: '/main',
    component: () => import('@/layouts/default/Default.vue'),
    children: [
      {
        path: '',
        name: 'Main',
        component: () => import('@/views/MainView.vue'),
      },
    ]
  },
  {
    path: '/mypage',
    component: () => import('@/layouts/default/Default.vue'),
    children: [
      {
        path: '',
        name: 'MyPage',
        component: () => import('@/views/MypageView.vue'),
      },
    ]
  },
  {
    path: '/group',
    component: () => import('@/layouts/default/HomeDefault.vue'),
    children: [
      {
        path: '',
        name: 'Grouppage',
        component: () => import('@/views/GroupView.vue'),
        children:[
          {
            path: '',
            name: 'GroupMainPage',
            component: () => import('@/views/GroupPageView.vue')
          },
          {
            path: 'videochat',
            component: () => import('@/views/VideoChat.vue'),
            name: 'VideoChat'
          }
        ]
      },
    ]
  },
  {
    path:'/404',
    name: 'NotFound',
    component: () => import('@/views/NotFound.vue'),
  },
  {
    path: '/:pathMathch(.*)*',
    redirect: "/404"
    // notfound!
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
})

export default router
