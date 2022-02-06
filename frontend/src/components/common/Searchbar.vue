<template>
  <div>
    <div>
      <input
        class="text-secondary Searchbar-inputBox p-2"
        v-on:input="async"
        @keyup.enter="SearchData"
        placeholder="Search..."
      />
    </div>
    <div class="ui cards" style="margin: 10px" v-if="searchQuery">
      <div
        class="card ui fluid"
        v-for="(camp, idx) in searchedProducts"
        :key="idx"
        style="margin: 0"
      >
        <div class="content">
          <div style="float: left">
            <img
              class="right floated mini ui image"
              :src="camp.firstImageUrl"
              style="width: 50px; height: 50px"
            />
          </div>
          <div class="header" style="margin-left: 70px">{{ camp.facltNm }}</div>
          <div class="meta" style="margin-left: 70px">{{ camp.addr1 }} |</div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Searchbar",
  data() {
    return { inputData: null };
  },
  methods: {
    async(e) {
      this.inpuData = e.target.value;
    },
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

<style>
.Searchbar-inputBox {
  border-radius: 10px;
  min-width: 200px;
}
</style>
