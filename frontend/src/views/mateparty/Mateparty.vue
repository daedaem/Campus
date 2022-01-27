<template>
  <body>
    <h1>Mate party</h1>
    <Searchbar style="margin:20px 0;"/>
    <Filters/>
    <Newmodal/>
    
    <div>
      <!-- <div style="margin-top:20px" align="left">캠핑 검색 결과</div><span style="margin-left: 500px;"><b-button pill style="width: 100px; height: 40px;" @click="goMakeparty">글 작성</b-button></span> -->
    </div>
    <Pagination/>    
    
  </body>
</template>

<script>
import Pagination from '../../components/mateparty/Pagination.vue'
import Filters from '@/components/mateparty/Filters.vue'
import Newmodal from '@/components/mateparty/Newmodal.vue'
import Searchbar from '../../components/mateparty/Searchbar.vue'
import {mapState} from 'vuex'
export default {
  data() {
    return {

    }
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

  methods : {
    goMakeparty() {
      this.$router.push({name: 'Makeparty'})
    }
  },

  computed : {
    ...mapState(['mateList'])
  },

  create() {
    console.log(this.mateList)
  }
}
</script>

<style scoped>
@media (min-width: 768px) {
  body { width: 768px;
  /* width : 768px; */
  margin: 0 auto;
  padding: 0 20px;
  background: beige; } }


.test {
  width :100%;
}

</style>