<template>
  <div>
          <div class="container contact-form" >
        <div class="row">
            <div >
              평점1<input type="number" v-model="campRateDto.campRateCleanliness">
              평점2<input type="number" v-model="campRateDto.campRatePrice">
              평점3<input type="number" v-model="campRateDto.campRateFacility">
                <p align="left">제목</p>
                <div class="form-group">
                    <input v-model="campRateDto.campRateTitle" type="text" name="txtName" class="form-control" placeholder="Your Name *" />
                </div>
            </div>
            <div >
                <p align="left">내용</p>
                <div class="form-group">
                    <textarea v-model="campRateDto.campRateContent" name="txtMsg" class="form-control" placeholder="Your Message *" style="width: 100%; height: 150px;"></textarea>
                </div>
            </div>
            
            <div class="form-group">
                <input type="submit" name="btnSubmit" class="btnContact" value="Send Message" @click="send"  />
            </div>
        </div>
      </div>
  </div>
</template>

<script>
import axios from 'axios'
import {ref} from 'vue'
import {useStore} from 'vuex'

// const SERVER_URL = `http://i6e102.p.ssafy.io`
const SERVER_URL = 'http://localhost:8080'
// import qs from 'query-string'

export default {
  name : 'Campsitereview',
  
  setup() {
    const store = useStore()
    const campRateDto = ref({
      campRateCleanliness : null,
      campRatePrice :null,
      campRateFacility : null,
      userNo : store.state.myNum,
      campRateContent : null,
      campRateTitle : null,
      contentId : '10',
    })

    const send = () => {
      console.log(campRateDto.value)
      let form = new FormData()
      form.append("campRateCleanliness",campRateDto.value.campRateCleanliness)
      form.append("campRatePrice",campRateDto.value.campRatePrice)
      form.append("campRateFacility",campRateDto.value.campRateFacility)
      form.append("userNo",campRateDto.value.userNo)
      form.append("campRateContent",campRateDto.value.campRateContent)
      form.append("campRateTitle",campRateDto.value.campRateTitle)
      form.append("contentId",campRateDto.value.contentId)
      axios({
        method : 'POST',
        url : `${SERVER_URL}/camp/rate`,
        headers : {'content-type' : 'application/json'}, 
        data : form
      })
      .then(res => {
        console.log(res)
      })
      .catch(err => {
        console.log(err)
      })
    }

    return {
      send,
      campRateDto,

    }
  }
}

</script>

<style>

</style>