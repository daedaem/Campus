<template>
  <div>
    <!-- 피드 게시물 첨부 사진이 한 개일때 -->
    <div class="feed-picture-box d-flex" v-if="feed.imgurl.length == 1">
      <div class="feed-picture">
        <img :src="`${feed.imgurl[0]}`" class="d-block w-100" alt="..." />
      </div>
    </div>
    <!-- 두개이상일 때 -->

    <!-- 피드 게시물 첨부 사진이 두장 이상 일때 -->
    <div class="feed-picture-box" v-else-if="feed.imgurl.length == 2">
      <div class="feed">
        <div
          id="carouselExampleIndicators"
          class="carousel slide"
          data-bs-ride="carousel"
          data-bs-interval="false"
        >
          <div class="carousel-indicators">
            <!-- 밑 반복을 줄이기 위해서 썼으나 밑에 숫자를 문법으로 나타내는 법 모름
            v-for="indicator in feed.imgurl.length"
            :key="indicator.key" -->
            <button
              type="button"
              data-bs-target="#carouselExampleIndicators"
              data-bs-slide-to="0"
              class="active"
              aria-current="true"
              aria-label="Slide 1"
            ></button>
            <button
              type="button"
              data-bs-target="#carouselExampleIndicators"
              data-bs-slide-to="1"
              aria-label="Slide 2"
            ></button>
          </div>
          <div class="carousel-inner">
            <div class="carousel-item active">
              <img :src="`${feed.imgurl[0]}`" class="d-block w-100" alt="..." />
            </div>
            <div class="carousel-item">
              <img :src="`${feed.imgurl[1]}`" class="d-block w-100" alt="..." />
            </div>
          </div>
          <button
            class="carousel-control-prev"
            type="button"
            data-bs-target="#carouselExampleIndicators"
            data-bs-slide="prev"
          >
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
          </button>
          <button
            class="carousel-control-next"
            type="button"
            data-bs-target="#carouselExampleIndicators"
            data-bs-slide="next"
          >
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
          </button>
        </div>
      </div>
    </div>
    <!-- 세장일 때 -->
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "FeedListItemCarousel",
  props: {
    // feeds: Object,
    feed: Object,
  },
  data() {
    return {
      feedimage: "",
    };
  },
  computed: {
    ...mapState(["feeds"]),
  },
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
