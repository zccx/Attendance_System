<template>
  <div>
    <mt-header fixed title="课程信息" style="height: 50px;font-size: 18px;align-items: center">
      <router-link to="/home" slot="left">
        <mt-button icon="back">返回</mt-button>
      </router-link>
    </mt-header>
    <!--<mt-field v-for="item in items" :label="item.name" style="margin-top: 50px"></mt-field>-->

      <table style="margin-top: 50px" class=table14_1 v-if="this.exist==true">
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
     let data={
       sno:store.fetch('User').sno
     }
     this.$http.post('/api/user/selectCourse',data).then((res)=>{
       if(res.data==-1){
        this.exist=false
       }else {
         this.exist=true
         this.items=res.data
         var length=this.items.length;
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
  font-size:1.0em;
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
