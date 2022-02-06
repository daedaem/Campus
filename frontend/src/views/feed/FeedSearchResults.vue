<template>
  <div class="FeedSearchResult-totalFrame">
    <p class="fs-1 m-3">#검색단어</p>
    <div class="fs-4">인기 게시물</div>

    <div
      class="FeedSearchResults-repsContentsBox d-flex justify-content-around align-items-center"
    >
      <div class="첫번쨰">
        <div class="FeedSearchResults-repsImage m-3">
          <img
            src="https://entertainimg.kbsmedia.co.kr/cms/uploads/PERSON_20211124154837_f9c6fbc082f4fc2b8796396eb20a5bcc.jpg"
            alt="이미지"
          />
        </div>
      </div>
      <div class="두번쨰">
        <div class="FeedSearchResults-repsImage m-3">
          <img
            src="http://theviewers.co.kr/Files/30/Images/201902/28401_23866_3233.jpg"
            alt="이미지"
          />
        </div>
      </div>
      <div class="세번쨰">
        <div class="FeedSearchResults-repsImage m-3">
          <img
            src="https://news.nateimg.co.kr/orgImg/my/2021/09/16/202109152211873331_1.jpg"
            alt="이미지"
          />
        </div>
      </div>
      <div class="네번쨰">
        <div class="FeedSearchResults-repsImage m-3">
          <img
            src="https://entertainimg.kbsmedia.co.kr/cms/uploads/PERSON_20211124154837_f9c6fbc082f4fc2b8796396eb20a5bcc.jpg"
            alt="이미지"
          />
        </div>
      </div>
    </div>
    <div class="fs-4">게시물들</div>
    <div class="게시물 박스들">
      <div class="게시물 박스들 틀">
        <div class="feedcards">1</div>
        <div class="feedcards">2</div>
        <div class="feedcards">3</div>
        <div class="feedcards">4</div>
      </div>
    </div>
    <!-- {{ this.searchResults }} -->
  </div>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  name: "FeedSearchResults",
  data() {
    return {};
  },
  methods: {},
  created: function () {
    console.log(this.searchResults);
  },
  computed: {
    ...mapGetters(["searchResults"]),
  },
};
</script>

<style>
/* @media (min-width: 736px) { */
.FeedSearchResults-repsContentsBox {
  align-items: center;
  /* font-size: 16px; */
  /* line-height: 24px; */
  margin: 20px auto 20px auto;
  max-width: 935px;
  width: 90%;
  border: 2px solid #eee;
  border-radius: 30px;
  /* width: calc(100% - 40px); */
}
/* .FeedSearchResults-repsContentsBox {
  width: 100%;
} */
.FeedSearchResults-repsImage {
  background-color: #fafafa;

  border-radius: 50%;
  box-sizing: border-box;
  display: block;
  /* flex: 0 0 auto; */
  margin: 0 auto;
  overflow: hidden;
  position: relative;
  max-width: 152px;
  max-height: 152px;
  /* width: 100%; */
  /* height: 100%; */
}
/* } */
.FeedSearchResult-totalFrame {
  width: 100vw;
  height: 100vh;
}
.FeedSearchResult-resultInfo {
  height: 25%;
}
.feedcards {
  width: 200px;
  height: 200px;
  background-color: black;
}
</style>
