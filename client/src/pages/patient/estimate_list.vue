<template>
  <div>
    <van-nav-bar title="新增量表" @click-right="onAddEstimate">
      <template #right>
        <van-icon name="plus" size="18" />
      </template>
    </van-nav-bar>

    <van-list
      v-model="loading"
      :finished="finished"
      finished-text="没有更多了"
      @load="onLoad"
    >
      <van-cell v-for="item in list" :key="item.id" :title="item.code" clickable @click="onCellClick">
        <template #label>
          <span class="custom-title">{{ item.score }}岁</span>
        </template>

        <!-- <template #default>
          <span class="custom-title">{{ caulateGender(item.gender) }}</span>
        </template> -->
      </van-cell>
    </van-list>
  </div>
</template>




<script>
import { Toast } from "vant";

import api from "@/apis";

export default {
  name: "esimate_list",
  data() {
    return {
      
      list: [],
      loading: false,
      finished: false,
      
    };
  },
  components: {},

  mounted() {
    //this.onLoad();
  },
  methods: {
    onLoad() {
      let id = this.$route.params.id;

      api
        .findByPatientId(id)
        .then((res) => {
          this.loading = false;

          this.list = res.data;
          this.finished = true;
        })
        .catch((ex) => {
          console.log(ex);
          Toast.clear();
        });
    },
    onCellClick() {
      this.$router.push({ name: "patient_add" }); // -> /user/123
    },
    onAddEstimate() {
      this.$router.push({ name: "esimate" }); // -> /user/123
     
    }
  },
};
</script>


