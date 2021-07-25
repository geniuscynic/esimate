package com.xjjxmm.esimate.service

import com.xjjxmm.esimate.repository.pojo.EstimateItemEntity
import com.xjjxmm.esimate.vo.AddEstimateItemVo
import com.xjjxmm.esimate.vo.EstimateItemVo


interface EstimateItemService {

    fun add(estimateItem : AddEstimateItemVo) : Long

    fun getById(id : Long) : EstimateItemVo

    fun findByPatientId(patientId: Long) : List<EstimateItemVo>

}