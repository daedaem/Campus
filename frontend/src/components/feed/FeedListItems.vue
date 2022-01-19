<template>
  <div class="feed-frame">
    <div class="user-feed-cards" v-for="feed in feeds" :key="feed.id">
      <div class="user-feed-card">
        <div class="user-profile d-flex">
          <div class="user-profile-infos d-flex justify-content-between">
            {{ feed.id }}
            <div class="user-profile-username">{{ feed.first_name }}</div>
          </div>
          <div class="user-feed-alert">follow</div>
        </div>
      </div>

      <!-- 피드 게시물 첨부 사진이 한 개일때 -->
      <div class="feed-picture-box" v-if="feed.imgurl.length >= 1">
        <div class="feed">
          <div
            id="carouselExampleIndicators"
            class="carousel slide"
            data-bs-ride="carousel"
            data-bs-interval="false"
          >
            <div class="carousel-indicators">
              <button
                type="button"
                data-bs-target="#carouselExampleIndicators"
                data-bs-slide-to="0"
                class="active"
                aria-current="true"
                aria-label="Slide 1"
              ></button>
              <!-- <button
              type="button"
              data-bs-target="#carouselExampleIndicators"
              data-bs-slide-to="1"
              aria-label="Slide 2"
            ></button>
            <button
              type="button"
              data-bs-target="#carouselExampleIndicators"
              data-bs-slide-to="2"
              aria-label="Slide 3"
            ></button> -->
            </div>
            <div class="carousel-inner">
              <div class="carousel-item active">
                <img :src="`${feed.imgurl}`" class="d-block w-100" alt="..." />
              </div>
              <!-- <div class="carousel-item">
              <img
                src="@/assets/images/bear.png"
                class="d-block w-100"
                alt="..."
              />
            </div>
            <div class="carousel-item">
              <img
                src="@/assets/images/bear.png"
                class="d-block w-100"
                alt="..."
              />
            </div> -->
            </div>
            <button
              class="carousel-control-prev"
              type="button"
              data-bs-target="#carouselExampleIndicators"
              data-bs-slide="prev"
            >
              <span
                class="carousel-control-prev-icon"
                aria-hidden="true"
              ></span>
              <span class="visually-hidden">Previous</span>
            </button>
            <button
              class="carousel-control-next"
              type="button"
              data-bs-target="#carouselExampleIndicators"
              data-bs-slide="next"
            >
              <span
                class="carousel-control-next-icon"
                aria-hidden="true"
              ></span>
              <span class="visually-hidden">Next</span>
            </button>
          </div>
        </div>
      </div>
      <!-- 피드 게시물 첨부 사진이 두장 이상 일때 -->
      <div class="feed-picture-box" v-else>
        <div class="feed">
          <div
            id="carouselExampleIndicators"
            class="carousel slide"
            data-bs-ride="carousel"
            data-bs-interval="false"
          >
            <div class="carousel-indicators">
              <button
                type="button"
                data-bs-target="#carouselExampleIndicators"
                data-bs-slide-to="0"
                class="active"
                aria-current="true"
                aria-label="Slide 1"
              ></button>
              <!-- <button
              type="button"
              data-bs-target="#carouselExampleIndicators"
              data-bs-slide-to="1"
              aria-label="Slide 2"
            ></button>
            <button
              type="button"
              data-bs-target="#carouselExampleIndicators"
              data-bs-slide-to="2"
              aria-label="Slide 3"
            ></button> -->
            </div>
            <div class="carousel-inner">
              <div class="carousel-item active">
                <img :src="`${feed.imgurl}`" class="d-block w-100" alt="..." />
              </div>
              <!-- <div class="carousel-item">
              <img
                src="@/assets/images/bear.png"
                class="d-block w-100"
                alt="..."
              />
            </div>
            <div class="carousel-item">
              <img
                src="@/assets/images/bear.png"
                class="d-block w-100"
                alt="..."
              />
            </div> -->
            </div>
            <button
              class="carousel-control-prev"
              type="button"
              data-bs-target="#carouselExampleIndicators"
              data-bs-slide="prev"
            >
              <span
                class="carousel-control-prev-icon"
                aria-hidden="true"
              ></span>
              <span class="visually-hidden">Previous</span>
            </button>
            <button
              class="carousel-control-next"
              type="button"
              data-bs-target="#carouselExampleIndicators"
              data-bs-slide="next"
            >
              <span
                class="carousel-control-next-icon"
                aria-hidden="true"
              ></span>
              <span class="visually-hidden">Next</span>
            </button>
          </div>
        </div>
      </div>

      <div class="feed-text">
        Lorem Ipsum is simply dummy text of the printing and typesetting
        industry. Lorem Ipsum has been the industry's standard dummy text ever
        since the 1500s, when an unknown printer took a galley of type and
        scrambled it to make a type specimen book. It has survived not only five
        centuries, but also the leap into electronic typesetting, remaining
        essentially unchanged. It was popularised in the 1960s with the release
        of Letraset sheets containing Lorem Ipsum passages, and more recently
        with desktop publishing software like Aldus PageMaker including versions
        of Lorem Ipsum
      </div>
      <div class="user-feed-buttons d-flex justify-content-around">
        <div class="d-flex">
          <i class="bi bi-heart-fill"></i>
          <i class="fas fa-fire-alt"></i>
          <p>좋아요 갯수</p>
        </div>
        <div class="d-flex">
          댓글
          <p>댓글 개수</p>
        </div>
        <div class="d-flex">
          공유이모티콘
          <p>공유</p>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import { mapState } from "vuex";
export default {
  name: "feedlistitems",
  // props: {
  //   feeds: Object,
  // },
  computed: {
    ...mapState(["feeds"]),
  },
};
</script>

<style>
/* .feed-frame {
  border: 1px solid #dbdbdb;
} */
.user-feed-cards {
  border-radius: 3px;

  margin: 0px 0px 30px 0px;
  background-color: white;
  border: 1px solid #dbdbdb;
}
.feed-picture-box {
  padding: 10px;
  border: 1px solid #dbdbdb;
}
.user-feed-card {
  padding: 20px 30px 20px 30px;
  border: 1px solid #dbdbdb;

  /* border-bottom: 1px solid #eee; */
  /* border-bottom: 1px solid black; */
  /* border-top: 1px solid black; */
  /* border-bottom: 1px solid #eee; */
}
.user-feed-alert {
  margin-left: auto;
}
.feed-text {
  border: 1px solid #dbdbdb;

  text-align: justify;
  font-size: 18px;
  padding: 20px 20px;
}

.user-feed-buttons {
  /* margin: 10px 0px; */
  padding: 10px 0px;
  border: 1px solid #dbdbdb;
}
</style>
