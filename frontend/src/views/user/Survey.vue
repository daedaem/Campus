<template>
  <div>
    <div class="card my-auto mx-auto" style="width: 25rem; height: 400px">
      <div class="card-body">
        <h2 class="card-title my-3">캠핑 유형 조사</h2>

        <div class="container p-3" align="left">
          <!-- 1 페이지 -->
          <div v-if="page === 1">
            <h1>Q1</h1>
            <button
              type="button"
              :class="{
                mbtiButtonOn: oneButton,
                mbtiButtonOff: !oneButton,
              }"
              @click="mbtione"
            >
              옆 텐트의 모르는 사람에게 말을 걸지 않는다
            </button>
            <button
              type="button"
              :class="{
                mbtiButtonOn: notoneButton,
                mbtiButtonOff: !notoneButton,
              }"
              @click="mbtinotone"
            >
              나는 캠핑장 옆 텐트에서 망치 빌리는 것이 어렵지 않다
            </button>
            <button class="mt-3" @click.prevent="next()">Next</button>
          </div>

          <!-- 2 페이지 -->
          <div v-if="page === 2">
            <h2>Q2</h2>

            <button
              type="button"
              :class="{
                mbtiButtonOn: twoButton,
                mbtiButtonOff: !twoButton,
              }"
              @click="mbtitwo"
            >
              나는 할 거리가 많은 캠핑장을 찾는다
            </button>
            <button
              type="button"
              :class="{
                mbtiButtonOn: nottwoButton,
                mbtiButtonOff: !nottwoButton,
              }"
              @click="mbtinottwo"
            >
              나는 조용한 캠핑장을 찾는다
            </button>

            <div class="mt-3">
              <button @click.prevent="prev()">Previous</button>
              <button @click.prevent="next()">Next</button>
            </div>
          </div>

          <!-- 3 페이지 -->
          <div v-if="page === 3">
            <h2>Q3</h2>
            <button
              type="button"
              :class="{
                mbtiButtonOn: threeButton,
                mbtiButtonOff: !threeButton,
              }"
              @click="mbtithree"
            >
              나는 혼자 캠핑 가면 지루해서 기피한다.
            </button>
            <button
              type="button"
              :class="{
                mbtiButtonOn: notthreeButton,
                mbtiButtonOff: !notthreeButton,
              }"
              @click="mbtinotthree"
            >
              나는 여럿이 같이 캠핑가면 피곤하다.
            </button>

            <div class="mt-3">
              <button @click.prevent="prev()">Previous</button>
              <button @click.prevent="next()">Next</button>
            </div>
          </div>

          <!-- 4 페이지 -->
          <div v-if="page === 4">
            <h2>Q4</h2>

            <button
              type="button"
              :class="{
                mbtiButtonOn: fourButton,
                mbtiButtonOff: !fourButton,
              }"
              @click="mbtifour"
            >
              나는 익숙한 캠핑장에 가는 것을 선호한다.
            </button>
            <button
              type="button"
              :class="{
                mbtiButtonOn: notfourButton,
                mbtiButtonOff: !notfourButton,
              }"
              @click="mbtinotfour"
            >
              나는 가능하면 새로운 캠핑장을 경험해보는 것을 좋아한다.
            </button>

            <div class="mt-3">
              <button @click.prevent="prev()">Previous</button>
              <button @click.prevent="next()">Next</button>
            </div>
          </div>

          <div v-if="page === 5">
            <h2>Q5</h2>
            <button
              type="button"
              :class="{
                mbtiButtonOn: fiveButton,
                mbtiButtonOff: !fiveButton,
              }"
              @click="mbtifive"
            >
              나는 필요한 것만 챙겨서 다니는 미니멀 캠핑이 좋다
            </button>
            <button
              type="button"
              :class="{
                mbtiButtonOn: notfiveButton,
                mbtiButtonOff: !notfiveButton,
              }"
              @click="mbtinotfive"
            >
              나는 분위기에 죽고 사는 감성 캠핑이 좋다
            </button>

            <div class="mt-3">
              <button @click.prevent="prev()">Previous</button>
              <button @click.prevent="next()">Next</button>
            </div>
          </div>

          <div v-if="page === 6">
            <h2>Q6</h2>
            <button
              type="button"
              :class="{
                mbtiButtonOn: sixButton,
                mbtiButtonOff: !sixButton,
              }"
              @click="mbtisix"
            >
              나는 캠핑장 가는 방법을 구체적으로 공부해서, 인근에 액티비티
              정보를 사전에 찾아본다
            </button>
            <button
              type="button"
              :class="{
                mbtiButtonOn: notsixButton,
                mbtiButtonOff: !notsixButton,
              }"
              @click="mbtinotsix"
            >
              나는 캠핑장 가는 방법을 당일 아침 네비게이션으로 확인한다.
            </button>

            <div class="mt-3">
              <button @click.prevent="prev()">Previous</button>
              <button @click.prevent="next()">Next</button>
            </div>
          </div>

          <div v-if="page === 7">
            <h2>Q7</h2>

            <button
              type="button"
              :class="{
                mbtiButtonOn: sevenButton,
                mbtiButtonOff: !sevenButton,
              }"
              @click="mbtiseven"
            >
              지인이 캠핑하는데 눈이 왔다고 하면, 내 반응은 ‘분위기 좋았어?’
              라고 물어본다
            </button>
            <button
              type="button"
              :class="{
                mbtiButtonOn: notsevenButton,
                mbtiButtonOff: !notsevenButton,
              }"
              @click="mbtinotseven"
            >
              지인이 캠핑하는데 눈이 왔다고 하면, 내 반응은 ‘텐트는 잘 말렸어?’
              라고 물어본다
            </button>

            <div class="mt-3">
              <button @click.prevent="prev()">Previous</button>
              <button @click.prevent="next()">Next</button>
            </div>
          </div>

          <div v-if="page === 8">
            <h2>Q8</h2>

            <button
              type="button"
              :class="{
                mbtiButtonOn: eightButton,
                mbtiButtonOff: !eightButton,
              }"
              @click="mbtieight"
            >
              나는 내가 해야 할 일을 먼저 하고, 옆 사람이 어려워하는 것을
              도와준다
            </button>
            <button
              type="button"
              :class="{
                mbtiButtonOn: noteightButton,
                mbtiButtonOff: !noteightButton,
              }"
              @click="mbtinoteight"
            >
              나는 내가 해야 할 일이 있어도, 옆사람이 텐트치는 것이 어려우면, 그
              것을 먼저 도와준다
            </button>

            <div class="mt-3">
              <button @click.prevent="prev()">Previous</button>
              <button @click.prevent="next()">Next</button>
            </div>
          </div>

          <div v-if="page === 9">
            <h2>Q9</h2>
            <button
              type="button"
              :class="{
                mbtiButtonOn: nineButton,
                mbtiButtonOff: !nineButton,
              }"
              @click="mbtinine"
            >
              주변 사람들에게 같이가면 좋은 캠퍼로 인식되고 싶다.
            </button>
            <button
              type="button"
              :class="{
                mbtiButtonOn: notnineButton,
                mbtiButtonOff: !notnineButton,
              }"
              @click="mbtinotnine"
            >
              주변 사람들에게 텐트 칼각 능력이 있는 캠퍼로 인식되고 싶다.
            </button>

            <div class="mt-3">
              <button @click.prevent="prev()">Previous</button>
              <button @click.prevent="next()">Next</button>
            </div>
          </div>

          <div v-if="page === 10">
            <h2>Q10</h2>
            <button
              type="button"
              :class="{
                mbtiButtonOn: tenButton,
                mbtiButtonOff: !tenButton,
              }"
              @click="mbtiten"
            >
              세워둔 캠핑 계획을 못하면 매우 스트레스 받는다
            </button>
            <button
              type="button"
              :class="{
                mbtiButtonOn: nottenButton,
                mbtiButtonOff: !nottenButton,
              }"
              @click="mbtinotten"
            >
              세워둔 캠핑 계획을 못하면 ‘그럴수도 있지 뭐, 다른거 하자’
            </button>

            <div class="mt-3">
              <button @click.prevent="prev()">Previous</button>
              <button @click.prevent="next()">Next</button>
            </div>
          </div>

          <div v-if="page === 11">
            <h2>Q11</h2>
            <button
              type="button"
              :class="{
                mbtiButtonOn: eleButton,
                mbtiButtonOff: !eleButton,
              }"
              @click="mbtiele"
            >
              나는 텐트 피칭(설치)시 팩을 1~2개 덜 박아서, 텐트가 살짝 울어도
              괜찮다
            </button>
            <button
              type="button"
              :class="{
                mbtiButtonOn: noteleButton,
                mbtiButtonOff: !noteleButton,
              }"
              @click="mbtinotele"
            >
              나는 텐트 피칭(설치)시 모든 팩을 다 박아서, 칼같이 팽팽한 텐트를
              보면서 성취감을 느낀다
            </button>

            <div class="mt-3">
              <button @click.prevent="prev()">Previous</button>
              <button @click.prevent="next()">Next</button>
            </div>
          </div>

          <div v-if="page === 12">
            <h2>Q12</h2>
            <button
              type="button"
              :class="{
                mbtiButtonOn: tweButton,
                mbtiButtonOff: !tweButton,
              }"
              @click="mbtitwe"
            >
              캠핑장 퇴실 시간에 맞춰서 나가려고 할 때, 늦을까봐 불안해서 조금
              일찍 나간다
            </button>
            <button
              type="button"
              :class="{
                mbtiButtonOn: nottweButton,
                mbtiButtonOff: !nottweButton,
              }"
              @click="mbtinottwe"
            >
              캠핑장 퇴실 시간에 맞춰서 나가려고 한다.
            </button>

