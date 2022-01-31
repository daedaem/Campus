import { createStore } from "vuex";
import axios from "axios";
import createPersistedState from 'vuex-persistedstate'

export default createStore({
  plugins: [
    createPersistedState(),
  ],
  state: {
    user: null,
    token: localStorage.getItem("jwt"),
    usernumber: "",
    equipLists: [],
    mateList: [],
    uploadimages: "",
    feeddetailnum: 0,
    isLogin: localStorage.getItem("jwt") ? true : false,
    nickname: null,
    feedList: [],
    myNum: "",
    myProfileimageurl: "",
  },
  mutations: {
    CREATE_EQUIP: function (state, equipItem) {
      state.equipLists.push(equipItem);
    },
    DELETE_EQUIP: function (state, equipItem) {
      const index = state.equipLists.indexOf(equipItem);
      state.equipLists.splice(index, 1);
    },
    TODETAIL: function (state, feeddetailnum) {
      state.feeddetailnum = feeddetailnum;
    },
  
    FEEDLIST: function (state, feedList) {
      state.feedList = feedList;
    },

    //mate
    VIEW_MATE(state, data) {
      state.mateList = data;
    },

    // 로그인
    LOGIN: function (state) {
      state.token = localStorage.getItem("jwt");
    },
    LOGOUT: function (state) {
      state.token = null;
    },

  },
  actions: {
    createEquip: function ({ commit }, equipItem) {
      commit("CREATE_EQUIP", equipItem);
    },
    deleteEquip: function ({ commit }, equipItem) {
      commit("DELETE_EQUIP", equipItem);
    },
    // 로그인
    login: function ({ commit }) {
      commit("LOGIN");
    },
    logout: function ({ commit }) {
      commit("LOGOUT");
    },
    toDetail: function ({ commit }, feeddetailnum) {
      commit("TODETAIL", feeddetailnum);
     
    },
    feedList: function ({ commit }, feedList) {
      commit("FEEDLIST", feedList);
    },
    //mate
    viewMate({ commit }, data) {
      commit("VIEW_MATE", data);
    },
  },
  getters: {
    config: function (state) {
      return {
        Authorization: `JWT ${state.token}`,
      };
    },
  },
  
  modules: {

  },

  modules: {},
});
