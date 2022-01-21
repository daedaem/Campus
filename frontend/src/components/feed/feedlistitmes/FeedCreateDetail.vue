<template>
  <div class="feedcreateframe d-flex justify-content-center align-items-center">
    <!-- <div class="modal-dialog modal-fullscreen-sm-down"> -->
    <div class="frame d-flex">
      <div class="pictureFrame">사진란</div>
      <div>
        <!-- 글 작성란-->
        <div class="input-group">
          <input
            type="file"
            class="form-control"
            id="inputGroupFile04"
            aria-describedby="inputGroupFileAddon04"
            aria-label="Upload"
          />
          <button
            class="btn btn-outline-secondary"
            type="button"
            id="inputGroupFileAddon04"
          >
            Button
          </button>
        </div>

        <b-form-textarea
          id="textarea"
          placeholder="Enter something..."
          v-model="text"
          rows="4"
          max-rows="8"
        ></b-form-textarea>
        <!-- 텍스트 내용 적는란 -->
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
    };
  },
};
</script>

<style>
/* .button {
    display: flex;
    justify-content: center;
} */
.feedcreateframe {
  width: 90vw;
  height: 90vh;
  margin: auto;
}
.frame {
  margin: auto;
  width: 80%;
  height: 70%;
  top: 0;
  bottom: 0;
}
.pictureFrame {
  width: 60%;
  height: 100%;
}
.input-group {
  width: 10%;
  height: 1h;
}
/* .form-floating{

} */

/* 인스타 제일 큰 곳 */
/* .RnEpo {
    -webkit-box-align: center;
    -webkit-align-items: center;
    -ms-flex-align: center;
    align-items: center;
    background-color: rgba(0,0,0,.65);
    bottom: 0;
    -webkit-box-orient: vertical;
    -webkit-box-direction: normal;
    -webkit-flex-direction: column;
    flex-direction: column;
    left: 0;
    overflow-y: auto;
    position: fixed;
    right: 0;
    -webkit-tap-highlight-color: #000;
    top: 0;
    z-index: 100; */
</style>
