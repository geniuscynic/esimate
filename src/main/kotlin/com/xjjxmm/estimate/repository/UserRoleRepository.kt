package com.xjjxmm.estimate.repository

import com.xjjxmm.estimate.repository.mapper.UserRoleMapper
import com.xjjxmm.estimate.repository.pojo.UserRoleEntity
import org.springframework.stereotype.Repository

@Repository
class UserRoleRepository : BaseResponse<UserRoleEntity, UserRoleMapper>() {
    
}