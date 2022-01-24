<template>
  <div class="wrapC">
    <div class="wrap-contact3">
      <form class="contact3-form validate-form">
        <h1 class="contact3-form-title">Camp-Us</h1>
        <div class="login-header">
          <!-- 로그인 창 -->
          <div>
            <div>
              이메일 :
            </div>
            <div class="wrap-input3">
              <input 
              class="input3"
              type="text"
              placeholder="example@google.com"
              v-model="email"
              id="email"
              >
            </div>
          </div>
          <!-- 패스워드 -->
          <div class="password-container">
            <div>
              패스워드 :
            </div>
            <div class="wrap-input3">
              <input 
              class="input3"
              type="password"
              placeholder="패스워드를 입력해주세요"
              v-model="password"
              id="password"
              >
                {{ error.password }}
            </div>
            <div 
            v-if="error.password"
            >
              
            </div>
          </div>
          <!-- 로그인버튼 -->
          <div class="container-contact3-form-btn">
            <button class="login-button">
              로그인
            </button>
          </div>

          
          <!-- <section class="test">
            <div class="google login-button" v-on:click="GoogleLoginBtn">구글 로그인</div>
            <div class="google" id="my-signin2" style="display: none"></div>
          </section> -->
          <div>
            <div class="g-signin2" data-onsuccess="onSignIn"></div>
            <button @click="signout">구글 로그아웃</button>
          </div>

          <span style="color: #000000;" >비밀번호 찾기</span>
          <span style="color: #000000;"><router-link to="Signup">회원가입</router-link></span>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
import PV from "password-validator";
import * as EmailValidator from "email-validator";

export default {
  name: "Login",
  data: () => {
    return {
      email: "",
      password: "",
      passwordSchema: new PV(),
      error: {
        email: false,
        passowrd: false
      },
      isSubmit: false,
      component: this,
      buttonShow: false,
      accountError: false,
      userEmails: [],
      userPasswords: [],
    };
  },
  created() {
    this.component = this;
    this.passwordSchema
      .is()
      .min(8)
      .is()
      .max(20)
      .has()
      .digits()
      .has()
      .letters();
  },
  watch: {
    // password: function(v) {
    //   this.checkForm(); 
    // },
    // email: function(v) {
    //   this.checkForm();
    // }
  },
  methods: {
    // 이메일 체크
    checkForm() {
      if (this.email.length >= 0 && !EmailValidator.validate(this.email)) {
        this.error.email = "이메일 형식으로 작성해주세요";
        this.buttonShow = false
        this.accountError = false
      }
      else { this.error.email = false;

      }

      if (
        this.password.length >= 0 &&
        !this.passwordSchema.validate(this.password)
      )
        { 
          this.error.password = "영문, 숫자 포함 8자리 이상이어야 합니다.";
          this.buttonShow = false
          this.accountError = false
        }
      else {
        this.error.password = false;
        this.buttonShow = true
      }
    },
    onLogin() {
      var emailIdx = this.userEmails.indexOf(this.email)
      if ( emailIdx == -1) {
        this.accountError = "이메일 또는 비밀번호를 다시 확인해주세요"
      } else {
        if (this.password == this.userPasswords[emailIdx]) {
          if (this.simpleShow) {
            this.simpleOff()
          } else {
            this.accountError = false
            const userInfo = {
              user_email: this.email,
              user_password: this.password,
            }
            this.$store.dispatch("login", userInfo)
            this.simpleOn()
          }
        } else {
          this.accountError = "이메일 또는 비밀번호를 다시 확인해주세요"
        }
      }
    },
    moveToSignUp: function () {
      this.$router.push({name: 'Signup'})
    },

    simpleOn: function () {
      this.simpleShow = !this.simpleShow
    },
    simpleOff: function () {
      this.simpleShow = !this.simpleShow
    },
    
    signout() {
      const authInst = window.gapi.auth2.getAuthInstance();
      authInst.signOut().then(() => {
        console.log('User Signed Out!!!')
      });
    }

    // 구글폼로그인
    // GoogleLoginBtn:function(){
    //   var self = this;

    //   window.gapi.signin2.render('my-signin2', {
    //     scope: 'profile email',
    //     width: 240,
    //     height: 50,
    //     longtitle: true,
    //     theme: 'dark',
    //     onsuccess: this.GoogleLoginSuccess,
    //     onfailure: this.GoogleLoginFailure,
    //   });

    //   setTimeout(function () {
    //     if (!self.googleLoginCheck) {
    //       const auth = window.gapi.auth2.getAuthInstance();
    //       auth.isSignedIn.get();
    //       document.querySelector('.abcRioButton').click();
    //     }
    //   }, 1500)

    // },
    // async GoogleLoginSuccess(googleUser) {
    //   const googleEmail = googleUser.getBasicProfile().getEmail();
    //   if (googleEmail !== 'undefined') {
    //     console.log(googleEmail);
    //   }
    // },
    // //구글 로그인 콜백함수 (실패)
    // GoogleLoginFailure(error) {
    //   console.log(error);
    // },
  }
}
</script>

<style scoped>
  .test{ display:flex;
   justify-content: center;
  align-items: center;
  margin-top: 1vh;
  }

  .google{ width: 200px;
   height:40px;
  background-color:#ffffff;
  border:1px #a8a8a8 solid;
  color:black;
  display:flex;
  align-items: center;
  justify-content: center;
  cursor:pointer; 
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
  border-bottom: 2px solid rgba(255,255,255,0.24);
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