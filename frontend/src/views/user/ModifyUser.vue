<template>
  <div>
    <div v-if="step === 1">
      <div class="registration-form">
        <form>
          <h1>정보 수정</h1>
          <div class="row">
            <label>이메일</label>
            <div class="form-group">
              <input
                class="form-control item"
                type="email"
                style="width: 70%; float: left"
                placeholder="이메일을 입력하세요"
                v-model="credentials.userEmail"
                autofocus
                :disabled="this.validatedcheck === true"
              />
            </div>
          </div>

          <div class="row">
            <label>이름</label>
            <div class="form-group">
              <input
                class="form-control item"
                type="text"
                style="width: 70%; float: left"
                v-model="credentials.userName"
                autofocus
                :disabled="this.validatedcheck === true"
              />
            </div>
          </div>

          <div class="row">
            <label>닉네임</label>
            <div class="form-group">
              <input
                class="form-control item"
                type="text"
                style="width: 70%; float: left"
                placeholder="닉네임을 입력하세요"
                v-model="credentials.userNickname"
                autofocus
                @blur="nicknameValid"
                :disabled="this.validatedcheck === true"
              />

              <!-- <button
								class="check-button"
								@click="duplNickname()"
								type="button"
								>중복확인</button> -->
            </div>
            <!-- <small align="left" v-if="!nicknameValidFlag && this.credentials.userNickname.length > 0" class="check-form" style="color:red">
							특수문자를 사용할 수 없습니다.
						</small> -->
          </div>

          <div class="row mt-2">
            <label>비밀번호</label>
            <div class="form-group">
              <input
                class="form-control item"
                type="password"
                style="width: 70%; float: left"
                placeholder="비밀번호를 입력하세요"
                v-model="credentials.userPassword"
                autofocus
                @blur="passwordValid"
              />
            </div>
            <!-- 소문자/숫자가 1개이상 존재하고 8-16자리 -->
            <small
              align="left"
              v-if="
                !passwordValidFlag && this.credentials.userPassword.length > 0
              "
              class="check-form"
              style="color: red"
            >
              유효하지 않은 비밀번호 입니다.
            </small>
          </div>

          <div class="row mt-2">
            <label>비밀번호 확인</label>
            <div class="form-group">
              <input
                class="form-control item"
                type="password"
                style="width: 70%; float: left"
                placeholder="비밀번호를 한번 더 입력하세요"
                v-model="credentials.password_confirmation"
                autofocus
                @blur="passwordCheckValid"
              />
            </div>
            <small
              align="left"
              v-if="
                !passwordCheckFlag &&
                this.credentials.password_confirmation.length > 0
              "
              class="check-form"
              style="color: red"
            >
              비밀번호가 다릅니다.
            </small>
          </div>

          <!-- 다음 버튼 -->
          <div class="row">
            <button class="check-button mt-2" @click.prevent="next()">
              Next
            </button>
          </div>

          <div class="row">
            <button
              class="delete-button mt-3"
              @click="deleteAccount"
              type="button"
            >
              회원탈퇴
            </button>
          </div>
        </form>
      </div>
    </div>

    <!-- 2페이지 -->
    <div v-if="step === 2">
      <div class="registration-form">
        <form>
          <h1>추가 정보 수정</h1>
          <div class="form-group row mb-3">
            <h4>나이</h4>
            <select
              @change="age_select"
              v-model="credentials.userAge"
              class="form-select"
            >
              <option disabled value="">나이 선택</option>
              <option v-for="option in 80" :key="option" :value="option">
                {{ option }}
              </option>
              <!-- <option value="10">10대</option>
							<option value="20">20대</option>
							<option value="30">30대</option>
							<option value="40">40대</option>
							<option value="50">50대</option>
							<option value="60">60대</option>
							<option value="70">70대</option>
							<option value="80">80대</option>
							<option value="90">90대</option> -->
            </select>
          </div>

          <div class="form-group row mb-3">
            <h4>거주 지역</h4>
            <select
              @change="area_select"
              v-model="credentials.userLocation"
              class="form-select"
            >
              <option disabled value="">지역선택</option>
              <option value="서울">서울</option>
              <option value="부산">부산</option>
              <option value="대구">대구</option>
              <option value="인천">인천</option>
              <option value="광주">광주</option>
              <option value="대전">대전</option>
              <option value="울산">울산</option>
              <option value="세종">세종</option>
              <option value="경기">경기</option>
              <option value="강원">강원</option>
              <option value="충북">충북</option>
              <option value="충남">충남</option>
              <option value="전북">전북</option>
              <option value="전남">전남</option>
              <option value="경북">경북</option>
              <option value="경남">경남</option>
              <option value="제주">제주</option>
            </select>
          </div>

          <div class="form-group row mb-3">
            <h1 class="row mx-1">성별</h1>
            <div class="row">
              <div class="col">
                <button
                  type="button"
                  :class="{
                    modifygenderButtonOn: maleButton,
                    modifygenderButtonOff: !maleButton,
                  }"
                  @click="clickMale"
                >
                  남자
                </button>
              </div>
              <div class="col">
                <button
                  type="button"
                  :class="{
                    modifygenderButtonOn: femaleButton,
                    modifygenderButtonOff: !femaleButton,
                  }"
                  @click="clickFemale"
                >
                  여자
                </button>
              </div>
            </div>
          </div>

          <div class="form-group row mb-3">
            <h4>나의 프로필</h4>
            <Fileupload @image="uploadedImage" />
          </div>

          <div class="d-flex justify-content-between">
            <button @click.prevent="prev()" class="check-button" type="button">
              Previous
            </button>
            <button @click.prevent="next()" class="check-button" type="button">
              Next
            </button>
          </div>

          <div class="row">
            <button
              class="delete-button mt-3"
              @click="deleteAccount"
              type="button"
            >
              회원탈퇴
            </button>
          </div>
        </form>
      </div>
    </div>

    <div v-if="step === 3">
      <div class="registration-form">
        <form>
          <!-- 스타일 -->
          <div class="item-box2 mt-3">
            <CampStyle2
              @style-status="styleStatus"
              :campStyle1="this.credentials.campStyle1"
              :campStyle2="this.credentials.campStyle2"
              :campStyle3="this.credentials.campStyle3"
              :campStyle4="this.credentials.campStyle4"
              :campStyle5="this.credentials.campStyle5"
              :campStyle6="this.credentials.campStyle6"
            />
          </div>

          <!-- 보유장비 -->
          <div class="mt-3">
            <Items2
              :campEquipLantern="this.credentials.campEquipLantern"
              :campEquipReel="this.credentials.campEquipReel"
              :campEquipBurner="this.credentials.campEquipBurner"
              :campEquipicebox="this.credentials.campEquipicebox"
              :campEquipTableChair="this.credentials.campEquipTableChair"
              :campEquipSleepingbag="this.credentials.campEquipSleepingbag"
              :campEquipPot="this.credentials.campEquipPot"
              :campEquipTent="this.credentials.campEquipTent"
              :campEquipBrazier="this.credentials.campEquipBrazier"
              :campEquipTarp="this.credentials.campEquipTarp"
              @img-status="imgStatus"
            />
          </div>

          <div class="d-flex justify-content-between mt-5">
            <button class="check-button" type="button" @click.prevent="prev()">
              Previous
            </button>
            <button
              class="check-button"
              type="button"
              @click.prevent="onSubmit()"
            >
              Save
            </button>
          </div>

          <div class="row">
            <button
              class="delete-button mt-3"
              @click="deleteAccount"
              type="button"
            >
              회원탈퇴
            </button>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import Items2 from "@/components/user/Items2.vue";
