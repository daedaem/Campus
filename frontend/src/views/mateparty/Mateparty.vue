<template>
  <body>
    <h1>Mate party</h1>
    <Filters/>
    <div>
      <span>캠핑 검색 결과</span><span style="margin-left: 500px;"><b-button pill style="width: 100px; height: 40px;" @click="goMakeparty">글 작성</b-button></span>
    </div>
    <Pagination/>    

  </body>
</template>

<script>
import Pagination from '../../components/mateparty/Pagination.vue'
import Filters from '../../components/mateparty/Filters.vue'
export default {
  data() {
    return {

    }
  },

  components: { 
    Pagination,
    Filters,
  },

  name : 
    'Mateparty'
  ,

  methods : {
    goMakeparty() {
      this.$router.push({name: 'Makeparty'})
    }
  }
}
</script>

<style scoped>
body {
  width: 768px;
  margin: 0 auto;
  padding: 0 20px;
  background: beige;
}



</style>