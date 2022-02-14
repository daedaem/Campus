<template>
  <div class="container" style="padding-left:0px;">
    
    <div class="filterbox row">
      <div class="form-check filterbox1 col-3">
        <input :disabled="campCheck.length > 0 && !campCheck.includes('오토캠핑')" class="form-check-input" v-model="campCheck" type="checkbox" value="오토캠핑" id="flexCheckDefault100">
        <label class="form-check-label" for="flexCheckDefault100">
          오토캠핑
        </label>
      </div>
      <div class="form-check filterbox1 col-3" >
        <input :disabled="campCheck.length > 0 && !campCheck.includes('글램핑')" class="form-check-input" v-model="campCheck" type="checkbox" value="글램핑" id="flexCheckChecked101" >
        <label class="form-check-label" for="flexCheckChecked101">
          글램핑
        </label>
      </div>
      <div class="form-check filterbox1 col-3">
        <input :disabled="campCheck.length > 0 && !campCheck.includes('카라반')" class="form-check-input" v-model="campCheck" type="checkbox" value="카라반" id="flexCheckChecked102" >
        <label class="form-check-label" for="flexCheckChecked102">
          카라반
        </label>
      </div>
      <div class="form-check filterbox1 col-3">
        <input :disabled="campCheck.length > 0 && !campCheck.includes('차박')" class="form-check-input" v-model="campCheck" type="checkbox" value="차박" id="flexCheckChecked103" >
        <label class="form-check-label" for="flexCheckChecked103">
          차박
        </label>
      </div>
    </div>
    <h4 align="left" style="margin-top:20px;">동행 제한</h4>
    <div class="filterbox row">
      <div class="form-check filterbox1 col-3">
        <input :disabled="limitCheck.length > 0 && !limitCheck.includes('1')" class="form-check-input" v-model="limitCheck" type="checkbox" value="1" id="flexCheckDefault200">
        <label class="form-check-label" for="flexCheckDefault200">
          1인
        </label>
      </div>
      <div class="form-check filterbox1 col-3">
        <input :disabled="limitCheck.length > 0 && !limitCheck.includes('2')" class="form-check-input" v-model="limitCheck" type="checkbox" value="2" id="flexCheckChecked201" >
        <label class="form-check-label" for="flexCheckChecked201">
          2인
        </label>
      </div>
      <div class="form-check filterbox1 col-3">
        <input :disabled="limitCheck.length > 0 && !limitCheck.includes('3')" class="form-check-input" v-model="limitCheck" type="checkbox" value="3" id="flexCheckChecked202">
        <label class="form-check-label" for="flexCheckChecked202">
          3인 이상
        </label>
      </div>
    </div>
    <h4 align="left" style="margin-top:20px;">캠핑 스타일</h4>
    <div class="filterbox row">
      <div class="form-check filterbox1 col-3">
        <input :disabled="styleCheck.length > 2 && !styleCheck.includes('액티비티')" class="form-check-input" v-model="styleCheck" type="checkbox" value="액티비티" id="flexCheckDefault300">
        <label class="form-check-label" for="flexCheckDefault300">
          액티비티
        </label>
      </div>
      <div class="form-check filterbox1 col-3">
        <input :disabled="styleCheck.length > 2 && !styleCheck.includes('힐링')" class="form-check-input" v-model="styleCheck" type="checkbox" value="힐링" id="flexCheckChecked301" >
        <label class="form-check-label" for="flexCheckChecked301">
          힐링
        </label>
      </div>
      <div class="form-check filterbox1 col-3">
        <input :disabled="styleCheck.length > 2 && !styleCheck.includes('요리')" class="form-check-input" v-model="styleCheck" type="checkbox" value="요리" id="flexCheckChecked302" >
        <label class="form-check-label" for="flexCheckChecked302">
          요리
        </label>
      </div>
      <div class="form-check filterbox1 col-3">
        <input :disabled="styleCheck.length > 2 && !styleCheck.includes('음주')" class="form-check-input" v-model="styleCheck" type="checkbox" value="음주" id="flexCheckChecked303" >
        <label class="form-check-label" for="flexCheckChecked303">
          음주
        </label>
      </div>
      <div class="form-check filterbox1 col-3">
        <input :disabled="styleCheck.length > 2 && !styleCheck.includes('독서')" class="form-check-input" v-model="styleCheck" type="checkbox" value="독서" id="flexCheckChecked304" >
        <label class="form-check-label" for="flexCheckChecked304">
          독서
        </label>
      </div>
      <div class="form-check filterbox1 col-3">
        <input :disabled="styleCheck.length > 2 && !styleCheck.includes('낚시')" class="form-check-input" v-model="styleCheck" type="checkbox" value="낚시" id="flexCheckChecked305" >
        <label class="form-check-label" for="flexCheckChecked305">
          낚시
        </label>
      </div>
      <div class="form-check filterbox1 col-3">
        <input :disabled="styleCheck.length > 2 && !styleCheck.includes('하이킹')" class="form-check-input" v-model="styleCheck" type="checkbox" value="하이킹" id="flexCheckChecked306" >
        <label class="form-check-label" for="flexCheckChecked306">
          하이킹
        </label>
      </div>
      <div class="form-check filterbox1 col-3">
        <input :disabled="styleCheck.length > 2 && !styleCheck.includes('물놀이')" class="form-check-input" v-model="styleCheck" type="checkbox" value="물놀이" id="flexCheckChecked307" >
        <label class="form-check-label" for="flexCheckChecked307">
          물놀이
        </label>
      </div>
      <div class="form-check filterbox1 col-3">
        <input :disabled="styleCheck.length > 2 && !styleCheck.includes('등산')" class="form-check-input" v-model="styleCheck" type="checkbox" value="등산" id="flexCheckChecked308" >
        <label class="form-check-label" for="flexCheckChecked308">
          등산
        </label>
      </div>
      <div class="form-check filterbox1 col-3">
        <input :disabled="styleCheck.length > 2 && !styleCheck.includes('불멍')" class="form-check-input" v-model="styleCheck" type="checkbox" value="불멍" id="flexCheckChecked309" >
        <label class="form-check-label" for="flexCheckChecked309">
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
  /* float: left; */
  width: 100px;
  height: 40px;
  margin : 0px;
  
} 

h4 {
  color : #5a83ab;
}



</style>