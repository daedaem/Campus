<template>
  <div class="FeedListTotalframe d-flex">
    <div class="FeedListFrame">
      <router-link
        class="text-decoration-none fw-bold text-primary align-middle align-self-center"
        :to="{ name: 'FeedCreate' }"
      >
        <button type="button" class="btn btn-success m-3">
          <i class="bi bi-plus-square fs-3"></i>
        </button>
      </router-link>
      <div
        class="body d-flex flex-column justify-content-center align-items-center"
      >
        <div class="total-frame">
          <div>
            <feed-list-items
              v-for="(feed, i) in feedList"
              :key="i"
              :feed="feed"
            >
            </feed-list-items>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import FeedListItems from "../../components/feed/FeedListItems.vue";
import { mapState } from "vuex";
import axios from "axios";

export default {
  name: "FeedList",
  components: {
    // FeedListItemModal,
    FeedListItems,
  },
  created: function () {
    axios("http://localhost:8080/sns")
      .then((res) => {
        // console.log(res.data.list);
        const data = res.data.list;
        this.$store.dispatch("feedList", data);
      })

      .catch((err) => {
        console.log(err);
      });
  },
  // created: function () {
  //   this.$store.dispatch("LoadFeedListItems");
  // },
  computed: {
    ...mapState(["feedList"]),
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
//       url:`/feed/?page=${pageNum}`,
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
