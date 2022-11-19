<template>
  <div class="login">
    <h1>Login</h1>
      <label for="email">Email</label>
      <input type="text" id="email" v-model="userId" placeholder="Email">
      <label for="password">Password</label>
      <input type="password" id="password" v-model="password" placeholder="Password">
      <button type="button" @click="login">Login</button>
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
    async login() {
        await this.$store.dispatch("login", {
          userId: this.userId,
          password: this.password
        });

        this.$router.push("/home");
    }
  }
}
</script>

<style scoped>

</style>