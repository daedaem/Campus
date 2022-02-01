<template>
  <div class="container mt-5 d-flex justify-content-center">
    <div class="card p-4 m-3">
        <div class="first">
  
            <div class="time d-flex flex-row align-items-center justify-content-between mt-3">
                <div class="d-flex align-items-center"> <i class="fa fa-clock-o clock"></i>  </div>
                <div> <span class="font-weight-bold">동행</span> </div>
            </div>
        </div>
        <div class="second d-flex flex-row mt-2">
            <div class="image mr-3"><i class="bi bi-person-circle fa-3x"></i> </div>
            <div class="">
                <div class="d-flex flex-row mb-1">
                    <div class="ratings ml-2"> <i class="fa fa-star"></i> <i class="fa fa-star"></i> <i class="fa fa-star"></i> <i class="fa fa-star"></i> <i class="fa fa-star"></i> </div>
                </div>
                <div> #능동 #INTP #뭐시기 </div>
            </div>
        </div>
        <hr class="line-color">
        
    </div>
    <div class="card p-4 m-3">
        <div class="first">
  
            <div class="time d-flex flex-row align-items-center justify-content-between mt-3">
                <div class="d-flex align-items-center"> <i class="fa fa-clock-o clock"></i> <span class="hour ml-1">☆☆☆☆☆</span> </div>
                <div> <span class="font-weight-bold">동행</span> </div>
            </div>
        </div>
        <div class="second d-flex flex-row mt-2">
            <div class="image mr-3"> <img src="https://i.imgur.com/0LKZQYM.jpg" class="rounded-circle" width="60" /> </div>
            <div class="">
                <div class="d-flex flex-row mb-1"> <span>@hairtaje</span>
                    <div class="ratings ml-2"> <i class="fa fa-star"></i> <i class="fa fa-star"></i> <i class="fa fa-star"></i> <i class="fa fa-star"></i> <i class="fa fa-star"></i> </div>
                </div>
                <div> #능동 #INTP #뭐시기 </div>
            </div>
        </div>
        <hr class="line-color">
        
    </div>
    
  </div>

</template>

<script>
export default {
  name : 'Members',
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Roboto&display=swap');

body {
    background-color: #eee;
    font-family: 'Roboto', sans-serif
}

.card {
    /* background-color: #B9F6CA; */
    width: 300px;
    border-radius: 20px
}

.heading {
    font-weight: 700
}

.hour {
    margin-top: 1px;
    color: green;
    font-size: 12px
}

.ratings i {
    color: #388E3C
}

.btn {
    border-radius: 15px !important
}

.line-color {
    color: green;
    height: 3px
}
</style>