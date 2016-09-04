/*
Navicat MySQL Data Transfer

Source Server         : 192.168.7.102
Source Server Version : 50616
Source Host           : 192.168.7.102:3306
Source Database       : ane_bi

Target Server Type    : MYSQL
Target Server Version : 50616
File Encoding         : 65001

Date: 2016-09-04 09:57:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ane_bi_codes
-- ----------------------------
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

-- ----------------------------
-- Records of ane_bi_codes
-- ----------------------------
INSERT INTO `ane_bi_codes` VALUES ('490744315314176', 'aging_type_all', '交件时效', '2016-08-26 16:02:43', '2016-08-26 16:02:43', null, '全部时效类型');
INSERT INTO `ane_bi_codes` VALUES ('490745495486464', 'aging_type_all', '派件时效', '2016-08-26 16:03:01', '2016-08-26 16:03:01', null, '全部时效类型');
INSERT INTO `ane_bi_codes` VALUES ('490746613661696', 'aging_type_all', '干线时效', '2016-08-26 16:03:19', '2016-08-26 16:03:19', null, '全部时效类型');
INSERT INTO `ane_bi_codes` VALUES ('490749742022656', 'aging_type_distr', '交件时效', '2016-08-26 16:04:06', '2016-08-26 16:04:06', null, '分拨时效类型');
INSERT INTO `ane_bi_codes` VALUES ('490750867668992', 'aging_type_distr', '派件时效', '2016-08-26 16:04:23', '2016-08-26 16:04:23', null, '分拨时效类型');
INSERT INTO `ane_bi_codes` VALUES ('490752104726528', 'aging_type_distr', '干线时效', '2016-08-26 16:04:42', '2016-08-26 16:04:42', null, '分拨时效类型');
INSERT INTO `ane_bi_codes` VALUES ('490754655518720', 'aging_type_site', '交件时效', '2016-08-26 16:05:21', '2016-08-26 16:05:21', null, '网点时效类型');
INSERT INTO `ane_bi_codes` VALUES ('490755644260352', 'aging_type_site', '派件时效', '2016-08-26 16:05:36', '2016-08-26 16:05:36', null, '网点时效类型');
INSERT INTO `ane_bi_codes` VALUES ('506484605517824', 'car_type', '9.6m', '2016-08-29 10:45:41', '2016-08-29 10:45:41', null, '车型');
INSERT INTO `ane_bi_codes` VALUES ('506485793423360', 'car_type', '17.5m', '2016-08-29 10:45:59', '2016-08-29 10:45:59', null, '车型');
INSERT INTO `ane_bi_codes` VALUES ('507333249400832', 'distr_level', '超级枢纽', '2016-08-29 14:21:31', '2016-08-29 14:21:31', null, '分拨等级');
INSERT INTO `ane_bi_codes` VALUES ('507335235731456', 'distr_level', '枢纽', '2016-08-29 14:22:01', '2016-08-29 14:22:01', null, '分拨等级');
INSERT INTO `ane_bi_codes` VALUES ('507336670707712', 'distr_level', '一级分拨', '2016-08-29 14:22:23', '2016-08-29 14:22:23', null, '分拨等级');
INSERT INTO `ane_bi_codes` VALUES ('507337708666880', 'distr_level', '二级分拨', '2016-08-29 14:22:39', '2016-08-29 14:22:39', null, '分拨等级');
INSERT INTO `ane_bi_codes` VALUES ('507338346397696', 'distr_level', '三级分拨', '2016-08-29 14:22:48', '2016-08-29 14:22:48', null, '分拨等级');
INSERT INTO `ane_bi_codes` VALUES ('507339519295488', 'distr_level', '一级集散', '2016-08-29 14:23:06', '2016-08-29 14:23:06', null, '分拨等级');
INSERT INTO `ane_bi_codes` VALUES ('507340444532736', 'distr_level', '二级集散', '2016-08-29 14:23:20', '2016-08-29 14:23:20', null, '分拨等级');
INSERT INTO `ane_bi_codes` VALUES ('507341308231680', 'distr_level', '三级集散', '2016-08-29 14:23:34', '2016-08-29 14:23:34', null, '分拨等级');

-- ----------------------------
-- Table structure for ane_bi_cost
-- ----------------------------
DROP TABLE IF EXISTS `ane_bi_cost`;
CREATE TABLE `ane_bi_cost` (
  `cost_id` int(8) NOT NULL AUTO_INCREMENT COMMENT '费用主键',
  `cost_name` varchar(20) DEFAULT NULL COMMENT '费用名称',
  `cost_type` int(3) DEFAULT NULL COMMENT '费用类型',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `source_code` int(3) DEFAULT NULL COMMENT '数据来源',
  `status` int(1) DEFAULT NULL COMMENT '来源',
  PRIMARY KEY (`cost_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='业务指标项目费用表';

-- ----------------------------
-- Records of ane_bi_cost
-- ----------------------------
INSERT INTO `ane_bi_cost` VALUES ('2', '燃油费', '0', '2016-08-30 15:43:09', '0', '1');
INSERT INTO `ane_bi_cost` VALUES ('3', '燃油费', '0', '2016-08-30 15:43:09', '0', '1');
INSERT INTO `ane_bi_cost` VALUES ('4', '燃油费', '0', '2016-08-30 15:43:09', '0', '1');

-- ----------------------------
-- Table structure for ane_bi_daily_module
-- ----------------------------
DROP TABLE IF EXISTS `ane_bi_daily_module`;
CREATE TABLE `ane_bi_daily_module` (
  `module_id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `module_name` varchar(30) DEFAULT NULL COMMENT '模板名称',
  `module_order` int(8) DEFAULT NULL COMMENT '展示顺序',
  `created_id` int(8) DEFAULT NULL COMMENT '创建人工号',
  `created_name` varchar(20) DEFAULT NULL COMMENT '创建人名称',
  `updated_id` int(8) DEFAULT NULL COMMENT '修改人 工号',
  `updated_name` varchar(20) DEFAULT NULL COMMENT '修改人姓名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `status` int(1) DEFAULT NULL COMMENT '数据状态(0:删除，1:正常)',
  PRIMARY KEY (`module_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='日报模板表';

-- ----------------------------
-- Records of ane_bi_daily_module
-- ----------------------------
INSERT INTO `ane_bi_daily_module` VALUES ('1', '模块13', '1', '12121', '杨得朝', '0', null, '2016-08-30 11:12:46', null, '1');
INSERT INTO `ane_bi_daily_module` VALUES ('3', '模块1', '1', '12121', '杨得朝', '0', null, '2016-08-30 11:11:27', null, '1');
INSERT INTO `ane_bi_daily_module` VALUES ('4', '模块1', '1', '12121', '杨得朝', '0', null, '2016-08-30 11:11:28', null, '1');
INSERT INTO `ane_bi_daily_module` VALUES ('5', '模块1', '1', '12121', '杨得朝', '0', null, '2016-08-30 11:11:28', null, '1');
INSERT INTO `ane_bi_daily_module` VALUES ('6', '模块1', '1', '12121', '杨得朝', '0', null, '2016-08-30 11:11:28', null, '1');
INSERT INTO `ane_bi_daily_module` VALUES ('7', '模块1', '1', '12121', '杨得朝', '0', null, '2016-08-30 11:11:28', null, '1');

-- ----------------------------
-- Table structure for ane_bi_dimension
-- ----------------------------
DROP TABLE IF EXISTS `ane_bi_dimension`;
CREATE TABLE `ane_bi_dimension` (
  `dimension_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键标识',
  `dimension_name` varchar(50) DEFAULT NULL COMMENT '维度名称',
  `kpi_id` int(10) DEFAULT NULL COMMENT 'kpi标识',
  `dimension_type` int(3) DEFAULT NULL COMMENT '维度类别',
  `obj_date` datetime DEFAULT NULL COMMENT '月份',
  `target_value` double DEFAULT NULL COMMENT '目标值',
  `department_id` int(3) DEFAULT NULL COMMENT '部门编号',
  `department_type` varchar(50) DEFAULT NULL COMMENT '部门类别',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `created_name` varchar(50) DEFAULT NULL COMMENT '创建人',
  `created_id` int(8) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`dimension_id`),
  KEY `kip_id` (`kpi_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='维度目标值维护表';

-- ----------------------------
-- Records of ane_bi_dimension
-- ----------------------------
INSERT INTO `ane_bi_dimension` VALUES ('14', '浙江省区', '1', '1', '2016-08-22 15:58:07', '0.92', '110', '运营', '2016-08-22 15:58:44', null, '阿萨德飞洒', '45454', '1');
INSERT INTO `ane_bi_dimension` VALUES ('15', '浙江省区', '1', '1', '2016-08-22 15:58:07', '0.92', '110', '运营', '2016-08-22 15:58:44', null, '阿萨德飞洒', '45454', '1');
INSERT INTO `ane_bi_dimension` VALUES ('16', '杭州大区', '1', '0', null, '0', '0', '运维', '2016-08-29 17:42:51', null, '杨得朝', '12121', '1');
INSERT INTO `ane_bi_dimension` VALUES ('17', '杭州大区', '1', '0', null, '0', '0', '运维', '2016-08-29 17:47:36', null, '杨得朝', '12121', '1');
INSERT INTO `ane_bi_dimension` VALUES ('18', '杭州大区', '1', '0', null, '0', '0', '运维', '2016-08-29 17:48:42', null, '杨得朝', '12121', '1');
INSERT INTO `ane_bi_dimension` VALUES ('19', '杭州大区', '1', '0', null, '0', '0', '运维', '2016-08-29 18:02:27', null, '杨得朝', '12121', '1');

-- ----------------------------
-- Table structure for ane_bi_fixed_target
-- ----------------------------
DROP TABLE IF EXISTS `ane_bi_fixed_target`;
CREATE TABLE `ane_bi_fixed_target` (
  `fixed_target_id` int(8) NOT NULL AUTO_INCREMENT COMMENT '固定指标主键',
  `fixed_target_name` varchar(50) DEFAULT NULL COMMENT '固定指标名称',
  `show_mark` int(1) DEFAULT NULL COMMENT '呈现标识(1:呈现，0:不呈现)',
  `show_name` varchar(50) DEFAULT NULL COMMENT '呈现名称',
  `show_type` varchar(50) DEFAULT NULL COMMENT '呈现方式',
  `target_order` int(8) DEFAULT NULL COMMENT '自定义顺序',
  `module_id` int(8) DEFAULT NULL COMMENT '所属模块',
  `fixed_mark` int(1) DEFAULT NULL COMMENT '固定指标标识(1:固定，0:非固定)',
  `created_id` int(8) DEFAULT NULL COMMENT '创建人id',
  `created_name` varchar(30) DEFAULT NULL COMMENT '创建人名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `updated_id` int(8) DEFAULT NULL COMMENT '修改人id',
  `updated_name` varchar(30) DEFAULT NULL COMMENT '修改人名称',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `status` int(1) DEFAULT NULL COMMENT '数据状态',
  PRIMARY KEY (`fixed_target_id`),
  KEY `所属模块` (`module_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='固定指标维护表';

-- ----------------------------
-- Records of ane_bi_fixed_target
-- ----------------------------
INSERT INTO `ane_bi_fixed_target` VALUES ('1', '网络收入修改', '1', '网络收入修改', '模式二', '3', '0', '0', '0', '杨得朝', '2016-09-03 11:23:54', '2323', '更新', '2016-09-03 11:23:54', '1');
INSERT INTO `ane_bi_fixed_target` VALUES ('2', '网络收入', '1', '网络收入', null, '1', '0', '0', '0', '杨得朝', '2016-09-03 11:21:29', '0', null, null, '1');
INSERT INTO `ane_bi_fixed_target` VALUES ('3', '网络收入', '1', '网络收入', null, '1', '0', '0', '0', '杨得朝', '2016-09-03 11:21:29', '0', null, null, '1');
INSERT INTO `ane_bi_fixed_target` VALUES ('4', '网络收入', '1', '网络收入', null, '1', '0', '0', '0', '杨得朝', '2016-09-03 11:21:30', '0', null, null, '1');
INSERT INTO `ane_bi_fixed_target` VALUES ('5', '网络收入', '1', '网络收入', '模式一', '1', '0', '0', '0', '杨得朝', '2016-09-03 11:31:37', '0', null, null, '1');
INSERT INTO `ane_bi_fixed_target` VALUES ('6', '网络收入', '1', '网络收入', '模式一', '1', '0', '0', '0', '杨得朝', '2016-09-03 11:31:38', '0', null, null, '1');
INSERT INTO `ane_bi_fixed_target` VALUES ('7', '网络收入', '1', '网络收入', '模式一', '1', '0', '0', '0', '杨得朝', '2016-09-03 11:31:38', '0', null, null, '1');
INSERT INTO `ane_bi_fixed_target` VALUES ('8', '网络收入', '1', '网络收入', '模式一', '1', '0', '0', '0', '杨得朝', '2016-09-03 11:31:39', '0', null, null, '1');
INSERT INTO `ane_bi_fixed_target` VALUES ('9', '网络收入', '1', '网络收入', '模式一', '1', '0', '0', '0', '杨得朝', '2016-09-03 11:31:39', '0', null, null, '1');
INSERT INTO `ane_bi_fixed_target` VALUES ('10', '网络收入', '1', '网络收入', '模式一', '1', '0', '0', '0', '杨得朝', '2016-09-03 11:31:39', '0', null, null, '1');
INSERT INTO `ane_bi_fixed_target` VALUES ('11', '网络收入', '1', '网络收入', '模式一', '1', '0', '0', '0', '杨得朝', '2016-09-03 11:31:39', '0', null, null, '1');
INSERT INTO `ane_bi_fixed_target` VALUES ('12', '网络收入', '1', '网络收入', '模式一', '1', '0', '0', '0', '杨得朝', '2016-09-03 11:31:39', '0', null, null, '1');
INSERT INTO `ane_bi_fixed_target` VALUES ('13', '网络收入', '1', '网络收入', '模式一', '1', '0', '0', '0', '杨得朝', '2016-09-03 11:31:40', '0', null, null, '1');
INSERT INTO `ane_bi_fixed_target` VALUES ('14', '网络收入', '1', '网络收入', '模式一', '1', '0', '0', '0', '杨得朝', '2016-09-03 11:31:40', '0', null, null, '1');
INSERT INTO `ane_bi_fixed_target` VALUES ('15', '网络收入', '1', '网络收入', '模式一', '1', '0', '0', '0', '杨得朝', '2016-09-03 11:31:40', '0', null, null, '1');
INSERT INTO `ane_bi_fixed_target` VALUES ('16', '网络收入', '1', '网络收入', '模式一', '1', '0', '0', '0', '杨得朝', '2016-09-03 11:31:40', '0', null, null, '1');
INSERT INTO `ane_bi_fixed_target` VALUES ('17', '网络收入', '1', '网络收入', '模式一', '1', '0', '0', '0', '杨得朝', '2016-09-03 11:31:40', '0', null, null, '1');

-- ----------------------------
-- Table structure for ane_bi_kpi
-- ----------------------------
DROP TABLE IF EXISTS `ane_bi_kpi`;
CREATE TABLE `ane_bi_kpi` (
  `kpi_id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'kip主键',
  `kpi_name` varchar(20) DEFAULT NULL COMMENT 'kip名称',
  `kpi_simple_name` varchar(20) DEFAULT NULL COMMENT '简称',
  `kpi_type` int(3) DEFAULT NULL COMMENT 'kpi类型',
  `effective_begin_time` datetime DEFAULT NULL COMMENT '有效结束时间',
  `effective_end_time` datetime DEFAULT NULL COMMENT '有效开始时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `created_name` varchar(20) DEFAULT NULL COMMENT '创建人姓名',
  `updated_name` varchar(20) DEFAULT NULL COMMENT '修改人姓名',
  `created_id` int(8) DEFAULT NULL COMMENT '创建人Id',
  `updated_id` int(8) DEFAULT NULL COMMENT '修改人id',
  `status` int(1) DEFAULT NULL COMMENT '启用状态',
  PRIMARY KEY (`kpi_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COMMENT='KPI基础数据表';

-- ----------------------------
-- Records of ane_bi_kpi
-- ----------------------------
INSERT INTO `ane_bi_kpi` VALUES ('18', '万票遗失率', 'wpysl', '1', null, null, '2016-09-01 14:56:28', null, '杨得朝', null, '0', '0', '1');
INSERT INTO `ane_bi_kpi` VALUES ('19', '万票遗失率', 'wpysl', '1', null, null, '2016-09-01 14:56:31', null, '杨得朝', null, '0', '0', '1');
INSERT INTO `ane_bi_kpi` VALUES ('20', '万票遗失率', 'wpysl', '1', null, null, '2016-09-01 14:56:31', null, '杨得朝', null, '0', '0', '1');
INSERT INTO `ane_bi_kpi` VALUES ('21', '万票遗失率', 'wpysl', '1', null, null, '2016-09-01 14:56:31', null, '杨得朝', null, '0', '0', '1');
INSERT INTO `ane_bi_kpi` VALUES ('22', '万票遗失率', 'wpysl', '1', null, null, '2016-09-01 14:56:31', null, '杨得朝', null, '0', '0', '1');
INSERT INTO `ane_bi_kpi` VALUES ('23', '万票遗失率', 'wpysl', '1', null, null, '2016-09-01 14:56:32', null, '杨得朝', null, '0', '0', '1');
INSERT INTO `ane_bi_kpi` VALUES ('24', '万票遗失率', 'wpysl', '1', null, null, '2016-09-01 14:56:32', null, '杨得朝', null, '0', '0', '1');
INSERT INTO `ane_bi_kpi` VALUES ('25', '万票遗失率', 'wpysl', '1', null, null, '2016-09-01 14:56:32', null, '杨得朝', null, '0', '0', '1');
INSERT INTO `ane_bi_kpi` VALUES ('26', '万票遗失率', 'wpysl', '1', null, null, '2016-09-01 14:56:32', null, '杨得朝', null, '0', '0', '1');
INSERT INTO `ane_bi_kpi` VALUES ('27', '万票遗失率', 'wpysl', '1', null, null, '2016-09-01 14:56:32', null, '杨得朝', null, '0', '0', '1');
INSERT INTO `ane_bi_kpi` VALUES ('28', '万票遗失率', 'wpysl', '1', null, null, '2016-09-01 14:56:32', null, '杨得朝', null, '0', '0', '1');
INSERT INTO `ane_bi_kpi` VALUES ('29', '万票遗失率', 'wpysl', '1', null, null, '2016-09-01 14:56:33', null, '杨得朝', null, '0', '0', '1');
INSERT INTO `ane_bi_kpi` VALUES ('30', '万票遗失率', 'wpysl', '1', null, null, '2016-09-03 09:28:14', null, '杨得朝', null, '0', '0', '1');
INSERT INTO `ane_bi_kpi` VALUES ('31', '万票遗失率', 'wpysl', '1', null, null, '2016-09-03 09:28:16', null, '杨得朝', null, '0', '0', '1');
INSERT INTO `ane_bi_kpi` VALUES ('32', '万票遗失率', 'wpysl', '1', null, null, '2016-09-03 09:28:16', null, '杨得朝', null, '0', '0', '1');
INSERT INTO `ane_bi_kpi` VALUES ('33', '万票遗失率', 'wpysl', '1', null, null, '2016-09-03 09:28:16', null, '杨得朝', null, '0', '0', '1');
INSERT INTO `ane_bi_kpi` VALUES ('34', '万票遗失率', 'wpysl', '1', null, null, '2016-09-03 09:28:16', null, '杨得朝', null, '0', '0', '1');

-- ----------------------------
-- Table structure for ane_bi_organization
-- ----------------------------
DROP TABLE IF EXISTS `ane_bi_organization`;
CREATE TABLE `ane_bi_organization` (
  `ID` bigint(20) DEFAULT NULL COMMENT 'ID',
  `AREA` varchar(50) DEFAULT NULL COMMENT '区域',
  `AREA_PROVINCE` varchar(50) DEFAULT NULL COMMENT '省区',
  `AREA_REGION` varchar(50) DEFAULT NULL COMMENT '运营大区',
  `DISTRIBUTION` varchar(50) DEFAULT NULL COMMENT '分拨',
  `DISTR_LEVEL` varchar(50) DEFAULT NULL COMMENT '分拨等级',
  `UPDATE_BY` varchar(50) DEFAULT NULL COMMENT '最后修改人',
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '最后修改时间',
  `SYNC_TIME` datetime DEFAULT NULL COMMENT '最新同步时间',
  `VALID_DATE` datetime DEFAULT NULL COMMENT '有效日期',
  `IS_FORBIDDEN` int(1) DEFAULT NULL COMMENT '是否禁用(1是0否)'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织架构管理';

-- ----------------------------
-- Records of ane_bi_organization
-- ----------------------------

-- ----------------------------
-- Table structure for ane_bi_plan_time
-- ----------------------------
DROP TABLE IF EXISTS `ane_bi_plan_time`;
CREATE TABLE `ane_bi_plan_time` (
  `operation_id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `site_id` int(8) DEFAULT NULL COMMENT '分拨id',
  `site_name` varchar(50) DEFAULT NULL COMMENT '分拨名称',
  `car_type_name` varchar(50) DEFAULT NULL COMMENT '车辆名称',
  `car_type` varchar(20) DEFAULT NULL COMMENT '车型',
  `unload_car_time` double(8,0) DEFAULT NULL COMMENT '卸车操作时间(单位是小时)',
  `load_car_time` double(6,0) DEFAULT NULL COMMENT '装车操作时间(单位是小时)',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `created_id` int(8) DEFAULT NULL COMMENT '创建人id',
  `created_name` varchar(50) DEFAULT NULL COMMENT '创建人姓名',
  `status` int(1) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`operation_id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ane_bi_plan_time
-- ----------------------------
INSERT INTO `ane_bi_plan_time` VALUES ('1', '12121', '上海分拨中心更新', null, '0', '0', '0', '2016-09-02 10:09:03', '2016-09-02 10:09:03', '0', '杨得朝更新', '1');
INSERT INTO `ane_bi_plan_time` VALUES ('2', '12121', '上海分拨中心', null, '0', '0', '0', '2016-09-02 10:07:33', null, '0', '杨得朝', '1');
INSERT INTO `ane_bi_plan_time` VALUES ('3', '12121', '上海分拨中心', null, '0', '0', '0', '2016-09-02 10:07:34', null, '0', '杨得朝', '1');
INSERT INTO `ane_bi_plan_time` VALUES ('4', '12121', '上海分拨中心', null, '0', '0', '0', '2016-09-02 10:07:34', null, '0', '杨得朝', '1');
INSERT INTO `ane_bi_plan_time` VALUES ('5', '12121', '上海分拨中心', null, '0', '0', '0', '2016-09-02 10:07:34', null, '0', '杨得朝', '1');
INSERT INTO `ane_bi_plan_time` VALUES ('6', '12121', '上海分拨中心', null, '0', '0', '0', '2016-09-02 10:13:12', null, '0', '杨得朝', '1');
INSERT INTO `ane_bi_plan_time` VALUES ('7', '12121', '上海分拨中心', null, '0', '0', '0', '2016-09-02 10:13:13', null, '0', '杨得朝', '1');
INSERT INTO `ane_bi_plan_time` VALUES ('8', '12121', '上海分拨中心', null, '0', '0', '0', '2016-09-02 10:13:13', null, '0', '杨得朝', '1');
INSERT INTO `ane_bi_plan_time` VALUES ('9', '12121', '上海分拨中心', null, '0', '0', '0', '2016-09-02 10:13:13', null, '0', '杨得朝', '1');
INSERT INTO `ane_bi_plan_time` VALUES ('10', '12121', '上海分拨中心', null, '0', '0', '0', '2016-09-02 10:13:14', null, '0', '杨得朝', '1');
INSERT INTO `ane_bi_plan_time` VALUES ('11', '12121', '上海分拨中心', null, '0', '0', '0', '2016-09-02 10:13:14', null, '0', '杨得朝', '1');
INSERT INTO `ane_bi_plan_time` VALUES ('12', '12121', '上海分拨中心', null, '0', '0', '0', '2016-09-02 10:13:14', null, '0', '杨得朝', '1');
INSERT INTO `ane_bi_plan_time` VALUES ('13', '12121', '上海分拨中心', null, '0', '0', '0', '2016-09-02 10:13:14', null, '0', '杨得朝', '1');
INSERT INTO `ane_bi_plan_time` VALUES ('14', '12121', '上海分拨中心', null, '0', '0', '0', '2016-09-02 10:13:14', null, '0', '杨得朝', '1');
INSERT INTO `ane_bi_plan_time` VALUES ('15', '12121', '上海分拨中心', null, '0', '0', '0', '2016-09-02 10:13:14', null, '0', '杨得朝', '1');
INSERT INTO `ane_bi_plan_time` VALUES ('16', '12121', '上海分拨中心', null, '0', '0', '0', '2016-09-02 10:13:15', null, '0', '杨得朝', '1');
INSERT INTO `ane_bi_plan_time` VALUES ('17', '12121', '上海分拨中心', null, '0', '0', '0', '2016-09-02 10:13:15', null, '0', '杨得朝', '1');

-- ----------------------------
-- Table structure for ane_bi_site_extra_days
-- ----------------------------
DROP TABLE IF EXISTS `ane_bi_site_extra_days`;
CREATE TABLE `ane_bi_site_extra_days` (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `site_name` varchar(50) DEFAULT NULL COMMENT '网点名称',
  `site_pinyin` varchar(50) DEFAULT NULL COMMENT '网点拼音',
  `site_type` varchar(50) DEFAULT NULL COMMENT '网点属性',
  `aging_type` varchar(50) DEFAULT NULL COMMENT '时效类型',
  `extra_days` int(2) DEFAULT NULL COMMENT '额外天数',
  `memo` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(50) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='全国时效额外天数表';

-- ----------------------------
-- Records of ane_bi_site_extra_days
-- ----------------------------
INSERT INTO `ane_bi_site_extra_days` VALUES ('484715579441152', '上海分拨中心', 'shfbzx', '一级分拨中心', '交件时效', '1', '上海分拨中心', null, '2016-08-26 09:47:23', null, '2016-08-26 09:48:02');
INSERT INTO `ane_bi_site_extra_days` VALUES ('484722049024000', '苏州分拨中心', 'szfbzx', '一级分拨中心', '干线时效', '-2', '苏州分拨中心', null, '2016-08-26 09:47:23', null, '2016-08-26 09:47:52');
INSERT INTO `ane_bi_site_extra_days` VALUES ('485059053355008', '常山网点', 'cswd', '二级分拨中心', '交件时效', '1', '常山网点', null, '2016-08-26 09:47:20', null, '2016-08-26 09:47:55');
INSERT INTO `ane_bi_site_extra_days` VALUES ('485169283203072', '南通分拨中心', 'ntfbzx', '一级分拨中心', '交件时效', '1', '南通分拨中心', null, '2016-08-26 09:47:16', null, '2016-08-26 09:47:59');
INSERT INTO `ane_bi_site_extra_days` VALUES ('489238979674112', '通州网点', 'tzwd', '一级网点', '交件时效', '1', '通州网点', null, '2016-08-26 09:47:14', null, '2016-08-26 10:07:29');
INSERT INTO `ane_bi_site_extra_days` VALUES ('489349149884416', '如东网点', 'rdwd', '一级网点', '交件时效', '-1', '如东网点升水', null, '2016-08-26 10:07:55', null, '2016-08-26 10:07:55');
INSERT INTO `ane_bi_site_extra_days` VALUES ('489350471680000', '上海分拨中心', 'shfbzx', '一级分拨中心', '派件时效', '1', null, null, '2016-08-26 10:08:15', null, '2016-08-26 10:08:15');
INSERT INTO `ane_bi_site_extra_days` VALUES ('489351060258816', '上海分拨中心', 'shfbzx', '一级分拨中心', '干线时效', '1', null, null, '2016-08-26 10:08:24', null, '2016-08-26 10:08:24');
INSERT INTO `ane_bi_site_extra_days` VALUES ('489352667594752', '如东网点', 'rdwd', '一级网点', '干线时效', '1', null, null, '2016-08-26 10:08:49', null, '2016-08-26 10:08:49');
INSERT INTO `ane_bi_site_extra_days` VALUES ('489353663807488', '如东网点', 'rdwd', '一级网点', '派件时效', '1', null, null, '2016-08-26 10:09:04', null, '2016-08-26 10:09:04');
INSERT INTO `ane_bi_site_extra_days` VALUES ('489354787291136', '测试数据', 'cssj', '二级网点', '交件时效', '1', '测试数据', null, '2016-08-26 10:09:21', null, '2016-08-29 16:35:43');

-- ----------------------------
-- Table structure for ane_bi_site_radio_standard
-- ----------------------------
DROP TABLE IF EXISTS `ane_bi_site_radio_standard`;
CREATE TABLE `ane_bi_site_radio_standard` (
  `d` bigint(20) NOT NULL COMMENT '主键ID',
  `radio` decimal(5,4) DEFAULT NULL COMMENT '比例值',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(50) DEFAULT NULL COMMENT '修改人',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`d`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='班车可承接网点比例标准表';

-- ----------------------------
-- Records of ane_bi_site_radio_standard
-- ----------------------------
INSERT INTO `ane_bi_site_radio_standard` VALUES ('479180414386176', '0.5600', null, '2016-08-24 15:01:52', null, '2016-08-24 15:01:52');

-- ----------------------------
-- Table structure for ane_bi_target
-- ----------------------------
DROP TABLE IF EXISTS `ane_bi_target`;
CREATE TABLE `ane_bi_target` (
  `target_id` int(8) NOT NULL AUTO_INCREMENT COMMENT '指标主键',
  `target_name` varchar(20) DEFAULT NULL COMMENT '指标名称',
  `income_mark` int(1) DEFAULT NULL COMMENT '收入标识(1:选中，0：未选中)',
  `price_mark` int(1) DEFAULT NULL COMMENT '单价标识(1:选中，0:未选中)',
  `created_id` int(8) DEFAULT NULL COMMENT '创建人id',
  `created_name` varchar(20) DEFAULT NULL COMMENT '创建人名称',
  `updated_id` int(8) DEFAULT NULL COMMENT '修改人id',
  `updated_name` varchar(20) DEFAULT NULL COMMENT '修改人名称',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `status` int(1) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`target_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='业务类指标表';

-- ----------------------------
-- Records of ane_bi_target
-- ----------------------------
INSERT INTO `ane_bi_target` VALUES ('2', '网络增值业务', '1', '1', '12121', '杨得朝', '0', null, '2016-08-30 15:15:29', null, '1');
INSERT INTO `ane_bi_target` VALUES ('3', '网络增值业务', '1', '1', '12121', '杨得朝', '0', null, '2016-08-30 15:17:26', null, '1');
INSERT INTO `ane_bi_target` VALUES ('4', '网络增值业务', '1', '1', '12121', '杨得朝', '0', null, '2016-08-30 15:17:26', null, '1');
INSERT INTO `ane_bi_target` VALUES ('5', '网络增值业务', '1', '1', '12121', '杨得朝', '0', null, '2016-08-30 15:17:26', null, '1');

-- ----------------------------
-- Table structure for ane_bi_target_cost
-- ----------------------------
DROP TABLE IF EXISTS `ane_bi_target_cost`;
CREATE TABLE `ane_bi_target_cost` (
  `operation_id` int(8) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `target_id` int(8) DEFAULT NULL COMMENT '业务指标id',
  `cost_id` int(8) DEFAULT NULL COMMENT '费用项目id',
  PRIMARY KEY (`operation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='业务指标/费用项目关系表';

-- ----------------------------
-- Records of ane_bi_target_cost
-- ----------------------------

-- ----------------------------
-- Table structure for nationalplanschedules
-- ----------------------------
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

-- ----------------------------
-- Records of nationalplanschedules
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
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

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for schedulesstops
-- ----------------------------
DROP TABLE IF EXISTS `schedulesstops`;
CREATE TABLE `schedulesstops` (
  `id` varchar(50) NOT NULL,
  `scheduleId` varchar(50) DEFAULT NULL COMMENT '班次ID',
  `stopId` varchar(50) DEFAULT NULL COMMENT '经停地ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='班次-经停地关联表';

-- ----------------------------
-- Records of schedulesstops
-- ----------------------------

-- ----------------------------
-- Table structure for stops
-- ----------------------------
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

-- ----------------------------
-- Records of stops
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
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

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', '1', '1', '1', '1', '1', '1', '1', '1', '2016-08-17 17:23:02', '2016-08-17 17:22:58', '1');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  `created` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
