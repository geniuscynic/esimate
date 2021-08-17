package com.xjjxmm.estimate.model

abstract class BaseChooseBox (override val code: String, val title:String,
                              val desc:String?=null, val options: List<ChooseBoxEstimateOption>) : EstimateElement {

    //override var value: String=""

    override fun getScore(): Int {

        return options.filter { it.checked }.sumOf {
            it.getScore()
        }

    }
}