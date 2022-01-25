<template>

<div class="container mx-auto mt-4">
  <div class="row">
    <div class="col-md-3">
      <div class="card" style="width: 10rem; height:14rem;">
  <img style="height:100%;" :src="items[0].imgurl" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title" align="left">Card title</h5>
        <h6 class="card-subtitle mb-2 text-muted" align="left">Card subtitle</h6>
    <p class="card-text" align="left">wf</p>
      
  </div>
  </div>
    </div>    
       <div class="col-md-3">
<div class="card" style="width: 10rem; height:15rem;">
  <img src="https://i.imgur.com/ZTkt4I5.jpg" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title" align="left">Card title</h5>
        <h6 class="card-subtitle mb-2 text-muted" align="left">Card subtitle</h6>
    <p class="card-text" align="left">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
   
  </div>
  </div>
    </div>    
          <div class="col-md-3">
<div class="card" style="width: 10rem; height:14rem;">
  <img src="https://i.imgur.com/ZTkt4I5.jpg" class="card-img-top" alt="...">
  <div class="card-body" align="left">
    <h5 class="card-title">Card title</h5>
        <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    
  </div>
  </div>
  </div>
  <div class="col-md-3">
<div class="card" style="width: 10rem; height:14rem;">
  <img src="https://i.imgur.com/ZTkt4I5.jpg" class="card-img-top" alt="...">
  <div class="card-body" align="left">
    <h5 class="card-title">Card title</h5>
        <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    
  </div>
  </div>
  </div>
  
    
</div>
</div>
</template>

<script>
const items = [
          { id: 1, first_name: 'Fred', last_name: 'Flintstone', imgurl: 'https://picsum.photos/id/973/200/300' },
          { id: 2, first_name: 'Wilma', last_name: 'Flintstone', imgurl: 'https://cdn.pixabay.com/photo/2015/02/02/11/08/office-620817_960_720.jpg'  },
          { id: 3, first_name: 'Barney', last_name: 'Rubble', imgurl: 'https://picsum.photos/id/973/200/300'  },
          { id: 4, first_name: 'Betty', last_name: 'Rubble', imgurl: 'https://cdn.pixabay.com/photo/2015/02/02/11/08/office-620817_960_720.jpg'  },
          { id: 5, first_name: 'Pebbles', last_name: 'Flintstone', imgurl: 'https://picsum.photos/id/973/200/300'  },
          { id: 6, first_name: 'Bamm Bamm', last_name: 'Rubble', imgurl: 'https://cdn.pixabay.com/photo/2015/02/02/11/08/office-620817_960_720.jpg'  },
          { id: 7, first_name: 'The Great', last_name: 'Gazzoo', imgurl: 'https://picsum.photos/id/973/200/300'  },
          { id: 8, first_name: 'Rockhead', last_name: 'Slate', imgurl: 'https://cdn.pixabay.com/photo/2015/02/02/11/08/office-620817_960_720.jpg'  },
          { id: 9, first_name: 'Pearl', last_name: 'Slaghoople', imgurl: 'https://picsum.photos/id/973/200/300'  }
        ]
export default {
  name : 'Maincarousel',
  data() {
    return {
      items : items
    }
  }

}


</script>

<style  scoped>
:root {
  --gradient: linear-gradient(to left top, #DD2476 10%, #FF512F 90%) !important;
}

body {
  background: #111 !important;
}

.card {
  background: #222;
  border: 1px solid #dd2476;
  color: rgba(250, 250, 250, 0.8);
  margin-bottom: 2rem;
}

.btn {
  border: 5px solid;
  border-image-slice: 1;
  background: var(--gradient) !important;
  -webkit-background-clip: text !important;
  -webkit-text-fill-color: transparent !important;
  border-image-source:  var(--gradient) !important; 
  text-decoration: none;
  transition: all .4s ease;
}

.btn:hover, .btn:focus {
      background: var(--gradient) !important;
  -webkit-background-clip: none !important;
  -webkit-text-fill-color: #fff !important;
  border: 5px solid #fff !important; 
  box-shadow: #222 1px 0 10px;
  text-decoration: underline;
}
</style>