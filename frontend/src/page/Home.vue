<template>

    <div id="home">
    <h1>{{ hellomsg }}</h1>
    <img  style="max-height: 300px; max-widows: 1000px;" src="./../assets/Vhands.jpg">
    </div>

</template>

<script>
export default {
  name: 'Home',
  props: { hellomsg: { type: String, required: true } }
}

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  #home {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 20px;
  }
</style>

