<template>
  <div class="service">
    <h3>{{ msg }}</h3>

    <button @click="callHelloApi()"> Backend Call</button>

    <h4>Backend response: {{ backendResponse }}</h4>

  </div>
</template>

<script>
  import api from "../backend-service/backend-api";
  import {mapActions, mapGetters, mapState} from 'vuex';

  export default {
    name: 'service',

    data () {
      return {
        msg: 'Java backend de calısan rest endpointleri invoke ornek',
        backendResponse: [],
        errors: []
      }
    },
    computed: {
      ...mapGetters(['user','organization']),

    },
    methods: {
      // Fetches posts when the component is created.
      callHelloApi () {
        api.hello(this.user).then(response => {
            this.backendResponse = response.data;
            console.log(response.data)
        })
        .catch(error => {
          this.errors.push(error)
        })
      }
    }
  }

</script>
<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  h1, h2 ,h3{
    font-weight: normal;
  }

  ul {
    list-style-type: none;
    padding: 0;
  }

  li {
    display: inline-block;
    margin: 0 10px;
  }

  a {
    color: #42b983;
  }
</style>
