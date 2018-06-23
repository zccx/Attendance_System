<template>
  <div id="Home" >
    <mt-header fixed title="首页-教师" style="height: 50px;font-size: 18px;align-items: center">
      <!--<mt-button style="height: 30px"  slot="right" @click="exit"><a style="font-size: 15px">退出</a></mt-button>-->
    </mt-header>
    <mt-swipe style="height: 300px">
      <mt-swipe-item><img src="../assets/home1.jpg"></mt-swipe-item>
      <mt-swipe-item><img src="../assets/home2.jpg"></mt-swipe-item>
      <mt-swipe-item><img src="../assets/home3.jpg"></mt-swipe-item>
      <mt-swipe-item><img src="../assets/home4.jpg"></mt-swipe-item>
    </mt-swipe>

    <table style="width:100%">
      <tr style="height: 150px">
        <td>
          <img src="../assets/1.png"/><br/>
          <router-link to="/release" style="text-decoration: none"><a  style="text-align: center">发布签到</a></router-link>
        </td>
        <td>
          <div class="wrap">
            <div><img src="../assets/3.png"/>
              <router-link to="/qingjia_t" style="text-decoration: none"><a style="text-align: center">请假管理</a></router-link></div>

            <div class="notice" v-if="this.data1.length!=0">{{this.data1.length}}</div>
          </div>
          <!--<img src="../assets/3.png"/><br/>-->
          <!--<router-link to="/qingjia_t" style="text-decoration: none"><a style="text-align: center">请假管理</a></router-link>-->
        </td>
      </tr>
      <tr style="height: 150px">
        <td>
          <img src="../assets/6.png"/><br/>
          <router-link to="/Course_t" style="text-decoration: none"><a style="text-align: center">课程管理</a></router-link>
        </td>
        <td>
          <img src="../assets/5.png"/><br/>
          <router-link to="/record_t" style="text-decoration: none"><a style="text-align: center">签到记录</a></router-link>
        </td>
      </tr>
    </table>

    <mt-tabbar>
      <mt-tab-item id="消息" >
        <img slot="icon" src="../assets/email-filling.png" >
        消息
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
  import MtPopup from "../../node_modules/mint-ui/packages/popup/src/popup.vue";
  import store from './store'
  export default {
    components: {
      MtPopup,
      MtTabbar,
      MtTabItem,
      MtSwipe,
      MtSwipeItem,
      MtHeader,
    },
    name:'Home',
    data(){
      return{
        data1:[]
      }
    },
    mounted(){
      let data={
        tno:store.fetch('User').tno
      }
      this.$http.post('/api/user/selectCourse_t',data).then((res)=>{
        var length=res.data.length
        for(var i=0;i<length;i++){
          let data={
            cno:res.data[i].cno,
            isapproval:false
          }
          this.$http.post('/api/user/selectQingjia',data).then((res)=>{
            var _this=this
            if(res.data!='无'){
              for(var i=0;i<res.data.length;i++){
                var _this=this
                _this.data1.push(res.data[i]);
              }
            }
          })
        }
      })
    },
    methods:{
      clickFn:function () {
        this.$router.push({ path: 'edit' })
      },
      exit:function () {
        let userdata=store.fetch('User')
        userdata.islogin=false
        store.save('User',userdata)
        this.$router.push({path:'/'})
      }
    }

  }
</script>

<style>
  .popup-backdrop {
  }
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
