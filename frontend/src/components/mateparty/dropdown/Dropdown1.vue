<template>
  <div>
      <h4>인원 제한</h4>
      <input class="form-control item" list="member" placeholder="인원 제한 " v-model="memberValue">
  <datalist id="member">
    <option v-for="option in 20" :key="option" :value="option"></option>
  </datalist>  
  </div>
</template>

<script>
export default {
  name : 'Dropdown1',
  methods : {
    
  },
  data() {
    return {
      memberValue : ''
    }
  },

  watch : {
    memberValue(text) {
      this.$emit('member-value',text)
    },
  }
}

</script>

<style>

</style>