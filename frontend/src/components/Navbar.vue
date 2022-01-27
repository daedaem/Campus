<template>
<div id="app">
  <div id="nav">
 <nav class=" navbar navbar-expand-lg navbar-light bg-light fixed-top" style="padding-left:30px;">
    <a class="navbar-brand" href="#">Logo Here</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent" data-bs-toggle="collapse" data-bs-target=".navbar-collapse.hide">
        <!-- replacing the ul with a div tag -->
        <!-- <ul class="navbar-nav me-auto mb-2 mb-lg-0">   -->
        <div class="navbar-nav mr-auto">
            <!-- on each of the li tag , there is a class named *nav item*, copy it and place it on the a tag & delete the li -->
            <!-- <a class=" nav-item nav-link active" aria-current="page" href="#">Home</a> -->
            <!-- replace the a tag with the router link -->
            <router-link to="/" class="nav-item nav-link" data-bs-toggle="collapse" data-bs-target=".navbar-collapse.show">Home</router-link>
            <router-link :to="{name: 'Mateparty'}" class="nav-item nav-link" data-bs-toggle="collapse" data-bs-target=".navbar-collapse.show">About</router-link>
            <router-link to="/Mateparty" class="nav-link" data-bs-toggle="collapse" data-bs-target=".navbar-collapse.show" @click="test">Careers</router-link>
            <router-link to="/Contact" class="nav-link" data-bs-toggle="collapse" data-bs-target=".navbar-collapse.show">Contact</router-link>
            <router-view></router-view>
        </div>
        <form class="d-flex">
            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success" type="submit">Search</button>
        </form>
    </div>
</nav>
 </div>
</div>
</template>

<script>

export default {
  name : 'Navbar',
  setup() {
    const test = () => {
      console.log(1)
    }
  
  
  
  return {
    test,
  }
  
  }



}

</script>

<style scoped>

 #nav{
background: whitesmoke;
width:100vw;
}
#nav {
  padding: 30px;
  text-align: center;
}
#nav a {
  font-weight: bold;
  color: #2c3e50;
}
#nav a.router-link-exact-active {
  color: whitesmoke;
  background: crimson;
  border-radius: .5rem;
}
</style>