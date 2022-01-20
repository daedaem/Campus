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
    const options = reactive([0, 1, 2])
    return {
      value,
      options,
    }
  },
  components: {
    VueSelect,
  }

}
</script>

<style>

</style>