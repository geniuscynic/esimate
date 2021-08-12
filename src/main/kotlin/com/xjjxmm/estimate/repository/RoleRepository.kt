package com.xjjxmm.estimate.repository

import com.xjjxmm.estimate.repository.mapper.RoleMapper
import com.xjjxmm.estimate.repository.pojo.RoleEntity
import org.springframework.stereotype.Repository

@Repository
class RoleRepository : BaseResponse<RoleEntity, RoleMapper>() {
    
}