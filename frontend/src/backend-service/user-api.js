import axios from 'axios/index'

const AXIOS = axios.create({
  baseURL: `/api`
});


export default {
    getUser(userId) {
        return AXIOS.get(`/user/` + userId);
    },
    createUser(firstName, lastName,email, password) {
        return AXIOS.post(`/user/`,{
            firstName: firstName,
            lastName:lastName,
            email:email,
            password:password
        });
    },
    getSecured(email, password) {
        return AXIOS.post(`/secured/`,{
                email: email,
                password: password
            });
    }
}


