import Vue from 'vue'
import Vuex from 'vuex'
import api from '../backend-service/backend-api'

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        loginStatus: false,
        loginError: false,
        user:{
            email: null,
            firstName:null,
            lastName: null,
            username:null,
            userPass: null
        }
    },
    mutations: {
        login_success(state, payload){
            state.loginStatus = true;
            state.user.email = payload.email;
            state.user.userPass = payload.userPass;
            state.user.firstName = payload.firstName;
            state.user.lastName = payload.lastName;
            localStorage.setItem('isLoggedIn', 'true')
        },
        login_error(state, payload){
            state.loginError = true;
            state.email = payload.email;
        },
        logout(state){
            state.loginStatus = false;
            state.userPass =null;
            state.email = null;
            localStorage.setItem('isLoggedIn', 'false')
        },
        setLogin(state,payload){
            state.loginStatus = payload == 'true' ? true : false;
        },

    },
    actions: {
        login({commit}, {email, password}) {
            return new Promise((resolve, reject) => {
                console.log("Accessing backend with email: '" + email);
                api.getSecured(email, password)
                    .then(response => {
                        console.log("Response: '" + response.data + "' with Statuscode " + response.status);
                        if(response.status == 200) {
                            console.log("Login successful");
                            // place the loginSuccess state into our vuex store
                            commit('login_success', {
                                email: email,
                                userPass: password
                            });

                        }
                        resolve(response)
                    })
                    .catch(error => {
                        console.log("Error: " + error);
                        // place the loginError state into our vuex store
                        commit('login_error', {
                            email: email
                        });
                        reject("Invalid credentials!")
                    })
            })
        },
        logout({commit}) {
             commit('logout');
        },
        loginStatus({commit}, payload) {
             commit('setLogin',payload);
        }
    },
    getters: {
        hasLoginErrored: state => state.loginError,
        isLoggedIn: state => state.loginStatus,
        getEmail: state => state.email,
        getUserPass: state => state.userPass
    }
})