<<<<<<< HEAD
            <div class="mt-3">
              <button @click.prevent="prev()">Previous</button>
              <button @click.prevent="[checkmbti(), onSubmit()]">finish</button>
            </div>
          </div>
        </div>
      </div>
    </div>
    <button @click="mbtiskip">스킵버튼</button>
    Debug: {{ credentials }}
  </div>
=======
					<div v-if="page === 10">
						<h2>Q10</h2>
						<button
							type="button"
							:class="{
								mbtiButtonOn: tenButton,
								mbtiButtonOff: !tenButton,
							}"
							@click="mbtiten">
							세워둔 캠핑 계획을 못하면 매우 스트레스 받는다
						</button>
						<button
							type="button"
							:class="{
								mbtiButtonOn: nottenButton,
								mbtiButtonOff: !nottenButton,
							}"
							@click="mbtinotten">
							세워둔 캠핑 계획을 못하면 ‘그럴수도 있지 뭐, 다른거 하자’
						</button>


						<div class="mt-3">
							<button @click.prevent="prev()">Previous</button>
							<button @click.prevent="next()">Next</button>
						</div>
					</div>

					<div v-if="page === 11">
						<h2>Q11</h2>
						<button
							type="button"
							:class="{
								mbtiButtonOn: eleButton,
								mbtiButtonOff: !eleButton,
							}"
							@click="mbtiele">
							나는 텐트 피칭(설치)시 팩을 1~2개 덜 박아서, 텐트가 살짝 울어도 괜찮다 
						</button>
						<button
							type="button"
							:class="{
								mbtiButtonOn: noteleButton,
								mbtiButtonOff: !noteleButton,
							}"
							@click="mbtinotele">
							나는 텐트 피칭(설치)시 모든 팩을 다 박아서, 칼같이 팽팽한 텐트를 보면서 성취감을 느낀다
						</button>


						<div class="mt-3">
							<button @click.prevent="prev()">Previous</button>
							<button @click.prevent="next()">Next</button>
						</div>
					</div>

					<div v-if="page === 12">
						<h2>Q12</h2>
						<button
							type="button"
							:class="{
								mbtiButtonOn: tweButton,
								mbtiButtonOff: !tweButton,
							}"
							@click="mbtitwe">
							캠핑장 퇴실 시간에 맞춰서 나가려고 할 때, 늦을까봐 불안해서 조금 일찍 나간다
						</button>
						<button
							type="button"
							:class="{
								mbtiButtonOn: nottweButton,
								mbtiButtonOff: !nottweButton,
							}"
							@click="mbtinottwe">
							캠핑장 퇴실 시간에 맞춰서 나가려고 한다.
						</button>


						<div class="mt-3">
							<button @click.prevent="prev()">Previous</button>
							<button @click.prevent="checkmbti()">finish</button>
						</div>
					</div>
				
				
				
				
				</div>


			</div>
		</div>
		<button @click="mbtiskip">스킵버튼</button>
		Debug: {{ credentials }}
	</div>
