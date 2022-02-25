<template>
  <Navbar/>
  <div>
    <div v-if="step === 1">
      <div class="registration-form">
        <form>
          <h1>기본 정보</h1>
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
                @blur="emailValid"
              />

              <button class="check-button" @click="duplEmail()" type="button">
                중복확인
              </button>
            </div>
          </div>

						<!-- 닉네임 입력 -->
						<div class="row">
							<label>닉네임</label>
							<div class="form-group">
								<input
									class="form-control item"
									type="text"
									style="width:70%; float: left"
									maxlength='8'
									placeholder="닉네임을 입력하세요"
									v-model="credentials.userNickname"
									autofocus
									@blur="nicknameValid">

              <button
                class="check-button"
                @click="duplNickname()"
                type="button"
              >
                중복확인
              </button>
            </div>
          </div>

						<!-- 이름 입력 -->
						<div class="row">
							<label>이름</label>
							<div class="form-group">
								<input
									class="form-control item"
									type="text"
									style="width:70%; float: left"
									placeholder="이름을 입력하세요."
									v-model="credentials.userName"
									autofocus>
							</div>
						</div>
							
						<!-- 비밀번호 -->
						<div class="row">
							<label>비밀번호</label>
							<div class="form-group">
								<input 
									class="form-control item"
									type="password"
									style="width:70%; float: left"
									placeholder='소문자/숫자 1개이상 8자리이상'
									v-model="credentials.userPassword"
									autofocus
									@blur="passwordValid"
									>
							</div>
							<!-- 소문자/숫자가 1개이상 존재하고 8-16자리 -->
							<small align="left" v-if="!passwordValidFlag && this.credentials.userPassword.length > 0" class="check-form">
								유효하지 않은 비밀번호 입니다.
							</small>
						</div>

          

          <!-- 비밀번호확인 -->
          <div class="row">
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
        </form>
      </div>
    </div>

    <!-- 2페이지 -->
    <div v-if="step === 2">
      <div class="registration-form">
        <form>
          <h1 class="mb-3">추가 정보 입력</h1>
          <!-- 나이 선택 -->
          <div class="form-group row mb-3">
            <h4>나이</h4>
            <!-- <label>나이</label> -->
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

          <!-- 지역선택 -->
          <div class="form-group row mb-3">
            <h4>지역</h4>
            <!-- <label>거주 지역</label> -->
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

          <!-- 성별 선택 -->
          <div class="form-group row mb-3">
            <h4 class="row mx-1">성별</h4>
            <!-- <label class="row">성별</label> -->
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

          <!-- 이미지 삽입 -->
          <div class="form-group row mb-3 row">
            <h4>나의 프로필</h4>
            <Fileupload @image="uploadedImage" />
          </div>

          <!-- 버튼 -->
          <div class="d-flex justify-content-between">
            <button @click.prevent="prev()" class="check-button" type="button">
              Previous
            </button>
            <button @click.prevent="next()" class="check-button" type="button">
              Next
            </button>
          </div>
        </form>
      </div>
    </div>

    <!-- 3페이지 -->
    <div v-if="step === 3">
      <div class="registration-form">
        <form>
          <!-- 스타일 -->
          <div class="item-box2 mt-3">
            <style_Dropdown @style-status="styleStatus" />
          </div>

          <!-- 보유장비 -->
          <div class="mt-3">
            <Items @img-status="imgStatus" />
          </div>

          <div class="d-flex justify-content-between mt-5">
            <button type="button" class="check-button" @click.prevent="prev()">
              Previous
            </button>
            <button
              v-if="submitCheck"
              type="button"
              class="check-button"
              @click.prevent="onSubmit()"
            >
              가입
            </button>
            <button v-else type="button" class="check-button">불가</button>
          </div>
        </form>
        <!-- <div class="item-box mt-3">
							<div align="left">
								<h4>기타 장비</h4>
							</div>
							<EquipInput />
							<EquipList />
						</div> -->
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import Items from "@/components/user/Items.vue";
// import EquipInput from '@/components/user/equip_input.vue'
// import EquipList from '@/components/user/equip_list.vue'
import style_Dropdown from "../../components/user/campstyle.vue";
import Fileupload from "@/components/user/Fileupload.vue";
import Navbar from "@/components/common/Navbar.vue"
import Swal from "sweetalert2";

