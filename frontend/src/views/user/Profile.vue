<template>
	<div>
		<div>
			Debug: {{ this.user_data }}
		</div>
		<section class="profile-container">
			<section class="profile-grid">
				<div class="photo">
					<!-- <img src="https://w.namu.la/s/dabd214cce31238efc33e14536a8145b7ca02b2871bbc5c0b1213e26b3df4b69c33c94d815fc7529c0e9f8f05a39698b6b9b2f86785782c8825888b1f1403d6797e2d5a185e51eaf077a8e48185b69666b2ea7b1600935774217a7d9c45fa7faa3d0760690695013391b253d02840690" alt="이미지"> -->
					<img v-bind:src="this.user_data.userProfileImage" alt="">
				</div>
				<div class="name-buttons d-flex justify-content-between">
					<h1>{{ this.user_data.userNickname }}의 프로필</h1>
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
				
				<div class="userInfo-follow">
					<!-- <button class="userInfo-follow-btn-following" v-if="myFollowings.include(userId)" @click="unfollow(userId)">언팔로우</button>
					<button class="userInfo-follow-btn" v-else-if="userId != myId" @click="follow(userId)" >팔로우</button> -->
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
				<li class="follow" @click="followShowOff2">
					<b>팔로워</b><p>{{ followersList.length }}</p>
				</li>
				<li class="follow" @click="followShowOff">
					<b>팔로우</b><p>{{ followingsList.length }}</p>
				</li>
			</ul>
		</section>

		<section class="instagram-container">
			<footer class="image-footer">
				<!-- <div id="tabs-posts"> -->
					<div v-for="(tab, index) in tabs" :key="index"
									v-bind:class="{active: currentTab === index}"
									v-on:click="currentTab = index">{{ tab }}</div>			
				<!-- </div>	 -->
			</footer>
		</section>

		<section class="mt-2 d-flex justify-content-center">
			<div class="tab-content">
				<div v-show="currentTab==0">
					<ProfileInfo
						:user_data="this.user_data"
					/>
				</div>
				<div v-show="currentTab==1">
					<ProfileFeed/>
				</div>
				<div v-show="currentTab==2">
					<ProfileHistory/>
				</div>
			</div>
		</section>

		

	</div>
</template>

<script>
import axios from "axios";
// import FollowModal from '@/components/user/FollowModal.vue'
import ProfileFeed from '@/components/user/Profilefeed.vue'
import ProfileHistory from '@/components/user/Profilehistory.vue'
import ProfileInfo from '@/components/user/ProfileInfo.vue'

// const SERVER_URL = `http://i6e102.p.ssafy.io`
const SERVER_URL = "http://localhost:8080";

export default {
	name: "Profile",
	props: {
		userEmail: {
			type:String
		},

	},
	data() {
		return {
			// userId: Number(this.$route.params.user_id), // 현재 유저넘버
			my_data: this.$store.state.userList,
			myId: this.$store.state.myNum, // 로그인한 유저넘버
			myEmail: this.$store.state.userEmail,
			user_data: {},
			userId: "", // 보고있는 프로필 넘버
			currentTab: 0,
			tabs: ['Profile', 'FEED', 'History'],

			followingModal:false, //모달
      followerModal:false, //모달
			followersList: [], // userId 팔로워 리스트
			followingsList: [], // userId 팔로잉 리스트
			myFollowings: [], // myId 팔로잉리스트
			myFollowers: [], // myId 팔로워리스트
			followShow: false,
      followShow2: false,


		}
	},
	components: {
		// FollowModal,
		ProfileFeed,
		ProfileHistory,
		ProfileInfo,
	},

	created: function () {
		console.log("보고있는 프로필",this.$route.params.userEmail) 
		console.log("로그인",this.myEmail)
		console.log(this.myId)
		// console.log("데이터",this.user_data)
		// console.log("세부", this.user_data.campEquipTent)
		// 보고있는 이메일
		this.user_email = this.$route.params.userEmail // 이메일에서 바꿔야함 유저넘버로
		this.getProfile() // 유저 정보 가져오기

	},

	methods : {
		getProfile: function() {
			axios
				.get(`${SERVER_URL}/user/${this.user_email}`)
				.then(res => {
					// 여기서 불러온 아이디 넘버 가져오기
					console.log(res.data)
					this.user_data = res.data
					console.log("유저정보",this.user_data)
				})
				.catch(() => {
					alert("프로필을 가져올 수 없습니다.")
				})
		},
		// follow: function () {
		// 	const credentials = {
		// 		from_id: this.myId,
		// 		to_id: this.userId,
		// 	}
		// 	axios.post(`${SERVER_URL}/follow`, credentials)
		// 	.then((res) => {
		// 		console.log(res)
		// 		this.myFollowings.push(userId)
		// 		if (this.userId == )

		// 	})
		// },
	


		moveToModify: function () {
      this.$router.push({ name: "Modify" });
    },
		
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
		margin-left: 50px;
    margin-right: 50px; 
		justify-content: center;
    font-size: 1.2rem;
    font-family: 'Roboto',sans-serif; 
    align-items: center;
    font-weight: 300;
    text-align: center;
}
.instagram-container .image-footer div{
    text-decoration: none;
    color: rgb(90, 90, 90);
}
.instagram-container .post {
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


</style>