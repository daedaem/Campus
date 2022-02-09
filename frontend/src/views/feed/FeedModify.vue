<template>
  <div
    class="FeedModify-TotalFrame d-flex flex-row justify-content-center align-items-start"
  >
    <!-- <router-link :to="{ name: 'FeedList' }"
      ><i class="bi bi-x-lg fs-2"></i
    ></router-link> -->
    <div class="FeedModify-Frame">
      <!-- 작성 게시글 타이틀 -->
      <div
        class="d-flex justify-content-between align-items-center FeedModify-title py-2"
      >
        <!-- <feed-create-modal></feed-create-modal> -->
        <router-link
          class="text-decoration-none text-black"
          :to="{ name: 'FeedList' }"
        >
          <i class="bi bi-arrow-left ps-3 fs-4"></i>
        </router-link>
        <div class="fs-5 fw-bold">게시글 수정</div>
        <p
          @click="ModifyFeed"
          class="text-decoration-none fw-bold text-primary align-middle align-self-center pe-3"
        >
          완료
        </p>
      </div>
      <div class="FeedModify-contentbox d-flex">
        <!-- 이미지 업로드 -->

        <div class="FeedModify-leftbox">
          <!-- carousel로 바꾸기 -->
          <div
            v-if="feedModifyImageList.imageList.length > 0"
            class="d-flex justify-content-center align-items-center"
          >
            <div class="FeedModify-contentbox-UploadImgFrame">
              <feed-modify-carousel
                class="feed-create-carousel"
                :feedModifyImageList="feedModifyImageList"
              ></feed-modify-carousel>
              <!-- <img
                v-for="(image, index) in feedModifyContent.imageList"
                :key="index"
                :src="`${feedModifyContent.imageList[index]}`"
                alt=""
                class="FeedModify-UploadImage"
              /> -->
              <!-- 업로드 사진 취소 마크 -->
            </div>
          </div>
          <!-- 이미지 업로드 없다면 업로드 -->
          <form v-else align="left" method="post" enctype="multipart/form-data">
            <input
              ref="image"
              type="file"
              multiple="multiple"
              id="fileName"
              accept="image/*"
              @change="uploadImg"
            />
          </form>

          <!-- <form v-else align="left" method="post" enctype="multipart/form-data">
            <input
              ref="image"
              @change="uploadImg"
              type="file"
              multiple="multiple"
              id="chooseFile"
              name="chooseFile"
              accept="image/*"
            />
          </form> -->
        </div>
        <div class="FeedModify-rightbox">
          <div class="FeedModify-item2 d-flex my-2">
            <div class="FeedModify-user-feed-card">
              <div class="d-flex align-items-center">
                <div class="d-flex justify-content-center">
                  <img
                    :src="`${userList.userProfileImage}`"
                    class="FeedModify-user-profile-image"
                    alt="..."
                  />
                </div>
                <div class="FeedModify-user-profile-username fs-5">
                  <!-- {{ feed.first_name }} -->
                </div>
                <div class="FeedModify-user-feed-alert fw-bold">
                  {{ userList.userNickname }}
                </div>
              </div>
            </div>
          </div>
          <!-- <div>
              <img src="" alt="프로필 사진" />
            </div>
            <p>닉네임</p>
          </div> -->
          <div class="form-floating">
            <div>
              <b-form-textarea
                id="textarea-rows"
                placeholder="당신의 캠프여정을 공유하세요."
                rows="8"
                v-model="feedModifyContent.snsContent"
              ></b-form-textarea>
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

import axios from "axios";
import { mapState } from "vuex";
import FeedModifyCarousel from "../../components/feed/FeedModifyCarousel.vue";
// import FeedCreateCarousel from "../../components/feed/FeedCreateCarousel.vue";
// import FeedDetailCarousel from "../../components/feed/feeddetailitems/FeedDetailCarousel.vue";
// import FeedCreateModal from "../../components/feed/FeedCreateModal.vue";

// const SERVER_URL = process.env.VUE_APP_SERVER_URL;
// import { ValidationProvider } from "vee-validate"

