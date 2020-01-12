
import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/page/Home'
import Service from '@/page/Service'
import User from '@/page/User'
import Login from '@/page/Login'
import Protected from '@/page/Protected'

import store from './store'

Vue.use(Router);

// uris without hashes #, see https://router.vuejs.org/guide/essentials/history-mode.html#html5-history-mode
const routes =  [
    { path: '/', component: Home },
    { path: '/callservice', component: Service },
    { path: '/user', component: User },
    { path: '/login', component: Login },
    {
        path: '/protected',
        component: Protected,
        meta: {
            requiresAuth: true
        }
    },
    { path: '*', redirect: '/' }
];

const router = new Router({
    mode: 'history',
    routes
});

router.beforeEach((to, from, next) => {
    localStorage.setItem('lastRoute', to.fullPath);
    if (to.matched.some(record => record.meta.requiresAuth)) {
        // this route requires auth, check if logged in
        // if not, redirect to login page.
        if ( localStorage.getItem('isLoggedIn') != "true") {
            next({
                path: '/login'
            })
        } else {
            next();
        }
    } else {
        next(); // make sure to always call next()!
    }
});

export default router;