<template>
  <b-container fluid class="bv-example-row pt-1">
    <b-row align-h="center">
      <b-col sm="6" md="4" lg="3" class="justify-content-md-center" align="center">
        <div >
          <b-img thumbnail fluid src="https://i.picsum.photos/id/326/250/250.jpg" alt="Image 1"></b-img>

          <b-button size="sm" class="mt-2 p-2 h-10" sm variant="outline-info">upload image</b-button>

        </div>
      </b-col>
      <b-col sm="6" md="8" lg="7">

        <b-form>
          <b-form-group
                  id="input-group-1"
                  label-for="input-1"
                  description="We'll never share your email with anyone else.">
            <b-form-input
                    id="input-1"
                    v-model="user.email"
                    type="email"
                    required
                    placeholder="Enter email"
            ></b-form-input>
          </b-form-group>

          <b-form-group
                  id="input-group-2"
                  label-for="input-1">

          <b-input-group   id="input-group-2">
            <b-form-input   v-model="user.name"  placeholder="Enter first name"></b-form-input>
            <b-form-input   v-model="user.surname"  placeholder="Enter last name"></b-form-input>
          </b-input-group>
          </b-form-group>

          <b-form-group id="input-group-2" label-for="input-2">
            <b-form-input
                    id="input-2"
                    v-model="user.username"
                    required
                    placeholder="Enter username"
            ></b-form-input>

          </b-form-group>
          <b-form-group id="input-group-3" label-for="input-3">
            <b-form-input
                    id="input-3"
                    v-model="user.address"
                    required
                    placeholder="Enter your address information"
            ></b-form-input>

          </b-form-group>
          <b-button variant="outline-info" type="submit">Save</b-button>
        </b-form>
      </b-col>
    </b-row>
  </b-container>
</template>
<script>
  import {mapActions, mapGetters, mapState} from 'vuex';
export default {
  name: 'protected',
  data() {
    return {
      formUser: {
        email: '',
        name: '',
        surname: '',
        username: '',
        address: ''
      }
    }
  },
  computed: {
    ...mapGetters(['user'])
  },
  methods: {

  },
  mounted() {
    this.formUser=this.user;
  }
}

</script>

