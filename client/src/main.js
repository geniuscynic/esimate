import Vue from 'vue'
import '@/plugins/vant.js'
import * as filters from '@/plugins/filters.js'
import App from './App.vue'
import router from './router'
import store from './store'

Vue.config.productionTip = false
Object.keys(filters).forEach(key => {
    Vue.filter(key, filters[key])
  })

  
new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app')