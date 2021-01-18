import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import * as axios from 'axios'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import { BTable, BPagination, BFormCheckbox, BForm, BButton } from 'bootstrap-vue'

Vue.component('b-button', BButton)
Vue.component('b-form', BForm)
Vue.component('b-checkbox', BFormCheckbox)
Vue.component('b-pigination', BPagination)
Vue.component('b-table', BTable)

Vue.config.productionTip = false
Vue.prototype.$axxios = axios

new Vue({
  router,
  store,
  axios,
  render: h => h(App)
}).$mount('#app')
