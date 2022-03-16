import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui'
import './theme/index.css';
import 'element-ui/lib/theme-chalk/display.css';
import 'bootstrap/dist/css/bootstrap.min.css'
import axios from 'axios'
Vue.prototype.$http = axios

// router.afterEach((to,from,next)=>{
//   to
//   from
//   next
//   window.scrollTo(0,0)
//   console.log("跳转了！！！")
// })
router.afterEach((to,from,next) => {
  to
  from
  next
  document.body.scrollTop =0;
  document.documentElement.scrollTop = 0;
});
Vue.config.productionTip = false
Vue.use(ElementUI)
new Vue({
  render: h => h(App),
  router
}).$mount('#app')
