package com.xjjxmm.esimate.service

import com.xjjxmm.esimate.repository.pojo.EstimateItemEntity
import com.xjjxmm.esimate.vo.*


interface PatientService {

    /**
     * @Description: 新增患者
     * @Param: 量表详情
     * @return:
     * @Author: zjw
     * @Date: 2021/7/30
     */
    fun add(patientVo : AddPatientVo) : Long

    /**
     * @Description: 修改患者
     * @Param:
     * @return:
     * @Author: zjw
     * @Date: 2021/8/2
     */
    fun save(patientVo: PatientVo): Boolean

    /**
    * @Description: 根据id获取患者
    * @Param:
    * @return:
    * @Author: zjw
    * @Date: 2021/8/3
    */
    fun getById(id : Long) : PatientVo

    /**
    * @Description: 患者列表
    * @Param:
    * @return:
    * @Author: zjw
    * @Date: 2021/8/3
    */
    fun listPatient(): List<PatientVo>
}