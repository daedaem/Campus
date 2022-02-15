<template>
  <div>
    <label for="fileName">이미지 선택</label>
    <input ref="image" type="file" id="fileName" accept="image/*" @change="setProfileImg" style="opacity: 0">
    <div class="image-box">
      <div v-if="image" class="img-box2">
        <img :src="image" style="height:300px; width : 100%;" alt="">
      </div>
      <div v-else class="img-box2">
        <img for="fileName" style="height: 250px; width:100%" src="https://cdn.pixabay.com/photo/2021/10/11/00/59/upload-6699084_960_720.png" alt="">
      </div>
    </div>
  </div>
</template>

<script>
// import axios from 'axios'

export default {
  data() {
    return {
      image : ''
    }
  },
  methods: {
    setProfileImg() {
      var frm = new FormData()
      var photoFile = document.getElementById('fileName')
      console.log(photoFile)
      console.log(photoFile.files[0])

      frm.append('fileName', photoFile.files[0])

      this.$emit('image',frm)
      
      var image = this.$refs["image"].files[0];
      
      const url = URL.createObjectURL(image);
      console.log(url);
      this.image = url;
      

    }   
  }
}
</script>


<style scoped>
.label-box{
  object-fit: cover;
}
.image-box{
  overflow: hidden;
  margin: 0 auto;
}
.img-box2{
  object-fit: cover;

}
/* .input-box {
  overflow: hidden;
} */
</style>