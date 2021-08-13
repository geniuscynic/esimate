package com.xjjxmm.estimate.repository.mapper

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import com.xjjxmm.estimate.repository.pojo.RoleEntity
import com.xjjxmm.estimate.repository.pojo.UserEntity

interface UserMapper : BaseMapper<UserEntity> {
    fun getUser(loginName:String) : List<RoleEntity>
}