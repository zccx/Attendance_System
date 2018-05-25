<template>
  <div id="record">
    <mt-header fixed title="签到记录" style="height: 50px;font-size: 18px;align-items: center">
      <router-link to="/home" slot="left">
        <mt-button icon="back">返回</mt-button>
      </router-link>
    </mt-header>
    <table  style="background-color:#fff;width: 400px;margin-top: 50px">
      <tr style="background-color: #F7F7F7;height: 30px">
        <th>日期</th>
        <th>时间</th>
        <th>教室</th>
        <th>课程</th>
      </tr>
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
    </table>
  </div>
</template>


<script>

  export  default {
    components: {
    },
    name:'record',
  }
</script>
<style>

</style>
