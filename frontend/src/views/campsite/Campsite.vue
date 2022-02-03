<template>
  <div>
    
    <div class="container mt-5 mb-5">
    <div class="d-flex justify-content-center row">
        <div class="col-md-10">
          
            <div class="row p-2 bg-white border rounded mt-2" v-for="(item,idx) in articles" :key="idx">
              {{item}}
                <div class="col-md-3 mt-1"><img class="img-fluid img-responsive rounded product-image" :src="item.firstImageUrl"></div>
                <div class="col-md-6 mt-1">
                    <h5>{{item.facltNm}}</h5>
                    <div class="d-flex flex-row">
                        <div class="ratings mr-2"><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i><i class="fa fa-star"></i></div>
                    </div>
                    <div class="mt-1 mb-1 spec-1">{{item.addr1}}</div>
                    <div class="mt-1 mb-1 spec-1">{{item.lineIntro}}</div>
                    <p class="text-justify text-truncate para mb-0">There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable.<br><br></p>
                </div>
                <div class="align-items-center align-content-center col-md-3 border-left mt-1">
                    <div class="d-flex flex-row align-items-center">
                        <h4 class="mr-1">$13.99</h4><span class="strike-text">$20.99</span>
                    </div>
                    <h6 class="text-success">Free shipping</h6>
                    <div class="d-flex flex-column mt-4"><button class="btn btn-primary btn-sm" type="button">Details</button><button class="btn btn-outline-primary btn-sm mt-2" type="button">Add to wishlist</button></div>
                </div>
                <!-- {{item}} -->
            </div>
            
        </div>
    </div>
</div>


  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'Campsite',
  data () {
    return {
      articles: [],
      limit : 10,
      offset : 0,
    }
  },
  methods : {
    getDatas() {
      axios({
      methods: 'get',
      url : 'http://localhost:8080/camp',
      params : {
        limit :this.limit,
        offset : this.offset,
        searchWord : '',
        doNm : '',
      }
    })
    .then(res => {
      this.articles.push(...res.data.list)
      console.log(this.articles)
    })

    .catch(err =>{
      console.log(err)
    })
    }
  },
  mounted() {
    this.getDatas()
    window.addEventListener("scroll",() =>{
      let scrollTop = document.documentElement.scrollTop
      let scrollHeight = document.documentElement.scrollHeight
      let clientHeight = document.documentElement.clientHeight

      if (scrollTop+clientHeight>=scrollHeight-10) {
        this.offset += 10
        // this.limit += 10
        this.getDatas()
      
      }
    })
  }
}
</script>

<style>

</style>