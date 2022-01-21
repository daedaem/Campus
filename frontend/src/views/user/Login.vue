<template>
  <div class="wrapC">
    <h1>로그인하기</h1>
    <div class="login-header">
      <!-- 로그인 창 -->
      <div class="login-container">
        <div>
          이메일 :
        </div>
        <div>
          <input type="text"
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
        <div>
          <input type="password"
          placeholder="패스워드를 입력해주세요"
          v-model="password"
          id="password"
          >
        </div>
      </div>
      <!-- 로그인버튼 -->
      <div>
        <button class="login-button">
          로그인
        </button>
      </div>

      
      <section class="test">
        <div class="google" v-on:click="GoogleLoginBtn">구글 로그인</div>
        <div class="google" id="my-signin2" style="display: none"></div>
      </section>

      <span style="color: #000000" >비밀번호 찾기</span><br>
      <span style="color: #000000"><router-link to="Signup">회원가입</router-link></span>
    </div>
  </div>
</template>

<script>

export default {
  name: "Login",
  methods: {
    // 구글폼로그인
    GoogleLoginBtn:function(){
      var self = this;

      window.gapi.signin2.render('my-signin2', {
        scope: 'profile email',
        width: 240,
        height: 50,
        longtitle: true,
        theme: 'dark',
        onsuccess: this.GoogleLoginSuccess,
        onfailure: this.GoogleLoginFailure,
      });

      setTimeout(function () {
        if (!self.googleLoginCheck) {
          const auth = window.gapi.auth2.getAuthInstance();
          auth.isSignedIn.get();
          document.querySelector('.abcRioButton').click();
        }
      }, 1500)

    },
    async GoogleLoginSuccess(googleUser) {
      const googleEmail = googleUser.getBasicProfile().getEmail();
      if (googleEmail !== 'undefined') {
        console.log(googleEmail);
      }
    },
    //구글 로그인 콜백함수 (실패)
    GoogleLoginFailure(error) {
      console.log(error);
    },
  }
}
</script>

<style scoped>
  .test{ display:flex;
   justify-content: center;
  align-items: center;
  margin-top: 4vh;
  }

  .google{ width: 200px;
   height:40px;
  background-color:#ffffff;
  border:1px #a8a8a8 solid;
  color:black;
  display:flex;
  align-items: center;
  justify-content: center;
  cursor:pointer; }

  
  .wrapC {
  display: flex;
  flex-direction: column;
  background-color: white;
  padding: 0 4vw;
  min-height: 100vh;
}
  .login-container {
  display: flex;
  flex-direction: column;
  justify-content: center;
  margin-top: 5vh;
  padding: 0 15vw;
  /* align-items: center; */
}
.login-button {
  width: 100%;
  margin-top: 12vh;
  background-color: white;
  color: green;
  border: 0.3vw solid;
  border-color: green;
  font-weight: bold;
  font-size: 2vw;
  padding: 0.5vw;
  border-radius: 1vw;
  transition-duration: 0.5s;
}

</style>