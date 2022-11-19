<template>
  <div class="app">
    <div class="layout">
      <div class="layout-sidebar">
        <MainMenu />
      </div>
      <div class="layout-content">
        <router-view />
      </div>
    </div>
  </div>
</template>
<script>
import MainMenu from "@/components/menu/MainMenu";
export default {
  name: "App",
  components: {
    MainMenu,
  },
};
</script>
<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}
</style>
