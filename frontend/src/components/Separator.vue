<template>
  <div class="p-5 m-5">
    <slot></slot>
  </div>
</template>

<script>
export default {
  name: 'Separator',
  props: { hellomsg: { type: String, required: true } }
}

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>

