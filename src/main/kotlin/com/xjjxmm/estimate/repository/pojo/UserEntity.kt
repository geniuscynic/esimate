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
@TableName(value = "user")
data class UserEntity(

    @TableId(type = IdType.ASSIGN_ID)
    var id:Long?=null,

    @TableField(value = "username")
    var nickName: String?=null,

    @TableField(value = "loginname")
    var loginName: String?=null,

    @TableField(value = "password")
    var password: String?=null,

    @TableField(value = "salt")
    var salt: String?=null,

    //@TableField(value = "password")
    //private val authorities: Collection<GrantedAuthority>
)

/*
CREATE TABLE `user` (
  `id` bigint unsigned NOT NULL,
  `username` varchar(45) NOT NULL COMMENT '姓名',
  `loginname` varchar(45) NOT NULL COMMENT '登入名',
  `password` varchar(45) DEFAULT NULL COMMENT '密码',
  `salt` varchar(45) DEFAULT NULL COMMENT '盐',
  `create_time` datetime NOT NULL,
  `create_user_id` int NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
*/

