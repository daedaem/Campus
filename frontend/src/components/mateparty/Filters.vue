<template>
  <div class="filterbox">
    <b-button  v-b-modal.modal-1 class="filterbox1" pill>날짜</b-button>
    <b-modal id="modal-1" title="BootstrapVue">
      <h4>날짜 필터</h4>
      <!-- <Modal1/> -->
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
 
</template>

<script>
// import Modal1 from  '../../components/mateparty/modal/Modal1.vue'

export default {
  name : 'Filters',
  components : {
    // Modal1,
  },
  data() {
    return {
      range: {
        start: new Date(2020, 0, 1),
        end: new Date(2020, 0, 5)
      },

      masks: {
        input: 'YYYY-MM-DD h:mm A',
      },
      selected: [], // Must be an array reference!
      options: [
        { text: 'Orange', value: 'orange' },
        { text: 'Apple', value: 'apple' },
        { text: 'Pineapple', value: 'pineapple' },
        { text: 'Grape', value: 'grape' }
      ]

    }
  }
}
</script>

<style>
.filterbox {
  overflow: hidden;
}

.filterbox1 {
  float: left;
  width: 80px;
  height: 40px;
  margin-left: 20px;
} 
</style>