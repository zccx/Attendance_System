<template>
  <div>
    <mt-header fixed title="签到记录" style="height: 50px;font-size: 18px;align-items: center">
      <router-link to="/home1" slot="left">
        <mt-button icon="back">返回</mt-button>
      </router-link>
    </mt-header>
    <div v-if="this.items.length==0" style="margin-top: 200px">
      <a style="font-size: 25px">暂无任何签到记录</a>
    </div>
    <div v-else style="margin-top: 50px">
      <mt-cell-swipe
        :right="[
              {content: '详细',style: {background:'#00BFFF', color: '#fff', textAlign: 'center'},
               handler(){detail(item)}},
          ]"
        :title="(index+1).toString()"
        v-for="(item,index) in items"
        :key="item.cno">
        <ul style="width: 250px" >
          <li>课程名称：{{item.course}}</li>
          <li>签到日期：{{item.date}}</li>
          <li>上课时间：{{item.stime1}}</li>
          <li>应到人数：{{length[index]}}</li>
          <li>实到人数：{{length1[index]}}</li>
          <li>请假人数：{{length2[index]}}</li>
        </ul>
      </mt-cell-swipe>
    </div>
  </div>
</template>
<script>
  import store from './store'
  export default {
    data(){
      return{
        items:{},
        length:{},
        length1:{},
        length2:{},
        flag:0,
        flag1:0,
        flag2:0
      }
    },
    mounted(){
      let data={
        tno:store.fetch('User').tno
      }
      this.$http.post('/api/user/select_rel_tno',data).then((res)=>{
        for(var i=0;i<res.data.length;i++){
          var stime = new Date("2018/01/01 " + res.data[i].stime1)
          var hour=stime.getHours()
          var min=stime.getMinutes()
          if(min>30){
            hour=hour+1;
            min=min-30
          }else if(min<30){
            min=min+30
          }else{
            hour=hour+1
            min='00'
          }
          let data1={
            cno:res.data[i].cno
          }
          res.data[i].stime1=hour+":"+min
          this.$http.post('/api/user/select_stu',data1).then((res)=>{
            this.$set(this.length,this.flag,res.data.length)
            this.flag=this.flag+1
          })
          let data2={
            cno:res.data[i].cno,
            date:res.data[i].date
          }
          this.$http.post('/api/user/select_record',data2).then((res)=>{
            this.$set(this.length1,this.flag1,res.data.length)
            this.flag1=this.flag1+1
          })
          this.$http.post('/api/user/select_qj',data2).then((res)=>{
            this.$set(this.length2,this.flag2,res.data.length)
            this.flag2=this.flag2+1
          })
        }
          this.items=res.data
      })
    },
    methods:{
      detail(val){
        this.$router.push({path:'/qd_detail',query:{cno:val.cno,date:val.date}})
      }
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
