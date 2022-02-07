<template>
  <div class="test">
    <body>
      
      <Fileupload @image="uploadedImage"/>
      
        <div style="margin-left: 30px;">
          <Filtermake @style-check="styleCheck" @limit-check="limitCheck" @camp-check="campCheck" />

          <div align="left" class="filterbox">
            <div align="left" class="filterbox2">
              <Dropdown1 @member-value="memberValue"/>
            </div>
            <div align="left" class="filterbox1">
              <Dropdown2 @age-value1="ageValue1" @age-value2="ageValue2"/>
          </div>
          
        </div>
        
        <Campchoice align="left" style="margin-top:50px; margin-bottom:20px;" @camp-data="campValue"/>
        <Datepicker @date-in="dateIn"/>
      <!-- <div class="camping">
        <input class="input1" type="text" placeholder="캠핑장 선택">
      </div> -->
      </div>
      <br>
      <Items @img-status="imgStatus"/> 
      
      
      <div class="container contact-form" >
        <div class="row">
            <div >
                <p align="left">제목</p>
                <div class="form-group">
                    <input v-model="partyData.mateTitle" type="text" name="txtName" class="form-control" placeholder="Your Name *" />
                </div>
            </div>
            <div >
                <p align="left">메이트 소개</p>
                <div class="form-group">
                    <textarea v-model="partyData.mateContent" name="txtMsg" class="form-control" placeholder="Your Message *" style="width: 100%; height: 150px;"></textarea>
                </div>
            </div>
            
            <div class="form-group">
                <input type="submit" name="btnSubmit" class="btnContact" value="Send Message" @click="test"  />
            </div>
        </div>
      </div>
      
      
    </body>
  </div>
  
</template>

<script>
import Filtermake from '@/components/mateparty/Filtermake.vue'
import Dropdown1 from '../../components/mateparty/dropdown/Dropdown1.vue'
import Dropdown2 from '../../components/mateparty/dropdown/Dropdown2.vue'
import Items from '@/components/mateparty/Items.vue'
import Campchoice from '@/components/mateparty/Campchoice.vue'
import Fileupload from '@/components/mateparty/Fileupload.vue'
import Datepicker from '@/components/mateparty/Datepicker.vue'
import axios from 'axios'

