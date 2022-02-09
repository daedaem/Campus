<template>
  <div>
    가나다라마바사아잧카타파하
    <div>
    <input type="text" v-model="replyData.campRateReplyContent"><button @click="add">추가</button>
    </div>
  </div>
</template>

<script>
// const SERVER_URL = `http://i6e102.p.ssafy.io`
const SERVER_URL = "http://localhost:8080"
import axios from 'axios'
import {ref} from 'vue'


export default {
  name : "CampRatecomment",
  props : ['detailData'],
  setup(props) {
    const reviewData = ref(props.detailData)
    const replyData = ref({
      campRateNo : reviewData.value.campRateNo,
      campRateReplyContent : null,
    })

    axios({
      method :'get',
      url : `${SERVER_URL}/camp/rate/reply/${reviewData.value.campRateNo}`
    })
    .then(res =>{
      console.log(res)
    })
    .catch(err => {
      console.log(err)
    })

    const add = () => {
      axios({
        method : 'post',
        url : `${SERVER_URL}/camp/rate/reply`,
        data : replyData.value
      })
      .then( res => {
        console.log(res)
      })
      .catch( err => {
        console.log(err)
      })
    }
    console.log(reviewData.value)
    return {
      add,
      reviewData,
      replyData,
    }

  }

}
</script>

<style>

</style>