>>>>>>> 718598346e95dc702d937f60de30fe46c2342de3
</template>

<script>
import axios from "axios";

// const SERVER_URL = process.env.VUE_APP_SERVER_URL
<<<<<<< HEAD
const SERVER_URL = `http://i6e102.p.ssafy.io:8080`;
// const SERVER_URL = `http://localhost:8080`;

export default {
  name: "Survey",
  data() {
    return {
      page: 1,
      credentials: {
        survey: {
          EI: "",
          SN: "",
          TF: "",
          JP: "",
        },
      },
      oneButton: false,
      notoneButton: false,
      twoButton: false,
      nottwoButton: false,
      threeButton: false,
      notthreeButton: false,
      fourButton: false,
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
    };
  },
=======
const SERVER_URL = 'http://localhost:8080';

export default {
	name: "Survey",
	data() {
		return {
			page: 1,
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
			tenButton : false,
			nottenButton: false,
			eleButton: false,
			noteleButton: false,
			tweButton: false,
			nottweButton: false,
			
>>>>>>> 718598346e95dc702d937f60de30fe46c2342de3

  methods: {
    prev() {
      this.page--;
    },
    next() {
      this.page++;
    },
    onSubmit() {
      axios({
        method: "put",
        url: `${SERVER_URL}/user/mbti`,
        data: this.credentials,
      })
        .then((res) => {
          console.log(res);
          alert("설문조사 완료");
          this.$router.push({ name: "Mainpage" });
        })
        .catch(() => {
          alert("다시 시도해주세요.");
        });
    },
    mbtiskip: function () {
      this.$router.push({ name: "Mainpage" });
    },

<<<<<<< HEAD
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
=======
			question1: 0,
			question2: 0,
			question3: 0,
			question4: 0,
			userEmail: "",
			isMBTI: false
		}
	},
	created: function() {
		console.log(this.$store.state.userEmail)
		this.userEmail = this.$store.state.userEmail
	},

	methods: {
		prev() {
			this.page--;
		},
		next() {
			this.page++;
		},
		onSubmit() {
			axios
				.put(`${SERVER_URL}/user/mbti`, {
					userEmail: this.userEmail,
					userMBTI: this.credentials.MBTI
				})
				.then((res) => {
					console.log(res)
					alert("설문조사 완료")
					this.$router.push({name: "Mainpage"})
				})
				.catch(() => {
					alert("다시 시도해주세요.")
				})
		},
		mbtiskip: function () {
			this.$router.push({ name: "Mainpage"})
		},
>>>>>>> 718598346e95dc702d937f60de30fe46c2342de3

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

<<<<<<< HEAD
      if (this.question4 > 0) {
        this.credentials.survey.JP = "J";
      } else {
        this.credentials.survey.JP = "P";
      }
    },
  },
};
=======
			if (this.question2 > 0) {
				this.credentials.survey.SN = "S"
			} else {
				this.credentials.survey.SN = "N"
			}

			if (this.question3 > 0) {
				this.credentials.survey.TF = "T"
			} else {
				this.credentials.survey.TF = "F"
			}

			if (this.question4 > 0) {
				this.credentials.survey.JP = "J"
			} else {
				this.credentials.survey.JP = "P"
			}

			if (this.credentials.survey.EI !== null && 
				this.credentials.survey.SN !== null &&
				this.credentials.survey.TF !== null &&
				this.credentials.survey.JP !== null) {
					this.credentials.MBTI =
					this.credentials.survey.EI.concat(
						this.credentials.survey.SN,
						this.credentials.survey.TF,
						this.credentials.survey.JP
					)
					
					this.isMBTI = true
				}
			if (this.isMBTI === true) {
				this.onSubmit()
			} else {
				alert("다시 시도해주세요")
			}
			



		}


	}
}
>>>>>>> 718598346e95dc702d937f60de30fe46c2342de3
</script>

<style>
.mbtiButtonOn {
  background-color: skyblue;
}
.mbtiButtonOff {
  background-color: white;
}
</style>
