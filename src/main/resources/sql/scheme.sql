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


DROP TABLE IF EXISTS `nationalplanschedules`;
CREATE TABLE `nationalplanschedules` (
  `id` varchar(50) NOT NULL,
  `routeName` varchar(200) DEFAULT NULL COMMENT '班线名称',
  `loadType` varchar(50) DEFAULT NULL COMMENT '装卸类型',
  `vehicleType` varchar(50) DEFAULT NULL COMMENT '车型',
  `departPeriod` varchar(200) DEFAULT NULL COMMENT '发车周期',
  `departPlaceId` varchar(50) DEFAULT NULL COMMENT '始发地id',
  `departPlace` varchar(50) DEFAULT NULL COMMENT '始发地名称',
  `departTime` time DEFAULT NULL COMMENT '始发时间',
  `destinationId` varchar(50) DEFAULT NULL COMMENT '目的地id',
  `destination` varchar(50) DEFAULT NULL COMMENT '目的地',
  `arteryTime` int(11) DEFAULT NULL COMMENT '干线时效',
  `arriveTime` time DEFAULT NULL COMMENT '到达时间',
  `cargoRoute` varchar(200) DEFAULT NULL COMMENT '货物路线',
  `stopNames` varchar(200) DEFAULT NULL COMMENT '经停地名称',
  `stopsNum` int(4) DEFAULT NULL COMMENT '经停地数目',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='全国计划班次表';


DROP TABLE IF EXISTS `stops`;
CREATE TABLE `stops` (
  `id` varchar(50) NOT NULL,
  `stopId` varchar(50) DEFAULT NULL COMMENT '经停地id',
  `stopName` varchar(50) DEFAULT NULL COMMENT '经停地',
  `stopSort` int(4) DEFAULT NULL COMMENT '经停地顺序',
  `arteryTime` int(11) DEFAULT NULL COMMENT '干线时效',
  `arriveTime` time DEFAULT NULL COMMENT '规定到达时间',
  `intervalTime` int(11) DEFAULT NULL COMMENT '中转间隔时间',
  `leaveTime` time DEFAULT NULL COMMENT '规定离开时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='班次经停地';


DROP TABLE IF EXISTS `schedulesstops`;
CREATE TABLE `schedulesstops` (
  `id` varchar(50) NOT NULL,
  `scheduleId` varchar(50) DEFAULT NULL COMMENT '班次ID',
  `stopId` varchar(50) DEFAULT NULL COMMENT '经停地ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='班次-经停地关联表';