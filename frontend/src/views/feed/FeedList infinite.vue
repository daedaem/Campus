<template>
  <div class="FeedListTotalframe d-flex">
    <!-- <infinite-scroll @infini></infinite-scroll> -->
    <div class="FeedListFrame">
      <div
        class="body d-flex flex-column justify-content-center align-items-center"
      >
        <div class="total-frame">
          <div>
            <!-- <infinite-scroll @infinite-scroll="feed"> -->
            <feed-list-items
              v-for="(feed, i) in feedLists"
              :key="i"
              :feed="feed"
            >
            </feed-list-items>
            <!-- </infinite-scroll> -->
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
// const SERVER_URL = `http://i6e102.p.ssafy.io`;
const SERVER_URL = `http://localhost:8080`;

import FeedListItems from "../../components/feed/FeedListItems.vue";
import { mapState } from "vuex";
import axios from "axios";
import { ref, onMounted } from "vue";
// import { ref } from "vue";
// import InfiniteScroll from "infinite-loading-vue3";

// import FeedDetail from "./FeedDetail.vue";
// import InfiniteLoading from "v3-infinite-loading";
// import "v3-infinite-loading/lib/style.css";

export default {
  name: "FeedList",
  components: {
    FeedListItems,
<<<<<<< HEAD:frontend/src/views/feed/FeedList infinite.vue
=======

    // FeedDetail
  },
  methods: {},
  created: function () {
    // console.log(this.$store.state.user);
    axios
      // .get("http://localhost:8080/sns")
      .get("http://i6e102.p.ssafy.io:8080/sns")
      .then((res) => {
        // console.log(res.data.list);
        const data = res.data.list;
        this.$store.dispatch("feedList", data);
      })

      .catch((err) => {
        console.log(err);
      });
>>>>>>> a1e6018649b8a8d57bf799c0f2d57ea9d2091069:frontend/src/views/feed/FeedList copy.vue
  },

  computed: {
    ...mapState(["feedList"]),
    ...mapState(["user"]),
  },
  setup() {
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
          console.log(res.data.list);
          feedLists.value.push(...res.data.ist);
          // this.$store.dispatch("feedList", data);
          console.log(feedLists.value);
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
@media (min-width: 768px) {
  .FeedListTotalframe {
    width: 100%;
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
</style>
