<template>
  <div v-if="mate.mateStatus === 'N'">
      <div align="center" style="margin-top: 50px; margin-bottom : 50px; color:#7ac4e1;">모집이 마갑되었습니다. 함께한 캠퍼들을 평가해주세요.</div>
      <div class="container mt-5 d-flex justify-content-center">
      <div class="row">
        <div class="card p-4 m-3 col-6" v-for="(item, idx) in member" :key="idx">
          <div v-if="item.mateApplyCheck === 0">
            <div class="first" align="leftt" style="margin-left: 10px; margin-bottom:10px;">
              @{{item.userNickname}}
            </div>
          
            <div class="second d-flex flex-row">
            
              <div class="page" >
                <div class="page__demo">
                  <div class="page__group">
                    <div class="rating">
                      <span style="color:black; font-size:20px;">친절도</span><input type="radio" name="rating-star" class="rating__control screen-reader" :id="'rc16'+idx" value="1" v-model="item.kindRate">
                      <input type="radio" name="rating-star" class="rating__control screen-reader" :id="'rc17'+idx" value="2" v-model="item.kindRate">
                      <input type="radio" name="rating-star" class="rating__control screen-reader" :id="'rc18'+idx" value="3" v-model="item.kindRate">
                      <input type="radio" name="rating-star" class="rating__control screen-reader" :id="'rc19'+idx" value="4" v-model="item.kindRate">
                      <input type="radio" name="rating-star" class="rating__control screen-reader" :id="'rc20'+idx" value="5" v-model="item.kindRate">
                      <label :for="'rc16'+idx" class="rating__item">
                        <svg class="rating__star">
                          <use xlink:href="#star"></use>
                        </svg>
                        <span class="screen-reader">1</span>
                      </label>
                      <label :for="'rc17'+idx" class="rating__item">
                        <svg class="rating__star">
                          <use xlink:href="#star"></use>
                        </svg>
                        <span class="screen-reader">2</span>
                      </label>
                      <label :for="'rc18'+idx" class="rating__item">
                        <svg class="rating__star">
                          <use xlink:href="#star"></use>
                        </svg>
                        <span class="screen-reader">3</span>
                      </label>
                      <label :for="'rc19'+idx" class="rating__item">
                        <svg class="rating__star">
                          <use xlink:href="#star"></use>
                        </svg>
                        <span class="screen-reader">4</span>
                      </label>
                      <label :for="'rc20'+idx" class="rating__item">
                        <svg class="rating__star">
                          <use xlink:href="#star"></use>
                        </svg>
                        <span class="screen-reader">5</span>
                      </label>	
                    </div>

                  </div>
                  <div class="page__group">  
                    <div class="rating">
                      <span style="color:black; font-size:20px; ">정확도</span><input type="radio" name="rating-star2" class="rating__control screen-reader" :id="'rc21'+idx" value="1" v-model="item.accurancyRate">
                      <input type="radio" name="rating-star2" class="rating__control screen-reader" :id="'rc22'+idx" value="2" v-model="item.accurancyRate">
                      <input type="radio" name="rating-star2" class="rating__control screen-reader" :id="'rc23'+idx" value="3" v-model="item.accurancyRate">
                      <input type="radio" name="rating-star2" class="rating__control screen-reader" :id="'rc24'+idx" value="4" v-model="item.accurancyRate">
                      <input type="radio" name="rating-star2" class="rating__control screen-reader" :id="'rc25'+idx" value="5" v-model="item.accurancyRate">
                      <label :for="'rc21'+idx" class="rating__item">
                        <svg class="rating__star">
                          <use xlink:href="#star"></use>
                        </svg>
                        <span class="screen-reader">1</span>
                      </label>
                      <label :for="'rc22'+idx" class="rating__item">
                        <svg class="rating__star">
                          <use xlink:href="#star"></use>
                        </svg>
                        <span class="screen-reader">2</span>
                      </label>
                      <label :for="'rc23'+idx" class="rating__item">
                        <svg class="rating__star">
                          <use xlink:href="#star"></use>
                        </svg>
                        <span class="screen-reader">3</span>
                      </label>
                      <label :for="'rc24'+idx" class="rating__item">
                        <svg class="rating__star">
                          <use xlink:href="#star"></use>
                        </svg>
                        <span class="screen-reader">4</span>
                      </label>
                      <label :for="'rc25'+idx" class="rating__item">
                        <svg class="rating__star">
                          <use xlink:href="#star"></use>
                        </svg>
                        <span class="screen-reader">5</span>
                      </label>	
                    </div>    

                  </div>

                  <div class="page__group">  
                    <div class="rating">
                      <span style="color:black; font-size:20px;">숙련도</span><input type="radio" name="rating-star3" class="rating__control screen-reader" :id="'rc26'+idx" value="1" v-model="item.abilityRate">
                      <input type="radio" name="rating-star3" class="rating__control screen-reader" :id="'rc27'+idx" value="2" v-model="item.abilityRate">
                      <input type="radio" name="rating-star3" class="rating__control screen-reader" :id="'rc28'+idx" value="3" v-model="item.abilityRate">
                      <input type="radio" name="rating-star3" class="rating__control screen-reader" :id="'rc29'+idx" value="4" v-model="item.abilityRate">
                      <input type="radio" name="rating-star3" class="rating__control screen-reader" :id="'rc30'+idx" value="5" v-model="item.abilityRate">
                      <label :for="'rc26'+idx" class="rating__item">
                        <svg class="rating__star">
                          <use xlink:href="#star"></use>
                        </svg>
                        <span class="screen-reader">1</span>
                      </label>
                      <label :for="'rc27'+idx" class="rating__item">
                        <svg class="rating__star">
                          <use xlink:href="#star"></use>
                        </svg>
                        <span class="screen-reader">2</span>
                      </label>
                      <label :for="'rc28'+idx" class="rating__item">
                        <svg class="rating__star">
                          <use xlink:href="#star"></use>
                        </svg>
                        <span class="screen-reader">3</span>
                      </label>
                      <label :for="'rc29'+idx" class="rating__item">
                        <svg class="rating__star">
                          <use xlink:href="#star"></use>
                        </svg>
                        <span class="screen-reader">4</span>
                      </label>
                      <label :for="'rc30'+idx" class="rating__item">
                        <svg class="rating__star">
                          <use xlink:href="#star"></use>
                        </svg>
                        <span class="screen-reader">5</span>
                      </label>	
                    </div>    

                  </div>
                </div>
    
              </div>
              <svg xmlns="http://www.w3.org/2000/svg" style="display: none">
              <symbol id="star" viewBox="0 0 26 28">
                <path d="M26 10.109c0 .281-.203.547-.406.75l-5.672 5.531 1.344 7.812c.016.109.016.203.016.313 0 .406-.187.781-.641.781a1.27 1.27 0 0 1-.625-.187L13 21.422l-7.016 3.687c-.203.109-.406.187-.625.187-.453 0-.656-.375-.656-.781 0-.109.016-.203.031-.313l1.344-7.812L.39 10.859c-.187-.203-.391-.469-.391-.75 0-.469.484-.656.875-.719l7.844-1.141 3.516-7.109c.141-.297.406-.641.766-.641s.625.344.766.641l3.516 7.109 7.844 1.141c.375.063.875.25.875.719z"/>
              </symbol>
              </svg>

              
            </div>
            <div align="center"><button @click="rating(item.kindRate,item.accurancyRate,item.abilityRate,item.userNo,item.mateListNo)">평가하기</button></div>
          </div>
          <div v-else class="row-vh d-flex flex-column align-items-center" align="center" style="height:214px; margin:0 auto;">
            <div style="margin-top:75px; "><i class="bi bi-balloon-heart-fill fa-3x" style="color:red;"></i></div>
            <div >평가완료</div>
          </div>
          </div>
        
      </div>
    </div>

  
  </div>  
  <div v-else>
    <div class="container mt-5 d-flex justify-content-center">
      <div class="row">
        <div
          class="card p-4 m-3 col-6"
          v-for="(item, idx) in member"
          :key="idx"
        >
          <div class="first" align="right" style="margin-right: 10px">
            <span>Age : {{ item.userAge }}</span> <span v-if="mate.userNo === myNum">Gender : {{ item.userGender }}</span
            ><button
              v-if="item.userNo === myNum"
              @click="delCard(item.mateListNo)"
              style="background-color:white; color:red; border-color:red;"
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
                <div class="star-ratings" style="margin-top: 0px">
                  <div
                    class="star-ratings-fill space-x-2 text-lg"
                    :style="{ width: item.userRatePoint * 20 + 1.5 + '%' }"
                  >
                    <span>★</span><span>★</span><span>★</span><span>★</span
                    ><span>★</span>
                  </div>
                  <div class="star-ratings-base space-x-2 text-lg">
                    <span>★</span><span>★</span><span>★</span><span>★</span
                    ><span>★</span>&nbsp;<span style="font-family:Arial; font-size:16px;">{{ item.userRatePoint }}/5</span>
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

    <div align="center">
      <b-button
        :class="visible ? 'null' : 'collapsed'"
        :aria-expanded="visible ? 'true' : 'false'"
        aria-controls="collapse-4"
        @click="visible = !visible"
        style="background-color: #7ac4e1; border-color:#7ac4e1; border-size:2px;"
      >
        <span v-if="check === 0 && mate.userNo != myNum" >메이트 참가</span>
        <span v-else >참가 중</span>
      </b-button>
      <b-button v-if="mate.userNo === myNum" @click="mateDefine"
        >모집마감</b-button
      >
      <b-collapse id="collapse-4" v-model="visible" class="mt-2">
        <b-card 
          ><div style="float: center; ">
            <div v-if="check === 0">
              <div><i class="bi bi-exclamation-lg" style="font-size:20px;"></i>동행인원 제한 : {{mate.friendlimit}}인</div>
              <input type="text" v-model="friendnum" style=" width:25%; text-align:center;" />
              <button @click="join" class="box">
                확인
              </button>
            </div>
            <div v-else>
              <button @click="join" class="box">참가 취소</button>
            </div>
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

    mate.value.mateList.forEach(ele => {
      // console.log(ele)
      ele["kindRate"] = null
      ele["accurancyRate"] = null
      ele["abilityRate"] = null
      ele['check'] = 0
    })
    console.log(mate.value)

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
        props.mateDetail.memberlimit < Number(friendnum.value) + Number(memberSum.value) ) {
        alert("인원 초과입니다.");
      } else if (Number(friendnum.value) > props.mateDetail.friendlimit) {
        alert("동행인원 수를 확인해주세요.");
      } else if (mate.value.lowestAge > me.value.userAge || me.value.userAge > mate.value.highestAge ) {
        alert("연령대를 확인해주세요.")
      }
      else {
        if (check.value === 0) {
          visible.value = false;
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
        // member.value.push(meList)
        console.log('조인', meList)
        axios({
          method : 'post',
          url : `${SERVER_URL}/mate/apply`,
          data : meList
        })
        .then(res => {
          console.log(res)
          axios({
            method: "get",
            url: `${SERVER_URL}/mate/${props.mateNm}`,
          })
          .then((res) => {
            const temp = res.data.dto;
            member.value = temp.mateList
            console.log('불러오기',res)

          })
          .catch((err) => {
            console.log(err);
          })
        })
        .catch(err => {
          console.log(err)
        })

          check.value += 1;
        } else {
          // 여기다가 지우는거 넣으면 됨
          // 호준이가 버린함수
          check.value -= 1;
        }
      }
    }

    const delCard = (temp) => {
        console.log(temp)
        console.log(member.value[0])
        axios({
          method : 'delete',
          url : `${SERVER_URL}/mate/apply/${temp}`
        })
        .then(res => {
          console.log(res)
          axios({
            method: "get",
            url: `${SERVER_URL}/mate/${props.mateNm}`,
          })
          .then((res) => {
            const temp = res.data.dto;
            member.value = temp.mateList
            check.value -=1
          })
          .catch((err) => {
            console.log(err);
          })
        })

        .catch(err => {
          console.log(err);
        })
    
    }

    const mateDefine = () => {
      mate.value.mateStatus = 'N'
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
      mate.value.mateStatus = 'N'
    }

    const rating = (kind,accurancy,ability,userNo,listNo) => {
      const avg = (Number(kind) + Number(accurancy) + Number(ability))/3
      const sendData = {
        userRatePoint : avg,
        userNo : userNo
      }
      console.log(avg)
      axios({
        method : 'post',
        url : `${SERVER_URL}/user/rate`,
        data : sendData
      })
      .then( res => {
        console.log(res)
      })
      .catch( err => {
        console.log(err)
      })

      axios({
        method : 'post',
        url : `${SERVER_URL}/mate/apply/check/${listNo}`,
      })
      .then( res=> {
        console.log(res)
      })
      .catch(err => {
        console.log(err)
      })
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
      rating,
    };
  },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Roboto&display=swap");

