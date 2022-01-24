<template>
  <div>
    <div>
      <form
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
      <img :src="image" alt="" class="" />
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

      // 체크하는것
      checkId: false,
      checkNickname: false,
      checkEmail: false,
      checkEmailCode: false,
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

<style></style>
