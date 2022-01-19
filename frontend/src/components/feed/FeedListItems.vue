<template>
  <div class="feed-frame">
    <div class="user-feed-cards" v-for="feed in feeds" :key="feed.id">
      <div class="user-feed-card">
        <div class="d-flex justify-content-center align-items-center">
          <div>
            <img
              :src="`${feed.profile_image_url}`"
              class="user-profile-image"
              alt="..."
            />
          </div>
          <div class="user-profile-username">{{ feed.first_name }}</div>
          <div class="user-feed-alert">follow</div>
        </div>
      </div>

      <!-- 피드 사진 캐러셀 -->
      <feed-list-item-carousel v-bind:feed="feed"></feed-list-item-carousel>
      <!-- 피드 게시글 내용 -->
      <div class="feed-text">
        Lorem Ipsum is simply dummy text of the printing and typesetting
        industry. Lorem Ipsum has been the industry's standard dummy text ever
        since the 1500s, when an unknown printer took a galley of type and
        scrambled it to make a type specimen book. It has survived not only five
        centuries, but also the leap into electronic typesetting, remaining
        essentially unchanged.
      </div>

      <!-- 피드 게시글 밑 버튼들 -->
      <div class="user-feed-buttons d-flex justify-content-around fs-4">
        <span class="heart-box d-flex my-auto">
          <i class="bi bi-heart-fill me-3"></i>
          <p class="fs-6 my-auto">1234</p>
        </span>

        <div class="comment-box my-auto">
          <span>
            <b-icon
              icon="chat-dots"
              font-size="25px"
              :class="visible ? null : 'collapsed'"
              :aria-expanded="visible ? 'true' : 'false'"
              aria-controls="comment"
              @click="visible = !visible"
            >
            </b-icon>
          </span>
        </div>
        <span class="share-box d-flex me-3 my-auto">
          <i class="bi bi-envelope-plus"></i>
        </span>
      </div>
      <!-- <textarea v-auto-resize name="" id="" cols="30" rows="10"></textarea> -->
      <b-collapse id="comment" v-model="visible" class="comment-total-frame">
        <div class="d-flex">
          <div class="col-1">
            <img
              :src="`${feeds[0].profile_image_url}`"
              class="user-comment-profile-image mx-1"
              alt="..."
            />
          </div>

          <div class="form-floating d-flex flex-grow-1">
            <!-- 밑에 @keyup.enter="댓글 입력하는 함수실행" -->
            <textarea
              v-model="commentcontent"
              class="flex-grow-1"
              id="commentcontent"
            >
            </textarea>
            <label for="commentcontent">댓글을 입력하세요...</label>
            <button class="btn btn-outline-secondary fs-6">게시</button>
          </div>
        </div>
      </b-collapse>
    </div>
  </div>
</template>
<script>
import { mapState } from "vuex";
import FeedListItemCarousel from "./feedlistitmes/FeedListItemCarousel.vue";

export default {
  components: { FeedListItemCarousel },
  name: "feedlistitems",
  data() {
    return {
      visible: true,
    };
  },
  methods: {},
  // },
  computed: {
    ...mapState(["feeds"]),
  },
};
</script>

<style>
.feed-frame {
  min-height: 400px;
  /* max-height: 800px; */
  width: 600px;
}
.user-feed-cards {
  border-radius: 3px;

  margin: 0px 0px 30px 0px;
  background-color: white;
  border: 1px solid #dbdbdb;
}
.user-profile-image {
  /* display: inline-block; */
  border-radius: 50%;
  margin: 0px 20px 0px 0px;
  width: 42px;
  height: 42px;
}

.user-profile-username {
  display: block;
  font-size: 18px;
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
  font-size: 16px;
  padding: 20px 20px;
}

.user-feed-buttons {
  /* margin: 10px 0px; */
  padding: 10px 0px;
  border: 1px solid #dbdbdb;
}
.comment-total-frame {
  height: 80px;
}
.collapsed-comment {
  height: 50px;
  /* margin: auto; */
}
.user-comment-profile-image {
  /* display: inline-block; */
  border-radius: 50%;
  margin: 0px 20px 0px 0px;
  width: 30px;
  height: 30px;
}
</style>
