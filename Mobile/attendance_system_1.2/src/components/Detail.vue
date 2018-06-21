<template>
  <div>
    <mt-header fixed title="信息详情" style="height: 50px;font-size: 18px;align-items: center">
      <router-link to="/xiaoxi_stu" slot="left">
        <mt-button icon="back">返回</mt-button>
      </router-link>
    </mt-header>
    <mt-cell-swipe></mt-cell-swipe>
    <mt-field label="请假人"  v-model="name" readonly disableClear></mt-field>
    <mt-field label="学号" v-model="sno" readonly disableClear></mt-field>
    <mt-field label="请假课程" v-model="course" readonly disableClear></mt-field>
    <mt-field label="请假时间" v-model="qjday" readonly disableClear></mt-field>
    <mt-field label="请假理由" v-model="reason" readonly disableClear></mt-field>
    <mt-field label="状态" placeholder="通过" state="success" v-if="this.ispass==true" readonly disableClear></mt-field>
    <mt-field label="状态" placeholder="未通过" state="error" v-if="this.ispass==false" readonly disableClear></mt-field>
    <mt-field label="理由" v-model="refuse" v-if="this.ispass==false" readonly disableClear></mt-field>

  </div>
</template>
<script>
  import MtCellSwipe from "../../node_modules/mint-ui/packages/cell-swipe/src/cell-swipe.vue";

  export default {
    components: {MtCellSwipe},
    data(){
      return{
        items:{},
        name:'',
        course:'',
        sno:'',
        qjday:'',
        reason:'',
        ispass:'',
        refuse:''
      }
    },
    mounted(){
      let query=this.$route.query
      let data={
        id:query.id
      }
      console.log(data)
      this.$http.post('/api/user/select_detail',data).then((res)=>{
        this.items=res.data
        this.name=res.data[0].name;
        this.sno=res.data[0].sno;
        this.course=res.data[0].course;
        this.qjday=res.data[0].qjday;
        this.reason=res.data[0].reason;
        this.ispass=res.data[0].ispass;
        this.refuse=res.data[0].refuse
        console.log(this.items)
      })
      let data1={
        id:query.id,
        isread:true
      }
      this.$http.post('/api/user/update_qj1',data1).then((res)=>{
          console.log("success")
      })
    }
  }
</script>
<style>
</style>
