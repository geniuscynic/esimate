package com.xjjxmm.estimate.controller

import com.xjjxmm.estimate.service.AccountService
import com.xjjxmm.estimate.vo.AddRoleVo
import com.xjjxmm.estimate.vo.AddUserVo
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@Api(value = "用户",  tags = ["用户管理接口"])
@RestController
@RequestMapping("api/account")
class AccountController {

    private val log = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    lateinit var accountService : AccountService

    /**
     * @Description: 新增角色
     * @Param: 角色详情
     * @return:
     * @Author: zjw
     * @Date: 2021/7/30
     */
    @ApiOperation(value = "新增角色")
    @PostMapping("role/add")
    fun addRole(@RequestBody roleVo: AddRoleVo) : Boolean {
        return accountService.addRole(roleVo)
    }

    /**
     * @Description: 新增用户
     * @Param:
     * @return:
     * @Author: zjw
     * @Date: 2021/8/2
     */
    @ApiOperation(value = "新增用户")
    @PostMapping("user/add")
    fun addUser(@RequestBody userVo: AddUserVo): Boolean {
        return accountService.addUser(userVo)
    }


}