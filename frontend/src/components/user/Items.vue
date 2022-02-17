<template>
  <div class="items">
      <div class="filterbox1"  @click="imgControl('1')">
        <img width="100" height="100" src="../../assets/images/랜던_색상버전.png" alt="" v-if="this.imgStatus.campEquipLantern === 0">
        <img width="100" height="100" src="../../assets/images/랜던_검정버전.png" alt="" v-else>
        <div>랜턴</div>
      </div>
      <div class="filterbox1" @click="imgControl('2')">
        <img width="100" height="100"  src="../../assets/images/린선_색상버전.png" alt="" v-if="this.imgStatus.campEquipReel === 0">
        <img width="100" height="100"  src="../../assets/images/린선_검정버전.png" alt="" v-else>
        <div>릴선</div>
      </div>
      <div  class="filterbox1" @click="imgControl('3')">
        <img width="100" height="100"  src="../../assets/images/버너_색상버전.png" alt="" v-if="this.imgStatus.campEquipBurner === 0">
        <img width="100" height="100"  src="../../assets/images/버너_검정버전.png" alt="" v-else>
        <div>버너</div>
      </div>
      <div class="filterbox1" @click="imgControl('4')">
        <img width="100" height="100"  src="../../assets/images/아이스박스_색상버전.png" alt="" v-if="this.imgStatus.campEquipicebox === 0">
        <img width="100" height="100"  src="../../assets/images/아이스박스_검정버전.png" alt="" v-else>
        <div>아이스박스</div>
      </div>
      <div class="filterbox1" @click="imgControl('5')">
        <img width="100" height="100" src="../../assets/images/의자_색상버전.png" alt="" v-if="this.imgStatus.campEquipTableChair === 0">
        <img width="100" height="100" src="../../assets/images/의자_검정버전.png" alt="" v-else>
        <div>의자</div>
      </div>
      <div class="filterbox1" @click="imgControl('6')">
        <img width="100" height="100" src="../../assets/images/침낭_색상버전.png" alt="" v-if="this.imgStatus.campEquipSleepingbag === 0">
        <img width="100" height="100" src="../../assets/images/침낭_검정버전.png" alt="" v-else>
        <div>침낭</div>
      </div>
      <div class="filterbox1" @click="imgControl('7')">
        <img width="100" height="100" src="../../assets/images/타프_색상버전.png" alt="" v-if="this.imgStatus.campEquipTarp === 0">
        <img width="100" height="100" src="../../assets/images/타프_검정버전.png" alt="" v-else>
        <div>타프</div>
      </div>
      <div class="filterbox1" @click="imgControl('8')">
        <img width="100" height="100" src="../../assets/images/테이블_색상버전.png" alt="" v-if="this.imgStatus.campEquipPot === 0">
        <img width="100" height="100" src="../../assets/images/테이블_검정버전.png" alt="" v-else>
        <div>테이블</div>
      </div>
      <div class="filterbox1" @click="imgControl('9')">
        <img width="100" height="100" src="../../assets/images/텐트_색상버전.png" alt="" v-if="this.imgStatus.campEquipTent === 0">
        <img width="100" height="100" src="../../assets/images/텐트_검정버전.png" alt="" v-else>
        <div>텐트</div>
      </div>
      <div class="filterbox1" @click="imgControl('10')">
        <img width="100" height="100" src="@/assets/images/화로대_색상버젼.png" alt="" v-if="this.imgStatus.campEquipBrazier === 0">
        <img width="100" height="100" src="@/assets/images/화로대_검정버전.png" alt="" v-else>
        <div>화로대</div>
      </div>
    </div>
</template>

<script>
export default {
  name : 'Items',
  methods : {
  imgControl(x) {
      // console.log(x)
      if (x === '1') {
        if ( this.imgStatus.campEquipLantern === 0) {
          this.imgStatus.campEquipLantern += 1
        } else {
          this.imgStatus.campEquipLantern = 0 
        }
      }
      if (x === '2') {
        if ( this.imgStatus.campEquipReel === 0) {
          this.imgStatus.campEquipReel += 1
        } else {
          this.imgStatus.campEquipReel = 0 
        }
      }
      if (x === '3') {
        if ( this.imgStatus.campEquipBurner === 0) {
          this.imgStatus.campEquipBurner += 1
        } else {
          this.imgStatus.campEquipBurner = 0 
        }
      }
      if (x === '4') {
        if ( this.imgStatus.campEquipicebox === 0) {
          this.imgStatus.campEquipicebox += 1
        } else {
          this.imgStatus.campEquipicebox = 0 
        }
      }
      if (x === '5') {
        if ( this.imgStatus.campEquipTableChair === 0) {
          this.imgStatus.campEquipTableChair += 1
        } else {
          this.imgStatus.campEquipTableChair = 0 
        }
      }
      if (x === '6') {
        if ( this.imgStatus.campEquipSleepingbag === 0) {
          this.imgStatus.campEquipSleepingbag += 1
        } else {
          this.imgStatus.campEquipSleepingbag = 0 
        }
      }
      if (x === '7') {
        if ( this.imgStatus.campEquipTarp === 0) {
          this.imgStatus.campEquipTarp += 1
        } else {
          this.imgStatus.campEquipTarp = 0 
        }
      }
      if (x === '8') {
        if ( this.imgStatus.campEquipPot === 0) {
          this.imgStatus.campEquipPot += 1
        } else {
          this.imgStatus.campEquipPot = 0 
        }
      }
      if (x === '9') {
        if ( this.imgStatus.campEquipTent === 0) {
          this.imgStatus.campEquipTent += 1
        } else {
          this.imgStatus.campEquipTent = 0 
        }
      }
      if (x === '10') {
        if ( this.imgStatus.campEquipBrazier === 0) {
          this.imgStatus.campEquipBrazier += 1
        } else {
          this.imgStatus.campEquipBrazier = 0 
        }
      }
    },
  },  
  data() {
    return {
      previewImage: null,
      imgStatus : {
        campEquipLantern : 0,
        campEquipReel : 0,
        campEquipBurner : 0,
        campEquipicebox : 0,
        campEquipTableChair : 0,
        campEquipSleepingbag : 0,
        campEquipTarp : 0,
        campEquipPot : 0,
        campEquipTent : 0,
        campEquipBrazier : 0,
      }
    }
  },
  watch : {
    imgStatus: {
      handler(text){
        this.$emit('img-status',text)
      },
      deep: true
      // this.$emit('img-status',text)
    }
  }
}
</script>

<style scoped>
.items {
  overflow: hidden;
  border-style: solid;
  border-color: rgb(204, 123, 123);
  border-radius: 45px;
  padding: 20px;
}

.filterbox1 {
  float: left;
  /* margin: auto; */
  margin-left: 40px;
  margin-right: 20px;
}

img:hover {
  background-color: #eee
}



</style>