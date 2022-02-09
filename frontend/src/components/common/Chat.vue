<template>
  <div >
    <input type="checkbox" id="check"> <label class="chat-btn" for="check"> <i class="fa fa-commenting-o comment"></i> <i class="fa fa-close close"></i> </label>
      <div class="wrapper">
        <div class="header">
          
        </div>
      </div>
  </div>
</template>

<script>
import axios from 'axios'
import Stomp from 'webstomp-client'
import SockJS from 'sockjs-client'

export default {
  name : 'Chat',
  data: () => {
    return {
      id: -1,
      nickname: '',
      title:'',
      roomid:-1,
      idx:0,
      msg:[],
      content:"",
      stompClient:null
    }
  },
  created() {
    // 채팅방 내용 불러오기
       axios({
         method:'get',
        url:'/api/chat/room/message/'+this.roomid+"?page="+this.idx,
        baseURL:'http://localhost:8080/'
      }).then(res=>{
        this.msg = []
        for(let i=res.data.length-1; i>-1; i--){
          let m={
            'senderNickname':res.data[i].senderNickname,
            'content':res.data[i].content,
            'style': res.data[i].senderId == this.id ? 'myMsg':'otherMsg'
          }
          this.msg.push(m)
        }
      }, err=>{
        console.log(err)
        alert("error : 새로고침하세요")
      })
    // socket 연결
     let socket = new SockJS('http://localhost:8080/ws')
    this.stompClient = Stomp.over(socket)
    this.stompClient.connect({}, frame=>{
      console.log("success", frame)
      this.stompClient.subscribe("/sub/"+this.roomid, res=>{
        let jsonBody = JSON.parse(res.body)
             let m={
            'senderNickname':jsonBody.senderNickname,
            'content': jsonBody.content,
            'style': jsonBody.senderId == this.id ? 'myMsg':'otherMsg'
          }
          this.msg.push(m)
      })
    }, err=>{
console.log("fail", err)
    })
  },
  methods:{
    sendMessage(){
     if(this.content.trim() !='' && this.stompClient!=null) {
        let chatMessage = {
          'content': this.content,
          'chatroomId' : this.roomid,
          'senderNickname':this.nickname,
          'senderId': this.id,
          'id':"0"
        }
        this.stompClient.send("/pub/message", JSON.stringify(chatMessage),{})
   
        this.content=''
    }
    }
  }
  
}
</script>

<style scoped>

body {
    background-color: #eee
}

.chat-btn {
    position: absolute;
    right: 14px;
    bottom: 30px;
    cursor: pointer
}

.chat-btn .close {
    display: none
}

.chat-btn i {
    transition: all 0.9s ease
}

#check:checked~.chat-btn i {
    display: block;
    pointer-events: auto;
    transform: rotate(180deg)
}

#check:checked~.chat-btn .comment {
    display: none
}

.chat-btn i {
    font-size: 22px;
    color: #fff !important
}

.chat-btn {
    width: 50px;
    height: 50px;
    display: flex;
    justify-content: center;
    align-items: center;
    border-radius: 50px;
    background-color: blue;
    color: #fff;
    font-size: 22px;
    border: none
}

.wrapper {
    position: absolute;
    right: 20px;
    bottom: 100px;
    width: 300px;
    background-color: #fff;
    border-radius: 5px;
    opacity: 0;
    transition: all 0.4s
}

#check:checked~.wrapper {
    opacity: 1
}

.header {
    padding: 13px;
    background-color: blue;
    border-radius: 5px 5px 0px 0px;
    margin-bottom: 10px;
    color: #fff
}

.chat-form {
    padding: 15px
}

.chat-form input,
textarea,
button {
    margin-bottom: 10px
}

.chat-form textarea {
    resize: none
}

.form-control:focus,
.btn:focus {
    box-shadow: none
}

.btn,
.btn:focus,
.btn:hover {
    background-color: blue;
    border: blue
}

#check {
    display: none !important
}
</style>