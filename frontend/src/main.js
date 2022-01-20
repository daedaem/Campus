import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.js";
import BootstrapVue3 from "bootstrap-vue-3";
import "bootstrap/dist/css/bootstrap.css";
import "bootstrap-icons/font/bootstrap-icons.css";
import "bootstrap-vue-3/dist/bootstrap-vue-3.css";
import "vue-universal-modal/dist/index.css";
import VueUniversalModal from "vue-universal-modal";

createApp(App).use(store).use(router).use(BootstrapVue3).use(VueUniversalModal, { teleportTarget: "#modals" }).mount("#app");
