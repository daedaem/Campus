<template>
  <nav class="navbar navbar-expand-lg navbar-dark bg-custom-2">
    <div class="container-fluid d-flex">
      <div class="d-flex align-items-center">
        <a class="ms-3 navbar-brand" href="#">Navbar</a>
        <div class="Navbar-buttons d-flex align-items-center">
          <div class="nav-item">
            <a class="nav-link" aria-current="page" href="/sns"
              ><i class="fs-5 bi bi-journal-richtext"></i><br />피드</a
            >
          </div>

          <div class="nav-item dropdown">
            <a
              class="nav-link dropdown-toggle"
              href="#"
              id="navbarDropdown"
              role="button"
              data-bs-toggle="dropdown"
              aria-expanded="false"
            >
              <i class="fs-5 bi bi-people"></i>
              <br />메이트</a
            >
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <li>
                <a class="dropdown-item" href="/mateparty">메이트(모집)</a>
              </li>
              <li>
                <a class="dropdown-item" href="/matematch">메이트(매칭)</a>
              </li>
              <!-- <li><hr class="dropdown-divider"></li> -->
            </div>
          </div>
          <div class="nav-item">
            <a class="nav-link" href="#"
              ><i class="fs-5 pt-1 fas fa-campground"></i> <br />캠핑장</a
            >
          </div>
        </div>
      </div>

      <div class="Navbar-Searchbar">
        <form class="d-flex">
          <input
            class="form-control me-2"
            type="search"
            placeholder="Search"
            aria-label="Search"
          />
          <button class="btn btn-outline-light" type="submit">Search</button>
        </form>
      </div>
      <!-- <div class="d-flex justify-content-center align-items-center"> -->
      <!-- <div>
          <router-link
            class="text-decoration-none fw-bold text-primary align-middle align-self-center"
            :to="{ name: 'FeedCreate' }"
          >
            <button type="button" class="btn">
              <i class="bi bi-plus-square fs-5"></i>
            </button>
          </router-link>
        </div> -->
      <div class="nav-item dropdown">
        <a
          class="nav-link dropdown-toggle"
          href="#"
          id="navbarDropdown"
          role="button"
          data-bs-toggle="dropdown"
          aria-expanded="false"
        >
          <i class="fs-5 bi bi-person-badge"></i>
          <br />회원관리</a
        >
        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
          <li v-if="this.$store.state.token">
            <ul @click="logout">
              로그아웃
            </ul>
            <!-- <a class="nav-link " href="/signup">회원가입</a> -->
          </li>
          <li v-if="this.$store.state.token === null">
            <ul @click="moveToLogin">
              로그인
            </ul>
            <ul @click="moveToSignUp">
              회원가입
            </ul>
          </li>
          <!-- <li><hr class="dropdown-divider"></li> -->
        </ul>
      </div>
      <!-- </div> -->
      <div class="col-11 hidden-Navbar-Searchbar my-3">
        <form class="d-flex">
          <input
            class="form-control me-2"
            type="search"
            placeholder="Search"
            aria-label="Search"
          />
          <button class="btn btn-outline-light" type="submit">Search</button>
        </form>
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
      this.$store.state.user = null;
      localStorage.removeItem("jwt");
      this.$store.dispatch("logout");
      alert("로그아웃");
      this.$router.push({ name: "Login" });
    },
    moveToSignUp: function () {
      this.$router.push({ name: "Signup" });
    },
    moveToLogin: function () {
      this.$router.push({ name: "Login" });
    },
  },

  created: function () {
    const token = localStorage.getItem("jwt");
    if (token) {
      this.$store.dispatch("login");
    }
  },
};
</script>

<style scoped>
/* 760보다 작으면 서치바 숨기고 */
/* 숨겨져있던 서치바 길게 */
@media (max-width: 760px) {
  .Navbar-Searchbar {
    display: none;
  }
  .hidden-Navbar-Searchbar {
    margin: auto;

    /* flex-grow: 1; */
    /* width: 80%; */
  }
}
@media (min-width: 761px) {
  .hidden-Navbar-Searchbar {
    display: none;
  }
}
@media (max-width: 440px) {
  .Navbar-buttons {
    margin: auto;
    font-size: 10%;
  }
  .nav-item {
    margin: auto;
    font-size: 10%;
  }
}
.bg-custom-1 {
  background-color: #85144b;
}

.bg-custom-2 {
  background-image: linear-gradient(180deg, #000000 0%, #757575 100%);
}
.bi-plus-square {
  color: #eee;
  border-radius: 30%;
}
.nav-link {
  color: #eee;
}
.nav-link:visited {
  color: #eee;
}
.form-control {
  border-radius: 15px;
}
</style>
