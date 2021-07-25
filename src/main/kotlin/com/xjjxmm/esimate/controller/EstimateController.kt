package com.xjjxmm.esimate.controller

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.xjjxmm.esimate.service.EstimateItemService
import com.xjjxmm.esimate.service.EstimateTemplateParseHandler
import com.xjjxmm.esimate.vo.AddEstimateItemVo
import com.xjjxmm.esimate.vo.EstimateItemVo
import com.xjjxmm.esimate.vo.EstimateTemplate
import io.swagger.annotations.Api
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.DefaultResourceLoader
import org.springframework.core.io.Resource
import org.springframework.core.io.ResourceLoader
import org.springframework.web.bind.annotation.*
import utity.MappingKit.mapper
import java.io.BufferedReader

import java.io.InputStreamReader
import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.parsers.SAXParserFactory


@Api(value = "量表",  tags = ["量表测试接口"])
@RestController
@RequestMapping("estimate")
class EstimateController {

    private val log = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    lateinit var estimateItemService : EstimateItemService

    @PostMapping
    fun add(@RequestBody estimateItem : AddEstimateItemVo) : Long {
        return estimateItemService.add(estimateItem)
    }

    @GetMapping
    fun getById(id: Long): EstimateItemVo {
        val entity = estimateItemService.getById(id)

        return entity.mapper()
    }

    @GetMapping("patient/{patientId}")
    fun findByPatientId(@PathVariable("patientId") patientId: Long): List<EstimateItemVo> {
        val entity = estimateItemService.findByPatientId(patientId)

        return entity.mapper()
    }

    @GetMapping("template/{code}")
    fun getTemplate(code:String) : EstimateTemplate{
        val resourceLoader: ResourceLoader = DefaultResourceLoader()
        val inputFile: Resource = resourceLoader.getResource("templates/$code.xml")

        if(!inputFile.exists()) {
            throw Exception("$code.xml 文件不存在")
        }

        val sAXParserFactory = SAXParserFactory.newInstance()
        val sAXParser = sAXParserFactory.newSAXParser()

        val handler = EstimateTemplateParseHandler()
        sAXParser.parse(inputFile.inputStream, handler)

        return handler.estimateTemplate

    }
}