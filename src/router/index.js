import Vue from "vue";
import VueRouter from 'vue-router'
import Index from "@/views/Index";
import AllArticles from "@/views/AllArticles";
import Classes from "@/views/Classes";
import Schedule from "@/views/Schedule";
import Article from "@/views/Article";

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
    },
    {
        path: "/article",
        component: Article
    }
]
const router = new VueRouter({
    // mode:"history",
    routes
})

export default router
