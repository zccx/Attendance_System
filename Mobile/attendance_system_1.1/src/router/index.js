import Vue from 'vue'
import Router from 'vue-router'
import Edit from '../components/Edit.vue'
import HelloWorld from '@/components/HelloWorld'
import Home from '../components/Home.vue'
import Record from '../components/Record.vue'
import Login from '../components/Login.vue'
import Register from '../components/Register.vue'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path:'/',
      name:'Home',
      component:Home
    },
    {
      path: '/helloworld',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/edit',
      name: 'Edit',
      component: Edit
    },
    {
      path: '/record',
      name: 'Record',
      component: Record
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/register',
      name: 'Register',
      component: Register
    }
  ],
  mode:"history"
})

