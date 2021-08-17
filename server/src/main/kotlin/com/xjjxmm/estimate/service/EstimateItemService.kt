package com.xjjxmm.estimate.service

import com.xjjxmm.estimate.model.EstimateTemplate
import com.xjjxmm.estimate.vo.*


interface EstimateItemService {

    /**
    * @Description: 获取量表模板
    * @Param:
    * @return:
    * @Author: zjw
    * @Date: 2021/7/30
    */
    fun getTemplate(code:String) : EstimateTemplate

    /**
     * @Description: 新增评分信息
     * @Param: 量表详情
     * @return:
     * @Author: zjw
     * @Date: 2021/7/30
     */
    fun add(estimateItem : AddEstimateItemVo) : Long

    /**
     * @Description: 修改评分信息
     * @Param:
     * @return:
     * @Author: zjw
     * @Date: 2021/8/2
     */
    fun save(estimateItem: EditEstimateItemVo): Boolean


    fun getByEstimateId(id : Long) : EstimateItemVo

    /**
    * @Description: 根据患者id得到两边列表
    * @Param: 
    * @return: 
    * @Author: zjw
    * @Date: 2021/8/4
    */
    fun findByPatientId(patientId: Long) : List<PatientEstimateItemListVo>

    /**
     * @Description: 获取所有可评分的量表
     * @Param:
     * @return:
     * @Author: zjw
     * @Date: 2021/8/4
     */
    fun listEstimate() : List<EstimateItemListVo>

    /**
     * @Description: 初始化可评分的量表
     * @Param:
     * @return:
     * @Author: zjw
     * @Date: 2021/8/15
     */
    fun initEstimateTemplate(): List<EstimateItemListVo>

}