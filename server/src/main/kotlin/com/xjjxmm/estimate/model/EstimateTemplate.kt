package com.xjjxmm.estimate.model

import com.xjjxmm.estimate.vo.SelectedEstimateItem


abstract class AbstractEstimateTemplate {
    lateinit var  code : String
    lateinit var title : String

    lateinit var groups : List<EstimateGroup>

    abstract fun getScore() : Int
    /*fun getScore() : Int {
        return groups.sumOf {
            it.getScore()
        }
    }*/

    fun setItems(items : List<SelectedEstimateItem>) {
        groups.forEach {
            it.setItems(items)
        }
    }
}

class EstimateTemplate : AbstractEstimateTemplate() {
    override fun getScore(): Int {
        return groups.sumOf {
            it.getScore()
        }
    }
}


















