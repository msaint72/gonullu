import Vue from 'vue'
import Vuex from 'vuex'
import api from './components/backend-api'

Vue.use(Vuex);

export default new Vuex.Store({
    state: {
        loginSuccess: false,
        loginError: false,
        email: null,
        userPass: null
    },
    mutations: {
        login_success(state, payload){
            state.loginSuccess = true;
            state.email = payload.email;
            state.userPass = payload.userPass;
        },
        login_error(state, payload){
            state.loginError = true;
            state.email = payload.email;
        }
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
        }
    },
    getters: {
        isLoggedIn: state => state.loginSuccess,
        hasLoginErrored: state => state.loginError,
        getEmail: state => state.email,
        getUserPass: state => state.userPass
    }
})