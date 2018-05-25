<template>
  <div id="edit">
    <mt-header fixed title="编辑个人信息" style="height: 50px;font-size: 18px;align-items: center">
      <router-link to="/home" slot="left">
        <mt-button icon="back">返回</mt-button>
      </router-link>
    </mt-header>
    <br/>
    <div style="margin-top: 50px">
    <mt-field label="用户名" placeholder="请输入用户名" v-model="username"></mt-field>
    <mt-field label="邮箱" placeholder="请输入邮箱" type="email" v-model="email"></mt-field>
    <mt-field label="密码" placeholder="请输入密码" type="password" v-model="password"></mt-field>
    <mt-field label="手机号" placeholder="请输入手机号" type="tel" v-model="phone"></mt-field>
    <mt-field label="姓名" placeholder="请输入姓名" type="url" v-model="name"></mt-field>
    <mt-field label="专业" placeholder="请输入专业" type="url" v-model="zhuanye"></mt-field>
    <mt-field label="年级" placeholder="请输入年级" type="url" v-model="grade"></mt-field>
    <mt-field label="生日" placeholder="请输入生日" type="date" v-model="birthday"></mt-field>
    <mt-field label="备注"  type="textarea" rows="4" v-model="note"></mt-field>
    <mt-button style="width: 150px" type="primary">保存</mt-button>
    <mt-button style="width: 150px" type="default">取消</mt-button>
    </div>
  </div>
</template>

<script>
  import MtButton from "../../node_modules/mint-ui/packages/button/src/button.vue";

  export  default {
    components: {
      MtButton,
    },
    name:'edit'
  }
</script>

<style>

</style>
