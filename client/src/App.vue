<template>
  <div id="app">

<router-view/>
   
  </div>
</template>

<style lang="less">
body {
  font-size: 16px;
  background-color: #f8f8f8;
  -webkit-font-smoothing: antialiased;
}
</style>


<script>
import { Toast } from 'vant';  
export default {
  data() {
    return {
      active: 'home1',
    };
  },
   methods: {
    onClickLeft() {
      Toast('返回');
    },
    onClickRight() {
      Toast('按钮');
    },
  },
};
</script>
