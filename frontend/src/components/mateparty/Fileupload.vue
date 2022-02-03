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
      console.log(1)
      var frm = new FormData()
      var merong = new FormData()
      var photoFile = document.getElementById('fileName')
      console.log(photoFile.files[0])
      frm.append('fileName', photoFile.files[0])
      console.log(merong)
      console.log(2)
      console.log(frm)
      merong.append('key1', 'value1');
      merong.append('key2', 'value2');
      frm.append('key1', 'value1');
      frm.append('key2', 'value2');
      console.log(merong.keys())
      for (let key of merong.keys()) {
        console.log(key);
      }

      // FormData의 value 확인
      for (let value of merong.values()) {
        console.log(value);
      }
      for (let key of frm.keys()) {
        console.log(key);
      }

      // FormData의 value 확인
      for (let value of frm.values()) {
        console.log(value);
      }
      
      this.$emit('image',frm)
      
      
    }   
  }
}
</script>


<style >

</style>