<template>
  <div class="overflow-auto">
    <b-row :per-page="perPage" :current-page="currentPage"> 
      <b-card-group class ="col-md-4 col-sm-6 col-xs-12 " v-for="(item,idx) in paginatedItems" :key="idx" >
        
        <b-card title-variant="card_title" class="mb-5 test" :title="item.mateTitle" :img-src='item.mateImageUrl' img-alt="Image" img-top @click ="this.$router.push({name: 'Partyinfo', params: { mateNo : item.mateNo }})" >
          <b-card-text >
            <div align="left" v-if="item.campStyleList" >
              <span v-if="item.campStyleList.style1">{{'#'+item.campStyleList.style1}}</span><span v-if="item.campStyleList.style2">{{' #'+item.campStyleList.style2}}</span><span v-if="item.campStyleList.style3">{{' #'+item.campStyleList.style3}}</span>
            </div>
            <div align="left">
              {{item.mateCampsite}}
            </div>
            <div align="right">
              {{item.userNickName}}
            </div>
          </b-card-text>
          <template #footer>
            <small class="text-muted" >{{item.mateUpdateTime}}</small>
          </template>
        </b-card>
      
      </b-card-group>
    </b-row>
      <b-pagination
      align="center"
      @click="onPageChanged"
      v-model="currentPage"
      :total-rows="totalRows"
      :per-page="perPage"
      aria-controls="my-table"
      ></b-pagination>


  </div>

</template>

<script>

// import axios from "axios";
// const SERVER_URL = process.env.VUE_APP_SERVER_URL;

export default {
  props : {

      newFilter : Array,
 
    },
  name : 'Pagination',
  components : {
    
  },
  data() {
    return {
      paginatedItems: '',
      totalRows: this.newFilter.length,
      perPage: 6,
      currentPage: 1,
    }
  },
  methods: {
    
    
    paginate (page_size, page_number) {
        
        let itemsToParse = this.newFilter
        this.paginatedItems = itemsToParse.slice(page_number * page_size, (page_number + 1) * page_size);
        console.log(this.paginatedItems)
       
    },
    onPageChanged() {
      console.log(2)
      this.paginate(this.perPage, this.currentPage - 1)
    },


  },
  created(){
    if (this.newFilter) {
      this.paginate(this.perPage, 0)
    }
  },

  watch : {
    newFilter : {
      handler() {
        
        this.paginate(this.perPage, 0)
      },
      deep : true
    },
    
  },

  computed : {
 
  },
  

}
</script>

<style>
.card-group > .test{
  /* background-color :red; */
  border-radius: 20px;
  font-size: 12px;
  word-break:break-all;
  text-overflow: ellipsis;
  overflow: hidden;
  white-space: nowrap;
  width:100%;
  /* background-color:#fdf4f4;; */
}
.card-img-top {
  height: 150px;
  /* border-color: red; */
}

.card-group .test img{
  border-top-left-radius:20px;
  border-top-right-radius:20px;

}

.card-group .test .card-body {
  /* background-color: #fff6ec; */
  
}
.card-group .test .card-footer {
  /* background-color: #fffcf8;; */
}

h4 {
  font-size : 5px;
}
img{
  /* border-radius :40px; */
}

.card-title{
  font-size: 18px;
  height:43.19px;
  display: block;
  color: black;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: normal;
  line-height: 1.2;
/*        height: 4.8em;*/
  text-align: left;
  word-wrap: break-word;
  display: -webkit-box;
  -webkit-line-clamp: 2 ;
  -webkit-box-orient: vertical;

}

.card-text{
  display: block;
  color: black;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: normal;
/*        height: 4.8em;*/
  text-align: left;
  word-wrap: break-word;
  display: -webkit-box;
  -webkit-line-clamp: 2 ;
  -webkit-box-orient: vertical;
}

.card-footer{
  text-align:center;
}

.page-item > .page-link{
  color : #7ac4e1;
}
.test{
  
}

@media (max-width: 576px) {
  .card-group > .test{
  border-radius: 20px;
  font-size: 15px;
  word-break:break-all;
  text-overflow: ellipsis;
  overflow: hidden;
  white-space: nowrap;
  width:100%;
  height :550px;
  }
  .card-img-top {
  height: 350px;
  /* border-color: red; */
  }
  .card-title{
  font-size: 24px;
  height:50px;
  display: block;
  color: black;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: normal;
  line-height: 1.2;
/*        height: 4.8em;*/
  text-align: left;
  word-wrap: break-word;
  display: -webkit-box;
  -webkit-line-clamp: 2 ;
  -webkit-box-orient: vertical;

  }
}
</style>