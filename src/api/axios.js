import axios from "axios";
// import config from "@/config";

const baseUrl = "http://localhost:8081/"
class HttpRequest{
    constructor(baseUrl) {
        this.baseUrl = baseUrl
    }

    getInsideConfig(){
        return {
            baseURL: this.baseUrl,
            header: {}
        }
    }
    interceptors(instance){
        instance.interceptors.request.use(function (config) {
            // 在发送请求之前做些什么
            return config;
        }, function (error) {
            // 对请求错误做些什么
            return Promise.reject(error);
        });

        instance.interceptors.response.use(function (response) {
            // 对响应数据做点什么
            return response;
        }, function (error) {
            // 对响应错误做点什么

            return Promise.reject(error);
        });
    }
    request(options){
        const instance = axios.create()
        options = {...this.getInsideConfig(), ...options}
        this.interceptors(instance)
        return instance(options)
    }
}
export default new HttpRequest(baseUrl)
