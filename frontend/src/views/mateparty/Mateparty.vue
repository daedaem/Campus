<template>
  <Navbar></Navbar>
  <div style="height:400px; overflow:hidden;">
  <img style="object-fit:cover;" class="dd" src="https://images.pexels.com/photos/7148973/pexels-photo-7148973.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260" alt="">
  </div>
  <body>
 
      

    <!-- <h1>Mate party</h1> -->
    <!-- <Searchbar class="col" style="margin: 20px 0" /> -->
    <h1 style="margin-top:50px;">메이트 모집</h1>
    <div style="margin-top:30px;">
      <Filters @filter-data="filterData" style="width:100%;"/>
    </div>
    <!-- <Newmodal /> -->
    <br>
    <!-- <div style="overflow:hidden z-index:30"> -->

      <div align="right">
        <b-button
          pill
          style="width: 100px; height: 40px; margin-top: 40px; margin-bottom: 20px; background-color:#7ac4e1; border-color:#7ac4e1; align:right;"
          @click="goMakeparty"
          
          >글 작성</b-button
        >
      </div>

    <Pagination
      v-if="testlist.length != 0"
      :matelists="matelists"
      :filterlist="filterlist"
      :testlist="testlist"
      
    />
    <!-- {{matelists}} -->
  </body>
</template>

