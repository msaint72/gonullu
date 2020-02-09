<template>
  <b-container fluid  class="bv-example-row pt-5">
    <b-row align-h="center" >
      <b-col cols="2"  class="justify-content-md-center">

          <b-img thumbnail fluid src="https://i.picsum.photos/id/326/250/250.jpg" alt="Image 1"></b-img>
        <b-button  pill  variant="outline-secondary" class="px-3 my-2"> <p class="h5">Upload Image <b-icon icon="upload"></b-icon></p>  </b-button>
      </b-col>
      <b-col cols="5" >

        <b-form>
          <b-form-group
                  id="input-group-1"
                  label="Email address:"
                  label-for="input-1"
                  description="We'll never share your email with anyone else.">
            <b-form-input
                    id="input-1"
                    v-model="form.email"
                    type="email"
                    required
                    placeholder="Enter email"
            ></b-form-input>
          </b-form-group>
          <b-input-group >
            <b-form-input aria-label="First name"></b-form-input>
            <b-form-input aria-label="Last name"></b-form-input>
          </b-input-group>

          <b-form-group id="input-group-2" label="Your name:" label-for="input-2">
            <b-form-input
                    id="input-2"
                    v-model="form.name"
                    required
                    placeholder="Enter name"
            ></b-form-input>
          </b-form-group>
          <b-form-group id="input-group-2" label="Your surname:" label-for="input-2">
          <b-form-input
                  id="input-2"
                  v-model="form.surname"
                  required
                  placeholder="Enter surname"
          ></b-form-input>

        </b-form-group>
          <b-form-group id="input-group-2" label="Your username:" label-for="input-2">
            <b-form-input
                    id="input-2"
                    v-model="form.username"
                    required
                    placeholder="Enter username"
            ></b-form-input>

          </b-form-group>
          <b-button type="submit" variant="info">Save</b-button>
        </b-form>

      </b-col>
    </b-row>
  </b-container>
</template>

<script>

export default {
  name: 'protected',
  data() {
    return {
      form: {
        email: '',
        name: '',
        surname: '',
        username: '',
        checked: []
      },
      foods: [{ text: 'Select One', value: null }, 'Carrots', 'Beans', 'Tomatoes', 'Corn'],
      show: true
    }
  },
  methods: {

  }
}

</script>

