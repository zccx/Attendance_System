<template>
  <div>
    <mt-header fixed title="签到" style="height: 50px;font-size: 18px;align-items: center">
      <router-link to="/home" slot="left">
        <mt-button icon="back">返回</mt-button>
      </router-link>
    </mt-header>
    <table style="margin-top: 80px;width: 95%">
    <tr style="height: 50px">
      <td style="align-content:flex-end;width: 40%">
        <label style="font-size: 20px"><b>课程：</b></label>
      </td>
      <td style="width: 50%;">
        <select style="height: 40px;width: 225px;">
          <option value="student" selected="selected" >工程实践</option>
          <option value="teacher">智能技术</option>
        </select>
      </td>
    </tr>
      <tr style="height: 50px;">
        <td style="width: 40%;align-content:flex-end">
          <label style="font-size: 20px"><b>行数：</b></label>
        </td>
        <td style="width: 50%;">
          <select style="height: 40px;width: 225px;">
            <option value="student" selected="selected" >1</option>
            <option value="teacher">2</option>
          </select>
        </td>
      </tr>
      <tr style="height: 50px;">
        <td style="width: 150px;align-content:flex-end">
          <label style="font-size: 20px"><b>列数：</b></label>
        </td>
        <td style="width: 225px;">
          <select style="height: 40px;width: 225px;" >
            <option value="student" selected="selected" >1</option>
            <option value="teacher">2</option>
          </select>
        </td>
      </tr>
    </table>
    <!--<picker v-model="visible" :data-items="items" @change="onValuesChange">-->
      <!--<div class="top-content" slot="top-content">Top of the content.</div>-->
      <!--<div class="bottom-content" slot="bottom-content">Bottom of the content.</div>-->
    <!--</picker>-->
    <mt-button style="width: 150px;margin-top: 30px" type="primary">签到</mt-button>
  </div>
</template>
<script>
  export default {
    methods: {
      onValuesChange(result1, result2) {
        console.log(result1, result2);
      }
    },

    data() {
      return {
        visible: true,
        items: [
          {
            values: ['2000', '2001', '2002', '2003', '2004', '2005', '2006', '2007'],
          }, {
            values: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12'],
          }
        ]
      }
    }
  }
</script>
<style>

</style>
