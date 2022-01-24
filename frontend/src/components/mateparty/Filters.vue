<template>
  <!-- <div class="filterbox">
    <div class="filterbox1">
      <b-button pill type="button" class="btn btn-secondary"  data-bs-toggle="modal" data-bs-target="#exampleModal1">
        날짜
      </b-button>
      
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
      <b-button pill type="button" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#exampleModal2">
        유형
      </b-button>
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
      <b-button pill button type="button" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#asd">
        스타일
      </b-button>
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
  
      <b-button pill button type="button" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#exampleModal33">
        기타
      </b-button>

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
    
          
  </div> -->
  <!-- <Modal4/> -->
  
  <button type="button" class="btn btn-secondary launch"  data-bs-toggle="modal" data-bs-target="#staticBackdrop"> <i class="fa fa-info"></i> 날짜
</button>
<div class="modal fade" id="staticBackdrop" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body ">
              <Modal1 @date-check="dateCheck"/>
            </div>
        </div>
    </div>
</div>
  <button type="button" class="btn btn-secondary launch" data-bs-toggle="modal" data-bs-target="#staticBackdrop2"> <i class="fa fa-info"></i> 유형
</button>
<div class="modal fade" id="staticBackdrop2" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body ">
              <Modal2 @camp-check="campCheck"/>
            </div>
        </div>
    </div>
</div>
  <button type="button" class="btn btn-secondary launch" data-bs-toggle="modal" data-bs-target="#staticBackdrop3"> <i class="fa fa-info"></i> 스타일
</button>
<div class="modal fade" id="staticBackdrop3" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body ">
              <Modal3 @style-check="styleCheck"/>
            </div>
        </div>
    </div>
</div>
  <button type="button" class="btn btn-secondary launch" data-bs-toggle="modal" data-bs-target="#staticBackdrop4"> <i class="fa fa-info"></i> 정렬
</button>
<div class="modal fade" id="staticBackdrop4" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-body ">
              <Modal4/>
            </div>
        </div>
    </div>
</div>
</template>

<script>
import Modal1 from  '../../components/mateparty/modal/Modal1.vue'
import Modal2 from  '../../components/mateparty/modal/Modal2.vue'
import Modal3 from  '../../components/mateparty/modal/Modal3.vue'
import Modal4 from  '../../components/mateparty/modal/Modal4.vue'



export default {
  name : 'Filters',
  components : {
    Modal1,
    Modal2,
    Modal3,
    Modal4,

  },
  setup() {
    const campCheck = (box) => {
      console.log(box)
    }
    const styleCheck = (box2) => {
      console.log(box2)
    }
    const dateCheck = (box3) => {
      console.log(box3)
    }


    return {
      campCheck,
      styleCheck,
      dateCheck,
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

.modal-content{
   border-radius: 45px;
}

.modal-body {

  border-radius: 45px;
  background: linear-gradient(#3a7bd5, #3a6073);
}
</style>