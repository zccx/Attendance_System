<template>
  <div>
    <mt-header fixed title="课程管理" style="height: 50px;font-size: 18px;align-items: center">
      <router-link to="/Course_t" slot="left">
        <mt-button icon="back">返回</mt-button>
      </router-link>
    </mt-header>
    <mt-cell-swipe></mt-cell-swipe>
    <table style="width: 100%">
      <tr>
        <td>姓名</td>
        <td>学号</td>
        <td>电话</td>
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
