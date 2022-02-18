<template>
  <div>
     <Datepicker v-model="date" range />
  </div>
</template>

<script>
import Datepicker from 'vue3-date-time-picker';
import 'vue3-date-time-picker/dist/main.css'
import { ref, onMounted, watch} from 'vue';

export default {
  components: { Datepicker },
  // watch : {
  //   date: {
  //     handler(val) {
  //       const selectedDate = val
  //       console.log
  //       this.$emit('date-in',selectedDate)
  //       }
  //     },
  //     deep : true,
  //   },
  emits : ['date-in'],
  setup(props,{emit}) {
      const date = ref();
      
      // For demo purposes assign range from the current date
      onMounted(() => {
          const startDate = new Date();
          const endDate = new Date(new Date().setDate(startDate.getDate() + 7));
          date.value = [startDate, endDate];
          
      })

      const sendChange = (event) => {
        emit('date-in', event.target.value)
      }

      watch(date, (value) => {
        emit('date-in', value)
      })



      // watch(
      //   () => date
      // )
      
  


    
      
      return {
          date,
          sendChange
      }

  
  }
}
</script>

<style>

</style>