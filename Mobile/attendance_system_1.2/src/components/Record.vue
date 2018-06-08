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
    <table style="background-color:#fff;width: 100%;margin-top: 50px;" v-else>
      <tr style="background-color: #F7F7F7;height: 30px">
        <th>编号</th>
        <th>日期</th>
        <th>时间</th>
        <th>教室</th>
        <th>行数</th>
        <th>列数</th>
        <th>课程</th>
      </tr>
      <tr v-for="(item,index) in items" style="height: 40px">
        <td>{{index+1}}</td>
        <td>{{item.date}}</td>
        <td>{{item.time}}</td>
        <td>{{item.classroom}}</td>
        <td>{{item.row}}</td>
        <td>{{item.col}}</td>
        <td>{{item.course}}</td>
      </tr>
    </table>
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
<style>

</style>
