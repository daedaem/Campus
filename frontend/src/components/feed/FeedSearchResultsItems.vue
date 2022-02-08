<template>
  <!-- <b-card alt="" img-alt="Image" img-top> -->
  <div class="py-4 mx-2">
    <!-- <di class=""v> -->
    <b-card-img
      class="FeedSearchResultsItems-cards"
      :src="`${searchedFeed.imageList[0].snsImageUrl}`"
      @click="moveToDetail"
    ></b-card-img>
    <!-- <b-card-text class="my-1"> {{ newWord }} </b-card-text> -->
    <!-- </di> -->
  </div>
  <!-- </b-card> -->
</template>

<script>
export default {
  name: "FeedSearchResultsItems",
  data() {
    return { searchedFeedWord: null, newWord: "" };
  },
  props: {
    searchedFeed: Object,
    searchWord: String,
  },
  methods: {
    moveToDetail() {
      this.$store.dispatch("toDetail", this.feed);
      this.$router.push({
        name: "FeedDetail",
        params: { snsNo: this.searchedFeed.snsNo },
      });
    },
  },
  created() {
    const word = this.searchWord;
    this.searchedFeedWord = this.searchedFeed.snsContent.match(word).input;
    // console.log(this.searchedFeedWord);
    const wordOfPosition = this.searchedFeed.snsContent.indexOf(word);
    this.newWord = this.searchedFeedWord.substring(wordOfPosition);
    // console.log(newWord);
    // console.log("된거가", this.searchedFeedWord.input);
  },
};
</script>

<style>
.FeedSearchResultsItems-cards {
  border: 1px solid #eee;
  border-radius: 5%;
}
</style>