const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {
  name: "Signup",
  components: {
    Items,
    // EquipInput,
    // EquipList,
    style_Dropdown,
    Fileupload,
    Navbar,
  },
  data() {
    return {
      step: 1,
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
      userProfileImage: "", // 이미지
      maleButton: false,
      femaleButton: false,
      emailValidFlag: false, // 이메일 유효성 검사
      nicknameValidFlag: false, // 닉네임 유효성 검사
      passwordValidFlag: false, // 비밀번호 유효성검사
      passwordCheckFlag: false, // 비밀번호 동일 검사
      submitCheck: false,
      checkValue: false,
      emailcheck: false,
      namecheck: false,

      resultAlert: false,
    };
  },

  methods: {
    prev() {
      this.step--;
      if (
        this.emailValidFlag === true &&
        this.nicknameValidFlag === true &&
        this.passwordValidFlag === true &&
        this.passwordCheckFlag === true &&
        this.emailcheck === true &&
        this.namecheck === true &&
        this.credentials.userName.length > 0
      ) {
        this.submitCheck = true;
      }
    },
    next() {
      this.step++;
      if (
        this.emailValidFlag === true &&
        this.nicknameValidFlag === true &&
        this.passwordValidFlag === true &&
        this.passwordCheckFlag === true &&
        this.emailcheck === true &&
        this.namecheck === true &&
        this.credentials.userName.length > 0
      ) {
        this.submitCheck = true;
      }
    },
    // ischecked() {
    // 	if ()
    // },

    onSubmit() {
      axios({
        method: "post",
        url: `${SERVER_URL}/user`,
        data: this.credentials,
      })
        .then((res) => {
          console.log(res);
          Swal.fire({
            title: "회원가입에 성공하였습니다!",
            icon: "success",
            timer: 2000,
          });
          this.$router.push({ name: "Login" });
        })
        .catch(() => {
          console.log(this.credentials);
          Swal.fire({
            title: "서버에 오류가 생겼습니다. 다시 시도해 주세요.",
            icon: "warning",
            timer: 2000,
          });
        });

      this.imageSend();
    },
    imageSend: function () {
      axios({
        method: "put",
        url: `${SERVER_URL}/user/image/${this.credentials.userEmail}`,
        headers: { "Content-Type": "multipart/form-data" },
        data: this.userProfileImage,
      }).catch(() => {
        console.log("이미지가 없습니다.");
      });
    },

    // 이메일 유효성 체크
    emailValid() {
      if (
        /^([0-9a-zA-Z_.-]+)@([0-9a-zA-Z_-]+).(.[0-9a-zA-Z_-]+){1,2}$/.test(
          this.credentials.userEmail
        )
      ) {
        this.emailValidFlag = true;
        console.log(this.emailValidFlag);
      } else {
        this.emailValidFlag = false;
        console.log(this.emailValidFlag);
      }
    },

    // 닉네임 유효성 체크
    nicknameValid() {
      if (!/[~!@#$%^&*()_+|<>?:{}]/.test(this.credentials.userNickname)) {
        this.nicknameValidFlag = true;
      } else {
        this.nicknameValidFlag = false;
      }
    },

    // 비밀번호 유효성 체크
    passwordValid() {
      if (
        /^(?=.*[a-z])(?=.*[0-9]).{8,16}$/.test(this.credentials.userPassword)
      ) {
        this.passwordValidFlag = true;
      } else {
        this.passwordValidFlag = false;
      }
    },

    // 비밀번호 확인 유효성 체크
    passwordCheckValid() {
      if (
        this.credentials.userPassword === this.credentials.password_confirmation
      ) {
        this.passwordCheckFlag = true;
      } else {
        this.passwordCheckFlag = false;
      }
    },

    checkGender() {
      if (!this.credentials.userGender) {
        this.error.userGender = "성별을 선택해주세요";
        this.buttonShow = false;
      } else {
        this.error.userGender = false;
      }
    },
    duplEmail: function () {
      axios
        // console.log(this.credentials.userNickname)
        .get(`${SERVER_URL}/user/duplemail/${this.credentials.userEmail}`, {
          userEmail: this.credentials.userEmail,
        })
        .then((res) => {
          console.log("한번보자", res.data.result);
          if (res.data.result === -1) {
            this.emailcheck = false;
            Swal.fire({
              title: "이미 존재하는 이메일입니다.",
              icon: "warning",
              timer: 2000,
            });
          } else if (res.data.result === 1 && this.emailValidFlag === false) {
            Swal.fire({
              title: "이메일 형식에 맞지 않습니다.",
              icon: "warning",
              timer: 2000,
            });
          } else if (res.data.result === 1 && this.emailValidFlag === true) {
            this.emailcheck = true;
            Swal.fire({
              title: "사용가능한 이메일 입니다.",
              icon: "success",
              timer: 2000,
            });
          }
        })
        .catch((err) => {
          console.log(err);
        });
    },
    duplNickname: function () {
      axios({
        method: "get",
        url: `${SERVER_URL}/user/duplnickname/${this.credentials.userNickname}`,
        data: this.credentials.userNickname,
        contentType: "charset=utf-8",
      }).then((res) => {
        if (res.data.result === -1) {
          this.namecheck = false;
          Swal.fire({
            title: "이미 존재하는 닉네임입니다.",
            icon: "warning",
            timer: 2000,
          });
        } else if (res.data.result === 1 && this.nicknameValidFlag === false) {
          Swal.fire({
            title: "닉네임 형식에 맞지 않습니다.",
            icon: "warning",
            timer: 2000,
          });
        } else if (res.data.result === 1 && this.nicknameValidFlag === true) {
          this.namecheck = true;
          Swal.fire({
            title: "사용 가능한 닉네임 입니다.",
            icon: "success",
            timer: 2000,
          });
        }
      });
    },

    age_select() {
      console.log(this.credentials.userAge);
    },

    area_select() {
      console.log(this.credentials.userLocation);
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
    // uploadImg() {
    //   console.log("들어왔다");
    //   var image = this.$refs["image"].files[0];

    //   const url = URL.createObjectURL(image);
    //   this.credentials.userProfileImage = url;
    //   console.log(url);
    //   console.log(this.credentials.userProfileImage);
    // },
    uploadedImage(file) {
      this.userProfileImage = file;
      console.log(this.userProfileImage);
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

.filterbox1 {
  float: left;
  margin-left: 50px;
  margin-right: 20px;
}
.filterbox2 {
  float: left;
}

.input3 {
  width: 80%;
  font-family: Poppins-Regular;
  font-size: 15px;
  color: #fff;
  line-height: 1.5;
  padding: 0 5px;
}

.form-group {
  position: relative;
  overflow: hidden;
}

.check-form {
  color: red;
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
.swal-button {
  background-color: #ffb2d9;
  font-size: 12px;
  text-shadow: 0px -1px 0px rgba(0, 0, 0, 0.3);
}
input[type="password"] {
  font-family: "NanumSquare";
}
input[type="text"] {
  font-family: "NanumSquare";
}
input[type="email"] {
  font-family: "NanumSquare";
}
</style>
