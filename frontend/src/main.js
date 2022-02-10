import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.js";
import BootstrapVue3 from "bootstrap-vue-3";
import "bootstrap/dist/css/bootstrap.css";
import "bootstrap-vue-3/dist/bootstrap-vue-3.css";
import "vue-universal-modal/dist/index.css";
import VueUniversalModal from "vue-universal-modal";
import { library } from "@fortawesome/fontawesome-svg-core";
import { faPhone } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/vue-fontawesome";
import { faImages as fasImages } from "@fortawesome/free-solid-svg-icons";
import "bootstrap-icons/font/bootstrap-icons.css";
import { faUser } from "@fortawesome/free-solid-svg-icons";
import InfiniteLoading from "v3-infinite-loading";
import "v3-infinite-loading/lib/style.css";
import VueSweetalert2 from 'vue-sweetalert2';
import 'sweetalert2/dist/sweetalert2.min.css';


// import {Tabs, Tab} from 'vue3-tabs-component';

library.add(faPhone, fasImages, faUser);

createApp(App)
  .use(store)
  .use(router)
  .use(BootstrapVue3)
  .use(VueUniversalModal, { teleportTarget: "#modals" })
  // .component('tabs', Tabs)
  // .component('tab', Tab)
  .use(VueSweetalert2)

  .component(
    "font-awesome-icon",
    FontAwesomeIcon,
    "infinite-loading",
    InfiniteLoading
  )
  .mount("#app");