body {
  /* background-color: #eee; */
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

button{
  /* color: #7ac4e1;
  background-color: #fff;
  border: 3px solid #7ac4e1;
  border-radius: 30px; */
}

.card {
  background-color:rgb(234, 247, 255);
  border: 0px solid white;
}

.bi-exclamation-lg {
  color:red;

}

/* --------------------------- */




/*
=====
DEPENDENCES
=====
*/

.screen-reader{
  width: var(--screenReaderWidth, 1px) !important;
  height: var(--screenReaderHeight, 1px) !important;
  padding: var(--screenReaderPadding, 0) !important;
  border: var(--screenReaderBorder, none) !important;

  position: var(--screenReaderPosition, absolute) !important;
  clip: var(--screenReaderClip, rect(1px, 1px, 1px, 1px)) !important;
  overflow: var(--screenReaderOverflow, hidden) !important;
}

/*
=====
CORE STYLES
=====
*/

.rating{
  --uiRatingColor: var(--ratingColor, #eee);
  --uiRatingColorActive: var(--ratingColorActive, #ffcc00);

  display: var(--ratingDisplay, flex);
  font-size: var(--ratingSize, 1rem);
  color: var(--uiRatingColor);
}
    
.rating__control:nth-of-type(1):focus ~ .rating__item:nth-of-type(1)::before,
.rating__control:nth-of-type(2):focus ~ .rating__item:nth-of-type(2)::before,
.rating__control:nth-of-type(3):focus ~ .rating__item:nth-of-type(3)::before,
.rating__control:nth-of-type(4):focus ~ .rating__item:nth-of-type(4)::before,
.rating__control:nth-of-type(5):focus ~ .rating__item:nth-of-type(5)::before{
  content: ""; 
  box-shadow: 0 0 0 var(--ratingOutlineWidth, 4px) var(--uiRatingColorActive);

  position: absolute;
  top: -.15em;
  right: 0;
  bottom: -.15em;
  left: 0;
  z-index: -1;
}

.rating__item{
  cursor: pointer;  
  position: relative;
}

.rating__item{
  /* 별 가로 패딩 */
  /* padding-left: .25em;
  padding-right: .25em; */
}

.rating__star{
  display: block;
  width: 1em;
  height: 1em;

  fill: currentColor;
  stroke: var(--ratingStroke, #222);
  stroke-width: var(--ratingStrokeWidth, 1px);
}

.rating:hover,
.rating__control:nth-of-type(1):checked ~ .rating__item:nth-of-type(1),
.rating__control:nth-of-type(2):checked ~ .rating__item:nth-of-type(-n+2),
.rating__control:nth-of-type(3):checked ~ .rating__item:nth-of-type(-n+3),
.rating__control:nth-of-type(4):checked ~ .rating__item:nth-of-type(-n+4),
.rating__control:nth-of-type(5):checked ~ .rating__item:nth-of-type(-n+5){
  color: var(--uiRatingColorActive);
}

.rating__item:hover ~ .rating__item{
  color: var(--uiRatingColor);
}

/*
=====
SETTINGS
=====
*/

.rating{
  /* --ratingSize: 2rem; */
  --ratingColor: #eee;
  --ratingColorActive: #ffcc00;
}

/*
=====
DEMO
=====
*/

body{
  font-family: -apple-system, BlinkMacSystemFont, Segoe UI, Roboto, Open Sans, Ubuntu, Fira Sans, Helvetica Neue, sans-serif;
  font-size: 1rem;
  margin: 0;
}

.page{
  min-height: 100px;
  display: flex;
}

.page__demo{
  /* margin: auto;   */
}

.page__group{
  /* margin-top: 2rem;
  margin-bottom: 2rem; */
  
}

.page__hint{
  display: block;
  font-weight: 700;
  margin-top: 1rem;
}

@media (min-width: 641px){
  .page__demo{
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
  }

  .page__group{
    margin-left: 3.5rem;
    margin-right: 3.5rem;
    height :50px;
  }
}

</style>
