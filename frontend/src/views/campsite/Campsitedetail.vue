<template>
  <!-- <body>
   <div class="hero">
      <div class="a">
        <img :src="detailData.firstImageUrl">
     
      </div>
      <div class="b">
        <div class="b1">
          <img src="http://unsplash.it/600x400?random">
          <h2>Title</h2>
        </div>
        <div class="b2">
          <img src="http://unsplash.it/600x500?random">
          <h2>Title</h2>
        </div>
      </div>
    </div>
    
  </body> -->
  <div class="a-box">
      <div class="img-container">
        <div class="img-inner">
          <div class="inner-skew">
            <img src="https://images.unsplash.com/photo-1584791097929-aa825fe8e1e1?ixlib=rb-1.2.1&q=85&fm=jpg&crop=entropy&cs=srgb&ixid=eyJhcHBfaWQiOjE0NTg5fQ">
          </div>
        </div>
      </div>
      <div class="text-container">
        <h3>A blue bird</h3>
        <div>
          This a demo experiment to skew image container. It looks good.
        </div>
      </div>
    </div>
  
</template>

<script>
// import {onMounted, } from 'vue'
import {useRoute} from 'vue-router'
import axios from 'axios'
import {ref} from 'vue'

export default {
  name : 'CampsiteDetail',
  
  setup() {
    const route = useRoute()
    const detailData = ref([])
    const id = route.params.contentId
    console.log(id)
    axios({
      method : 'get',
      url : `http://localhost:8080/camp/${id}`
    })
    .then(res => {
      detailData.value = res.data.dto
      console.log(detailData.value)
    })
    .catch(err => {
      
      console.log(err)
    })


    return {
      detailData,
    }
  }
}
</script>

<style scoped>

/* @media (min-width: 768px) {
  body {
    width: 768px;
    margin: 0 auto;
    padding: 0 20px;
    background: beige; }
  
  .hero {
  display: flex;
  height: 340px;
  }

  }

  
  .hero div {
    position: relative;
  }
  .hero img {
    object-fit: cover;
    width: 100%;
    height: 100%;
    display: block;
  }
  .hero h2 {
    position: absolute;
    bottom: 0;
    left: 0;
    color: white;
    font-weight: normal;
    margin: 10px;
  }
  .a, .b {
    flex: 1;
  }
  .b {
    display: flex;
    flex-direction: column;
    height: 100%;
  }
  .b1, .b2 {
    height: 50%;
  }
  .a:before,
  .b1:before,
  .b2:before {
    content: '';
    position: absolute;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
    background-image: linear-gradient(
            to bottom,
            rgba(20, 20, 20, 0) 10%,
            rgba(20, 20, 20, 0.25) 25%,
            rgba(20, 20, 20, 0.5) 50%,
            rgba(160, 160, 160, 0.75) 75%,
            rgb(255, 255, 255) 100%
          );
    
    opacity: .6;
  } */
.topbody {
  text-align: center;
  padding: 30px;
  background: #f8f4f2;
  font-family: Arial;
}

.a-box {
  display: inline-block;
  width: 240px;
  text-align: center;
}

.img-container {
    height: 230px;
    width: 200px;
    overflow: hidden;
    border-radius: 0px 0px 20px 20px;
    display: inline-block;
}

.img-container img {
    transform: skew(0deg, -13deg);
    height: 250px;
    margin: -35px 0px 0px -70px;
}

.inner-skew {
    display: inline-block;
    border-radius: 20px;
    overflow: hidden;
    padding: 0px;
    transform: skew(0deg, 13deg);
    font-size: 0px;
    margin: 30px 0px 0px 0px;
    background: #c8c2c2;
    height: 250px;
    width: 200px;
}

.text-container {
  box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.2);
  padding: 120px 20px 20px 20px;
  border-radius: 20px;
  background: #fff;
  margin: -120px 0px 0px 0px;
  line-height: 19px;
  font-size: 14px;
}

.text-container h3 {
  margin: 20px 0px 10px 0px;
  color: #04bcff;
  font-size: 18px;
}
</style>