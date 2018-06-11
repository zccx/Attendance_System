<template>
  <div>
  <mt-header fixed title="请假管理" style="height: 50px;font-size: 18px;align-items: center">
    <router-link to="/home1" slot="left">
      <mt-button icon="back">返回</mt-button>
    </router-link>
  </mt-header>
    <mt-cell-swipe></mt-cell-swipe>
    <div v-if="this.data1.length!=0">
   <mt-cell-swipe
     :right="[
              {content: '通过',style: {background:'#00BFFF', color: '#fff', textAlign: 'center'},
               handler(){release(item)}},
              {content: '拒绝',style: {background: 'red', color: '#fff' , textAlign: 'center'},
               handler(){delete1(item)}}
          ]"
     :title="(index+1).toString()"
      v-for="(item,index) in data1"
      :key="item.tno">
     <ul style="width: 250px" >
       <li>请假人：{{item.name}}</li>
       <li>学号：{{item.sno}}</li>
       <li>请假日期：{{item.qjday}}</li>
       <li>请假课程：{{item.course}}</li>
       <li>请假理由：{{item.reason}}</li>
     </ul>
   </mt-cell-swipe>
    </div>
    <div style="margin-top: 200px" v-else>
      <a style="font-size: 25px">暂无请假信息</a>
    </div>
  </div>
</template>
<script>
  import store from './store'
  import MtCellSwipe from "../../node_modules/mint-ui/packages/cell-swipe/src/cell-swipe.vue";
  export default {
    components: {MtCellSwipe},
    data(){
      return{
        data1: [],
      }
    },
    mounted(){
      let data={
        tno:store.fetch('User').tno
      }
      this.$http.post('/api/user/selectCourse_t',data).then((res)=>{
        var length=res.data.length
        console.log("长度"+length)
        for(var i=0;i<length;i++){
          let data={
            cno:res.data[i].cno,
            isapproval:false
          }
          console.log("i="+i)
          this.$http.post('/api/user/selectQingjia',data).then((res)=>{
            console.log(res.data.length)
            if(res.data!='无'){
              for(var i=0;i<res.data.length;i++){
                var _this=this
                _this.data1.push(res.data[i]);
              }
            }
          })
          console.log(this.data1)
        }
      })
      console.log("this.data1="+this.data1.length)
    },
    created() {

    },
    methods:{
      release(val){
        this.$messagebox.confirm('您确定通过吗？','提示').then(action=> {
          let data={
            id:val.id,
            refuse:'',
            isapproval:true,
            ispass:true
          }
          console.log(data)
          this.$http.post('/api/user/update_qj',data).then((res)=>{
                this.$router.push({path:'/blank'})
              })
          console.log(val)
          console.info('release:' + val)
        }).catch(()=>{
          this.$toast('操作取消')
        })
      },
      delete1(val){
        this.$messagebox.prompt('理由').then((val1)=>{
          let data={
            id:val.id,
            refuse:val1.value,
            isapproval:true,
            ispass:false
          }
          this.$http.post('/api/user/update_qj',data).then((res)=>{
            this.$router.push({path:'/blank'})
          })
        }).catch(()=>{
          this.$toast('操作取消')
        })
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
  li{
    list-style-type:none;
    color: black;
    text-align: left;
  }
</style>
