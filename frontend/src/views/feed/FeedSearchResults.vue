<template>
  <div>
    <Navbar></Navbar>
    <div class="FeedSearchResults-TotalFrame">
      <div class="upBox">
        <div class="searchKeyword d-flex align-items-center">
          <div>
            <img
              :src="`${searchResult[0].imageList[0].snsImageUrl}`"
              class="FeedSearchWordImage my-3"
              alt=""
            />
          </div>
          <div>
            <div class="card-body">
              <div class="searchResultText ms-3 fs-1">{{ searchWord }}</div>
            </div>
          </div>
        </div>
      </div>
      <div class="bottomBox mt-5">
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
const SERVER_URL = process.env.VUE_APP_SERVER_URL;

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
@media (min-width: 360px) {
  .FeedSearchWordImage {
    width: 100px;
    height: 100px;
    border-radius: 50%;
    object-fit: cover;
    margin-left: 2rem;
  }
  .upBox {
    /* height: 400px; */
    /* width: 80%; */
    margin: auto;

    margin-top: 5%;
  }
}
@media (min-width: 768px) {
  .FeedSearchResults-TotalFrame {
    max-width: 768px;
    margin: auto;
  }
  .searchResultText {
    text-align: start;
    margin: 0 0 0 0;
  }
  .feed-search-results-items-group {
  }
  .FeedSearchWordImage {
    width: 170px;
    height: 170px;
    margin-left: 2rem;
    border-radius: 50%;
    object-fit: cover;
  }
}
.searchKeyword {
  /* background: #fff; */
  /* border-radius: 10px; */
  /* border: 1px solid #ccc; */
}
.upBox {
  /* height: 400px; */
  /* width: 80%; */
  margin: auto;
  margin-top: 5%;
}

.bottomBox {
  /* padding: 3rem; */
}
.FeedSearchResultItems-ImageBox {
  /* border: 1px solid #fff; */
  border-radius: 10%;
  width: 100;
}
</style>
