<template>
  <div class="home">
    <h1>Home</h1>
    <p v-if="!isLoggedIn">You are not logged in</p>
    <p v-else>You are logged in</p>
  </div>
</template>

<script>
export default {
  name: "HomeView",
  computed: {
    isLoggedIn() {
      return this.$store.getters.isLoggedIn;
    }
  }
}
</script>

<style scoped>

</style>