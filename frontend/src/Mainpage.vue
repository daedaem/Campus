<template>
  <body>
    <div class="box" style="width:100%; height:100vh;">
      <img width="100%" height="100%" src="@/assets/images/bonfire-gab201fb38_1920.jpg" alt="">
      <div class="overlay"> 
        <div>오른쪽으로 스와이프</div>  
          <a class="btn btn-lg" href="#">
              <span>계정 만들기</span>
          </a>
      </div>
    </div>
    <div class="filterbox">
      <div style="float:left; margin-left:20px; margin-top:50px; margin-bottom:30px;">지금 뜨는 메이트 모집</div>
      <div style="float:right; margin-right:20px; margin-top:50px;">전체보기</div>
    </div>
    <Maincarousel/>
    
    
  

  </body>
</template>

<script>
import Maincarousel from '@/components/mateparty/Maincarousel.vue'
import axios from 'axios'
import {useStore, } from 'vuex'
import {computed,  } from 'vue'

export default {
  name : 'Mainpage',
  components : {
    Maincarousel
  },

  setup() { 
    const store = useStore()
    // const ab = ref('')
    const viewFunc =  (data) => {
      // console.log(data)
      store.dispatch('viewMate',data)
      
    }
   
    const matelist = computed(() => store.state.mateList)
    axios({
      methods: 'get',
      url : 'http://localhost:8080/mate',
    })
    .then(res => {
      console.log(res.data.list)
      viewFunc(res.data.list)
      
    })

    .catch(err =>{
      console.log(err)
    })
  
    return {
      matelist,
     
    }
  }
  
}
</script>

<style scoped>
body {
  /* width: 100vw;
  height: 100vh; */
  /* margin: 0 auto; */
  /* padding: 0 20px; */
  /* background: beige; */
}

p {
  line-height: 6px;
}
.box {
  position : relative;
}

.overlay {
  position: absolute;
  /* display: flex;
  height : 100vh;
  justify-content: center;
  align-items: center; */
 top: 50%;
	left: 50%;
	transform: translate( -50%, -50% );
  padding: 5px;
  color : white;
  font-size : 50px;
}

.btn{
    color: #fff;
    background: linear-gradient(135deg, #ec5008, #dd12a0);
    font-family: 'Comfortaa', ;
    font-size: 22px;
    font-weight: 700;
    text-transform: lowercase;
    padding: 10px 20px;
    border: none;
    border-radius: 45px;
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


.filterbox{
  overflow: hidden;
}





</style>