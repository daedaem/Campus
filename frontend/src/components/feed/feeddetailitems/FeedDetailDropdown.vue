<template>
  <div>
    <div>
      <b-dropdown
        size="lg"
        variant="link-black"
        toggle-class="text-decoration-none"
        no-caret
      >
        <template #button-content>
          &#x2026;<span class="sr-only"></span>
        </template>
        <b-dropdown-item-button
          @click="modifyFeed"
          v-if="this.myNum === this.feed.userNo"
          >수정</b-dropdown-item-button
        >
        <b-dropdown-item-button
          variant="danger"
          text="Outline Danger"
          @click="deleteFeed"
          v-if="this.myNum === this.feed.userNo"
          >삭제</b-dropdown-item-button
        >
        <b-dropdown-item-button>취소</b-dropdown-item-button>
      </b-dropdown>
    </div>

    <!-- 나랑 불일치하면  -->
    <!-- <div>
    <div>
      <b-dropdown
        size="lg"
        variant="link-black"
        toggle-class="text-decoration-none"
        no-caret
      >
        <template #button-content>
          &#x2026;<span style="cursor: pointer" class="sr-only"></span>
        </template>
        <b-dropdown-item-button
          variant="danger"
          text="Outline Danger"
          @click="spamReport"
          ><p class="text-center">신고</p></b-dropdown-item-button
        >
        <b-dropdown-item-button
          @click="cancelFollow"
          variant="danger"
          text="Outline Danger"
          ><p class="text-center">팔로우 취소</p></b-dropdown-item-button
        > -->
    <!-- <b-dropdown-item-button @click="Feedetail"
          >게시물 상세보기</b-dropdown-item-button
        > -->
    <!-- <b-dropdown-item-button
          ><p class="text-center">취소</p></b-dropdown-item-button
        >
      </b-dropdown>
    </div> -->
    <!-- </div> -->
  </div>
</template>

<script>
// const SERVER_URL = `http://i6e102.p.ssafy.io`;
const SERVER_URL = "http://localhost:8080";

import axios from "axios";
import { mapState } from "vuex";

export default {
  name: "FeedDetailDropDown",
  // components: {},
  // data() {},
  props: {
    feed: Object,
  },
  data() {
    return {
      feedinfo: "",
    };
  },
  methods: {
    deleteFeed() {
      axios
        .delete(`${SERVER_URL}/sns/${this.feed.snsNo}`)
        .then(() => {
          // console.log(res);
          this.$router.push({ name: "FeedList" });
          // this.feedDetailContents = res.data.dto;
          // console.log(this.feedDetailContents);
          // if (res.data.rate) {
          //   this.currentRate = res.data.rate;
          //   this.ratingDone = 1;
          // }
        })
        .catch((err) => {
          console.log(err);
          alert("실패하였습니다.");
        });
    },
    modifyFeed() {
      axios
        .put(`${SERVER_URL}/sns/${this.feed.snsNo}`)
        .then((res) => {
          console.log(res);
          this.$router.push({ name: "FeedList" });
          // this.feedDetailContents = res.data.dto;
          // console.log(this.feedDetailContents);
          // if (res.data.rate) {
          //   this.currentRate = res.data.rate;
          //   this.ratingDone = 1;
          // }
        })
        .catch((err) => {
          console.log(err);
          alert("실패하였습니다.");
        });
      this.$router.push({ name: "FeedDetail" });
    },
    // spamReport() {
    //   // this.$router.push({ name: "Reviews" });
    // },
    // cancelFollow() {},
    // // FeedDetail() {
    // //   this.$router.push({ name: "Reviews" });
    // // },
  },
  computed: {
    ...mapState(["myNum"]),
  },
};
</script>

<style></style>
