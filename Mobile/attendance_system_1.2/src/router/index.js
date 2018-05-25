import Vue from 'vue'
import Router from 'vue-router'
import Login from '../components/Login.vue'
import Register from '../components/Register.vue'
import Home from '../components/Home.vue'
import Record from '../components/Record.vue'
import Edit from '../components/Edit.vue'
import Home1 from '../components/Home1.vue'
import HelloWorld from '../components/HelloWorld.vue'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path:'/home',
      name:'/Home',
      component:Home,
    },
    {
      path: '/',
      name: 'Login',
      component: Login,
    },
    {
      path:'/register',
      name:'Register',
      component:Register,
    },
    {
      path:'/record',
      name:'Record',
      component:Record,
    },
    {
      path:'/edit',
      name:'Edit',
      component:Edit,
    },
    {
      path:'/home1',
      name:'Home1',
      component:Home1,
    },
  ],
  mode:'history'
})
