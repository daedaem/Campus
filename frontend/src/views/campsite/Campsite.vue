<template>
  <Navbar id="navbar"></Navbar>
  <body>
    <div>
      <div class="container mt-5 mb-5">
        <div class="d-flex justify-content-center row">
          <CampSearch/>
          <div class="col-md-10">
            <div
              class="row p-2 bg-white border rounded mt-2"
              v-for="(item, idx) in articles"
              :key="idx"
            >
              <!-- {{item}} -->
              <div class="col-md-3 mt-1">
                <img
                  v-if="item.firstImageUrl === null"
                  class="img-fluid img-responsive rounded product-image"
                  src="https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png"
                  style="height: 80%"
                />
                <img
                  v-else
                  class="img-fluid img-responsive rounded product-image"
                  :src="item.firstImageUrl"
                  style="height: 80%"
                />
              </div>
              <div class="col-md-6 mt-1">
                <h5 @click="goDetail(item.contentId)">{{ item.facltNm }}</h5>
                <div class="d-flex flex-row">
                  <div class="ratings mr-2">
                    <i class="fa fa-star"></i><i class="fa fa-star"></i
                    ><i class="fa fa-star"></i><i class="fa fa-star"></i>
                  </div>
                </div>
                <div class="mt-1 mb-1 spec-1">{{ item.addr1 }}</div>
                <div class="mt-1 mb-1 spec-1">{{ item.lineIntro }}</div>
                <!-- <p class="text-justify text-truncate para mb-0">There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable.<br><br></p> -->
              </div>
              <div
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
              </div>
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
import CampSearch from "@/components/campsite/campSearch.vue"
const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {
  name: "Campsite",
  components: {
    Navbar,
    CampSearch,
  },
  setup() {
    const store = useStore();
    const router = useRouter();
    const articles = ref([]);
    const limit = ref(10);
    const offset = ref(0);
    const lst = ref(0);
    const mylst = ref([])
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
          console.log("뭔데", res);
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
        method: 'post',
        url: `${SERVER_URL}/camp/like/${userNm}/${boardid}`
      })
        .then((res) => {
          console.log(res);
        })
    };
    
    const cancelHeart = (boardid) => {
      const userNm = store.state.myNum;
      axios({
        method: 'delete',
        url: `${SERVER_URL}/camp/like/${userNm}/${boardid}`
      })
        .then((res) => {
          console.log(res)
        })
    };

    const camplikeuser = () => {
      const userNm = store.state.myNum;
      const mycamping = [];
      axios({
        method: 'get',
        url: `${SERVER_URL}/camp/like/${userNm}`
      })
        .then((res) => {
          lst.value = res.data.campLikeList
          // console.log("크크", lst.value.length)
          for (let i=0; i<lst.value.length; i++) {
            mycamping.push(lst.value[i].contentId)
          }
          // console.log('본다', lst.value)
          mylst.value = mycamping
          console.log("확인하자", res)
          console.log("캠핑", mycamping)
        })
        .catch((err) => {
          console.log("여긴오나",err)
          console.log(userNm)
        })
    }

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
/* 수정해야함 */
/* @media (max-width: 420px) {
  .navbar {
    display: none;
  }
} */
@media(max-width: 768px){
  body {
    width:100%;
    margin: 0 auto;
    padding: 0 20px;
    background: #fafafa;
  
}}
@media (min-width: 768px) {
  body {
    width: 768px;
    margin: 0 auto;
    padding: 0 20px;
    background: #fafafa;
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
  color: #938787;
  font-size: 15px;
}

h5 {
  font-weight: 400;
}

.para {
  font-size: 16px;
}
</style>
