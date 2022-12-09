<template>
  <div class="app">
    <div class="layout">
      <div class="">
        <MainMenu />
      </div>
      <div class="layout-content">
        <router-view />
      </div>
    </div>
    <Toast />
  </div>
</template>
<script>
import MainMenu from "@/components/menu/MainMenu";
import Toast from "primevue/toast";
export default {
  name: "App",
  components: {
    MainMenu,
    Toast,
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
