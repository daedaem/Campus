<template>
<body>
  <div class="container-fluid h-100">
    <div class="row justify-content-center h-100">
      <input type="checkbox" id="check" @click="showRooms()" > <label class="chat-btn" for="check" > <i class="fa fa-commenting-o comment" ></i> <i class="fa fa-close close" ></i> </label>
        <div class="wrapper">
          <div class="header">
            
          <div v-if="visible===0">
            <div class="col-md-12 col-xl-12 chat"><div class="card mb-sm-12 mb-md-12 contacts_card">
              <div class="card-body contacts_body">
                <ul class="contacts">
                  <li>
             
             
                  <div v-for="(item,idx) in chatList" :key="idx" >

                    <div class="d-flex bd-highlight">
                      <div class="user_info">
                        <div @click="visibleCheck(),sendlist(item.id),temp(item.id,item.title),socketConnect(item.id)">
                          <span>{{item.title}}</span>
                        </div>
                      </div>
                    </div>
                  </div>
                
                  </li>
                </ul>
              
                </div></div>
          </div>
          
          
          
          
            </div>
          <div v-else >
            <div class="col-md-12 col-xl-12 chat">
              <div class="card"> 
                <div class="card-body msg_card_body">
                  <div v-for="(item2,idx) in MessageList" :key="idx">
                    <div v-bind:class="item2.style">
                        <div class="msg_cotainer">
                          {{item2.content}}
                          <span class="msg_time">{{item2.senderNickname}}</span>
                        </div>
                      </div>
                  </div>

 
                  <button @click="visibleCheck(),delTrash(temps.id)" >뒤로가기</button>  
                  <div class="card-footer">
                    <div class="input-group">
                      <textarea name="" class="form-control type_msg" placeholder="Type your message..." v-model="content"></textarea>
                      <div class="input-group-append">
                        <span class="input-group-text send_btn" @click="sendMessage()"><i class="fas fa-location-arrow"></i></span>
                      </div>
                    </div>
                  </div>         
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</template>                            

<script>
import axios from 'axios'
import Stomp from 'webstomp-client'
import SockJS from 'sockjs-client'


