package com.xjjxmm.estimate.repository.pojo

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.GrantedAuthority

/**
 * @author zjw
 * @description 自定义用户类
 * @date 2021/8/1
 */
@TableName(value = "role")
data class RoleEntity(

    @TableId(type = IdType.ASSIGN_ID)
    var id:Long?=null,

    @TableField(value = "code")
    var code: String?=null,

    @TableField(value = "name")
    var  name: String?=null,

    @TableField(value = "`desc`")
    var  description: String?=null,

    //@TableField(value = "password")
    //private val authorities: Collection<GrantedAuthority>
)

/*
CREATE TABLE `role` (
  `id` bigint unsigned NOT NULL,
  `code` varchar(45) NOT NULL COMMENT 'code',
  `name` varchar(45) NOT NULL COMMENT '名称',
  `desc` varchar(45) DEFAULT NULL COMMENT '描述'
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
*/
