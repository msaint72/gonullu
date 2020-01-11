<template>
 <div id="nav">
   <router-link to="/">Home</router-link> |
   <router-link to="/callservice">Service</router-link> |
   <router-link to="/user">SignUp</router-link> |
   <router-link to="/login">Login</router-link> |
   <router-link to="/protected">Protected</router-link>
 </div>
</template>

<script>
export default {
  name: 'MainHeader'
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
</style>
