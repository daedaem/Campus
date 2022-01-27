<template>
  <vue-select
      v-model="value"
      :options="options"
      close-on-select
    ></vue-select>
    
</template>

<script>
import { reactive, ref,  } from 'vue'
import VueSelect from 'vue-next-select'
import 'vue-next-select/dist/index.min.css'

export default {
    name: 'Dropdown',
    setup() {
    const value = ref(0)
    const options = reactive(['10대','20대','30대','40대','50대','60대','70대','80대','90대'])
    return {
      value,
      options,
    }
  },
  components: {
    VueSelect,
  },

}
</script>

<style>

</style>