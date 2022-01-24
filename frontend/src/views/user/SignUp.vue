<template>
	<div class="wrapC">
		<div class="wrap-contact3">
			<h1 class="contact3-form-title">회원가입</h1>
			<!-- input만들기 -->
			<b-col>
				<!-- 이메일 만들기 -->
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
								autofocus>
							</b-form-input>
							<b-button
								@click="check_user_email"
								>인증</b-button>
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
							autofocus>
							</b-form-input>
							<b-button>확인</b-button>
						</b-form-group>
					</b-col>
				</b-row>

				<!-- 닉네임 중복확인 -->
				<b-row>
					<b-col>
						<!-- 최소 2자이상 -->
						<!-- <ValidationProvider
							name="닉네임"
							rules="required|min:2"
						> -->
						<b-form-group>
							<label style="float:left"
							>닉네임</label>
							<b-form-input
							type="text"
							style="width:50%; float: left"
							placeholder="닉네임을 입력하세요"
							autofocus>
							</b-form-input>
							<b-button>중복확인</b-button>
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
							type="text"
							style="width:50%; float: left"
							placeholder='비밀번호를 입력하세요'
							autofocus>
							</b-form-input>
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
							type="text"
							style="width:50%; float: left"
							placeholder="비밀번호를 한번 더 입력하세요"
							autofocus>
							</b-form-input>
						</b-form-group>
					</b-col>
				</b-row>
			</b-col>

				
			<br>
			<br>
			<br>
			<div class="w-32 h-32 border-2 border-dotted border-blue-500">
				<div>
					<form align="left" class="filterbox1" method="post" enctype="multipart/form-data">
						<div>
							<label for="chooseFile">
								Click
							</label>
						</div>
					<input ref="image" @change="uploadImg()" type="file" id="chooseFile" name="chooseFile" accept="image/*">
					</form>
					<img :src="image" alt="" class="">
				</div>
			</div>

			<label>
				<input v-model="isTerm" type="checkbox" id="term" />
				<span>약관을 동의합니다.</span>
			</label>
			<span>약관보기</span>

			<div>
				<b-button class="send-button" @click="onCliclkFormButton" variant="success">가입하기</b-button>
				
				<b-button variant="success"><router-link class="text-decoration-none text-white" to="addSign">추가정보입력</router-link></b-button>
			</div>
		</div>
	</div>
</template>

<script>
import axios from "axios";


const SERVER_URL = process.env.VUE_APP_SERVER_URL
// import { ValidationProvider } from "vee-validate"


export default {
	name: 'Signup',
	data() {
    return {
			credentials: {
				userId: "",
				nickname: "",
				email: "",
				password: "",
			},
			image : '',

			// 체크하는것
			checkId: false,
			checkNickname: false,
			checkEmail : false,
			checkEmailCode: false,
    }
  },
  methods: {
    uploadImg() {
      console.log('들어왔다')
      var image = this.$refs['image'].files[0]

      const url = URL.createObjectURL(image)
      this.image = url
      console.log(url)
      console.log(this.image)
    },
		// 제출했을때
		onSubmit() {
			if ( this.checkId == false || this.checkNickname == false || this.checkEmailCode == false )	{
				alert("중복체크 및 유효성 검사 확인 바랍니다.")
			} else {
				axios.post(`${SERVER_URL}/user`, this.credentials)
				.then(() => {
					alert("회원가입 성공")
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
				// 아직
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
</style>