<template>
  <div>
    <estimate :data="data" @onSave="save" />
  </div>
</template>


<script>
import estimate from './estimateComponents'

import { Toast } from "vant";

import api from "@/apis";

export default {
  name: "organization",
  data() {
    return {
      data: {},
      code: "",
      id: "1421020082949681153"
    };
  },
  components:{
    'estimate': estimate
  },

  mounted() {
    this.onLoad();
  },
  methods: {
    onLoad() {
      //let _this = this;
      api
        .getEstimateById(this.id)
        .then((res) => {
          this.data = res.data.detail;

          console.log(this.data);
        })
        .catch((ex) => {
          console.log(ex);
          Toast.clear();
        });
    },
    save(form) {
      console.log(form);

      api.AddEsimate(form).then((res) => {
          //this.data = res.data;
          console.log(res);
          //console.log(this.data);
          //this.code = res.detail.code;
          this.data = res.detail;
        })
        .catch((ex) => {
          console.log(ex);
          Toast.clear();
        });
    },
    toggle(index) {
      //debugger;
      this.$refs.checkboxes.find(t=>t.name == index).toggle();
    },
  },
};
</script>


