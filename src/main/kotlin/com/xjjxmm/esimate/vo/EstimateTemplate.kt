package com.xjjxmm.esimate.vo

import com.alibaba.fastjson.annotation.JSONField


class EstimateTemplate {
    lateinit var  code : String
    lateinit var title : String
    lateinit var groups : List<EstimateGroup>

    fun getScore() : Int {
        return groups.sumOf {
            it.getScore()
        }
    }
}

 class EstimateGroup {
    var code:String? = null
    var title: String? = null
    var desc:String? = null
     lateinit var elements : List<EstimateElement>

    fun getScore() : Int {
        return elements.sumOf {
            it.getScore()
        }
    }
}

enum class EstimateElementType {
    RadioButton,
    CheckBox
}

interface EstimateElement {
    val type : EstimateElementType
    fun getScore() : Int
}

abstract class BaseChooseBox (val code: String, val title:String, val desc:String?=null, val options: List<EstimateOption>) : EstimateElement {

    override fun getScore(): Int {

        return options.filter { it.checked }.sumOf {
            it.getScore()
        }

    }
}

class EstimateRadioBox(code: String, title: String, desc: String? = null, options: List<EstimateOption>) : BaseChooseBox(code, title, desc, options) {
    override val type = EstimateElementType.RadioButton
}

class EstimateCheckBox(code: String, title:String, desc:String?=null, options: List<EstimateOption>) : BaseChooseBox(code, title,desc, options) {
    override val type = EstimateElementType.CheckBox

}


data class EstimateOption(val code: String, val text:String, val score:String) {
    val checked:Boolean = false

    fun getScore(): Int {
        return score.toIntOrNull()?:0
    }
}
