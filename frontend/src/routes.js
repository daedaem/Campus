import Login from "./views/user/Login.vue";
import Join from "./views/user/Join.vue";
import Feed from "./views/feed/FeedList.vue";
import FeedMain from "./views/feed/IndexFeed.vue";
import Components from "./views/Components.vue";
import Mateparty from "./views/mateparty/Mateparty.vue";

export default [
  {
    path: "/",
    name: "Login",
    component: Login,
  },
  {
    path: "/user/join",
    name: "Join",
    component: Join,
  },
  {
    path: "/feed",
    name: "Feed",
    component: Feed,
  },
  {
    path: "/feed/main",
    name: "FeedMain",
    component: FeedMain,
  },
  {
    path: "/components",
    name: "Components",
    component: Components,
  },
  {
    path: "/mateparty",
    name: "Mateparty",
    component: Mateparty,
  },
];
