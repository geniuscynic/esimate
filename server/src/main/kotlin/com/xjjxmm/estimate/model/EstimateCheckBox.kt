package com.xjjxmm.estimate.model

import com.xjjxmm.estimate.vo.SelectedEstimateItem

class EstimateCheckBox(code: String, title:String, desc:String?=null, options: List<ChooseBoxEstimateOption>) : BaseChooseBox(code, title,desc, options) {
    override val type = EstimateElementType.CheckBox

    val value : MutableList<String> = mutableListOf()

    override fun setItems(items : List<SelectedEstimateItem>) {
        options.forEach { op ->
            items.firstOrNull {  it ->
                it.code == op.code
            }?.let { se->
                value.add(se.code)
            }
        }
//        items.firstOrNull  { t->t.code == code }?.value?.let { it ->
//
//            value = it
//
//            it.forEach { item ->
//                options.firstOrNull { o -> o.code == item }?.let { op ->
//                    op.checked = true
//                }
//            }
//
//        }
    }
}