<template>
  <div id="Home" style="width: 100%;margin: 0px;padding: 0px">
    <mt-header fixed title="首页-学生" style="height: 50px;font-size: 18px;align-items: center">
      <!--<mt-button style="height: 30px"  slot="right" @click="exit"><a style="font-size: 15px">退出</a></mt-button>-->
      <!--<mt-button style="height: 30px"   icon="more" slot="right"></mt-button>-->
    </mt-header>
    <div style="width: 100%">
    <mt-swipe style="height: 300px;width: 100%">
      <mt-swipe-item><img src="../assets/home1.jpg" style="width: 100%"></mt-swipe-item>
      <mt-swipe-item><img src="../assets/home2.jpg" style="width: 100%"></mt-swipe-item>
      <mt-swipe-item><img src="../assets/home3.jpg" style="width: 100%"></mt-swipe-item>
      <mt-swipe-item><img src="../assets/home4.jpg" style="width: 100%"></mt-swipe-item>
    </mt-swipe>
    </div>
    <table style="width: 100%">
      <tr style="height: 120px">
        <td>
          <img src="../assets/1.png"/><br/>
          <router-link to="/Qiandao" style="text-decoration: none"><a  style="text-align: center">签到</a></router-link>
        </td>
        <td>
          <img src="../assets/3.png"/><br/>
          <router-link to="/Qingjia" style="text-decoration: none"><a style="text-align: center">请假</a></router-link>
        </td>
      </tr>
      <tr style="height: 120px">
        <td>
          <img src="../assets/6.png"/><br/>
          <router-link to="/Course_stu" style="text-decoration: none"><a style="text-align: center">课程</a></router-link>
        </td>
        <td>
          <img src="../assets/5.png"/><br/>
          <router-link to="/record" style="text-decoration: none"><a style="text-align: center">记录</a></router-link>
        </td>
      </tr>
    </table>
    <mt-tabbar>
      <mt-tab-item id="消息" >
        <img slot="icon" src="../assets/email-filling.png" @click="toXiaoxi">
        消息
        <mt-badge type="error" size="small" v-if="this.items.length!=0">{{this.items.length}}</mt-badge>
      </mt-tab-item>


      <mt-tab-item id="设置">
        <img slot="icon" src="../assets/set.png" @click="clickFn">
        设置
      </mt-tab-item>
    </mt-tabbar>
  </div>
</template>

<script>
  import MtHeader from "../../node_modules/mint-ui/packages/header/src/header.vue";
  import MtSwipeItem from "../../node_modules/mint-ui/packages/swipe/src/swipe-item.vue";
  import MtSwipe from "../../node_modules/mint-ui/packages/swipe/src/swipe.vue";
  import MtTabItem from "../../node_modules/mint-ui/packages/tab-item/src/tab-item.vue";
  import MtTabbar from "../../node_modules/mint-ui/packages/tabbar/src/tabbar.vue";
  import store from './store'
  export default {
    components: {
      MtTabbar,
      MtTabItem,
      MtSwipe,
      MtSwipeItem,
      MtHeader,
    },
    name:'Home',
    data(){
      return{
        items:{}
      }
    },
    mounted(){
      let data={
        sno:store.fetch('User').sno,
        isapproval:true,
        isread:false
      }
      console.log(data)
      this.$http.post('/api/user/select_xx',data).then((res)=>{
        this.items=res.data
        console.log(res.data)
      })
    },
    methods:{
      toXiaoxi:function(){
        this.$router.push({path:'xiaoxi_stu'})
      },
      clickFn:function () {
//        let query=this.$route.query;
//        var username=query.name;
//        console.log(username);
        this.$router.push({path: 'edit'})
      },
      exit:function () {
        let userdata=store.fetch('User')
        userdata.islogin=false
        console.log(userdata)
        store.save('User',userdata)
        this.$router.push({path:'/'})
      }
    }

  }
</script>

<style scoped>
  .wrap {
    width:70px;
    margin-bottom:-5px;
    margin-left: 55px;
    margin-right: -80px;
    position:relative;
  }
  .img {
    width:70px;
    height:50px;
    border:1px solid #000;
  }
  .notice {
    width:18px;
    height:18px;
    line-height:20px;
    font-size:8px;
    color:#fff;
    text-align:center;
    background-color:#f00;
    border-radius:50%;
    position:absolute;
    right:0px;
    top:-10px;
  }
</style>
