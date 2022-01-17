<template>
  <body>
    <h1>Mate party</h1>
    <div class="filterbox">
      <div class="filterbox1">1</div>
      <div class="filterbox2">2</div>
      <div class="filterbox3">3</div>
    </div>
  </body>
</template>

<script>
export default {
  name : 
    'Mateparty'
  ,
}
</script>

<style scoped>
body {
  width: 768px;
  margin: 0 auto;
  padding: 0 20px;
  background: beige;
}

.filterbox {
  display: flex;
}
.filterbox1 {
  float: left;
  background: red;
}
.filterbox2 {
  float: left;
  background: blue;
}
.filterbox3 {
  float: left;
  background: green;
}
</style>