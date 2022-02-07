<template>
  <nav class="navbar navbar-expand-lg navbar-dark bg-custom-2">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">Navbar</a>
      <button
        class="navbar-toggler"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="/sns">SNS</a>
          </li>

          <li class="nav-item dropdown">
            <a
              class="nav-link dropdown-toggle"
              href="#"
              id="navbarDropdown"
              role="button"
              data-bs-toggle="dropdown"
              aria-expanded="false"
            >
              Dropdown
            </a>
            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
              <li>
                <a class="dropdown-item" href="/mateparty">메이트(모집)</a>
              </li>
              <li>
                <a class="dropdown-item" href="/matematch">메이트(매칭)</a>
              </li>
              <!-- <li><hr class="dropdown-divider"></li> -->
            </ul>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">캠핑장</a>
          </li>
          <li class="nav-item">
            <button class="nav-link" @click="myProfile">프로필</button>
          </li>
        </ul>
        <form class="d-flex">
          <input
            class="form-control me-2"
            type="search"
            placeholder="Search"
            aria-label="Search"
          />
          <button class="btn btn-outline-light" type="submit">Search</button>
        </form>
        <li class="nav-item">
          <div v-if="this.$store.state.isLogin">
            <button @click="logout">로그아웃</button>
            <!-- <a class="nav-link " href="/signup">회원가입</a> -->
          </div>
          <div v-if="this.$store.state.isLogin == false">
            <button @click="moveToLogin">로그인</button>
            <button @click="moveToSignUp">회원가입</button>
          </div>
        </li>
      
      </div>
    </div>
  </nav>
</template>

<script>
import { useRouter } from "vue-router";
import { ref } from "vue";
export default {
  name: "Navbar",
  setup() {
    const router = useRouter();
    const onoff = ref(0);
    const refresh = () => {
      if (onoff.value === 0) {
        onoff.value += 1;
        console.log(onoff.value);
      } else {
        onoff.value -= 1;
        router.go();
        console.log(onoff.value);
      }
    };

    return {
      refresh,
      onoff,
    };
  },
  methods: {
    logout: function () {
      localStorage.removeItem("jwt");
      this.$store.dispatch("logout");
      sessionStorage.removeItem("userList")
      sessionStorage.removeItem("myNum")
      sessionStorage.removeItem("userEmail")
      sessionStorage.removeItem("userPassword")

      alert("로그아웃");
      this.$router.push({ name: "Login" });
    },
    moveToSignUp: function () {
      this.$router.push({ name: "Signup" });
    },
    moveToLogin: function () {
      this.$router.push({ name: "Login" });
    },
    myProfile: function () {
      console.log(this.$store.getters.getUserId)
      this.$router.push({ name: 'Profile', params: { userEmail: `${this.$store.getters.getUserId}`}})
    }

  },

  created: function () {
    const token = localStorage.getItem("jwt");
    if (token) {
      this.$store.dispatch("login");
    }
  
  
 
  
  },
  



}

 
</script>

<style scoped>
.bg-custom-1 {
  background-color: #85144b;
}

.bg-custom-2 {
  background-image: linear-gradient(180deg, #000000 0%, #757575 100%);
}
</style>
