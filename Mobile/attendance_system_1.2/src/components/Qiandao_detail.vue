<template>
  <div>
    <mt-header fixed title="签到详细" style="height: 50px;font-size: 18px;align-items: center">
      <router-link to="/record_t" slot="left">
        <mt-button icon="back">返回</mt-button>
      </router-link>
    </mt-header>
    <mt-cell-swipe>
    </mt-cell-swipe>
    <table style="width: 100%" class=table14_1>
      <tr>
        <td style="width: 30%">学号</td>
        <td style="width: 20%">姓名</td>
        <td style="width: 20%">是否签到</td>
        <td style="width: 30%">签到时间</td>
      </tr>
      <tr v-for="(item,index) in items">
        <td >{{item.sno}}</td>
        <td >{{item.stu_name}}</td>
        <td >{{item.name}}</td>
        <td >{{item.cno}}</td>
      </tr>
    </table>
  </div>
</template>
<script>
  import MtCellSwipe from "../../node_modules/mint-ui/packages/cell-swipe/src/cell-swipe.vue";

  export default {
    components: {MtCellSwipe},
    data(){
      return{
        items:{}
      }
    },
    mounted(){
      let data={
        cno:this.$route.query.cno,
        date:this.$route.query.date
      }
      this.$http.post('/api/user/select_stu',data).then((res)=>{
          this.items=res.data
        this.$http.post('/api/user/select_record',data).then((res)=>{
          for(var j=0;j<this.items.length;j++){
            this.items[j].name='否'
            this.items[j].cno=''
          }
          for(var i=0;i<res.data.length;i++){
            for(var j=0;j<this.items.length;j++){
              if(res.data[i].sno==this.items[j].sno){
                this.items[j].name='是'
                this.items[j].cno=res.data[i].time
              }continue;
            }
          }
        })
        console.log(this.items)
        this.$http.post('/api/user/select_qj',data).then((res)=>{
          for(var i=0;i<res.data.length;i++){
            for(var j=0;j<this.items.length;j++){
              if(res.data[i].sno==this.items[j].sno){
                this.items[j].name='请假'
              }continue;
            }
          }
        })
      })
    }
  }
</script>
<style scoped>
  .table14_1 table {
    width:100%;
    margin:15px 0;
    border:0;
  }
  .table14_1 th {
    font-weight:bold;
    background-color:#e7f6fe;
    color:#57c5fe
  }
  .table14_1,.table14_1 th,.table14_1 td {
    font-size:0.95em;
    text-align:center;
    padding:4px;
    border-collapse:collapse;
  }
  .table14_1 th,.table14_1 td {
    border: 1px solid #ffffff;
    border-width:1px
  }
  .table14_1 th {
    border: 1px solid #e7f6fe;
    border-width:1px 0 1px 0
  }
  .table14_1 td {
    border: 1px solid #eeeeee;
    border-width:1px 0 1px 0
  }
  .table14_1 tr {
    border: 1px solid #ffffff;
  }
  .table14_1 tr:nth-child(odd){
    background-color:#f7f7f7;
  }
  .table14_1 tr:nth-child(even){
    background-color:#ffffff;
  }
</style>
