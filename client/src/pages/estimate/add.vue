<template>
  <div>
    <estimate :data="data" @onSave="save" />
  </div>
</template>


<script>
import estimate from "./estimateComponents";
import { mapState } from "vuex";
//import { Toast } from "vant";

import api from "@/apis";

export default {
  name: "organization",
  data() {
    return {
      data: {},
      //id: this.$route.params.id
    };
  },
  components: {
    estimate: estimate,
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
    async save(form) {
      //console.log(this.patientId);
      form.patientId = this.patientId;

      console.log(form);

      let res = await api.AddEsimate(form);
      console.log(res);

      this.$router.push({ name: "esimate" });
      // .then((res) => {
      //     //this.data = res.data;
      //     console.log(res);
      //     //console.log(this.data);
      //   })
      //   .catch((ex) => {
      //     console.log(ex);
      //     Toast.clear();
      //   });
    },
    toggle(index) {
      //debugger;
      this.$refs.checkboxes.find((t) => t.name == index).toggle();
    },
  },
  computed: {
    // 使用对象展开运算符将此对象混入到外部对象中
    ...mapState({
      patientId: 'patientId'
    })
  },
};
</script>


