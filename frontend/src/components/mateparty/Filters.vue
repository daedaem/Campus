<template>
  <body>
    
  <div class="container">
    <div class="row">
    
      <div class="btn-group filterbox1 col-4" style="margin-left:0px;">
      <button class="btn dropdown-toggle" type="button" id="dropdownMenuClickable" data-bs-toggle="dropdown" data-bs-auto-close="false" aria-expanded="false" style="position:relative; color: #7ac4e1; z-index:10;">
        날짜
      </button>
      <Modal1 @date-check="dateCheck" style=" opacity: 0.1; position:absolute; z-index:10;" />
       </div>
        

    <div class="btn-group filterbox1 col-4" >
      <button class="btn  dropdown-toggle" type="button" id="dropdownMenuClickable" data-bs-toggle="dropdown" data-bs-auto-close="false" aria-expanded="false" style="color: #7ac4e1;">
        유형
      </button>
      <ul class="dropdown-menu" aria-labelledby="dropdownMenuClickable">
        <Modal2 @camp-check="campCheck"/>
      </ul>
    </div>
    <div class="btn-group filterbox1 col-4">
      <button class="btn  dropdown-toggle" type="button" id="dropdownMenuClickable" data-bs-toggle="dropdown" data-bs-auto-close="false" aria-expanded="false" style="color: #7ac4e1;">
        테마
      </button>
      <ul class="dropdown-menu" aria-labelledby="dropdownMenuClickable">
        <Modal3 @style-check="styleCheck"/>
      </ul>
    </div>
    <div class="btn-group filterbox1 col-4">
      <button class="btn  dropdown-toggle" type="button" id="dropdownMenuClickable" data-bs-toggle="dropdown" data-bs-auto-close="false" aria-expanded="false" style="color: #7ac4e1;">
        정렬
      </button>
      <ul class="dropdown-menu" aria-labelledby="dropdownMenuClickable">
        <Modal4 @sort-check="sortCheck"/>
      </ul>
    </div>
    <div class="btn-group filterbox1-apply col-4">
      <button class="btn" type="button" aria-expanded="false" style="color: #fff;" @click="apply">
        적용
      </button>
      
    </div>
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
  
  setup(props,{emit}) {
    const store = useStore()
    const allData = ref({
      mateCampstart : null,
      mateCampend : null,
      mateCamptype : null,
      campStyleList : {
        style1 : null,
        style2 : null,
        style3 : null
      },
      sortList : ref(null),
    })
    const filterInit = ref(0)
    
    const apply = () =>{

      console.log(allData.value)
      axios({
          method : 'post',
          url : `${SERVER_URL}/mate/filter`,
          data : allData.value
      })
      .then(res => {
        console.log(res)
        if (res.data.dto.matefilter === -1) {
          alert('검색 결과가 없습니다.')
        } else {
          emit('filter-data',res)
          allData.value.mateCampstart = null
          allData.value.mateCampend = null
          if (store.state.initData === 0) {
            store.dispatch('initData',1)
          } else {
            store.dispatch('initData',0)
          }
        }
        
      })
      .catch(err => {
        console.log(err)
      })
    }


    const dateCheck = (val) => {
      console.log(val)
      allData.value.mateCampstart = val[0]
      allData.value.mateCampend = val[1]
      console.log(allData.value)
       
    }
    const styleCheck = (val) => {
      console.log(val)
      if (val) {
        if (val.length === 1) {
          allData.value.campStyleList.style1 =val[0];
    
        } else if (val.length === 2) {
          allData.value.campStyleList.style1 = val[0] 
          allData.value.campStyleList.style2 = val[1] 
           
            
   
        } else if (val.length === 3) {
         allData.value.campStyleList.style1 = val[0]
         allData.value.campStyleList.style2 = val[1]
         allData.value.campStyleList.style3 = val[2]
          
          }
        }
      console.log(allData.value)
      }

    

    const campCheck = (val) => {
      
      allData.value.mateCamptype = val
      console.log(allData.value)
    }
    // const sortCheck = (val) => {
    //   console.log(val.value)
    // }

   
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
      dateCheck,
      campCheck,
      styleCheck,
      // sortCheck,
      filterInit,
      

    }
  }
}
</script>

<style scoped>
@media (min-width: 599px) {
  .filterbox1 {
    float: left;
  width: 80px;
  height: 30px;
  margin-bottom: 10px;
  background: #fff;
  border:0.5px solid #ccc;
  font:black;
  margin-left: 20px;
  font-size : 14px;
  }
}


.filterbox {
  overflow: hidden;
}

.filterbox1 {
  float: left;
  width: 90px;
  height: 40px;
 
  background-color: #fff;
  color: #7ac4e1;
  border: 2px solid #7ac4e1;
  border-radius: 30px;
  font-size : 14px;
  margin:5px;
  position : relative;
  
  
} 
.filterbox1-apply{
    float: left;
  width: 90px;
  height: 40px;
 
  background-color: #7ac4e1;
  color: #fff;
  border: 3px solid #7ac4e1;
  border-radius: 30px;
  font-size : 14px;
  margin:5px;
  position : relative;
}
.modal-content{
   border-radius: 45px;
}
.buttonfont{
    font-size:12px
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









