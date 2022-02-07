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

            <div
              class="user-profile-username fs-6 fw-bold"
              style="cursor: pointer"
            >
              {{ feed.userNickname }}
            </div>
          </div>
          <feed-list-item-dropdown v-bind:feed="feed"></feed-list-item-dropdown>
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
        <p class="fs-6 text-start" style="overflow: auto">
          {{ feed.snsContent }}
        </p>
      </div>

      <!-- 피드 게시글 밑 버튼들 -->
      <div class="user-feed-buttons d-flex justify-content-around fs-4">
        <span
          style="cursor: pointer"
          class="heart-box d-flex my-auto"
          @click="giveHeart"
          v-if="this.amiliked == 0"
        >
          <i class="bi bi-heart me-3"></i>
          <p class="fs-6 my-auto">{{ likeCount }}</p>
        </span>
        <span
          style="cursor: pointer"
          class="heart-box d-flex my-auto"
          @click="cancelHeart"
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
          <div class="my-auto col-12">
            <div class="form-floating">
              <div
                v-for="(comment, i) in this.comments"
                :key="i"
                :comment="comment"
              >
                <div v-if="this.comments">
                  <div
                    class="d-flex justify-content-between align-items-center py-2"
                  >
                    <div
                      class="d-flex justify-content-start align-items-center ps-3 col-9"
                    >
                      <img
                        :src="`${comment.userProfileImage}`"
                        alt=""
                        class="user-comment-profile-image"
                      />
                      <div class="fw-bold">
                        {{ comment.userNickname }}
                      </div>
                      <div
                        class="FeedListItems-commentContent col mx-3 text-start"
                        style="overflow: auto"
                      >
                        {{ comment.snsReplyContent }}
                      </div>
                    </div>
                    <div class="col" style="overflow: auto">
                      {{ comment.snsReplyCreateTime }}
                    </div>
                  </div>
                </div>
              </div>
              <div
                class="d-flex justify-content-around align-items-center my-3"
              >
                <!-- 밑에 @keyup.enter="댓글 입력하는 함수실행" -->
                <div
                  class="d-flex justify-content-center align-items-center mx-2"
                >
                  <img
                    :src="`${this.$store.state.userList.userProfileImage}`"
                    alt=""
                    class="user-comment-profile-image ms-2"
                  />

                  <div class="fw-bold">
                    {{ this.$store.state.userList.userNickname }}
                  </div>
                </div>
                <textarea
                  v-model="my_comment.snsReplyContent"
                  id="commentcontent"
                  ref="textarea"
                  rows="2"
                  class="d-flex col"
                  placeholder=" 댓글을 입력하세요"
                  style="overflow: auto"
                >
                </textarea>
                <div class="d-flex align-items-cetner">
                  <p
                    @click="leaveComment"
                    class="btn-sm btn-outline-transparent text-primary"
                    type="button"
                    id="commentcontent"
                  >
                    게시
                  </p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </b-collapse>
    </div>
  </div>
</template>
<script>
const SERVER_URL = `http://i6e102.p.ssafy.io`;
// const SERVER_URL = "http://localhost:8080";

import { mapState } from "vuex";
import axios from "axios";
import FeedListItemCarousel from "./feedlistitems/FeedListItemCarousel.vue";
import FeedListItemDropdown from "./feedlistitems/FeedListItemDropdown.vue";