const SERVER_URL = `http://i6e102.p.ssafy.io`
// const SERVER_URL = `localhost:8080`
export default {
  name: 'Makeparty',
  components : {
    Items,
    Filtermake,
    Dropdown1,
    Dropdown2,
    Campchoice,
    Fileupload,
    Datepicker,
  },
  data: function() {
    return {
        partyData : {
          friendlimit : null,
          campStyleList : null,
          memberlimit : null,
          lowestAge : null,
          highestAge : null,
          campingsite : null,
          mateCampstart : null,
          mateCampend : null,
          mateCamptype: null,
          campEquipRequiredList : null,

          mateTitle : null,
          mateContent: null,
        },
        mateImageUrl : null,
      }
  },
  created () {
    console.log(this.$store.state.userList)
    console.log(this.$store.state.mateList)
  },
  methods: {
  //image upload and preview methods
    selectImage () {
      this.$refs.fileInput.click()
    },
    pickFile () {
      let input = this.$refs.fileInput
      let file = input.files
      if (file && file[0]) {
        let reader = new FileReader
        reader.onload = e => {
          this.previewImage = e.target.result
        }
        reader.readAsDataURL(file[0])
        this.$emit('input', file[0])
      }
    },
    
    styleCheck(text) {
      const temp = {
        style1 : null,
        style2 : null,
        style3 : null,

      }

      if (text.length === 1) {
        temp.style1 = text[0]
      } else if (text.length === 2) {
        temp.style1 = text[0], temp.style2 = text[1]
      } else if (text.length === 3) {
        temp.style1 = text[0], temp.style2 = text[1], temp.style3 = text[2]
      }
      this.partyData.campStyleList = temp
    },
    
    limitCheck(text) {
      this.partyData.friendlimit = Number(text)
    },
    campCheck(text) {
      this.partyData.mateCamptype = text[0]
    },
    memberValue(text) {
      this.partyData.memberlimit = Number(text)
    },
    ageValue1(text) {
      this.partyData.lowestAge = Number(text)
    },
    ageValue2(text) {
      this.partyData.highestAge = Number(text)
    },
    imgStatus(text) {
      this.partyData.campEquipRequiredList = text
    },  
    campValue(text) {
      this.paryDaa.campingsite = text
    },
    uploadedImage(file) {
      
      this.mateImageUrl = file
      console.log(this.mateImageUrl)
    },
    dateIn(value) {
      console.log(value)
        
      if (value[0].toString().substring(4,7) === 'Jan') {
        var startMonth = '01'
      }
      if (value[0].toString().substring(4,7) === 'Feb') {
        startMonth = '02'
      } else if (value[0].toString().substring(4,7) === 'Feb') {
        startMonth = '02'
      } else if (value[0].toString().substring(4,7) === 'Mar') {
        startMonth = '03'
      } else if (value[0].toString().substring(4,7) === 'Apr') {
        startMonth = '04'
      } else if (value[0].toString().substring(4,7) === 'May') {
        startMonth = '05'
      } else if (value[0].toString().substring(4,7) === 'Jun') {
        startMonth = '06'
      } else if (value[0].toString().substring(4,7) === 'Jul') {
        startMonth = '07'
      } else if (value[0].toString().substring(4,7) === 'Aug') {
        startMonth = '08'
      } else if (value[0].toString().substring(4,7) === 'Sep') {
        startMonth = '09'
      } else if (value[0].toString().substring(4,7) === 'Oct') {
        startMonth = '10'
      } else if (value[0].toString().substring(4,7) === 'Nov') {
        startMonth = '11'
      } else if (value[0].toString().substring(4,7) === 'Dec') {
        startMonth = '12'
      }

      if (value[1].toString().substring(4,7) === 'Jan') {
        var endMonth = '01'
      }
      if (value[1].toString().substring(4,7) === 'Feb') {
        endMonth = '02'
      } else if (value[1].toString().substring(4,7) === 'Mar') {
        endMonth = '03'
      } else if (value[1].toString().substring(4,7) === 'Apr') {
        endMonth = '04'
      } else if (value[1].toString().substring(4,7) === 'May') {
        endMonth = '05'
      } else if (value[1].toString().substring(4,7) === 'Jun') {
        endMonth = '06'
      } else if (value[1].toString().substring(4,7) === 'Jul') {
        endMonth = '07'
      } else if (value[1].toString().substring(4,7) === 'Aug') {
        endMonth = '08'
      } else if (value[1].toString().substring(4,7) === 'Sep') {
        endMonth = '09'
      } else if (value[1].toString().substring(4,7) === 'Oct') {
        endMonth = '10'
      } else if (value[1].toString().substring(4,7) === 'Nov') {
        endMonth = '11'
      } else if (value[1].toString().substring(4,7) === 'Dec') {
        endMonth = '12'
      }
      const startYear = value[0].toString().substring(11,15)
      const startDay = value[0].toString().substring(8,10)
      const mateCampstart = (startYear+'-'+startMonth+'-'+startDay)

      const endYear = value[1].toString().substring(11,15)
      const endDay = value[1].toString().substring(8,10)
      const mateCampend = endYear+'-'+endMonth+'-'+endDay

      this.partyData.mateCampstart = mateCampstart
      this.partyData.mateCampend = mateCampend
    },
    

    test() {
      // console.log(this.partyData)
      console.log(2)
      axios({
        method: 'post',
        
        url : `${SERVER_URL}/mate`,
        data : this.partyData,
  
      })
      .then((res) => {
        // console.log(res.dada.dto.mateNo)
        console.log(res.data.dto.mateNo)
        console.log(this.mateImageUrl)
        if (this.mateImageUrl) {
        axios({
        method: 'post',
        headers: { 'Content-Type': 'multipart/form-data' },
        url : `${SERVER_URL}/mate/${res.data.dto.mateNo}`,
        data : this.mateImageUrl
        
        })
        .then(res => {
          console.log(res)
         
          
        })
        .catch(err => {
          console.log(err)
        })
        } 
     
        setTimeout(()=> {this.$router.push({name:'Mateparty'})},1000)
        
      })

      .catch(err => {
        console.log(err)
      })
      

    
      
    }
    
    

  },
  
  
 }  





</script>

<style scoped>
body {
  /* width: 768px; */
  width :768px;
  margin: 0 auto;
  padding: 0 20px;
  background: beige;
}

.test {
  width :100%;
}

.imagePreviewWrapper {
  background-repeat: no-repeat;
    width: 200px;
    height: 125px;
    display: block;
    cursor: pointer;
    margin: 0 auto 30px;
    background-size: contain;
    background-position: center center;
}

.filterbox {
  overflow: hidden;
}

.filterbox1 {
  float: left;
  margin-left: 50px;
  margin-right: 20px;
}
.filterbox2 {
  float: left;
} 

.input1 {
  float: left;
  width: 250px;
  height: 32px;
  font-size: 15px;
  border: 2;
  /* border-br: red; */
  border-radius: 15px;
  outline: none;
  padding-left: 10px;
  background-color: rgb(224, 224, 224);
}

.contact-form{
    background: #fff;
    margin-top: 10%;
    margin-bottom: 5%;
    width: 100%;
}
.contact-form .form-control{
    border-radius:1rem;
}
.contact-image{
    text-align: center;
}
.contact-image img{
    border-radius: 6rem;
    width: 11%;
    margin-top: -3%;
    transform: rotate(29deg);
}
.contact-form form{
    padding: 14%;
}
.contact-form form .row{
    margin-bottom: -7%;
}
.contact-form h3{
    margin-bottom: 8%;
    margin-top: -10%;
    text-align: center;
    color: #0062cc;
}
.contact-form .btnContact {
    width: 50%;
    border: none;
    border-radius: 1rem;
    padding: 1.5%;
    background: #dc3545;
    font-weight: 600;
    color: #fff;
    cursor: pointer;
}
.btnContactSubmit
{
    width: 50%;
    border-radius: 1rem;
    padding: 1.5%;
    color: #fff;
    background-color: #0062cc;
    border: none;
    cursor: pointer;
}

.camping {
  overflow: hidden;
  margin-top: 100px;
  margin-bottom: 40px;
}


</style>