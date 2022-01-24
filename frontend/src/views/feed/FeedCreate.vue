<template>
  <!-- <div class="modal-dialog modal-fullscreen-sm-down"> -->
  <!-- 글 작성란-->
  <div class="frame mx-auto">
    <div>
      <div class="title fs-4 py-2 fw-bold">새글 작성란</div>
    </div>
    <!-- 사진 -->
    <feed-create-items></feed-create-items>
    <!-- 텍스트 내용 적는란 -->
  </div>
</template>

<script>
import FeedCreateItems from "../../components/feed/FeedCreateItems.vue";
export default {
  name: "FeedCreate",
  components: { FeedCreateItems },
  data() {
    return {
      text: "",
    };
  },
};
</script>

<style scoped>
/* .feedcreateframe {
  width: 100vw;
  height: 100vh;
  background-color: antiquewhite;
} */
.frame {
  /* width: 70%; */
  /* max-height: calc(100vh - 100px); */
  /* max-width: calc(100vw - 400px); */
  /* min-height: 600px; */
  height: 80vh;
  width: 100vh;
  margin: 20px;
  background-color: green;
  border-radius: 10%;
}

.title {
  background-color: aquamarine;
  height: 10%;
  border-top-left-radius: 10%;
  border-top-right-radius: 10%;
}
.titlecontent {
  margin: auto;
}
.uploaded-image {
  width: 100%;
  height: 100%;
}
</style>
