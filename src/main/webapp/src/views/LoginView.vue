<template>
  <div class="login">
    <h1>Login</h1>
    <form>
      <label for="email">Email</label>
      <input type="email" id="email" v-model="userId" placeholder="Email">
      <label for="password">Password</label>
      <input type="password" id="password" v-model="password" placeholder="Password">
      <button type="submit" @click.prevent="login">Login</button>
    </form>
  </div>
</template>

<script>
export default {
  name: "LoginView",
  data() {
    return {
      userId: "",
      password: ""
    };
  },
  methods: {
    login() {
      this.$store.dispatch("login", { userId: this.userId, password: this.password });
    }
  }
}
</script>

<style scoped>

</style>