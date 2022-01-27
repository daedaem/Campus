<template>
	<div class="wrapC">
		<div class="wrap-contact3">
			<h1 class="contact3-form-title">회원가입</h1>
			<!-- input만들기 -->
			<b-col>			
				<b-row>
					<b-col>
						<b-form-group>
							<label style="float:left"
							>이메일</label>
							<b-form-input
								type="email"
								style="width:50%; float: left"
								placeholder="이메일을 입력하세요"
								v-model="credentials.email"
								required
								@keypress.enter="check_user_email"
								autofocus
								@blur="emailValid">
							</b-form-input>
							
							<b-button
								@click="check_user_email"
								>인증</b-button>
							<div v-if="!emailValidFlag">
								유효하지 않은 이메일 입니다.
							</div>
						</b-form-group>
					</b-col>
				</b-row>

				<!-- 이메일 인증번호 확인 -->
				<b-row>
					<b-col>
						<b-form-group>
							<label style="float:left"
							>인증번호</label>
							<b-form-input
							type="text"
							style="width:50%; float: left"
							placeholder="인증번호를 입력하세요"
							v-model="emailCode"
							autofocus
							@keypress.enter="check_user_emailCode">
							</b-form-input>
							<b-button
							@click="check_user_emailCode"
							>확인</b-button>
						</b-form-group>
					</b-col>
				</b-row>

				<!-- 닉네임 중복확인 -->
				<b-row>
					<b-col>
						<b-form-group>
							<label style="float:left"
							>닉네임</label>
							<b-form-input
							type="text"
							style="width:50%; float: left"
							placeholder="닉네임을 입력하세요"
							v-model="credentials.nickname"
							autofocus>
							</b-form-input>
							<b-button
								@click="check_user_nickname"
							>중복확인</b-button>
						</b-form-group>
					</b-col>
				</b-row>

				<!-- 비밀번호 -->
				<b-row>
					<b-col>
						<b-form-group>
							<label style="float:left"
							>비밀번호</label>
							<b-form-input
							type="password"
							style="width:50%; float: left"
							placeholder='비밀번호를 입력하세요'
							v-model="credentials.password"
							@keypress.enter="onSubmit()"
							autofocus
							@blur="passwordValid"
							>
							</b-form-input>
							<!-- 대문자/소문자/숫자가 1개이상 존재하고 8-16자리 -->
							<div v-if="!passwordValidFlag">
								유효하지 않은 비밀번호 입니다.
							</div>
						</b-form-group>
					</b-col>
				</b-row>

				<!-- 비밀번호 확인 -->
				<b-row>
					<b-col>
						<b-form-group>
							<label style="float:left"
							>비밀번호 확인</label>
							<b-form-input
							type="password"
							style="width:50%; float: left"
							placeholder="비밀번호를 한번 더 입력하세요"
							v-model="credentials.password_confirmation"
							@keypress.enter="onSubmit()"
							autofocus
							@blur="passwordCheckValid"
							>
							</b-form-input>
							<div v-if="!passwordCheckFlag">
								비밀번호가 다릅니다.
							</div>
						</b-form-group>
					</b-col>
				</b-row>
			</b-col>


			

			<label>
				<input type="checkbox" id="term" />
				<span>약관을 동의합니다.</span>
			</label>
			<span>약관보기</span>

			<div>
				<b-button class="send-button" variant="success">가입하기</b-button>
				
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
				userId: "",
				nickname: "",
				email: "",
				password: "",
				password_confirmation: "",
				image: "",
				user_gender: "",
				user_area: "",
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
			emailValidFlag: true,
			passwordValidFlag: true,
			passwordCheckFlag: true,

			
			emailCode: "",
			possible_email: false,

      // 체크하는것
      checkId: false,
      checkNickname: false,
      checkEmail: false,
      checkEmailCode: false,
    };
  },
  methods: {
		emailValid() {
			if (/^([0-9a-zA-Z_.-]+)@([0-9a-zA-Z_-]+).(.[0-9a-zA-Z_-]+){1,2}$/.test(this.credentials.email)) {
				this.emailValidFlag = true
			} else {
				this.emailValidFlag = false
			}
		},

		passwordValid() {
			if (/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,16}$/.test(this.credentials.password)) { 
				this.passwordValidFlag = true 
			} else { 
				this.passwordValidFlag = false
			}
		},
		passwordCheckValid() {
			if (this.credentials.password === this.credentials.password_confirmation) {
				this.passwordCheckFlag = true
			} else {
				this.passwordCheckFlag = false
			}
		},
		


		// 제출했을때
		onSubmit() {
			// 아이디 체크, 닉네임 체크, 이메일코드 체크
			if ( this.checkId == false || this.checkNickname == false || this.checkEmail == false ||this.checkEmailCode == false || this.passwordValidFlag == true || this.passwordCheckFlag == true)	{
				alert("중복체크 및 유효성 검사 확인 바랍니다.")
			} else {
				axios({
					method: "POST",
					url: `${SERVER_URL}/user/signup`,
					data: this.credentials,
				})
					.then(() => {
						alert("회원가입 성공")
						this.$router.push({name: 'Home'})
					})
					.catch(() => {
						alert("서버에 오류가 생겼습니다. 다시 시도해주세요")
					})
			}
		},
		check_user_email: function() {
			if (this.checkId == false || this.checkNickname == false || this.credentials.email == "") {
				alert("닉네임, 아이디 중복체크 확인 및 이메일을 입력 바랍니다.")
				this.credentials.email = "";
			} else {
				axios
					.post(`${SERVER_URL}/user/email`, this.credentials)
					.then(() => {
						alert("사용 가능한 이메일 입니다. 인증코드를 입력 바랍니다.");
						this.checkEmail = true;
						this.possible_email = true;
					})
					.catch(() => {
						if (this.credentials.email != "") {
							alert("현재 사용중인 이메일 입니다.");
							this.credentials.email = ""
						}
					})
			}
		},

		check_user_emailCode: function () {
			if (this.emailCode == "") {
				alert("인증코드 다시 입력바랍니다.")
			} else {
					axios
						.post(`${SERVER_URL}/user/email/${this.credentials.email}/${this.emailCode}`)
						.then(() => {
							this.checkEmailCode = true;
							alert("인증 완료")
						})
						.catch(() => {
							if (this.emailCode != "") {
								alert("인증번호가 일치하지 않습니다.");
								this.emailCode = "";
							}
						})
			}
		},

		check_user_nickname: function () {
			if (this.credentials.nickname == "" ) {
				alert("닉네임을 다시 입력 바랍니다.")
				this.credentials.nickname = "";
			}
			else {
				axios
					.get(`${SERVER_URL}/user/nickname/${this.credentials.nickname}`)
					.then(() => {
						alert("사용 가능한 닉네임입니다.")
						this.checkNickname = true;
					})
					.catch(() => {
						if (this.credentials.nickname != "") {
							alert("현재 사용중인 닉네임 입니다.");
							this.credentials.nickname = "";
						}
					})
			}
		}
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
  padding-bottom: 70px;
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

</style>
