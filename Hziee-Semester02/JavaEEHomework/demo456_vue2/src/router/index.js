import Vue from 'vue'
import Router from 'vue-router'
// import Home from '../components/Home'
// import Login from "@/components/Login";
// import HelloWorld from "@/components/HelloWorld";
// import PdfScanCodeInWarehouse from "@/components/PdfScanCodeInWarehouse";
import GetUserInfo from "@/components/display_pages/GetUserInfo";
Vue.use(Router)

Router.prototype.goBack = function () {
    this.isBack = true
    window.history.go(-1)
}

export default new Router({
    routes: [
        {
            path: '/',
            name: 'GetUserInfo',
            component: GetUserInfo
        },
        {
            path: '/MenuList',
            name: 'MenuList',
            component: () => import('@/components/display_pages/MenuList')
        },
        {
            path: '/ShoppingCart',
            name: 'ShoppingCart',
            component: () => import('@/components/display_pages/ShoppingCart')
        },
        {
            path: '/FinishedOrders',
            name: 'FinishedOrders',
            component: () => import('@/components/display_pages/FinishedOrders')
        },
        {
            path: '/ChooseToPay',
            name: 'ChooseToPay',
            component: () => import('@/components/display_pages/ChooseToPay')
        }
        // {
        //     path: '/',
        //     name: 'PdfScanCodeInWarehouse',
        //     component: PdfScanCodeInWarehouse
        // },
        // {
        //     path: '/',
        //     name: 'Login',
        //     component: Login
        // },
        // {
        //     path: '/',
        //     name: 'HelloWorld',
        //     component: HelloWorld
        // },
        // {
        //     path: '/',
        //     name: 'Home',
        //     component: Home
        // },
    ]
})
