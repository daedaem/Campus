<template>
  <Navbar class="Navbar"></Navbar>
  <div class="container d-flex flex-row justify-content-center">
    <div class="CampSiteDetail-TotalFrame">
      <div class="m-4">
        <div>
          <h2 align="left">{{ detailData.facltNm }}</h2>
          <div class="ms-3 d-flex justify- content-center align-items-center">
            <div class="mx-2"><i class="bi bi-star-fill"></i><span v-if="rateAvg">{{rateAvg.toFixed(1)}}</span><span v-else>&nbsp;3.2</span></div>

            <div class="mx-2">
              <i class="bi bi-chat-left-dots px-2"></i>리뷰 {{rateList.length}}
            </div>
            <div class="mx-2">
              <i class="bi bi-geo-alt"></i> {{ detailData.doNm }}
              {{ detailData.sigunguNm }}
            </div>
          </div>
        </div>

        <div>
          <div
            class="CampSiteDetail-ImageFrame d-flex justify-content-center pt-3 pb-3"
          >
            <img :src="detailData.firstImageUrl" alt="" />
          </div>
          <hr>
          <h4>캠핑장 소개</h4>
          <div class="campsitedetailContent">
            <p>{{ detailData.intro }}</p>
          </div>
          <hr />
          <h4>편의시설</h4>
          <!-- <div v-if="detailData.value.sbrsEtc.includes('수영장')"> -->
          <!-- 부대시설 -->
          <div class="campSiteDetailContent">
            <div v-if="splitedList">
              <span v-for="(item,idx) in splitedList" :key="idx">
                <span class="tag tag-flutter tag-lg" v-if="idx%3 === 0">{{item}}</span>
                <span class="tag tag-typescript tag-lg" v-else-if="idx%2 === 0">{{item}}</span>
                <span class="tag tag-electron tag-lg" v-else>{{item}}</span>
              </span>
            </div>
          </div>
          <h4 style="margin-top:20px;">테마</h4>
          <div class="campSiteDetailContent">
            <div v-if="splitedThemeList">
              <span v-for="(item,idx) in splitedThemeList" :key="idx">
                <span class="tag tag-rxjs tag-lg" v-if="idx%3 === 0">{{item}}</span>
                <span class="tag tag-graphql tag-lg" v-else-if="idx%2 === 0">{{item}}</span>
                <span class="tag tag-machine-learning tag-lg" v-else>{{item}}</span>
              </span>
            </div>
            <div v-if="addList">
              <span v-for="(item,idx) in addList" :key="idx">
                <span class="tag tag-rxjs tag-lg" v-if="idx%3 === 0">{{item}}</span>
                <span class="tag tag-graphql tag-lg" v-else-if="idx%2 === 0">{{item}}</span>
                <span class="tag tag-machine-learning tag-lg" v-else>{{item}}</span>
              </span>
            </div>
        
        
        
        
        </div> 
         

          
          
          <hr>
          <h4>캠핑장 위치</h4>

          <Kakaomap v-if="detailData.length != 0" :detailData="detailData" />
        

        <div class="d-flex flex-row justify-content-between " style="margin-top:29px;">
          <div>
            <h4 style="">후기</h4>
          </div>
          <button @click="review" class="write">후기 작성</button>
        </div>
          <CampRatelist v-if="rateList.length != 0" :rateList="rateList" />
        
      </div>
    </div>
  </div>
</div>
</template>

<script>
import Kakaomap from "@/components/campsite/Kakaomap.vue";
// import {onMounted, } from 'vue'
import { useRoute, useRouter } from "vue-router";
import axios from "axios";
import { ref,computed } from "vue";
import CampRatelist from "@/components/campsite/CampRatelist.vue";
import Navbar from "@/components/common/Navbar.vue";

const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {
  name: "Campsitedetail",
  components: {
    Kakaomap,
    Navbar,
    CampRatelist,
  },
  setup() {
    const totalAvg = ref(0)
    const route = useRoute();
    const detailData = ref([]);
    const router = useRouter();
    const id = route.params.contentId;
    console.log(id)
    const checksbrsEtc = () => {
      // console.log("하이", res);
      if (detailData.value.sbrsEtc.includes("수영장")) {
        // console.log("있어요");
      }
    };

    // 캠핑장 정보
    axios({
      method: "get",
      url: `${SERVER_URL}/camp/${id}`,
    })
      .then((res) => {
        detailData.value = res.data.dto;
        // console.log(detailData.value.sbrsEtc);
        // this.checksbrsEtc;
        // checksbrsEtc();
        checksbrsEtc(detailData.value);
      })
      .catch((err) => {
        console.log(err);
      });

    const rateList = ref([]);
    //후기불러오기
    axios({
      method: "get",
      url: `${SERVER_URL}/camp/rate/${id}`,
    })
      .then((res) => {
        rateList.value = res.data.list;
        console.log(rateList.value);
        rateList.value.forEach( ele => {
        console.log(ele.campRateCleanliness + ele.campRateFacility + ele.campRatePrice)
        totalAvg.value += ele.campRateCleanliness + ele.campRateFacility + ele.campRatePrice
      })
      })
      .catch((err) => {
        console.log(err);
      });
    console.log(detailData.value);
    console.log(rateList.value);

    const review = () => {
      router.push({ name: "Campsitereview", params: { 'content': id } });
    };

    
    

    const rateAvg = computed(() => {
      return totalAvg.value / (3*rateList.value.length) 
    })


    const splitedList = computed(() => {
        if (detailData.value.sbrsCl) {
        return detailData.value.sbrsCl.split(',')
        } else return ""
      })

   

    const splitedThemeList = computed(() => {
        if (detailData.value.sbrsEtc) {
        return detailData.value.sbrsEtc.split(',')
        } else return ""
      })
  
    const addList = computed(() => {
        if (detailData.value.posblFcltyCl) {
        return detailData.value.posblFcltyCl.split(',')
        } else return ""
      })



    return {
      rateList,
      detailData,
      review,
      checksbrsEtc,
      totalAvg,
      rateAvg,
      splitedList,
      splitedThemeList,
      addList,
    };
  },
};
</script>

