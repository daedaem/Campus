<template>
  <div class="FeedCreateDetailTotalFrame">
    <div class="FeedCreateDetailFrame">
      <div class="row1">제목</div>
      <div class="contentbox">
        <div class="leftbox">
          <img
            src="https://cdn.pixabay.com/photo/2019/06/28/03/07/camping-4303357_960_720.jpg"
            alt=""
            class="FeedCreateDetailUploadImage align-self-center"
          />
          <!-- <div class="item1"><img src="" alt="" /></div> -->
        </div>
        <div class="rightbox">
          <div class="item2 d-flex">
            <div>
              <img src="" alt="프로필 사진" />
            </div>
            <p>닉네임</p>
          </div>
          <div class="item3">내용</div>
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
    };
  },
};
</script>

<style>
.FeedCreateDetailTotalFrame {
  height: 100vh;
  /* width: 70vw; */
  /* margin: 0 auto; */
  /* display: table; */
  /* margin-left: auto; */
  /* margin-right: auto; */
  background-color: greenyellow;
  /* margin: 0 auto; */
}
.leftbox {
  /* width: 60%; */
  height: 100%;
}
.rightbox {
  /* width: 60%; */
  height: 100%;
}
.FeedCreateDetailFrame {
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
  background-color: aqua;
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
