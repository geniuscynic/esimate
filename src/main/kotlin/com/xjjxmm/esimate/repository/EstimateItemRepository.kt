package com.xjjxmm.esimate.repository

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.baomidou.mybatisplus.extension.service.IService
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.xjjxmm.esimate.repository.mapper.EstimateItemMapper
import com.xjjxmm.esimate.repository.pojo.EstimateItemEntity
import org.springframework.stereotype.Repository

@Repository
class EstimateItemRepository : BaseResponse<EstimateItemEntity, EstimateItemMapper>() {

    fun findByPatientId(patientId: Long) : List<EstimateItemEntity> {

        return this.ktQuery().eq(EstimateItemEntity::patientId, patientId).list()
    }
}