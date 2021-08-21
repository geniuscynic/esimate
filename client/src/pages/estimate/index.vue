<template>
  <div>
    <van-nav-bar title="患者量表" @click-right="onAddEstimate">
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
      <van-cell
        v-for="item in list"
        :key="item.id"
        :title="item.estimateTitle"
        clickable
        @click="onCellClick(item)"
        is-link
      >
        <template #label>
          <span class="custom-title">{{ item.estimateScore }}分</span>
        </template>

        <!-- <template #default>
          <span class="custom-title">{{ caulateGender(item.gender) }}</span>
        </template> -->
      </van-cell>
    </van-list>
  </div>
</template>




<script>
//import { Toast } from "vant";
import { mapState } from "vuex";

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
    async onLoad() {
      //let id = this.$route.params.id;

      let res = await api.findByPatientId(this.patientId);
      // .then((res) => {
      this.loading = false;

      this.list = res.data;
      this.finished = true;

      console.log(res);
      // })
      // .catch((ex) => {
      //   console.log(ex);
      //   Toast.clear();
      // });
    },
    onCellClick(item) {
      this.$router.push({ name: "estimate_edit", params: { id: item.id }  }); // -> /user/123
    },
    onAddEstimate() {
      this.$router.push({ name: "esimate_list" });
      //this.$router.push({ name: "esimate_list", params: { id: this.id } }); // -> /user/123
    },
  },
  computed: mapState(["patientId"]),
};
</script>


