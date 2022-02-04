<template>
	<div class="mt-3">
		<input 
			class="input-box"
			type="text"
			v-model="newEquip"
			v-on:keyup.enter="createEquip"
			placeholder="장비 입력">
		<span class="addContainer" v-on:click="createEquip">
        <i class="far fa-plus-square addBtn"></i>
    </span>
	</div>
</template>

<script>

export default {
	name: 'equip_input',
	data: function() {
		return {
			newEquip: ""
		}
	},
	methods: {
		createEquip: function () {
			const equipItem = {
				equipname: this.newEquip
			}
			if (equipItem.equipname) {
				this.$store.dispatch('createEquip', equipItem)
			}
			this.newEquip = null

		}
	}
}
</script>

<style scoped>
.input-box {
	width: 90%;
}
.addContainer {
  float: right;
  background: linear-gradient(to right, green, yellow);
  display: block;
  width: 10%;
  border-radius: 0 5px 5px 0;
	height: 28px;
}
.addBtn {
  vertical-align: middle;
}

</style>