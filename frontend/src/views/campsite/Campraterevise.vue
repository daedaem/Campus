<template>
  
  
  <body>
    <div class="registration-form container">
        <div class="row">
        <form>
            <div class="page">
  <div class="page__demo">
    <div class="page__group">
      <div class="rating">
        <span style="color:black; font-size:20px;">청결 평가</span><input type="radio" name="rating-star" class="rating__control screen-reader" id="rc1" value="1" v-model="campRateDto.campRateCleanliness">
        <input type="radio" name="rating-star" class="rating__control screen-reader" id="rc2" value="2" v-model="campRateDto.campRateCleanliness">
        <input type="radio" name="rating-star" class="rating__control screen-reader" id="rc3" value="3" v-model="campRateDto.campRateCleanliness">
        <input type="radio" name="rating-star" class="rating__control screen-reader" id="rc4" value="4" v-model="campRateDto.campRateCleanliness">
        <input type="radio" name="rating-star" class="rating__control screen-reader" id="rc5" value="5" v-model="campRateDto.campRateCleanliness">
        <label for="rc1" class="rating__item">
          <svg class="rating__star">
            <use xlink:href="#star"></use>
          </svg>
          <span class="screen-reader">1</span>
        </label>
        <label for="rc2" class="rating__item">
          <svg class="rating__star">
            <use xlink:href="#star"></use>
          </svg>
          <span class="screen-reader">2</span>
        </label>
        <label for="rc3" class="rating__item">
          <svg class="rating__star">
            <use xlink:href="#star"></use>
          </svg>
          <span class="screen-reader">3</span>
        </label>
        <label for="rc4" class="rating__item">
          <svg class="rating__star">
            <use xlink:href="#star"></use>
          </svg>
          <span class="screen-reader">4</span>
        </label>
        <label for="rc5" class="rating__item">
          <svg class="rating__star">
            <use xlink:href="#star"></use>
          </svg>
          <span class="screen-reader">5</span>
        </label>	
      </div>

    </div>
    <div class="page__group">  
      <div class="rating">
        <span style="color:black; font-size:20px;">시설 평가</span><input type="radio" name="rating-star2" class="rating__control screen-reader" id="rc6" value="1" v-model="campRateDto.campRatePrice">
        <input type="radio" name="rating-star2" class="rating__control screen-reader" id="rc7" value="2" v-model="campRateDto.campRatePrice">
        <input type="radio" name="rating-star2" class="rating__control screen-reader" id="rc8" value="3" v-model="campRateDto.campRatePrice">
        <input type="radio" name="rating-star2" class="rating__control screen-reader" id="rc9" value="4" v-model="campRateDto.campRatePrice">
        <input type="radio" name="rating-star2" class="rating__control screen-reader" id="rc10" value="5" v-model="campRateDto.campRatePrice">
        <label for="rc6" class="rating__item">
          <svg class="rating__star">
            <use xlink:href="#star"></use>
          </svg>
          <span class="screen-reader">1</span>
        </label>
        <label for="rc7" class="rating__item">
          <svg class="rating__star">
            <use xlink:href="#star"></use>
          </svg>
          <span class="screen-reader">2</span>
        </label>
        <label for="rc8" class="rating__item">
          <svg class="rating__star">
            <use xlink:href="#star"></use>
          </svg>
          <span class="screen-reader">3</span>
        </label>
        <label for="rc9" class="rating__item">
          <svg class="rating__star">
            <use xlink:href="#star"></use>
          </svg>
          <span class="screen-reader">4</span>
        </label>
        <label for="rc10" class="rating__item">
          <svg class="rating__star">
            <use xlink:href="#star"></use>
          </svg>
          <span class="screen-reader">5</span>
        </label>	
      </div>    

    </div>

    <div class="page__group">  
      <div class="rating">
        <span style="color:black; font-size:20px;">가격 평가</span><input type="radio" name="rating-star3" class="rating__control screen-reader" id="rc11" value="1" v-model="campRateDto.campRateFacility">
        <input type="radio" name="rating-star3" class="rating__control screen-reader" id="rc12" value="2" v-model="campRateDto.campRateFacility">
        <input type="radio" name="rating-star3" class="rating__control screen-reader" id="rc13" value="3" v-model="campRateDto.campRateFacility">
        <input type="radio" name="rating-star3" class="rating__control screen-reader" id="rc14" value="4" v-model="campRateDto.campRateFacility">
        <input type="radio" name="rating-star3" class="rating__control screen-reader" id="rc15" value="5" v-model="campRateDto.campRateFacility">
        <label for="rc11" class="rating__item">
          <svg class="rating__star">
            <use xlink:href="#star"></use>
          </svg>
          <span class="screen-reader">1</span>
        </label>
        <label for="rc12" class="rating__item">
          <svg class="rating__star">
            <use xlink:href="#star"></use>
          </svg>
          <span class="screen-reader">2</span>
        </label>
        <label for="rc13" class="rating__item">
          <svg class="rating__star">
            <use xlink:href="#star"></use>
          </svg>
          <span class="screen-reader">3</span>
        </label>
        <label for="rc14" class="rating__item">
          <svg class="rating__star">
            <use xlink:href="#star"></use>
          </svg>
          <span class="screen-reader">4</span>
        </label>
        <label for="rc15" class="rating__item">
          <svg class="rating__star">
            <use xlink:href="#star"></use>
          </svg>
          <span class="screen-reader">5</span>
        </label>	
      </div>    

    </div>
  </div>
