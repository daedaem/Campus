<template>
	<div>
		<div>
			<h4 align="left">캠핑 스타일</h4>
			<hr>
			<div class="filterbox">
				<div class="form-check filterbox1 btn">
					<input class="form-check-input" v-model="campstyle" type="checkbox" value="음식/음주" id="flexCheckDefault">
					<label class="form-check-label" for="flexCheckDefault">
						음식/음주
					</label>
				</div>
				<div class="form-check filterbox1 btn">
					<input class="form-check-input" v-model="campstyle" type="checkbox" value="불멍/수다" id="flexCheckDefault">
					<label class="form-check-label" for="flexCheckDefault">
						불멍/수다
					</label>
				</div>
				<div class="form-check filterbox1 btn">
					<input class="form-check-input" v-model="campstyle" type="checkbox" value="캠프파이어" id="flexCheckDefault">
					<label class="form-check-label" for="flexCheckDefault">
						캠프파이어
					</label>
				</div>
				<br>
				<br>
				<div class="form-check filterbox1 btn">
					<input class="form-check-input" v-model="campstyle" type="checkbox" value="등산" id="flexCheckDefault">
					<label class="form-check-label" for="flexCheckDefault">
						등산
					</label>
				</div>
				<div class="form-check filterbox1 btn">
					<input class="form-check-input" v-model="campstyle" type="checkbox" value="사진찍기" id="flexCheckDefault">
					<label class="form-check-label" for="flexCheckDefault">
						사진찍기
					</label>
				</div>
				<div class="form-check filterbox1 btn">
					<input class="form-check-input" v-model="campstyle" type="checkbox" value="음악감상" id="flexCheckDefault">
					<label class="form-check-label" for="flexCheckDefault">
						음악감상
					</label>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
export default {
	name: 'campstyle',
	data() {
		return {
			campstyle: [],
		}
	},
	watch: {
		styleCheck(text) {
			this.$emit('style-check',text)
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
  width: 120px;
  height: 40px;
	border-style: solid;
  border-color: rgb(204, 123, 123);
  border-radius: 45px;
} 

.item-box {
  border-style: solid;
  border-color: rgb(204, 123, 123);
  border-radius: 45px;
  padding: 20px;
  width: 100%;
}
</style>