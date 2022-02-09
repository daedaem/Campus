<template>
  <div>
    <Navbar></Navbar>
    <div class="FeedSearchResults-TotalFrame">
      <div class="upBox mx-5 my-4">
        <div class="row g-0 d-flex justify-content-around align-items-center">
          <div class="col-md-4">
            <img
              :src="`${searchResult[0].imageList[0].snsImageUrl}`"
              class="FeedSearchWordImage ms-3 my-3"
              alt=""
            />
          </div>
          <div class="col-md-8">
            <div class="card-body">
              <div class="searchResultText fs-1">{{ searchWord }}</div>
            </div>
          </div>
        </div>
      </div>
      <div class="bottomBox">
        <div class="fs-5 p-3 text-start">인기 게시물</div>
        <!-- {{ searchResult[0].imageList[0].snsImageUrl }} -->
        <div class="FeedSearchResultItems-ImageBox">
          <b-card-group columns class="feed-search-results-items-group">
            <feed-search-results-items
              v-for="(feed, i) in searchResult"
              :key="i"
              :searchedFeed="feed"
              :searchWord="searchWord"
            ></feed-search-results-items>
          </b-card-group>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import FeedSearchResultsItems from "../../components/feed/FeedSearchResultsItems.vue";
import Navbar from "@/components/common/Navbar.vue";

import { mapState } from "vuex";
import { mapGetters } from "vuex";
import axios from "axios";
// const SERVER_URL = `http://i6e102.p.ssafy.io:8080`
const SERVER_URL = "http://localhost:8080";

export default {
  name: "news",
  components: { FeedSearchResultsItems, Navbar },
  data() {
    return {
      searchresults: null,
      searchedImageList: null,
    };
  },
  methods: {},
  created: function () {
    // this.$router.reload();

    // console.log("돼요?", this.$store.state.searchResult);
    // this.searchresults = this.$store.state.searchResult;
    axios
      .get(`${SERVER_URL}/sns`)
      .then((res) => {
        // console.log(res.data.list);
        // console.log(res);
        const data = res.data.list;
        this.$store.dispatch("feedList", data);
        // console.log(res.data.list);
      })
      .catch((err) => {
        console.log(err);
      });
  },
  computed: {
    ...mapState(["searchWord"]),
    // ...mapState(["feedList"]),

    ...mapGetters(["searchResult"]),
    // ...mapState(["searchResult"]),
  },
};
</script>

<style>
@media (min-width: 740px) {
  .searchResultText {
    text-align: start;
    margin: 0 0 0 0;
  }
  .feed-search-results-items-group {
  }
}
.upBox {
  /* height: 400px; */
  width: 80%;
}
.FeedSearchWordImage {
  width: 200px;
  height: 200px;
  border-radius: 50%;
  object-fit: cover;
}
.bottomBox {
  padding: 3rem;
}
.FeedSearchResultItems-ImageBox {
  border: 1px solid #fff;
  border-radius: 10%;
  width: 100;
}
</style>
