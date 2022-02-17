<template>
  <div class="feed-frame col-12 col-sm-12 col-md-12">
    <div class="user-feed-cards">
      <div class="user-feed-card">
        <div class="d-flex justify-content-between align-items-center">
          <div class="d-flex justify-content-center align-items-center">
            <div>
              <router-link :to="{ name: 'Profile',  params: { userEmail: feed.userEmail }}">
              <img
                v-if="feed.userProfileImage === null" 
                style="cursor: pointer"
                src="https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png"
                class="user-profile-image"
                alt="...">
              <img
                v-else
                style="cursor: pointer"
                :src="`${feed.userProfileImage}`"
                class="user-profile-image"
                alt="..."
              /></router-link>
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
        <p class="calcuatedTime text-end">{{ ContentTime }}</p>
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

        <span class="comment-box my-auto">
          <span>
            <!-- visible? visible이 참이면 null 거짓이면 collapsed -->
            <!-- ara-expanded가 visible이 참이면 true 아니면 false -->
            <!-- 그래서 클릭할 때마다 visible이 참 거짓이 바뀜 -->
            <i
              class="bi bi-chat-dots"
              font-size="25px"
              :class="visible ? null : 'collapsed'"
              :aria-expanded="visible ? 'true' : 'false'"
              aria-controls="comment"
              @click="visible = !visible"
              style="cursor: pointer"
            ></i>
          </span>
        </span>
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
                      <router-link :to="{ name: 'Profile',  params: { userEmail: comment.userEmail }}">
                      <img
                        v-if="comment.userProfileImage === null"
                        src="https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png"
                        alt=""
                        class="user-comment-profile-image"
                      />
                      <img
                        v-else
                        :src="`${comment.userProfileImage}`"
                        alt=""
                        class="user-comment-profile-image"
                      /></router-link>
                      <div class="fw-bold">
                        {{ comment.userNickname }}
                      </div>
                      <div
                        class="FeedListItems-commentContent col mx-3 text-start"
                      >
                        {{ comment.snsReplyContent }}
                      </div>
                    </div>
                    <div
                      class="d-flex align-items-center me-3"
                      style="overflow: auto; min-width: 55px"
                    >
                      <div class="ReplyTime me-1">
                        {{ ReplyTime[i] }}
                      </div>
                      <i
                        i
                        v-if="
                          comment.userNo === this.$store.state.userList.userNo
                        "
                        class="bi bi-x"
                        @click="deleteComment(comment)"
                      ></i>
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
                    v-if="this.$store.state.userList.userProfileImage === null"
                    src="https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png" 
                    alt=""
                    class="user-comment-profile-image ms-2">
                  <img
                    v-else
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
const SERVER_URL = process.env.VUE_APP_SERVER_URL;

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
      ContentTime: "",
      ReplyTime: [],
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
    deleteComment(comment) {
      // console.log(comment);
      axios({
        method: "delete",
        // 맨 뒤에 2를 현재 내 usernumber로 바꿔줄 예정

        url: `${SERVER_URL}/sns/reply/${comment.snsReplyNo}
      `,
        //         // headers: { "Access-Control-Allow-Origin": "*" },
        //         // data: this.my_comment,
        //         // credentials,
        //         // headers: this.$store.getters.config,
      })
        .then(() => {
          console.log;
          //
          this.snsComments();
        })
        .catch((err) => {
          console.log(err);
        });
    },
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
        });
    },
    giveHeart: function () {
      axios({
        method: "post",
        // 맨 뒤에 2를 현재 내 usernumber로 바꿔줄 예정
        url: `${SERVER_URL}/sns/like/${this.feed.snsNo}/${this.$store.state.userList.userNo}`,
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
      this.ReplyTime = [];
      axios
        .get(`${SERVER_URL}/sns/reply/${this.feed.snsNo}`)
        .then((res) => {
          console.log(res);

          if (res.data.list.length > 0) {
            for (let i = 0; i < res.data.list.length; i++) {
              this.comments.unshift(res.data.list[i]);
              this.ReplyTime.unshift(
                this.calculatedReplyTime(res.data.list[i].snsReplyCreateTime)
              );
            }
          }
          // console.log("snscomments", this.comments)}};
        })
        .catch((err) => {
          console.log(err);
        });
    },
    calculatedReplyTime(res) {
      // console.log(res);
      let ReplynewTime = new Date(res);
      var ReplynowTime = new Date();
      // console.log(ReplynewTime);
      // console.log(ReplynowTime);
      const milliSeconds = ReplynowTime - ReplynewTime - 9 * 60 * 60 * 1000;
      const seconds = milliSeconds / 1000;
      if (seconds < 60) return `방금 전`;
      const minutes = seconds / 60;
      if (minutes < 60) return `${Math.floor(minutes)}분 전`;
      const hours = minutes / 60;
      if (hours < 24) return `${Math.floor(hours)}시간 전`;
      const days = hours / 24;
      if (days < 7) return `${Math.floor(days)}일 전`;
      const weeks = days / 7;
      if (weeks < 5) return `${Math.floor(weeks)}주 전`;
      const months = days / 30;
      if (months < 12) return `${Math.floor(months)}개월 전`;
      const years = days / 365;
      return `${Math.floor(years)}년 전`;
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

    calculatedContentTime(res) {
      // console.log(res);
      let ContentnewTime = new Date(res);
      var ContentnowTime = new Date();
      // console.log(ContentnewTime);
      // console.log(ContentnowTime);
      const milliSeconds = ContentnowTime - ContentnewTime - 9 * 60 * 60 * 1000;
      const seconds = milliSeconds / 1000;
      if (seconds < 60) return `방금 전`;
      const minutes = seconds / 60;
      if (minutes < 60) return `${Math.floor(minutes)}분 전`;
      const hours = minutes / 60;
      if (hours < 24) return `${Math.floor(hours)}시간 전`;
      const days = hours / 24;
      if (days < 7) return `${Math.floor(days)}일 전`;
      const weeks = days / 7;
      if (weeks < 5) return `${Math.floor(weeks)}주 전`;
      const months = days / 30;
      if (months < 12) return `${Math.floor(months)}개월 전`;
      const years = days / 365;
      return `${Math.floor(years)}년 전`;
    },
  },
  created: function () {
    // console.log(this.comment.snsReplyCreateTim);
    this.likedCheck();
    this.likesCountCheck();
    this.snsComments();
    this.ContentTime = this.calculatedContentTime(this.feed.snsCreateTime);
    // if (this.feed.snsUpdateTime) {
    //   this.ContentTime = this.calculatedContentTime(this.feed.snsUpdateTime);
    // }
    // console.log(this.calculated(this.feed.snsCreateTime));

    // console.log("몇시간이냐", this.feed.snsCreateTime);

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
*{  font-family:Segoe UI Historic, Segoe UI, Helvetica, Arial, sans-serif;}
.feedlistitems-commentcontent{
  font-weight: 400;
  overflow: "auto";
  
}
.bi-heart-fill{
    color: rgb(237, 73, 86);
    fill: rgb(237, 73, 86);
    height: 24;
    width: 24;}
    
@media (min-width: 420px) {
  .user-feed-cards {
    border-radius: 20px;
    margin: 0px 0px 30px 0px;
    background-color: white;
    border: 1px solid #dbdbdb;
  }
}
.feed-frame {
  min-height: 400px;
  /* max-width: 600px; */
  /* margin: 0 auto; */

  /* max-height: 800px; */
}
.user-feed-cards {
  /* border-radius: 20px; */
  margin: 0px 0px 30px 0px;
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
  /* border: 1px solid #dbdbdb; */

  /* border-bottom: 1px solid #eee; */
  /* border-bottom: 1px solid black; */
  /* border-top: 1px solid black; */
  /* border-bottom: 1px solid #eee; */
}
.user-feed-alert {
  margin-left: auto;
}

.feed-text {
  /* border: 1px solid #dbdbdb; */
  text-align: justify;
  font-size: 16px;
  padding: 20px 20px;
}

.user-feed-buttons {
  /* margin: 10px 0px; */
  padding: 10px 0px;
  border-top: 1px solid #dbdbdb;
  /* border-bottom: 1px solid #dbdbdb; */
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
.calcuatedTime {
  font-size: 12px;
}
.ReplyTime {
  font-size: 10px;
}
</style>
