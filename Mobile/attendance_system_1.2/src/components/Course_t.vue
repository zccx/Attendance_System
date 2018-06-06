<template>
  <div>
    <mt-header fixed title="课程信息" style="height: 50px;font-size: 18px;align-items: center">
      <router-link to="/home1" slot="left">
        <mt-button icon="back">返回</mt-button>
      </router-link>
    </mt-header>
    <mt-field></mt-field>
    <mt-cell-swipe
      :right="rightButtons"
      :title="item.name"
      v-for="item in items">
      <ul class="li">
        <li>{{item.sweek}}-{{item.eweek}}周</li>
        <li>{{item.weekday}}</li>
        <li>{{item.classroom}}</li>
        <li>{{item.stime}}-{{item.etime}}</li>
      </ul>
    </mt-cell-swipe>
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
        tno:store.fetch('User').tno
      }
      console.log(data)
      this.$http.post('/api/user/selectCourse_t',data).then((res)=>{
        this.items=res.data
      //  console.log(this.items)
      })
      console.log(this.items)
    },
    data(){
      return{
        items:[]
      }
    },
    created() {
      this.rightButtons = [
        {
          content: '管理',
          style: { background:'#00BFFF', color: '#fff' }
        },
        {
          content: '删除',
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
  .li{
    list-style-type:none;
    color: black;
    text-align: left;
  }
</style>
