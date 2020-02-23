import api from "../backend-service/backend-api";

export default {
    namespaced: true,
    state: {
        organization:{
            id:null,
            name:null,
            summary:null,
            address:{
                province:"",
                district:"",
                zipcode: "",
                adress:"",

            },
            web:null,
            phone:null,
            causes:[],
        }
    },
    mutations: {
        setOrgInfo(state,orgData){
            state.organization.id=orgData.id;
            state.organization.name=orgData.name;
            state.organization.address=orgData.address;
            state.organization.phone=orgData.phone;
            state.organization.web=orgData.web;
            state.organization.summary=orgData.summary;
            state.organization.causes=orgData.causes;
        }
    },
    actions: {
        getOrgData({commit,state},userData){
            console.log("getting organization data for id:"+userData.id);
            return api.getOrganization(userData)
                .then(response=>{
                    console.log(response);
                    if(response.status ==200){
                        commit('setOrgInfo',response.data);
                    }
                })
                .catch(error=>{
                    console.log("Error: " + error);
                });
        },
        saveOrganization({commit,state},payload){
            console.log("updating organization with id:"+payload.organization.id);
            api.updateOrganization(payload.organization,payload.token)
                .then(response=>{
                    console.log(response);
                    if(response.status ==200){
                        commit('setOrgInfo',response.data);
                    }
                })
                .catch(error=>{
                    console.log("Error: " + error);
                });
        }
    },
    getters: {
        organization:state=>state.organization
    }
};