import CampStyle2 from "@/components/user/campstyle2.vue";
import Fileupload from "@/components/user/Fileupload.vue";
import Swal from "sweetalert2";

const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {
  name: "ModifyUser",
  components: {
    Items2,
    CampStyle2,
    Fileupload,
  },

  data() {
    return {
      step: 1,
      myId: this.$store.state.myNum, // 로그인한 유저넘버
      myEmail: this.$store.state.userEmail, // 로그인한 유저이메일
      credentials: {
        userEmail: "", // 이메일
        userNickname: "", // 닉네임
        userPassword: "", // 패스워드
        userName: "",
        password_confirmation: "", // 패스워드확인
        userGender: "", // 성별
        userLocation: "", // 지역
        userAge: "", // 나이
        userMBTI: "",
        campEquipLantern: 0,
        campEquipReel: 0,
        campEquipBurner: 0,
        campEquipicebox: 0,
        campEquipTableChair: 0,
        campEquipSleepingbag: 0,
        campEquipTarp: 0,
        campEquipPot: 0,
        campEquipTent: 0,
        campEquipBrazier: 0,
        campStyle1: 0,
        campStyle2: 0,
        campStyle3: 0,
        campStyle4: 0,
        campStyle5: 0,
        campStyle6: 0,
        userProfileImage: "",
        // 보유장비
        imgStatus: {
          campEquipLantern: 0,
          campEquipReel: 0,
          campEquipBurner: 0,
          campEquipicebox: 0,
          campEquipTableChair: 0,
          campEquipSleepingbag: 0,
          campEquipTarp: 0,
          campEquipPot: 0,
          campEquipTent: 0,
          campEquipBrazier: 0,
        },
        styleStatus: {
          campStyle1: 0,
          campStyle2: 0,
          campStyle3: 0,
          campStyle4: 0,
          campStyle5: 0,
          campStyle6: 0,
        },
      },
      maleButton: false,
      femaleButton: false,
      nicknameValidFlag: false,
      passwordValidFlag: false, // 비밀번호 유효성검사
      passwordCheckFlag: false, // 비밀번호 동일 검사
      validatedcheck: true,
    };
  },

  created: function () {
    console.log(this.myEmail);
    this.getProfile();
  },
  methods: {
    prev() {
      this.step--;
    },
    next() {
      this.step++;
    },
		onSubmit: function() {
			this.credentials.userEmail = this.myEmail
			console.log(1)
			axios({
				method: "put",
				url: `${SERVER_URL}/user`,
				data: this.credentials
			})
				.then((res) => {
					console.log(res)
					Swal.fire({ title: '회원정보 수정에 성공하였습니다.', icon: 'success', timer:2000})
					this.$router.push({name: 'Mainpage'})
				})
				.catch(() => {
					console.log("수정안됨")
					Swal.fire({ title: "서버에 오류가 생겼습니다. 다시 시도해 주세요.", icon: 'warning', timer:2000})
				})
			this.imageSend()
		},
		imageSend: function () {
			axios ({
				method: "put",
				url: `${SERVER_URL}/user/image/${this.credentials.userEmail}`,
				headers: { 'Content-Type': 'multipart/form-data' },
				data: this.userProfileImage
			})
				.catch(() => {
					console.log("이미지가 없습니다.")
			})
		},
		getProfile: function() {
			axios.get(`${SERVER_URL}/user/${this.myEmail}`)
			.then(res => {
				console.log(res)
				this.credentials.userEmail = res.data.userEmail
				this.credentials.userNickname = res.data.userNickname
				this.credentials.userPassword = res.data.userPassword
				this.credentials.userName = res.data.userName
				this.credentials.password_confirmation = res.data.userPassword
				this.credentials.userGender = res.data.userGender
				this.credentials.userLocation = res.data.userLocation
				this.credentials.userAge = res.data.userAge
				this.credentials.userMBTI = res.data.userMBTI
				this.credentials.campEquipLantern = res.data.campEquipLantern
				this.credentials.campEquipReel = res.data.campEquipReel
				this.credentials.campEquipBurner = res.data.campEquipBurner
				this.credentials.campEquipicebox = res.data.campEquipicebox
				this.credentials.campEquipTableChair = res.data.campEquipTableChair
				this.credentials.campEquipSleepingbag = res.data.campEquipSleepingbag
				this.credentials.campEquipTarp = res.data.campEquipTarp
				this.credentials.campEquipPot = res.data.campEquipPot
				this.credentials.campEquipTent = res.data.campEquipTent
				this.credentials.campEquipBrazier = res.data.campEquipBrazier
				this.credentials.campStyle1 = res.data.campStyle1
				this.credentials.campStyle2 = res.data.campStyle2
				this.credentials.campStyle3 = res.data.campStyle3
				this.credentials.campStyle4 = res.data.campStyle4
				this.credentials.campStyle5 = res.data.campStyle5
				this.credentials.campStyle6 = res.data.campStyle6
				this.credentials.userProfileImage = res.data.userProfileImage

				if (this.credentials.userGender == 'W') {
					this.femaleButton = true
				} else if (this.credentials.userGender == 'M') {
					this.maleButton = true
				}

			})
			.catch((err) => {
				console.log(err)
			})
		},
		duplNickname: function () {
			axios ({
				method: "get",
				url: `${SERVER_URL}/user/duplnickname/${this.credentials.userNickname}`,
				data: this.credentials.userNickname,
				contentType: "charset=utf-8"
			})
				.then((res) => {
					if (res.data.result === -1) {
						this.namecheck = false
						Swal.fire({ title: "이미 존재하는 닉네임입니다.", icon: 'warning', timer:2000})
					} else if (res.data.result === 1 && this.nicknameValidFlag === false) {
						Swal.fire({ title: "닉네임 형식에 맞지 않습니다.", icon: 'warning', timer:2000})
					} else if (res.data.result === 1 && this.nicknameValidFlag === true){
						this.namecheck = true
						Swal.fire({ title: "사용 가능한 닉네임 입니다.", icon: 'success', timer:2000})
					}
				})
		},
		deleteAccount: function () {
			Swal.fire({
				title: '정말 삭제하시겠습니까?',
				icon: 'warning',
				showCancelButton: true,
				confirmButtonColor: '#3085d6',
				cancelButtonColor: '#d33',
				confirmButtonText: '삭제',
				cancelButtonText: '취소',
			}).then((result) => {
				if (result.isConfirmed) {
					axios.delete(`${SERVER_URL}/user/${this.myEmail}`)
					.then(() => {
						Swal.fire({
							title: '계정이 안전하게 삭제되었습니다.!',
							icons: 'success'
						})
						this.logout()
						this.$router.push({ name:"Mainpage"})
					})
					.catch(() => {
						Swal.fire({
							title: '잠시 후 다시 시도해주세요.',
							icons: 'warning'
						})
					})
				}
			})

		},
		logout: function () {
      this.$store.state.user = null;
      this.$store.state.userEmail = null;
      this.$store.dispatch("logout");
      sessionStorage.removeItem("userList");
      sessionStorage.removeItem("myNum");
      sessionStorage.removeItem("userEmail");
      sessionStorage.removeItem("userPassword");
    },

    clickFemale: function () {
      this.femaleButton = true;
      this.maleButton = false;
      this.credentials.userGender = "W";
      console.log(this.credentials.userGender);
    },

    clickMale: function () {
      this.maleButton = true;
      this.femaleButton = false;
      this.credentials.userGender = "M";
      console.log(this.credentials.userGender);
    },
    uploadedImage(file) {
      this.userProfileImage = file;
      console.log(this.userProfileImage);
    },

    imgStatus(text) {
      if (text.campEquipLantern === 1) {
        this.credentials.imgStatus.campEquipLantern = 1;
        this.credentials.campEquipLantern = 1;
      } else {
        this.credentials.imgStatus.campEquipLantern = 0;
        this.credentials.campEquipLantern = 0;
      }
      if (text.campEquipReel === 1) {
        this.credentials.imgStatus.campEquipReel = 1;
        this.credentials.campEquipReel = 1;
      } else {
        this.credentials.imgStatus.campEquipReel = 0;
        this.credentials.campEquipReel = 0;
      }
      if (text.campEquipBurner === 1) {
        this.credentials.imgStatus.campEquipBurner = 1;
        this.credentials.campEquipBurner = 1;
      } else {
        this.credentials.imgStatus.campEquipBurner = 0;
        this.credentials.campEquipBurner = 0;
      }
      if (text.campEquipicebox === 1) {
        this.credentials.imgStatus.campEquipicebox = 1;
        this.credentials.campEquipicebox = 1;
      } else {
        this.credentials.imgStatus.campEquipicebox = 0;
        this.credentials.campEquipicebox = 0;
      }
      if (text.campEquipTableChair === 1) {
        this.credentials.imgStatus.campEquipTableChair = 1;
        this.credentials.campEquipTableChair = 1;
      } else {
        this.credentials.imgStatus.campEquipTableChair = 0;
        this.credentials.campEquipTableChair = 0;
      }
      if (text.campEquipSleepingbag === 1) {
        this.credentials.imgStatus.campEquipSleepingbag = 1;
        this.credentials.campEquipSleepingbag = 1;
      } else {
        this.credentials.imgStatus.campEquipSleepingbag = 0;
        this.credentials.campEquipSleepingbag = 0;
      }
      if (text.campEquipTarp === 1) {
        this.credentials.imgStatus.campEquipTarp = 1;
        this.credentials.campEquipTarp = 1;
      } else {
        this.credentials.imgStatus.campEquipTarp = 0;
        this.credentials.campEquipTarp = 0;
      }
      if (text.campEquipPot === 1) {
        this.credentials.imgStatus.campEquipPot = 1;
        this.credentials.campEquipPot = 1;
      } else {
        this.credentials.imgStatus.campEquipPot = 0;
        this.credentials.campEquipPot = 0;
      }
      if (text.campEquipTent === 1) {
        this.credentials.imgStatus.campEquipTent = 1;
        this.credentials.campEquipTent = 1;
      } else {
        this.credentials.imgStatus.campEquipTent = 0;
        this.credentials.campEquipTent = 0;
      }
      if (text.campEquipBrazier === 1) {
        this.credentials.imgStatus.campEquipBrazier = 1;
        this.credentials.campEquipBrazier = 1;
      } else {
        this.credentials.imgStatus.campEquipBrazier = 0;
        this.credentials.campEquipBrazier = 0;
      }
    },
    styleStatus(text) {
      if (text.campStyle1 === 1) {
        this.credentials.styleStatus.campStyle1 = "Y";
        this.credentials.campStyle1 = "Y";
      } else {
        this.credentials.styleStatus.campStyle1 = "N";
        this.credentials.campStyle1 = "N";
      }

      if (text.campStyle2 === 1) {
        this.credentials.styleStatus.campStyle2 = "Y";
        this.credentials.campStyle2 = "Y";
      } else {
        this.credentials.styleStatus.campStyle2 = "N";
        this.credentials.campStyle2 = "N";
      }

      if (text.campStyle3 === 1) {
        this.credentials.styleStatus.campStyle3 = "Y";
        this.credentials.campStyle3 = "Y";
      } else {
        this.credentials.styleStatus.campStyle3 = "N";
        this.credentials.campStyle3 = "N";
      }

      if (text.campStyle4 === 1) {
        this.credentials.styleStatus.campStyle4 = "Y";
        this.credentials.campStyle4 = "Y";
      } else {
        this.credentials.styleStatus.campStyle4 = "N";
        this.credentials.campStyle4 = "N";
      }

      if (text.campStyle5 === 1) {
        this.credentials.styleStatus.campStyle5 = "Y";
        this.credentials.campStyle5 = "Y";
      } else {
        this.credentials.styleStatus.campStyle5 = "N";
        this.credentials.campStyle5 = "N";
      }

      if (text.campStyle6 === 1) {
        this.credentials.styleStatus.campStyle6 = "Y";
        this.credentials.campStyle6 = "Y";
      } else {
        this.credentials.styleStatus.campStyle6 = "N";
        this.credentials.campStyle6 = "N";
      }
    },
    nicknameValid() {
      if (!/[~!@#$%^&*()_+|<>?:{}]/.test(this.credentials.userNickname)) {
        this.nicknameValidFlag = true;
      } else {
        this.nicknameValidFlag = false;
      }
    },
    passwordValid() {
      if (
        /^(?=.*[a-z])(?=.*[0-9]).{8,16}$/.test(this.credentials.userPassword)
      ) {
        this.passwordValidFlag = true;
      } else {
        this.passwordValidFlag = false;
      }
    },
    passwordCheckValid() {
      if (
        this.credentials.userPassword === this.credentials.password_confirmation
      ) {
        this.passwordCheckFlag = true;
      } else {
        this.passwordCheckFlag = false;
      }
    },
  },
};
</script>

<style scoped>
.registration-form {
  padding: 50px 0;
}
.registration-form form {
  background-color: #dee9ff;
  max-width: 600px;
  margin: auto;
  padding: 50px 70px;
  border-radius: 30px;
  /* border-top-left-radius: 30px;
	border-top-right-radius: 30px; */
  box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.075);
}
.registration-form .item {
  border-radius: 20px;
  margin-bottom: 25px;
  padding: 10px 20px;
  margin-right: 20px;
}
.registration-form .check-button {
  border-radius: 30px;
  padding: 10px 20px;
  margin-bottom: 25px;
  font-weight: bold;
  background-color: #5791ff;
  border: none;
  color: white;
}
.modifygenderButtonOn {
  border-radius: 20px;
  padding: 10px 20px;
  margin-bottom: 25px;
  font-weight: bold;
  width: 80%;
  background-color: skyblue;
  color: white;
  transition-duration: 0.5s;
}
.modifygenderButtonOff {
  border-radius: 20px;
  padding: 10px 20px;
  margin-bottom: 25px;
  font-weight: bold;
  width: 80%;
  background-color: white;
  border: none;
  transition-duration: 0.5s;
}

.delete-button {
  border-radius: 30px;
  padding: 10px 20px;
  margin-bottom: 25px;
  font-weight: bold;
  background-color: #fb0102;
  border: none;
  color: white;
}

input[type="password"] {
  font-family: "NanumSquare";
}
</style>
