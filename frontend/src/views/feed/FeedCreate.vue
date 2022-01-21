<template>
  <div class="feedcreateframe d-flex justify-content-center align-items-center">
    <!-- <div class="modal-dialog modal-fullscreen-sm-down"> -->
    <div class="frame">
      <!-- 글 작성란-->
      <div class="title">
        <p class="fs-4 fw-bold">새글 작성란</p>
      </div>
      <div>
        <div>
          <img
            src="https://cdn.pixabay.com/photo/2021/10/09/00/15/landscape-6692712__340.jpg"
            alt=""
          />
        </div>
        <div class="input-group d-flex flex-column">
          <input
            type="file"
            class="picture"
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
      </div>
    </div>
    <!-- 텍스트 내용 적는란 -->
  </div>
</template>

<script>
export default {
  name: "FeedCreate",
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
  width: 100vw;
  height: 100vh;
  background-color: antiquewhite;
}
.frame {
  width: 70%;
  height: 80%;
  margin: auto;
  background-color: azure;
}

/* .pictureFrame { */
/* width: 60%; */
/* height: 100%; */
/* } */
.title {
  background-color: aquamarine;
  height: 3rem;
}
.titlecontent {
  margin: auto;
}
/* .input-group { */
/* width: 10%; */
/* width: 400px; */
/* height: 400px; */
/* height: 30%; */
/* } */
/* .picture { */
/* } */

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
