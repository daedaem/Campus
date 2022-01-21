import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import Makeparty from '../views/mateparty/Makeparty.vue'
import Mateparty from '../views/mateparty/Mateparty.vue'
import Signup from '../views/user/SignUp.vue'
import Login from '../views/user/Login.vue'
import addSign from '../views/user/addSign.vue'
import FeedList from "../views/feed/FeedList.vue"
import FeedCreate from "../views/feed/FeedCreate.vue";

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/about",
    name: "About",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/About.vue"),
  },
  {
    path: "/mateparty",
    name: "Mateparty",
    component: Mateparty,
    // component: () => import('../views/mateparty/Mateparty.vue')
  },
  {
    path: "/makeparty",
    name: "Makeparty",
    component: Makeparty,
    // component: () => import('../views/mateparty/Makeparty.vue')
  },
  {
    path: "/feed",
    name: "FeedList",
    component: FeedList,
  },
  {
    path: "/feed/create",
    name: "FeedCreate",
    component: FeedCreate,
  },
  {
    path: "/login",
    name: "Login",
    component: Login,
  },
  {
    path: "/signup",
    name: "Signup",
    component: Signup,
  },
  {
    path: "/addsign",
    name: "addSign",
    component: addSign,
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
