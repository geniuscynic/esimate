package com.xjjxmm.estimate.vo

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId

class PermissionVo {

    var id:Long = 0

    lateinit var code: String

    lateinit var description: String

    lateinit var route: String

    lateinit var routeMethod: String

}