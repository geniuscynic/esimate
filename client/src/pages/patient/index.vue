<template>
  <div>
    <van-nav-bar title="新增患者" @click-right="onClickRight">
      <template #right>
        <van-icon name="plus" size="18" />
      </template>
    </van-nav-bar>

    <van-pull-refresh v-model="refreshing" @refresh="onRefresh">
      <van-list
        v-model="loading"
        :finished="finished"
        finished-text="没有更多了"
        @load="onLoad"
      >
        <van-cell v-for="item in list" :key="item.id" :title="item.name" clickable @click="onCellClick(item)">
          <template #label>
            <span class="custom-title">{{ item.age }}岁</span>
          </template>

          <template #default>
            <span class="custom-title">{{ caulateGender(item.gender) }}</span>
          </template>
        </van-cell>
      </van-list>
    </van-pull-refresh>
  </div>
</template>




<script>
//import { Toast } from "vant";

import api from "@/apis";

import { mapMutations } from 'vuex'

export default {
  name: "patient",
  data() {
    return {
      list: [],
      loading: false,
      finished: false,
      refreshing: false,
    };
  },
  components: {},

  mounted() {
    //this.onLoad();
  },
  methods: {
    ...mapMutations([
      'setPatientId', 
    ]),
    async onLoad() {
      let res = await api.GetPatient();
        //.then((res) => {
          if (this.refreshing) {
            this.list = [];
            this.refreshing = false;
          }

          this.refreshing = false;

          this.loading = false;

          this.list = res.data;
          this.finished = true;
        // })
        // .catch((ex) => {
        //   console.log(ex);
        //   Toast.clear();
        // });
    },
    onRefresh() {
      // 清空列表数据
      this.finished = false;

      // 重新加载数据
      // 将 loading 设置为 true，表示处于加载状态
      this.loading = true;
      this.onLoad();
    },
    onClickRight() {
      this.$router.push({ name: "patient_add" }); // -> /user/123
    },
    onCellClick(item) {
      this.setPatientId(item.id);
      this.$router.push({ name: "estimate" }); 
      //this.$router.push({ name: "patient_estimate_list", params: { id: item.id } }); 
    },
    caulateGender(gender) {
      if (gender == 1) {
        return "男";
      }

      if (gender == 2) {
        return "女";
      }

      return "";
    },
  },
};
</script>


