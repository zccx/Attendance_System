<template>
  <div style="margin-top: 5px">
    <!--<mt-header fixed title="Login" style="height: 50px;font-size: 18px;align-items: center;"></mt-header>-->
    <label style="font-size: 25px">Login</label><br/>
    <img style="width: 100%;margin-top: 10px" src="../assets/qian.jpg"/>
    <table style="width: 100%;margin-top: 50px">
      <tr style="height: 50px;">
        <td style="width: 40%;">
          <label style="font-size: 18px"><b>用户名：</b></label>
        </td>
        <td style="width: 60%;">
          <input type="text"  placeholder="请输入用户名" style="height: 30px;border: hidden" v-model="username">
        </td>
      </tr>
      <tr style="height: 50px;">
        <td style="">
          <label style="font-size: 18px"><b>密  码：</b></label>
        </td>
        <td style="">
          <input type="password" placeholder="请输入密码" style="height: 30px;border: hidden" v-model="password">
        </td>
      </tr>
      <tr style="height: 50px;">
        <td style="">
          <label style="font-size: 18px"><b>登录类型：</b></label>
        </td>
        <td style="">
          <select style="height: 30px;width: 180px" v-model="userType" >
            <option value="student" selected="selected" >学生</option>
            <option value="teacher">老师</option>
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
  import store from './store'
  export  default {
    data(){
      return{
        username:'',
        password:'',
        userType:'student',
    //    items: store.fetch('user')
      }
    },
    components: {
      MtHeader,
      MtButton},
//    watch: {
//      items: {
//        handler: function(val, oldVal) {
//          store.save('user',val);
//        },
//        deep: true
//      }
//    },
    methods:{
      toLogin() {
        var thisday=''
        var myDate = new Date();
        myDate.getYear();        //获取当前年份(2位)
        myDate.getFullYear();    //获取完整的年份(4位,1970-????)
        myDate.getMonth();       //获取当前月份(0-11,0代表1月)
        myDate.getDate();        //获取当前日(1-31)
        var mytime1=myDate.getDay();         //获取当前星期X(0-6,0代表星期天)
        myDate.getTime();        //获取当前时间(从1970.1.1开始的毫秒数)
        var mytime2=myDate.getHours();       //获取当前小时数(0-23)
        var mytime3=myDate.getMinutes();     //获取当前分钟数(0-59)
        myDate.getSeconds();     //获取当前秒数(0-59)
        myDate.getMilliseconds();    //获取当前毫秒数(0-999)
        myDate.toLocaleDateString();     //获取当前日期
        var mytime=myDate.toLocaleTimeString();     //获取当前时间
        myDate.toLocaleString();        //获取日期与时间
        switch (mytime1){
          case 0:
            thisday='星期天';
            break;
          case 1:
            thisday='星期一';
            break;
          case 2:
            thisday='星期二';
            break;
          case 3:
            thisday='星期三';
            break;
          case 4:
            thisday='星期四';
            break;
          case 5:
            thisday='星期五';
            break;
          case 6:
            thisday='星期六';
            break;
        }
        if(mytime3<10){
          console.log(thisday+" "+mytime2+":0"+mytime3);
        }
        console.log(mytime1);
        console.log(thisday);

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
                var sno=res.data[0].sno
                var name=res.data[0].name
                console.log(sno)
               let Userdata={
                  name:name,
                  username: this.username,
                  pwd:this.password,
                  sno:sno,
                  userType:'student',
                  islogin:true,
                }
                //var loginname=res.data[0].username
                store.save('User',Userdata)
              //  this.items.push({'name': this.username});
                this.$router.push({path:'/home'})
                console.log(name);
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
                store.save('User',{
                  'name':res.data[0].name,
                  'tno':res.data[0].tno,
                  'username': this.username,
                  'pwd':this.password,
                  'userType':'teacher',
                  'islogin':true})
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
