<template>
  <div class="filterbox">
    <div class="filterbox1">
      <!-- Button trigger modal -->
      <b-button pill type="button" class="btn btn-secondary"  data-bs-toggle="modal" data-bs-target="#exampleModal1">
        날짜
      </b-button>
      
      <!-- Modal -->
      <div class="modal fade" id="exampleModal1" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLabel">날짜 필터</h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
              <Modal1/>

            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
              <button type="button" class="btn btn-primary">Save changes</button>
            </div>
          </div>
        </div>
      </div>    
    </div>
    <div class="filterbox1">
      <!-- Button trigger modal -->
      <b-button pill type="button" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#exampleModal2">
        유형
      </b-button>
      <!-- Modal -->
      <div class="modal fade" id="exampleModal2" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLabel">캠핑 유형</h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
              <Modal2/>

            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
              <button type="button" class="btn btn-primary">Save changes</button>
            </div>
          </div>
        </div>
      </div>    
    </div>
    <div class=" filterbox1">
      <!-- Button trigger modal -->
      <b-button pill button type="button" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#asd">
        스타일
      </b-button>
      <!-- Modal -->
      <div class="modal fade" id="asd" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLabel">캠핑 스타일</h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
              <Modal3/>
       
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
              <button type="button" class="btn btn-primary">Save changes</button>
            </div>
          </div>
        </div>
      </div>    
    </div>
    <div class=" filterbox1">
      <!-- Button trigger modal -->
      <b-button pill button type="button" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#exampleModal33">
        기타
      </b-button>
      <!-- Modal -->
      <div class="modal fade" id="exampleModal33" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="exampleModalLabel">캠핑 기타</h5>
              <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
              <Modal4/>
           
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
              <button type="button" class="btn btn-primary">Save changes</button>
            </div>
          </div>
        </div>
      </div>    
    </div>
  
          
  </div>
  <!-- <Modal4/> -->
  
</template>

<script>
import Modal1 from  '../../components/mateparty/modal/Modal1.vue'
import Modal2 from  '../../components/mateparty/modal/Modal2.vue'
import Modal3 from  '../../components/mateparty/modal/Modal2.vue'
import Modal4 from  '../../components/mateparty/modal/Modal2.vue'



export default {
  name : 'Filters',
  components : {
    Modal1,
    Modal2,
    Modal3,
    Modal4,

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

<style scoped>
.filterbox {
  overflow: hidden;
}

.filterbox1 {
  float: left;
  width: 100px;
  height: 40px;
} 
</style>