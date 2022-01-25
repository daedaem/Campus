import { createStore } from "vuex";

export default createStore({
  state: {
    equipLists: [],
    isUser: false,
    uploadimages: "",
    feeds: [
      {
        id: 1,
        first_name: "Fred",
        last_name: "Flintstone",
        profile_image_url:
          "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png",
        imgurl: [
          "https://cdn.pixabay.com/photo/2019/06/28/03/07/camping-4303357_960_720.jpg",
          "https://cdn.pixabay.com/photo/2016/11/07/00/47/sea-1804591__340.jpg",
        ],
        likecount: 4,
      },
      {
        id: 2,
        first_name: "Wilma",
        last_name: "Flintstone",
        profile_image_url:
          "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png",
        imgurl: [
          "https://cdn.pixabay.com/photo/2013/06/09/17/04/fire-123784_960_720.jpg",
          "https://cdn.pixabay.com/photo/2021/01/04/10/45/tent-5887144__340.jpg",
        ],
        likecount: 5,
      },
      {
        id: 3,
        first_name: "Barney",
        last_name: "Rubble",
        profile_image_url:
          "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png",
        imgurl: [
          "https://cdn.pixabay.com/photo/2016/11/25/23/15/moon-1859616_960_720.jpg",
        ],
        likecount: 6,
      },
      {
        id: 4,
        first_name: "Betty",
        last_name: "Rubble",
        profile_image_url:
          "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png",
        imgurl: [
          "https://cdn.pixabay.com/photo/2017/08/17/08/08/camp-2650359_960_720.jpg",
        ],
        likecount: 50,
      },
      {
        id: 5,
        first_name: "Pebbles",
        last_name: "Flintstone",
        profile_image_url:
          "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png",
        imgurl: [
          "https://cdn.pixabay.com/photo/2019/08/06/09/34/fire-4387886__340.jpg",
          "https://cdn.pixabay.com/photo/2015/02/02/11/08/office-620817_960_720.jpg",
          "https://cdn.pixabay.com/photo/2015/02/02/11/08/office-620817_960_720.jpg",
        ],
        likecount: 49,
      },
      {
        id: 6,
        first_name: "Bamm Bamm",
        last_name: "Rubble",
        profile_image_url:
          "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png",
        imgurl: [
          "https://cdn.pixabay.com/photo/2015/02/02/11/08/office-620817_960_720.jpg",
        ],
        likecount: 100,
      },
      {
        id: 7,
        first_name: "The Great",
        last_name: "Gazzoo",
        profile_image_url:
          "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png",
        imgurl: [
          "https://cdn.pixabay.com/photo/2015/02/02/11/08/office-620817_960_720.jpg",
          "https://cdn.pixabay.com/photo/2015/02/02/11/08/office-620817_960_720.jpg",
          "https://cdn.pixabay.com/photo/2015/02/02/11/08/office-620817_960_720.jpg",
        ],
        likecount: 432,
      },
      {
        id: 8,
        first_name: "Rockhead",
        last_name: "Slate",
        profile_image_url:
          "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png",
        imgurl: [
          "https://cdn.pixabay.com/photo/2019/10/03/11/14/camp-4522970__340.jpg",
          "https://cdn.pixabay.com/photo/2020/01/15/12/56/kyrgyzstan-4767876__340.jpg",
          "https://cdn.pixabay.com/photo/2016/11/29/04/17/bonfire-1867275__340.jpg",
        ],
        likecount: 256,
      },
      {
        id: 9,
        first_name: "Pearl",
        last_name: "Slaghoople",
        profile_image_url:
          "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png",
        imgurl: [
          "https://cdn.pixabay.com/photo/2016/11/21/15/14/camping-1845906__340.jpg",
        ],
        likecount: 123456,
      },
      {
        id: 10,
        first_name: "Sord",
        last_name: "Sordsese",
        profile_image_url: "https://i.stack.imgur.com/l60Hf.png",
        imgurl: [
          "https://cdn.pixabay.com/photo/2018/12/19/22/38/aconcagua-3884935__340.jpg",
        ],
        likecount: 19203,
      },
    ],
  },
  mutations: {
    CREATE_EQUIP: function (state, equipItem) {
      state.equipLists.push(equipItem);
    },
    DELETE_EQUIP: function (state, equipItem) {
      const index = state.equipLists.indexOf(equipItem);
      state.equipLists.splice(index, 1);
    },
  },
  actions: {
    createEquip: function ({ commit }, equipItem) {
      commit("CREATE_EQUIP", equipItem);
    },
    deleteEquip: function ({ commit }, equipItem) {
      commit("DELETE_EQUIP", equipItem);
    },
  },
  modules: {},
});
