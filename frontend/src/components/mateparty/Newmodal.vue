<template>
  <div clas="tabbarFrame d-flex">
    <div class="wrapper">
      <div
        class="tabbar d-flex justify-content-between align-items-center pt-1"
      >
        <!-- <div><img class="logos" src="@/assets/images/logo3.png" alt="" /></div> -->

        <router-link
          :to="{ name: 'Mainpage' }"
          class="mainpagerouter d-flex flex-column justify-content-center align-items-center"
          ><i class="bi bi-house-door fs-5"></i>
          <div class="NewModalDiscription">Home</div></router-link
        >

        <router-link
          :to="{ name: 'FeedList' }"
          class="feedrouter d-flex flex-column justify-content-center align-items-center me-5"
          ><i class="bi bi bi-journal-richtext fs-5"></i>
          <div class="NewModalDiscription">SNS</div></router-link
        >
        <router-link
          :to="{ name: 'Campsite' }"
          class="campisterouter d-flex flex-column justify-content-center align-items-center ms-5"
          ><i class="bi bi bi-binoculars fs-5"></i>
          <div class="NewModalDiscription">캠핑장</div>
        </router-link>

        <div v-if="this.$store.state.userEmail">
          <a
            class="profilerouter nav-link d-flex flex-column justify-content-center align-items-center"
            aria-current="page"
            :href="`
              /profile/${this.$store.state.userEmail}`"
          >
            <i class="bi bi-person fs-5"> </i>
            <div class="NewModalDiscription">프로필</div>
          </a>
        </div>
        <div v-else>
          <a
            class="nav-link d-flex flex-column justify-content-center align-items-center"
            aria-current="page"
            href="/login"
            ><i class="bi bi-person fs-3"> </i>
            <div class="NewModalDiscription">로그인</div>
          </a>
        </div>

        <div class="circle">
          <i class="fas fa-plus plus-icon"></i>
          <i class="bi bi-person-plus social" @click="goMatematch"> </i>
          <i class="bi bi-people social" @click="gotoParty"> </i>
        </div>
        <div class="circleBackground"></div>
      </div>
    </div>
  </div>
  <!-- </div> -->
</template>

<script>
const tabs = document.querySelectorAll(".tab");

tabs.forEach((clickedTab) => {
  clickedTab.addEventListener("click", () => {
    tabs.forEach((tab) => {
      tab.classList.remove("active");
    });
    clickedTab.classList.add("active");
  });
});

export default {
  name: "Newmodal",
  components: {
    // Modal2,
  },
  methods: {
    goMatematch() {
      this.$router.push({
        name: "Mateparty",
      });
    },
    gotoParty() {
      this.$router.push({
        name: "Matematch",
        params: { userNo: `${this.$store.state.myNum}` },
      });
    },
  },
};
</script>

<style lang="scss" scoped>
$tabbar-height: 50px;
$circle-radius: 80px;
$backgroundColor: black;

.logos {
  width: 30x;
  height: 30px;
}
html,
body {
  padding: 0;
  margin: 0;
  height: 100%;
  width: 100%;
}
@media (min-width: 768px) {
  * {
    display: none;
  }
}
* {
  box-sizing: border-box;
}
.bi {
  color: black;
}
.nav-link {
  padding: 0;
}
.wrapper {
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: $backgroundColor;
}

.tabbar {
  // position: relative;
  position: fixed;
  bottom: 0px;
  left: 0vw;
  height: $tabbar-height;
  // min-width: 300px;
  width: 100%;
  padding-left: 35px;
  padding-right: 35px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  // border-radius: 25px;
  background-color: white;
  box-shadow: 0 10px 20px rgba(82, 74, 74, 0.3);
  z-index: 10001;
}

.tabbar:after {
  content: "";
  position: absolute;
  bottom: 7px;
  height: 4px;
  width: 35%;
  left: 50%;
  transform: translateX(-50%);
  background-color: gray;
  opacity: 0.3;
}

.circle {
  position: absolute;
  left: 50%;
  transform: translateX(-50%);
  bottom: calc(100px - #{$circle-radius / 2});
  margin-bottom: -50px;
  height: 45px;
  width: 45px;
  border-radius: 40px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  overflow: hidden;
  background-color: #7ac4e1;
  z-index: 9;
  box-shadow: 0 5px 5px rgba(255, 147, 85, 0.35);
  transition: height 0.3s;
}
.clicked_campistrouter {
  color: black;
}
.circle:hover {
  height: 110px;
  border-radius: 50px;
}

.circle .plus-icon {
  color: white;
  font-size: 27px;
  transition: opacity 0.3s, transform 0.2s;
}

.circle:hover .plus-icon {
  transform: rotate(360deg);
  opacity: 0;
}

.circle .social {
  position: absolute;
  top: 195px;
  color: white;
  background-color: rgba(255, 212, 212, 0.308);
  height: 35px;
  width: 35px;
  margin-bottom: 5px;
  border-radius: 50%;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 23px;
  cursor: pointer;
}

.circle .social:nth-child(2) {
  opacity: 0;
  transition: opacity 0.3s, top 0.5s ease;
}

.circle .social:nth-child(3) {
  opacity: 0;
  transition: opacity 0.3s, top 0.5s 0.1s ease;
}

.circle .social:nth-child(1) {
  opacity: 0;
  transition: opacity 0.3s, top 0.5s 0.22s ease;
  margin-bottom: 0px;
}

.circle:hover .social:nth-child(2) {
  opacity: 1;
  top: 5px;
}

.circle:hover .social:nth-child(3) {
  opacity: 1;
  top: calc(5px + 60px + 5px);
}

.circle:hover .social:nth-child(4) {
  opacity: 1;
  top: calc(5px + 60px + 5px + 60px + 5px);
}

.circleBackground {
  position: absolute;
  left: 50%;
  transform: translateX(-50%);
  bottom: calc(100px - #{$circle-radius + 20} / 2);
  margin-bottom: 0;
  // height: calc(#{$circle-radius} + 20px);
  // width: calc(#{$circle-radius} + 20px);
  border-radius: calc(#{$circle-radius + 20} / 2);
  background-color: $backgroundColor;
}

.icon-home,
.icon-settings {
  font-size: 23px;
  color: $backgroundColor;
}
.bi-journal-richtext {
  font-size: 23px;
  color: $backgroundColor;
}
.NewModalDiscription {
  font-size: 12px;
  color: black;
}
</style>
