<template>
    <div id="header">
     <div v-if="this.isLoggedIn">
         <b-navbar toggleable="lg" type="dark" variant="success">
             <b-navbar-brand to="/">Volunteer</b-navbar-brand>
             <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>
            <b-collapse id="nav-collapse" is-nav>
                <b-navbar-nav>
                    <b-nav-item :to="this.PATHS.SERVICE">Service</b-nav-item>
                    <b-nav-item :to="this.PATHS.PROTECTED">Protected</b-nav-item>
                </b-navbar-nav>
                <!-- Right Aligned Menu Items -->
                <b-navbar-nav class="ml-auto">
                    <b-nav-item-dropdown text="User" right>
                        <b-dropdown-item><span  class="logout" v-on:click="this.logout">Logout</span></b-dropdown-item>
                        <b-dropdown-item :to="this.PATHS.PROFILE">Profile</b-dropdown-item>
                    </b-nav-item-dropdown>
                </b-navbar-nav>
            </b-collapse>
         </b-navbar>
     </div>
     <div v-else>
         <router-link :to="this.PATHS.HOME">Home</router-link> |
         <router-link :to="this.PATHS.USER_PAGE">SignUp</router-link> |
         <router-link :to="this.PATHS.LOGIN">Login</router-link>
     </div>
</div>
</template>

<script>
    import {mapGetters} from 'vuex';
    import { URL_PATH} from "../../UrlMappings";

    export default {

        name: 'MainHeader',
        computed: {
            ...mapGetters(['isLoggedIn'])
        },
        data () {
            return {
                PATHS: URL_PATH
            }
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

    #header {
        font-family: 'Avenir', Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #2c3e50;
        margin-top: 20px;
    }

</style>
