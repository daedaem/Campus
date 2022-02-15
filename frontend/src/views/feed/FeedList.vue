<template>
  <Navbar></Navbar>
  <div class="FeedListBackground" v-if="this.$store.state.isLogin != false">
    <div
      class="FeedListTotalframe d-flex"
      v-if="this.$store.state.isLogin"
    >
      <div class="FeedListFrame">
        <div
          class="body d-flex flex-column justify-content-center align-items-center"
        >
          <div class="total-frame col-12">
            <div
              v-if="this.$store.state.isLogin"
              class="FeedCreateFrame"
            >
              <div class="d-flex justify-content-center align-items-center">
                <div v-if="this.$store.state.userProfileImage == null">
                  <img
                    class="FeedList-ProfileImage"
                    src="https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png"
                    alt=""
                  />
                </div>
                <div v-else>
                  <img
                    class="FeedList-ProfileImage"
                    :src="`${this.$store.state.userProfileImage}`"
                    alt=""
                  />
                </div>
                <div class="FeedListuserNickname d-flex align-items-center">
                  <div class="FeedListuserNotification">
                    {{ this.$store.state.userList.userNickname }} 님, 당신의
                    캠핑을 공유해주세요.
                  </div>
                </div>
                <a class="nav-link mt-2" aria-current="page" href="/sns/create">
                  <!-- <i class="bi bi-journal-richtext"></i> -->

                  <i class="bi bi-plus-square fs-3"></i>
                </a>
              </div>
              <hr style="width: 90%; margin: auto" />
              <div style="height: 20%"><br /></div>
            </div>
          </div>
        </div>
        <div>
          <feed-list-items
            v-for="(feed, i) in feedLists"
            :key="i"
            :feed="feed"
            class="feedListItems"
          >
          </feed-list-items>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
const SERVER_URL = process.env.VUE_APP_SERVER_URL;

import FeedListItems from "../../components/feed/FeedListItems.vue";
import Navbar from "@/components/common/Navbar.vue";

import { mapState } from "vuex";
import axios from "axios";
import { ref, onMounted } from "vue";
// import { useRouter } from "vue-router";

// import { ref } from "vue";

// import FeedDetail from "./FeedDetail.vue";

export default {
  name: "FeedList",
  components: {
    FeedListItems,
    Navbar,

    // FeedDetail
  },
  methods: {},
  created: function () {
    if (this.$store.state.userEmail == null) {
      alert("로그인이 필요한 서비스입니다.");
      this.$router.push({ name: "Login" });
    }
    // console.log(this.$store.state.user);
    axios
      .get(`${SERVER_URL}/sns`)
      // .get("http://i6e102.p.ssafy.io:8080/sns")
      .then((res) => {
        console.log("나옵니까", res);
        // console.log(res.data.list);
        const data = res.data.list;
        this.$store.dispatch("feedList", data);
      })

      .catch((err) => {
        console.log(err);
      });
  },

  computed: {
    ...mapState(["feedList"]),
    ...mapState(["userList"]),
    ...mapState(["myProfileimageurl"]),
  },
  setup() {
    // const router = useRouter();
    const feedLists = ref([]);
    const limit = ref(10);
    const offset = ref(0);

    const getDatas = () => {
      axios({
        methods: "get",
        url: `${SERVER_URL}/sns`,
        params: {
          limit: limit.value,
          offset: offset.value,
          // searchWord : '',
          // doNm : '',
        },
      })
        .then((res) => {
          console.log("뭔데", res);
          feedLists.value.push(...res.data.list);
          // console.log(feedLists.value);
          // this.$store.dispatch("feedList", data);
          // console.log("넣습니다", feedLists);
        })
        .then((res) => {
          // console.log("되나요?", res.data.list);
          feedLists.value.push(...res.data.list);
          // this.$store.dispatch("feedList", data);
          // console.log("넣습니다", this.feedLists);
        })
        .catch((err) => {
          console.log(err);
        });
    };
    onMounted(() => {
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
      feedLists,
      limit,
      offset,
      getDatas,
    };
  },
  // created: function() {
  //   console.log(this.feeds)
  // }
};
// let pagNum = 0
// 스크롤 높이에서 스크롤바의 탑의 차이가 내가 보는 창길이와 같을 때
// document.addEventListener("scroll", () => {
//   const { scrollHeight, scrollTop, clientHeight } = document.documentElement;
//   if (scrollHeight - Math.round(scrollTop) === clientHeight) {
//     axios({
//       method: 'get',
//     })
//     }
//   }
// });
</script>

<style scoped>
.feedListItems {
  border-radius: 30px;
}
@media(max-width:758px){
  .FeedCreateFrame {
  width: 100%;
  background: #fff;
  /* border-radius: 20px; */
  border-top: 1px solid #dbdbdb;
  border-bottom: 1px solid #dbdbdb;
  min-height: 70px;
  margin-top: 20px;
  margin-bottom: 20px;
}
}
@media (min-width: 768px) {
  .FeedCreateFrame {
  width: 100%;
  background: #fff;
  border-radius: 20px;
  border: 1px solid #dbdbdb;
  min-height: 70px;
  margin-top: 20px;
  margin-bottom: 20px;
}
  .FeedListBackground {
    /* width:768px; */
    /* margin:auto; */
    /* background: #fafafa; */
  }
  .FeedListTotalframe {
    padding-top: 3%;
    width: 60%;
    margin: auto;
  }

  .FeedListFrame {
    width: 768px;
    margin: auto;
  }

  .btn {
    border-radius: 30%;
  }

  /* .feed {
    width: 80vw;
    max-width: 480px;
    position: center;
  } */
  /* p {
    font-size: 16px;
  } */
  .nav {
    height: 20px;
    /* height: auto; */
    width: 100%;
  }

  .total-frame {
    /* max-width: calc(100vw - 500px); */
    /* width: 80vw; */
    margin: 0 auto;
    /* padding: 0 20px; */
    /* background-color: antiquewhite; */
  }
  .feed {
    /* padding: 30px; */
    margin: 20px;
    /* border-bottom: 1px solid #eee; */

    /* transition: 0.2s; */
    /* &:hover {
      background-color: #f4f4f4;
    } */
    /* .content {
      .url {
        color: #ccc;
      }
    } */
  }
}

.FeedList-ProfileImage {
  width: 40px;
  height: 40px;
  border-radius: 50%;
  margin: 0.5rem;
}
.FeedListuserNickname {
  margin-left: 2px;
  width: 80%;
  background: #f2f2f2;
  border-radius: 15px;
  min-height: 40px;
}
.FeedListuserNotification {
  font-size: 13px;
  color: #7c7e7f;
  padding-left: 12px;
}
.nav-link {
  color: #7c7e7f;
}
</style>
