package com.xjjxmm.esimate.controller

import com.xjjxmm.esimate.service.PatientService
import com.xjjxmm.esimate.vo.AddPatientVo
import com.xjjxmm.esimate.vo.PatientVo
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@Api(value = "患者管理",  tags = ["患者管理接口"])
@RestController
@RequestMapping("api/patient")
class PatientController {

    @Autowired
    lateinit var patientService: PatientService

    /**
     * @Description: 新增患者
     * @Param: 量表详情
     * @return:
     * @Author: zjw
     * @Date: 2021/7/30
     */
    @ApiOperation(value = "新增患者")
    @PostMapping("add")
    fun add(@RequestBody patientVo : AddPatientVo) : Long {
        return patientService.add(patientVo)
    }

    /**
     * @Description: 修改患者
     * @Param:
     * @return:
     * @Author: zjw
     * @Date: 2021/8/2
     */
    @ApiOperation(value = "保存患者")
    @PostMapping("save")
    fun save(@RequestBody patientVo: PatientVo): Boolean {
        return patientService.save(patientVo)
    }

    /**
     * @Description: 根据id获取患者
     * @Param:
     * @return:
     * @Author: zjw
     * @Date: 2021/8/3
     */
    @ApiOperation(value = "根据id获取患者")
    @GetMapping("{id}")
    fun getById(@PathVariable id : Long) : PatientVo {
        return patientService.getById(id)
    }

    /**
     * @Description: 患者列表
     * @Param:
     * @return:
     * @Author: zjw
     * @Date: 2021/8/3
     */
    @ApiOperation(value = "患者列表")
    @GetMapping("list")
    fun listPatient(): List<PatientVo> {
        return patientService.listPatient()
    }
}