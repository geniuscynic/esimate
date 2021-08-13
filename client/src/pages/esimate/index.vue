<template>
  <div>
    <van-nav-bar title="新增量表" />

    <!-- 左对齐 -->
    <van-row type="flex" gutter="20">
      <van-col span="6" v-for="item in data" :key="item.code">
        <van-button type="primary" block>{{ item.title }}</van-button>
      </van-col>
    </van-row>

   
  </div>
</template>

<style>
.element-title {
  background: #9dbdca;
  color: aliceblue;
}
</style>

<script>
import { Toast } from "vant";

import api from "@/apis";

export default {
  name: "organization",
  data() {
    return {
      data: [],
    };
  },
  mounted() {
    this.onLoad();
  },
  methods: {
    onLoad() {
      //let _this = this;
      api
        .listEstimate()
        .then((res) => {
          this.data = res.data;

          console.log(this.data);
        })
        .catch((ex) => {
          console.log(ex);
          Toast.clear();
        });
    },
    save() {
      //console.log(this.data);

      let result = [];
      for (let group of this.data.groups) {
        for (let element of group.elements) {
          let temp = {};
          temp.code = element.code;

          if (Array.isArray(element.value) && element.value.length > 0) {
            temp.value = element.value;

            result.push(temp);
          } else if (element.value != "") {
            temp.value = [element.value];

            result.push(temp);
          }
        }
      }

      this.form.data = result;
      this.form.code = this.code;

      console.log(this.form);
      api
        .AddEsimate(this.form)
        .then((res) => {
          //this.data = res.data;
          console.log(res);
          //console.log(this.data);
        })
        .catch((ex) => {
          console.log(ex);
          Toast.clear();
        });
    },
    toggle(index) {
      //debugger;
      this.$refs.checkboxes.find((t) => t.name == index).toggle();
    },
  },
};
</script>


