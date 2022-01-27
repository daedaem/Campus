<template>
  <div class="Detail">
    <div
      class="FeedDetailTotal d-flex justify-content-center align-items-center"
    >
      <div class="FeedDetailTotalFrame">
        <div
          class="FeedDetailContentsFrame d-flex justify-content-center align-items-center flex-wrap align-items-stretch"
        >
          <div
            class="FeedDetail-Leftbox col-12 col-sm-7 col-md-7 col-lg-7 col-xl-7 col-xxl-7 d-flex flex-column align-self-center"
          >
            <div>
              <img
                class="FeedDetail-Leftbox-Image"
                src="http://placehold.it/800x800"
                alt=""
              />
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
                  <img
                    src="http://placehold.it/800x800"
                    class="FeedDetail-user-profile-image"
                    alt="..."
                  />
                  <div class="FeedDetail-ProfileBox-Username py-4">
                    유저네임
                  </div>
                </div>
                <div
                  class="FeedDetail-ProfileBox-Dropdown d-flex flex-column justify-self-end align-self-start pe-2"
                >
                  <feed-detail-dropdown></feed-detail-dropdown>
                </div>
              </div>
            </div>
            <div class="FeedDetail-RightBox-ContentBox p-4">작성자 글 내용</div>
            <div class="FeedDetail-RightBox-CommentBox p-4">
              <div>댓글 내용</div>
            </div>
            <div
              class="FeedDetail-RightBox-ButtonBox d-flex justify-content-around fs-4 py-3"
            >
              <!-- 밑에 삽입 예정 
          @click="[changedheart(), heartcount()]"-->
              <span
                class="heart-box d-flex my-auto"
                @click="changedheart(feed)"
                v-if="heartclick == 1"
              >
                <i class="bi bi-heart me-3"></i>
                <!-- <p class="fs-6 my-auto">{{ feed.likecount }}</p> -->
              </span>
              <span
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
                    <div class="d-flex">
                      <!-- 밑에 @keyup.enter="댓글 입력하는 함수실행" -->

                      <textarea
                        v-model="commentcontent"
                        id="commentcontent"
                        ref="textarea"
                        rows="1"
                        class="d-flex col-10 p-1"
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
import FeedDetailDropdown from "../../components/feed/FeedDetailDropdown.vue";
export default {
  name: "FeedDetail",
  components: {
    FeedDetailDropdown,
  },
  data() {
    return {
      commentcontent: [],
      visible: true,

      heartclick: 1,
      heartcount: 0,
    };
  },
  mehtods: {
    changedheart(feed) {
      if (this.heartclick > 0) {
        console.log(feed);
        this.heartclick = 0;
        this.$store.state.feeds[feed.id - 1].likecount += 1;
        // this.heartcount = this.$store.state.feeds[feed.id].likecount
      } else {
        this.heartclick = 1;
        this.$store.state.feeds[feed.id - 1].likecount -= 1;
        // this.heartcount = this.$store.state.feeds[feed.id].likecount
      }
      console.log(feed);
    },
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
}
@media (max-width: 574px) {
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
.FeedDetailTotalFrame {
  margin: auto;
  /* width: 90%; */
  /* height: 90%; */
  border-radius: 15px;
}
.FeedDetailContentsFrame {
  width: 100%;
  border-radius: 15px;
}

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

  background-color: #ffff;
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
