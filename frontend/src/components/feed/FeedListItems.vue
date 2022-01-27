<template>
  <div class="feed-frame col-12 col-sm-12 col-md-10">
    <div class="user-feed-cards">
      <div class="user-feed-card">
        <div class="d-flex justify-content-between align-items-center">
          <div class="d-flex justify-content-center align-items-center">
            <div>
              <img
                style="cursor: pointer"
                :src="`${feed.profile_image_url}`"
                class="user-profile-image"
                alt="..."
              />
            </div>

            <div class="user-profile-username fs-5" style="cursor: pointer">
              {{ feed.first_name }}
            </div>
          </div>
          <feed-dropdown></feed-dropdown>
          <!-- <div v-if="followed == 0" @click="follow" class="user-feed-alert">
            <i class="bi bi-person-plus fs-4"></i>
          </div>
          <div v-else class="user-feed-alert">
            <i class="bi bi-person-check-fill fs-4"></i> -->
          <!-- </div> -->
        </div>
      </div>

      <!-- 피드 사진 캐러셀 -->
      <feed-list-item-carousel v-bind:feed="feed"></feed-list-item-carousel>
      <!-- 피드 게시글 내용 -->
      <div class="feed-text">
        <p class="fs-6">
          Lorem Ipsum is simply dummy text of the printing and typesetting
          industry. Lorem Ipsum has been the industry's standard dummy text ever
          since the 1500s, when an unknown printer took a galley of type and
          scrambled it to make a type specimen book. It has survived not only
          five centuries, but also the leap into electronic typesetting,
          remaining essentially unchanged.
        </p>
      </div>

      <!-- 피드 게시글 밑 버튼들 -->
      <div class="user-feed-buttons d-flex justify-content-around fs-4">
        <!-- 밑에 삽입 예정 
          @click="[changedheart(), heartcount()]"-->
        <span
          style="cursor: pointer"
          class="heart-box d-flex my-auto"
          @click="changedheart(feed)"
          v-if="heartclick == 1"
        >
          <i class="bi bi-heart me-3"></i>
          <p class="fs-6 my-auto">{{ feed.likecount }}</p>
        </span>
        <span
          style="cursor: pointer"
          class="heart-box d-flex my-auto"
          @click="changedheart(feed)"
          v-else
        >
          <i class="bi bi-heart-fill me-3"></i>
          <p class="fs-6 my-auto">{{ feed.likecount }}</p>
        </span>

        <div class="comment-box my-auto">
          <span>
            <!-- visible? visible이 참이면 null 거짓이면 collapsed -->
            <!-- ara-expanded가 visible이 참이면 true 아니면 false -->
            <!-- 그래서 클릭할 때마다 visible이 참 거짓이 바뀜 -->
            <b-icon
              style="cursor: pointer"
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
      <b-collapse id="comment" v-model="visible">
        <div
          class="collapsed-comment d-flex justify-content-around align-items-center"
        >
          <div class="my-auto">
            <img
              :src="`${feeds[0].profile_image_url}`"
              class="user-comment-profile-image mx-1 my-auto"
              alt="..."
            />
          </div>
          <div class="my-auto col-10">
            <div class="form-floating">
              <div class="d-flex">
                <!-- 밑에 @keyup.enter="댓글 입력하는 함수실행" -->

                <textarea
                  v-model="commentcontent"
                  id="commentcontent"
                  ref="textarea"
                  rows="1"
                  class="d-flex col-10 me-2"
                  placeholder="댓글을 입력하세요"
                >
                </textarea>
                <button
                  class="btn btn-outline-secondary fs-6 me-1"
                  type="button"
                  id="commentcontent"
                >
                  게시
                </button>
              </div>
            </div>
          </div>
        </div>
      </b-collapse>
    </div>
  </div>
</template>
<script>
import { mapState } from "vuex";
import FeedDropdown from "./FeedDropdown.vue";
import FeedListItemCarousel from "./feedlistitems/FeedListItemCarousel.vue";

export default {
  components: { FeedListItemCarousel, FeedDropdown },
  name: "FeedListItems",

  props: {
    feed: Object,
  },
  data() {
    return {
      commentcontent: [],
      visible: true,
      heartclick: 1,
      heartcount: 0,
      followed: 0,
      // 좋아요 갯수는 이후에 해당 게시글의 좋아요에다가 더하는 기능으로 바꾸려고 함
      // likecount = 0
    };
  },
  methods: {
    // 만약 좋아요를 했다면 좋아요 취소
    changedheart(feed) {
      if (this.heartclick > 0) {
        this.heartclick = 0;
        this.$store.state.feeds[feed.id - 1].likecount += 1;
        // this.heartcount = this.$store.state.feeds[feed.id].likecount
      } else {
        this.heartclick = 1;
        this.$store.state.feeds[feed.id - 1].likecount -= 1;
        // this.heartcount = this.$store.state.feeds[feed.id].likecount
      }
      //   },
      //   heartcount() {
      //     if (heart == null) {
      //       console.log("heart is null");
      //     } else {
      //       console.log("heart is filled");
      //       heartcount + 1;
      //     }
      //   },
    },
    follow() {
      if (this.followed == 0) {
        this.followed = 1;
      } else this.followed == 1;
      alert("정말 취소하시겠나요?");
    },
  },
  computed: {
    ...mapState(["feeds"]),
  },
};
</script>

<style scoped>
.feed-frame {
  min-height: 400px;
  /* max-width: 600px; */
  margin: 0 auto;

  /* max-height: 800px; */
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
  /* font-size: ; */
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
.collapsed-comment {
  height: 80px;
  /* margin: auto; */
}
.user-comment-profile-image {
  /* display: inline-block; */
  border-radius: 50%;
  margin: 0px 20px 0px 0px;
  width: 30px;
  height: 30px;
  cursor: pointer;
}
</style>
