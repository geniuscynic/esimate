<template>
  <div>
    <van-nav-bar :title="data.title" />
    <van-cell-group
      :title="group.title"
      v-for="group in data.groups"
      :key="group.code"
    >
      <template v-for="elements in group.elements">
        <van-cell
          :title="elements.title"
          :key="'title_' + elements.code"
          class="element-title"
        />

        <van-radio-group
          v-model="elements.value"
          :key="'radio_' + elements.code"
          v-if="elements.type == 'RadioButton'"
        >
          <van-cell-group>
            <van-cell
              :title="option.text"
              clickable
              v-for="option in elements.options"
              :key="option.code"
              @click="elements.value = option.code"
            >
              <template #right-icon>
                <van-radio :name="option.code" />
              </template>
            </van-cell>
          </van-cell-group>
        </van-radio-group>

        <van-checkbox-group
          v-model="elements.value"
          :key="'checkbox_' + elements.code"
          v-if="elements.type == 'CheckBox'"
        >
          <van-cell-group>
            <van-cell
              :title="option.text"
              clickable
              v-for="option in elements.options"
              :key="option.code"
              @click="toggle(option.code)"
            >
              <template #right-icon>
                <van-checkbox
                  :name="option.code"
                  ref="checkboxes"
                  shape="square"
                />
              </template>
            </van-cell>
          </van-cell-group>
        </van-checkbox-group>

        <van-cell-group
          :key="'text_' + elements.code"
          v-if="elements.type == 'Text'"
        >
          <van-field
            autosize
            v-for="option in elements.options"
            :key="option.code"
            v-model="option.value"
            label=""
            :placeholder="option.text | emptyText"
          />
        </van-cell-group>
      </template>
    </van-cell-group>

    <van-button type="primary" block @click="save">保存</van-button>
  </div>
</template>

<style>
.element-title {
  background: #9dbdca;
  color: aliceblue;
}
</style>

<script>
export default {
  name: "estimateComponents",
  props: {
    data: {
      type: Object,
    },
  },
  data() {
    return {
      form: {
        estimatePhase: 0,
        estimateModule: "",
        code: "",
        data: {},
      },
    };
  },
  mounted() {},
  methods: {
    save() {
      //console.log(this.data);
      let result = [];
      for (let group of this.data.groups) {
        for (let element of group.elements) {
          //let temp = {};
          //temp.code = element.code;

          if (element.type == "RadioButton") {
            //temp.value = element.value;
            if (element.value != "") {
              result.push({
                code: element.value,
                value: element.value,
              });
            }
          } else if (element.type == "CheckBox") {
            //temp.value = element.value;
            for (let checkValue of element.value) {
              result.push({
                code: checkValue,
                value: checkValue,
              });
            }
          } else if (element.type == "Text") {
            //temp.value = element.value;
            for (let option of element.options) {
              result.push({
                code: option.code,
                value: option.value,
              });
            }
          }
          // if (Array.isArray(element.value) && element.value.length > 0) {
          //   temp.value = element.value;

          //   result.push(temp);
          // } else if (element.value != "") {
          //   temp.value = [element.value];

          //   result.push(temp);
          // }
        }
      }

      this.form.data = result;
      this.form.code = this.data.code;

      console.log(this.form);

      // this.$emit("onSave", this.form);
    },
    toggle(index) {
      //debugger;
      this.$refs.checkboxes.find((t) => t.name == index).toggle();
    },
  },
};
</script>


