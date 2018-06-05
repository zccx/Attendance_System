<template>
  <div>
  <mt-header fixed title="请假管理" style="height: 50px;font-size: 18px;align-items: center">
    <router-link to="/home1" slot="left">
      <mt-button icon="back">返回</mt-button>
    </router-link>
  </mt-header>
    <mt-cell-swipe></mt-cell-swipe>
   <mt-cell-swipe
     :right="rightButtons"
     :title="(index+1).toString()"
      v-for="(item,index) in data1">
     <ul style="width: 250px" v-for='value in item'>
       <li>请假人：{{value.name}}</li>
       <li>学号：{{value.sno}}</li>
       <li>请假日期：{{value.qjday}}</li>
       <li>请假课程：{{value.course}}</li>
       <li>请假理由：{{value.reason}}</li>
     </ul>
   </mt-cell-swipe>
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
        console.log(length)
        for(var i=0;i<length;i++){
          let data={
            cno:res.data[i].cno,
            isapproval:'0'
          }
          console.log(i)
          this.$http.post('/api/user/selectQingjia',data).then((res)=>{
            var _this=this
            _this.data1.push(res.data);
          })
        }
      })
      console.log(this.data1)
    },
    created() {
      this.rightButtons = [
        {
          content: '通过',
          style: { background:'#00BFFF', color: '#fff' },
          handler:()=>{
            this.$messagebox.confirm('您确定通过吗？','提示').then(action=>{

            })
          }
        },
        {
          content: '拒绝',
          style: { background: 'red', color: '#fff' },
          handler: () => {
            this.$messagebox.prompt('请输入拒绝理由')
            //this.$messagebox()
          //  this.$toast('hello')
           // this.$http.post()
          }
        }
      ];
    },
    methods:{
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
