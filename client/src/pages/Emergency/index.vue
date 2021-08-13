<template>
  <van-pull-refresh v-model="refreshing" @refresh="onRefresh">
    <van-list
      v-model="loading"
      :finished="finished"
      finished-text="没有更多了"
      @load="onLoad"
    >
      <van-cell v-for="item in list" :key="item.PatientId"  @click="onPatientClick(item)">
        <template #title>
            <span class="custom-title">{{item.Name}}</span>
            <span class="custom-title">{{item.Age}}</span>
        </template>

        <template #default>
            <span class="custom-title">{{item.MdtType}}</span>
        </template>

        <template #label>
            <div>
              <label >分诊时间：</label>
              <span>{{item.TRIAGE_TIME}}</span> 
          </div>
          <div>
              <label >腕带号：</label>
              <span>{{item.RelationId}}</span> 
            </div>
          <div>
              <label >联系方式：</label>
              <span>{{item.PhoneNumer}}</span> 
          </div>
          <div>
              <label >主诉</label>
              <span>{{item.PatientSay}}</span> 
          </div>
        </template>
      </van-cell>
    </van-list>
  </van-pull-refresh>
</template>

<script>
import { Toast } from "vant";

import api from "@/apis";

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
      let _this = this;
      api
        .GetEmergency()
        .then((res) => {
          

          if (this.refreshing) {
            this.list = [];
            this.refreshing = false;
          }

          for (let i = 0; i < res.data.length; i++) {
            _this.list.push(res.data[i]);
          }

          _this.loading = false;

          //if (_this.list.length >= 40) {
            _this.finished = true;

            console.log(_this.list);
          //}
        })
        .catch((ex) => {
          console.log(ex);
          Toast.clear();
        });
    },
    onRefresh() {
      // 清空列表数据
      this.finished = false;

      // 重新加载数据
      // 将 loading 设置为 true，表示处于加载状态
      this.loading = true;
      this.onLoad();
    },
    onPatientClick(item) {
      this.$router.push({
        name: "detail",
        params: {
          id: item.RelationId,
        }
      });
    }
  },
};
</script>


