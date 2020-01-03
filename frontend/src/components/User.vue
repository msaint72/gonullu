<template>
  <div class="user">
    <h4>Create User</h4>

    <h5>Sample database interaction...</h5>
    <div v-if="showResponse">
      <b-alert variant="success" show>User created with Id: {{ user.userId }}</b-alert>
    </div>
    <b-container>
      <b-form-row class="justify-content-center">
        <b-col sm="2">
          <label>Firstname :</label>
        </b-col>
        <b-col  sm="6">
          <b-input type="text"  v-model="user.firstName" placeholder="first name"></b-input>
        </b-col>
      </b-form-row>
      <b-form-row class="justify-content-center">
        <b-col sm="2">
          <label>Lastname :</label>
        </b-col>
        <b-col  sm="6">
          <b-input type="text" v-model="user.lastName" placeholder="last name"></b-input>
        </b-col>
      </b-form-row>
      <b-form-row class="justify-content-center">
        <b-col sm="2">
          <label>Email :</label>
        </b-col>
        <b-col  sm="6">
          <b-input  type="text" v-model="user.email" placeholder="email"></b-input>
        </b-col>
      </b-form-row>

      <b-form-row class="justify-content-center">
        <b-col sm="2">
          <label>Password :</label>
        </b-col>
        <b-col  sm="6">
          <b-input type="password" v-model="user.password" placeholder="password"></b-input>
        </b-col>
      </b-form-row>
      <b-form-row class="justify-content-center">
      <b-col sm="3">
        <b-btn variant="success" @click="createNewUser()">Create User</b-btn>
      </b-col>
      </b-form-row>
    </b-container>

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
  div {
    padding-bottom: 10px;
  }
</style>
