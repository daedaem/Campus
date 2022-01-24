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
    const options = reactive(['서울', '부산', '대구', '인천', '광주', '대전', '울산', '세종', '경기', '강원', '충북', '충남', '전북', '전남', '경북', '경남', '제주'])
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