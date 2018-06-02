<template>
  <div id="app">
  <div class='vue-demo'>
    <input type="text" class="txt" v-model='newItem' @keyup.enter='addItemFun'>
  <ul>
    <li v-for="it in items">{{it.name}}</li>
  </ul>
  </div>
  </div>
</template>
<script>
  import store from './store'
  export default {
    name: 'app',
    data() {
      return {
        key:'user',
        newItem: '',
        items: store.fetch('user')
      }
    },
    watch: {
      items: {
        handler: function(val, oldVal) {
          store.save('user',val);
        },
        deep: true
      }
    },
    methods: {
      addItemFun() {
        var _this = this;
        _this.items.push({'name': _this.newItem,'pwd':'465456' });
        _this.newItem = '';
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

  .vue-demo {
    width: 400px;
    margin: 0 30px;
  }

  .txt {
    width: 200px;
    height: 25px;
    line-height: 24px;
    border-radius: 5px;
  }

</style>
