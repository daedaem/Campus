<template>
  <Navbar id="navbar"></Navbar>
  <div class="CampSitebackground">
    <div class="CampeSitebackground-imgcover">
      <div class="CampeSitebackground-content ps-5">캠핑장</div>
      <div></div>
    </div>
  </div>
  <body>
    <div>
      <div></div>
      <div class="container mt-5 mb-5">
        <div class="d-flex justify-content-center row">
          <div class="capmsiteContent d-flex flex-row mx-2 align-items-start">
            <!-- <campsite-drop></campsite-drop> -->
            <div class="CampSite-FilterBox">
              <campsite-filter class="my-3 mx-2"></campsite-filter>
            </div>
            <div style="max-width: 768px">
              <div
                class="row p-2 bg-white mb-3"
                style="
                  min-height: 200px;
                  border-radius: 15px;
                  border: 1px solid #dbdbdb;
                "
                v-for="(item, idx) in articles"
                :key="idx"
              >
                <!-- {{item}} -->
                <div class="CampSiteImageFrame my-2" style="width: 210px">
                  <img
                    class="img-fluid img-responsive rounded product-image"
                    style="height: 100%"
                    :src="item.firstImageUrl"
                  />
                </div>
                <div class="d-flex flex-column col-md-5">
                  <div class="mt-3">
                    <h5 @click="goDetail(item.contentId)">
                      {{ item.facltNm }}
                    </h5>
                    <div class="d-flex flex-row mb-3">
                      <div class="ratings mr-2">
                        <i class="fa fa-star"></i><i class="fa fa-star"></i
                        ><i class="fa fa-star"></i><i class="fa fa-star"></i>
                      </div>
                    </div>
                  </div>
                  <div class="mt-3">
                    <div class="mb-1 spec-1">{{ item.addr1 }}</div>
                    <div class="mt-1 mb-1 spec-1">{{ item.lineIntro }}</div>
                  </div>
                  <!-- <p class="text-justify text-truncate para mb-0">There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable.<br><br></p> -->
                </div>
                <div
                  class="align-items-center align-content-center col-md-3 border-left mt-1"
                >
                  <div class="d-flex flex-row align-items-center">
                    <h5 class="mt-3">후기</h5>
                  </div>
                  <h6 class="text-success">찜?</h6>
                  <div class="d-flex flex-column pt-2 mt-4">
                    <button
                      class="btn btn-primary btn-sm"
                      type="button"
                      style="font-size: 12px"
                    >
                      <i class="bi bi-telephone-fill"></i> {{ item.tel }}
                    </button>
                    <button
                      class="btn btn-outline-primary btn-sm mt-2"
                      type="button"
                      v-if="item.resveUrl != null"
                    >
                      예약사이트
                    </button>
                    <button
                      class="btn btn-outline-primary btn-sm mt-2"
                      type="button"
                      v-else
                    >
                      전화예약문의
                    </button>
                  </div>
                </div>
                <!-- {{item}} -->
              </div>
              <!-- <div
                class="align-items-center align-content-center col-md-3 border-left mt-1"
              >
                <div class="d-flex flex-row align-items-center">
                  <h4 class="mr-1">후기</h4>
                </div>

                <span
                  v-if="mylst.includes(item.contentId) === false"
                  style="cursor: pointer"
                  class="heart-box"
                  @click="giveHeart(item.contentId)"
                >
                  <i class="bi bi-heart me-3"></i>
                </span>
                <span
                  v-else
                  style="cursor: pointer"
                  class="heart-box"
                  @click="cancelHeart(item.contentId)"
                >
                  <i class="bi bi-heart-fill me-3" style="color:red;"></i>
                </span>
                <div class="d-flex flex-column mt-4">
                  <button
                    class="btn btn-primary btn-sm"
                    type="button"
                    style="font-size: 12px"
                  >
                    <i class="bi bi-telephone-fill"></i> {{ item.tel }}
                  </button>
                  <button
                    class="btn btn-outline-primary btn-sm mt-2"
                    type="button"
                    v-if="item.resveUrl != null"
                  >
                    예약사이트
                  </button>
                  <button
                    class="btn btn-outline-primary btn-sm mt-2"
                    type="button"
                    v-else
                  >
                    전화예약문의
                  </button>
                </div>
              </div> -->
              <!-- {{item}} -->
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
</template>

