package com.xjjxmm.estimate.vo


class EstimateTemplate {
    lateinit var  code : String
    lateinit var title : String
    lateinit var groups : List<EstimateGroup>

    fun getScore() : Int {
        return groups.sumOf {
            it.getScore()
        }
    }

    fun setSelectedItems(items : List<SelectedEstimateItem>) {
        groups.forEach {
            it.setSelectedItems(items)
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

     fun setSelectedItems(items : List<SelectedEstimateItem>) {
         elements.forEach {
             it.setSelectedItems(items)
         }
     }
 }

enum class EstimateElementType {
    RadioButton,
    CheckBox
}

interface EstimateElement {
    val code: String

    val type : EstimateElementType
    fun getScore() : Int
    fun setSelectedItems(items: List<SelectedEstimateItem>)
}

abstract class BaseChooseBox (override val code: String, val title:String, val desc:String?=null, val options: List<EstimateOption>) : EstimateElement {

    override fun getScore(): Int {

        return options.filter { it.checked }.sumOf {
            it.getScore()
        }

    }


}

class EstimateRadioBox(code: String, title: String, desc: String? = null, options: List<EstimateOption>) : BaseChooseBox(code, title, desc, options) {
    override val type = EstimateElementType.RadioButton

    var value : String = ""

    override fun setSelectedItems(items : List<SelectedEstimateItem>) {
        items.firstOrNull  { t->t.code == code }?.value?.firstOrNull()?.let { it ->
            value = it

            options.firstOrNull { o -> o.code == value }?.let { op ->
                op.checked = true
            }
        }
    }

}

class EstimateCheckBox(code: String, title:String, desc:String?=null, options: List<EstimateOption>) : BaseChooseBox(code, title,desc, options) {
    override val type = EstimateElementType.CheckBox

    var value : List<String> = mutableListOf()

    override fun setSelectedItems(items : List<SelectedEstimateItem>) {
        items.firstOrNull  { t->t.code == code }?.value?.let { it ->

                value = it

                value.forEach { item ->
                    options.firstOrNull { o -> o.code == item }?.let { op ->
                        op.checked = true
                    }
                }

        }
    }
}


data class EstimateOption(val code: String, val text:String, val score:String) {
    var checked:Boolean = false

    fun getScore(): Int {
        return score.toIntOrNull()?:0
    }
}
