<template>

  <div id="nav">
    <router-link to="/">Home</router-link> |
    <router-link to="/about">About</router-link>
  <router-view></router-view>
  </div>
  <!-- 삭제금지 -->
  


</template>

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  background-color: #fafafa;
  font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
    Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
  // font-style: normal;
  font-size: 14px;
  // line-height: 18px;
  font-weight: 400;
  // color: #2c3e50;
}

.nav {
  padding: 40px 0px 40px 0px;
  // margin: 0px 0px 0px 0px;
  border-bottom: 1px solid #eee;
  position: sticky;
  background-color: green;
  // .nav {
  // }
  // a {
  //   font-weight: bold;
  //   color: #2c3e50;

  //   &.router-link-exact-active {
  //     color: #42b983;
  //   }
  // }
}
</style>
