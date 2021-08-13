package com.xjjxmm.estimate.repository.pojo

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.time.LocalDateTime


@TableName(value = "estimate_item")
data class EstimateItemEntity(
    @TableId(type = IdType.ASSIGN_ID)
    var id : Long?=null,

    @TableField(value = "patient_id")
    var patientId: Long?=null,

    //@TableField(value = "rf_Id")
    //var rfId : String?=null,


    @TableField(value = "estimate_phase")
    var estimatePhase : Int?=null, //1,2,3,4 入院 出院

    @TableField(value = "estimate_module")
    var estimateModule : String?=null, //卒中， 血透

    @TableField(value = "template_code")
    var code: String?=null,

    @TableField(value = "content")
    var content: String?=null,

    @TableField(value = "create_Time")
    var createTime : LocalDateTime?=null,

    @TableField(value = "create_User_Id")
    var createUserId: Long?=null,

    @TableField(value = "update_Time")
    var updateTime : LocalDateTime ?=null,

    @TableField(value = "update_User_Id")
    var updateUserId: Long?=null,

    )

/*
CREATE TABLE `estimate_item` (
  `id` bigint unsigned NOT NULL,
  `patient_id` bigint unsigned NOT NULL COMMENT '患者唯一id',
  `rf_id` varchar(45) NOT NULL COMMENT '腕带号',
  `estimate_phase` int NOT NULL COMMENT '评分阶段',
  `estimate_module` varchar(45) NOT NULL COMMENT '所属模块',
  `template_code` varchar(45) NOT NULL COMMENT '量表名',
  `content` longtext NOT NULL COMMENT '内容',
  `create_Time` datetime NOT NULL,
  `create_User_Id` int NOT NULL,
  `update_Time` datetime DEFAULT NULL,
  `update_User_Id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
*/
