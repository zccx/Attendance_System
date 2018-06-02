<template>
  <div>
    <mt-header fixed title="课程信息" style="height: 50px;font-size: 18px;align-items: center">
      <router-link to="/home1" slot="left">
        <mt-button icon="back">返回</mt-button>
      </router-link>
    </mt-header>
    <mt-cell-swipe
      :right="rightButtons"
      title="自然辩证法"
      style="margin-top: 50px">
      <ul>
        <li >1-12周</li>
        <li>周一</li>
        <li>15:50-17:30</li>
      </ul>
    </mt-cell-swipe>
    <mt-cell-swipe
      :right="rightButtons"
      title="工程实践">
      <ul>
        <li >1-12周</li>
        <li>周一</li>
        <li>15:50-17:30</li>
      </ul>
    </mt-cell-swipe>
    <mt-cell-swipe
      :right="rightButtons"
      title="智能技术">
      <ul>
        <li >1-12周</li>
        <li>周一</li>
        <li>15:50-17:30</li>
      </ul>
    </mt-cell-swipe>
    <mt-cell-swipe
      :right="rightButtons"
      title="工程实践">
      <ul>
        <li >1-12周</li>
        <li>周一</li>
        <li>15:50-17:30</li>
      </ul>
    </mt-cell-swipe>
  </div>
</template>
<script>
  import MtField from "../../node_modules/mint-ui/packages/field/src/field.vue";

  export default {
    components: {
      MtField

    },
    created() {
      this.rightButtons = [
        {
          content: '管理',
          style: { background:'#00BFFF', color: '#fff' }
        },
        {
          content: '删除',
          style: { background: 'red', color: '#fff' },
          handler: () => this.$messagebox('delete')
        }
      ];
    },
    methods: {
      leftButtonHandler(evt) {
        console.log(123);
      }
    }
  }
</script>
<style>
  li{
    height: 20px;
  }
</style>
