import axios from 'axios/index'

const AXIOS = axios.create({
  baseURL: `/api`,
  timeout: 3000
});


export default {
    hello() {
        return AXIOS.get(`/hello`);
    },
    getSecured(email, password) {
        return AXIOS.post(`/secured/`,{
                email: email,
                password: password
            });
    },
    getUser(user) {
        console.log(user);
        return AXIOS.get(`/user/` + user.userId, { headers: { Authorization: user.token } });
    },
    getOrganization(user) {
        console.log(user);
        return AXIOS.get(`/organization/` + user.id, { headers: { Authorization: user.token } });
    },
    updateOrganization(organization,token) {
        console.log(organization);
        console.log(token);
        return AXIOS.put(`/organization/`+organization.id,
            { name:organization.name,
                    summary:organization.summary},
            { headers: { Authorization: token } }
            );
    }
}


