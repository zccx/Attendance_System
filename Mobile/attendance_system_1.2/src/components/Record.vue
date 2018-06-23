<template>
  <div id="record">
    <mt-header fixed title="签到记录" style="height: 50px;font-size: 18px;align-items: center">
      <router-link to="/home" slot="left">
        <mt-button icon="back">返回</mt-button>
      </router-link>
    </mt-header>
    <div v-if="this.items.length==0" style="margin-top: 200px">
      <a style="font-size: 25px">暂无任何签到记录</a>
    </div>
    <div v-else style="margin-top: 50px">
      <mt-cell-swipe

        :title="(index+1).toString()"
        v-for="(item,index) in items"
        :key="item.tno">
        <ul style="width: 250px" >
          <li>课程名称：{{item.course}}</li>
          <li>教室：{{item.classroom}}</li>
          <li>签到日期：{{item.date}}</li>
          <li>签到位置：第{{item.row}}行，第{{item.col}}列</li>
          <li>签到时间：{{item.time}}</li>
        </ul>
      </mt-cell-swipe>
    </div>
  </div>
</template>


<script>
import store from './store'
  export  default {
    components: {
    },
    data(){
      return{
        items:{}
      }
    },
    name:'record',
    mounted(){
      let data={
        sno:store.fetch('User').sno
      }

      this.$http.post('/api/user/selectRecord',data).then((res)=>{
        this.items=res.data
      })
    }
  }
</script>
<style scoped>
  li{
  list-style-type:none;
  color: black;
  text-align: left;
    padding: 2px;
}
</style>
