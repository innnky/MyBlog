import axios from "./axios";
export const getIndexInformation = () => {
  return axios.request({
      url: "/indexInformation",
      method: "get"
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
export const getMall = (param) => {
    return axios.request({
        url:'/mall/getMall',
        method: 'get',
        params:param
    })
}