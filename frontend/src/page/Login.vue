<template>

<div id="login">
  <div class="unprotected">
    <b-container>
      <form @submit.prevent="callLogin()">
        <b-form-row class="justify-content-center">
          <b-col class="login" sm="4"><b-input type="text" placeholder="email" v-model="email"></b-input></b-col>
          <b-col class="login" sm="4"><b-input type="password" placeholder="password" v-model="password"></b-input></b-col>
          <b-col sm="1"><b-btn variant="success" type="submit">Login</b-btn></b-col>
        </b-form-row>
        <p v-if="error" class="error">Bad login information</p>
      </form>
    </b-container>
  </div>
</div>
  </template>

<script>
export default {
  name: 'login',

  data () {
    return {
      loginError: false,
      email: '',
      password: '',
      error: false,
      errors: []
    }
  },
  methods: {
    callLogin() {
      this.errors = [];
      this.$store.dispatch("login", { email: this.email, password: this.password})
        .then(() => {
          this.$router.push('/Protected')
        })
        .catch(error => {
          this.loginError = true;
          this.errors.push(error);
          this.error = true
        })
    }
  }
}
</script>
<style>
  #login {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 20px;
  }
</style>