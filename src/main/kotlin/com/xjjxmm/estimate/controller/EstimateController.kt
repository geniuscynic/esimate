package com.xjjxmm.estimate.controller

import com.xjjxmm.estimate.service.EstimateItemService
import com.xjjxmm.estimate.vo.*
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import utity.MappingKit.mapper


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

    /**
     * @Description: 根据患者id得到两边列表
     * @Param:
     * @return:
     * @Author: zjw
     * @Date: 2021/8/4
     */
    @GetMapping("patient/{patientId}")
    fun findByPatientId(@PathVariable("patientId") patientId: Long): List<PatientEstimateItemListVo> {
        return estimateItemService.findByPatientId(patientId)
    }

    @GetMapping("list")
    fun listEstimate(): List<EstimateItemListVo> {
        return estimateItemService.listEstimate()
    }
}