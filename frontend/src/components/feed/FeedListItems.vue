<template>
  <div class="feed-frame col-12 col-sm-12 col-md-10">
    <div class="user-feed-cards">
      <div class="user-feed-card">
        <div class="d-flex justify-content-between align-items-center">
          <div class="d-flex justify-content-center align-items-center">
            <div>
              <img
                style="cursor: pointer"
                :src="`${feed.userProfileImage}`"
                class="user-profile-image"
                alt="..."
              />
            </div>

            <div class="user-profile-username fs-5" style="cursor: pointer">
              {{ feed.userNickname }}
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
        <p class="fs-6">{{ feed.snsContent }}</p>
      </div>

      <!-- 피드 게시글 밑 버튼들 -->
      <div class="user-feed-buttons d-flex justify-content-around fs-4">
        <span
          style="cursor: pointer"
          class="heart-box d-flex my-auto"
          @click="giveHeart(feed)"
          v-if="amiliked == 0"
        >
          <i class="bi bi-heart me-3"></i>
          <p class="fs-6 my-auto">{{ likeCount }}</p>
        </span>
        <span
          style="cursor: pointer"
          class="heart-box d-flex my-auto"
          @click="cancelHeart(feed)"
          v-else
        >
          <i class="bi bi-heart-fill me-3"></i>
          <p class="fs-6 my-auto">{{ likeCount }}</p>
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
            <!-- <img
              :src="`${this.$store.state.myProifle.userProfileImage}`"
              class="user-comment-profile-image mx-1 my-auto"
              alt="..."
            /> -->
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
import axios from "axios";

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
      likeCount: 0,
      // follow했는지 여부
      followed: 0,
      // 내 유저번호
      userNum: "",
      likedpeople: [],
      amiliked: 0,
      heartstatus: 0,
      myProfileNum: this.$store.state.myNum,

      // 좋아요 갯수는 이후에 해당 게시글의 좋아요에다가 더하는 기능으로 바꾸려고 함
    };
  },
  methods: {
    likesCountCheck() {
      axios
        .get(`http://localhost:8080/sns/likecount/${this.feed.snsNo}/`)
        .then((res) => {
          // console.log(res);
          const likeCount = res.data.likeCount;
          this.likeCount = likeCount;
          // this.$store.dispatch("feedList", data);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    // 좋아요 여부 확인
    likedCheck() {
      axios
        .get(`http://localhost:8080/sns/like/${this.feed.userNo}/`)
        .then((res) => {
          // console.log("좋아요했는지 체크", res);
          // 좋아요 한 사람들 리스트
          // console.log(res);
          const likedpeople = res.data.like;
          if (likedpeople.includes(this.myProfileNum)) {
            this.amiliked = 1;
          } else {
            this.amiliked = 0;
          }
        });
    },
    // 좋아요 숫자 세기

    giveHeart() {
      axios
        .post(
          // `http://localhost:8080/sns/like/${this.feed.snsNo}/${this.myProfileNum}`
          // 내 유저넘버 저장되고 나면 밑에 주석
          `http://localhost:8080/sns/like/${this.feed.snsNo}/${this.feed.userNo}`
        )
        .then(() => {
          // console.log(res);
          this.likeCount += 1;
          // this.likeCount.push;
          // this.$store.dispatch("feedList", data);
        })

        .catch((err) => {
          console.log(err);
        });
    },
    cancelHeart() {
      axios
        .delete(
          // `http://localhost:8080/sns/like/${this.feed.snsNo}/${this.myProfileNum}`
          // 내 유저넘버 저장되고 나면 밑에 주석
          `http://localhost:8080/sns/like/${this.feed.snsNo}/${this.feed.userNo}`
        )
        .then(() => {
          // console.log(res);
          this.likeCount -= 1;
          // this.likeCount.push;
          // this.$store.dispatch("feedList", data);
        })

        .catch((err) => {
          console.log(err);
        });
    },
    // 좋아요 했는지 여부는
    // 해당 글의 좋아요 리스트에서 내 유저 넘버있는지 여부 확인

    //       // this.likeCount.push;
    //       // this.$store.dispatch("feedList", data);
    //     })
    //     .catch((err) => {
    //       console.log(err);
    //     });
    // },
    // 만약 좋아요를 했다면 좋아요 취소
    // changedheart() {
    // if (this.heartclick > 0) {
    // this.heartclick = 0;
    //     this.$store.state.feeds[feed.id - 1].likecount += 1;
    //     // this.heartcount = this.$store.state.feeds[feed.id].likecount
    //   } else {
    //     this.heartclick = 1;
    //     this.$store.state.feeds[feed.id - 1].likecount -= 1;
    // this.heartcount = this.$store.state.feeds[feed.id].likecount

    //   },
    //   heartcount() {
    //     if (heart == null) {
    //       console.log("heart is null");
    //     } else {
    //       console.log("heart is filled");
    //       heartcount + 1;
    //     }
    //   },
    follow() {
      if (this.followed == 0) {
        this.followed = 1;
      } else this.followed == 1;
      alert("정말 취소하시겠나요?");
    },
  },
  created: function () {
    this.likedCheck();
    this.likesCountCheck();
  },

  computed: {
    ...mapState(["myProfile"]),
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
