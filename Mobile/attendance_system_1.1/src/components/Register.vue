<template>
  <div>
    <mt-header title="注册" style="height: 50px;font-size: 18px;align-items: center">
    </mt-header>
    <br/>
    <mt-field label="用户名" placeholder="请输入用户名" v-model="username"></mt-field>
    <mt-field label="邮箱" placeholder="请输入邮箱" type="email" v-model="email"></mt-field>
    <mt-field label="密码" placeholder="请输入密码" type="password" v-model="password"></mt-field>
    <mt-field label="确认密码" placeholder="请再输入一次密码" type="password" v-model="password1"></mt-field>
    <mt-field label="手机号" placeholder="请输入手机号" type="tel" v-model="phone"></mt-field>
    <mt-field label="姓名" placeholder="请输入姓名" type="url" v-model="name"></mt-field>
    <mt-field label="专业" placeholder="请输入专业" type="url" v-model="zhuanye"></mt-field>
    <mt-field label="年级" placeholder="请输入年级" type="url" v-model="grade"></mt-field>
    <mt-field label="生日" placeholder="请输入生日" type="date" v-model="birthday"></mt-field>
    <mt-field label="备注"  type="textarea" rows="4" v-modal="note"></mt-field>
    <mt-button style="width: 150px" type="primary" @click.native="save()">保存</mt-button>
    <mt-button style="width: 150px" type="default" @click="reBack()">取消</mt-button>
  </div>
</template>
<script>

  import { AlertModule, Alert } from 'vux';
  import { Toast } from 'mint-ui';
  export  default {
    components:{
        Alert
    },
    methods:{
      reBack:function () {
        this.$router.push({path:'/login'})
      },
      save:function () {
        Toast({
          title:'恭喜！',
          message: '注册成功！',

        });
        this.$router.push({path:'/login'})
      }
    }
  }
</script>
<style>

</style>
