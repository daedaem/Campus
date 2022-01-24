<template>
<div>
  <h4>날짜</h4>
  <!-- <Datepicker class="box" v-model="date1" range></Datepicker> -->
  <Datepicker v-model="date"></Datepicker>
  <Datepicker v-model="date" range></Datepicker>
    <div align="center">
        <div class="col-sm-3">
        <a class="btn btn-lg" href="#" @click="$emit('date-check',date)">
            <span>button</span>
        </a>
    </div>
</div>
</div>
</template>


<script>
import Datepicker from 'vue3-date-time-picker'
import 'vue3-date-time-picker/dist/main.css'
import { ref, onMounted } from 'vue';


export default {
  name: 'Modal1',
  emits : ['date-check'],
  components: {
    Datepicker,
  },
  setup() {
        const date = ref();

        // For demo purposes assign range from the current date
        onMounted(() => {
            const startDate = new Date();
            const endDate = new Date(new Date().setDate(startDate.getDate() + 7));
            date.value = [startDate, endDate];
        })
        
        return {
            date,
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