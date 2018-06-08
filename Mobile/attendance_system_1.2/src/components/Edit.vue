<template>
  <div id="edit" >
    <mt-header fixed title="设置" style="height: 50px;font-size: 18px;align-items: center">
      <router-link to="/home" slot="left" v-if="this.userType=='student'">
        <mt-button icon="back">返回</mt-button>
      </router-link>
      <router-link to="/home1" slot="left" v-else>
        <mt-button icon="back">返回</mt-button>
      </router-link>
    </mt-header>
    <div style="margin-top: 50px;">
      <mt-cell
        title="完善个人信息"
        to="/update"
        is-link
        value=""
      >
      </mt-cell>
      <mt-cell
        title="修改密码"
        to="/xgpwd"
        is-link
        value="">
      </mt-cell>
    </div>
    <div style="margin-top: 50px;">
      <mt-cell
        title="联系电话:400-888-888"

        value=""
      >
      </mt-cell>
      <mt-cell
        title="版本号1.2.4"
        value=""
      style="align-content: center">
      </mt-cell>
    </div>
    <div style="margin-top: 50px;background-color: gainsboro">
      <mt-cell
        title="安全退出"
        to="/exit"
        is-link
        value="">
      </mt-cell>
    </div>
  </div>
</template>

<script>
  import MtButton from "../../node_modules/mint-ui/packages/button/src/button.vue";
  import store from './store'
  export  default {
    components: {
      MtButton,
    },
    name:'edit',
    data(){
      //let query=this.$route.query;
     return{
//      username:query.name,
//      email:'',
//      password:''
       userType:store.fetch('User').userType
     }
    },
    methods:{

    }
  }
</script>

<style>

</style>
