package com.xjjxmm.esimate.controller

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.xjjxmm.esimate.service.EstimateItemService
import com.xjjxmm.esimate.service.EstimateTemplateParseHandler
import com.xjjxmm.esimate.vo.*
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.DefaultResourceLoader
import org.springframework.core.io.Resource
import org.springframework.core.io.ResourceLoader
import org.springframework.web.bind.annotation.*
import utity.MappingKit.mapper
import java.io.BufferedReader

import java.io.InputStreamReader
import java.lang.annotation.ElementType
import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.parsers.SAXParserFactory


@Api(value = "量表",  tags = ["量表测试接口"])
@RestController
@RequestMapping("api/estimate")
class EstimateController {

    private val log = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    lateinit var estimateItemService : EstimateItemService

    /**
     * @Description: 获取量表模板
     * @Param:
     * @return:
     * @Author: zjw
     * @Date: 2021/7/30
     */
    @ApiOperation(value = "获取量表模板")
    @GetMapping("template/{code}")
    fun getEstimateTemplate(@PathVariable("code")code: String): EstimateTemplate {
        val entity = estimateItemService.getTemplate( code)

        return entity.mapper()
    }

    /**
     * @Description: 查找量表详情
     * @Param:
     * @return:
     * @Author: zjw
     * @Date: 2021/7/30
     */
    @ApiOperation(value = "查找量表详情")
    @GetMapping("{id}")
    fun getEstimateDetailById(@PathVariable id : Long) : EstimateItemVo {
        return estimateItemService.getByEstimateId(id)
    }

    /**
    * @Description: 新增评分信息
    * @Param: 量表详情
    * @return:
    * @Author: zjw
    * @Date: 2021/7/30
    */
    @ApiOperation(value = "新增评分信息")
    @PostMapping("add")
    fun add(@RequestBody estimateItem : AddEstimateItemVo) : Long {
        return estimateItemService.add(estimateItem)
    }

    /**
    * @Description: 修改评分信息
    * @Param:
    * @return:
    * @Author: zjw
    * @Date: 2021/8/2
    */
    @ApiOperation(value = "修改评分信息")
    @PostMapping("save")
    fun save(@RequestBody estimateItem:  EditEstimateItemVo) : Boolean {
        return estimateItemService.save(estimateItem)
    }




    /*@GetMapping
    fun getByEstimateId(@PathVariable("id")id: Long): EstimateItemVo {
        val entity = estimateItemService.getByEstimateId(id)

        return entity.mapper()
    }*/

    @GetMapping("patient/{patientId}")
    fun findByPatientId(@PathVariable("patientId") patientId: Long): List<EstimateItemVo> {
        val entity = estimateItemService.findByPatientId(patientId)

        return entity.mapper()
    }
}