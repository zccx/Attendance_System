<template>
  <div>
    <mt-header fixed title="注册" style="height: 50px;font-size: 18px;align-items: center">
    </mt-header>
    <div style="margin-top: 50px">
    <mt-field label="用户名" placeholder="请输入用户名" v-model="userName"></mt-field>
    <mt-field label="邮箱" placeholder="请输入邮箱" type="email" v-model="mail"></mt-field>
    <mt-field label="密码" placeholder="请输入密码" type="password" v-model="password"></mt-field>
    <mt-field label="确认密码" placeholder="请再输入一次密码" type="password" v-model="password1"></mt-field>
    <mt-field label="手机号" placeholder="请输入手机号" type="tel" v-model="phone"></mt-field>
    <mt-field label="姓名" placeholder="请输入姓名" type="text" v-model="name"></mt-field>
    <mt-field label="学校" placeholder="请输入学校" type="text" v-model="school"></mt-field>
    <mt-field label="学院" placeholder="请输入学院" type="text" v-model="academy"></mt-field>
    <mt-field label="专业" placeholder="请输入专业" type="text" v-model="major"></mt-field>
    <mt-field label="年级" placeholder="请输入年级" type="text" v-model="grade"></mt-field>
    <mt-field label="备注"  type="textarea" rows="2" v-model="remark"></mt-field>
    <mt-button style="width: 150px" type="primary" @click.native="saveUser">保存</mt-button>
    <mt-button style="width: 150px" type="default" @click="reBack()">取消</mt-button>
    </div>
    </div>
</template>
<script>
  import { Toast } from 'mint-ui';
  import MtField from "../../node_modules/mint-ui/packages/field/src/field.vue";
  import MtButton from "../../node_modules/mint-ui/packages/button/src/button.vue";
  export  default {
    data(){
      return{
        userName:'',
        password:'',
        password1:'',
        mail:'',
        phone:'',
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
    methods:{
      reBack:function () {
        this.$router.push({path:'/'})
      },
      saveUser() {
        var username = this.userName;
        var password = this.password;
        var password1 =this.password1;
        var mail = this.mail;
        var phone = this.phone;
        var name = this.name;
        var school = this.school;
        var academy = this.academy;
        var major = this.major;
        var grade = this.grade;
        var remark = this.remark;
        let data ={
          username: username,
          password: password,
          mail: mail,
          phone: phone,
          name: name,
          school: school,
          academy: academy,
          major: major,
          grade: grade,
          remark: remark,
          sex: '男'
        }
        if(this.userName==""||this.password=="")
        {
          Toast({
            title:'错误！',
            message: '用户名和密码不能为空！',
          });
        }
        else if(this.password!=this.password1){
          Toast({
            title:'错误！',
            message: '两次密码不一致！',
          });
        }
        else{
          this.$http.post('/api/user/addStudent',data).then((res) => {
          console.log(res);
//          console.log(res.result[0].password);
            if(res.data == -1) {
              Toast({
                title:'错误！',
                message: '用户名已存在！',
              });
              this.username = ''
            }
            else if(res.status == 200){
              this.username = ''
              Toast({
                title:'恭喜！',
                message: '注册成功！',
              });
              this.$router.push({path:'/'})
              /*注册成功之后再跳回登录页*/
              setTimeout(function(){
                this.showRegister = false
                this.showLogin = true
                this.showTishi = false
              }.bind(this),2000)
            }
        })
        }
      }
    }
  }
</script>
<style>

</style>
