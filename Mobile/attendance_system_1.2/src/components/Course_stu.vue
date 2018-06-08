<template>
  <div>
    <mt-header fixed title="课程信息" style="height: 50px;font-size: 18px;align-items: center">
      <router-link to="/home" slot="left">
        <mt-button icon="back">返回</mt-button>
      </router-link>
    </mt-header>
    <!--<mt-field v-for="item in items" :label="item.name" style="margin-top: 50px"></mt-field>-->

      <table style="margin-top: 50px" v-if="this.exist==true">
        <tr>
          <td>课程名称</td>
          <td>课程信息</td>
        </tr>
        <tr v-for="(item,index) in data1" style="width: 100%;align-items: center">
          <td style="width: 250px" v-for="value in item">{{value.name}}</td>
          <td style="text-align: left;width: 200px" v-for="value in item">
            <ul>
            <li>{{value.sweek}}-{{value.eweek}}周</li>
            <li>{{value.weekday}}</li>
            <li>{{value.classroom}}</li>
            <li>{{value.stime}}-{{value.etime}}</li>
            </ul>
          </td>
        </tr>
      </table>
    <div v-else style="margin-top: 200px">
      <a style="font-size: 25px">暂无任何课程</a>
    </div>
  </div>
</template>
<script>
 import MtField from "../../node_modules/mint-ui/packages/field/src/field.vue";
 import store from './store'
 export default {
   components: {
     MtField
   },
   mounted(){
     console.log("页面加载完成")
     //var sno=store.fetch('User').sno;
     let data={
       sno:store.fetch('User').sno
     }
     this.$http.post('/api/user/selectCourse',data).then((res)=>{
       if(res.data==-1){
        this.exist=false
       }else {
         this.exist=true
         this.items=res.data
         console.log(this.items.length)
         var length=this.items.length;
         //console.log(length)
         for(var j=0;j<length;j++){
           let data={
             cno:this.items[j].cno
           }
           this.$http.post('/api/user/selectCourse_1',data).then((res)=>{
             this.data1.push(res.data)
           })
         }
       }
     })
     console.log(this.data1)
   },
   data(){
     return {
        items:[],
       data1:[],
       exist:''
     }
   },
   created() {
     this.rightButtons = [
       {
         content: 'Mark as Unread',
         style: { background: 'lightgray', color: '#fff' }
       },
       {
         content: 'Delete',
         style: { background: 'red', color: '#fff' },
         handler: () => this.$messagebox('delete')
       }
     ];
   },
   methods: {
     leftButtonHandler(evt) {
       console.log(123);
     }
   }
 }
</script>
<style scoped>
li{
  padding: 1px;
}
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
