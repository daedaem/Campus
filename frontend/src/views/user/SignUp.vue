<template>
	<div class="wrapC">
		<div class="wrap-contact3">
			<h1 class="contact3-form-title">회원가입</h1>
			<!-- input만들기 -->
			
			<div class="email-container">
				<h6 align="left">
					이메일
				</h6>
				<div class="form-group">
					<b-form-input
						type="email"
						style="width:50%; float: left"
						placeholder="이메일을 입력하세요"
						v-model="credentials.email"
						required
						autofocus
						@blur="emailValid">
					</b-form-input>

					<b-button
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
						v-model="credentials.nickname"
						autofocus
						@blur="nicknameValid">
					</b-form-input>
					<b-button
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
						v-model="credentials.password"
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
				<input type="checkbox" id="term" />
				<span>약관을 동의합니다.</span>
				<span>약관보기</span>
			</div>

			<!-- 가입 버튼 -->
			<div class="d-flex justify-content-between mx-3 mt-3">
				<b-button 
					class="send-button" 
					variant="success"
					@click="onSubmit()">
					가입하기
				</b-button>
				<b-button variant="success"><router-link class="text-decoration-none text-white" to="addSign">추가정보입력</router-link></b-button>
			</div>

		
		</div>
	</div>
</template>

<script>
import axios from "axios";

const SERVER_URL = process.env.VUE_APP_SERVER_URL

export default {
  name: "Signup",
  data() {
		return {
			credentials: {
				email: "", // 이메일
				nickname: "", // 닉네임
				password: "", // 패스워드
				password_confirmation: "", // 패스워드확인 
				image: "", // 이미지
				user_gender: "", // 성별
				user_area: "", // 지역
				// 보유장비
				imgStatus : {
					lantern : 0,
					powerstrip : 0,
					burner : 0,
					icebox : 0,
					chair : 0,
					sleepingbag : 0,
					tarp : 0,
					table : 0,
					tent : 0,
					brazier : 0,
				}
			},
			emailValidFlag: "", // 이메일 유효성 검사
			nicknameValidFlag: "", // 닉네임 유효성 검사
			passwordValidFlag: "", // 비밀번호 유효성검사
			passwordCheckFlag: "", // 비밀번호 동일 검사
		}
	},

	methods: {
		onSubmit() {
			axios ({
				method: "post",
				url: `${SERVER_URL}/user/signup`,
				data: this.credentials,
			})
				.then((res) => {
					console.log(res)
					alert("회원가입 성공")
					this.$router.push({name: 'Login'})
				})
				.catch(() => {
					console.log(this.credentials)
					alert("서버에 오류가 생겼습니다. 다시 시도해주세요")
				})
			// console.log(this.credentials)
			// 유효성 통과못할 시
			// if (this.emailValidFlag === true || this.nicknameValidFlag === true || this.passwordValidFlag === true || this.passwordCheckFlag === true) {
			// 	console.log(this.emailValidFlag)
			// 	console.log(this.nicknameValidFlag)
			// 	console.log(this.passwordValidFlag)
			// 	console.log(this.passwordCheckFlag)
			// 	alert("유효성 검사 확인 부탁드립니다.")
			// 유효성 통과 할시
			// } else {
			// 	axios ({
			// 	method: "post",
			// 	url: `${SERVER_URL}/user/signup`,
			// 	data: this.credentials,
			// })
			// 	.then((res) => {
			// 		console.log(res)
			// 		alert("회원가입 성공")
			// 		this.$router.push({name: 'Login'})
			// 	})
			// 	.catch(() => {
			// 		console.log(this.credentials)
			// 		alert("서버에 오류가 생겼습니다. 다시 시도해주세요")
			// 	})
			// }
		},

		// 이메일 유효성 체크
		emailValid() {
			if (/^([0-9a-zA-Z_.-]+)@([0-9a-zA-Z_-]+).(.[0-9a-zA-Z_-]+){1,2}$/.test(this.credentials.email)) {
				this.emailValidFlag = true
				console.log(this.emailValidFlag)
			} else {
				this.emailValidFlag = false
				console.log(this.emailValidFlag)
			}
		},

		// 닉네임 유효성 체크
		nicknameValid() {
			if (!/[~!@#$%^&*()_+|<>?:{}]/.test(this.credentials.nickname)) {
				this.nicknameValidFlag = true
			} else {
				this.nicknameValidFlag = false
			}
		},

		// 비밀번호 유효성 체크
		passwordValid() {
			if (/^(?=.*[a-z])(?=.*[0-9]).{8,16}$/.test(this.credentials.password)) { 
				this.passwordValidFlag = true 
			} else { 
				this.passwordValidFlag = false
			}
		},

		// 비밀번호 확인 유효성 체크
		passwordCheckValid() {
			if (this.credentials.password === this.credentials.password_confirmation) {
				this.passwordCheckFlag = true
			} else {
				this.passwordCheckFlag = false
			}
		},
	}
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

</style>
