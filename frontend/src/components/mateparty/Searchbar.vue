<template>
  <div>
    <div class="container">
    <div class="row height d-flex justify-content-center align-items-center" >
        <div class="col-md-12">
            <div class="form"> <i class="fa fa-search"></i> <input v-model="search" type="text" class="form-control form-input" placeholder="Search anything..."> <span class="left-pan"><i class="fa fa-microphone"></i></span> </div>
         <!-- <div v-if="search">
         <div  v-for="post in filteredPosts" :key="post.id" class="post" >
            <div @click="asd">
              <div>{{post.id}}</div>
              <div>{{post.body}}</div>
            </div>
         </div>
        </div> -->
        </div>
       
    </div>
    </div>
      

  </div>
</template>

<script>
export default {
  name : 'Searchbar',
  data() {
    return {
      search : '',
      posts: [
        {
          id: 1,
          title: 'post 1',
          body: 'vue.js is cool',
        },
        {
          id: 2,
          title: 'post 2',
          body: 'react.js is hot',
        },
        {
          id: 3,
          title: 'post 3',
          body: 'angular.js is hot',
        },
      ]
      
    }
  },
  computed : {
    filteredPosts() {
      return this.posts.filter(post => post.body.includes(this.search))
    },
    
  },
  methods : {
    asd() {
      console.log(1)
    }
  }
  
  
}
</script>

<style scoped>
@media (min-width: 768px) {
  .container {
  width : 50%;
  }
}



.height {
  background-color:white;
}

.form {
    position: relative;
    border: 1px solid rgb(121, 121, 121);
    border-radius: 10px;
}

.form .fa-search {
    position: absolute;
    top: 20px;
    left: 20px;
    color: #9ca3af
}

.form span {
    position: absolute;
    right: 17px;
    top: 13px;
    padding: 2px;
    border-left: 1px solid #d1d5db
}

.left-pan {
    padding-left: 7px
}

.left-pan i {
    padding-left: 10px
}

.form-input {
    height: 55px;
    text-indent: 33px;
    border-radius: 10px
}

.form-input:focus {
    box-shadow: none;
    border: none
}

.post {
  border-bottom: 1px solid rgb(196, 196, 196);
  width: 336px;
  
}
</style>