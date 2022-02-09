<template>
  <div class="FeedDetail">
    <div class="FeedDetailTotal">
      <div class="FeedDetailTotalFrame">
        <div
          class="feedDetailContentsFrame d-flex justify-content-center align-items-center flex-wrap align-items-stretch"
        >
          <div
            class="FeedDetail-Leftbox col-12 col-sm-7 col-md-7 col-lg-7 col-xl-7 col-xxl-7 d-flex flex-column align-self-center"
          >
            <div class="">
              <feed-detail-carousel
                class="feed-detail-carousel d-flex"
                :imageList="feedDetailContents"
              ></feed-detail-carousel>
            </div>
          </div>
          <div class="FeedDetail-RightBox col d-flex flex-column">
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
                    class="FeedDetail-ProfileBox-Username py-4 fs-6 fw-bold"
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
              <div class="fs-6" style="overflow: auto">
                {{ this.feedDetailContents.snsContent }}
              </div>
            </div>

            <div
              class="FeedDetail-RightBox-ButtonBox d-flex justify-content-around fs-4 py-3"
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
            <b-collapse id="comment" v-model="visible">
              <div
                class="collapsed-comment d-flex justify-content-around align-items-center"
              >
                <div class="my-auto col-12">
                  <div class="form-floating">
                    <div
                      v-for="(comment, i) in this.comments"
                      :key="i"
                      :comment="comment"
                    >
                      <div v-if="this.comments">
                        <div
                          class="d-flex px-2 justify-content-between align-items-center"
                        >
                          <div
                            class="d-flex justify-content-start align-items-center ms-1 col-10"
                          >
                            <img
                              :src="`${comment.userProfileImage}`"
                              alt=""
                              class="user-comment-profile-image ms-2"
                            />
                            <div class="fw-bold">
                              {{ comment.userNickname }}
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
                          <div class="col" style="overflow: auto">
                            {{ comment.snsReplyCreateTime }}
                          </div>
                        </div>
                      </div>
                    </div>
                    <div
                      class="FeedDetail-Rightbox-Commentinputbox d-flex justify-content-center align-items-center col-12"
                    >
                      <img
                        :src="`${this.$store.state.userList.userProfileImage}`"
                        alt=""
                        class="user-comment-profile-image m-3"
                      />

                      <div class="fw-bold me-2">
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
                      <p
                        @click="leaveComment"
                        class="btn-sm btn-outline-transparent text-primary m-2"
                        type="button"
                        id="commentcontent"
                      >
                        게시
                      </p>
                    </div>
                  </div>
                </div>
              </div>
            </b-collapse>
            <div class="nothing"></div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
const SERVER_URL = `http://i6e102.p.ssafy.io:8080`;
// const SERVER_URL = "http://localhost:8080";

import { mapState } from "vuex";
import axios from "axios";

import FeedDetailCarousel from "../../components/feed/feeddetailitems/FeedDetailCarousel.vue";
import FeedDetailDropdown from "../../components/feed/feeddetailitems/FeedDetailDropdown.vue";

