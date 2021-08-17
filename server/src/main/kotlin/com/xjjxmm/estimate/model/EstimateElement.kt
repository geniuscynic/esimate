package com.xjjxmm.estimate.model

import com.xjjxmm.estimate.vo.SelectedEstimateItem

interface EstimateElement {
    val code: String
    //var value: String
    val type : EstimateElementType

    fun getScore() : Int
    fun setItems(items: List<SelectedEstimateItem>)
}