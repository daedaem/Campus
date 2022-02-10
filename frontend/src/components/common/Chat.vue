<template>
  <div >
    <input type="checkbox" id="check" @click="showRooms()" > <label class="chat-btn" for="check" > <i class="fa fa-commenting-o comment" ></i> <i class="fa fa-close close" ></i> </label>
      <div class="wrapper">
        <div class="header">
          <div v-if="visible===0">
            <div v-for="(item,idx) in chatList" :key="idx" >
                <div @click="visibleCheck(),sendlist(item.id),temp(item.id,item.title),socketConnect(item.id)">
                  {{item}}
                </div>
            </div>
          </div>
          <div v-else >
              <!-- {{MessageList}} -->
              <div v-for="(item2,idx) in MessageList" :key="idx">
                <div v-bind:class="item2.style">
                  <h5 style="margin: 3px">
                    {{item2.senderNickname}}
                  </h5>
                  {{item2.content}}
                </div>
              </div>
              <input type="text" v-model="content"><button @click="sendMessage()">보내기</button>
              <button @click="visibleCheck(),delTrash(temps.id)" >뒤로가기</button>
              <!-- {{MessageList}} -->
              
          </div>
        </div>
      </div>
      
  </div>
  
</template>                            

<script>
import axios from 'axios'
import Stomp from 'webstomp-client'
import SockJS from 'sockjs-client'


// const SERVER_URL = `http://i6e102.p.ssafy.io`
const SERVER_URL = "http://localhost:8080"
export default {
  name : 'Chat',
  components : {

  },
  data: () => {
    return {
      id: -1,
      nickname: '',
      title:'',
      roomid:-1,
      idx:0,
      msg:[],
      content:"",
      stompClient:null,
      chatList : null,
      visible : 0,
      MessageList : [],
      temps : {
        id : null,
        title :null,
      },
      socketStop : [],
    }
  },
  created() {
    console.log('채팅창열림')
    // 채팅방 내용 불러오기
       
    
  },
  methods:{
    delTrash(roomNm){
      this.MessageList = []
      this.socketStop.push(roomNm)
      console.log(this.socketStop)
    },
    socketConnect(roomid){
      // socket 연결
      console.log(this.socketStop.includes(roomid))
      if (this.socketStop.includes(roomid) === false) {
          console.log('check')
        let socket = new SockJS('http://localhost:8080/ws')
        this.stompClient = Stomp.over(socket)
        this.stompClient.connect({}, frame=>{
          console.log("success", frame)
          this.stompClient.subscribe("/sub/"+roomid, res=>{
            let jsonBody = JSON.parse(res.body)
            let m={
              'senderNickname':jsonBody.senderNickname,
              'content': jsonBody.content,
              'style': jsonBody.senderId == this.$store.state.userList.userNo ? 'myMsg':'otherMsg'
            }
            
              console.log(m)
              this.MessageList.push(m)
            
          })
        }, err=>{
          console.log("fail", err)
        })
        }
    },
    temp(id,title) {
      this.temps.id = id
      this.temps.title = title
      
    },
    visibleCheck() {
      if (this.visible === 0) {
        this.visible = 1 
      } else {
        this.visible = 0
      }
    },
    showRooms() {
      console.log('오잉')
      console.log(this.$store.state.myNum)
      axios({
        method: 'get',
        url : `${SERVER_URL}/api/chat/rooms/${this.$store.state.myNum}`,
      })
      .then(res => {
        console.log(res.data)
        this.chatList = res.data
      })
      .catch(err => {
        console.log(err)
      })

      console.log(this.chatList)
      // axios({
      //    method:'get',
      //   url:'/api/chat/room/message/'+this.roomid+"?page="+this.idx,
      //   baseURL:'http://localhost:8080/'
      // })
      // .then(res=>{
      //   this.msg = []
      //   for(let i=res.data.length-1; i>-1; i--){
      //     let m={
      //       'senderNickname':res.data[i].senderNickname,
      //       'content':res.data[i].content,
      //       'style': res.data[i].senderId == this.id ? 'myMsg':'otherMsg'
      //     }
      //     this.msg.push(m)
      //   }
      // })
      // .catch(err=>{
      //   console.log(err)
      //   alert("error : 새로고침하세요")
      // })
    },

    sendlist(id) {
      axios({
        method : 'get',
        url : `${SERVER_URL}/api/chat/room/message/${id}`
      })
      .then(res => {
        console.log(res)
        this.MessageList = res.data.reverse()

      })
      .catch(err => {
        console.log(err)
      })
    },


    sendMessage(){
      const roomNo = this.temps.id
      const roomTitle = this.temps.title
      console.log('중복실행테스트')
      if(this.content.trim() !='' && this.stompClient!=null) {
          
          let chatMessage = {
            'title' : roomTitle,
            'content': this.content,
            'chatroomId' : roomNo,
            'senderNickname':this.$store.state.userList.userNickname,
            'senderId': this.$store.state.userList.userNo,
            'id':"0"
          }
          console.log(chatMessage)
          this.stompClient.send("/pub/message", JSON.stringify(chatMessage),{})
          this.content = ''
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

.header .myMsg{
text-align: right;

}
.otherMsg{
  text-align: left;

}

</style>