<template>
  <div id="app">
    <main-header></main-header>
    <div class="main-body">
    <router-view :hellomsg="msg"></router-view>
    </div>
    <main-footer></main-footer>
  </div>
</template>

<script>
import MainHeader from './components/head/MainHeader.vue'
import MainFooter from './components/foot/MainFooter.vue'
export default {
  name: 'app',
  components: { MainHeader,MainFooter } ,
  data () {
    return {
      msg: 'Welcome to Volunteer Mark Demo Application'
    }
  }
}
</script>

<style lang="scss">
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 20px;
}
.main-body{
  min-height: 500px;
}
</style>
