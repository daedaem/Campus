<template>
  <div>
    <div class="nav">내브바 들어갈 자리</div>

    <div class="total-frame">
      <feed-list-items>
        <!-- {{ feed.id }} -->
      </feed-list-items>
      <!-- {{ feeds }} -->
      <!-- <feed-list-items></feed-list-items> -->
      <!-- :key="item.title" -->
      <!-- :eachOfListItems="item" -->
    </div>
  </div>
</template>

<script>
import FeedListItems from "../../components/feed/FeedListItems.vue";
// import { mapState } from "vuex";

export default {
  name: "feedlist",
  components: { FeedListItems },

  // created: function () {
  //   this.$store.dispatch("LoadFeedListItems");
  // },
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
  padding: 20px 20px 20px 20px;
  margin: 20px 30px;
  border-bottom: 1px solid #eee;
}
.total-frame {
  width: 768px;
  /* width: 80vw; */
  margin: 0 auto;
  padding: 0 20px;
  background-color: antiquewhite;
}
.feed {
  /* padding: 30px; */
  margin: 20px;
  width: vm;
  border-bottom: 1px solid #eee;

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
