<template>
    


  <div class="container mt-5 d-flex justify-content-center">
    <div class="card p-4 m-3 col-6" v-for="(item,idx) in member" :key="idx">
        <div class="first">
  
            <div class="time d-flex flex-row align-items-center justify-content-between mt-3">
                <div class="d-flex align-items-center"> <i class="fa fa-clock-o clock"></i>  </div>
                <!-- <div> <span class="font-weight-bold">동행</span> </div> -->
            </div>
        </div>
        <div class="second d-flex flex-row mt-2">
            <div class="image mr-3"><i class="bi bi-person-circle fa-3x"></i> </div>
            <div class="">
                <div class="d-flex flex-row mb-1">
                    <div class="star-ratings">
                        <div 
                        class="star-ratings-fill space-x-2 text-lg"
                        :style="{ width: item.userRatePoint*20+1.5 + '%' }"
                        >
                            <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                        </div>
                        <div class="star-ratings-base space-x-2 text-lg">
                            <span>★</span><span>★</span><span>★</span><span>★</span><span>★</span>
                        </div>
                    </div>
                </div>
                <span v-for="(style,idx2) in stylelist2[idx]" :key="idx2">
                    {{'#'+style}}
                </span>
            </div>
        </div>
        <hr class="line-color">
    </div>
    
    
    
  </div>

</template>

<script>
import {ref} from 'vue'


export default {
  name : 'Members',
  props : ['mateDetail'],
  
  components : {

  },
  setup(props) {
    
    
    const member = ref(props.mateDetail.mateList)
    const stylelist2 = []
    

    member.value.forEach(element => {
        const stylelist = []
        if (element.campStyle1 === 'Y') {
            stylelist.push('요식')
        } 
        if (element.campStyle2 === 'Y') {
            stylelist.push('불멍')
        } 
        if (element.campStyle3 === 'Y') {
            stylelist.push('캠파')
        } 
        if (element.campStyle4 === 'Y') {
            stylelist.push('등산')
        } 
        if (element.campStyle5 === 'Y') {
            stylelist.push('사진')
        } 
        if (element.campStyle6 === 'Y') {
            stylelist.push('노래')
        }
        
        stylelist2.push(stylelist)
    });
    
    
    const ratingToPercent = () => {
        const score = +this.restaurant.averageScore * 20;
        return score + 1.5;
    }
    


      return {
          member,
          stylelist2,
          ratingToPercent,
          
          
      }
  }
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


.star-ratings {
  color: #aaa9a9; 
  position: relative;
  unicode-bidi: bidi-override;
  width: max-content;
  -webkit-text-fill-color: transparent; /* Will override color (regardless of order) */
  -webkit-text-stroke-width: 1.3px;
  -webkit-text-stroke-color: #2b2a29;
}
 
.star-ratings-fill {
  color: #fff58c;
  padding: 0;
  position: absolute;
  z-index: 1;
  display: flex;
  top: 0;
  left: 0;
  overflow: hidden;
  -webkit-text-fill-color: gold;
}
 
.star-ratings-base {
  z-index: 0;
  padding: 0;
}
</style>