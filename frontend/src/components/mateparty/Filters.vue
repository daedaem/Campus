<template>
<div class="filterbox">
  <button type="button" class="btn btn-secondary launch filterbox1"  data-bs-toggle="modal" data-bs-target="#staticBackdrop"> <i class="fa fa-info"></i> 날짜
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
  <button type="button" class="btn btn-secondary launch filterbox1" data-bs-toggle="modal" data-bs-target="#staticBackdrop2"> <i class="fa fa-info"></i> 유형
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
  <button type="button" class="btn btn-secondary launch filterbox1" data-bs-toggle="modal" data-bs-target="#staticBackdrop3"> <i class="fa fa-info"></i> 스타일
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
  <button type="button" class="btn btn-secondary launch filterbox1" data-bs-toggle="modal" data-bs-target="#staticBackdrop4"> <i class="fa fa-info"></i> 정렬
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
<button @click="cancleFilter">취소 </button>
    
</div>
</template>

<script>
import Modal1 from  '../../components/mateparty/modal/Modal1.vue'
import Modal2 from  '../../components/mateparty/modal/Modal2.vue'
import Modal3 from  '../../components/mateparty/modal/Modal3.vue'
import Modal4 from  '../../components/mateparty/modal/Modal4.vue'
import {ref,watch } from 'vue'
import { useRouter } from "vue-router";

export default {
  emits : ['filter-data'],
  name : 'Filters',
  components : {
    Modal1,
    Modal2,
    Modal3,
    Modal4,

  },
  
  setup(props,{emit}) {
    const router = useRouter()
    const allData = ref({
      date : ref(null),
      camp : ref(null),
      style : ref(null),
    })
    // const endData = ref([])

    const campCheck = (box) => {
      allData.value.camp= box
      
    }
    const styleCheck = (box2) => {
      allData.value.style= box2
      
    }
    const dateCheck = (box3) => {
      allData.value.date= box3
     
    }
    const cancleFilter = () => {
      
      router.go();
    }
  watch(
  () => allData,
  (state) => {
    // console.log('deep', state.value)
    emit('filter-data',state.value)
  },
  { deep: true }
  )


    return {
      campCheck,
      styleCheck,
      dateCheck,
      allData,
      cancleFilter
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
  margin-left: 0px;
} 

.modal-content{
   border-radius: 45px;
}

.modal-body {

  border-radius: 45px;
  background: linear-gradient(#3a7bd5, #3a6073);
}
</style>