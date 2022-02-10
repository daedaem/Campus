<template>
  <div>
    <span>!코멘트리스트!</span>
    <div v-for="(item,idx) in commentList" :key="idx">
      <span v-if="visible===0">{{item.campRateReplyContent}}(내용) |</span>  <img :src="item.userProfileImage" alt="">{{item.userNickname}}(닉네임)
      <span v-if="myNo===item.userNo">
        <span v-if="visible ===0">
          <button  @click="revBtn">수정</button>
        </span>
        <span v-else >
          
          <input type="text" v-model="revText"><button @click="rev(item.campRateReplyNo)">확인</button><button @click="revBtn">취소</button>

        </span>
        <button  @click="del(item.campRateReplyNo,idx)" v-if="visible===0">삭제</button>
      </span>
    </div>
    <div>
    <input type="text" v-model="replyData.campRateReplyContent"><button @click="add">추가</button>
    </div>
    
  </div>
<!-- rev(item.campRateReplyNo,idx) -->
  
</template>

<script>
const SERVER_URL = process.env.VUE_APP_SERVER_URL;

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
    const revText = ref('')
    const visible = ref(0)
    const revBtn = () => {
      if (visible.value === 0) {
        visible.value = 1
      } else {
        visible.value = 0
      }
    }
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
      // commentList.value.push({
      //   campRateNo : reviewData.value.campRateNo,
      //   campRateReplyContent : replyData.value.campRateReplyContent,
      //   userNo : store.state.myNum
      // })
      
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
    const rev = (ReplyNo) => {
      revBtn()
      let form = new FormData()
      form.append("campRateReplyNo" , ReplyNo)
      form.append("campRateNo",reviewData.value.campRateNo)
      form.append("campRateReplyContent",revText.value)
      form.append("userNo",store.state.myNum)

     
      axios({
        method : 'put',
        url : `${SERVER_URL}/camp/rate/reply`,
        data : form
      })
      .then( res => {
        console.log(res)
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
      })
      .catch( err => {
        console.log(err)
      })
      revText.value = ''
      
    }
    return {
      add,
      reviewData,
      replyData,
      commentList,
      myNo,
      del,
      rev,
      visible,
      revBtn,
      revText,
    }

  }

}
</script>

<style>

</style>