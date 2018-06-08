<template>
<div>

</div>
</template>
<script>
  import store from './store'
  export default {
    data(){
      return{
        data:{}
      }
    },
    mounted(){
     let data=store.fetch('User')
      data.islogin=false
      data.name=''
      data.username=''
      data.pwd=''
      data.sno=''
      data.userType=''
      data.phone=''
      console.log(data)
      store.save('User',data)
      this.$router.push({path:'/'})
    }
  }
</script>
<style>

</style>
