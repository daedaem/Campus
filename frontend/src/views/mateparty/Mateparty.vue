<template>
  <Navbar class="CampusNavbar" id="TotalNavbar"></Navbar>
  <div class="MateParty">
    <div class="MateParty-imgcover">
      <div class="MateParty-content"><h1 style="">메이트 모집</h1></div>
      <div></div>
    </div>
  </div>
  <div style="background-color : #fafafa;">
  <body>
    <!-- <h1>Mate party</h1> -->
    <!-- <Searchbar class="col" style="margin: 20px 0" /> -->
    <!-- <div class="container" style="width:100%;">  
        <div class="col-12"> -->
    <div style="margin-top: 30px">
      <Filters @filter-data="filterData" style="width: 100%" />
    </div>
    <!-- <Newmodal /> -->
    <br />
    <!-- <div style="overflow:hidden z-index:30"> -->

    <div align="right">
      <b-button
        pill
        style="
          width: 100px;
          height: 40px;
          margin-top: 40px;
          margin-bottom: 20px;
          background-color: #7ac4e1;
          border-color: #7ac4e1;
          align: right;
        "
        @click="goMakeparty"
        >글 작성</b-button
      >
    </div>
    <Pagination v-if="newFilter.length != 0" :newFilter="newFilter" />
    <!-- {{matelists}} -->
    <!-- </div>
    </div>
    </div> -->
  </body>
  </div>
</template>

<script>
import Pagination from "../../components/mateparty/Pagination.vue";
import Filters from "@/components/mateparty/Filters.vue";
import router from "@/router";
import { ref } from "vue";
import { useStore } from "vuex";
import Navbar from "@/components/common/Navbar.vue";
import Swal from "sweetalert2"

// const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {
  props: {
    filterlist: Array,
  },
  components: {
    Pagination,
    Filters,
    Navbar,

  },

  name: "Mateparty",
  setup() {
    const store = useStore();
    if (store.state.userEmail == null) {
      Swal.fire({
        title : "로그인이 필요한 서비스입니다.",
        icon : "warning",
        timer : 2000,
      })
      router.push({ name: "Login" });
    }
    
    // const testlist = ref("");
    
    const newFilter = ref(store.state.mateList);
    const goMakeparty = () => {
      router.push({ name: "Makeparty" });
    };

    const filterData = (val) => {
      console.log(val);
      newFilter.value = val.data.list;
    };

    return {
      goMakeparty,
      filterData,
      newFilter,
    };
  },
};
</script>

<style scoped>
.MateParty {
  width: 100%;
  height: 200px;
  background: black;
  background-color: rgba(0, 0, 0, 0.4);

  /* background-position: 30%; */
  /* background-repeat: no-repeat; */
  background: url("./../../assets/images/pexels-vlad-bagacian-1061640.jpg") 50%
    65% no-repeat;
  background-size: 100% auto;
}
.MateParty-imgcover {
  position: absolute;
  width: 100%;
  height: 200px;
  background-color: rgba(0, 0, 0, 0.5);
  z-index: 1;
}
.MateParty-content {
  position: absolute;
  top: 30%;
  left: 20%;
  /* transform: translate(-50%, -50%); */
  font-size: 3rem;
  color: white;
  z-index: 2;
  text-align: center;
}
.writebutton {
  background-color: #7ac4e1;
  border: 1px solid #fff;
}

@media (min-width: 768px) {
  body {
    width: 768px;
    /* padding: 0 20px; */
    background: #fafafa;
    margin: 0 auto;
  }
}
body {
  /* width : 768px; */
  /* margin: 0 auto; */
  padding: 0 20px;
}
.test {
  width: 100%;
}

.dd {
  width: 100%;
  height: 100%;
  height: auto;
  aspect-ratio: 16/9;
}

img {
  width: 100%;
  height: auto;
  aspect-ratio: 16/9;
}
</style>
