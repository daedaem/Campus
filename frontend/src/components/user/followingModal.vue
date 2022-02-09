<template>
	<div v-if="followinglist.length !== 0">
		<div v-for="(value, idx) in followinglist" :key="idx">
			<!-- {{ value}} -->
			<img class="User-profile-image mx-2" :src="value.userProfileImage" alt="">
			<a @click="myProfile(value.userEmail)">{{ value.userNickname}}</a>
		</div>
		<span data-bs-dismiss="modal">확인</span>
	</div>
	<div v-else>
		<h2>팔로잉이 아무도없네요 ㅠㅠ</h2>
		<span data-bs-dismiss="modal">확인</span>

	</div>


</template>

<script>
export default {
	name: 'followingModal',
	props: {
		followinglist: Object
	},
	methods: {
		myProfile: function (e) {
			this.$router.go({
				name: 'Profile',
				params: { userEmail: e}
			})
		}
	}
}
</script>

<style scoped>
.User-profile-image {
    width: 40px;
    height: 40px;
    border-radius: 20px;
  }
</style>