<template>
	<div v-if="feedList.length !== 0" class="instagram-container">
		<div class="post" v-for="(value, idx) in feedList" :key="idx">
			<!-- {{ value.imageList.snsImageUrl }} -->
			<img class="img-photo" :src="value.imageList[0].snsImageUrl">
			<span class="hover-img" @click="movetofeed(value.snsNo)">
				<p class="icon-heart">{{value.snsCreateTime}}</p>
			</span>
		</div>
	</div>
	<div v-else>
		<h1>아직 피드가 없습니다!</h1>
	</div>
</template>

<script>
export default {
	name: "Profilefeed",
	props: {
		feedList: Object,
	},
	methods: {
		movetofeed: function (e) {
			this.$router.push({ 
				name: 'FeedDetail',
				params: { snsNo: e}})
		}
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
.hover-img .icon-heart::before  {
    content: '♥ ';
}
.hover-img .icon-heart::after  {
    content: ' ♥';
}
</style>