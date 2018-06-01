<template>
  <div>
    <mt-header fixed title="课程信息" style="height: 50px;font-size: 18px;align-items: center">
      <router-link to="/home" slot="left">
        <mt-button icon="back">返回</mt-button>
      </router-link>
    </mt-header>
    <mt-field  label="工程实践" style="margin-top: 50px">
      <ul>
        <li >1-12周</li>
        <li>周六</li>
        <li>8:00-12:00</li>
      </ul>
    </mt-field>
    <mt-field  label="工程英语">
      <ul>
        <li >1-15周</li>
        <li>周四</li>
        <li>14:00-15:40</li>
      </ul>
    </mt-field>
    <mt-field  label="智能技术">
      <ul>
        <li >1-18周</li>
        <li>周五</li>
        <li>14:00-16:35</li>
      </ul>
    </mt-field>
    <mt-field  label="自然辩证法">
      <ul>
        <li >1-12周</li>
        <li>周一</li>
        <li>15:50-17:30</li>
      </ul>
    </mt-field>
  </div>
</template>
<script>
 import MtField from "../../node_modules/mint-ui/packages/field/src/field.vue";

 export default {
   components: {
     MtField

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
<style>
li{
  height: 20px;
}
</style>
