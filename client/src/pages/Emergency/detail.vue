<template>
  <van-row type="flex">
  <van-col span="6">span: 6</van-col>
</van-row>
</template>

<script>
//import { Toast } from "vant";

//import api from "@/apis";

export default {
  name: "organization",
  data() {
    return {
      list: [],
      loading: false,
      finished: false,
      refreshing: false,
    };
  },
  methods: {
    onLoad() {
      console.log(this.$route.params.id);
     //this.init(this.$route.params.id);  
    },
    onRefresh() {
      // 清空列表数据
      this.finished = false;

      // 重新加载数据
      // 将 loading 设置为 true，表示处于加载状态
      this.loading = true;
      this.onLoad();
    },
  },
  mounted() {
    this.onLoad();
  }
};
</script>


