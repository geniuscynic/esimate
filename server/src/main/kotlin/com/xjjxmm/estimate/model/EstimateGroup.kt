package com.xjjxmm.estimate.model

import com.xjjxmm.estimate.vo.SelectedEstimateItem

abstract class AbstractEstimateGroup {
    var code:String? = null
    var title: String? = null
    var desc:String? = null
    lateinit var elements : List<EstimateElement>

    abstract fun getScore() : Int

    /*fun getScore() : Int {
        return elements.sumOf {
            it.getScore()
        }
    }*/

    fun setItems(items : List<SelectedEstimateItem>) {
        elements.forEach {
            it.setItems(items)
        }
    }
}

class EstimateGroup : AbstractEstimateGroup() {
    override fun getScore(): Int {
        return elements.sumOf {
            it.getScore()
        }
    }

}