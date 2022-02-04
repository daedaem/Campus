<template>
  <body>
    <div style="margin-top: 20px; width: 30%; height:250px; float: left; ">
      <img class="mainimage" src="https://cdn.pixabay.com/photo/2015/02/02/11/08/office-620817_960_720.jpg" alt="">
    </div>
    <div align="left" style="margin-top: 20px; width: 65%; height: 250px;  float: right; word-break:break-all;"><div style="float:right;">{{mateDetail.mateCampstart}} ~ {{mateDetail.mateCampend}}</div>
      <h4 style="font-weight:1000; font-size:25px;">{{mateDetail.mateTitle}}</h4>
      <font-awesome-icon :icon="['fas','user']" size="lg"/>&nbsp;&nbsp;&nbsp;<span style="font-weight:500; font-size:20px;">2/4</span>
      <br>
      <br>
      <br>
      <br>
      
      <hr>
      <div style="display:flex; float:right;">
        
        <img style="margin-top:20px;" class="smallimage" :src="mateDetail.userProfileImage" alt="">
        <div style="margin-left:20px; margin-top:20px;"><span>@{{mateDetail.userNickName}}</span><br>메이트|뭐시기|후기|</div>
        
      </div>
    </div>
    <div style="visibility:hidden">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
    <hr>

    <Carousel2 v-if="mateDetail.length != 0" :mateDetail="mateDetail"/>
    
    <Cards class="mycard" v-if="mateDetail.length != 0" :mateDetail="mateDetail"/>
    <Items2 v-if="mateDetail.length != 0" :mateDetail="mateDetail"/>
    <div><Members  v-if="mateDetail.length != 0" :mateDetail="mateDetail"/></div>
    
    <div>
    <b-button
      :class="visible ? null : 'collapsed'"
      :aria-expanded="visible ? 'true' : 'false'"
      aria-controls="collapse-4"
      @click="visible = !visible"
    >
      Toggle Collapse
    </b-button>
    <b-collapse id="collapse-4" v-model="visible" class="mt-2">
      <b-card><div style="float:center">
      <input type="text" v-model="friendnum"><button @click="join">메이트 참가</button>
    </div></b-card>
    </b-collapse>
    </div>
    <!-- <div style="margin-top: 20px; margin-left: 40px; width: 140px; height:200px;  float: left; ">
      <img class="mainimage" src="https://cdn.pixabay.com/photo/2015/02/02/11/08/office-620817_960_720.jpg" alt="">
    </div> -->
    <Matejoin/>
    
    
    <!-- <div align="left" style="margin-top: 20px; margin-left: 20px; width: 400px; height: 200px;  float: left; word-break:break-all;">
      <h4 style="font-weight:1000; font-size:25px;">경남 카라반 펜션</h4>
      ☆☆☆☆☆  3.7 / 4.5
      
     
      <div style="display:flex; float:left;">

      </div>
    </div> -->
    
        
  </body>
</template>

<script>
import Carousel2 from '../../components/mateparty/Carousel2.vue'
import Cards from '../../components/mateparty/Cards.vue'
import Items2 from '../../components/mateparty/Items2.vue'
import Members from '../../components/mateparty/Members.vue'
import axios from 'axios'
import {ref, } from 'vue'
import {useStore} from 'vuex'
import Matejoin from '../../components/mateparty/Matejoin.vue'


export default {
  name : 'Partyinfo',
  props : {
    mateNo : String,
  },
  components: {
    Carousel2,    
    Cards,
    Items2,
    Members,
    Matejoin,
  },
  setup(props) {
    const store = useStore()    
    console.log(store.state.mateList)     
    // const myMate = (computed(() => store.state.mateList.filter(mate => mate.mateNo === Number(props.mateNo))))
    const mateDetail = ref([])
    const me = ref(store.state.userList)
   
    const visible = ref(false)
    const friendnum = ref(5)
    

    axios({
      method: 'get',
      url : `http://localhost:8080/mate/${props.mateNo}`
    })
    .then(res => {
      mateDetail.value = res.data.dto
      console.log(mateDetail.value)
    })
    .catch(err =>{
      console.log(err)
    })

    
    

    const join = () => {
      console.log(me.value)
      const meList = {
          campStyle1: null,
          campStyle2: null,
          campStyle3: null,
          campStyle4: null,
          campStyle5: null,
          campStyle6: null,
          mateListNum: null,
          userGender : null,
          userMBTI : null,
          userRatePoint : null,
          userAge : null,
          mateNo : props.mateNo
      } 
      
      meList.campStyle1 = me.value.campStyle1
      meList.campStyle2 = me.value.campStyle2
      meList.campStyle3 = me.value.campStyle3
      meList.campStyle4 = me.value.campStyle4
      meList.campStyle5 = me.value.campStyle5
      meList.campStyle6 = me.value.campStyle6
      meList.mateListNum = friendnum.value
      meList.userGender = me.value.userGender
      meList.userMBTI = me.value.userMBTI
      meList.userRatePoint = me.value.userRatePoint
      meList.userAge = me.value.userAge
      console.log(meList)
      // axios({
      //   method : 'post',
      //   url : 'http://localhost:8080/mate/apply',
      //   data : meList
      // })
      // .then(res => {
      //   console.log(res)
      // })
      // .catch(err => {
      //   console.log(err)
      // })
      
      
      
    
      
    }
    

    return {
      // myMate,
      // Mate
      mateDetail,
      visible,
      join,
      me,
      friendnum,
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

@media (max-width: 768px) {
  .mycard {
    width : 100%;
  }
}
.mainimage {
  
  border: solid;
  border-radius: 10px;
  width : 100%;
  height : 100%;
}

.smallimage {
  width :50px;
  height : 50px;
  border-radius: 100%;
}
/* 
.filterbox1 {
  float: left;
}

.filterbox2 {
  float: right;
} */
</style>