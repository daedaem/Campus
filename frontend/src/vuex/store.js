import Vue from "vue";
import Vuex from "vuex";
import state from "./state";
import getters from "./getters";
import actions from "./actions";
import mutations from "./mutations";

Vue.use(Vuex);

// const state = {
//   //   isUser: false,
// };

export default new Vuex.Store({
  // state: {
  //   isUser: false,
  //   feeds: [],
  // },
  state,
  mutations,
  getters,
  actions,
});
