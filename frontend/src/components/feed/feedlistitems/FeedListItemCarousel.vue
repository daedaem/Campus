<template>
  <!-- 피드 게시물 첨부 사진이 한 개일때 -->
  <div class="feed-picture-box d-flex" v-if="feed.imageList.length == 1">
    <div class="feed-picture">
      <img
        :src="`${feed.imageList[0].snsImageUrl}`"
        class="d-block w-100"
        alt="..."
      />
    </div>
  </div>
  <!-- 두개이상일 때 -->
  <!-- 피드 게시물 첨부 사진이 두장 이상 일때 -->
  <div class="feed-picture-box" v-else-if="feed.imageList.length == 2">
    <div class="feed-picture">
      <div
        :id="feedid"
        class="carousel carousel-dark slide"
        data-bs-ride="carousel"
        data-bs-interval="false"
      >
        <div class="carousel-indicators">
          <!-- 밑 반복을 줄이기 위해서 썼으나 밑에 숫자를 문법으로 나타내는 법 모름
            v-for="indicator in feed.imageList.length"
            :key="indicator.key" -->
          <button
            type="button"
            @click="carouselidadd(feed)"
            :data-bs-target="feedlink"
            data-bs-slide-to="0"
            class="active"
            aria-current="true"
            aria-label="Slide 1"
          ></button>
          <button
            type="button"
            @click="carouselidadd(feed)"
            :data-bs-target="feedlink"
            data-bs-slide-to="1"
            aria-label="Slide 2"
          ></button>
        </div>
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img
              :src="`${feed.imageList[0].snsImageUrl}`"
              class="d-block w-100"
              alt="..."
            />
          </div>
          <div class="carousel-item">
            <img
              :src="`${feed.imageList[1].snsImageUrl}`"
              class="d-block w-100"
              alt="..."
            />
          </div>
        </div>
        <button
          class="carousel-control-prev"
          type="button"
          @click="carouselidadd(feed)"
          :data-bs-target="feedlink"
          data-bs-slide="prev"
        >
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Previous</span>
        </button>
        <button
          class="carousel-control-next"
          @click="carouselidadd(feed)"
          :data-bs-target="feedlink"
          data-bs-slide="next"
        >
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Next</span>
        </button>
      </div>
    </div>
  </div>
  <!-- 세장일 때 -->
  <div class="feed-picture-box" v-else-if="feed.imageList.length == 3">
    <div class="feed-picture">
      <div
        :id="feedid"
        class="carousel carousel-dark slide"
        data-bs-ride="carousel"
        data-bs-interval="false"
      >
        <div class="carousel-indicators">
          <!-- 밑 반복을 줄이기 위해서 썼으나 밑에 숫자를 문법으로 나타내는 법 모름
            v-for="indicator in feed.imageList.length"
            :key="indicator.key" -->
          <button
            type="button"
            @click="carouselidadd(feed)"
            :data-bs-target="feedlink"
            data-bs-slide-to="0"
            class="active"
            aria-current="true"
            aria-label="Slide 1"
          ></button>
          <button
            type="button"
            @click="carouselidadd(feed)"
            :data-bs-target="feedlink"
            data-bs-slide-to="1"
            aria-label="Slide 2"
          ></button>
          <button
            type="button"
            @click="carouselidadd(feed)"
            :data-bs-target="feedlink"
            data-bs-slide-to="2"
            aria-label="Slide 3"
          ></button>
        </div>
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img
              :src="`${feed.imageList[0].snsImageUrl}`"
              class="d-block w-100"
              alt="..."
            />
          </div>
          <div class="carousel-item">
            <img
              :src="`${feed.imageList[1].snsImageUrl}`"
              class="d-block w-100"
              alt="..."
            />
          </div>
          <div class="carousel-item">
            <img
              :src="`${feed.imageList[2].snsImageUrl}`"
              class="d-block w-100"
              alt="..."
            />
          </div>
        </div>
        <button
          class="carousel-control-prev"
          type="button"
          @click="carouselidadd(feed)"
          :data-bs-target="feedlink"
          data-bs-slide="prev"
        >
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Previous</span>
        </button>
        <button
          class="carousel-control-next"
          @click="carouselidadd(feed)"
          :data-bs-target="feedlink"
          data-bs-slide="next"
        >
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Next</span>
        </button>
      </div>
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
      feedid: "",
      feedlink: "",
    };
  },
  methods: {
    carouselidadd: function (feed) {
      this.feedid = "feed" + feed.snsNo;
      this.feedlink = "#" + this.feedid;
      console.log(this.feedlink);
    },
  },

  // computed: {
  //   ...mapState(["feeds"]),
  // },
};
</script>

<style scoped>
/* .total-feed-box { */
/* } */
.feed-picture-box {
  /* padding: 10px; */
  height: 100%;
  /* min-height: 400px; */
  max-height: 600px;
}
.carousel-inner {
  max-height: 600px;
}
.feed-picture {
  width: 100%;
  /* height: 100%; */
  margin: auto;

  /* height: 500px; */
  /* min-height: 400 px; */
  /* max-height: 400 px; */
}
</style>
