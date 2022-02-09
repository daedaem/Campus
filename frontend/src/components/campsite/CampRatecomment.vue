<template>
  <div>
    <span>!코멘트리스트!</span>
    <div v-for="(item,idx) in commentList" :key="idx">
      {{item.campRateReplyContent}}
      <button v-if="myNo===item.userNo" @click="del(item.campRateReplyNo,idx)"></button>
    </div>
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
import {useStore} from 'vuex'

export default {
  name : "CampRatecomment",
  props : ['detailData'],
  setup(props) {
    const store = useStore()
    const commentList = ref([])
    const reviewData = ref(props.detailData)
    const replyData = ref({
      campRateNo : reviewData.value.campRateNo,
      campRateReplyContent : null,
      userNo : store.state.myNum,
    })
    
    const myNo = store.state.myNum
    axios({
      method :'get',
      url : `${SERVER_URL}/camp/rate/reply/${reviewData.value.campRateNo}`
    })
    .then(res =>{
      commentList.value = res.data.list
    })
    .catch(err => {
      console.log(err)
    })

    const add = () => {
      commentList.value.push({
        campRateNo : reviewData.value.campRateNo,
        campRateReplyContent : replyData.value.campRateReplyContent,
        userNo : store.state.myNum
      })
      
      let form = new FormData()
      form.append("campRateNo",reviewData.value.campRateNo)
      form.append("campRateReplyContent",replyData.value.campRateReplyContent)
      form.append("userNo",store.state.myNum)
      axios({
        method : 'post',
        url : `${SERVER_URL}/camp/rate/reply`,
        data : form
      })
      .then( res => {
        console.log(res)
      })
      .catch( err => {
        console.log(err)
      })
      replyData.value.campRateReplyContent = ''
    }
    console.log(reviewData.value)
    console.log(commentList.value)

    const del = (ReplyNo,idx) => {
      console.log(idx)
      // console.log(ReplyNo)
      // localStorage.removeItem(item)
      commentList.value.splice(idx,1)
      axios({
        method : 'delete',
        url : `${SERVER_URL}/camp/rate/reply/${ReplyNo}`
      })
      .then(res => {
        console.log(res)
      })
      .catch(err => {
        console.log(err)
      })

    }
    return {
      add,
      reviewData,
      replyData,
      commentList,
      myNo,
      del,
    }

  }

}
</script>

<style>

</style>