</div>
<svg xmlns="http://www.w3.org/2000/svg" style="display: none">
  <symbol id="star" viewBox="0 0 26 28">
    <path d="M26 10.109c0 .281-.203.547-.406.75l-5.672 5.531 1.344 7.812c.016.109.016.203.016.313 0 .406-.187.781-.641.781a1.27 1.27 0 0 1-.625-.187L13 21.422l-7.016 3.687c-.203.109-.406.187-.625.187-.453 0-.656-.375-.656-.781 0-.109.016-.203.031-.313l1.344-7.812L.39 10.859c-.187-.203-.391-.469-.391-.75 0-.469.484-.656.875-.719l7.844-1.141 3.516-7.109c.141-.297.406-.641.766-.641s.625.344.766.641l3.516 7.109 7.844 1.141c.375.063.875.25.875.719z"/>
  </symbol>
</svg>

          
            <div class="form-group" style="margin-top:80px;">
              <h4>후기 제목</h4>
                <input type="text" class="form-control item" id="username" placeholder="Username" v-model="campRateDto.campRateTitle">
            </div>
            <div class="form-group" style="margin-top:40px;">
              <h4>내용</h4>
                <textarea
                  v-model="campRateDto.campRateContent"
                  name="txtMsg"
                  class="form-control item"
                  placeholder="Your Message *"
                  style="width: 100%; min-height: 250px"
                ></textarea>
                
            </div>
            
            <div class="form-group" align="center">
                <button type="button" class="btn btn-block create-account" @click="send">Create Review</button>
            </div>
        </form>
        
        </div>
    </div>


</body>
</template>

<script>
import axios from 'axios'
import {ref} from 'vue'
import {useStore} from 'vuex'
import {useRoute,useRouter} from 'vue-router'

const SERVER_URL = process.env.VUE_APP_SERVER_URL;
export default {
  name: "Campraterevise",
  setup() {
    const route = useRoute()
    const router = useRouter()
    const store = useStore()
    const campRateDto = ref({
      campRateCleanliness: null,
      campRatePrice: null,
      campRateFacility: null,
      userNo: store.state.myNum,
      campRateContent: null,
      campRateTitle: null,
      contentId: "10",
    });

    const send = () => {
      console.log(campRateDto.value);
      let form = new FormData();
      form.append("campRateCleanliness", campRateDto.value.campRateCleanliness);
      form.append("campRatePrice", campRateDto.value.campRatePrice);
      form.append("campRateFacility", campRateDto.value.campRateFacility);
      // form.append("userNo",campRateDto.value.userNo)
      form.append("campRateNo", route.params.rateNo);
      form.append("campRateContent", campRateDto.value.campRateContent);
      form.append("campRateTitle", campRateDto.value.campRateTitle);
      form.append("contentId", campRateDto.value.contentId);
      axios({
        method: "put",
        url: `${SERVER_URL}/camp/rate`,
        headers: { "content-type": "application/json" },
        data: form,
      })
      .then(res => {
        console.log(res)
        router.push({ name : 'Campsitedetail', params : { contentId : campRateDto.value.contentId}})
      })
      .catch(err => {
        console.log(err)
      })
    }

    return {
      campRateDto,
      send,
    };
  },
};
</script>

<style scoped>
body{
  background-color: #dee9ff;
  width: 768px;
  margin: 0 auto;
  padding: 0 20px;
}

.registration-form{
	padding: 50px 0;
}

.registration-form form{
    background-color: #fff;
    max-width: 600px;
    margin: auto;
    padding: 50px 70px;
    border-top-left-radius: 30px;
    border-top-right-radius: 30px;
    box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.075);
}

.registration-form .form-icon{
	text-align: center;
    background-color: #5891ff;
    border-radius: 50%;
    font-size: 40px;
    color: white;
    width: 100px;
    height: 100px;
    margin: auto;
    margin-bottom: 50px;
    line-height: 100px;
}

