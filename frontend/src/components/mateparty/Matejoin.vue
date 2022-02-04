<template>
  <div>
    <div>
    <b-button
      :class="visible ? null : 'collapsed'"
      :aria-expanded="visible ? 'true' : 'false'"
      aria-controls="collapse-4"
      @click="visible = !visible"
    >
      Toggle Collapse
    </b-button>
    <b-collapse id="collapse-4" v-model="visible" class="mt-2">
      <b-card><div style="float:center">
      <input type="text" v-model="friendnum"><button @click="join">메이트 참가</button>
    </div></b-card>
    </b-collapse>
    </div>
  </div>
</template>

<script>
export default {
  name : 'Matejoin',
  data() {
    return {
      visible : false,
      abc : this.$store.state.userList,
      bcd : this.$store.state.mateList
    }
  },
  created(){
    console.log(this.abc)
    console.log(this.bcd)
  }

}
</script>

<style>

</style>