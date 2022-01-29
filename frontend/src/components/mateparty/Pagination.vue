<template>
  <div class="overflow-auto">


    <b-row :per-page="perPage" :current-page="currentPage"> 
      <b-card-group class ="col-lg-4 col-sm-6" v-for="(item,idx) in paginatedItems" :key="idx"  >
        
        <b-card class="mb-5" :title="item.mateTitle" img-src='https://cdn.pixabay.com/photo/2015/02/02/11/08/office-620817_960_720.jpg' img-alt="Image" img-top>
          <b-card-text >
            <div align="left">
              {{item.mateCampstyle}}
            </div>
            <div align="left">
              {{item.mateCampsite}}
            </div>
            <div align="left">
              {{item.userNo}}
            </div>
          </b-card-text>
          <template #footer>
            <small class="text-muted">Last updated 3 mins ago</small>
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
      filterItems : this.filterlist,
      items : this.matelists,
      paginatedItems: '',
      totalRows: this.matelists.length,
      perPage: 6,
      currentPage: 1,
  

    }
  },
  methods: {
    
    paginate (page_size, page_number) {
        
        let itemsToParse = this.items
        this.paginatedItems = itemsToParse.slice(page_number * page_size, (page_number + 1) * page_size);
    },
    onPageChanged() {
      
      this.paginate(this.perPage, this.currentPage - 1)
    },

  },
  mounted(){
    
    if (this.matelists) {
      this.paginate(this.perPage, 0)
    }
  },

  
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