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
    <div><Members/></div>
    <div style="margin-top: 20px; margin-left: 40px; width: 140px; height:200px;  float: left; ">
      <img class="mainimage" src="https://cdn.pixabay.com/photo/2015/02/02/11/08/office-620817_960_720.jpg" alt="">
    </div>
    <div align="left" style="margin-top: 20px; margin-left: 20px; width: 400px; height: 200px;  float: left; word-break:break-all;">
      <h4 style="font-weight:1000; font-size:25px;">경남 카라반 펜션</h4>
      ☆☆☆☆☆  3.7 / 4.5
      
     
      <div style="display:flex; float:left;">

      </div>
    </div>
    
        
  </body>
</template>

<script>
import Carousel2 from '../../components/mateparty/Carousel2.vue'
import Cards from '../../components/mateparty/Cards.vue'
import Items2 from '../../components/mateparty/Items2.vue'
import Members from '../../components/mateparty/Members.vue'
import axios from 'axios'
import {ref} from 'vue'
// import {useStore} from 'vuex'
// import {computed} from 'vue'


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
  },
  setup(props) {
    // const store = useStore()         
    // const myMate = (computed(() => store.state.mateList.filter(mate => mate.mateNo === Number(props.mateNo))))
    const mateDetail = ref([])

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

    return {
      // myMate,
      // Mate
      mateDetail
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