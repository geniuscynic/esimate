import axios from 'axios'
import { Toast } from 'vant';
//import router from '@/router'
// import store from '@/store'

const service = axios.create({
    baseURL: process.env.VUE_APP_BASE_API, // url = base url + request url
    headers: {
        // 'Authorization': 'Bearer ' + store.state.token
    },
    // withCredentials: true, // send cookies when cross-domain requests
    timeout: 5000 // request timeout
})

// 添加响应拦截器
service.interceptors.response.use(function(response) {
    console.log("error1", response)
        // 对响应数据做点什么
    return response
}, function(error) {
    console.log("error", error.response)
    Toast.fail(error.response);
    // 对响应错误做点什么
    return Promise.reject(error)
});



export default service