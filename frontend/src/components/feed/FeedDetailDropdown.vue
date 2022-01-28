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
  </div>
</template>

<script>
export default {
  name: "FeedDetailDropDown",
  // components: {},
  // data() {},

  methods: {
    deleteFeed() {},
    modifyFeed() {},
  },
  // setup(props){
  //   const {} = toRefs

  // }
};
</script>

<style></style>
