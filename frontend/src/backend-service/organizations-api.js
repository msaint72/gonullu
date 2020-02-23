import axios from 'axios/index'

const AXIOS = axios.create({
    baseURL: `/api`
});


export default {
    createOrganization(organization) {
        return AXIOS.post(`/organization/`,{
            name:organization.name
        });
    },
    updateOrganization(organization) {
        return AXIOS.put(`/organization/`+organization.id,{
            name:organization.name,
            summary:organization.summary
        });
    }
}


