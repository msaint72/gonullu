import Home from '@/page/Home'
import Service from '@/page/Service'
import User from '@/page/User'
import Login from '@/page/Login'
import Protected from '@/page/Protected'
import Profile from '@/page/Profile'

// uris without hashes #, see https://router.vuejs.org/guide/essentials/history-mode.html#html5-history-mode
const PATHS = {
    HOME : '/',
    SERVICE : '/callservice',
    USER_PAGE : '/user',
    LOGIN : '/login',
    PROTECTED : '/protected',
    PROFILE : '/profile',
}
const routes =  [
    { path: PATHS.HOME, component: Home },
    { path: PATHS.SERVICE, component: Service },
    { path: PATHS.USER_PAGE, component: User },
    { path: PATHS.LOGIN, component: Login },
    { path: PATHS.PROFILE, component: Profile },
    {
        path: '/protected',
        component: Protected,
        meta: {
            requiresAuth: true
        }
    },
    { path: '*', redirect: '/' }
];
export  {routes, PATHS as URL_PATH};