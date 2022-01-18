<template>
  <body>
    <h1>Mate party</h1>
    <div class="filterbox">
      <b-button  v-b-modal.modal-1 class="filterbox1" pill>날짜</b-button>
      <b-modal id="modal-1" title="BootstrapVue">
        <p class="my-4">1</p>
      </b-modal>
      <b-button  v-b-modal.modal-2 class="filterbox1" pill>유형</b-button>
      <b-modal id="modal-2" title="BootstrapVue">
        <p class="my-4">2</p>
      </b-modal>
      <b-button  v-b-modal.modal-3 class="filterbox1" pill>스타일</b-button>
      <b-modal id="modal-3" title="BootstrapVue">
        <p class="my-4">3</p>
      </b-modal>
      <b-button  v-b-modal.modal-4 class="filterbox1" pill>정렬</b-button>
      <b-modal id="modal-4" title="BootstrapVue">
        <p class="my-4">4</p>
      </b-modal>
    </div>
    
    <h2>캠핑 검색 결과</h2>
    <Pagination/>    

  </body>
</template>

<script>
import Pagination from '../../components/mateparty/Pagination.vue'
export default {
  components: { 
    Pagination,
  },
  name : 
    'Mateparty'
  ,
}
</script>

<style scoped>
body {
  width: 768px;
  margin: 0 auto;
  padding: 0 20px;
  background: beige;
}

.filterbox {
  overflow: hidden;
}

.filterbox1 {
  float: left;
  width: 70px;
  height: 40px;
  margin-left: 20px;
} 

</style>