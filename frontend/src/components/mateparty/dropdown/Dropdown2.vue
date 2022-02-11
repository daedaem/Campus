<template>
  <div>
    <h4>연령 제한</h4>
      <input list="age1" placeholder="캠핑장 " v-model="ageValue1">
        <datalist id="age1">
          <option v-for="option in 20" :key="option" :value="option"></option>
          <!-- <option value="Internet Explorer"></option>
          <option value="Firefox"></option>
          <option value="Chrome"></option>
          <option value="Opera"></option>
          <option value="Safari"></option> -->
        </datalist>  
          ~ 
      <input list="age2" placeholder="캠핑장 " v-model="ageValue2">
        <datalist id="age2">
          <option v-for="option in 20" :key="option" :value="option" ></option>
          <!-- <option value="Internet Explorer"></option>
          <option value="Firefox"></option>
          <option value="Chrome"></option>
          <option value="Opera"></option>
          <option value="Safari"></option> -->
        </datalist>  
  </div>
</template>

<script>
export default {
  name : 'Dropdown2',
  data() {
    return {
    ageValue1 : '',
    ageValue2 : '',
    }
  },
  watch : {
    ageValue1(text) {
      this.$emit('age-value1', text)
    },
    ageValue2(text) {
      this.$emit('age-value2',text)
    }
  }
}

</script>

<style>

</style>