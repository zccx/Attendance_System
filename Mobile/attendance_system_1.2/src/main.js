// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import  VueResource  from 'vue-resource'
import VueRouter from 'vue-router'
import Mint from 'mint-ui';
import { Button } from 'mint-ui';

Vue.component(Button.name, Button);
Vue.use(Mint);
Vue.use(VueResource)
Vue.use(VueRouter)

Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
