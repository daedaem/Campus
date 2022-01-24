<template>
  <div>
    <nav class="nav">안녕</nav>
    <div class="total-frame">
      <div>
        <feed-list-items v-for="(feed, i) in feeds" :key="i" :feed="feed">
          <!-- {{ feed.id }} -->
        </feed-list-items>
        <!-- <div></div> -->
        <!-- {{ feeds }} -->
        <!-- <feed-list-items></feed-list-items> -->
        <!-- :key="item.title" -->
        <!-- :eachOfListItems="item" -->
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

<style>
/* .feed {
  width: 80vw;
  max-width: 480px;
  position: center;
} */
/* p {
  font-size: 16px;
} */
.nav {
  height: 1vh;
  width: 100%;
}

.total-frame {
  max-width: calc(100vw - 500px);
  /* width: 80vw; */
  margin: 0 auto;
  padding: 0 20px;
  /* background-color: antiquewhite; */
}
.feed {
  /* padding: 30px; */
  margin: 20px;
  width: vm;
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
</style>
