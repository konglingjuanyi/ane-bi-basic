DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `username` varchar(200) DEFAULT NULL,
  `password` varchar(200) DEFAULT NULL,
  `nikename` varchar(200) DEFAULT NULL,
  `number` varchar(100) DEFAULT NULL,
  `id_number` varchar(30) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `phone_number` varchar(50) DEFAULT NULL,
  `avatar_url` varchar(200) DEFAULT NULL,
  `remark` varchar(1000) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `name` varchar(100) DEFAULT NULL COMMENT '角色名',
  `type` varchar(20) DEFAULT NULL COMMENT '角色类型',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  `created` datetime DEFAULT NULL COMMENT '创建时间',
  `updated` datetime DEFAULT NULL COMMENT '修改时间',
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  `created` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS `ane_bi_codes`;
CREATE TABLE `ane_bi_codes` (
  `id` bigint(20) NOT NULL COMMENT '数据域id',
  `code_type` varchar(32) NOT NULL COMMENT '编码类型',
  `code_name` varchar(50) DEFAULT NULL COMMENT '编码名称',
  `create_time` datetime DEFAULT NULL COMMENT '系统生成时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `created_name` varchar(20) DEFAULT NULL COMMENT '操作人',
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`,`code_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统管理/数据编码';
