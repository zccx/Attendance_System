<template>
  <div>
    <mt-header fixed title="课程信息" style="height: 50px;font-size: 18px;align-items: center">
      <router-link to="/home1" slot="left">
        <mt-button icon="back">返回</mt-button>
      </router-link>
    </mt-header>
    <mt-field></mt-field>
    <mt-cell-swipe
      :right="[
              {content: '查看',style: {background:'#00BFFF', color: '#fff', textAlign: 'center'},
               handler(){release(item)}},
          ]"
      :title="item.name"
      v-for="item in items"
      :key="item.id">
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
      this.$http.post('/api/user/selectCourse_t',data).then((res)=>{
        this.items=res.data
      })
    },
    data(){
      return{
        items:[]
      }
    },

    methods: {
      leftButtonHandler(evt) {
      },
      release(val){
        this.$router.push({path:'/student',query:{cno:val.cno}})
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
