<template>
	<div>
		<div class="card my-auto mx-auto" style="width: 25rem; height: 400px">
			<div class="card-body">
				<h2 class="card-title my-3">캠핑 유형 조사</h2>
				
				<div class="container p-3" align="left">
					<h4
						v-if="page === 0"
						>Q1</h4>

					<h4
						v-if="page === 1"
						>Q1</h4>

					<h4
						v-if="page === 2"
						>Q1</h4>

					<h4
						v-if="page === 3"
						>Q1</h4>
					
					
					<div class="mx-auto my-auto survey-box">
						옆 텐트의 모르는 사람에게 말을 걸지 않는다
					</div>
					<div class="mx-auto my-auto survey-box mt-2">
						나는 캠핑장 옆 텐트에서 망치 빌리는 것이 어렵지 않다
					</div>

				</div>
			</div>
		</div>
		
		

	</div>
</template>

<script>

export default {
	name: "Survey"
}
</script>

<style>
.survey-box{
	border-style: solid;
  border-color: grey;
  border-radius: 30px;
	background: grey;
	color: white;
  padding: 20px;
  width: 300px;
  height:80px;
	text-align: center;
	font-size: large;
	
}
</style>