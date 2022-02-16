<template>
	<div v-if="historyList.length !== 0" class="instagram-container">
		<div class="post" v-for="(value, idx) in historyList" :key="idx">
			<img class="img-photo" :src="value.mateImageUrl">
			<span class="hover-img" @click="movetohistory(value.mateNo)">
				<p class="icon-heart">{{value.mateTitle}}</p>
			</span>
		</div>
	</div>
	<div v-else>
		<div>
			<h1>아직 함께하신 여정이 없습니다.</h1>
		</div>
	</div>
</template>

<script>
export default {
	name: "Profilehistory",
	props: {
		historyList: Object,
	},
	methods: {
		movetohistory: function (e) {
		this.$router.push({ 
			name: 'Partyinfo',
			params: { mateNo: e}})
		},
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