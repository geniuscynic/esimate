<template>
  <div>
    <van-nav-bar title="新增量表" />

    <!-- 左对齐 -->
    <div class="div_wapper">
      <div v-for="item in data" :key="item.code">
        <van-button type="primary" block @click="choosed(item)">{{ item.title }}</van-button>
      </div>
    </div>

   
  </div>
</template>

<style lang="less" scope>
.div_wapper {
  display: flex;
  flex-wrap: wrap;

  &>div {
    padding: 10px;
  }

}
</style>>


<script>
//import { Toast } from "vant";

import api from "@/apis";

export default {
  name: "organization",
  data() {
    return {
      data: []
    };
  },
  mounted() {
    this.onLoad();
  },
  methods: {
    async onLoad() {
      //let _this = this;
      let res = await api.listEstimate()
      this.data = res.data;
        // .then((res) => {
        //   this.data = res.data;

        //   console.log(this.data);
        // })
        // .catch((ex) => {
        //   console.log(ex);
        //   Toast.clear();
        // });
    },
    choosed(item) {
      console.log(item.code);
      this.$router.push({ name: "estimate_add", params: {  code: item.code } }); // -> /user/123
    },
    
  },
};
</script>


