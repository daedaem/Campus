<template>
  <div class="overflow-auto">

    
    <b-row :per-page="perPage" :current-page="currentPage"> 
      <b-card-group class ="col-md-4 col-sm-6 col-xs-12" v-for="(item,idx) in paginatedItems" :key="idx"  >
        
        <b-card class="mb-5" :title="item.mateTitle" :img-src='item.mateImageUrl' img-alt="Image" img-top @click ="this.$router.push({name: 'Partyinfo', params: { mateNo : item.mateNo }})">
          <b-card-text >
            <div align="left" v-if="item.campStyleList" >
              <span>{{'#'+item.campStyleList.style1}}</span><span>{{'#'+item.campStyleList.style2}}</span><span>{{'#'+item.campStyleList.style3}}</span>
            </div>
            <div align="left">
              {{item.mateCampsite}}
            </div>
            <div align="right">
              {{item.userNickName}}
            </div>
          </b-card-text>
          <template #footer>
            <small class="text-muted">{{item.mateUpdateTime}}</small>
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
import {mapState} from 'vuex'

export default {
  props : {
      matelists : Array,
      filterlist : Array,
    },
  name : 'Pagination',
  components : {
    
  },
  data() {
    return {
    
     
      paginatedItems: '',
      totalRows: this.matelists.length,
      perPage: 6,
      currentPage: 1,
  

    }
  },
  methods: {
    
    paginate (page_size, page_number) {
        console.log(this.matelists)
        let itemsToParse = this.matelists
        this.paginatedItems = itemsToParse.slice(page_number * page_size, (page_number + 1) * page_size);
       
    },
    onPageChanged() {
      console.log(2)
      this.paginate(this.perPage, this.currentPage - 1)
    },


  },
  mounted(){
   
    if (this.matelists) {
      this.paginate(this.perPage, 0)
    }
  },

  watch : {
    matelists : {
      handler() {
        this.paginate(this.perPage, 0)
      },
      deep : true
    },
    
  },

  computed : {
    ...mapState['mateList'],
    // filterItems() {
    //   return this.paginatedItems.filter(item => {return item.})
    // }
  }
  
  
  // computed: {
  //   filterItems() {
  //     return this.items.filter(item => )
  //   }

  // },
  // filterSearch() {
  //      return this.products
  //                 .filter(product => product.topic.toLowerCase().match(this.search.toLowerCase()))
  //                 .filter(product => product.price < checkbox.Value)
  //   } 

}
</script>

<style>

</style>