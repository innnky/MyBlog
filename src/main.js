import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui'
import './theme/index.css';
import 'element-ui/lib/theme-chalk/display.css';
import 'bootstrap/dist/css/bootstrap.min.css'
import axios from 'axios'
Vue.prototype.$http = axios


Vue.config.productionTip = false
Vue.use(ElementUI)
new Vue({
  render: h => h(App),
  router
}).$mount('#app')
