import Vue from 'vue'
import Vuex from 'vuex'
import api from '../backend-service/backend-api'

Vue.use(Vuex);

export default {
    state: {
        idToken:null,
        loginStatus: false,
        loginError: false,
        user:{
            userId: null,
            email: null,
            firstName:null,
            surname: null,
            name:null,
            orgName:null,
            orgId:null,
            username:null,
            userPass: null
        }
    },
    mutations: {
        login_success(state, userData){
            state.loginStatus = true;
            state.user.userId=userData.userId;
            state.user.email = userData.email;
            state.idToken=userData.token;
            localStorage.setItem('isLoggedIn', 'true')
        },
        login_error(state, payload){
            state.loginError = true;
            state.email = payload.email;
        },
        logout(state){
            state.loginStatus = false;
            state.user.userId=null;
            state.user.firstName=null;
            state.user.lastName=null;
            state.user.email=null;
            localStorage.setItem('isLoggedIn', 'false')
        },
        setLogin(state,payload){
            state.loginStatus = payload == 'true' ? true : false;
        },
        setUserInfo(state,userData){
            state.user.firstName=userData.firstName;
            state.user.lastName=userData.lastName;
            state.user.orgName=userData.orgName;
            state.user.orgId=userData.orgId;
        }
    },
    actions: {
        login({commit,dispatch}, {email, password}) {
            return new Promise((resolve, reject) => {
                console.log("Accessing backend with email: '" + email);
                api.getSecured(email, password)
                    .then(response => {
                        console.log("Response: '" + response.data + "' with Statuscode " + response.status);
                        if(response.status == 200) {
                            console.log("Login successful userId:"+response.headers.userid);
                            // place the loginSuccess state into our vuex store
                            commit('login_success', {
                                email: email,
                                token:response.headers.authorization,
                                userId:response.headers.userid
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
        },
        getUserData({commit,state},userData){
            console.log("getting user data for:"+userData.userId);
            console.log("Name:"+state.user.firstName);
            if(state.user.firstName!=null){
                return;
            }
            api.getUser(userData)
                .then(response=>{
                    console.log(response);
                    if(response.status == 200) {
                        commit('setUserInfo',response.data);
                    }
            })
                .catch(error => {
                        console.log("Error: " + error);
                });
        }
    },
    getters: {
        hasLoginErrored: state => state.loginError,
        isLoggedIn: state => state.loginStatus,
        getEmail: state => state.user.email,
        userId:state=>state.user.userId,
        token:state=>state.idToken,
        user: state=>state.user
    }
}