.registration-form .item{
	border-radius: 20px;
    margin-bottom: 25px;
    padding: 10px 20px;
}

.registration-form .create-account{
    border-radius: 30px;
    padding: 10px 20px;
    font-size: 18px;
    font-weight: bold;
    background-color: #5791ff;
    border: none;
    color: white;
    margin-top: 20px;
}

.registration-form .social-media{
    max-width: 600px;
    background-color: #fff;
    margin: auto;
    padding: 35px 0;
    text-align: center;
    border-bottom-left-radius: 30px;
    border-bottom-right-radius: 30px;
    color: #9fadca;
    border-top: 1px solid #dee9ff;
    box-shadow: 0px 2px 10px rgba(0, 0, 0, 0.075);
}

.registration-form .social-icons{
    margin-top: 30px;
    margin-bottom: 16px;
}

.registration-form .social-icons a{
    font-size: 23px;
    margin: 0 3px;
    color: #5691ff;
    border: 1px solid;
    border-radius: 50%;
    width: 45px;
    display: inline-block;
    height: 45px;
    text-align: center;
    background-color: #fff;
    line-height: 45px;
}

.registration-form .social-icons a:hover{
    text-decoration: none;
    opacity: 0.6;
}

@media (max-width: 576px) {
    .registration-form form{
        padding: 50px 20px;
    }

    .registration-form .form-icon{
        width: 70px;
        height: 70px;
        font-size: 30px;
        line-height: 70px;
    }
}



/*
=====
DEPENDENCES
=====
*/

.screen-reader{
  width: var(--screenReaderWidth, 1px) !important;
  height: var(--screenReaderHeight, 1px) !important;
  padding: var(--screenReaderPadding, 0) !important;
  border: var(--screenReaderBorder, none) !important;

  position: var(--screenReaderPosition, absolute) !important;
  clip: var(--screenReaderClip, rect(1px, 1px, 1px, 1px)) !important;
  overflow: var(--screenReaderOverflow, hidden) !important;
}

/*
=====
CORE STYLES
=====
*/

.rating{
  --uiRatingColor: var(--ratingColor, #eee);
  --uiRatingColorActive: var(--ratingColorActive, #ffcc00);

  display: var(--ratingDisplay, flex);
  font-size: var(--ratingSize, 1rem);
  color: var(--uiRatingColor);
}
    
.rating__control:nth-of-type(1):focus ~ .rating__item:nth-of-type(1)::before,
.rating__control:nth-of-type(2):focus ~ .rating__item:nth-of-type(2)::before,
.rating__control:nth-of-type(3):focus ~ .rating__item:nth-of-type(3)::before,
.rating__control:nth-of-type(4):focus ~ .rating__item:nth-of-type(4)::before,
.rating__control:nth-of-type(5):focus ~ .rating__item:nth-of-type(5)::before{
  content: ""; 
  box-shadow: 0 0 0 var(--ratingOutlineWidth, 4px) var(--uiRatingColorActive);

  position: absolute;
  top: -.15em;
  right: 0;
  bottom: -.15em;
  left: 0;
  z-index: -1;
}

.rating__item{
  cursor: pointer;  
  position: relative;
}

.rating__item{
  padding-left: .25em;
  padding-right: .25em;
}

.rating__star{
  display: block;
  width: 1em;
  height: 1em;

  fill: currentColor;
  stroke: var(--ratingStroke, #222);
  stroke-width: var(--ratingStrokeWidth, 1px);
}

.rating:hover,
.rating__control:nth-of-type(1):checked ~ .rating__item:nth-of-type(1),
.rating__control:nth-of-type(2):checked ~ .rating__item:nth-of-type(-n+2),
.rating__control:nth-of-type(3):checked ~ .rating__item:nth-of-type(-n+3),
.rating__control:nth-of-type(4):checked ~ .rating__item:nth-of-type(-n+4),
.rating__control:nth-of-type(5):checked ~ .rating__item:nth-of-type(-n+5){
  color: var(--uiRatingColorActive);
}

.rating__item:hover ~ .rating__item{
  color: var(--uiRatingColor);
}

/*
=====
SETTINGS
=====
*/

.rating{
  --ratingSize: 2rem;
  --ratingColor: #eee;
  --ratingColorActive: #ffcc00;
}

/*
=====
DEMO
=====
*/



.page{

}

.page__demo{

}

.page__group{
  margin-top: 2rem;
  margin-bottom: 2rem;

}

.page__hint{
  display: block;
  font-weight: 700;
  margin-top: 1rem;
}

@media (min-width: 641px){
  .page__demo{

  }

  .page__group{
    margin-left: 3.5rem;
    margin-right: 3.5rem;
  }
}



</style>
