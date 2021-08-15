package com.xjjxmm.estimate.repository

import com.xjjxmm.estimate.repository.mapper.EstimateItemMapper
import com.xjjxmm.estimate.repository.mapper.EstimateTemplateMapper
import com.xjjxmm.estimate.repository.pojo.EstimateItemEntity
import com.xjjxmm.estimate.repository.pojo.EstimateTemplateEntity
import org.springframework.stereotype.Repository

@Repository
class EstimateTemplateRepository : BaseResponse<EstimateTemplateEntity, EstimateTemplateMapper>() {



}