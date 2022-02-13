<template>
<div class="container">
  
  <div class="items row">
    <h4>보유 장비</h4>
      <div class="filterbox1 col-md-3 col-sm-3 col-6 "  @click="imgControl('1')">
        <img width="100" height="100" src="../../assets/images/랜던_검정버전.png" alt="" v-if="this.imgStatus.lantern === 0">
        <img width="100" height="100" src="../../assets/images/랜던_색상버전.png" alt="" v-else>
        <div>랜턴</div>
      </div>
      <div class="filterbox1 col-md-3 col-sm-3 col-6 " @click="imgControl('2')">
        <img width="100" height="100"  src="../../assets/images/린선_검정버전.png" alt="" v-if="this.imgStatus.powerstrip === 0">
        <img width="100" height="100"  src="../../assets/images/린선_색상버전.png" alt="" v-else>
        <div>릴선</div>
      </div>
      <div  class="filterbox1 col-md-3 col-sm-3 col-6 " @click="imgControl('3')">
        <img width="100" height="100"  src="../../assets/images/버너_검정버전.png" alt="" v-if="this.imgStatus.burner === 0">
        <img width="100" height="100"  src="../../assets/images/버너_색상버전.png" alt="" v-else>
        <div>버너</div>
      </div>
      <div class="filterbox1 col-md-3 col-sm-3 col-6 " @click="imgControl('4')">
        <img width="100" height="100"  src="../../assets/images/아이스박스_검정버전.png" alt="" v-if="this.imgStatus.icebox === 0">
        <img width="100" height="100"  src="../../assets/images/아이스박스_색상버전.png" alt="" v-else>
        <div>아이스박스</div>
      </div>
      <div class="filterbox1 col-md-3 col-sm-3 col-6 " @click="imgControl('5')">
        <img width="100" height="100" src="../../assets/images/의자_검정버전.png" alt="" v-if="this.imgStatus.chair === 0">
        <img width="100" height="100" src="../../assets/images/의자_색상버전.png" alt="" v-else>
        <div>의자</div>
      </div>
      <div class="filterbox1 col-md-3 col-sm-3 col-6 " @click="imgControl('6')">
        <img width="100" height="100" src="../../assets/images/침낭_검정버전.png" alt="" v-if="this.imgStatus.sleepingbag === 0">
        <img width="100" height="100" src="../../assets/images/침낭_색상버전.png" alt="" v-else>
        <div>침낭</div>
      </div>
      <div class="filterbox1 col-md-3 col-sm-3 col-6 " @click="imgControl('7')">
        <img width="100" height="100" src="../../assets/images/타프_검정버전.png" alt="" v-if="this.imgStatus.tarp === 0">
        <img width="100" height="100" src="../../assets/images/타프_색상버전.png" alt="" v-else>
        <div>타프</div>
      </div>
      <div class="filterbox1 col-md-3 col-sm-3 col-6 " @click="imgControl('8')">
        <img width="100" height="100" src="../../assets/images/테이블_검정버전.png" alt="" v-if="this.imgStatus.table1 === 0">
        <img width="100" height="100" src="../../assets/images/테이블_색상버전.png" alt="" v-else>
        <div>테이블</div>
      </div>
      <div class="filterbox1 col-md-3 col-sm-3 col-6 " @click="imgControl('9')">
        <img width="100" height="100" src="../../assets/images/텐트_검정버전.png" alt="" v-if="this.imgStatus.tent === 0">
        <img width="100" height="100" src="../../assets/images/텐트_색상버전.png" alt="" v-else>
        <div>탠트</div>
      </div>
      <div class="filterbox1 col-md-3 col-sm-3 col-6 " @click="imgControl('10')">
        <img width="100" height="100" src="@/assets/images/화로대_검정버전.png" alt="" v-if="this.imgStatus.brazier === 0">
        <img width="100" height="100" src="@/assets/images/화로대_색상버젼.png" alt="" v-else>
        <div>화로대</div>
      </div>
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
        if ( this.imgStatus.lantern === 0) {
          this.imgStatus.lantern += 1
        } else {
          this.imgStatus.lantern = 0 
        }
      }
      if (x === '2') {
        if ( this.imgStatus.powerstrip === 0) {
          this.imgStatus.powerstrip += 1
        } else {
          this.imgStatus.powerstrip = 0 
        }
      }
      if (x === '3') {
        if ( this.imgStatus.burner === 0) {
          this.imgStatus.burner += 1
        } else {
          this.imgStatus.burner = 0 
        }
      }
      if (x === '4') {
        if ( this.imgStatus.icebox === 0) {
          this.imgStatus.icebox += 1
        } else {
          this.imgStatus.icebox = 0 
        }
      }
      if (x === '5') {
        if ( this.imgStatus.chair === 0) {
          this.imgStatus.chair += 1
        } else {
          this.imgStatus.chair = 0 
        }
      }
      if (x === '6') {
        if ( this.imgStatus.sleepingbag === 0) {
          this.imgStatus.sleepingbag += 1
        } else {
          this.imgStatus.sleepingbag = 0 
        }
      }
      if (x === '7') {
        if ( this.imgStatus.tarp === 0) {
          this.imgStatus.tarp += 1
        } else {
          this.imgStatus.tarp = 0 
        }
      }
      if (x === '8') {
        if ( this.imgStatus.table1 === 0) {
          this.imgStatus.table1 += 1
        } else {
          this.imgStatus.table1 = 0 
        }
      }
      if (x === '9') {
        if ( this.imgStatus.tent === 0) {
          this.imgStatus.tent += 1
        } else {
          this.imgStatus.tent = 0 
        }
      }
      if (x === '10') {
        if ( this.imgStatus.brazier === 0) {
          this.imgStatus.brazier += 1
        } else {
          this.imgStatus.brazier = 0 
        }
      }
    },
  },  
  data() {
    return {
      previewImage: null,
      imgStatus : {
        lantern : 0,
        powerstrip : 0,
        burner : 0,
        icebox : 0,
        chair : 0,
        sleepingbag : 0,
        tarp : 0,
        table1 : 0,
        tent : 0,
        brazier : 0,
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