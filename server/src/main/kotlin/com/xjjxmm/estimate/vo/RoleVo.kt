package com.xjjxmm.estimate.vo

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.GrantedAuthority


class AddRoleVo {

    lateinit var code: String

    lateinit var  name: String

    lateinit var  description: String

}

