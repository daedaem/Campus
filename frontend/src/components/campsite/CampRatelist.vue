<template>
  <body>


<div clsss="container">
  <div class="row">
    <div v-for="(data,idx) in rateData" :key="idx" class="col-md-6 col-12" style="margin-top:20px;">
      <div class="d-flex flex-row justify-content-between">
        <div  class="title">{{data.campRateTitle}}</div>
        <div>
          <div class="star-ratings" style="margin-top: 0px">
            <div
              class="star-ratings-fill space-x-2 text-lg"
              :style="{ width: (data.campRateFacility+data.campRatePrice+data.campRateCleanliness)/3 * 13 + 1.5 + '%' }"
            >
              <span>★</span><span>★</span><span>★</span><span>★</span
              ><span>★</span>
            </div>
            <div class="star-ratings-base space-x-2 text-lg">
              <span>★</span><span>★</span><span>★</span><span>★</span
              ><span>★</span><span style="margin-left:10px; color:yellow">{{((data.campRateFacility+data.campRatePrice+data.campRateCleanliness)/3).toFixed(1)}}</span>
            </div>
            <div></div>
          </div>
        </div>
      </div>
      <div class="d-flex flex-row justify-content-between box">
        <div class="nickname">@{{data.userNickname}}</div>
        <div class="date">{{data.campRateUpdateTime}}</div>
      </div>
      <div class="content">{{data.campRateContent}}</div>
      <div class="show d-flex align-items: center;" >
        <details>
        <summary>Show more<i class="bi bi-chevron-double-right " style="padding-top:5px;"></i> </summary>
          <hr>
          <span style="margin-top:10px;">상세 평점</span><button @click="goRaterevise(data.campRateNo)" style="margin-left: 5px; color: #7ac4e1; border: 2px solid #7ac4e1; border-radius: 10px; background-color:#fff;">수정</button>
          <div style="margin-top:10px;">
            <div class="d-flex">
              <div style="margin-right:10px;">Facility</div>
              <div class="star-ratings" style="margin-top: 0px">
                <div
                  class="star-ratings-fill space-x-2 text-lg"
                  :style="{ width: (data.campRateFacility) * 13 + 1.5 + '%' }"
                >
                
                  <span>★</span><span>★</span><span>★</span><span>★</span
                  ><span>★</span>
                </div>
                <div class="star-ratings-base space-x-2 text-lg">
                  <span>★</span><span>★</span><span>★</span><span>★</span
                  ><span>★</span><span style="margin-left:10px; color:yellow">{{(data.campRateFacility).toFixed(1)}}</span>
                </div>
                <div></div>
              </div>
            </div>
            <div class="d-flex">
              <div style="margin-right:10px;">Price</div>
            <div class="star-ratings" style="margin-top: 0px">
              <div
                class="star-ratings-fill space-x-2 text-lg"
                :style="{ width: (data.campRatePrice) * 13 + 1.5 + '%' }"
              >
                <span>★</span><span>★</span><span>★</span><span>★</span
                ><span>★</span>
              </div>
              <div class="star-ratings-base space-x-2 text-lg">
                <span>★</span><span>★</span><span>★</span><span>★</span
                ><span>★</span><span style="margin-left:10px; color:yellow">{{(data.campRatePrice).toFixed(1)}}</span>
              </div>
              <div></div>
            </div>
            </div>
            <div class="d-flex">
              <div style="margin-right:10px;">Cleanliness</div>
            <div class="star-ratings" style="margin-top: 0px">
              <div
                class="star-ratings-fill space-x-2 text-lg"
                :style="{ width: (data.campRateCleanliness) * 13 + 1.5 + '%' }"
              >
                <span>★</span><span>★</span><span>★</span><span>★</span
                ><span>★</span>
              </div>
              <div class="star-ratings-base space-x-2 text-lg">
                <span>★</span><span>★</span><span>★</span><span>★</span
                ><span>★</span><span style="margin-left:10px; color:yellow">{{(data.campRateCleanliness).toFixed(1)}}</span>
              </div>
              <div></div>
            </div>
            </div>
          </div>
        </details>
      </div>
      <hr>
      
      </div>
    </div>
    </div>
    
  

    
  </body>
</template>

<script>
import {ref} from 'vue'
import { useRouter } from "vue-router"
import CampRatecomment from '@/components/campsite/CampRatecomment.vue'

export default {
  name: "CampRatelist",
  props: ["rateList"],
  setup(props) {
    const router = useRouter();
    const temp = ref(props.rateList)
    const rateData = ref([]);
    rateData.value = temp.value.reverse()
    const goDetail = (no) => {
      router.push({ name: "Campratedetail", params: { rateNo: no } });
    };

    const goRaterevise = (Rn) => {
      router.push({name: 'Campraterevise', params : { rateNo : Rn} })
    }
    return {
      rateData,
      goDetail,
      CampRatecomment,
      temp,
      goRaterevise,
    }
  }

}
</script>

<style scoped>

@media (min-width: 768px) {
  body {
    width: 100%;

    /* padding: 0 20px; */
    background: #fff;
  }
}

@media (min-width: 0) {
    .g-mr-15 {
        margin-right: 1.07143rem !important;
    }
}
@media (min-width: 0){
    .g-mt-3 {
        margin-top: 0.21429rem !important;
    }
}

.g-height-50 {
    height: 50px;
}

.g-width-50 {
    width: 50px !important;
}

@media (min-width: 0){
    .g-pa-30 {
        padding: 2.14286rem !important;
    }
}

.g-bg-secondary {
    background-color: #fafafa !important;
}

.u-shadow-v18 {
    box-shadow: 0 5px 10px -6px rgba(0, 0, 0, 0.15);
}

.g-color-gray-dark-v4 {
    color: #777 !important;
}

.g-font-size-12 {
    font-size: 0.85714rem !important;
}

.media-comment {
    margin-top:20px
}

.media-body {
  /* width: 80%; */
}


.star-ratings {
  color: #fff58c;
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

details > summary {
  list-style: none;
}

details > summary::-webkit-details-marker {
  display: none;
}

.title{
  font-weight: 1000;
    
  height : 25px;
  font-size: 14px;
  display:block;
  overflow:hidden;
  text-overflow: ellipsis;
  white-space: normal;
  text-align: left;
  word-wrap: break-word;
  display: -webkit-box;
  -webkit-line-clamp: 1 ;
  -webkit-box-orient: vertical; 
}

.nickname {
  margin-top : 10px;
  color:#7ac4e1;
  /* rgb(117, 117, 117); */
}
.date {
  color:#7ac4e1;
  margin-top : 10px;
  font-size: 12px;
}
.content {
  
  height : 43px;
  font-size: 14px;
  display:block;
  overflow:hidden;
  margin-top : 20px;
  text-overflow: ellipsis;
  white-space: normal;
  text-align: left;
  word-wrap: break-word;
  display: -webkit-box;
  -webkit-line-clamp: 2 ;
  -webkit-box-orient: vertical; 
  
}

summary{
  text-decoration: underline;
  text-underline-position: under;
  margin-top:7px;

}

hr {
  border: solid 1px #7ac4e1;

}
</style>
