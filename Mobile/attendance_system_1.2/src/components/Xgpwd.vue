<template>
  <div>
    <mt-header fixed title="修改密码" style="height: 50px;font-size: 18px;align-items: center">
      <router-link to="/edit" slot="left">
        <mt-button icon="back">返回</mt-button>
      </router-link>
    </mt-header>
    <div style="margin-top: 50px">
      <mt-field label="原密码" type="password"  v-model="password" ></mt-field>
      <mt-field label="新密码" type="password" v-model="npassword" ></mt-field>
      <mt-field label="确认密码"  type="password" v-model="apassword" ></mt-field>
      <mt-button style="width: 150px;margin-top: 20px" type="primary"  @click.native="changePwd()">保存</mt-button>
      <mt-button style="width: 150px" type="default" @click="reBack()">重置</mt-button>
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
        password:'',
        npassword:'',
        apassword:''
      }
    },
    components:{
      MtButton,
      MtField,
    },
    methods:{
      changePwd(){
        var pwd=store.fetch('User').pwd
        if(this.password==''||this.npassword==''||this.apassword==''){
          Toast({
            title:'错误',
            message:'输入不能为空！'
          })
        }
        else if(this.password != pwd){
          Toast({
            title:'错误',
            message:'原密码错误！'
          })
        }else if(this.apassword!=this.npassword){
          Toast({
            title:'错误',
            message:'两次密码不一致！'
          })
        }else if(this.password==this.npassword){
          Toast({
            title:'错误',
            message:'新旧密码不能一样！'
          })
        }
        else{
          let data={
            password:this.npassword,
            username:store.fetch('User').username
          }
          this.$http.post('/api/user/update_pwd',data).then((res)=>{
            console.log('hello')
            Toast({
              title:'成功',
              message:'修改成功！'
            })
            let data1=store.fetch('User')
            data1.pwd=this.npassword
            store.save('User',data1)
            this.$router.push({path:'/edit'})
          })
        }
      },
      reBack(){
        this.password=''
        this.apassword=''
        this.npassword=''
        //this.$router.push({path:'/edit'})
      }
    }
  }
</script>
<style>

</style>
