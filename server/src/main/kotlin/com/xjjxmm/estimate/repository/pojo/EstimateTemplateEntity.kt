package com.xjjxmm.estimate.repository.pojo

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.baomidou.mybatisplus.annotation.TableName
import java.time.LocalDateTime


@TableName(value = "estimate_template")
data class EstimateTemplateEntity(
    @TableId(type = IdType.AUTO)
    var id : Long?=null,

    @TableField(value = "code")
    var code: String?=null,

    @TableField(value = "filename")
    var fileName : String?=null,

    @TableField(value = "title")
    var title : String?=null,
)

/*
CREATE TABLE `estimate_template` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `code` varchar(45) NOT NULL COMMENT 'code',
  `fileName` varchar(100) NOT NULL COMMENT '文件名',
  `title` varchar(45) NOT NULL COMMENT '量表名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
*/
