package com.xjjxmm.esimate.service

import com.xjjxmm.esimate.repository.pojo.EstimateItemEntity
import com.xjjxmm.esimate.vo.AddEstimateItemVo
import com.xjjxmm.esimate.vo.EstimateItemVo
import com.xjjxmm.esimate.vo.EstimateTemplate


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

    fun getByEstimateId(id : Long) : EstimateItemVo

    fun findByPatientId(patientId: Long) : List<EstimateItemVo>





}