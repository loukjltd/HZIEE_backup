import Vue from 'vue'
import Router from 'vue-router'
// import MyFirstVue from "@/components/MyFirstVue";
import HelloWorld from "@/components/HelloWorld";
import ElPut from "@/components/ElPut";

Vue.use(Router)
Router.prototype.goBack = function () {
    this.isBack = true
    window.history.go(-1)
}
export default new Router({
    routes: [
        {
            path: '/',
            name: 'ElPut',
            component: ElPut
        },
        {
            path: '/',
            name: 'HelloWorld',
            component: HelloWorld
        },
    ]
})