<template>
  <div class="FeedSearchResult-totalFrame">
    <div class="upBox mx-5 my-4" v-if="searchResult.length > 0">
      <div class="row g-0 d-flex justify-content-around align-items-center">
        <div class="col-md-4">
          <img
            :src="`${feedList[0].imageList[0].snsImageUrl}`"
            class="FeedSearchWordImage m-3"
            alt=""
          />
        </div>
        <div class="col-md-8">
          <div class="card-body">
            <div class="searchResultText fs-1">{{ searchWord }}</div>
          </div>
        </div>
      </div>
      <div class="fs-6 ps-4 text-start">인기 게시물</div>
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
      <div>{{ feed }}</div>
      <div class="fs-4">게시물들</div>
      <div class="게시물 박스들">
        <!-- {{ searchResult }} -->
        <div class="FeedSearchResults-FrameBox d-flex">
          <div v-for="(feed, idx) in searchResult" :key="idx">
            <!-- <div>{{ feed }}</div> -->
            <!-- <div>{{ feed.snsNo }}</div> -->
            <!-- <div>{{ feed.userNickname }}</div> -->
            <!-- <div>{{ feed.snsContent }}</div> -->
            <div class="FeedSearch-ImageBox">
              <img
                :src="`${feed.imageList[0].snsImageUrl}`"
                class="FeedSearch-ImageBox-Image"
                alt=""
              />
            </div>
          </div>
        </div>
        <!-- {{ this.searchResults }} -->
      </div>
    </div>
    <div v-else>
      <p class="fs-1 m-3">{{ searchWord }}</p>
      <p class="fs-6">검색어와 관련된 피드가 없습니다.</p>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";
// import { mapGetters } from "vuex";
import axios from "axios";
const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {
  name: "FeedSearchResults",
  data() {
    // return { searchresults: this.$store.state.searchResult };
  },
  methods: {},
  created: function () {
    // this.$router.reload();

    // console.log("돼요?", this.$store.state.searchResult);
    // this.searchresults = this.$store.state.searchResult;
    axios({
      methods: "get",
      url: `${SERVER_URL}/sns`,
      params: {
        // limit: limit.value,
        // offset: offset.value,
        searchWord: this.$store.state.searchWord,
        // doNm : '',
      },
    }).then((res) => {
      //     // articles.value.push(...res.data.list);
      console.log("나오나", res);
      //     this.searchResults.push(res.data.list);
      //       this.$store.dispatch("feedList", data);
    });
  },
  computed: {
    ...mapState(["searchWord"]),
    // ...mapGetters(["searchResult"]),
    ...mapState(["searchResult"]),
  },

  //     .then((res) => {
  //       // console.log(res.data.list);

  //       const data = res.data.list;
  //       console.log(res.data.list);
  //     })
  //     .catch((err) => {
  //       console.log(err);
  //     });
  // },
};
</script>

<style>
.FeedSearchResult-totalFrame {
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Helvetica,
    Arial, sans-serif;
  /* @media (min-width: 736px) { */
}
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
.FeedSearchResults-repsContentsBox {
  max-width: 800px;
}
.FeedSearchResults-FrameBox {
  max-width: 800px;
}
.feedcards {
}
.FeedSearch-ImageBox {
  margin: 4rem;
  /* width: 200px; */
  /* height: 200px; */
  background-color: black;
  /* width: 200px;
  height: 200px; */
  /* -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  box-sizing: border-box; */
}
.FeedSearch-ImageBox-Image {
  width: 200px;
  height: 200px;

  /* object-fit: contain; */
}
</style>
