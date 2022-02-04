<template>
	<div class="follow-modal-container">
		<div class="follow-title-header">
			<div class="follow-title-title">
				<!-- {{ title }} -->
			</div>
		</div>
		<div class="follow-modal-content">
			<!-- <div v-if="followList.length==0">목록이 없습니다.</div>
			<div>

			</div> -->

		</div>
		<b>팔로우</b><p> 13</p>
	</div>
</template>

<script>
export default {
	name: "FollowModal",

	props: {
		followList: {
			type: Array,
		}
	}

}
</script>

<style>
.follow-modal-container {
  display: flex;
  flex-direction: column;
  background-color: white;
  width: 50vw;
  margin: 0 auto;
  border-radius: 2vw;
  box-shadow: 0 0.2vw 0.8vw rgba(0, 0, 0, 0.33);
  transition: all .3s ease;
}

.follow-title-header {
  display: flex;
  justify-content: center;
  font-size: 2vw;
  font-weight: bold;
  color: black;
  padding: 1vw;
}

.follow-modal-content {
  display: flex;
  flex-direction: column;
  height: 40vh;
  overflow: hidden;
  overflow-y: auto;
  -webkit-overflow-scrolling: touch;
  border-top: 0.1vw solid gray;
  padding: 1vw 2vw;
  transition-duration: 0.5s;
}
</style>