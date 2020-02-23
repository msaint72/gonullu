<template>
  <div>

    <b-btn variant="primary" @click="getSecuredTextFromBackend()">Call the secured API</b-btn>
    <p></p>

    <div v-if="user">
      <h1><b-badge variant="success">  {{ user.firstName+ ' '+ user.lastName }}</b-badge></h1>
    </div>

    <div v-if="user.orgName">
      <b-badge variant="success">Organization:</b-badge>  {{ user.orgName + '(' +user.orgId+')' }}
    </div>

    <div v-if="securedApiCallSuccess">
      <b-badge variant="success">API call</b-badge> Full response: {{ backendResponse }} <b-badge variant="success">successful</b-badge>
    </div>
    <div v-if="errors">
      <b-badge variant="warning">API call</b-badge> {{ errors }} <b-badge variant="warning">NOT successful</b-badge>
    </div>
  </div>

</template>

<script>
  import api from '../backend-service/backend-api'
  import store from '../store/globalStore'
  import {mapGetters,mapActions} from 'vuex';

export default {
  name: 'protected',
  data () {
    return {
      backendResponse: '',
      securedApiCallSuccess: false,
      errors: null
    }
  },
  computed:{
    ...mapGetters(['user']),
    userId(){
      return this.$store.getters.userId;
    },
    user(){
      return this.$store.getters.user;
    }
  },
  created(){
    this.$store.dispatch('getUserData',
            { userId:this.$store.getters.userId,
              token:this.$store.getters.token} )
  },
  methods: {
    getSecuredTextFromBackend() {
      api.getSecured(store.getters.getEmail, store.getters.getUserPass)
              .then(response => {
                console.log("Response: '" + response.data + "' with Statuscode " + response.status);
                this.securedApiCallSuccess = true;
                this.backendResponse = response.data;
              })
              .catch(error => {
                console.log("Error: " + error);
                this.errors = error;
              })
    }
  },
}

</script>

