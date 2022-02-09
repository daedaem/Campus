<template>
  <Navbar></Navbar>
  <div class="FeedListTotalframe">
    <!-- <infinite-scroll @infini></infinite-scroll> -->

    <div class="FeedListFrame">
      <div
        class="body d-flex flex-column justify-content-center align-items-center"
      >
        <div class="total-frame">
          <div>
            <!-- <infinite-scroll @infinite-scroll="feed"> -->
            <feed-list-items
              v-for="(feed, i) in feedList"
              :key="i"
              :feed="feed"
            >
            </feed-list-items>
            <!-- </infinite-scroll> -->
          </div>
        </div>
      </div>
    </div>
    <div>
      <a href="#" class="btn_gotop">
        <span class="glyphicon glyphicon-chevron-up"> </span>
      </a>
    </div>
  </div>
</template>

<script>
<<<<<<< HEAD
// const SERVER_URL = `http://i6e102.p.ssafy.io`;
const SERVER_URL = `http://localhost:8080`;
=======
const SERVER_URL = `http://i6e102.p.ssafy.io:8080`;
// const SERVER_URL = `http://localhost:8080`;
>>>>>>> a1e6018649b8a8d57bf799c0f2d57ea9d2091069

import FeedListItems from "../../components/feed/FeedListItems.vue";
import { mapState } from "vuex";
import axios from "axios";
// import { ref } from "vue";
// import InfiniteScroll from "infinite-loading-vue3";
import Navbar from "@/components/common/Navbar.vue";

// import FeedDetail from "./FeedDetail.vue";
// import InfiniteLoading from "v3-infinite-loading";
// import "v3-infinite-loading/lib/style.css";

export default {
  name: "FeedList",
  components: {
    // InfiniteScroll,
    // FeedListItemModal,
    FeedListItems,
    Navbar,
    //
    // FeedDetail
  },
  // methods: {},
  created: function () {
    // console.log(this.$store.state.user);
    // axios
    //   .get(`${SERVER_URL}/sns`)
    //   .then((res) => {
    //     // console.log(res.data.list);
    //     const data = res.data.list;
    //     this.$store.dispatch("feedList", data);
    //     console.log(res.data.list);
    //   })
    //   .catch((err) => {
    //     console.log(err);
    //   });
    console.log("created feed list");
    this.getFeedList();
  },

  computed: {
    ...mapState(["feedList"]),
    ...mapState(["user"]),
  },
  // created: function() {
  //   console.log(this.feeds)
  // }
  methods: {
    getFeedList: function() {
      axios
      .get(`${SERVER_URL}/sns`)
      .then((res) => {
        // console.log(res.data.list);
        const data = res.data.list;
        this.$store.dispatch("feedList", data);
        // console.log(res.data.list);
      })
      .catch((err) => {
        console.log(err);
      });
    },
  },
};
// let pagNum = 0
// 스크롤 높이에서 스크롤바의 탑의 차이가 내가 보는 창길이와 같을 때
// document.addEventListener("scroll", () => {
//   const { scrollHeight, scrollTop, clientHeight } = document.documentElement;
//   if (scrollHeight - Math.round(scrollTop) === clientHeight) {
//     axios({
//       method: 'get',
//       url:`/feed/?page=${pageNum}`,
//     })
//     }
//   }
// });
//
</script>

<style scoped>
/* @font-face {
  font-family: "myFont";
  src: url("../../assets/fonts/BM/BMDOHYEON_ttf.ttf");
} */
/* * { */
/* font-family: 본문용 서체 "-apple-system", "BlinkMacSystemFont", */
/* "Apple SD Gothic Neo", "Inter", "Spoqa Han Sans", "Segoe UI", Sans-Serif, */
/* "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol"; */
/* font-family: "myFont"; */
/* } */
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
.btn_gotop {
  display: none;
  position: fixed;
  bottom: 30px;
  right: 30px;
  z-index: 999;
  border: 1px solid #ccc;
  outline: none;
  background-color: white;
  color: #333;
  cursor: pointer;
  padding: 15px 20px;
  border-radius: 100%;
}
</style>
