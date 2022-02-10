<template>
  <div class="home">
    <h2>채팅 입장</h2>
    <input type="text" v-model="id" placeholder="ID" />
    <input type="text" v-model="nickname" placeholder="NICKNAME" />
    <br />

    <input type="button" @click="enterChatRoom()" value="ENTER" />
    <input type="button" @click="createUser()" value="CREATE" />
  </div>
</template>

<script>
import axios from 'axios'
export default {
    data: () => {
    return {
      id: 0,
      nickname: '',
      randomNick : ['익명의 비버','익명의 고양이', '익명의 토끼', '익명의 사자', '익명의 악어','익명의 펭귄','익명의 올빼미','익명의 라이언','익명의 무지','익명의 어피치','익명의 죠르디', '베어그릴스' ]
    }
  },
  methods:{
    randomItem(a) { return a[Math.floor(Math.random()* a.length)] },
    enterChatRoom() {    
       axios({
        method:'post',
        url:'/api/chat/llogin',
        baseURL:`${SERVER_URL}/`,
        headers:{'content-type': 'application/json'},
        data : {"id":this.id,"nickname":this.nickname}
      }).then(res=>{
        this.nickname = res.data
        // 이거 수정해야댐.
          this.$router.push({name:"Roomlist",params:{id : this.$store.state.myNum, nickname: this.randomItem(this.randomNick)}})
      }, err=>{
        alert("id, nickname error")
      console.log(err)
      })
    },
    createUser () {
      this.id = 0
      axios({
        method:'post',
        url:'/api/chat/uuser',
        baseURL:`${SERVER_URL}`,
        headers:{'content-type': 'application/json'},
        data : {"id":this.id,"nickname":this.nickname}
      }).then(res=>{
        this.id = res.data.id
        this.nickname = res.data.nickname
        this.$router.push({name:"Roomlist",params:{id : this.id, nickname: this.nickname}})
      }, err=>{
        alert("create user error")
        console.log(err)
      })
    }
  },
  computed : {
    
  }
};
</script>