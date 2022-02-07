<template>
	<div class="instagram-container">
		<div class="post">
			<img class="img-photo" src="https://mblogthumb-phinf.pstatic.net/MjAyMTAzMDJfOTQg/MDAxNjE0NjUyODEwMjA4.Mke1iK04NvEshDy3RKu1vKU7e8yFperDHmGLjs-oZFcg.rh42I91igxjSf7dcRcLutsIGsD0oj8EwyRyN56KhK30g.JPEG.mckl795/IMG_5646.JPG?type=w800">
			<span class="hover-img">
				<p class="icon-heart">02/12/20</p>
			</span>
		</div>

		<div class="post">
			<img class="img-photo" src="https://mblogthumb-phinf.pstatic.net/MjAyMTAzMDJfMTAw/MDAxNjE0NjUyODExMTIx.cAOLni0SBq4n5ON7OIK6sNJt9jLfsM_vJOW6yh3dZvcg.tLvkk0yYhHwel-RyapOkQBSNdmwi-czXXKWknhzJWS4g.JPEG.mckl795/IMG_5647.JPG?type=w800">
			<span class="hover-img">
				<p class="icon-heart">02/12/20</p>
			</span>
		</div>

		<div class="post">
			<img class="img-photo" src="https://mblogthumb-phinf.pstatic.net/MjAyMTAzMDJfMjIy/MDAxNjE0NjUyODEwMjIx.W9f2-zoExfTlaNrOz1uUteKxz8d6HqK5TLvbx_jmrlIg.zzj4DJc7Uq3-O7ng8ELzqX0SYRw_psnjz1tcti48NQ8g.JPEG.mckl795/IMG_5648.JPG?type=w800">
			<span class="hover-img">
				<p class="icon-heart">02/12/20</p>
			</span>
		</div>
	</div>
</template>

<script>
export default {
	name: "Profilefeed",
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