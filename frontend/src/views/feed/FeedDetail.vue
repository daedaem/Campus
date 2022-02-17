<template>
  <div class="FeedDetail">
    <Navbar></Navbar>
    <div class="FeedDetailTotal">
      <div class="FeedDetailTotalFrame">
        <div class="feedDetailContentsFrame">
          <div class="FeedDetail-Leftbox">
            <feed-detail-carousel
              v-if="feedDetailContents.length != 0"
              :ImageList="feedDetailContents"
            ></feed-detail-carousel>
          </div>
          <div
            class="FeedDetail-RightBox d-flex flex-column justify-content-between"
          >
            <div>
              <div class="FeedDetail-RightBox-ProfileBox">
                <div
                  class="d-flex FeedDetail-RightBox-ProfileBox-UserInfo ps-3 justify-content-between align-items-center"
                >
                  <div
                    class="FeedDetail-ProfileBox-Image d-flex align-items-center ps-2"
                  >
                    <!-- 프로필이미지넣어지면 -->
                    <img
                      style="cursor: pointer"
                      :src="`${this.feedDetailContents.userProfileImage}`"
                      class="FeedDetail-user-profile-image"
                      alt="..."
                    />
                    <div
                      class="FeedDetail-ProfileBox-Username py-4 fw-bold"
                      style="cursor: pointer"
                    >
                      {{ this.feedDetailContents.userNickname }}
                    </div>
                  </div>
                  <div
                    class="FeedDetail-ProfileBox-Dropdown d-flex flex-column justify-self-end align-self-start pe-2"
                  >
                    <feed-detail-dropdown
                      v-bind:feedDetailContents="feedDetailContents"
                    ></feed-detail-dropdown>
                  </div>
                </div>
              </div>
              <div class="FeedDetail-RightBox-ContentBox text-start p-3">
                <div class="FeedDetailContent">
                  {{ this.feedDetailContents.snsContent }}
                  <p class="calculatedTime text-end">{{ ContentTime }}</p>
                </div>
              </div>
            </div>
            <b-collapse id="comment" v-model="visible">
              <div
                class="collapsed-comment d-flex justify-content-around align-items-center"
              >
                <div class="my-auto col-12">
                  <div class="form-floating">
                    <div class="FeedDetail-RightBox-CommentBox">
                      <div
                        v-for="(comment, i) in this.comments"
                        :key="i"
                        :comment="comment"
                      >
                        <div v-if="this.comments">
                          <div
                            class="FeedDetail-RightBox-CommentBoxDetail d-flex px-2 pt-1 justify-content-between align-items-center"
                          >
                            <div
                              class="d-flex justify-content-start align-items-center ms-1 col-10 py-1"
                            >
                              <div
                                class="d-flex align-items-center justify-content-center"
                                style="min-width: 95px"
                              >
                                <router-link :to="{ name: 'Profile',  params: { userEmail: comment.userEmail }}">
                                <img
                                  :src="`${comment.userProfileImage}`"
                                  alt=""
                                  class="user-comment-profile-image ms-2"
                                /></router-link>
                                <div class="commentUserNickname fw-bold">
                                  {{ comment.userNickname }}
                                </div>
                              </div>
                              <div
                                class="FeedListItems-commentContent col text-start ms-3"
                                style="overflow: auto"
                              >
                                <div class="m-2">
                                  {{ comment.snsReplyContent }}
                                </div>
                              </div>
                            </div>
                            <div class="d-flex" style="min-width: 40px">
                              <div class="replytime" style="font-szie: 8px">
                                {{ ReplyTime[i] }}
                              </div>
                              <i
                                v-if="
                                  comment.userNo ===
                                  this.$store.state.userList.userNo
                                "
                                class="bi bi-x"
                                @click="deleteComment(comment)"
                              ></i>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div
                      v-if="this.$store.state.userEmail == null"
                      class="FeedDetail-Rightbox-Commentinputbox d-flex justify-content-center align-items-center col-12"
                    >
                      <p>좋아요 또는 댓글을 남기려면 로그인을 해주세요.</p>
                    </div>
                    <div
                      v-else
                      class="FeedDetail-Rightbox-Commentinputbox d-flex justify-content-center align-items-center col-12"
                    >
                      <img
                        :src="`${this.$store.state.userList.userProfileImage}`"
                        alt=""
                        class="user-comment-profile-image m-3"
                      />

                      <div class="FeedDetailUserCommentName fw-bold me-2">
                        {{ this.$store.state.userList.userNickname }}
                      </div>
                      <textarea
                        v-model="my_comment.snsReplyContent"
                        id="commentcontent"
                        ref="textarea"
                        rows="1"
                        class="FeedDetail-WriteComment d-flex m-2 col"
                        placeholder="댓글을 입력하세요"
                        style="overflow: auto"
                      >
                      </textarea>
                      <div
                        @click="leaveComment"
                        class="leaveCommentButton btn-sm btn-outline-transparent text-primary m-2"
                        type="button"
                        id="commentcontent"
                      >
                        게시
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </b-collapse>
            <div
              class="FeedDetail-RightBox-ButtonBox d-flex justify-content-around fs-5 py-2"
            >
              <!-- 밑에 삽입 예정 
          @click="[changedheart(), heartcount()]"-->
              <span
                style="cursor: pointer"
                class="heart-box d-flex my-auto"
                @click="giveHeart"
                v-if="this.amiliked == 0"
              >
                <i class="bi bi-heart me-3"></i>
                <p class="fs-6 my-auto">
                  {{ this.likeCount }}
                </p>
              </span>
              <span
                style="cursor: pointer"
                class="heart-box d-flex my-auto"
                @click="cancelHeart"
                v-else
              >
                <i class="bi bi-heart-fill me-3"></i>
                <p class="fs-6 my-auto">
                  {{ this.likeCount }}
                </p>
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
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
const SERVER_URL = process.env.VUE_APP_SERVER_URL;

