<template>
  <div v-if="endCheck != 0">모집이 마감되었습니다.</div>
  <div v-else>
    <div class="container mt-5 d-flex justify-content-center">
      <div class="row">
        <div
          class="card p-4 m-3 col-6"
          v-for="(item, idx) in member"
          :key="idx"
        >
          <div class="first" align="right" style="margin-right: 10px">
            <span>{{ item.userAge }}</span> <span>{{ item.userGender }}</span
            ><button
              v-if="item.userNo === myNum"
              @click="delCard(item.mateListNo)"
            >
              x
            </button>
            <div
              class="time d-flex flex-row align-items-center justify-content-between"
            >
              <div class="d-flex align-items-center">
                <span>{{ "#" + item.userMBTI }}</span
                ><i class="fa fa-clock-o clock"></i>
              </div>
              <!-- <div> <span class="font-weight-bold">동행</span> </div> -->
            </div>
          </div>
          <div class="second d-flex flex-row">
            <div class="image mr-3">
              <i class="bi bi-person-circle fa-3x"></i>
            </div>
            <div>
              <div
                class="d-flex flex-row"
                style="margin-left: 10px; margin-bottom: 7px"
              >
                <div class="star-ratings" style="margin-top: 7px">
                  <div
                    class="star-ratings-fill space-x-2 text-lg"
                    :style="{ width: item.userRatePoint * 20 + 1.5 + '%' }"
                  >
                    <span>★</span><span>★</span><span>★</span><span>★</span
                    ><span>★</span>
                  </div>
                  <div class="star-ratings-base space-x-2 text-lg">
                    <span>★</span><span>★</span><span>★</span><span>★</span
                    ><span>★</span>&nbsp;<span>{{ item.userRatePoint }}/5</span>
                  </div>
                  <div></div>
                </div>
              </div>
              <div style="margin-left: 10px">
                <span v-if="item.campStyle1 != 'N'"># 요식</span
                ><span v-if="item.campStyle2 != 'N'"># 불멍</span
                ><span v-if="item.campStyle3 != 'N'"># 캠파</span
                ><span v-if="item.campStyle4 != 'N'"># 등산</span
                ><span v-if="item.campStyle5 != 'N'"># 사진</span
                ><span v-if="item.campStyle6 != 'N'"># 음악</span>
              </div>
              <!-- <span v-for="(style,idx2) in stylelist2[idx]" :key="idx2">
                    {{'#'+style}}
                </span> -->
            </div>
          </div>
          <!-- <hr class="line-color"> -->
        </div>
      </div>
    </div>

    <div>
      <b-button
        :class="visible ? null : 'collapsed'"
        :aria-expanded="visible ? 'true' : 'false'"
        aria-controls="collapse-4"
        @click="visible = !visible"
      >
        <span v-if="check === 0 && mate.userNo != myNum">메이트 참가</span>
        <span v-else>참가완료</span>
      </b-button>
      <b-button v-if="mate.userNo === myNum" @click="mateDefine"
        >모집마감</b-button
      >
      <b-collapse id="collapse-4" v-model="visible" class="mt-2">
        <b-card
          ><div style="float: center">
            <div v-if="check === 0">
              <input type="text" v-model="friendnum" /><button @click="join">
                메이트 참가
              </button>
            </div>
            <div v-else><button @click="join">참가 취소</button></div>
          </div></b-card
        >
      </b-collapse>
    </div>
  </div>
</template>

<script>
import { ref } from "vue";
import axios from "axios";
import { useStore } from "vuex";

const SERVER_URL = process.env.VUE_APP_SERVER_URL;


