package com.xjjxmm.estimate.model

abstract class EstimateOption(val code: String, val text:String) {

}

class ChooseBoxEstimateOption(code: String, text:String, val score:String):EstimateOption(code, text) {
   internal var checked:Boolean = false

    fun getScore(): Int {
        return score.toIntOrNull()?:0
    }
}

class TextEstimateOption(code: String, text:String) :EstimateOption(code, text) {
    //var checked:Boolean = false
    var value:String = ""

}