<template>
	<div v-if="followerlist.length !== 0">
		<div v-for="(value, idx) in followerlist" :key="idx">
			<img class="User-profile-image mx-2" :src="value.userProfileImage" alt="">
			<a @click="myProfile(value.userEmail)">{{ value.userNickname}}</a>
		</div>
		<span data-bs-dismiss="modal">확인</span>
	</div>
	<div v-else>
		<h2>팔로워가 아무도없네요 ㅠㅠ</h2>
		<span data-bs-dismiss="modal">확인</span>

	</div>
</template>

<script>
export default {
	name: 'followerModal',
	props: {
		followerlist: Object
	},
	methods: {
		myProfile: function (e) {
			console.log(this.$route)
			console.log(e)
			this.$router.push(this.$route)
			// this.$router.push({
			// 	name: 'Profile',
			// 	// query: {userEmail: e}
			// 	params: { userEmail: e}
			// })
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