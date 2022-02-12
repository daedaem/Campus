<template>
  <body>
    
  
    <div>
      <div class="btn-group filterbox1">
      <button class="btn dropdown-toggle" type="button" id="dropdownMenuClickable" data-bs-toggle="dropdown" data-bs-auto-close="false" aria-expanded="false" style="position:relative; color: #7ac4e1; z-index:10;">
        날짜
      </button>
      <Modal1 @date-check="dateCheck" style=" opacity: 0.1; position:absolute; z-index:10;" />
       </div>
        

    <div class="btn-group filterbox1">
      <button class="btn  dropdown-toggle" type="button" id="dropdownMenuClickable" data-bs-toggle="dropdown" data-bs-auto-close="false" aria-expanded="false" style="color: #7ac4e1;">
        유형
      </button>
      <ul class="dropdown-menu" aria-labelledby="dropdownMenuClickable">
        <Modal2 @date-check="dateCheck"/>
      </ul>
    </div>
    <div class="btn-group filterbox1">
      <button class="btn  dropdown-toggle" type="button" id="dropdownMenuClickable" data-bs-toggle="dropdown" data-bs-auto-close="false" aria-expanded="false" style="color: #7ac4e1;">
        스타일
      </button>
      <ul class="dropdown-menu" aria-labelledby="dropdownMenuClickable">
        <Modal3 @date-check="dateCheck"/>
      </ul>
    </div>
    <div class="btn-group filterbox1">
      <button class="btn  dropdown-toggle" type="button" id="dropdownMenuClickable" data-bs-toggle="dropdown" data-bs-auto-close="false" aria-expanded="false" style="color: #7ac4e1;">
        정렬
      </button>
      <ul class="dropdown-menu" aria-labelledby="dropdownMenuClickable">
        <Modal4 @date-check="dateCheck"/>
      </ul>
    </div>
    <div class="btn-group filterbox1">
      <button class="btn" type="button" aria-expanded="false" style="color: #7ac4e1;" @click="apply">
        적용
      </button>
      
    </div>
    
  </div>
  </body>
</template>

<script>
import Modal1 from  '../../components/mateparty/modal/Modal1.vue'
import Modal2 from  '../../components/mateparty/modal/Modal2.vue'
import Modal3 from  '../../components/mateparty/modal/Modal3.vue'
import Modal4 from  '../../components/mateparty/modal/Modal4.vue'
import {ref,} from 'vue'
import {useStore} from 'vuex'
import axios from "axios";
const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {
  emits : ['filter-data'],
  name : 'Filters',
  components : {
    Modal1,
    Modal2,
    Modal3,
    Modal4,

  },
  
  setup() {
    const store = useStore()

    const allData = ref({
      mateCampstart : store.state.dateCheck[0],
      mateCampend : store.state.dateCheck[1],
      mateCamptype : store.state.campCheck[0],
      // mateCampstyle : store.state.styleCheck,
      sortList : ref(null),
    })
    
    const apply = () =>{
      console.log(allData.value)
      axios({
          method : 'post',
          url : `${SERVER_URL}/mate/filter`,
          data : allData.value
        })
        .then(res => {
          console.log(res)
        })
        .catch(err => {
          console.log(err)
        })
    }
    // const endData = ref([])

    
  // watch(
  // () => allData,
  // (state) => {
  //   // console.log('deep', state.value)
  //   emit('filter-data',state.value)
  // },
  // { deep: true }
  // )


    return {
      apply,
      allData,
      

    }
  }
}
</script>

<style scoped>
@media (max-width: 599px) {
  .filterbox1 {
    float: left;
    width: 100px;
    height : 40px;
    margin-bottom: 10px;
  }
}


.filterbox {
  overflow: hidden;
}

.filterbox1 {
  float: left;
  width: 90px;
  height: 40px;
  margin-left: 0px;
  background-color: #fff;
  color: #7ac4e1;
  border: 3px solid #7ac4e1;
  border-radius: 30px;
  font-size : 14px;
  position : relative;
  
  
} 

.modal-content{
   border-radius: 45px;
}

.modal-body {

  border-radius: 45px;
  background: linear-gradient(#3a7bd5, #3a6073);
}




.dropdown-menu{
      height:200px;
      overflow-y:auto;
  }



</style>









