<template>
  <div class="wrapC">
    <div class="wrap-contact3">
      <form class="contact3-form validate-form">
        <h1 class="contact3-form-title">Camp-Us</h1>
        <!-- 로그인 -->
        <div class="login-header">
          <!-- 이메일 -->
          <div class="email-container">
            <div align="left">이메일</div>
            <div class="wrap-input3">
              <input
                class="input3"
                type="text"
                placeholder="example@google.com"
                v-model="credentials.userEmail"
                id="email"
              />
            </div>
          </div>
          <!-- 패스워드 -->
          <div class="password-container">
            <div align="left">패스워드</div>
            <div class="wrap-input3">
              <input
                class="input3"
                type="password"
                placeholder="Password"
                v-model="credentials.userPassword"
                id="password"
              />
            </div>
          </div>

          <!-- 로그인버튼 -->
          <div class="container-contact3-form-btn">
            <button class="login-button" @click="login" type="button">
              로그인
            </button>
          </div>

          <!-- 구글 로그인 -->
          <!-- <div class="d-flex justify-content-between mx-3 mt-3">
            <div class="g-signin2" data-onsuccess="onSignIn"></div>
            <button @click="signout" align="left" class="btn-primary">
              로그아웃
            </button>
          </div> -->

          <!-- 카카오 -->
          <!-- <div class="d-flex justify-content-between mx-3 mt-3">
            <img class="kakao_btn" src="@/assets/login/kakao_login_medium_wide.png" 
              @click="kakaoLogin"
              alt="">
          </div> -->
          <!-- <button @click="logout">
            로그아웃
          </button> -->


          <!-- 회원가입 및 비밀번호 찾기 -->
          <div class="d-flex justify-content-between mx-3 mt-3">
            <button type="button" class="btn-primary" @click="moveToSignUp">회원가입</button>
            <button class="btn-primary" @click="movetofindPw">비밀번호</button>
          </div>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import axios from "axios";
// import { mapActions } from "vuex";
const SERVER_URL = `http://i6e102.p.ssafy.io`

export default {
  name: "Login",
  data: () => {
    return {
      credentials: {
        userEmail: "",
        userPassword: "",
      },
      error_check_login: true,
      googleUser: null,
      value: "",
      rules: {
        required: (value) => !!value || "Required.",
        lengthValid: (value) =>
          (value && value.length >= 5) || "MIN 5 characters",
      },
    };
    
  },

  // 구글
  // mounted() {
  //   window.addEventListener(
  //     "google-oauth-library-load",
  //     this.renderSignInButton
  //   );
  // },

  methods: {
    // ...mapActions(["login"]),
    login: function () {
      axios({
        method: "POST",
        url: `${SERVER_URL}/login`,
        data: this.credentials,
      })
        .then((res) => {
          alert("로그인")
          this.$store.state.user = this.credentials.userEmail
          this.$store.state.myNum = res.data.userNo
          this.$store.state.userList = res.data
          // console.log(this.$store.state.userList)
          // console.log(this.$store.state.user)
          // console.log(this.$store.state.myNum)
          localStorage.setItem('jwt', res.data.token)
          this.$store.dispatch("login"); 
        
          this.$router.push({name: 'Mainpage'})
        })
        .catch((err) => {
          alert("이메일과 비밀번호를 확인해주세요")
          console.log(err)
        })
    },
    // logout: function() {
    //   localStorage.removeItem('jwt');
    //   this.$store.dispatch("logout")
    //   alert("로그아웃")
    //   this.$router.push({name: 'login'})
    // },

    // 회원가입 이동
    moveToSignUp: function () {
      this.$router.push({ name: "Signup" });
    },

    // 비밀번호 찾기
    movetofindPw: function () {
      this.$router.push({ name: "findPw" });
    },

    // 구글
    // renderSignInButton() {
    //   window.gapi.signin2.render("my-signin2", {
    //     scope: "profile email",
    //     width: 240,
    //     height: 50,
    //     longtitle: true,
    //     theme: "dark",
    //     onsuccess: this.onSuccess,
    //     onfailure: this.onFailure,
    //   });
    // },
    // kakaoLogin() {
    //     // console.log(window.Kakao);
    //     window.Kakao.Auth.login({
    //         scope : 'account_email, gender',
    //         success: this.GetMe,
    //     });
    // },
    // GetMe(authObj){
    //     console.log(authObj);
    //     window.Kakao.API.request({
    //         url:'/v2/user/me',
    //         success : res => {
    //             const kakao_account = res.kakao_account;
    //             const userInfo = {
    //                 nickname : kakao_account.profile.nickname,
    //                 email : kakao_account.email,
    //                 password : '',
    //                 account_type : 2,
    //             }

    //               axios.post(`http://localhost:8080/account/kakao`,{
    //                   email : userInfo.email,
    //                   nickname : userInfo.nickname
    //               })
    //               .then(res => {
    //                 console.log(res);
    //                 console.log("데이터베이스에 회원 정보가 있음!");
    //               })
    //               .catch(err => {
    //                   console.log(err);
    //                 console.log("데이터베이스에 회원 정보가 없음!");
    //               })
    //             console.log(userInfo);
    //             alert("로그인 성공!");
    //             this.$bvModal.hide("bv-modal-example");
    //         },
    //         fail : error => {
    //             this.$router.push("/errorPage");
    //             console.log(error);
    //         }
    //     })
    // },

    onSuccess(googleUser) {
      console.log(googleUser);
      this.googleUser = googleUser.getBasicProfile();
      this.$router.push({ name: "Home" });
    },
    onFailure(error) {
      console.log(error);
    },

    // 구글 로그아웃
    signout() {
      const authInst = window.gapi.auth2.getAuthInstance();
      authInst.signOut().then(() => {
        console.log("User Signed Out!!!");
      });
    },
  },
};
</script>

<style scoped>
.test {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 1vh;
}

.google {
  width: 200px;
  height: 40px;
  background-color: #ffffff;
  border: 1px #a8a8a8 solid;
  color: black;
  display: flex;
  align-items: center;
  justify-content: center;
  cursor: pointer;
}

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
.login-container {
  display: flex;
  flex-direction: column;
  justify-content: center;
  margin-top: 5vh;
  padding: 0 15vw;
  /* align-items: center; */
}

.contact3-form {
  width: 100%;
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

.login-button {
  width: 100%;
  margin-top: 2vh;
  background-color: white;
  color: green;
  border: 0.3vw solid;
  border-color: green;
  font-weight: bold;
  font-size: 1vw;
  padding: 0.5vw;
  border-radius: 1vw;
  transition-duration: 0.5s;
}
input {
  outline: none;
  border: none;
}

.wrap-input3 {
  width: 100%;
  position: relative;
  border-bottom: 2px solid rgba(255, 255, 255, 0.24);
  border-top: 2px solid #f3a90800;
  margin-bottom: 27px;
}

.input3 {
  display: block;
  width: 100%;
  background: transparent;
  font-family: Poppins-Regular;
  font-size: 15px;
  color: #fff;
  line-height: 1.2;
  padding: 0 5px;
}

.focus-input3 {
  position: absolute;
  display: block;
  width: 100%;
  height: 100%;
  top: 0;
  left: 0;
  pointer-events: none;
}

.validate-input {
  position: relative;
}

.container-contact3-form-btn {
  padding-top: 23px;
}
</style>
