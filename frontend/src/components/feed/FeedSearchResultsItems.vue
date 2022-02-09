<template>
  <!-- <b-card alt="" img-alt="Image" img-top> -->
  <!-- <di class=""v> -->
  <!-- <b-card-text class="my-1"> {{ newWord }} </b-card-text> -->
  <!-- <b-card-group> -->

  <b-card
    no-body
    class="FeedSearchResultsItems-cards my-3"
    :img-src="`${searchedFeed.imageList[0].snsImageUrl}`"
    @click="moveToDetail"
  >
    <template #footer>
      <small class="text-muted fw-bold text-start">{{
        "@" + searchedFeed.userNickname
      }}</small>
    </template>
  </b-card>

  <!-- </b-card-group> -->
  <!-- </di> -->
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
  cursor: pointer;
  transform: scale(1);
  -webkit-transform: scale(1);
  -moz-transform: scale(1);
  -ms-transform: scale(1);
  -o-transform: scale(1);
  transition: all 0.3s ease-in-out;
}
.FeedSearchResultsItems-cards:hover {
  transform: scale(1.1);
  -webkit-transform: scale(1.1);
  -moz-transform: scale(1.1);
  -ms-transform: scale(1.1);
  -o-transform: scale(1.1);
}
</style>
