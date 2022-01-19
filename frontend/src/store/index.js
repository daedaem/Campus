import { createStore } from "vuex";

export default createStore({
  state: {
    isUser: false,
    feeds: [
      {
        id: 1,
        first_name: "Fred",
        last_name: "Flintstone",
        profile_image_url:
          "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png",
        imgurl: [
          "https://cdn.pixabay.com/photo/2019/06/28/03/07/camping-4303357_960_720.jpg",
          "https://cdn.pixabay.com/photo/2015/02/02/11/08/office-620817_960_720.jpg",
        ],
      },
      {
        id: 2,
        first_name: "Wilma",
        last_name: "Flintstone",
        profile_image_url:
          "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png",
        imgurl: [
          "https://cdn.pixabay.com/photo/2013/06/09/17/04/fire-123784_960_720.jpg",
          "https://cdn.pixabay.com/photo/2015/02/02/11/08/office-620817_960_720.jpg",
        ],
      },
      {
        id: 3,
        first_name: "Barney",
        last_name: "Rubble",
        profile_image_url:
          "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png",
        imgurl:
          "https://cdn.pixabay.com/photo/2016/11/25/23/15/moon-1859616_960_720.jpg",
      },
      {
        id: 4,
        first_name: "Betty",
        last_name: "Rubble",
        profile_image_url:
          "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png",
        imgurl:
          "https://cdn.pixabay.com/photo/2017/08/17/08/08/camp-2650359_960_720.jpg",
      },
      {
        id: 5,
        first_name: "Pebbles",
        last_name: "Flintstone",
        profile_image_url:
          "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png",
        imgurl: [
          "https://cdn.pixabay.com/photo/2015/02/02/11/08/office-620817_960_720.jpg",
          "https://cdn.pixabay.com/photo/2015/02/02/11/08/office-620817_960_720.jpg",
          "https://cdn.pixabay.com/photo/2015/02/02/11/08/office-620817_960_720.jpg",
        ],
      },
      {
        id: 6,
        first_name: "Bamm Bamm",
        last_name: "Rubble",
        profile_image_url:
          "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png",
        imgurl:
          "https://cdn.pixabay.com/photo/2015/02/02/11/08/office-620817_960_720.jpg",
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
          "https://cdn.pixabay.com/photo/2020/02/04/10/42/people-4817872__340.jpg",
        ],
      },
      {
        id: 9,
        first_name: "Pearl",
        last_name: "Slaghoople",
        profile_image_url:
          "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png",
        imgurl:
          "https://cdn.pixabay.com/photo/2016/11/21/15/14/camping-1845906__340.jpg",
      },
      {
        id: 10,
        first_name: "Sord",
        last_name: "Sordsese",
        profile_image_url: "https://i.stack.imgur.com/l60Hf.png",
        imgurl:
          "https://cdn.pixabay.com/photo/2018/12/19/22/38/aconcagua-3884935__340.jpg",
      },
    ],
  },
  mutations: {},
  actions: {},
  modules: {},
});
