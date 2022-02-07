<template>
  <body>
    <div>
      <img :src="detailData.firstImageUrl" alt="">
    </div>
    <div class="m-4">
      <h2 align = "left" >{{detailData.facltNm}}</h2>
      <div align="left">
        <div>
        <i class="bi bi-star-fill"></i><span>4.7</span> * <span>후기 90개</span>
        </div>
        <div>
          {{detailData.doNm}} {{detailData.sigunguNm}}
        </div>
        <hr>
        <div>
        
          <h4>캠핑장 소개</h4>
          <div>{{detailData.intro}}</div>
          <hr>
          <h4>편의시설 및 테마</h4>
          <div>{{detailData.sbrsEtc}}</div>
          <div>{{detailData.sbrsCl}}</div>
          <div>{{detailData.posblFcltyCl}}</div>
        </div>
        <hr>
        <Kakaomap v-if="detailData.length != 0" :detailData="detailData"/>

      </div>
    </div>
    
  </body>
</template>

<script>
import Kakaomap from '@/components/campsite/Kakaomap.vue'
// import {onMounted, } from 'vue'
import {useRoute} from 'vue-router'
import axios from 'axios'
import {ref} from 'vue'

export default {
  name : 'CampsiteDetail',
  components : {
    Kakaomap,
  },
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

@media (min-width: 768px) {
  body {
    width: 768px;
    margin: 0 auto;
    padding: 0 20px;
    background: beige; }

}
 



</style>