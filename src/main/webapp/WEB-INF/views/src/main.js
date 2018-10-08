import Vue from 'vue';
import VueRouter from 'vue-router';
import App from './app.vue';
import Router from './router';

Vue.use(VueRouter);

const router = new VueRouter({
    mode: 'history',
    routes: Router
});

new Vue ({
    el: "#app",
    render: h => h(App),
    router: router
});