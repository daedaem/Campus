<template>
	<div>
		<div>
			<h4 align="left">캠핑 스타일</h4>
			<hr>
			<div class="filterbox">
				<div class="form-check filterbox1">
					<input class="form-check-input" v-model="campCheck" type="checkbox" value="음식/음주" id="flexCheckDefault">
					<label class="form-check-label" for="flexCheckDefault">
						음식/음주
					</label>
				</div>
				<div class="form-check filterbox1">
					<input class="form-check-input" v-model="campCheck" type="checkbox" value="불멍/수다" id="flexCheckChecked2" >
					<label class="form-check-label" for="flexCheckChecked2">
						불멍/수다
					</label>
				</div>
				<div class="form-check filterbox1">
					<input class="form-check-input" v-model="campCheck" type="checkbox" value="캠프파이어" id="flexCheckChecked3" >
					<label class="form-check-label" for="flexCheckChecked3">
						캠프파이어
					</label>
				</div>
				<div class="form-check filterbox1">
					<input class="form-check-input" v-model="campCheck" type="checkbox" value="등산" id="flexCheckChecked4" >
					<label class="form-check-label" for="flexCheckChecked4">
						등산
					</label>
				</div>
				<div class="form-check filterbox1">
					<input class="form-check-input" v-model="campCheck" type="checkbox" value="사진찍기" id="flexCheckChecked5" >
					<label class="form-check-label" for="flexCheckChecked5">
						사진찍기
					</label>
				</div>
				<div class="form-check filterbox1">
					<input class="form-check-input" v-model="campCheck" type="checkbox" value="음악감상" id="flexCheckChecked6">
					<label class="form-check-label" for="flexCheckChecked6">
						음악감상
					</label>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
import {ref} from 'vue'
export default {
	name: 'campstyle',
	emits : ['style-check'],
	setup() {
    
    const campCheck = ref([])
    const submit = () => {
      // console.log(campCheck.value)
      // this.$emit('camp-check',campCheck)
    }
    return {
      campCheck,
      submit
    }
  },
}
</script>

<style scoped>
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
    color:black;
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
</style>