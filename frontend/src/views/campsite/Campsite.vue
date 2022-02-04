<template>
<body>
  

  <div>
    
    <div class="container mt-5 mb-5">
    <div class="d-flex justify-content-center row">
        <div class="col-md-10">
          
            <div class="row p-2 bg-white border rounded mt-2" v-for="(item,idx) in articles" :key="idx" >
              <!-- {{item}} -->
                <div class="col-md-3 mt-1"><img class="img-fluid img-responsive rounded product-image" :src="item.firstImageUrl" style="height:80%;"></div>
                <div class="col-md-6 mt-1">
                    <h5>{{item.facltNm}}</h5>
                    <div class="d-flex flex-row">
                        <div class="ratings mr-2"><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i></div>
                    </div>
                    <div class="mt-1 mb-1 spec-1">{{item.addr1}}</div>
                    <div class="mt-1 mb-1 spec-1">{{item.lineIntro}}</div>
                    <!-- <p class="text-justify text-truncate para mb-0">There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable.<br><br></p> -->
                </div>
                <div class="align-items-center align-content-center col-md-3 border-left mt-1">
                    <div class="d-flex flex-row align-items-center">
                        <h4 class="mr-1">후기</h4>
                    </div>
                    <h6 class="text-success">찜?</h6>
                    <div class="d-flex flex-column mt-4" >
                      <button class="btn btn-primary btn-sm" type="button" style="font-size:12px;"><i class="bi bi-telephone-fill"></i> {{item.tel}}</button>
                      <button class="btn btn-outline-primary btn-sm mt-2" type="button" v-if="item.resveUrl != null">예약사이트</button>
                      <button class="btn btn-outline-primary btn-sm mt-2" type="button" v-else>전화예약문의</button>
                    </div>
                </div>
                <!-- {{item}} -->
            </div>
            
        </div>
    </div>
    
</div>

    
  </div>
  </body>
</template>

<script>
import axios from 'axios'
import {ref, onMounted} from 'vue'
// import {useRouter} from 'vue-router'

export default {
  name: 'Campsite',
  setup() {
    // const router = useRouter()
    const articles = ref([])
    const limit = ref(10)
    const offset = ref(0)
    // const goDetail = () => { router.push({name: 'Campsitedetail', params: {}})}
    const getDatas = () => {

      axios({
      methods: 'get',
      url : 'http://localhost:8080/camp',
      params : {
        limit :limit.value,
        offset : offset.value,
        // searchWord : '',
        // doNm : '',
      }
      })
      .then(res => {
        articles.value.push(...res.data.list)
        
        console.log(articles.value)
      })

      .catch(err =>{
        console.log(err)
      })
      }
   
    onMounted(() => {
      getDatas()
      window.addEventListener("scroll",() =>{
        let scrollTop = document.documentElement.scrollTop
        let scrollHeight = document.documentElement.scrollHeight
        let clientHeight = document.documentElement.clientHeight

        if (scrollTop+clientHeight>=scrollHeight-10) {
          offset.value += 10
          // this.limit += 10
          getDatas()
        
        }
        })
    })
    

    return {
      articles,
      limit,
      offset,
      getDatas,
    }
  }
  // data () {
  //   return {
  //     articles: [],
  //     limit : 10,
  //     offset : 0,
  //   }
  // },
  // methods : {
  //   getDatas() {
  //     axios({
  //     methods: 'get',
  //     url : 'http://localhost:8080/camp',
  //     params : {
  //       limit :this.limit,
  //       offset : this.offset,
  //       // searchWord : '',
  //       // doNm : '',
  //     }
  //   })
  //   .then(res => {
  //     this.articles.push(...res.data.list)
  //     console.log(this.articles)
  //   })

  //   .catch(err =>{
  //     console.log(err)
  //   })
  //   }
  // },
  // mounted() {
  //   this.getDatas()
  //   window.addEventListener("scroll",() =>{
  //     let scrollTop = document.documentElement.scrollTop
  //     let scrollHeight = document.documentElement.scrollHeight
  //     let clientHeight = document.documentElement.clientHeight

  //     if (scrollTop+clientHeight>=scrollHeight-10) {
  //       this.offset += 10
  //       // this.limit += 10
  //       this.getDatas()
      
  //     }
  //   })
  // }
}
</script>

<style scoped>
@media (min-width: 768px) {
  body {
    width: 768px;
    margin: 0 auto;
    padding: 0 20px;
    background: beige; }
  }

.ratings i {
    font-size: 16px;
    color: red
}

.strike-text {
    color: red;
    text-decoration: line-through
}

.product-image {
    width: 100%
}

.dot {
    height: 7px;
    width: 7px;
    margin-left: 6px;
    margin-right: 6px;
    margin-top: 3px;
    background-color: blue;
    border-radius: 50%;
    display: inline-block
}

.spec-1 {
    color: #938787;
    font-size: 15px
}

h5 {
    font-weight: 400
}

.para {
    font-size: 16px
}
</style>