export default {
  name: "FeedModify",
  components: {
    FeedModifyCarousel,
    // FeedCreateCarousel,
    // FeedDetailCarousel,
    // FeedCreateModal,
    // FeedCreateCarousel,
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

      // credentials: {
      //   "userNo": this.$store.state.myNum,
      //   nickname: "",
      //   email: "",
      //   password: "",
      // },
      feedModifyContent: {
        // imageList: [],
        snsContent: "",
        userNo: this.$store.state.myNum,
      },
      frm: "",
      feedModifyImageList: {
        imageList: [],
      },
      nowfeed: "",
    };
  },
  methods: {
    uploadImg() {
      // console.log(this.feedModifyContent);
      // 전송용
      var frm = new FormData();
      var photoFile = document.getElementById("fileName");
      // console.log(photoFile.files);
      // frm.append("fileName", photoFile.files[0]);
      // console.log(merong);
      // console.log(2);
      // console.log(frm);
      var cnt = photoFile.files.length;
      for (var i = 0; i < cnt; i++) {
        frm.append("fileName", photoFile.files[i]);
      }
      this.frm = frm;
      // console.log(frm);

      // 업로드 이미지 확인
      var image = this.$refs["image"].files[0];
      // console.log(image);
      const url = URL.createObjectURL(image);
      this.image = url;
      // console.log(url);
      // console.log(this.$refs["image"].files.length);

      // console.log("드갔나", this.frm);
      // 업로드하기 위해 올린 파일 길이를 인덱스로
      for (let i = 0; i < this.$refs["image"].files.length; i++) {
        // url 주소를 각 이미지별로 생성해서
        let url = URL.createObjectURL(this.$refs["image"].files[i]);
        //   // imageList 폴더에 넣어둠
        this.feedModifyImageList.imageList.push(url);
      }
    },
    cancelUploadImage() {
      // console.log('안녕');
      // console.log(this.$refs["image"]);
      // console.log(this.image);
      // console.log(this.imageList);

      // this.clearImage();
      this.imageinfo = "";
      // this.imageinfo.imageList.splice(this.feedid, 1); // this.image = null;
      // this.imageList = null;
    },

    ModifyFeed() {
      // console.log(this.feedCreateContent);
      // console.log(this.userList);
      // console.log(this.frm);
      // console.log(this.feedCreateContent);
      if (!this.feedModifyContent.snsContent) {
        alert("작성된 글이 없습니다.");
      }
      if (!this.imageinfo && !this.frm) {
        alert("첨부된 이미지가 없습니다.");
      } else {
        if (
          // 문자열 양끝 공백 제거
          // feedModifyContent.images도 trim해야하는지확인해보자
          this.feedModifyContent.snsContent.trim()
        ) {
          // console.log("1", this.feedModifyContent.snsContent);
          // console.log("2", this.feedModifyContent);
          axios({
            method: "put",
            url: `${SERVER_URL}/sns/modify/${this.detailFeedsnsNo}`,
            data: this.feedModifyContent,
          })
            .then(() => {
              // console.log("소리찔러~", this.firm);
              // this.datas = res.data.dto;
              this.nowfeedNumber = this.detailFeedsnsNo;
              if (this.frm) {
                axios({
                  method: "put",
                  url: `${SERVER_URL}/sns/modifyImage/${this.detailFeedsnsNo}`,
                  headers: { "content-type": "multipart/form-data" },
                  data: this.frm,
                })
                  .then((res) => {
                    // routerpush, 글없으면 막기
                    // console.log("들어왔습니까", res);Qdk
                    this.$store.dispatch("toDetail", this.nowfeedNumber);
                    this.$router.push({
                      name: "FeedDetail",
                      params: {
                        snsNo: this.nowfeedNumber,
                        // data: this.nowfeed,
                      },
                      data: {
                        imageList: res.data.imageList,
                      },
                    });
                  })
                  .catch((err) => {
                    console.log(err);
                    alert("실패하였습니다.");
                  });
              } else {
                axios({
                  method: "put",
                  url: `${SERVER_URL}/sns/modify/${this.detailFeedsnsNo}`,
                  data: this.feedModifyContent,
                })
                  .then((res) => {
                    // routerpush, 글없으면 막기
                    // console.log("들어왔습니까", res);Qdk
                    this.$store.dispatch("toDetail", this.nowfeedNumber);
                    this.$router.push({
                      name: "FeedDetail",
                      params: {
                        snsNo: this.nowfeedNumber,
                        // data: this.nowfeed,
                      },
                      data: {
                        imageList: res.data.imageList,
                      },
                    });
                  })
                  .catch((err) => {
                    console.log(err);
                    alert("실패하였습니다.");
                  });
              }
              // else if (
              //   this.feedModifyImageList.imageList == [] &&
              //   this.firm == null
              // ) {
              //   alert("없습니다.");
              //   // axios({
              //   //   method: "put",
              //   //   url: `${SERVER_URL}/sns/modifyImage/${this.detailFeedsnsNo}`,
              //   //   headers: { "content-type": "multipart/form-data" },
              //   //   data: this.frm,
              //   // });
              // }
            })
            .then(() => {
              axios
                .get(`${SERVER_URL}/sns`)
                .then((res) => {
                  // console.log(res.data.list);
                  const data = res.data.list;
                  this.$store.dispatch("feedList", data);
                  // console.log(res);
                })
                .catch((err) => {
                  console.log(err);
                });
            });
        }
      }
    },
  },
  created: function () {
    // console.log(this.firm);

    // console.log(this.feedModifyContent);
    //
    // 라우터에 입력된 주소로 피드 넘버체크
    this.detailFeedsnsNo = this.$route.params.snsNo;

    // 디테일한 내용을 가져오기 위하여
    axios
      .get(`${SERVER_URL}/sns/${this.detailFeedsnsNo}`)
      .then((res) => {
        // console.log(res);
        this.feedModifyContent = res.data.dto;
        this.feedModifyImageList.imageList = res.data.dto.imageList;
        this.imageinfo = this.feedModifyImageList.imageList;

        this.$store.dispatch("toDetail", res.data.dto);
        console.log(this.feedModifyImageList);

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
  // updated: function () {},
  // mounted: function () {
  //   // this.ModifyFeed;
  // },
  // 제출했을때
};
</script>

<style scoped>
@media (min-width: 574px) {
  .FeedModify-contentbox {
    max-width: 800px;
    /* flex-wrap: wrap; */
    /* min-width: 400px; */
    /* } */
  }
  .FeedModify-Frame {
    /* height: 60vh; */
    width: 768px;
    position: relative;
    height: 100%;
    /* padding: 10px; */
    margin: auto;
    /* padding-top: 10%; */
  }
  .FeedModify-leftbox {
    border: 1px solid #dbdbdb;
    border-radius: 3px;
    min-height: 400px;
    max-width: 460px;
    background-color: #ffff;
    padding: 10px;
    flex-grow: 1;
  }
}
@media (max-width: 574px) {
  .FeedModify-contentbox {
    flex-wrap: wrap;
    /* min-width: 400px; */
    /* } */
  }
  .FeedModify-Frame {
    /* height: 60vh; */
    width: 768px;
    position: relative;
    height: 100%;
    /* padding: 10px; */
    margin: auto;
    padding-top: 5%;
  }
  .FeedModify-leftbox {
    border: 1px solid #dbdbdb;
    border-radius: 3px;
    min-height: 400px;
    /* max-width: 460px; */
    background-color: #ffff;
    padding: 10px;
    flex-grow: 1;
  }
}
.navbar {
  display: none;
}
.FeedModify-TotalFrame {
  height: 100vh;
  background-color: rgba(0, 0, 0, 0.85);
  padding-top: 5%;
  /* width: 768px; */
  /* padding: 0 20px; */
  /* background: beige; */
}

.FeedModify-title {
  background-color: #ffff;
  border-top-left-radius: 5px;
  border-top-right-radius: 5px;
  /* min-width: 400px; */

  border: 1px solid #dbdbdb;
}

.feed-create-carousel {
  width: 100%;
  /* height:100%; */
}
.FeedModify-rightbox {
  border: 1px solid #dbdbdb;
  border-radius: 3px;
  padding: 10px;
  flex-grow: 1;
  min-height: 400px;
  background-color: #ffff;
}
.FeedModify-contentbox-UploadImgFrame {
  position: relative;
}
.FeedModify-textarea {
  overflow: auto;
  resize: vertical;
}
.FeedModify-textarea::placeholder {
  color: #ffff;
  font-size: 0.5rem;
}
.FeedModify-items {
  position: relative;
  padding: 1rem;
  margin: 1rem -15px 0;
  border-radius: 3px;
  border: 1px solid #dbdbdb;
}
.FeedModify-UploadImage {
  /* width: 100%; */
  width: 360px;
  height: auto;
  /* height: 100%; */

  display: block;
}
.FeedModify-user-profile-image {
  border-radius: 50%;
  margin: 0px 20px 0px 0px;
  width: 42px;
  height: 42px;
}

/* .bi-x-lg {
  position: absolute;
  /* z-index: auto; */
/* right: 5%; */
/* top: 5%; */
/* color: white;  */
/* z-index: 100; */
/* position: absolute; */
/* top: 0%; */
/* } */
</style>
