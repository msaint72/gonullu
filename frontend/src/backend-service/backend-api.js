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
    }
}


