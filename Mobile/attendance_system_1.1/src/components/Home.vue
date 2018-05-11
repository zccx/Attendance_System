<template>
  <div id="Home" >
    <mt-header fixed title="首页" style="height: 50px;font-size: 18px;align-items: center">
      <mt-button style="height: 30px" @click="clickFn"  icon="more" slot="right"></mt-button>
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
          <router-link to="/"><a  style="text-align: center">签到</a></router-link>
        </td>
        <td>
          <img src="../assets/3.png"/><br/>
          <router-link to="/"><a style="text-align: center">请假</a></router-link>
        </td>
      </tr>
      <tr style="height: 150px">
        <td>
          <img src="../assets/6.png"/><br/>
          <router-link to="/"><a style="text-align: center">课程</a></router-link>
        </td>
        <td>
          <img src="../assets/5.png"/><br/>
          <router-link to="/record"><a style="text-align: center">记录</a></router-link>
        </td>
      </tr>
    </table>
    </div>
</template>

<script>
  import LoadMore from "../../node_modules/vux/src/components/load-more/index.vue";
  import MtHeader from "../../node_modules/mint-ui/packages/header/src/header.vue";
  import MtSwipeItem from "../../node_modules/mint-ui/packages/swipe/src/swipe-item.vue";
  import MtSwipe from "../../node_modules/mint-ui/packages/swipe/src/swipe.vue";

  export default {
    components: {
      MtSwipe,
      MtSwipeItem,
      MtHeader,
      LoadMore},
    name:'Home',
    methods:{
      clickFn:function () {
        this.$router.push({ path: 'edit' })
      }
    }

  }
</script>

<style>

</style>
