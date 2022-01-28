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
            <feed-list-items v-for="(feed, i) in feeds" :key="i" :feed="feed">
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

export default {
  name: "FeedList",
  components: {
    // FeedListItemModal,
    FeedListItems,
  },
  // created: function () {
  //   this.$store.dispatch("LoadFeedListItems");
  // },
  computed: {
    ...mapState(["feeds"]),
  },
  // created: function() {
  //   console.log(this.feeds)
  // }
};
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
