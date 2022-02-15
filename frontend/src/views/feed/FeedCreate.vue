<template>
  <div
    class="FeedCreate-TotalFrame d-flex flex-row justify-content-center align-items-start"
  >
    <!-- <router-link :to="{ name: 'FeedList' }"
      ><i class="bi bi-x-lg fs-2"></i
    ></router-link> -->
    <div class="FeedCreate-Frame">
      <!-- 작성 게시글 타이틀 -->
      <div class="d-flex justify-content-between FeedCreate-title py-2">
        <!-- <feed-create-modal></feed-create-modal> -->
        <router-link
          class="text-decoration-none text-black"
          :to="{ name: 'FeedList' }"
        >
          <i class="bi bi-arrow-left ps-3 fs-4"></i>
        </router-link>
        <div class="fs-5 fw-bold">새 게시글 작성</div>
        <p
          @click="CreateFeed"
          class="text-decoration-none fw-bold text-primary align-middle align-self-center pe-3"
        >
          업로드
        </p>
      </div>
      <div class="FeedCreate-contentbox d-flex">
        <!-- 이미지 업로드 -->

        <div
          class="FeedCreate-leftbox d-flex justify-content-center align-items-center"
        >
          <!-- carousel로 바꾸기 -->
          <div
            v-if="feedCreateImageList.ImageList.length > 0"
            class="FeedCreate-leftbox-contentBox-Frame d-flex justify-content-center align-items-center"
          >
            <div class="FeedCreate-contentbox-UploadImgFrame">
              <feed-create-carousel
                class="feed-create-carousel"
                :ImageList="feedCreateImageList"
              ></feed-create-carousel>
              <!-- <img
                v-for="(image, index) in feedCreateContent.imageList"
                :key="index"
                :src="`${feedCreateContent.imageList[index]}`"
                alt=""
                class="FeedCreate-UploadImage"
              /> -->
              <!-- 업로드 사진 취소 마크 -->
            </div>
          </div>
          <!-- 이미지 업로드 없다면 업로드 -->
          <div v-if="feedCreateImageList.ImageList.length == 0">
            <div>
              <!-- <i @click="uploadImg" class="bi bi-images"></i> -->
              <label for="fileName">
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  width="16"
                  height="16"
                  fill="currentColor"
                  class="bi bi-images"
                  viewBox="0 0 16 16"
                >
                  <path d="M4.502 9a1.5 1.5 0 1 0 0-3 1.5 1.5 0 0 0 0 3z" />
                  <path
                    d="M14.002 13a2 2 0 0 1-2 2h-10a2 2 0 0 1-2-2V5A2 2 0 0 1 2 3a2 2 0 0 1 2-2h10a2 2 0 0 1 2 2v8a2 2 0 0 1-1.998 2zM14 2H4a1 1 0 0 0-1 1h9.002a2 2 0 0 1 2 2v7A1 1 0 0 0 15 11V3a1 1 0 0 0-1-1zM2.002 4a1 1 0 0 0-1 1v8l2.646-2.354a.5.5 0 0 1 .63-.062l2.66 1.773 3.71-3.71a.5.5 0 0 1 .577-.094l1.777 1.947V5a1 1 0 0 0-1-1h-10z"
                  />
                </svg>
              </label>
              <form
                align="left"
                method="post"
                enctype="multipart/form-data"
                class="d-flex flex-column align-items-center"
              >
                <input
                  ref="image"
                  type="file"
                  multiple="multiple"
                  id="fileName"
                  accept="image/*"
                  @change="uploadImg"
                  style="display: none"
                />

                <p>클릭하여 사진을 첨부해주세요.</p>
                <!-- <i class="bi bi-images"></i> -->
              </form>
            </div>
          </div>
          <!-- <cropper
            class="cropper"
            :src="this.image"
            :stencil-props="{
              aspectRatio: 10 / 12,
            }"
            @change="change"
          /> -->

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
        <div class="FeedCreate-rightbox">
          <div class="FeedCreate-item2 d-flex my-2">
            <div class="FeedCreate-user-feed-card">
              <div class="d-flex align-items-center">
                <div class="d-flex justify-content-center">
                  <img
                    :src="`${userList.userProfileImage}`"
                    class="FeedCreate-user-profile-image"
                    alt="..."
                  />
                </div>
                <div class="FeedCreate-user-profile-username fs-5">
                  <!-- {{ feed.first_name }} -->
                </div>
                <div class="FeedCreate-user-feed-alert fw-bold">
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
                placeholder="&#10;당신의 캠핑을 공유해주세요.&#10;&#10; #캠핑"
                rows="8"
                v-model="feedCreateContent.snsContent"
              ></b-form-textarea>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
const SERVER_URL = process.env.VUE_APP_SERVER_URL;

// import { Cropper } from "vue-advanced-cropper";
// import "vue-advanced-cropper/dist/style.css";

import axios from "axios";
import { mapState } from "vuex";
import FeedCreateCarousel from "../../components/feed/FeedCreateCarousel.vue";
// import FeedCreateModal from "../../components/feed/FeedCreateModal.vue";

// import { ValidationProvider } from "vee-validate"

