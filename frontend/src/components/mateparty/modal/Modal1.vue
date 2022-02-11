<template>
<div>
  <h4>날짜</h4>
  <Datepicker/>
  <Datepicker @date-in="dateIn" />
  
    <div align="center">
        <div class="col-sm-3">
        <a class="btn btn-lg" @click="sendData" @date-in="dateIn">
            <span data-bs-dismiss="modal">button</span>
        </a>
    </div>
</div>
</div>

</template>


<script>
import Datepicker from '@/components/mateparty/Datepicker.vue'
import 'vue3-date-time-picker/dist/main.css'
// import Datepicker from '../Datepicker.vue'
import {ref} from 'vue'

export default {
  emits : ['date-check'],
  name: 'Modal1',
  components: {
    Datepicker

  },
  setup(props,{emit}) {
    const myData = ref('')
    
    const dateIn = (val) => {myData.value = val}

    const sendData = () => {emit('date-check', myData.value)}
  
  
  return {
    dateIn,
    sendData,
  
 
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