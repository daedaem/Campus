<template>
  <body>
    <h1>Mate party</h1>
    <Searchbar style="margin:20px 0;"/>
    <Filters @filter-data="filterData"/>
    <Newmodal/>
    
    <div>
      <div style="margin-top:20px" align="left">캠핑 검색 결과</div><span style="margin-left: 500px;"><b-button pill style="width: 100px; height: 40px;"  clcik="goMakeparty">글 작성</b-button></span>
    </div>
    <Pagination v-if="matelists" :matelists="matelists" :filterlist="filterlist"/>    
    <!-- {{matelists}} -->
    
  </body>
</template>

<script>
import Pagination from '../../components/mateparty/Pagination.vue'
import Filters from '@/components/mateparty/Filters.vue'
import Newmodal from '@/components/mateparty/Newmodal.vue'
import Searchbar from '../../components/mateparty/Searchbar.vue'
// import {mapState} from 'vuex'
import router from "@/router";
import { ref,  } from 'vue'
import { useStore } from 'vuex'
// import {mapState} from 'vuex'
// import axios from 'axios'



export default {
  props : {
    filterlist : Array,
  },
  components: { 
    Pagination,
    Filters,
    Newmodal,
    Searchbar
  },

  name :
    'Mateparty'
  ,

  setup() {
    const store = useStore()
    const goMakeparty = () => { router.push({name: 'Makeparty'})}
    
    const matelists =  store.state.mateList
    const filterlist = ref('')
    const test = ref(matelists)

    const filterData = (val) => {
      
      filterlist.value = val
      console.log(filterlist.value)

      

      if (filterlist.value.camp) {
        filterlist.value.camp.forEach((item) => {

        test.value = test.value.camp.includes(item)
          
        })
      }

      // const filterUtil = computed(() => {
      //   filterlist.value.date.forEach((item) => {
      //     console.log(item)
      //   })
      // })
      // return console.log(1)
      
      
    }
      
    
    
    
   
    
  
    return {
      matelists,
      goMakeparty,
      filterData,
      test
      
      
      
    }
    
    

  }

  
  
}
</script>

<style scoped>
@media (min-width: 768px) {
  body {
    width: 100%;
    margin: 0 auto;
    padding: 0 20px;
    background: beige; }
  }


.test {
  width :100%;
}

</style>