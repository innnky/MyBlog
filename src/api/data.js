import axios from "./axios";
export const getIndexInformation = () => {
    return axios.request({
        url: "/indexInformation",
        method: "get"
    })
}
export const getAllArticle = (param) => {
    return axios.request({
        url: "/all/article",
        method: "get",
        params:param
    })
}
export const getMenu = (param) =>{
    return axios.request({
        url:'/permission/getMenu',
        method: 'post',
        data:param
    })
}
export const getData = () =>{
    return axios.request({
        url:'/home/getData'
    })
}
export const editUser = (param) => {
    return axios.request({
        url:'/user/editUser',
        method: 'post',
        data:param
    })
}
export const addUser = (param) => {
    return axios.request({
        url:'/user/addUser',
        method: 'post',
        data:param
    })
}
export const getUser = (param) => {
    return axios.request({
        url:'/user/getUser',
        method: 'get',
        params:param
    })
}
export const delUser = (param) => {
    return axios.request({
        url:'/user/delUser',
        method: 'post',
        data:param
    })
}
export const getArticleDetail = (id) => {
    return axios.request({
        url:`/article/${id}`,
        method: 'get',
    })
}

export const getCommentByArticle = (id)=>{
    return axios.request({
        url:`/comment/article/${id}`,
        method: 'get'
    })
}
export const insertComment = (param)=>{
    return axios.request({
        url:`/comment/`,
        method: 'post',
        params: param
    })
}