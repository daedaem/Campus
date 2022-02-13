<template>
  <div>
    <input
      class="Searchbar-inputBox"
      type="text" placeholder="&#xf52a; Search" 
      style="font-family:'bootstrap-icons';"      
      @input="async"
      @keyup.enter="SearchData()"
      
    />

    <!-- <div class="ui cards" style="margin: 10px" v-if="inputData">
      <div
        class="card ui fluid"
        v-for="(feed, idx) in searchResults"
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
    </div> -->
  </div>
</template>

<script>
import { mapState } from "vuex";
const SERVER_URL = process.env.VUE_APP_SERVER_URL;

import axios from "axios";

export default {
  name: "Searchbar",

  data() {
    // temp는 일단 피드 리스트 전부 받아옴
    return { inputData: "", temp: [], searchResults: [] };
  },
  methods: {
    async(e) {
      this.inputData = e.target.value;
      // console.log(e.target.value);
    },
    SearchData() {
      // 맨 앞이 #면 #하나 제거하고 공백제거
      if (this.inputData[0] == "#") {
        this.inputData = this.inputData.substr(1).trim();
        // console.log("된건가", this.inputData);
      }
      if (this.inputData) {
        //글자 존재하고 공백 아님
        this.inputData = this.inputData.trim();
        // console.log(this.inputData);
        // 공백 제거 후에 2글자 미만임
        if (this.inputData.trim().length < 2) {
          alert("Please type at least two letters.");
          // 공백 제거해도 2글자 이상이면 진행
        } else {
          axios({
            methods: "get",
            url: `${SERVER_URL}/sns`,
            params: { searchWord: "#" + this.inputData },
          })
            .then((res) => {
              // articles.value.push(...res.data.list);
              // this.searchResults = res.data.list;
              console.log("있는데", res.data.list);
              this.$store.dispatch("searchData", "#" + this.inputData);
              this.$store.dispatch("searchResult", res.data.list);

              // params: {
              //   // limit: limit.value,
              //   // offset: offset.value,
              //   searchWord: this.$store.state.searchWord,
              //   // doNm : '',
              // },
            })
            .then(() => {
              //   // console.log(res.data.list);
              this.$router.push({
                name: "FeedSearchResults",
              });
              //       this.$store.dispatch("feedList", data);
            })
            .catch((err) => {
              console.log(err);
            });
        }
        // 공백 제거 후에 글자 존재 안함= 완전 공백임
      }
      // 글자가 존재안함
      else {
        alert("There is an empty box.");
      }
    },
  },
  created: function () {
    this.temp = this.$store.state.feedList;
    // console.log(this.$store.state.user);
  },
  computed: {
    ...mapState(["feedList"]),

    // searchedData: function(){
    //   return this.$store.state.searchResult.filter(()=>)
    // }
  },
};
</script>

<style>
.Searchbar-inputBox {
  min-width: 100px;
  max-width: 150px;
  height: 40px;
  background: transparent;
  border: transparent;
  border-bottom: 1px solid white;
  text:black;
  
}input::placeholder {
  color: #fafafa;
  /* font-style: italic; */
}
</style>
