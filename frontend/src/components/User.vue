<template>
  <div class="user">
    <h4>Create User</h4>

    <h5>Sample database interaction...</h5>

    <input type="text" v-model="user.firstName" placeholder="first name">
    <input type="text" v-model="user.lastName" placeholder="last name">
    <input type="text" v-model="user.email" placeholder="email">
    <input type="text" v-model="user.password" placeholder="password">

    <button @click="createNewUser()">Create User</button>

    <div v-if="showResponse"><h6>User created with Id: {{ user.userId }}</h6></div>

    <button v-if="showResponse" @click="retrieveUser()">Retrieve user {{user.userId}} data from database</button>

    <h4 v-if="showRetrievedUser">Retrieved User {{retrievedUser.firstName}} {{retrievedUser.lastName}}</h4>

  </div>
</template>

<script>
  import api from "./backend-api";

  export default {
    name: 'user',

    data () {
      return {
        response: [],
        errors: [],
        user: {
          lastName: '',
          firstName: '',
          email: '',
          password: '',
          userId: ''
        },
        showResponse: false,
        retrievedUser: {},
        showRetrievedUser: false
      }
    },
    methods: {
      // Fetches posts when the component is created.
      createNewUser () {

        api.createUser(this.user.firstName,
                      this.user.lastName,
                      this.user.email,
                      this.user.password).then(response => {
            // JSON responses are automatically parsed.
            this.response = response.data;
            this.user.userId = response.data.userId;
            console.log('Created new User with this data: ' + response.data);
            this.showResponse = true
          })
          .catch(e => {
            this.errors.push(e)
          })
      },
      retrieveUser () {
        api.getUser(this.user.userId).then(response => {
            // JSON responses are automatically parsed.
            this.retrievedUser = response.data;
            this.showRetrievedUser = true
          })
          .catch(e => {
            this.errors.push(e)
          })
      }
    }
  }

</script>


<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  h1, h2 {
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