export default {
  name: "FeedListItems",
  components: { FeedListItemCarousel, FeedListItemDropdown },

  props: {
    feed: Object,
  },
  data() {
    return {
      my_comment: {
        snsReplyContent: "",
        userNo: this.$store.state.userList.userNo,
        snsNo: this.feed.snsNo,
      },
      // snsReplyContent: {

      //   commentcontent:""
      // },
      comments: [],
      visible: true,
      likeCount: 0,
      // follow했는지 여부
      followed: 0,
      // 내 유저번호
      // userNum: "",
      likedpeople: [],
      amiliked: 0,
      // commentCreateTime: this.comment.snsReplyCreateTime,
      myProfileNum: this.$store.state.userList.userNo,

      // 좋아요 갯수는 이후에 해당 게시글의 좋아요에다가 더하는 기능으로 바꾸려고 함
    };
  },
  methods: {
    likesCountCheck() {
      axios
        .get(`${SERVER_URL}/sns/likecount/${this.feed.snsNo}/`)
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
        .get(`${SERVER_URL}/sns/like/${this.$store.state.userList.userNo}`)
        .then((res) => {
          // console.log("좋아요했는지 체크", res);
          // 좋아요 한 사람들 리스트
          // console.log("좋아요리스트", res.data.like.length);
          // console.log("되나", this.feed.snsNo);
          // const likedpeople = res.data.like;
          for (let i = 0; i < res.data.like.length; i++) {
            if (res.data.like[i].snsNo == this.feed.snsNo) {
              this.amiliked = 1;
            }
          }

          //   let temp = likedpeople[i];

          //     console.log("있습니다.");
          // }
        });
      // console.log("되나", this.feed.snsNo);
      // });
    },
    giveHeart: function () {
      // console.log("너", this.$store.state.myNum);
      // console.log("나", this.feed.snsNo);
      // const credentials = {
      //   // userNo: this.$store.state.myNum,
      //   snsNo: this.feed.snsNo,
      // };

      axios({
        method: "post",
        // url: `${SERVER_URL}/sns/like/${this.feed.snsNo}/${this.$store.state.myNum}`,

        // 맨 뒤에 2를 현재 내 usernumber로 바꿔줄 예정
        url: `${SERVER_URL}/sns/like/${this.feed.snsNo}/${this.$store.state.userList.userNo}`,
        // headers: { "Access-Control-Allow-Origin": "*" },
        // data: this.my_comment,
        // credentials,
        // headers: this.$store.getters.config,
      })
        .then(() => {
          // console.log
          this.amiliked = 1;
          this.likeCount += 1;
          //
        })
        .catch((err) => {
          console.log(err);
        });
    },
    cancelHeart() {
      axios({
        method: "delete",
        url: `${SERVER_URL}/sns/like/${this.feed.snsNo}/${this.$store.state.userList.userNo}`,

        // data: this.my_comment,
        // headers: this.$store.getters.config,
      })
        .then(() => {
          this.amiliked = 0;
          this.likeCount -= 1;
        })
        .catch((err) => {
          console.log(err);
        });
    },
    leaveComment() {
      if (this.my_comment.snsReplyContent) {
        if (this.my_comment.snsReplyContent.trim()) {
          this.my_comment.userNo = this.$store.state.userList.userNo;
          this.my_comment.snsNo = this.feed.snsNo;
          axios({
            method: "post",
            url: `${SERVER_URL}/sns/reply`,
            data: this.my_comment,
            // headers: this.$store.getters.config,
          })
            .then(() => {
              // console.log(this.my_comment.snsNo);
              // console.log(this.$store.state.userList.userNo);
              this.my_comment.snsReplyContent = null;
              // console.log("댓글남기자");
            })
            .then(() => {
              this.snsComments();
            })
            .catch((err) => {
              console.log(err);
            });
        } else {
          alert(`Please input content.`);
        }
      } else {
        alert(`Please input content.`);
      }
    },
    snsComments() {
      this.comments = [];
      axios
        .get(`${SERVER_URL}/sns/reply/${this.feed.snsNo}`)
        .then((res) => {
          // console.log(res);

          if (res.data.list.length > 0) {
            for (let i = 0; i < res.data.list.length; i++) {
              this.comments.unshift(res.data.list[i]);
              // console.log(this.comments);
            }
          }
          // console.log("snscomments", this.comments)}};
        })
        .catch((err) => {
          console.log(err);
        });
    },

    follow() {
      axios({ method: "post", url: `{${SERVER_URL}}/follow` }).then((res) => {
        console.log(res);
      });

      // if (this.followed == 0) {
      //   this.followed = 1;
      // } else this.followed == 1;
      // alert("정말 취소하시겠나요?");
    },
  },
  created: function () {
    this.likedCheck();
    this.likesCountCheck();
    this.snsComments();
    // console.log(this.$store.state.myNum);
    // console.log(this.$store.state.userList.userNo);
    this.my_comment.userNo = this.$store.state.userList.userNo;
  },

  computed: {
    ...mapState(["userList"]),
    ...mapState(["nickname"]),
    ...mapState(["myProfileimageurl"]),
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

  margin: 5px 0px 30px 0px;
  background-color: white;
  border: 1px solid #dbdbdb;
}
.user-profile-image {
  /* display: inline-block; */
  border-radius: 50%;
  margin: 0px 15px 0px 0px;
  width: 42px;
  height: 42px;
  cursor: pointer;
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
/* .FeedListItems-commentContent { */
/* border: 0.5px solid; */
/* padding: 5px; */
/* } */
.user-feed-buttons {
  /* margin: 10px 0px; */
  padding: 10px 0px;
  border: 1px solid #dbdbdb;
}
.collapsed-comment {
  min-height: 80px;
  /* margin: auto; */
}
.user-comment-profile-image {
  /* display: inline-block; */
  border-radius: 50%;
  margin: 0px 15px 0px 0px;
  width: 30px;
  height: 30px;
  cursor: pointer;
}
</style>
