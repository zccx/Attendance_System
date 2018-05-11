<template>
  <div>
    <!--<mt-header fixed title="Login" style="height: 50px;font-size: 18px;align-items: center;"></mt-header>-->
    <label style="font-size: 25px">Login</label><br/>
    <img style="width: 400px" src="../assets/qian.jpg"/>
    <table style="width:350px;margin: 50px 35px">
      <tr style="height: 50px;">
        <td style="width: 150px;">
    <label style="font-size: 20px"><b>用户名：</b></label>
        </td>
        <td style="width: 200px;">
    <input type="text"  placeholder="请输入用户名" style="height: 30px;border: hidden">
        </td>
      </tr>
      <tr style="height: 50px;">
        <td style="width: 150px;">
    <label style="font-size: 20px"><b>密  码：</b></label>
        </td>
        <td style="width: 200px;">
    <input type="password" placeholder="请输入密码" style="height: 30px;border: hidden">
        </td>
      </tr>
    </table>
    <mt-button style="width: 150px" type="primary" @click="toLogin()">登录</mt-button>
    <mt-button style="width: 150px" type="default" @click="toRegister()">注册</mt-button>
    <br/>
    <div style="margin-top: 100px">
    <router-link to="/login" ><a style="text-align: center">其他方式登录</a></router-link>
    </div>
    <!--<mt-field label="用户名" placeholder="请输入用户名" v-model="username"></mt-field>-->
    <!--<mt-field label="密码" placeholder="请输入密码" type="password" v-model="password"></mt-field>-->
  </div>
</template>
<script>
export  default {
  methods:{
    toLogin:function () {
      this.$router.push({path:'/'})
    },
    toRegister:function () {
      this.$router.push({path:'/Register'})
    }
  }
}
</script>
<style>

</style>
