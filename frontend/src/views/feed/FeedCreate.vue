<template>
  <div
    class="FeedCreate-TotalFrame d-flex flex-row justify-content-center align-items-start"
  >
    <router-link :to="{ name: 'FeedList' }"
      ><i class="bi bi-x-lg fs-2"></i
    ></router-link>
    <div class="FeedCreate-Frame">
      <!-- 작성 게시글 타이틀 -->
      <div class="d-flex justify-content-between FeedCreate-title py-2">
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
      <div class="FeedCreate-contentbox d-flex ">
        <!-- 이미지 업로드 -->

        <div class="FeedCreate-leftbox">
          <!-- carousel로 바꾸기 -->
          <div
            v-if="feedCreateContent.imageList.length > 0"
            class="d-flex justify-content-center align-items-center"
          >
            <div class="FeedCreate-contentbox-UploadImgFrame">
              <feed-create-carousel class="feed-create-carousel"
                :imageList="feedCreateContent"
              ></feed-create-carousel>
              <!-- <img
                v-for="(image, index) in feedCreateContent.imageList"
                :key="index"
                :src="`${feedCreateContent.imageList[index]}`"
                alt=""
                class="FeedCreate-UploadImage"
              /> -->
              <!-- 업로드 사진 취소 마크 -->
              <div>
                <i class="bi bi-x-circle fs-4" @click="cancelUploadImage"></i>
              </div>
            </div>
          </div>
          <!-- 이미지 업로드 없다면 업로드 -->
          <form v-else align="left" method="post" enctype="multipart/form-data">
            <input
              ref="image"
              @change="uploadImg"
              type="file"
              multiple="multiple"
              id="chooseFile"
              name="chooseFile"
              accept="image/*"
            />
          </form>
        </div>
        <div class="FeedCreate-rightbox">
          <div class="FeedCreate-item2 d-flex my-2">
            <div class="FeedCreate-user-feed-card">
              <div class="d-flex align-items-center">
                <div class="d-flex justify-content-center">
                  <img
                    :src="`${{ myProfileimageurl }}`"
                    class="FeedCreate-user-profile-image"
                    alt="..."
                  />
                </div>
                <div class="FeedCreate-user-profile-username fs-5">
                  <!-- {{ feed.first_name }} -->
                </div>
                <div class="FeedCreate-user-feed-alert fw-bold">
                  {{ nickname }}
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
const SERVER_URL = `http://i6e102.p.ssafy.io`;

import axios from "axios";
import { mapState } from "vuex";
import FeedCreateCarousel from "../../components/feed/FeedCreateCarousel.vue";

// const SERVER_URL = process.env.VUE_APP_SERVER_URL;
// import { ValidationProvider } from "vee-validate"

export default {
  name: "FeedCreate",
  components: {
    FeedCreateCarousel,
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
        imageList: [],
        snsContent: "",
        userNo: this.$store.state.myNum,
      },
    };
  },
  methods: {
    uploadImg() {
      // var image = this.$refs["image"].files[0];
      // // console.log(image);
      // const url = URL.createObjectURL(image);
      // this.image = url;
      // console.log(url);
      // console.log(this.$refs["image"].files.length);

      // 업로드하기 위해 올린 파일 길이를 인덱스로
      for (let i = 0; i < this.$refs["image"].files.length; i++) {
        // url 주소를 각 이미지별로 생성해서
        let url = URL.createObjectURL(this.$refs["image"].files[i]);
        // imageList 폴더에 넣어둠

        this.feedCreateContent.imageList.push(url);
        // console.log(this.feedCreateContent.imageList[0]);
        // axios({
        //   method: "post",
        //   url: "",
        // }).then((res) => {
        //   this.$store.dispatch("uploadimages", res.data.id);
        // });
      }
      // this.$refs.image.value = "";

      // imageList.push(this.$refs["image"].files[i]);
      // console.log(imageList);
    },
    cancelUploadImage() {
      // console.log('안녕');
      // console.log(this.$refs["image"]);
      // console.log(this.image);
      // console.log(this.imageList);

      // this.clearImage();
      this.feedCreateContent.imageList = []; // this.image = null;
      // this.imageList = null;
    },
    // clearImage() {
    //   this.uploadReady = false;
    //   this.$nextTick(() => {
    //     this.uploadReady = true;
    //   });
    // },
    CreateFeed() {
      console.log(this.feedCreateContent);
      if (
        this.feedCreateContent.snsContent &&
        this.feedCreateContent.imageList
      ) {
        if (
          // 문자열 양끝 공백 제거
          // feedCreateContent.images도 trim해야하는지확인해보자
          this.feedCreateContent.snsContent.trim()
        ) {
          axios({
            method: "post",
            // url도 받아오는대로 확인
            url: `${SERVER_URL}/sns/create`,
            // headers는 토큰 어떻게 하냐에 따라 달라질것
            // headers: this.$store.getters.config,
            data: this.feedCreateContent,
          })
            .then(() => {
              // console.log(res.data);
              this.$store.dispatch("toDetail", this.feed);
              this.$router.push({ name: "FeedDetail" });
            })
            .catch((err) => {
              console.log(err);
              alert("실패하였습니다.");
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
    ...mapState(["myNum"]),
    ...mapState(["nickname"]),
    ...mapState(["myProfileimageurl"]),
  },
  // 제출했을때
};
</script>

<style scoped>
@media (min-width: 574px) {
  .FeedCreate-contentbox {
    max-width:800px
  /* flex-wrap: wrap; */
/* min-width: 400px; */
/* } */
  }}
  @media (max-width: 574px) {
    .FeedCreate-contentbox {
  flex-wrap: wrap;
/* min-width: 400px; */
/* } */}
  }
.FeedCreate-TotalFrame {
  height: 100vh;
  background-color: rgba(0, 0, 0, 0.85);
  /* width: 768px; */
  /* padding: 0 20px; */
  /* background: beige; */
}
.FeedCreate-Frame {
  /* height: 60vh; */
  width: 768px;
  position: relative;
  height: 100%;
  /* padding: 10px; */
  margin: auto;
  /* padding-top: 10%; */
  /* padding-top: 10%; */
}
.FeedCreate-title {
  background-color: #ffff;
  border-top-left-radius: 5px;
  border-top-right-radius: 5px;
  /* min-width: 400px; */

  border: 1px solid #dbdbdb;
}

.FeedCreate-leftbox {
  border: 1px solid #dbdbdb;
  border-radius: 3px;
  /* min-height: 400px; */
  max-width: 460px;
  background-color: #ffff;
  padding: 10px;
    flex-grow: 1;

}
.feed-create-carousel{
  width:100%;
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
.FeedCreate-contentbox-UploadImgFrame {
  position: relative;
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
.bi-x-circle {
  position: absolute;
  z-index: 100;
  top: 2%;
  right: 2%;
}
.bi-x-lg {
  position: absolute;
  /* z-index: auto; */
  right: 5%;
  top: 5%;
  color: white; /* z-index: 100; */
  /* position: absolute; */
  /* top: 0%; */
}
</style>
