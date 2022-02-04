<template>
<div>
 <h4>캠핑 스타일</h4>

    <div class="filterbox">
      <div class="form-check filterbox1">
        <input :disabled="styleCheck.length > 2 && !styleCheck.includes('액티비티')" class="form-check-input" v-model="styleCheck" type="checkbox" value="액티비티" id="flexCheckDefault5">
        <label class="form-check-label" for="flexCheckDefault5">
          액티비티
        </label>
      </div>
      <div class="form-check filterbox1">
        <input :disabled="styleCheck.length > 2 && !styleCheck.includes('힐링')" class="form-check-input" v-model="styleCheck" type="checkbox" value="힐링" id="flexCheckChecked6" >
        <label class="form-check-label" for="flexCheckChecked6">
          힐링
        </label>
      </div>
      <div class="form-check filterbox1">
        <input :disabled="styleCheck.length > 2 && !styleCheck.includes('요리')" class="form-check-input" v-model="styleCheck" type="checkbox" value="요리" id="flexCheckChecked7" >
        <label class="form-check-label" for="flexCheckChecked7">
          요리
        </label>
      </div>
      <div class="form-check filterbox1">
        <input :disabled="styleCheck.length > 2 && !styleCheck.includes('음주')" class="form-check-input" v-model="styleCheck" type="checkbox" value="음주" id="flexCheckChecked8" >
        <label class="form-check-label" for="flexCheckChecked8">
          음주
        </label>
      </div>
      <div class="form-check filterbox1">
        <input :disabled="styleCheck.length > 2 && !styleCheck.includes('독서')" class="form-check-input" v-model="styleCheck" type="checkbox" value="독서" id="flexCheckChecked20" >
        <label class="form-check-label" for="flexCheckChecked20">
          독서
        </label>
      </div>
      <div class="form-check filterbox1">
        <input :disabled="styleCheck.length > 2 && !styleCheck.includes('낚시')" class="form-check-input" v-model="styleCheck" type="checkbox" value="낚시" id="flexCheckChecked21" >
        <label class="form-check-label" for="flexCheckChecked21">
          낚시
        </label>
      </div>
      <div class="form-check filterbox1">
        <input :disabled="styleCheck.length > 2 && !styleCheck.includes('하이킹')" class="form-check-input" v-model="styleCheck" type="checkbox" value="하이킹" id="flexCheckChecked22" >
        <label class="form-check-label" for="flexCheckChecked22">
          하이킹
        </label>
      </div>
      <div class="form-check filterbox1">
        <input :disabled="styleCheck.length > 2 && !styleCheck.includes('물놀이')" class="form-check-input" v-model="styleCheck" type="checkbox" value="물놀이" id="flexCheckChecked23" >
        <label class="form-check-label" for="flexCheckChecked23">
          물놀이
        </label>
      </div>
      <div class="form-check filterbox1">
        <input :disabled="styleCheck.length > 2 && !styleCheck.includes('등산')"  class="form-check-input" v-model="styleCheck" type="checkbox" value="등산" id="flexCheckChecked24" >
        <label class="form-check-label" for="flexCheckChecked24">
          등산
        </label>
      </div>
      <div class="form-check filterbox1">
        <input :disabled="styleCheck.length > 2 && !styleCheck.includes('불멍')" class="form-check-input" v-model="styleCheck" type="checkbox" value="불멍" id="flexCheckChecked25" >
        <label class="form-check-label" for="flexCheckChecked25">
          불멍
        </label>
      </div>
    </div>
   
    <div align="center">
        <div class="col-sm-3">
        <a data-bs-dismiss="modal" class="btn btn-lg" href="#" @click="$emit('style-check',styleCheck)">
            <span>button</span>
        </a>
    </div>
</div>
</div>
</template>

<script >
import {ref} from 'vue'

export default {
  name : 'Modal3',
  emits : ['style-check'],
  setup() {
    
    const styleCheck = ref([])
    const submit = () => {
      // console.log(campCheck.value)
      // this.$emit('camp-check',campCheck)
    }
    return {
      styleCheck,
      submit
    }
  },
  // watch : {
  //   campCheck(text) {
  //     console.log(text)
  //   }
  // }
}
</script>

<style scoped>
.checkbox-list{
    color: #fff;
    /* background: linear-gradient(#3a7bd5, #3a6073); */
    padding: 25px;
    border-radius: 10px;
}
.form-check{
    border-bottom: 1px dashed rgba(255,255,255,0.5);
    padding: 5px 5px 9px 5px;
    margin: 0 0 10px;
    display: block;
}
.form-check input[type=checkbox]{
    margin: 0;
    visibility: hidden;
    left: 1px;
    top: 1px;
}
.form-check label{
    color:white;
    font-size: 20px;
    line-height: 26px;
    padding-left: 35px;
    margin: 0;
    display: block;
    cursor: pointer;
    position: relative;
    transition: all 0.3s ease 0s;
}
.form-check label:before,
.form-check label:after{
    content: "";
    width: 20px;
    height: 20px;
    border: 3px solid rgba(255,255,255,0.5);
    border-radius: 4px;
    position: absolute;
    top: 3px;
    left: 3px;
    transition: all 0.25s;
}
.form-check label:after{
    height: 10px;
    width: 16px;
    border-radius: 0 0 0 4px;
    border: 5px solid #fff;
    border-top: none;
    border-right: none;
    opacity: 0;
    transform: rotate(-45deg);
    top: 15px;
    left: 6px;
}
.form-check input[type=checkbox]:checked+label{ font-weight: 600; }
.form-check input[type=checkbox]:checked+label:before{
    opacity: 0;
    top: -10px;
}
.form-check input[type=checkbox]:checked+label:after{
    opacity: 1;
    top: 6px;
}
@media only screen and (max-width:767px){
    .checkbox{ margin: 0 0 20px; }
}
.btn{
    color: #fff;
    background: linear-gradient(135deg, #ffbb00, #3f300e);

    font-size: 22px;
    font-weight: 700;
    text-transform: lowercase;
    padding: 10px 20px;
    border: none;
    border-radius: 15px;
    overflow: hidden;
    position: relative;
    transition: all 0.3s cubic-bezier(0.02, 0.01, 0.47, 1);
}
.btn:hover{
    color: #fff;
    border: none;
    box-shadow: 0 0 10px rgba(0,0,0,0.3);
    animation: rotate 0.7s ease-in-out both;
}
.btn:before,
.btn:after{
    content: '';
    background: #fff;
    width: 100px;
    height: 100px;
    border-radius: 50%;
    opacity: 0;
    transform: translate(100%, -25%) translate3d(0, 0, 0);
    position: absolute;
    right: 0;
    bottom: 0;
    z-index: -1;
    transition: all 0.15s cubic-bezier(0.02, 0.01, 0.47, 1);
}
.btn:hover:before,
.btn:hover:after{
    opacity: 0.15;
}
.btn:hover:before{ transform: translate3d(50%, 0, 0) scale(0.9); }
.btn:hover:after{ transform: translate(50%, 0) scale(1.1); }
@keyframes rotate{
    0%{ transform: rotate(0deg); }
    25%{ transform: rotate(3deg); }
    50%{ transform: rotate(-3deg); }
    75%{ transform: rotate(1deg); }
    100%{ transform: rotate(0deg); }
}
@media only screen and (max-width: 767px){
    .btn{ margin-bottom: 20px; }
}
</style>