export default {
  name: "Members",
  props: ["mateDetail", "mateNm"],

  components: {},
  setup(props) {
    const store = useStore();
    const myNum = store.state.myNum;
    const visible = ref(false);
    const memberSum = ref(0);
    const mate = ref(props.mateDetail);
    console.log(mate.value);
    props.mateDetail.mateList.forEach((element) => {
      memberSum.value += element.mateListNum;
      if (element.campStyle1 === "Y") {
        element.campStyle1 = "요식";
      }
      if (element.campStyle2 === "Y") {
        element.campStyle2 = "불멍";
      }
      if (element.campStyle3 === "Y") {
        element.campStyle3 = "캠파";
      }
      if (element.campStyle4 === "Y") {
        element.campStyle4 = "등산";
      }
      if (element.campStyle5 === "Y") {
        element.campStyle5 = "사진";
      }
      if (element.campStyle6 === "Y") {
        element.campStyle6 = "노래";
      }
    });
    const member = ref(props.mateDetail.mateList);
    console.log(member.value);
    const endCheck = ref(0);
    const friendnum = ref(0);
    const me = ref(store.state.userList);
    const check = ref(0);
    const joinCheck = member.value.forEach((element) => {
      if (store.state.myNum === element.userNo) {
        check.value = 1;
      }
    });

    const ratingToPercent = () => {
      const score = +this.restaurant.averageScore * 20;
      return score + 1.5;
    };
    const join = () => {
      if (
        props.mateDetail.memberlimit <
        Number(friendnum.value) + Number(memberSum.value)
      ) {
        console.log(props.mateDetail.memberlimit);
        console.log(Number(friendnum.value) + Number(memberSum.value));
        alert("인원초과 수고");
      } else if (Number(friendnum.value) > props.mateDetail.friendlimit) {
        alert("인원초과 수고");
      } else {
        if (check.value === 0) {
          visible.value = false;
          console.log(me.value);
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
            mateNo : props.mateNm,
            userNo : myNum,
            userNickname : store.state.userList.userNickname,
        } 
        
      meList.campStyle1 = me.value.campStyle1
      meList.campStyle2 = me.value.campStyle2
      meList.campStyle3 = me.value.campStyle3
      meList.campStyle4 = me.value.campStyle4
      meList.campStyle5 = me.value.campStyle5
      meList.campStyle6 = me.value.campStyle6
      meList.mateListNum = Number(friendnum.value)
      meList.userGender = me.value.userGender
      meList.userMBTI = me.value.userMBTI
      meList.userRatePoint = me.value.userRatePoint
      meList.userAge = me.value.userAge
      member.value.push(meList)
      console.log(meList)
      axios({
        method : 'post',
        url : `${SERVER_URL}/mate/apply`,
        data : meList
      })
      .then(res => {
        console.log(res)
      })
      .catch(err => {
        console.log(err)
      })

        // meList.campStyle1 = me.value.campStyle1
        // meList.campStyle2 = me.value.campStyle2
        // meList.campStyle3 = me.value.campStyle3
        // meList.campStyle4 = me.value.campStyle4
        // meList.campStyle5 = me.value.campStyle5
        // meList.campStyle6 = me.value.campStyle6
        // meList.mateListNum = Number(friendnum.value)
        // meList.userGender = me.value.userGender
        // meList.userMBTI = me.value.userMBTI
        // meList.userRatePoint = me.value.userRatePoint
        // meList.userAge = me.value.userAge
        // member.value.push(meList)
        // console.log(meList)
        // axios({
        //   method : 'post',
        //   url : `${SERVER_URL}/mate/apply`,
        //   data : meList
        // })
        // .then(res => {
        //   console.log(res)
        // })
        // .catch(err => {
        //   console.log(err)
        // })

          meList.campStyle1 = me.value.campStyle1;
          meList.campStyle2 = me.value.campStyle2;
          meList.campStyle3 = me.value.campStyle3;
          meList.campStyle4 = me.value.campStyle4;
          meList.campStyle5 = me.value.campStyle5;
          meList.campStyle6 = me.value.campStyle6;
          meList.mateListNum = Number(friendnum.value);
          meList.userGender = me.value.userGender;
          meList.userMBTI = me.value.userMBTI;
          meList.userRatePoint = me.value.userRatePoint;
          meList.userAge = me.value.userAge;
          member.value.push(meList);
          console.log(meList);
          axios({
            method: "post",
            url: `${SERVER_URL}/mate/apply`,
            data: meList,
          })
            .then((res) => {
              console.log(res);
            })
            .catch((err) => {
              console.log(err);
            });

          check.value += 1;
        } else {
          // 여기다가 지우는거 넣으면 됨
          // 호준이가 버린함수
          check.value -= 1;
        }
      }
    }

    const delCard = (temp) => {
        axios({
          method :'delete',
          url : `${SERVER_URL}/mate/apply/${temp}`
          
        })
        .catch((err) => {
          console.log(err);
        });
    };

    const mateDefine = () => {
      endCheck.value += 1
      axios({
        method : 'put',
        url : `${SERVER_URL}/mate/detail/status/${mate.value.mateNo}`,
      
        
      })      
      .then(res =>{
        console.log(res)
      })
      .catch(err => {
        console.log(err)
      })
    }
    
    const moment = require('moment'); 
    const today = moment().add(1,'days').format('YYYY-MM-DD');
    
    
    if (today === mate.value.mateCampstart) {
      console.log(1);
      endCheck.value += 1;
    }

    return {
      member,
      ratingToPercent,
      join,
      friendnum,
      visible,
      joinCheck,
      check,
      myNum,
      delCard,
      memberSum,
      mate,
      endCheck,
      mateDefine,
      today,
    };
  },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Roboto&display=swap");

body {
  background-color: #eee;
  font-family: "Roboto", sans-serif;
}

.card {
  /* background-color: #B9F6CA; */
  width: 300px;
  border-radius: 20px;
}

.heading {
  font-weight: 700;
}

.hour {
  margin-top: 1px;
  color: green;
  font-size: 12px;
}

.ratings i {
  color: #388e3c;
}

.btn {
  border-radius: 15px !important;
}

.line-color {
  color: green;
  height: 3px;
}

.star-ratings {
  color: #aaa9a9;
  position: relative;
  unicode-bidi: bidi-override;
  width: max-content;
  -webkit-text-fill-color: transparent; /* Will override color (regardless of order) */
  -webkit-text-stroke-width: 1.3px;
  -webkit-text-stroke-color: #2b2a29;
}

.star-ratings-fill {
  color: #fff58c;
  padding: 0;
  position: absolute;
  z-index: 1;
  display: flex;
  top: 0;
  left: 0;
  overflow: hidden;
  -webkit-text-fill-color: gold;
}

.star-ratings-base {
  z-index: 0;
  padding: 0;
}
</style>
