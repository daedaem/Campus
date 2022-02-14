<template>
  <body>
    <div class="container">
      <div class="row" >
      
        <div class="col-6"     
        >
          지금 뜨는 메이트 모집
        </div>
        <div class="col-6" align="right" @click="goCampsite()">
          전체보기
        </div>
      
      </div>
      <div class="row">
        <div class="card col-md-2 col-" v-for="(item, idx) in recentlist" :key="idx" style="margin-top:50px;" @click="goRecentDetail(item.mateNo)">
          <img
            class="card-img-top"
            :src="item.mateImageUrl"
            alt=""
        
            v-if="item.mateImageUrl"
          />
          <img
            class="card-img-top"
            src="https://cdn.pixabay.com/photo/2015/11/26/00/14/woman-1063100__340.jpg"
            alt=""
            style="height: 150px"
            v-else
          />
          <div class="card-body" >
            <h5 class="card-title" align="left" style="height: 75px">
              {{ item.mateTitle }}
            </h5>
            <div class="card-text" align="right">
              <small class="text-muted">
                <div align="right">@{{ item.userNickname }}</div>
              </small>
                <div align="right">
                  <small>
                    <i class="far fa-user" ></i>
                    <span v-if="item.mateList" align="right"> {{ item.mateList.length }}</span>
                    <span v-else> 0</span>
                    <span> / {{ item.memberlimit}}</span>
                  </small>
                </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- footer -->
    <div class="container-fluid pb-0 mb-0 justify-content-between text-light">
      <footer>
        <div class="row my-5 justify-content-center py-5">
          <div class="col-11">
            <div class="row">
              <div class="col-xl-8 col-md-4 col-sm-4 col-12 my-auto mx-auto a">
                <h3 class="text-muted mb-md-0 mb-5 bold-text">CAMPUS</h3>
              </div>
              <div class="col-xl-2 col-md-4 col-sm-4 col-12">
                <h6 class="mb-3 mb-lg-4 bold-text"><b>MENU</b></h6>
                <ul class="list-unstyled">
                  <li>Home</li>
                  <li>About</li>
                  <li>Blog</li>
                  <li>Portfolio</li>
                </ul>
              </div>
              <div class="col-xl-2 col-md-4 col-sm-4 col-12">
                <h6 class="mb-3 mb-lg-4 text-muted bold-text mt-sm-0 mt-5">
                  <b>ADDRESS</b>
                </h6>
                <p class="mb-1">Yeonje-gu, Busan, Republic of Korea</p>
                <p>YURIM-ASIAD Apt.</p>
              </div>
            </div>
            <div class="row">
              <div
                class="col-xl-8 col-md-4 col-sm-4 col-auto my-md-0 mt-5 order-sm-1 order-3 align-self-end"
              >
                <p class="social text-muted mb-0 pb-0 bold-text">
                  <span class="mx-2"
                    ><i class="fa fa-facebook" aria-hidden="true"></i
                  ></span>
                  <span class="mx-2"
                    ><i class="fa fa-linkedin-square" aria-hidden="true"></i
                  ></span>
                  <span class="mx-2"
                    ><i class="fa fa-twitter" aria-hidden="true"></i
                  ></span>
                  <span class="mx-2"
                    ><i class="fa fa-instagram" aria-hidden="true"></i
                  ></span>
                </p>
                <small class="rights"
                  ><span>&#174;</span> TEAM CAMPUS All Rights Reserved.</small
                >
              </div>
              <div
                class="col-xl-2 col-md-4 col-sm-4 col-auto order-1 align-self-end"
              >
                <h6 class="mt-55 mt-2 text-muted bold-text">
                  <b>HAESUNG JO</b>
                </h6>
                <small>
                  <span><i class="fa fa-envelope" aria-hidden="true"></i></span>
                  tg8685@gmail.com</small
                >
              </div>
              <div
                class="col-xl-2 col-md-4 col-sm-4 col-auto order-2 align-self-end mt-3"
              >
                <h6 class="text-muted bold-text"><b>HOJUN CHOI</b></h6>
                <small
                  ><span
                    ><i class="fa fa-envelope" aria-hidden="true"></i
                  ></span>
                  matt9504@naver.com</small
                >
              </div>
            </div>
          </div>
        </div>
      </footer>
    </div>
  </body>
</template>

<script>
import { ref } from "vue";
import {useRouter} from 'vue-router'
export default {
  name: "Maincarousel",
  props: {
    mainlist: Array,
  },
  setup(props) {
    const router = useRouter()
    const recentlist = ref(props.mainlist);
    console.log(recentlist.value);
    // console.log(props.mainlist[1])
    // const recentlist = ref(props.mainlist)
    // console.log(recentlist.value)

    const goCampsite = () => {
      router.push({name:'Mateparty'})
    }

    const goRecentDetail = (No) => {
      router.push({name : 'Partyinfo',params: { mateNo : No}})
    }
    return {
      recentlist,
      goCampsite,
      goRecentDetail,
    };
  },
};
</script>

<style lang="scss" scoped>
.merong {
}

@media (min-width: 768px) {
.row > .card {
    margin-left : 18px;
    margin-right : 18px;

    background: #fff;
 
  }
}
a {
  text-decoration: none;
}

.card > .card-img-top {
  height: 200px;
   object-fit:cover;
}

@media (max-width : 768px) {
 .card > .card-img-top {
  height: 240px;
  object-fit:cover;
  // .card > .card-body {
    // height: 100px;
  // }
} 
}
/* Card Styles */

h1 {
  color: #fff;
  padding: 10px 0;
}
.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  transition: 0.3s;
  height:380px;
  border: none;
  &:hover {
    box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.4);
  }
  a {
    color: initial;
    &:hover {
      text-decoration: initial;
    }
  }
  .text-muted i {
    margin: 0 10px;
  }
}

.footer {
  background-color: rgb(231, 231, 231);
}

@import url("https://fonts.googleapis.com/css?family=Rubik&display=swap");

.container-fluid {
  overflow: hidden;
  margin-top: 250px;
  background: #262626;
  color: #627482 !important;
  margin-bottom: 0;
  padding-bottom: 0;
}

small {
  font-size: calc(
    12px + (15 - 12) * ((100vw - 360px) / (1600 - 360))
  ) !important;
}

.bold-text {
  color: #989c9e !important;
}

.mt-55 {
  margin-top: calc(
    50px + (60 - 50) * ((100vw - 360px) / (1600 - 360))
  ) !important;
}

h3 {
  font-size: calc(
    34px + (40 - 34) * ((100vw - 360px) / (1600 - 360))
  ) !important;
}

.social {
  font-size: 21px !important;
}

.rights {
  font-size: calc(
    10px + (12 - 10) * ((100vw - 360px) / (1600 - 360))
  ) !important;
}
</style>
