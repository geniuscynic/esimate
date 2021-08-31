CREATE TABLE `estimate_item`
(
    `id`              bigint unsigned NOT NULL,
    `patient_id`      bigint unsigned NOT NULL COMMENT '患者唯一id',
    #`rf_id`           varchar(45)     NOT NULL COMMENT '腕带号',
    `estimate_phase`  int             NOT NULL COMMENT '评分阶段',
    `estimate_module` varchar(45)     NOT NULL COMMENT '所属模块',
    `template_code`   varchar(45)     NOT NULL COMMENT '量表名',
    `content`         longtext        NOT NULL COMMENT '内容',
    `create_Time`     datetime        NOT NULL,
    `create_User_Id`  int             NOT NULL,
    `update_Time`     datetime DEFAULT NULL,
    `update_User_Id`  int      DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `estimate_template`
(
    `id`       bigint unsigned NOT NULL AUTO_INCREMENT,
    `code`     varchar(45)     NOT NULL COMMENT 'code',
    `fileName` varchar(100)    NOT NULL COMMENT '文件名',
    `title`    varchar(45)     NOT NULL COMMENT '量表名称',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;


CREATE TABLE `patient`
(
    `id`             bigint unsigned NOT NULL,
    `name`           varchar(45)     NOT NULL COMMENT '姓名',
    `gender`         int      DEFAULT NULL COMMENT '性别',
    `age`            int      DEFAULT NULL COMMENT '年龄',
    `create_time`    datetime        NOT NULL,
    `create_user_id` int             NOT NULL,
    `update_time`    datetime DEFAULT NULL,
    `update_user_id` int      DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `permission`
(
    `id`          bigint unsigned NOT NULL,
    `code`        varchar(45)     NOT NULL COMMENT 'code',
    `description` varchar(45)     NOT NULL COMMENT '描述信息',
    `route`       varchar(45) DEFAULT NULL COMMENT '密码',
    `routeMethod` varchar(45) DEFAULT NULL COMMENT '盐',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

CREATE TABLE `permission_role`
(
    `id`  bigint unsigned NOT NULL,
    `pid` bigint          NOT NULL COMMENT '用户id',
    `rid` bigint          NOT NULL COMMENT '角色id',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;


CREATE TABLE `role`
(
    `id`   bigint unsigned NOT NULL,
    `code` varchar(45)     NOT NULL COMMENT 'code',
    `name` varchar(45)     NOT NULL COMMENT '名称',
    `desc` varchar(45) DEFAULT NULL COMMENT '描述',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;


CREATE TABLE `user`
(
    `id`             bigint unsigned NOT NULL,
    `username`       varchar(45)     NOT NULL COMMENT '姓名',
    `loginname`      varchar(45)     NOT NULL COMMENT '登入名',
    `password`       varchar(45) DEFAULT NULL COMMENT '密码',
    `salt`           varchar(45) DEFAULT NULL COMMENT '盐',
    `create_time`    datetime        NOT NULL,
    `create_user_id` int             NOT NULL,
    `update_time`    datetime    DEFAULT NULL,
    `update_user_id` int         DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;


CREATE TABLE `user_role`
(
    `id`  bigint unsigned NOT NULL,
    `uid` bigint          NOT NULL COMMENT '用户id',
    `rid` bigint          NOT NULL COMMENT '角色id',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;