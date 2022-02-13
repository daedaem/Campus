<template>
  <div v-if="mateData.imageList.length != 0">
    <Carousel :itemsToShow="res" :wrapAround="true">
      <Slide v-for="(item,idx) in mateData.imageList" :key="idx">
        <div class="carousel__item">
          <img
            style="width: 100%; height: 100%; border-radius: 10px"
            :src="item.snsImageUrl"
            alt="321"
          />
        </div>
      </Slide>
    </Carousel>
    <Pagination />
  </div>
  <div v-else>
    <Carousel :itemsToShow="res" :wrapAround="true">
      <Slide v-for="(item,idx) in items" :key="idx">
        <div class="carousel__item" style="">
          <img
            style="width: 100%; height: 100%; border-radius: 10px"
            :src="item.imgurl"
            alt="321"
          />
        </div>
      </Slide>
    </Carousel>
    <Pagination />


  </div>
</template>

<script>
const items = [
  {
    id: 1,
    first_name: "Fred",
    last_name: "Flintstone",
    imgurl: "https://picsum.photos/id/973/200/300",
  },
  {
    id: 2,
    first_name: "Wilma",
    last_name: "Flintstone",
    imgurl:
      "https://cdn.pixabay.com/photo/2015/02/02/11/08/office-620817_960_720.jpg",
  },
  {
    id: 3,
    first_name: "Barney",
    last_name: "Rubble",
    imgurl: "https://picsum.photos/id/973/200/300",
  },
  {
    id: 4,
    first_name: "Betty",
    last_name: "Rubble",
    imgurl:
      "https://cdn.pixabay.com/photo/2015/02/02/11/08/office-620817_960_720.jpg",
  },
  {
    id: 5,
    first_name: "Pebbles",
    last_name: "Flintstone",
    imgurl: "https://picsum.photos/id/973/200/300",
  },
  {
    id: 6,
    first_name: "Bamm Bamm",
    last_name: "Rubble",
    imgurl:
      "https://cdn.pixabay.com/photo/2015/02/02/11/08/office-620817_960_720.jpg",
  },
  {
    id: 7,
    first_name: "The Great",
    last_name: "Gazzoo",
    imgurl: "https://picsum.photos/id/973/200/300",
  },
  {
    id: 8,
    first_name: "Rockhead",
    last_name: "Slate",
    imgurl:
      "https://cdn.pixabay.com/photo/2015/02/02/11/08/office-620817_960_720.jpg",
  },
  {
    id: 9,
    first_name: "Pearl",
    last_name: "Slaghoople",
    imgurl: "https://picsum.photos/id/973/200/300",
  },
];
import { defineComponent } from "vue";
import { Carousel, Slide, Pagination } from "vue3-carousel";

import "vue3-carousel/dist/carousel.css";

export default defineComponent({
  name: "Carousel2",
  props : ['mateDetail'],
  components: {
    Carousel,
    Slide,
    Pagination,
  },
  data() {
    return {
      items: items,
      mateData : this.mateDetail,
      width : 768,
      height : 0,
      res : 3.95,

    };
  },

  created() {
    if (this.width < 500) {
            this.res = 2.3
          } else {
            this.res = 3.95
          }
  },
  mounted() {
    console.log(this.mateData)
     window.addEventListener('resize', this.handleResize);
 

  },
  beforeUnmount() {
        // console.log("beforeDestroy...");
        window.removeEventListener('resize', this.handleResize);
  },
  methods: {
      handleResize() {
          this.width = window.innerWidth;
          this.height = window.innerHeight;
          if (this.width <= 768) {
            this.res = 2.3
          } else {
            this.res = 3.95
          }
      }
  }
  
  
});
</script>

<style scoped>
.carousel__slide > .carousel__item {
  transform: scale(1);
  opacity: 0.5;
  transition: 0.5s;
}
.carousel__slide--visible > .carousel__item {
  opacity: 1;
  transform: rotateY(0);

}
.carousel__slide--next > .carousel__item {
  transform: scale(0.9) translate(-10px);
}
.carousel__slide--prev > .carousel__item {
  transform: scale(0.9) translate(10px);
}
.carousel__slide--active > .carousel__item {
  transform: scale(1.1);
}

.carousel__item {
  width: 150px;
  height: 150px;
}

@media (max-width: 768px) {
  .carousel__item {
   width :100px; 
  }
}
</style>
