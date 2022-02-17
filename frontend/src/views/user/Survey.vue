<template>
  <Navbar/>
  <div>
    <div class="container p-3" align="left">
      <!-- 1 페이지 -->
      <div v-if="page === 1">
        <div class="registration-form">
          <form>
            <h1>Q1</h1>
            <div class="row mb-3">
              <b-progress :max="max" >
                <b-progress-bar :value="page" striped :animated="animate" variant="info">
                  <span><strong>{{ page }} / {{ max }}</strong></span>
                </b-progress-bar>
              </b-progress>
            </div>
            <div class="row">
              <button
                type="button"
                :class="{
                  mbtiButtonOn: oneButton,
                  mbtiButtonOff: !oneButton,}"
                @click="mbtione">
                옆 텐트의 모르는 사람에게 말을 걸지 않는다
              </button>
            </div>
            <div class="row">
              <button
                type="button"
                :class="{
                  mbtiButtonOn: notoneButton,
                  mbtiButtonOff: !notoneButton,}"
                @click="mbtinotone">
                나는 캠핑장 옆 텐트에서 망치 빌리는 것이 어렵지 않다
              </button>
            </div>
            <div class="row">
              <button class="check-button mt-3" @click.prevent="next()">Next</button>
            </div>
          </form>
        </div>
      </div>

      <!-- 2 페이지 -->
      <div v-if="page === 2">
        <div class="registration-form">
          <form>
            <h1>Q2</h1>
            <div class="row mb-3">
              <b-progress :max="max" >
                <b-progress-bar :value="page" striped :animated="animate" variant="info">
                  <span><strong>{{ page }} / {{ max }}</strong></span>
                </b-progress-bar>
              </b-progress>
            </div>
            <div class="row">
              <button
                type="button"
                :class="{
                  mbtiButtonOn: twoButton,
                  mbtiButtonOff: !twoButton,}"
                @click="mbtitwo">
                나는 할 거리가 많은 캠핑장을 찾는다
              </button>
            </div>
            <div class="row">
              <button
                type="button"
                :class="{
                  mbtiButtonOn: nottwoButton,
                  mbtiButtonOff: !nottwoButton,}"
                @click="mbtinottwo">
                나는 조용한 캠핑장을 찾는다
              </button>
            </div>
            <div class="d-flex justify-content-between">
              <button class="check-button" type="button" @click.prevent="prev()">Previous</button>
              <button class="check-button" type="button" @click.prevent="next()">Next</button>
            </div>
          </form>
        </div>
      </div>

      <!-- 3 페이지 -->
      <div v-if="page === 3">
        <div class="registration-form">
          <form>
            <h1>Q3</h1>
            <div class="row mb-3">
              <b-progress :max="max" >
                <b-progress-bar :value="page" striped :animated="animate" variant="info">
                  <span><strong>{{ page }} / {{ max }}</strong></span>
                </b-progress-bar>
              </b-progress>
            </div>
            <div class="row">
              <button
                type="button"
                :class="{
                  mbtiButtonOn: threeButton,
                  mbtiButtonOff: !threeButton,}"
                @click="mbtithree">
                나는 혼자 캠핑 가면 지루해서 기피한다.
              </button>
            </div>
            <div class="row">
              <button
                type="button"
                :class="{
                  mbtiButtonOn: notthreeButton,
                  mbtiButtonOff: !notthreeButton,}"
                @click="mbtinotthree">
                나는 여럿이 같이 캠핑가면 피곤하다.
              </button>
            </div>
            <div class="d-flex justify-content-between">
              <button class="check-button" type="button" @click.prevent="prev()">Previous</button>
              <button class="check-button" type="button" @click.prevent="next()">Next</button>
            </div>
          </form>
        </div>
      </div>

      <!-- 4 페이지 -->
      <div v-if="page === 4">
        <div class="registration-form">
          <form>
            <h1>Q4</h1>
            <div class="row mb-3">
              <b-progress :max="max" >
                <b-progress-bar :value="page" striped :animated="animate" variant="info">
                  <span><strong>{{ page }} / {{ max }}</strong></span>
                </b-progress-bar>
              </b-progress>
            </div>
            <div class="row">
              <button
                type="button"
                :class="{
                  mbtiButtonOn: fourButton,
                  mbtiButtonOff: !fourButton,}"
                @click="mbtifour">
                나는 익숙한 캠핑장에 가는 것을 선호한다.
              </button>
            </div>
            <div class="row">
              <button
                type="button"
                :class="{
                  mbtiButtonOn: notfourButton,
                  mbtiButtonOff: !notfourButton,}"
                @click="mbtinotfour">
                나는 가능하면 새로운 캠핑장을 경험해보는 것을 좋아한다.
              </button>
            </div>
            <div class="d-flex justify-content-between">
              <button class="check-button" type="button" @click.prevent="prev()">Previous</button>
              <button class="check-button" type="button" @click.prevent="next()">Next</button>
            </div>
          </form>
        </div>
      </div>

      <div v-if="page === 5">
        <div class="registration-form">
          <form>
            <h1>Q5</h1>
            <div class="row mb-3">
              <b-progress :max="max" >
                <b-progress-bar :value="page" striped :animated="animate" variant="info">
                  <span><strong>{{ page }} / {{ max }}</strong></span>
                </b-progress-bar>
              </b-progress>
            </div>
            <div class="row">
              <button
                type="button"
                :class="{
                  mbtiButtonOn: fiveButton,
                  mbtiButtonOff: !fiveButton,}"
                @click="mbtifive">
                나는 필요한 것만 챙겨서 다니는 미니멀 캠핑이 좋다
              </button>
            </div>
            <div class="row">
              <button
                type="button"
                :class="{
                  mbtiButtonOn: notfiveButton,
                  mbtiButtonOff: !notfiveButton,}"
                @click="mbtinotfive">
                나는 분위기에 죽고 사는 감성 캠핑이 좋다
              </button>
            </div>
            <div class="d-flex justify-content-between">
              <button class="check-button" type="button" @click.prevent="prev()">Previous</button>
              <button class="check-button" type="button" @click.prevent="next()">Next</button>
            </div>
          </form>
        </div>
      </div>

      <div v-if="page === 6">
        <div class="registration-form">
          <form>
            <h1>Q6</h1>
            <div class="row mb-3">
              <b-progress :max="max" >
                <b-progress-bar :value="page" striped :animated="animate" variant="info">
                  <span><strong>{{ page }} / {{ max }}</strong></span>
                </b-progress-bar>
              </b-progress>
            </div>
            <div class="row">
              <button
                type="button"
                :class="{
                  mbtiButtonOn: sixButton,
                  mbtiButtonOff: !sixButton,}"
                @click="mbtisix">
                나는 캠핑장 가는 방법을 구체적으로 공부해서, 인근에 액티비티
                정보를 사전에 찾아본다
              </button>
            </div>
            <div class="row">
              <button
                type="button"
                :class="{
                  mbtiButtonOn: notsixButton,
                  mbtiButtonOff: !notsixButton,}"
                @click="mbtinotsix">
                나는 캠핑장 가는 방법을 당일 아침 네비게이션으로 확인한다.
              </button>
            </div>
            <div class="d-flex justify-content-between">
              <button class="check-button" type="button" @click.prevent="prev()">Previous</button>
              <button class="check-button" type="button" @click.prevent="next()">Next</button>
            </div>
          </form>
        </div>
      </div>

      <div v-if="page === 7">
        <div class="registration-form">
          <form>
            <h1>Q7</h1>
            <div class="row mb-3">
              <b-progress :max="max" >
                <b-progress-bar :value="page" striped :animated="animate" variant="info">
                  <span><strong>{{ page }} / {{ max }}</strong></span>
                </b-progress-bar>
              </b-progress>
            </div>
            <div class="row">
              <button
                type="button"
                :class="{
                  mbtiButtonOn: sevenButton,
                  mbtiButtonOff: !sevenButton,}"
                @click="mbtiseven">
                지인이 캠핑하는데 눈이 왔다고 하면, 내 반응은 ‘분위기 좋았어?’
                라고 물어본다
              </button>
            </div>
            <div class="row">
              <button
                type="button"
                :class="{
                  mbtiButtonOn: notsevenButton,
                  mbtiButtonOff: !notsevenButton,}"
                @click="mbtinotseven">
                지인이 캠핑하는데 눈이 왔다고 하면, 내 반응은 ‘텐트는 잘 말렸어?’
                라고 물어본다
              </button>
            </div>
            <div class="d-flex justify-content-between">
              <button class="check-button" type="button" @click.prevent="prev()">Previous</button>
              <button class="check-button" type="button" @click.prevent="next()">Next</button>
            </div>
          </form>
        </div>
      </div>

      <div v-if="page === 8">
        <div class="registration-form">
          <form>
            <h1>Q8</h1>
            <div class="row mb-3">
              <b-progress :max="max" >
                <b-progress-bar :value="page" striped :animated="animate" variant="info">
                  <span><strong>{{ page }} / {{ max }}</strong></span>
                </b-progress-bar>
              </b-progress>
            </div>
            <div class="row">
              <button
                type="button"
                :class="{
                  mbtiButtonOn: eightButton,
                  mbtiButtonOff: !eightButton,}"
                @click="mbtieight">
                나는 내가 해야 할 일을 먼저 하고, 옆 사람이 어려워하는 것을
                도와준다
              </button>
            </div>
            <div class="row">
              <button
                type="button"
                :class="{
                  mbtiButtonOn: noteightButton,
                  mbtiButtonOff: !noteightButton,}"
                @click="mbtinoteight">
                나는 내가 해야 할 일이 있어도, 옆사람이 텐트치는 것이 어려우면, 그
                것을 먼저 도와준다
              </button>
            </div>
            <div class="d-flex justify-content-between">
              <button class="check-button" type="button" @click.prevent="prev()">Previous</button>
              <button class="check-button" type="button" @click.prevent="next()">Next</button>
            </div>
          </form>
        </div>
      </div>

      <div v-if="page === 9">
        <div class="registration-form">
          <form>
            <h1>Q9</h1>
            <div class="row mb-3">
              <b-progress :max="max" >
                <b-progress-bar :value="page" striped :animated="animate" variant="info">
                  <span><strong>{{ page }} / {{ max }}</strong></span>
                </b-progress-bar>
              </b-progress>
            </div>
            <div class="row">
              <button
                type="button"
                :class="{
                  mbtiButtonOn: nineButton,
                  mbtiButtonOff: !nineButton,}"
                @click="mbtinine">
                주변 사람들에게 같이가면 좋은 캠퍼로 인식되고 싶다.
              </button>
            </div>
            <div class="row">
              <button
                type="button"
                :class="{
                  mbtiButtonOn: notnineButton,
                  mbtiButtonOff: !notnineButton,}"
                @click="mbtinotnine">
                주변 사람들에게 텐트 칼각 능력이 있는 캠퍼로 인식되고 싶다.
              </button>
            </div>
            <div class="d-flex justify-content-between">
              <button class="check-button" type="button" @click.prevent="prev()">Previous</button>
              <button class="check-button" type="button" @click.prevent="next()">Next</button>
            </div>
          </form>
        </div>
      </div>

      <div v-if="page === 10">
        <div class="registration-form">
          <form>
            <h1>Q10</h1>
            <div class="row mb-3">
              <b-progress :max="max" >
                <b-progress-bar :value="page" striped :animated="animate" variant="info">
                  <span><strong>{{ page }} / {{ max }}</strong></span>
                </b-progress-bar>
              </b-progress>
            </div>
            <div class="row">
              <button
                type="button"
                :class="{
                  mbtiButtonOn: tenButton,
                  mbtiButtonOff: !tenButton,}"
                @click="mbtiten">
                세워둔 캠핑 계획을 못하면 매우 스트레스 받는다
              </button>
            </div>
            <div class="row">
              <button
                type="button"
                :class="{
                  mbtiButtonOn: nottenButton,
                  mbtiButtonOff: !nottenButton,}"
                @click="mbtinotten">
                세워둔 캠핑 계획을 못하면 ‘그럴수도 있지 뭐, 다른거 하자’
              </button>
            </div>
            <div class="d-flex justify-content-between">
              <button class="check-button" type="button" @click.prevent="prev()">Previous</button>
              <button class="check-button" type="button" @click.prevent="next()">Next</button>
            </div>
          </form>
        </div>
      </div>

      <div v-if="page === 11">
        <div class="registration-form">
          <form>
            <h1>Q11</h1>
            <div class="row mb-3">
              <b-progress :max="max" >
                <b-progress-bar :value="page" striped :animated="animate" variant="info">
                  <span><strong>{{ page }} / {{ max }}</strong></span>
                </b-progress-bar>
              </b-progress>
            </div>
            <div class="row">
              <button
                type="button"
                :class="{
                  mbtiButtonOn: eleButton,
                  mbtiButtonOff: !eleButton,}"
                @click="mbtiele">
                나는 텐트 피칭(설치)시 팩을 1~2개 덜 박아서, 텐트가 살짝 울어도
                괜찮다
              </button>
            </div>
            <div class="row">
              <button
                type="button"
                :class="{
                  mbtiButtonOn: noteleButton,
                  mbtiButtonOff: !noteleButton,}"
                @click="mbtinotele">
                나는 텐트 피칭(설치)시 모든 팩을 다 박아서, 칼같이 팽팽한 텐트를
                보면서 성취감을 느낀다
              </button>
            </div>
            <div class="d-flex justify-content-between">
              <button class="check-button" type="button" @click.prevent="prev()">Previous</button>
              <button class="check-button" type="button" @click.prevent="next()">Next</button>
            </div>
          </form>
        </div>
      </div>

      <div v-if="page === 12">
        <div class="registration-form">
          <form>
            <div class="row">
              <h1>Q12</h1>

            </div>
            <div class="row mb-3">
              <b-progress :max="max" >
                <b-progress-bar :value="page" striped :animated="animate" variant="info">
                  <span><strong>{{ page }} / {{ max }}</strong></span>
                </b-progress-bar>
              </b-progress>
            </div>
            <div class="row">
              <button
                type="button"
                :class="{
                  mbtiButtonOn: tweButton,
                  mbtiButtonOff: !tweButton,}"
                @click="mbtitwe">
                캠핑장 퇴실 시간에 맞춰서 나가려고 할 때, 늦을까봐 불안해서 조금
                일찍 나간다
              </button>
            </div>
            <div class="row">
              <button
                type="button"
                :class="{
                  mbtiButtonOn: nottweButton,
                  mbtiButtonOff: !nottweButton,}"
                @click="mbtinottwe">
                캠핑장 퇴실 시간에 맞춰서 나가려고 한다.
              </button>
            </div>
            <div class="d-flex justify-content-between">
              <button class="check-button" type="button" @click.prevent="prev()">Previous</button>
              <button class="check-button" type="button" @click.prevent="checkmbti()">finish</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import Navbar from "@/components/common/Navbar.vue";
