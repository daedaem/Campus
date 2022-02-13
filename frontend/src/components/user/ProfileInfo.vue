<template>
	<h1 align="left">나의 보유장비</h1>
	<div class="info-container">
		<div class="items">
      <div class="filterbox1"  >
        <img width="100" height="100" src="../../assets/images/랜던_검정버전.png" alt="" v-if="this.user_data.campEquipLantern === 0">
        <img width="100" height="100" src="../../assets/images/랜던_색상버전.png" alt="" v-else>
        <div>랜턴</div>
      </div>
      <div class="filterbox1" >
        <img width="100" height="100"  src="../../assets/images/린선_검정버전.png" alt="" v-if="this.user_data.campEquipReel === 0">
        <img width="100" height="100"  src="../../assets/images/린선_색상버전.png" alt="" v-else>
        <div>릴선</div>
      </div>
      <div  class="filterbox1" >
        <img width="100" height="100"  src="../../assets/images/버너_검정버전.png" alt="" v-if="this.user_data.campEquipBurner === 0">
        <img width="100" height="100"  src="../../assets/images/버너_색상버전.png" alt="" v-else>
        <div>버너</div>
      </div>
      <div class="filterbox1" >
        <img width="100" height="100"  src="../../assets/images/아이스박스_검정버전.png" alt="" v-if="this.user_data.campEquipIcebox === 0">
        <img width="100" height="100"  src="../../assets/images/아이스박스_색상버전.png" alt="" v-else>
        <div>아이스박스</div>
      </div>
      <div class="filterbox1" >
        <img width="100" height="100" src="../../assets/images/의자_검정버전.png" alt="" v-if="this.user_data.campEquipTableChair === 0">
        <img width="100" height="100" src="../../assets/images/의자_색상버전.png" alt="" v-else>
        <div>의자</div>
      </div>
      <div class="filterbox1" >
        <img width="100" height="100" src="../../assets/images/침낭_검정버전.png" alt="" v-if="this.user_data.campEquipSleepingbag === 0">
        <img width="100" height="100" src="../../assets/images/침낭_색상버전.png" alt="" v-else>
        <div>침낭</div>
      </div>
      <div class="filterbox1" >
        <img width="100" height="100" src="../../assets/images/타프_검정버전.png" alt="" v-if="this.user_data.campEquipTarp === 0">
        <img width="100" height="100" src="../../assets/images/타프_색상버전.png" alt="" v-else>
        <div>타프</div>
      </div>
      <div class="filterbox1" >
        <img width="100" height="100" src="../../assets/images/테이블_검정버전.png" alt="" v-if="this.user_data.campEquipPot === 0">
        <img width="100" height="100" src="../../assets/images/테이블_색상버전.png" alt="" v-else>
        <div>테이블</div>
      </div>
      <div class="filterbox1" >
        <img width="100" height="100" src="../../assets/images/텐트_검정버전.png" alt="" v-if="this.user_data.campEquipTent === 0">
        <img width="100" height="100" src="../../assets/images/텐트_색상버전.png" alt="" v-else>
        <div>탠트</div>
      </div>
      <div class="filterbox1" >
        <img width="100" height="100" src="@/assets/images/화로대_검정버전.png" alt="" v-if="this.user_data.campEquipBrazier === 0">
        <img width="100" height="100" src="@/assets/images/화로대_색상버젼.png" alt="" v-else>
        <div>화로대</div>
      </div>
    </div>
	</div>
	<h1 align="left" class="mt-3">캠핑장 정보</h1>
</template>

<script>
export default {
	name: 'ProfileInfo',
	data() {
		return {
		}
	},
	props: {
		user_data: {
			type: Object,
		}
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


</style>