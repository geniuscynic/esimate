package com.xjjxmm.estimate.repository

import com.xjjxmm.estimate.repository.mapper.EstimateItemMapper
import com.xjjxmm.estimate.repository.pojo.EstimateItemEntity
import org.springframework.stereotype.Repository

@Repository
class EstimateItemRepository : BaseResponse<EstimateItemEntity, EstimateItemMapper>() {

    fun findByPatientId(patientId: Long) : List<EstimateItemEntity> {
        return this.baseMapper.findByPatientId(patientId)
        //return this.ktQuery().eq(EstimateItemEntity::patientId, patientId).list()
    }


}