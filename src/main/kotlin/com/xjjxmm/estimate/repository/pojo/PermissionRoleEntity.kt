package com.xjjxmm.estimate.repository.pojo

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.GrantedAuthority
import java.rmi.server.UID

/**
 * @author zjw
 * @description 自定义用户类
 * @date 2021/8/1
 */
@TableName(value = "permission_role")
data class PermissionRoleEntity(

    @TableId(type = IdType.ASSIGN_ID)
    var id:String?=null,

    @TableField(value = "pid")
    var pid: Long?=null,

    @TableField(value = "rid")
    var rid: Long?=null,
    //@TableField(value = "password")
    //private val authorities: Collection<GrantedAuthority>
)

/*
CREATE TABLE `permission_role` (
  `id` bigint unsigned NOT NULL,
  `pid` bigint NOT NULL COMMENT '用户id',
  `rid` bigint NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
*/

