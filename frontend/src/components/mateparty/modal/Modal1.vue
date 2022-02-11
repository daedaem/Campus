<template>
<div>
  <Datepicker @date-in="dateIn" />
</div>

</template>


<script>
import Datepicker from '@/components/mateparty/Datepicker.vue'
import 'vue3-date-time-picker/dist/main.css'
// import Datepicker from '../Datepicker.vue'
// import {ref} from 'vue'
// const date = ref(new Date())
// const dateFrom = ref(new Date())
import {useStore} from 'vuex'
export default {

  name: 'Modal1',
  components: {
    Datepicker

  },
  setup() {
    const dateFormat = (date) => {
        let month = date.getMonth() + 1;
        let day = date.getDate();
       

        month = month >= 10 ? month : '0' + month;
        day = day >= 10 ? day : '0' + day;
       

        return date.getFullYear() + '-' + month + '-' + day
      }
    const store = useStore()    
    const dateIn = (val) => {
      if (val) {
        const start = dateFormat(val[0])
        const end = dateFormat(val[1])
        const data = [start,end]
        store.dispatch('dateCheck',data)
      }
      }
    

  
   
  
    
  return {
    dateIn,
    dateFormat

  
 
  }
  
  }
  

}
</script>

<style scoped>
.box {
  visibility: hidden;
}

.btn{
    color: #fff;
    background: linear-gradient(135deg, #ffbb00, #3f300e);

    font-size: 22px;
    font-weight: 700;
    text-transform: lowercase;
    padding: 10px 20px;
    border: none;
    border-radius: 15px;
    overflow: hidden;
    position: relative;
    transition: all 0.3s cubic-bezier(0.02, 0.01, 0.47, 1);
}
.btn:hover{
    color: #fff;
    border: none;
    box-shadow: 0 0 10px rgba(0,0,0,0.3);
    animation: rotate 0.7s ease-in-out both;
}
.btn:before,
.btn:after{
    content: '';
    background: #fff;
    width: 100px;
    height: 100px;
    border-radius: 50%;
    opacity: 0;
    transform: translate(100%, -25%) translate3d(0, 0, 0);
    position: absolute;
    right: 0;
    bottom: 0;
    z-index: -1;
    transition: all 0.15s cubic-bezier(0.02, 0.01, 0.47, 1);
}
.btn:hover:before,
.btn:hover:after{
    opacity: 0.15;
}
.btn:hover:before{ transform: translate3d(50%, 0, 0) scale(0.9); }
.btn:hover:after{ transform: translate(50%, 0) scale(1.1); }
@keyframes rotate{
    0%{ transform: rotate(0deg); }
    25%{ transform: rotate(3deg); }
    50%{ transform: rotate(-3deg); }
    75%{ transform: rotate(1deg); }
    100%{ transform: rotate(0deg); }
}
@media only screen and (max-width: 767px){
    .btn{ margin-bottom: 20px; }
}
</style>