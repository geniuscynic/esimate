package com.xjjxmm.estimate.service

import com.xjjxmm.estimate.vo.PermissionVo


interface PermissionService {
    /**
     * @Description: 新增患者
     * @Param: 量表详情
     * @return:
     * @Author: zjw
     * @Date: 2021/7/30
     */
    fun add(permissionVo : PermissionVo) : Long
}