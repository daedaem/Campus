<template>
  <div>
          <div class="container contact-form" >
        <div class="row">
            <!-- <div >
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
            </div> -->
            
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
// import {useStore} from 'vuex'

// const SERVER_URL = `http://i6e102.p.ssafy.io`
// const SERVER_URL = 'http://localhost:8080'


export default {
  name : 'Campsitereview',
  setup() {
    // const store = useStore()
    const campRateDto = ref({
      campRateCleanliness : 3,
      campRatePrice :2,
      campRateFacility : 1,
      userNo : 27,
      campRateContent : '뷰내용',
      campRateTitle : '뷰제목',
      contentId : '10',
    })
    // campRateDto.value.userNo = 

    const send = () => {
        console.log(campRateDto.value)
        axios({
          method : 'POST',
          url : "http://localhost:8080/camp/rate",
          headers:{'content-type': 'application/json'},
          data : campRateDto.value
        })
        .then(res => {
          console.log(res)
        })
        .catch(err =>{
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