<template>
  <div id="app">
    <mt-header title="首页">
      <mt-button  @click="clickFn"  icon="more" slot="right"></mt-button>
    </mt-header>
    <mt-swipe style="height: 200px">
      <mt-swipe-item><img width="375px" src="./assets/home.jpg"></mt-swipe-item>
      <mt-swipe-item><img width="375px" src="./assets/qian.jpg"></mt-swipe-item>
    </mt-swipe>
    <mt-home></mt-home>
    <mt-edit></mt-edit>
  </div>
</template>

<script>
  import mtEdit from './components/Edit.vue'
  import mtHome from './components/Home.vue'
  import MtSwipe from "../node_modules/mint-ui/packages/swipe/src/swipe.vue";
  import MtCellSwipe from "../node_modules/mint-ui/packages/cell-swipe/src/cell-swipe.vue";
  import MtSwipeItem from "../node_modules/mint-ui/packages/swipe/src/swipe-item.vue";
export default {
  name: 'App',
  components:{
    MtSwipeItem,
    MtCellSwipe,
    MtSwipe,
    mtEdit,
    mtHome
  },
  methods: {
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
