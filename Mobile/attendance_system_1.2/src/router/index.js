import Vue from 'vue'
import Router from 'vue-router'
import Login from '../components/Login.vue'
import Register from '../components/Register.vue'
import Home from '../components/Home.vue'
import Record from '../components/Record.vue'
import Edit from '../components/Edit.vue'
import Home1 from '../components/Home1.vue'
import Qiandao from '../components/Qiandao.vue'
import Qingjia from '../components/Qingjia.vue'
import Course_stu from '../components/Course_stu.vue'
import Course_t from '../components/Course_t.vue'
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
    {
      path:'/qiandao',
      name:'Qiandao',
      component:Qiandao,
    },
    {
      path:'/qingjia',
      name:'Qingjia',
      component:Qingjia,
    },
    {
      path:'/Course_stu',
      name:'Course_stu',
      component:Course_stu,
    },
    {
      path:'/Course_t',
      name:'Course_t',
      component:Course_t,
    },
  ],
  mode:'history'
})