import Swal from 'sweetalert2'

const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {
  name: "Survey",
  components: {
    Navbar
  },
  data() {
    return {
      page: 1,
      max: 12,
      credentials: {
        survey: {
          EI: "",
          SN: "",
          TF: "",
          JP: "",
        },
        MBTI: "",
      },
      oneButton: false,
      notoneButton: false,
      twoButton: false,
      nottwoButton: false,
      threeButton: false,
      notthreeButton: false,
      fourButton: false,
      notfourButton: false,
      fiveButton: false,
      notfiveButton: false,
      sixButton: false,
      notsixButton: false,
      sevenButton: false,
      notsevenButton: false,
      eightButton: false,
      noteightButton: false,
      nineButton: false,
      notnineButton: false,
      tenButton: false,
      nottenButton: false,
      eleButton: false,
      noteleButton: false,
      tweButton: false,
      nottweButton: false,

      question1: 0,
      question2: 0,
      question3: 0,
      question4: 0,
      userEmail: "",
      isMBTI: false,
      animate: true,
      finalCheck: false,
    };
  },
  created: function () {
    console.log(this.$store.state.userEmail);
    this.userEmail = this.$store.state.userEmail;
  },

  methods: {

    prev() {
      this.page--;
      this.allcheck();
    },
    next() {
      this.page++;
      this.allcheck();
    },
    allcheck() {
      if ((this.oneButton || this.notoneButton) == true && (this.twoButton || this.nottwoButton) == true &&
      (this.threeButton || this.notthreeButton) == true && (this.fourButton || this.notfourButton) == true &&
      (this.fiveButton || this.notfiveButton) == true && (this.sixButton || this.notsixButton) == true &&
      (this.sevenButton || this.notsevenButton) == true && (this.eightButton || this.noteightButton) == true &&
      (this.nineButton || this.notnineButton) == true && (this.tenButton || this.nottenButton) == true &&
      (this.eleButton || this.noteleButton) == true) {
        this.finalCheck = true
      }
    },
    onSubmit() {
      if (this.finalCheck === false) {
        Swal.fire({title: '설문조사를 완료해주십시요', icon:'info', timer:2000})
      } else {
        axios
          .put(`${SERVER_URL}/user/mbti`, {
            userEmail: this.userEmail,
            userMBTI: this.credentials.MBTI,
          })
          .then((res) => {
            console.log(res);
            Swal.fire({title: '설문조사가 완료되었습니다.', icon:'success', text: this.credentials.MBTI, timer:2000})
            this.$router.push({ name: "Mainpage" });
          })
          .catch(() => {
            alert("다시 시도해주세요.");
          });
      }
    },
    mbtiskip: function () {
      this.$router.push({ name: "Mainpage" });
    },

    mbtione: function () {
      this.oneButton = true;
      this.notoneButton = false;
    },
    mbtinotone: function () {
      this.notoneButton = true;
      this.oneButton = false;
    },
    mbtitwo: function () {
      this.twoButton = true;
      this.nottwoButton = false;
    },
    mbtinottwo: function () {
      this.nottwoButton = true;
      this.twoButton = false;
    },
    mbtithree: function () {
      this.threeButton = true;
      this.notthreeButton = false;
    },
    mbtinotthree: function () {
      this.notthreeButton = true;
      this.threeButton = false;
    },
    mbtifour: function () {
      this.fourButton = true;
      this.notfourButton = false;
    },
    mbtinotfour: function () {
      this.notfourButton = true;
      this.fourButton = false;
    },
    mbtifive: function () {
      this.fiveButton = true;
      this.notfiveButton = false;
    },
    mbtinotfive: function () {
      this.notfiveButton = true;
      this.fiveButton = false;
    },
    mbtisix: function () {
      this.sixButton = true;
      this.notsixButton = false;
    },
    mbtinotsix: function () {
      this.notsixButton = true;
      this.sixButton = false;
    },
    mbtiseven: function () {
      this.sevenButton = true;
      this.notsevenButton = false;
    },
    mbtinotseven: function () {
      this.notsevenButton = true;
      this.sevenButton = false;
    },
    mbtieight: function () {
      this.eightButton = true;
      this.noteightButton = false;
    },
    mbtinoteight: function () {
      this.noteightButton = true;
      this.eightButton = false;
    },
    mbtinine: function () {
      this.nineButton = true;
      this.notnineButton = false;
    },
    mbtinotnine: function () {
      this.notnineButton = true;
      this.nineButton = false;
    },
    mbtiten: function () {
      this.tenButton = true;
      this.nottenButton = false;
    },
    mbtinotten: function () {
      this.nottenButton = true;
      this.tenButton = false;
    },
    mbtiele: function () {
      this.eleButton = true;
      this.noteleButton = false;
    },
    mbtinotele: function () {
      this.noteleButton = true;
      this.eleButton = false;
    },
    mbtitwe: function () {
      this.tweButton = true;
      this.nottweButton = false;
    },
    mbtinottwe: function () {
      this.nottweButton = true;
      this.tweButton = false;
    },
    checkmbti: function () {
      if (this.oneButton === true) {
        this.question1 += 1;
      } else {
        this.question1 -= 1;
      }
      if (this.twoButton === true) {
        this.question1 += 1;
      } else {
        this.question1 -= 1;
      }
      if (this.threeButton === true) {
        this.question1 += 1;
      } else {
        this.question1 -= 1;
      }
      if (this.fourButton === true) {
        this.question2 += 1;
      } else {
        this.question2 -= 1;
      }
      if (this.fiveButton === true) {
        this.question2 += 1;
      } else {
        this.question2 -= 1;
      }
      if (this.sixButton === true) {
        this.question2 += 1;
      } else {
        this.question2 -= 1;
      }
      if (this.sevenButton === true) {
        this.question3 += 1;
      } else {
        this.question3 -= 1;
      }
      if (this.eightButton === true) {
        this.question3 += 1;
      } else {
        this.question3 -= 1;
      }
      if (this.nineButton === true) {
        this.question3 += 1;
      } else {
        this.question3 -= 1;
      }
      if (this.tenButton === true) {
        this.question4 += 1;
      } else {
        this.question4 -= 1;
      }
      if (this.eleButton === true) {
        this.question4 += 1;
      } else {
        this.question4 -= 1;
      }
      if (this.tweButton === true) {
        this.question4 += 1;
      } else {
        this.question4 -= 1;
      }

      if (this.question1 > 0) {
        this.credentials.survey.EI = "E";
      } else {
        this.credentials.survey.EI = "I";
      }

      if (this.question2 > 0) {
        this.credentials.survey.SN = "S";
      } else {
        this.credentials.survey.SN = "N";
      }

      if (this.question3 > 0) {
        this.credentials.survey.TF = "T";
      } else {
        this.credentials.survey.TF = "F";
      }

      if (this.question4 > 0) {
        this.credentials.survey.JP = "J";
      } else {
        this.credentials.survey.JP = "P";
      }

      if (
        this.credentials.survey.EI !== null &&
        this.credentials.survey.SN !== null &&
        this.credentials.survey.TF !== null &&
        this.credentials.survey.JP !== null
      ) {
        this.credentials.MBTI = this.credentials.survey.EI.concat(
          this.credentials.survey.SN,
          this.credentials.survey.TF,
          this.credentials.survey.JP
        );

        this.isMBTI = true;
      }
      if (this.isMBTI === true) {
        this.onSubmit();
      } else {
        alert("다시 시도해주세요");
      }
    },
  },
};
</script>