export default {
  name: "FeedDetail",
  components: {
    FeedDetailCarousel,
    FeedDetailDropdown,
  },
  props: {
    feed: Object,
  },
  data() {
    return {
      my_comment: {
        snsReplyContent: "",
        userNo: this.$store.state.userList.userNo,
        snsNo: this.detailFeedsnsNo,
      },
      visible: true,
      amiliked: 0,
      likedpeople: [],
      likeCount: 0,

      feedDetailContents: "",
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
    giveHeart: function () {
      axios({
        method: "post",
        url: `${SERVER_URL}/sns/like/${this.detailFeedsnsNo}/${this.$store.state.userList.userNo}`,
      })
        .then(() => {
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
    snsComments() {
      this.comments = [];
      axios
        .get(`${SERVER_URL}/sns/reply/${this.detailFeedsnsNo}`)
        .then((res) => {
          // console.log(res);
          if (res.data.list.length > 0) {
            for (let i = 0; i < res.data.list.length; i++) {
              this.comments.unshift(res.data.list[i]);
            }
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },

  created: function () {
    console.log(this.feed);
    this.detailFeedsnsNo = this.$route.params.snsNo;
    this.my_comment.userNo = this.$store.state.userList.userNo;
    this.likedCheck();
    this.likesCountCheck();
    this.snsComments;
    // console.log(this.$store.state.userList.userNo);

    // 디테일한 내용을 가져오기 위하여
    axios
      .get(`${SERVER_URL}/sns/${this.detailFeedsnsNo}`)
      .then((res) => {
        this.feedDetailContents = res.data.dto;
        this.$store.dispatch("toDetail", res.data.dto);

        // 댓글 창 보기
        if (res.data.dto.replyList.length > 0) {
          for (let i = 0; i < res.data.dto.replyList.length; i++) {
            this.comments.unshift(res.data.dto.replyList[i]);
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
/* 574픽셀부터는 사진 외 내용이 밑으로 가므로 top공백을 없애주기 위해서 feeddetailtotal 프레임에 css걸어줌 */

@media (min-width: 574px) {
  .FeedDetailTotal {
    width: 100%;
    height: 100%;
  }
  .FeedDetail {
    width: 96vw;
    height: 95vh;
    border: 1px#000000;
    /* background-color: rgba(0, 0, 0, 0.85); */
  }
  .FeedDetailTotalFrame {
    margin: auto;
    width: 80%;
    /* height: 80%; */
    margin-top: 2%;
    border-radius: 15px;
  }
  .feedDetailContentsFrame {
    width: 100%;
    background-color: #ffff;
    border-radius: 15px;
    border: 1px solid #eee;
  }
}
@media (max-width: 574px) {
  .FeedDetailTotalFrame {
    margin: auto;
    width: 100%;
    height: 100%;
    border-radius: 15px;
  }
  .feedDetailContentsFrame {
    width: 100%;
    background-color: #ffff;
    height: 100%;
    border-radius: 15px;
    border: 1px solid #eee;
  }

  .FeedDetail-RightBox-CommentBox {
    display: none;
  }
  .FeedDetail-RightBox-Textarea {
    flex: 1;
  }
  .FeedDetail-RightBox-ProfileBox {
    width: 100%;
    height: 100px;
    /* flex: 1; */
    border-bottom: 1px solid #eee;
  }
  .FeedDetail-RightBox-ContentBox {
    /* flex-shrink: 1;
  flex-grow: 1; */
    border-bottom: 1px solid #eee;
    flex: 3;
  }
  .FeedDetail-RightBox-ButtonBox {
    border-bottom: 1px solid #eee;
    /* flex-grow: 2; */
    flex: 1;
  }

  /* .FeedDetail-RightBox-Textarea {
    display: none;
  } */
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
  border-bottom: 1px solid #eee;
  /* background-color: bisque; */
}
.FeedDetail-Leftbox {
  /* background-color: greenyellow; */
  border: 1px solid #eee;
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
  min-height: 300px;

  border: 1px solid #eee;
  /* width: 100%; */
}
.FeedDetail-RightBox-ProfileBox {
  width: 100%;
  height: 100px;

  /* height: 20%; */
  /* flex: 1; */
  border-bottom: 1px solid #eee;
}
.FeedDetail-RightBox-ContentBox {
  /* flex-shrink: 1;
  flex-grow: 1; */
  border-bottom: 1px solid #eee;
  flex: 1.1;
}
.FeedDetail-RightBox-CommentBox {
  border-bottom: 1px solid #eee;
  flex: 3;
}
.FeedDetail-RightBox-ButtonBox {
  border-bottom: 1px solid #eee;
  /* flex-grow: 2; */
}

.FeedDetail-RightBox-ProfileBox-UserInfo {
  height: 100%;
  width: 100%;
}
.FeedDetail-user-profile-image {
  border-radius: 50%;
  margin: 0px 20px 0px 0px;
  max-width: 42px;
  max-height: 42px;
}
.user-comment-profile-image {
  /* display: inline-block; */
  border-radius: 50%;
  margin: 0px 20px 0px 0px;
  width: 30px;
  height: 30px;
  cursor: pointer;
}
.FeedDetail-Rightbox-Commentinputbox {
  border-top: 1px solid#eee;
}
.FeedDetail-WriteComment {
  border-top: 1px solid #eee;
}
.nothing {
  border-top: 1px solid #eee;
  min-height: 30px;
  max-height: 200px;
}
</style>
