<template>
  <div>
    <van-nav-bar
      title="患者管理"
      @click-right="onClickRight"
      left-text="返回"
      left-arrow
      @click-left="onClickLeft"
    >
      <!-- <template #right>
            
             <van-icon name="plus" size="18" />
        </template> -->
    </van-nav-bar>
    <van-form>
      <van-field
        v-model="form.name"
        name="用户名"
        label="用户名"
        placeholder="用户名"
        :rules="[{ required: true, message: '请填写用户名' }]"
      />

      <van-field name="radio" label="性别">
        <template #input>
          <van-radio-group v-model="form.gender" direction="horizontal">
            <van-radio name="1">男</van-radio>
            <van-radio name="2">女</van-radio>
            <van-radio name="0">未知</van-radio>
          </van-radio-group>
        </template>
      </van-field>

      <van-field
        name="年龄"
        label="年龄"
        readonly
        clickable
        :value="form.age"
        @touchstart.native.stop="show = true"
      />
      <van-number-keyboard
        v-model="form.age"
        :show="show"
        :maxlength="2"
        @blur="show = false"
      />
      <div style="margin: 16px">
        <van-button round block type="info" @click="save">提交</van-button>
      </div>
    </van-form>
  </div>
</template>




<script>
import { Toast } from "vant";

import api from "@/apis";

export default {
  name: "patient",
  data() {
    return {
      form: {
        name: "",
        age: "",
        gender: "",
      },
      show: false,
    };
  },
  components: {},

  mounted() {},
  methods: {
    save() {
      //console.log(this.form);

      api
        .AddPatient(this.form)
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
    onClickLeft() {
      this.$router.push({ name: "patient" }); // -> /user/123
    },
    onClickRight() {},
  },
};
</script>