import { mapState } from "vuex";
import axios from "axios";
import Navbar from "@/components/common/Navbar.vue";

import FeedDetailCarousel from "../../components/feed/feeddetailitems/FeedDetailCarousel.vue";
import FeedDetailDropdown from "../../components/feed/feeddetailitems/FeedDetailDropdown.vue";

export default {
  name: "FeedDetail",
  components: {
    Navbar,
    FeedDetailCarousel,
    FeedDetailDropdown,
  },
  data() {
    return {
      my_comment: {
        snsReplyContent: "",
        userNo: this.$store.state.userList.userNo,
        snsNo: this.detailFeedsnsNo,
      },
      visible: false,
      amiliked: 0,
      likedpeople: [],
      likeCount: 0,
      ContentTime: "",
      ReplyTime: [],
      feedDetailContents: [],
      comments: [],
      detailFeedsnsNo: "",
      commentContent: "",
    };
  },
  methods: {
    likesCountCheck() {
      axios
        .get(`${SERVER_URL}/sns/likecount/${this.detailFeedsnsNo}/`)
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
    likedCheck() {
      axios
        .get(`${SERVER_URL}/sns/like/${this.$store.state.userList.userNo}`)
        .then((res) => {
          // console.log("좋아요했는지 체크", res);
          // 좋아요 한 사람들 리스트
          // console.log(res);
          for (let i = 0; i < res.data.like.length; i++) {
            if (res.data.like[i].snsNo == this.detailFeedsnsNo) {
              this.amiliked = 1;
            }
          }
        });
    },
    giveHeart() {
      axios({
        method: "post",
        url: `${SERVER_URL}/sns/like/${this.detailFeedsnsNo}/${this.$store.state.userList.userNo}`,
      })
        .then((res) => {
          console.log("찍히나", res);
          this.amiliked = 1;
          this.likeCount += 1;
        })
        .catch((err) => {
          console.log(err);
        });
    },
    cancelHeart() {
      axios({
        method: "delete",
        url: `${SERVER_URL}/sns/like/${this.detailFeedsnsNo}/${this.$store.state.userList.userNo}`,
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
          (this.my_comment.snsNo = this.detailFeedsnsNo),
            axios({
              method: "post",
              url: `${SERVER_URL}/sns/reply`,
              data: this.my_comment,
            })
              .then(() => {
                this.my_comment.snsReplyContent = null;
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
    deleteComment(comment) {
      console.log("요거", comment);
      axios({
        method: "delete",
        // 맨 뒤에 2를 현재 내 usernumber로 바꿔줄 예정

        url: `${SERVER_URL}/sns/reply/${comment.snsReplyNo}
      `,
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
    snsComments() {
      this.comments = [];
      this.ReplyTime = [];

      axios
        .get(`${SERVER_URL}/sns/reply/${this.detailFeedsnsNo}`)
        .then((res) => {
          if (res.data.list.length > 0) {
            for (let i = 0; i < res.data.list.length; i++) {
              this.comments.unshift(res.data.list[i]);
              this.ReplyTime.unshift(
                this.calculatedReplyTime(res.data.list[i].snsReplyCreateTime)
              );
            }
          }
        })
        .catch((err) => {
          console.log(err);
        });
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
  },

  created: function () {
    if (this.$store.state.userEmail == null) {
      alert("로그인이 필요한 서비스입니다.");
      this.$router.push({ name: "Login" });
    }
    // console.log("뭐냐", this.feed);
    this.detailFeedsnsNo = this.$route.params.snsNo;
    this.my_comment.userNo = this.$store.state.userList.userNo;
    this.likedCheck();
    this.likesCountCheck();
    this.snsComments();

    // console.log(this.$store.state.userList.userNo);

    // 디테일한 내용을 가져오기 위하여
    axios
      .get(`${SERVER_URL}/sns/${this.detailFeedsnsNo}`)
      .then((res) => {
        console.log("뭐고!!!!!!!!!!", res);
        this.feedDetailContents = res.data.dto;
        this.$store.dispatch("toDetail", res.data.dto);
        this.ContentTime = this.calculatedContentTime(
          res.data.dto.snsCreateTime
        );
        // if (res.data.dto.snsUpdateTime) {
        //   this.ContentTime = this.calculatedContentTime(
        //     res.data.dto.snsUpdateTime
        //   );
        // }
        // 댓글 창 보기
        this.comments = [];
        this.ReplyTime = [];
        if (res.data.dto.replyList.length > 0) {
          for (let i = 0; i < res.data.dto.replyList.length; i++) {
            this.comments.unshift(res.data.dto.replyList[i]);
            this.ReplyTime.unshift(
              this.calculatedReplyTime(
                res.data.dto.replyList[i].snsReplyCreateTime
              )
            );
          }
        }
      })
      .catch((err) => {
        console.log(err);
      })

      .catch((err) => {
        console.log(err);
        alert("실패하였습니다.");
      });
  },
  computed: {
    ...mapState(["userList"]),
  },
};
</script>

<style>
.bi-heart-fill {
  color: rgb(237, 73, 86);
  fill: rgb(237, 73, 86);
  height: 24;
  width: 24;
}
/* 574픽셀부터는 사진 외 내용이 밑으로 가므로 top공백을 없애주기 위해서 feeddetailtotal 프레임에 css걸어줌 */
@media (max-width: 768px) {
}
@media (min-width: 768px) {
  .FeedDetailTotal {
    width: calc(100% - 40px);
    /* height: calc(100% - 40px); */
    /* height: 80%; */
    margin: auto;

    /* height: 100%; */
  }
  .FeedDetail {
    width: 96vw;
    height: 95vh;
    /* border: 1px#000000; */
    /* background-color: rgba(0, 0, 0, 0.85); */
  }
  .FeedDetailTotalFrame {
    margin: auto;
    width: calc(100% - 40px);
    /* width: 80%; */
    /* height: 80%; */
    margin-top: 2%;
    /* align-items: center; */
    /* border-radius: 15px; */
    height: calc(80% - 40px);
  }
  .feedDetailContentsFrame {
    display: flex;
    flex-direction: row;
    /* flex: wrap; */
    min-height: 430px;
    width: calc(100% - 40px);
    margin: auto;
    margin-top: 5%;
    height: calc(100% - 40px);
    /* max-height: 00px; */
    max-width: 935px;
    /* max-width: */
    background-color: #ffff;
    border-radius: 20px;
    border: 1px solid #eee;
  }
  .FeedDetail-Leftbox {
    /* background-color: greenyellow; */
    /* border: 1px solid #eee; */
    /* min-height: 300px; */
    /* max-width: 450px; */
    display: flex;
    justify-content: center;
    align-items: center;
    flex: 1;
    min-width: 50%;
    max-width: 600px;

    flex-grow: 1;
    /* align-self: center; */

    /* align-self: stretch; */

    /* height: 100%; */
    /* width: 100%; */
  }

  .FeedDetail-RightBox {
    display: flex;
    flex-direction: column;
    flex-grow: 1;
    flex-shrink: 1;
    max-width: 360px;
    /* max-height: 500px; */
    background-color: #ffff;

    /* border: 1px solid #eee; */
    /* width: 100%; */
  }
  .FeedDetail-RightBox-ContentBox {
    /* flex-grow: 1; */
    /* flex-shrink: 1; */
    /* flex: 1; */
  }
  .FeedDetail-WriteComment {
    font-size: 12px;
  }
  .FeedDetailContent {
    font-size: 14px;
  }
  .FeedDetailContent .calculatedTime {
    font-size: 10px;
  }
  .FeedDetailUserCommentName {
    max-width: 60px;
    font-size: 12px;
    /* text-overflow: ellipsis; */
    overflow: hidden;
  }
  .leaveCommentButton {
    font-size: 6px;
  }
}

.FeedDetail {
  width: 100vw;
  height: 100vh;
  border: 1px#000000;
  /* background-color: rgba(0, 0, 0, 0.85); */
}
/* .FeedDetailTotal {
  width: 100%;
  height: 100%;
} */

.feedDetailContentsFrame {
  /* border-bottom: 1px solid #eee; */
  max-width: 960px;
  border-radius: 20px;

  /* background-color: bisque; */
}
.FeedDetail-Leftbox {
  /* background-color: greenyellow; */
  /* border: 1px solid #eee; */
  /* min-height: 300px; */
  /* height: 100%; */
  width: 100%;
}
.FeedDetail-Leftbox-Image {
  width: 100%;
}
.feed-detail-carousel {
  width: 100%;
  height: 100%;
}
.FeedDetail-RightBox {
  /* flex-grow: 1; */
  /* max-height: 500px; */
  min-height: 300px;
  background: #fff;
  border-left: 1px solid #eee;
  /* width: 100%; */
}
.FeedDetail-RightBox-ProfileBox {
  width: 100%;
  /* height: 100px; */

  /* height: 20%; */
  /* flex: 1; */
  border-bottom: 1px solid #eee;
}
.FeedDetail-RightBox-ContentBox {
  /* flex-shrink: 1;
  flex-grow: 1; */
  min-height: 135px;
  max-height: 135px;
  overflow: auto;
  flex-grow: 1;

  border-bottom: 1px solid #eee;
  /* 스크롤바 감추기 */
  -ms-overflow-style: none;
  scrollbar-width: none;
  /* flex: 1; */
}
.FeedDetail-RightBox-ContentBox::-webkit-scrollbar {
  display: none;
}
.FeedDetail-RightBox-CommentBox {
  height: 120px;
  /* flex-grow: 2; */
  /* flex: 2; */
  overflow: auto;
  -ms-overflow-style: none;
  scrollbar-width: none;

  /* flex: 1; */
}
.FeedDetail-RightBox-CommentBox ::-webkit-scrollbar {
  display: none;
}
.FeedDetail-RightBox-CommentBoxDetail {
  /* border-bottom: 1px solid #eee; */
  font-size: 12px;
  /* flex: 1; */
}

.FeedDetail-RightBox-ButtonBox {
  /* border-radius: 15px; */
  /* flex-grow: 2; */
}

.FeedDetail-RightBox-ProfileBox-UserInfo {
  height: 100%;
  width: 100%;
}
.FeedDetail-user-profile-image {
  border-radius: 50%;
  margin: 0px 20px 0px 0px;
  align-self: center;
  height: 35px;
  width: 35px;
  /* min-height: 20px;
  min-width: 20px;
  max-width: 42px;
  max-height: 42px; */
}
.user-comment-profile-image {
  /* display: inline-block; */
  border-radius: 50%;
  margin: 0px 10px 0px 0px;
  width: 25px;
  height: 25px;
  cursor: pointer;
}
.FeedDetail-Rightbox-Commentinputbox {
  /* border-top: 1px solid#eee; */
  border-top: 1px solid #eee;
  border-bottom: 1px solid #eee;
  font-size: 12px;
}
.FeedDetail-WriteComment {
  border-top: 1px solid #eee;
}
.nothing {
  border-top: 1px solid #eee;
  min-height: 30px;
  max-height: 200px;
}
.replytime {
  font-size: 6px;
  color: grey;
  overflow: auto;
}
.calculatedTime {
  font-size: 10px;
  color: grey;
}
.commentUserNickname {
  font-size: 11px;
}
.FeedDetail-ProfileBox-Username {
  font-size: 12px;
}
.bi-x {
  cursor: pointer;
  transition: 0.5s ease;
}
.bi-x :hover {
  /* display: */
  opacity: 0;
}
</style>
