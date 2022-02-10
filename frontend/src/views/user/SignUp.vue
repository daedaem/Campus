<template>
	<Navbar></Navbar>
	<div>
		<form>
			<div v-if="step === 1">
				
				<div class="wrapC">
					<div class="wrap-contact3">
						<h1 class="contact3-form-title">기본 정보</h1>

						<div class="email-container">
							<h6 align="left">
								이메일
							</h6>
						
							<div class="form-group">
								<b-form-input
									type="email"
									style="width:50%; float: left"
									placeholder="이메일을 입력하세요"
									v-model="credentials.userEmail"
									autofocus
									@blur="emailValid">
								</b-form-input>

								<b-button
									@click="checkNickname()"
									>인증</b-button>
							</div>
							<div align="left" v-if="!emailValidFlag" class="check-form">
								유효하지 않은 이메일 입니다.
							</div>
						</div>

						<!-- 인증번호 입력 -->
						<div class="emailcode-container mt-2">
							<h6 align="left">
								인증번호
							</h6>
							<div class="form-group">
								<b-form-input
									type="text"
									style="width:50%; float: left"
									placeholder="인증번호를 입력하세요"
									autofocus>
								</b-form-input>
								<b-button
								>확인</b-button>
							</div>
							<div align="left">
							</div>
						</div>

						<!-- 닉네임 입력 -->
						<div class="nickname-container mt-2">
							<h6 align="left">
								닉네임
							</h6>
							<div class="form-group">
								<b-form-input
									type="text"
									style="width:50%; float: left"
									placeholder="닉네임을 입력하세요"
									v-model="credentials.userNickname"
									autofocus
									@blur="nicknameValid">
								</b-form-input>
								<b-button
								@click="checkNickname()"
								>중복확인</b-button>
							</div>
							<div align="left" v-if="!nicknameValidFlag" class="check-form">
								특수문자를 사용할 수 없습니다.
							</div>
						</div>

						<!-- 비밀번호 -->
						<div class="password-container mt-2">
							<h6 align="left">
								비밀번호
							</h6>
							<div class="form-group">
								<b-form-input
									type="password"
									style="width:50%; float: left"
									placeholder='비밀번호를 입력하세요'
									v-model="credentials.userPassword"
									autofocus
									@blur="passwordValid"
									>
								</b-form-input>
							</div>
							<!-- 소문자/숫자가 1개이상 존재하고 8-16자리 -->
							<div align="left" v-if="!passwordValidFlag" class="check-form">
								유효하지 않은 비밀번호 입니다.
							</div>
						</div>


						<!-- 비밀번호 확인 -->
						<div class="passwordconfirm-container mt-3">
							<h6 align="left">
								비밀번호확인
							</h6>
							<div class="form-group">
								<b-form-input
									type="password"
									style="width:50%; float: left"
									placeholder="비밀번호를 한번 더 입력하세요"
									v-model="credentials.password_confirmation"
									autofocus
									@blur="passwordCheckValid"
									>
								</b-form-input>
							</div>
							<!-- 비밀번호 확인 -->
							<div align="left" v-if="!passwordCheckFlag" class="check-form">
								비밀번호가 다릅니다.
							</div>
						</div>

						<!--  약관동의 -->
						<div class="form-group mt-3" align="left">
							<input type="checkbox" id="term" v-model="checkValue" :value="ischecked()" />
							<span>약관을 동의합니다.</span>
							<!-- <span>약관보기</span> -->
						</div>


						<!-- 다음 버튼 -->
						<button
							class="mt-5" 
							@click.prevent="next()">Next</button>

					</div>
				</div>		
			</div>

			<!-- 2페이지 -->
			<div v-if="step === 2">
				
				<div class="wrapC">
					<div class="wrap-contact3">
						<h1 class="contact3-form-title">추가 정보</h1>

						<div class="item-box">
							<div class="d-flex">
								<!-- 나이 입력 -->
								<div align="left" class="p-3">
									<h4>나이</h4>
									<select @change="age_select" v-model="credentials.userAge" class="form-select">
										<option disabled value="">나이 선택</option>
										<option value="10">10대</option>
										<option value="20">20대</option>
										<option value="30">30대</option>
										<option value="40">40대</option>
										<option value="50">50대</option>
										<option value="60">60대</option>
										<option value="70">70대</option>
										<option value="80">80대</option>
										<option value="90">90대</option>
									</select>
								</div>

								<!-- 지역 입력 -->
								<div align="left" class="p-3">
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
							</div>

							<!-- 성별 입력 -->
							<div>
								<div align="left"><h4>성별</h4></div>
								<div align="left">
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

						<!-- 이미지 -->
						<Fileupload @image="uploadedImage"/>
					
					<div class="d-flex justify-content-between mt-5">
						<button @click.prevent="prev()">Previous</button>
						<button @click.prevent="next()">Next</button>
					</div>


					</div>
				</div>
				
			</div>

			<div v-if="step === 3">
				<div class="wrapC">
					<div class="wrap-contact3">
						<h1 class="contact3-form-title">Camp Style</h1>
						
						<div class="item-box2 mt-3">
							<style_Dropdown @style-status="styleStatus" />	
						</div>
						<div class="mt-3">
							<Items @img-status="imgStatus"/>
						</div>
						<div class="item-box mt-3">
							<div align="left">
								<h4>기타 장비</h4>
							</div>
							<EquipInput />
							<EquipList />
						</div>

						<div class="d-flex justify-content-between mt-5">
							<button @click.prevent="prev()">Previous</button>
							<button v-if="submitCheck" @click.prevent="onSubmit()">가입</button>
							<button v-else type="button">불가</button>
						</div>


					</div>
				</div>
			
	
			</div>
		</form>

	</div>
