import globalStore          from './globalStore.js';
import Vuex           from 'vuex';
import organizationStore  from './organizationStore.js'


export default new Vuex.Store({
    modules: {
        organizationStore
    },
    ...globalStore
});