<template>
  <div
    class="FeedCreate-TotalFrame d-flex flex-column justify-content-center align-items-center"
  >
    <div class="FeedCreate-Frame">
      <!-- 작성 게시글 타이틀 -->
      <div class="d-flex justify-content-between FeedCreate-title py-2">
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
      <!-- 이미지 업로드 -->
      <div class="contentbox d-flex flex-wrap">
        <div class="leftbox">
          <div
            v-if="image"
            class="d-flex flex-column justify-content-center align-items-center"
          >
            <div class="FeedCreate-contentbox-UploadImgFrame">
              <img :src="image" alt="" class="FeedCreate-UploadImage" />
              <div>
                <i class="bi bi-x-circle fs-4"></i>
              </div>
              <div>
                <i class="bi bi-images fs-4"></i>
              </div>
            </div>
          </div>
          <!-- 이미지 업로드 없다면 업로드 -->
          <form
            v-else
            align="left"
            class="filterbox1"
            method="post"
            enctype="multipart/form-data"
          >
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

        <div class="rightbox d-flex flex-column">
          <div class="item2 d-flex my-2">
            <div
              class="p-2 user-feed-card d-flex justify-content-center align-items-center"
            >
              <div class="d-flex align-items-center">
                <div class="d-flex justify-content-center">
                  <img
                    :src="profileimage"
                    class="FeedCreate-user-profile-image"
                    alt="..."
                  />
                </div>
                <div class="FeedCreate-user-profile-username fs-5">
                  <!-- {{ feed.first_name }} -->
                </div>
                <div class="FeedCreateuser-feed-alert">username</div>
              </div>
              <!-- <feed-create-carousel></feed-create-carousel> -->
              <div>
                <div class="FeedCreate-user-profile-username fs-5">
                  <!-- {{ feed.first_name }} -->
                </div>
                <div class="user-feed-alert">username</div>
                <!-- </div> -->
              </div>
              <!-- <div>
              <img src="" alt="프로필 사진" />
            </div>
            <p>닉네임</p>
          </div> -->
              <div class="form-floating">
                <div class="textaera-frame">
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
    </div>
  </div>
</template>

<script>
// import FeedCreateCarousel from "../../components/feed/FeedCreateCarousel.vue";
// import axios from "axios";

// const SERVER_URL = process.env.VUE_APP_SERVER_URL;
// import { ValidationProvider } from "vee-validate"

export default {
  name: "FeedCreate",
  components: {
    // FeedCreateCarousel,
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
      profileimage:
        "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png",
    };
  },
  methods: {
    uploadImg() {
      let images = this.$refs["image"].files;
      let image = this.$refs["image"].files[0];
      // console.log(image);
      console.log(this.$refs["image"].files);
      const url = URL.createObjectURL(image);
      this.image = url;
      // console.log(url);
      // console.log(this.image);

      for (let i = 0; i < this.$refs["image"].files.length; i++) {
        images.push(this.$refs["image"].files[i]);
        console.log(images);
      }
      // 제출했을때
    },
  },
};
</script>

<style scoped>
.FeedCreate-TotalFrame {
  height: 100vh;
  width: 768px;
  background-color: #262626;
  z-index: -1;
  margin: auto;
}
.FeedCreate-Frame {
  height: 90%;
  /* width: 70%; */
  position: relative;
  padding-top: 5%;
  padding-bottom: 5%;
  /* left: 15%; */
  /* margin: auto; */
}
.contentbox {
  /* min-width: 300px; */
  min-width: 400px;
  height: inherit;
}
.leftbox {
  /* width: 60%; */
  /* width: 400px; */
  border: 1px solid #dbdbdb;
  border-radius: 3px;
  /* min-height: 400px; */
  /* min-width: 300px; */

  /* height: 600px; */
  /* height: 100%; */
  padding: 10px;
  flex-grow: 1;
  background-color: #ffff;

  /* align-self: stretch; */
}
.rightbox {
  /* width: 60%; */
  /* height: 100%; */
  border: 1px solid #dbdbdb;
  border-radius: 3px;
  padding: 10px;
  flex-grow: 1;

  background-color: #ffff;
}
.FeedCreate-title {
  background-color: #ffff;
  border-top-left-radius: 5px;
  border-top-right-radius: 5px;
  min-width: 400px;

  border: 1px solid #dbdbdb;
}
.FeedCreate-contentbox-UploadImgFrame {
  position: relative;
  /* background-color: #ffff; */
}

.textarea {
  overflow: auto;
  resize: vertical;
}
textarea::placeholder {
  color: #262626;
  font-size: 0.5rem;
}

.items {
  position: relative;
  padding: 1rem;
  margin: 1rem -15px 0;
  border-radius: 3px;
  border: 1px solid #dbdbdb;
  /* border-width: 0.2rem 0 0; */
}
.FeedCreate-UploadImage {
  width: 100%;
  /* max-width: 500px; */
  max-height: 500px;
  display: block;
}
.FeedCreate-user-profile-image {
  /* display: inline-block; */
  border-radius: 50%;
  margin: 0px 20px 0px 0px;
  width: 35px;
  height: 35px;
}

.bi-x-circle {
  position: absolute;
  z-index: auto;
  top: 2%;
  right: 2%;
}
.bi-images {
  position: absolute;
  z-index: auto;
  bottom: 2%;
  right: 2%;
}
</style>
