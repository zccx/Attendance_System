<template>
  <div>
    <mt-header fixed title="信息" style="height: 50px;font-size: 18px;align-items: center">
      <router-link to="/home" slot="left">
        <mt-button icon="back">返回</mt-button>
      </router-link>
    </mt-header>
    <mt-field></mt-field>
    <div style="padding-top: 10px;padding-bottom: 5px">
    <span  >共 {{this.items.length}} 条信息,未读消息 {{this.count}} 条</span>
    </div>
    <mt-cell title="请假信息"  is-link v-for="item in items" :key="item.id" v-if="item.isread==false" :to="{path:'/detail',query:{id:item.id}}" ></mt-cell>
    <mt-cell title="请假信息"  is-link v-for="item in items" :key="item.id" v-if="item.isread==true" :to="{path:'/detail',query:{id:item.id}}" style="color: #cccccc"></mt-cell>
</div>
</template>
<script>
  import store from './store'
  export default {
    data(){
      return {
        items:[],
        message:'请假',
        count:0
      }
    },
    mounted(){
      let data={
        sno:store.fetch('User').sno,
        isapproval:true,
      }
      this.$http.post('/api/user/select_Xx1',data).then((res)=>{
        for(var i=0;i<res.data.length;i++)
        {
          this.items.push(res.data[i])
          if(res.data[i].isread==false){
            this.count++;
          }
        }
      })
    },
    method:{
      toDetail:function(){
        this.$router.push({path:'/'})
      },
    }
  }
</script>
<style scoped>
  table, th , td  {
    border: 1px solid grey;
    border-collapse: collapse;
    padding: 5px;
  }
  table tr:nth-child(odd) {
    background-color: #f1f1f1;
  }
  table tr:nth-child(even) {
    background-color: #ffffff;
  }
</style>
