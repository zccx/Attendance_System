// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import MintUI from 'mint-ui'
import 'mint-ui/lib/style.css'
import HelloWorld from './components/HelloWorld.vue'
import router from './router'
import Home from './components/Home.vue'

Vue.use(MintUI)
Vue.config.productionTip = false

//配置路由
// const router =new VueRouter({
//     routes:[
//       {path:"/",component:Home},
//       {path:"/helloword",component:HelloWorld}
//     ],
//     mode:"history",
// })
/* eslint-disable no-new */

new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
