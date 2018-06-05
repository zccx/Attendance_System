// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import  VueResource  from 'vue-resource'
import VueRouter from 'vue-router'
import Mint from 'mint-ui';
import { Button } from 'mint-ui';
import picker from 'vue-3d-picker';
import VueAMap from 'vue-amap';

Vue.use(VueAMap);
Vue.component(picker.name, picker);
Vue.component(Button.name, Button);
Vue.use(Mint);
Vue.use(VueResource)
Vue.use(VueRouter)

Vue.config.productionTip = false

VueAMap.initAMapApiLoader({
  key: '640d2da32b3e7516de69175da9d0d0e3',
  plugin: ['AMap.Autocomplete', 'AMap.Geolocation','AMap.PlaceSearch', 'AMap.Scale', 'AMap.OverView', 'AMap.ToolBar', 'AMap.MapType', 'AMap.PolyEditor', 'AMap.CircleEditor'],
  // 默认高德 sdk 版本为 1.4.4
  v: '1.4.4'
});
/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
