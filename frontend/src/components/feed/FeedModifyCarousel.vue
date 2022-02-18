<template>
  <div class="total-feed-box">
    <!-- 피드 게시물 첨부 사진이 한 개일때 -->
    <div class="feed-picture-box d-flex" v-if="this.imageinfo.length == 1">
      <div class="feed-picture">
        <img :src="`${imageinfo[0]}`" class="d-block w-100 h-100" alt="..." />
      </div>
    </div>
    <!-- 두개이상일 때 -->
    <!-- 피드 게시물 첨부 사진이 두장 이상 일때 -->
    <div class="feed-picture-box d-flex" v-if="this.imageinfo.length == 2">
      <div class="feed-picture">
        <div
          :id="feedid"
          class="carousel carousel-dark slide"
          data-bs-ride="carousel"
          data-bs-interval="false"
        >
          <div class="carousel-indicators">
            <!-- 밑 반복을 줄이기 위해서 썼으나 밑에 숫자를 문법으로 나타내는 법 모름
            v-for="indicator in feed.imgurl.length"
            :key="indicator.key" -->
            <button
              type="button"
              @click="carouselidadd(image)"
              :data-bs-target="feedlink"
              data-bs-slide-to="0"
              class="active sm"
              aria-current="true"
              aria-label="Slide 1"
            ></button>
            <button
              type="button"
              @click="carouselidadd(image)"
              :data-bs-target="feedlink"
              data-bs-slide-to="1"
              aria-label="Slide 2"
            ></button>
          </div>
          <div class="carousel-inner">
            <div class="carousel-item active">
              <img :src="`${imageinfo[0]}`" class="d-block w-100" alt="..." />
            </div>
            <div class="carousel-item">
              <img :src="`${imageinfo[1]}`" class="d-block w-100" alt="..." />
            </div>
          </div>
          <button
            class="carousel-control-prev"
            type="button"
            @click="carouselidadd(image)"
            :data-bs-target="feedlink"
            data-bs-slide="prev"
          >
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
          </button>
          <button
            class="carousel-control-next"
            @click="carouselidadd(image)"
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
    <div class="feed-picture-box" v-if="this.imageinfo.length == 3">
      <div class="feed-picture">
        <div
          :id="feedid"
          class="carousel carousel-dark slide"
          data-bs-ride="carousel"
          data-bs-interval="false"
        >
          <div class="carousel-indicators">
            <!-- 밑 반복을 줄이기 위해서 썼으나 밑에 숫자를 문법으로 나타내는 법 모름
            v-for="indicator in feed.imgurl.length"
            :key="indicator.key" -->
            <button
              type="button"
              @click="carouselidadd(image)"
              :data-bs-target="feedlink"
              data-bs-slide-to="0"
              class="active"
              aria-current="true"
              aria-label="Slide 1"
              style="z-index: 100"
            ></button>
            <button
              type="button"
              @click="carouselidadd(image)"
              :data-bs-target="feedlink"
              data-bs-slide-to="1"
              aria-label="Slide 2"
              style="z-index: 100"
            ></button>
            <button
              type="button"
              @click="carouselidadd(image)"
              :data-bs-target="feedlink"
              data-bs-slide-to="2"
              aria-label="Slide 3"
              style="z-index: 100"
            ></button>
          </div>
          <div class="carousel-inner">
            <div class="carousel-item active">
              <img :src="`${imageinfo[0]}`" class="d-block w-100" alt="..." />
            </div>
            <div class="carousel-item">
              <img :src="`${imageinfo[0]}`" class="d-block w-100" alt="..." />
            </div>
            <div class="carousel-item">
              <img :src="`${imageinfo[0]}`" class="d-block w-100" alt="..." />
            </div>
          </div>
          <button
            class="carousel-control-prev"
            type="button"
            @click="carouselidadd(image)"
            :data-bs-target="feedlink"
            data-bs-slide="prev"
            style="z-index: 100"
          >
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden"></span>
          </button>
          <button
            class="carousel-control-next"
            @click="carouselidadd(image)"
            :data-bs-target="feedlink"
            data-bs-slide="next"
            style="z-index: 100"
          >
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
// import { mapState } from "vuex";

export default {
  name: "FeedDetailCarousel",
  props: {
    // feeds: Object,
    ImageList: Object,
  },
  data() {
    return {
      imageinfo: [],
      feedid: "",
      feedlink: "",
    };
  },
  methods: {
    carouselidadd: function (nums) {
      // for (let i; 0 < ImageList.length; i++){
      // console.log(nums);
      this.feedid = "feed" + nums;
      this.feedlink = "#" + this.feedid;
      // console.logf(ImageList);
      // console.log(;
    },
  },

  created: function () {
    this.imageinfo = this.ImageList;

    // console.log("캐럿", this.ImageList);
    // console.log("첫째",this.imageinfo[0]);
    // console.log(this.imageinfo.length);
    console.log("답은", this.imageinfo);
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
  /* height: 100%; */
  /* min-height: 400px; */
  max-height: 600px;
  border: 1px solid #dbdbdb;
}

.feed-picture {
  /* width: 100%; */
  /* height: 100%; */
  margin: auto;

  /* height: 500px; */
  /* min-height: 400 px; */
  /* max-height: 400 px; */
}

/* .carousel-control-prev{
width: 100%;
  height:100%;

}
.carousel-control-next{
  width: 100%;
  height:100%;
} */
</style>
