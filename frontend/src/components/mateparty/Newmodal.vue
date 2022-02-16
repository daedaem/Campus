<template>
<div clas="d-flex">
<div class="wrapper">
  <div class="navbar">
    <i class="fas fa-home icon-home"></i>
    <i class="fas fa-cog icon-settings" style="margin-right:70px"></i>
    <i class="fas fa-cog icon-settings"></i>
    <i class="fas fa-cog icon-settings"></i>


    <div class="circle">
      <i class="fas fa-plus plus-icon"></i>
      <i class="fab fa-youtube social" style="margin-top:5px;"></i>
      <i class="fab fa-twitter social"  style="margin-top:5px;"></i>
      
    
    </div>
    <div class="circleBackground"></div>
  </div>
</div>
</div>
<!-- </div> -->
</template>


<script >


const tabs = document.querySelectorAll('.tab');

tabs.forEach(clickedTab =>{
	clickedTab.addEventListener('click', () =>{
		tabs.forEach(tab => {
			tab.classList.remove('active');
		});
		clickedTab.classList.add('active');
	});
});

export default {
  name : 'Newmodal',
  components : {
    // Modal2,
  }

}
</script>

<style lang="scss" scoped>

$navbar-height: 80px;
$circle-radius: 80px;
$backgroundColor: rgb(253, 192, 223);

html,
body {
  padding: 0;
  margin: 0;
  height: 100%;
  width: 100%;
}

* {
  box-sizing: border-box;
}

.wrapper {
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: $backgroundColor;
}

.navbar {
  // position: relative;
  position: fixed;
  bottom : 0px;
  left:0vw;
  height: $navbar-height;
  // min-width: 300px;
  width:100%;
  padding-left: 35px;
  padding-right: 35px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  border-radius: 25px;
  background-color: white;
  box-shadow: 0 10px 20px rgba(82, 74, 74, 0.3);
  z-index : 10001;
}

.navbar:after {
  content: "";
  position: absolute;
  bottom: 7px;
  height: 4px;
  width: 35%;
  left: 50%;
  transform: translateX(-50%);
  background-color: gray;
  opacity: 0.3;
}

.circle {
  position: absolute;
  left: 50%;
  transform: translateX(-50%);
  bottom: calc(105px - #{$circle-radius / 2});
  margin-bottom: -50px;
  height: 55px;
  width: 60px;
  border-radius: 40px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  overflow: hidden;
  background-color: rgb(255, 94, 0);
  z-index: 9;
  box-shadow: 0 5px 5px rgba(255, 147, 85, 0.35);
  transition: height 0.3s;
}

.circle:hover {
  height: 140px;
  border-radius: 50px;
}

.circle .plus-icon {
  color: white;
  font-size: 27px;
  transition: opacity 0.3s, transform 0.2s;
}

.circle:hover .plus-icon {
  transform: rotate(360deg);
  opacity: 0;
}

.circle .social {
  position: absolute;
  top: 195px;
  color: white;
  background-color: rgba(255, 212, 212, 0.308);
  height: 50px;
  width: 50px;
  margin-bottom: 5px;
  border-radius: 50%;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 25px;
  cursor: pointer;
}

.circle .social:nth-child(2) {
  opacity: 0;
  transition: opacity 0.3s, top 0.5s ease;
}

.circle .social:nth-child(3) {
  opacity: 0;
  transition: opacity 0.3s, top 0.5s 0.1s ease;
}

.circle .social:nth-child(4) {
  opacity: 0;
  transition: opacity 0.3s, top 0.5s 0.22s ease;
  margin-bottom: 0px;
}

.circle:hover .social:nth-child(2) {
  opacity: 1;
  top: 5px;
}

.circle:hover .social:nth-child(3) {
  opacity: 1;
  top: calc(5px + 60px + 5px);
}

.circle:hover .social:nth-child(4) {
  opacity: 1;
  top: calc(5px + 60px + 5px + 60px + 5px);
}

.circleBackground {
  position: absolute;
  left: 50%;
  transform: translateX(-50%);
  bottom: calc(100px - #{$circle-radius + 20} / 2);
  margin-bottom: 0;
  // height: calc(#{$circle-radius} + 20px);
  // width: calc(#{$circle-radius} + 20px);
  border-radius: calc(#{$circle-radius + 20} / 2);
  background-color: $backgroundColor;
}

.icon-home,
.icon-settings {
  font-size: 29px;
  color: $backgroundColor;
}

</style>