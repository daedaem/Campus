<template>
  <div>수정페이지</div>
</template>

<script>
// const SERVER_URL = "http://localhost:8080";
const SERVER_URL = "http://i6e102.p.ssafy.io:8080";
import axios from "axios";

export default {
  name: "FeedModify",
  data() {
    return {
      feedDetailContents: "",
      detailFeedsnsNo: "",
    };
  },
  methods: {
    getFeedInfo() {
      axios.get(`${SERVER_URL}/sns/${this.detailFeedsnsNo}`).then((res) => {
        this.feedDetailContents = res.data.dto;
        this.$store.dispatch("toDetail", res.data.dto);
      });
    },
  },
  created: function () {
    this.detailFeedsnsNo = this.$route.params.snsNo;
    // console.log(this.detailFeedsnsNo);
    this.getFeedInfo;
    // console.log(res);
    // axios
    //   .get(`${SERVER_URL}/sns/like/${this.$store.state.userList.userNo}`)
    //   .then((res) => {
    //     // console.log("좋아요했는지 체크", res);
    //     // 좋아요 한 사람들 리스트
    //     console.log(res);
    //   });
  },
};
</script>

<style></style>
