<template>
	<div>
		정보수정
	</div>
</template>

<script>
import axios from "axios";

const SERVER_URL = process.env.VUE_APP_SERVER_URL

export default {
	name: "ModifyUser",
	data() {
		return {
			step:1,
			credentials: {
				email: "", // 이메일
				nickname: "", // 닉네임
				password: "", // 패스워드
				password_confirmation: "", // 패스워드확인 
				image: "", // 이미지
				user_gender: "", // 성별
				user_area: "", // 지역
				user_age: "", // 나이

				// 보유장비
				imgStatus : {
					lantern : 0,
					powerstrip : 0,
					burner : 0,
					icebox : 0,
					chair : 0,
					sleepingbag : 0,
					tarp : 0,
					table : 0,
					tent : 0,
					brazier : 0,
				},
				styleStatus : {
					food : 0,
					talk : 0,
					campfire: 0,
					climb : 0,
					photo : 0,
					music : 0,
				}
			},
		}
	},

	created: function () {
		this.getProfile()
	},
	methods: {
		getProfile: function() {
			const token = localStorage.getItem('jwt')
			axios({
				method: 'get',
				url: `${SERVER_URL}/user/${this.user}`,
				headers: {Authorization: `JWT ${token}`},
			})
			.then(res => {
				this.credentials.email = res.data.email
				this.credentials.nickname = res.data.nickname
				this.credentials.password = res.data.password
				this.credentials.password_confirmation = res.data.password_confirmation
				this.credentials.image = res.data.image
				this.credentials.user_gender = res.data.user_gender
				this.credentials.user_area = res.data.user_area
				this.credentials.user_age = res.data.user_age
			})
			.catch((err) => {
				console.log(err)
			})
		}
	}
}
</script>

<style>

</style>