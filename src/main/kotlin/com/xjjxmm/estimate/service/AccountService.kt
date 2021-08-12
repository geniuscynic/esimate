package com.xjjxmm.estimate.service

import com.xjjxmm.estimate.vo.AddRoleVo
import com.xjjxmm.estimate.vo.AddUserVo


interface AccountService {

    /**
     * @Description: 新增角色
     * @Param: 角色详情
     * @return:
     * @Author: zjw
     * @Date: 2021/7/30
     */
    fun addRole(roleVo: AddRoleVo) : Boolean

    /**
     * @Description: 新增用户
     * @Param:
     * @return:
     * @Author: zjw
     * @Date: 2021/8/2
     */
    fun addUser(userVo: AddUserVo): Boolean

   
}