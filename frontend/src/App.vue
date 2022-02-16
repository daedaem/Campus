<template>
  <div id="app">
    <Chat class="chat" />
    <router-view :key="$route.fullPath"></router-view>
  </div>
  <!-- 삭제금지 -->
</template>

<script>
// import Navbar from "@/components/Navbar.vue";
// import Navbar from "@/components/Navbar.vue";
import Chat from "@/components/common/Chat.vue";

export default {
  name: "App",
  components: {
    // Navbar,
    // Navbar,
    Chat,
  },
};
</script>

<style lang="scss">
@font-face {
  font-family: "myFont";
  src: url("./assets/fonts/BM/BMDOHYEON_ttf.ttf");
  // font-family: /* 본문용 서체 */ "-apple-system", "BlinkMacSystemFont",
  //   "Apple SD Gothic Neo", "Inter", "Spoqa Han Sans", "Segoe UI", Sans-Serif,
  //   "Apple Color Emoji", "Segoe UI Emoji", "Segoe UI Symbol";
}
* {
  font-family: "myFont";
}
#app {
  //   font-family: Avenir, Helvetica, Arial, sans-serif;
  //   -webkit-font-smoothing: antialiased;
  //   -moz-osx-font-smoothing: grayscale;
  //   text-align: center;
  background-color: #fafafa;
  //   font-family: -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, Oxygen,
  //     Ubuntu, Cantarell, "Open Sans", "Helvetica Neue", sans-serif;
  //   // font-style: normal;
  //   font-size: 14px;
  //   // line-height: 18px;
  //   font-weight: 400;
  //   // color: #2c3e50;
}

@media (max-width: 768px) {
  .chat {
    // background: whitesmoke;
    position: absolute;
    left: 10;
    bottom: 0;
  }
}

// .nav {
//   padding: 40px 0px 40px 0px;
// margin: 0px 0px 0px 0px;
// border-bottom: 1px solid #eee;
// position: sticky;
// background-color: green;
// .nav {
// }
// a {
//   font-weight: bold;
//   color: #2c3e50;

//   &.router-link-exact-active {
//     color: #42b983;
//   }
// }
// }
@media (max-width: 420px) {
  #nav {
    // background: whitesmoke;

    width: 100vw;
    position: fixed;
  }
}
#nav {
  padding: 30px;
  text-align: center;
}
</style>
