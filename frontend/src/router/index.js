import { createRouter, createWebHistory } from "vue-router";
// import Home from "../views/Home.vue";
import Makeparty from "../views/mateparty/Makeparty.vue";
import Mateparty from "../views/mateparty/Mateparty.vue";
import Signup from "../views/user/SignUp.vue";
import Login from "../views/user/Login.vue";
import FeedList from "../views/feed/FeedList.vue";
import FeedDetail from "../views/feed/FeedDetail.vue";
import FeedCreate from "../views/feed/FeedCreate.vue";
import Partyinfo from "../views/mateparty/Partyinfo.vue";
import Matematch from "../views/matematch/Matematch.vue";
import Mainpage from "../Mainpage.vue";
import findPw from "../views/user/FindPassword.vue";
import Survey from "../views/user/Survey.vue";
import Profile from "../views/user/Profile.vue";
import Modify from "../views/user/ModifyUser.vue";
import Campsite from "../views/campsite/Campsite.vue";
import Campsitedetail from "../views/campsite/Campsitedetail.vue";
import Materevise from "../views/mateparty/Materevise.vue";
import test from "../components/common/test.vue";

import FeedModify from "../views/feed/FeedModify.vue";
import FeedSearchResults from "../views/feed/FeedSearchResults.vue";
const routes = [
  {
    path: "/",
    name: "Mainpage",
    component: Mainpage,
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
    path: "/mateparty/makeparty",
    name: "Makeparty",
    component: Makeparty,
  },
  {
    path: "/sns",
    name: "FeedList",
    component: FeedList,
  },
  {
    // path: "/sns/:snsNo",
    path: "/sns/:snsNo",
    name: "FeedDetail",
    component: FeedDetail,
  },
  {
    path: "/sns/:snsNo/update",
    name: "FeedModify",
    component: FeedModify,
  },
  {
    path: "/create",
    name: "FeedCreate",
    component: FeedCreate,
  },
  // {
  //   path: "/feed/create/detail",
  //   // path: "/feed/create/:feed_id",
  //   name: "FeedCreateDetail",
  //   component: FeedCreateDetail,
  // },
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
    path: "/findPw",
    name: "findPw",
    component: findPw,
  },
  {
    path: "/mateparty/:mateNo",
    name: "Partyinfo",
    component: Partyinfo,
    props: true,
  },
  {
    path: "/matematch/:userNo",
    name: "Matematch",
    component: Matematch,
  },
  {
    path: "/survey/",
    name: "Survey",
    component: Survey,
  },
  {
    path: "/profile/:userEmail",
    name: "Profile",
    component: Profile,
  },
  {
    path: "/modifyuser",
    name: "Modify",
    component: Modify,
  },
  {
    path: "/campsite/",
    name: "Campsite",
    component: Campsite,
  },
  {
    path: "/campsite/:contentId",
    name: "Campsitedetail",
    component: Campsitedetail,
  },
  {
    path: "/mateparty/rev/:mateNo",
    name: "Materevise",
    component: Materevise,
  },
  {
    path: "/searchresults/",
    name: "FeedSearchResults",
    component: FeedSearchResults,
  },
  {
    path: "/test/",
    name: "test",
    component: test,
  },

];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
