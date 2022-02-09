<template>
  <nav class="navbar navbar-expand-lg navbar-dark bg-custom-2">
    <div class="container-fluid d-flex">
      <div class="d-flex align-items-center">
        <a class="brandname ms-3 navbar-brand" href="#">Navbar</a>
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
            <a class="nav-link fa-campground-text" href="#"
              ><i class="fs-5 pt-1 fas fa-campground"></i> <br />캠핑장</a
            >
          </div>

          <div class="Navbar-Searchbar ms-5">
            <searchbar @search-Data="searchData"></searchbar>
            <!-- <form class="d-flex">
          <input
            class="form-control me-2"
            type="search"
            placeholder="Search"
            aria-label="Search"
          /> -->
            <!-- <button class="btn btn-outline-light" type="submit">Search</button> -->
            <!-- </form> -->
          </div>
        </div>
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

      <b-dropdown
        size="sm"
        dropleft
        variant="transparent"
        toggle-class="text-decoration-none"
        no-caret
        class="Navbar-dropdown"
      >
        <template #button-content>
          <div
            v-if="this.$store.state.userEmail"
            class="d-flex justify-content-center align-items-center"
          >
            <img
              v-if="this.$store.state.userList.userProfileImage"
              :src="`${this.$store.state.userList.userProfileImage}`"
              alt=""
              class="Navbar-User-profile-image ms-2"
            />
            <img
              v-if="this.$store.state.userList.userProfileImage == null"
              :src="this.$store.state.myProfileimageurl"
              alt=""
              class="Navbar-User-profile-image ms-2"
            />
            <div class="fw-bold Navbar-User-profile-nickname ms-3">
              {{ this.$store.state.userList.userNickname }}
            </div>
          </div>
          <div v-if="this.$store.state.userEmail == null">
            <img
              src="https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png"
              alt=""
              class="Navbar-User-profile-image ms-2"
            />
            <!-- <i class="fs-5 bi bi-person-badge"></i> -->
          </div>
        </template>
        <div class="dropdown-items" v-if="this.$store.state.userEmail">
          <b-dropdown-item text="Small" class="bnt-sm" @click="myProfile"
            >마이페이지</b-dropdown-item
          >
          <b-dropdown-item text="Small" @click="logout"
            >로그아웃</b-dropdown-item
          >
        </div>


        <div v-if="this.$store.state.userEmail === null">
          <b-dropdown-item @click="moveToSignUp">회원가입</b-dropdown-item>
          <b-dropdown-divider></b-dropdown-divider>

          <b-dropdown-item @click="moveToLogin"> 로그인</b-dropdown-item>
        </div>
      </b-dropdown>
      <!-- </div> -->

      <div class="col-11 hidden-Navbar-Searchbar my-3">
        <form class="d-flex">
          <input
            class="form-control me-2"
            type="search"
            placeholder="Search"
            aria-label="Search"
          />
        </form>
      </div>
    </div>
  </nav>
</template>

<script>
const SERVER_URL = "http://localhost:8080";
// const SERVER_URL = `http://i6e102.p.ssafy.io`;
import { mapState } from "vuex";

import { useRouter } from "vue-router";
import { ref } from "vue";
import axios from "axios";
import Searchbar from "./common/Searchbar.vue";

export default {
  components: { Searchbar },
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
      this.$store.state.userEmail = null;
      this.$store.dispatch("logout");
      sessionStorage.removeItem('userList')
      sessionStorage.removeItem('myNum')
      sessionStorage.removeItem('userEmail')
      sessionStorage.removeItem('userPassword')
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
      console.log(this.$store.getters.getUserId);
      this.$router.push({
        name: "Profile",
        params: { userEmail: `${this.$store.getters.getUserId}` },
      });
    },
    searchData: function (inputdata) {
      axios
        .get(`${SERVER_URL}/movies/find/${inputdata}`)
        .then((res) => {
          this.movies = res.data;
          this.$store.dispatch("searchMovie", this.movies);
          this.$router.push({ name: "MovieSearchResult" });
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },

  created: function () {
  },
  computed: {
    ...mapState(["userList"]),
    ...mapState(["nickname"]),
    ...mapState(["myProfileimageurl"]),
  },
};
</script>

<style scoped>
/* 760보다 작으면 서치바 숨기고 */
/* 숨겨져있던 서치바 길게 */
@media (max-width: 800px) {
  .Navbar-Searchbar {
    display: none;
  }

  .hidden-Navbar-Searchbar {
    margin: auto;
  }
  .btn-group {
    padding-right: 2rem;
  }
}
@media (min-width: 800px) {
  .hidden-Navbar-Searchbar {
    display: none;
  }
  .btn-group {
    padding-right: 3rem;
  }
}
@media (max-width: 580px) {
  .Navbar-buttons {
    margin: auto;
    font-size: 10%;
  }
  .nav-item {
    margin: auto;
    font-size: 10%;
  }
  .Navbar-User-profile-image {
    width: 25px;
    height: 25px;
    border-radius: 20px;
  }
  .Navbar-User-profile-nickname {
    color: #eee;
    font-size: 14px;
  }
}
@media (min-width: 581px) {
  .Navbar-User-profile-image {
    width: 45px;
    height: 45px;
    border-radius: 30px;
  }
}
@media (max-width: 478px) {
  .brandname {
    size: 5px;
  }
  .dropdown-items {
    width: 10px;
  }
  .b-dropdown {
    text-align: left;
  }
  .btn-group {
    margin-right: 5rem;
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

.Navbar-User-profile-nickname {
  color: #eee;
}
.form-control {
  border-radius: 15px;
}
.bi-person-badge {
  color: #eee;
}
.bi-person-badge-text {
  color: #eee;
}
</style>