const SERVER_URL = process.env.VUE_APP_SERVER_URL;
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
        let socket = new SockJS(`${SERVER_URL}/ws`)
        this.stompClient = Stomp.over(socket)
        this.stompClient.connect({}, frame=>{
          console.log("success", frame)
          this.stompClient.subscribe("/sub/"+roomid, res=>{
            let jsonBody = JSON.parse(res.body)
            let m={
              'senderNickname':jsonBody.senderNickname,
              'content': jsonBody.content,
              'style': jsonBody.senderId == this.$store.state.userList.userNo ? "d-flex justify-content-end mb-4 my":'d-flex justify-content-start mb-4 your'
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
        const temp = res.data
        temp.forEach(e => {
          if (e.senderId === this.$store.state.userList.userNo) {
            e['style'] = 'd-flex justify-content-end mb-4 my'
          } else {
            e['style'] = 'd-flex justify-content-start mb-4 your'
          }
          
        });
        console.log(temp)
        this.MessageList = temp.reverse()

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
    border: none;
    position: fixed;
    z-index: 10001;
}

.wrapper {
    position: absolute;
    right: 20px;
    bottom: 100px;
    width: 400px;
    background-color: #fff;
    border-radius: 5px;
    opacity: 0;
    transition: all 0.4s
}

#check:checked~.wrapper {
    opacity: 1
}

.header {
    position: fixed;
    z-index: 10001;
    padding: 13px;
    /* background-color: blue; */
    border-radius: 5px 5px 0px 0px;
    margin-bottom: 10px;
    color: #fff;
    bottom : 80px;
    right : 20px;
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


body{
    
    height: 100%;
    margin: 0;
    background: #7F7FD5;
        background: -webkit-linear-gradient(to right, #91EAE4, #86A8E7, #7F7FD5);
        background: linear-gradient(to right, #91EAE4, #86A8E7, #7F7FD5);
    
  }

  .chat{
    margin-top: auto;
    margin-bottom: auto;
  }
  .card{
    height: 500px;
    border-radius: 15px !important;
    background-color: #98cde2 !important;
  }
  .contacts_body{
    padding:  0.75rem 0 !important;
    overflow-y: auto;
    white-space: nowrap;
  }
  .msg_card_body{
    overflow-y: auto;
  }
  .card-header{
    border-radius: 15px 15px 0 0 !important;
    border-bottom: 0 !important;
  }
  .card-footer{
  border-radius: 0 0 15px 15px !important;
    border-top: 0 !important;
}
  .container{
    align-content: center;
  }
  .search{
    border-radius: 15px 0 0 15px !important;
    background-color: rgba(0,0,0,0.3) !important;
    border:0 !important;
    color:white !important;
  }
  .search:focus{
        box-shadow:none !important;
          outline:0px !important;
  }
  .type_msg{
    background-color: rgba(0,0,0,0.3) !important;
    border:0 !important;
    color:white !important;
    height: 60px !important;
    overflow-y: auto;
  }
    .type_msg:focus{
        box-shadow:none !important;
          outline:0px !important;
  }
  .attach_btn{
border-radius: 15px 0 0 15px !important;
background-color: rgba(0,0,0,0.3) !important;
    border:0 !important;
    color: white !important;
    cursor: pointer;
  }
  .send_btn{
border-radius: 0 15px 15px 0 !important;
background-color: rgba(0,0,0,0.3) !important;
    border:0 !important;
    color: white !important;
    cursor: pointer;
    height : 60px;
  }
  .search_btn{
    border-radius: 0 15px 15px 0 !important;
    background-color: rgba(0,0,0,0.3) !important;
    border:0 !important;
    color: white !important;
    cursor: pointer;
  }
  .contacts{
    list-style: none;
    padding: 0;
  }
  .contacts li{
    width: 100% !important;
    padding: 5px 10px;
    margin-bottom: 15px !important;
  }
.active{
    background-color: rgba(0,0,0,0.3);
}
  .user_img{
    height: 70px;
    width: 70px;
    border:1.5px solid #f5f6fa;
  
  }
  .user_img_msg{
    height: 40px;
    width: 40px;
    border:1.5px solid #f5f6fa;
  
  }
.img_cont{
    position: relative;
    height: 70px;
    width: 70px;
}
.img_cont_msg{
    height: 40px;
    width: 40px;
}
.online_icon{
  position: absolute;
  height: 15px;
  width:15px;
  background-color: #4cd137;
  border-radius: 50%;
  bottom: 0.2em;
  right: 0.4em;
  border:1.5px solid white;
}
.offline{
  background-color: #c23616 !important;
}
.user_info{
  margin-top: auto;
  margin-bottom: auto;
  margin-left: 15px;
}
.user_info span{
  font-size: 20px;
  color: white;
}
.user_info p{
font-size: 10px;
color: rgba(255,255,255,0.6);
}
.video_cam{
  margin-left: 50px;
  margin-top: 5px;
}
.video_cam span{
  color: white;
  font-size: 20px;
  cursor: pointer;
  margin-right: 20px;
}
.msg_cotainer{
  margin-top: auto;
  margin-bottom: auto;
  margin-left: 10px;
  border-radius: 25px;
  background-color: #82ccdd;
  padding: 10px;
  position: relative;
}
.msg_cotainer_send{
  margin-top: auto;
  margin-bottom: auto;
  margin-right: 10px;
  border-radius: 25px;
  background-color: #78e08f;
  padding: 10px;
  position: relative;
}
.msg_time{
  position: absolute;
  left: 0;
  bottom: -15px;
  color: rgba(255,255,255,0.5);
  font-size: 10px;
}
.msg_time_send{
  position: absolute;
  right:0;
  bottom: -15px;
  color: rgba(255,255,255,0.5);
  font-size: 10px;
}
.msg_head{
  position: relative;
}
#action_menu_btn{
  position: absolute;
  right: 10px;
  top: 10px;
  color: white;
  cursor: pointer;
  font-size: 20px;
}
.action_menu{
  z-index: 1;
  position: absolute;
  padding: 15px 0;
  background-color: rgba(0,0,0,0.5);
  color: white;
  border-radius: 15px;
  top: 30px;
  right: 15px;
  display: none;
}
.action_menu ul{
  list-style: none;
  padding: 0;
margin: 0;
}
.action_menu ul li{
  width: 100%;
  padding: 10px 15px;
  margin-bottom: 5px;
}
.action_menu ul li i{
  padding-right: 10px;

}
.action_menu ul li:hover{
  cursor: pointer;
  background-color: rgba(0,0,0,0.2);
}
@media(max-width: 576px){
.contacts_card{
  margin-bottom: 15px !important;
}
}

.my > .msg_cotainer{
  background-color:rgb(251, 255, 0);

}

.your > .msg_cotainer{
  background-color : white;
}
</style>