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
import App from '../components/app.vue'
import Qingjia_t from '../components/Qingjia_t.vue'
import Update from '../components/Update.vue'
import Xgpwd from '../components/Xgpwd.vue'
import Exit from '../components/Exit.vue'
import Blank from '../components/Blank.vue'
import Student from '../components/Student.vue'

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
    {
      path:'/app',
      name:'app',
      component:App,
    },
    {
      path:'/qingjia_t',
      name:'qingjia_t',
      component:Qingjia_t,
    },
    {
      path:'/update',
      name:'update',
      component:Update,
    },
    {
      path:'/xgpwd',
      name:'xgpwd',
      component:Xgpwd,
    },
    {
      path:'/exit',
      name:'exit',
      component:Exit,
    },
    {
      path:'/blank',
      name:'blank',
      component:Blank,
    },
    {
      path:'/student',
      name:'student',
      component:Student
    }
  ],
  mode:'history'
})
