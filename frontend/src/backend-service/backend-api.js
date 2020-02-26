import axios from 'axios/index'

const AXIOS = axios.create({
  baseURL: `/api`
});


export default {
    hello(user) {
        return AXIOS.get(`/hello`,{ headers: { Authorization: user.token } });
    },
    getSecured(email, password) {
        return AXIOS.post(`/login`,{
                email: email,
                password: password
            });
    },
    getUser(user) {
        return AXIOS.get(`/user/` + user.userId,{ headers: { Authorization: user.token } });
    },
    getOrganization(user) {
        console.log(user);
        return AXIOS.get(`/organization/` + user.id, { headers: { Authorization: user.token } });
    },
    updateOrganization(organization,token) {
        console.log(organization);
        return AXIOS.put(`/organization/`+organization.id,
            { name:organization.name,
                    summary:organization.summary,
                    phone:organization.phone,
                    web:organization.web,
                    causes:[...organization.causes]},
            { headers: { Authorization: token } }
            );
    },
    getCauseList(user) {
        return AXIOS.get(`/reference/cause`,{ headers: { Authorization: user.token } });
    }
}


