package com.xjjxmm.estimate.repository

import com.xjjxmm.estimate.repository.mapper.PatientMapper
import com.xjjxmm.estimate.repository.pojo.PatientEntity
import org.springframework.stereotype.Repository

@Repository
class PatientRepository : BaseResponse<PatientEntity, PatientMapper>() {
}