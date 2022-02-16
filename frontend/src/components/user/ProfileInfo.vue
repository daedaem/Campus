<template>
  <h1 align="left">나의 보유장비</h1>
	<div class="info-container ">
		<div class="items">
      <div class="filterbox1"  >
        <img width="100" height="100" src="../../assets/images/랜던_색상버전.png" alt="" v-if="this.user_data.campEquipLantern === 0">
        <img width="100" height="100" src="../../assets/images/랜던_검정버전.png" alt="" v-else>
        <div v-if="this.user_data.campEquipLantern === 0" class="font-box">랜턴</div>
        <div v-else class="font-box2">랜턴</div>
      </div>
      <div class="filterbox1" >
        <img width="100" height="100"  src="../../assets/images/린선_색상버전.png" alt="" v-if="this.user_data.campEquipReel === 0">
        <img width="100" height="100"  src="../../assets/images/린선_검정버전.png" alt="" v-else>
        <div>릴선</div>
      </div>
      <div  class="filterbox1" >
        <img width="100" height="100"  src="../../assets/images/버너_색상버전.png" alt="" v-if="this.user_data.campEquipBurner === 0">
        <img width="100" height="100"  src="../../assets/images/버너_검정버전.png" alt="" v-else>
        <div>버너</div>
      </div>
      <div class="filterbox1" >
        <img width="100" height="100"  src="../../assets/images/아이스박스_색상버전.png" alt="" v-if="this.user_data.campEquipIcebox === 0">
        <img width="100" height="100"  src="../../assets/images/아이스박스_검정버전.png" alt="" v-else>
        <div>아이스박스</div>
      </div>
      <div class="filterbox1" >
        <img width="100" height="100" src="../../assets/images/의자_색상버전.png" alt="" v-if="this.user_data.campEquipTableChair === 0">
        <img width="100" height="100" src="../../assets/images/의자_검정버전.png" alt="" v-else>
        <div>의자</div>
      </div>
      <div class="filterbox1" >
        <img width="100" height="100" src="../../assets/images/침낭_색상버전.png" alt="" v-if="this.user_data.campEquipSleepingbag === 0">
        <img width="100" height="100" src="../../assets/images/침낭_검정버전.png" alt="" v-else>
        <div>침낭</div>
      </div>
      <div class="filterbox1" >
        <img width="100" height="100" src="../../assets/images/타프_색상버전.png" alt="" v-if="this.user_data.campEquipTarp === 0">
        <img width="100" height="100" src="../../assets/images/타프_검정버전.png" alt="" v-else>
        <div>타프</div>
      </div>
      <div class="filterbox1" >
        <img width="100" height="100" src="../../assets/images/테이블_색상버전.png" alt="" v-if="this.user_data.campEquipPot === 0">
        <img width="100" height="100" src="../../assets/images/테이블_검정버전.png" alt="" v-else>
        <div>테이블</div>
      </div>
      <div class="filterbox1" >
        <img width="100" height="100" src="../../assets/images/텐트_색상버전.png" alt="" v-if="this.user_data.campEquipTent === 0">
        <img width="100" height="100" src="../../assets/images/텐트_검정버전.png" alt="" v-else>
        <div>탠트</div>
      </div>
      <div class="filterbox1" >
        <img width="100" height="100" src="@/assets/images/화로대_색상버젼.png" alt="" v-if="this.user_data.campEquipBrazier === 0">
        <img width="100" height="100" src="@/assets/images/화로대_검정버전.png" alt="" v-else>
        <div>화로대</div>
      </div>
    </div>
	</div>
	<h1 align="left" class="my-3">나만의 캠핑장</h1>
  <div class="d-flex">

    <div v-if="camp_List.length !== 0" class="instagram-container">
      <div class="post" v-for="(value, idx) in camp_List" :key="idx">
        <img class="img-photo" :src="value.firstImageUrl">
        <span class="hover-img" @click="movetocamp(value.contentId)">
          <p class="icon-heart">{{ value.facltNm }}</p>
        </span>
      </div>
    </div>
    <div v-else>
      <div v-if="this.seeUser === this.currentUser">
        <div class="d-flex justify-content-center">
          <button class="check-button" @click="movecampinfo()">Go</button>
        </div>
      </div>
      <div v-else>
        <div class="d-flex justify-content-center">
          <h4>아직 좋아하시는 캠핑장이 없네요</h4>
        </div>
      </div>

    </div>
  </div>
</template>

<script>
export default {
	name: 'ProfileInfo',
	data() {
		return {
      seeUser: "",
			currentUser: "",
		}
	},
	props: {
		user_data: {
			type: Object,
		},
    camp_List: {
      type: Object,
    }
	},
  methods: {
    movetocamp: function (e) {
      this.$router.push({
        name: 'Campsitedetail',
        params: { contentId: e}
      })
    },
    movecampinfo: function () {
      this.$router.push({
        name: 'Campsite'
      })
    }
  },
  created: function() {
		this.seeUser = this.$route.params.userEmail
		this.currentUser = this.$store.state.userList.userEmail
	}
}
</script>

<style scoped>
.info-container{
	align-content: center;
	display: flex;
	justify-content: center;
	width: 930px;
}
.items {
  overflow: hidden;
  border-style: solid;
  border-color: rgb(204, 123, 123);
  border-radius: 45px;
  padding: 20px;
}

.filterbox1 {
  float: left;
  margin-left: 40px;
  margin-right: 20px;
}

img:hover {
  background-color: #eee
}
.instagram-container {
  display: grid;
  grid-template-columns: minmax(150px, 465px) minmax(auto, 465px);
  grid-template-rows: 300px auto auto 300px auto;
  display: inline-grid;
  /* grid-template-columns: 1fr 1fr; */
  row-gap: 25px;
  column-gap: 25px;
}

.instagram-container .post{
    cursor: pointer;
    position: relative; 
    display: block;
    width: 100%;
}
.img-photo{
    width: 100%;
    height: 100%;
    object-fit: cover;
    vertical-align: top;
}

.instagram-container .hover-img{
  background: rgba(0,0,0, .4);
	position: absolute;
	left: 0;
	right: 0;
	bottom: 0;
	top: 0;
	display: none;
	align-items: center;
	justify-content: center;
	color: white;
  text-align: center;
  font-size: 2.2rem;
}
.post:hover  .hover-img{
    display: flex;
}

</style>