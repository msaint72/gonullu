<template>
  <separator>
    <h1>{{ hellomsg }}</h1>
    <img  style="max-height: 300px; max-widows: 1000px;" src="./../assets/Vhands.jpg">
  </separator>
</template>

<script>
  import Separator from '../components/Separator.vue'
export default {
  name: 'Home',
  components : {Separator},
  props: { hellomsg: { type: String, required: true } }
}

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>

