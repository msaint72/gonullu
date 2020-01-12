<template>
 <div id="nav">
     <div v-if="this.isLoggedIn">
         <router-link to="/">Home</router-link> |
         <router-link to="/callservice">Service</router-link> |
         <router-link to="/protected">Protected</router-link> |
         <span  class="logout" v-on:click="this.logout">Logout</span>
     </div>
     <div v-else>
         <router-link to="/">Home</router-link> |
         <router-link to="/user">SignUp</router-link> |
         <router-link to="/login">Login</router-link>
     </div>
 </div>
</template>

<script>
    import {mapActions, mapGetters} from 'vuex';

    export default {

        name: 'MainHeader',
        computed: {
            ...mapGetters(['isLoggedIn'])
        },
        methods: {
            logout() {
                this.$store.dispatch("logout")
                this.$router.push('/')
            }
        }
    }

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">


  #nav {
    padding: 30px;
  a {
    font-weight: bold;
    color: #2c3e50;
  &.router-link-exact-active {
     color: #42b983;
   }
  }
  }
  .logout{
      font-weight: bold;
      color: #2c3e50;
  }
</style>
