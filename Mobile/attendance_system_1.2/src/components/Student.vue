<template>
  <div>
    <mt-header fixed title="课程管理" style="height: 50px;font-size: 18px;align-items: center">
      <router-link to="/Course_t" slot="left">
        <mt-button icon="back">返回</mt-button>
      </router-link>
    </mt-header>
    <mt-cell-swipe></mt-cell-swipe>
    <table style="width: 100%" class=table14_1>
      <tr>
        <td style="width: 25%">姓名</td>
        <td style="width: 35%">学号</td>
        <td style="width: 40%">电话</td>
      </tr>
      <tr v-for="(item,index) in data1">
        <td v-for="value in item">{{value.name}}</td>
        <td v-for="value in item">{{value.sno}}</td>
        <td v-for="value in item">{{value.phone}}</td>
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
        data1:[],
      }
    },
    mounted(){
      let data={
        cno:this.$route.query.cno
      }
      this.$http.post('/api/user/select_stu',data).then((res)=>{
        for(var i=0;i<res.data.length;i++){
          let data={
            sno:res.data[i].sno
          }
        this.$http.post('/api/user/select_student',data).then((res)=>{
            this.data1.push(res.data)
         })
        }
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
