<template>
  <div class="FeedDetail">
    <div class="FeedDetailTotal">
      <div class="FeedDetailTotalFrame">
        <div
          class="FeedDetailContentsFrame d-flex justify-content-center align-items-center flex-wrap align-items-stretch"
        >
          <div
            class="FeedDetail-Leftbox col-12 col-sm-7 col-md-7 col-lg-7 col-xl-7 col-xxl-7 d-flex flex-column align-self-center"
          >
            <div>
              <feed-detail-carousel
                class="FeedDetail-Leftbox-Image"
                v-bind:feed="this.feedDetailContents"
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
                  <!-- <img
                    style="cursor: pointer"
                    :src="`${this.feedDetailContents.userProfileImage}`"
                    class="FeedDetail-user-profile-image"
                    alt="..."
                  /> -->
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
                    v-bind:feed="this.feedDetailContents"
                  ></feed-detail-dropdown>
                </div>
              </div>
            </div>
            <div class="FeedDetail-RightBox-ContentBox text-start p-3">
              <div class="fs-6" style="overflow: auto">
                {{ this.feedDetailContents.snsContent }}
              </div>
            </div>
            <div class="FeedDetail-RightBox-CommentBox p-4">
              <div>
                <div
                  v-for="(comment, i) in this.comments"
                  :key="i"
                  :comment="comment"
                >
                  <div v-if="this.comments">
                    <div
                      class="d-flex justify-content-between align-items-center"
                    >
                      <div
                        class="d-flex justify-content-start align-items-center ms-3 mt-3 col-9"
                      >
                        <!-- <img
                          :src="`${comment.userProfileImage}`"
                          alt=""
                          class="user-comment-profile-image"
                        /> -->
                        <div class="fw-bold">
                          <!-- {{ comment.userNickname }} -->
                        </div>
                        <div
                          class="FeedListItems-commentContent col mx-3 text-start"
                          style="overflow: auto"
                        >
                          <!-- {{ comment.snsReplyContent }} -->
                        </div>
                      </div>
                      <div class="col" style="overflow: auto">
                        <!-- {{ comment.snsReplyCreateTime }} -->
                      </div>
                    </div>
                  </div>
                </div>
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
                @click="changedheart(feed)"
                v-if="heartclick == 1"
              >
                <i class="bi bi-heart me-3"></i>
                <!-- <p class="fs-6 my-auto">{{ feed.likecount }}</p> -->
              </span>
              <span
                style="cursor: pointer"
                class="heart-box d-flex my-auto"
                @click="changedheart(feed)"
                v-else
              >
                <i class="bi bi-heart-fill me-3"></i>
                <!-- <p class="fs-6 my-auto">{{ feed.likecount }}</p> -->
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
                <div class="my-auto col-10">
                  <div class="form-floating">
                    <div
                      class="d-flex justify-content-center align-items-center"
                    >
                      <!-- 밑에 @keyup.enter="댓글 입력하는 함수실행" -->

                      <textarea
                        v-model="commentcontent"
                        id="commentcontent"
                        ref="textarea"
                        rows="1"
                        class="d-flex col-10 p-1"
                        placeholder="댓글을 입력하세요"
                        style="overflow: auto"
                      >
                      </textarea>
                      <p
                        class="btn-sm btn-outline-transparent col-2 text-primary fs-6 me-1"
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
            <div class="FeedDetail-RightBox-Textarea p-4">
              <div class="form-floating">
                <div class="d-flex justify-content-center align-items-stretch">
                  <!-- 밑에 @keyup.enter="댓글 입력하는 함수실행" -->
                  <!-- <textarea
                    v-model="commentcontent"
                    id="commentcontent"
                    ref="textarea"
                    rows="1"
                    class="col-9"
                    placeholder="댓글을 입력하세요"
                  >
                  </textarea>
                  <button
                    class="btn btn-outline-secondary fs-6 ms-1"
                    type="button"
                    id="commentcontent"
                  >
                    게시
                  </button> -->
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
// const SERVER_URL = `http://i6e102.p.ssafy.io`;
const SERVER_URL = "http://localhost:8080";

// import { mapState } from "vuex";
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
      // feedinfo: this.feed,
      visible: true,
      heartclick: 1,
      heartcount: 0,
      feedDetailContents: "",
      snsReplyContent: "",
      comments: [],
      detailFeedsnsNo: "",
      commentContent: "",
    };
  },
  methods: {
    // changedheart(feed) {
    //   if (this.heartclick > 0) {
    //     // console.log(feed);
    //     this.heartclick = 0;
    //     this.$store.state.feeds[feed.id - 1].likecount += 1;
    //     // this.heartcount = this.$store.state.feeds[feed.id].likecount
    //   } else {
    //     this.heartclick = 1;
    //     this.$store.state.feeds[feed.id - 1].likecount -= 1;
    //     // this.heartcount = this.$store.state.feeds[feed.id].likecount
    //   }
    //   // console.log(feed);
    // },
    // detailsnsComments() {
    // axios
    //     .get(`${SERVER_URL}/sns/reply/${this.detailfeed.snsNo}`)
    //     .then((res) => {
    //       if (res.data.list.length > 0) {
    //         for (let i = 0; i < res.data.list.length; i++) {
    //           this.comments.unshift(res.data.list[i]);
    //           // console.log(this.comments);
    //         }
    //       }
    //       // console.log("snscomments", this.comments)}};
    //     })
    //     .catch((err) => {
    //       console.log(err);
    //     });
    // },
  },
  // mounted() {
  // },

  created: function () {
    // this.detailsnsComments();
    this.detailFeedsnsNo = this.$route.params.snsNo;
    console.log(this.detailFeedsnsNo);

    axios
      .get(`${SERVER_URL}/sns/${this.detailFeedsnsNo}`)
      .then((res) => {
        console.log(res.data.dto.replyList.length);
        this.feedDetailContents = res.data.dto;
        // 댓글 창 보기
        if (res.data.dto.replyList.length > 0) {
          for (let i = 0; i < res.data.dto.replyList.length; i++) {
            this.comments.unshift(res.data.dto.replyList[i]);
          }
        }
      })
      .catch((err) => {
        console.log(err);

        // console.log("이건", res);
        // console.log(this.detailfeed);
        // this.detailfeed = res;
        // console.log(this.detailfeed);
        // console.log(this.detailFeedsnsNo);
        // this.feedDetailContents = res.data.dto;
        // console.log(this.feedDetailContents);
        // if (res.data.rate) {
        //   this.currentRate = res.data.rate;
        //   this.ratingDone = 1;
        // }
      })
      // .then(() => )

      .catch((err) => {
        console.log(err);
        alert("실패하였습니다.");
      });
  },
  // computed: {
  //   ...mapState(["detailFeed"]),
  // },
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
  .FeedDetailContentsFrame {
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
  .FeedDetailContentsFrame {
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
    height: 20%;
    flex: 1;
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

.FeedDetailContentsFrame {
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
.FeedDetail-RightBox {
  /* flex-grow: 1; */
  min-height: 300px;

  border: 1px solid #eee;
  /* width: 100%; */
}
.FeedDetail-RightBox-ProfileBox {
  width: 100%;
  height: 20%;
  flex: 1;
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
  border: 3px solid;
}
</style>
