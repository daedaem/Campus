<template>
  
      <input list="age1" placeholder="최소 나이 " v-model="ageValue1" class="left" >
        <datalist id="age1">
          <option v-for="option in 20" :key="option" :value="option"></option>
        </datalist>  
      <input list="age2" placeholder="최고 나이" v-model="ageValue2" class="right">
        <datalist id="age2">
          <option v-for="option in 20" :key="option" :value="option" ></option>
        </datalist>  

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

.left {
  /* border-top-left-radius: 20; */
  border-radius : 20px;
  width:7rem;
  border: 1px solid #ced4da;

  text-align: center;
}

.right {
  border-radius: 20px;
  width:7rem;
  margin-left:5px;
  border: 1px solid #ced4da;

  text-align: center;
}
</style>