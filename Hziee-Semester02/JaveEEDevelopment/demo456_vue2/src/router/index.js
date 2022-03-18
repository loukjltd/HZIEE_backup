import Vue from "vue";
import Router from 'vue-router';
import Home from '../components/Home';
import Login from '../components/Login';
import HelloWorld from "../components/HelloWorld";
Vue.use(Router);

Router.prototype.goBack = function () {
    this.isBack = true
    window.history.go(-1)
}
export default new Router({
    routes: [
        {
            path: '/',
            name: 'Login',
            component: Login
        },
        {
            path: '/',
            name: 'Home',
            component: Home
        },
        {
            path: '/',
            name: 'HelloWorld',
            component: HelloWorld
        }
    ]
})