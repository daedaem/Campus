<template>
  <div>제목 : {{detailData.campRateTitle}}</div>
  <div>내용 : {{detailData.campRateContent}}</div>
  <div>닉네임 : {{detailData.userNickname}}</div>
  <div>시설 평가 : {{detailData.campRateFacility}}</div>
  <div>가격 평가 : {{detailData.campRatePrice}}</div>
  <div>청결 평가 : {{detailData.campRateCleanliness}}</div>
  <button @click="rev(detailData.campRateNo)">수정</button>
  <button @click="del(detailData.campRateNo)">삭제</button>
  <div>
  <CampRatecomment v-if="detailData.length != 0" :detailData="detailData"/>
  </div>

</template>

<script>
import axios from 'axios'
import {useRoute, useRouter} from 'vue-router'
import {ref} from 'vue'
import CampRatecomment from '@/components/campsite/CampRatecomment.vue'

const SERVER_URL = process.env.VUE_APP_SERVER_URL;
export default {
  name : 'Campratedetail',
  components :{
    CampRatecomment,
  },
  setup() {
    const route = useRoute()
    const router = useRouter()
    const rateNo = route.params.rateNo
    const detailData = ref([])


    axios({
      method : 'get',
      url : `${SERVER_URL}/camp/rate/detail/${rateNo}`
    })
    .then(res => {
      
      detailData.value = res.data.dto
    })
    .catch(err => {
      console.log(err)
    })

    console.log(detailData.value)

    const rev = (Nm) => {
      router.push({name : 'Campraterevise' ,params : { rateNo : Nm}})
    }

    const del = (Nm) => {
      axios({
        method : 'delete',
        url : `${SERVER_URL}/camp/rate/${Nm}`
        // url 수정필요
      })
      .then(res => {
        console.log(res)
        router.go(-1)
      })
      .catch(err => {
        console.log(err)
      })
    }


    return {
      detailData,
      rev,
      del,
    
    }
  }
}
</script>

<style>

</style>