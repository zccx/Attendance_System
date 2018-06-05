<template>
  <div class="amap-page-container">
    <input type="text" ref="searchText" id="searchText" @keyup="keyUpSearch" placeholder="请输入地址"/>


    <div class="address_items" id="address_result" v-if="searchData.length > 0">
      <div class="address_item" v-for="item in searchData">
        <div class="title">{{ item.name }}</div>
        <div class="description">{{ item.pname }}{{ item.cityname }}{{ item.address }}</div>
      </div>
    </div>

    <!--<el-amap vid="amap" :plugin="plugin" class="amap-demo" :center="center">-->
    <!--</el-amap>-->

    <!--<div class="toolbar">-->
        <!--<span v-if="loaded">-->
          <!--location: lng = {{ lng }} lat = {{ lat }}-->
        <!--</span>-->
      <!--<span v-else>正在定位</span>-->
    <!--</div>-->
  </div>
</template>
<script>
  import store from './store'
  export default{
    method:{
      keyUpSearch () {
        var _this = this
        var txt = this.$refs.searchText.value;
      AMap.service(["AMap.PlaceSearch"],function(){
        var placeSearch = new AMap.PlaceSearch({
          //构造地点查询类
          pageSize: 12, pageIndex: 1, city: "成都",
          // 城市
          cityLimit: 'true', panel: 'temp'
          // 搜索结果的展示面板对元素id，不知道为什么一定要有该参数，最终获取的结果才更完整，参数更多跟完整，
          //所以我在页面随便写了一个<div id="temp" style="display:none"></div>
      });
        //关键字查询
        placeSearch.search(txt, function(status, result) {
          if (status == 'complete' && result.info == 'OK') {
//这里可以console.log(result)，查看所有返回的参数，遍历展示这些基本的，我就不赘述
            _this.searchData = result.poiList.pois
          }


        })
      })
      }


    }
  }

</script>
<style>
  #app {
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
  }
  .amap-wrapper {
    width: 500px;
    height: 500px;
  }
  .vue-demo {
    width: 400px;
    margin: 0 30px;
  }
  .amap-demo {
    height: 300px;
  }
  .txt {
    width: 200px;
    height: 25px;
    line-height: 24px;
    border-radius: 5px;
  }

</style>
