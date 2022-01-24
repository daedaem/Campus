<template>
  <div class="total d-flex">
    <div class="uploadimageframeV1" v-if="images">
      <img :src="images" alt="No Image" />
    </div>
    <div v-else class="uploadimageframeV2">
      <form method="post" enctype="multipart/form-data">
        <input
          ref="image"
          @change="uploadImg()"
          type="file"
          id="file-input"
          name="file-input"
          accept="image/*"
          class="uploadimage"
        />
      </form>
    </div>
    <div class="profilewidthtextarea m-2 p-2">
      <div class="d-flex">
        <div>
          <img
            src="https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_1280.png"
            class="user-comment-profile-image mx-1 my-auto"
            alt="..."
          />
        </div>
        <div class="profile-username ms-3 text-start">
          <p class="fs-6 fw-bold">이름</p>
        </div>
      </div>
      <div class="p-3">
        <b-form-textarea
          class="p-3"
          id="textarea-rows"
          placeholder="Tall textarea"
          rows="10"
        ></b-form-textarea>
      </div>
    </div>
  </div>
</template>

<script>
// import axios from "axios";
export default {
  name: "FeedCreateItems",
  data() {
    return {
      images:
        "https://cdn.pixabay.com/photo/2022/01/10/15/29/wind-mills-6928590__340.jpg",
      // "https://cdn.pixabay.com/photo/2022/01/10/15/29/wind-mills-6928590__340.jpg",
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
  },
};
</script>

<style>
.total {
  flex: 1;
}
.totalframe {
  height: 100%;
  align-self: stretch;
}
.uploadimageframeV2 {
  padding: 20px;
  align-self: center;
}
.uploadimageframeV1 {
  width: 55%;
  align-self: center;
}
.profilewidthtextarea {
  background-color: yellow;
  width: 45%;
}
.form input {
  border: 1px solid #ccc;
  border-radius: 5px;
  padding: 5px 10px;
}
.form input::file-selector-button {
  display: none;
}
</style>
