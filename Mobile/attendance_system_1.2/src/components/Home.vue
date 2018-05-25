<template>
  <div id="Home" >
    <mt-header fixed title="首页-学生" style="height: 50px;font-size: 18px;align-items: center">
      <mt-button style="height: 30px"  slot="right" @click="exit"><a style="font-size: 15px">退出</a></mt-button>
      <!--<mt-button style="height: 30px"   icon="more" slot="right"></mt-button>-->
    </mt-header>
    <mt-swipe style="height: 300px">
      <mt-swipe-item><img src="../assets/home1.jpg"></mt-swipe-item>
      <mt-swipe-item><img src="../assets/home2.jpg"></mt-swipe-item>
      <mt-swipe-item><img src="../assets/home3.jpg"></mt-swipe-item>
      <mt-swipe-item><img src="../assets/home4.jpg"></mt-swipe-item>
    </mt-swipe>

    <table style="width: 375px">
      <tr style="height: 150px">
        <td>
          <img src="../assets/1.png"/><br/>
          <router-link to="/" style="text-decoration: none"><a  style="text-align: center">签到</a></router-link>
        </td>
        <td>
          <img src="../assets/3.png"/><br/>
          <router-link to="/" style="text-decoration: none"><a style="text-align: center">请假</a></router-link>
        </td>
      </tr>
      <tr style="height: 150px">
        <td>
          <img src="../assets/6.png"/><br/>
          <router-link to="/" style="text-decoration: none"><a style="text-align: center">课程</a></router-link>
        </td>
        <td>
          <img src="../assets/5.png"/><br/>
          <router-link to="/record" style="text-decoration: none"><a style="text-align: center">记录</a></router-link>
        </td>
      </tr>
    </table>
    <mt-tabbar>
      <mt-tab-item id="消息" >
        <img slot="icon" src="../assets/email-filling.png" >
        消息
      </mt-tab-item>
      <mt-tab-item id="我的">
        <img slot="icon" src="../assets/account-filling.png" @click="clickFn">
        我的
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

  export default {
    components: {
      MtTabbar,
      MtTabItem,
      MtSwipe,
      MtSwipeItem,
      MtHeader,
    },
    name:'Home',
    methods:{
      clickFn:function () {
        this.$router.push({path: 'edit'})
      },
      exit:function () {
        this.$router.push({path:'login'})
      }
    }

  }
</script>

<style>

</style>
