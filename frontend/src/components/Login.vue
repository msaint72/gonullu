<template>
  <div class="unprotected" v-if="loginError">
    <h3><b-badge variant="danger">wrong password ?</b-badge></h3>
    <h5>try to remember that... </h5>
  </div>
  <div class="unprotected" v-else>
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