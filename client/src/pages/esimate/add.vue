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
      data: {}
    };
  },
  components:{
    'estimate': estimate
  },

  mounted() {
    this.onLoad();
  },
  methods: {
    async onLoad() {
      let code = this.$route.params.code;
      //let _this = this;
      let res = await api.GetEsimate(code);
       this.data = res.data;
      console.log(this.data);
        // .then((res) => {
        //   this.data = res.data;

        //   console.log(this.data);
        // })
        // .catch((ex) => {
        //   console.log(ex);
        //   Toast.clear();
        // });
    },
    save(form) {
      console.log(form);

      api.AddEsimate(form).then((res) => {
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
      this.$refs.checkboxes.find(t=>t.name == index).toggle();
    },
  },
};
</script>


