<template>
  <nav class="navbar d-flex align-items-center">
    <div class="container-fluid d-flex align-items-center">
      <div class="d-flex align-items-center">
        <a class="brandname ms-3 navbar-brand" href="#">
          <img
            width="56"
            height="44"
            src="../../assets/images/logo1.png"
            alt=""
          />
        </a>
        <div
          class="Navbar-buttons d-flex justify-content-around align-items-center"
        >
          <div class="nav-item">
            <a class="nav-link" aria-current="page" href="/sns">
              SNS
              <!-- <i class="bi bi-journal-richtext"></i> -->
            </a>
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
              메이트
              <!-- <i class="bi bi-people"></i> -->
            </a>
            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
              <li>
                <a class="dropdown-item" href="/mateparty">메이트(모집)</a>
              </li>
              <li>
                <a class="dropdown-item" @click="goMatematch()">메이트(매칭)</a>
              </li>
              <li>
                <a class="dropdown-item" @click="mySurvey()">설문조사</a>
              </li>
              <!-- <li><hr class="dropdown-divider"></li> -->
            </div>
          </div>
          <div class="nav-item">
            <a class="nav-link" href="/campsite"
              >캠핑장
              <!-- <i class="fas fa-campground"></i
            > -->
            </a>
          </div>

          <div class="Navbar-Searchbar ms-5">
            <searchbar></searchbar>
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
              <i class="bi bi-plus-square ></i>
            </button>
          </router-link>
        </div> -->
      <div class="d-flex">
        <div class="d-flex justify-content-center align-items-center">
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
                  v-if="
                    this.$store.state.userList.userProfileImage == null &&
                    this.$store.state.userList.userGender == null
                  "
                  src="https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png"
                  alt=""
                  class="Navbar-User-profile-image ms-2"
                />
                <img
                  v-if="
                    this.$store.state.userList.userProfileImage == null &&
                    this.$store.state.userList.userGender == 'M'
                  "
                  src="http://reflecteen.org.uk/wp-content/uploads/2017/10/person-holding-1-300x300.jpg"
                  alt=""
                  class="Navbar-User-profile-image ms-2"
                />
                <img
                  v-if="
                    this.$store.state.userList.userProfileImage == null &&
                    this.$store.state.userList.userGender == 'W'
                  "
                  src="https://i.pinimg.com/originals/a7/ee/b8/a7eeb85a1d27390ebdf770f8cf31e434.jpg"
                  alt=""
                  class="Navbar-User-profile-image ms-2"
                />
                <div class="Navbar-User-profile-nickname ms-3">
                  {{ this.$store.state.userList.userNickname }}
                </div>
              </div>
              <div
                v-if="this.$store.state.userEmail == null"
                class="d-flex justify-contents-center align-items-center"
              >
                <i class="fs-3 bi bi-person-badge"></i>
                <div class="bi-person-badge-name ms-2">Guest</div>
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
        </div>
      </div>
    </div>
  </nav>
</template>

<script>
// const SERVER_URL = process.env.VUE_APP_SERVER_URL;
import { mapState } from "vuex";
import Swal from "sweetalert2";

import { useRouter } from "vue-router";
import { ref } from "vue";
import Searchbar from "./Searchbar.vue";
import { useStore } from "vuex";
export default {
  components: { Searchbar },
  name: "Navbar",
  setup() {
    const router = useRouter();
    const store = useStore();
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

    const goMatematch = () => {
      console.log(store.state.myNum);
      router.push({ name: "Matematch", params: { userNo: store.state.myNum } });
    };

    return {
      refresh,
      onoff,
      goMatematch,
    };
  },
  methods: {
    logout: function () {
      this.$store.state.user = null;
      this.$store.state.userEmail = null;
      this.$store.state.userGender = null;
      this.$store.state.SearchWord = null;
      this.$store.dispatch("logout");
      sessionStorage.removeItem("userList");
      sessionStorage.removeItem("myNum");
      sessionStorage.removeItem("userEmail");
      sessionStorage.removeItem("userPassword");
      localStorage.removeItem("vuex");
      Swal.fire({
        title: "로그아웃 되었습니다.",
        icon: "success",
        timer: 2000,
      });
      this.$router.push({ name: "Login" });
    },
    moveToSignUp: function () {
      this.$router.push({ name: "Signup" });
    },
    moveToLogin: function () {
      this.$router.push({ name: "Login" });
    },
    mySurvey: function () {
      console.log("엠비티아이", this.$store.state.userList.userMBTI);
      this.$router.push({ name: "Survey" });
    },
    myProfile: function () {
      console.log(this.$store.getters.getUserId);
      this.$router.push({
        name: "Profile",
        params: { userEmail: `${this.$store.getters.getUserId}` },
      });
    },
  },

  created: function () {
    if (sessionStorage.getItem("userEmail") === null) {
      localStorage.removeItem("vuex");
    }
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
.navbar {
  /* height: 60px; */
  font-family: "navfont";
}
@font-face {
  font-family: "navfont";
  src: url("./../../assets/fonts/Frip/NotoSansKR-Regular.otf");
}
a .Navbar-User-profile-nickname {
  font-family: "navfont";
}

@media (max-width: 800px) {
  .Navbar-Searchbar {
    display: none;
  }
  .btn-group {
    margin-right: 1rem;
    padding-right: 1rem;
  }

  .btn-group {
    padding-right: 2rem;
  }
}
@media (min-width: 800px) {
  .btn-group {
    margin-right: 3rem;
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
    /* color: blacolor: #fff;ck; */
    font-size: 12px;
  }
}
@media (min-width: 581px) {
  .Navbar-User-profile-image {
    width: 30px;
    height: 30px;
    border-radius: 30px;
  }
}
@media (max-width: 478px) {
  .brandname {
    size: 5px;
    /* color: blaccolor: #fff;k; */
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

.navbar {
  background-color: #7ac4e1;

  /* border-bottom: 5px solid green; */
}
.bi-plus-square {
  color: #fff;
  border-radius: 30%;
}
.nav-link {
  color: #fff;
}
.nav-link:visited {
  color: #fff;
}

.Navbar-User-profile-nickname {
  color: #fff;
}
.form-control {
  border-radius: 15px;
}
.bi-person-badge {
  color: #fff;
}
.bi-person-badge-name {
  color: #fff;
}
.brandname {
  color: #fff;
}
</style>
