<template>
  <body>
    
    <div class="App container mt-5">
    <div class="mb-3">
      <input style="display:none" class="form-control" ref="fileInput" type="file" @input="pickFile">
      </div>
        
       <div class="imagePreviewWrapper" :style="{ 'background-image': `url(${previewImage})` }" @click="selectImage"><font-awesome-icon :icon="['fas','images']" size="10x"/></div>
    </div>
    <Filtermake/>


    <div align="left">
      <div align="left" class="filterbox2">인원 제한
      <Dropdown/>
      </div>
      <div align="left" class="filterbox1">연령 제한
        <Dropdown />
        
        <div align="center">~</div>
        <Dropdown/>
      </div>
    </div>
    <!-- <div v-if="choose === 0" @click="imgsel">
    <img width="200" height="200" src="../../assets/images/icebox3.png" alt="qwsdfd">
    </div>
    <div v-else @click="imgsel">
    <img width="200" height="200" src="../../assets/images/bear.png" alt="qwsdfd">
    </div> -->
    <div class="col-md-12">
                               <input class="form-control" type="text" name="name" placeholder="Full Name" required>
  </body>
  
  
</template>

<script>
import Filtermake from '@/components/mateparty/Filtermake.vue'
import Dropdown from '../../components/mateparty/Dropdown.vue'
export default {
  name: 'Makeparty',
  components : {
    Filtermake,
    Dropdown
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
    // imgsel() {
    //   if (this.choose === 0) {
    //     this.choose += 1
    //   } else {
    //     this.choose = 0
    //   }
    // }

  },
  data: function() {
    return {
     previewImage: null,
     choose : 0
  }  
}
}
</script>

<style scoped>
body {
  width: 768px;
  margin: 0 auto;
  padding: 0 20px;
  background: beige;
}
.imagePreviewWrapper {
  background-repeat: no-repeat;
    width: 250px;
    height: 250px;
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
</style>