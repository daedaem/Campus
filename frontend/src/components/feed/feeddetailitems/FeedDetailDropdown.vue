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
          v-if="this.myNum === this.feedDetailContents.userNo"
          >수정</b-dropdown-item-button
        >
        <b-dropdown-item-button
          variant="danger"
          text="Outline Danger"
          @click="deleteFeed"
          v-if="this.myNum === this.feedDetailContents.userNo"
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
<<<<<<< HEAD
<<<<<<< HEAD
const SERVER_URL = `http://i6e102.p.ssafy.io:8080`;
// const SERVER_URL = "http://localhost:8080";
=======
// const SERVER_URL = `http://i6e102.p.ssafy.io`;
const SERVER_URL = "http://localhost:8080";
>>>>>>> ce9f3cb85fa91356530793925e7462b19bed5fa3
=======
// const SERVER_URL = `http://i6e102.p.ssafy.io`;
const SERVER_URL = "http://localhost:8080";
>>>>>>> 718598346e95dc702d937f60de30fe46c2342de3

import axios from "axios";
import { mapState } from "vuex";

export default {
  name: "FeedDetailDropDown",
  // components: {},
  // data() {},
  props: {
    feedDetailContents: Object,
  },
  data() {
    return {
      feedinfo: "",
    };
  },
  methods: {
    deleteFeed() {
      axios
        .delete(`${SERVER_URL}/sns/${this.feedDetailContents.snsNo}`)
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
      // axios
      // .put(`${SERVER_URL}/sns/${this.feedDetailContents.snsNo}`)
      // .then((res) => {
      // console.log(res);
      this.$router.push({ name: "FeedModify" });
      // this.feedDetailContents = res.data.dto;
      // console.log(this.feedDetailContents);
      // if (res.data.rate) {
      //   this.currentRate = res.data.rate;
      //   this.ratingDone = 1;
      // }
      // })
      // .catch((err) => {
      // console.log(err);
      // alert("실패하였습니다.");
      // });
      // // this.$router.push({
      // //   name: "FeedDetail",
      // //   data: {
      // //     feed: this.feed,
      // //   },
      // });
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
