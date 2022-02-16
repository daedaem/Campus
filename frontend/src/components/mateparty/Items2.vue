<template>
<div class="container">
  
  <div class="items row">
    <h4>보유 장비</h4>
      <div class="filterbox1 col-md-3 col-sm-3 col-6 " >
        <img width="100" height="100" src="../../assets/images/랜던_검정버전.png" alt="" v-if="this.imgStatus.lantern === 1">
        <img width="100" height="100" src="../../assets/images/랜던_색상버전.png" alt="" v-else>
        <div :style="this.imgStatus.lantern ? '' : 'color:#daddde;'">랜턴</div>
      </div>
      <div class="filterbox1 col-md-3 col-sm-3 col-6 ">
        <img width="100" height="100"  src="../../assets/images/린선_검정버전.png" alt="" v-if="this.imgStatus.powerstrip === 1">
        <img width="100" height="100"  src="../../assets/images/린선_색상버전.png" alt="" v-else>
        <div :style="this.imgStatus.powerstrip ? '' : 'color:#daddde;'">릴선</div>
      </div>
      <div  class="filterbox1 col-md-3 col-sm-3 col-6 ">
        <img width="100" height="100"  src="../../assets/images/버너_검정버전.png" alt="" v-if="this.imgStatus.burner === 1">
        <img width="100" height="100"  src="../../assets/images/버너_색상버전.png" alt="" v-else>
        <div :style="this.imgStatus.burner ? '' : 'color:#daddde;'">버너</div>
      </div>
      <div class="filterbox1 col-md-3 col-sm-3 col-6 ">
        <img width="100" height="100"  src="../../assets/images/아이스박스_검정버전.png" alt="" v-if="this.imgStatus.icebox === 1">
        <img width="100" height="100"  src="../../assets/images/아이스박스_색상버전.png" alt="" v-else>
        <div :style="this.imgStatus.icebox ? '' : 'color:#daddde;'">아이스박스</div>
      </div>
      <div class="filterbox1 col-md-3 col-sm-3 col-6 ">
        <img width="100" height="100" src="../../assets/images/의자_검정버전.png" alt="" v-if="this.imgStatus.chair === 1">
        <img width="100" height="100" src="../../assets/images/의자_색상버전.png" alt="" v-else>
        <div :style="this.imgStatus.chair ? '' : 'color:#daddde;'">의자</div>
      </div>
      <div class="filterbox1 col-md-3 col-sm-3 col-6 ">
        <img width="100" height="100" src="../../assets/images/침낭_검정버전.png" alt="" v-if="this.imgStatus.sleepingbag === 1">
        <img width="100" height="100" src="../../assets/images/침낭_색상버전.png" alt="" v-else>
        <div :style="this.imgStatus.sleepingbag ? '' : 'color:#daddde;'">침낭</div>
      </div>
      <div class="filterbox1 col-md-3 col-sm-3 col-6 ">
        <img width="100" height="100" src="../../assets/images/타프_검정버전.png" alt="" v-if="this.imgStatus.tarp === 1">
        <img width="100" height="100" src="../../assets/images/타프_색상버전.png" alt="" v-else>
        <div :style="this.imgStatus.tarp ? '' : 'color:#daddde;'">타프</div>
      </div>
      <div class="filterbox1 col-md-3 col-sm-3 col-6 ">
        <img width="100" height="100" src="../../assets/images/테이블_검정버전.png" alt="" v-if="this.imgStatus.table1 === 1">
        <img width="100" height="100" src="../../assets/images/테이블_색상버전.png" alt="" v-else>
        <div :style="this.imgStatus.table1 ? '' : 'color:#daddde;'">테이블</div>
      </div>
      <div class="filterbox1 col-md-3 col-sm-3 col-6 ">
        <img width="100" height="100" src="../../assets/images/텐트_검정버전.png" alt="" v-if="this.imgStatus.tent === 1">
        <img width="100" height="100" src="../../assets/images/텐트_색상버전.png" alt="" v-else>
        <div :style="this.imgStatus.tent ? '' : 'color:#daddde;'">탠트</div>
      </div>
      <div class="filterbox1 col-md-3 col-sm-3 col-6 ">
        <img width="100" height="100" src="@/assets/images/화로대_검정버전.png" alt="" v-if="this.imgStatus.brazier === 1">
        <img width="100" height="100" src="@/assets/images/화로대_색상버젼.png" alt="" v-else>
        <div :style="this.imgStatus.brazier ? '' : 'color:#daddde;'">화로대</div>
      </div>
    </div>

    </div>
</template>

<script>
export default {
  name : 'Items2',
  props : ['mateDetail'],
  methods : {
  
  },
  data() {
    return {
      previewImage: null,
      imgStatus : this.mateDetail.campEquipRequiredList
      
    }
  },
  
  created() {
    console.log(this.mateDetail)
  }

}
</script>

<style scoped>
.items {
  overflow: hidden;
  /* border-style: solid; */
  /* border-color: rgb(204, 123, 123); */
  border-radius: 45px;
  padding: 20px;
}

.filterbox1 {
  float: left;
  margin-left: 00px;
  margin-right: 00px;
}

img:hover {
  background-color: #eee
}


</style>