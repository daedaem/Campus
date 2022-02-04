<template>
   <h4>캠핑 유형</h4>

    <div class="filterbox">
      <div class="form-check filterbox1">
        <input class="form-check-input" v-model="sortListCheck" type="checkbox" value="멤버" id="flexCheckDefault71">
        <label class="form-check-label" for="flexCheckDefault71">
          멤버 많은 순
        </label>
      </div>
      <div class="form-check filterbox1">
        <input class="form-check-input" v-model="sortListCheck" type="checkbox" value="빠른" id="flexCheckChecked72" >
        <label class="form-check-label" for="flexCheckChecked72">
          시작날짜 빠른 순
        </label>
      </div>
      <div class="form-check filterbox1">
        <input class="form-check-input" v-model="sortListCheck" type="checkbox" value="최신" id="flexCheckChecked73" >
        <label class="form-check-label" for="flexCheckChecked73">
          최신순
        </label>
      </div>
      
    </div>
  <div align="center">
    <div class="col-sm-3">
    <a data-bs-dismiss="modal" class="btn btn-lg" href="#" @click="$emit('sortListcheck',sortListCheck) ">
        <span>button</span>
    </a>
    </div>
  </div>
</template>

<script>
import {ref} from 'vue'

export default {
  name : 'Modal4',
  emits : ['sortListcheck'],
  setup() {
    const sortListCheck = ref([])
    
    return {
      sortListCheck,
    }
  
  }
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