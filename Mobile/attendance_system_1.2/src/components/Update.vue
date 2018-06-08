<template>
  <div>
    <mt-header fixed title="修改个人信息" style="height: 50px;font-size: 18px;align-items: center">
      <router-link to="/edit" slot="left">
        <mt-button icon="back">返回</mt-button>
      </router-link>
    </mt-header>
    <div style="margin-top: 50px">
      <mt-field label="用户名"  v-model="userName" readonly></mt-field>
      <mt-field label="学号" type="text" v-model="sno" readonly v-if="this.userType=='student'"></mt-field>
      <mt-field label="工号" type="text" v-model="tno" readonly v-else></mt-field>
      <mt-field label="手机号"  type="tel" v-model="phone" readonly v-if="this.userType=='student'"></mt-field>
      <mt-field label="姓名" placeholder="请输入姓名" type="text" v-model="name" v-if="this.userType=='student'"></mt-field>
      <mt-field label="姓名" placeholder="请输入姓名" type="text" v-model="name" v-if="this.userType=='teacher'" readonly></mt-field>
      <mt-field label="性别" placeholder="请输入性别" type="text" v-model="sex"></mt-field>
      <mt-field label="手机号" placeholder="请输入手机号" type="tel" v-model="phone" v-if="this.userType=='teacher'"></mt-field>
      <mt-field label="邮箱" placeholder="请输入邮箱" type="email" v-model="mail"></mt-field>
      <mt-field label="学校" placeholder="请输入学校" type="text" v-model="school"></mt-field>
      <mt-field label="学院" placeholder="请输入学院" type="text" v-model="academy"></mt-field>
      <mt-field label="专业" placeholder="请输入专业" type="text" v-model="major" v-if="this.userType=='student'"></mt-field>
      <mt-field label="年级" placeholder="请输入年级" type="text" v-model="grade" v-if="this.userType=='student'"></mt-field>
      <mt-field label="备注"  type="textarea" rows="2" v-model="remark"></mt-field>
      <mt-button style="width: 150px;margin-top: 20px" type="primary"  @click.native="updateUser">保存</mt-button>
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
        userName:'',
        phone:'',
        sno:'',
        tno:'',
        mail:'',
        name:'',
        sex:'',
        school:'',
        academy:'',
        major:'',
        grade:'',
        remark:'',
        userType:store.fetch('User').userType,
        items:{}
      }
    },
    components:{
      MtButton,
      MtField,
    },
   mounted(){
      let data={
        username:store.fetch('User').username
      }
      if(store.fetch('User').userType=='student'){
      this.userName=store.fetch('User').username,
      this.sno=store.fetch('User').sno,
        this.phone=store.fetch('User').phone
     this.$http.post('/api/user/selectStudent',data).then((res)=>{
        this.mail=res.data[0].mail
       this.name=res.data[0].name
       this.sex=res.data[0].sex
       this.school=res.data[0].school
       this.academy=res.data[0].academy
       this.major=res.data[0].major
       this.grade=res.data[0].grade
       this.remark=res.data[0].remark
       console.log(res.data)
       console.log('success')
     })
      }
      else{
        this.userName=store.fetch('User').username;
        this.tno=store.fetch('User').tno;
        this.name=store.fetch('User').name
        this.$http.post('/api/user/selectTeacher',data).then((res)=>{
          this.mail=res.data[0].mail
          this.phone=res.data[0].phone
          this.sex=res.data[0].sex
          this.school=res.data[0].school
          this.academy=res.data[0].academy
          this.remark=res.data[0].remark
          console.log(res.data)
          console.log('success')
        })
      }
   },
    methods:{
     updateUser(){
       if(this.userType=='student'){
        let data={
          name:this.name,
          sex:this.sex,
          mail:this.mail,
          school:this.school,
          academy:this.academy,
          major:this.major,
          grade:this.grade,
          remark:this.remark,
          sno:this.sno
        }
        this.$http.post('/api/user/updateStudent',data).then((res)=>{
          Toast({
            title:'恭喜！',
            message:'修改成功！'
          })
          let data1=store.fetch('User')
          data1.name=this.name
          store.save('User',data1)
          this.$router.push({path:'/edit'})
          console.log('success')
       })
     }else if(this.userType=='teacher'){
         let data={
           phone:this.phone,
           sex:this.sex,
           school:this.school,
           mail:this.mail,
           academy:this.academy,
           remark:this.remark,
           tno:this.tno
         }
         this.$http.post('/api/user/updateTeacher',data).then((res)=>{
           Toast({
             title:'恭喜！',
             message:'修改成功！'
           })
           this.$router.push({path:'/edit'})
           console.log('success')
         })
       }
     },
      reBack:function () {
       if(this.userType=='student'){
         this.name=''
         this.major=''
         this.grade=''
       }else{
         this.phone=''
       }
       this.mail=''
       this.sex=''
       this.school=''
       this.academy=''
       this.remark=''
        //this.$router.push({path:'/edit'})
      },

    }
  }
</script>
<style>

</style>
