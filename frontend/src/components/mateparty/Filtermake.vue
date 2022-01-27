<template>
  <div>
    <h4 align="left">캠핑 유형</h4>
    <div class="filterbox">
      <div class="form-check filterbox1">
        <input class="form-check-input" v-model="campCheck" type="checkbox" value="오토캠핑" id="flexCheckDefault">
        <label class="form-check-label" for="flexCheckDefault">
          오토캠핑
        </label>
      </div>
      <div class="form-check filterbox1">
        <input class="form-check-input" v-model="campCheck" type="checkbox" value="글램핑" id="flexCheckChecked" >
        <label class="form-check-label" for="flexCheckChecked">
          글램핑
        </label>
      </div>
      <div class="form-check filterbox1">
        <input class="form-check-input" v-model="campCheck" type="checkbox" value="카라반" id="flexCheckChecked" >
        <label class="form-check-label" for="flexCheckChecked">
          카라반
        </label>
      </div>
      <div class="form-check filterbox1">
        <input class="form-check-input" v-model="campCheck" type="checkbox" value="차박" id="flexCheckChecked" >
        <label class="form-check-label" for="flexCheckChecked">
          차박
        </label>
      </div>
    </div>
    <h4 align="left">동행 제한</h4>
    <div class="filterbox">
      <div class="form-check filterbox1">
        <input class="form-check-input" v-model="limitCheck" type="checkbox" value="1인" id="flexCheckDefault">
        <label class="form-check-label" for="flexCheckDefault">
          1인
        </label>
      </div>
      <div class="form-check filterbox1">
        <input class="form-check-input" v-model="limitCheck" type="checkbox" value="2인" id="flexCheckChecked" >
        <label class="form-check-label" for="flexCheckChecked">
          2인
        </label>
      </div>
      <div class="form-check filterbox1">
        <input class="form-check-input" v-model="limitCheck" type="checkbox" value="3인 이상" id="flexCheckChecked">
        <label class="form-check-label" for="flexCheckChecked">
          3인 이상
        </label>
      </div>
    </div>
    <h4 align="left">캠핑 스타일</h4>
    <div class="filterbox">
      <div class="form-check filterbox1">
        <input class="form-check-input" v-model="styleCheck" type="checkbox" value="액티비티" id="flexCheckDefault">
        <label class="form-check-label" for="flexCheckDefault">
          액티비티
        </label>
      </div>
      <div class="form-check filterbox1">
        <input class="form-check-input" v-model="styleCheck" type="checkbox" value="힐링" id="flexCheckChecked" >
        <label class="form-check-label" for="flexCheckChecked">
          힐링
        </label>
      </div>
      <div class="form-check filterbox1">
        <input class="form-check-input" v-model="styleCheck" type="checkbox" value="요리" id="flexCheckChecked" >
        <label class="form-check-label" for="flexCheckChecked">
          요리
        </label>
      </div>
      <div class="form-check filterbox1">
        <input class="form-check-input" v-model="styleCheck" type="checkbox" value="음주" id="flexCheckChecked" >
        <label class="form-check-label" for="flexCheckChecked">
          음주
        </label>
      </div>
      <div class="form-check filterbox1">
        <input class="form-check-input" v-model="styleCheck" type="checkbox" value="독서" id="flexCheckChecked" >
        <label class="form-check-label" for="flexCheckChecked">
          독서
        </label>
      </div>
      <div class="form-check filterbox1">
        <input class="form-check-input" v-model="styleCheck" type="checkbox" value="낚시" id="flexCheckChecked" >
        <label class="form-check-label" for="flexCheckChecked">
          낚시
        </label>
      </div>
      <div class="form-check filterbox1">
        <input class="form-check-input" v-model="styleCheck" type="checkbox" value="하이킹" id="flexCheckChecked" >
        <label class="form-check-label" for="flexCheckChecked">
          하이킹
        </label>
      </div>
      <div class="form-check filterbox1">
        <input class="form-check-input" v-model="styleCheck" type="checkbox" value="물놀이" id="flexCheckChecked" >
        <label class="form-check-label" for="flexCheckChecked">
          물놀이
        </label>
      </div>
      <div class="form-check filterbox1">
        <input class="form-check-input" v-model="styleCheck" type="checkbox" value="등산" id="flexCheckChecked" >
        <label class="form-check-label" for="flexCheckChecked">
          등산
        </label>
      </div>
      <div class="form-check filterbox1">
        <input class="form-check-input" v-model="styleCheck" type="checkbox" value="불멍" id="flexCheckChecked" >
        <label class="form-check-label" for="flexCheckChecked">
          불멍
        </label>
      </div>
    </div>
    

    






  </div>
</template>

<script>
export default {
  name : 'Filtermake',
  data() {
    return {
      campCheck : [],
      limitCheck : [],
      styleCheck : [],
      drinkCheck : [],
    }
  },
  methods : {

  },

  watch : {
    drinkCheck(text) {
      this.$emit('drink-check',text)
    },
    styleCheck(text) {
      this.$emit('style-check',text)
    },
    limitCheck(text) {
      this.$emit('limit-check',text)
    },
    campCheck(text) {
      this.$emit('camp-check',text)
    }
  }
}
</script>

<style scoped>
.filterbox {
  overflow: hidden;
}

.filterbox1 {
  float: left;
  width: 100px;
  height: 40px;
} 



</style>