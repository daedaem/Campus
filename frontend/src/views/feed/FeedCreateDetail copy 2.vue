<template>
  <div
    class="FeedCreateDetail-TotalFrame d-flex flex-row justify-content-center align-items-start"
  >
    <div class="FeedCreateDetail-Frame">
      <!-- 작성 게시글 타이틀 -->
      <div class="d-flex justify-content-between FeedCreateDetail-title py-2">
        <router-link
          class="text-decoration-none text-black"
          :to="{ name: 'FeedList' }"
        >
          <i class="bi bi-arrow-left ps-3 fs-4"></i>
        </router-link>
        <div class="fs-5 fs-bold">새 게시글 작성</div>
        <router-link
          class="text-decoration-none fw-bold text-primary align-middle align-self-center pe-3"
          :to="{ name: 'FeedCreate' }"
          >업로드</router-link
        >
      </div>
      <div class="FeedCreateDetail-contentbox d-flex flex-wrap">
        <!-- 이미지 업로드 -->

        <div class="FeedCreateDetail-leftbox">
          <div
            v-if="image"
            class="d-flex justify-content-center align-items-center"
          >
            <div class="FeedCreateDetail-contentbox-UploadImgFrame">
              <img
                v-for="(image, index) in images"
                :key="index"
                :src="images[index]"
                alt=""
                class="FeedCreateDetail-UploadImage"
              />
              <!-- 업로드 사진 취소 마크 -->
              <div>
                <i class="bi bi-x-circle fs-4" @click="cancelUploadImage()"></i>
              </div>
            </div>
          </div>
          <!-- 이미지 업로드 없다면 업로드 -->
          <form v-else align="left" method="post" enctype="multipart/form-data">
            <input
              ref="image"
              @change="uploadImg()"
              type="file"
              multiple="multiple"
              id="chooseFile"
              name="chooseFile"
              accept="image/*"
            />
          </form>
        </div>
        <div class="FeedCreateDetail-rightbox">
          <div class="FeedCreateDetail-item2 d-flex my-2">
            <div class="FeedCreateDetail-user-feed-card">
              <div class="d-flex align-items-center">
                <div class="d-flex justify-content-center">
                  <img
                    :src="profileimage"
                    class="FeedCreateDetail-user-profile-image"
                    alt="..."
                  />
                </div>
                <div class="FeedCreateDetail-user-profile-username fs-5">
                  <!-- {{ feed.first_name }} -->
                </div>
                <div class="FeedCreateDetailuser-feed-alert">username</div>
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
              ></b-form-textarea>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
// import axios from "axios";

// const SERVER_URL = process.env.VUE_APP_SERVER_URL;
// import { ValidationProvider } from "vee-validate"

export default {
  name: "FeedCreateDetail",
  components: {
    // FeedCreateCarousel,
  },
  props: {
    feed: Object,
  },
  data() {
    return {
      credentials: {
        userId: "",
        nickname: "",
        email: "",
        password: "",
      },
      image: "",
      images: [],
      uploadReady: true,

      profileimage:
        "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png",
    };
  },
  methods: {
    uploadImg() {
      var image = this.$refs["image"].files[0];
      // console.log(image);
      const url = URL.createObjectURL(image);
      this.image = url;
      // console.log(url);
      // console.log(this.image);

      // 업로드하기 위해 올린 파일 길이를 인덱스로
      for (let i = 0; i < this.$refs["image"].files.length; i++) {
        // url 주소를 각 이미지별로 생성해서
        let url = URL.createObjectURL(this.$refs["image"].files[i]);
        // images 폴더에 넣어둠
        this.images.push(url);
        // axios({
        //   method: "post",
        //   url: "",
        // }).then((res) => {
        //   this.$store.dispatch("uploadimages", res.data.id);
        // });
      }
      // this.$refs.image.value = "";

      // images.push(this.$refs["image"].files[i]);
      // console.log(images);
    },
    cancelUploadImage() {
      // console.log(this.$refs["image"]);
      // console.log(this.image);
      // console.log(this.images);

      this.clearImage();
      this.$refs.image = null;
      // this.image = null;
      // this.images = null;
    },
    clearImage() {
      this.uploadReady = false;
      this.$nextTick(() => {
        this.uploadReady = true;
      });
    },
  },
  // 제출했을때
};
</script>

<style scoped>
.FeedCreateDetail-TotalFrame {
  height: 100vh;
  /* width: 768px; */
  /* padding: 0 20px; */
  /* background: beige; */
}
.FeedCreateDetail-Frame {
  /* height: 60vh; */
  width: 768px;
  position: relative;
  height: auto;
  top: 5%;
}
.FeedCreateDetail-title {
  background-color: #ffff;
  border-top-left-radius: 5px;
  border-top-right-radius: 5px;
  /* min-width: 400px; */

  border: 1px solid #dbdbdb;
}
/* .FeedCreateDetail-contentbox { */
/* min-width: 400px; */
/* } */
.FeedCreateDetail-leftbox {
  border: 1px solid #dbdbdb;
  border-radius: 3px;
  min-height: 400px;
  background-color: #ffff;
  padding: 10px;
  flex-grow: 1;
}
.FeedCreateDetail-rightbox {
  border: 1px solid #dbdbdb;
  border-radius: 3px;
  padding: 10px;
  flex-grow: 1;
  min-height: 400px;
  background-color: #ffff;
}
.FeedCreateDetail-contentbox-UploadImgFrame {
  position: relative;
}
.FeedCreateDetail-textarea {
  overflow: auto;
  resize: vertical;
}
.FeedCreateDetail-textarea::placeholder {
  color: #ffff;
  font-size: 0.5rem;
}
.FeedCreateDetail-items {
  position: relative;
  padding: 1rem;
  margin: 1rem -15px 0;
  border-radius: 3px;
  border: 1px solid #dbdbdb;
}
.FeedCreateDetail-UploadImage {
  /* width: 100%; */
  width: 360px;
  height: auto;
  /* height: 100%; */

  display: block;
}
.FeedCreateDetail-user-profile-image {
  border-radius: 50%;
  margin: 0px 20px 0px 0px;
  width: 42px;
  height: 42px;
}
.bi-x-circle {
  position: absolute;
  z-index: auto;
  top: 2%;
  right: 2%;
}
</style>
