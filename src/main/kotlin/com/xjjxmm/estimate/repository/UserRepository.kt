package com.xjjxmm.estimate.repository

import com.xjjxmm.estimate.repository.mapper.UserMapper
import com.xjjxmm.estimate.repository.pojo.RoleEntity
import com.xjjxmm.estimate.repository.pojo.UserEntity
import org.springframework.stereotype.Repository

@Repository
class UserRepository : BaseResponse<UserEntity, UserMapper>() {
    fun getUser(loginName:String) : List<RoleEntity> {
        return this.baseMapper.getUser(loginName)
    }
}