<template>
  <div>
    <!--<mt-header fixed title="Login" style="height: 50px;font-size: 18px;align-items: center;"></mt-header>-->
    <label style="font-size: 25px">Login</label><br/>
    <img style="width: 375px;margin-top: 10px" src="../assets/qian.jpg"/>
    <table style="width:375px;margin-top: 50px">
      <tr style="height: 50px;">
        <td style="width: 150px;">
          <label style="font-size: 20px"><b>用户名：</b></label>
        </td>
        <td style="width: 225px;">
          <input type="text"  placeholder="请输入用户名" style="height: 30px;border: hidden" v-model="username">
        </td>
      </tr>
      <tr style="height: 50px;">
        <td style="width: 150px;align-content:flex-end">
          <label style="font-size: 20px"><b>密  码：</b></label>
        </td>
        <td style="width: 225px;">
          <input type="password" placeholder="请输入密码" style="height: 30px;border: hidden" v-model="password">
        </td>
      </tr>
      <tr style="height: 50px;">
        <td style="width: 150px;align-content:flex-end">
          <label style="font-size: 20px"><b>登录类型：</b></label>
        </td>
        <td style="width: 225px;">
          <select style="height: 40px;width: 180px;" v-model="userType" >
            <option value="student" selected="selected" >我是学生</option>
            <option value="teacher">我是老师</option>
          </select>
        </td>
      </tr>
    </table>

    <!--<mt-radio-->
      <!--v-model="userType"-->
      <!--:options="['我是学生', '我是老师']">-->
    <!--</mt-radio>-->
    <br/>
    <mt-button style="width: 150px;height: 40px;" type="primary" @click="toLogin">登录</mt-button>
    <mt-button style="width: 150px;height: 40px;margin-left: 20px" type="default" @click="toRegister()">注册</mt-button>
    <br/>
    <div style="margin-top: 100px">
      <router-link to="/" ><a style="text-align: center">其他方式登录</a></router-link>
    </div>
  </div>
</template>
<script>
  import MtButton from "../../node_modules/mint-ui/packages/button/src/button.vue";
  import MtHeader from "../../node_modules/mint-ui/packages/header/src/header.vue";
  import { Toast } from 'mint-ui';
  export  default {
    data(){
      return{
        username:'',
        password:'',
        userType:''
      }
    },
    components: {
      MtHeader,
      MtButton},
    methods:{
      toLogin() {
        var username = this.username;
        var password =this.password;
        let data = {
          username:username,
          password:password
        }
        if(this.username==""||this.password=="")
        {
          Toast({
            title:'错误！',
            message: '用户名和密码不能为空！',
          });
        }else{
          if(this.userType=='student'){
            this.$http.post('/api/user/selectStudent',data).then((res)=>{
              console.log(res);
              if(res.data == -1) {
                Toast({
                  title:'错误！',
                  message: '用户名不存在！',
                });
              }else if(res.data == 0){
                Toast({
                  title:'错误！',
                  message: '密码错误！',
                });
              }else{
                this.$router.push({path:'/home'})
              }
            })
          }
          else if(this.userType=='teacher'){
            this.$http.post('/api/user/selectTeacher',data).then((res)=>{
              console.log(res);
              if(res.data == -1) {
                Toast({
                  title:'错误！',
                  message: '用户名不存在！',
                });
              }else if(res.data == 0){
                Toast({
                  title:'错误！',
                  message: '密码错误！',
                });
              }else{
                this.$router.push({path:'/home1'})
              }
            })
          }
        }
      },
      toRegister:function () {
        this.$router.push({path:'/Register'})
      }
    }
  }
</script>
<style>

</style>
