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
        <b-dropdown-item-button @click="modifyFeed"
          >수정</b-dropdown-item-button
        >
        <b-dropdown-item-button
          variant="danger"
          text="Outline Danger"
          @click="deleteFeed"
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
export default {
  name: "FeedDropDown",
  // components: {},
  // data() {},
  props: {
    feed: Object,
  },

  methods: {
    deleteFeed() {
      this.$router.push({ name: "Reviews" });
    },
    modifyFeed() {
      this.$router.push({ name: "Reviews" });
    },
    spamReport() {
      // this.$router.push({ name: "Reviews" });
    },
    cancelFollow() {},
    // FeedDetail() {
    //   this.$router.push({ name: "Reviews" });
    // },
  },

  // setup(props){
  //   const {} = toRefs

  // }
};
</script>

<style></style>
