<template>
  <div class="user">
    <h4>Create User</h4>

    <h5>Sample database interaction...</h5>
    <div v-if="showResponse">
      <b-alert variant="success" show>User created with Id: {{ user.userId }}</b-alert>
    </div>
    <div v-if="errors.length>0" v-for="error in errors">
      <b-alert variant="success" show> {{ error }}</b-alert>
    </div>
    <b-container>
      <b-form-row class="text-sm-right">
        <b-col sm="4">
          <label>Firstname :</label>
        </b-col>
        <b-col  sm="6">
          <b-input type="text"  v-model="user.firstName" placeholder="first name" class="form-control" :class="{ 'is-invalid': submitted && $v.user.firstName.$error }" ></b-input>
          <div v-if="submitted && !$v.user.firstName.required" class="invalid-feedback">First Name is required</div>
        </b-col>
      </b-form-row>
      <b-form-row>
        <b-col sm="4" class="text-sm-right">
          <label>Lastname :</label>
        </b-col>
        <b-col  sm="6">
          <b-input type="text" v-model="user.lastName" placeholder="last name" class="form-control" :class="{ 'is-invalid': submitted && $v.user.lastName.$error }" ></b-input>
          <div v-if="submitted && !$v.user.lastName.required" class="invalid-feedback">Last Name is required</div>
        </b-col>
      </b-form-row>
      <b-form-row>
        <b-col sm="4" class="text-sm-right">
          <label>Email :</label>
        </b-col>
        <b-col  sm="6">
          <b-input  type="text" v-model="user.email" placeholder="email" class="form-control" :class="{ 'is-invalid': submitted && $v.user.email.$error }" ></b-input>
          <div v-if="submitted && $v.user.email.$error" class="invalid-feedback"  >
            <span v-if="!$v.user.email.required">Email is required</span>
            <span v-if="!$v.user.email.email">Email is invalid</span>
          </div>
        </b-col>
      </b-form-row>
      <b-form-row>
        <b-col sm="4" class="text-sm-right">
          <label>Password :</label>
        </b-col>
        <b-col  sm="6">
          <b-input type="password" v-model="user.password" placeholder="password" class="form-control" :class="{ 'is-invalid': submitted && $v.user.password.$error }"></b-input>
          <div v-if="submitted && $v.user.password.$error" class="invalid-feedback">
            <span v-if="!$v.user.password.required">Password is required</span>
            <span v-if="!$v.user.password.minLength">Password must be at least 6 characters</span>
          </div>
        </b-col>
      </b-form-row>
      <b-form-row>
        <b-col sm="4" class="text-sm-right">
          <label>Confirm Password :</label>
        </b-col>
        <b-col  sm="6">
          <b-input type="password" v-model="user.confirmPassword" placeholder="confirm password" class="form-control" :class="{ 'is-invalid': submitted && $v.user.confirmPassword.$error }"></b-input>
          <div v-if="submitted && $v.user.confirmPassword.$error" class="invalid-feedback">
            <span v-if="!$v.user.confirmPassword.required">Password is required</span>
            <span v-else-if="!$v.user.confirmPassword.sameAsPassword">Passwords must match</span>
          </div>
        </b-col>
      </b-form-row>
      <b-form-row class="justify-content-center">
      <b-col sm="3">
        <b-btn variant="success" @click="createNewUser">Create User</b-btn>
      </b-col>
      </b-form-row>
    </b-container>
    <button v-if="showResponse" @click="retrieveUser()">Retrieve user {{user.userId}} data from database</button>

    <h4 v-if="showRetrievedUser">Retrieved User {{retrievedUser.firstName}} {{retrievedUser.lastName}}</h4>

  </div>
</template>

<script>
  import api from "./backend-api";
  import { required, email, minLength, sameAs }  from 'vuelidate/lib/validators'
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
          confirmPassword: '',
          userId: ''
        },
        showResponse: false,
        retrievedUser: {},
        showRetrievedUser: false,
        submitted:false
      }
    },
    validations: {
      user: {
        firstName: {
          required
        },
        lastName: {
          required
        },
        email: { required, email },
        password: { required, minLength: minLength(6) },
        confirmPassword: { required, sameAsPassword: sameAs('password') }
      }
    },
    methods: {
      // Fetches posts when the component is created.
      createNewUser () {
        this.submitted=true;
        this.$v.$touch();
        if (this.$v.$invalid) {
          return;
        }
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
  span .error{
    color: #d72c4a;

  }
</style>
