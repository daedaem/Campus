<template>
  <div>
    <div class="ms-1 fw-bold">
      <div class="filtertitle my-2">상세조건</div>
    </div>
    <div class="d-flex flex-around mx-1 my-1">
      <button class="buttonfilter-apply col mx-1" @click="findCampsite">
        적용
      </button>
      <button class="buttonfilter-cancel col mx-1" @click="filterCancel">
        취소
      </button>
    </div>
    <hr />
    <div>
      <div class="CampsiteFilterLocationTitle fw-bold">지역</div>
      <div class="form-check form-check-inline">
        <input
          v-if="doNm.length == 0 || doNm.includes('경기도')"
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
          v-if="doNm.length == 0 || doNm.includes('강원도')"
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
          v-if="doNm.length == 0 || doNm.includes('경상남도')"
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
          v-if="doNm.length == 0 || doNm.includes('경상북도')"
          class="form-check-input"
          type="checkbox"
          id="inlineCheckbox4"
          value="경상북도"
          v-model="doNm"
        />
        <label class="form-check-label" for="inlineCheckbox4">경상북도</label>
      </div>
      <div class="form-check form-check-inline">
        <input
          v-if="doNm.length == 0 || doNm.includes('전라남도')"
          class="form-check-input"
          type="checkbox"
          id="inlineCheckbox5"
          value="전라남도"
          v-model="doNm"
        />
        <label class="form-check-label" for="inlineCheckbox5">전라남도</label>
      </div>
      <div class="form-check form-check-inline">
        <input
          v-if="doNm.length == 0 || doNm.includes('전라북도')"
          class="form-check-input"
          type="checkbox"
          id="inlineCheckbox6"
          value="전라북도"
          v-model="doNm"
        />
        <label class="form-check-label" for="inlineCheckbox6">전라북도</label>
      </div>
      <div class="form-check form-check-inline">
        <input
          v-if="doNm.length == 0 || doNm.includes('충청남도')"
          class="form-check-input"
          type="checkbox"
          id="inlineCheckbox7"
          value="충청남도"
          v-model="doNm"
        />
        <label class="form-check-label" for="inlineCheckbox7">충청남도</label>
      </div>
      <div class="form-check form-check-inline">
        <input
          v-if="doNm.length == 0 || doNm.includes('충청북도')"
          class="form-check-input"
          type="checkbox"
          id="inlineCheckbox8"
          value="충청북도"
          v-model="doNm"
        />
        <label class="form-check-label" for="inlineCheckbox8">충청북도</label>
      </div>
      <div class="form-check form-check-inline">
        <input
          v-if="doNm.length == 0 || doNm.includes('제주도')"
          class="form-check-input"
          type="checkbox"
          id="inlineCheckbox9"
          value="제주도"
          v-model="doNm"
        />
        <label class="form-check-label" for="inlineCheckbox9">제주도</label>
      </div>
      <div class="form-check form-check-inline">
        <input
          v-if="doNm.length == 0 || doNm.includes('서울시')"
          class="form-check-input"
          type="checkbox"
          id="inlineCheckbox10"
          value="서울시"
          v-model="doNm"
        />
        <label class="form-check-label" for="inlineCheckbox10">서울시</label>
      </div>
      <div class="form-check form-check-inline">
        <input
          v-if="doNm.length == 0 || doNm.includes('세종시')"
          class="form-check-input"
          type="checkbox"
          id="inlineCheckbox11"
          value="세종시"
          v-model="doNm"
        />
        <label class="form-check-label" for="inlineCheckbox11">세종시</label>
      </div>
      <div class="form-check form-check-inline">
        <input
          v-if="doNm.length == 0 || doNm.includes('인천시')"
          class="form-check-input"
          type="checkbox"
          id="inlineCheckbox12"
          value="인천시"
          v-model="doNm"
        />
        <label class="form-check-label" for="inlineCheckbox12">인천시</label>
      </div>
      <div class="form-check form-check-inline">
        <input
          v-if="doNm.length == 0 || doNm.includes('대구시')"
          class="form-check-input"
          type="checkbox"
          id="inlineCheckbox13"
          value="대구시"
          v-model="doNm"
        />
        <label class="form-check-label" for="inlineCheckbox13">대구시</label>
      </div>
      <div class="form-check form-check-inline">
        <input
          v-if="doNm.length == 0 || doNm.includes('대전시')"
          class="form-check-input"
          type="checkbox"
          id="inlineCheckbox14"
          value="대전시"
          v-model="doNm"
        />
        <label class="form-check-label" for="inlineCheckbox14">대전시</label>
      </div>
      <div class="form-check form-check-inline">
        <input
          v-if="doNm.length == 0 || doNm.includes('부산시')"
          class="form-check-input"
          type="checkbox"
          id="inlineCheckbox15"
          value="부산시"
          v-model="doNm"
        />
        <label class="form-check-label" for="inlineCheckbox15">부산시</label>
      </div>
      <div class="form-check form-check-inline">
        <input
          v-if="doNm.length == 0 || doNm.includes('울산시')"
          class="form-check-input"
          type="checkbox"
          id="inlineCheckbox16"
          value="울산시"
          v-model="doNm"
        />
        <label class="form-check-label" for="inlineCheckbox16">울산시</label>
      </div>
      <div class="form-check form-check-inline">
        <input
          v-if="doNm.length == 0 || doNm.includes('광주시')"
          class="form-check-input"
          type="checkbox"
          id="inlineCheckbox17"
          value="광주시"
          v-model="doNm"
        />
        <label class="form-check-label" for="inlineCheckbox17">광주시</label>
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
      articles: "",
      searchWord: null,
      // doNmtemp: [],
      doNm: [],
      sigunguNm: null,
      toiletCo: 0,
      swrmCo: 0,
      wtrplCo: 0,
      trlerAcmpnyAt: "",
      caravAcmpnyAt: "",
      animalCmgCl: "",
      exprnProgrmAt: "",
      clturEventAt: "",
      eqpmnLendCl: "",
      siteMgCo: 0,
      do: ['강원도', '경기도', '충청남도', '전라남도', '충청북도', '경상남도', '경상북도', '서울시', '세종시', '전라북도', '인천시', '제주도', '대구시', '대전시', '부산시', '울산시', '광주시'],
    };
  },
  methods: {
    findCampsite() {

      this.changed();
      // console.log(this.selected, "단어");
      // for (let i = 0; i <script this.doNm.length; i++) {
      // console.log(this.selected[i], "단어추출");
      axios({
        methods: "get",
        url: `${SERVER_URL}/camp`,
        params: {
          limit: 2000,
          offset: 0,
          searchWord: this.searchWord,
          doNm: this.doNm,
          sigunguNm: this.sigunguNm,
          toiletCo: this.toiletCo,
          swrmCo: this.swrmCo,
          wtrplCo: this.wtrplCo,
          trlerAcmpnyAt: this.trlerAcmpnyAt,
          caravAcmpnyAt: this.caravAcmpnyAt,
          animalCmgCl: this.animalCmgCl,
          exprnProgrmAt: this.exprnProgrmAt,
          clturEventAt: this.clturEventAt,
          eqpmnLendCl: this.eqpmnLendCl,
          siteMgCo: this.siteMgCo,
        },
      }).then((res) => {
        // articles.value.push(...res.data.list);
        // this.searchResults = res.data.list;
        console.log("필터 데이터 전송", res.data.list);
        // this.$router.reload()

        // this.resultCampSite = res.data;
        // if (res.data.list.length > 0) {
        // for (let i = 0; i < res.data.list.length; i++) {
        // this.$store.state.resultOfCampsite = res.data.list;
        // console.log(this.$store.state.resultOfCampsite);
        // }
        // } else {
        // this.$store.state.resultOfCampsite = res.data.list;
        // }
        // this.router.go(0)
        this.$emit("newarticles", res.data.list);
      //         if (this.doNm == null) {
      //   this.doNm = null;
      // }
        // this.$store.dispatch("resultOfCampsite", res.data.list);

        // console.log(this.$store.state.resultCampSite);
        // articles.value.push(...res.data.list);
        this.filterCancel();

        // this.$store.dispatch("searchData", "#" + this.inputData);
        // this.$store.dispatch("searchResult", res.data.list);
      });
      // }
      // console.log(e.target.value);
    },
    filterCancel() {
      (this.searchWord = null),
        (this.doNm = []),
        (this.sigunguNm = null),
        (this.toiletCo = 0),
        (this.swrmCo = 0),
        (this.wtrplCo = 0),
        (this.trlerAcmpnyAt = ""),
        (this.caravAcmpnyAt = ""),
        (this.animalCmgCl = ""),
        (this.exprnProgrmAt = ""),
        (this.clturEventAt = ""),
        (this.eqpmnLendCl = ""),
        (this.siteMgCo = 0);
    },
    changed() {
      if (this.doNm.length > 0) {
        this.doNm = this.doNm[0];
        this.sigunguNm = "";
        this.searchWord = "";
      }
      if (this.doNm.length == 0) {
        this.doNm = null;
      }
      // } else if (this.doNm.length == 1) {
      //   this.doNm = this.doNm[0];
      // }
      // if (this.sigunguNm == false) {
      //   this.sigunguNm = null;
      // }
      if (this.toiletCo == false) {
        this.toiletCo = 0;
      } else {
        this.toiletCo = 1;
      }
      if (this.swrmCo == false) {
        this.swrmCo = 0;
      } else {
        this.swrmCo = 1;
      }
      if (this.wtrplCo == false) {
        this.wtrplCo = 0;
      } else {
        this.wtrplCo = 1;
      }
      if (this.trlerAcmpnyAt == false) {
        this.trlerAcmpnyAt = "";
      } else {
        this.trlerAcmpnyAt = "Y";
      }
      if (this.caravAcmpnyAt == false) {
        this.caravAcmpnyAt = "";
      } else {
        this.caravAcmpnyAt = "Y";
      }
      if (this.animalCmgCl == false) {
        this.animalCmgCl = "";
      } else {
        this.animalCmgCl = "가능";
      }
      if (this.exprnProgrmAt == false) {
        this.exprnProgrmAt = "";
      } else {
        this.exprnProgrmAt = "Y";
      }
      if (this.clturEventAt == false) {
        this.clturEventAt = "";
      } else {
        this.clturEventAt = "Y";
      }
      if (this.eqpmnLendCl == false) {
        this.eqpmnLendCl = "";
      } else {
        this.eqpmnLendCl = "Y";
      }
      if (this.siteMgCo == false) {
        this.siteMgCo = 0;
      } else {
        this.siteMgCo = 1;
      }
    },
  },
  // watch: {
    // doNm() {
    // if (this.doNmtemp.length == 1) {
    //     this.doNm = this.doNmtemp;
    //     this.doNmtemp = true;
    //   }
    // if (this.doNm == false) {
    //   this.doNm = [];
    // }
    //   if (this.doNmtemp.length == 0) {
    //     this.doNm = "";
    //   }
    // },
    // },
  // },
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
