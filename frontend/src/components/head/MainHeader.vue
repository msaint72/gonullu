<template>
     <div v-if="this.isLoggedIn">
         <b-navbar toggleable="lg" type="dark" variant="success">
             <b-navbar-brand to="/">Volunteer</b-navbar-brand>
             <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
            <b-collapse id="nav-collapse" is-nav>
                <b-navbar-nav>
                    <b-nav-item to="/callservice">Service</b-nav-item>
                    <b-nav-item to="/protected">Protected</b-nav-item>
                </b-navbar-nav>
                <!-- Right Aligned Menu Items -->
                <b-navbar-nav class="ml-auto">
                    <b-nav-item-dropdown text="User" right>
                        <b-dropdown-item><span  class="logout" v-on:click="this.logout">Logout</span></b-dropdown-item>
                        <b-dropdown-item to="/">Profile</b-dropdown-item>
                    </b-nav-item-dropdown>
                </b-navbar-nav>
            </b-collapse>
         </b-navbar>
     </div>
     <div v-else>
         <router-link to="/">Home</router-link> |
         <router-link to="/user">SignUp</router-link> |
         <router-link to="/login">Login</router-link>
     </div>
</template>

<script>
    import {mapActions, mapGetters} from 'vuex';

    export default {

        name: 'MainHeader',
        computed: {
            ...mapGetters(['isLoggedIn'])
        },
        methods: {
            logout() {
                this.$store.dispatch("logout")
                this.$router.push('/')
            }
        }
    }

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">



</style>
