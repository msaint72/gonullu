import Vue from 'vue'
import Router from 'vue-router'
import {routes,URL_PATH} from './UrlMappings'

Vue.use(Router);

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
                path: URL_PATH.LOGIN
            })
        } else {
            next();
        }
    } else {
        next(); // make sure to always call next()!
    }
});

export default router;