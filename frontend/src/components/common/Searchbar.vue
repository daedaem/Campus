<template>
  <b-container class="searchbar d-flex">
    <b-row class="">
      <b-form-input
        class="text-secondary"
        v-model="inputData"
        @keyup.enter="SearchData"
        placeholder="Search for a movie..."
      >
      </b-form-input>
    </b-row>
  </b-container>
</template>

<script>
export default {
  name: "Searchbar",
  data() {
    return { inputData: null };
  },
  methods: {
    SearchData() {
      // 글자 존재
      if (this.inputData) {
        //글자 존재하고 공백 아님
        if (this.inputData.trim()) {
          // 공백 제거 후에 2글자 미만임
          if (this.inputData.trim().length < 2) {
            alert("Please type at least two letters.");
            // 공백 제거해도 2글자 이상이면 진행
          } else {
            this.$emit("searchData", "#" + this.inputData);
          }
          // 공백 제거 후에 글자 존재 안함= 완전 공백임
        } else {
          alert("There is an empty box.");
        }
        // 글자가 존재안함
      } else {
        alert("There is an empty box.");
      }
    },
  },
};
</script>

<style></style>
