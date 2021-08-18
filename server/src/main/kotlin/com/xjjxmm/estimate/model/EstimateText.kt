package com.xjjxmm.estimate.model

import com.xjjxmm.estimate.vo.SelectedEstimateItem

class EstimateText(override val code: String, val title:String, val desc:String?=null, val options: List<TextEstimateOption>) :
    EstimateElement {
    //var value: String=""
    override val type = EstimateElementType.Text
    override fun getScore(): Int {
        return 0
    }

    override fun setItems(items : List<SelectedEstimateItem>) {
        options.forEach {  op->
            items.firstOrNull { it->
                op.code == it.code
            }?.value?.firstOrNull()?.let { value->
                op.value = value
            }
        }
//        items.firstOrNull  { t->t.code == code }?.value?.firstOrNull()?.let { it ->
//            value = it
//        }
    }

}