<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<script>
  import store from './components/store'
export default {
  name: 'App',
  mounted(){
    var islogin=store.fetch('User').islogin;
    var userType=store.fetch('User').userType;
    if(islogin==true){
      if(userType=='student'){
        this.$router.push({path:'/home'})
      }else if(userType=='teacher'){
        this.$router.push({path:'/home1'})
      }
    }
  }
}
</script>

<style>
  /*@import '~vux/src/styles/reset.less';*/
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
