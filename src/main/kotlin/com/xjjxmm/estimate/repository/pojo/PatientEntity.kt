package com.xjjxmm.estimate.repository.pojo

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.time.LocalDateTime


@TableName(value = "patient")
class PatientEntity {
    @TableId(type = IdType.ASSIGN_ID)
    var id: Long? = null

    @TableField(value = "name")
    lateinit var name: String //卒中， 血透

    @TableField(value = "gender")
    var gender: Int? = null  //1 男 2 女 0 其他

    @TableField(value = "age")
    var age: Int? = null

    @TableField(value = "create_time")
    var createTime: LocalDateTime? = null

    @TableField(value = "create_user_id")
    var createUserId: Long? = null

    @TableField(value = "update_time")
    var updateTime: LocalDateTime? = null

    @TableField(value = "update_user_id")
    var updateUserId: Long? = null

}

/*
CREATE TABLE `patient` (
  `id` bigint unsigned NOT NULL,
  `name` varchar(45) NOT NULL COMMENT '姓名',
  `gender` int DEFAULT NULL COMMENT '性别',
  `age` int DEFAULT NULL COMMENT '年龄',
  `create_time` datetime NOT NULL,
  `create_user_id` int NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_user_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
*/
