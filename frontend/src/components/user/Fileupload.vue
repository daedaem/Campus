<template>
  <div>
    <div v-if="image.length === 0" align="center">
      <label for="fileName">
        <svg
          xmlns="http://www.w3.org/2000/svg"
          width="100%"
          height="250px"
          fill="currentColor"
          class="bi bi-images"
          viewBox="0 0 16 16"
        >
          <path d="M4.502 9a1.5 1.5 0 1 0 0-3 1.5 1.5 0 0 0 0 3z" />
          <path
            d="M14.002 13a2 2 0 0 1-2 2h-10a2 2 0 0 1-2-2V5A2 2 0 0 1 2 3a2 2 0 0 1 2-2h10a2 2 0 0 1 2 2v8a2 2 0 0 1-1.998 2zM14 2H4a1 1 0 0 0-1 1h9.002a2 2 0 0 1 2 2v7A1 1 0 0 0 15 11V3a1 1 0 0 0-1-1zM2.002 4a1 1 0 0 0-1 1v8l2.646-2.354a.5.5 0 0 1 .63-.062l2.66 1.773 3.71-3.71a.5.5 0 0 1 .577-.094l1.777 1.947V5a1 1 0 0 0-1-1h-10z"
          />
        </svg></label>
    </div>
    <input ref="image" type="file" id="fileName" accept="image/*" @change="setProfileImg" style="opacity: 0">
    <div class="image-box">
      <div v-if="image" class="img-box2">
        <img :src="image" style="height:300px; width : 100%;" alt="">
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