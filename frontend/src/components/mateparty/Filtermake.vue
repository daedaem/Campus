<template>
  <div>
    <h4 align="left">캠핑 유형</h4>
    <div class="filterbox">
      <div class="form-check filterbox1">
        <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
        <label class="form-check-label" for="flexCheckDefault">
          오토캠핑
        </label>
      </div>
      <div class="form-check filterbox1">
        <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked>
        <label class="form-check-label" for="flexCheckChecked">
          글램핑
        </label>
      </div>
      <div class="form-check filterbox1">
        <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked>
        <label class="form-check-label" for="flexCheckChecked">
          카라반
        </label>
      </div>
      <div class="form-check filterbox1">
        <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked>
        <label class="form-check-label" for="flexCheckChecked">
          차박
        </label>
      </div>
    </div>
    <h4 align="left">동행 제한</h4>
    <div class="filterbox">
      <div class="form-check filterbox1">
        <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
        <label class="form-check-label" for="flexCheckDefault">
          1인
        </label>
      </div>
      <div class="form-check filterbox1">
        <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked>
        <label class="form-check-label" for="flexCheckChecked">
          2인
        </label>
      </div>
      <div class="form-check filterbox1">
        <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked>
        <label class="form-check-label" for="flexCheckChecked">
          3인 이상
        </label>
      </div>
    </div>
    <h4 align="left">캠핑 스타일</h4>
    <div class="filterbox">
      <div class="form-check filterbox1">
        <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
        <label class="form-check-label" for="flexCheckDefault">
          액티비티
        </label>
      </div>
      <div class="form-check filterbox1">
        <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked>
        <label class="form-check-label" for="flexCheckChecked">
          힐링
        </label>
      </div>
      <div class="form-check filterbox1">
        <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked>
        <label class="form-check-label" for="flexCheckChecked">
          요리
        </label>
      </div>
    </div>
    <h4 align="left">음주</h4>
    <div class="filterbox">
      <div class="form-check filterbox1">
        <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
        <label align="left" class="form-check-label" for="flexCheckDefault">
          음주
        </label>
      </div>
      <div class="form-check filterbox1">
        <input class="form-check-input" type="checkbox" value="" id="flexCheckChecked" checked>
        <label class="form-check-label" for="flexCheckChecked">
          비음주
        </label>
      </div>
    </div>








  </div>
</template>

<script>
export default {
  name : 'Filtermake'
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