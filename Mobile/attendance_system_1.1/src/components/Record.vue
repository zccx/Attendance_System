<template>
  <div id="record">
    <mt-header title="签到记录" style="height: 50px;font-size: 18px;align-items: center">
    </mt-header>
    <load-more tip="签到记录" :show-loading="false" background-color="#fbf9fe"></load-more>
    <x-table :cell-bordered="false" :content-bordered="false" style="background-color:#fff;">
      <thead>
      <tr style="background-color: #F7F7F7">
        <th>日期</th>
        <th>时间</th>
        <th>教室</th>
        <th>课程</th>
      </tr>
      </thead>
      <tbody>
      <tr>
        <td>2018.5.5</td>
        <td>8:00</td>
        <td>数计中-307</td>
        <td>工程实践</td>
      </tr>
      <tr>
        <td>2018.4.21</td>
        <td>7:58</td>
        <td>数计中-307</td>
        <td>工程实践</td>
      </tr>
      <tr>
        <td>2018.4.14</td>
        <td>7:44</td>
        <td>数计中-307</td>
        <td>工程实践</td>
      </tr>
      <tr>
        <td>2018.4.7</td>
        <td>8:44</td>
        <td>数计中-307</td>
        <td>工程实践</td>
      </tr>
      <tr>
        <td>2018.3.31</td>
        <td>7:59</td>
        <td>数计中-307</td>
        <td>工程实践</td>
      </tr>
      <tr>
        <td>2018.3.24</td>
        <td>8:03</td>
        <td>数计中-307</td>
        <td>工程实践</td>
      </tr>
      </tbody>
    </x-table>
  </div>
</template>


<script>
  import { FormPreview } from 'vux'
  import MtTabContainer from "../../node_modules/mint-ui/packages/tab-container/src/tab-container.vue";
  import MtTabContainerItem from "../../node_modules/mint-ui/packages/tab-container-item/src/tab-container-item.vue";
  import MtCell from "../../node_modules/mint-ui/packages/cell/src/cell.vue";
  import XButton from "../../node_modules/vux/src/components/x-button/index.vue";
  import XTable from "../../node_modules/vux/src/components/x-table/index.vue";
  import LoadMore from "../../node_modules/vux/src/components/load-more/index.vue";

  export  default {
    components: {
      LoadMore,
      XTable,
      XButton,
      MtCell,
      MtTabContainerItem,
      MtTabContainer,
      FormPreview
    },
    name:'record',
  }
</script>
<style>

</style>
