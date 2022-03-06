import Vue from "vue";
import VueRouter from 'vue-router'
import Index from "@/views/Index";
import AllArticles from "@/views/AllArticles";
import Classes from "@/views/Classes";
import Schedule from "@/views/Schedule";

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        component: Index
    },
    {
        path: '/allArticles',
        component: AllArticles
    },
    {
        path: '/classes',
        component: Classes
    },
    {
        path: '/schedule',
        component: Schedule
    }
]
const router = new VueRouter({
    // mode:"history",
    routes
})

export default router