<script>
import axios from "axios";
import { ref, onMounted } from "vue";
import { useRouter } from "vue-router";
import { useStore } from "vuex";
import Navbar from "@/components/common/Navbar.vue";
// import CampSearch from "@/components/campsite/campSearch.vue"
import CampsiteFilter from "@/components/campsite/CampsiteFilter.vue";
const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {
  name: "Campsite",
  components: {
    Navbar,
    // CampSearch,
    CampsiteFilter,
  },
  setup() {
    const store = useStore();
    const router = useRouter();
    const articles = ref([]);
    const limit = ref(10);
    const offset = ref(0);
    const lst = ref(0);
    const mylst = ref([]);
    // const mycamping = ref([]);
    // const goDetail = () => { router.push({name: 'Campsitedetail', params: {}})}
    const getDatas = () => {
      axios({
        methods: "get",
        url: `${SERVER_URL}/camp`,
        params: {
          limit: limit.value,
          offset: offset.value,
          // searchWord : '',
          // doNm : '',
        },
      })
        .then((res) => {
          // console.log("뭔데", res);
          articles.value.push(...res.data.list);

          // console.log(articles.value);
        })

        .catch((err) => {
          console.log(err);
        });
    };

    const goDetail = (id) => {
      router.push({ name: "Campsitedetail", params: { contentId: id } });
    };

    const giveHeart = (boardid) => {
      const userNm = store.state.myNum;
      axios({
        method: "post",
        url: `${SERVER_URL}/camp/like/${userNm}/${boardid}`,
      }).then((res) => {
        console.log(res);
      });
    };

    const cancelHeart = (boardid) => {
      const userNm = store.state.myNum;
      axios({
        method: "delete",
        url: `${SERVER_URL}/camp/like/${userNm}/${boardid}`,
      }).then((res) => {
        console.log(res);
      });
    };

    const camplikeuser = () => {
      const userNm = store.state.myNum;
      const mycamping = [];
      axios({
        method: "get",
        url: `${SERVER_URL}/camp/like/${userNm}`,
      })
        .then((res) => {
          lst.value = res.data.campLikeList;
          console.log("크크", lst.value.length);
          for (let i = 0; i < lst.value.length; i++) {
            mycamping.push(lst.value[i].contentId);
          }
          // console.log('본다', lst.value)
          mylst.value = mycamping;
          console.log("확인하자", res);
          console.log("캠핑", mycamping);
        })
        .catch((err) => {
          console.log("여긴오나", err);
          // console.log(userNm);
        });
    };

    onMounted(() => {
      camplikeuser();
      getDatas();
      window.addEventListener("scroll", () => {
        let scrollTop = document.documentElement.scrollTop;
        let scrollHeight = document.documentElement.scrollHeight;
        let clientHeight = document.documentElement.clientHeight;

        if (scrollTop + clientHeight >= scrollHeight - 10) {
          offset.value += 10;
          // this.limit += 10
          getDatas();
        }
      });
    });

    return {
      articles,
      limit,
      offset,
      getDatas,
      goDetail,
      giveHeart,
      cancelHeart,
      camplikeuser,
      lst,
      mylst,
    };
  },
};
</script>

<style scoped>
.navbar {
  /* width: 968px; */
  /* align-self: stretch; */
  padding-left: calc(100% - 90%);
  padding-right: calc(100vw - 90%);

  /* padding-left: calc(100% - 80%); */
  /* padding-right: calc(100vw - 10%); */
}
/* 수정해야함 */
/* @media (max-width: 420px) {
  .navbar {
    display: none;
  }
} */
.CampSitebackground {
  width: 100%;
  height: 200px;
  background: black;
  background-color: rgba(0, 0, 0, 0.4);

  /* background-position: 30%; */
  /* background-repeat: no-repeat; */
  background: url("https://cdn.discordapp.com/attachments/932494858533359646/942331192177492048/pexels-juan-pablo-guzman-fernandez-2166822.jpg")
    50% 50% no-repeat;
  /* background: 50% 70% no-repeat; */
  background-size: 100% auto;
}
.CampeSitebackground-imgcover {
  position: absolute;
  width: 100%;
  height: 200px;
  background-color: rgba(0, 0, 0, 0.4);
  z-index: 1;
}
.CampeSitebackground-content {
  position: absolute;
  top: 30%;
  left: 20%;
  /* transform: translate(-50%, -50%); */
  font-size: 3rem;
  color: white;
  z-index: 2;
  text-align: center;
}
@media (max-width: 768px) {
  body {
    width: 100%;
    margin: 0 auto;
    padding: 0 20px;
    background: #fafafa;
  }
  .CampSiteImageFrame img {
    object-fit: cover;
  }
}
@media (min-width: 768px) {
  body {
    /* width: 900px; */
    margin: 0 auto;
    padding: 0 20px;
    background: #fafafa;
  }
  .container {
    width: 968px;
    margin: 0 auto;
    padding: 0 20px;
    background: #fafafa;
  }
  .capmsiteContent {
    width: 100%;
  }
  .CampSiteImageFrame img {
    object-fit: cover;
  }
}

.ratings i {
  font-size: 16px;
  color: red;
}

.strike-text {
  color: red;
  text-decoration: line-through;
}

.product-image {
  width: 100%;
}

.dot {
  height: 7px;
  width: 7px;
  margin-left: 6px;
  margin-right: 6px;
  margin-top: 3px;
  background-color: blue;
  border-radius: 50%;
  display: inline-block;
}

.spec-1 {
  color: black;
  font-size: 13px;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
  font-size: fw-bold;
  line-height: 12px;
}

h5 {
  font-weight: 400;
}

.para {
  font-size: 16px;
}
.CampSite-FilterBox {
  width: 200px;
  /* height: 900px; */
  padding-left: 2px;
  padding-right: 2px;
  margin-right: 3rem;
  background: #fff;
  /* display: flex; */
  border-radius: 15px;
  border: 1px solid #dbdbdb;
}
.campsite-filter {
  /* width: 300px; */
  /* height: 200px; */
  /* background: #fff; */
}
</style>
