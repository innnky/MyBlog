import Vue from "vue";
import VueRouter from 'vue-router'
import Index from "@/views/Index";
import AllArticles from "@/views/AllArticles";
import Classes from "@/views/Classes";
import Schedule from "@/views/Schedule";
import Article from "@/views/Article";
import MessageBoard from "@/views/MessageBoard";

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
        path: "/article/:aid",
        component: Article,

    },
    {
        path: "/message",
        component: MessageBoard
    }
]
const router = new VueRouter({
    // mode:"history",
    routes
})

export default router