<style scoped>
.Navbar {
  width: 100%;
}
.CampSiteDetail-ImageFrame {
  border-radius: 50%;
}
.CampSiteDetail-ImageFrame img {
  border-radius: 3%;
}
@media (max-width: 420px) {
  .CampSiteDetail-ImageFrame img {
    /* width: 100%; */
    max-width: 100%;
    max-height: 400px;
  }
}
@media (max-width: 768px) {
  body {
    width: 768px;
    margin: 0 auto;
    padding: 0 20px;
    background: beige;
  }
  .CampSiteDetail-ImageFrame img {
    width: 100%;
    max-width: 100%;
    max-height: 400px;
  }
}
@media (min-width: 769px) {
  .container {
    width: 70%;
  }
  .CampSiteDetail-TotalFrame {
    /* margin-top: 4%; */
    min-width: 768px;
    max-width: 768px;
    background: #fff;
    margin-top: 5%;
    margin-bottom: 5%;
    border-radius: 20px;
    /* height:90vh */

    /* width: 90%; */
  }
  .campsitedetailContent p {
    font-family: "Comfortaa";
  }
  .CampSiteDetail-ImageFrame img {
    /* width: 100%; */
    max-width: 70%;
    max-height: 400px;
  }
}
.CampSiteDetail-TotalFrame {
  /* margin-top: 4%; */
}

.bi-star-fill{
  color: #7ac4e1;
}

.bi-chat-left-dots{
  color: #7ac4e1;
}

.bi-geo-alt {
  color: #7ac4e1;
}

.write { 
  color: #7ac4e1;
  border: 3px solid #7ac4e1;
  border-radius: 30px;
  background-color:#fff
}




:root {
    --red:#ff3860;--red-dark:#ff1443;--red-light:#ff5c7c;--blue:#498afb;--blue-dark:#2674fa;--blue-light:#6ca0fc;--orange:#fa8142;--orange-dark:#f96a1f;--orange-light:#fb9865;--green:#09c372;--green-dark:#07a15e;--green-light:#0be586;--purple:#9166cc;--purple-dark:#7d4bc3;--purple-light:#a481d5;--yellow:#ffdd57;--yellow-dark:#ffd633;--yellow-light:#ffe47a;--pink:#ff4088;--pink-dark:#ff1c72;--pink-light:#ff649e;--gray0:#f8f8f8;--gray1:#dbe1e8;--gray2:#b2becd;--gray3:#6c7983;--gray4:#454e56;--gray5:#2a2e35;--gray6:#12181b;--nav-width:4em;--font-body:"sofia-pro",sans-serif;--font-head:"sofia-pro",sans-serif;--font-code:"attribute-mono",monospace;--font-size:20px;--max-width-bp:768px;--orange-pink:linear-gradient(to bottom right,var(--orange-light),var(--orange-dark) 85%);--green-grad:linear-gradient(to bottom right,var(--green-light),var(--green-dark) 85%);--background:var(--gray6);--text-color:var(--gray2);--h-color:#fff;--nav-shadow:4px 0 10px -3px #010101;--card-shadow:0 4px 8px rgba(0,0,0,0.38);--toc-shadow:rgba(0,0,0,0.7) 0px 10px 20px 0px;--nav-bg:var(--gray5);--tag-bg:var(--gray4);--code-bg:#22262f;--card-bg:var(--gray5);--overlay-bg:rgba(0,0,0,0.9);--h-border:2px dashed var(--nav-bg);--nav-border:2px dashed var(--text-color);--card-radius:0.25em;transition: all .3s ease
}





.tag {
    display: inline-block;
    border-radius: 3px;
    padding: .2em .5em .3em;
    border-radius: 2px;
    background: var(--tag-bg);
    color: var(--text-color);
    font-weight: 600;
    margin: .25em .1em
}

h1.tag {
    margin-left: 0;
    margin-right: 0
}

.tag-sm {
    font-size: .7em;
    display: inline-block;
    letter-spacing: .15ch;
    font-weight: 400
}

.tag-lg {
    font-size: 1.2em;
    border-radius: 4px
}

.tag-bg {
    background: var(--background)
}


.tag-typescript {
    background: #2775c3;
    color: #fff
}





.tag-cloud-functions {
    background: rgb(145, 143, 143);
    color: rgb(180, 87, 87)
}

.tag-flutter {
    background: #54c5f8;
    color: #003b6c
}


.tag-stripe {
    color: #fff;
    background: #6675e0
}

.tag-rxjs {
    background: rgb(255, 106, 131);
    color: rgb(0, 0, 0);
}

.tag-graphql {
    color: #fff;
    background: #e10097
}
.tag-machine-learning {
    color: rgb(141, 140, 140);
    background: pink
}


.tag-ionic {
    background: rgb(102, 102, 102);
    color: #c5c6c7
}



.tag-electron {
    color: #313244;
    background: #adecf3
}

hr {
  border: solid 1px #7ac4e1;
}
</style>
