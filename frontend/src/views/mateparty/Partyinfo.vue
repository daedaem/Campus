<template>
  <Navbar></Navbar>
  <body>
    <div style="margin-top: 20px; width: 30%; height: 250px; float: left">
      <button v-if="userNm === mateDetail.userNo" @click="delPost">x</button>
      <img
        class="mainimage"
        src="https://cdn.pixabay.com/photo/2015/02/02/11/08/office-620817_960_720.jpg"
        alt=""
      />
    </div>
    <div
      align="left"
      style="
        margin-top: 20px;
        width: 65%;
        height: 250px;
        float: right;
        word-break: break-all;
      "
    >
      <div style="float: right">
        {{ mateDetail.mateCampstart }} ~ {{ mateDetail.mateCampend }}
      </div>
      <h4 style="font-weight: 1000; font-size: 25px">
        {{ mateDetail.mateTitle }}
      </h4>
      <font-awesome-icon
        :icon="['fas', 'user']"
        size="lg"
      />&nbsp;&nbsp;&nbsp;<span style="font-weight: 500; font-size: 20px"
        >{{ joinMembernum }}/{{ mateDetail.memberlimit }}</span
      >
      <br />
      <br />
      <br />
      <br />

      <hr />
      <div style="display: flex; float: right">
        <img
          style="margin-top: 20px"
          class="smallimage"
          :src="mateDetail.userProfileImage"
          alt=""
        />
        <div style="margin-left: 20px; margin-top: 20px">
          <span>@{{ mateDetail.userNickName }}</span
          ><br />메이트|뭐시기|후기|
        </div>
      </div>
    </div>
    <div style="visibility: hidden">
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    </div>
    <hr />

    <Carousel2 v-if="mateDetail.length != 0" :mateDetail="mateDetail" />

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
    <button @click="goPartyrevise(mateDetail.mateNo)">수정</button>

    <!-- <div style="margin-top: 20px; margin-left: 40px; width: 140px; height:200px;  float: left; ">
      <img class="mainimage" src="https://cdn.pixabay.com/photo/2015/02/02/11/08/office-620817_960_720.jpg" alt="">
    </div> -->

    <!-- <div align="left" style="margin-top: 20px; margin-left: 20px; width: 400px; height: 200px;  float: left; word-break:break-all;">
      <h4 style="font-weight:1000; font-size:25px;">경남 카라반 펜션</h4>
      ☆☆☆☆☆  3.7 / 4.5
      
     
      <div style="display:flex; float:left;">

      </div>
    </div> -->
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
import Navbar from "@/components/common/Navbar.vue";

// const SERVER_URL = `http://i6e102.p.ssafy.io`
const SERVER_URL = "http://localhost:8080";

export default {
  name: "Partyinfo",
  props: {
    mateNo: String,
  },
  components: {
    Navbar,
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
    const joinMembernum = ref(0);
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
      })
      .then((res) => {
        mateDetail.value = res.data.dto;
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
    background: beige;
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
}

.smallimage {
  width: 50px;
  height: 50px;
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