export default {
  name: "FeedCreate",
  components: {
    // Cropper,

    FeedCreateCarousel,
    // FeedCreateModal,
    // FeedCreateCarousel,
  },
  props: {
    feed: Object,
  },
  data() {
    return {
      // credentials: {
      //   "userNo": this.$store.state.myNum,
      //   nickname: "",
      //   email: "",
      //   password: "",
      // },
      feedCreateContent: {
        // imageList: [],
        snsContent: "",
        userNo: this.$store.state.myNum,
      },
      frm: "",
      feedCreateImageList: {
        ImageList: [],
      },
      nowfeed: "",
    };
  },
  methods: {
    change({ coordinates, canvas }) {
      console.log(coordinates, canvas);
    },
    uploadImg() {
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

      // 업로드하기 위해 올린 파일 길이를 인덱스로
      for (let i = 0; i < this.$refs["image"].files.length; i++) {
        // url 주소를 각 이미지별로 생성해서
        let url = URL.createObjectURL(this.$refs["image"].files[i]);
        //   // imageList 폴더에 넣어둠

        this.feedCreateImageList.ImageList.push(url);
      }
    },

    CreateFeed() {
      // console.log(this.feedCreateContent);
      // console.log(this.userList);
      // console.log(this.frm);
      // console.log(this.feedCreateContent);
      if (
        this.feedCreateContent.snsContent &&
        this.feedCreateImageList.ImageList
      ) {
        if (this.feedCreateContent.snsContent[0] == "#") {
          this.feedCreateContent.snsContent =
            "#" + this.feedCreateContent.snsContent.substr(1).trim();
          // console.log("된건가", this.inputData);
        }
        if (
          // 문자열 양끝 공백 제거
          // feedCreateContent.images도 trim해야하는지확인해보자
          this.feedCreateContent.snsContent.trim()
        ) {
          axios({
            method: "post",
            url: `${SERVER_URL}/sns/create`,
            data: this.feedCreateContent,
          })
            .then((res) => {
              this.datas = res.data.dto;
              this.nowfeed = res.data.dto.snsNo;
              axios({
                method: "post",
                url: `${SERVER_URL}/sns/create/${res.data.dto.snsNo}`,
                headers: { "content-type": "multipart/form-data" },
                data: this.frm,
              })
                .then((res) => {
                  this.$store.dispatch("toDetail", this.nowfeed);
                  this.$router.push({
                    name: "FeedDetail",
                    params: {
                      snsNo: this.nowfeed,
                      // data: this.nowfeed,
                    },
                    data: {
                      ImageList: res.data.ImageList,
                    },
                  });
                })
                .then((res) => {
                  console.log(res);
                })
                .catch((err) => {
                  console.log(err);
                  alert("실패하였습니다.");
                });
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
        } else {
          alert(`There's an empty box`);
        }
      } else {
        alert(`There's an empty box`);
      }
    },
  },
  computed: {
    ...mapState(["userList"]),
  },
  // 제출했을때
};
</script>

<style scoped>
@media (min-width: 574px) {
  .FeedCreate-contentbox {
    max-width: 800px;
    /* flex-wrap: wrap; */
    /* min-width: 400px; */
    /* } */
  }
  .FeedCreate-Frame {
    /* height: 60vh; */
    width: 768px;
    position: relative;
    height: 100%;
    /* padding: 10px; */
    margin: auto;
    /* padding-top: 10%; */
  }
  .FeedCreate-leftbox {
    border: 1px solid #dbdbdb;
    border-radius: 3px;
    min-height: 400px;
    max-width: 460px;
    background-color: #ffff;
    /* padding: 10px; */
    flex-grow: 1;
  }
}
@media (max-width: 574px) {
  .FeedCreate-contentbox {
    flex-wrap: wrap;
    /* min-width: 400px; */
    /* } */
  }
  .FeedCreate-Frame {
    /* height: 60vh; */
    width: 768px;
    position: relative;
    height: 100%;
    /* padding: 10px; */
    margin: auto;
    padding-top: 5%;
  }
  .FeedCreate-leftbox {
    border: 1px solid #dbdbdb;
    border-radius: 3px;
    min-height: 400px;
    /* max-width: 460px; */
    background-color: #ffff;
    /* padding: 10px; */
    flex-grow: 1;
  }
}
.navbar {
  display: none;
}
.FeedCreate-TotalFrame {
  height: 100vh;
  background-color: rgba(0, 0, 0, 0.85);
  padding-top: 5%;
  /* width: 768px; */
  /* padding: 0 20px; */
  /* background: beige; */
}

.FeedCreate-title {
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
.FeedCreate-rightbox {
  border: 1px solid #dbdbdb;
  border-radius: 3px;
  padding: 10px;
  flex-grow: 1;
  min-height: 400px;
  background-color: #ffff;
}
.FeedCreate-leftbox-contentBox-Frame {
  height: 100%;
}
.FeedCreate-contentbox-UploadImgFrame {
  position: relative;
  height: 100%;
}
.FeedCreate-textarea {
  overflow: auto;
  resize: vertical;
}
.FeedCreate-textarea::placeholder {
  color: #ffff;
  font-size: 0.5rem;
}
.FeedCreate-items {
  position: relative;
  padding: 1rem;
  margin: 1rem -15px 0;
  border-radius: 3px;
  border: 1px solid #dbdbdb;
}
.FeedCreate-UploadImage {
  /* width: 100%; */
  width: 360px;
  height: auto;
  /* height: 100%; */

  display: block;
}
.FeedCreate-user-profile-image {
  border-radius: 50%;
  margin: 0px 20px 0px 0px;
  width: 42px;
  height: 42px;
}
.bi-images {
  height: 250px;
  width: 250px;
}
/* .b-form-textarea {
  font: 14px;
} */
textarea::placeholder {
  color: grey;
  font-size: 14px;
}
/* .cropper {
  height: 600px;
  width: 600px;
  background: #ddd;
} */
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
