<template>
	<div v-if="feedList.length !== 0" class="instagram-container">
		<div class="post" v-for="(value, idx) in feedList" :key="idx">
			<!-- {{ value.imageList.snsImageUrl }} -->
			<img class="img-photo" :src="value.imageList[0].snsImageUrl">
			<span class="hover-img" @click="movetofeed(value.snsNo)">
				<p class="icon-heart">{{value.snsCreateTime.slice(0,10) }}</p>
			</span>
		</div>
	</div>
	<div v-else>
		<div v-if="this.seeUser === this.currentUser">
			<h1>게시글을 한번 작성해보러 갈까요?</h1>
			<div class="d-flex justify-content-center">
				<button class="check-button" @click="createFeed()">Go</button>
			</div>
		</div>
		<div v-else>
			<h1>아직 게시글이 없습니다.</h1>
		</div>
	</div>
</template>

<script>
export default {
	name: "Profilefeed",
	data() {
		return {
			seeUser: "",
			currentUser: "",
		}
	},
	props: {
		feedList: Object,
	},
	methods: {
		movetofeed: function (e) {
			this.$router.push({ 
				name: 'FeedDetail',
				params: { snsNo: e}})
		},
		createFeed: function () {
			this.$router.push({
				name: 'FeedCreate'
			})
		}
	},
	created: function() {
		this.seeUser = this.$route.params.userEmail
		this.currentUser = this.$store.state.userList.userEmail
	}
}
</script>

<style scoped>
.instagram-container .post{
    cursor: pointer;
    position: relative; 
    display: block;
    width: 100%;
}
.img-photo{
    width: 100%;
    height: 100%;
    object-fit: cover;
    vertical-align: top;
}

.instagram-container .hover-img{
  background: rgba(0,0,0, .4);
	position: absolute;
	left: 0;
	right: 0;
	bottom: 0;
	top: 0;
	display: none;
	align-items: center;
	justify-content: center;
	color: white;
  text-align: center;
  font-size: 2.2rem;
}
.post:hover  .hover-img{
    display: flex;
}


.check-button{
  border-radius: 30px;
  padding: 10px 20px;
  font-size: 18px;
  font-weight: bold;
  background-color: #5791ff;
  border: none;
  color: white;
  margin-top: 20px;
}
</style>