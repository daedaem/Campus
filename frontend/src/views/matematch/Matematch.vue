<template>
  <body>
    <div class="flex">
      <p>CAMP<sub>with</sub>US</p>
    </div>
    <div class="container">
      <div class="row">
        <div class="col-lg-6" v-for="(item, idx) in matchData" :key="idx">
          <div class="card p-0">
            <div class="card-image">
              <img :src="item.userProfileImage" alt="" />
            </div>
            <div class="card-content d-flex flex-column align-items-center">
              <h4 class="pt-2">{{ item.userNickname }}</h4>
              <h5>{{ item.userMBTI }}</h5>
              <ul class="social-icons d-flex justify-content-center">
                <li style="--i: 1">
                  <i
                    class="bi bi-instagram white"
                    @click="goProfile(item.userEmail)"
                  ></i>
                </li>
                <li style="--i: 2">
                  <i class="bi bi-chat white" @click="goChatting"></i>
                </li>
                <li style="--i: 3">
                  <i
                    class="bi bi-person-circle white"
                    v-b-popover.hover="'I am popover content!'"
                    title="Popover Title"
                  ></i>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </body>
</template>

<script>
// import {mapState} from 'vuex'
import axios from "axios";
import { ref } from "vue";
// import {useRouter} from 'vue'
// import {useStore} from 'vuex'

const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {
  name: "Matematch",
  setup() {
    //   const store = useStore()
    //   const userNo = store.state.myNum
    const matchData = ref([]);

    axios({
      method: "get",
      url: `${SERVER_URL}/mate/match/4`,
    })
      .then((res) => {
        const temp = res.data.matelist;
        matchData.value = temp;
        console.log(matchData.value);
      })
      .catch((err) => {
        console.log(err);
      });

    const goProfile = (userEmail) => {
      console.log(userEmail);
      // router.push({name : 'Profile' , params : { userEmail : userEmail} })
    };

    return {
      matchData,
      goProfile,
    };
  },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700;800;900&display=swap");

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: "Poppins", sans-serif;
}

@media (min-width: 768px) {
  body {
    width: 768px;
    margin: 0 auto;
    padding: 0 20px;
    background: beige;
  }
}

.container {
  margin-top: 100px;
}

.container .row .col-lg-4 {
  display: flex;
  /* justify-content: center */
}

.card {
  position: relative;
  padding: 0;
  margin: 0 !important;
  border-radius: 20px;
  overflow: hidden;
  max-width: 280px;
  height: 400px;
  cursor: pointer;
  border: none;
  box-shadow: 0 5px 15px rgba(0, 0, 0, 0.2);
}

.card .card-image {
  width: 100%;
  height: 400px;
}

.card .card-image img {
  width: 100%;
  height: 400px;
  object-fit: cover;
}

.card .card-content {
  position: absolute;
  bottom: -180px;
  color: #fff;
  background: rgba(255, 255, 255, 0.2);
  backdrop-filter: blur(15px);
  min-height: 130px;
  width: 100%;
  transition: bottom 0.4s ease-in;
  box-shadow: 0 -10px 10px rgba(255, 255, 255, 0.1);
  border-top: 1px solid rgba(255, 255, 255, 0.2);
}

.card:hover .card-content {
  bottom: 0px;
}

.card:hover .card-content h4,
.card:hover .card-content h5 {
  transform: translateY(10px);
  opacity: 1;
}

.card .card-content h4,
.card .card-content h5 {
  font-size: 1.1rem;
  text-transform: uppercase;
  letter-spacing: 3px;
  text-align: center;
  transition: 0.8s;
  font-weight: 500;
  opacity: 0;
  transform: translateY(-40px);
  transition-delay: 0.2s;
}

.card .card-content h5 {
  transition: 0.5s;
  font-weight: 200;
  font-size: 0.8rem;
  letter-spacing: 2px;
}

.card .card-content .social-icons {
  list-style: none;
  padding: 0;
}

.card .card-content .social-icons li {
  margin: 10px;
  transition: 0.5s;
  transition-delay: calc(0.15s * var(--i));
  transform: translateY(50px);
}

.card:hover .card-content .social-icons li {
  transform: translateY(20px);
}

.card .card-content .social-icons li a {
  color: #fff;
}

.card .card-content .social-icons li a span {
  font-size: 1.3rem;
}

@media (max-width: 991.5px) {
  .container {
    margin-top: 20px;
  }

  .container .row .col-lg-4 {
    margin: 20px 0px;
  }
}
.white,
.white a {
  color: #fff;
}

.headline1 {
  font-size: 40px;
  /* margin: -.6em 0 -1em 0; */
}

.headline2 {
  font-size: 60px;
  margin-top: 20px;

  z-index: -1;
  margin-right: 10px;
}

sub,
sup {
  font-size: 22px;
  opacity: 0.8;
}

sub {
  font-size: 36px;
  animation: flash 2s infinite;
}

.flex {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100%;
}

@keyframes flash {
  0% {
    opacity: 0.5;
  }
  50% {
    opacity: 1;
  }
  100% {
    opacity: 0.5;
  }
}

.flex {
  margin: 0;
  font-size: 80px;
  color: #fff;
  font-family: "Pacifico", sans-serif;
  text-shadow: 0 2px 2px rgba(0, 0, 0, 0.3);
  -webkit-font-smoothing: antialiased;
}
</style>
