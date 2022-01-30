import { createStore } from "vuex";
import axios from "axios";
import createPersistedState from "vuex-persistedstate";

export default createStore({
  plugins: [createPersistedState()],

  state: {
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
    LOGIN: function (state) {
      state.isLogin = true;
      const token = localStorage.getItem("jwt");
      axios({
        method: "get",
        url: `${process.env.VUE_APP_MCS_URL}/accounts/profile/`,
        headers: { Authorization: `JWT ${token}` },
      }).then((res) => {
        this.commit("SET_PROFILE", res.data);
      });
    },
    LOGOUT: function (state) {
      state.nickname = null;
      state.isLogin = false;
      localStorage.removeItem("jwt");
    },
    SET_PROFILE: function (state, res) {
      state.myProfile.myNum = res.myNum;
    },
  },
  actions: {
    createEquip: function ({ commit }, equipItem) {
      commit("CREATE_EQUIP", equipItem);
    },
    deleteEquip: function ({ commit }, equipItem) {
      commit("DELETE_EQUIP", equipItem);
    },
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

  modules: {},
});
