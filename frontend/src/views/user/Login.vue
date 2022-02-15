<template>
  <Navbar></Navbar>
  <div class="registration-form">
      <form style="border-top-left-radius: 30px; border-top-right-radius: 30px; border-bottom-left-radius: 0px;border-bottom-right-radius:0px">
        <div class="form-icon">
          <h1>Camp-Us</h1>
          <span><i class="icon icon-user"></i></span>
        </div>

        <div class="form-group">
          <input 
            type="text"
            class="form-control item" 
            id="username" 
            placeholder="Username"
            v-model="credentials.userEmail">
        </div>

        <div class="form-group">
          <input 
            type="password" 
            class="form-control item" 
            id="password"
            placeholder="Password"
            v-model="credentials.userPassword">
        </div>

        <!-- 회원가입 및 비밀번호 찾기 -->
        <div class="d-flex justify-content-between mx-3">
          <div @click="moveToSignUp">
            회원가입
          </div>
          <div @click="movetofindPw">
            비밀번호
          </div>
        </div>

        <div class="form-group">
          <button 
            type="button" 
            class="btn btn-block login-account"
            @click="login"
            @keyup.enter="login()"
            >Login</button>
        </div>

      </form>

      <div class="social-media">
        <h5>Social Login</h5>
        <div class="social-icons">
            <a href="#"><i class="icon-social-google" title="Google"></i></a>
        </div>
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

          <!-- <div class="col">
            <a class="btn btn-lg btn-secondary" th:href="@{/kakao/oauth}"
              >카카오로 로그인하기</a
            >
          </div>
          <div class="col">
            <a class="btn btn-lg btn-secondary" th:href="@{/kakao/logout}"
              >로그아웃</a
            >
          </div> -->
  </div>
</template>

<script>
import axios from "axios";
// import { mapActions } from "vuex";
import Swal from 'sweetalert2'
import Navbar from "@/components/common/Navbar.vue";

const SERVER_URL = process.env.VUE_APP_SERVER_URL;

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
    };
  },
  components: {
    Navbar,
  },

  // 구글
  // mounted() {
  //   window.addEventListener(
  //     "google-oauth-library-load",
  //     this.renderSignInButton
  //   );
  // },

  methods: {
    // 로그인
    login: function () {
      console.log(this.credentials);
      axios({
        method: "POST",
        url: `${SERVER_URL}/login`,
        data: this.credentials,
      })
        .then((res) => {
          Swal.fire({title:'로그인에 성공하였습니다.', timer:2000})
          console.log("이건가",res)
          this.$store.dispatch("login");
          this.$store.dispatch("userList", res.data);
          this.$store.dispatch("myNum", res.data.userNo);
          this.$store.dispatch("userEmail", res.data.userEmail);
          this.$store.dispatch("myProfileimageurl", res.data.userProfileImage);
          this.$store.dispatch("userGender", res.data.userGender);
          sessionStorage.setItem("userList", this.$store.state.userList);
          sessionStorage.setItem("myNum", Number(this.$store.state.myNum));
          sessionStorage.setItem(
            "userEmail",
            this.$store.state.userList.userEmail
          );
          sessionStorage.setItem(
            "userPassword",
            this.$store.state.userList.userPassword
          );
          if (
            this.$store.state.myProfileimageurl === null &&
            this.$store.state.userGender === "M"
          ) {
            this.$store.dispatch("changeManImage");
          } else if (
            this.$store.state.myProfileimageurl === null &&
            this.$store.state.userGender === "W"
          ) {
            this.$store.dispatch("changeWImage");
          } else if (
            this.$store.state.myProfileimageurl === null &&
            this.$store.state.userGender === null
          ) {
            this.$store.dispatch("changeImage");
          }

          this.$router.push({ name: "Mainpage" });
        })
        .catch((err) => {
          Swal.fire({title: '이메일과 비밀번호를 확인해주세요', icons:'error', time:2000})
          console.log(err)
        })
    },

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
    kakaoLogin() {
      // console.log(window.Kakao);
      window.Kakao.Auth.login({
        scope: "account_email, gender",
        success: this.GetMe,
      });
    },
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

    // onSuccess(googleUser) {
    //   console.log(googleUser);
    //   this.googleUser = googleUser.getBasicProfile();
    //   this.$router.push({ name: "Home" });
    // },
    // onFailure(error) {
    //   console.log(error);
    // },

    // 구글 로그아웃
    // signout() {
    //   const authInst = window.gapi.auth2.getAuthInstance();
    //   authInst.signOut().then(() => {
    //     console.log("User Signed Out!!!");
    //   });
    // },
  },
};
</script>

<style scoped>
.registration-form{
	padding: 50px 0;
}

.registration-form form{
  /* background-color: #fff; */
  background-color: #dee9ff;
  max-width: 600px;
  margin: auto;
  padding: 50px 70px;
  border-top-left-radius: 30px;
  border-top-right-radius: 30px;
  box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.075);
}
.registration-form .item{
	border-radius: 20px;
  margin-bottom: 25px;
  padding: 10px 20px;
}

.registration-form .login-account{
  border-radius: 30px;
  padding: 10px 20px;
  font-size: 18px;
  font-weight: bold;
  background-color: #5791ff;
  border: none;
  color: white;
  margin-top: 20px;
}

.registration-form .social-media{
  max-width: 600px;
  background-color: #fff;
  margin: auto;
  padding: 35px 0;
  text-align: center;
  border-bottom-left-radius: 30px;
  border-bottom-right-radius: 30px;
  color: #9fadca;
  border-top: 1px solid #dee9ff;
  box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.075);
}

.registration-form .social-icons{
    margin-top: 30px;
    margin-bottom: 16px;
}

.registration-form .social-icons a{
    font-size: 23px;
    margin: 0 3px;
    color: #5691ff;
    border: 1px solid;
    border-radius: 50%;
    width: 45px;
    display: inline-block;
    height: 45px;
    text-align: center;
    background-color: #fff;
    line-height: 45px;
}

.registration-form .social-icons a:hover{
    text-decoration: none;
    opacity: 0.6;
}

input[type=password] {
  font-family: 'NanumSquare'
}

@media (max-width: 576px) {
  .registration-form form{
      padding: 50px 20px;
  }

  .registration-form .form-icon{
      width: 70px;
      height: 70px;
      font-size: 30px;
      line-height: 70px;
  }
}


/* .test {
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
*/
</style>