</template>

<script>
import axios from "axios";
import Items from '@/components/user/Items.vue'
import EquipInput from '@/components/user/equip_input.vue'
import EquipList from '@/components/user/equip_list.vue'
import style_Dropdown from '../../components/user/campstyle.vue'
import Fileupload from '@/components/user/Fileupload.vue'
import Navbar from "@/components/common/Navbar.vue";

// const SERVER_URL = `http://i6e102.p.ssafy.io`
const SERVER_URL = "http://localhost:8080";

export default {
	name: "Signup",
	components: {
		Items,
		EquipInput,
		EquipList,
		style_Dropdown,
		Fileupload,
		Navbar,
	},
	data() {
    return {
      step:1,
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
				campEquipLantern : 0,
				campEquipReel : 0,
				campEquipBurner : 0,
				campEquipicebox : 0,
				campEquipTableChair : 0,
				campEquipSleepingbag : 0,
				campEquipTarp : 0,
				table : 0,
				campEquipTent : 0,
				campEquipBrazier : 0,
				campStyle1 : 0,
				campStyle2 : 0,
				campStyle3: 0,
				campStyle4 : 0,
				campStyle5 : 0,
				campStyle6 : 0,
				// 보유장비
				imgStatus : {
					campEquipLantern : 0,
					campEquipReel : 0,
					campEquipBurner : 0,
					campEquipicebox : 0,
					campEquipTableChair : 0,
					campEquipSleepingbag : 0,
					campEquipTarp : 0,
					table : 0,
					campEquipTent : 0,
					campEquipBrazier : 0,
				},
				styleStatus : {
					campStyle1 : 0,
					campStyle2 : 0,
					campStyle3: 0,
					campStyle4 : 0,
					campStyle5 : 0,
					campStyle6 : 0,
				}
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
    }
  },

  methods:{
    prev() {
      this.step--;
			if (this.emailValidFlag === true && this.nicknameValidFlag === true && this.passwordValidFlag === true && this.passwordCheckFlag === true) {
				this.submitCheck = true
			}
    },
    next() {
      this.step++;
			if (this.emailValidFlag === true && this.nicknameValidFlag === true && this.passwordValidFlag === true && this.passwordCheckFlag === true) {
				this.submitCheck = true
			}
    },
		ischecked() {

		},

		onSubmit() {
			axios ({
				method: "post",
				url: `${SERVER_URL}/user`,
				data: this.credentials,
			})
				.then((res) => {
					console.log(res)
					alert("회원가입 성공")
					this.$router.push({name: 'Mainpage'})
				})
				.catch(() => {
					console.log(this.credentials)
					alert("서버에 오류가 생겼습니다. 다시 시도해주세요")
				})
			
			this.imageSend()
		},
		imageSend: function() {
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

		// 이메일 유효성 체크
		emailValid() {
			if (/^([0-9a-zA-Z_.-]+)@([0-9a-zA-Z_-]+).(.[0-9a-zA-Z_-]+){1,2}$/.test(this.credentials.userEmail)) {
				this.emailValidFlag = true
				console.log(this.emailValidFlag)
			} else {
				this.emailValidFlag = false
				console.log(this.emailValidFlag)
			}
		},

		// 닉네임 유효성 체크
		nicknameValid() {
			if (!/[~!@#$%^&*()_+|<>?:{}]/.test(this.credentials.userNickname)) {
				this.nicknameValidFlag = true
			} else {
				this.nicknameValidFlag = false
			}
		},

		// 비밀번호 유효성 체크
		passwordValid() {
			if (/^(?=.*[a-z])(?=.*[0-9]).{8,16}$/.test(this.credentials.userPassword)) { 
				this.passwordValidFlag = true 
			} else { 
				this.passwordValidFlag = false
			}
		},

		// 비밀번호 확인 유효성 체크
		passwordCheckValid() {
			if (this.credentials.userPassword === this.credentials.password_confirmation) {
				this.passwordCheckFlag = true
			} else {
				this.passwordCheckFlag = false
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
		checkNickname: function () {
			axios
				// console.log(this.credentials.userNickname)
				.get(`${SERVER_URL}/user/dupl/${this.credentials.userEmail}`, {
					userEmail: this.credentials.userEmail
				})
				.then(res => {
					console.log("한번보자",res)
				})
				.catch(err => {
					console.log(err)
				})
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
				this.credentials.imgStatus.campEquipLantern = 1
				this.credentials.campEquipLantern = 1
			} else {
				this.credentials.imgStatus.campEquipLantern = 0
				this.credentials.campEquipLantern = 0
			}
			if (text.campEquipReel === 1) {
				this.credentials.imgStatus.campEquipReel = 1
				this.credentials.campEquipReel = 1
			} else {
				this.credentials.imgStatus.campEquipReel = 0
				this.credentials.campEquipReel = 0
			}
			if (text.campEquipBurner === 1) {
				this.credentials.imgStatus.campEquipBurner = 1
				this.credentials.campEquipBurner = 1
			} else {
				this.credentials.imgStatus.campEquipBurner = 0
				this.credentials.campEquipBurner = 0
			}
			if (text.campEquipicebox === 1) {
				this.credentials.imgStatus.campEquipicebox = 1
				this.credentials.campEquipicebox = 1
			} else {
				this.credentials.imgStatus.campEquipicebox = 0
				this.credentials.campEquipicebox = 0
			}
			if (text.campEquipTableChair === 1) {
				this.credentials.imgStatus.campEquipTableChair = 1
				this.credentials.campEquipTableChair = 1
			} else {
				this.credentials.imgStatus.campEquipTableChair = 0
				this.credentials.campEquipTableChair = 0
			}
			if (text.campEquipSleepingbag === 1) {
				this.credentials.imgStatus.campEquipSleepingbag = 1
				this.credentials.campEquipSleepingbag = 1
			} else {
				this.credentials.imgStatus.campEquipSleepingbag = 0
				this.credentials.campEquipSleepingbag = 0
			}
			if (text.campEquipTarp === 1) {
				this.credentials.imgStatus.campEquipTarp = 1
				this.credentials.campEquipTarp = 1
			} else {
				this.credentials.imgStatus.campEquipTarp = 0
				this.credentials.campEquipTarp = 0
			}
			if (text.table === 1) {
				this.credentials.imgStatus.table = 1
				this.credentials.table = 1
			} else {
				this.credentials.imgStatus.table = 0
				this.credentials.table = 0
			}
			if (text.campEquipTent === 1) {
				this.credentials.imgStatus.campEquipTent = 1
				this.credentials.campEquipTent = 1
			} else {
				this.credentials.imgStatus.campEquipTent = 0
				this.credentials.campEquipTent = 0
			}
			if (text.campEquipBrazier === 1) {
				this.credentials.imgStatus.campEquipBrazier = 1
				this.credentials.campEquipBrazier = 1
			} else {
				this.credentials.imgStatus.campEquipBrazier = 0
				this.credentials.campEquipBrazier = 0
			}
    },

		styleStatus(text) {
			if (text.campStyle1 === 1) {
				this.credentials.styleStatus.campStyle1 = "Y"
				this.credentials.campStyle1 = "Y"
			} else {
				this.credentials.styleStatus.campStyle1 = "N"
				this.credentials.campStyle1 = "N"
			}

			if (text.campStyle2 === 1) {
				this.credentials.styleStatus.campStyle2 = "Y"
				this.credentials.campStyle2 = "Y"
			} else {
				this.credentials.styleStatus.campStyle2 = "N"
				this.credentials.campStyle2 = "N"
			}

			if (text.campStyle3 === 1) {
				this.credentials.styleStatus.campStyle3 = "Y"
				this.credentials.campStyle3 = "Y"
			} else {
				this.credentials.styleStatus.campStyle3 = "N"
				this.credentials.campStyle3 = "N"
			}

			if (text.campStyle4 === 1) {
				this.credentials.styleStatus.campStyle4 = "Y"
				this.credentials.campStyle4 = "Y"
			} else {
				this.credentials.styleStatus.campStyle4 = "N"
				this.credentials.campStyle4 = "N"
			}

			if (text.campStyle5 === 1) {
				this.credentials.styleStatus.campStyle5 = "Y"
				this.credentials.campStyle5 = "Y"
			} else {
				this.credentials.styleStatus.campStyle5 = "N"
				this.credentials.campStyle5 = "N"
			}

			if (text.campStyle6 === 1) {
				this.credentials.styleStatus.campStyle6 = "Y"
				this.credentials.campStyle6 = "Y"
			} else {
				this.credentials.styleStatus.campStyle6 = "N"
				this.credentials.campStyle6 = "N"
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
      this.userProfileImage = file
      console.log(this.userProfileImage)
    },
  },
}
</script>

<style>
.wrapC {
  display: flex;
  width: 100%;
  flex-direction: column;
  background-color: white;
  align-items: center;
  justify-content: top;
  padding: 0 4vw;
  min-height: 100vh;
}

.wrap-contact3 {
  width: 500px;
  background: #80c64a;
  background: -webkit-linear-gradient(45deg, #56ab2f, #a8e063);
  background: -o-linear-gradient(45deg, #56ab2f, #a8e063);
  background: -moz-linear-gradient(45deg, #56ab2f, #a8e063);
  background: linear-gradient(45deg, #56ab2f, #a8e063);
  border-radius: 10px;
  overflow: hidden;
  padding: 72px 55px 65px 55px;
}

.contact3-form-title {
  display: block;
  font-family: Poppins-Bold;
  font-size: 39px;
  color: #fff;
  line-height: 1.2;
  text-align: center;
  padding-bottom: 30px;
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
  width: 40%;
  margin: 0 1vw;
  margin-top: 2vh;
  background-color: skyblue;
  color: white;
  border: 0.3vw solid;
  border-color: skyblue;
  font-weight: bold;
  font-size: 2vw;
  padding: 0.5vw;
  border-radius: 1vw;
  transition-duration: 0.5s;
}
.modifygenderButtonOff {
  width: 40%;
  margin: 0 1vw;
  margin-top: 2vh;
  background-color: white;
  color: mediumslateblue;
  border: 0.3vw solid;
  border-color: mediumslateblue;
  font-weight: bold;
  font-size: 2vw;
  padding: 0.5vw;
  border-radius: 1vw;
  transition-duration: 0.5s;
}
</style>