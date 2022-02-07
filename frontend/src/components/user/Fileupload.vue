<template>
  <div>
    <label for="fileName" class="join-profile-img-edit">
      <input type="file" id="fileName" accept="image/*" @change="setProfileImg">
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
      
      
    }   
  }
}
</script>


<style >

</style>