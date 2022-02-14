<template>
  <div>
    <div class="ms-1 fw-bold">
      <div class="filtertitle my-2">상세조건</div>
    </div>
    <div class="d-flex flex-around mx-1 my-1">
      <button
        class="buttonfilter-apply col mx-1"
        type="submit"
        @click="findCampsite"
      >
        적용
      </button>
      <button
        class="buttonfilter-cancel col mx-1"
        type="submit"
        @click="filterCancel"
      >
        취소
      </button>
    </div>
    <hr />
    <div>
      <div class="CampsiteFilterLocationTitle fw-bold">지역</div>
      <div class="form-check form-check-inline">
        <input
          class="form-check-input"
          type="checkbox"
          id="inlineCheckbox1"
          value="경기도"
          v-model="doNm"
        />
        <label class="form-check-label" for="inlineCheckbox1">경기도</label>
      </div>

      <div class="form-check form-check-inline">
        <input
          class="form-check-input"
          type="checkbox"
          id="inlineCheckbox2"
          value="강원도"
          v-model="doNm"
        />
        <label class="form-check-label" for="inlineCheckbox2">강원도</label>
      </div>

      <div class="form-check form-check-inline">
        <input
          class="form-check-input"
          type="checkbox"
          id="inlineCheckbox3"
          value="경상남도"
          v-model="doNm"
        />
        <label class="form-check-label" for="inlineCheckbox3">경상남도</label>
      </div>
      <div class="form-check form-check-inline">
        <input
          class="form-check-input"
          type="checkbox"
          id="inlineCheckbox4"
          value="경상북도"
          v-model="doNm"
        />
        <label class="form-check-label" for="inlineCheckbox4">경상북도</label>
      </div>
    </div>
    <hr />
    <!-- 부대시설 -->
    <div>
      <div class="CampsiteFilterLocationTitle fw-bold">부대시설</div>
      <div class="form-check form-check-inline">
        <input
          class="form-check-input"
          type="checkbox"
          id="inlineCheckbox5"
          value="화장실"
          v-model="toiletCo"
        />
        <label class="form-check-label" for="inlineCheckbox5">화장실</label>
      </div>

      <div class="form-check form-check-inline">
        <input
          class="form-check-input"
          type="checkbox"
          id="inlineCheckbox6"
          value="샤워실"
          v-model="swrmCo"
        />
        <label class="form-check-label" for="inlineCheckbox6">샤워실</label>
      </div>

      <div class="form-check form-check-inline">
        <input
          class="form-check-input"
          type="checkbox"
          id="inlineCheckbox7"
          value="개수대"
          v-model="wtrplCo"
        />
        <label class="form-check-label" for="inlineCheckbox7">개수대</label>
      </div>
      <div class="form-check form-check-inline">
        <input
          class="form-check-input"
          type="checkbox"
          id="inlineCheckbox8"
          value="개인 트레일러"
          v-model="trlerAcmpnyAt"
        />
        <label class="form-check-label" for="inlineCheckbox8"
          >개인 트레일러</label
        >
      </div>
      <div class="form-check form-check-inline">
        <input
          class="form-check-input"
          type="checkbox"
          id="inlineCheckbox9"
          value="개인 카라반"
          v-model="caravAcmpnyAt"
        />
        <label class="form-check-label" for="inlineCheckbox9"
          >개인 카라반</label
        >
      </div>
    </div>
    <hr />
    <!-- 기타  -->
    <div>
      <div class="CampsiteFilterLocationTitle fw-bold">기타 시설</div>
      <div class="form-check form-check-inline">
        <input
          class="form-check-input"
          type="checkbox"
          id="inlineCheckbox10"
          value="반려견 동반"
          v-model="animalCmgCl"
        />
        <label class="form-check-label" for="inlineCheckbox10"
          >반려견 동반</label
        >
      </div>

      <div class="form-check form-check-inline">
        <input
          class="form-check-input"
          type="checkbox"
          id="inlineCheckbox11"
          value="체험 프로그램"
          v-model="exprnProgrmAt"
        />
        <label class="form-check-label" for="inlineCheckbox11"
          >체험 프로그램</label
        >
      </div>

      <div class="form-check form-check-inline">
        <input
          class="form-check-input"
          type="checkbox"
          id="inlineCheckbox12"
          value="자체 문화 행사"
          v-model="clturEventAt"
        />
        <label class="form-check-label" for="inlineCheckbox12"
          >자체 문화 행사</label
        >
      </div>
      <div class="form-check form-check-inline">
        <input
          class="form-check-input"
          type="checkbox"
          id="inlineCheckbox13"
          value="캠핑 장비 대여"
          v-model="eqpmnLendCl"
        />
        <label class="form-check-label" for="inlineCheckbox13"
          >캠핑 장비 대여</label
        >
      </div>
      <div class="form-check form-check-inline">
        <input
          class="form-check-input"
          type="checkbox"
          id="inlineCheckbox14"
          value="사이트 주차"
          v-model="siteMgCo"
        />
        <label class="form-check-label" for="inlineCheckbox14"
          >사이트 주차</label
        >
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {
  data() {
    return {
      resultCampSite: [],
      searchWord: null,
      doNm: null,
      sigunguNm: "",
      toiletCo: 0,
      swrmCo: 1,
      wtrplCo: 0,
      trlerAcmpnyAt: "",
      caravAcmpnyAt: "",
      animalCmgCl: "",
      exprnProgrmAt: "",
      clturEventAt: "",
      eqpmnLendCl: 0,
      siteMgCo: 0,
    };
  },
  methods: {
    findCampsite() {
      console.log(
        this.searchWord,
        this.doNm,
        this.sigunguNm,
        this.toiletCo,
        this.swrmCo,
        this.wtrplCo,
        this.trlerAcmpnyAt,
        this.caravAcmpnyAt,
        this.exprnProgrmAt,
        this.exprnProgrmAt,
        this.clturEventAt,
        this.eqpmnLendCl,
        this.siteMgCo
      );
      this.changed();
      // console.log(this.selected, "단어");
      // for (let i = 0; i <script this.doNm.length; i++) {
      // console.log(this.selected[i], "단어추출");
      axios({
        methods: "get",
        url: `${SERVER_URL}/camp`,
        params: {
          limit: 2906,
          offset: 0,
        },
        data: {
          searchWord: this.searchWord,
          doNm: this.doNm,
          sigunguNm: this.sigunguNm,
          toiletCo: this.toiletCo,
          swrmCo: this.swrmCo,
          wtrplCo: this.wtrplCo,
          trlerAcmpnyAt: this.trlerAcmpnyAt,
          caravAcmpnyAt: this.caravAcmpnyAt,
          animalCmgCl: this.exprnProgrmAt,
          exprnProgrmAt: this.exprnProgrmAt,
          clturEventAt: this.clturEventAt,
          eqpmnLendCl: this.eqpmnLendCl,
          siteMgCo: this.siteMgCo,
        },
      }).then((res) => {
        // articles.value.push(...res.data.list);
        // this.searchResults = res.data.list;
        console.log("있는데", res);
        // this.$store.dispatch("searchData", "#" + this.inputData);
        // this.$store.dispatch("searchResult", res.data.list);
      });
      // }
      // console.log(e.target.value);
    },
    filterCancel() {
      (this.searchWord = null),
        (this.doNm = ""),
        (this.sigunguNm = ""),
        (this.toiletCo = 0),
        (this.swrmCo = 0),
        (this.wtrplCo = 0),
        (this.trlerAcmpnyAt = 0),
        (this.caravAcmpnyAt = 0),
        (this.animalCmgCl = 0),
        (this.exprnProgrmAt = 0),
        (this.clturEventAt = 0),
        (this.eqpmnLendCl = 0),
        (this.siteMgCo = 0);
    },
    async changed() {
      if (this.doNm == "") {
        this.doNm = 0;
      } else {
        this.doNm = 1;
      }
      if (this.sigunguNm === false) {
        this.sigunguNm = 0;
      } else {
        this.sigunguNm = 1;
      }
      if (this.toiletCo === false) {
        this.toiletCo = 0;
      } else {
        this.toiletCo = 1;
      }
      if (this.swrmCo === false) {
        this.swrmCo = 0;
      } else {
        this.swrmCo = 1;
      }
      if (this.wtrplCo === false) {
        this.wtrplCo = 0;
      } else {
        this.wtrplCo = 1;
      }
      if (this.trlerAcmpnyAt === false) {
        this.trlerAcmpnyAt = "";
      } else {
        this.trlerAcmpnyAt = "Y";
      }
      if (this.caravAcmpnyAt === false) {
        this.caravAcmpnyAt = "";
      } else {
        this.caravAcmpnyAt = "Y";
      }
      if (this.animalCmgCl === false) {
        this.animalCmgCl = "";
      } else {
        this.animalCmgCl = "가능";
      }
      if (this.exprnProgrmAt === false) {
        this.exprnProgrmAt = "";
      } else {
        this.exprnProgrmAt = "Y";
      }
      if (this.clturEventAt === false) {
        this.clturEventAt = "";
      } else {
        this.clturEventAt = "Y";
      }
      if (this.eqpmnLendCl === false) {
        this.eqpmnLendCl = "";
      } else {
        this.eqpmnLendCl = "Y";
      }
      if (this.siteMgCo === false) {
        this.siteMgCo = 0;
      } else {
        this.siteMgCo = 1;
      }
    },
  },
};
</script>

<style>
.filtertitle {
  font-size: 15px;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
}
.CampsiteFilterLocationTitle {
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
  font: bold;
  font-size: 14px;
}
.form-check {
  margin-top: 5px;
  margin-right: 5px;
  font-size: 13px;
}
.form-check > .form-check-label {
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
}
.buttonfilter-apply {
  background: #7ac4e1;
  font-size: 13px;
  min-height: 30px;
  color: white;
  border-radius: 4px;
  border: 1px solid #fff;

  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
}
.buttonfilter-cancel {
  background: white;
  font-size: 13px;
  min-height: 30px;
  color: #7ac4e1;
  border-radius: 4px;
  border: 1px solid #7ac4e1;

  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
}
</style>
