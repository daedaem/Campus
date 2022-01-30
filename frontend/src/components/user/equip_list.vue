<template>
	<div>
		<ul>
			<li v-for="equipList in $store.state.equipLists" 
				v-bind:key="equipList">
				{{ equipList.equipname }}
				<span class="removeBtn" v-on:click="deleteEquip(equipList, index)">
          <i class="fas fa-trash-alt"></i>
        </span>
			</li>
		</ul>
	</div>
</template>

<script>
import { mapState } from 'vuex'

export default {
	name: 'equip_list',
	computed: {
		...mapState([
			'equipLists'
		])
	},
	methods: {
		deleteEquip: function () {
			this.$store.dispatch('deleteEquip', this.equipLists)
		}
	}

}
</script>

<style scoped>
ul {
  list-style-type: none;
  padding-left: 0;
  margin-top: 0;
  text-align: left;
}
li {
  display: flex;
  min-height: 50px;
  height: 50px;
  line-height: 50px;
  margin: 0.5rem 0;
  padding: 0 0.9rem;
  background: white;
	border-style: solid;
  border-color: green;
  border-radius: 45px;
  border-radius: 5px;
}
.removeBtn {
  margin-left: auto;
  color: grey;
}
</style>