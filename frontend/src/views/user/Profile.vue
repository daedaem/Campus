<template>
	<div>
		<section class="profile-container">
			<section class="profile-grid">
				<div class="photo">
					<img src="https://w.namu.la/s/dabd214cce31238efc33e14536a8145b7ca02b2871bbc5c0b1213e26b3df4b69c33c94d815fc7529c0e9f8f05a39698b6b9b2f86785782c8825888b1f1403d6797e2d5a185e51eaf077a8e48185b69666b2ea7b1600935774217a7d9c45fa7faa3d0760690695013391b253d02840690" alt="이미지">
				</div>
				<div class="name-buttons d-flex justify-content-between">
					<h1>Winter</h1>
					<div class="">
						<button @click="moveToModify" class="btn profile-settings-btn" aria-label="profile settings"><i class="fas fa-cog" aria-hidden="true"></i></button>
					</div>
				</div>
				
				<div class="mt-2">
					<span class="mx-1">#등산</span>
					<span class="mx-1">#백패킹</span>
				</div>

				<div class="mt-2">
					3.7 / 5
				</div>
				
				<div>
					<button>follow</button>
				</div>

			</section>
			
		</section>

		<!-- 프로필 정보 -->
		<section>
			<ul class="profile-stats">
				<li>
					<b>여정</b><p> 18</p>
				</li>
				<li>
					<b>게시글</b><p> 18</p>
				</li>
				<li>
					<b>팔로워</b><p> 20</p>
				</li>
				<li>
					<b>팔로우</b><p> 13</p>
				</li>
			</ul>
		</section>

		<section class="instagram-container">
			<footer class="image-footer ">
				<div>
					<a href=""><b>Profile</b></a>
				</div>
				<div>
					<a href="">FEED</a>
				</div>
				<div>
					<a href="">History</a>
				</div>
			</footer>

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
				<img class="img-photo" src="https://mblogthumb-phinf.pstatic.net/MjAyMTAzMDJfMTAw/MDAxNjE0NjUyODExMTIx.cAOLni0SBq4n5ON7OIK6sNJt9jLfsM_vJOW6yh3dZvcg.tLvkk0yYhHwel-RyapOkQBSNdmwi-czXXKWknhzJWS4g.JPEG.mckl795/IMG_5647.JPG?type=w800">
				<span class="hover-img">
					<p class="icon-heart">02/12/20</p>
				</span>
			</div>

		</section>

		

	</div>
</template>

<script>
import axios from "axios";

const SERVER_URL = process.env.VUE_APP_SERVER_URL

export default {
	name: "Profile",
	data() {
		return {
			user: this.$route.params.user,
			person: null,
			followingModal:false, //모달...
      followerModal:false, //모달...
			// followingList: [],
			// followerList: [],

		}
	},

	created: function () {
		this.getProfile()
	},

	methods : {
		getProfile: function() {
			const token = localStorage.getItem('jwt')
			axios({
				method: 'get',
				url: `${SERVER_URL}/user/${this.user}`,
				headers: {Authorization: `JWT ${token}`},
			})
			.then(res => {
				this.person = res.data
			})
		},
		moveToModify: function () {
      this.$router.push({ name: "Modify" });
    },
		followingList() {
			this.followingModal = !this.followingModal
		},
		followerList() {
			this.followerModal = !this.followerModal
		}
	}

}
</script>

<style scoped>
.profile-container{
    display: flex;
    justify-content: center;
    margin-bottom: 15px;
    padding-top: 30px;
    font-family: 'Roboto',sans-serif;
    font-weight: 300;
}
.profile-grid{
    display: grid;
    grid-template-columns:minmax(150px,230px) minmax(auto,700px);
    grid-template-rows: 30px auto auto 30px auto;
    grid-template-areas: "photo  user-bottom"
                         "photo  second-line"
                         "photo  description"
                         "photo  followers-line";
                         /* "h-post h-post";    */
    row-gap: 10px;
}
.profile-grid div{
    display: flex;
}
.profile-grid .photo{ 
    padding-left: 20px;
    grid-area: photo;
}
.profile-grid .photo img{
    width: 140px;
    height: 140px;
    border-radius: 50%;
    padding: 3px;
    background-color: white;
    border: 3px solid rgb(192, 187, 187);
    object-fit: cover;
}
.profile-grid .name-buttons{
    grid-area: user-bottom;
    display: flex;
}
.profile-grid .name-buttons div{
    height: 40px;
		width: 40px;
}
.profile-grid .name-buttons button{
    display: flex;
		width:40px;
		height:40px;
    font-weight:600;
    padding: 0 5px;
    align-items: center;
    justify-content: center;
    border: 2px solid #efefef   ;
    background-color: rgb(250,250,250);
}

.profile-stats {
    margin-top: 2.3rem;
		align-items: center;
		/* border-bottom: 0.1rem solid #dadada; */
}

.profile-stats li {
    display: inline-block;
    font-size: 1.5rem;
    line-height: 1.5;
    margin-right: 3.5rem;
    cursor: pointer;
}

.profile-stats li:last-of-type {
  margin-right: 0;
}

.instagram-container{

    display: grid;
    justify-content: center;
    grid-template-columns:repeat(3,minmax(auto,293px));
    grid-template-rows: auto ;
    background-color: #fafafa;
    row-gap: 25px;
    column-gap: 25px;
}
.instagram-container .image-footer{
    border-top: 1px solid rgb(201, 195, 195);
    align-items: center;
    display: flex;
    justify-content: center;
    grid-column-start: 1 ;
    grid-column-end: 4;
}
.instagram-container .image-footer div{
    display: flex;
    padding-top: 15px;
    margin-right: 50px; 
    font-size: 1.2rem;
    font-family: 'Roboto',sans-serif; 
    align-items: center;
    font-weight: 300;
    text-align: center;
}
.instagram-container .image-footer a{
    text-decoration: none;
    color: rgb(90, 90, 90);
}
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




</style>