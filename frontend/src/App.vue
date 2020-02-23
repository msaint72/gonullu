<template>
  <div id="app">
    <main-header></main-header>
    <div class="main-body">
      <separator>
      <transition name="component-fade" mode="out-in">
        <router-view :hellomsg="msg"></router-view>
      </transition>
      </separator>
    </div>
    <main-footer></main-footer>
  </div>
</template>

<script>
import MainHeader from './components/head/MainHeader.vue'
import MainFooter from './components/foot/MainFooter.vue'
import Separator from './components/Separator.vue'

export default {
  name: 'app',
  components: { MainHeader,MainFooter ,Separator} ,
  data () {
    return {
      msg: 'Welcome to Volunteer Demo Application'
    }
  },
  created() {
    const loginStat = localStorage.getItem('isLoggedIn');
    this.$store.dispatch("loginStatus", loginStat)
    const comingRoute = localStorage.getItem('lastRoute');
    const path = comingRoute !== null ? comingRoute : "/";
    localStorage.removeItem('comingRoute');
    if(loginStat =="true"){
      this.$router.push({ path })
    }
  }
}
</script>

<style scoped lang="scss">

.main-body{
  min-height: 500px;
}
.component-fade-enter-active, .component-fade-leave-active {
  transition: opacity .3s ease;
}
.component-fade-enter, .component-fade-leave-to
  /* .component-fade-leave-active below version 2.1.8 */ {
  opacity: 0;
}
</style>
