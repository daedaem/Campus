import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import Makeparty from '../views/mateparty/Makeparty.vue'
import Mateparty from '../views/mateparty/Mateparty.vue'
import Feed from "@/views/feed/FeedList.vue"
const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path : '/mateparty',
    name : 'Mateparty',
    component : Mateparty,
    // component: () => import('../views/mateparty/Mateparty.vue')
  },
  {
    path : '/makeparty',
    name : 'Makeparty',
    component : Makeparty,
    // component: () => import('../views/mateparty/Makeparty.vue')
  },
  {
    path: "/feed",
    name: "Feed",
    component: Feed,
  },




]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
