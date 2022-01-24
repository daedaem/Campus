<template>
  <div>
    <!-- 피드 게시물 첨부 사진이 한 개일때 -->
    <div class="feed-picture-box d-flex" v-if="feed.imgurl.length == 1">
      <div class="feed-picture">
        <img :src="`${feed.imgurl}`" class="d-block w-100" alt="..." />
      </div>
    </div>
    <!-- 두개이상일 때 -->
    <div class="feed-picture-box" v-else-if="feed.imgurl.length == 2">
      <b-carousel
        id="carousel-1"
        v-model="slide"
        :interval="0"
        controls
        indicators
        background="#ababab"
        img-width="1024"
        img-height="480"
        style="text-shadow: 1px 1px 2px #333"
        @sliding-start="onSlideStart"
        @sliding-end="onSlideEnd"
      >
        <b-carousel-slide
          :img-src="`${feed.imgurl[0]}`"
          class="d-block w-100"
        ></b-carousel-slide>

        <b-carousel-slide
          :img-src="`${feed.imgurl[1]}`"
          class="d-block w-100"
        ></b-carousel-slide>
      </b-carousel>

      <p class="mt-4">Sliding: {{ sliding }}</p>
    </div>
  </div>
</template>

<script>
// import { mapState } from "vuex";

export default {
  name: "FeedListItemCarousel",
  props: {
    // feeds: Object,
    feed: Object,
  },
  data() {
    return {
      slide: 0,
      sliding: null,
    };
  },
  methods: {
    onSlideStart() {
      this.sliding = true;
    },
    onSlideEnd() {
      this.sliding = false;
    },
  },
  created: function () {
    // console.log(this.feed);
    // console.log(this.feeds);
  },
  // computed: {
  //   ...mapState(["feeds"]),
  // },
};
</script>

<style>
.feed-picture-box {
  /* padding: 10px; */
  height: 100%;
  min-height: 400px;
  max-height: 600px;
  border: 1px solid #dbdbdb;
}

.feed-picture {
  width: 100%;
  margin: auto;
  /* height: 500px; */
  /* min-height: 400 px; */
  /* max-height: 400 px; */
}
</style>
