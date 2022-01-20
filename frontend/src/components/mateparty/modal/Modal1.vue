<template>
  <Datepicker v-model="date1" range></Datepicker>
  123
</template>


<script>
import Datepicker from 'vue3-date-time-picker';
import 'vue3-date-time-picker/dist/main.css'
import { ref, onMounted } from 'vue';


export default {
  name: 'Modal1',
  components: {
    Datepicker,
  },
  setup() {
        const date = ref();

        // For demo purposes assign range from the current date
        onMounted(() => {
            const startDate = new Date();
            const endDate = new Date(new Date().setDate(startDate.getDate() + 7));
            date.value = [startDate, endDate];
        })
        
        return {
            date,
        }
    }
}
</script>

<style>

</style>