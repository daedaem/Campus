<template>
  <body>
    
    <Fileupload @image="uploadedImage"/>
    
      <div style="margin-left: 30px;">
        <Filtermake @drink-check="drinkCheck" @style-check="styleCheck" @limit-check="limitCheck" @camp-check="campCheck" />

        <div align="left" class="filterbox">
          <div align="left" class="filterbox2">
            <Dropdown1 @member-value="memberValue"/>
          </div>
          <div align="left" class="filterbox1">
            <Dropdown2 @age-value1="ageValue1" @age-value2="ageValue2"/>
        </div>
        
      </div>
      
      <Campchoice align="left" style="margin-top:50px; margin-bottom:20px;"/>
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
                  <input v-model="title" type="text" name="txtName" class="form-control" placeholder="Your Name *" />
              </div>
          </div>
          <div >
              <p align="left">메이트 소개</p>
              <div class="form-group">
                  <textarea v-model="content" name="txtMsg" class="form-control" placeholder="Your Message *" style="width: 100%; height: 150px;"></textarea>
              </div>
          </div>
          
          <div class="form-group">
              <input type="submit" name="btnSubmit" class="btnContact" value="Send Message" />
          </div>
      </div>
    </div>
    
  </body>
  
  
</template>

<script>
import Filtermake from '@/components/mateparty/Filtermake.vue'
import Dropdown1 from '../../components/mateparty/dropdown/Dropdown1.vue'
import Dropdown2 from '../../components/mateparty/dropdown/Dropdown2.vue'
import Items from '@/components/mateparty/Items.vue'
import Campchoice from '@/components/mateparty/Campchoice.vue'
import Fileupload from '@/components/mateparty/Fileupload.vue'
export default {
  name: 'Makeparty',
  components : {
    Items,
    Filtermake,
    Dropdown1,
    Dropdown2,
    Campchoice,
    Fileupload,
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
    drinkCheck(text) {
      console.log(text)
    },
    styleCheck(text) {
      console.log(text)
    },
    limitCheck(text) {
      console.log(text)
    },
    campCheck(text) {
      console.log(text)
    },
    memberValue(text) {
      console.log(text)
    },
    ageValue1(text) {
      console.log(text)
    },
    ageValue2(text) {
      console.log(text)
    },
    imgStatus(text) {
      console.log(text)
    },
    uploadedImage(file) {
      console.log(file)
    }

  },
  data: function() {
    return {
        title : '',
        content : ''
      }
  }  
 }  

</script>

<style scoped>
body {
  width: 768px;
  margin: 0 auto;
  padding: 0 20px;
  /* background: beige; */
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