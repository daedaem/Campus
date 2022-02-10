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

        <b-dropdown-item-button @click="moveToDetail" :feed="feed"
          >게시물 상세보기</b-dropdown-item-button
        >
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
import { mapState } from "vuex";
import axios from "axios";
const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {
  name: "FeedListItemDropDown",
  // components: {},
  // data() {},
  props: {
    feed: Object,
  },
  data() {
    return {};
  },
  methods: {
    moveToDetail() {
      // console.log(this.feed);
      this.$store.dispatch("toDetail", this.feed);
      this.$router.push({
        name: "FeedDetail",
        params: { snsNo: this.feed.snsNo },
      });
    },
    deleteFeed() {
      axios
        .delete(`${SERVER_URL}/sns/${this.feed.snsNo}`)
        .then(() => {
          console.log("삭제완료요");
          location.reload();

          // this.$router.push({ name: "FeedList" });

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
      this.$router.push({
        name: "FeedModify",
        params: { snsNo: this.feed.snsNo },
      });
    },
    // spamReport() {
    // this.$router.push({ name: "Reviews" });
    // },
    // cancelFollow() {},
    // FeedDetail() {
    //   this.$router.push({ name: "Reviews" });
    // },
  },
  computed: {
    ...mapState(["myNum"]),
  },

  // setup(props){
  //   const {} = toRefs

  // }
};
</script>

<style></style>
