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
@TableName(value = "permission")
data class PermissionEntity(

    @TableId(type = IdType.AUTO)
    var id:Long?=null,

    @TableField(value = "code")
    var code: String?=null,

    @TableField(value = "description")
    var description: String?=null,

    @TableField(value = "route")
    var route: String?=null,

    @TableField(value = "route_method")
    var routeMethod: String?=null,

    //@TableField(value = "password")
    //private val authorities: Collection<GrantedAuthority>
)

/*
CREATE TABLE `permission` (
  `id` bigint unsigned NOT NULL,
  `code` varchar(45) NOT NULL COMMENT 'code',
  `description` varchar(45) NOT NULL COMMENT '描述信息',
  `route` varchar(45) DEFAULT NULL COMMENT '密码',
  `routeMethod` varchar(45) DEFAULT NULL COMMENT '盐',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
*/

