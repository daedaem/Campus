<template>
  <div class="FeedCreateDetail-TotalFrame">
    <div class="FeedCreateDetail-Frame">
      <div class="d-flex justify-content-between FeedCreateDetail-title py-2">
        <router-link
          class="text-decoration-none text-black"
          :to="{ name: 'FeedList' }"
        >
          <i class="bi bi-arrow-left ps-3 fs-4"></i
        ></router-link>
        <div class="fs-5 fs-bold">새 게시글 작성</div>
        <router-link
          class="text-decoration-none fw-bold text-primary align-middle col-2 align-self-center"
          :to="{ name: 'FeedCreate' }"
          >업로드</router-link
        >
      </div>
      <div class="contentbox d-flex flex-wrap">
        <div class="leftbox col-sm-12 col-md-7">
          <img v-if="image" :src="image" alt="" class="uploadimage" />
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
              id="chooseFile"
              name="chooseFile"
              accept="image/*"
            />
          </form>
        </div>
        <div class="rightbox col-md-5">
          <div class="item2 d-flex my-2">
            <div class="user-feed-card">
              <div class="d-flex align-items-center">
                <div class="d-flex justify-content-center">
                  <img
                    :src="profileimage"
                    class="user-profile-image"
                    alt="..."
                  />
                </div>
                <div class="user-profile-username fs-5">
                  <!-- {{ feed.first_name }} -->
                </div>
                <div class="user-feed-alert">follow</div>
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
                placeholder="Tall textarea"
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
  data() {
    return {
      credentials: {
        userId: "",
        nickname: "",
        email: "",
        password: "",
      },
      image: "",
      profileimage:
        "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png",
    };
  },
  methods: {
    uploadImg() {
      console.log("들어왔다");
      var image = this.$refs["image"].files[0];

      const url = URL.createObjectURL(image);
      this.image = url;
      console.log(url);
      console.log(this.image);
    },
    // 제출했을때
  },
};
</script>

<style>
.FeedCreateDetail-TotalFrame {
  height: 100vh;
}
.FeedCreateDetail-title {
  background-color: ffffff;
  border-top-left-radius: 5px;
  border-top-right-radius: 5px;
  min-width: 300px;
  border: 1px solid #dbdbdb;
}
.contentbox {
  min-width: 300px;
}
.leftbox {
  /* width: 60%; */
  /* width: 400px; */
  border: 1px solid #dbdbdb;
  border-radius: 3px;
  min-height: 400px;
  /* height: 600px; */
  /* height: 100%; */
  padding: 10px;
  flex-grow: 1;

  /* align-self: stretch; */
}
.rightbox {
  /* width: 60%; */
  /* height: 100%; */
  border: 1px solid #dbdbdb;
  border-radius: 3px;
  padding: 10px;
  flex-grow: 1;
  min-height: 400px;
}
.textarea {
  overflow: auto;
  resize: vertical;
}
.FeedCreateDetail-Frame {
  height: 60vh;
  width: 70vw;
  position: relative;
  top: 10%;
  /* left: 15%; */
  margin: auto;
}
.items {
  position: relative;
  padding: 1rem;
  margin: 1rem -15px 0;
  border-radius: 3px;
  border: 1px solid #dbdbdb;
  /* border-width: 0.2rem 0 0; */
}
.FeedCreateDetailUploadImage {
  width: 100%;
  height: 100%;
}
.user-profile-image {
  /* display: inline-block; */
  border-radius: 50%;
  margin: 0px 20px 0px 0px;
  width: 42px;
  height: 42px;
}
.uploadimage {
  /* max-width: 100%; */
  /* padding-top: 20%; */
  display: block;
  width: 100%;

  /* vertical-align: middle; */
}
</style>
