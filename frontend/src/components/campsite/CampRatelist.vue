<template>
  <body>
    <div v-for="(data,idx) in rateData" :key="idx">
      <!-- <div @click="goDetail(data.campRateNo)">{{data.campRateTitle}}</div> -->
      <details>
        <summary style="font-size:20px;">제목 : {{data.campRateTitle}} <i class="bi bi-arrow-down-circle"></i></summary>
        <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="media g-mb-30 media-comment">
                
                    <div class="media-body u-shadow-v18 g-bg-secondary g-pa-30" @click="goDetail(data.campRateNo)">
                      <div class="g-mb-15">
                        <h5 class="h5 g-color-gray-dark-v1 mb-0">{{data.campRateTitle}}</h5>
                        <span class="g-color-gray-dark-v4 g-font-size-12">{{data.campRateUpdateTime}}</span>
                      </div>
                
                      <p style="min-height:100px">{{data.campRateContent}}</p>

                      <ul class="list-inline d-sm-flex my-0">
                        <li class="list-inline-item g-mr-20">
                          <div>청결도</div>
                            <div class="star-ratings" style="margin-top: 0px">
                              <div
                                class="star-ratings-fill space-x-2 text-lg"
                                :style="{ width: data.campRateCleanliness * 20 + 1.5 + '%' }"
                              >
                                <span>★</span><span>★</span><span>★</span><span>★</span
                                ><span>★</span>
                              </div>
                              <div class="star-ratings-base space-x-2 text-lg">
                                <span>★</span><span>★</span><span>★</span><span>★</span
                                ><span>★</span>
                              </div>
                              <div></div>
                            </div>
                        </li>
                        <li class="list-inline-item g-mr-20">
                            시설
                            <div class="star-ratings" style="margin-top: 0px">
                              <div
                                class="star-ratings-fill space-x-2 text-lg"
                                :style="{ width: data.campRateFacility * 20 + 1.5 + '%' }"
                              >
                                <span>★</span><span>★</span><span>★</span><span>★</span
                                ><span>★</span>
                              </div>
                              <div class="star-ratings-base space-x-2 text-lg">
                                <span>★</span><span>★</span><span>★</span><span>★</span
                                ><span>★</span>
                              </div>
                              <div></div>
                            </div>
       
                        </li>
                        <li class="list-inline-item g-mr-20">
                          가격
                   
                            <div class="star-ratings" style="margin-top: 0px">
                              <div
                                class="star-ratings-fill space-x-2 text-lg"
                                :style="{ width: data.campRatePrice * 20 + 1.5 + '%' }"
                              >
                                <span>★</span><span>★</span><span>★</span><span>★</span
                                ><span>★</span>
                              </div>
                              <div class="star-ratings-base space-x-2 text-lg">
                                <span>★</span><span>★</span><span>★</span><span>★</span
                                ><span>★</span>
                              </div>
                              <div></div>
                            </div>
                  
                        </li>
                      </ul>
                    </div>
                </div>
            </div>

        </div>
        </div>
        <CampRatecomment/>
      </details>
    </div>
  </body>
</template>

<script>
import {ref} from 'vue'
import { useRouter } from "vue-router"
import CampRatecomment from '@/components/campsite/CampRatecomment.vue'

export default {
  name : 'CampRatelist',
  props : ['rateList'],
  setup(props) {
    const router = useRouter()
    console.log(props.rateList)
    const rateData = ref(props.rateList)
    const goDetail = (no) => {
      router.push({name : 'Campratedetail' , params : { rateNo : no}})
    }

    return {
      rateData,
      goDetail,
      CampRatecomment,
    }
  }

}
</script>

<style scoped>

@media (min-width: 768px) {
  body {
    width: 70%;

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
</style>