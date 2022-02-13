<template>
	<div v-if="followerlist.length !== 0">
		<h1>팔로워</h1>
		<hr>
		<div class="mb-2" v-for="(value, idx) in followerlist" :key="idx">
			
				<img v-if="value.userProfileImage != null" class="User-profile-image mx-2" :src="value.userProfileImage" alt="">
				<img v-else class="User-profile-image mx-2" src="https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png" alt="">
				<a @click="myProfile(value.userEmail)" data-bs-dismiss="modal">{{ value.userNickname}}</a>
		</div>
		<span class="button-follow" data-bs-dismiss="modal">확인</span>
	</div>
	<div v-else>
		<h2>아직 팔로워가 없습니다.</h2>
		<span class="button-follow" data-bs-dismiss="modal">확인</span>

	</div>
</template>

<script>
export default {
	name: 'followerModal',
	props: {
		followerlist: Object,
	},
	methods: {
		myProfile: function (e) {
			console.log(this.$route)
			console.log(e)
			// this.$router.push(this.$route)
			this.$router.push({
				name: 'Profile',
				// query: {userEmail: e}
				params: { userEmail: e}
			})
		}
	},
}
</script>

<style scoped>
.User-profile-image {
    width: 40px;
    height: 40px;
    border-radius: 20px;
  }

.button-follow{
	border-radius: 30px;
  padding: 10px 20px;
  font-size: 18px;
  font-weight: bold;
  background-color: #5791ff;
  border: none;
  color: white;
  margin-top: 30px;
}

</style>