<script>
import Pagination from "../../components/mateparty/Pagination.vue";
import Filters from "@/components/mateparty/Filters.vue";
// import Newmodal from "@/components/mateparty/Newmodal.vue";
// import Searchbar from "../../components/mateparty/Searchbar.vue";
// import {mapState} from 'vuex'
import router from "@/router";
import { ref, computed } from "vue";
import { useStore } from "vuex";
// import {mapState} from 'vuex'
import axios from "axios";
import Navbar from "@/components/common/Navbar.vue";
const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {
  props: {
    filterlist: Array,
  },
  components: {
    Pagination,
    Filters,
    // Newmodal,
    // Searchbar,
    Navbar,
  },

  name: "Mateparty",
  setup() {
    const store = useStore();
    


    const testlist = ref("");
    const viewFunc = (data) => {
      // console.log(data)
      store.dispatch("viewMate", data);
    };

    const matelist = computed(() => store.state.mateList);
    axios({
      methods: "get",
      url: `${SERVER_URL}/mate`,
    })
      .then((res) => {
        // console.log(res.data.list)
        viewFunc(res.data.list);
        testlist.value = res.data.list;
      })

      .catch((err) => {
        console.log(err);
      });

    const goMakeparty = () => {
      router.push({ name: "Makeparty" });
    };

    const matelists = ref(store.state.mateList);
    const filterlist = ref("");
    const test = ref([]);
    console.log(matelists.value);

    const filterData = (val) => {
      console.log(val);
      filterlist.value = val;

      if (filterlist.value.date) {
        // const month = val.date[0].toString().substring(4,7)
        if (val.date[0].toString().substring(4, 7) === "Jan") {
          var startMonth = "01";
        } else if (val.date[0].toString().substring(4, 7) === "Feb") {
          startMonth = "02";
        } else if (val.date[0].toString().substring(4, 7) === "Mar") {
          startMonth = "03";
        } else if (val.date[0].toString().substring(4, 7) === "Apr") {
          startMonth = "04";
        } else if (val.date[0].toString().substring(4, 7) === "May") {
          startMonth = "05";
        } else if (val.date[0].toString().substring(4, 7) === "Jun") {
          startMonth = "06";
        } else if (val.date[0].toString().substring(4, 7) === "Jul") {
          startMonth = "07";
        } else if (val.date[0].toString().substring(4, 7) === "Aug") {
          startMonth = "08";
        } else if (val.date[0].toString().substring(4, 7) === "Sep") {
          startMonth = "09";
        } else if (val.date[0].toString().substring(4, 7) === "Oct") {
          startMonth = "10";
        } else if (val.date[0].toString().substring(4, 7) === "Nov") {
          startMonth = "11";
        } else if (val.date[0].toString().substring(4, 7) === "Dec") {
          startMonth = "12";
        }

        if (val.date[1].toString().substring(4, 7) === "Jan") {
          var endMonth = "01";
        }
        if (val.date[1].toString().substring(4, 7) === "Feb") {
          endMonth = "02";
        } else if (val.date[1].toString().substring(4, 7) === "Mar") {
          endMonth = "03";
        } else if (val.date[1].toString().substring(4, 7) === "Apr") {
          endMonth = "04";
        } else if (val.date[1].toString().substring(4, 7) === "May") {
          endMonth = "05";
        } else if (val.date[1].toString().substring(4, 7) === "Jun") {
          endMonth = "06";
        } else if (val.date[1].toString().substring(4, 7) === "Jul") {
          endMonth = "07";
        } else if (val.date[1].toString().substring(4, 7) === "Aug") {
          endMonth = "08";
        } else if (val.date[1].toString().substring(4, 7) === "Sep") {
          endMonth = "09";
        } else if (val.date[1].toString().substring(4, 7) === "Oct") {
          endMonth = "10";
        } else if (val.date[1].toString().substring(4, 7) === "Nov") {
          endMonth = "11";
        } else if (val.date[1].toString().substring(4, 7) === "Dec") {
          endMonth = "12";
        }

        const startYear = val.date[0].toString().substring(11, 15);
        const startDay = val.date[0].toString().substring(8, 10);
        const startDate = startYear + "-" + startMonth + "-" + startDay;

        const endYear = val.date[1].toString().substring(11, 15);
        const endDay = val.date[1].toString().substring(8, 10);
        const endDate = endYear + "-" + endMonth + "-" + endDay;

        matelists.value = matelists.value.filter(function (item) {
          return (
            item.mateCampstart >= startDate && item.mateCampstart <= endDate
          );
        });
      }

      if (filterlist.value.camp) {
        matelists.value = matelists.value.filter(function (item) {
          return item.mateCamptype === filterlist.value.camp[0];
        });
      }

      if (filterlist.value.style) {
        if (filterlist.value.style.length === 1) {
          matelists.value = matelists.value.filter(function (item) {
            return item.mateCampstyle === filterlist.value.style[0];
          });
        } else if (filterlist.value.style.length === 2) {
          matelists.value = matelists.value.filter(function (item) {
            return (
              item.mateCampstyle === filterlist.value.style[0] ||
              item.mateCampstyle === filterlist.value.style[1]
            );
          });
        } else if (filterlist.value.style.length === 3) {
          matelists.value = matelists.value.filter(function (item) {
            return (
              item.mateCampstyle === filterlist.value.style[0] ||
              item.mateCampstyle === filterlist.value.style[1] ||
              item.mateCampstyle === filterlist.value.style[2]
            );
          });
        }
      }

      if (filterlist.value.sortList) {
        if (filterlist.value.sortList[0] === "빠른") {
          matelists.value.sort(function (a, b) {
            return a.mateCampstart < b.mateCampstart
              ? -1
              : a.mateCampstart > b.mateCampstart
              ? 1
              : 0;
          });
        } else if (filterlist.value.sortList[0] === "최신") {
          matelists.value.sort(function (a, b) {
            return a.mateCreateTime < b.mateCreateTime
              ? -1
              : a.mateCreateTime > b.mateCreateTime
              ? 1
              : 0;
          });
        }
      }

      console.log(matelists.value);
    };

    return {
      matelists,
      goMakeparty,
      filterData,
      test,
      matelist,
      testlist,
      
    };
  },
};
</script>

<style scoped>
@media (min-width: 768px) {
  body {
    width: 768px;
    margin: 0 auto;
    padding: 0 20px;
    background: #fff;
  }
}

body {

    /* margin: 0 20; */
    padding: 0 20px;

}
.test {
  width: 100%;
}

.dd {
  width :100%;
  height:100%;
}
</style>
