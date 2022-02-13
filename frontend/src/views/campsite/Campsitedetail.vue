<template>
  <Navbar class="Navbar"></Navbar>
  <div class="container d-flex flex-row justify-content-center">
    <div class="CampSiteDetail-TotalFrame">
      <div class="m-4">
        <div>
          <h2 align="left">{{ detailData.facltNm }}</h2>
          <div class="ms-3 d-flex justify- content-center align-items-center">
            <div class="mx-2"><i class="bi bi-star-fill"></i>4.7</div>

            <div class="mx-2">
              <i class="bi bi-chat-left-dots px-2"></i>리뷰 90개
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
          <hr />
          <h4>캠핑장 소개</h4>
          <div class="campsitedetailContent">
            <p>{{ detailData.intro }}</p>
          </div>
          <hr />
          <h4>편의시설 및 테마</h4>
          <!-- <div v-if="detailData.value.sbrsEtc.includes('수영장')"> -->
          <!-- 부대시설 -->
          <div class="campSiteDetailContent">
            <p style="font-style: oblique" class="">{{ detailData.sbrsCl }}</p>
            <!-- 부대시설 기타-->
            <p style="font-style: oblique" class="">{{ detailData.sbrsEtc }}</p>
            <!-- </div> -->
            <!-- 부대이용가능 -->
            <p style="font-style: oblique" class="">
              {{ detailData.posblFcltyCl }}
            </p>
          </div>
          <hr />
          <h4>캠핑장 위치</h4>

          <Kakaomap v-if="detailData.length != 0" :detailData="detailData" />
        </div>
        <hr />
        <button @click="review">후기 작성</button>
        <hr />
        <div>
          <h4>후기</h4>

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
import { ref } from "vue";
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
    const route = useRoute();
    const detailData = ref([]);
    const router = useRouter();
    const id = route.params.contentId;

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
      })
      .catch((err) => {
        console.log(err);
      });
    console.log(detailData.value);
    console.log(rateList.value);

    const review = () => {
      router.push({ name: "Campsitereview", params: { rateNo: id } });
    };
    return {
      rateList,
      detailData,
      review,
      checksbrsEtc,
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
</style>
