package com.xjjxmm.estimate.model

import com.xjjxmm.estimate.vo.SelectedEstimateItem

class EstimateRadioBox(code: String, title: String, desc: String? = null, options: List<ChooseBoxEstimateOption>) : BaseChooseBox(code, title, desc, options) {
    override val type = EstimateElementType.RadioButton

    var value = ""

    override fun setItems(items : List<SelectedEstimateItem>) {
        items.firstOrNull  { t->t.code == code }?.value?.firstOrNull()?.let { it ->
            value = it

            options.firstOrNull { o -> o.code == value }?.let { op ->
                op.checked = true
            }
        }
    }

}