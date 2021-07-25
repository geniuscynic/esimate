package com.xjjxmm.esimate.service

import com.xjjxmm.esimate.vo.*
import org.slf4j.LoggerFactory
import org.xml.sax.Attributes
import org.xml.sax.helpers.DefaultHandler

class EstimateTemplateParseHandler : DefaultHandler() {

    private val log = LoggerFactory.getLogger(this.javaClass)

    lateinit var  estimateTemplate  : EstimateTemplate

    private val estimateGroups = mutableListOf<EstimateGroup>()

    private lateinit var estimateGroup : EstimateGroup

    private lateinit var estimateElements : MutableList<EstimateElement>

    private lateinit var estimateRadioBox: EstimateRadioBox
    private lateinit var estimateCheckBox: EstimateCheckBox

    private lateinit var estimateOptions : MutableList<EstimateOption>


    override fun startDocument() {
        super.startDocument()
    }

    override fun startElement(uri: String?, localName: String?, qName: String?, attributes: Attributes?) {
        super.startElement(uri, localName, qName, attributes)

        when (qName) {
            "Template" -> {
                val templateCode = attributes?.getValue("code")?:""
                val templateTitle = attributes?.getValue("title")?:""

                estimateTemplate = EstimateTemplate().apply {
                       code = templateCode
                       title = templateTitle
                       groups = estimateGroups
                }

                log.debug("templateName:$templateCode, templateTitle: $templateTitle")
            }
            "Group" -> {
                val groupCode =attributes?.getValue("code")
                val groupTitle =attributes?.getValue("title")
                val groupDesc =attributes?.getValue("desc")

                estimateElements = mutableListOf()
                estimateGroup = EstimateGroup().apply {
                        code = groupCode
                    title = groupTitle
                    desc = groupDesc
                    elements = estimateElements
                }
                estimateGroups.add(estimateGroup)

                log.debug("groupCode:$groupCode, groupTitle: $groupTitle, groupDesc: $groupDesc")
            }
            "RadioBox" -> {

                val elementCode =attributes?.getValue("code")?:""
                val elementTitle =attributes?.getValue("title")?:""
                val elementDesc =attributes?.getValue("desc")

                estimateOptions = mutableListOf()
                estimateRadioBox = EstimateRadioBox(elementCode, elementTitle, elementDesc, estimateOptions)
                estimateElements.add(estimateRadioBox)


                log.debug("RadioBox:$elementCode, elementTitle: $elementTitle, elementDesc: $elementDesc")
            }
            "CheckBox" -> {
                val elementCode =attributes?.getValue("code")?:""
                val elementTitle =attributes?.getValue("title")?:""
                val elementDesc =attributes?.getValue("desc")

                estimateOptions = mutableListOf()
                estimateCheckBox = EstimateCheckBox(elementCode, elementTitle, elementDesc, estimateOptions)
                estimateElements.add(estimateCheckBox)

                log.debug("CheckBox:$elementCode, elementTitle: $elementTitle, elementDesc: $elementDesc")
            }
            "Option" -> {
                val optionCode =attributes?.getValue("code")?:""
                val optionTitle =attributes?.getValue("text")?:""
                val optionScore =attributes?.getValue("score")?:""

                estimateOptions.add(EstimateOption(optionCode, optionTitle, optionScore))

                log.debug("optionCode:$optionCode, optionTitle: $optionTitle, optionScore: $optionScore")
            }
        }
    }

    override fun characters(ch: CharArray?, start: Int, length: Int) {
        super.characters(ch, start, length)
    }

    override fun endElement(uri: String?, localName: String?, qName: String?) {
        super.endElement(uri, localName, qName)
    }

    override fun endDocument() {
        super.endDocument()
    }

}