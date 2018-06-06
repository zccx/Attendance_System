<template>
  <div>
    <mt-header fixed title="完善个人信息" style="height: 50px;font-size: 18px;align-items: center">
    </mt-header>
    <div style="margin-top: 50px">
      <mt-field label="用户名"  v-model="userName" readonly></mt-field>
      <mt-field label="学号" type="text" v-model="sno" readonly></mt-field>
      <mt-field label="手机号"  type="tel" v-model="phone" readonly></mt-field>
      <mt-field label="邮箱" placeholder="请输入邮箱" type="email" v-model="mail"></mt-field>
      <mt-field label="姓名" placeholder="请输入姓名" type="text" v-model="name"></mt-field>
      <mt-field label="学校" placeholder="请输入学校" type="text" v-model="school"></mt-field>
      <mt-field label="学院" placeholder="请输入学院" type="text" v-model="academy"></mt-field>
      <mt-field label="专业" placeholder="请输入专业" type="text" v-model="major"></mt-field>
      <mt-field label="年级" placeholder="请输入年级" type="text" v-model="grade"></mt-field>
      <mt-field label="备注"  type="textarea" rows="2" v-model="remark"></mt-field>
      <mt-button style="width: 150px;margin-top: 20px" type="primary"  @click.native="updateUser">保存</mt-button>
      <mt-button style="width: 150px" type="default" @click="reBack()">取消</mt-button>
    </div>
  </div>
</template>
<script>
  import { Toast } from 'mint-ui';
  import MtField from "../../node_modules/mint-ui/packages/field/src/field.vue";
  import MtButton from "../../node_modules/mint-ui/packages/button/src/button.vue";
  import store from './store'
 export default {
    data(){
      return{
        userName:'',
        phone:'',
        sno:'',
        mail:'',
        name:'',
        school:'',
        academy:'',
        major:'',
        grade:'',
        remark:''
      }
    },
    components:{
      MtButton,
      MtField
    },
   mounted(){
      let data=store.fetch('User')
     this.userName=data.username;
     this.sno=data.sno;
     this.phone=data.phone;
   },
    methods:{
     updateUser(){

     },
      reBack:function () {
        this.$router.push({path:'/edit'})
      },

    }
  }
</script>
<style>

</style>
