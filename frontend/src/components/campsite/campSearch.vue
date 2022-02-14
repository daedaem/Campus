<template>
	<div>
		<input
      class="Searchbar-inputBox"
      @input="async"
      @keyup.enter="SearchData()"
      placeholder=""
    />
	</div>
</template>

<script>
import axios from 'axios';
const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {
	name: 'campSearch',
	data() {
    return { inputData: "", temp: [], searchResults: [] };
  },
	methods: {
		async(e) {
			this.inputData = e.target.value;
		},
		getdo: function () {
			axios
				.get(`${SERVER_URL}/camp/do`)
				.then((res) => {
					console.log("확인",res)
				})
		},
		getsi: function () {
			axios
				.get(`${SERVER_URL}/camp/sigungu/강원도`)
				.then((res) => {
					console.log("캠핑장", res)
				})
		},
		SearchData() {
			if (this.inputData) {
				this.inputData = this.inputData.trim();

				if (this.inputData.trim().length < 2) {
					alert("글자수가 너무 작습니다.")
				} else {
					console.log(3)
					axios({
						method: 'get',
						url: `${SERVER_URL}/camp`,
						params: {
							doNm: '강원도',
							sigunguNm: '춘천시',
						}
					})
						.then((res)=> {
							console.log("확인", res.data)
						})
				}
			}
		}
	},
	created: function () {
		this.getdo()
		this.getsi()
	}
}
</script>

<style>
.Searchbar-inputBox {
  min-width: 100px;
  max-width: 150px;
  height: 40px;
  background: transparent;
  border: transparent;
  border-bottom: 1px solid black;
}
</style>