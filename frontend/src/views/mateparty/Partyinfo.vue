<template>

  <body>
    <div class="myButton" align="right">
    <button v-if="userNm === mateDetail.userNo" @click="delPost" style="width: 100px; height: 40px; margin-top:5px; margin-bottom: 5px; background-color:red; border-color:red; align:right; border-radius:20px; color:white;">삭제</button><button @click="goPartyrevise(mateDetail.mateNo)" v-if="userNm===mateDetail.userNo" style="width: 100px; height: 40px; margin-top:5px; margin-bottom: 5px; background-color:#7ac4e1; border-color:#7ac4e1; align:right; border-radius:20px; color:white;">수정</button>
    </div>
    <div class="container">
      <div class="row">
        <div style="margin-top: 20px; height: 300px; ">
          <img class="mainimage" :src="mateDetail.mateImageUrl" alt="" />
        </div>
        <div style="margin-top: 20px;" class="text">
          <h4 style="font-weight: 1000; font-size: 25px">
            {{ mateDetail.mateTitle }}
          </h4>
          
          <div style="float:right; overflow:hidden;">
            <font-awesome-icon :icon="['fas', 'user']" size="lg" style="color :#7ac4e1; margin-top:20px;"/>
            <span style="font-weight: 500; font-size: 20px; color:#7ac4e1;">{{ joinMembernum }}/{{ mateDetail.memberlimit }}</span>
          </div>
          <div style="clear:both; margin-top:100px;">{{mateDetail.mateContent}}</div>

        </div>  
      </div>
      <div class="row">
        <Carousel2 v-if="mateDetail.length != 0" :mateDetail="mateDetail" />
      </div>
    <Cards
      class="mycard"
      v-if="mateDetail.length != 0"
      :mateDetail="mateDetail"
    />
    <Items2 v-if="mateDetail.length != 0" :mateDetail="mateDetail" />
    <div>
      <Members
        v-if="mateDetail.length != 0"
        :mateDetail="mateDetail"
        :mateNm="mateNm"
        @joinedmember="nowmember"
      />
    </div>
    
    
    <!-- <div style="margin-top: 20px; margin-left: 40px; width: 140px; height:200px;  float: left; ">
      <img class="mainimage" src="https://cdn.pixabay.com/photo/2015/02/02/11/08/office-620817_960_720.jpg" alt="">
    </div> -->

    <!-- <div align="left" style="margin-top: 20px; margin-left: 20px; width: 400px; height: 200px;  float: left; word-break:break-all;">
      <h4 style="font-weight:1000; font-size:25px;">경남 카라반 펜션</h4>
      ☆☆☆☆☆  3.7 / 4.5
      
     
      <div style="display:flex; float:left;">

      </div>
    </div> -->
      
    </div>
  </body>
</template>

<script>
import Carousel2 from "../../components/mateparty/Carousel2.vue";
import Cards from "../../components/mateparty/Cards.vue";
import Items2 from "../../components/mateparty/Items2.vue";
import Members from "../../components/mateparty/Members.vue";
import axios from "axios";
import { ref } from "vue";
import { useStore } from "vuex";
import { useRouter } from "vue-router";

const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {
  name: "Partyinfo",
  props: {
    mateNo: String,
  },
  components: {
    Carousel2,
    Cards,
    Items2,
    Members,
  },
  setup(props) {
    const store = useStore();
    const router = useRouter();
    console.log(store.state.mateList);
    const mateNm = ref(props.mateNo);
    const userNm = store.state.myNum;
    // const myMate = (computed(() => store.state.mateList.filter(mate => mate.mateNo === Number(props.mateNo))))
    const mateDetail = ref([]);
    const joinMembernum = ref(1);
    axios({
      method: "get",
      url: `${SERVER_URL}/mate/${props.mateNo}`,
    })
    .then((res) => {
      mateDetail.value = res.data.dto;

      mateDetail.value.mateList.forEach(
        (ele) => (joinMembernum.value += ele.mateListNum)
      );
      console.log(mateDetail.value);
    })
    .catch((err) => {
      console.log(err);
    });

    const delPost = () => {
      const temp = mateDetail.value.mateNo;
      axios({
        method: "delete",
        url: `${SERVER_URL}/mate/${temp}`,
      })
        .then((res) => {
          console.log(res);
          setTimeout(() => {
            router.push({ name: "Mateparty" });
          }, 3000);
        })
        .catch((err) => {
          console.log(err);
        });
    };

    const goPartyrevise = (Num) => {
      router.push({ name: "Materevise", params: { mateNo: Num } });
    };

    // const today = new Date()
    // var year = today.getFullYear();
    // var month = ('0' + (today.getMonth() + 1)).slice(-2);
    // var day = ('0' + today.getDate()).slice(-2);

    // const todayy = year + '-' + month  + '-' + day;
    //     console.log(todayy)

    // if (mateDetail.value.mateCampstart >= todayy) {
    //   console.log(1)
    // } else { console.log(mateDetail.value.mateCampstart - todayy)}

    return {
      // myMate,
      // Mate
      mateDetail,
      delPost,
      goPartyrevise,
      userNm,
      joinMembernum,

      mateNm,
    };
  },
};
</script>

<style scoped>
@media (min-width: 768px) {
  body {
    width: 768px;
    margin: 0 auto;
    padding: 0 20px;
    /* background: beige; */
  }
}

@media (max-width: 768px) {
  .mycard {
    width: 100%;
  }
}
.mainimage {
  border: solid;
  border-radius: 10px;
  width: 100%;
  height: 100%;
  /* object-fit:cover; */
  aspect-ratio: 16/9;
}

.smallimage {
  width: 50px;
  height: 50px;
  border-radius: 100%;
}

.text{
  min-height : 450px;

}

.myButton { 
  
}
</style>
