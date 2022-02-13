<template>
  <div  >
    <label for="fileName" class="join-profile-img-edit" >
      <input ref="image" type="file" id="fileName" accept="image/*" @change="setProfileImg" style="opacity: 0">
      <div style="width : 500px; overflow:hidden; ">
        <div v-if="image" style="height:250px; width : 100%;">
          <img :src="image" alt="" class="aa" >
        </div>
        <div v-else style="height:250px; width : 100%;">
          <img src="https://cdn.pixabay.com/photo/2021/10/11/00/59/upload-6699084_960_720.png" alt="" style="margin-left:100px;">
        </div>
      </div>
    </label>
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


<style >
#fileName {

}

.join-profile-img-edit{
 
}

.aa{
  width :100%;
  height:100%;
}

img {
 max-width: 100%;
 max-height: 100%;
}
</style>