<template>
  <div class="FeedCreateDetail-TotalFrame">
    <div class="FeedCreateDetail-Frame">
      <div class="row1">제목</div>
      <div class="contentbox d-flex flex-wrap align-items-stretch">
        <div class="leftbox col-sm-12 col-md-7">
          <img :src="data" alt="" class="FeedCreateDetailUploadImage" />
          <div class="w-32 h-32 border-2 border-dotted border-blue-500">
            <form
              align="left"
              class="filterbox1"
              method="post"
              enctype="multipart/form-data"
            >
              <div>
                <label for="chooseFile"> Click </label>
              </div>
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
          <!-- <div class="item1"><img src="" alt="" /></div> -->
        </div>
        <div class="rightbox col-md-5">
          <div class="item2 d-flex">
            <!-- <div>
              <img src="" alt="프로필 사진" />
            </div> -->
            <p>닉네임</p>
          </div>
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
export default {
  name: "FeedCreateDetail",
  data() {
    return {
      text: "",
      image: "",
    };
  },
  method: {
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
.FeedCreateDetail-TotalFrame {
  height: 100vh;
  /* width: 70vw; */
  /* margin: 0 auto; */
  /* display: table; */
  /* margin-left: auto; */
  /* margin-right: auto; */
  /* background-color: greenyellow; */
  /* margin: 0 auto; */
}
.contentbox {
  /* align-items: stretch; */
  /* gap: 5px 5px; */
}
.leftbox {
  /* width: 60%; */
  /* height: 100%; */
  padding: 10px;
  align-self: stretch;
}
.rightbox {
  /* width: 60%; */
  /* height: 100%; */
  padding: 10px;
  flex-grow: 1;
}
.textarea {
  overflow: auto;
  resize: vertical;
}
.FeedCreateDetail-Frame {
  height: 70vh;
  width: 80vw;

  /* min-height: 40%; */
  /* max-height: 60%; */
  /* width: 60vw; */
  /* position: absolute; */
  margin: auto;
  /* background-color: green; */
  /* vertical-align: auto; */
}
.row1 {
  /* background-color: aqua; */
}
.items {
  position: relative;
  padding: 1rem;
  margin: 1rem -15px 0;
  border: solid #f8f9fa;
  border-width: 0.2rem 0 0;
}
/* .contentbox { */
/* width: 100%;
}
  height: 100%; */
/* .leftbox {
  width: 80%;
  height: 60%;
} */
.FeedCreateDetailUploadImage {
  width: 100%;
  height: 100%;
}
img {
  object-fit: cover;
}
</style>
