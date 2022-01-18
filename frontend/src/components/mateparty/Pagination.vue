<template>
  <div class="overflow-auto">


    <p class="mt-3">Current Page: {{ currentPage }}</p>

    <b-row :per-page="perPage" :current-page="currentPage"> 
      <b-card-group class ="col-4" v-for="(item,idx) in paginatedItems" :key="idx" >
        <b-card class="mb-5" :title="item.first_name" :img-src="item.imgurl" img-alt="Image" img-top>
          <b-card-text>
            {{item.last_name}}
          </b-card-text>
          <template #footer>
            <small class="text-muted">Last updated 3 mins ago</small>
          </template>
        </b-card>
      
      </b-card-group>
    </b-row>

    <nav aria-label="Page navigation example">
      <ul class="pagination">
        <li class="page-item">
          <a class="page-link" href="#" aria-label="Previous">
            <span aria-hidden="true">&laquo;</span>
          </a>
        </li>
        <li class="page-item"><a class="page-link" href="#">1</a></li>
        <li class="page-item"><a class="page-link" href="#">2</a></li>
        <li class="page-item"><a class="page-link" href="#">3</a></li>
        <li class="page-item">
          <a class="page-link" href="#" aria-label="Next">
            <span aria-hidden="true">&raquo;</span>
          </a>
        </li>
      </ul>
    </nav>
  </div>
    <v-pagination
    v-model="page"
    :pages="10"
    :range-size="1"
    active-color="#DCEDFF"
    @update:modelValue="updateHandler"
    />
</template>

<script>
import VPagination from "@hennge/vue3-pagination";

const items = [
          { id: 1, first_name: 'Fred', last_name: 'Flintstone', imgurl: 'https://cdn.pixabay.com/photo/2015/02/02/11/08/office-620817_960_720.jpg' },
          { id: 2, first_name: 'Wilma', last_name: 'Flintstone', imgurl: 'https://cdn.pixabay.com/photo/2015/02/02/11/08/office-620817_960_720.jpg'  },
          { id: 3, first_name: 'Barney', last_name: 'Rubble', imgurl: 'https://cdn.pixabay.com/photo/2015/02/02/11/08/office-620817_960_720.jpg'  },
          { id: 4, first_name: 'Betty', last_name: 'Rubble', imgurl: 'https://cdn.pixabay.com/photo/2015/02/02/11/08/office-620817_960_720.jpg'  },
          { id: 5, first_name: 'Pebbles', last_name: 'Flintstone', imgurl: 'https://cdn.pixabay.com/photo/2015/02/02/11/08/office-620817_960_720.jpg'  },
          { id: 6, first_name: 'Bamm Bamm', last_name: 'Rubble', imgurl: 'https://cdn.pixabay.com/photo/2015/02/02/11/08/office-620817_960_720.jpg'  },
          { id: 7, first_name: 'The Great', last_name: 'Gazzoo', imgurl: 'https://cdn.pixabay.com/photo/2015/02/02/11/08/office-620817_960_720.jpg'  },
          { id: 8, first_name: 'Rockhead', last_name: 'Slate', imgurl: 'https://cdn.pixabay.com/photo/2015/02/02/11/08/office-620817_960_720.jpg'  },
          { id: 9, first_name: 'Pearl', last_name: 'Slaghoople', imgurl: 'https://cdn.pixabay.com/photo/2015/02/02/11/08/office-620817_960_720.jpg'  }
        ]
export default {
  name : 'Pagination',
  components : {
    VPagination,
  },
  data() {
    return {
      items : items,
      paginatedItems: items,
      totalRows: items.length,
      perPage: 3,
      currentPage: 1,
    }
  },
  methods: {

  },
  mounted(){
 
  },
  computed: {

  },

}
</script>

<style>

</style>