<style>
/* .mbtiButtonOn {
  background-color: skyblue;
}
.mbtiButtonOff {
  background-color: white;
} */

.registration-form{
	padding: 50px 0;
}
.registration-form form{
	background-color: #dee9ff;
	max-width: 600px;
	margin: auto;
	padding: 50px 70px;
	border-radius: 30px;
	/* border-top-left-radius: 30px;
	border-top-right-radius: 30px; */
	box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.075);
}
.check-button{
	border-radius: 30px;
	padding: 10px 20px;
	margin-bottom: 25px;
	font-weight: bold;
	background-color: #5791ff;
	border: none;
	color: white;
}

.out-button{
	border-radius: 30px;
	padding: 10px 20px;
	margin-bottom: 25px;
	font-weight: bold;
	background-color: #c81414;
	border: none;
	color: white;
}

.mbtiButtonOn {
	border-radius: 20px;
	padding: 10px 20px;
	margin-bottom: 25px;
	font-weight: bold;
  width: 80%;
	background-color: skyblue;
	color: white;
  transition-duration: 0.5s;
}
.mbtiButtonOff {
	border-radius: 20px;
	padding: 10px 20px;
	margin-bottom: 25px;
	font-weight: bold;
  width: 80%;
	background-color: white;
	border: none;
  transition-duration: 0.5s;
}
</style>
