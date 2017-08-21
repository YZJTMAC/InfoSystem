/*
Navicat MySQL Data Transfer

Source Server         : wuliu
Source Server Version : 50154
Source Host           : localhost:3306
Source Database       : edu

Target Server Type    : MYSQL
Target Server Version : 50154
File Encoding         : 65001

Date: 2014-06-09 09:20:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `edu_audit`
-- ----------------------------
DROP TABLE IF EXISTS `edu_audit`;
CREATE TABLE `edu_audit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_id` int(11) DEFAULT NULL,
  `audit_status` int(11) DEFAULT NULL COMMENT '审核状态,15:自动审核通过、13:通过，12：未通过,14:审核中,11:未审核 ',
  `audit_auditor` varchar(20) DEFAULT NULL COMMENT '审核人',
  `audit_date` datetime DEFAULT NULL COMMENT '审核时间',
  `audit_option` text COMMENT '审核意见',
  `audit_create_by` varchar(20) DEFAULT NULL,
  `audit_update_by` varchar(20) DEFAULT NULL,
  `audit_create_date` datetime DEFAULT NULL,
  `audit_update_date` datetime DEFAULT NULL,
  `old_version` int(11) DEFAULT NULL COMMENT '教师信息旧版本号',
  `new_version` int(11) DEFAULT NULL COMMENT '教师信息新版本号',
  `change_type` int(11) DEFAULT NULL COMMENT '变更类型:1 信息变更 、 2 调动操作 、50编制调动、离退操作:(31 退休、32死亡 、33离休、34离岗、35病休、36其他) ',
  `past_province_id` int(11) DEFAULT NULL,
  `past_province_name` varchar(255) DEFAULT NULL,
  `past_city_id` int(11) DEFAULT NULL,
  `past_city_name` varchar(255) DEFAULT NULL,
  `past_district_id` int(11) DEFAULT NULL,
  `past_district_name` varchar(255) DEFAULT NULL,
  `past_school_id` int(11) DEFAULT NULL,
  `past_school_name` varchar(255) DEFAULT NULL,
  `new_province_id` int(11) DEFAULT NULL,
  `new_province_name` varchar(255) DEFAULT NULL,
  `new_city_id` int(11) DEFAULT NULL,
  `new_city_name` varchar(255) DEFAULT NULL,
  `new_district_id` int(11) DEFAULT NULL,
  `new_district_name` varchar(255) DEFAULT NULL,
  `new_school_id` int(11) DEFAULT NULL,
  `new_school_name` varchar(255) DEFAULT NULL,
  `mobilizeMark` text COMMENT '调动说明',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of edu_audit
-- ----------------------------
INSERT INTO `edu_audit` VALUES ('1', '13', '13', 'hnadmin', '2014-05-21 11:04:42', '', 'hnadmin', 'hnadmin', '2014-05-21 11:04:23', '2014-05-21 11:04:42', '1', '2', '2', '1', '湖南省', '2', '长沙市', '5', '天心区', '2', '天心区小学', '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '调动测试');
INSERT INTO `edu_audit` VALUES ('2', '16', '12', 'hnadmin', '2014-05-23 16:20:48', '', 'hnadmin', 'hnadmin', '2014-05-23 16:17:24', '2014-05-23 16:20:48', '1', '2', '2', '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '1', '湖南省', '2', '长沙市', '5', '天心区', '2', '天心区小学', '信息修改');
INSERT INTO `edu_audit` VALUES ('3', '16', '13', 'hnadmin', '2014-05-23 16:24:22', '', 'hnadmin', 'hnadmin', '2014-05-23 16:23:15', '2014-05-23 16:24:22', '3', '4', '2', '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '1', '湖南省', '2', '长沙市', '5', '天心区', '2', '天心区小学', '调动信息');
INSERT INTO `edu_audit` VALUES ('4', '16', '12', 'hnadmin', '2014-05-23 16:34:02', '不够资格', 'hnadmin', 'hnadmin', '2014-05-23 16:31:44', '2014-05-23 16:34:02', '4', '5', '50', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '补充编制');
INSERT INTO `edu_audit` VALUES ('5', '16', '13', 'hnadmin', '2014-05-23 16:36:14', '同意', 'hnadmin', 'hnadmin', '2014-05-23 16:35:48', '2014-05-23 16:36:14', '6', '7', '50', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '调整编制');
INSERT INTO `edu_audit` VALUES ('6', '16', '12', 'hnadmin', '2014-05-23 16:43:22', '需要医院证明', 'hnadmin', 'hnadmin', '2014-05-23 16:39:48', '2014-05-23 16:43:22', null, null, '35', null, null, null, null, null, null, null, null, '1', '湖南省', '2', '长沙市', '5', '天心区', '2', '天心区小学', '高血压');
INSERT INTO `edu_audit` VALUES ('7', '16', '13', 'hnadmin', '2014-05-23 16:48:09', '通过', 'hnadmin', 'hnadmin', '2014-05-23 16:47:46', '2014-05-23 16:48:09', null, null, '35', null, null, null, null, null, null, null, null, '1', '湖南省', '2', '长沙市', '5', '天心区', '2', '天心区小学', '高血压，已经开具医院证明');
INSERT INTO `edu_audit` VALUES ('8', '17', '12', 'hnadmin', '2014-05-23 16:53:16', '不符合条件', 'hnadmin', 'hnadmin', '2014-05-23 16:52:01', '2014-05-23 16:53:16', null, null, '34', null, null, null, null, null, null, null, null, '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '');
INSERT INTO `edu_audit` VALUES ('9', '17', '13', 'hnadmin', '2014-05-26 10:33:03', '', 'hnadmin', 'hnadmin', '2014-05-23 16:53:54', '2014-05-26 10:33:03', null, null, '34', null, null, null, null, null, null, null, null, '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '身体不适');
INSERT INTO `edu_audit` VALUES ('10', '7', '13', 'hnadmin', '2014-05-23 16:55:07', '通过', 'hnadmin', 'hnadmin', '2014-05-23 16:54:31', '2014-05-23 16:55:07', null, null, '35', null, null, null, null, null, null, null, null, '1', '湖南省', '2', '长沙市', '6', '长沙市', '8', '望城区实验小学', '');
INSERT INTO `edu_audit` VALUES ('11', '12', '12', 'hnadmin', '2014-05-23 17:01:43', '虚假信息', 'hnadmin', 'hnadmin', '2014-05-23 17:00:20', '2014-05-23 17:01:43', null, null, '32', null, null, null, null, null, null, null, null, '1', '湖南省', '3', '湘潭市', '11', '湘潭市', '7', '韶山初中', '');
INSERT INTO `edu_audit` VALUES ('12', '12', '13', 'hnadmin', '2014-05-23 17:03:59', '通过', 'hnadmin', 'hnadmin', '2014-05-23 17:03:24', '2014-05-23 17:03:59', null, null, '32', null, null, null, null, null, null, null, null, '1', '湖南省', '3', '湘潭市', '11', '湘潭市', '7', '韶山初中', '死亡');
INSERT INTO `edu_audit` VALUES ('13', '6', '12', 'hnadmin', '2014-05-23 17:11:57', '', 'hnadmin', 'hnadmin', '2014-05-23 17:07:49', '2014-05-23 17:11:57', null, null, '31', null, null, null, null, null, null, null, null, '1', '湖南省', '2', '长沙市', '5', '长沙市', '2', '天心区小学', '');
INSERT INTO `edu_audit` VALUES ('14', '6', '13', 'hnadmin', '2014-05-23 17:14:48', '通过', 'hnadmin', 'hnadmin', '2014-05-23 17:13:08', '2014-05-23 17:14:48', null, null, '33', null, null, null, null, null, null, null, null, '1', '湖南省', '2', '长沙市', '5', '长沙市', '2', '天心区小学', '离休');
INSERT INTO `edu_audit` VALUES ('15', '16', '12', 'hnadmin', '2014-05-23 17:20:30', '', 'hnadmin', 'hnadmin', '2014-05-23 17:17:49', '2014-05-23 17:20:30', '7', '8', '40', '1', '湖南省', '2', '长沙市', '5', '天心区', '2', '天心区小学', '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '有能力');
INSERT INTO `edu_audit` VALUES ('16', '16', '13', 'hnadmin', '2014-05-23 17:21:27', '', 'hnadmin', 'hnadmin', '2014-05-23 17:21:05', '2014-05-23 17:21:27', '9', '10', '40', '1', '湖南省', '2', '长沙市', '5', '天心区', '2', '天心区小学', '1', '湖南省', '3', '湘潭市', '8', '雨湖区', '1', '雨湖区初中', '返聘');
INSERT INTO `edu_audit` VALUES ('17', '18', '12', 'hnadmin', '2014-05-26 10:10:35', '', 'laoshi21', 'hnadmin', '2014-05-26 10:08:50', '2014-05-26 10:10:35', '1', '2', '1', null, null, null, null, null, null, null, null, '1', '湖南省', '2', '长沙市', '4', '长沙市', '4', '芙蓉区小学', null);
INSERT INTO `edu_audit` VALUES ('18', '18', '13', 'hnadmin', '2014-05-26 10:14:18', '', 'laoshi21', 'hnadmin', '2014-05-26 10:14:01', '2014-05-26 10:14:18', '3', '4', '1', null, null, null, null, null, null, null, null, '1', '湖南省', '2', '长沙市', '4', '长沙市', '4', '芙蓉区小学', null);
INSERT INTO `edu_audit` VALUES ('19', '16', '13', 'hnadmin', '2014-05-26 10:18:15', '', 'hnadmin', 'hnadmin', '2014-05-26 10:18:08', '2014-05-26 10:18:15', null, null, '35', null, null, null, null, null, null, null, null, '1', '湖南省', '3', '湘潭市', '8', '雨湖区', '1', '雨湖区初中', '');
INSERT INTO `edu_audit` VALUES ('20', '26', '13', 'hnadmin', '2014-05-26 10:25:05', '123', 'hnadmin', 'hnadmin', '2014-05-26 10:24:50', '2014-05-26 10:25:05', null, null, '34', null, null, null, null, null, null, null, null, '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '123');
INSERT INTO `edu_audit` VALUES ('21', '16', '13', 'hnadmin', '2014-05-26 10:30:36', '', 'hnadmin', 'hnadmin', '2014-05-26 10:30:27', '2014-05-26 10:30:36', '10', '11', '40', '1', '湖南省', '3', '湘潭市', '8', '雨湖区', '1', '雨湖区初中', '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '都得');
INSERT INTO `edu_audit` VALUES ('22', '16', '13', 'hnadmin', '2014-05-26 10:30:55', '', 'hnadmin', 'hnadmin', '2014-05-26 10:30:49', '2014-05-26 10:30:55', null, null, '34', null, null, null, null, null, null, null, null, '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '');
INSERT INTO `edu_audit` VALUES ('23', '18', '13', 'hnadmin', '2014-05-26 15:35:35', '', 'laoshi21', 'hnadmin', '2014-05-26 15:23:48', '2014-05-26 15:35:35', '4', '5', '50', null, null, null, null, null, null, null, null, '1', '湖南省', '2', '长沙市', '4', '长沙市', '4', '芙蓉区小学', null);
INSERT INTO `edu_audit` VALUES ('24', '18', '13', 'hnadmin', '2014-05-26 15:37:56', '', 'hnadmin', 'hnadmin', '2014-05-26 15:36:00', '2014-05-26 15:37:56', '5', '6', '2', '1', '湖南省', '2', '长沙市', '4', '长沙市', '4', '芙蓉区小学', '1', '湖南省', '2', '长沙市', '5', '天心区', '2', '天心区小学', '发起调动');
INSERT INTO `edu_audit` VALUES ('25', '18', '13', 'hnadmin', '2014-05-27 14:43:44', '', 'hnadmin', 'hnadmin', '2014-05-27 14:43:34', '2014-05-27 14:43:44', '6', '7', '2', '1', '湖南省', '2', '长沙市', '5', '天心区', '2', '天心区小学', '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '阿斯顿');
INSERT INTO `edu_audit` VALUES ('26', '18', '13', 'hnadmin', '2014-05-27 14:44:12', '', 'hnadmin', 'hnadmin', '2014-05-27 14:44:03', '2014-05-27 14:44:12', '7', '8', '50', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '都得');
INSERT INTO `edu_audit` VALUES ('27', '23', '13', 'hnadmin', '2014-05-28 09:12:34', '', 'hnadmin', 'hnadmin', '2014-05-28 09:08:52', '2014-05-28 09:12:34', '1', '2', '2', '1', '湖南省', '3', '湘潭市', '9', '湘潭市', '6', '岳塘区小学', '1', '湖南省', '3', '湘潭市', '9', '湘潭市', '6', '岳塘区小学', '具体要求');
INSERT INTO `edu_audit` VALUES ('28', '23', '13', 'hnadmin', '2014-05-28 09:12:23', '', 'hnadmin', 'hnadmin', '2014-05-28 09:08:53', '2014-05-28 09:12:23', '1', '2', '2', '1', '湖南省', '3', '湘潭市', '9', '湘潭市', '6', '岳塘区小学', '1', '湖南省', '3', '湘潭市', '9', '湘潭市', '6', '岳塘区小学', '具体要求');
INSERT INTO `edu_audit` VALUES ('29', '18', '12', 'shengadmin', '2014-05-29 13:05:36', '111', 'hnadmin', 'shengadmin', '2014-05-28 09:09:38', '2014-05-29 13:05:36', '8', '9', '2', '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '发起调动');
INSERT INTO `edu_audit` VALUES ('30', '22', '11', null, null, null, 'hnadmin', 'hnadmin', '2014-05-28 09:10:30', '2014-05-28 09:10:30', '1', '2', '2', '1', '湖南省', '3', '湘潭市', '8', '湘潭市', '1', '雨湖区初中', '1', '湖南省', '3', '湘潭市', '8', '湘潭市', '1', '雨湖区初中', '调动');
INSERT INTO `edu_audit` VALUES ('31', '23', '11', null, null, null, 'hnadmin', 'hnadmin', '2014-05-28 09:13:26', '2014-05-28 09:13:26', '2', '3', '2', '1', '湖南省', '3', '湘潭市', '9', '湘潭市', '6', '岳塘区小学', '1', '湖南省', '3', '湘潭市', '9', '湘潭市', '6', '岳塘区小学', '11');
INSERT INTO `edu_audit` VALUES ('32', '13', '13', 'hnadmin', '2014-05-28 09:23:10', '', 'hnadmin', 'hnadmin', '2014-05-28 09:22:24', '2014-05-28 09:23:10', '2', '3', '2', '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '1', '湖南省', '2', '长沙市', '5', '天心区', '2', '天心区小学', '调动');
INSERT INTO `edu_audit` VALUES ('33', '13', '13', 'hnadmin', '2014-05-28 09:55:07', '', 'hnadmin', 'hnadmin', '2014-05-28 09:54:24', '2014-05-28 09:55:07', null, null, '35', null, null, null, null, null, null, null, null, '1', '湖南省', '2', '长沙市', '5', '天心区', '2', '天心区小学', '病休');
INSERT INTO `edu_audit` VALUES ('34', '13', '13', 'hnadmin', '2014-05-28 09:58:01', '', 'hnadmin', 'hnadmin', '2014-05-28 09:55:31', '2014-05-28 09:58:01', '3', '4', '40', '1', '湖南省', '2', '长沙市', '5', '天心区', '2', '天心区小学', '1', '湖南省', '2', '长沙市', '5', '天心区', '2', '天心区小学', '返聘');
INSERT INTO `edu_audit` VALUES ('35', '13', '13', 'hnadmin', '2014-05-28 09:59:10', '', 'hnadmin', 'hnadmin', '2014-05-28 09:58:46', '2014-05-28 09:59:10', null, null, '34', null, null, null, null, null, null, null, null, '1', '湖南省', '2', '长沙市', '5', '天心区', '2', '天心区小学', '离岗');
INSERT INTO `edu_audit` VALUES ('36', '13', '13', 'hnadmin', '2014-05-28 10:12:34', '', 'hnadmin', 'hnadmin', '2014-05-28 10:00:20', '2014-05-28 10:12:34', '4', '5', '40', '1', '湖南省', '2', '长沙市', '5', '天心区', '2', '天心区小学', '1', '湖南省', '2', '长沙市', '5', '天心区', '2', '天心区小学', '1');
INSERT INTO `edu_audit` VALUES ('37', '13', '13', 'hnadmin', '2014-05-28 10:13:23', '', 'hnadmin', 'hnadmin', '2014-05-28 10:13:06', '2014-05-28 10:13:23', null, null, '31', null, null, null, null, null, null, null, null, '1', '湖南省', '2', '长沙市', '5', '天心区', '2', '天心区小学', '退休');
INSERT INTO `edu_audit` VALUES ('38', '13', '13', 'hnadmin', '2014-05-28 10:13:51', '', 'hnadmin', 'hnadmin', '2014-05-28 10:13:39', '2014-05-28 10:13:51', '5', '6', '40', '1', '湖南省', '2', '长沙市', '5', '天心区', '2', '天心区小学', '1', '湖南省', '2', '长沙市', '5', '天心区', '2', '天心区小学', '1');
INSERT INTO `edu_audit` VALUES ('39', '13', '13', 'hnadmin', '2014-05-28 10:14:21', '', 'hnadmin', 'hnadmin', '2014-05-28 10:14:02', '2014-05-28 10:14:21', null, null, '31', null, null, null, null, null, null, null, null, '1', '湖南省', '2', '长沙市', '5', '天心区', '2', '天心区小学', '1');
INSERT INTO `edu_audit` VALUES ('40', '13', '13', 'hnadmin', '2014-05-28 10:14:44', '', 'hnadmin', 'hnadmin', '2014-05-28 10:14:34', '2014-05-28 10:14:44', '6', '7', '40', '1', '湖南省', '2', '长沙市', '5', '天心区', '2', '天心区小学', '1', '湖南省', '2', '长沙市', '5', '天心区', '2', '天心区小学', '1');
INSERT INTO `edu_audit` VALUES ('41', '13', '12', 'hnadmin', '2014-05-28 10:15:30', '', 'hnadmin', 'hnadmin', '2014-05-28 10:15:00', '2014-05-28 10:15:30', null, null, '32', null, null, null, null, null, null, null, null, '1', '湖南省', '2', '长沙市', '5', '天心区', '2', '天心区小学', '死亡');
INSERT INTO `edu_audit` VALUES ('42', '13', '13', 'hnadmin', '2014-05-28 10:38:10', '证件齐全', 'hnadmin', 'hnadmin', '2014-05-28 10:17:46', '2014-05-28 10:38:10', null, null, '35', null, null, null, null, null, null, null, null, '1', '湖南省', '2', '长沙市', '5', '天心区', '2', '天心区小学', '1');
INSERT INTO `edu_audit` VALUES ('43', '13', '13', 'hnadmin', '2014-05-28 10:19:42', '', 'hnadmin', 'hnadmin', '2014-05-28 10:19:34', '2014-05-28 10:19:42', '7', '8', '40', '1', '湖南省', '2', '长沙市', '5', '天心区', '2', '天心区小学', '1', '湖南省', '2', '长沙市', '5', '天心区', '2', '天心区小学', '1');
INSERT INTO `edu_audit` VALUES ('44', '13', '13', 'hnadmin', '2014-05-28 10:22:06', '符合离岗要求', 'hnadmin', 'hnadmin', '2014-05-28 10:20:11', '2014-05-28 10:22:06', null, null, '34', null, null, null, null, null, null, null, null, '1', '湖南省', '2', '长沙市', '5', '天心区', '2', '天心区小学', '11');
INSERT INTO `edu_audit` VALUES ('45', '13', '13', 'hnadmin', '2014-05-28 10:22:26', '', 'hnadmin', 'hnadmin', '2014-05-28 10:22:16', '2014-05-28 10:22:26', '8', '9', '40', '1', '湖南省', '2', '长沙市', '5', '天心区', '2', '天心区小学', '1', '湖南省', '2', '长沙市', '5', '天心区', '2', '天心区小学', '1');
INSERT INTO `edu_audit` VALUES ('46', '13', '13', 'hnadmin', '2014-05-28 10:23:53', '符合条件', 'hnadmin', 'hnadmin', '2014-05-28 10:22:37', '2014-05-28 10:23:53', null, null, '31', null, null, null, null, null, null, null, null, '1', '湖南省', '2', '长沙市', '5', '天心区', '2', '天心区小学', '1');
INSERT INTO `edu_audit` VALUES ('47', '13', '13', 'hnadmin', '2014-05-28 10:26:59', '', 'hnadmin', 'hnadmin', '2014-05-28 10:25:29', '2014-05-28 10:26:59', '9', '10', '40', '1', '湖南省', '2', '长沙市', '5', '天心区', '2', '天心区小学', '1', '湖南省', '2', '长沙市', '5', '天心区', '2', '天心区小学', '紧缺人才');
INSERT INTO `edu_audit` VALUES ('48', '13', '13', 'hnadmin', '2014-05-28 10:38:31', '', 'hnadmin', 'hnadmin', '2014-05-28 10:38:24', '2014-05-28 10:38:31', '10', '11', '40', '1', '湖南省', '2', '长沙市', '5', '天心区', '2', '天心区小学', '1', '湖南省', '2', '长沙市', '5', '天心区', '2', '天心区小学', '1');
INSERT INTO `edu_audit` VALUES ('49', '6', '13', 'hnadmin', '2014-05-28 10:53:24', '', 'hnadmin', 'hnadmin', '2014-05-28 10:53:16', '2014-05-28 10:53:24', '1', '2', '40', '1', '湖南省', '2', '长沙市', '5', '长沙市', '2', '天心区小学', '1', '湖南省', '2', '长沙市', '5', '长沙市', '2', '天心区小学', '1');
INSERT INTO `edu_audit` VALUES ('50', '6', '13', 'hnadmin', '2014-05-28 10:54:13', '', 'hnadmin', 'hnadmin', '2014-05-28 10:54:07', '2014-05-28 10:54:13', null, null, '34', null, null, null, null, null, null, null, null, '1', '湖南省', '2', '长沙市', '5', '长沙市', '2', '天心区小学', '1');
INSERT INTO `edu_audit` VALUES ('51', '6', '13', 'hnadmin', '2014-05-28 10:54:38', '', 'hnadmin', 'hnadmin', '2014-05-28 10:54:31', '2014-05-28 10:54:38', '2', '3', '40', '1', '湖南省', '2', '长沙市', '5', '长沙市', '2', '天心区小学', '1', '湖南省', '2', '长沙市', '5', '长沙市', '2', '天心区小学', '1');
INSERT INTO `edu_audit` VALUES ('52', '6', '13', 'hnadmin', '2014-05-28 10:54:54', '', 'hnadmin', 'hnadmin', '2014-05-28 10:54:48', '2014-05-28 10:54:54', null, null, '31', null, null, null, null, null, null, null, null, '1', '湖南省', '2', '长沙市', '5', '长沙市', '2', '天心区小学', '1');
INSERT INTO `edu_audit` VALUES ('53', '6', '13', 'hnadmin', '2014-05-28 10:55:19', '', 'hnadmin', 'hnadmin', '2014-05-28 10:55:13', '2014-05-28 10:55:19', '3', '4', '40', '1', '湖南省', '2', '长沙市', '5', '长沙市', '2', '天心区小学', '1', '湖南省', '2', '长沙市', '5', '长沙市', '2', '天心区小学', '1');
INSERT INTO `edu_audit` VALUES ('54', '7', '13', 'hnadmin', '2014-05-28 16:20:55', '', 'hnadmin', 'hnadmin', '2014-05-28 16:20:48', '2014-05-28 16:20:55', '1', '2', '40', '1', '湖南省', '2', '长沙市', '6', '长沙市', '8', '望城区实验小学', '1', '湖南省', '2', '长沙市', '6', '长沙市', '8', '望城区实验小学', '2');
INSERT INTO `edu_audit` VALUES ('55', '13', '13', 'shengadmin', '2014-05-29 16:01:13', '', 'shengadmin', 'shengadmin', '2014-05-29 16:01:02', '2014-05-29 16:01:13', '11', '12', '2', '1', '湖南省', '2', '长沙市', '5', '天心区', '2', '天心区小学', '1', '湖南省', '2', '长沙市', '5', '天心区', '2', '天心区小学', '11');
INSERT INTO `edu_audit` VALUES ('56', '16', '13', 'shengadmin', '2014-05-29 16:39:35', '', 'shengadmin', 'shengadmin', '2014-05-29 16:39:28', '2014-05-29 16:39:35', '11', '12', '40', '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '1');
INSERT INTO `edu_audit` VALUES ('57', '16', '13', 'shengadmin', '2014-05-29 16:39:54', '', 'shengadmin', 'shengadmin', '2014-05-29 16:39:46', '2014-05-29 16:39:54', null, null, '31', null, null, null, null, null, null, null, null, '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '11');
INSERT INTO `edu_audit` VALUES ('58', '16', '13', 'shengadmin', '2014-05-29 16:40:23', '', 'shengadmin', 'shengadmin', '2014-05-29 16:40:17', '2014-05-29 16:40:23', '12', '13', '40', '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '1');
INSERT INTO `edu_audit` VALUES ('59', '16', '13', 'shengadmin', '2014-05-29 16:40:49', '', 'shengadmin', 'shengadmin', '2014-05-29 16:40:42', '2014-05-29 16:40:49', null, null, '33', null, null, null, null, null, null, null, null, '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '1');
INSERT INTO `edu_audit` VALUES ('60', '16', '13', 'shengadmin', '2014-05-29 16:41:26', '', 'shengadmin', 'shengadmin', '2014-05-29 16:41:20', '2014-05-29 16:41:26', '13', '14', '40', '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '1');
INSERT INTO `edu_audit` VALUES ('61', '16', '13', 'shengadmin', '2014-05-29 16:41:40', '', 'shengadmin', 'shengadmin', '2014-05-29 16:41:34', '2014-05-29 16:41:40', null, null, '35', null, null, null, null, null, null, null, null, '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '1');
INSERT INTO `edu_audit` VALUES ('62', '16', '13', 'shengadmin', '2014-05-29 16:42:08', '1', 'shengadmin', 'shengadmin', '2014-05-29 16:42:01', '2014-05-29 16:42:08', '14', '15', '40', '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '1');
INSERT INTO `edu_audit` VALUES ('63', '26', '13', 'shengadmin', '2014-06-04 14:03:31', '', 'shengadmin', 'shengadmin', '2014-06-04 14:03:15', '2014-06-04 14:03:31', '1', '2', '40', '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '11');
INSERT INTO `edu_audit` VALUES ('64', '17', '13', 'shengadmin', '2014-06-04 14:06:45', '', 'shengadmin', 'shengadmin', '2014-06-04 14:06:24', '2014-06-04 14:06:45', '1', '2', '40', '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '1');
INSERT INTO `edu_audit` VALUES ('65', '17', '13', 'shengadmin', '2014-06-04 14:07:09', '1', 'shengadmin', 'shengadmin', '2014-06-04 14:07:00', '2014-06-04 14:07:09', null, null, '35', null, null, null, null, null, null, null, null, '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '1');
INSERT INTO `edu_audit` VALUES ('66', '17', '13', 'shengadmin', '2014-06-04 14:12:53', '', 'shengadmin', 'shengadmin', '2014-06-04 14:08:20', '2014-06-04 14:12:53', '2', '3', '40', '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '1');
INSERT INTO `edu_audit` VALUES ('67', '17', '12', 'shengadmin', '2014-06-04 14:17:47', '1', 'shengadmin', 'shengadmin', '2014-06-04 14:15:42', '2014-06-04 14:17:47', '3', '4', '50', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '方便管理');
INSERT INTO `edu_audit` VALUES ('68', '17', '13', 'shengadmin', '2014-06-04 14:19:28', '通过', 'shengadmin', 'shengadmin', '2014-06-04 14:18:09', '2014-06-04 14:19:28', '5', '6', '50', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '补充编制');
INSERT INTO `edu_audit` VALUES ('69', '38', '13', 'shengadmin', '2014-06-04 14:34:30', '', 'shengadmin', 'shengadmin', '2014-06-04 14:34:11', '2014-06-04 14:34:30', '1', '2', '2', '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '测试');
INSERT INTO `edu_audit` VALUES ('70', '5', '11', 'teacher1', '2014-06-05 00:00:00', null, 'teacher1', 'teacher1', '2014-06-05 09:33:22', '2014-06-05 09:33:22', '1', '2', '1', null, null, null, null, null, null, null, null, '1', '湖南省', '2', '长沙市', '4', '长沙市', '4', '芙蓉区小学', null);
INSERT INTO `edu_audit` VALUES ('71', '40', '13', 'xuexiaoadmin', '2014-06-06 17:19:57', '123', 'xuexiaoadmin', 'xuexiaoadmin', '2014-06-06 17:19:37', '2014-06-06 17:19:57', null, null, '31', null, null, null, null, null, null, null, null, '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '11');
INSERT INTO `edu_audit` VALUES ('72', '40', '12', 'xuexiaoadmin', '2014-06-06 17:31:26', '1123', 'xuexiaoadmin', 'xuexiaoadmin', '2014-06-06 17:27:44', '2014-06-06 17:31:26', '1', '2', '40', '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '11');
INSERT INTO `edu_audit` VALUES ('73', '40', '12', 'xuexiaoadmin', '2014-06-06 17:32:33', '11', 'xuexiaoadmin', 'xuexiaoadmin', '2014-06-06 17:27:44', '2014-06-06 17:32:33', '1', '2', '40', '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '11');
INSERT INTO `edu_audit` VALUES ('74', '40', '13', 'xuexiaoadmin', '2014-06-06 17:40:02', '1123', 'xuexiaoadmin', 'xuexiaoadmin', '2014-06-06 17:39:03', '2014-06-06 17:40:02', '4', '5', '40', '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '11');
INSERT INTO `edu_audit` VALUES ('75', '40', '13', 'xuexiaoadmin', '2014-06-06 17:47:28', '123123', 'xuexiaoadmin', 'xuexiaoadmin', '2014-06-06 17:47:20', '2014-06-06 17:47:28', null, null, '31', null, null, null, null, null, null, null, null, '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '12312');
INSERT INTO `edu_audit` VALUES ('77', '38', '11', 'teacher4', '2014-06-06 00:00:00', null, 'teacher4', 'teacher4', '2014-06-06 18:07:02', '2014-06-06 18:07:02', '2', '3', '1', null, null, null, null, null, null, null, null, '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', null);
INSERT INTO `edu_audit` VALUES ('81', '40', '13', 'xuexiaoadmin', '2014-06-07 10:50:01', '13123', 'shengadmin', 'xuexiaoadmin', '2014-06-07 10:12:13', '2014-06-07 10:50:01', '5', '6', '40', '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '11');
INSERT INTO `edu_audit` VALUES ('82', '40', '11', '刘萍', '2014-06-07 00:00:00', null, 'xuexiaoadmin', 'xuexiaoadmin', '2014-06-07 10:50:34', '2014-06-07 10:50:34', null, null, '32', null, null, null, null, null, null, null, null, '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '123123');
INSERT INTO `edu_audit` VALUES ('83', '18', '11', '省管理员', '2014-06-07 00:00:00', null, 'shengadmin', 'shengadmin', '2014-06-07 14:42:53', '2014-06-07 14:42:53', null, null, '31', null, null, null, null, null, null, null, null, '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '');
INSERT INTO `edu_audit` VALUES ('84', '38', '11', '省管理员', '2014-06-07 00:00:00', null, 'shengadmin', 'shengadmin', '2014-06-07 14:42:53', '2014-06-07 14:42:53', null, null, '33', null, null, null, null, null, null, null, null, '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '');
INSERT INTO `edu_audit` VALUES ('85', '39', '11', '省管理员', '2014-06-07 00:00:00', null, 'shengadmin', 'shengadmin', '2014-06-07 14:42:54', '2014-06-07 14:42:54', null, null, '34', null, null, null, null, null, null, null, null, '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '');
INSERT INTO `edu_audit` VALUES ('86', '36', '11', '省管理员', '2014-06-07 00:00:00', null, 'shengadmin', 'shengadmin', '2014-06-07 14:42:54', '2014-06-07 14:42:54', null, null, '35', null, null, null, null, null, null, null, null, '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '');
INSERT INTO `edu_audit` VALUES ('87', '40', '11', '省管理员', '2014-06-07 00:00:00', null, 'shengadmin', 'shengadmin', '2014-06-07 14:42:54', '2014-06-07 14:42:54', null, null, '32', null, null, null, null, null, null, null, null, '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '');

-- ----------------------------
-- Table structure for `edu_diploma`
-- ----------------------------
DROP TABLE IF EXISTS `edu_diploma`;
CREATE TABLE `edu_diploma` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT '启用1 禁用0',
  `head` text,
  `content` text,
  `foot` text,
  `position_right` int(11) DEFAULT NULL COMMENT '单位 像素',
  `position_top` int(11) DEFAULT NULL COMMENT '单位 像素',
  `position_width` int(11) DEFAULT NULL COMMENT '单位 像素',
  `position_height` int(11) DEFAULT NULL COMMENT '单位 像素',
  `seal` varchar(250) DEFAULT NULL COMMENT '印章',
  `create_by` varchar(50) DEFAULT NULL,
  `update_by` varchar(50) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `project_id` int(11) DEFAULT NULL,
  `signet_id` int(11) DEFAULT NULL COMMENT '电子印章id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of edu_diploma
-- ----------------------------
INSERT INTO `edu_diploma` VALUES ('2', '14年度证书模版', '2014', '1', '<p align=\"center\">\n	<strong><span style=\"font-size:32px;\">14年继教证书</span></strong> \n</p>\n<p align=\"right\">\n	<strong><span style=\"font-size:32px;\"><span style=\"font-size:24px;\">证书编号：{code}</span><br />\n</span></strong>\n</p>', '<p>\n	&nbsp;\n</p>\n<p>\n	&nbsp;\n</p>\n<p align=\"left\">\n	<span style=\"font-size:32px;\"><strong>&nbsp;&nbsp;&nbsp; {name},您已经通过14年的继教考核，学分{score}，学时{period}已达标，成绩是{grade}，故颁发此证书以资奖励。</strong></span> \n</p>', '<p align=\"right\">\n	&nbsp;\n</p>\n<p align=\"right\">\n	&nbsp;\n</p>\n<p align=\"right\">\n	<strong><span style=\"font-size:32px;\">中国教师教育网</span></strong> \n</p>', '800', '550', '100', '100', '0', 'shengadmin', 'shengadmin', '2014-06-07 00:00:00', '2014-06-07 00:00:00', null, '2');
INSERT INTO `edu_diploma` VALUES ('3', '湖南省14年小学骨干老师培训项目证书模版', '2014', '0', '<p align=\"center\">\n	<span style=\"font-size:24px;\"><strong>湖南省14年小学骨干老师培训项目结业证书</strong></span> \n</p>\n<p align=\"right\">\n	<span style=\"font-size:24px;\"><strong>证书编号：{code}<br />\n</strong></span> \n</p>', '<p align=\"left\">\n	<span style=\"font-size:24px;\"></span>&nbsp;\n</p>\n<p align=\"left\">\n	<span style=\"font-size:24px;\"></span>&nbsp;\n</p>\n<p align=\"left\">\n	<span style=\"font-size:24px;\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; {name}，您好，已经通过湖南省14年小学骨干老师培训项目的培训，学分{grade}已经合格，成绩{grade}，颁发此证书予以证明</span> \n</p>', '<p align=\"right\">\n	&nbsp;\n</p>\n<p align=\"right\">\n	&nbsp;\n</p>\n<p align=\"right\">\n	<span style=\"font-size:24px;\"><strong>中国教师教育网</strong></span> \n</p>', '800', '550', '100', '100', '0', 'shengadmin', 'shengadmin', '2014-06-04 00:00:00', '2014-06-04 00:00:00', '4', '2');
INSERT INTO `edu_diploma` VALUES ('4', '小学校长项目模版设置', '2014', '0', '<div align=\"center\">\n	<span style=\"font-size:32px;\">小学校长项目</span> \n</div>', '<div align=\"left\">\n	<p>\n		<br />\n	</p>\n	<p>\n		<br />\n	</p>\n	<p>\n		<span style=\"font-size:32px;\"><strong>已经合格，特发此证书。</strong></span> \n	</p>\n</div>', '<div align=\"right\">\n	<p>\n		<br />\n	</p>\n	<p>\n		<br />\n	</p>\n	<p>\n		<span style=\"font-size:32px;\">中国教师教育网</span> \n	</p>\n</div>', '800', '550', '100', '100', '1', 'hnadmin', 'hnadmin', '2014-05-28 00:00:00', '2014-05-28 00:00:00', '3', '2');
INSERT INTO `edu_diploma` VALUES ('5', '', '2014', '0', '', '', '', null, null, null, null, '0', 'hnadmin', 'hnadmin', '2014-05-28 00:00:00', '2014-05-28 00:00:00', '6', '3');
INSERT INTO `edu_diploma` VALUES ('6', '', '2014', '0', '', '', '', null, null, null, null, '0', 'hnadmin', 'hnadmin', '2014-05-28 00:00:00', '2014-05-28 00:00:00', '1', '3');
INSERT INTO `edu_diploma` VALUES ('7', '2014年湖南省小学校长职务培训项目证书模版', '2014', '0', '<div align=\"center\">\n	<p>\n		<strong><span style=\"font-size:32px;\">2014年湖南省小学校长职务培训项目证书</span></strong>\n	</p>\n	<p align=\"right\">\n		<strong><span style=\"font-size:32px;\">证书编号：{code}<br />\n</span></strong>\n	</p>\n</div>', '<strong><span style=\"font-size:32px;\">&nbsp;&nbsp;&nbsp; {name}老师，您已经通过本项目的考核，已经达到标准，学时{period}；学分{score}；成绩{grade}，故发此证书以资鼓励。</span></strong><br />', '<div align=\"right\">\n	<p>\n		<br />\n	</p>\n	<p>\n		<br />\n	</p>\n	<p>\n		<strong><span style=\"font-size:32px;\">中国教师教育网</span></strong>\n	</p>\n</div>', '800', '550', '100', '100', '1', 'shengadmin', 'shengadmin', '2014-06-04 00:00:00', '2014-06-04 00:00:00', '10', '4');
INSERT INTO `edu_diploma` VALUES ('8', '', '2014', '0', '&nbsp;如: 证书编号：YN0000001要写成证书编号：{code}', '如: XXX同志要写成{name}同志,学时用{period}字符代替，&nbsp; 学分用{score}字符代替， 成绩用{grade}字符代替<br />', '<p>\n	尾巴\n</p>', '1', '2', '3', '4', '0', 'shengadmin', 'shengadmin', '2014-06-07 00:00:00', '2014-06-07 00:00:00', '18', '4');
INSERT INTO `edu_diploma` VALUES ('9', '1213', '2014', '0', '如: 证书编号：YN0000001要写成证书编号：{code}', '如: XXX同志要写成{name}同志<br />\n学时用{period}字符代替，&nbsp; 学分用{score}字符代替， 成绩用{grade}字符代替', '如: XXX同志要写成{name}同志<br />\n学时用{period}字符代替，&nbsp; 学分用{score}字符代替， 成绩用{grade}字符代替', null, null, null, null, '0', 'shengadmin', 'shengadmin', '2014-06-07 00:00:00', '2014-06-07 00:00:00', '13', '4');

-- ----------------------------
-- Table structure for `edu_jobtransfer_history`
-- ----------------------------
DROP TABLE IF EXISTS `edu_jobtransfer_history`;
CREATE TABLE `edu_jobtransfer_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_id` int(11) DEFAULT NULL COMMENT '教师id',
  `past_province_id` int(11) DEFAULT NULL,
  `past_province_name` varchar(100) DEFAULT NULL,
  `past_city_id` int(11) DEFAULT NULL,
  `past_city_name` varchar(100) DEFAULT NULL,
  `past_district_name` varchar(100) DEFAULT NULL,
  `past_district_id` int(11) DEFAULT NULL COMMENT '调动前地区id',
  `past_school_id` int(11) DEFAULT NULL,
  `past_school_name` varchar(100) DEFAULT NULL,
  `new_proivnce_name` varchar(100) DEFAULT NULL,
  `new_province_id` int(11) DEFAULT NULL,
  `new_city_id` int(11) DEFAULT NULL,
  `new_city_name` varchar(100) DEFAULT NULL,
  `new_district_id` int(11) DEFAULT NULL COMMENT '调动后地区id',
  `new_district_name` varchar(100) DEFAULT NULL,
  `new_school_name` varchar(100) DEFAULT NULL,
  `new_school_id` int(11) DEFAULT NULL,
  `create_by` varchar(100) DEFAULT NULL COMMENT '操作人',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `old_version` int(11) DEFAULT NULL COMMENT '调动前版本号',
  `new_version` int(11) DEFAULT NULL COMMENT '新版本号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教师工作调动审核记录表';

-- ----------------------------
-- Records of edu_jobtransfer_history
-- ----------------------------

-- ----------------------------
-- Table structure for `edu_message`
-- ----------------------------
DROP TABLE IF EXISTS `edu_message`;
CREATE TABLE `edu_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` text CHARACTER SET utf8 COMMENT '消息内容',
  `status` int(4) DEFAULT NULL COMMENT '0:无效，1：有效，2：已读，3：未读',
  `create_by` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `update_by` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  `receive_user_id` int(11) DEFAULT NULL COMMENT '消息接受者',
  `send_user_id` int(11) DEFAULT NULL COMMENT '发送人的Id',
  `title` varchar(255) CHARACTER SET utf8 DEFAULT NULL COMMENT '标题',
  `send_time` date DEFAULT NULL COMMENT '消息发送时间',
  `send_user_name` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '消息发送者',
  `receive_user_name` varchar(20) CHARACTER SET utf8 DEFAULT NULL COMMENT '收信人的Name',
  `user_image_url` varchar(50) CHARACTER SET utf8 DEFAULT NULL COMMENT '图片URL',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of edu_message
-- ----------------------------
INSERT INTO `edu_message` VALUES ('1', '年度继教考核未达到要求', '3', 'hnssadmin1', '2014-05-22', null, null, '5', '4', '继教考核提醒', '2014-05-22', 'hnssadmin1', '李明', null);
INSERT INTO `edu_message` VALUES ('2', '年度继教考核未达到要求', '3', 'hnadmin', '2014-05-27', null, null, '26', '2', '继教考核提醒', '2014-05-27', 'hnadmin', 'dean测试', null);
INSERT INTO `edu_message` VALUES ('3', '参与报名的时间快截止了，请积极参与', '2', 'hnssadmin1', '2014-05-29', 'teacher1', '2014-05-29', null, '4', '参与报名的截止时间', '2014-05-29', 'hnssadmin1', 'teacher1', null);
INSERT INTO `edu_message` VALUES ('4', '此消息已经收到。', '3', 'teacher1', '2014-05-29', null, null, null, '5', '关于报名', '2014-05-29', 'teacher1', 'hnssadmin1', null);
INSERT INTO `edu_message` VALUES ('5', '年度继教考核未达到要求', '3', 'shengadmin', '2014-06-04', null, null, '7', '2', '继教考核提醒', '2014-06-04', 'shengadmin', '李长兴', null);
INSERT INTO `edu_message` VALUES ('6', '年度继教考核未达到要求', '3', 'hnssadmin1', '2014-06-05', null, null, '38', '4', '继教考核提醒', '2014-06-05', 'hnssadmin1', '李焕', null);
INSERT INTO `edu_message` VALUES ('7', '年度继教考核未达到要求', '3', 'hnssadmin1', '2014-06-05', null, null, '36', '4', '继教考核提醒', '2014-06-05', 'hnssadmin1', '王鹏', null);
INSERT INTO `edu_message` VALUES ('8', '年度继教考核未达到要求', '3', 'shengadmin', '2014-06-07', null, null, '40', '2', '继教考核提醒', '2014-06-07', 'shengadmin', '邓果', null);
INSERT INTO `edu_message` VALUES ('9', '年度继教考核未达到要求', '3', 'shengadmin', '2014-06-07', null, null, '39', '2', '继教考核提醒', '2014-06-07', 'shengadmin', '柳宁', null);
INSERT INTO `edu_message` VALUES ('10', '年度继教考核未达到要求', '3', 'shengadmin', '2014-06-07', null, null, '40', '2', '继教考核提醒', '2014-06-07', 'shengadmin', '邓果', null);
INSERT INTO `edu_message` VALUES ('11', '年度继教考核未达到要求', '3', 'shengadmin', '2014-06-07', null, null, '40', '2', '继教考核提醒', '2014-06-07', 'shengadmin', '邓果', null);
INSERT INTO `edu_message` VALUES ('12', '年度继教考核未达到要求', '3', 'shengadmin', '2014-06-07', null, null, '39', '2', '继教考核提醒', '2014-06-07', 'shengadmin', '柳宁', null);
INSERT INTO `edu_message` VALUES ('13', '年度继教考核未达到要求', '3', 'shengadmin', '2014-06-07', null, null, '26', '2', '继教考核提醒', '2014-06-07', 'shengadmin', 'dean测试', null);
INSERT INTO `edu_message` VALUES ('14', '年度继教考核未达到要求', '3', 'shengadmin', '2014-06-07', null, null, '40', '2', '继教考核提醒', '2014-06-07', 'shengadmin', '邓果', null);
INSERT INTO `edu_message` VALUES ('15', '年度继教考核未达到要求', '3', 'shengadmin', '2014-06-07', null, null, '40', '2', '继教考核提醒', '2014-06-07', 'shengadmin', '邓果', null);
INSERT INTO `edu_message` VALUES ('16', '年度继教考核未达到要求', '3', 'shengadmin', '2014-06-07', null, null, '39', '2', '继教考核提醒', '2014-06-07', 'shengadmin', '柳宁', null);
INSERT INTO `edu_message` VALUES ('17', '年度继教考核未达到要求', '3', 'shengadmin', '2014-06-07', null, null, '40', '2', '继教考核提醒', '2014-06-07', 'shengadmin', '邓果', null);
INSERT INTO `edu_message` VALUES ('18', '年度继教考核未达到要求', '3', 'shengadmin', '2014-06-07', null, null, '40', '2', '继教考核提醒', '2014-06-07', 'shengadmin', '邓果', null);
INSERT INTO `edu_message` VALUES ('19', '年度继教考核未达到要求', '3', 'shengadmin', '2014-06-07', null, null, '40', '2', '继教考核提醒', '2014-06-07', 'shengadmin', '邓果', null);
INSERT INTO `edu_message` VALUES ('20', '年度继教考核未达到要求', '3', 'shengadmin', '2014-06-07', null, null, '40', '2', '继教考核提醒', '2014-06-07', 'shengadmin', '邓果', null);
INSERT INTO `edu_message` VALUES ('21', '年度继教考核未达到要求', '3', 'shengadmin', '2014-06-07', null, null, '18', '2', '继教考核提醒', '2014-06-07', 'shengadmin', '李明一', null);
INSERT INTO `edu_message` VALUES ('22', '年度继教考核未达到要求', '3', 'shengadmin', '2014-06-07', null, null, '40', '2', '继教考核提醒', '2014-06-07', 'shengadmin', '邓果', null);
INSERT INTO `edu_message` VALUES ('23', '年度继教考核未达到要求', '3', 'shengadmin', '2014-06-07', null, null, '39', '2', '继教考核提醒', '2014-06-07', 'shengadmin', '柳宁', null);
INSERT INTO `edu_message` VALUES ('24', '年度继教考核未达到要求', '3', 'shengadmin', '2014-06-07', null, null, '40', '2', '继教考核提醒', '2014-06-07', 'shengadmin', '邓果', null);
INSERT INTO `edu_message` VALUES ('25', '年度继教考核未达到要求', '3', 'shengadmin', '2014-06-07', null, null, '40', '2', '继教考核提醒', '2014-06-07', 'shengadmin', '邓果', null);
INSERT INTO `edu_message` VALUES ('26', '年度继教考核未达到要求', '3', 'shengadmin', '2014-06-07', null, null, '39', '2', '继教考核提醒', '2014-06-07', 'shengadmin', '柳宁', null);
INSERT INTO `edu_message` VALUES ('27', '年度继教考核未达到要求', '3', 'shengadmin', '2014-06-07', null, null, '35', '2', '继教考核提醒', '2014-06-07', 'shengadmin', '李宁波', null);
INSERT INTO `edu_message` VALUES ('28', '年度继教考核未达到要求', '3', 'shengadmin', '2014-06-07', null, null, '25', '2', '继教考核提醒', '2014-06-07', 'shengadmin', '黄雷磊', null);
INSERT INTO `edu_message` VALUES ('29', '年度继教考核未达到要求', '3', 'shengadmin', '2014-06-07', null, null, '36', '2', '继教考核提醒', '2014-06-07', 'shengadmin', '王鹏', null);

-- ----------------------------
-- Table structure for `edu_model`
-- ----------------------------
DROP TABLE IF EXISTS `edu_model`;
CREATE TABLE `edu_model` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `model_name` varchar(20) DEFAULT NULL COMMENT '继教信息板块名称',
  `model_code` varchar(20) DEFAULT NULL COMMENT '继教信息版块编码',
  `train_type` varchar(20) DEFAULT NULL COMMENT '培训类型',
  `train_hour` varchar(20) DEFAULT NULL COMMENT '学时',
  `train_score` varchar(10) DEFAULT NULL COMMENT '\r\n            学分\r\n            ',
  `start_date` date DEFAULT NULL COMMENT '计划开始日期',
  `end_date` date DEFAULT NULL COMMENT '计划结束日期：',
  `memo` text,
  `create_by` varchar(20) DEFAULT NULL,
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `update_by` varchar(20) DEFAULT NULL,
  `update_date` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `exchange_role` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of edu_model
-- ----------------------------
INSERT INTO `edu_model` VALUES ('1', '湖南省14年继教计划', '67', '1', null, '3', '2014-05-01', '2014-12-24', '', 'hnssadmin1', '2014-06-07 16:11:44', 'hnadmin', '2014-05-28 10:56:22', '111');
INSERT INTO `edu_model` VALUES ('2', '湖南省13年继教信息', '2', '1', null, '3', '2013-05-01', '2013-11-13', '添加13年继教信息', 'hnssadmin1', '2014-05-29 13:33:54', 'hnssadmin1', '2014-05-29 13:33:54', null);

-- ----------------------------
-- Table structure for `edu_organization`
-- ----------------------------
DROP TABLE IF EXISTS `edu_organization`;
CREATE TABLE `edu_organization` (
  `organization_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) DEFAULT NULL,
  `organization_name` varchar(20) DEFAULT NULL COMMENT '机构名称',
  `contacts` varchar(20) DEFAULT NULL COMMENT '机构联系人',
  `contacts_type` varchar(20) DEFAULT NULL COMMENT '机构联系方式\r\n            ',
  `organization_adderss` varchar(100) DEFAULT NULL COMMENT '机构联系地址',
  `organization_province_id` int(5) DEFAULT NULL COMMENT '机构所在省id',
  `organization_province_name` varchar(50) DEFAULT NULL COMMENT '机构所在省name',
  `organization_city_id` int(5) DEFAULT NULL COMMENT '机构所在市id',
  `organization_city_name` varchar(50) DEFAULT NULL COMMENT '机构所在市name',
  `organization_district_id` int(5) DEFAULT NULL COMMENT '机构所在区id',
  `organization_district_name` varchar(50) DEFAULT NULL COMMENT '机构所在区name',
  `memo` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(20) DEFAULT NULL COMMENT '创建人',
  `create_date` date DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(20) DEFAULT NULL COMMENT '更新人',
  `update_date` date DEFAULT NULL COMMENT '更新时间',
  `status` int(2) DEFAULT NULL,
  `type` int(2) DEFAULT NULL COMMENT '区分实施机构和承培机构，1为承培机构，2为实施机构',
  PRIMARY KEY (`organization_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of edu_organization
-- ----------------------------
INSERT INTO `edu_organization` VALUES ('1', null, '湖南承培机构1', '王磊', '18723748933', '北京市海淀区西土城1号', '1', '湖南省', null, null, null, null, '', 'hnadmin', '2014-05-21', null, null, '1', '1');
INSERT INTO `edu_organization` VALUES ('2', null, '湖南实施机构', '张明', '15899231987', '北京市海淀区北土城1号', '1', '湖南省', null, null, null, null, '', 'hnadmin', '2014-05-21', null, null, '0', '2');
INSERT INTO `edu_organization` VALUES ('3', null, '湖南实施机构', '张明', '1589932294', '北京市海淀区北土城45号', '1', '湖南省', null, null, null, null, '', 'hnadmin', '2014-05-21', null, null, '1', '2');
INSERT INTO `edu_organization` VALUES ('4', null, '湖南承培机构2', '李丽', '13516171811', '湖南省长沙市', '1', '湖南省', null, null, null, null, '', 'hnadmin', '2014-05-21', null, null, '1', '1');

-- ----------------------------
-- Table structure for `edu_organization_project`
-- ----------------------------
DROP TABLE IF EXISTS `edu_organization_project`;
CREATE TABLE `edu_organization_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `organization_id` int(11) DEFAULT NULL COMMENT '机构id\r\n            ',
  `project_id` int(11) DEFAULT NULL COMMENT '项目id',
  `training_home_address` varchar(200) DEFAULT NULL COMMENT '培训平台首页地址',
  `training_address` varchar(200) DEFAULT NULL COMMENT '培训平台接口地址',
  `project_status` int(10) DEFAULT NULL COMMENT '项目状态',
  `plan_num` int(10) DEFAULT NULL COMMENT '分配人数',
  `actual_num` int(10) DEFAULT NULL COMMENT '实际参加人数',
  `create_by` varchar(20) DEFAULT NULL COMMENT '创建人',
  `create_date` date DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(20) DEFAULT NULL COMMENT '更新人',
  `update_date` date DEFAULT NULL COMMENT '更新时间',
  `organization_name` varchar(50) DEFAULT NULL,
  `class_subject_id` varchar(50) DEFAULT NULL COMMENT '承接项目培训学科',
  `class_subject_name` varchar(100) DEFAULT NULL,
  `area_code` varchar(100) DEFAULT NULL COMMENT '承接项目地区编码',
  `area_name` varchar(100) DEFAULT NULL COMMENT '承接项目地区名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of edu_organization_project
-- ----------------------------
INSERT INTO `edu_organization_project` VALUES ('1', '1', '2', 'http://www.baidu.com', 'http://www.baidu.com', '40', '50', null, 'hnssadmin1', '2014-05-21', 'hnssadmin1', '2014-05-21', '湖南承培机构1', '1', '小学语文', '2', '长沙市');
INSERT INTO `edu_organization_project` VALUES ('2', '4', '2', 'http://www.baidu.com', 'http://www.baidu.com', '40', '50', null, 'hnssadmin1', '2014-05-21', 'hnssadmin1', '2014-05-21', '湖南承培机构2', '1', '小学语文', '3', '湘潭市');
INSERT INTO `edu_organization_project` VALUES ('3', '1', '3', 'http://www.baidu.com', 'http://www.baidu.com', '40', '100', null, 'hnssadmin1', '2014-05-21', 'hnssadmin1', '2014-05-21', '湖南承培机构1', '1', '小学语文', '1', '湖南省');
INSERT INTO `edu_organization_project` VALUES ('4', '1', '4', 'http://www.baidu.com', 'http://www.baidu.com', '40', '50', null, 'hnssadmin1', '2014-05-21', 'hnssadmin1', '2014-05-21', '湖南承培机构1', '1', '小学语文', '1', '湖南省');
INSERT INTO `edu_organization_project` VALUES ('5', '4', '4', 'http://www.baidu.com', 'http://www.baidu.com', '40', '50', null, 'hnssadmin1', '2014-05-21', 'hnssadmin1', '2014-05-21', '湖南承培机构2', '1', '小学语文', '1', '湖南省');
INSERT INTO `edu_organization_project` VALUES ('6', '1', '5', 'http://www.baidu.com', 'http://www.baidu.com', '40', '100', null, 'hnssadmin1', '2014-05-22', 'hnssadmin1', '2014-05-22', '湖南承培机构1', '1', '小学语文', '1', '湖南省');
INSERT INTO `edu_organization_project` VALUES ('7', '1', '7', 'http://www.baidu.com', 'http://www.baidu.com', '40', '100', null, 'hnssadmin1', '2014-05-23', 'hnssadmin1', '2014-05-23', '湖南承培机构1', '1', '小学语文', '1', '湖南省');
INSERT INTO `edu_organization_project` VALUES ('8', '1', '6', 'http://www.baidu.com', 'http://www.baidu.com', '40', '100', null, 'hnadmin', '2014-05-27', 'hnadmin', '2014-05-27', '湖南承培机构1', '1', '小学语文', '1', '湖南省');
INSERT INTO `edu_organization_project` VALUES ('9', '1', '8', 'http://www.baidu.com', 'http://www.baidu.com', '40', '100', null, 'hnadmin', '2014-05-27', 'hnadmin', '2014-05-27', '湖南承培机构1', '1', '小学语文', '1', '湖南省');
INSERT INTO `edu_organization_project` VALUES ('10', '1', '9', null, null, '30', '50', null, 'hnssadmin1', '2014-05-28', 'hnssadmin1', '2014-05-28', '湖南承培机构1', '8', '小学语文', '2', '长沙市');
INSERT INTO `edu_organization_project` VALUES ('11', '4', '9', null, null, '30', '50', null, 'hnssadmin1', '2014-05-28', 'hnssadmin1', '2014-05-28', '湖南承培机构2', '8', '小学语文', '3', '湘潭市');
INSERT INTO `edu_organization_project` VALUES ('12', '1', '10', 'http://www.baidu.com', 'http://www.baidu.com', '31', '50', null, 'shengadmin', '2014-05-29', 'shengadmin', '2014-05-29', '湖南承培机构1', '8', '小学语文', '3', '湘潭市');
INSERT INTO `edu_organization_project` VALUES ('13', '4', '10', null, null, '30', '50', null, 'shengadmin', '2014-05-29', 'shengadmin', '2014-05-29', '湖南承培机构2', '8', '小学语文', '2', '长沙市');
INSERT INTO `edu_organization_project` VALUES ('14', '1', '11', 'http://www.baidu.com', 'http://www.baidu.com', '40', '100', null, 'shengadmin', '2014-06-04', 'shengadmin', '2014-06-04', '湖南承培机构1', '8', '小学语文', '1', '湖南省');
INSERT INTO `edu_organization_project` VALUES ('15', '1', '13', 'http://www.baidu.com', 'http://www.baidu.com', '40', '50', null, 'shengadmin', '2014-06-04', 'shengadmin', '2014-06-04', '湖南承培机构1', '8', '小学语文', '2', '长沙市');
INSERT INTO `edu_organization_project` VALUES ('16', '4', '13', 'http://www.baidu.com', 'http://www.baidu.com', '40', '50', null, 'shengadmin', '2014-06-04', 'shengadmin', '2014-06-04', '湖南承培机构2', '8', '小学语文', '2', '长沙市');
INSERT INTO `edu_organization_project` VALUES ('17', '1', '14', 'http://www.baidu.com', 'http://www.baidu.com', '40', '100', null, 'shengadmin', '2014-06-04', 'shengadmin', '2014-06-04', '湖南承培机构1', '8', '小学语文', '1', '湖南省');
INSERT INTO `edu_organization_project` VALUES ('18', '1', '15', 'http://www.baidu.com', 'http://www.baidu.com', '40', '50', null, 'shengadmin', '2014-06-04', 'shengadmin', '2014-06-04', '湖南承培机构1', '8', '小学语文', '1', '湖南省');
INSERT INTO `edu_organization_project` VALUES ('19', '4', '15', 'http://www.baidu.com', 'http://www.baidu.com', '40', '50', null, 'shengadmin', '2014-06-04', 'shengadmin', '2014-06-04', '湖南承培机构2', '8', '小学语文', '1', '湖南省');
INSERT INTO `edu_organization_project` VALUES ('20', '1', '16', 'http://www.baidu.com', 'http://www.baidu.com', '40', '50', null, 'shengadmin', '2014-06-04', 'shengadmin', '2014-06-04', '湖南承培机构1', '8', '小学语文', '1', '湖南省');
INSERT INTO `edu_organization_project` VALUES ('21', '4', '16', 'http://www.baidu.com', 'http://www.baidu.com', '40', '50', null, 'shengadmin', '2014-06-04', 'shengadmin', '2014-06-04', '湖南承培机构2', '8', '小学语文', '1', '湖南省');
INSERT INTO `edu_organization_project` VALUES ('22', '1', '17', 'http://www.baidu.com', 'http://www.baidu.com', '40', '100', null, 'shengadmin', '2014-06-05', 'shengadmin', '2014-06-05', '湖南承培机构1', '8', '小学语文', '2', '长沙市');
INSERT INTO `edu_organization_project` VALUES ('23', '1', '18', 'http://www.baidu.com', 'http://www.baidu.com', '40', '100', null, 'hnssadmin1', '2014-06-05', 'hnssadmin1', '2014-06-05', '湖南承培机构1', '8', '小学语文', '1', '湖南省');

-- ----------------------------
-- Table structure for `edu_paper`
-- ----------------------------
DROP TABLE IF EXISTS `edu_paper`;
CREATE TABLE `edu_paper` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_date` date DEFAULT NULL COMMENT '创建日期',
  `start_date` date DEFAULT NULL COMMENT '开始时间',
  `end_date` date DEFAULT NULL COMMENT '结束时间',
  `username` varchar(30) DEFAULT NULL COMMENT '创建用户',
  `attended_num` int(11) DEFAULT '0' COMMENT '参加人数',
  `name` varchar(255) DEFAULT NULL COMMENT '问卷名称',
  `status` int(11) DEFAULT '0' COMMENT '问卷状态0未开启；1开启；2删除;3结束',
  `note` text COMMENT '简介',
  `project_id` int(11) DEFAULT NULL COMMENT '项目id',
  `area_id` int(11) DEFAULT NULL COMMENT '地区id',
  `subject_id` int(11) DEFAULT NULL COMMENT '学科id',
  `isforce` int(11) DEFAULT '1' COMMENT '是否强制执行，0是；1否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of edu_paper
-- ----------------------------
INSERT INTO `edu_paper` VALUES ('1', '2014-05-21', '2014-05-01', '2014-10-15', 'hnssadmin1', '3', '项目调查问卷', '1', '调查该项目的使用情况', '2', '1', '1', '1');
INSERT INTO `edu_paper` VALUES ('2', '2014-05-22', '2014-05-01', '2014-05-23', 'hnadmin', '1', 'sdfsafdda', '3', 'sadfsadf', '3', '1', '1', '1');
INSERT INTO `edu_paper` VALUES ('3', '2014-05-22', '2014-05-01', '2014-11-20', 'hnssadmin1', '2', '调查问卷', '1', '', '4', '1', '1', '1');
INSERT INTO `edu_paper` VALUES ('4', '2014-05-23', '2014-05-01', '2014-11-19', 'hnssadmin1', '2', '调查问卷', '1', '', '7', '1', '1', '1');
INSERT INTO `edu_paper` VALUES ('5', '2014-06-05', '2014-06-02', '2014-11-12', 'shengadmin', '2', '最新问卷', '1', '', '13', '1', '1', '1');
INSERT INTO `edu_paper` VALUES ('6', '2014-06-05', '2014-06-03', '2014-10-15', 'shengadmin', '3', '问卷1', '1', '', '15', '1', '1', '1');
INSERT INTO `edu_paper` VALUES ('7', '2014-06-05', '2014-06-03', '2014-10-06', 'shengadmin', '2', '问卷1', '1', '', '16', '1', '1', '1');

-- ----------------------------
-- Table structure for `edu_project`
-- ----------------------------
DROP TABLE IF EXISTS `edu_project`;
CREATE TABLE `edu_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_no` varchar(20) DEFAULT NULL COMMENT '项目编号',
  `project_name` varchar(50) DEFAULT NULL COMMENT '项目名称',
  `year` int(11) DEFAULT NULL COMMENT '年度',
  `start_date` date DEFAULT NULL COMMENT '开始日期',
  `end_date` date DEFAULT NULL COMMENT '结束日期',
  `project_scope_id` int(11) DEFAULT NULL COMMENT '项目范围',
  `project_scope_name` varchar(20) DEFAULT NULL,
  `project_property_id` int(11) DEFAULT NULL COMMENT '项目性质',
  `project_property_name` varchar(20) DEFAULT NULL,
  `train_scope_id` varchar(100) DEFAULT NULL COMMENT '培训范围',
  `train_scope_name` varchar(100) DEFAULT NULL,
  `train_type_id` int(11) DEFAULT NULL COMMENT '培训类型',
  `train_type_name` varchar(20) DEFAULT NULL,
  `class_period` int(11) DEFAULT NULL COMMENT '学时',
  `class_score` float DEFAULT NULL COMMENT '学分',
  `memo` text,
  `project_attchement` varchar(250) DEFAULT NULL COMMENT '项目附件',
  `sign_up_way` int(11) DEFAULT NULL COMMENT '报名方式',
  `status` int(11) DEFAULT NULL,
  `create_by` varchar(50) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `update_by` varchar(50) DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  `plan_num` int(11) DEFAULT NULL,
  `file_names` varchar(500) DEFAULT NULL,
  `edu_model_type` int(11) DEFAULT NULL,
  `is_score_published` int(11) DEFAULT '0' COMMENT '是否已发布过成绩.默认为0未发布.1.已发布成绩.',
  `view_score_rule` varchar(255) DEFAULT NULL COMMENT '教师查看成绩规则:提交项目总结,完成对承培机构评价,完成项目调查与评估',
  `score_publish_rule` int(11) DEFAULT '0' COMMENT '成线发布规则:0公布分数默认.1按是否合格发布.2按等级公布',
  `score_level_rule` varchar(255) DEFAULT NULL COMMENT '合格成绩分数,取得学时最低分数,成绩等级化分60|60,70,80',
  `has_stop_sign` int(11) DEFAULT NULL,
  `pid` int(2) DEFAULT NULL,
  `cid` int(3) DEFAULT NULL,
  `did` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of edu_project
-- ----------------------------
INSERT INTO `edu_project` VALUES ('1', 'PX001', '添加测试', '2014', '2014-04-27', '2014-06-07', '2', '省级培训项目', '0', '', '3', '湘潭市', '0', '', '10', null, '', null, '2', '0', 'hnadmin', '2014-05-21', 'hnadmin', '2014-05-21', '100', null, '1', '0', null, '0', null, null, '1', '3', null);
INSERT INTO `edu_project` VALUES ('2', '73', '湖南省2014年小学教师培训项目', '2014', '2014-05-01', '2014-12-17', '1', '国培项目', '1', '教师培训', '1', '湖南省', '1', '远程', '20', null, '', null, '3', '60', 'hnssadmin1', '2014-05-21', 'hnssadmin1', '2014-05-21', '100', null, '1', '1', '111', '2', '60', '1', '1', '0', '0');
INSERT INTO `edu_project` VALUES ('3', '1', '湖南省14年小学校长培训项目', '2014', '2014-05-01', '2014-11-19', '1', '国培项目', '2', '校长培训', '1', '湖南省', '1', '远程', '20', null, '', null, '1', '50', 'hnssadmin1', '2014-05-21', 'hnssadmin1', '2014-05-21', '100', null, '1', '1', '000', '1', '0', '1', '1', '0', '0');
INSERT INTO `edu_project` VALUES ('4', '2', '湖南省14年小学骨干老师培训项目', '2014', '2014-05-01', '2014-12-25', '1', '国培项目', '1', '教师培训', '1', '湖南省', '1', '远程', '10', null, '', null, '2', '50', 'hnssadmin1', '2014-05-21', 'hnssadmin1', '2014-05-21', '100', null, '1', '1', '000', '1', '0', null, '1', '0', '0');
INSERT INTO `edu_project` VALUES ('5', '4', '湖南省14年小学教师班主任项目', '2014', '2014-05-01', '2014-11-19', '1', '国培项目', '1', '教师培训', '1', '湖南省', '1', '远程', '10', null, '', null, '2', '40', 'hnssadmin1', '2014-05-22', 'hnssadmin1', '2014-05-22', '100', null, '1', '0', null, '0', null, null, '1', '0', '0');
INSERT INTO `edu_project` VALUES ('6', '5', '湖南14年小学高级教师培训项目', '2014', '2014-05-01', '2014-11-12', '1', '国培项目', '0', '', '1', '湖南省', '1', '远程', '20', null, '', '', '1', '50', 'hnssadmin1', '2014-05-22', 'hnssadmin1', '2014-05-22', '100', '', '1', '1', '000', '2', '60', null, '1', '0', '0');
INSERT INTO `edu_project` VALUES ('7', '6', '湖南省14年小学语文学科培训', '2014', '2014-05-01', '2014-11-12', '1', '国培项目', '1', '教师培训', '1', '湖南省', '1', '远程', '20', null, '', null, '3', '50', 'hnssadmin1', '2014-05-22', 'hnssadmin1', '2014-05-22', '100', null, '1', '1', '111', '2', '60', null, '1', '0', '0');
INSERT INTO `edu_project` VALUES ('8', '7', '湖南省省培项目小学教师项目', '2014', '2014-05-01', '2014-11-20', '1', '国培项目', '1', '教师培训', '1', '湖南省', '1', '远程', '20', null, '项目范围', '7/1401156445329.jpg', '2', '40', 'hnadmin', '2014-05-27', 'hnadmin', '2014-05-27', '100', '中国职业技术教育学会平台banner.jpg', '1', '0', null, '0', null, null, '1', '0', '0');
INSERT INTO `edu_project` VALUES ('9', '10', '2014年小学骨干校长培训项目', '2014', '2014-05-01', '2014-11-28', '1', '国培项目', '1', '教师培训', '1', '湖南省', '1', '远程', '20', null, '', null, '2', '30', 'hnssadmin1', '2014-05-28', 'hnssadmin1', '2014-05-28', '100', null, '1', '0', null, '0', null, null, '1', '0', '0');
INSERT INTO `edu_project` VALUES ('10', '14', '2014年湖南省小学校长职务培训项目', '2014', '2014-05-01', '2014-11-05', '1', '国培项目', '1', '教师培训', '1', '湖南省', '1', '远程', '20', null, '', null, '2', '30', 'shengadmin', '2014-05-29', 'shengadmin', '2014-05-29', '100', null, '1', '0', null, '0', null, null, '1', '0', '0');
INSERT INTO `edu_project` VALUES ('11', '21', '小学教师远程培训14年度', '2014', '2014-06-01', '2014-12-24', '1', '国培项目', '1', '教师培训', '1', '湖南省', '1', '远程', '20', null, '范围', '21/1401865987744.jpg', '2', '40', 'shengadmin', '2014-06-04', 'shengadmin', '2014-06-04', '100', '中国职业技术教育学会平台banner.jpg', '1', '0', null, '0', null, null, '1', '0', '0');
INSERT INTO `edu_project` VALUES ('12', '22', '小学骨干教师项目14年度', '2014', '2014-06-02', '2014-12-23', '1', '国培项目', '1', '教师培训', '1', '湖南省', '1', '远程', '20', null, '', null, '2', '30', 'shengadmin', '2014-06-04', 'shengadmin', '2014-06-04', '0', null, '1', '0', null, '0', null, null, '1', '0', '0');
INSERT INTO `edu_project` VALUES ('13', '23', '小学校长培训项目14年度', '2014', '2014-06-02', '2014-11-20', '1', '国培项目', '1', '教师培训', '1', '湖南省', '1', '远程', '10', null, '', null, '2', '50', 'hnssadmin1', '2014-06-04', 'hnssadmin1', '2014-06-04', '100', null, '1', '1', '111', '3', '60,70,80', null, '1', '0', '0');
INSERT INTO `edu_project` VALUES ('14', '24', '教师小学学段校长培训', '2014', '2014-06-03', '2014-11-20', '1', '国培项目', '1', '教师培训', '1', '湖南省', '1', '远程', '20', null, '', null, '2', '40', 'shengadmin', '2014-06-04', 'shengadmin', '2014-06-04', '100', null, '1', '0', null, '0', null, null, '1', '0', '0');
INSERT INTO `edu_project` VALUES ('15', '19', '教师小学骨干培训', '2014', '2014-06-02', '2014-12-25', '1', '国培项目', '1', '教师培训', '1', '湖南省', '1', '远程', '10', null, '', '', '2', '50', 'shengadmin', '2014-06-04', 'shengadmin', '2014-06-04', '100', '', '1', '1', '000', '2', '60', null, '1', '0', '0');
INSERT INTO `edu_project` VALUES ('16', '25', '教师小学班主任培训', '2014', '2014-06-02', '2014-11-19', '1', '国培项目', '1', '教师培训', '1', '湖南省', '1', '远程', '0', null, '', null, '2', '50', 'shengadmin', '2014-06-04', 'shengadmin', '2014-06-04', '100', null, '1', '1', '111', '1', '60', null, '1', '0', '0');
INSERT INTO `edu_project` VALUES ('17', '27', '湖南长沙小学教师培训项目', '2014', '2014-06-02', '2014-11-12', '1', '国培项目', '1', '教师培训', '2', '长沙市', '1', '远程', '10', null, '新的项目范围测试', '27/1401930715645.docx', '2', '40', 'shengadmin', '2014-06-05', 'shengadmin', '2014-06-05', '100', '下一步工作.docx', '1', '0', null, '0', null, null, '1', '2', '0');
INSERT INTO `edu_project` VALUES ('18', '29', '湖南省14年小学教师远程培训项目', '2014', '2014-06-02', '2014-10-15', '1', '国培项目', '1', '教师培训', '1', '湖南省', '1', '远程', '20', null, '', '', '2', '40', 'hnssadmin1', '2014-06-05', 'hnssadmin1', '2014-06-05', '100', '', '1', '0', null, '0', null, null, '1', '0', '0');

-- ----------------------------
-- Table structure for `edu_project_allocate_by_area`
-- ----------------------------
DROP TABLE IF EXISTS `edu_project_allocate_by_area`;
CREATE TABLE `edu_project_allocate_by_area` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) DEFAULT NULL COMMENT '项目ID',
  `area_id` int(11) DEFAULT NULL COMMENT '地点或者学校ID',
  `status` int(11) DEFAULT NULL COMMENT '状态：0 未上报  1 已上报',
  `allocate_plan_num` int(11) DEFAULT NULL COMMENT '计划上报人数',
  `allocate_fact_num` int(11) DEFAULT NULL COMMENT '实际上报人数',
  `memo` varchar(200) DEFAULT NULL,
  `type` int(11) DEFAULT NULL COMMENT '0:点 1:学校',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of edu_project_allocate_by_area
-- ----------------------------
INSERT INTO `edu_project_allocate_by_area` VALUES ('1', '2', '2', '1', '50', '3', null, '0');
INSERT INTO `edu_project_allocate_by_area` VALUES ('2', '2', '3', '1', '50', null, null, '0');
INSERT INTO `edu_project_allocate_by_area` VALUES ('3', '2', '4', '1', '0', '0', null, '0');
INSERT INTO `edu_project_allocate_by_area` VALUES ('4', '2', '5', '1', '0', '0', null, '0');
INSERT INTO `edu_project_allocate_by_area` VALUES ('5', '2', '6', '1', '0', '0', null, '0');
INSERT INTO `edu_project_allocate_by_area` VALUES ('6', '2', '7', '1', '0', '0', null, '0');
INSERT INTO `edu_project_allocate_by_area` VALUES ('7', '2', '8', '1', '0', '0', null, '0');
INSERT INTO `edu_project_allocate_by_area` VALUES ('8', '2', '9', '1', '0', '0', null, '0');
INSERT INTO `edu_project_allocate_by_area` VALUES ('9', '2', '10', '1', '0', '0', null, '0');
INSERT INTO `edu_project_allocate_by_area` VALUES ('10', '2', '11', '1', '0', '0', null, '0');
INSERT INTO `edu_project_allocate_by_area` VALUES ('11', '2', '1', '1', '100', '3', null, '0');
INSERT INTO `edu_project_allocate_by_area` VALUES ('12', '2', '1', '1', '0', '0', null, '1');
INSERT INTO `edu_project_allocate_by_area` VALUES ('13', '2', '2', '1', '0', '0', null, '1');
INSERT INTO `edu_project_allocate_by_area` VALUES ('14', '2', '3', '1', '0', '0', null, '1');
INSERT INTO `edu_project_allocate_by_area` VALUES ('15', '2', '4', '1', '0', '0', null, '1');
INSERT INTO `edu_project_allocate_by_area` VALUES ('16', '2', '5', '1', '0', '0', null, '1');
INSERT INTO `edu_project_allocate_by_area` VALUES ('17', '2', '6', '1', '0', '0', null, '1');
INSERT INTO `edu_project_allocate_by_area` VALUES ('18', '2', '7', '1', '0', '0', null, '1');
INSERT INTO `edu_project_allocate_by_area` VALUES ('19', '2', '8', '1', '0', '0', null, '1');
INSERT INTO `edu_project_allocate_by_area` VALUES ('20', '7', '2', '1', '50', '2', null, '0');
INSERT INTO `edu_project_allocate_by_area` VALUES ('21', '7', '3', '1', '50', '0', null, '0');

-- ----------------------------
-- Table structure for `edu_project_audit`
-- ----------------------------
DROP TABLE IF EXISTS `edu_project_audit`;
CREATE TABLE `edu_project_audit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `auditor_id` int(11) DEFAULT NULL COMMENT '审核人ID',
  `applicant_id` int(11) DEFAULT NULL COMMENT '上报人ID',
  `auditor_real_name` varchar(20) DEFAULT NULL COMMENT '审核人真实姓名',
  `audit_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '审核日期',
  `audit_status` int(11) DEFAULT NULL COMMENT '审核状态 0 不通过  1 通过',
  `memo` text,
  `project_id` int(11) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of edu_project_audit
-- ----------------------------
INSERT INTO `edu_project_audit` VALUES ('1', '2', '4', '省管理员', '2014-05-21 10:04:59', '1', '', '2', '2014-05-21 10:03:20', '2014-05-21 10:04:59');
INSERT INTO `edu_project_audit` VALUES ('2', '2', '4', '省管理员', '2014-05-21 10:10:30', '1', '', '3', '2014-05-21 10:10:23', '2014-05-21 10:10:30');
INSERT INTO `edu_project_audit` VALUES ('3', '2', '4', '省管理员', '2014-05-21 11:24:40', '1', '', '4', '2014-05-21 11:24:28', '2014-05-21 11:24:40');
INSERT INTO `edu_project_audit` VALUES ('4', '2', '4', '省管理员', '2014-05-22 16:43:20', '1', '', '5', '2014-05-22 16:43:06', '2014-05-22 16:43:20');
INSERT INTO `edu_project_audit` VALUES ('5', '2', '4', '省管理员', '2014-05-22 17:08:52', '1', '', '6', '2014-05-22 17:08:27', '2014-05-22 17:08:52');
INSERT INTO `edu_project_audit` VALUES ('6', '2', '4', '省管理员', '2014-05-22 17:10:23', '1', '', '7', '2014-05-22 17:10:18', '2014-05-22 17:10:23');
INSERT INTO `edu_project_audit` VALUES ('7', '2', '2', '省管理员', '2014-05-27 10:07:36', '1', '', '8', '2014-05-27 10:07:29', '2014-05-27 10:07:36');
INSERT INTO `edu_project_audit` VALUES ('8', '2', '4', '省管理员', '2014-05-28 15:16:41', '1', '', '9', '2014-05-28 15:16:00', '2014-05-28 15:16:41');
INSERT INTO `edu_project_audit` VALUES ('9', '2', '2', '省管理员', '2014-05-29 15:29:49', '1', '', '10', '2014-05-29 15:29:44', '2014-05-29 15:29:49');
INSERT INTO `edu_project_audit` VALUES ('10', '2', '2', '省管理员', '2014-06-04 15:23:29', '1', '', '11', '2014-06-04 15:13:49', '2014-06-04 15:23:29');
INSERT INTO `edu_project_audit` VALUES ('11', '2', '2', '省管理员', '2014-06-04 15:23:26', '1', '', '12', '2014-06-04 15:13:52', '2014-06-04 15:23:26');
INSERT INTO `edu_project_audit` VALUES ('12', '2', '4', '省管理员', '2014-06-04 15:23:23', '1', '', '13', '2014-06-04 15:15:41', '2014-06-04 15:23:23');
INSERT INTO `edu_project_audit` VALUES ('13', '2', '2', '省管理员', '2014-06-04 15:35:18', '1', '', '14', '2014-06-04 15:35:01', '2014-06-04 15:35:18');
INSERT INTO `edu_project_audit` VALUES ('14', '2', '2', '省管理员', '2014-06-04 15:35:14', '1', '', '15', '2014-06-04 15:35:03', '2014-06-04 15:35:14');
INSERT INTO `edu_project_audit` VALUES ('15', '2', '2', '省管理员', '2014-06-04 15:35:11', '1', '', '16', '2014-06-04 15:35:06', '2014-06-04 15:35:11');
INSERT INTO `edu_project_audit` VALUES ('16', '2', '2', '省管理员', '2014-06-05 09:11:30', '0', '', '17', '2014-06-05 09:10:54', '2014-06-05 09:11:30');
INSERT INTO `edu_project_audit` VALUES ('17', '2', '2', '省管理员', '2014-06-05 09:12:35', '1', '', '17', '2014-06-05 09:11:59', '2014-06-05 09:12:35');
INSERT INTO `edu_project_audit` VALUES ('18', '2', '4', '省管理员', '2014-06-05 15:13:15', '1', '', '18', '2014-06-05 15:12:49', '2014-06-05 15:13:15');

-- ----------------------------
-- Table structure for `edu_project_class`
-- ----------------------------
DROP TABLE IF EXISTS `edu_project_class`;
CREATE TABLE `edu_project_class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(50) DEFAULT NULL COMMENT '课程名称',
  `class_type` varchar(20) DEFAULT NULL COMMENT '课程类型',
  `class_type_id` int(11) DEFAULT NULL,
  `class_url` varchar(250) DEFAULT NULL COMMENT '课程地址',
  `memo` text,
  `status` int(11) DEFAULT NULL,
  `create_by` varchar(50) DEFAULT NULL,
  `update_by` varchar(50) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  `class_subject_name` varchar(50) DEFAULT NULL,
  `class_subject_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL COMMENT '创建课程的角色id(管理员, 机构)',
  `user_id` int(11) DEFAULT NULL COMMENT '创建课程的登陆人帐号id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of edu_project_class
-- ----------------------------

-- ----------------------------
-- Table structure for `edu_project_class_category`
-- ----------------------------
DROP TABLE IF EXISTS `edu_project_class_category`;
CREATE TABLE `edu_project_class_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) DEFAULT NULL,
  `class_id` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `create_by` varchar(50) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `update_by` varchar(50) DEFAULT NULL,
  `udate_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of edu_project_class_category
-- ----------------------------

-- ----------------------------
-- Table structure for `edu_project_comment`
-- ----------------------------
DROP TABLE IF EXISTS `edu_project_comment`;
CREATE TABLE `edu_project_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) DEFAULT NULL,
  `project_score` float DEFAULT NULL COMMENT '项目评分',
  `teacher_id` int(11) DEFAULT NULL COMMENT '教师ID',
  `organization_id` int(11) DEFAULT NULL COMMENT '机构ID',
  `status` int(11) DEFAULT NULL COMMENT '审核状态（通过--13，不通过--12，待审核--11）',
  `teacher_score` float DEFAULT NULL COMMENT '老师得分',
  `teacher_train_status_id` int(11) DEFAULT NULL,
  `teacher_train_status_name` varchar(20) DEFAULT NULL COMMENT '老师培训状态（合格，不合格）',
  `create_by` varchar(50) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `update_by` varchar(50) DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  `teacher_score_audit_status_id` int(11) DEFAULT '11' COMMENT '学分审核状态(合格13,不合格12,待审核11)',
  `teacher_score_audit_status_name` varchar(50) DEFAULT '待审核' COMMENT '待审核,合格,不合格',
  `audit_memo` text,
  `teacher_class_score` int(11) DEFAULT '0' COMMENT '教师学分',
  `teacher_class_period` int(11) DEFAULT '0' COMMENT '教师学时',
  `upload_date` varchar(20) DEFAULT NULL COMMENT '上传培训成绩时间',
  `version` int(11) DEFAULT NULL COMMENT '教师报名时的版本号',
  `type` int(11) DEFAULT NULL COMMENT '是否是补报名:0--正常报名，1--补报名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of edu_project_comment
-- ----------------------------
INSERT INTO `edu_project_comment` VALUES ('1', '2', null, '5', '1', '13', '97', '1', '合格', 'laoshi1', '2014-05-21', 'hnssadmin1', '2014-05-21', '11', '待审核', '', null, '20', '2014年05月21日 14点16分', '1', '0');
INSERT INTO `edu_project_comment` VALUES ('2', '2', '5', '6', '1', '13', '45', '0', '不合格', 'laoshi2', '2014-05-21', 'hnssadmin1', '2014-05-21', '11', '待审核', '', null, '0', null, '1', '0');
INSERT INTO `edu_project_comment` VALUES ('3', '2', null, '7', '1', '13', '62', '1', '合格', 'laoshi3', '2014-05-21', 'hnssadmin1', '2014-05-21', '11', '待审核', '', null, '20', null, '1', '0');
INSERT INTO `edu_project_comment` VALUES ('4', '2', null, '10', null, '13', '72', '1', '合格', 'hnssadmin1', '2014-05-21', 'hnssadmin1', '2014-05-21', '11', '待审核', '', null, '20', '2014年05月21日 14点16分', '1', '0');
INSERT INTO `edu_project_comment` VALUES ('5', '3', '1', '5', '1', '13', '90', null, null, 'laoshi1', '2014-05-21', 'jigouadmin1', '2014-06-05', '11', '待审核', '', null, null, '2014年06月05日 10点14分', '1', '0');
INSERT INTO `edu_project_comment` VALUES ('6', '3', '6', '6', '1', '11', '80', null, null, 'hnssadmin1', '2014-05-21', 'jigouadmin1', '2014-06-05', '11', '待审核', null, null, null, '2014年06月05日 10点14分', '1', '0');
INSERT INTO `edu_project_comment` VALUES ('7', '3', '2', '7', '1', '11', null, null, null, 'hnssadmin1', '2014-05-21', 'hnssadmin1', '2014-05-21', '11', '待审核', null, null, null, null, '1', '0');
INSERT INTO `edu_project_comment` VALUES ('8', '4', '1', '7', '1', '13', '95', '1', '合格', 'laoshi3', '2014-05-21', 'hncpadmin1', '2014-05-22', '13', '合格', '', '1', '10', '2014年05月21日 15点46分', '1', '0');
INSERT INTO `edu_project_comment` VALUES ('9', '4', '3', '5', '1', '11', null, null, null, 'laoshi1', '2014-05-21', 'laoshi1', '2014-05-21', '11', '待审核', null, null, null, null, '1', '1');
INSERT INTO `edu_project_comment` VALUES ('10', '7', '4', '5', '1', '13', '89', '1', '合格', 'hnadmin', '2014-05-22', 'hnssadmin1', '2014-05-23', '13', '合格', '', '2', '20', '2014年05月23日 09点33分', '1', '0');
INSERT INTO `edu_project_comment` VALUES ('11', '7', '1', '7', '1', '13', '67', '1', '合格', 'hnadmin', '2014-05-22', 'hnadmin', '2014-05-23', '13', '合格', '', '2', '20', null, '1', '0');
INSERT INTO `edu_project_comment` VALUES ('12', '5', null, '18', null, '13', null, null, null, 'laoshi21', '2014-05-27', 'hnadmin', '2014-05-27', '11', '待审核', '', null, null, null, '6', '1');
INSERT INTO `edu_project_comment` VALUES ('13', '6', '2', '18', null, '11', '89', '1', '合格', 'laoshi21', '2014-05-27', 'hnadmin', '2014-05-28', '11', '待审核', '', null, '20', null, '6', '0');
INSERT INTO `edu_project_comment` VALUES ('14', '6', null, '20', null, '13', '67', '1', '合格', 'laoshi23', '2014-05-27', 'hnadmin', '2014-05-28', '11', '待审核', '', null, '20', null, '1', '1');
INSERT INTO `edu_project_comment` VALUES ('15', '8', null, '18', null, '13', null, null, null, 'laoshi21', '2014-05-27', 'hnadmin', '2014-05-27', '11', '待审核', '', null, null, null, '6', '1');
INSERT INTO `edu_project_comment` VALUES ('16', '8', null, '5', null, '13', null, null, null, 'laoshi1', '2014-05-27', 'shengadmin', '2014-06-04', '11', '待审核', '', null, null, null, '1', '1');
INSERT INTO `edu_project_comment` VALUES ('17', '9', null, '18', null, '13', null, null, null, 'laoshi21', '2014-05-28', 'hnssadmin1', '2014-05-28', '11', '待审核', '', '0', '0', null, '9', '0');
INSERT INTO `edu_project_comment` VALUES ('18', '9', null, '38', '1', '13', null, null, null, 'teacher4', '2014-06-05', 'shengadmin', '2014-06-04', '11', '待审核', '', '0', '0', null, '2', '0');
INSERT INTO `edu_project_comment` VALUES ('19', '8', null, '38', null, '13', null, null, null, 'teacher4', '2014-06-04', 'shengadmin', '2014-06-04', '11', '待审核', '', '0', '0', null, '2', '1');
INSERT INTO `edu_project_comment` VALUES ('20', '5', null, '38', null, '13', null, null, null, 'teacher4', '2014-06-04', 'shengadmin', '2014-06-04', '11', '待审核', '', '0', '0', null, '2', '1');
INSERT INTO `edu_project_comment` VALUES ('21', '10', null, '38', null, '13', null, null, null, 'teacher4', '2014-06-04', 'shengadmin', '2014-06-04', '11', '待审核', '', '0', '0', null, '2', '0');
INSERT INTO `edu_project_comment` VALUES ('22', '16', '4', '38', '1', '13', '89', '1', '合格', 'teacher4', '2014-06-05', 'shengadmin', '2014-06-05', '11', '待审核', '', '0', '0', '2014年06月05日 09点27分', '2', '1');
INSERT INTO `edu_project_comment` VALUES ('23', '15', '3', '38', '1', '13', '89', '1', '合格', 'teacher4', '2014-06-04', 'shengadmin', '2014-06-05', '13', '合格', '', '1', '10', '2014年06月05日 09点27分', '2', '1');
INSERT INTO `edu_project_comment` VALUES ('24', '11', null, '38', '1', '13', null, null, null, 'teacher4', '2014-06-04', 'shengadmin', '2014-06-04', '11', '待审核', '', '0', '0', null, '2', '1');
INSERT INTO `edu_project_comment` VALUES ('25', '13', '2', '38', '1', '13', '89', '1', '优秀', 'teacher4', '2014-06-05', 'shengadmin', '2014-06-05', '13', '合格', '', '1', '10', '2014年06月05日 09点51分', '2', '1');
INSERT INTO `edu_project_comment` VALUES ('26', '14', null, '38', '1', '13', null, null, null, 'teacher4', '2014-06-04', 'shengadmin', '2014-06-04', '11', '待审核', '', '0', '0', null, '2', '1');
INSERT INTO `edu_project_comment` VALUES ('27', '15', '4', '39', '1', '13', '75', '1', '合格', 'teacher5', '2014-06-05', 'shengadmin', '2014-06-05', '11', '待审核', '', '0', '10', '2014年06月05日 09点27分', '1', '1');
INSERT INTO `edu_project_comment` VALUES ('28', '11', null, '39', '1', '13', null, null, null, 'teacher5', '2014-06-05', 'shengadmin', '2014-06-05', '11', '待审核', '', '0', '0', null, '1', '1');
INSERT INTO `edu_project_comment` VALUES ('29', '16', '1', '39', '1', '13', '50', '0', '不合格', 'teacher5', '2014-06-05', 'shengadmin', '2014-06-05', '11', '待审核', '', '0', '0', '2014年06月05日 09点27分', '1', '1');
INSERT INTO `edu_project_comment` VALUES ('30', '14', null, '39', '1', '13', null, null, null, 'teacher5', '2014-06-05', 'shengadmin', '2014-06-05', '11', '待审核', '', '0', '0', null, '1', '1');
INSERT INTO `edu_project_comment` VALUES ('31', '13', '5', '39', '1', '13', '70', '1', '良好', 'teacher5', '2014-06-05', 'shengadmin', '2014-06-05', '11', '待审核', '', '0', '10', '2014年06月05日 09点51分', '1', '1');
INSERT INTO `edu_project_comment` VALUES ('32', '17', null, '38', '1', '13', '89', null, null, 'teacher4', '2014-06-05', 'shengadmin', '2014-06-05', '11', '待审核', '', '0', '0', '2014年06月05日 09点39分', '2', '1');
INSERT INTO `edu_project_comment` VALUES ('33', '17', null, '39', '1', '13', '70', null, null, 'teacher5', '2014-06-05', 'shengadmin', '2014-06-05', '11', '待审核', '', '0', '0', '2014年06月05日 09点39分', '1', '1');
INSERT INTO `edu_project_comment` VALUES ('34', '12', null, '39', null, '13', null, null, null, 'teacher5', '2014-06-05', 'shengadmin', '2014-06-05', '11', '待审核', '', '0', '0', null, '1', '0');
INSERT INTO `edu_project_comment` VALUES ('35', '17', null, '5', null, '13', '78', null, null, 'teacher1', '2014-06-05', 'shengadmin', '2014-06-05', '11', '待审核', '', '0', '0', '2014年06月05日 09点39分', '1', '1');
INSERT INTO `edu_project_comment` VALUES ('36', '17', null, '35', '1', '13', '79', null, null, 'teacher2', '2014-06-05', 'shengadmin', '2014-06-05', '11', '待审核', '', '0', '0', '2014年06月05日 09点39分', '1', '1');
INSERT INTO `edu_project_comment` VALUES ('37', '17', null, '21', null, '13', '56', null, null, 'laoshi24', '2014-06-05', 'shengadmin', '2014-06-05', '11', '待审核', '', '0', '0', '2014年06月05日 09点39分', '1', '1');
INSERT INTO `edu_project_comment` VALUES ('38', '13', null, '35', '1', '13', '59', '0', '不合格', 'teacher2', '2014-06-05', 'shengadmin', '2014-06-05', '11', '待审核', '', '0', '10', '2014年06月05日 09点47分', '1', '1');
INSERT INTO `edu_project_comment` VALUES ('39', '13', null, '5', null, '13', '78', '1', '良好', 'teacher1', '2014-06-05', 'shengadmin', '2014-06-05', '11', '待审核', '', '0', '10', '2014年06月05日 09点47分', '2', '1');
INSERT INTO `edu_project_comment` VALUES ('40', '13', '3', '18', '4', '13', '80', '1', '优秀', 'laoshi21', '2014-06-05', 'shengadmin', '2014-06-05', '11', '待审核', '', '0', '10', '2014年06月05日 09点47分', '10', '1');
INSERT INTO `edu_project_comment` VALUES ('41', '17', null, '18', '1', '13', null, null, null, 'laoshi21', '2014-06-05', 'shengadmin', '2014-06-05', '11', '待审核', '', '0', '0', null, '10', '1');
INSERT INTO `edu_project_comment` VALUES ('42', '18', null, '38', '1', '13', null, null, null, 'teacher4', '2014-06-05', 'hnssadmin1', '2014-06-05', '11', '待审核', '', '0', '0', null, '2', '1');

-- ----------------------------
-- Table structure for `edu_project_count`
-- ----------------------------
DROP TABLE IF EXISTS `edu_project_count`;
CREATE TABLE `edu_project_count` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) DEFAULT '0' COMMENT '项目ID',
  `plan_num` int(11) DEFAULT NULL COMMENT '计划培训数目',
  `actual_num` int(11) DEFAULT NULL COMMENT '实际培训数目',
  `pass_rate` float DEFAULT NULL COMMENT '通过率',
  `study_rate` float DEFAULT NULL COMMENT '学习率',
  `create_by` varchar(50) DEFAULT NULL,
  `update_by` varchar(50) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of edu_project_count
-- ----------------------------

-- ----------------------------
-- Table structure for `edu_project_notrain`
-- ----------------------------
DROP TABLE IF EXISTS `edu_project_notrain`;
CREATE TABLE `edu_project_notrain` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) NOT NULL COMMENT '项目编码',
  `name` varchar(100) NOT NULL COMMENT '项目名称',
  `type_id` int(11) NOT NULL COMMENT '项目类型id:校本培训项目;非培训类项目',
  `type_name` varchar(50) NOT NULL COMMENT '项目类型名称:校本培训项目;非培训类项目',
  `model_id` int(11) NOT NULL COMMENT '继教板块id',
  `model_name` varchar(100) NOT NULL COMMENT '继教板块名称',
  `year` varchar(4) DEFAULT NULL COMMENT '项目年度',
  `credit` int(11) DEFAULT '0' COMMENT '学分',
  `scope_id` int(11) DEFAULT NULL COMMENT '项目范围id',
  `scope_name` varchar(50) DEFAULT NULL COMMENT '项目范围名称',
  `organizer` varchar(100) DEFAULT NULL COMMENT '组织单位',
  `begin_date` date DEFAULT NULL COMMENT '开始时间',
  `end_date` date DEFAULT NULL COMMENT '结束时间',
  `property_id` int(11) DEFAULT NULL COMMENT '项目性质',
  `property_name` varchar(50) DEFAULT NULL COMMENT '项目性质名称',
  `train_type_id` int(11) DEFAULT NULL COMMENT '培训类型',
  `train_type_name` varchar(50) DEFAULT NULL COMMENT '培训类型名称',
  `description` varchar(50) DEFAULT NULL COMMENT '备注',
  `create_date` datetime DEFAULT NULL,
  `create_by` varchar(100) DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_by` varchar(100) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  `did` int(11) DEFAULT NULL,
  `sid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of edu_project_notrain
-- ----------------------------
INSERT INTO `edu_project_notrain` VALUES ('1', '1', '湖南省14年非培训类项目', '2', '非培训类项目', '1', '湖南省14年继教计划', '2014', '2', '2', '长沙市', '教师网', '2014-05-01', '2014-11-19', '0', '0', '0', '0', '', null, null, null, null, '1', '2', null, null);
INSERT INTO `edu_project_notrain` VALUES ('3', '2', '湖南省14年校本培训项目', '1', '校本培训项目', '1', '湖南省14年继教计划', '2014', '1', '2', '天心区小学', '教师网', '2014-05-01', '2014-11-19', '1', '教师培训', '1', '远程', '', null, null, null, null, '1', '2', '4', '2');
INSERT INTO `edu_project_notrain` VALUES ('4', '8', '湖南省非培训类项目小学教师类', '2', '非培训类项目', '1', '湖南省14年继教计划', '2014', '3', '1', '湖南省', '教师网', '2014-05-01', '2014-12-26', '0', '0', '0', '0', '', null, null, null, null, '1', null, null, null);
INSERT INTO `edu_project_notrain` VALUES ('5', '9', '湖南省项目', '2', '非培训类项目', '1', '湖南省14年继教计划', '2014', '2', '1', '湖南省', '教师网', '2014-05-01', '2014-12-18', '0', '0', '0', '0', '', null, null, null, null, '1', null, null, null);
INSERT INTO `edu_project_notrain` VALUES ('6', '10', '湖南校本培训类项目', '1', '校本培训项目', '1', '湖南省14年继教计划', '2014', '2', '2', '天心区小学', '教师网', '2014-05-01', '2014-12-24', '1', '教师培训', '1', '远程', '', null, null, null, null, '1', '2', '4', '2');
INSERT INTO `edu_project_notrain` VALUES ('7', '28', '湖南省非培训类小学教师项目', '2', '非培训类项目', '1', '湖南省14年继教计划', '2014', '2', null, '', '湖南省', '2014-06-02', '2014-11-19', '0', '0', '0', '0', '', null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `edu_project_notrain_comment`
-- ----------------------------
DROP TABLE IF EXISTS `edu_project_notrain_comment`;
CREATE TABLE `edu_project_notrain_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL COMMENT '教师ID',
  `teacher_score` float DEFAULT NULL COMMENT '老师得分,即学分登记的分数',
  `audit_score` float DEFAULT '0' COMMENT '审核后学分',
  `audit_status` int(11) DEFAULT '11' COMMENT '审核状态（通过--13，不通过--12，待审核--11）',
  `audit_status_name` varchar(20) DEFAULT NULL COMMENT '审核结果（合格，不合格）',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人(学分登记人)',
  `create_date` date DEFAULT NULL COMMENT '创建(学分登记)日期',
  `update_by` varchar(50) DEFAULT NULL COMMENT '更新人(学分审核人)',
  `update_date` date DEFAULT NULL COMMENT '更新(学分审核)时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of edu_project_notrain_comment
-- ----------------------------
INSERT INTO `edu_project_notrain_comment` VALUES ('1', '1', '5', '2', '2', '13', '合格', null, null, null, null);
INSERT INTO `edu_project_notrain_comment` VALUES ('2', '1', '6', '1', '1', '13', '合格', null, null, null, null);
INSERT INTO `edu_project_notrain_comment` VALUES ('3', '1', '7', '0', '0', '13', '合格', null, null, null, null);
INSERT INTO `edu_project_notrain_comment` VALUES ('4', '1', '8', '1', '1', '13', '合格', null, null, null, null);
INSERT INTO `edu_project_notrain_comment` VALUES ('5', '1', '13', '1', '1', '13', '合格', null, null, null, null);
INSERT INTO `edu_project_notrain_comment` VALUES ('6', '3', '6', '1', '1', '13', '不合格', null, null, null, null);
INSERT INTO `edu_project_notrain_comment` VALUES ('7', '4', '5', '2', '2', '13', '合格', null, null, null, null);
INSERT INTO `edu_project_notrain_comment` VALUES ('19', '6', '6', '2', '3', '13', '合格', null, null, null, null);
INSERT INTO `edu_project_notrain_comment` VALUES ('20', null, null, null, '0', '11', null, null, null, null, null);
INSERT INTO `edu_project_notrain_comment` VALUES ('21', null, null, null, '0', '11', null, null, null, null, null);
INSERT INTO `edu_project_notrain_comment` VALUES ('22', '5', '5', '2', '2', '13', '合格', null, null, null, null);
INSERT INTO `edu_project_notrain_comment` VALUES ('23', '6', '13', '2', '2', '13', '合格', null, null, null, null);
INSERT INTO `edu_project_notrain_comment` VALUES ('24', '5', '6', '1', '2', '13', '合格', null, null, null, null);
INSERT INTO `edu_project_notrain_comment` VALUES ('25', '5', '7', '3', '2', '13', '合格', null, null, null, null);
INSERT INTO `edu_project_notrain_comment` VALUES ('26', '6', '19', '3', '2', '13', '合格', null, null, null, null);
INSERT INTO `edu_project_notrain_comment` VALUES ('27', '5', '9', '2', '2', '13', '合格', null, null, null, null);
INSERT INTO `edu_project_notrain_comment` VALUES ('28', '5', '8', '2', '0', '11', null, null, null, null, null);
INSERT INTO `edu_project_notrain_comment` VALUES ('29', '3', '13', '2', '0', '11', null, null, null, null, null);
INSERT INTO `edu_project_notrain_comment` VALUES ('30', '4', '21', '3', '3', '13', '合格', null, null, null, null);
INSERT INTO `edu_project_notrain_comment` VALUES ('31', '4', '38', '3', '3', '13', '合格', null, null, null, null);
INSERT INTO `edu_project_notrain_comment` VALUES ('32', '4', '26', '1', '0', '11', null, null, null, null, null);

-- ----------------------------
-- Table structure for `edu_project_summary`
-- ----------------------------
DROP TABLE IF EXISTS `edu_project_summary`;
CREATE TABLE `edu_project_summary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL COMMENT '总结角色类型（0：实施机构，1：教师，2：承培机构,3:总结报告，4:省管理员）',
  `title` varchar(50) DEFAULT NULL COMMENT '总结标题',
  `content` text COMMENT '总结内容',
  `attchement_title` varchar(200) DEFAULT NULL COMMENT '附件标题',
  `attchement_url` varchar(255) DEFAULT NULL COMMENT '附件url',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '提交时间',
  `create_by` int(11) DEFAULT NULL COMMENT '提交人ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of edu_project_summary
-- ----------------------------
INSERT INTO `edu_project_summary` VALUES ('1', '2', '2', '承培机构管理员的培训总结', '此次培训进行的非常顺利，总结起来还不错，上传一下培训中的点点滴滴的记录。', '1400658661071.jpg', 'uploadFile/summary/', '2014-05-21 15:51:01', '3');
INSERT INTO `edu_project_summary` VALUES ('2', '2', '1', '本项目的培训总结', '经过这么长时间的培训，总体水平得到了很大的提升，以后会多参加相关的培训。', '1400662452995.jpg', 'uploadFile/summary/', '2014-05-21 16:54:12', '5');
INSERT INTO `edu_project_summary` VALUES ('3', '2', '1', '我的总结', '总体感觉进度还可以，比较满意', null, null, '2014-05-21 17:00:06', '6');
INSERT INTO `edu_project_summary` VALUES ('4', '2', '4', '', '', null, null, '2014-05-22 09:26:11', '4');
INSERT INTO `edu_project_summary` VALUES ('5', '3', '4', '项目总结报告', '本项目按照计划如期进行，进行过程比较顺利，师生反映都比较良好，实现预期的目标。12', '1400809113923.jpg', 'uploadFile/summary/', '2014-05-23 10:56:03', '4');
INSERT INTO `edu_project_summary` VALUES ('6', '3', '1', '老师端培训总结', '我对此项目的培训感觉受益匪浅，以后还会继续参加此类培训', '1400814244449.jpg', 'uploadFile/summary/', '2014-05-23 11:04:04', '5');
INSERT INTO `edu_project_summary` VALUES ('7', '4', '0', '实施机构对小学校长项目的总结', '总起来说，这次培训还是比较顺利的完成了。', '1400814807012.jpg', 'uploadFile/summary/', '2014-06-05 11:09:29', '4');
INSERT INTO `edu_project_summary` VALUES ('8', '4', '1', '李明的培训总结', '我对本次项目感到非常的满意，学到了许多的知识。', null, null, '2014-05-23 11:14:34', '5');
INSERT INTO `edu_project_summary` VALUES ('9', '16', '1', '柳宁对教师小学骨干项目的总结', '感觉学习很充实。怎么会显示其他人的总结，纳闷', '1401936486521.jpg', 'uploadFile/summary/', '2014-06-05 10:51:22', '39');
INSERT INTO `edu_project_summary` VALUES ('10', '13', '1', '柳宁对小学校长项目的总结', '时间过的很快，培训都结束了，学到很多有用的知识，感觉很好', null, null, '2014-06-05 15:22:14', '38');

-- ----------------------------
-- Table structure for `edu_project_train_target`
-- ----------------------------
DROP TABLE IF EXISTS `edu_project_train_target`;
CREATE TABLE `edu_project_train_target` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) DEFAULT NULL COMMENT '项目id',
  `grade_id` int(11) DEFAULT NULL COMMENT '年级',
  `grade_name` varchar(20) DEFAULT NULL,
  `sex` char(2) DEFAULT NULL COMMENT '性别',
  `education_background_id` int(11) DEFAULT NULL COMMENT '学历',
  `education_background_name` varchar(50) DEFAULT NULL,
  `position_id` int(11) DEFAULT NULL COMMENT '职务',
  `position_name` varchar(50) DEFAULT NULL,
  `professional_title_id` int(11) DEFAULT NULL COMMENT '职称',
  `professional_title_name` varchar(50) DEFAULT NULL,
  `is_class_charger` char(2) DEFAULT NULL COMMENT '是否是班主任',
  `subject_id` varchar(50) DEFAULT NULL COMMENT '学科',
  `subject_name` varchar(50) DEFAULT NULL,
  `stduty_section_id` varchar(50) DEFAULT NULL COMMENT '学段',
  `stduty_section` varchar(20) DEFAULT NULL,
  `is_free` char(2) DEFAULT NULL COMMENT '是否收费',
  `must_audit` char(2) DEFAULT NULL COMMENT '是否审核',
  `charging_standard` varchar(50) DEFAULT NULL COMMENT '收费标准',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of edu_project_train_target
-- ----------------------------
INSERT INTO `edu_project_train_target` VALUES ('1', '1', null, null, null, '0', '', '0', '', '0', '', null, '6', '初中数学', '', '', '0', null, '0');
INSERT INTO `edu_project_train_target` VALUES ('2', '2', null, null, null, '0', '', '0', '', '0', '', null, '1', '小学语文', '', '', '0', null, '0');
INSERT INTO `edu_project_train_target` VALUES ('3', '3', null, null, null, '0', '', '0', '', '0', '', null, '1', '小学语文', '', '', '0', null, '0');
INSERT INTO `edu_project_train_target` VALUES ('4', '4', null, null, null, '0', '', '0', '', '0', '', null, '1', '小学语文', '', '', '0', null, '0');
INSERT INTO `edu_project_train_target` VALUES ('5', '5', null, null, null, '0', '', '0', '', '0', '', null, '1', '小学语文', '', '', '0', null, '0');
INSERT INTO `edu_project_train_target` VALUES ('6', '6', null, '', null, '0', '', '0', '', '0', '', null, '1', '小学语文', '', '', '0', null, '0');
INSERT INTO `edu_project_train_target` VALUES ('7', '7', null, null, null, '0', '', '0', '', '0', '', null, '1', '小学语文', '', '', '0', null, '0');
INSERT INTO `edu_project_train_target` VALUES ('8', '8', null, null, null, '0', '', '0', '', '0', '', null, '1', '小学语文', '', '', '0', null, '0');
INSERT INTO `edu_project_train_target` VALUES ('9', '9', null, null, null, '0', '', '0', '', '0', '', null, '8', '小学语文', '', '', '0', null, '0');
INSERT INTO `edu_project_train_target` VALUES ('10', '10', null, null, null, '3', '本科', '0', '', '3', '中级职称', null, '8', '小学语文', '', '', '0', null, '0');
INSERT INTO `edu_project_train_target` VALUES ('11', '11', null, null, null, '0', '', '0', '', '0', '', null, '8', '小学语文', '', '', '0', null, '0');
INSERT INTO `edu_project_train_target` VALUES ('12', '12', null, null, null, '0', '', '0', '', '0', '', null, '8', '小学语文', '', '', '0', null, '0');
INSERT INTO `edu_project_train_target` VALUES ('13', '13', null, null, null, '0', '', '0', '', '0', '', null, '8', '小学语文', '', '', '0', null, '0');
INSERT INTO `edu_project_train_target` VALUES ('14', '14', null, null, null, '0', '', '0', '', '0', '', null, '8', '小学语文', '', '', '0', null, '0');
INSERT INTO `edu_project_train_target` VALUES ('15', '15', null, '', null, '0', '', '0', '', '0', '', null, '8', '小学语文', '', '', '0', null, '0');
INSERT INTO `edu_project_train_target` VALUES ('16', '16', null, null, null, '0', '', '0', '', '0', '', null, '8', '小学语文', '', '', '0', null, '0');
INSERT INTO `edu_project_train_target` VALUES ('17', '17', null, '', null, '0', '', '0', '', '0', '', '-1', '8', '小学语文', '', '', '0', null, '0');
INSERT INTO `edu_project_train_target` VALUES ('18', '18', null, '', null, '0', '', '0', '', '0', '', null, '8', '小学语文', '', '', '0', null, '0');

-- ----------------------------
-- Table structure for `edu_question`
-- ----------------------------
DROP TABLE IF EXISTS `edu_question`;
CREATE TABLE `edu_question` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_date` date DEFAULT NULL COMMENT '创建日期',
  `username` varchar(30) DEFAULT NULL COMMENT '创建者',
  `question_type` int(11) DEFAULT NULL COMMENT '问题类型 单选2,多选3，填空0,问答1',
  `rank` int(11) DEFAULT NULL COMMENT '顺序',
  `title` varchar(2000) DEFAULT NULL COMMENT '题干',
  `paper_id` int(11) DEFAULT NULL COMMENT '问卷id',
  `required_answer` varchar(50) DEFAULT NULL COMMENT '是否必填',
  `show_style` int(11) DEFAULT NULL COMMENT '每行选项数',
  `sta` varchar(255) DEFAULT '0' COMMENT '试题状态：0正常；1删除;',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of edu_question
-- ----------------------------
INSERT INTO `edu_question` VALUES ('1', '2014-05-21', 'hnssadmin1', '2', '1', '您对本次培训还满意吗', '1', 'Y', '2', '1');
INSERT INTO `edu_question` VALUES ('2', '2014-05-21', 'hnssadmin1', '3', '1', '您通过本次培训学到了什么', '1', 'Y', '2', '0');
INSERT INTO `edu_question` VALUES ('3', '2014-05-21', 'hnssadmin1', '1', '1', '您对这类培训的建议', '1', 'Y', '2', '0');
INSERT INTO `edu_question` VALUES ('4', '2014-05-21', 'hnssadmin1', '2', '1', '您对本次培训满意吗', '1', 'Y', '2', '0');
INSERT INTO `edu_question` VALUES ('5', '2014-05-22', 'hnadmin', '2', '1', '题干题干题干题干题干', '2', 'Y', '2', '0');
INSERT INTO `edu_question` VALUES ('6', '2014-05-22', 'hnssadmin1', '2', '1', '您对本次培训满意吗', '3', 'Y', '2', '0');
INSERT INTO `edu_question` VALUES ('7', '2014-05-22', 'hnssadmin1', '3', '1', '您从本次培训中学到了什么', '3', 'Y', '2', '0');
INSERT INTO `edu_question` VALUES ('8', '2014-05-22', 'hnssadmin1', '1', '1', '您对这类培训的建议', '3', 'Y', '2', '0');
INSERT INTO `edu_question` VALUES ('9', '2014-05-22', 'hnssadmin1', '0', '1', '参加该培训需要付出_与_', '3', 'Y', '2', '0');
INSERT INTO `edu_question` VALUES ('10', '2014-05-23', 'hnssadmin1', '2', '1', '您对本次培训满意吗？', '4', 'Y', '2', '0');
INSERT INTO `edu_question` VALUES ('11', '2014-05-23', 'hnssadmin1', '3', '1', '本次培训给你带来了什么', '4', 'Y', '2', '0');
INSERT INTO `edu_question` VALUES ('12', '2014-05-23', 'hnssadmin1', '1', '1', '怎么做好自己的学习与工作的平横工作', '4', 'Y', '2', '0');
INSERT INTO `edu_question` VALUES ('13', '2014-06-05', 'shengadmin', '2', '1', '你对本次培训满意吗', '5', 'Y', '2', '0');
INSERT INTO `edu_question` VALUES ('14', '2014-06-05', 'shengadmin', '3', '1', '如下哪个你觉得最重要，非必填', '5', 'N', '2', '0');
INSERT INTO `edu_question` VALUES ('15', '2014-06-05', 'shengadmin', '1', '1', '你觉得这次培训带给你什么', '5', 'Y', '2', '0');
INSERT INTO `edu_question` VALUES ('16', '2014-06-05', 'shengadmin', '2', '1', '你对本次培训满意吗', '6', 'Y', '2', '0');
INSERT INTO `edu_question` VALUES ('17', '2014-06-05', 'shengadmin', '3', '1', '如下哪个是必要的', '7', 'Y', '2', '0');

-- ----------------------------
-- Table structure for `edu_question_options`
-- ----------------------------
DROP TABLE IF EXISTS `edu_question_options`;
CREATE TABLE `edu_question_options` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_date` date DEFAULT NULL COMMENT '创建日期',
  `username` varchar(30) DEFAULT NULL COMMENT '创建者',
  `content` varchar(255) DEFAULT NULL COMMENT '选项内容',
  `rank` int(11) DEFAULT NULL COMMENT '顺序',
  `question_id` int(11) DEFAULT NULL COMMENT '问题id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of edu_question_options
-- ----------------------------
INSERT INTO `edu_question_options` VALUES ('1', '2014-05-21', 'hnssadmin1', '满意', '1', '1');
INSERT INTO `edu_question_options` VALUES ('2', '2014-05-21', 'hnssadmin1', '不满意', '1', '1');
INSERT INTO `edu_question_options` VALUES ('3', '2014-05-21', 'hnssadmin1', '知识', '1', '2');
INSERT INTO `edu_question_options` VALUES ('4', '2014-05-21', 'hnssadmin1', '能力', '1', '2');
INSERT INTO `edu_question_options` VALUES ('5', '2014-05-21', 'hnssadmin1', '人际关系', '1', '2');
INSERT INTO `edu_question_options` VALUES ('6', '2014-05-21', 'hnssadmin1', '教学水平', '1', '2');
INSERT INTO `edu_question_options` VALUES ('7', '2014-05-21', 'hnssadmin1', '  ', '1', '3');
INSERT INTO `edu_question_options` VALUES ('8', '2014-05-21', 'hnssadmin1', '满意', '1', '4');
INSERT INTO `edu_question_options` VALUES ('9', '2014-05-21', 'hnssadmin1', '不满意', '1', '4');
INSERT INTO `edu_question_options` VALUES ('10', '2014-05-22', 'hnadmin', '选项１选项１选项１选项１选项１选项１', '1', '5');
INSERT INTO `edu_question_options` VALUES ('11', '2014-05-22', 'hnssadmin1', '满意', '1', '6');
INSERT INTO `edu_question_options` VALUES ('12', '2014-05-22', 'hnssadmin1', '不满意', '1', '6');
INSERT INTO `edu_question_options` VALUES ('13', '2014-05-22', 'hnssadmin1', '讲课方法', '1', '7');
INSERT INTO `edu_question_options` VALUES ('14', '2014-05-22', 'hnssadmin1', '讲课态度', '1', '7');
INSERT INTO `edu_question_options` VALUES ('15', '2014-05-22', 'hnssadmin1', '沟通方法', '1', '7');
INSERT INTO `edu_question_options` VALUES ('16', '2014-05-22', 'hnssadmin1', '班级管理方法', '1', '7');
INSERT INTO `edu_question_options` VALUES ('17', '2014-05-22', 'hnssadmin1', '  ', '1', '8');
INSERT INTO `edu_question_options` VALUES ('18', '2014-05-22', 'hnssadmin1', '  ', '1', '9');
INSERT INTO `edu_question_options` VALUES ('19', '2014-05-23', 'hnssadmin1', '满意', '1', '10');
INSERT INTO `edu_question_options` VALUES ('20', '2014-05-23', 'hnssadmin1', '不满意', '1', '10');
INSERT INTO `edu_question_options` VALUES ('21', '2014-05-23', 'hnssadmin1', '知识', '1', '11');
INSERT INTO `edu_question_options` VALUES ('22', '2014-05-23', 'hnssadmin1', '精神鼓励', '1', '11');
INSERT INTO `edu_question_options` VALUES ('23', '2014-05-23', 'hnssadmin1', '朋友', '1', '11');
INSERT INTO `edu_question_options` VALUES ('24', '2014-05-23', 'hnssadmin1', '智慧', '1', '11');
INSERT INTO `edu_question_options` VALUES ('25', '2014-05-23', 'hnssadmin1', '  ', '1', '12');
INSERT INTO `edu_question_options` VALUES ('26', '2014-06-05', 'shengadmin', '是', '1', '13');
INSERT INTO `edu_question_options` VALUES ('27', '2014-06-05', 'shengadmin', '否', '1', '13');
INSERT INTO `edu_question_options` VALUES ('28', '2014-06-05', 'shengadmin', '知识', '1', '14');
INSERT INTO `edu_question_options` VALUES ('29', '2014-06-05', 'shengadmin', '人力', '1', '14');
INSERT INTO `edu_question_options` VALUES ('30', '2014-06-05', 'shengadmin', '财力', '1', '14');
INSERT INTO `edu_question_options` VALUES ('31', '2014-06-05', 'shengadmin', '运气', '1', '14');
INSERT INTO `edu_question_options` VALUES ('32', '2014-06-05', 'shengadmin', '  ', '1', '15');
INSERT INTO `edu_question_options` VALUES ('33', '2014-06-05', 'shengadmin', '是', '1', '16');
INSERT INTO `edu_question_options` VALUES ('34', '2014-06-05', 'shengadmin', '否', '1', '16');
INSERT INTO `edu_question_options` VALUES ('35', '2014-06-05', 'shengadmin', '时间', '1', '17');
INSERT INTO `edu_question_options` VALUES ('36', '2014-06-05', 'shengadmin', '精力', '1', '17');

-- ----------------------------
-- Table structure for `edu_relas_func_role`
-- ----------------------------
DROP TABLE IF EXISTS `edu_relas_func_role`;
CREATE TABLE `edu_relas_func_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `func_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4443 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of edu_relas_func_role
-- ----------------------------
INSERT INTO `edu_relas_func_role` VALUES ('547', '20', '9');
INSERT INTO `edu_relas_func_role` VALUES ('548', '20', '10');
INSERT INTO `edu_relas_func_role` VALUES ('549', '20', '30');
INSERT INTO `edu_relas_func_role` VALUES ('550', '20', '31');
INSERT INTO `edu_relas_func_role` VALUES ('551', '20', '32');
INSERT INTO `edu_relas_func_role` VALUES ('552', '20', '33');
INSERT INTO `edu_relas_func_role` VALUES ('553', '20', '34');
INSERT INTO `edu_relas_func_role` VALUES ('554', '20', '40');
INSERT INTO `edu_relas_func_role` VALUES ('555', '20', '42');
INSERT INTO `edu_relas_func_role` VALUES ('556', '20', '1');
INSERT INTO `edu_relas_func_role` VALUES ('557', '20', '2');
INSERT INTO `edu_relas_func_role` VALUES ('558', '20', '45');
INSERT INTO `edu_relas_func_role` VALUES ('559', '20', '46');
INSERT INTO `edu_relas_func_role` VALUES ('560', '20', '66');
INSERT INTO `edu_relas_func_role` VALUES ('561', '20', '7');
INSERT INTO `edu_relas_func_role` VALUES ('562', '20', '8');
INSERT INTO `edu_relas_func_role` VALUES ('563', '20', '14');
INSERT INTO `edu_relas_func_role` VALUES ('564', '20', '15');
INSERT INTO `edu_relas_func_role` VALUES ('565', '20', '22');
INSERT INTO `edu_relas_func_role` VALUES ('566', '20', '23');
INSERT INTO `edu_relas_func_role` VALUES ('567', '20', '24');
INSERT INTO `edu_relas_func_role` VALUES ('568', '20', '13');
INSERT INTO `edu_relas_func_role` VALUES ('569', '20', '29');
INSERT INTO `edu_relas_func_role` VALUES ('570', '20', '26');
INSERT INTO `edu_relas_func_role` VALUES ('571', '20', '27');
INSERT INTO `edu_relas_func_role` VALUES ('572', '20', '28');
INSERT INTO `edu_relas_func_role` VALUES ('573', '20', '35');
INSERT INTO `edu_relas_func_role` VALUES ('574', '20', '71');
INSERT INTO `edu_relas_func_role` VALUES ('575', '20', '75');
INSERT INTO `edu_relas_func_role` VALUES ('576', '20', '76');
INSERT INTO `edu_relas_func_role` VALUES ('577', '20', '80');
INSERT INTO `edu_relas_func_role` VALUES ('578', '20', '86');
INSERT INTO `edu_relas_func_role` VALUES ('579', '20', '87');
INSERT INTO `edu_relas_func_role` VALUES ('580', '20', '88');
INSERT INTO `edu_relas_func_role` VALUES ('581', '20', '17');
INSERT INTO `edu_relas_func_role` VALUES ('582', '20', '3');
INSERT INTO `edu_relas_func_role` VALUES ('583', '20', '4');
INSERT INTO `edu_relas_func_role` VALUES ('584', '20', '11');
INSERT INTO `edu_relas_func_role` VALUES ('585', '20', '44');
INSERT INTO `edu_relas_func_role` VALUES ('586', '20', '47');
INSERT INTO `edu_relas_func_role` VALUES ('587', '20', '55');
INSERT INTO `edu_relas_func_role` VALUES ('588', '20', '53');
INSERT INTO `edu_relas_func_role` VALUES ('589', '20', '50');
INSERT INTO `edu_relas_func_role` VALUES ('590', '20', '52');
INSERT INTO `edu_relas_func_role` VALUES ('591', '20', '60');
INSERT INTO `edu_relas_func_role` VALUES ('592', '20', '59');
INSERT INTO `edu_relas_func_role` VALUES ('593', '20', '58');
INSERT INTO `edu_relas_func_role` VALUES ('594', '20', '5');
INSERT INTO `edu_relas_func_role` VALUES ('595', '20', '6');
INSERT INTO `edu_relas_func_role` VALUES ('596', '20', '69');
INSERT INTO `edu_relas_func_role` VALUES ('597', '20', '36');
INSERT INTO `edu_relas_func_role` VALUES ('598', '20', '43');
INSERT INTO `edu_relas_func_role` VALUES ('599', '20', '63');
INSERT INTO `edu_relas_func_role` VALUES ('600', '20', '64');
INSERT INTO `edu_relas_func_role` VALUES ('601', '20', '65');
INSERT INTO `edu_relas_func_role` VALUES ('602', '20', '67');
INSERT INTO `edu_relas_func_role` VALUES ('603', '20', '68');
INSERT INTO `edu_relas_func_role` VALUES ('836', '10', '10');
INSERT INTO `edu_relas_func_role` VALUES ('837', '10', '2');
INSERT INTO `edu_relas_func_role` VALUES ('838', '10', '8');
INSERT INTO `edu_relas_func_role` VALUES ('839', '10', '70');
INSERT INTO `edu_relas_func_role` VALUES ('840', '10', '71');
INSERT INTO `edu_relas_func_role` VALUES ('841', '10', '72');
INSERT INTO `edu_relas_func_role` VALUES ('842', '10', '73');
INSERT INTO `edu_relas_func_role` VALUES ('843', '10', '74');
INSERT INTO `edu_relas_func_role` VALUES ('844', '10', '75');
INSERT INTO `edu_relas_func_role` VALUES ('845', '10', '76');
INSERT INTO `edu_relas_func_role` VALUES ('846', '10', '77');
INSERT INTO `edu_relas_func_role` VALUES ('847', '10', '78');
INSERT INTO `edu_relas_func_role` VALUES ('848', '10', '79');
INSERT INTO `edu_relas_func_role` VALUES ('849', '10', '80');
INSERT INTO `edu_relas_func_role` VALUES ('850', '10', '81');
INSERT INTO `edu_relas_func_role` VALUES ('851', '10', '85');
INSERT INTO `edu_relas_func_role` VALUES ('852', '10', '86');
INSERT INTO `edu_relas_func_role` VALUES ('853', '10', '87');
INSERT INTO `edu_relas_func_role` VALUES ('854', '10', '88');
INSERT INTO `edu_relas_func_role` VALUES ('855', '10', '4');
INSERT INTO `edu_relas_func_role` VALUES ('856', '10', '6');
INSERT INTO `edu_relas_func_role` VALUES ('2714', '3', '9');
INSERT INTO `edu_relas_func_role` VALUES ('2715', '3', '10');
INSERT INTO `edu_relas_func_role` VALUES ('2716', '3', '30');
INSERT INTO `edu_relas_func_role` VALUES ('2717', '3', '31');
INSERT INTO `edu_relas_func_role` VALUES ('2718', '3', '32');
INSERT INTO `edu_relas_func_role` VALUES ('2719', '3', '33');
INSERT INTO `edu_relas_func_role` VALUES ('2720', '3', '34');
INSERT INTO `edu_relas_func_role` VALUES ('2721', '3', '105');
INSERT INTO `edu_relas_func_role` VALUES ('2722', '3', '106');
INSERT INTO `edu_relas_func_role` VALUES ('2723', '3', '107');
INSERT INTO `edu_relas_func_role` VALUES ('2724', '3', '108');
INSERT INTO `edu_relas_func_role` VALUES ('2725', '3', '111');
INSERT INTO `edu_relas_func_role` VALUES ('2726', '3', '112');
INSERT INTO `edu_relas_func_role` VALUES ('2727', '3', '113');
INSERT INTO `edu_relas_func_role` VALUES ('2728', '3', '114');
INSERT INTO `edu_relas_func_role` VALUES ('2729', '3', '1');
INSERT INTO `edu_relas_func_role` VALUES ('2730', '3', '2');
INSERT INTO `edu_relas_func_role` VALUES ('2731', '3', '45');
INSERT INTO `edu_relas_func_role` VALUES ('2732', '3', '46');
INSERT INTO `edu_relas_func_role` VALUES ('2733', '3', '7');
INSERT INTO `edu_relas_func_role` VALUES ('2734', '3', '8');
INSERT INTO `edu_relas_func_role` VALUES ('2735', '3', '70');
INSERT INTO `edu_relas_func_role` VALUES ('2736', '3', '71');
INSERT INTO `edu_relas_func_role` VALUES ('2737', '3', '72');
INSERT INTO `edu_relas_func_role` VALUES ('2738', '3', '73');
INSERT INTO `edu_relas_func_role` VALUES ('2739', '3', '74');
INSERT INTO `edu_relas_func_role` VALUES ('2740', '3', '75');
INSERT INTO `edu_relas_func_role` VALUES ('2741', '3', '76');
INSERT INTO `edu_relas_func_role` VALUES ('2742', '3', '77');
INSERT INTO `edu_relas_func_role` VALUES ('2743', '3', '78');
INSERT INTO `edu_relas_func_role` VALUES ('2744', '3', '79');
INSERT INTO `edu_relas_func_role` VALUES ('2745', '3', '80');
INSERT INTO `edu_relas_func_role` VALUES ('2746', '3', '81');
INSERT INTO `edu_relas_func_role` VALUES ('2747', '3', '86');
INSERT INTO `edu_relas_func_role` VALUES ('2748', '3', '87');
INSERT INTO `edu_relas_func_role` VALUES ('2749', '3', '88');
INSERT INTO `edu_relas_func_role` VALUES ('2750', '3', '3');
INSERT INTO `edu_relas_func_role` VALUES ('2751', '3', '4');
INSERT INTO `edu_relas_func_role` VALUES ('2752', '3', '5');
INSERT INTO `edu_relas_func_role` VALUES ('2753', '3', '6');
INSERT INTO `edu_relas_func_role` VALUES ('2754', '3', '69');
INSERT INTO `edu_relas_func_role` VALUES ('2755', '3', '36');
INSERT INTO `edu_relas_func_role` VALUES ('2756', '3', '39');
INSERT INTO `edu_relas_func_role` VALUES ('2757', '3', '62');
INSERT INTO `edu_relas_func_role` VALUES ('2758', '3', '63');
INSERT INTO `edu_relas_func_role` VALUES ('2759', '3', '64');
INSERT INTO `edu_relas_func_role` VALUES ('2760', '3', '65');
INSERT INTO `edu_relas_func_role` VALUES ('2761', '3', '67');
INSERT INTO `edu_relas_func_role` VALUES ('2762', '3', '68');
INSERT INTO `edu_relas_func_role` VALUES ('2763', '3', '89');
INSERT INTO `edu_relas_func_role` VALUES ('2764', '3', '90');
INSERT INTO `edu_relas_func_role` VALUES ('2765', '3', '91');
INSERT INTO `edu_relas_func_role` VALUES ('2766', '3', '95');
INSERT INTO `edu_relas_func_role` VALUES ('2767', '3', '96');
INSERT INTO `edu_relas_func_role` VALUES ('2768', '3', '97');
INSERT INTO `edu_relas_func_role` VALUES ('2769', '3', '98');
INSERT INTO `edu_relas_func_role` VALUES ('2770', '3', '99');
INSERT INTO `edu_relas_func_role` VALUES ('2771', '3', '100');
INSERT INTO `edu_relas_func_role` VALUES ('2772', '3', '101');
INSERT INTO `edu_relas_func_role` VALUES ('2773', '3', '102');
INSERT INTO `edu_relas_func_role` VALUES ('2774', '3', '103');
INSERT INTO `edu_relas_func_role` VALUES ('2775', '3', '115');
INSERT INTO `edu_relas_func_role` VALUES ('3155', '2', '9');
INSERT INTO `edu_relas_func_role` VALUES ('3156', '2', '10');
INSERT INTO `edu_relas_func_role` VALUES ('3157', '2', '30');
INSERT INTO `edu_relas_func_role` VALUES ('3158', '2', '31');
INSERT INTO `edu_relas_func_role` VALUES ('3159', '2', '32');
INSERT INTO `edu_relas_func_role` VALUES ('3160', '2', '33');
INSERT INTO `edu_relas_func_role` VALUES ('3161', '2', '34');
INSERT INTO `edu_relas_func_role` VALUES ('3162', '2', '40');
INSERT INTO `edu_relas_func_role` VALUES ('3163', '2', '105');
INSERT INTO `edu_relas_func_role` VALUES ('3164', '2', '106');
INSERT INTO `edu_relas_func_role` VALUES ('3165', '2', '107');
INSERT INTO `edu_relas_func_role` VALUES ('3166', '2', '108');
INSERT INTO `edu_relas_func_role` VALUES ('3167', '2', '111');
INSERT INTO `edu_relas_func_role` VALUES ('3168', '2', '116');
INSERT INTO `edu_relas_func_role` VALUES ('3169', '2', '1');
INSERT INTO `edu_relas_func_role` VALUES ('3170', '2', '2');
INSERT INTO `edu_relas_func_role` VALUES ('3171', '2', '45');
INSERT INTO `edu_relas_func_role` VALUES ('3172', '2', '46');
INSERT INTO `edu_relas_func_role` VALUES ('3173', '2', '7');
INSERT INTO `edu_relas_func_role` VALUES ('3174', '2', '8');
INSERT INTO `edu_relas_func_role` VALUES ('3175', '2', '70');
INSERT INTO `edu_relas_func_role` VALUES ('3176', '2', '71');
INSERT INTO `edu_relas_func_role` VALUES ('3177', '2', '72');
INSERT INTO `edu_relas_func_role` VALUES ('3178', '2', '73');
INSERT INTO `edu_relas_func_role` VALUES ('3179', '2', '74');
INSERT INTO `edu_relas_func_role` VALUES ('3180', '2', '75');
INSERT INTO `edu_relas_func_role` VALUES ('3181', '2', '76');
INSERT INTO `edu_relas_func_role` VALUES ('3182', '2', '77');
INSERT INTO `edu_relas_func_role` VALUES ('3183', '2', '78');
INSERT INTO `edu_relas_func_role` VALUES ('3184', '2', '79');
INSERT INTO `edu_relas_func_role` VALUES ('3185', '2', '80');
INSERT INTO `edu_relas_func_role` VALUES ('3186', '2', '81');
INSERT INTO `edu_relas_func_role` VALUES ('3187', '2', '85');
INSERT INTO `edu_relas_func_role` VALUES ('3188', '2', '86');
INSERT INTO `edu_relas_func_role` VALUES ('3189', '2', '87');
INSERT INTO `edu_relas_func_role` VALUES ('3190', '2', '88');
INSERT INTO `edu_relas_func_role` VALUES ('3191', '2', '3');
INSERT INTO `edu_relas_func_role` VALUES ('3192', '2', '4');
INSERT INTO `edu_relas_func_role` VALUES ('3193', '2', '11');
INSERT INTO `edu_relas_func_role` VALUES ('3194', '2', '47');
INSERT INTO `edu_relas_func_role` VALUES ('3195', '2', '55');
INSERT INTO `edu_relas_func_role` VALUES ('3196', '2', '53');
INSERT INTO `edu_relas_func_role` VALUES ('3197', '2', '54');
INSERT INTO `edu_relas_func_role` VALUES ('3198', '2', '48');
INSERT INTO `edu_relas_func_role` VALUES ('3199', '2', '49');
INSERT INTO `edu_relas_func_role` VALUES ('3200', '2', '50');
INSERT INTO `edu_relas_func_role` VALUES ('3201', '2', '51');
INSERT INTO `edu_relas_func_role` VALUES ('3202', '2', '52');
INSERT INTO `edu_relas_func_role` VALUES ('3203', '2', '56');
INSERT INTO `edu_relas_func_role` VALUES ('3204', '2', '60');
INSERT INTO `edu_relas_func_role` VALUES ('3205', '2', '59');
INSERT INTO `edu_relas_func_role` VALUES ('3206', '2', '61');
INSERT INTO `edu_relas_func_role` VALUES ('3207', '2', '57');
INSERT INTO `edu_relas_func_role` VALUES ('3208', '2', '58');
INSERT INTO `edu_relas_func_role` VALUES ('3209', '2', '84');
INSERT INTO `edu_relas_func_role` VALUES ('3210', '2', '92');
INSERT INTO `edu_relas_func_role` VALUES ('3211', '2', '5');
INSERT INTO `edu_relas_func_role` VALUES ('3212', '2', '6');
INSERT INTO `edu_relas_func_role` VALUES ('3213', '2', '69');
INSERT INTO `edu_relas_func_role` VALUES ('3214', '2', '36');
INSERT INTO `edu_relas_func_role` VALUES ('3215', '2', '39');
INSERT INTO `edu_relas_func_role` VALUES ('3216', '2', '62');
INSERT INTO `edu_relas_func_role` VALUES ('3217', '2', '63');
INSERT INTO `edu_relas_func_role` VALUES ('3218', '2', '64');
INSERT INTO `edu_relas_func_role` VALUES ('3219', '2', '65');
INSERT INTO `edu_relas_func_role` VALUES ('3220', '2', '67');
INSERT INTO `edu_relas_func_role` VALUES ('3221', '2', '68');
INSERT INTO `edu_relas_func_role` VALUES ('3222', '2', '89');
INSERT INTO `edu_relas_func_role` VALUES ('3223', '2', '90');
INSERT INTO `edu_relas_func_role` VALUES ('3224', '2', '91');
INSERT INTO `edu_relas_func_role` VALUES ('3225', '2', '95');
INSERT INTO `edu_relas_func_role` VALUES ('3226', '2', '96');
INSERT INTO `edu_relas_func_role` VALUES ('3227', '2', '97');
INSERT INTO `edu_relas_func_role` VALUES ('3228', '2', '98');
INSERT INTO `edu_relas_func_role` VALUES ('3229', '2', '99');
INSERT INTO `edu_relas_func_role` VALUES ('3230', '2', '100');
INSERT INTO `edu_relas_func_role` VALUES ('3231', '2', '101');
INSERT INTO `edu_relas_func_role` VALUES ('3232', '2', '102');
INSERT INTO `edu_relas_func_role` VALUES ('3233', '2', '103');
INSERT INTO `edu_relas_func_role` VALUES ('3234', '2', '115');
INSERT INTO `edu_relas_func_role` VALUES ('3235', '8', '9');
INSERT INTO `edu_relas_func_role` VALUES ('3236', '8', '32');
INSERT INTO `edu_relas_func_role` VALUES ('3237', '8', '33');
INSERT INTO `edu_relas_func_role` VALUES ('3238', '8', '34');
INSERT INTO `edu_relas_func_role` VALUES ('3239', '8', '112');
INSERT INTO `edu_relas_func_role` VALUES ('3240', '8', '113');
INSERT INTO `edu_relas_func_role` VALUES ('3241', '8', '114');
INSERT INTO `edu_relas_func_role` VALUES ('3242', '8', '116');
INSERT INTO `edu_relas_func_role` VALUES ('3243', '8', '1');
INSERT INTO `edu_relas_func_role` VALUES ('3244', '8', '2');
INSERT INTO `edu_relas_func_role` VALUES ('3245', '8', '7');
INSERT INTO `edu_relas_func_role` VALUES ('3246', '8', '8');
INSERT INTO `edu_relas_func_role` VALUES ('3247', '8', '70');
INSERT INTO `edu_relas_func_role` VALUES ('3248', '8', '71');
INSERT INTO `edu_relas_func_role` VALUES ('3249', '8', '72');
INSERT INTO `edu_relas_func_role` VALUES ('3250', '8', '73');
INSERT INTO `edu_relas_func_role` VALUES ('3251', '8', '74');
INSERT INTO `edu_relas_func_role` VALUES ('3252', '8', '75');
INSERT INTO `edu_relas_func_role` VALUES ('3253', '8', '76');
INSERT INTO `edu_relas_func_role` VALUES ('3254', '8', '77');
INSERT INTO `edu_relas_func_role` VALUES ('3255', '8', '78');
INSERT INTO `edu_relas_func_role` VALUES ('3256', '8', '79');
INSERT INTO `edu_relas_func_role` VALUES ('3257', '8', '4');
INSERT INTO `edu_relas_func_role` VALUES ('3258', '8', '6');
INSERT INTO `edu_relas_func_role` VALUES ('3302', '0', '10');
INSERT INTO `edu_relas_func_role` VALUES ('3303', '0', '111');
INSERT INTO `edu_relas_func_role` VALUES ('3304', '0', '1');
INSERT INTO `edu_relas_func_role` VALUES ('3305', '0', '2');
INSERT INTO `edu_relas_func_role` VALUES ('3306', '0', '45');
INSERT INTO `edu_relas_func_role` VALUES ('3307', '0', '46');
INSERT INTO `edu_relas_func_role` VALUES ('3308', '0', '66');
INSERT INTO `edu_relas_func_role` VALUES ('3309', '0', '8');
INSERT INTO `edu_relas_func_role` VALUES ('3310', '0', '3');
INSERT INTO `edu_relas_func_role` VALUES ('3311', '0', '4');
INSERT INTO `edu_relas_func_role` VALUES ('3312', '0', '11');
INSERT INTO `edu_relas_func_role` VALUES ('3313', '0', '44');
INSERT INTO `edu_relas_func_role` VALUES ('3314', '0', '47');
INSERT INTO `edu_relas_func_role` VALUES ('3315', '0', '55');
INSERT INTO `edu_relas_func_role` VALUES ('3316', '0', '53');
INSERT INTO `edu_relas_func_role` VALUES ('3317', '0', '54');
INSERT INTO `edu_relas_func_role` VALUES ('3318', '0', '48');
INSERT INTO `edu_relas_func_role` VALUES ('3319', '0', '49');
INSERT INTO `edu_relas_func_role` VALUES ('3320', '0', '51');
INSERT INTO `edu_relas_func_role` VALUES ('3321', '0', '52');
INSERT INTO `edu_relas_func_role` VALUES ('3322', '0', '56');
INSERT INTO `edu_relas_func_role` VALUES ('3323', '0', '60');
INSERT INTO `edu_relas_func_role` VALUES ('3324', '0', '59');
INSERT INTO `edu_relas_func_role` VALUES ('3325', '0', '61');
INSERT INTO `edu_relas_func_role` VALUES ('3326', '0', '57');
INSERT INTO `edu_relas_func_role` VALUES ('3327', '0', '58');
INSERT INTO `edu_relas_func_role` VALUES ('3328', '0', '84');
INSERT INTO `edu_relas_func_role` VALUES ('3329', '0', '6');
INSERT INTO `edu_relas_func_role` VALUES ('3523', '4', '9');
INSERT INTO `edu_relas_func_role` VALUES ('3524', '4', '10');
INSERT INTO `edu_relas_func_role` VALUES ('3525', '4', '30');
INSERT INTO `edu_relas_func_role` VALUES ('3526', '4', '31');
INSERT INTO `edu_relas_func_role` VALUES ('3527', '4', '33');
INSERT INTO `edu_relas_func_role` VALUES ('3528', '4', '34');
INSERT INTO `edu_relas_func_role` VALUES ('3529', '4', '104');
INSERT INTO `edu_relas_func_role` VALUES ('3530', '4', '105');
INSERT INTO `edu_relas_func_role` VALUES ('3531', '4', '106');
INSERT INTO `edu_relas_func_role` VALUES ('3532', '4', '107');
INSERT INTO `edu_relas_func_role` VALUES ('3533', '4', '108');
INSERT INTO `edu_relas_func_role` VALUES ('3534', '4', '111');
INSERT INTO `edu_relas_func_role` VALUES ('3535', '4', '114');
INSERT INTO `edu_relas_func_role` VALUES ('3536', '4', '1');
INSERT INTO `edu_relas_func_role` VALUES ('3537', '4', '2');
INSERT INTO `edu_relas_func_role` VALUES ('3538', '4', '45');
INSERT INTO `edu_relas_func_role` VALUES ('3539', '4', '46');
INSERT INTO `edu_relas_func_role` VALUES ('3540', '4', '7');
INSERT INTO `edu_relas_func_role` VALUES ('3541', '4', '8');
INSERT INTO `edu_relas_func_role` VALUES ('3542', '4', '70');
INSERT INTO `edu_relas_func_role` VALUES ('3543', '4', '71');
INSERT INTO `edu_relas_func_role` VALUES ('3544', '4', '72');
INSERT INTO `edu_relas_func_role` VALUES ('3545', '4', '73');
INSERT INTO `edu_relas_func_role` VALUES ('3546', '4', '74');
INSERT INTO `edu_relas_func_role` VALUES ('3547', '4', '75');
INSERT INTO `edu_relas_func_role` VALUES ('3548', '4', '76');
INSERT INTO `edu_relas_func_role` VALUES ('3549', '4', '77');
INSERT INTO `edu_relas_func_role` VALUES ('3550', '4', '78');
INSERT INTO `edu_relas_func_role` VALUES ('3551', '4', '79');
INSERT INTO `edu_relas_func_role` VALUES ('3552', '4', '80');
INSERT INTO `edu_relas_func_role` VALUES ('3553', '4', '81');
INSERT INTO `edu_relas_func_role` VALUES ('3554', '4', '85');
INSERT INTO `edu_relas_func_role` VALUES ('3555', '4', '86');
INSERT INTO `edu_relas_func_role` VALUES ('3556', '4', '87');
INSERT INTO `edu_relas_func_role` VALUES ('3557', '4', '88');
INSERT INTO `edu_relas_func_role` VALUES ('3558', '4', '5');
INSERT INTO `edu_relas_func_role` VALUES ('3559', '4', '6');
INSERT INTO `edu_relas_func_role` VALUES ('3560', '4', '69');
INSERT INTO `edu_relas_func_role` VALUES ('3561', '4', '36');
INSERT INTO `edu_relas_func_role` VALUES ('3562', '4', '39');
INSERT INTO `edu_relas_func_role` VALUES ('3563', '4', '62');
INSERT INTO `edu_relas_func_role` VALUES ('3564', '4', '63');
INSERT INTO `edu_relas_func_role` VALUES ('3565', '4', '64');
INSERT INTO `edu_relas_func_role` VALUES ('3566', '4', '65');
INSERT INTO `edu_relas_func_role` VALUES ('3567', '4', '67');
INSERT INTO `edu_relas_func_role` VALUES ('3568', '4', '68');
INSERT INTO `edu_relas_func_role` VALUES ('3569', '4', '89');
INSERT INTO `edu_relas_func_role` VALUES ('3570', '4', '90');
INSERT INTO `edu_relas_func_role` VALUES ('3571', '4', '91');
INSERT INTO `edu_relas_func_role` VALUES ('3572', '4', '95');
INSERT INTO `edu_relas_func_role` VALUES ('3573', '4', '96');
INSERT INTO `edu_relas_func_role` VALUES ('3574', '4', '97');
INSERT INTO `edu_relas_func_role` VALUES ('3575', '4', '98');
INSERT INTO `edu_relas_func_role` VALUES ('3576', '4', '99');
INSERT INTO `edu_relas_func_role` VALUES ('3577', '4', '100');
INSERT INTO `edu_relas_func_role` VALUES ('3578', '4', '101');
INSERT INTO `edu_relas_func_role` VALUES ('3579', '4', '102');
INSERT INTO `edu_relas_func_role` VALUES ('3580', '4', '103');
INSERT INTO `edu_relas_func_role` VALUES ('3581', '4', '115');
INSERT INTO `edu_relas_func_role` VALUES ('3582', '0', '120');
INSERT INTO `edu_relas_func_role` VALUES ('3770', '1', '9');
INSERT INTO `edu_relas_func_role` VALUES ('3771', '1', '10');
INSERT INTO `edu_relas_func_role` VALUES ('3772', '1', '30');
INSERT INTO `edu_relas_func_role` VALUES ('3773', '1', '32');
INSERT INTO `edu_relas_func_role` VALUES ('3774', '1', '33');
INSERT INTO `edu_relas_func_role` VALUES ('3775', '1', '34');
INSERT INTO `edu_relas_func_role` VALUES ('3776', '1', '105');
INSERT INTO `edu_relas_func_role` VALUES ('3777', '1', '106');
INSERT INTO `edu_relas_func_role` VALUES ('3778', '1', '107');
INSERT INTO `edu_relas_func_role` VALUES ('3779', '1', '108');
INSERT INTO `edu_relas_func_role` VALUES ('3780', '1', '111');
INSERT INTO `edu_relas_func_role` VALUES ('3781', '1', '112');
INSERT INTO `edu_relas_func_role` VALUES ('3782', '1', '113');
INSERT INTO `edu_relas_func_role` VALUES ('3783', '1', '114');
INSERT INTO `edu_relas_func_role` VALUES ('3784', '1', '116');
INSERT INTO `edu_relas_func_role` VALUES ('3785', '1', '1');
INSERT INTO `edu_relas_func_role` VALUES ('3786', '1', '2');
INSERT INTO `edu_relas_func_role` VALUES ('3787', '1', '45');
INSERT INTO `edu_relas_func_role` VALUES ('3788', '1', '46');
INSERT INTO `edu_relas_func_role` VALUES ('3789', '1', '66');
INSERT INTO `edu_relas_func_role` VALUES ('3790', '1', '7');
INSERT INTO `edu_relas_func_role` VALUES ('3791', '1', '8');
INSERT INTO `edu_relas_func_role` VALUES ('3792', '1', '70');
INSERT INTO `edu_relas_func_role` VALUES ('3793', '1', '71');
INSERT INTO `edu_relas_func_role` VALUES ('3794', '1', '72');
INSERT INTO `edu_relas_func_role` VALUES ('3795', '1', '73');
INSERT INTO `edu_relas_func_role` VALUES ('3796', '1', '74');
INSERT INTO `edu_relas_func_role` VALUES ('3797', '1', '75');
INSERT INTO `edu_relas_func_role` VALUES ('3798', '1', '76');
INSERT INTO `edu_relas_func_role` VALUES ('3799', '1', '77');
INSERT INTO `edu_relas_func_role` VALUES ('3800', '1', '78');
INSERT INTO `edu_relas_func_role` VALUES ('3801', '1', '79');
INSERT INTO `edu_relas_func_role` VALUES ('3802', '1', '81');
INSERT INTO `edu_relas_func_role` VALUES ('3803', '1', '85');
INSERT INTO `edu_relas_func_role` VALUES ('3804', '1', '86');
INSERT INTO `edu_relas_func_role` VALUES ('3805', '1', '87');
INSERT INTO `edu_relas_func_role` VALUES ('3806', '1', '88');
INSERT INTO `edu_relas_func_role` VALUES ('3807', '1', '117');
INSERT INTO `edu_relas_func_role` VALUES ('3808', '1', '3');
INSERT INTO `edu_relas_func_role` VALUES ('3809', '1', '4');
INSERT INTO `edu_relas_func_role` VALUES ('3810', '1', '11');
INSERT INTO `edu_relas_func_role` VALUES ('3811', '1', '47');
INSERT INTO `edu_relas_func_role` VALUES ('3812', '1', '55');
INSERT INTO `edu_relas_func_role` VALUES ('3813', '1', '53');
INSERT INTO `edu_relas_func_role` VALUES ('3814', '1', '54');
INSERT INTO `edu_relas_func_role` VALUES ('3815', '1', '49');
INSERT INTO `edu_relas_func_role` VALUES ('3816', '1', '50');
INSERT INTO `edu_relas_func_role` VALUES ('3817', '1', '51');
INSERT INTO `edu_relas_func_role` VALUES ('3818', '1', '52');
INSERT INTO `edu_relas_func_role` VALUES ('3819', '1', '56');
INSERT INTO `edu_relas_func_role` VALUES ('3820', '1', '60');
INSERT INTO `edu_relas_func_role` VALUES ('3821', '1', '59');
INSERT INTO `edu_relas_func_role` VALUES ('3822', '1', '57');
INSERT INTO `edu_relas_func_role` VALUES ('3823', '1', '58');
INSERT INTO `edu_relas_func_role` VALUES ('3824', '1', '84');
INSERT INTO `edu_relas_func_role` VALUES ('3825', '1', '92');
INSERT INTO `edu_relas_func_role` VALUES ('3826', '1', '5');
INSERT INTO `edu_relas_func_role` VALUES ('3827', '1', '6');
INSERT INTO `edu_relas_func_role` VALUES ('3828', '1', '69');
INSERT INTO `edu_relas_func_role` VALUES ('3829', '1', '36');
INSERT INTO `edu_relas_func_role` VALUES ('3830', '1', '39');
INSERT INTO `edu_relas_func_role` VALUES ('3831', '1', '62');
INSERT INTO `edu_relas_func_role` VALUES ('3832', '1', '63');
INSERT INTO `edu_relas_func_role` VALUES ('3833', '1', '64');
INSERT INTO `edu_relas_func_role` VALUES ('3834', '1', '65');
INSERT INTO `edu_relas_func_role` VALUES ('3835', '1', '67');
INSERT INTO `edu_relas_func_role` VALUES ('3836', '1', '68');
INSERT INTO `edu_relas_func_role` VALUES ('3837', '1', '89');
INSERT INTO `edu_relas_func_role` VALUES ('3838', '1', '90');
INSERT INTO `edu_relas_func_role` VALUES ('3839', '1', '91');
INSERT INTO `edu_relas_func_role` VALUES ('3840', '1', '95');
INSERT INTO `edu_relas_func_role` VALUES ('3841', '1', '96');
INSERT INTO `edu_relas_func_role` VALUES ('3842', '1', '97');
INSERT INTO `edu_relas_func_role` VALUES ('3843', '1', '98');
INSERT INTO `edu_relas_func_role` VALUES ('3844', '1', '99');
INSERT INTO `edu_relas_func_role` VALUES ('3845', '1', '100');
INSERT INTO `edu_relas_func_role` VALUES ('3846', '1', '101');
INSERT INTO `edu_relas_func_role` VALUES ('3847', '1', '102');
INSERT INTO `edu_relas_func_role` VALUES ('3848', '1', '103');
INSERT INTO `edu_relas_func_role` VALUES ('3849', '1', '115');
INSERT INTO `edu_relas_func_role` VALUES ('3850', '1', '124');
INSERT INTO `edu_relas_func_role` VALUES ('3851', '1', '125');
INSERT INTO `edu_relas_func_role` VALUES ('3852', '1', '126');
INSERT INTO `edu_relas_func_role` VALUES ('3989', '5', '9');
INSERT INTO `edu_relas_func_role` VALUES ('3990', '5', '10');
INSERT INTO `edu_relas_func_role` VALUES ('3991', '5', '40');
INSERT INTO `edu_relas_func_role` VALUES ('3992', '5', '42');
INSERT INTO `edu_relas_func_role` VALUES ('3993', '5', '109');
INSERT INTO `edu_relas_func_role` VALUES ('3994', '5', '111');
INSERT INTO `edu_relas_func_role` VALUES ('3995', '5', '1');
INSERT INTO `edu_relas_func_role` VALUES ('3996', '5', '2');
INSERT INTO `edu_relas_func_role` VALUES ('3997', '5', '45');
INSERT INTO `edu_relas_func_role` VALUES ('3998', '5', '46');
INSERT INTO `edu_relas_func_role` VALUES ('3999', '5', '66');
INSERT INTO `edu_relas_func_role` VALUES ('4000', '5', '7');
INSERT INTO `edu_relas_func_role` VALUES ('4001', '5', '8');
INSERT INTO `edu_relas_func_role` VALUES ('4002', '5', '23');
INSERT INTO `edu_relas_func_role` VALUES ('4003', '5', '26');
INSERT INTO `edu_relas_func_role` VALUES ('4004', '5', '27');
INSERT INTO `edu_relas_func_role` VALUES ('4005', '5', '28');
INSERT INTO `edu_relas_func_role` VALUES ('4006', '5', '94');
INSERT INTO `edu_relas_func_role` VALUES ('4007', '5', '110');
INSERT INTO `edu_relas_func_role` VALUES ('4008', '5', '4');
INSERT INTO `edu_relas_func_role` VALUES ('4009', '5', '5');
INSERT INTO `edu_relas_func_role` VALUES ('4010', '5', '6');
INSERT INTO `edu_relas_func_role` VALUES ('4011', '5', '25');
INSERT INTO `edu_relas_func_role` VALUES ('4012', '5', '43');
INSERT INTO `edu_relas_func_role` VALUES ('4013', '5', '93');
INSERT INTO `edu_relas_func_role` VALUES ('4343', '6', '10');
INSERT INTO `edu_relas_func_role` VALUES ('4344', '6', '111');
INSERT INTO `edu_relas_func_role` VALUES ('4345', '6', '1');
INSERT INTO `edu_relas_func_role` VALUES ('4346', '6', '2');
INSERT INTO `edu_relas_func_role` VALUES ('4347', '6', '45');
INSERT INTO `edu_relas_func_role` VALUES ('4348', '6', '46');
INSERT INTO `edu_relas_func_role` VALUES ('4349', '6', '66');
INSERT INTO `edu_relas_func_role` VALUES ('4350', '6', '7');
INSERT INTO `edu_relas_func_role` VALUES ('4351', '6', '8');
INSERT INTO `edu_relas_func_role` VALUES ('4352', '6', '85');
INSERT INTO `edu_relas_func_role` VALUES ('4353', '6', '16');
INSERT INTO `edu_relas_func_role` VALUES ('4354', '6', '17');
INSERT INTO `edu_relas_func_role` VALUES ('4355', '6', '18');
INSERT INTO `edu_relas_func_role` VALUES ('4356', '6', '19');
INSERT INTO `edu_relas_func_role` VALUES ('4357', '6', '20');
INSERT INTO `edu_relas_func_role` VALUES ('4358', '6', '21');
INSERT INTO `edu_relas_func_role` VALUES ('4359', '6', '83');
INSERT INTO `edu_relas_func_role` VALUES ('4360', '6', '127');
INSERT INTO `edu_relas_func_role` VALUES ('4361', '6', '4');
INSERT INTO `edu_relas_func_role` VALUES ('4362', '6', '6');
INSERT INTO `edu_relas_func_role` VALUES ('4363', '7', '9');
INSERT INTO `edu_relas_func_role` VALUES ('4364', '7', '10');
INSERT INTO `edu_relas_func_role` VALUES ('4365', '7', '32');
INSERT INTO `edu_relas_func_role` VALUES ('4366', '7', '33');
INSERT INTO `edu_relas_func_role` VALUES ('4367', '7', '34');
INSERT INTO `edu_relas_func_role` VALUES ('4368', '7', '40');
INSERT INTO `edu_relas_func_role` VALUES ('4369', '7', '105');
INSERT INTO `edu_relas_func_role` VALUES ('4370', '7', '106');
INSERT INTO `edu_relas_func_role` VALUES ('4371', '7', '107');
INSERT INTO `edu_relas_func_role` VALUES ('4372', '7', '108');
INSERT INTO `edu_relas_func_role` VALUES ('4373', '7', '111');
INSERT INTO `edu_relas_func_role` VALUES ('4374', '7', '112');
INSERT INTO `edu_relas_func_role` VALUES ('4375', '7', '113');
INSERT INTO `edu_relas_func_role` VALUES ('4376', '7', '114');
INSERT INTO `edu_relas_func_role` VALUES ('4377', '7', '116');
INSERT INTO `edu_relas_func_role` VALUES ('4378', '7', '1');
INSERT INTO `edu_relas_func_role` VALUES ('4379', '7', '2');
INSERT INTO `edu_relas_func_role` VALUES ('4380', '7', '45');
INSERT INTO `edu_relas_func_role` VALUES ('4381', '7', '46');
INSERT INTO `edu_relas_func_role` VALUES ('4382', '7', '66');
INSERT INTO `edu_relas_func_role` VALUES ('4383', '7', '7');
INSERT INTO `edu_relas_func_role` VALUES ('4384', '7', '8');
INSERT INTO `edu_relas_func_role` VALUES ('4385', '7', '70');
INSERT INTO `edu_relas_func_role` VALUES ('4386', '7', '71');
INSERT INTO `edu_relas_func_role` VALUES ('4387', '7', '72');
INSERT INTO `edu_relas_func_role` VALUES ('4388', '7', '74');
INSERT INTO `edu_relas_func_role` VALUES ('4389', '7', '75');
INSERT INTO `edu_relas_func_role` VALUES ('4390', '7', '76');
INSERT INTO `edu_relas_func_role` VALUES ('4391', '7', '77');
INSERT INTO `edu_relas_func_role` VALUES ('4392', '7', '78');
INSERT INTO `edu_relas_func_role` VALUES ('4393', '7', '79');
INSERT INTO `edu_relas_func_role` VALUES ('4394', '7', '81');
INSERT INTO `edu_relas_func_role` VALUES ('4395', '7', '85');
INSERT INTO `edu_relas_func_role` VALUES ('4396', '7', '86');
INSERT INTO `edu_relas_func_role` VALUES ('4397', '7', '87');
INSERT INTO `edu_relas_func_role` VALUES ('4398', '7', '88');
INSERT INTO `edu_relas_func_role` VALUES ('4399', '7', '129');
INSERT INTO `edu_relas_func_role` VALUES ('4400', '7', '3');
INSERT INTO `edu_relas_func_role` VALUES ('4401', '7', '4');
INSERT INTO `edu_relas_func_role` VALUES ('4402', '7', '11');
INSERT INTO `edu_relas_func_role` VALUES ('4403', '7', '47');
INSERT INTO `edu_relas_func_role` VALUES ('4404', '7', '55');
INSERT INTO `edu_relas_func_role` VALUES ('4405', '7', '53');
INSERT INTO `edu_relas_func_role` VALUES ('4406', '7', '54');
INSERT INTO `edu_relas_func_role` VALUES ('4407', '7', '48');
INSERT INTO `edu_relas_func_role` VALUES ('4408', '7', '49');
INSERT INTO `edu_relas_func_role` VALUES ('4409', '7', '51');
INSERT INTO `edu_relas_func_role` VALUES ('4410', '7', '56');
INSERT INTO `edu_relas_func_role` VALUES ('4411', '7', '60');
INSERT INTO `edu_relas_func_role` VALUES ('4412', '7', '59');
INSERT INTO `edu_relas_func_role` VALUES ('4413', '7', '61');
INSERT INTO `edu_relas_func_role` VALUES ('4414', '7', '57');
INSERT INTO `edu_relas_func_role` VALUES ('4415', '7', '58');
INSERT INTO `edu_relas_func_role` VALUES ('4416', '7', '84');
INSERT INTO `edu_relas_func_role` VALUES ('4417', '7', '5');
INSERT INTO `edu_relas_func_role` VALUES ('4418', '7', '6');
INSERT INTO `edu_relas_func_role` VALUES ('4419', '7', '69');
INSERT INTO `edu_relas_func_role` VALUES ('4420', '7', '36');
INSERT INTO `edu_relas_func_role` VALUES ('4421', '7', '39');
INSERT INTO `edu_relas_func_role` VALUES ('4422', '7', '43');
INSERT INTO `edu_relas_func_role` VALUES ('4423', '7', '62');
INSERT INTO `edu_relas_func_role` VALUES ('4424', '7', '63');
INSERT INTO `edu_relas_func_role` VALUES ('4425', '7', '64');
INSERT INTO `edu_relas_func_role` VALUES ('4426', '7', '65');
INSERT INTO `edu_relas_func_role` VALUES ('4427', '7', '67');
INSERT INTO `edu_relas_func_role` VALUES ('4428', '7', '68');
INSERT INTO `edu_relas_func_role` VALUES ('4429', '7', '89');
INSERT INTO `edu_relas_func_role` VALUES ('4430', '7', '90');
INSERT INTO `edu_relas_func_role` VALUES ('4431', '7', '91');
INSERT INTO `edu_relas_func_role` VALUES ('4432', '7', '93');
INSERT INTO `edu_relas_func_role` VALUES ('4433', '7', '95');
INSERT INTO `edu_relas_func_role` VALUES ('4434', '7', '96');
INSERT INTO `edu_relas_func_role` VALUES ('4435', '7', '97');
INSERT INTO `edu_relas_func_role` VALUES ('4436', '7', '98');
INSERT INTO `edu_relas_func_role` VALUES ('4437', '7', '99');
INSERT INTO `edu_relas_func_role` VALUES ('4438', '7', '100');
INSERT INTO `edu_relas_func_role` VALUES ('4439', '7', '101');
INSERT INTO `edu_relas_func_role` VALUES ('4440', '7', '102');
INSERT INTO `edu_relas_func_role` VALUES ('4441', '7', '103');
INSERT INTO `edu_relas_func_role` VALUES ('4442', '7', '115');

-- ----------------------------
-- Table structure for `edu_response`
-- ----------------------------
DROP TABLE IF EXISTS `edu_response`;
CREATE TABLE `edu_response` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `username` varchar(30) DEFAULT NULL COMMENT '创建者',
  `ipaddress` varchar(255) DEFAULT NULL COMMENT 'ip地址',
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `project_id` int(11) DEFAULT NULL COMMENT '项目id',
  `paper_id` int(11) DEFAULT NULL COMMENT '问卷id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of edu_response
-- ----------------------------
INSERT INTO `edu_response` VALUES ('1', '2014-05-21 11:00:00', 'laoshi1', '218.247.190.130', '李明', '2', '1');
INSERT INTO `edu_response` VALUES ('2', '2014-05-21 20:00:00', 'laoshi2', '218.247.190.130', '高力', '2', '1');
INSERT INTO `edu_response` VALUES ('3', '2014-05-22 10:00:00', 'laoshi8', '127.0.0.1', '黄雷', '2', '1');
INSERT INTO `edu_response` VALUES ('4', '2014-05-22 10:50:47', 'laoshi1', '127.0.0.1', '李明', '3', '2');
INSERT INTO `edu_response` VALUES ('5', '2014-05-22 00:00:00', 'laoshi1', '218.247.190.130', '李明', '4', '3');
INSERT INTO `edu_response` VALUES ('6', '2014-05-23 00:00:00', 'laoshi1', '218.247.190.130', '李明', '7', '4');
INSERT INTO `edu_response` VALUES ('7', '2014-05-23 10:01:32', 'laoshi2', '127.0.0.1', '高力', '4', '3');
INSERT INTO `edu_response` VALUES ('8', '2014-05-28 15:21:47', 'laoshi21', '218.247.190.130', '李明一', '7', '4');
INSERT INTO `edu_response` VALUES ('9', '2014-06-05 10:41:23', 'teacher5', '218.247.190.130', '柳宁', '15', '6');
INSERT INTO `edu_response` VALUES ('10', '2014-06-05 10:41:45', 'teacher5', '218.247.190.130', '柳宁', '16', '7');
INSERT INTO `edu_response` VALUES ('11', '2014-06-05 10:42:18', 'teacher5', '218.247.190.130', '柳宁', '13', '5');
INSERT INTO `edu_response` VALUES ('12', '2014-06-05 10:48:25', 'teacher4', '218.247.190.130', '李焕', '13', '5');
INSERT INTO `edu_response` VALUES ('13', '2014-06-05 10:48:34', 'teacher4', '218.247.190.130', '李焕', '15', '6');
INSERT INTO `edu_response` VALUES ('14', '2014-06-05 10:48:42', 'teacher4', '218.247.190.130', '李焕', '16', '7');
INSERT INTO `edu_response` VALUES ('15', '2014-06-05 10:56:04', 'laoshi24', '218.247.190.130', '潘莹', '15', '6');

-- ----------------------------
-- Table structure for `edu_response_question`
-- ----------------------------
DROP TABLE IF EXISTS `edu_response_question`;
CREATE TABLE `edu_response_question` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `username` varchar(30) DEFAULT NULL COMMENT '创建者',
  `answer` varchar(2000) DEFAULT NULL COMMENT '回答;question_options_id; 多选用|分割',
  `response_id` int(11) DEFAULT NULL COMMENT '答卷id',
  `question_id` int(11) DEFAULT NULL COMMENT '问题id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of edu_response_question
-- ----------------------------
INSERT INTO `edu_response_question` VALUES ('1', '2014-05-21 00:00:00', 'laoshi1', '3|4|5|', '1', '2');
INSERT INTO `edu_response_question` VALUES ('2', '2014-05-21 00:00:00', 'laoshi1', '多点儿老师进行指导', '1', '3');
INSERT INTO `edu_response_question` VALUES ('3', '2014-05-21 00:00:00', 'laoshi1', '8', '1', '4');
INSERT INTO `edu_response_question` VALUES ('4', '2014-05-21 00:00:00', 'laoshi2', '4|', '2', '2');
INSERT INTO `edu_response_question` VALUES ('5', '2014-05-21 00:00:00', 'laoshi2', '多多益善', '2', '3');
INSERT INTO `edu_response_question` VALUES ('6', '2014-05-21 00:00:00', 'laoshi2', '9', '2', '4');
INSERT INTO `edu_response_question` VALUES ('7', '2014-05-22 00:00:00', 'laoshi8', '3|4|6|', '3', '2');
INSERT INTO `edu_response_question` VALUES ('8', '2014-05-22 00:00:00', 'laoshi8', 'asfdasdf', '3', '3');
INSERT INTO `edu_response_question` VALUES ('9', '2014-05-22 00:00:00', 'laoshi8', '8', '3', '4');
INSERT INTO `edu_response_question` VALUES ('10', '2014-05-22 00:00:00', 'laoshi1', '10', '4', '5');
INSERT INTO `edu_response_question` VALUES ('11', '2014-05-22 00:00:00', 'laoshi1', '11', '5', '6');
INSERT INTO `edu_response_question` VALUES ('12', '2014-05-22 00:00:00', 'laoshi1', '13|14|15|', '5', '7');
INSERT INTO `edu_response_question` VALUES ('13', '2014-05-22 00:00:00', 'laoshi1', 'asdf ', '5', '8');
INSERT INTO `edu_response_question` VALUES ('14', '2014-05-22 00:00:00', 'laoshi1', 'asdf', '5', '9');
INSERT INTO `edu_response_question` VALUES ('15', '2014-05-23 00:00:00', 'laoshi1', '19', '6', '10');
INSERT INTO `edu_response_question` VALUES ('16', '2014-05-23 00:00:00', 'laoshi1', '21|22|23|', '6', '11');
INSERT INTO `edu_response_question` VALUES ('17', '2014-05-23 00:00:00', 'laoshi1', '时间分配好', '6', '12');
INSERT INTO `edu_response_question` VALUES ('18', '2014-05-23 00:00:00', 'laoshi2', '11', '7', '6');
INSERT INTO `edu_response_question` VALUES ('19', '2014-05-23 00:00:00', 'laoshi2', '13|', '7', '7');
INSERT INTO `edu_response_question` VALUES ('20', '2014-05-23 00:00:00', 'laoshi2', 'asdfasdf', '7', '8');
INSERT INTO `edu_response_question` VALUES ('21', '2014-05-23 00:00:00', 'laoshi2', 'sadfsafas', '7', '9');
INSERT INTO `edu_response_question` VALUES ('22', '2014-05-28 00:00:00', 'laoshi21', '19', '8', '10');
INSERT INTO `edu_response_question` VALUES ('23', '2014-05-28 00:00:00', 'laoshi21', '21|22|', '8', '11');
INSERT INTO `edu_response_question` VALUES ('24', '2014-05-28 00:00:00', 'laoshi21', '司法瑟瑟发抖', '8', '12');
INSERT INTO `edu_response_question` VALUES ('25', '2014-06-05 00:00:00', 'teacher5', '33', '9', '16');
INSERT INTO `edu_response_question` VALUES ('26', '2014-06-05 00:00:00', 'teacher5', '35|36|', '10', '17');
INSERT INTO `edu_response_question` VALUES ('27', '2014-06-05 00:00:00', 'teacher5', '27', '11', '13');
INSERT INTO `edu_response_question` VALUES ('28', '2014-06-05 00:00:00', 'teacher5', '30|31|', '11', '14');
INSERT INTO `edu_response_question` VALUES ('29', '2014-06-05 00:00:00', 'teacher5', '知识', '11', '15');
INSERT INTO `edu_response_question` VALUES ('30', '2014-06-05 00:00:00', 'teacher4', '26', '12', '13');
INSERT INTO `edu_response_question` VALUES ('31', '2014-06-05 00:00:00', 'teacher4', '28|29|30|31|', '12', '14');
INSERT INTO `edu_response_question` VALUES ('32', '2014-06-05 00:00:00', 'teacher4', '能量', '12', '15');
INSERT INTO `edu_response_question` VALUES ('33', '2014-06-05 00:00:00', 'teacher4', '34', '13', '16');
INSERT INTO `edu_response_question` VALUES ('34', '2014-06-05 00:00:00', 'teacher4', '35|', '14', '17');
INSERT INTO `edu_response_question` VALUES ('35', '2014-06-05 00:00:00', 'laoshi24', '34', '15', '16');

-- ----------------------------
-- Table structure for `edu_school`
-- ----------------------------
DROP TABLE IF EXISTS `edu_school`;
CREATE TABLE `edu_school` (
  `school_id` int(11) NOT NULL AUTO_INCREMENT,
  `school_name` varchar(50) DEFAULT NULL COMMENT '学校名称',
  `school_type_id` int(5) DEFAULT NULL COMMENT '学校类型id',
  `school_type_name` varchar(50) DEFAULT NULL COMMENT '学校类型名称',
  `school_province_id` int(5) DEFAULT NULL,
  `school_province_name` varchar(50) DEFAULT NULL,
  `school_city_id` int(5) DEFAULT NULL,
  `school_city_name` varchar(50) DEFAULT NULL,
  `school_district_id` int(5) DEFAULT NULL,
  `school_district_name` varchar(50) DEFAULT NULL,
  `school_contacts` varchar(20) DEFAULT NULL COMMENT '学校联系人',
  `school_contacts_type` varchar(20) DEFAULT NULL COMMENT '学校联系方式',
  `school_contacts_address` varchar(100) DEFAULT NULL COMMENT '学校联系地址',
  `school_memo` varchar(300) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(20) DEFAULT NULL COMMENT '创建人',
  `create_date` date DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(20) DEFAULT NULL COMMENT '更新人',
  `update_date` date DEFAULT NULL COMMENT '更新时间',
  `status` int(5) DEFAULT '1' COMMENT '1:有效，0 无效',
  `school_nature_id` int(5) DEFAULT NULL COMMENT '学校性质：1：公办；0民办',
  `school_nature_name` varchar(20) DEFAULT NULL COMMENT '学校性质：公办，民办',
  `area_type_id` int(5) DEFAULT NULL,
  `area_type_name` varchar(20) DEFAULT NULL,
  `school_code` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`school_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of edu_school
-- ----------------------------
INSERT INTO `edu_school` VALUES ('1', '雨湖区初中', '2', '初中', '1', '湖南省', '3', '湘潭市', '8', '雨湖区', '李四', '111', '湖北省', '22', 'xitongadmin', '2014-05-21', 'xitongadmin', '2014-05-21', '1', '1', '公办', null, null, '10001');
INSERT INTO `edu_school` VALUES ('2', '天心区小学', '1', '小学', '1', '湖南省', '2', '长沙市', '5', '天心区', '张三', '1232', '湖北省', '2', 'xitongadmin', '2014-05-21', 'xitongadmin', '2014-05-21', '1', '0', '民办', null, null, '100002');
INSERT INTO `edu_school` VALUES ('3', '雨花区初中', '2', '初中', '1', '湖南省', '2', '长沙市', '7', '雨花区', '李四', '1111', '湖北省', '1', 'xitongadmin', '2014-05-21', 'xitongadmin', '2014-05-21', '1', '0', '民办', null, null, '100003');
INSERT INTO `edu_school` VALUES ('4', '芙蓉区小学', '1', '小学', '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '张三', '1232', '湖北省', '11', 'xitongadmin', '2014-05-21', 'xitongadmin', '2014-05-21', '1', '1', '公办', null, null, '100004');
INSERT INTO `edu_school` VALUES ('5', '湘乡市小学', '1', '小学', '1', '湖南省', '3', '湘潭市', '10', '湘乡市', '李俊', '111', '湖北省', '22', 'xitongadmin', '2014-05-21', 'xitongadmin', '2014-05-21', '1', '1', '公办', null, null, '100005');
INSERT INTO `edu_school` VALUES ('6', '岳塘区小学', '1', '小学', '1', '湖南省', '3', '湘潭市', '9', '岳塘区', '李俊', '22', '湖北省', '22', 'xitongadmin', '2014-05-21', 'xitongadmin', '2014-05-21', '1', '0', '民办', null, null, '100006');
INSERT INTO `edu_school` VALUES ('7', '韶山初中', '2', '初中', '1', '湖南省', '3', '湘潭市', '11', '韶山市', '李俊', '222', '湖北省', '22', 'xitongadmin', '2014-05-21', 'xitongadmin', '2014-05-21', '1', '0', '民办', null, null, '100007');
INSERT INTO `edu_school` VALUES ('8', '望城区实验小学', '1', '小学', '1', '湖南省', '2', '长沙市', '6', '望城区', '李四', '1233', '湖北省', '33', 'xitongadmin', '2014-05-21', 'xitongadmin', '2014-05-21', '1', '1', '公办', null, null, '100008');

-- ----------------------------
-- Table structure for `edu_statistic_jijiao`
-- ----------------------------
DROP TABLE IF EXISTS `edu_statistic_jijiao`;
CREATE TABLE `edu_statistic_jijiao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `year` varchar(4) DEFAULT NULL COMMENT '年度',
  `teacher_num` int(11) DEFAULT NULL COMMENT '参训教师数',
  `train_num` varchar(100) DEFAULT NULL COMMENT '培训人次',
  `percent` float(5,4) DEFAULT NULL COMMENT '合格率',
  `area_id` int(11) DEFAULT NULL COMMENT '地区ID',
  `area_name` varchar(100) DEFAULT NULL COMMENT '地区名称',
  `area_pid` int(11) DEFAULT NULL COMMENT '上级地区ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of edu_statistic_jijiao
-- ----------------------------
INSERT INTO `edu_statistic_jijiao` VALUES ('1', '2014', '25', '61', '0.1600', '1', '湖南省', '0');
INSERT INTO `edu_statistic_jijiao` VALUES ('2', '2014', '17', '59', '0.2353', '2', '长沙市', '1');
INSERT INTO `edu_statistic_jijiao` VALUES ('3', '2014', '8', '2', '0.0000', '3', '湘潭市', '1');
INSERT INTO `edu_statistic_jijiao` VALUES ('4', '2014', '10', '38', '0.2000', '4', '芙蓉区', '2');
INSERT INTO `edu_statistic_jijiao` VALUES ('5', '2014', '3', '10', '0.3333', '5', '天心区', '2');
INSERT INTO `edu_statistic_jijiao` VALUES ('6', '2014', '2', '7', '0.5000', '6', '望城区', '2');
INSERT INTO `edu_statistic_jijiao` VALUES ('7', '2014', '2', '4', '0.0000', '7', '雨花区', '2');
INSERT INTO `edu_statistic_jijiao` VALUES ('8', '2014', '2', '1', '0.0000', '8', '雨湖区', '3');
INSERT INTO `edu_statistic_jijiao` VALUES ('9', '2014', '2', '1', '0.0000', '9', '岳塘区', '3');
INSERT INTO `edu_statistic_jijiao` VALUES ('10', '2014', '2', '0', '0.0000', '10', '湘乡市', '3');
INSERT INTO `edu_statistic_jijiao` VALUES ('11', '2014', '2', '0', '0.0000', '11', '韶山市', '3');
INSERT INTO `edu_statistic_jijiao` VALUES ('12', '2014', '0', null, null, '14', '株洲市', '1');
INSERT INTO `edu_statistic_jijiao` VALUES ('13', '2014', '0', null, null, '15', '荷塘区', '14');
INSERT INTO `edu_statistic_jijiao` VALUES ('14', '2014', '0', null, null, '16', '石峰区', '14');
INSERT INTO `edu_statistic_jijiao` VALUES ('15', '2014', '0', null, null, '17', '邵阳市', '1');
INSERT INTO `edu_statistic_jijiao` VALUES ('16', '2014', '0', null, null, '18', '双清区', '17');
INSERT INTO `edu_statistic_jijiao` VALUES ('17', '2014', '0', null, null, '19', '北塔区', '17');
INSERT INTO `edu_statistic_jijiao` VALUES ('32', '2014', '25', '61', '0.1600', '1', '湖南省', '0');
INSERT INTO `edu_statistic_jijiao` VALUES ('33', '2014', '17', '59', '0.2353', '2', '长沙市', '1');
INSERT INTO `edu_statistic_jijiao` VALUES ('34', '2014', '8', '2', '0.0000', '3', '湘潭市', '1');
INSERT INTO `edu_statistic_jijiao` VALUES ('35', '2014', '10', '38', '0.2000', '4', '芙蓉区', '2');
INSERT INTO `edu_statistic_jijiao` VALUES ('36', '2014', '3', '10', '0.3333', '5', '天心区', '2');
INSERT INTO `edu_statistic_jijiao` VALUES ('37', '2014', '2', '7', '0.5000', '6', '望城区', '2');
INSERT INTO `edu_statistic_jijiao` VALUES ('38', '2014', '2', '4', '0.0000', '7', '雨花区', '2');
INSERT INTO `edu_statistic_jijiao` VALUES ('39', '2014', '2', '1', '0.0000', '8', '雨湖区', '3');
INSERT INTO `edu_statistic_jijiao` VALUES ('40', '2014', '2', '1', '0.0000', '9', '岳塘区', '3');
INSERT INTO `edu_statistic_jijiao` VALUES ('41', '2014', '2', '0', '0.0000', '10', '湘乡市', '3');
INSERT INTO `edu_statistic_jijiao` VALUES ('42', '2014', '2', '0', '0.0000', '11', '韶山市', '3');
INSERT INTO `edu_statistic_jijiao` VALUES ('43', '2014', '0', null, null, '14', '株洲市', '1');
INSERT INTO `edu_statistic_jijiao` VALUES ('44', '2014', '0', null, null, '15', '荷塘区', '14');
INSERT INTO `edu_statistic_jijiao` VALUES ('45', '2014', '0', null, null, '16', '石峰区', '14');
INSERT INTO `edu_statistic_jijiao` VALUES ('46', '2014', '0', null, null, '17', '邵阳市', '1');
INSERT INTO `edu_statistic_jijiao` VALUES ('47', '2014', '0', null, null, '18', '双清区', '17');
INSERT INTO `edu_statistic_jijiao` VALUES ('48', '2014', '0', null, null, '19', '北塔区', '17');

-- ----------------------------
-- Table structure for `edu_statistic_model`
-- ----------------------------
DROP TABLE IF EXISTS `edu_statistic_model`;
CREATE TABLE `edu_statistic_model` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `model_id` int(11) DEFAULT NULL COMMENT '板块id',
  `model_name` varchar(100) DEFAULT NULL COMMENT '板块名称',
  `teacher_id` int(11) DEFAULT NULL COMMENT '教师ID',
  `teacher_name` varchar(100) DEFAULT NULL COMMENT '教师姓名',
  `teacher_score` float DEFAULT NULL COMMENT '总学分,汇总板块下所有项目的学分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=73698 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of edu_statistic_model
-- ----------------------------
INSERT INTO `edu_statistic_model` VALUES ('73580', '1', '湖南省14年继教计划', '5', '李明', '8');
INSERT INTO `edu_statistic_model` VALUES ('73581', '1', '湖南省14年继教计划', '6', '高力', '7');
INSERT INTO `edu_statistic_model` VALUES ('73582', '1', '湖南省14年继教计划', '7', '李长兴', '5');
INSERT INTO `edu_statistic_model` VALUES ('73583', '1', '湖南省14年继教计划', '8', '潘钰莹', '1');
INSERT INTO `edu_statistic_model` VALUES ('73584', '1', '湖南省14年继教计划', '9', '杨伟峰', '2');
INSERT INTO `edu_statistic_model` VALUES ('73585', '1', '湖南省14年继教计划', '10', '李亚平', '0');
INSERT INTO `edu_statistic_model` VALUES ('73586', '1', '湖南省14年继教计划', '11', '李韦伯', '0');
INSERT INTO `edu_statistic_model` VALUES ('73587', '1', '湖南省14年继教计划', '12', '黄雷', '0');
INSERT INTO `edu_statistic_model` VALUES ('73588', '1', '湖南省14年继教计划', '13', '杨君', '3');
INSERT INTO `edu_statistic_model` VALUES ('73589', '1', '湖南省14年继教计划', '16', '王宁', '0');
INSERT INTO `edu_statistic_model` VALUES ('73590', '1', '湖南省14年继教计划', '17', '李军', '0');
INSERT INTO `edu_statistic_model` VALUES ('73591', '1', '湖南省14年继教计划', '18', '李明一', '0');
INSERT INTO `edu_statistic_model` VALUES ('73592', '1', '湖南省14年继教计划', '19', '高力景', '2');
INSERT INTO `edu_statistic_model` VALUES ('73593', '1', '湖南省14年继教计划', '20', '李科', '0');
INSERT INTO `edu_statistic_model` VALUES ('73594', '1', '湖南省14年继教计划', '21', '潘莹', '3');
INSERT INTO `edu_statistic_model` VALUES ('73595', '1', '湖南省14年继教计划', '22', '杨峰', '0');
INSERT INTO `edu_statistic_model` VALUES ('73596', '1', '湖南省14年继教计划', '23', '李平', '0');
INSERT INTO `edu_statistic_model` VALUES ('73597', '1', '湖南省14年继教计划', '24', '李韦', '0');
INSERT INTO `edu_statistic_model` VALUES ('73598', '1', '湖南省14年继教计划', '25', '黄雷磊', '0');
INSERT INTO `edu_statistic_model` VALUES ('73599', '1', '湖南省14年继教计划', '26', 'dean测试', '0');
INSERT INTO `edu_statistic_model` VALUES ('73600', '1', '湖南省14年继教计划', '35', '李宁波', '0');
INSERT INTO `edu_statistic_model` VALUES ('73601', '1', '湖南省14年继教计划', '36', '王鹏', '0');
INSERT INTO `edu_statistic_model` VALUES ('73602', '1', '湖南省14年继教计划', '38', '李焕', '5');
INSERT INTO `edu_statistic_model` VALUES ('73603', '1', '湖南省14年继教计划', '39', '柳宁', '0');
INSERT INTO `edu_statistic_model` VALUES ('73604', '1', '湖南省14年继教计划', '40', '邓果', '0');
INSERT INTO `edu_statistic_model` VALUES ('73611', '1', '湖南省14年继教计划', '5', '李明', '8');
INSERT INTO `edu_statistic_model` VALUES ('73612', '1', '湖南省14年继教计划', '6', '高力', '7');
INSERT INTO `edu_statistic_model` VALUES ('73613', '1', '湖南省14年继教计划', '7', '李长兴', '5');
INSERT INTO `edu_statistic_model` VALUES ('73614', '1', '湖南省14年继教计划', '8', '潘钰莹', '1');
INSERT INTO `edu_statistic_model` VALUES ('73615', '1', '湖南省14年继教计划', '9', '杨伟峰', '2');
INSERT INTO `edu_statistic_model` VALUES ('73616', '1', '湖南省14年继教计划', '10', '李亚平', '0');
INSERT INTO `edu_statistic_model` VALUES ('73617', '1', '湖南省14年继教计划', '11', '李韦伯', '0');
INSERT INTO `edu_statistic_model` VALUES ('73618', '1', '湖南省14年继教计划', '12', '黄雷', '0');
INSERT INTO `edu_statistic_model` VALUES ('73619', '1', '湖南省14年继教计划', '13', '杨君', '3');
INSERT INTO `edu_statistic_model` VALUES ('73620', '1', '湖南省14年继教计划', '16', '王宁', '0');
INSERT INTO `edu_statistic_model` VALUES ('73621', '1', '湖南省14年继教计划', '17', '李军', '0');
INSERT INTO `edu_statistic_model` VALUES ('73622', '1', '湖南省14年继教计划', '18', '李明一', '0');
INSERT INTO `edu_statistic_model` VALUES ('73623', '1', '湖南省14年继教计划', '19', '高力景', '2');
INSERT INTO `edu_statistic_model` VALUES ('73624', '1', '湖南省14年继教计划', '20', '李科', '0');
INSERT INTO `edu_statistic_model` VALUES ('73625', '1', '湖南省14年继教计划', '21', '潘莹', '3');
INSERT INTO `edu_statistic_model` VALUES ('73626', '1', '湖南省14年继教计划', '22', '杨峰', '0');
INSERT INTO `edu_statistic_model` VALUES ('73627', '1', '湖南省14年继教计划', '23', '李平', '0');
INSERT INTO `edu_statistic_model` VALUES ('73628', '1', '湖南省14年继教计划', '24', '李韦', '0');
INSERT INTO `edu_statistic_model` VALUES ('73629', '1', '湖南省14年继教计划', '25', '黄雷磊', '0');
INSERT INTO `edu_statistic_model` VALUES ('73630', '1', '湖南省14年继教计划', '26', 'dean测试', '0');
INSERT INTO `edu_statistic_model` VALUES ('73631', '1', '湖南省14年继教计划', '35', '李宁波', '0');
INSERT INTO `edu_statistic_model` VALUES ('73632', '1', '湖南省14年继教计划', '36', '王鹏', '0');
INSERT INTO `edu_statistic_model` VALUES ('73633', '1', '湖南省14年继教计划', '38', '李焕', '5');
INSERT INTO `edu_statistic_model` VALUES ('73634', '1', '湖南省14年继教计划', '39', '柳宁', '0');
INSERT INTO `edu_statistic_model` VALUES ('73635', '1', '湖南省14年继教计划', '40', '邓果', '0');
INSERT INTO `edu_statistic_model` VALUES ('73642', '2', '湖南省13年继教信息', '5', '李明', '0');
INSERT INTO `edu_statistic_model` VALUES ('73643', '2', '湖南省13年继教信息', '6', '高力', '0');
INSERT INTO `edu_statistic_model` VALUES ('73644', '2', '湖南省13年继教信息', '7', '李长兴', '0');
INSERT INTO `edu_statistic_model` VALUES ('73645', '2', '湖南省13年继教信息', '8', '潘钰莹', '0');
INSERT INTO `edu_statistic_model` VALUES ('73646', '2', '湖南省13年继教信息', '9', '杨伟峰', '0');
INSERT INTO `edu_statistic_model` VALUES ('73647', '2', '湖南省13年继教信息', '10', '李亚平', '0');
INSERT INTO `edu_statistic_model` VALUES ('73648', '2', '湖南省13年继教信息', '11', '李韦伯', '0');
INSERT INTO `edu_statistic_model` VALUES ('73649', '2', '湖南省13年继教信息', '12', '黄雷', '0');
INSERT INTO `edu_statistic_model` VALUES ('73650', '2', '湖南省13年继教信息', '13', '杨君', '0');
INSERT INTO `edu_statistic_model` VALUES ('73651', '2', '湖南省13年继教信息', '16', '王宁', '0');
INSERT INTO `edu_statistic_model` VALUES ('73652', '2', '湖南省13年继教信息', '17', '李军', '0');
INSERT INTO `edu_statistic_model` VALUES ('73653', '2', '湖南省13年继教信息', '18', '李明一', '0');
INSERT INTO `edu_statistic_model` VALUES ('73654', '2', '湖南省13年继教信息', '19', '高力景', '0');
INSERT INTO `edu_statistic_model` VALUES ('73655', '2', '湖南省13年继教信息', '20', '李科', '0');
INSERT INTO `edu_statistic_model` VALUES ('73656', '2', '湖南省13年继教信息', '21', '潘莹', '0');
INSERT INTO `edu_statistic_model` VALUES ('73657', '2', '湖南省13年继教信息', '22', '杨峰', '0');
INSERT INTO `edu_statistic_model` VALUES ('73658', '2', '湖南省13年继教信息', '23', '李平', '0');
INSERT INTO `edu_statistic_model` VALUES ('73659', '2', '湖南省13年继教信息', '24', '李韦', '0');
INSERT INTO `edu_statistic_model` VALUES ('73660', '2', '湖南省13年继教信息', '25', '黄雷磊', '0');
INSERT INTO `edu_statistic_model` VALUES ('73661', '2', '湖南省13年继教信息', '26', 'dean测试', '0');
INSERT INTO `edu_statistic_model` VALUES ('73662', '2', '湖南省13年继教信息', '35', '李宁波', '0');
INSERT INTO `edu_statistic_model` VALUES ('73663', '2', '湖南省13年继教信息', '36', '王鹏', '0');
INSERT INTO `edu_statistic_model` VALUES ('73664', '2', '湖南省13年继教信息', '38', '李焕', '0');
INSERT INTO `edu_statistic_model` VALUES ('73665', '2', '湖南省13年继教信息', '39', '柳宁', '0');
INSERT INTO `edu_statistic_model` VALUES ('73666', '2', '湖南省13年继教信息', '40', '邓果', '0');
INSERT INTO `edu_statistic_model` VALUES ('73673', '2', '湖南省13年继教信息', '5', '李明', '0');
INSERT INTO `edu_statistic_model` VALUES ('73674', '2', '湖南省13年继教信息', '6', '高力', '0');
INSERT INTO `edu_statistic_model` VALUES ('73675', '2', '湖南省13年继教信息', '7', '李长兴', '0');
INSERT INTO `edu_statistic_model` VALUES ('73676', '2', '湖南省13年继教信息', '8', '潘钰莹', '0');
INSERT INTO `edu_statistic_model` VALUES ('73677', '2', '湖南省13年继教信息', '9', '杨伟峰', '0');
INSERT INTO `edu_statistic_model` VALUES ('73678', '2', '湖南省13年继教信息', '10', '李亚平', '0');
INSERT INTO `edu_statistic_model` VALUES ('73679', '2', '湖南省13年继教信息', '11', '李韦伯', '0');
INSERT INTO `edu_statistic_model` VALUES ('73680', '2', '湖南省13年继教信息', '12', '黄雷', '0');
INSERT INTO `edu_statistic_model` VALUES ('73681', '2', '湖南省13年继教信息', '13', '杨君', '0');
INSERT INTO `edu_statistic_model` VALUES ('73682', '2', '湖南省13年继教信息', '16', '王宁', '0');
INSERT INTO `edu_statistic_model` VALUES ('73683', '2', '湖南省13年继教信息', '17', '李军', '0');
INSERT INTO `edu_statistic_model` VALUES ('73684', '2', '湖南省13年继教信息', '18', '李明一', '0');
INSERT INTO `edu_statistic_model` VALUES ('73685', '2', '湖南省13年继教信息', '19', '高力景', '0');
INSERT INTO `edu_statistic_model` VALUES ('73686', '2', '湖南省13年继教信息', '20', '李科', '0');
INSERT INTO `edu_statistic_model` VALUES ('73687', '2', '湖南省13年继教信息', '21', '潘莹', '0');
INSERT INTO `edu_statistic_model` VALUES ('73688', '2', '湖南省13年继教信息', '22', '杨峰', '0');
INSERT INTO `edu_statistic_model` VALUES ('73689', '2', '湖南省13年继教信息', '23', '李平', '0');
INSERT INTO `edu_statistic_model` VALUES ('73690', '2', '湖南省13年继教信息', '24', '李韦', '0');
INSERT INTO `edu_statistic_model` VALUES ('73691', '2', '湖南省13年继教信息', '25', '黄雷磊', '0');
INSERT INTO `edu_statistic_model` VALUES ('73692', '2', '湖南省13年继教信息', '26', 'dean测试', '0');
INSERT INTO `edu_statistic_model` VALUES ('73693', '2', '湖南省13年继教信息', '35', '李宁波', '0');
INSERT INTO `edu_statistic_model` VALUES ('73694', '2', '湖南省13年继教信息', '36', '王鹏', '0');
INSERT INTO `edu_statistic_model` VALUES ('73695', '2', '湖南省13年继教信息', '38', '李焕', '0');
INSERT INTO `edu_statistic_model` VALUES ('73696', '2', '湖南省13年继教信息', '39', '柳宁', '0');
INSERT INTO `edu_statistic_model` VALUES ('73697', '2', '湖南省13年继教信息', '40', '邓果', '0');

-- ----------------------------
-- Table structure for `edu_statistic_school`
-- ----------------------------
DROP TABLE IF EXISTS `edu_statistic_school`;
CREATE TABLE `edu_statistic_school` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num` int(11) DEFAULT NULL COMMENT '数量',
  `area_id` int(11) DEFAULT NULL COMMENT '地区ID',
  `area_name` varchar(100) DEFAULT NULL COMMENT '地区名称',
  `area_pid` int(11) DEFAULT NULL COMMENT '上级地区ID',
  `dict1_type` varchar(100) DEFAULT NULL COMMENT '字典类型',
  `dict1_id` varchar(255) DEFAULT NULL,
  `dict1_name` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=297 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of edu_statistic_school
-- ----------------------------
INSERT INTO `edu_statistic_school` VALUES ('1', '5', '1', '湖南省', '0', 'stduty_section', '1', '幼儿园');
INSERT INTO `edu_statistic_school` VALUES ('2', '3', '2', '长沙市', '1', 'stduty_section', '1', '幼儿园');
INSERT INTO `edu_statistic_school` VALUES ('3', '2', '3', '湘潭市', '1', 'stduty_section', '1', '幼儿园');
INSERT INTO `edu_statistic_school` VALUES ('4', '1', '4', '芙蓉区', '2', 'stduty_section', '1', '幼儿园');
INSERT INTO `edu_statistic_school` VALUES ('5', '1', '5', '天心区', '2', 'stduty_section', '1', '幼儿园');
INSERT INTO `edu_statistic_school` VALUES ('6', '1', '6', '望城区', '2', 'stduty_section', '1', '幼儿园');
INSERT INTO `edu_statistic_school` VALUES ('7', '0', '7', '雨花区', '2', 'stduty_section', '1', '幼儿园');
INSERT INTO `edu_statistic_school` VALUES ('8', '0', '8', '雨湖区', '3', 'stduty_section', '1', '幼儿园');
INSERT INTO `edu_statistic_school` VALUES ('9', '1', '9', '岳塘区', '3', 'stduty_section', '1', '幼儿园');
INSERT INTO `edu_statistic_school` VALUES ('10', '1', '10', '湘乡市', '3', 'stduty_section', '1', '幼儿园');
INSERT INTO `edu_statistic_school` VALUES ('11', '0', '11', '韶山市', '3', 'stduty_section', '1', '幼儿园');
INSERT INTO `edu_statistic_school` VALUES ('12', '0', '14', '株洲市', '1', 'stduty_section', '1', '幼儿园');
INSERT INTO `edu_statistic_school` VALUES ('13', '0', '15', '荷塘区', '14', 'stduty_section', '1', '幼儿园');
INSERT INTO `edu_statistic_school` VALUES ('14', '0', '16', '石峰区', '14', 'stduty_section', '1', '幼儿园');
INSERT INTO `edu_statistic_school` VALUES ('15', '0', '17', '邵阳市', '1', 'stduty_section', '1', '幼儿园');
INSERT INTO `edu_statistic_school` VALUES ('16', '0', '18', '双清区', '17', 'stduty_section', '1', '幼儿园');
INSERT INTO `edu_statistic_school` VALUES ('17', '0', '19', '北塔区', '17', 'stduty_section', '1', '幼儿园');
INSERT INTO `edu_statistic_school` VALUES ('32', '5', '1', '湖南省', '0', 'stduty_section', '1', '幼儿园');
INSERT INTO `edu_statistic_school` VALUES ('33', '3', '2', '长沙市', '1', 'stduty_section', '1', '幼儿园');
INSERT INTO `edu_statistic_school` VALUES ('34', '2', '3', '湘潭市', '1', 'stduty_section', '1', '幼儿园');
INSERT INTO `edu_statistic_school` VALUES ('35', '1', '4', '芙蓉区', '2', 'stduty_section', '1', '幼儿园');
INSERT INTO `edu_statistic_school` VALUES ('36', '1', '5', '天心区', '2', 'stduty_section', '1', '幼儿园');
INSERT INTO `edu_statistic_school` VALUES ('37', '1', '6', '望城区', '2', 'stduty_section', '1', '幼儿园');
INSERT INTO `edu_statistic_school` VALUES ('38', '0', '7', '雨花区', '2', 'stduty_section', '1', '幼儿园');
INSERT INTO `edu_statistic_school` VALUES ('39', '0', '8', '雨湖区', '3', 'stduty_section', '1', '幼儿园');
INSERT INTO `edu_statistic_school` VALUES ('40', '1', '9', '岳塘区', '3', 'stduty_section', '1', '幼儿园');
INSERT INTO `edu_statistic_school` VALUES ('41', '1', '10', '湘乡市', '3', 'stduty_section', '1', '幼儿园');
INSERT INTO `edu_statistic_school` VALUES ('42', '0', '11', '韶山市', '3', 'stduty_section', '1', '幼儿园');
INSERT INTO `edu_statistic_school` VALUES ('43', '0', '14', '株洲市', '1', 'stduty_section', '1', '幼儿园');
INSERT INTO `edu_statistic_school` VALUES ('44', '0', '15', '荷塘区', '14', 'stduty_section', '1', '幼儿园');
INSERT INTO `edu_statistic_school` VALUES ('45', '0', '16', '石峰区', '14', 'stduty_section', '1', '幼儿园');
INSERT INTO `edu_statistic_school` VALUES ('46', '0', '17', '邵阳市', '1', 'stduty_section', '1', '幼儿园');
INSERT INTO `edu_statistic_school` VALUES ('47', '0', '18', '双清区', '17', 'stduty_section', '1', '幼儿园');
INSERT INTO `edu_statistic_school` VALUES ('48', '0', '19', '北塔区', '17', 'stduty_section', '1', '幼儿园');
INSERT INTO `edu_statistic_school` VALUES ('63', '0', '1', '湖南省', '0', 'stduty_section', '3', '初中');
INSERT INTO `edu_statistic_school` VALUES ('64', '0', '2', '长沙市', '1', 'stduty_section', '3', '初中');
INSERT INTO `edu_statistic_school` VALUES ('65', '0', '3', '湘潭市', '1', 'stduty_section', '3', '初中');
INSERT INTO `edu_statistic_school` VALUES ('66', '0', '4', '芙蓉区', '2', 'stduty_section', '3', '初中');
INSERT INTO `edu_statistic_school` VALUES ('67', '0', '5', '天心区', '2', 'stduty_section', '3', '初中');
INSERT INTO `edu_statistic_school` VALUES ('68', '0', '6', '望城区', '2', 'stduty_section', '3', '初中');
INSERT INTO `edu_statistic_school` VALUES ('69', '0', '7', '雨花区', '2', 'stduty_section', '3', '初中');
INSERT INTO `edu_statistic_school` VALUES ('70', '0', '8', '雨湖区', '3', 'stduty_section', '3', '初中');
INSERT INTO `edu_statistic_school` VALUES ('71', '0', '9', '岳塘区', '3', 'stduty_section', '3', '初中');
INSERT INTO `edu_statistic_school` VALUES ('72', '0', '10', '湘乡市', '3', 'stduty_section', '3', '初中');
INSERT INTO `edu_statistic_school` VALUES ('73', '0', '11', '韶山市', '3', 'stduty_section', '3', '初中');
INSERT INTO `edu_statistic_school` VALUES ('74', '0', '14', '株洲市', '1', 'stduty_section', '3', '初中');
INSERT INTO `edu_statistic_school` VALUES ('75', '0', '15', '荷塘区', '14', 'stduty_section', '3', '初中');
INSERT INTO `edu_statistic_school` VALUES ('76', '0', '16', '石峰区', '14', 'stduty_section', '3', '初中');
INSERT INTO `edu_statistic_school` VALUES ('77', '0', '17', '邵阳市', '1', 'stduty_section', '3', '初中');
INSERT INTO `edu_statistic_school` VALUES ('78', '0', '18', '双清区', '17', 'stduty_section', '3', '初中');
INSERT INTO `edu_statistic_school` VALUES ('79', '0', '19', '北塔区', '17', 'stduty_section', '3', '初中');
INSERT INTO `edu_statistic_school` VALUES ('94', '0', '1', '湖南省', '0', 'stduty_section', '3', '初中');
INSERT INTO `edu_statistic_school` VALUES ('95', '0', '2', '长沙市', '1', 'stduty_section', '3', '初中');
INSERT INTO `edu_statistic_school` VALUES ('96', '0', '3', '湘潭市', '1', 'stduty_section', '3', '初中');
INSERT INTO `edu_statistic_school` VALUES ('97', '0', '4', '芙蓉区', '2', 'stduty_section', '3', '初中');
INSERT INTO `edu_statistic_school` VALUES ('98', '0', '5', '天心区', '2', 'stduty_section', '3', '初中');
INSERT INTO `edu_statistic_school` VALUES ('99', '0', '6', '望城区', '2', 'stduty_section', '3', '初中');
INSERT INTO `edu_statistic_school` VALUES ('100', '0', '7', '雨花区', '2', 'stduty_section', '3', '初中');
INSERT INTO `edu_statistic_school` VALUES ('101', '0', '8', '雨湖区', '3', 'stduty_section', '3', '初中');
INSERT INTO `edu_statistic_school` VALUES ('102', '0', '9', '岳塘区', '3', 'stduty_section', '3', '初中');
INSERT INTO `edu_statistic_school` VALUES ('103', '0', '10', '湘乡市', '3', 'stduty_section', '3', '初中');
INSERT INTO `edu_statistic_school` VALUES ('104', '0', '11', '韶山市', '3', 'stduty_section', '3', '初中');
INSERT INTO `edu_statistic_school` VALUES ('105', '0', '14', '株洲市', '1', 'stduty_section', '3', '初中');
INSERT INTO `edu_statistic_school` VALUES ('106', '0', '15', '荷塘区', '14', 'stduty_section', '3', '初中');
INSERT INTO `edu_statistic_school` VALUES ('107', '0', '16', '石峰区', '14', 'stduty_section', '3', '初中');
INSERT INTO `edu_statistic_school` VALUES ('108', '0', '17', '邵阳市', '1', 'stduty_section', '3', '初中');
INSERT INTO `edu_statistic_school` VALUES ('109', '0', '18', '双清区', '17', 'stduty_section', '3', '初中');
INSERT INTO `edu_statistic_school` VALUES ('110', '0', '19', '北塔区', '17', 'stduty_section', '3', '初中');
INSERT INTO `edu_statistic_school` VALUES ('125', '0', '1', '湖南省', '0', 'stduty_section', '4', '高中');
INSERT INTO `edu_statistic_school` VALUES ('126', '0', '2', '长沙市', '1', 'stduty_section', '4', '高中');
INSERT INTO `edu_statistic_school` VALUES ('127', '0', '3', '湘潭市', '1', 'stduty_section', '4', '高中');
INSERT INTO `edu_statistic_school` VALUES ('128', '0', '4', '芙蓉区', '2', 'stduty_section', '4', '高中');
INSERT INTO `edu_statistic_school` VALUES ('129', '0', '5', '天心区', '2', 'stduty_section', '4', '高中');
INSERT INTO `edu_statistic_school` VALUES ('130', '0', '6', '望城区', '2', 'stduty_section', '4', '高中');
INSERT INTO `edu_statistic_school` VALUES ('131', '0', '7', '雨花区', '2', 'stduty_section', '4', '高中');
INSERT INTO `edu_statistic_school` VALUES ('132', '0', '8', '雨湖区', '3', 'stduty_section', '4', '高中');
INSERT INTO `edu_statistic_school` VALUES ('133', '0', '9', '岳塘区', '3', 'stduty_section', '4', '高中');
INSERT INTO `edu_statistic_school` VALUES ('134', '0', '10', '湘乡市', '3', 'stduty_section', '4', '高中');
INSERT INTO `edu_statistic_school` VALUES ('135', '0', '11', '韶山市', '3', 'stduty_section', '4', '高中');
INSERT INTO `edu_statistic_school` VALUES ('136', '0', '14', '株洲市', '1', 'stduty_section', '4', '高中');
INSERT INTO `edu_statistic_school` VALUES ('137', '0', '15', '荷塘区', '14', 'stduty_section', '4', '高中');
INSERT INTO `edu_statistic_school` VALUES ('138', '0', '16', '石峰区', '14', 'stduty_section', '4', '高中');
INSERT INTO `edu_statistic_school` VALUES ('139', '0', '17', '邵阳市', '1', 'stduty_section', '4', '高中');
INSERT INTO `edu_statistic_school` VALUES ('140', '0', '18', '双清区', '17', 'stduty_section', '4', '高中');
INSERT INTO `edu_statistic_school` VALUES ('141', '0', '19', '北塔区', '17', 'stduty_section', '4', '高中');
INSERT INTO `edu_statistic_school` VALUES ('156', '0', '1', '湖南省', '0', 'stduty_section', '4', '高中');
INSERT INTO `edu_statistic_school` VALUES ('157', '0', '2', '长沙市', '1', 'stduty_section', '4', '高中');
INSERT INTO `edu_statistic_school` VALUES ('158', '0', '3', '湘潭市', '1', 'stduty_section', '4', '高中');
INSERT INTO `edu_statistic_school` VALUES ('159', '0', '4', '芙蓉区', '2', 'stduty_section', '4', '高中');
INSERT INTO `edu_statistic_school` VALUES ('160', '0', '5', '天心区', '2', 'stduty_section', '4', '高中');
INSERT INTO `edu_statistic_school` VALUES ('161', '0', '6', '望城区', '2', 'stduty_section', '4', '高中');
INSERT INTO `edu_statistic_school` VALUES ('162', '0', '7', '雨花区', '2', 'stduty_section', '4', '高中');
INSERT INTO `edu_statistic_school` VALUES ('163', '0', '8', '雨湖区', '3', 'stduty_section', '4', '高中');
INSERT INTO `edu_statistic_school` VALUES ('164', '0', '9', '岳塘区', '3', 'stduty_section', '4', '高中');
INSERT INTO `edu_statistic_school` VALUES ('165', '0', '10', '湘乡市', '3', 'stduty_section', '4', '高中');
INSERT INTO `edu_statistic_school` VALUES ('166', '0', '11', '韶山市', '3', 'stduty_section', '4', '高中');
INSERT INTO `edu_statistic_school` VALUES ('167', '0', '14', '株洲市', '1', 'stduty_section', '4', '高中');
INSERT INTO `edu_statistic_school` VALUES ('168', '0', '15', '荷塘区', '14', 'stduty_section', '4', '高中');
INSERT INTO `edu_statistic_school` VALUES ('169', '0', '16', '石峰区', '14', 'stduty_section', '4', '高中');
INSERT INTO `edu_statistic_school` VALUES ('170', '0', '17', '邵阳市', '1', 'stduty_section', '4', '高中');
INSERT INTO `edu_statistic_school` VALUES ('171', '0', '18', '双清区', '17', 'stduty_section', '4', '高中');
INSERT INTO `edu_statistic_school` VALUES ('172', '0', '19', '北塔区', '17', 'stduty_section', '4', '高中');
INSERT INTO `edu_statistic_school` VALUES ('187', '0', '1', '湖南省', '0', 'stduty_section', '6', '小学');
INSERT INTO `edu_statistic_school` VALUES ('188', '0', '2', '长沙市', '1', 'stduty_section', '6', '小学');
INSERT INTO `edu_statistic_school` VALUES ('189', '0', '3', '湘潭市', '1', 'stduty_section', '6', '小学');
INSERT INTO `edu_statistic_school` VALUES ('190', '0', '4', '芙蓉区', '2', 'stduty_section', '6', '小学');
INSERT INTO `edu_statistic_school` VALUES ('191', '0', '5', '天心区', '2', 'stduty_section', '6', '小学');
INSERT INTO `edu_statistic_school` VALUES ('192', '0', '6', '望城区', '2', 'stduty_section', '6', '小学');
INSERT INTO `edu_statistic_school` VALUES ('193', '0', '7', '雨花区', '2', 'stduty_section', '6', '小学');
INSERT INTO `edu_statistic_school` VALUES ('194', '0', '8', '雨湖区', '3', 'stduty_section', '6', '小学');
INSERT INTO `edu_statistic_school` VALUES ('195', '0', '9', '岳塘区', '3', 'stduty_section', '6', '小学');
INSERT INTO `edu_statistic_school` VALUES ('196', '0', '10', '湘乡市', '3', 'stduty_section', '6', '小学');
INSERT INTO `edu_statistic_school` VALUES ('197', '0', '11', '韶山市', '3', 'stduty_section', '6', '小学');
INSERT INTO `edu_statistic_school` VALUES ('198', '0', '14', '株洲市', '1', 'stduty_section', '6', '小学');
INSERT INTO `edu_statistic_school` VALUES ('199', '0', '15', '荷塘区', '14', 'stduty_section', '6', '小学');
INSERT INTO `edu_statistic_school` VALUES ('200', '0', '16', '石峰区', '14', 'stduty_section', '6', '小学');
INSERT INTO `edu_statistic_school` VALUES ('201', '0', '17', '邵阳市', '1', 'stduty_section', '6', '小学');
INSERT INTO `edu_statistic_school` VALUES ('202', '0', '18', '双清区', '17', 'stduty_section', '6', '小学');
INSERT INTO `edu_statistic_school` VALUES ('203', '0', '19', '北塔区', '17', 'stduty_section', '6', '小学');
INSERT INTO `edu_statistic_school` VALUES ('218', '0', '1', '湖南省', '0', 'stduty_section', '6', '小学');
INSERT INTO `edu_statistic_school` VALUES ('219', '0', '2', '长沙市', '1', 'stduty_section', '6', '小学');
INSERT INTO `edu_statistic_school` VALUES ('220', '0', '3', '湘潭市', '1', 'stduty_section', '6', '小学');
INSERT INTO `edu_statistic_school` VALUES ('221', '0', '4', '芙蓉区', '2', 'stduty_section', '6', '小学');
INSERT INTO `edu_statistic_school` VALUES ('222', '0', '5', '天心区', '2', 'stduty_section', '6', '小学');
INSERT INTO `edu_statistic_school` VALUES ('223', '0', '6', '望城区', '2', 'stduty_section', '6', '小学');
INSERT INTO `edu_statistic_school` VALUES ('224', '0', '7', '雨花区', '2', 'stduty_section', '6', '小学');
INSERT INTO `edu_statistic_school` VALUES ('225', '0', '8', '雨湖区', '3', 'stduty_section', '6', '小学');
INSERT INTO `edu_statistic_school` VALUES ('226', '0', '9', '岳塘区', '3', 'stduty_section', '6', '小学');
INSERT INTO `edu_statistic_school` VALUES ('227', '0', '10', '湘乡市', '3', 'stduty_section', '6', '小学');
INSERT INTO `edu_statistic_school` VALUES ('228', '0', '11', '韶山市', '3', 'stduty_section', '6', '小学');
INSERT INTO `edu_statistic_school` VALUES ('229', '0', '14', '株洲市', '1', 'stduty_section', '6', '小学');
INSERT INTO `edu_statistic_school` VALUES ('230', '0', '15', '荷塘区', '14', 'stduty_section', '6', '小学');
INSERT INTO `edu_statistic_school` VALUES ('231', '0', '16', '石峰区', '14', 'stduty_section', '6', '小学');
INSERT INTO `edu_statistic_school` VALUES ('232', '0', '17', '邵阳市', '1', 'stduty_section', '6', '小学');
INSERT INTO `edu_statistic_school` VALUES ('233', '0', '18', '双清区', '17', 'stduty_section', '6', '小学');
INSERT INTO `edu_statistic_school` VALUES ('234', '0', '19', '北塔区', '17', 'stduty_section', '6', '小学');
INSERT INTO `edu_statistic_school` VALUES ('249', '0', '1', '湖南省', '0', 'stduty_section', '8', '职高');
INSERT INTO `edu_statistic_school` VALUES ('250', '0', '2', '长沙市', '1', 'stduty_section', '8', '职高');
INSERT INTO `edu_statistic_school` VALUES ('251', '0', '3', '湘潭市', '1', 'stduty_section', '8', '职高');
INSERT INTO `edu_statistic_school` VALUES ('252', '0', '4', '芙蓉区', '2', 'stduty_section', '8', '职高');
INSERT INTO `edu_statistic_school` VALUES ('253', '0', '5', '天心区', '2', 'stduty_section', '8', '职高');
INSERT INTO `edu_statistic_school` VALUES ('254', '0', '6', '望城区', '2', 'stduty_section', '8', '职高');
INSERT INTO `edu_statistic_school` VALUES ('255', '0', '7', '雨花区', '2', 'stduty_section', '8', '职高');
INSERT INTO `edu_statistic_school` VALUES ('256', '0', '8', '雨湖区', '3', 'stduty_section', '8', '职高');
INSERT INTO `edu_statistic_school` VALUES ('257', '0', '9', '岳塘区', '3', 'stduty_section', '8', '职高');
INSERT INTO `edu_statistic_school` VALUES ('258', '0', '10', '湘乡市', '3', 'stduty_section', '8', '职高');
INSERT INTO `edu_statistic_school` VALUES ('259', '0', '11', '韶山市', '3', 'stduty_section', '8', '职高');
INSERT INTO `edu_statistic_school` VALUES ('260', '0', '14', '株洲市', '1', 'stduty_section', '8', '职高');
INSERT INTO `edu_statistic_school` VALUES ('261', '0', '15', '荷塘区', '14', 'stduty_section', '8', '职高');
INSERT INTO `edu_statistic_school` VALUES ('262', '0', '16', '石峰区', '14', 'stduty_section', '8', '职高');
INSERT INTO `edu_statistic_school` VALUES ('263', '0', '17', '邵阳市', '1', 'stduty_section', '8', '职高');
INSERT INTO `edu_statistic_school` VALUES ('264', '0', '18', '双清区', '17', 'stduty_section', '8', '职高');
INSERT INTO `edu_statistic_school` VALUES ('265', '0', '19', '北塔区', '17', 'stduty_section', '8', '职高');
INSERT INTO `edu_statistic_school` VALUES ('280', '0', '1', '湖南省', '0', 'stduty_section', '8', '职高');
INSERT INTO `edu_statistic_school` VALUES ('281', '0', '2', '长沙市', '1', 'stduty_section', '8', '职高');
INSERT INTO `edu_statistic_school` VALUES ('282', '0', '3', '湘潭市', '1', 'stduty_section', '8', '职高');
INSERT INTO `edu_statistic_school` VALUES ('283', '0', '4', '芙蓉区', '2', 'stduty_section', '8', '职高');
INSERT INTO `edu_statistic_school` VALUES ('284', '0', '5', '天心区', '2', 'stduty_section', '8', '职高');
INSERT INTO `edu_statistic_school` VALUES ('285', '0', '6', '望城区', '2', 'stduty_section', '8', '职高');
INSERT INTO `edu_statistic_school` VALUES ('286', '0', '7', '雨花区', '2', 'stduty_section', '8', '职高');
INSERT INTO `edu_statistic_school` VALUES ('287', '0', '8', '雨湖区', '3', 'stduty_section', '8', '职高');
INSERT INTO `edu_statistic_school` VALUES ('288', '0', '9', '岳塘区', '3', 'stduty_section', '8', '职高');
INSERT INTO `edu_statistic_school` VALUES ('289', '0', '10', '湘乡市', '3', 'stduty_section', '8', '职高');
INSERT INTO `edu_statistic_school` VALUES ('290', '0', '11', '韶山市', '3', 'stduty_section', '8', '职高');
INSERT INTO `edu_statistic_school` VALUES ('291', '0', '14', '株洲市', '1', 'stduty_section', '8', '职高');
INSERT INTO `edu_statistic_school` VALUES ('292', '0', '15', '荷塘区', '14', 'stduty_section', '8', '职高');
INSERT INTO `edu_statistic_school` VALUES ('293', '0', '16', '石峰区', '14', 'stduty_section', '8', '职高');
INSERT INTO `edu_statistic_school` VALUES ('294', '0', '17', '邵阳市', '1', 'stduty_section', '8', '职高');
INSERT INTO `edu_statistic_school` VALUES ('295', '0', '18', '双清区', '17', 'stduty_section', '8', '职高');
INSERT INTO `edu_statistic_school` VALUES ('296', '0', '19', '北塔区', '17', 'stduty_section', '8', '职高');

-- ----------------------------
-- Table structure for `edu_statistic_teacher`
-- ----------------------------
DROP TABLE IF EXISTS `edu_statistic_teacher`;
CREATE TABLE `edu_statistic_teacher` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `num` int(11) DEFAULT NULL,
  `type` char(1) DEFAULT '0' COMMENT '0为地区，1为字典',
  `dict1_pid` int(11) DEFAULT NULL,
  `dict1_type` varchar(100) DEFAULT NULL COMMENT '字典类型',
  `dict1_id` varchar(255) DEFAULT NULL,
  `dict1_name` varchar(11) DEFAULT NULL,
  `dict2_type` varchar(100) DEFAULT NULL COMMENT '字典2类型',
  `dict2_id` int(11) DEFAULT NULL,
  `dict2_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2191 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of edu_statistic_teacher
-- ----------------------------
INSERT INTO `edu_statistic_teacher` VALUES ('1', '0', '1', null, 'stduty_section', '1', '幼儿园', 'educational_user', '3', '初中');
INSERT INTO `edu_statistic_teacher` VALUES ('2', '0', '1', null, 'stduty_section', '3', '初中', 'educational_user', '3', '初中');
INSERT INTO `edu_statistic_teacher` VALUES ('3', '0', '1', null, 'stduty_section', '4', '高中', 'educational_user', '3', '初中');
INSERT INTO `edu_statistic_teacher` VALUES ('4', '0', '1', null, 'stduty_section', '6', '小学', 'educational_user', '3', '初中');
INSERT INTO `edu_statistic_teacher` VALUES ('5', '0', '1', null, 'stduty_section', '8', '职高', 'educational_user', '3', '初中');
INSERT INTO `edu_statistic_teacher` VALUES ('8', '0', '1', null, 'stduty_section', '1', '幼儿园', 'educational_user', '3', '初中');
INSERT INTO `edu_statistic_teacher` VALUES ('9', '0', '1', null, 'stduty_section', '3', '初中', 'educational_user', '3', '初中');
INSERT INTO `edu_statistic_teacher` VALUES ('10', '0', '1', null, 'stduty_section', '4', '高中', 'educational_user', '3', '初中');
INSERT INTO `edu_statistic_teacher` VALUES ('11', '0', '1', null, 'stduty_section', '6', '小学', 'educational_user', '3', '初中');
INSERT INTO `edu_statistic_teacher` VALUES ('12', '0', '1', null, 'stduty_section', '8', '职高', 'educational_user', '3', '初中');
INSERT INTO `edu_statistic_teacher` VALUES ('15', '0', '1', null, 'stduty_section', '1', '幼儿园', 'educational_user', '4', '高中');
INSERT INTO `edu_statistic_teacher` VALUES ('16', '0', '1', null, 'stduty_section', '3', '初中', 'educational_user', '4', '高中');
INSERT INTO `edu_statistic_teacher` VALUES ('17', '0', '1', null, 'stduty_section', '4', '高中', 'educational_user', '4', '高中');
INSERT INTO `edu_statistic_teacher` VALUES ('18', '0', '1', null, 'stduty_section', '6', '小学', 'educational_user', '4', '高中');
INSERT INTO `edu_statistic_teacher` VALUES ('19', '0', '1', null, 'stduty_section', '8', '职高', 'educational_user', '4', '高中');
INSERT INTO `edu_statistic_teacher` VALUES ('22', '0', '1', null, 'stduty_section', '1', '幼儿园', 'educational_user', '4', '高中');
INSERT INTO `edu_statistic_teacher` VALUES ('23', '0', '1', null, 'stduty_section', '3', '初中', 'educational_user', '4', '高中');
INSERT INTO `edu_statistic_teacher` VALUES ('24', '0', '1', null, 'stduty_section', '4', '高中', 'educational_user', '4', '高中');
INSERT INTO `edu_statistic_teacher` VALUES ('25', '0', '1', null, 'stduty_section', '6', '小学', 'educational_user', '4', '高中');
INSERT INTO `edu_statistic_teacher` VALUES ('26', '0', '1', null, 'stduty_section', '8', '职高', 'educational_user', '4', '高中');
INSERT INTO `edu_statistic_teacher` VALUES ('29', '0', '1', null, 'stduty_section', '1', '幼儿园', 'educational_user', '5', '中专');
INSERT INTO `edu_statistic_teacher` VALUES ('30', '0', '1', null, 'stduty_section', '3', '初中', 'educational_user', '5', '中专');
INSERT INTO `edu_statistic_teacher` VALUES ('31', '0', '1', null, 'stduty_section', '4', '高中', 'educational_user', '5', '中专');
INSERT INTO `edu_statistic_teacher` VALUES ('32', '63', '1', null, 'stduty_section', '6', '小学', 'educational_user', '5', '中专');
INSERT INTO `edu_statistic_teacher` VALUES ('33', '0', '1', null, 'stduty_section', '8', '职高', 'educational_user', '5', '中专');
INSERT INTO `edu_statistic_teacher` VALUES ('36', '0', '1', null, 'stduty_section', '1', '幼儿园', 'educational_user', '5', '中专');
INSERT INTO `edu_statistic_teacher` VALUES ('37', '0', '1', null, 'stduty_section', '3', '初中', 'educational_user', '5', '中专');
INSERT INTO `edu_statistic_teacher` VALUES ('38', '0', '1', null, 'stduty_section', '4', '高中', 'educational_user', '5', '中专');
INSERT INTO `edu_statistic_teacher` VALUES ('39', '63', '1', null, 'stduty_section', '6', '小学', 'educational_user', '5', '中专');
INSERT INTO `edu_statistic_teacher` VALUES ('40', '0', '1', null, 'stduty_section', '8', '职高', 'educational_user', '5', '中专');
INSERT INTO `edu_statistic_teacher` VALUES ('43', '0', '1', null, 'stduty_section', '1', '幼儿园', 'educational_user', '6', '大专');
INSERT INTO `edu_statistic_teacher` VALUES ('44', '18', '1', null, 'stduty_section', '3', '初中', 'educational_user', '6', '大专');
INSERT INTO `edu_statistic_teacher` VALUES ('45', '0', '1', null, 'stduty_section', '4', '高中', 'educational_user', '6', '大专');
INSERT INTO `edu_statistic_teacher` VALUES ('46', '12', '1', null, 'stduty_section', '6', '小学', 'educational_user', '6', '大专');
INSERT INTO `edu_statistic_teacher` VALUES ('47', '0', '1', null, 'stduty_section', '8', '职高', 'educational_user', '6', '大专');
INSERT INTO `edu_statistic_teacher` VALUES ('50', '0', '1', null, 'stduty_section', '1', '幼儿园', 'educational_user', '6', '大专');
INSERT INTO `edu_statistic_teacher` VALUES ('51', '18', '1', null, 'stduty_section', '3', '初中', 'educational_user', '6', '大专');
INSERT INTO `edu_statistic_teacher` VALUES ('52', '0', '1', null, 'stduty_section', '4', '高中', 'educational_user', '6', '大专');
INSERT INTO `edu_statistic_teacher` VALUES ('53', '12', '1', null, 'stduty_section', '6', '小学', 'educational_user', '6', '大专');
INSERT INTO `edu_statistic_teacher` VALUES ('54', '0', '1', null, 'stduty_section', '8', '职高', 'educational_user', '6', '大专');
INSERT INTO `edu_statistic_teacher` VALUES ('57', '0', '1', null, 'stduty_section', '1', '幼儿园', 'educational_user', '7', '本科');
INSERT INTO `edu_statistic_teacher` VALUES ('58', '0', '1', null, 'stduty_section', '3', '初中', 'educational_user', '7', '本科');
INSERT INTO `edu_statistic_teacher` VALUES ('59', '0', '1', null, 'stduty_section', '4', '高中', 'educational_user', '7', '本科');
INSERT INTO `edu_statistic_teacher` VALUES ('60', '1', '1', null, 'stduty_section', '6', '小学', 'educational_user', '7', '本科');
INSERT INTO `edu_statistic_teacher` VALUES ('61', '0', '1', null, 'stduty_section', '8', '职高', 'educational_user', '7', '本科');
INSERT INTO `edu_statistic_teacher` VALUES ('64', '0', '1', null, 'stduty_section', '1', '幼儿园', 'educational_user', '7', '本科');
INSERT INTO `edu_statistic_teacher` VALUES ('65', '0', '1', null, 'stduty_section', '3', '初中', 'educational_user', '7', '本科');
INSERT INTO `edu_statistic_teacher` VALUES ('66', '0', '1', null, 'stduty_section', '4', '高中', 'educational_user', '7', '本科');
INSERT INTO `edu_statistic_teacher` VALUES ('67', '1', '1', null, 'stduty_section', '6', '小学', 'educational_user', '7', '本科');
INSERT INTO `edu_statistic_teacher` VALUES ('68', '0', '1', null, 'stduty_section', '8', '职高', 'educational_user', '7', '本科');
INSERT INTO `edu_statistic_teacher` VALUES ('71', '0', '1', null, 'stduty_section', '1', '幼儿园', 'educational_user', '8', '硕士研究生');
INSERT INTO `edu_statistic_teacher` VALUES ('72', '0', '1', null, 'stduty_section', '3', '初中', 'educational_user', '8', '硕士研究生');
INSERT INTO `edu_statistic_teacher` VALUES ('73', '0', '1', null, 'stduty_section', '4', '高中', 'educational_user', '8', '硕士研究生');
INSERT INTO `edu_statistic_teacher` VALUES ('74', '0', '1', null, 'stduty_section', '6', '小学', 'educational_user', '8', '硕士研究生');
INSERT INTO `edu_statistic_teacher` VALUES ('75', '0', '1', null, 'stduty_section', '8', '职高', 'educational_user', '8', '硕士研究生');
INSERT INTO `edu_statistic_teacher` VALUES ('78', '0', '1', null, 'stduty_section', '1', '幼儿园', 'educational_user', '8', '硕士研究生');
INSERT INTO `edu_statistic_teacher` VALUES ('79', '0', '1', null, 'stduty_section', '3', '初中', 'educational_user', '8', '硕士研究生');
INSERT INTO `edu_statistic_teacher` VALUES ('80', '0', '1', null, 'stduty_section', '4', '高中', 'educational_user', '8', '硕士研究生');
INSERT INTO `edu_statistic_teacher` VALUES ('81', '0', '1', null, 'stduty_section', '6', '小学', 'educational_user', '8', '硕士研究生');
INSERT INTO `edu_statistic_teacher` VALUES ('82', '0', '1', null, 'stduty_section', '8', '职高', 'educational_user', '8', '硕士研究生');
INSERT INTO `edu_statistic_teacher` VALUES ('85', '0', '1', null, 'stduty_section', '1', '幼儿园', 'educational_user', '9', '博士');
INSERT INTO `edu_statistic_teacher` VALUES ('86', '0', '1', null, 'stduty_section', '3', '初中', 'educational_user', '9', '博士');
INSERT INTO `edu_statistic_teacher` VALUES ('87', '0', '1', null, 'stduty_section', '4', '高中', 'educational_user', '9', '博士');
INSERT INTO `edu_statistic_teacher` VALUES ('88', '9', '1', null, 'stduty_section', '6', '小学', 'educational_user', '9', '博士');
INSERT INTO `edu_statistic_teacher` VALUES ('89', '0', '1', null, 'stduty_section', '8', '职高', 'educational_user', '9', '博士');
INSERT INTO `edu_statistic_teacher` VALUES ('92', '0', '1', null, 'stduty_section', '1', '幼儿园', 'educational_user', '9', '博士');
INSERT INTO `edu_statistic_teacher` VALUES ('93', '0', '1', null, 'stduty_section', '3', '初中', 'educational_user', '9', '博士');
INSERT INTO `edu_statistic_teacher` VALUES ('94', '0', '1', null, 'stduty_section', '4', '高中', 'educational_user', '9', '博士');
INSERT INTO `edu_statistic_teacher` VALUES ('95', '9', '1', null, 'stduty_section', '6', '小学', 'educational_user', '9', '博士');
INSERT INTO `edu_statistic_teacher` VALUES ('96', '0', '1', null, 'stduty_section', '8', '职高', 'educational_user', '9', '博士');
INSERT INTO `edu_statistic_teacher` VALUES ('99', '0', '1', null, 'stduty_section', '1', '幼儿园', 'educational_user', '10', '博士后');
INSERT INTO `edu_statistic_teacher` VALUES ('100', '0', '1', null, 'stduty_section', '3', '初中', 'educational_user', '10', '博士后');
INSERT INTO `edu_statistic_teacher` VALUES ('101', '0', '1', null, 'stduty_section', '4', '高中', 'educational_user', '10', '博士后');
INSERT INTO `edu_statistic_teacher` VALUES ('102', '0', '1', null, 'stduty_section', '6', '小学', 'educational_user', '10', '博士后');
INSERT INTO `edu_statistic_teacher` VALUES ('103', '0', '1', null, 'stduty_section', '8', '职高', 'educational_user', '10', '博士后');
INSERT INTO `edu_statistic_teacher` VALUES ('106', '0', '1', null, 'stduty_section', '1', '幼儿园', 'educational_user', '10', '博士后');
INSERT INTO `edu_statistic_teacher` VALUES ('107', '0', '1', null, 'stduty_section', '3', '初中', 'educational_user', '10', '博士后');
INSERT INTO `edu_statistic_teacher` VALUES ('108', '0', '1', null, 'stduty_section', '4', '高中', 'educational_user', '10', '博士后');
INSERT INTO `edu_statistic_teacher` VALUES ('109', '0', '1', null, 'stduty_section', '6', '小学', 'educational_user', '10', '博士后');
INSERT INTO `edu_statistic_teacher` VALUES ('110', '0', '1', null, 'stduty_section', '8', '职高', 'educational_user', '10', '博士后');
INSERT INTO `edu_statistic_teacher` VALUES ('113', '0', '1', null, 'stduty_section', '1', '幼儿园', 'project_subject', '3', '小学美术');
INSERT INTO `edu_statistic_teacher` VALUES ('114', '18', '1', null, 'stduty_section', '3', '初中', 'project_subject', '3', '小学美术');
INSERT INTO `edu_statistic_teacher` VALUES ('115', '0', '1', null, 'stduty_section', '4', '高中', 'project_subject', '3', '小学美术');
INSERT INTO `edu_statistic_teacher` VALUES ('116', '0', '1', null, 'stduty_section', '6', '小学', 'project_subject', '3', '小学美术');
INSERT INTO `edu_statistic_teacher` VALUES ('117', '0', '1', null, 'stduty_section', '8', '职高', 'project_subject', '3', '小学美术');
INSERT INTO `edu_statistic_teacher` VALUES ('120', '0', '1', null, 'stduty_section', '1', '幼儿园', 'project_subject', '3', '小学美术');
INSERT INTO `edu_statistic_teacher` VALUES ('121', '18', '1', null, 'stduty_section', '3', '初中', 'project_subject', '3', '小学美术');
INSERT INTO `edu_statistic_teacher` VALUES ('122', '0', '1', null, 'stduty_section', '4', '高中', 'project_subject', '3', '小学美术');
INSERT INTO `edu_statistic_teacher` VALUES ('123', '0', '1', null, 'stduty_section', '6', '小学', 'project_subject', '3', '小学美术');
INSERT INTO `edu_statistic_teacher` VALUES ('124', '0', '1', null, 'stduty_section', '8', '职高', 'project_subject', '3', '小学美术');
INSERT INTO `edu_statistic_teacher` VALUES ('127', '0', '1', null, 'stduty_section', '1', '幼儿园', 'project_subject', '4', '小学音乐');
INSERT INTO `edu_statistic_teacher` VALUES ('128', '0', '1', null, 'stduty_section', '3', '初中', 'project_subject', '4', '小学音乐');
INSERT INTO `edu_statistic_teacher` VALUES ('129', '3', '1', null, 'stduty_section', '4', '高中', 'project_subject', '4', '小学音乐');
INSERT INTO `edu_statistic_teacher` VALUES ('130', '0', '1', null, 'stduty_section', '6', '小学', 'project_subject', '4', '小学音乐');
INSERT INTO `edu_statistic_teacher` VALUES ('131', '0', '1', null, 'stduty_section', '8', '职高', 'project_subject', '4', '小学音乐');
INSERT INTO `edu_statistic_teacher` VALUES ('134', '0', '1', null, 'stduty_section', '1', '幼儿园', 'project_subject', '4', '小学音乐');
INSERT INTO `edu_statistic_teacher` VALUES ('135', '0', '1', null, 'stduty_section', '3', '初中', 'project_subject', '4', '小学音乐');
INSERT INTO `edu_statistic_teacher` VALUES ('136', '3', '1', null, 'stduty_section', '4', '高中', 'project_subject', '4', '小学音乐');
INSERT INTO `edu_statistic_teacher` VALUES ('137', '0', '1', null, 'stduty_section', '6', '小学', 'project_subject', '4', '小学音乐');
INSERT INTO `edu_statistic_teacher` VALUES ('138', '0', '1', null, 'stduty_section', '8', '职高', 'project_subject', '4', '小学音乐');
INSERT INTO `edu_statistic_teacher` VALUES ('141', '0', '1', null, 'stduty_section', '1', '幼儿园', 'project_subject', '5', '初中语文');
INSERT INTO `edu_statistic_teacher` VALUES ('142', '0', '1', null, 'stduty_section', '3', '初中', 'project_subject', '5', '初中语文');
INSERT INTO `edu_statistic_teacher` VALUES ('143', '0', '1', null, 'stduty_section', '4', '高中', 'project_subject', '5', '初中语文');
INSERT INTO `edu_statistic_teacher` VALUES ('144', '0', '1', null, 'stduty_section', '6', '小学', 'project_subject', '5', '初中语文');
INSERT INTO `edu_statistic_teacher` VALUES ('145', '0', '1', null, 'stduty_section', '8', '职高', 'project_subject', '5', '初中语文');
INSERT INTO `edu_statistic_teacher` VALUES ('148', '0', '1', null, 'stduty_section', '1', '幼儿园', 'project_subject', '5', '初中语文');
INSERT INTO `edu_statistic_teacher` VALUES ('149', '0', '1', null, 'stduty_section', '3', '初中', 'project_subject', '5', '初中语文');
INSERT INTO `edu_statistic_teacher` VALUES ('150', '0', '1', null, 'stduty_section', '4', '高中', 'project_subject', '5', '初中语文');
INSERT INTO `edu_statistic_teacher` VALUES ('151', '0', '1', null, 'stduty_section', '6', '小学', 'project_subject', '5', '初中语文');
INSERT INTO `edu_statistic_teacher` VALUES ('152', '0', '1', null, 'stduty_section', '8', '职高', 'project_subject', '5', '初中语文');
INSERT INTO `edu_statistic_teacher` VALUES ('155', '0', '1', null, 'stduty_section', '1', '幼儿园', 'project_subject', '6', '初中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('156', '0', '1', null, 'stduty_section', '3', '初中', 'project_subject', '6', '初中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('157', '0', '1', null, 'stduty_section', '4', '高中', 'project_subject', '6', '初中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('158', '5', '1', null, 'stduty_section', '6', '小学', 'project_subject', '6', '初中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('159', '0', '1', null, 'stduty_section', '8', '职高', 'project_subject', '6', '初中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('162', '0', '1', null, 'stduty_section', '1', '幼儿园', 'project_subject', '6', '初中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('163', '0', '1', null, 'stduty_section', '3', '初中', 'project_subject', '6', '初中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('164', '0', '1', null, 'stduty_section', '4', '高中', 'project_subject', '6', '初中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('165', '5', '1', null, 'stduty_section', '6', '小学', 'project_subject', '6', '初中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('166', '0', '1', null, 'stduty_section', '8', '职高', 'project_subject', '6', '初中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('169', '0', '1', null, 'stduty_section', '1', '幼儿园', 'project_subject', '7', '初中物理');
INSERT INTO `edu_statistic_teacher` VALUES ('170', '0', '1', null, 'stduty_section', '3', '初中', 'project_subject', '7', '初中物理');
INSERT INTO `edu_statistic_teacher` VALUES ('171', '0', '1', null, 'stduty_section', '4', '高中', 'project_subject', '7', '初中物理');
INSERT INTO `edu_statistic_teacher` VALUES ('172', '0', '1', null, 'stduty_section', '6', '小学', 'project_subject', '7', '初中物理');
INSERT INTO `edu_statistic_teacher` VALUES ('173', '0', '1', null, 'stduty_section', '8', '职高', 'project_subject', '7', '初中物理');
INSERT INTO `edu_statistic_teacher` VALUES ('176', '0', '1', null, 'stduty_section', '1', '幼儿园', 'project_subject', '7', '初中物理');
INSERT INTO `edu_statistic_teacher` VALUES ('177', '0', '1', null, 'stduty_section', '3', '初中', 'project_subject', '7', '初中物理');
INSERT INTO `edu_statistic_teacher` VALUES ('178', '0', '1', null, 'stduty_section', '4', '高中', 'project_subject', '7', '初中物理');
INSERT INTO `edu_statistic_teacher` VALUES ('179', '0', '1', null, 'stduty_section', '6', '小学', 'project_subject', '7', '初中物理');
INSERT INTO `edu_statistic_teacher` VALUES ('180', '0', '1', null, 'stduty_section', '8', '职高', 'project_subject', '7', '初中物理');
INSERT INTO `edu_statistic_teacher` VALUES ('183', '0', '1', null, 'stduty_section', '1', '幼儿园', 'project_subject', '8', '小学语文');
INSERT INTO `edu_statistic_teacher` VALUES ('184', '18', '1', null, 'stduty_section', '3', '初中', 'project_subject', '8', '小学语文');
INSERT INTO `edu_statistic_teacher` VALUES ('185', '3', '1', null, 'stduty_section', '4', '高中', 'project_subject', '8', '小学语文');
INSERT INTO `edu_statistic_teacher` VALUES ('186', '1', '1', null, 'stduty_section', '6', '小学', 'project_subject', '8', '小学语文');
INSERT INTO `edu_statistic_teacher` VALUES ('187', '37', '1', null, 'stduty_section', '8', '职高', 'project_subject', '8', '小学语文');
INSERT INTO `edu_statistic_teacher` VALUES ('190', '0', '1', null, 'stduty_section', '1', '幼儿园', 'project_subject', '8', '小学语文');
INSERT INTO `edu_statistic_teacher` VALUES ('191', '18', '1', null, 'stduty_section', '3', '初中', 'project_subject', '8', '小学语文');
INSERT INTO `edu_statistic_teacher` VALUES ('192', '3', '1', null, 'stduty_section', '4', '高中', 'project_subject', '8', '小学语文');
INSERT INTO `edu_statistic_teacher` VALUES ('193', '1', '1', null, 'stduty_section', '6', '小学', 'project_subject', '8', '小学语文');
INSERT INTO `edu_statistic_teacher` VALUES ('194', '37', '1', null, 'stduty_section', '8', '职高', 'project_subject', '8', '小学语文');
INSERT INTO `edu_statistic_teacher` VALUES ('197', '0', '1', null, 'stduty_section', '1', '幼儿园', 'project_subject', '9', '小学数学');
INSERT INTO `edu_statistic_teacher` VALUES ('198', '0', '1', null, 'stduty_section', '3', '初中', 'project_subject', '9', '小学数学');
INSERT INTO `edu_statistic_teacher` VALUES ('199', '0', '1', null, 'stduty_section', '4', '高中', 'project_subject', '9', '小学数学');
INSERT INTO `edu_statistic_teacher` VALUES ('200', '0', '1', null, 'stduty_section', '6', '小学', 'project_subject', '9', '小学数学');
INSERT INTO `edu_statistic_teacher` VALUES ('201', '4', '1', null, 'stduty_section', '8', '职高', 'project_subject', '9', '小学数学');
INSERT INTO `edu_statistic_teacher` VALUES ('204', '0', '1', null, 'stduty_section', '1', '幼儿园', 'project_subject', '9', '小学数学');
INSERT INTO `edu_statistic_teacher` VALUES ('205', '0', '1', null, 'stduty_section', '3', '初中', 'project_subject', '9', '小学数学');
INSERT INTO `edu_statistic_teacher` VALUES ('206', '0', '1', null, 'stduty_section', '4', '高中', 'project_subject', '9', '小学数学');
INSERT INTO `edu_statistic_teacher` VALUES ('207', '0', '1', null, 'stduty_section', '6', '小学', 'project_subject', '9', '小学数学');
INSERT INTO `edu_statistic_teacher` VALUES ('208', '4', '1', null, 'stduty_section', '8', '职高', 'project_subject', '9', '小学数学');
INSERT INTO `edu_statistic_teacher` VALUES ('211', '0', '1', null, 'stduty_section', '1', '幼儿园', 'project_subject', '10', '高中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('212', '0', '1', null, 'stduty_section', '3', '初中', 'project_subject', '10', '高中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('213', '0', '1', null, 'stduty_section', '4', '高中', 'project_subject', '10', '高中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('214', '0', '1', null, 'stduty_section', '6', '小学', 'project_subject', '10', '高中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('215', '0', '1', null, 'stduty_section', '8', '职高', 'project_subject', '10', '高中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('218', '0', '1', null, 'stduty_section', '1', '幼儿园', 'project_subject', '10', '高中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('219', '0', '1', null, 'stduty_section', '3', '初中', 'project_subject', '10', '高中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('220', '0', '1', null, 'stduty_section', '4', '高中', 'project_subject', '10', '高中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('221', '0', '1', null, 'stduty_section', '6', '小学', 'project_subject', '10', '高中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('222', '0', '1', null, 'stduty_section', '8', '职高', 'project_subject', '10', '高中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('225', '0', '1', null, 'stduty_section', '1', '幼儿园', 'teacher_professional', '2', '高级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('226', '1', '1', null, 'stduty_section', '3', '初中', 'teacher_professional', '2', '高级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('227', '1', '1', null, 'stduty_section', '4', '高中', 'teacher_professional', '2', '高级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('228', '0', '1', null, 'stduty_section', '6', '小学', 'teacher_professional', '2', '高级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('229', '5', '1', null, 'stduty_section', '8', '职高', 'teacher_professional', '2', '高级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('232', '0', '1', null, 'stduty_section', '1', '幼儿园', 'teacher_professional', '2', '高级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('233', '1', '1', null, 'stduty_section', '3', '初中', 'teacher_professional', '2', '高级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('234', '1', '1', null, 'stduty_section', '4', '高中', 'teacher_professional', '2', '高级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('235', '0', '1', null, 'stduty_section', '6', '小学', 'teacher_professional', '2', '高级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('236', '5', '1', null, 'stduty_section', '8', '职高', 'teacher_professional', '2', '高级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('239', '0', '1', null, 'stduty_section', '1', '幼儿园', 'teacher_professional', '3', '中级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('240', '1', '1', null, 'stduty_section', '3', '初中', 'teacher_professional', '3', '中级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('241', '0', '1', null, 'stduty_section', '4', '高中', 'teacher_professional', '3', '中级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('242', '0', '1', null, 'stduty_section', '6', '小学', 'teacher_professional', '3', '中级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('243', '2', '1', null, 'stduty_section', '8', '职高', 'teacher_professional', '3', '中级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('246', '0', '1', null, 'stduty_section', '1', '幼儿园', 'teacher_professional', '3', '中级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('247', '1', '1', null, 'stduty_section', '3', '初中', 'teacher_professional', '3', '中级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('248', '0', '1', null, 'stduty_section', '4', '高中', 'teacher_professional', '3', '中级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('249', '0', '1', null, 'stduty_section', '6', '小学', 'teacher_professional', '3', '中级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('250', '2', '1', null, 'stduty_section', '8', '职高', 'teacher_professional', '3', '中级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('253', '0', '1', null, 'stduty_section', '1', '幼儿园', 'teacher_professional', '4', '初级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('254', '0', '1', null, 'stduty_section', '3', '初中', 'teacher_professional', '4', '初级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('255', '0', '1', null, 'stduty_section', '4', '高中', 'teacher_professional', '4', '初级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('256', '0', '1', null, 'stduty_section', '6', '小学', 'teacher_professional', '4', '初级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('257', '0', '1', null, 'stduty_section', '8', '职高', 'teacher_professional', '4', '初级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('260', '0', '1', null, 'stduty_section', '1', '幼儿园', 'teacher_professional', '4', '初级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('261', '0', '1', null, 'stduty_section', '3', '初中', 'teacher_professional', '4', '初级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('262', '0', '1', null, 'stduty_section', '4', '高中', 'teacher_professional', '4', '初级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('263', '0', '1', null, 'stduty_section', '6', '小学', 'teacher_professional', '4', '初级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('264', '0', '1', null, 'stduty_section', '8', '职高', 'teacher_professional', '4', '初级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('267', '0', '1', null, 'stduty_section', '1', '幼儿园', 'age', '0', 'age0');
INSERT INTO `edu_statistic_teacher` VALUES ('268', '0', '1', null, 'stduty_section', '3', '初中', 'age', '0', 'age0');
INSERT INTO `edu_statistic_teacher` VALUES ('269', '0', '1', null, 'stduty_section', '4', '高中', 'age', '0', 'age0');
INSERT INTO `edu_statistic_teacher` VALUES ('270', '0', '1', null, 'stduty_section', '6', '小学', 'age', '0', 'age0');
INSERT INTO `edu_statistic_teacher` VALUES ('271', '0', '1', null, 'stduty_section', '8', '职高', 'age', '0', 'age0');
INSERT INTO `edu_statistic_teacher` VALUES ('274', '0', '1', null, 'stduty_section', '1', '幼儿园', 'age', '0', 'age0');
INSERT INTO `edu_statistic_teacher` VALUES ('275', '0', '1', null, 'stduty_section', '3', '初中', 'age', '0', 'age0');
INSERT INTO `edu_statistic_teacher` VALUES ('276', '0', '1', null, 'stduty_section', '4', '高中', 'age', '0', 'age0');
INSERT INTO `edu_statistic_teacher` VALUES ('277', '0', '1', null, 'stduty_section', '6', '小学', 'age', '0', 'age0');
INSERT INTO `edu_statistic_teacher` VALUES ('278', '0', '1', null, 'stduty_section', '8', '职高', 'age', '0', 'age0');
INSERT INTO `edu_statistic_teacher` VALUES ('281', '0', '1', null, 'stduty_section', '1', '幼儿园', 'age', '1', 'age1');
INSERT INTO `edu_statistic_teacher` VALUES ('282', '0', '1', null, 'stduty_section', '3', '初中', 'age', '1', 'age1');
INSERT INTO `edu_statistic_teacher` VALUES ('283', '0', '1', null, 'stduty_section', '4', '高中', 'age', '1', 'age1');
INSERT INTO `edu_statistic_teacher` VALUES ('284', '0', '1', null, 'stduty_section', '6', '小学', 'age', '1', 'age1');
INSERT INTO `edu_statistic_teacher` VALUES ('285', '0', '1', null, 'stduty_section', '8', '职高', 'age', '1', 'age1');
INSERT INTO `edu_statistic_teacher` VALUES ('288', '0', '1', null, 'stduty_section', '1', '幼儿园', 'age', '1', 'age1');
INSERT INTO `edu_statistic_teacher` VALUES ('289', '0', '1', null, 'stduty_section', '3', '初中', 'age', '1', 'age1');
INSERT INTO `edu_statistic_teacher` VALUES ('290', '0', '1', null, 'stduty_section', '4', '高中', 'age', '1', 'age1');
INSERT INTO `edu_statistic_teacher` VALUES ('291', '0', '1', null, 'stduty_section', '6', '小学', 'age', '1', 'age1');
INSERT INTO `edu_statistic_teacher` VALUES ('292', '0', '1', null, 'stduty_section', '8', '职高', 'age', '1', 'age1');
INSERT INTO `edu_statistic_teacher` VALUES ('295', '0', '1', null, 'stduty_section', '1', '幼儿园', 'age', '2', 'age2');
INSERT INTO `edu_statistic_teacher` VALUES ('296', '0', '1', null, 'stduty_section', '3', '初中', 'age', '2', 'age2');
INSERT INTO `edu_statistic_teacher` VALUES ('297', '0', '1', null, 'stduty_section', '4', '高中', 'age', '2', 'age2');
INSERT INTO `edu_statistic_teacher` VALUES ('298', '0', '1', null, 'stduty_section', '6', '小学', 'age', '2', 'age2');
INSERT INTO `edu_statistic_teacher` VALUES ('299', '0', '1', null, 'stduty_section', '8', '职高', 'age', '2', 'age2');
INSERT INTO `edu_statistic_teacher` VALUES ('302', '0', '1', null, 'stduty_section', '1', '幼儿园', 'age', '2', 'age2');
INSERT INTO `edu_statistic_teacher` VALUES ('303', '0', '1', null, 'stduty_section', '3', '初中', 'age', '2', 'age2');
INSERT INTO `edu_statistic_teacher` VALUES ('304', '0', '1', null, 'stduty_section', '4', '高中', 'age', '2', 'age2');
INSERT INTO `edu_statistic_teacher` VALUES ('305', '0', '1', null, 'stduty_section', '6', '小学', 'age', '2', 'age2');
INSERT INTO `edu_statistic_teacher` VALUES ('306', '0', '1', null, 'stduty_section', '8', '职高', 'age', '2', 'age2');
INSERT INTO `edu_statistic_teacher` VALUES ('309', '0', '1', null, 'stduty_section', '1', '幼儿园', 'age', '3', 'age3');
INSERT INTO `edu_statistic_teacher` VALUES ('310', '0', '1', null, 'stduty_section', '3', '初中', 'age', '3', 'age3');
INSERT INTO `edu_statistic_teacher` VALUES ('311', '0', '1', null, 'stduty_section', '4', '高中', 'age', '3', 'age3');
INSERT INTO `edu_statistic_teacher` VALUES ('312', '0', '1', null, 'stduty_section', '6', '小学', 'age', '3', 'age3');
INSERT INTO `edu_statistic_teacher` VALUES ('313', '0', '1', null, 'stduty_section', '8', '职高', 'age', '3', 'age3');
INSERT INTO `edu_statistic_teacher` VALUES ('316', '0', '1', null, 'stduty_section', '1', '幼儿园', 'age', '3', 'age3');
INSERT INTO `edu_statistic_teacher` VALUES ('317', '0', '1', null, 'stduty_section', '3', '初中', 'age', '3', 'age3');
INSERT INTO `edu_statistic_teacher` VALUES ('318', '0', '1', null, 'stduty_section', '4', '高中', 'age', '3', 'age3');
INSERT INTO `edu_statistic_teacher` VALUES ('319', '0', '1', null, 'stduty_section', '6', '小学', 'age', '3', 'age3');
INSERT INTO `edu_statistic_teacher` VALUES ('320', '0', '1', null, 'stduty_section', '8', '职高', 'age', '3', 'age3');
INSERT INTO `edu_statistic_teacher` VALUES ('323', '0', '1', null, 'stduty_section', '1', '幼儿园', 'age', '4', 'age4');
INSERT INTO `edu_statistic_teacher` VALUES ('324', '0', '1', null, 'stduty_section', '3', '初中', 'age', '4', 'age4');
INSERT INTO `edu_statistic_teacher` VALUES ('325', '0', '1', null, 'stduty_section', '4', '高中', 'age', '4', 'age4');
INSERT INTO `edu_statistic_teacher` VALUES ('326', '0', '1', null, 'stduty_section', '6', '小学', 'age', '4', 'age4');
INSERT INTO `edu_statistic_teacher` VALUES ('327', '0', '1', null, 'stduty_section', '8', '职高', 'age', '4', 'age4');
INSERT INTO `edu_statistic_teacher` VALUES ('330', '0', '1', null, 'stduty_section', '1', '幼儿园', 'age', '4', 'age4');
INSERT INTO `edu_statistic_teacher` VALUES ('331', '0', '1', null, 'stduty_section', '3', '初中', 'age', '4', 'age4');
INSERT INTO `edu_statistic_teacher` VALUES ('332', '0', '1', null, 'stduty_section', '4', '高中', 'age', '4', 'age4');
INSERT INTO `edu_statistic_teacher` VALUES ('333', '0', '1', null, 'stduty_section', '6', '小学', 'age', '4', 'age4');
INSERT INTO `edu_statistic_teacher` VALUES ('334', '0', '1', null, 'stduty_section', '8', '职高', 'age', '4', 'age4');
INSERT INTO `edu_statistic_teacher` VALUES ('337', '0', '1', null, 'stduty_section', '1', '幼儿园', 'age', '5', 'age5');
INSERT INTO `edu_statistic_teacher` VALUES ('338', '0', '1', null, 'stduty_section', '3', '初中', 'age', '5', 'age5');
INSERT INTO `edu_statistic_teacher` VALUES ('339', '0', '1', null, 'stduty_section', '4', '高中', 'age', '5', 'age5');
INSERT INTO `edu_statistic_teacher` VALUES ('340', '0', '1', null, 'stduty_section', '6', '小学', 'age', '5', 'age5');
INSERT INTO `edu_statistic_teacher` VALUES ('341', '0', '1', null, 'stduty_section', '8', '职高', 'age', '5', 'age5');
INSERT INTO `edu_statistic_teacher` VALUES ('344', '0', '1', null, 'stduty_section', '1', '幼儿园', 'age', '5', 'age5');
INSERT INTO `edu_statistic_teacher` VALUES ('345', '0', '1', null, 'stduty_section', '3', '初中', 'age', '5', 'age5');
INSERT INTO `edu_statistic_teacher` VALUES ('346', '0', '1', null, 'stduty_section', '4', '高中', 'age', '5', 'age5');
INSERT INTO `edu_statistic_teacher` VALUES ('347', '0', '1', null, 'stduty_section', '6', '小学', 'age', '5', 'age5');
INSERT INTO `edu_statistic_teacher` VALUES ('348', '0', '1', null, 'stduty_section', '8', '职高', 'age', '5', 'age5');
INSERT INTO `edu_statistic_teacher` VALUES ('351', '0', '1', null, 'stduty_section', '1', '幼儿园', 'age', '6', 'age6');
INSERT INTO `edu_statistic_teacher` VALUES ('352', '0', '1', null, 'stduty_section', '3', '初中', 'age', '6', 'age6');
INSERT INTO `edu_statistic_teacher` VALUES ('353', '0', '1', null, 'stduty_section', '4', '高中', 'age', '6', 'age6');
INSERT INTO `edu_statistic_teacher` VALUES ('354', '0', '1', null, 'stduty_section', '6', '小学', 'age', '6', 'age6');
INSERT INTO `edu_statistic_teacher` VALUES ('355', '0', '1', null, 'stduty_section', '8', '职高', 'age', '6', 'age6');
INSERT INTO `edu_statistic_teacher` VALUES ('358', '0', '1', null, 'stduty_section', '1', '幼儿园', 'age', '6', 'age6');
INSERT INTO `edu_statistic_teacher` VALUES ('359', '0', '1', null, 'stduty_section', '3', '初中', 'age', '6', 'age6');
INSERT INTO `edu_statistic_teacher` VALUES ('360', '0', '1', null, 'stduty_section', '4', '高中', 'age', '6', 'age6');
INSERT INTO `edu_statistic_teacher` VALUES ('361', '0', '1', null, 'stduty_section', '6', '小学', 'age', '6', 'age6');
INSERT INTO `edu_statistic_teacher` VALUES ('362', '0', '1', null, 'stduty_section', '8', '职高', 'age', '6', 'age6');
INSERT INTO `edu_statistic_teacher` VALUES ('365', '0', '1', null, 'stduty_section', '1', '幼儿园', 'age', '7', 'age7');
INSERT INTO `edu_statistic_teacher` VALUES ('366', '0', '1', null, 'stduty_section', '3', '初中', 'age', '7', 'age7');
INSERT INTO `edu_statistic_teacher` VALUES ('367', '0', '1', null, 'stduty_section', '4', '高中', 'age', '7', 'age7');
INSERT INTO `edu_statistic_teacher` VALUES ('368', '0', '1', null, 'stduty_section', '6', '小学', 'age', '7', 'age7');
INSERT INTO `edu_statistic_teacher` VALUES ('369', '0', '1', null, 'stduty_section', '8', '职高', 'age', '7', 'age7');
INSERT INTO `edu_statistic_teacher` VALUES ('372', '0', '1', null, 'stduty_section', '1', '幼儿园', 'age', '7', 'age7');
INSERT INTO `edu_statistic_teacher` VALUES ('373', '0', '1', null, 'stduty_section', '3', '初中', 'age', '7', 'age7');
INSERT INTO `edu_statistic_teacher` VALUES ('374', '0', '1', null, 'stduty_section', '4', '高中', 'age', '7', 'age7');
INSERT INTO `edu_statistic_teacher` VALUES ('375', '0', '1', null, 'stduty_section', '6', '小学', 'age', '7', 'age7');
INSERT INTO `edu_statistic_teacher` VALUES ('376', '0', '1', null, 'stduty_section', '8', '职高', 'age', '7', 'age7');
INSERT INTO `edu_statistic_teacher` VALUES ('379', '0', '1', null, 'stduty_section', '1', '幼儿园', 'age', '8', 'age8');
INSERT INTO `edu_statistic_teacher` VALUES ('380', '0', '1', null, 'stduty_section', '3', '初中', 'age', '8', 'age8');
INSERT INTO `edu_statistic_teacher` VALUES ('381', '0', '1', null, 'stduty_section', '4', '高中', 'age', '8', 'age8');
INSERT INTO `edu_statistic_teacher` VALUES ('382', '18', '1', null, 'stduty_section', '6', '小学', 'age', '8', 'age8');
INSERT INTO `edu_statistic_teacher` VALUES ('383', '0', '1', null, 'stduty_section', '8', '职高', 'age', '8', 'age8');
INSERT INTO `edu_statistic_teacher` VALUES ('386', '0', '1', null, 'stduty_section', '1', '幼儿园', 'age', '8', 'age8');
INSERT INTO `edu_statistic_teacher` VALUES ('387', '0', '1', null, 'stduty_section', '3', '初中', 'age', '8', 'age8');
INSERT INTO `edu_statistic_teacher` VALUES ('388', '0', '1', null, 'stduty_section', '4', '高中', 'age', '8', 'age8');
INSERT INTO `edu_statistic_teacher` VALUES ('389', '18', '1', null, 'stduty_section', '6', '小学', 'age', '8', 'age8');
INSERT INTO `edu_statistic_teacher` VALUES ('390', '0', '1', null, 'stduty_section', '8', '职高', 'age', '8', 'age8');
INSERT INTO `edu_statistic_teacher` VALUES ('393', '0', '1', null, 'stduty_section', '1', '幼儿园', 'age', '9', 'age9');
INSERT INTO `edu_statistic_teacher` VALUES ('394', '22', '1', null, 'stduty_section', '3', '初中', 'age', '9', 'age9');
INSERT INTO `edu_statistic_teacher` VALUES ('395', '0', '1', null, 'stduty_section', '4', '高中', 'age', '9', 'age9');
INSERT INTO `edu_statistic_teacher` VALUES ('396', '118', '1', null, 'stduty_section', '6', '小学', 'age', '9', 'age9');
INSERT INTO `edu_statistic_teacher` VALUES ('397', '0', '1', null, 'stduty_section', '8', '职高', 'age', '9', 'age9');
INSERT INTO `edu_statistic_teacher` VALUES ('400', '0', '1', null, 'stduty_section', '1', '幼儿园', 'age', '9', 'age9');
INSERT INTO `edu_statistic_teacher` VALUES ('401', '22', '1', null, 'stduty_section', '3', '初中', 'age', '9', 'age9');
INSERT INTO `edu_statistic_teacher` VALUES ('402', '0', '1', null, 'stduty_section', '4', '高中', 'age', '9', 'age9');
INSERT INTO `edu_statistic_teacher` VALUES ('403', '118', '1', null, 'stduty_section', '6', '小学', 'age', '9', 'age9');
INSERT INTO `edu_statistic_teacher` VALUES ('404', '0', '1', null, 'stduty_section', '8', '职高', 'age', '9', 'age9');
INSERT INTO `edu_statistic_teacher` VALUES ('407', '7', '0', '0', null, '1', '湖南省', 'teacher_professional', '2', '高级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('408', '5', '0', '1', null, '2', '长沙市', 'teacher_professional', '2', '高级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('409', '2', '0', '1', null, '3', '湘潭市', 'teacher_professional', '2', '高级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('410', '4', '0', '2', null, '4', '芙蓉区', 'teacher_professional', '2', '高级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('411', '1', '0', '2', null, '5', '天心区', 'teacher_professional', '2', '高级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('412', '0', '0', '2', null, '6', '望城区', 'teacher_professional', '2', '高级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('413', '0', '0', '2', null, '7', '雨花区', 'teacher_professional', '2', '高级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('414', '0', '0', '3', null, '8', '雨湖区', 'teacher_professional', '2', '高级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('415', '2', '0', '3', null, '9', '岳塘区', 'teacher_professional', '2', '高级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('416', '0', '0', '3', null, '10', '湘乡市', 'teacher_professional', '2', '高级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('417', '0', '0', '3', null, '11', '韶山市', 'teacher_professional', '2', '高级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('418', '0', '0', '1', null, '14', '株洲市', 'teacher_professional', '2', '高级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('419', '0', '0', '14', null, '15', '荷塘区', 'teacher_professional', '2', '高级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('420', '0', '0', '14', null, '16', '石峰区', 'teacher_professional', '2', '高级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('421', '0', '0', '1', null, '17', '邵阳市', 'teacher_professional', '2', '高级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('422', '0', '0', '17', null, '18', '双清区', 'teacher_professional', '2', '高级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('423', '0', '0', '17', null, '19', '北塔区', 'teacher_professional', '2', '高级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('438', '7', '0', '0', null, '1', '湖南省', 'teacher_professional', '2', '高级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('439', '5', '0', '1', null, '2', '长沙市', 'teacher_professional', '2', '高级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('440', '2', '0', '1', null, '3', '湘潭市', 'teacher_professional', '2', '高级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('441', '4', '0', '2', null, '4', '芙蓉区', 'teacher_professional', '2', '高级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('442', '1', '0', '2', null, '5', '天心区', 'teacher_professional', '2', '高级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('443', '0', '0', '2', null, '6', '望城区', 'teacher_professional', '2', '高级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('444', '0', '0', '2', null, '7', '雨花区', 'teacher_professional', '2', '高级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('445', '0', '0', '3', null, '8', '雨湖区', 'teacher_professional', '2', '高级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('446', '2', '0', '3', null, '9', '岳塘区', 'teacher_professional', '2', '高级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('447', '0', '0', '3', null, '10', '湘乡市', 'teacher_professional', '2', '高级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('448', '0', '0', '3', null, '11', '韶山市', 'teacher_professional', '2', '高级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('449', '0', '0', '1', null, '14', '株洲市', 'teacher_professional', '2', '高级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('450', '0', '0', '14', null, '15', '荷塘区', 'teacher_professional', '2', '高级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('451', '0', '0', '14', null, '16', '石峰区', 'teacher_professional', '2', '高级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('452', '0', '0', '1', null, '17', '邵阳市', 'teacher_professional', '2', '高级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('453', '0', '0', '17', null, '18', '双清区', 'teacher_professional', '2', '高级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('454', '0', '0', '17', null, '19', '北塔区', 'teacher_professional', '2', '高级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('469', '3', '0', '0', null, '1', '湖南省', 'teacher_professional', '3', '中级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('470', '3', '0', '1', null, '2', '长沙市', 'teacher_professional', '3', '中级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('471', '0', '0', '1', null, '3', '湘潭市', 'teacher_professional', '3', '中级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('472', '3', '0', '2', null, '4', '芙蓉区', 'teacher_professional', '3', '中级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('473', '0', '0', '2', null, '5', '天心区', 'teacher_professional', '3', '中级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('474', '0', '0', '2', null, '6', '望城区', 'teacher_professional', '3', '中级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('475', '0', '0', '2', null, '7', '雨花区', 'teacher_professional', '3', '中级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('476', '0', '0', '3', null, '8', '雨湖区', 'teacher_professional', '3', '中级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('477', '0', '0', '3', null, '9', '岳塘区', 'teacher_professional', '3', '中级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('478', '0', '0', '3', null, '10', '湘乡市', 'teacher_professional', '3', '中级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('479', '0', '0', '3', null, '11', '韶山市', 'teacher_professional', '3', '中级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('480', '0', '0', '1', null, '14', '株洲市', 'teacher_professional', '3', '中级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('481', '0', '0', '14', null, '15', '荷塘区', 'teacher_professional', '3', '中级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('482', '0', '0', '14', null, '16', '石峰区', 'teacher_professional', '3', '中级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('483', '0', '0', '1', null, '17', '邵阳市', 'teacher_professional', '3', '中级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('484', '0', '0', '17', null, '18', '双清区', 'teacher_professional', '3', '中级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('485', '0', '0', '17', null, '19', '北塔区', 'teacher_professional', '3', '中级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('500', '3', '0', '0', null, '1', '湖南省', 'teacher_professional', '3', '中级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('501', '3', '0', '1', null, '2', '长沙市', 'teacher_professional', '3', '中级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('502', '0', '0', '1', null, '3', '湘潭市', 'teacher_professional', '3', '中级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('503', '3', '0', '2', null, '4', '芙蓉区', 'teacher_professional', '3', '中级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('504', '0', '0', '2', null, '5', '天心区', 'teacher_professional', '3', '中级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('505', '0', '0', '2', null, '6', '望城区', 'teacher_professional', '3', '中级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('506', '0', '0', '2', null, '7', '雨花区', 'teacher_professional', '3', '中级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('507', '0', '0', '3', null, '8', '雨湖区', 'teacher_professional', '3', '中级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('508', '0', '0', '3', null, '9', '岳塘区', 'teacher_professional', '3', '中级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('509', '0', '0', '3', null, '10', '湘乡市', 'teacher_professional', '3', '中级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('510', '0', '0', '3', null, '11', '韶山市', 'teacher_professional', '3', '中级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('511', '0', '0', '1', null, '14', '株洲市', 'teacher_professional', '3', '中级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('512', '0', '0', '14', null, '15', '荷塘区', 'teacher_professional', '3', '中级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('513', '0', '0', '14', null, '16', '石峰区', 'teacher_professional', '3', '中级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('514', '0', '0', '1', null, '17', '邵阳市', 'teacher_professional', '3', '中级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('515', '0', '0', '17', null, '18', '双清区', 'teacher_professional', '3', '中级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('516', '0', '0', '17', null, '19', '北塔区', 'teacher_professional', '3', '中级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('531', '0', '0', '0', null, '1', '湖南省', 'teacher_professional', '4', '初级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('532', '0', '0', '1', null, '2', '长沙市', 'teacher_professional', '4', '初级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('533', '0', '0', '1', null, '3', '湘潭市', 'teacher_professional', '4', '初级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('534', '0', '0', '2', null, '4', '芙蓉区', 'teacher_professional', '4', '初级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('535', '0', '0', '2', null, '5', '天心区', 'teacher_professional', '4', '初级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('536', '0', '0', '2', null, '6', '望城区', 'teacher_professional', '4', '初级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('537', '0', '0', '2', null, '7', '雨花区', 'teacher_professional', '4', '初级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('538', '0', '0', '3', null, '8', '雨湖区', 'teacher_professional', '4', '初级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('539', '0', '0', '3', null, '9', '岳塘区', 'teacher_professional', '4', '初级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('540', '0', '0', '3', null, '10', '湘乡市', 'teacher_professional', '4', '初级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('541', '0', '0', '3', null, '11', '韶山市', 'teacher_professional', '4', '初级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('542', '0', '0', '1', null, '14', '株洲市', 'teacher_professional', '4', '初级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('543', '0', '0', '14', null, '15', '荷塘区', 'teacher_professional', '4', '初级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('544', '0', '0', '14', null, '16', '石峰区', 'teacher_professional', '4', '初级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('545', '0', '0', '1', null, '17', '邵阳市', 'teacher_professional', '4', '初级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('546', '0', '0', '17', null, '18', '双清区', 'teacher_professional', '4', '初级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('547', '0', '0', '17', null, '19', '北塔区', 'teacher_professional', '4', '初级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('562', '0', '0', '0', null, '1', '湖南省', 'teacher_professional', '4', '初级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('563', '0', '0', '1', null, '2', '长沙市', 'teacher_professional', '4', '初级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('564', '0', '0', '1', null, '3', '湘潭市', 'teacher_professional', '4', '初级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('565', '0', '0', '2', null, '4', '芙蓉区', 'teacher_professional', '4', '初级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('566', '0', '0', '2', null, '5', '天心区', 'teacher_professional', '4', '初级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('567', '0', '0', '2', null, '6', '望城区', 'teacher_professional', '4', '初级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('568', '0', '0', '2', null, '7', '雨花区', 'teacher_professional', '4', '初级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('569', '0', '0', '3', null, '8', '雨湖区', 'teacher_professional', '4', '初级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('570', '0', '0', '3', null, '9', '岳塘区', 'teacher_professional', '4', '初级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('571', '0', '0', '3', null, '10', '湘乡市', 'teacher_professional', '4', '初级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('572', '0', '0', '3', null, '11', '韶山市', 'teacher_professional', '4', '初级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('573', '0', '0', '1', null, '14', '株洲市', 'teacher_professional', '4', '初级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('574', '0', '0', '14', null, '15', '荷塘区', 'teacher_professional', '4', '初级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('575', '0', '0', '14', null, '16', '石峰区', 'teacher_professional', '4', '初级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('576', '0', '0', '1', null, '17', '邵阳市', 'teacher_professional', '4', '初级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('577', '0', '0', '17', null, '18', '双清区', 'teacher_professional', '4', '初级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('578', '0', '0', '17', null, '19', '北塔区', 'teacher_professional', '4', '初级职称');
INSERT INTO `edu_statistic_teacher` VALUES ('593', '0', '0', '0', null, '1', '湖南省', 'educational_user', '3', '初中');
INSERT INTO `edu_statistic_teacher` VALUES ('594', '0', '0', '1', null, '2', '长沙市', 'educational_user', '3', '初中');
INSERT INTO `edu_statistic_teacher` VALUES ('595', '0', '0', '1', null, '3', '湘潭市', 'educational_user', '3', '初中');
INSERT INTO `edu_statistic_teacher` VALUES ('596', '0', '0', '2', null, '4', '芙蓉区', 'educational_user', '3', '初中');
INSERT INTO `edu_statistic_teacher` VALUES ('597', '0', '0', '2', null, '5', '天心区', 'educational_user', '3', '初中');
INSERT INTO `edu_statistic_teacher` VALUES ('598', '0', '0', '2', null, '6', '望城区', 'educational_user', '3', '初中');
INSERT INTO `edu_statistic_teacher` VALUES ('599', '0', '0', '2', null, '7', '雨花区', 'educational_user', '3', '初中');
INSERT INTO `edu_statistic_teacher` VALUES ('600', '0', '0', '3', null, '8', '雨湖区', 'educational_user', '3', '初中');
INSERT INTO `edu_statistic_teacher` VALUES ('601', '0', '0', '3', null, '9', '岳塘区', 'educational_user', '3', '初中');
INSERT INTO `edu_statistic_teacher` VALUES ('602', '0', '0', '3', null, '10', '湘乡市', 'educational_user', '3', '初中');
INSERT INTO `edu_statistic_teacher` VALUES ('603', '0', '0', '3', null, '11', '韶山市', 'educational_user', '3', '初中');
INSERT INTO `edu_statistic_teacher` VALUES ('604', '0', '0', '1', null, '14', '株洲市', 'educational_user', '3', '初中');
INSERT INTO `edu_statistic_teacher` VALUES ('605', '0', '0', '14', null, '15', '荷塘区', 'educational_user', '3', '初中');
INSERT INTO `edu_statistic_teacher` VALUES ('606', '0', '0', '14', null, '16', '石峰区', 'educational_user', '3', '初中');
INSERT INTO `edu_statistic_teacher` VALUES ('607', '0', '0', '1', null, '17', '邵阳市', 'educational_user', '3', '初中');
INSERT INTO `edu_statistic_teacher` VALUES ('608', '0', '0', '17', null, '18', '双清区', 'educational_user', '3', '初中');
INSERT INTO `edu_statistic_teacher` VALUES ('609', '0', '0', '17', null, '19', '北塔区', 'educational_user', '3', '初中');
INSERT INTO `edu_statistic_teacher` VALUES ('624', '0', '0', '0', null, '1', '湖南省', 'educational_user', '3', '初中');
INSERT INTO `edu_statistic_teacher` VALUES ('625', '0', '0', '1', null, '2', '长沙市', 'educational_user', '3', '初中');
INSERT INTO `edu_statistic_teacher` VALUES ('626', '0', '0', '1', null, '3', '湘潭市', 'educational_user', '3', '初中');
INSERT INTO `edu_statistic_teacher` VALUES ('627', '0', '0', '2', null, '4', '芙蓉区', 'educational_user', '3', '初中');
INSERT INTO `edu_statistic_teacher` VALUES ('628', '0', '0', '2', null, '5', '天心区', 'educational_user', '3', '初中');
INSERT INTO `edu_statistic_teacher` VALUES ('629', '0', '0', '2', null, '6', '望城区', 'educational_user', '3', '初中');
INSERT INTO `edu_statistic_teacher` VALUES ('630', '0', '0', '2', null, '7', '雨花区', 'educational_user', '3', '初中');
INSERT INTO `edu_statistic_teacher` VALUES ('631', '0', '0', '3', null, '8', '雨湖区', 'educational_user', '3', '初中');
INSERT INTO `edu_statistic_teacher` VALUES ('632', '0', '0', '3', null, '9', '岳塘区', 'educational_user', '3', '初中');
INSERT INTO `edu_statistic_teacher` VALUES ('633', '0', '0', '3', null, '10', '湘乡市', 'educational_user', '3', '初中');
INSERT INTO `edu_statistic_teacher` VALUES ('634', '0', '0', '3', null, '11', '韶山市', 'educational_user', '3', '初中');
INSERT INTO `edu_statistic_teacher` VALUES ('635', '0', '0', '1', null, '14', '株洲市', 'educational_user', '3', '初中');
INSERT INTO `edu_statistic_teacher` VALUES ('636', '0', '0', '14', null, '15', '荷塘区', 'educational_user', '3', '初中');
INSERT INTO `edu_statistic_teacher` VALUES ('637', '0', '0', '14', null, '16', '石峰区', 'educational_user', '3', '初中');
INSERT INTO `edu_statistic_teacher` VALUES ('638', '0', '0', '1', null, '17', '邵阳市', 'educational_user', '3', '初中');
INSERT INTO `edu_statistic_teacher` VALUES ('639', '0', '0', '17', null, '18', '双清区', 'educational_user', '3', '初中');
INSERT INTO `edu_statistic_teacher` VALUES ('640', '0', '0', '17', null, '19', '北塔区', 'educational_user', '3', '初中');
INSERT INTO `edu_statistic_teacher` VALUES ('655', '0', '0', '0', null, '1', '湖南省', 'educational_user', '4', '高中');
INSERT INTO `edu_statistic_teacher` VALUES ('656', '0', '0', '1', null, '2', '长沙市', 'educational_user', '4', '高中');
INSERT INTO `edu_statistic_teacher` VALUES ('657', '0', '0', '1', null, '3', '湘潭市', 'educational_user', '4', '高中');
INSERT INTO `edu_statistic_teacher` VALUES ('658', '0', '0', '2', null, '4', '芙蓉区', 'educational_user', '4', '高中');
INSERT INTO `edu_statistic_teacher` VALUES ('659', '0', '0', '2', null, '5', '天心区', 'educational_user', '4', '高中');
INSERT INTO `edu_statistic_teacher` VALUES ('660', '0', '0', '2', null, '6', '望城区', 'educational_user', '4', '高中');
INSERT INTO `edu_statistic_teacher` VALUES ('661', '0', '0', '2', null, '7', '雨花区', 'educational_user', '4', '高中');
INSERT INTO `edu_statistic_teacher` VALUES ('662', '0', '0', '3', null, '8', '雨湖区', 'educational_user', '4', '高中');
INSERT INTO `edu_statistic_teacher` VALUES ('663', '0', '0', '3', null, '9', '岳塘区', 'educational_user', '4', '高中');
INSERT INTO `edu_statistic_teacher` VALUES ('664', '0', '0', '3', null, '10', '湘乡市', 'educational_user', '4', '高中');
INSERT INTO `edu_statistic_teacher` VALUES ('665', '0', '0', '3', null, '11', '韶山市', 'educational_user', '4', '高中');
INSERT INTO `edu_statistic_teacher` VALUES ('666', '0', '0', '1', null, '14', '株洲市', 'educational_user', '4', '高中');
INSERT INTO `edu_statistic_teacher` VALUES ('667', '0', '0', '14', null, '15', '荷塘区', 'educational_user', '4', '高中');
INSERT INTO `edu_statistic_teacher` VALUES ('668', '0', '0', '14', null, '16', '石峰区', 'educational_user', '4', '高中');
INSERT INTO `edu_statistic_teacher` VALUES ('669', '0', '0', '1', null, '17', '邵阳市', 'educational_user', '4', '高中');
INSERT INTO `edu_statistic_teacher` VALUES ('670', '0', '0', '17', null, '18', '双清区', 'educational_user', '4', '高中');
INSERT INTO `edu_statistic_teacher` VALUES ('671', '0', '0', '17', null, '19', '北塔区', 'educational_user', '4', '高中');
INSERT INTO `edu_statistic_teacher` VALUES ('686', '0', '0', '0', null, '1', '湖南省', 'educational_user', '4', '高中');
INSERT INTO `edu_statistic_teacher` VALUES ('687', '0', '0', '1', null, '2', '长沙市', 'educational_user', '4', '高中');
INSERT INTO `edu_statistic_teacher` VALUES ('688', '0', '0', '1', null, '3', '湘潭市', 'educational_user', '4', '高中');
INSERT INTO `edu_statistic_teacher` VALUES ('689', '0', '0', '2', null, '4', '芙蓉区', 'educational_user', '4', '高中');
INSERT INTO `edu_statistic_teacher` VALUES ('690', '0', '0', '2', null, '5', '天心区', 'educational_user', '4', '高中');
INSERT INTO `edu_statistic_teacher` VALUES ('691', '0', '0', '2', null, '6', '望城区', 'educational_user', '4', '高中');
INSERT INTO `edu_statistic_teacher` VALUES ('692', '0', '0', '2', null, '7', '雨花区', 'educational_user', '4', '高中');
INSERT INTO `edu_statistic_teacher` VALUES ('693', '0', '0', '3', null, '8', '雨湖区', 'educational_user', '4', '高中');
INSERT INTO `edu_statistic_teacher` VALUES ('694', '0', '0', '3', null, '9', '岳塘区', 'educational_user', '4', '高中');
INSERT INTO `edu_statistic_teacher` VALUES ('695', '0', '0', '3', null, '10', '湘乡市', 'educational_user', '4', '高中');
INSERT INTO `edu_statistic_teacher` VALUES ('696', '0', '0', '3', null, '11', '韶山市', 'educational_user', '4', '高中');
INSERT INTO `edu_statistic_teacher` VALUES ('697', '0', '0', '1', null, '14', '株洲市', 'educational_user', '4', '高中');
INSERT INTO `edu_statistic_teacher` VALUES ('698', '0', '0', '14', null, '15', '荷塘区', 'educational_user', '4', '高中');
INSERT INTO `edu_statistic_teacher` VALUES ('699', '0', '0', '14', null, '16', '石峰区', 'educational_user', '4', '高中');
INSERT INTO `edu_statistic_teacher` VALUES ('700', '0', '0', '1', null, '17', '邵阳市', 'educational_user', '4', '高中');
INSERT INTO `edu_statistic_teacher` VALUES ('701', '0', '0', '17', null, '18', '双清区', 'educational_user', '4', '高中');
INSERT INTO `edu_statistic_teacher` VALUES ('702', '0', '0', '17', null, '19', '北塔区', 'educational_user', '4', '高中');
INSERT INTO `edu_statistic_teacher` VALUES ('717', '4', '0', '0', null, '1', '湖南省', 'educational_user', '5', '中专');
INSERT INTO `edu_statistic_teacher` VALUES ('718', '2', '0', '1', null, '2', '长沙市', 'educational_user', '5', '中专');
INSERT INTO `edu_statistic_teacher` VALUES ('719', '2', '0', '1', null, '3', '湘潭市', 'educational_user', '5', '中专');
INSERT INTO `edu_statistic_teacher` VALUES ('720', '2', '0', '2', null, '4', '芙蓉区', 'educational_user', '5', '中专');
INSERT INTO `edu_statistic_teacher` VALUES ('721', '0', '0', '2', null, '5', '天心区', 'educational_user', '5', '中专');
INSERT INTO `edu_statistic_teacher` VALUES ('722', '0', '0', '2', null, '6', '望城区', 'educational_user', '5', '中专');
INSERT INTO `edu_statistic_teacher` VALUES ('723', '0', '0', '2', null, '7', '雨花区', 'educational_user', '5', '中专');
INSERT INTO `edu_statistic_teacher` VALUES ('724', '0', '0', '3', null, '8', '雨湖区', 'educational_user', '5', '中专');
INSERT INTO `edu_statistic_teacher` VALUES ('725', '0', '0', '3', null, '9', '岳塘区', 'educational_user', '5', '中专');
INSERT INTO `edu_statistic_teacher` VALUES ('726', '0', '0', '3', null, '10', '湘乡市', 'educational_user', '5', '中专');
INSERT INTO `edu_statistic_teacher` VALUES ('727', '2', '0', '3', null, '11', '韶山市', 'educational_user', '5', '中专');
INSERT INTO `edu_statistic_teacher` VALUES ('728', '0', '0', '1', null, '14', '株洲市', 'educational_user', '5', '中专');
INSERT INTO `edu_statistic_teacher` VALUES ('729', '0', '0', '14', null, '15', '荷塘区', 'educational_user', '5', '中专');
INSERT INTO `edu_statistic_teacher` VALUES ('730', '0', '0', '14', null, '16', '石峰区', 'educational_user', '5', '中专');
INSERT INTO `edu_statistic_teacher` VALUES ('731', '0', '0', '1', null, '17', '邵阳市', 'educational_user', '5', '中专');
INSERT INTO `edu_statistic_teacher` VALUES ('732', '0', '0', '17', null, '18', '双清区', 'educational_user', '5', '中专');
INSERT INTO `edu_statistic_teacher` VALUES ('733', '0', '0', '17', null, '19', '北塔区', 'educational_user', '5', '中专');
INSERT INTO `edu_statistic_teacher` VALUES ('748', '4', '0', '0', null, '1', '湖南省', 'educational_user', '5', '中专');
INSERT INTO `edu_statistic_teacher` VALUES ('749', '2', '0', '1', null, '2', '长沙市', 'educational_user', '5', '中专');
INSERT INTO `edu_statistic_teacher` VALUES ('750', '2', '0', '1', null, '3', '湘潭市', 'educational_user', '5', '中专');
INSERT INTO `edu_statistic_teacher` VALUES ('751', '2', '0', '2', null, '4', '芙蓉区', 'educational_user', '5', '中专');
INSERT INTO `edu_statistic_teacher` VALUES ('752', '0', '0', '2', null, '5', '天心区', 'educational_user', '5', '中专');
INSERT INTO `edu_statistic_teacher` VALUES ('753', '0', '0', '2', null, '6', '望城区', 'educational_user', '5', '中专');
INSERT INTO `edu_statistic_teacher` VALUES ('754', '0', '0', '2', null, '7', '雨花区', 'educational_user', '5', '中专');
INSERT INTO `edu_statistic_teacher` VALUES ('755', '0', '0', '3', null, '8', '雨湖区', 'educational_user', '5', '中专');
INSERT INTO `edu_statistic_teacher` VALUES ('756', '0', '0', '3', null, '9', '岳塘区', 'educational_user', '5', '中专');
INSERT INTO `edu_statistic_teacher` VALUES ('757', '0', '0', '3', null, '10', '湘乡市', 'educational_user', '5', '中专');
INSERT INTO `edu_statistic_teacher` VALUES ('758', '2', '0', '3', null, '11', '韶山市', 'educational_user', '5', '中专');
INSERT INTO `edu_statistic_teacher` VALUES ('759', '0', '0', '1', null, '14', '株洲市', 'educational_user', '5', '中专');
INSERT INTO `edu_statistic_teacher` VALUES ('760', '0', '0', '14', null, '15', '荷塘区', 'educational_user', '5', '中专');
INSERT INTO `edu_statistic_teacher` VALUES ('761', '0', '0', '14', null, '16', '石峰区', 'educational_user', '5', '中专');
INSERT INTO `edu_statistic_teacher` VALUES ('762', '0', '0', '1', null, '17', '邵阳市', 'educational_user', '5', '中专');
INSERT INTO `edu_statistic_teacher` VALUES ('763', '0', '0', '17', null, '18', '双清区', 'educational_user', '5', '中专');
INSERT INTO `edu_statistic_teacher` VALUES ('764', '0', '0', '17', null, '19', '北塔区', 'educational_user', '5', '中专');
INSERT INTO `edu_statistic_teacher` VALUES ('779', '1', '0', '0', null, '1', '湖南省', 'educational_user', '6', '大专');
INSERT INTO `edu_statistic_teacher` VALUES ('780', '1', '0', '1', null, '2', '长沙市', 'educational_user', '6', '大专');
INSERT INTO `edu_statistic_teacher` VALUES ('781', '0', '0', '1', null, '3', '湘潭市', 'educational_user', '6', '大专');
INSERT INTO `edu_statistic_teacher` VALUES ('782', '1', '0', '2', null, '4', '芙蓉区', 'educational_user', '6', '大专');
INSERT INTO `edu_statistic_teacher` VALUES ('783', '0', '0', '2', null, '5', '天心区', 'educational_user', '6', '大专');
INSERT INTO `edu_statistic_teacher` VALUES ('784', '0', '0', '2', null, '6', '望城区', 'educational_user', '6', '大专');
INSERT INTO `edu_statistic_teacher` VALUES ('785', '0', '0', '2', null, '7', '雨花区', 'educational_user', '6', '大专');
INSERT INTO `edu_statistic_teacher` VALUES ('786', '0', '0', '3', null, '8', '雨湖区', 'educational_user', '6', '大专');
INSERT INTO `edu_statistic_teacher` VALUES ('787', '0', '0', '3', null, '9', '岳塘区', 'educational_user', '6', '大专');
INSERT INTO `edu_statistic_teacher` VALUES ('788', '0', '0', '3', null, '10', '湘乡市', 'educational_user', '6', '大专');
INSERT INTO `edu_statistic_teacher` VALUES ('789', '0', '0', '3', null, '11', '韶山市', 'educational_user', '6', '大专');
INSERT INTO `edu_statistic_teacher` VALUES ('790', '0', '0', '1', null, '14', '株洲市', 'educational_user', '6', '大专');
INSERT INTO `edu_statistic_teacher` VALUES ('791', '0', '0', '14', null, '15', '荷塘区', 'educational_user', '6', '大专');
INSERT INTO `edu_statistic_teacher` VALUES ('792', '0', '0', '14', null, '16', '石峰区', 'educational_user', '6', '大专');
INSERT INTO `edu_statistic_teacher` VALUES ('793', '0', '0', '1', null, '17', '邵阳市', 'educational_user', '6', '大专');
INSERT INTO `edu_statistic_teacher` VALUES ('794', '0', '0', '17', null, '18', '双清区', 'educational_user', '6', '大专');
INSERT INTO `edu_statistic_teacher` VALUES ('795', '0', '0', '17', null, '19', '北塔区', 'educational_user', '6', '大专');
INSERT INTO `edu_statistic_teacher` VALUES ('810', '1', '0', '0', null, '1', '湖南省', 'educational_user', '6', '大专');
INSERT INTO `edu_statistic_teacher` VALUES ('811', '1', '0', '1', null, '2', '长沙市', 'educational_user', '6', '大专');
INSERT INTO `edu_statistic_teacher` VALUES ('812', '0', '0', '1', null, '3', '湘潭市', 'educational_user', '6', '大专');
INSERT INTO `edu_statistic_teacher` VALUES ('813', '1', '0', '2', null, '4', '芙蓉区', 'educational_user', '6', '大专');
INSERT INTO `edu_statistic_teacher` VALUES ('814', '0', '0', '2', null, '5', '天心区', 'educational_user', '6', '大专');
INSERT INTO `edu_statistic_teacher` VALUES ('815', '0', '0', '2', null, '6', '望城区', 'educational_user', '6', '大专');
INSERT INTO `edu_statistic_teacher` VALUES ('816', '0', '0', '2', null, '7', '雨花区', 'educational_user', '6', '大专');
INSERT INTO `edu_statistic_teacher` VALUES ('817', '0', '0', '3', null, '8', '雨湖区', 'educational_user', '6', '大专');
INSERT INTO `edu_statistic_teacher` VALUES ('818', '0', '0', '3', null, '9', '岳塘区', 'educational_user', '6', '大专');
INSERT INTO `edu_statistic_teacher` VALUES ('819', '0', '0', '3', null, '10', '湘乡市', 'educational_user', '6', '大专');
INSERT INTO `edu_statistic_teacher` VALUES ('820', '0', '0', '3', null, '11', '韶山市', 'educational_user', '6', '大专');
INSERT INTO `edu_statistic_teacher` VALUES ('821', '0', '0', '1', null, '14', '株洲市', 'educational_user', '6', '大专');
INSERT INTO `edu_statistic_teacher` VALUES ('822', '0', '0', '14', null, '15', '荷塘区', 'educational_user', '6', '大专');
INSERT INTO `edu_statistic_teacher` VALUES ('823', '0', '0', '14', null, '16', '石峰区', 'educational_user', '6', '大专');
INSERT INTO `edu_statistic_teacher` VALUES ('824', '0', '0', '1', null, '17', '邵阳市', 'educational_user', '6', '大专');
INSERT INTO `edu_statistic_teacher` VALUES ('825', '0', '0', '17', null, '18', '双清区', 'educational_user', '6', '大专');
INSERT INTO `edu_statistic_teacher` VALUES ('826', '0', '0', '17', null, '19', '北塔区', 'educational_user', '6', '大专');
INSERT INTO `edu_statistic_teacher` VALUES ('841', '1', '0', '0', null, '1', '湖南省', 'educational_user', '7', '本科');
INSERT INTO `edu_statistic_teacher` VALUES ('842', '1', '0', '1', null, '2', '长沙市', 'educational_user', '7', '本科');
INSERT INTO `edu_statistic_teacher` VALUES ('843', '0', '0', '1', null, '3', '湘潭市', 'educational_user', '7', '本科');
INSERT INTO `edu_statistic_teacher` VALUES ('844', '1', '0', '2', null, '4', '芙蓉区', 'educational_user', '7', '本科');
INSERT INTO `edu_statistic_teacher` VALUES ('845', '0', '0', '2', null, '5', '天心区', 'educational_user', '7', '本科');
INSERT INTO `edu_statistic_teacher` VALUES ('846', '0', '0', '2', null, '6', '望城区', 'educational_user', '7', '本科');
INSERT INTO `edu_statistic_teacher` VALUES ('847', '0', '0', '2', null, '7', '雨花区', 'educational_user', '7', '本科');
INSERT INTO `edu_statistic_teacher` VALUES ('848', '0', '0', '3', null, '8', '雨湖区', 'educational_user', '7', '本科');
INSERT INTO `edu_statistic_teacher` VALUES ('849', '0', '0', '3', null, '9', '岳塘区', 'educational_user', '7', '本科');
INSERT INTO `edu_statistic_teacher` VALUES ('850', '0', '0', '3', null, '10', '湘乡市', 'educational_user', '7', '本科');
INSERT INTO `edu_statistic_teacher` VALUES ('851', '0', '0', '3', null, '11', '韶山市', 'educational_user', '7', '本科');
INSERT INTO `edu_statistic_teacher` VALUES ('852', '0', '0', '1', null, '14', '株洲市', 'educational_user', '7', '本科');
INSERT INTO `edu_statistic_teacher` VALUES ('853', '0', '0', '14', null, '15', '荷塘区', 'educational_user', '7', '本科');
INSERT INTO `edu_statistic_teacher` VALUES ('854', '0', '0', '14', null, '16', '石峰区', 'educational_user', '7', '本科');
INSERT INTO `edu_statistic_teacher` VALUES ('855', '0', '0', '1', null, '17', '邵阳市', 'educational_user', '7', '本科');
INSERT INTO `edu_statistic_teacher` VALUES ('856', '0', '0', '17', null, '18', '双清区', 'educational_user', '7', '本科');
INSERT INTO `edu_statistic_teacher` VALUES ('857', '0', '0', '17', null, '19', '北塔区', 'educational_user', '7', '本科');
INSERT INTO `edu_statistic_teacher` VALUES ('872', '1', '0', '0', null, '1', '湖南省', 'educational_user', '7', '本科');
INSERT INTO `edu_statistic_teacher` VALUES ('873', '1', '0', '1', null, '2', '长沙市', 'educational_user', '7', '本科');
INSERT INTO `edu_statistic_teacher` VALUES ('874', '0', '0', '1', null, '3', '湘潭市', 'educational_user', '7', '本科');
INSERT INTO `edu_statistic_teacher` VALUES ('875', '1', '0', '2', null, '4', '芙蓉区', 'educational_user', '7', '本科');
INSERT INTO `edu_statistic_teacher` VALUES ('876', '0', '0', '2', null, '5', '天心区', 'educational_user', '7', '本科');
INSERT INTO `edu_statistic_teacher` VALUES ('877', '0', '0', '2', null, '6', '望城区', 'educational_user', '7', '本科');
INSERT INTO `edu_statistic_teacher` VALUES ('878', '0', '0', '2', null, '7', '雨花区', 'educational_user', '7', '本科');
INSERT INTO `edu_statistic_teacher` VALUES ('879', '0', '0', '3', null, '8', '雨湖区', 'educational_user', '7', '本科');
INSERT INTO `edu_statistic_teacher` VALUES ('880', '0', '0', '3', null, '9', '岳塘区', 'educational_user', '7', '本科');
INSERT INTO `edu_statistic_teacher` VALUES ('881', '0', '0', '3', null, '10', '湘乡市', 'educational_user', '7', '本科');
INSERT INTO `edu_statistic_teacher` VALUES ('882', '0', '0', '3', null, '11', '韶山市', 'educational_user', '7', '本科');
INSERT INTO `edu_statistic_teacher` VALUES ('883', '0', '0', '1', null, '14', '株洲市', 'educational_user', '7', '本科');
INSERT INTO `edu_statistic_teacher` VALUES ('884', '0', '0', '14', null, '15', '荷塘区', 'educational_user', '7', '本科');
INSERT INTO `edu_statistic_teacher` VALUES ('885', '0', '0', '14', null, '16', '石峰区', 'educational_user', '7', '本科');
INSERT INTO `edu_statistic_teacher` VALUES ('886', '0', '0', '1', null, '17', '邵阳市', 'educational_user', '7', '本科');
INSERT INTO `edu_statistic_teacher` VALUES ('887', '0', '0', '17', null, '18', '双清区', 'educational_user', '7', '本科');
INSERT INTO `edu_statistic_teacher` VALUES ('888', '0', '0', '17', null, '19', '北塔区', 'educational_user', '7', '本科');
INSERT INTO `edu_statistic_teacher` VALUES ('903', '0', '0', '0', null, '1', '湖南省', 'educational_user', '8', '硕士研究生');
INSERT INTO `edu_statistic_teacher` VALUES ('904', '0', '0', '1', null, '2', '长沙市', 'educational_user', '8', '硕士研究生');
INSERT INTO `edu_statistic_teacher` VALUES ('905', '0', '0', '1', null, '3', '湘潭市', 'educational_user', '8', '硕士研究生');
INSERT INTO `edu_statistic_teacher` VALUES ('906', '0', '0', '2', null, '4', '芙蓉区', 'educational_user', '8', '硕士研究生');
INSERT INTO `edu_statistic_teacher` VALUES ('907', '0', '0', '2', null, '5', '天心区', 'educational_user', '8', '硕士研究生');
INSERT INTO `edu_statistic_teacher` VALUES ('908', '0', '0', '2', null, '6', '望城区', 'educational_user', '8', '硕士研究生');
INSERT INTO `edu_statistic_teacher` VALUES ('909', '0', '0', '2', null, '7', '雨花区', 'educational_user', '8', '硕士研究生');
INSERT INTO `edu_statistic_teacher` VALUES ('910', '0', '0', '3', null, '8', '雨湖区', 'educational_user', '8', '硕士研究生');
INSERT INTO `edu_statistic_teacher` VALUES ('911', '0', '0', '3', null, '9', '岳塘区', 'educational_user', '8', '硕士研究生');
INSERT INTO `edu_statistic_teacher` VALUES ('912', '0', '0', '3', null, '10', '湘乡市', 'educational_user', '8', '硕士研究生');
INSERT INTO `edu_statistic_teacher` VALUES ('913', '0', '0', '3', null, '11', '韶山市', 'educational_user', '8', '硕士研究生');
INSERT INTO `edu_statistic_teacher` VALUES ('914', '0', '0', '1', null, '14', '株洲市', 'educational_user', '8', '硕士研究生');
INSERT INTO `edu_statistic_teacher` VALUES ('915', '0', '0', '14', null, '15', '荷塘区', 'educational_user', '8', '硕士研究生');
INSERT INTO `edu_statistic_teacher` VALUES ('916', '0', '0', '14', null, '16', '石峰区', 'educational_user', '8', '硕士研究生');
INSERT INTO `edu_statistic_teacher` VALUES ('917', '0', '0', '1', null, '17', '邵阳市', 'educational_user', '8', '硕士研究生');
INSERT INTO `edu_statistic_teacher` VALUES ('918', '0', '0', '17', null, '18', '双清区', 'educational_user', '8', '硕士研究生');
INSERT INTO `edu_statistic_teacher` VALUES ('919', '0', '0', '17', null, '19', '北塔区', 'educational_user', '8', '硕士研究生');
INSERT INTO `edu_statistic_teacher` VALUES ('934', '0', '0', '0', null, '1', '湖南省', 'educational_user', '8', '硕士研究生');
INSERT INTO `edu_statistic_teacher` VALUES ('935', '0', '0', '1', null, '2', '长沙市', 'educational_user', '8', '硕士研究生');
INSERT INTO `edu_statistic_teacher` VALUES ('936', '0', '0', '1', null, '3', '湘潭市', 'educational_user', '8', '硕士研究生');
INSERT INTO `edu_statistic_teacher` VALUES ('937', '0', '0', '2', null, '4', '芙蓉区', 'educational_user', '8', '硕士研究生');
INSERT INTO `edu_statistic_teacher` VALUES ('938', '0', '0', '2', null, '5', '天心区', 'educational_user', '8', '硕士研究生');
INSERT INTO `edu_statistic_teacher` VALUES ('939', '0', '0', '2', null, '6', '望城区', 'educational_user', '8', '硕士研究生');
INSERT INTO `edu_statistic_teacher` VALUES ('940', '0', '0', '2', null, '7', '雨花区', 'educational_user', '8', '硕士研究生');
INSERT INTO `edu_statistic_teacher` VALUES ('941', '0', '0', '3', null, '8', '雨湖区', 'educational_user', '8', '硕士研究生');
INSERT INTO `edu_statistic_teacher` VALUES ('942', '0', '0', '3', null, '9', '岳塘区', 'educational_user', '8', '硕士研究生');
INSERT INTO `edu_statistic_teacher` VALUES ('943', '0', '0', '3', null, '10', '湘乡市', 'educational_user', '8', '硕士研究生');
INSERT INTO `edu_statistic_teacher` VALUES ('944', '0', '0', '3', null, '11', '韶山市', 'educational_user', '8', '硕士研究生');
INSERT INTO `edu_statistic_teacher` VALUES ('945', '0', '0', '1', null, '14', '株洲市', 'educational_user', '8', '硕士研究生');
INSERT INTO `edu_statistic_teacher` VALUES ('946', '0', '0', '14', null, '15', '荷塘区', 'educational_user', '8', '硕士研究生');
INSERT INTO `edu_statistic_teacher` VALUES ('947', '0', '0', '14', null, '16', '石峰区', 'educational_user', '8', '硕士研究生');
INSERT INTO `edu_statistic_teacher` VALUES ('948', '0', '0', '1', null, '17', '邵阳市', 'educational_user', '8', '硕士研究生');
INSERT INTO `edu_statistic_teacher` VALUES ('949', '0', '0', '17', null, '18', '双清区', 'educational_user', '8', '硕士研究生');
INSERT INTO `edu_statistic_teacher` VALUES ('950', '0', '0', '17', null, '19', '北塔区', 'educational_user', '8', '硕士研究生');
INSERT INTO `edu_statistic_teacher` VALUES ('965', '1', '0', '0', null, '1', '湖南省', 'educational_user', '9', '博士');
INSERT INTO `edu_statistic_teacher` VALUES ('966', '1', '0', '1', null, '2', '长沙市', 'educational_user', '9', '博士');
INSERT INTO `edu_statistic_teacher` VALUES ('967', '0', '0', '1', null, '3', '湘潭市', 'educational_user', '9', '博士');
INSERT INTO `edu_statistic_teacher` VALUES ('968', '1', '0', '2', null, '4', '芙蓉区', 'educational_user', '9', '博士');
INSERT INTO `edu_statistic_teacher` VALUES ('969', '0', '0', '2', null, '5', '天心区', 'educational_user', '9', '博士');
INSERT INTO `edu_statistic_teacher` VALUES ('970', '0', '0', '2', null, '6', '望城区', 'educational_user', '9', '博士');
INSERT INTO `edu_statistic_teacher` VALUES ('971', '0', '0', '2', null, '7', '雨花区', 'educational_user', '9', '博士');
INSERT INTO `edu_statistic_teacher` VALUES ('972', '0', '0', '3', null, '8', '雨湖区', 'educational_user', '9', '博士');
INSERT INTO `edu_statistic_teacher` VALUES ('973', '0', '0', '3', null, '9', '岳塘区', 'educational_user', '9', '博士');
INSERT INTO `edu_statistic_teacher` VALUES ('974', '0', '0', '3', null, '10', '湘乡市', 'educational_user', '9', '博士');
INSERT INTO `edu_statistic_teacher` VALUES ('975', '0', '0', '3', null, '11', '韶山市', 'educational_user', '9', '博士');
INSERT INTO `edu_statistic_teacher` VALUES ('976', '0', '0', '1', null, '14', '株洲市', 'educational_user', '9', '博士');
INSERT INTO `edu_statistic_teacher` VALUES ('977', '0', '0', '14', null, '15', '荷塘区', 'educational_user', '9', '博士');
INSERT INTO `edu_statistic_teacher` VALUES ('978', '0', '0', '14', null, '16', '石峰区', 'educational_user', '9', '博士');
INSERT INTO `edu_statistic_teacher` VALUES ('979', '0', '0', '1', null, '17', '邵阳市', 'educational_user', '9', '博士');
INSERT INTO `edu_statistic_teacher` VALUES ('980', '0', '0', '17', null, '18', '双清区', 'educational_user', '9', '博士');
INSERT INTO `edu_statistic_teacher` VALUES ('981', '0', '0', '17', null, '19', '北塔区', 'educational_user', '9', '博士');
INSERT INTO `edu_statistic_teacher` VALUES ('996', '1', '0', '0', null, '1', '湖南省', 'educational_user', '9', '博士');
INSERT INTO `edu_statistic_teacher` VALUES ('997', '1', '0', '1', null, '2', '长沙市', 'educational_user', '9', '博士');
INSERT INTO `edu_statistic_teacher` VALUES ('998', '0', '0', '1', null, '3', '湘潭市', 'educational_user', '9', '博士');
INSERT INTO `edu_statistic_teacher` VALUES ('999', '1', '0', '2', null, '4', '芙蓉区', 'educational_user', '9', '博士');
INSERT INTO `edu_statistic_teacher` VALUES ('1000', '0', '0', '2', null, '5', '天心区', 'educational_user', '9', '博士');
INSERT INTO `edu_statistic_teacher` VALUES ('1001', '0', '0', '2', null, '6', '望城区', 'educational_user', '9', '博士');
INSERT INTO `edu_statistic_teacher` VALUES ('1002', '0', '0', '2', null, '7', '雨花区', 'educational_user', '9', '博士');
INSERT INTO `edu_statistic_teacher` VALUES ('1003', '0', '0', '3', null, '8', '雨湖区', 'educational_user', '9', '博士');
INSERT INTO `edu_statistic_teacher` VALUES ('1004', '0', '0', '3', null, '9', '岳塘区', 'educational_user', '9', '博士');
INSERT INTO `edu_statistic_teacher` VALUES ('1005', '0', '0', '3', null, '10', '湘乡市', 'educational_user', '9', '博士');
INSERT INTO `edu_statistic_teacher` VALUES ('1006', '0', '0', '3', null, '11', '韶山市', 'educational_user', '9', '博士');
INSERT INTO `edu_statistic_teacher` VALUES ('1007', '0', '0', '1', null, '14', '株洲市', 'educational_user', '9', '博士');
INSERT INTO `edu_statistic_teacher` VALUES ('1008', '0', '0', '14', null, '15', '荷塘区', 'educational_user', '9', '博士');
INSERT INTO `edu_statistic_teacher` VALUES ('1009', '0', '0', '14', null, '16', '石峰区', 'educational_user', '9', '博士');
INSERT INTO `edu_statistic_teacher` VALUES ('1010', '0', '0', '1', null, '17', '邵阳市', 'educational_user', '9', '博士');
INSERT INTO `edu_statistic_teacher` VALUES ('1011', '0', '0', '17', null, '18', '双清区', 'educational_user', '9', '博士');
INSERT INTO `edu_statistic_teacher` VALUES ('1012', '0', '0', '17', null, '19', '北塔区', 'educational_user', '9', '博士');
INSERT INTO `edu_statistic_teacher` VALUES ('1027', '0', '0', '0', null, '1', '湖南省', 'educational_user', '10', '博士后');
INSERT INTO `edu_statistic_teacher` VALUES ('1028', '0', '0', '1', null, '2', '长沙市', 'educational_user', '10', '博士后');
INSERT INTO `edu_statistic_teacher` VALUES ('1029', '0', '0', '1', null, '3', '湘潭市', 'educational_user', '10', '博士后');
INSERT INTO `edu_statistic_teacher` VALUES ('1030', '0', '0', '2', null, '4', '芙蓉区', 'educational_user', '10', '博士后');
INSERT INTO `edu_statistic_teacher` VALUES ('1031', '0', '0', '2', null, '5', '天心区', 'educational_user', '10', '博士后');
INSERT INTO `edu_statistic_teacher` VALUES ('1032', '0', '0', '2', null, '6', '望城区', 'educational_user', '10', '博士后');
INSERT INTO `edu_statistic_teacher` VALUES ('1033', '0', '0', '2', null, '7', '雨花区', 'educational_user', '10', '博士后');
INSERT INTO `edu_statistic_teacher` VALUES ('1034', '0', '0', '3', null, '8', '雨湖区', 'educational_user', '10', '博士后');
INSERT INTO `edu_statistic_teacher` VALUES ('1035', '0', '0', '3', null, '9', '岳塘区', 'educational_user', '10', '博士后');
INSERT INTO `edu_statistic_teacher` VALUES ('1036', '0', '0', '3', null, '10', '湘乡市', 'educational_user', '10', '博士后');
INSERT INTO `edu_statistic_teacher` VALUES ('1037', '0', '0', '3', null, '11', '韶山市', 'educational_user', '10', '博士后');
INSERT INTO `edu_statistic_teacher` VALUES ('1038', '0', '0', '1', null, '14', '株洲市', 'educational_user', '10', '博士后');
INSERT INTO `edu_statistic_teacher` VALUES ('1039', '0', '0', '14', null, '15', '荷塘区', 'educational_user', '10', '博士后');
INSERT INTO `edu_statistic_teacher` VALUES ('1040', '0', '0', '14', null, '16', '石峰区', 'educational_user', '10', '博士后');
INSERT INTO `edu_statistic_teacher` VALUES ('1041', '0', '0', '1', null, '17', '邵阳市', 'educational_user', '10', '博士后');
INSERT INTO `edu_statistic_teacher` VALUES ('1042', '0', '0', '17', null, '18', '双清区', 'educational_user', '10', '博士后');
INSERT INTO `edu_statistic_teacher` VALUES ('1043', '0', '0', '17', null, '19', '北塔区', 'educational_user', '10', '博士后');
INSERT INTO `edu_statistic_teacher` VALUES ('1058', '0', '0', '0', null, '1', '湖南省', 'educational_user', '10', '博士后');
INSERT INTO `edu_statistic_teacher` VALUES ('1059', '0', '0', '1', null, '2', '长沙市', 'educational_user', '10', '博士后');
INSERT INTO `edu_statistic_teacher` VALUES ('1060', '0', '0', '1', null, '3', '湘潭市', 'educational_user', '10', '博士后');
INSERT INTO `edu_statistic_teacher` VALUES ('1061', '0', '0', '2', null, '4', '芙蓉区', 'educational_user', '10', '博士后');
INSERT INTO `edu_statistic_teacher` VALUES ('1062', '0', '0', '2', null, '5', '天心区', 'educational_user', '10', '博士后');
INSERT INTO `edu_statistic_teacher` VALUES ('1063', '0', '0', '2', null, '6', '望城区', 'educational_user', '10', '博士后');
INSERT INTO `edu_statistic_teacher` VALUES ('1064', '0', '0', '2', null, '7', '雨花区', 'educational_user', '10', '博士后');
INSERT INTO `edu_statistic_teacher` VALUES ('1065', '0', '0', '3', null, '8', '雨湖区', 'educational_user', '10', '博士后');
INSERT INTO `edu_statistic_teacher` VALUES ('1066', '0', '0', '3', null, '9', '岳塘区', 'educational_user', '10', '博士后');
INSERT INTO `edu_statistic_teacher` VALUES ('1067', '0', '0', '3', null, '10', '湘乡市', 'educational_user', '10', '博士后');
INSERT INTO `edu_statistic_teacher` VALUES ('1068', '0', '0', '3', null, '11', '韶山市', 'educational_user', '10', '博士后');
INSERT INTO `edu_statistic_teacher` VALUES ('1069', '0', '0', '1', null, '14', '株洲市', 'educational_user', '10', '博士后');
INSERT INTO `edu_statistic_teacher` VALUES ('1070', '0', '0', '14', null, '15', '荷塘区', 'educational_user', '10', '博士后');
INSERT INTO `edu_statistic_teacher` VALUES ('1071', '0', '0', '14', null, '16', '石峰区', 'educational_user', '10', '博士后');
INSERT INTO `edu_statistic_teacher` VALUES ('1072', '0', '0', '1', null, '17', '邵阳市', 'educational_user', '10', '博士后');
INSERT INTO `edu_statistic_teacher` VALUES ('1073', '0', '0', '17', null, '18', '双清区', 'educational_user', '10', '博士后');
INSERT INTO `edu_statistic_teacher` VALUES ('1074', '0', '0', '17', null, '19', '北塔区', 'educational_user', '10', '博士后');
INSERT INTO `edu_statistic_teacher` VALUES ('1089', '2', '0', '0', null, '1', '湖南省', 'project_subject', '3', '小学美术');
INSERT INTO `edu_statistic_teacher` VALUES ('1090', '2', '0', '1', null, '2', '长沙市', 'project_subject', '3', '小学美术');
INSERT INTO `edu_statistic_teacher` VALUES ('1091', '0', '0', '1', null, '3', '湘潭市', 'project_subject', '3', '小学美术');
INSERT INTO `edu_statistic_teacher` VALUES ('1092', '1', '0', '2', null, '4', '芙蓉区', 'project_subject', '3', '小学美术');
INSERT INTO `edu_statistic_teacher` VALUES ('1093', '1', '0', '2', null, '5', '天心区', 'project_subject', '3', '小学美术');
INSERT INTO `edu_statistic_teacher` VALUES ('1094', '0', '0', '2', null, '6', '望城区', 'project_subject', '3', '小学美术');
INSERT INTO `edu_statistic_teacher` VALUES ('1095', '0', '0', '2', null, '7', '雨花区', 'project_subject', '3', '小学美术');
INSERT INTO `edu_statistic_teacher` VALUES ('1096', '0', '0', '3', null, '8', '雨湖区', 'project_subject', '3', '小学美术');
INSERT INTO `edu_statistic_teacher` VALUES ('1097', '0', '0', '3', null, '9', '岳塘区', 'project_subject', '3', '小学美术');
INSERT INTO `edu_statistic_teacher` VALUES ('1098', '0', '0', '3', null, '10', '湘乡市', 'project_subject', '3', '小学美术');
INSERT INTO `edu_statistic_teacher` VALUES ('1099', '0', '0', '3', null, '11', '韶山市', 'project_subject', '3', '小学美术');
INSERT INTO `edu_statistic_teacher` VALUES ('1100', '0', '0', '1', null, '14', '株洲市', 'project_subject', '3', '小学美术');
INSERT INTO `edu_statistic_teacher` VALUES ('1101', '0', '0', '14', null, '15', '荷塘区', 'project_subject', '3', '小学美术');
INSERT INTO `edu_statistic_teacher` VALUES ('1102', '0', '0', '14', null, '16', '石峰区', 'project_subject', '3', '小学美术');
INSERT INTO `edu_statistic_teacher` VALUES ('1103', '0', '0', '1', null, '17', '邵阳市', 'project_subject', '3', '小学美术');
INSERT INTO `edu_statistic_teacher` VALUES ('1104', '0', '0', '17', null, '18', '双清区', 'project_subject', '3', '小学美术');
INSERT INTO `edu_statistic_teacher` VALUES ('1105', '0', '0', '17', null, '19', '北塔区', 'project_subject', '3', '小学美术');
INSERT INTO `edu_statistic_teacher` VALUES ('1120', '2', '0', '0', null, '1', '湖南省', 'project_subject', '3', '小学美术');
INSERT INTO `edu_statistic_teacher` VALUES ('1121', '2', '0', '1', null, '2', '长沙市', 'project_subject', '3', '小学美术');
INSERT INTO `edu_statistic_teacher` VALUES ('1122', '0', '0', '1', null, '3', '湘潭市', 'project_subject', '3', '小学美术');
INSERT INTO `edu_statistic_teacher` VALUES ('1123', '1', '0', '2', null, '4', '芙蓉区', 'project_subject', '3', '小学美术');
INSERT INTO `edu_statistic_teacher` VALUES ('1124', '1', '0', '2', null, '5', '天心区', 'project_subject', '3', '小学美术');
INSERT INTO `edu_statistic_teacher` VALUES ('1125', '0', '0', '2', null, '6', '望城区', 'project_subject', '3', '小学美术');
INSERT INTO `edu_statistic_teacher` VALUES ('1126', '0', '0', '2', null, '7', '雨花区', 'project_subject', '3', '小学美术');
INSERT INTO `edu_statistic_teacher` VALUES ('1127', '0', '0', '3', null, '8', '雨湖区', 'project_subject', '3', '小学美术');
INSERT INTO `edu_statistic_teacher` VALUES ('1128', '0', '0', '3', null, '9', '岳塘区', 'project_subject', '3', '小学美术');
INSERT INTO `edu_statistic_teacher` VALUES ('1129', '0', '0', '3', null, '10', '湘乡市', 'project_subject', '3', '小学美术');
INSERT INTO `edu_statistic_teacher` VALUES ('1130', '0', '0', '3', null, '11', '韶山市', 'project_subject', '3', '小学美术');
INSERT INTO `edu_statistic_teacher` VALUES ('1131', '0', '0', '1', null, '14', '株洲市', 'project_subject', '3', '小学美术');
INSERT INTO `edu_statistic_teacher` VALUES ('1132', '0', '0', '14', null, '15', '荷塘区', 'project_subject', '3', '小学美术');
INSERT INTO `edu_statistic_teacher` VALUES ('1133', '0', '0', '14', null, '16', '石峰区', 'project_subject', '3', '小学美术');
INSERT INTO `edu_statistic_teacher` VALUES ('1134', '0', '0', '1', null, '17', '邵阳市', 'project_subject', '3', '小学美术');
INSERT INTO `edu_statistic_teacher` VALUES ('1135', '0', '0', '17', null, '18', '双清区', 'project_subject', '3', '小学美术');
INSERT INTO `edu_statistic_teacher` VALUES ('1136', '0', '0', '17', null, '19', '北塔区', 'project_subject', '3', '小学美术');
INSERT INTO `edu_statistic_teacher` VALUES ('1151', '3', '0', '0', null, '1', '湖南省', 'project_subject', '4', '小学音乐');
INSERT INTO `edu_statistic_teacher` VALUES ('1152', '3', '0', '1', null, '2', '长沙市', 'project_subject', '4', '小学音乐');
INSERT INTO `edu_statistic_teacher` VALUES ('1153', '0', '0', '1', null, '3', '湘潭市', 'project_subject', '4', '小学音乐');
INSERT INTO `edu_statistic_teacher` VALUES ('1154', '2', '0', '2', null, '4', '芙蓉区', 'project_subject', '4', '小学音乐');
INSERT INTO `edu_statistic_teacher` VALUES ('1155', '0', '0', '2', null, '5', '天心区', 'project_subject', '4', '小学音乐');
INSERT INTO `edu_statistic_teacher` VALUES ('1156', '0', '0', '2', null, '6', '望城区', 'project_subject', '4', '小学音乐');
INSERT INTO `edu_statistic_teacher` VALUES ('1157', '1', '0', '2', null, '7', '雨花区', 'project_subject', '4', '小学音乐');
INSERT INTO `edu_statistic_teacher` VALUES ('1158', '0', '0', '3', null, '8', '雨湖区', 'project_subject', '4', '小学音乐');
INSERT INTO `edu_statistic_teacher` VALUES ('1159', '0', '0', '3', null, '9', '岳塘区', 'project_subject', '4', '小学音乐');
INSERT INTO `edu_statistic_teacher` VALUES ('1160', '0', '0', '3', null, '10', '湘乡市', 'project_subject', '4', '小学音乐');
INSERT INTO `edu_statistic_teacher` VALUES ('1161', '0', '0', '3', null, '11', '韶山市', 'project_subject', '4', '小学音乐');
INSERT INTO `edu_statistic_teacher` VALUES ('1162', '0', '0', '1', null, '14', '株洲市', 'project_subject', '4', '小学音乐');
INSERT INTO `edu_statistic_teacher` VALUES ('1163', '0', '0', '14', null, '15', '荷塘区', 'project_subject', '4', '小学音乐');
INSERT INTO `edu_statistic_teacher` VALUES ('1164', '0', '0', '14', null, '16', '石峰区', 'project_subject', '4', '小学音乐');
INSERT INTO `edu_statistic_teacher` VALUES ('1165', '0', '0', '1', null, '17', '邵阳市', 'project_subject', '4', '小学音乐');
INSERT INTO `edu_statistic_teacher` VALUES ('1166', '0', '0', '17', null, '18', '双清区', 'project_subject', '4', '小学音乐');
INSERT INTO `edu_statistic_teacher` VALUES ('1167', '0', '0', '17', null, '19', '北塔区', 'project_subject', '4', '小学音乐');
INSERT INTO `edu_statistic_teacher` VALUES ('1182', '3', '0', '0', null, '1', '湖南省', 'project_subject', '4', '小学音乐');
INSERT INTO `edu_statistic_teacher` VALUES ('1183', '3', '0', '1', null, '2', '长沙市', 'project_subject', '4', '小学音乐');
INSERT INTO `edu_statistic_teacher` VALUES ('1184', '0', '0', '1', null, '3', '湘潭市', 'project_subject', '4', '小学音乐');
INSERT INTO `edu_statistic_teacher` VALUES ('1185', '2', '0', '2', null, '4', '芙蓉区', 'project_subject', '4', '小学音乐');
INSERT INTO `edu_statistic_teacher` VALUES ('1186', '0', '0', '2', null, '5', '天心区', 'project_subject', '4', '小学音乐');
INSERT INTO `edu_statistic_teacher` VALUES ('1187', '0', '0', '2', null, '6', '望城区', 'project_subject', '4', '小学音乐');
INSERT INTO `edu_statistic_teacher` VALUES ('1188', '1', '0', '2', null, '7', '雨花区', 'project_subject', '4', '小学音乐');
INSERT INTO `edu_statistic_teacher` VALUES ('1189', '0', '0', '3', null, '8', '雨湖区', 'project_subject', '4', '小学音乐');
INSERT INTO `edu_statistic_teacher` VALUES ('1190', '0', '0', '3', null, '9', '岳塘区', 'project_subject', '4', '小学音乐');
INSERT INTO `edu_statistic_teacher` VALUES ('1191', '0', '0', '3', null, '10', '湘乡市', 'project_subject', '4', '小学音乐');
INSERT INTO `edu_statistic_teacher` VALUES ('1192', '0', '0', '3', null, '11', '韶山市', 'project_subject', '4', '小学音乐');
INSERT INTO `edu_statistic_teacher` VALUES ('1193', '0', '0', '1', null, '14', '株洲市', 'project_subject', '4', '小学音乐');
INSERT INTO `edu_statistic_teacher` VALUES ('1194', '0', '0', '14', null, '15', '荷塘区', 'project_subject', '4', '小学音乐');
INSERT INTO `edu_statistic_teacher` VALUES ('1195', '0', '0', '14', null, '16', '石峰区', 'project_subject', '4', '小学音乐');
INSERT INTO `edu_statistic_teacher` VALUES ('1196', '0', '0', '1', null, '17', '邵阳市', 'project_subject', '4', '小学音乐');
INSERT INTO `edu_statistic_teacher` VALUES ('1197', '0', '0', '17', null, '18', '双清区', 'project_subject', '4', '小学音乐');
INSERT INTO `edu_statistic_teacher` VALUES ('1198', '0', '0', '17', null, '19', '北塔区', 'project_subject', '4', '小学音乐');
INSERT INTO `edu_statistic_teacher` VALUES ('1213', '1', '0', '0', null, '1', '湖南省', 'project_subject', '5', '初中语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1214', '1', '0', '1', null, '2', '长沙市', 'project_subject', '5', '初中语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1215', '0', '0', '1', null, '3', '湘潭市', 'project_subject', '5', '初中语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1216', '0', '0', '2', null, '4', '芙蓉区', 'project_subject', '5', '初中语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1217', '0', '0', '2', null, '5', '天心区', 'project_subject', '5', '初中语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1218', '0', '0', '2', null, '6', '望城区', 'project_subject', '5', '初中语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1219', '1', '0', '2', null, '7', '雨花区', 'project_subject', '5', '初中语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1220', '0', '0', '3', null, '8', '雨湖区', 'project_subject', '5', '初中语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1221', '0', '0', '3', null, '9', '岳塘区', 'project_subject', '5', '初中语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1222', '0', '0', '3', null, '10', '湘乡市', 'project_subject', '5', '初中语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1223', '0', '0', '3', null, '11', '韶山市', 'project_subject', '5', '初中语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1224', '0', '0', '1', null, '14', '株洲市', 'project_subject', '5', '初中语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1225', '0', '0', '14', null, '15', '荷塘区', 'project_subject', '5', '初中语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1226', '0', '0', '14', null, '16', '石峰区', 'project_subject', '5', '初中语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1227', '0', '0', '1', null, '17', '邵阳市', 'project_subject', '5', '初中语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1228', '0', '0', '17', null, '18', '双清区', 'project_subject', '5', '初中语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1229', '0', '0', '17', null, '19', '北塔区', 'project_subject', '5', '初中语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1244', '1', '0', '0', null, '1', '湖南省', 'project_subject', '5', '初中语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1245', '1', '0', '1', null, '2', '长沙市', 'project_subject', '5', '初中语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1246', '0', '0', '1', null, '3', '湘潭市', 'project_subject', '5', '初中语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1247', '0', '0', '2', null, '4', '芙蓉区', 'project_subject', '5', '初中语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1248', '0', '0', '2', null, '5', '天心区', 'project_subject', '5', '初中语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1249', '0', '0', '2', null, '6', '望城区', 'project_subject', '5', '初中语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1250', '1', '0', '2', null, '7', '雨花区', 'project_subject', '5', '初中语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1251', '0', '0', '3', null, '8', '雨湖区', 'project_subject', '5', '初中语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1252', '0', '0', '3', null, '9', '岳塘区', 'project_subject', '5', '初中语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1253', '0', '0', '3', null, '10', '湘乡市', 'project_subject', '5', '初中语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1254', '0', '0', '3', null, '11', '韶山市', 'project_subject', '5', '初中语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1255', '0', '0', '1', null, '14', '株洲市', 'project_subject', '5', '初中语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1256', '0', '0', '14', null, '15', '荷塘区', 'project_subject', '5', '初中语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1257', '0', '0', '14', null, '16', '石峰区', 'project_subject', '5', '初中语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1258', '0', '0', '1', null, '17', '邵阳市', 'project_subject', '5', '初中语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1259', '0', '0', '17', null, '18', '双清区', 'project_subject', '5', '初中语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1260', '0', '0', '17', null, '19', '北塔区', 'project_subject', '5', '初中语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1275', '4', '0', '0', null, '1', '湖南省', 'project_subject', '6', '初中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1276', '0', '0', '1', null, '2', '长沙市', 'project_subject', '6', '初中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1277', '4', '0', '1', null, '3', '湘潭市', 'project_subject', '6', '初中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1278', '0', '0', '2', null, '4', '芙蓉区', 'project_subject', '6', '初中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1279', '0', '0', '2', null, '5', '天心区', 'project_subject', '6', '初中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1280', '0', '0', '2', null, '6', '望城区', 'project_subject', '6', '初中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1281', '0', '0', '2', null, '7', '雨花区', 'project_subject', '6', '初中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1282', '2', '0', '3', null, '8', '雨湖区', 'project_subject', '6', '初中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1283', '0', '0', '3', null, '9', '岳塘区', 'project_subject', '6', '初中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1284', '0', '0', '3', null, '10', '湘乡市', 'project_subject', '6', '初中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1285', '2', '0', '3', null, '11', '韶山市', 'project_subject', '6', '初中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1286', '0', '0', '1', null, '14', '株洲市', 'project_subject', '6', '初中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1287', '0', '0', '14', null, '15', '荷塘区', 'project_subject', '6', '初中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1288', '0', '0', '14', null, '16', '石峰区', 'project_subject', '6', '初中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1289', '0', '0', '1', null, '17', '邵阳市', 'project_subject', '6', '初中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1290', '0', '0', '17', null, '18', '双清区', 'project_subject', '6', '初中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1291', '0', '0', '17', null, '19', '北塔区', 'project_subject', '6', '初中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1306', '4', '0', '0', null, '1', '湖南省', 'project_subject', '6', '初中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1307', '0', '0', '1', null, '2', '长沙市', 'project_subject', '6', '初中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1308', '4', '0', '1', null, '3', '湘潭市', 'project_subject', '6', '初中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1309', '0', '0', '2', null, '4', '芙蓉区', 'project_subject', '6', '初中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1310', '0', '0', '2', null, '5', '天心区', 'project_subject', '6', '初中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1311', '0', '0', '2', null, '6', '望城区', 'project_subject', '6', '初中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1312', '0', '0', '2', null, '7', '雨花区', 'project_subject', '6', '初中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1313', '2', '0', '3', null, '8', '雨湖区', 'project_subject', '6', '初中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1314', '0', '0', '3', null, '9', '岳塘区', 'project_subject', '6', '初中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1315', '0', '0', '3', null, '10', '湘乡市', 'project_subject', '6', '初中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1316', '2', '0', '3', null, '11', '韶山市', 'project_subject', '6', '初中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1317', '0', '0', '1', null, '14', '株洲市', 'project_subject', '6', '初中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1318', '0', '0', '14', null, '15', '荷塘区', 'project_subject', '6', '初中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1319', '0', '0', '14', null, '16', '石峰区', 'project_subject', '6', '初中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1320', '0', '0', '1', null, '17', '邵阳市', 'project_subject', '6', '初中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1321', '0', '0', '17', null, '18', '双清区', 'project_subject', '6', '初中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1322', '0', '0', '17', null, '19', '北塔区', 'project_subject', '6', '初中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1337', '0', '0', '0', null, '1', '湖南省', 'project_subject', '7', '初中物理');
INSERT INTO `edu_statistic_teacher` VALUES ('1338', '0', '0', '1', null, '2', '长沙市', 'project_subject', '7', '初中物理');
INSERT INTO `edu_statistic_teacher` VALUES ('1339', '0', '0', '1', null, '3', '湘潭市', 'project_subject', '7', '初中物理');
INSERT INTO `edu_statistic_teacher` VALUES ('1340', '0', '0', '2', null, '4', '芙蓉区', 'project_subject', '7', '初中物理');
INSERT INTO `edu_statistic_teacher` VALUES ('1341', '0', '0', '2', null, '5', '天心区', 'project_subject', '7', '初中物理');
INSERT INTO `edu_statistic_teacher` VALUES ('1342', '0', '0', '2', null, '6', '望城区', 'project_subject', '7', '初中物理');
INSERT INTO `edu_statistic_teacher` VALUES ('1343', '0', '0', '2', null, '7', '雨花区', 'project_subject', '7', '初中物理');
INSERT INTO `edu_statistic_teacher` VALUES ('1344', '0', '0', '3', null, '8', '雨湖区', 'project_subject', '7', '初中物理');
INSERT INTO `edu_statistic_teacher` VALUES ('1345', '0', '0', '3', null, '9', '岳塘区', 'project_subject', '7', '初中物理');
INSERT INTO `edu_statistic_teacher` VALUES ('1346', '0', '0', '3', null, '10', '湘乡市', 'project_subject', '7', '初中物理');
INSERT INTO `edu_statistic_teacher` VALUES ('1347', '0', '0', '3', null, '11', '韶山市', 'project_subject', '7', '初中物理');
INSERT INTO `edu_statistic_teacher` VALUES ('1348', '0', '0', '1', null, '14', '株洲市', 'project_subject', '7', '初中物理');
INSERT INTO `edu_statistic_teacher` VALUES ('1349', '0', '0', '14', null, '15', '荷塘区', 'project_subject', '7', '初中物理');
INSERT INTO `edu_statistic_teacher` VALUES ('1350', '0', '0', '14', null, '16', '石峰区', 'project_subject', '7', '初中物理');
INSERT INTO `edu_statistic_teacher` VALUES ('1351', '0', '0', '1', null, '17', '邵阳市', 'project_subject', '7', '初中物理');
INSERT INTO `edu_statistic_teacher` VALUES ('1352', '0', '0', '17', null, '18', '双清区', 'project_subject', '7', '初中物理');
INSERT INTO `edu_statistic_teacher` VALUES ('1353', '0', '0', '17', null, '19', '北塔区', 'project_subject', '7', '初中物理');
INSERT INTO `edu_statistic_teacher` VALUES ('1368', '0', '0', '0', null, '1', '湖南省', 'project_subject', '7', '初中物理');
INSERT INTO `edu_statistic_teacher` VALUES ('1369', '0', '0', '1', null, '2', '长沙市', 'project_subject', '7', '初中物理');
INSERT INTO `edu_statistic_teacher` VALUES ('1370', '0', '0', '1', null, '3', '湘潭市', 'project_subject', '7', '初中物理');
INSERT INTO `edu_statistic_teacher` VALUES ('1371', '0', '0', '2', null, '4', '芙蓉区', 'project_subject', '7', '初中物理');
INSERT INTO `edu_statistic_teacher` VALUES ('1372', '0', '0', '2', null, '5', '天心区', 'project_subject', '7', '初中物理');
INSERT INTO `edu_statistic_teacher` VALUES ('1373', '0', '0', '2', null, '6', '望城区', 'project_subject', '7', '初中物理');
INSERT INTO `edu_statistic_teacher` VALUES ('1374', '0', '0', '2', null, '7', '雨花区', 'project_subject', '7', '初中物理');
INSERT INTO `edu_statistic_teacher` VALUES ('1375', '0', '0', '3', null, '8', '雨湖区', 'project_subject', '7', '初中物理');
INSERT INTO `edu_statistic_teacher` VALUES ('1376', '0', '0', '3', null, '9', '岳塘区', 'project_subject', '7', '初中物理');
INSERT INTO `edu_statistic_teacher` VALUES ('1377', '0', '0', '3', null, '10', '湘乡市', 'project_subject', '7', '初中物理');
INSERT INTO `edu_statistic_teacher` VALUES ('1378', '0', '0', '3', null, '11', '韶山市', 'project_subject', '7', '初中物理');
INSERT INTO `edu_statistic_teacher` VALUES ('1379', '0', '0', '1', null, '14', '株洲市', 'project_subject', '7', '初中物理');
INSERT INTO `edu_statistic_teacher` VALUES ('1380', '0', '0', '14', null, '15', '荷塘区', 'project_subject', '7', '初中物理');
INSERT INTO `edu_statistic_teacher` VALUES ('1381', '0', '0', '14', null, '16', '石峰区', 'project_subject', '7', '初中物理');
INSERT INTO `edu_statistic_teacher` VALUES ('1382', '0', '0', '1', null, '17', '邵阳市', 'project_subject', '7', '初中物理');
INSERT INTO `edu_statistic_teacher` VALUES ('1383', '0', '0', '17', null, '18', '双清区', 'project_subject', '7', '初中物理');
INSERT INTO `edu_statistic_teacher` VALUES ('1384', '0', '0', '17', null, '19', '北塔区', 'project_subject', '7', '初中物理');
INSERT INTO `edu_statistic_teacher` VALUES ('1399', '15', '0', '0', null, '1', '湖南省', 'project_subject', '8', '小学语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1400', '12', '0', '1', null, '2', '长沙市', 'project_subject', '8', '小学语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1401', '3', '0', '1', null, '3', '湘潭市', 'project_subject', '8', '小学语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1402', '8', '0', '2', null, '4', '芙蓉区', 'project_subject', '8', '小学语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1403', '2', '0', '2', null, '5', '天心区', 'project_subject', '8', '小学语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1404', '1', '0', '2', null, '6', '望城区', 'project_subject', '8', '小学语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1405', '1', '0', '2', null, '7', '雨花区', 'project_subject', '8', '小学语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1406', '0', '0', '3', null, '8', '雨湖区', 'project_subject', '8', '小学语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1407', '2', '0', '3', null, '9', '岳塘区', 'project_subject', '8', '小学语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1408', '1', '0', '3', null, '10', '湘乡市', 'project_subject', '8', '小学语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1409', '0', '0', '3', null, '11', '韶山市', 'project_subject', '8', '小学语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1410', '0', '0', '1', null, '14', '株洲市', 'project_subject', '8', '小学语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1411', '0', '0', '14', null, '15', '荷塘区', 'project_subject', '8', '小学语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1412', '0', '0', '14', null, '16', '石峰区', 'project_subject', '8', '小学语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1413', '0', '0', '1', null, '17', '邵阳市', 'project_subject', '8', '小学语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1414', '0', '0', '17', null, '18', '双清区', 'project_subject', '8', '小学语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1415', '0', '0', '17', null, '19', '北塔区', 'project_subject', '8', '小学语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1430', '15', '0', '0', null, '1', '湖南省', 'project_subject', '8', '小学语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1431', '12', '0', '1', null, '2', '长沙市', 'project_subject', '8', '小学语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1432', '3', '0', '1', null, '3', '湘潭市', 'project_subject', '8', '小学语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1433', '8', '0', '2', null, '4', '芙蓉区', 'project_subject', '8', '小学语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1434', '2', '0', '2', null, '5', '天心区', 'project_subject', '8', '小学语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1435', '1', '0', '2', null, '6', '望城区', 'project_subject', '8', '小学语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1436', '1', '0', '2', null, '7', '雨花区', 'project_subject', '8', '小学语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1437', '0', '0', '3', null, '8', '雨湖区', 'project_subject', '8', '小学语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1438', '2', '0', '3', null, '9', '岳塘区', 'project_subject', '8', '小学语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1439', '1', '0', '3', null, '10', '湘乡市', 'project_subject', '8', '小学语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1440', '0', '0', '3', null, '11', '韶山市', 'project_subject', '8', '小学语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1441', '0', '0', '1', null, '14', '株洲市', 'project_subject', '8', '小学语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1442', '0', '0', '14', null, '15', '荷塘区', 'project_subject', '8', '小学语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1443', '0', '0', '14', null, '16', '石峰区', 'project_subject', '8', '小学语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1444', '0', '0', '1', null, '17', '邵阳市', 'project_subject', '8', '小学语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1445', '0', '0', '17', null, '18', '双清区', 'project_subject', '8', '小学语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1446', '0', '0', '17', null, '19', '北塔区', 'project_subject', '8', '小学语文');
INSERT INTO `edu_statistic_teacher` VALUES ('1461', '4', '0', '0', null, '1', '湖南省', 'project_subject', '9', '小学数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1462', '4', '0', '1', null, '2', '长沙市', 'project_subject', '9', '小学数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1463', '0', '0', '1', null, '3', '湘潭市', 'project_subject', '9', '小学数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1464', '4', '0', '2', null, '4', '芙蓉区', 'project_subject', '9', '小学数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1465', '0', '0', '2', null, '5', '天心区', 'project_subject', '9', '小学数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1466', '0', '0', '2', null, '6', '望城区', 'project_subject', '9', '小学数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1467', '0', '0', '2', null, '7', '雨花区', 'project_subject', '9', '小学数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1468', '0', '0', '3', null, '8', '雨湖区', 'project_subject', '9', '小学数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1469', '0', '0', '3', null, '9', '岳塘区', 'project_subject', '9', '小学数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1470', '0', '0', '3', null, '10', '湘乡市', 'project_subject', '9', '小学数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1471', '0', '0', '3', null, '11', '韶山市', 'project_subject', '9', '小学数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1472', '0', '0', '1', null, '14', '株洲市', 'project_subject', '9', '小学数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1473', '0', '0', '14', null, '15', '荷塘区', 'project_subject', '9', '小学数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1474', '0', '0', '14', null, '16', '石峰区', 'project_subject', '9', '小学数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1475', '0', '0', '1', null, '17', '邵阳市', 'project_subject', '9', '小学数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1476', '0', '0', '17', null, '18', '双清区', 'project_subject', '9', '小学数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1477', '0', '0', '17', null, '19', '北塔区', 'project_subject', '9', '小学数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1492', '4', '0', '0', null, '1', '湖南省', 'project_subject', '9', '小学数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1493', '4', '0', '1', null, '2', '长沙市', 'project_subject', '9', '小学数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1494', '0', '0', '1', null, '3', '湘潭市', 'project_subject', '9', '小学数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1495', '4', '0', '2', null, '4', '芙蓉区', 'project_subject', '9', '小学数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1496', '0', '0', '2', null, '5', '天心区', 'project_subject', '9', '小学数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1497', '0', '0', '2', null, '6', '望城区', 'project_subject', '9', '小学数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1498', '0', '0', '2', null, '7', '雨花区', 'project_subject', '9', '小学数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1499', '0', '0', '3', null, '8', '雨湖区', 'project_subject', '9', '小学数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1500', '0', '0', '3', null, '9', '岳塘区', 'project_subject', '9', '小学数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1501', '0', '0', '3', null, '10', '湘乡市', 'project_subject', '9', '小学数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1502', '0', '0', '3', null, '11', '韶山市', 'project_subject', '9', '小学数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1503', '0', '0', '1', null, '14', '株洲市', 'project_subject', '9', '小学数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1504', '0', '0', '14', null, '15', '荷塘区', 'project_subject', '9', '小学数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1505', '0', '0', '14', null, '16', '石峰区', 'project_subject', '9', '小学数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1506', '0', '0', '1', null, '17', '邵阳市', 'project_subject', '9', '小学数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1507', '0', '0', '17', null, '18', '双清区', 'project_subject', '9', '小学数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1508', '0', '0', '17', null, '19', '北塔区', 'project_subject', '9', '小学数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1523', '0', '0', '0', null, '1', '湖南省', 'project_subject', '10', '高中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1524', '0', '0', '1', null, '2', '长沙市', 'project_subject', '10', '高中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1525', '0', '0', '1', null, '3', '湘潭市', 'project_subject', '10', '高中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1526', '0', '0', '2', null, '4', '芙蓉区', 'project_subject', '10', '高中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1527', '0', '0', '2', null, '5', '天心区', 'project_subject', '10', '高中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1528', '0', '0', '2', null, '6', '望城区', 'project_subject', '10', '高中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1529', '0', '0', '2', null, '7', '雨花区', 'project_subject', '10', '高中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1530', '0', '0', '3', null, '8', '雨湖区', 'project_subject', '10', '高中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1531', '0', '0', '3', null, '9', '岳塘区', 'project_subject', '10', '高中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1532', '0', '0', '3', null, '10', '湘乡市', 'project_subject', '10', '高中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1533', '0', '0', '3', null, '11', '韶山市', 'project_subject', '10', '高中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1534', '0', '0', '1', null, '14', '株洲市', 'project_subject', '10', '高中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1535', '0', '0', '14', null, '15', '荷塘区', 'project_subject', '10', '高中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1536', '0', '0', '14', null, '16', '石峰区', 'project_subject', '10', '高中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1537', '0', '0', '1', null, '17', '邵阳市', 'project_subject', '10', '高中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1538', '0', '0', '17', null, '18', '双清区', 'project_subject', '10', '高中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1539', '0', '0', '17', null, '19', '北塔区', 'project_subject', '10', '高中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1554', '0', '0', '0', null, '1', '湖南省', 'project_subject', '10', '高中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1555', '0', '0', '1', null, '2', '长沙市', 'project_subject', '10', '高中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1556', '0', '0', '1', null, '3', '湘潭市', 'project_subject', '10', '高中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1557', '0', '0', '2', null, '4', '芙蓉区', 'project_subject', '10', '高中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1558', '0', '0', '2', null, '5', '天心区', 'project_subject', '10', '高中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1559', '0', '0', '2', null, '6', '望城区', 'project_subject', '10', '高中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1560', '0', '0', '2', null, '7', '雨花区', 'project_subject', '10', '高中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1561', '0', '0', '3', null, '8', '雨湖区', 'project_subject', '10', '高中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1562', '0', '0', '3', null, '9', '岳塘区', 'project_subject', '10', '高中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1563', '0', '0', '3', null, '10', '湘乡市', 'project_subject', '10', '高中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1564', '0', '0', '3', null, '11', '韶山市', 'project_subject', '10', '高中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1565', '0', '0', '1', null, '14', '株洲市', 'project_subject', '10', '高中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1566', '0', '0', '14', null, '15', '荷塘区', 'project_subject', '10', '高中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1567', '0', '0', '14', null, '16', '石峰区', 'project_subject', '10', '高中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1568', '0', '0', '1', null, '17', '邵阳市', 'project_subject', '10', '高中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1569', '0', '0', '17', null, '18', '双清区', 'project_subject', '10', '高中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1570', '0', '0', '17', null, '19', '北塔区', 'project_subject', '10', '高中数学');
INSERT INTO `edu_statistic_teacher` VALUES ('1585', '0', '0', '0', null, '1', '湖南省', 'age', '0', 'age0');
INSERT INTO `edu_statistic_teacher` VALUES ('1586', '0', '0', '1', null, '2', '长沙市', 'age', '0', 'age0');
INSERT INTO `edu_statistic_teacher` VALUES ('1587', '0', '0', '1', null, '3', '湘潭市', 'age', '0', 'age0');
INSERT INTO `edu_statistic_teacher` VALUES ('1588', '0', '0', '2', null, '4', '芙蓉区', 'age', '0', 'age0');
INSERT INTO `edu_statistic_teacher` VALUES ('1589', '0', '0', '2', null, '5', '天心区', 'age', '0', 'age0');
INSERT INTO `edu_statistic_teacher` VALUES ('1590', '0', '0', '2', null, '6', '望城区', 'age', '0', 'age0');
INSERT INTO `edu_statistic_teacher` VALUES ('1591', '0', '0', '2', null, '7', '雨花区', 'age', '0', 'age0');
INSERT INTO `edu_statistic_teacher` VALUES ('1592', '0', '0', '3', null, '8', '雨湖区', 'age', '0', 'age0');
INSERT INTO `edu_statistic_teacher` VALUES ('1593', '0', '0', '3', null, '9', '岳塘区', 'age', '0', 'age0');
INSERT INTO `edu_statistic_teacher` VALUES ('1594', '0', '0', '3', null, '10', '湘乡市', 'age', '0', 'age0');
INSERT INTO `edu_statistic_teacher` VALUES ('1595', '0', '0', '3', null, '11', '韶山市', 'age', '0', 'age0');
INSERT INTO `edu_statistic_teacher` VALUES ('1596', '0', '0', '1', null, '14', '株洲市', 'age', '0', 'age0');
INSERT INTO `edu_statistic_teacher` VALUES ('1597', '0', '0', '14', null, '15', '荷塘区', 'age', '0', 'age0');
INSERT INTO `edu_statistic_teacher` VALUES ('1598', '0', '0', '14', null, '16', '石峰区', 'age', '0', 'age0');
INSERT INTO `edu_statistic_teacher` VALUES ('1599', '0', '0', '1', null, '17', '邵阳市', 'age', '0', 'age0');
INSERT INTO `edu_statistic_teacher` VALUES ('1600', '0', '0', '17', null, '18', '双清区', 'age', '0', 'age0');
INSERT INTO `edu_statistic_teacher` VALUES ('1601', '0', '0', '17', null, '19', '北塔区', 'age', '0', 'age0');
INSERT INTO `edu_statistic_teacher` VALUES ('1616', '0', '0', '0', null, '1', '湖南省', 'age', '0', 'age0');
INSERT INTO `edu_statistic_teacher` VALUES ('1617', '0', '0', '1', null, '2', '长沙市', 'age', '0', 'age0');
INSERT INTO `edu_statistic_teacher` VALUES ('1618', '0', '0', '1', null, '3', '湘潭市', 'age', '0', 'age0');
INSERT INTO `edu_statistic_teacher` VALUES ('1619', '0', '0', '2', null, '4', '芙蓉区', 'age', '0', 'age0');
INSERT INTO `edu_statistic_teacher` VALUES ('1620', '0', '0', '2', null, '5', '天心区', 'age', '0', 'age0');
INSERT INTO `edu_statistic_teacher` VALUES ('1621', '0', '0', '2', null, '6', '望城区', 'age', '0', 'age0');
INSERT INTO `edu_statistic_teacher` VALUES ('1622', '0', '0', '2', null, '7', '雨花区', 'age', '0', 'age0');
INSERT INTO `edu_statistic_teacher` VALUES ('1623', '0', '0', '3', null, '8', '雨湖区', 'age', '0', 'age0');
INSERT INTO `edu_statistic_teacher` VALUES ('1624', '0', '0', '3', null, '9', '岳塘区', 'age', '0', 'age0');
INSERT INTO `edu_statistic_teacher` VALUES ('1625', '0', '0', '3', null, '10', '湘乡市', 'age', '0', 'age0');
INSERT INTO `edu_statistic_teacher` VALUES ('1626', '0', '0', '3', null, '11', '韶山市', 'age', '0', 'age0');
INSERT INTO `edu_statistic_teacher` VALUES ('1627', '0', '0', '1', null, '14', '株洲市', 'age', '0', 'age0');
INSERT INTO `edu_statistic_teacher` VALUES ('1628', '0', '0', '14', null, '15', '荷塘区', 'age', '0', 'age0');
INSERT INTO `edu_statistic_teacher` VALUES ('1629', '0', '0', '14', null, '16', '石峰区', 'age', '0', 'age0');
INSERT INTO `edu_statistic_teacher` VALUES ('1630', '0', '0', '1', null, '17', '邵阳市', 'age', '0', 'age0');
INSERT INTO `edu_statistic_teacher` VALUES ('1631', '0', '0', '17', null, '18', '双清区', 'age', '0', 'age0');
INSERT INTO `edu_statistic_teacher` VALUES ('1632', '0', '0', '17', null, '19', '北塔区', 'age', '0', 'age0');
INSERT INTO `edu_statistic_teacher` VALUES ('1647', '0', '0', '0', null, '1', '湖南省', 'age', '1', 'age1');
INSERT INTO `edu_statistic_teacher` VALUES ('1648', '0', '0', '1', null, '2', '长沙市', 'age', '1', 'age1');
INSERT INTO `edu_statistic_teacher` VALUES ('1649', '0', '0', '1', null, '3', '湘潭市', 'age', '1', 'age1');
INSERT INTO `edu_statistic_teacher` VALUES ('1650', '0', '0', '2', null, '4', '芙蓉区', 'age', '1', 'age1');
INSERT INTO `edu_statistic_teacher` VALUES ('1651', '0', '0', '2', null, '5', '天心区', 'age', '1', 'age1');
INSERT INTO `edu_statistic_teacher` VALUES ('1652', '0', '0', '2', null, '6', '望城区', 'age', '1', 'age1');
INSERT INTO `edu_statistic_teacher` VALUES ('1653', '0', '0', '2', null, '7', '雨花区', 'age', '1', 'age1');
INSERT INTO `edu_statistic_teacher` VALUES ('1654', '0', '0', '3', null, '8', '雨湖区', 'age', '1', 'age1');
INSERT INTO `edu_statistic_teacher` VALUES ('1655', '0', '0', '3', null, '9', '岳塘区', 'age', '1', 'age1');
INSERT INTO `edu_statistic_teacher` VALUES ('1656', '0', '0', '3', null, '10', '湘乡市', 'age', '1', 'age1');
INSERT INTO `edu_statistic_teacher` VALUES ('1657', '0', '0', '3', null, '11', '韶山市', 'age', '1', 'age1');
INSERT INTO `edu_statistic_teacher` VALUES ('1658', '0', '0', '1', null, '14', '株洲市', 'age', '1', 'age1');
INSERT INTO `edu_statistic_teacher` VALUES ('1659', '0', '0', '14', null, '15', '荷塘区', 'age', '1', 'age1');
INSERT INTO `edu_statistic_teacher` VALUES ('1660', '0', '0', '14', null, '16', '石峰区', 'age', '1', 'age1');
INSERT INTO `edu_statistic_teacher` VALUES ('1661', '0', '0', '1', null, '17', '邵阳市', 'age', '1', 'age1');
INSERT INTO `edu_statistic_teacher` VALUES ('1662', '0', '0', '17', null, '18', '双清区', 'age', '1', 'age1');
INSERT INTO `edu_statistic_teacher` VALUES ('1663', '0', '0', '17', null, '19', '北塔区', 'age', '1', 'age1');
INSERT INTO `edu_statistic_teacher` VALUES ('1678', '0', '0', '0', null, '1', '湖南省', 'age', '1', 'age1');
INSERT INTO `edu_statistic_teacher` VALUES ('1679', '0', '0', '1', null, '2', '长沙市', 'age', '1', 'age1');
INSERT INTO `edu_statistic_teacher` VALUES ('1680', '0', '0', '1', null, '3', '湘潭市', 'age', '1', 'age1');
INSERT INTO `edu_statistic_teacher` VALUES ('1681', '0', '0', '2', null, '4', '芙蓉区', 'age', '1', 'age1');
INSERT INTO `edu_statistic_teacher` VALUES ('1682', '0', '0', '2', null, '5', '天心区', 'age', '1', 'age1');
INSERT INTO `edu_statistic_teacher` VALUES ('1683', '0', '0', '2', null, '6', '望城区', 'age', '1', 'age1');
INSERT INTO `edu_statistic_teacher` VALUES ('1684', '0', '0', '2', null, '7', '雨花区', 'age', '1', 'age1');
INSERT INTO `edu_statistic_teacher` VALUES ('1685', '0', '0', '3', null, '8', '雨湖区', 'age', '1', 'age1');
INSERT INTO `edu_statistic_teacher` VALUES ('1686', '0', '0', '3', null, '9', '岳塘区', 'age', '1', 'age1');
INSERT INTO `edu_statistic_teacher` VALUES ('1687', '0', '0', '3', null, '10', '湘乡市', 'age', '1', 'age1');
INSERT INTO `edu_statistic_teacher` VALUES ('1688', '0', '0', '3', null, '11', '韶山市', 'age', '1', 'age1');
INSERT INTO `edu_statistic_teacher` VALUES ('1689', '0', '0', '1', null, '14', '株洲市', 'age', '1', 'age1');
INSERT INTO `edu_statistic_teacher` VALUES ('1690', '0', '0', '14', null, '15', '荷塘区', 'age', '1', 'age1');
INSERT INTO `edu_statistic_teacher` VALUES ('1691', '0', '0', '14', null, '16', '石峰区', 'age', '1', 'age1');
INSERT INTO `edu_statistic_teacher` VALUES ('1692', '0', '0', '1', null, '17', '邵阳市', 'age', '1', 'age1');
INSERT INTO `edu_statistic_teacher` VALUES ('1693', '0', '0', '17', null, '18', '双清区', 'age', '1', 'age1');
INSERT INTO `edu_statistic_teacher` VALUES ('1694', '0', '0', '17', null, '19', '北塔区', 'age', '1', 'age1');
INSERT INTO `edu_statistic_teacher` VALUES ('1709', '0', '0', '0', null, '1', '湖南省', 'age', '2', 'age2');
INSERT INTO `edu_statistic_teacher` VALUES ('1710', '0', '0', '1', null, '2', '长沙市', 'age', '2', 'age2');
INSERT INTO `edu_statistic_teacher` VALUES ('1711', '0', '0', '1', null, '3', '湘潭市', 'age', '2', 'age2');
INSERT INTO `edu_statistic_teacher` VALUES ('1712', '0', '0', '2', null, '4', '芙蓉区', 'age', '2', 'age2');
INSERT INTO `edu_statistic_teacher` VALUES ('1713', '0', '0', '2', null, '5', '天心区', 'age', '2', 'age2');
INSERT INTO `edu_statistic_teacher` VALUES ('1714', '0', '0', '2', null, '6', '望城区', 'age', '2', 'age2');
INSERT INTO `edu_statistic_teacher` VALUES ('1715', '0', '0', '2', null, '7', '雨花区', 'age', '2', 'age2');
INSERT INTO `edu_statistic_teacher` VALUES ('1716', '0', '0', '3', null, '8', '雨湖区', 'age', '2', 'age2');
INSERT INTO `edu_statistic_teacher` VALUES ('1717', '0', '0', '3', null, '9', '岳塘区', 'age', '2', 'age2');
INSERT INTO `edu_statistic_teacher` VALUES ('1718', '0', '0', '3', null, '10', '湘乡市', 'age', '2', 'age2');
INSERT INTO `edu_statistic_teacher` VALUES ('1719', '0', '0', '3', null, '11', '韶山市', 'age', '2', 'age2');
INSERT INTO `edu_statistic_teacher` VALUES ('1720', '0', '0', '1', null, '14', '株洲市', 'age', '2', 'age2');
INSERT INTO `edu_statistic_teacher` VALUES ('1721', '0', '0', '14', null, '15', '荷塘区', 'age', '2', 'age2');
INSERT INTO `edu_statistic_teacher` VALUES ('1722', '0', '0', '14', null, '16', '石峰区', 'age', '2', 'age2');
INSERT INTO `edu_statistic_teacher` VALUES ('1723', '0', '0', '1', null, '17', '邵阳市', 'age', '2', 'age2');
INSERT INTO `edu_statistic_teacher` VALUES ('1724', '0', '0', '17', null, '18', '双清区', 'age', '2', 'age2');
INSERT INTO `edu_statistic_teacher` VALUES ('1725', '0', '0', '17', null, '19', '北塔区', 'age', '2', 'age2');
INSERT INTO `edu_statistic_teacher` VALUES ('1740', '0', '0', '0', null, '1', '湖南省', 'age', '2', 'age2');
INSERT INTO `edu_statistic_teacher` VALUES ('1741', '0', '0', '1', null, '2', '长沙市', 'age', '2', 'age2');
INSERT INTO `edu_statistic_teacher` VALUES ('1742', '0', '0', '1', null, '3', '湘潭市', 'age', '2', 'age2');
INSERT INTO `edu_statistic_teacher` VALUES ('1743', '0', '0', '2', null, '4', '芙蓉区', 'age', '2', 'age2');
INSERT INTO `edu_statistic_teacher` VALUES ('1744', '0', '0', '2', null, '5', '天心区', 'age', '2', 'age2');
INSERT INTO `edu_statistic_teacher` VALUES ('1745', '0', '0', '2', null, '6', '望城区', 'age', '2', 'age2');
INSERT INTO `edu_statistic_teacher` VALUES ('1746', '0', '0', '2', null, '7', '雨花区', 'age', '2', 'age2');
INSERT INTO `edu_statistic_teacher` VALUES ('1747', '0', '0', '3', null, '8', '雨湖区', 'age', '2', 'age2');
INSERT INTO `edu_statistic_teacher` VALUES ('1748', '0', '0', '3', null, '9', '岳塘区', 'age', '2', 'age2');
INSERT INTO `edu_statistic_teacher` VALUES ('1749', '0', '0', '3', null, '10', '湘乡市', 'age', '2', 'age2');
INSERT INTO `edu_statistic_teacher` VALUES ('1750', '0', '0', '3', null, '11', '韶山市', 'age', '2', 'age2');
INSERT INTO `edu_statistic_teacher` VALUES ('1751', '0', '0', '1', null, '14', '株洲市', 'age', '2', 'age2');
INSERT INTO `edu_statistic_teacher` VALUES ('1752', '0', '0', '14', null, '15', '荷塘区', 'age', '2', 'age2');
INSERT INTO `edu_statistic_teacher` VALUES ('1753', '0', '0', '14', null, '16', '石峰区', 'age', '2', 'age2');
INSERT INTO `edu_statistic_teacher` VALUES ('1754', '0', '0', '1', null, '17', '邵阳市', 'age', '2', 'age2');
INSERT INTO `edu_statistic_teacher` VALUES ('1755', '0', '0', '17', null, '18', '双清区', 'age', '2', 'age2');
INSERT INTO `edu_statistic_teacher` VALUES ('1756', '0', '0', '17', null, '19', '北塔区', 'age', '2', 'age2');
INSERT INTO `edu_statistic_teacher` VALUES ('1771', '0', '0', '0', null, '1', '湖南省', 'age', '3', 'age3');
INSERT INTO `edu_statistic_teacher` VALUES ('1772', '0', '0', '1', null, '2', '长沙市', 'age', '3', 'age3');
INSERT INTO `edu_statistic_teacher` VALUES ('1773', '0', '0', '1', null, '3', '湘潭市', 'age', '3', 'age3');
INSERT INTO `edu_statistic_teacher` VALUES ('1774', '0', '0', '2', null, '4', '芙蓉区', 'age', '3', 'age3');
INSERT INTO `edu_statistic_teacher` VALUES ('1775', '0', '0', '2', null, '5', '天心区', 'age', '3', 'age3');
INSERT INTO `edu_statistic_teacher` VALUES ('1776', '0', '0', '2', null, '6', '望城区', 'age', '3', 'age3');
INSERT INTO `edu_statistic_teacher` VALUES ('1777', '0', '0', '2', null, '7', '雨花区', 'age', '3', 'age3');
INSERT INTO `edu_statistic_teacher` VALUES ('1778', '0', '0', '3', null, '8', '雨湖区', 'age', '3', 'age3');
INSERT INTO `edu_statistic_teacher` VALUES ('1779', '0', '0', '3', null, '9', '岳塘区', 'age', '3', 'age3');
INSERT INTO `edu_statistic_teacher` VALUES ('1780', '0', '0', '3', null, '10', '湘乡市', 'age', '3', 'age3');
INSERT INTO `edu_statistic_teacher` VALUES ('1781', '0', '0', '3', null, '11', '韶山市', 'age', '3', 'age3');
INSERT INTO `edu_statistic_teacher` VALUES ('1782', '0', '0', '1', null, '14', '株洲市', 'age', '3', 'age3');
INSERT INTO `edu_statistic_teacher` VALUES ('1783', '0', '0', '14', null, '15', '荷塘区', 'age', '3', 'age3');
INSERT INTO `edu_statistic_teacher` VALUES ('1784', '0', '0', '14', null, '16', '石峰区', 'age', '3', 'age3');
INSERT INTO `edu_statistic_teacher` VALUES ('1785', '0', '0', '1', null, '17', '邵阳市', 'age', '3', 'age3');
INSERT INTO `edu_statistic_teacher` VALUES ('1786', '0', '0', '17', null, '18', '双清区', 'age', '3', 'age3');
INSERT INTO `edu_statistic_teacher` VALUES ('1787', '0', '0', '17', null, '19', '北塔区', 'age', '3', 'age3');
INSERT INTO `edu_statistic_teacher` VALUES ('1802', '0', '0', '0', null, '1', '湖南省', 'age', '3', 'age3');
INSERT INTO `edu_statistic_teacher` VALUES ('1803', '0', '0', '1', null, '2', '长沙市', 'age', '3', 'age3');
INSERT INTO `edu_statistic_teacher` VALUES ('1804', '0', '0', '1', null, '3', '湘潭市', 'age', '3', 'age3');
INSERT INTO `edu_statistic_teacher` VALUES ('1805', '0', '0', '2', null, '4', '芙蓉区', 'age', '3', 'age3');
INSERT INTO `edu_statistic_teacher` VALUES ('1806', '0', '0', '2', null, '5', '天心区', 'age', '3', 'age3');
INSERT INTO `edu_statistic_teacher` VALUES ('1807', '0', '0', '2', null, '6', '望城区', 'age', '3', 'age3');
INSERT INTO `edu_statistic_teacher` VALUES ('1808', '0', '0', '2', null, '7', '雨花区', 'age', '3', 'age3');
INSERT INTO `edu_statistic_teacher` VALUES ('1809', '0', '0', '3', null, '8', '雨湖区', 'age', '3', 'age3');
INSERT INTO `edu_statistic_teacher` VALUES ('1810', '0', '0', '3', null, '9', '岳塘区', 'age', '3', 'age3');
INSERT INTO `edu_statistic_teacher` VALUES ('1811', '0', '0', '3', null, '10', '湘乡市', 'age', '3', 'age3');
INSERT INTO `edu_statistic_teacher` VALUES ('1812', '0', '0', '3', null, '11', '韶山市', 'age', '3', 'age3');
INSERT INTO `edu_statistic_teacher` VALUES ('1813', '0', '0', '1', null, '14', '株洲市', 'age', '3', 'age3');
INSERT INTO `edu_statistic_teacher` VALUES ('1814', '0', '0', '14', null, '15', '荷塘区', 'age', '3', 'age3');
INSERT INTO `edu_statistic_teacher` VALUES ('1815', '0', '0', '14', null, '16', '石峰区', 'age', '3', 'age3');
INSERT INTO `edu_statistic_teacher` VALUES ('1816', '0', '0', '1', null, '17', '邵阳市', 'age', '3', 'age3');
INSERT INTO `edu_statistic_teacher` VALUES ('1817', '0', '0', '17', null, '18', '双清区', 'age', '3', 'age3');
INSERT INTO `edu_statistic_teacher` VALUES ('1818', '0', '0', '17', null, '19', '北塔区', 'age', '3', 'age3');
INSERT INTO `edu_statistic_teacher` VALUES ('1833', '0', '0', '0', null, '1', '湖南省', 'age', '4', 'age4');
INSERT INTO `edu_statistic_teacher` VALUES ('1834', '0', '0', '1', null, '2', '长沙市', 'age', '4', 'age4');
INSERT INTO `edu_statistic_teacher` VALUES ('1835', '0', '0', '1', null, '3', '湘潭市', 'age', '4', 'age4');
INSERT INTO `edu_statistic_teacher` VALUES ('1836', '0', '0', '2', null, '4', '芙蓉区', 'age', '4', 'age4');
INSERT INTO `edu_statistic_teacher` VALUES ('1837', '0', '0', '2', null, '5', '天心区', 'age', '4', 'age4');
INSERT INTO `edu_statistic_teacher` VALUES ('1838', '0', '0', '2', null, '6', '望城区', 'age', '4', 'age4');
INSERT INTO `edu_statistic_teacher` VALUES ('1839', '0', '0', '2', null, '7', '雨花区', 'age', '4', 'age4');
INSERT INTO `edu_statistic_teacher` VALUES ('1840', '0', '0', '3', null, '8', '雨湖区', 'age', '4', 'age4');
INSERT INTO `edu_statistic_teacher` VALUES ('1841', '0', '0', '3', null, '9', '岳塘区', 'age', '4', 'age4');
INSERT INTO `edu_statistic_teacher` VALUES ('1842', '0', '0', '3', null, '10', '湘乡市', 'age', '4', 'age4');
INSERT INTO `edu_statistic_teacher` VALUES ('1843', '0', '0', '3', null, '11', '韶山市', 'age', '4', 'age4');
INSERT INTO `edu_statistic_teacher` VALUES ('1844', '0', '0', '1', null, '14', '株洲市', 'age', '4', 'age4');
INSERT INTO `edu_statistic_teacher` VALUES ('1845', '0', '0', '14', null, '15', '荷塘区', 'age', '4', 'age4');
INSERT INTO `edu_statistic_teacher` VALUES ('1846', '0', '0', '14', null, '16', '石峰区', 'age', '4', 'age4');
INSERT INTO `edu_statistic_teacher` VALUES ('1847', '0', '0', '1', null, '17', '邵阳市', 'age', '4', 'age4');
INSERT INTO `edu_statistic_teacher` VALUES ('1848', '0', '0', '17', null, '18', '双清区', 'age', '4', 'age4');
INSERT INTO `edu_statistic_teacher` VALUES ('1849', '0', '0', '17', null, '19', '北塔区', 'age', '4', 'age4');
INSERT INTO `edu_statistic_teacher` VALUES ('1864', '0', '0', '0', null, '1', '湖南省', 'age', '4', 'age4');
INSERT INTO `edu_statistic_teacher` VALUES ('1865', '0', '0', '1', null, '2', '长沙市', 'age', '4', 'age4');
INSERT INTO `edu_statistic_teacher` VALUES ('1866', '0', '0', '1', null, '3', '湘潭市', 'age', '4', 'age4');
INSERT INTO `edu_statistic_teacher` VALUES ('1867', '0', '0', '2', null, '4', '芙蓉区', 'age', '4', 'age4');
INSERT INTO `edu_statistic_teacher` VALUES ('1868', '0', '0', '2', null, '5', '天心区', 'age', '4', 'age4');
INSERT INTO `edu_statistic_teacher` VALUES ('1869', '0', '0', '2', null, '6', '望城区', 'age', '4', 'age4');
INSERT INTO `edu_statistic_teacher` VALUES ('1870', '0', '0', '2', null, '7', '雨花区', 'age', '4', 'age4');
INSERT INTO `edu_statistic_teacher` VALUES ('1871', '0', '0', '3', null, '8', '雨湖区', 'age', '4', 'age4');
INSERT INTO `edu_statistic_teacher` VALUES ('1872', '0', '0', '3', null, '9', '岳塘区', 'age', '4', 'age4');
INSERT INTO `edu_statistic_teacher` VALUES ('1873', '0', '0', '3', null, '10', '湘乡市', 'age', '4', 'age4');
INSERT INTO `edu_statistic_teacher` VALUES ('1874', '0', '0', '3', null, '11', '韶山市', 'age', '4', 'age4');
INSERT INTO `edu_statistic_teacher` VALUES ('1875', '0', '0', '1', null, '14', '株洲市', 'age', '4', 'age4');
INSERT INTO `edu_statistic_teacher` VALUES ('1876', '0', '0', '14', null, '15', '荷塘区', 'age', '4', 'age4');
INSERT INTO `edu_statistic_teacher` VALUES ('1877', '0', '0', '14', null, '16', '石峰区', 'age', '4', 'age4');
INSERT INTO `edu_statistic_teacher` VALUES ('1878', '0', '0', '1', null, '17', '邵阳市', 'age', '4', 'age4');
INSERT INTO `edu_statistic_teacher` VALUES ('1879', '0', '0', '17', null, '18', '双清区', 'age', '4', 'age4');
INSERT INTO `edu_statistic_teacher` VALUES ('1880', '0', '0', '17', null, '19', '北塔区', 'age', '4', 'age4');
INSERT INTO `edu_statistic_teacher` VALUES ('1895', '0', '0', '0', null, '1', '湖南省', 'age', '5', 'age5');
INSERT INTO `edu_statistic_teacher` VALUES ('1896', '0', '0', '1', null, '2', '长沙市', 'age', '5', 'age5');
INSERT INTO `edu_statistic_teacher` VALUES ('1897', '0', '0', '1', null, '3', '湘潭市', 'age', '5', 'age5');
INSERT INTO `edu_statistic_teacher` VALUES ('1898', '0', '0', '2', null, '4', '芙蓉区', 'age', '5', 'age5');
INSERT INTO `edu_statistic_teacher` VALUES ('1899', '0', '0', '2', null, '5', '天心区', 'age', '5', 'age5');
INSERT INTO `edu_statistic_teacher` VALUES ('1900', '0', '0', '2', null, '6', '望城区', 'age', '5', 'age5');
INSERT INTO `edu_statistic_teacher` VALUES ('1901', '0', '0', '2', null, '7', '雨花区', 'age', '5', 'age5');
INSERT INTO `edu_statistic_teacher` VALUES ('1902', '0', '0', '3', null, '8', '雨湖区', 'age', '5', 'age5');
INSERT INTO `edu_statistic_teacher` VALUES ('1903', '0', '0', '3', null, '9', '岳塘区', 'age', '5', 'age5');
INSERT INTO `edu_statistic_teacher` VALUES ('1904', '0', '0', '3', null, '10', '湘乡市', 'age', '5', 'age5');
INSERT INTO `edu_statistic_teacher` VALUES ('1905', '0', '0', '3', null, '11', '韶山市', 'age', '5', 'age5');
INSERT INTO `edu_statistic_teacher` VALUES ('1906', '0', '0', '1', null, '14', '株洲市', 'age', '5', 'age5');
INSERT INTO `edu_statistic_teacher` VALUES ('1907', '0', '0', '14', null, '15', '荷塘区', 'age', '5', 'age5');
INSERT INTO `edu_statistic_teacher` VALUES ('1908', '0', '0', '14', null, '16', '石峰区', 'age', '5', 'age5');
INSERT INTO `edu_statistic_teacher` VALUES ('1909', '0', '0', '1', null, '17', '邵阳市', 'age', '5', 'age5');
INSERT INTO `edu_statistic_teacher` VALUES ('1910', '0', '0', '17', null, '18', '双清区', 'age', '5', 'age5');
INSERT INTO `edu_statistic_teacher` VALUES ('1911', '0', '0', '17', null, '19', '北塔区', 'age', '5', 'age5');
INSERT INTO `edu_statistic_teacher` VALUES ('1926', '0', '0', '0', null, '1', '湖南省', 'age', '5', 'age5');
INSERT INTO `edu_statistic_teacher` VALUES ('1927', '0', '0', '1', null, '2', '长沙市', 'age', '5', 'age5');
INSERT INTO `edu_statistic_teacher` VALUES ('1928', '0', '0', '1', null, '3', '湘潭市', 'age', '5', 'age5');
INSERT INTO `edu_statistic_teacher` VALUES ('1929', '0', '0', '2', null, '4', '芙蓉区', 'age', '5', 'age5');
INSERT INTO `edu_statistic_teacher` VALUES ('1930', '0', '0', '2', null, '5', '天心区', 'age', '5', 'age5');
INSERT INTO `edu_statistic_teacher` VALUES ('1931', '0', '0', '2', null, '6', '望城区', 'age', '5', 'age5');
INSERT INTO `edu_statistic_teacher` VALUES ('1932', '0', '0', '2', null, '7', '雨花区', 'age', '5', 'age5');
INSERT INTO `edu_statistic_teacher` VALUES ('1933', '0', '0', '3', null, '8', '雨湖区', 'age', '5', 'age5');
INSERT INTO `edu_statistic_teacher` VALUES ('1934', '0', '0', '3', null, '9', '岳塘区', 'age', '5', 'age5');
INSERT INTO `edu_statistic_teacher` VALUES ('1935', '0', '0', '3', null, '10', '湘乡市', 'age', '5', 'age5');
INSERT INTO `edu_statistic_teacher` VALUES ('1936', '0', '0', '3', null, '11', '韶山市', 'age', '5', 'age5');
INSERT INTO `edu_statistic_teacher` VALUES ('1937', '0', '0', '1', null, '14', '株洲市', 'age', '5', 'age5');
INSERT INTO `edu_statistic_teacher` VALUES ('1938', '0', '0', '14', null, '15', '荷塘区', 'age', '5', 'age5');
INSERT INTO `edu_statistic_teacher` VALUES ('1939', '0', '0', '14', null, '16', '石峰区', 'age', '5', 'age5');
INSERT INTO `edu_statistic_teacher` VALUES ('1940', '0', '0', '1', null, '17', '邵阳市', 'age', '5', 'age5');
INSERT INTO `edu_statistic_teacher` VALUES ('1941', '0', '0', '17', null, '18', '双清区', 'age', '5', 'age5');
INSERT INTO `edu_statistic_teacher` VALUES ('1942', '0', '0', '17', null, '19', '北塔区', 'age', '5', 'age5');
INSERT INTO `edu_statistic_teacher` VALUES ('1957', '0', '0', '0', null, '1', '湖南省', 'age', '6', 'age6');
INSERT INTO `edu_statistic_teacher` VALUES ('1958', '0', '0', '1', null, '2', '长沙市', 'age', '6', 'age6');
INSERT INTO `edu_statistic_teacher` VALUES ('1959', '0', '0', '1', null, '3', '湘潭市', 'age', '6', 'age6');
INSERT INTO `edu_statistic_teacher` VALUES ('1960', '0', '0', '2', null, '4', '芙蓉区', 'age', '6', 'age6');
INSERT INTO `edu_statistic_teacher` VALUES ('1961', '0', '0', '2', null, '5', '天心区', 'age', '6', 'age6');
INSERT INTO `edu_statistic_teacher` VALUES ('1962', '0', '0', '2', null, '6', '望城区', 'age', '6', 'age6');
INSERT INTO `edu_statistic_teacher` VALUES ('1963', '0', '0', '2', null, '7', '雨花区', 'age', '6', 'age6');
INSERT INTO `edu_statistic_teacher` VALUES ('1964', '0', '0', '3', null, '8', '雨湖区', 'age', '6', 'age6');
INSERT INTO `edu_statistic_teacher` VALUES ('1965', '0', '0', '3', null, '9', '岳塘区', 'age', '6', 'age6');
INSERT INTO `edu_statistic_teacher` VALUES ('1966', '0', '0', '3', null, '10', '湘乡市', 'age', '6', 'age6');
INSERT INTO `edu_statistic_teacher` VALUES ('1967', '0', '0', '3', null, '11', '韶山市', 'age', '6', 'age6');
INSERT INTO `edu_statistic_teacher` VALUES ('1968', '0', '0', '1', null, '14', '株洲市', 'age', '6', 'age6');
INSERT INTO `edu_statistic_teacher` VALUES ('1969', '0', '0', '14', null, '15', '荷塘区', 'age', '6', 'age6');
INSERT INTO `edu_statistic_teacher` VALUES ('1970', '0', '0', '14', null, '16', '石峰区', 'age', '6', 'age6');
INSERT INTO `edu_statistic_teacher` VALUES ('1971', '0', '0', '1', null, '17', '邵阳市', 'age', '6', 'age6');
INSERT INTO `edu_statistic_teacher` VALUES ('1972', '0', '0', '17', null, '18', '双清区', 'age', '6', 'age6');
INSERT INTO `edu_statistic_teacher` VALUES ('1973', '0', '0', '17', null, '19', '北塔区', 'age', '6', 'age6');
INSERT INTO `edu_statistic_teacher` VALUES ('1988', '0', '0', '0', null, '1', '湖南省', 'age', '6', 'age6');
INSERT INTO `edu_statistic_teacher` VALUES ('1989', '0', '0', '1', null, '2', '长沙市', 'age', '6', 'age6');
INSERT INTO `edu_statistic_teacher` VALUES ('1990', '0', '0', '1', null, '3', '湘潭市', 'age', '6', 'age6');
INSERT INTO `edu_statistic_teacher` VALUES ('1991', '0', '0', '2', null, '4', '芙蓉区', 'age', '6', 'age6');
INSERT INTO `edu_statistic_teacher` VALUES ('1992', '0', '0', '2', null, '5', '天心区', 'age', '6', 'age6');
INSERT INTO `edu_statistic_teacher` VALUES ('1993', '0', '0', '2', null, '6', '望城区', 'age', '6', 'age6');
INSERT INTO `edu_statistic_teacher` VALUES ('1994', '0', '0', '2', null, '7', '雨花区', 'age', '6', 'age6');
INSERT INTO `edu_statistic_teacher` VALUES ('1995', '0', '0', '3', null, '8', '雨湖区', 'age', '6', 'age6');
INSERT INTO `edu_statistic_teacher` VALUES ('1996', '0', '0', '3', null, '9', '岳塘区', 'age', '6', 'age6');
INSERT INTO `edu_statistic_teacher` VALUES ('1997', '0', '0', '3', null, '10', '湘乡市', 'age', '6', 'age6');
INSERT INTO `edu_statistic_teacher` VALUES ('1998', '0', '0', '3', null, '11', '韶山市', 'age', '6', 'age6');
INSERT INTO `edu_statistic_teacher` VALUES ('1999', '0', '0', '1', null, '14', '株洲市', 'age', '6', 'age6');
INSERT INTO `edu_statistic_teacher` VALUES ('2000', '0', '0', '14', null, '15', '荷塘区', 'age', '6', 'age6');
INSERT INTO `edu_statistic_teacher` VALUES ('2001', '0', '0', '14', null, '16', '石峰区', 'age', '6', 'age6');
INSERT INTO `edu_statistic_teacher` VALUES ('2002', '0', '0', '1', null, '17', '邵阳市', 'age', '6', 'age6');
INSERT INTO `edu_statistic_teacher` VALUES ('2003', '0', '0', '17', null, '18', '双清区', 'age', '6', 'age6');
INSERT INTO `edu_statistic_teacher` VALUES ('2004', '0', '0', '17', null, '19', '北塔区', 'age', '6', 'age6');
INSERT INTO `edu_statistic_teacher` VALUES ('2019', '0', '0', '0', null, '1', '湖南省', 'age', '7', 'age7');
INSERT INTO `edu_statistic_teacher` VALUES ('2020', '0', '0', '1', null, '2', '长沙市', 'age', '7', 'age7');
INSERT INTO `edu_statistic_teacher` VALUES ('2021', '0', '0', '1', null, '3', '湘潭市', 'age', '7', 'age7');
INSERT INTO `edu_statistic_teacher` VALUES ('2022', '0', '0', '2', null, '4', '芙蓉区', 'age', '7', 'age7');
INSERT INTO `edu_statistic_teacher` VALUES ('2023', '0', '0', '2', null, '5', '天心区', 'age', '7', 'age7');
INSERT INTO `edu_statistic_teacher` VALUES ('2024', '0', '0', '2', null, '6', '望城区', 'age', '7', 'age7');
INSERT INTO `edu_statistic_teacher` VALUES ('2025', '0', '0', '2', null, '7', '雨花区', 'age', '7', 'age7');
INSERT INTO `edu_statistic_teacher` VALUES ('2026', '0', '0', '3', null, '8', '雨湖区', 'age', '7', 'age7');
INSERT INTO `edu_statistic_teacher` VALUES ('2027', '0', '0', '3', null, '9', '岳塘区', 'age', '7', 'age7');
INSERT INTO `edu_statistic_teacher` VALUES ('2028', '0', '0', '3', null, '10', '湘乡市', 'age', '7', 'age7');
INSERT INTO `edu_statistic_teacher` VALUES ('2029', '0', '0', '3', null, '11', '韶山市', 'age', '7', 'age7');
INSERT INTO `edu_statistic_teacher` VALUES ('2030', '0', '0', '1', null, '14', '株洲市', 'age', '7', 'age7');
INSERT INTO `edu_statistic_teacher` VALUES ('2031', '0', '0', '14', null, '15', '荷塘区', 'age', '7', 'age7');
INSERT INTO `edu_statistic_teacher` VALUES ('2032', '0', '0', '14', null, '16', '石峰区', 'age', '7', 'age7');
INSERT INTO `edu_statistic_teacher` VALUES ('2033', '0', '0', '1', null, '17', '邵阳市', 'age', '7', 'age7');
INSERT INTO `edu_statistic_teacher` VALUES ('2034', '0', '0', '17', null, '18', '双清区', 'age', '7', 'age7');
INSERT INTO `edu_statistic_teacher` VALUES ('2035', '0', '0', '17', null, '19', '北塔区', 'age', '7', 'age7');
INSERT INTO `edu_statistic_teacher` VALUES ('2050', '0', '0', '0', null, '1', '湖南省', 'age', '7', 'age7');
INSERT INTO `edu_statistic_teacher` VALUES ('2051', '0', '0', '1', null, '2', '长沙市', 'age', '7', 'age7');
INSERT INTO `edu_statistic_teacher` VALUES ('2052', '0', '0', '1', null, '3', '湘潭市', 'age', '7', 'age7');
INSERT INTO `edu_statistic_teacher` VALUES ('2053', '0', '0', '2', null, '4', '芙蓉区', 'age', '7', 'age7');
INSERT INTO `edu_statistic_teacher` VALUES ('2054', '0', '0', '2', null, '5', '天心区', 'age', '7', 'age7');
INSERT INTO `edu_statistic_teacher` VALUES ('2055', '0', '0', '2', null, '6', '望城区', 'age', '7', 'age7');
INSERT INTO `edu_statistic_teacher` VALUES ('2056', '0', '0', '2', null, '7', '雨花区', 'age', '7', 'age7');
INSERT INTO `edu_statistic_teacher` VALUES ('2057', '0', '0', '3', null, '8', '雨湖区', 'age', '7', 'age7');
INSERT INTO `edu_statistic_teacher` VALUES ('2058', '0', '0', '3', null, '9', '岳塘区', 'age', '7', 'age7');
INSERT INTO `edu_statistic_teacher` VALUES ('2059', '0', '0', '3', null, '10', '湘乡市', 'age', '7', 'age7');
INSERT INTO `edu_statistic_teacher` VALUES ('2060', '0', '0', '3', null, '11', '韶山市', 'age', '7', 'age7');
INSERT INTO `edu_statistic_teacher` VALUES ('2061', '0', '0', '1', null, '14', '株洲市', 'age', '7', 'age7');
INSERT INTO `edu_statistic_teacher` VALUES ('2062', '0', '0', '14', null, '15', '荷塘区', 'age', '7', 'age7');
INSERT INTO `edu_statistic_teacher` VALUES ('2063', '0', '0', '14', null, '16', '石峰区', 'age', '7', 'age7');
INSERT INTO `edu_statistic_teacher` VALUES ('2064', '0', '0', '1', null, '17', '邵阳市', 'age', '7', 'age7');
INSERT INTO `edu_statistic_teacher` VALUES ('2065', '0', '0', '17', null, '18', '双清区', 'age', '7', 'age7');
INSERT INTO `edu_statistic_teacher` VALUES ('2066', '0', '0', '17', null, '19', '北塔区', 'age', '7', 'age7');
INSERT INTO `edu_statistic_teacher` VALUES ('2081', '5', '0', '0', null, '1', '湖南省', 'age', '8', 'age8');
INSERT INTO `edu_statistic_teacher` VALUES ('2082', '4', '0', '1', null, '2', '长沙市', 'age', '8', 'age8');
INSERT INTO `edu_statistic_teacher` VALUES ('2083', '1', '0', '1', null, '3', '湘潭市', 'age', '8', 'age8');
INSERT INTO `edu_statistic_teacher` VALUES ('2084', '3', '0', '2', null, '4', '芙蓉区', 'age', '8', 'age8');
INSERT INTO `edu_statistic_teacher` VALUES ('2085', '0', '0', '2', null, '5', '天心区', 'age', '8', 'age8');
INSERT INTO `edu_statistic_teacher` VALUES ('2086', '0', '0', '2', null, '6', '望城区', 'age', '8', 'age8');
INSERT INTO `edu_statistic_teacher` VALUES ('2087', '1', '0', '2', null, '7', '雨花区', 'age', '8', 'age8');
INSERT INTO `edu_statistic_teacher` VALUES ('2088', '0', '0', '3', null, '8', '雨湖区', 'age', '8', 'age8');
INSERT INTO `edu_statistic_teacher` VALUES ('2089', '1', '0', '3', null, '9', '岳塘区', 'age', '8', 'age8');
INSERT INTO `edu_statistic_teacher` VALUES ('2090', '0', '0', '3', null, '10', '湘乡市', 'age', '8', 'age8');
INSERT INTO `edu_statistic_teacher` VALUES ('2091', '0', '0', '3', null, '11', '韶山市', 'age', '8', 'age8');
INSERT INTO `edu_statistic_teacher` VALUES ('2092', '0', '0', '1', null, '14', '株洲市', 'age', '8', 'age8');
INSERT INTO `edu_statistic_teacher` VALUES ('2093', '0', '0', '14', null, '15', '荷塘区', 'age', '8', 'age8');
INSERT INTO `edu_statistic_teacher` VALUES ('2094', '0', '0', '14', null, '16', '石峰区', 'age', '8', 'age8');
INSERT INTO `edu_statistic_teacher` VALUES ('2095', '0', '0', '1', null, '17', '邵阳市', 'age', '8', 'age8');
INSERT INTO `edu_statistic_teacher` VALUES ('2096', '0', '0', '17', null, '18', '双清区', 'age', '8', 'age8');
INSERT INTO `edu_statistic_teacher` VALUES ('2097', '0', '0', '17', null, '19', '北塔区', 'age', '8', 'age8');
INSERT INTO `edu_statistic_teacher` VALUES ('2112', '5', '0', '0', null, '1', '湖南省', 'age', '8', 'age8');
INSERT INTO `edu_statistic_teacher` VALUES ('2113', '4', '0', '1', null, '2', '长沙市', 'age', '8', 'age8');
INSERT INTO `edu_statistic_teacher` VALUES ('2114', '1', '0', '1', null, '3', '湘潭市', 'age', '8', 'age8');
INSERT INTO `edu_statistic_teacher` VALUES ('2115', '3', '0', '2', null, '4', '芙蓉区', 'age', '8', 'age8');
INSERT INTO `edu_statistic_teacher` VALUES ('2116', '0', '0', '2', null, '5', '天心区', 'age', '8', 'age8');
INSERT INTO `edu_statistic_teacher` VALUES ('2117', '0', '0', '2', null, '6', '望城区', 'age', '8', 'age8');
INSERT INTO `edu_statistic_teacher` VALUES ('2118', '1', '0', '2', null, '7', '雨花区', 'age', '8', 'age8');
INSERT INTO `edu_statistic_teacher` VALUES ('2119', '0', '0', '3', null, '8', '雨湖区', 'age', '8', 'age8');
INSERT INTO `edu_statistic_teacher` VALUES ('2120', '1', '0', '3', null, '9', '岳塘区', 'age', '8', 'age8');
INSERT INTO `edu_statistic_teacher` VALUES ('2121', '0', '0', '3', null, '10', '湘乡市', 'age', '8', 'age8');
INSERT INTO `edu_statistic_teacher` VALUES ('2122', '0', '0', '3', null, '11', '韶山市', 'age', '8', 'age8');
INSERT INTO `edu_statistic_teacher` VALUES ('2123', '0', '0', '1', null, '14', '株洲市', 'age', '8', 'age8');
INSERT INTO `edu_statistic_teacher` VALUES ('2124', '0', '0', '14', null, '15', '荷塘区', 'age', '8', 'age8');
INSERT INTO `edu_statistic_teacher` VALUES ('2125', '0', '0', '14', null, '16', '石峰区', 'age', '8', 'age8');
INSERT INTO `edu_statistic_teacher` VALUES ('2126', '0', '0', '1', null, '17', '邵阳市', 'age', '8', 'age8');
INSERT INTO `edu_statistic_teacher` VALUES ('2127', '0', '0', '17', null, '18', '双清区', 'age', '8', 'age8');
INSERT INTO `edu_statistic_teacher` VALUES ('2128', '0', '0', '17', null, '19', '北塔区', 'age', '8', 'age8');
INSERT INTO `edu_statistic_teacher` VALUES ('2143', '20', '0', '0', null, '1', '湖南省', 'age', '9', 'age9');
INSERT INTO `edu_statistic_teacher` VALUES ('2144', '13', '0', '1', null, '2', '长沙市', 'age', '9', 'age9');
INSERT INTO `edu_statistic_teacher` VALUES ('2145', '7', '0', '1', null, '3', '湘潭市', 'age', '9', 'age9');
INSERT INTO `edu_statistic_teacher` VALUES ('2146', '7', '0', '2', null, '4', '芙蓉区', 'age', '9', 'age9');
INSERT INTO `edu_statistic_teacher` VALUES ('2147', '3', '0', '2', null, '5', '天心区', 'age', '9', 'age9');
INSERT INTO `edu_statistic_teacher` VALUES ('2148', '2', '0', '2', null, '6', '望城区', 'age', '9', 'age9');
INSERT INTO `edu_statistic_teacher` VALUES ('2149', '1', '0', '2', null, '7', '雨花区', 'age', '9', 'age9');
INSERT INTO `edu_statistic_teacher` VALUES ('2150', '2', '0', '3', null, '8', '雨湖区', 'age', '9', 'age9');
INSERT INTO `edu_statistic_teacher` VALUES ('2151', '1', '0', '3', null, '9', '岳塘区', 'age', '9', 'age9');
INSERT INTO `edu_statistic_teacher` VALUES ('2152', '2', '0', '3', null, '10', '湘乡市', 'age', '9', 'age9');
INSERT INTO `edu_statistic_teacher` VALUES ('2153', '2', '0', '3', null, '11', '韶山市', 'age', '9', 'age9');
INSERT INTO `edu_statistic_teacher` VALUES ('2154', '0', '0', '1', null, '14', '株洲市', 'age', '9', 'age9');
INSERT INTO `edu_statistic_teacher` VALUES ('2155', '0', '0', '14', null, '15', '荷塘区', 'age', '9', 'age9');
INSERT INTO `edu_statistic_teacher` VALUES ('2156', '0', '0', '14', null, '16', '石峰区', 'age', '9', 'age9');
INSERT INTO `edu_statistic_teacher` VALUES ('2157', '0', '0', '1', null, '17', '邵阳市', 'age', '9', 'age9');
INSERT INTO `edu_statistic_teacher` VALUES ('2158', '0', '0', '17', null, '18', '双清区', 'age', '9', 'age9');
INSERT INTO `edu_statistic_teacher` VALUES ('2159', '0', '0', '17', null, '19', '北塔区', 'age', '9', 'age9');
INSERT INTO `edu_statistic_teacher` VALUES ('2174', '20', '0', '0', null, '1', '湖南省', 'age', '9', 'age9');
INSERT INTO `edu_statistic_teacher` VALUES ('2175', '13', '0', '1', null, '2', '长沙市', 'age', '9', 'age9');
INSERT INTO `edu_statistic_teacher` VALUES ('2176', '7', '0', '1', null, '3', '湘潭市', 'age', '9', 'age9');
INSERT INTO `edu_statistic_teacher` VALUES ('2177', '7', '0', '2', null, '4', '芙蓉区', 'age', '9', 'age9');
INSERT INTO `edu_statistic_teacher` VALUES ('2178', '3', '0', '2', null, '5', '天心区', 'age', '9', 'age9');
INSERT INTO `edu_statistic_teacher` VALUES ('2179', '2', '0', '2', null, '6', '望城区', 'age', '9', 'age9');
INSERT INTO `edu_statistic_teacher` VALUES ('2180', '1', '0', '2', null, '7', '雨花区', 'age', '9', 'age9');
INSERT INTO `edu_statistic_teacher` VALUES ('2181', '2', '0', '3', null, '8', '雨湖区', 'age', '9', 'age9');
INSERT INTO `edu_statistic_teacher` VALUES ('2182', '1', '0', '3', null, '9', '岳塘区', 'age', '9', 'age9');
INSERT INTO `edu_statistic_teacher` VALUES ('2183', '2', '0', '3', null, '10', '湘乡市', 'age', '9', 'age9');
INSERT INTO `edu_statistic_teacher` VALUES ('2184', '2', '0', '3', null, '11', '韶山市', 'age', '9', 'age9');
INSERT INTO `edu_statistic_teacher` VALUES ('2185', '0', '0', '1', null, '14', '株洲市', 'age', '9', 'age9');
INSERT INTO `edu_statistic_teacher` VALUES ('2186', '0', '0', '14', null, '15', '荷塘区', 'age', '9', 'age9');
INSERT INTO `edu_statistic_teacher` VALUES ('2187', '0', '0', '14', null, '16', '石峰区', 'age', '9', 'age9');
INSERT INTO `edu_statistic_teacher` VALUES ('2188', '0', '0', '1', null, '17', '邵阳市', 'age', '9', 'age9');
INSERT INTO `edu_statistic_teacher` VALUES ('2189', '0', '0', '17', null, '18', '双清区', 'age', '9', 'age9');
INSERT INTO `edu_statistic_teacher` VALUES ('2190', '0', '0', '17', null, '19', '北塔区', 'age', '9', 'age9');

-- ----------------------------
-- Table structure for `edu_statistic_year`
-- ----------------------------
DROP TABLE IF EXISTS `edu_statistic_year`;
CREATE TABLE `edu_statistic_year` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `year` varchar(4) DEFAULT NULL COMMENT '年度',
  `teacher_id` int(11) DEFAULT NULL COMMENT '教师ID',
  `teacher_name` varchar(100) DEFAULT NULL COMMENT '教师姓名',
  `teacher_score` float DEFAULT NULL COMMENT '总学分,汇总年度下所有项目的学分',
  `project_count` int(11) DEFAULT '0',
  `is_standard` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47596 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of edu_statistic_year
-- ----------------------------
INSERT INTO `edu_statistic_year` VALUES ('47540', '2014', '5', '李明', '8', '10', '1');
INSERT INTO `edu_statistic_year` VALUES ('47541', '2014', '6', '高力', '7', '6', '1');
INSERT INTO `edu_statistic_year` VALUES ('47542', '2014', '7', '李长兴', '5', '6', '1');
INSERT INTO `edu_statistic_year` VALUES ('47543', '2014', '8', '潘钰莹', '1', '2', '0');
INSERT INTO `edu_statistic_year` VALUES ('47544', '2014', '9', '杨伟峰', '2', '1', '0');
INSERT INTO `edu_statistic_year` VALUES ('47545', '2014', '10', '李亚平', '0', '1', '0');
INSERT INTO `edu_statistic_year` VALUES ('47546', '2014', '11', '李韦伯', '0', '0', '0');
INSERT INTO `edu_statistic_year` VALUES ('47547', '2014', '12', '黄雷', '0', '0', '0');
INSERT INTO `edu_statistic_year` VALUES ('47548', '2014', '13', '杨君', '3', '3', '0');
INSERT INTO `edu_statistic_year` VALUES ('47549', '2014', '16', '王宁', '0', '0', '0');
INSERT INTO `edu_statistic_year` VALUES ('47550', '2014', '17', '李军', '0', '0', '0');
INSERT INTO `edu_statistic_year` VALUES ('47551', '2014', '18', '李明一', '0', '6', '0');
INSERT INTO `edu_statistic_year` VALUES ('47552', '2014', '19', '高力景', '2', '1', '0');
INSERT INTO `edu_statistic_year` VALUES ('47553', '2014', '20', '李科', '0', '1', '0');
INSERT INTO `edu_statistic_year` VALUES ('47554', '2014', '21', '潘莹', '3', '2', '0');
INSERT INTO `edu_statistic_year` VALUES ('47555', '2014', '22', '杨峰', '0', '0', '0');
INSERT INTO `edu_statistic_year` VALUES ('47556', '2014', '23', '李平', '0', '0', '0');
INSERT INTO `edu_statistic_year` VALUES ('47557', '2014', '24', '李韦', '0', '0', '0');
INSERT INTO `edu_statistic_year` VALUES ('47558', '2014', '25', '黄雷磊', '0', '0', '0');
INSERT INTO `edu_statistic_year` VALUES ('47559', '2014', '26', 'dean测试', '0', '1', '0');
INSERT INTO `edu_statistic_year` VALUES ('47560', '2014', '35', '李宁波', '0', '2', '0');
INSERT INTO `edu_statistic_year` VALUES ('47561', '2014', '36', '王鹏', '0', '0', '0');
INSERT INTO `edu_statistic_year` VALUES ('47562', '2014', '38', '李焕', '5', '12', '1');
INSERT INTO `edu_statistic_year` VALUES ('47563', '2014', '39', '柳宁', '0', '7', '0');
INSERT INTO `edu_statistic_year` VALUES ('47564', '2014', '40', '邓果', '0', '0', '0');
INSERT INTO `edu_statistic_year` VALUES ('47571', '2014', '5', '李明', '8', '10', '1');
INSERT INTO `edu_statistic_year` VALUES ('47572', '2014', '6', '高力', '7', '6', '1');
INSERT INTO `edu_statistic_year` VALUES ('47573', '2014', '7', '李长兴', '5', '6', '1');
INSERT INTO `edu_statistic_year` VALUES ('47574', '2014', '8', '潘钰莹', '1', '2', '0');
INSERT INTO `edu_statistic_year` VALUES ('47575', '2014', '9', '杨伟峰', '2', '1', '0');
INSERT INTO `edu_statistic_year` VALUES ('47576', '2014', '10', '李亚平', '0', '1', '0');
INSERT INTO `edu_statistic_year` VALUES ('47577', '2014', '11', '李韦伯', '0', '0', '0');
INSERT INTO `edu_statistic_year` VALUES ('47578', '2014', '12', '黄雷', '0', '0', '0');
INSERT INTO `edu_statistic_year` VALUES ('47579', '2014', '13', '杨君', '3', '3', '0');
INSERT INTO `edu_statistic_year` VALUES ('47580', '2014', '16', '王宁', '0', '0', '0');
INSERT INTO `edu_statistic_year` VALUES ('47581', '2014', '17', '李军', '0', '0', '0');
INSERT INTO `edu_statistic_year` VALUES ('47582', '2014', '18', '李明一', '0', '6', '0');
INSERT INTO `edu_statistic_year` VALUES ('47583', '2014', '19', '高力景', '2', '1', '0');
INSERT INTO `edu_statistic_year` VALUES ('47584', '2014', '20', '李科', '0', '1', '0');
INSERT INTO `edu_statistic_year` VALUES ('47585', '2014', '21', '潘莹', '3', '2', '0');
INSERT INTO `edu_statistic_year` VALUES ('47586', '2014', '22', '杨峰', '0', '0', '0');
INSERT INTO `edu_statistic_year` VALUES ('47587', '2014', '23', '李平', '0', '0', '0');
INSERT INTO `edu_statistic_year` VALUES ('47588', '2014', '24', '李韦', '0', '0', '0');
INSERT INTO `edu_statistic_year` VALUES ('47589', '2014', '25', '黄雷磊', '0', '0', '0');
INSERT INTO `edu_statistic_year` VALUES ('47590', '2014', '26', 'dean测试', '0', '1', '0');
INSERT INTO `edu_statistic_year` VALUES ('47591', '2014', '35', '李宁波', '0', '2', '0');
INSERT INTO `edu_statistic_year` VALUES ('47592', '2014', '36', '王鹏', '0', '0', '0');
INSERT INTO `edu_statistic_year` VALUES ('47593', '2014', '38', '李焕', '5', '12', '1');
INSERT INTO `edu_statistic_year` VALUES ('47594', '2014', '39', '柳宁', '0', '7', '0');
INSERT INTO `edu_statistic_year` VALUES ('47595', '2014', '40', '邓果', '0', '0', '0');

-- ----------------------------
-- Table structure for `edu_sys_area`
-- ----------------------------
DROP TABLE IF EXISTS `edu_sys_area`;
CREATE TABLE `edu_sys_area` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `up_lv_code` varchar(20) DEFAULT NULL,
  `create_by` varchar(50) DEFAULT NULL,
  `update_by` varchar(50) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_date` timestamp NULL DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL COMMENT '类型 0：省 1：市 2：区',
  `area_code` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of edu_sys_area
-- ----------------------------
INSERT INTO `edu_sys_area` VALUES ('1', '1', '湖南省', '1', '0', null, null, '2014-05-21 09:27:44', '2014-05-21 09:27:44', '0', '39001');
INSERT INTO `edu_sys_area` VALUES ('2', '2', '长沙市', '1', '1', null, null, '2014-05-21 09:27:44', '2014-05-21 09:27:44', '1', '390001');
INSERT INTO `edu_sys_area` VALUES ('3', '3', '湘潭市', '1', '1', null, null, '2014-05-23 14:12:57', '2014-05-21 09:27:44', '1', '390002');
INSERT INTO `edu_sys_area` VALUES ('4', '4', '芙蓉区', '1', '2', null, null, '2014-05-21 09:27:44', '2014-05-21 09:27:44', '2', '3900011');
INSERT INTO `edu_sys_area` VALUES ('5', '5', '天心区', '1', '2', null, null, '2014-05-21 09:27:44', '2014-05-21 09:27:44', '2', '3900012');
INSERT INTO `edu_sys_area` VALUES ('6', '6', '望城区', '1', '2', null, null, '2014-05-21 09:27:44', '2014-05-21 09:27:44', '2', '3900013');
INSERT INTO `edu_sys_area` VALUES ('7', '7', '雨花区', '1', '2', null, null, '2014-05-21 09:27:44', '2014-05-21 09:27:44', '2', '3900014');
INSERT INTO `edu_sys_area` VALUES ('8', '8', '雨湖区', '1', '3', null, null, '2014-05-21 09:27:44', '2014-05-21 09:27:44', '2', '3900021');
INSERT INTO `edu_sys_area` VALUES ('9', '9', '岳塘区', '1', '3', null, null, '2014-05-21 09:27:44', '2014-05-21 09:27:44', '2', '3900022');
INSERT INTO `edu_sys_area` VALUES ('10', '10', '湘乡市', '1', '3', null, null, '2014-05-21 09:27:44', '2014-05-21 09:27:44', '2', '3900023');
INSERT INTO `edu_sys_area` VALUES ('11', '11', '韶山市', '1', '3', null, null, '2014-05-21 09:27:44', '2014-05-21 09:27:44', '2', '3900024');
INSERT INTO `edu_sys_area` VALUES ('12', '12', '衡阳市', '0', '1', 'hnadmin', 'hnadmin', '2014-05-23 14:18:28', '2014-05-23 14:14:40', '0', '390003');
INSERT INTO `edu_sys_area` VALUES ('14', '14', '株洲市', '1', '1', null, null, '2014-06-04 10:37:35', '2014-05-23 14:26:31', '1', '390003');
INSERT INTO `edu_sys_area` VALUES ('15', '15', '荷塘区', '1', '14', null, null, '2014-05-23 14:26:31', '2014-05-23 14:26:31', '2', '3900031');
INSERT INTO `edu_sys_area` VALUES ('16', '16', '石峰区', '1', '14', null, null, '2014-05-23 14:26:31', '2014-05-23 14:26:31', '2', '3900032');
INSERT INTO `edu_sys_area` VALUES ('17', '17', '邵阳市', '1', '1', null, null, '2014-06-04 11:17:19', '2014-06-04 10:47:49', '1', '3900104');
INSERT INTO `edu_sys_area` VALUES ('18', '18', '双清区', '1', '17', null, null, '2014-06-04 10:47:49', '2014-06-04 10:47:49', '2', '39001041');
INSERT INTO `edu_sys_area` VALUES ('19', '19', '北塔区', '1', '17', null, null, '2014-06-04 10:47:49', '2014-06-04 10:47:49', '2', '39001042');

-- ----------------------------
-- Table structure for `edu_sys_dictionary`
-- ----------------------------
DROP TABLE IF EXISTS `edu_sys_dictionary`;
CREATE TABLE `edu_sys_dictionary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dictionary_id` int(11) DEFAULT NULL COMMENT '字典id',
  `dictionary_type` varchar(100) DEFAULT NULL COMMENT '字典类型',
  `dictionary_type_name` varchar(100) DEFAULT NULL,
  `dictionary_name` varchar(100) DEFAULT NULL,
  `dictionary_code` varchar(100) DEFAULT NULL,
  `status` int(2) DEFAULT NULL COMMENT '1-有效，0-无效',
  PRIMARY KEY (`id`),
  KEY `dict_type` (`dictionary_type`)
) ENGINE=InnoDB AUTO_INCREMENT=148 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of edu_sys_dictionary
-- ----------------------------
INSERT INTO `edu_sys_dictionary` VALUES ('1', '1', 'project_subject', '学科', '小学语文', 'xk01', '0');
INSERT INTO `edu_sys_dictionary` VALUES ('2', '2', 'project_subject', '学科', '小学数学', 'xk02', '0');
INSERT INTO `edu_sys_dictionary` VALUES ('4', '1', 'stduty_section', '学段', '幼儿园', 'xd01', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('5', '2', 'stduty_section', '学段', '小学', 'xd02', '0');
INSERT INTO `edu_sys_dictionary` VALUES ('6', '1', 'project_status', '项目状态', '准备中', '', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('7', '2', 'project_status', '项目状态', '正在进行中', '', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('8', '3', 'project_status', '项目状态', '已结束', '', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('9', '1', 'project_score', '项目评分', '非常满意', '', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('10', '2', 'project_score', '项目评分', '满意', '', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('11', '3', 'project_score', '项目评分', '一般', '', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('12', '4', 'project_score', '项目评分', '不满意', '', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('13', '5', 'project_score', '项目评分', '非常不满意', '', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('14', '3', 'stduty_section', '学段', '初中', 'xd03', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('15', '4', 'stduty_section', '学段', '高中', 'xd04', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('17', '1', 'political_status', '政治面貌', '群众', 'zzmm002', '0');
INSERT INTO `edu_sys_dictionary` VALUES ('18', '2', 'political_status', '政治面貌', '党员', 'zzmm001', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('20', '3', 'project_subject', '学科', '小学美术', 'xk03', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('21', '4', 'project_subject', '学科', '小学音乐', 'xk04', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('24', '2', 'change_type', '信息变更类型', '调动', null, '1');
INSERT INTO `edu_sys_dictionary` VALUES ('25', '1', 'change_type', '信息变更类型', '信息变更', null, '1');
INSERT INTO `edu_sys_dictionary` VALUES ('26', '3', 'change_type', '信息变更类型', '离退休', null, '1');
INSERT INTO `edu_sys_dictionary` VALUES ('27', '5', 'project_subject', '学科', '初中语文', 'xk05', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('28', '6', 'project_subject', '学科', '初中数学', 'xk06', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('29', '1', 'school_type', '学校类型', '小学', null, '1');
INSERT INTO `edu_sys_dictionary` VALUES ('48', '1', 'study_grade', '年级', '一年级', 'nl01', null);
INSERT INTO `edu_sys_dictionary` VALUES ('49', '1', 'educational_user', '学历', '初中', 'xl01', null);
INSERT INTO `edu_sys_dictionary` VALUES ('50', '1', 'academic_degree', '学位', '博士', 'xw01', null);
INSERT INTO `edu_sys_dictionary` VALUES ('51', '1', 'teacher_seniority', '教师资格种类', '一级教师', 'jszg01', null);
INSERT INTO `edu_sys_dictionary` VALUES ('52', '1', 'teacher_professional', '教师职称', '正高级教师', 'jszh01', null);
INSERT INTO `edu_sys_dictionary` VALUES ('53', '1', 'project_scope', '项目范围', '国培项目', 'xm01', null);
INSERT INTO `edu_sys_dictionary` VALUES ('54', '1', 'project_nature', '项目性质', '教师培训', 'xmxz01', null);
INSERT INTO `edu_sys_dictionary` VALUES ('55', '1', 'Training type\r\nTraining type\r\nTraining type\r\ntraining_type', '培训类型', '远程', 'pxlx01', null);
INSERT INTO `edu_sys_dictionary` VALUES ('56', '1', 'teacher_osition', '教师职务', null, 'jszw01', null);
INSERT INTO `edu_sys_dictionary` VALUES ('59', '1', 'office_type', '学校行政职务', '普通教师', 'officetype001', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('60', '2', 'office_type', '学校行政职务', '高级教师', 'officetype002', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('61', '2', 'school_type', '学校类型', '初中', null, '1');
INSERT INTO `edu_sys_dictionary` VALUES ('62', '3', 'school_type', '学校类型', '高中', null, '1');
INSERT INTO `edu_sys_dictionary` VALUES ('63', '4', 'school_type', '学校类型', '职高', null, '1');
INSERT INTO `edu_sys_dictionary` VALUES ('64', '5', 'school_type', '学校类型', '幼儿园', null, '1');
INSERT INTO `edu_sys_dictionary` VALUES ('65', '32', 'change_type', '信息变更类型', '死亡', null, '1');
INSERT INTO `edu_sys_dictionary` VALUES ('66', '31', 'change_type', '信息变更类型', '退休', null, '1');
INSERT INTO `edu_sys_dictionary` VALUES ('67', '33', 'change_type', '信息变更类型', '离休', null, '1');
INSERT INTO `edu_sys_dictionary` VALUES ('68', '34', 'change_type', '信息变更类型', '离岗', null, '1');
INSERT INTO `edu_sys_dictionary` VALUES ('69', '35', 'change_type', '信息变更类型', '病休', null, '1');
INSERT INTO `edu_sys_dictionary` VALUES ('70', '36', 'change_type', '信息变更类型', '其他', null, '1');
INSERT INTO `edu_sys_dictionary` VALUES ('71', '2', 'project_scope', '项目范围', '省级项目', 'fw03', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('72', '2', 'project_nature', '项目性质', '骨干教师培训', 'xz01', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('73', '2', 'teacher_osition', '教师职务', '班导', 'zc01', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('74', '5', 'stduty_section', '学段', '初中英语', 'xk10', '0');
INSERT INTO `edu_sys_dictionary` VALUES ('75', '3', 'teacher_osition', '教师职务', '语文老师', 'xk08', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('76', '2', 'teacher_professional', '教师职称', '高级职称', 'zc01', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('77', '2', 'teacher_seniority', '教师资格种类', '教师特级等级', 'zg01', '0');
INSERT INTO `edu_sys_dictionary` VALUES ('78', '2', 'study_grade', '\n											年级\n										', '小学美术', 'H010', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('79', '3', 'project_scope', '\n											项目范围\n										', '准备中', 'K110', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('80', '6', 'stduty_section', '学段', '小学', 'xx01', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('81', '3', 'teacher_seniority', '\n											教师资格种类\n										', '湖南项目', 'hn007', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('82', '7', 'project_subject', '\n											学科\n										', '初中物理', 'xk099', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('83', '2', 'educational_user', '学历', '本科', 'XL001', '0');
INSERT INTO `edu_sys_dictionary` VALUES ('84', '3', 'political_status', '\n											政治面貌\n										', 'ZZMM', 'ZZMM', '0');
INSERT INTO `edu_sys_dictionary` VALUES ('85', '3', 'office_type', '\n											学校行政职务\n										', '职务', 'xxxzzw001', '0');
INSERT INTO `edu_sys_dictionary` VALUES ('86', '4', 'political_status', '政治面貌', '群众', 'zzmm002', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('87', '8', 'project_subject', '\n											学科\n										', '小学语文', 'xk02', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('88', '7', 'stduty_section', '\n											学段\n										', '都得', '阿斯顿飞', '0');
INSERT INTO `edu_sys_dictionary` VALUES ('89', null, 'teacher_staff', '\n											教师编制\n										', '事业编', 'bz001', '0');
INSERT INTO `edu_sys_dictionary` VALUES ('90', null, 'teacher_staff', '\n											教师编制\n										', '事业编1', 'bz003', '0');
INSERT INTO `edu_sys_dictionary` VALUES ('91', '8', 'stduty_section', '\n											学段\n										', '职高', 'xd06', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('92', '6', 'school_type', '\n											学校类型\n										', '幼儿园', 'xxlx01', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('93', '7', 'school_type', '\n											学校类型\n										', '小学类型', 'xxlx02', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('94', '9', 'stduty_section', '学段', '学段1', 'xdzd1', '0');
INSERT INTO `edu_sys_dictionary` VALUES ('95', '10', 'stduty_section', '学段', '学段2', 'xdzd2', '0');
INSERT INTO `edu_sys_dictionary` VALUES ('96', null, 'teacher_staff', '\n											教师编制\n										', '事业编', 'bz01', '0');
INSERT INTO `edu_sys_dictionary` VALUES ('97', null, 'teacher_staff', '\n											教师编制\n										', '企业编', 'bz02', '0');
INSERT INTO `edu_sys_dictionary` VALUES ('98', null, 'teacher_staff', '教师编制', '新编制', '1', '0');
INSERT INTO `edu_sys_dictionary` VALUES ('99', null, 'area_type', '\n													所在区划\n												', '城区', 'qh01', '0');
INSERT INTO `edu_sys_dictionary` VALUES ('100', '3', 'educational_user', '\n													学历\n												', '初中', 'xl01', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('101', '4', 'educational_user', '\n													学历\n												', '高中', 'xl02', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('102', '5', 'educational_user', '\n													学历\n												', '中专', 'xl03', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('103', '6', 'educational_user', '\n													学历\n												', '大专', 'xl04', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('104', '7', 'educational_user', '\n													学历\n												', '本科', 'xl05', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('105', '8', 'educational_user', '\n													学历\n												', '硕士研究生', 'xl06', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('106', '9', 'educational_user', '\n													学历\n												', '博士', 'xl07', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('107', '10', 'educational_user', '\n													学历\n												', '博士后', 'xl08', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('108', '2', 'academic_degree', '\n													学位\n												', '学士', 'xw01', '0');
INSERT INTO `edu_sys_dictionary` VALUES ('109', '3', 'academic_degree', '\n													学位\n												', '硕士', 'xw02', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('110', '4', 'academic_degree', '\n													学位\n												', '博士', 'xw03', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('111', null, 'school_nature', '\n													学校性质\n												', '公立', 'xxxz01', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('112', null, 'school_nature', '\n													学校性质\n												', '私立', 'xxxz02', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('113', '3', 'teacher_professional', '\n													教师职称\n												', '中级职称', 'zc02', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('114', '9', 'project_subject', '\n													学科\n												', '小学数学', 'xk01', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('115', '10', 'project_subject', '\n													学科\n												', '高中数学', 'xk07', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('116', '4', 'teacher_professional', '\n													教师职称\n												', '初级职称', 'zc03', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('117', '1', 'teacher_staff', '\n													教师编制\n												', '事业编', 'bz01', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('118', '1', 'area_type', '\n													所在区划\n												', '镇区', 'qh02', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('119', '1', 'school_nature', '\n													学校性质\n												', '民办', 'xxxz03', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('120', '5', 'academic_degree', '\n													学位\n												', '大学学士', 'xw01', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('121', '2', 'teacher_staff', '\n													教师编制\n												', '企业编制', 'bz03', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('122', '4', 'teacher_osition', '\n													教师职务\n												', '校长', 'zw02', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('123', '5', 'teacher_osition', '\n													教师职务\n												', '班主任', 'zw05', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('124', '4', 'office_type', '\n													学校行政职务\n												', '班主任', 'xzzw01', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('125', '5', 'office_type', '\n													学校行政职务\n												', '校长', 'xzzw02', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('126', '2', 'area_type', '\n													所在区划\n												', '乡村', 'qh03', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('127', '3', 'area_type', '\n													所在区划\n												', '城区', 'qh01', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('128', '4', 'teacher_seniority', '\n													教师资格种类\n												', '教师资格种类1', 'zgzl01', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('129', '5', 'teacher_seniority', '\n													教师资格种类\n												', '教师资格种类2', 'zgzl02', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('130', '6', 'office_type', '\n													学校行政职务\n												', '系主任', 'xxzw03', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('131', '3', 'teacher_staff', '\n													教师编制\n												', '编制外', 'bz02', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('132', '1', 'teacher_country', '国籍', '中国', 'gj01', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('133', '1', 'teacher_work_type', '教师岗位类别', '教师岗位', 'gw01', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('134', '1', 'teacher_work_lv', '教师岗位等级', '专业技术岗位二级', 'gwdj01', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('135', '1', 'teacher_diploma_type', '教师资格证种类', '初级中学教师资格', 'zgzzl01', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('136', '1', 'teacher_contract', '合同类型', '聘用合同', 'htlx01', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('137', '1', 'mandarin_lv', '普通话级别', '一级甲等', 'pthdj01', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('138', '1', 'free_teacher', '免费师范生 ', '地方免费师范生', 'mfsfs01', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('139', '1', 'special_teacher', '特岗教师', '中央特岗教师', 'tgjs01', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('140', '8', 'school_type', '\n													学校类型\n												', '初中教育学校', 'xxlx03', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('141', '9', 'school_type', '\n													学校类型\n												', '福建省教师进修学校', 'xxlx04', '0');
INSERT INTO `edu_sys_dictionary` VALUES ('142', '10', 'school_type', '\n													学校类型\n												', '高中教育学校', 'xxlx05', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('143', '11', 'school_type', '\n													学校类型\n												', '特殊学校', 'xxlx06', '0');
INSERT INTO `edu_sys_dictionary` VALUES ('144', '12', 'school_type', '\n													学校类型\n												', '小学教育学校', 'xxlx07', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('145', '13', 'school_type', '\n													学校类型\n												', '中等职业教育学校', 'xxlx08', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('146', '14', 'school_type', '\n													学校类型\n												', '特教学校', 'xxlx06', '1');
INSERT INTO `edu_sys_dictionary` VALUES ('147', '4', 'area_type', '所在区划', '21', '12', '0');

-- ----------------------------
-- Table structure for `edu_sys_function`
-- ----------------------------
DROP TABLE IF EXISTS `edu_sys_function`;
CREATE TABLE `edu_sys_function` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `func_name` varchar(100) DEFAULT NULL COMMENT '资源中文名称',
  `func_type` int(11) DEFAULT NULL COMMENT '资源类型： 1 频道 ； 2 模块；3 功能； 4 按钮',
  `func_code` varchar(50) NOT NULL,
  `func_url` varchar(100) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL COMMENT '排序字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=130 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of edu_sys_function
-- ----------------------------
INSERT INTO `edu_sys_function` VALUES ('1', '个人中心', '1', 'person_001', '', '1');
INSERT INTO `edu_sys_function` VALUES ('2', '个人中心设置', '2', 'person_002', '', '1');
INSERT INTO `edu_sys_function` VALUES ('3', '系统管理', '1', 'system_001', null, '2');
INSERT INTO `edu_sys_function` VALUES ('4', '系统管理', '2', 'system_002', null, '2');
INSERT INTO `edu_sys_function` VALUES ('5', '教师信息', '1', 'teacher_001', null, '3');
INSERT INTO `edu_sys_function` VALUES ('6', '教师信息', '2', 'teacher_002', null, '3');
INSERT INTO `edu_sys_function` VALUES ('7', '培训项目', '1', 'project_001', null, '4');
INSERT INTO `edu_sys_function` VALUES ('8', '培训项目管理 （旧）', '2', 'project_002', null, '4');
INSERT INTO `edu_sys_function` VALUES ('9', '继教信息', '1', 'furtheredu_001', null, '5');
INSERT INTO `edu_sys_function` VALUES ('10', '继教信息', '2', 'furtheredu_002', null, '5');
INSERT INTO `edu_sys_function` VALUES ('11', '地区管理', '3', 'system_003', null, '2');
INSERT INTO `edu_sys_function` VALUES ('13', '项目管理（旧）', '3', 'project_008', null, '2');
INSERT INTO `edu_sys_function` VALUES ('14', '设置报名方式（旧）', '3', 'project_003', null, '3');
INSERT INTO `edu_sys_function` VALUES ('15', '培训机构任务分配（旧）', '3', 'project_004', null, '4');
INSERT INTO `edu_sys_function` VALUES ('16', '培训项目管理(承培机构)', '3', 'project_030', '', '1');
INSERT INTO `edu_sys_function` VALUES ('17', '承培项目管理(承培机构)', '3', 'project_031', '', '2');
INSERT INTO `edu_sys_function` VALUES ('18', '项目状态设置(承培机构)', '3', 'project_032', '', '3');
INSERT INTO `edu_sys_function` VALUES ('19', '参训教师评价(承培机构)', '3', 'project_033', '', '4');
INSERT INTO `edu_sys_function` VALUES ('20', '查看教师评价(承培机构)', '3', 'project_034', '', '5');
INSERT INTO `edu_sys_function` VALUES ('21', '上传培训成绩(承培机构)', '3', 'project_035', '', '6');
INSERT INTO `edu_sys_function` VALUES ('22', '课程设置（旧）', '3', 'project_005', null, '5');
INSERT INTO `edu_sys_function` VALUES ('23', '项目评价（旧）', '3', 'project_006', null, '6');
INSERT INTO `edu_sys_function` VALUES ('24', '项目汇总统计', '3', 'project_007', null, '1');
INSERT INTO `edu_sys_function` VALUES ('25', '我的教师信息(教师)', '3', 'teacher_003', null, '1');
INSERT INTO `edu_sys_function` VALUES ('26', '项目学习(教师)', '3', 'project_010', null, '1');
INSERT INTO `edu_sys_function` VALUES ('27', '加入培训项目(教师)', '3', 'project_011', null, '1');
INSERT INTO `edu_sys_function` VALUES ('28', '查看培训成绩(教师)', '3', 'project_012', null, '1');
INSERT INTO `edu_sys_function` VALUES ('29', '教师成绩查询', '3', 'project_009', null, '9');
INSERT INTO `edu_sys_function` VALUES ('30', '继教信息(管理)', '3', 'furtheredu_003', null, '1');
INSERT INTO `edu_sys_function` VALUES ('31', '继教信息管理(管理)', '3', 'furtheredu_004', null, '2');
INSERT INTO `edu_sys_function` VALUES ('32', '年度考核设置(管理)', '3', 'furtheredu_005', null, '3');
INSERT INTO `edu_sys_function` VALUES ('33', '教师年度考核查询(管理)', '3', 'furtheredu_006', null, '4');
INSERT INTO `edu_sys_function` VALUES ('34', '年度证书模版设置', '3', 'furtheredu_007', null, '5');
INSERT INTO `edu_sys_function` VALUES ('35', '教师报名审核（旧）', '3', 'project_013', null, '1');
INSERT INTO `edu_sys_function` VALUES ('36', '教师信息管理', '3', 'teacher_004', null, '3');
INSERT INTO `edu_sys_function` VALUES ('39', '教师信息导入', '3', 'teacher_005', null, '2');
INSERT INTO `edu_sys_function` VALUES ('40', '继教考核查询(教师)', '3', 'furtheredu_008', null, '1');
INSERT INTO `edu_sys_function` VALUES ('41', '课程设置(机构)', '3', 'project_036', null, '7');
INSERT INTO `edu_sys_function` VALUES ('42', '教师打印证书(教师)', '3', 'furtheredu_009', null, '2');
INSERT INTO `edu_sys_function` VALUES ('43', '信息变更记录(教师)', '3', 'teacher_006', null, '1');
INSERT INTO `edu_sys_function` VALUES ('44', '角色管理', '3', 'system_004', null, '1');
INSERT INTO `edu_sys_function` VALUES ('45', '个人信息', '3', 'person_003', null, '1');
INSERT INTO `edu_sys_function` VALUES ('46', '修改密码', '3', 'person_004', null, '2');
INSERT INTO `edu_sys_function` VALUES ('47', '学校管理', '5', 'system_005', null, '2');
INSERT INTO `edu_sys_function` VALUES ('48', '生成管理员帐号', '3', 'system_006', null, '3');
INSERT INTO `edu_sys_function` VALUES ('49', '管理员管理', '3', 'system_007', null, '4');
INSERT INTO `edu_sys_function` VALUES ('50', '培训实施机构管理', '3', 'system_008', null, '5');
INSERT INTO `edu_sys_function` VALUES ('51', '数据字典管理', '3', 'system_009', null, '6');
INSERT INTO `edu_sys_function` VALUES ('52', '功能设置', '3', 'system_010', null, '7');
INSERT INTO `edu_sys_function` VALUES ('53', '学校管理-详情', '4', 'system_005_select', null, '1');
INSERT INTO `edu_sys_function` VALUES ('54', '学校管理-编辑', '4', 'system_005_update', null, '1');
INSERT INTO `edu_sys_function` VALUES ('55', '学校管理-删除', '4', 'system_005_delete', null, '1');
INSERT INTO `edu_sys_function` VALUES ('56', '管理员管理', '3', 'system_011', null, '1');
INSERT INTO `edu_sys_function` VALUES ('57', '管理员管理-详情', '4', 'system_011_select', null, '1');
INSERT INTO `edu_sys_function` VALUES ('58', '管理员管理-编辑', '4', 'system_011_update', null, '1');
INSERT INTO `edu_sys_function` VALUES ('59', '管理员管理-删除', '4', 'system_011_delete', null, '1');
INSERT INTO `edu_sys_function` VALUES ('60', '管理员管理-增加', '4', 'system_011_add', null, '1');
INSERT INTO `edu_sys_function` VALUES ('61', '管理员管理-导出', '4', 'system_011_export', null, '1');
INSERT INTO `edu_sys_function` VALUES ('62', '调动管理', '3', 'teacher_007', null, '1');
INSERT INTO `edu_sys_function` VALUES ('63', '调动管理-新增', '4', 'teacher_007_add', null, '1');
INSERT INTO `edu_sys_function` VALUES ('64', '调动管理-详情', '4', 'teacher_007_select', null, '1');
INSERT INTO `edu_sys_function` VALUES ('65', '调动管理-审核', '4', 'teacher_007_through', null, '1');
INSERT INTO `edu_sys_function` VALUES ('66', '通知', '3', 'person_005', null, '3');
INSERT INTO `edu_sys_function` VALUES ('67', '信息变更审核', '3', 'teacher_008', null, '8');
INSERT INTO `edu_sys_function` VALUES ('68', '教师离退休管理', '3', 'teacher_009', null, '9');
INSERT INTO `edu_sys_function` VALUES ('69', '教师信息审核', '3', 'teacher_002_1', null, '2');
INSERT INTO `edu_sys_function` VALUES ('70', '继教信息板块设置（行政/实施）', '3', 'project_014', null, '1');
INSERT INTO `edu_sys_function` VALUES ('71', '培训项目查询（行政/实施）', '3', 'project_015', null, '1');
INSERT INTO `edu_sys_function` VALUES ('72', '培训项目申报（行政/实施）', '3', 'project_016', null, '1');
INSERT INTO `edu_sys_function` VALUES ('73', '培训项目审核（行政/实施）', '3', 'project_017', null, '1');
INSERT INTO `edu_sys_function` VALUES ('74', '培训名额分配（行政/实施）', '3', 'project_018', null, '1');
INSERT INTO `edu_sys_function` VALUES ('75', '培训名额上报（行政/实施）', '3', 'project_019', null, '1');
INSERT INTO `edu_sys_function` VALUES ('76', '承培机构任务分配（行政/实施）', '3', 'project_020', null, '1');
INSERT INTO `edu_sys_function` VALUES ('77', '教师报名审核（行政/实施）', '3', 'project_021', null, '1');
INSERT INTO `edu_sys_function` VALUES ('78', '培训项目启动（行政/实施）', '3', 'project_022', null, '1');
INSERT INTO `edu_sys_function` VALUES ('79', '培训成绩导入（行政/实施）', '3', 'project_023', null, '1');
INSERT INTO `edu_sys_function` VALUES ('80', '培训总结（老师）', '3', 'project_024', null, '1');
INSERT INTO `edu_sys_function` VALUES ('81', '项目评价（行政/实施）', '3', 'project_025', null, '1');
INSERT INTO `edu_sys_function` VALUES ('82', '培训项目过程管理(承培机构)', '3', 'project_037', null, '8');
INSERT INTO `edu_sys_function` VALUES ('83', '培训总结(承培机构)', '3', 'project_038', null, '9');
INSERT INTO `edu_sys_function` VALUES ('84', '生成管理员帐号', '3', 'system_012', null, '1');
INSERT INTO `edu_sys_function` VALUES ('85', '提交项目总结报告（行政/实施）', '3', 'project_026', null, '1');
INSERT INTO `edu_sys_function` VALUES ('86', '项目调查与评估（行政/实施）', '3', 'project_027', null, '1');
INSERT INTO `edu_sys_function` VALUES ('87', '培训成绩发布（行政/实施）', '3', 'project_028', null, '1');
INSERT INTO `edu_sys_function` VALUES ('88', '培训项目关闭（行政/实施）', '3', 'project_029', null, '1');
INSERT INTO `edu_sys_function` VALUES ('89', '编制调整管理', '3', 'teacher_010', null, '1');
INSERT INTO `edu_sys_function` VALUES ('90', '编制调整管理-增加', '4', 'teacher_010_add', null, '1');
INSERT INTO `edu_sys_function` VALUES ('91', '编制调整管理-审核', '4', 'teacher_010_through', null, '1');
INSERT INTO `edu_sys_function` VALUES ('92', '承培机构管理', '3', 'system_013', null, '8');
INSERT INTO `edu_sys_function` VALUES ('93', '我的调动记录(教师)', '3', 'teacher_011', null, '1');
INSERT INTO `edu_sys_function` VALUES ('94', '项目调查(教师)', '3', 'project_040', null, '1');
INSERT INTO `edu_sys_function` VALUES ('95', '教师病休管理', '3', 'teacher_012', null, '1');
INSERT INTO `edu_sys_function` VALUES ('96', '教师离岗管理', '3', 'teacher_013', null, '1');
INSERT INTO `edu_sys_function` VALUES ('97', '教师死亡登记管理', '3', 'teacher_014', null, '1');
INSERT INTO `edu_sys_function` VALUES ('98', '教师返聘管理', '3', 'teacher_015', null, '1');
INSERT INTO `edu_sys_function` VALUES ('99', '教师病休审核', '3', 'teacher_016', null, '1');
INSERT INTO `edu_sys_function` VALUES ('100', '教师离岗审核', '3', 'teacher_017', null, '1');
INSERT INTO `edu_sys_function` VALUES ('101', '教师离退休审核', '3', 'teacher_018', null, '1');
INSERT INTO `edu_sys_function` VALUES ('102', '教师死亡登记审核', '3', 'teacher_019', null, '1');
INSERT INTO `edu_sys_function` VALUES ('103', '教师返聘审核', '3', 'teacher_020', null, '1');
INSERT INTO `edu_sys_function` VALUES ('104', '校本培训项目(管理)', '3', 'furtheredu_010', null, '3');
INSERT INTO `edu_sys_function` VALUES ('105', '非培训类项目(管理)', '3', 'furtheredu_011', null, '3');
INSERT INTO `edu_sys_function` VALUES ('106', '学分登记(管理)', '3', 'furtheredu_012', null, '3');
INSERT INTO `edu_sys_function` VALUES ('107', '学分审核(管理)', '3', 'furtheredu_013', null, '3');
INSERT INTO `edu_sys_function` VALUES ('108', '学分查询(管理)', '3', 'furtheredu_014', null, '3');
INSERT INTO `edu_sys_function` VALUES ('109', '项目证书打印(教师)', '3', 'furtheredu_015', null, '3');
INSERT INTO `edu_sys_function` VALUES ('110', '培训总结(教师)', '3', 'project_041', null, '1');
INSERT INTO `edu_sys_function` VALUES ('111', '继教证书', '2', 'furtheredu_016', null, '1');
INSERT INTO `edu_sys_function` VALUES ('112', '电子印章管理', '3', 'furtheredu_017', null, '1');
INSERT INTO `edu_sys_function` VALUES ('113', '项目证书设置', '3', 'furtheredu_018', null, '1');
INSERT INTO `edu_sys_function` VALUES ('114', '项目证书打印(实施/管理)', '3', 'furtheredu_019', null, '1');
INSERT INTO `edu_sys_function` VALUES ('115', '教师信息查询', '3', 'teacher_021', null, '1');
INSERT INTO `edu_sys_function` VALUES ('116', '学分兑换规则设置', '3', 'furtheredu_020', null, '1');
INSERT INTO `edu_sys_function` VALUES ('120', '系统设置', '3', 'system_020', null, '1');
INSERT INTO `edu_sys_function` VALUES ('121', '继教统计', '3', 'furtheredu_900', null, '1');
INSERT INTO `edu_sys_function` VALUES ('122', '继教统计', '3', 'furtheredu_901', null, null);
INSERT INTO `edu_sys_function` VALUES ('123', '学校统计', '3', 'system_021', null, null);
INSERT INTO `edu_sys_function` VALUES ('124', '教师信息统计', '3', 'teacher_900', null, null);
INSERT INTO `edu_sys_function` VALUES ('125', '按地区统计', '3', 'teacher_901', null, null);
INSERT INTO `edu_sys_function` VALUES ('126', '按学段统计', '3', 'teacher_902', null, null);
INSERT INTO `edu_sys_function` VALUES ('127', '培训总结(承培)', '3', 'project_044', null, '2');
INSERT INTO `edu_sys_function` VALUES ('128', '培训总结(实施)', '3', 'project_043', null, '2');
INSERT INTO `edu_sys_function` VALUES ('129', '培训总结(省)', '3', 'project_042', null, '2');

-- ----------------------------
-- Table structure for `edu_sys_platform_setup`
-- ----------------------------
DROP TABLE IF EXISTS `edu_sys_platform_setup`;
CREATE TABLE `edu_sys_platform_setup` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sys_style` int(11) DEFAULT NULL COMMENT '系统风格(0:深蓝色, 1:蓝色, 2:绿色, 3:红色)',
  `sys_name` varchar(200) DEFAULT NULL COMMENT '系统名称',
  `sys_logo` varchar(200) DEFAULT NULL COMMENT '系统LOGO',
  `login_logo` varchar(200) DEFAULT NULL COMMENT '登录LOGO',
  `copyright_notice` varchar(200) DEFAULT NULL COMMENT '版权声明',
  `contact_way` varchar(100) DEFAULT NULL COMMENT '联系方式',
  `create_by` varchar(100) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `update_by` varchar(100) DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of edu_sys_platform_setup
-- ----------------------------
INSERT INTO `edu_sys_platform_setup` VALUES ('1', '1', '教师继续教育管理平台', '/photo/logo.png', '/photo/logininfo.png', '© 2012-2062 中国教师教育网 版权所有。保留所有权利。 京ICP备12024815号/京ICP证120554号', '400-200-809', 'xitongadmin', '2014-05-26 13:37:32', 'xitongadmin', '2014-06-04 17:26:57');

-- ----------------------------
-- Table structure for `edu_sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `edu_sys_role`;
CREATE TABLE `edu_sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `create_by` varchar(100) DEFAULT NULL,
  `update_by` varchar(100) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of edu_sys_role
-- ----------------------------
INSERT INTO `edu_sys_role` VALUES ('1', '省管理员', '1', null, 'xitongadmin', null, '');
INSERT INTO `edu_sys_role` VALUES ('2', '市管理员', '1', null, 'xitongadmin', null, '');
INSERT INTO `edu_sys_role` VALUES ('3', '区管理员', '1', null, 'xitongadmin', null, '');
INSERT INTO `edu_sys_role` VALUES ('4', '校管理员', '1', null, 'xitongadmin', null, '');
INSERT INTO `edu_sys_role` VALUES ('5', '教师', '1', null, 'xitongadmin', null, '');
INSERT INTO `edu_sys_role` VALUES ('6', '承培机构管理员', '1', null, 'xitongadmin', null, '');
INSERT INTO `edu_sys_role` VALUES ('7', '实施机构管理员 （省）', '1', null, 'xitongadmin', null, '');
INSERT INTO `edu_sys_role` VALUES ('8', '实施机构管理员 （市）', '1', null, 'xitongadmin', null, '');
INSERT INTO `edu_sys_role` VALUES ('9', '实施机构管理员 （区）', '1', null, null, null, null);
INSERT INTO `edu_sys_role` VALUES ('10', '实施机构管理员 （校）', '1', null, 'xitongadmin', null, '');
INSERT INTO `edu_sys_role` VALUES ('20', '专家', '1', null, 'xitongadmin', null, '');
INSERT INTO `edu_sys_role` VALUES ('33', '系统管理员', '1', null, 'xitongadmin', null, '');

-- ----------------------------
-- Table structure for `edu_sys_setup`
-- ----------------------------
DROP TABLE IF EXISTS `edu_sys_setup`;
CREATE TABLE `edu_sys_setup` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `account_type` varchar(20) DEFAULT NULL COMMENT '可用登录方式(1:身份证号, 2:用户名, 3:教师编号)',
  `use_teacher_role` int(11) DEFAULT NULL COMMENT '是否关闭教师登录(1: 不关闭, 0:关闭)',
  `open_register_teacher` int(11) DEFAULT NULL COMMENT '是否开放注册教师(1:开放 0:关闭)',
  `teacher_info_change_audit` int(11) DEFAULT NULL COMMENT '教师信息变动审核(1:允许同级审核 0:不允许)',
  `teacher_info_safe` int(11) DEFAULT NULL COMMENT '教师信息导出安全(1:允许查看/导出身份证号和手机号 0:不允许)',
  `teacher_module_auther_id` varchar(200) DEFAULT NULL COMMENT '教师信息模块管理授权',
  `teacher_module_auther_name` varchar(500) DEFAULT NULL,
  `furtheredu_module_auther_id` varchar(200) DEFAULT NULL COMMENT '继教信息模块管理授权',
  `furtheredu_module_auther_name` varchar(500) DEFAULT NULL,
  `create_by` varchar(20) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `update_by` varchar(20) DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of edu_sys_setup
-- ----------------------------
INSERT INTO `edu_sys_setup` VALUES ('1', '1,2', '1', '1', '1', '1', null, null, null, null, 'xitongadmin', '2014-04-28 18:20:23', 'shengadmin', '2014-06-07 14:40:33');

-- ----------------------------
-- Table structure for `edu_sys_signet`
-- ----------------------------
DROP TABLE IF EXISTS `edu_sys_signet`;
CREATE TABLE `edu_sys_signet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `signet_name` varchar(100) DEFAULT NULL COMMENT '印章名称',
  `signet_url` varchar(500) DEFAULT NULL COMMENT '印章图片地址',
  `flag` int(11) DEFAULT NULL COMMENT '是否可用1：可用   0：禁用',
  `create_by` varchar(50) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `update_by` varchar(50) DEFAULT NULL,
  `update_date` date DEFAULT NULL COMMENT '电子印章表',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of edu_sys_signet
-- ----------------------------
INSERT INTO `edu_sys_signet` VALUES ('1', '印章1', '/photo/1400738844865.jpg', '0', 'hnssadmin1', '2014-05-22', '王丽', '2014-05-22');
INSERT INTO `edu_sys_signet` VALUES ('2', '印章1', '/photo/1400739008679.jpg', '1', 'hnssadmin1', '2014-05-22', 'hnssadmin1', '2014-05-22');
INSERT INTO `edu_sys_signet` VALUES ('3', '印章2', '/photo/1401246120942.png', '1', 'hnadmin', '2014-05-28', 'hnadmin', '2014-05-28');
INSERT INTO `edu_sys_signet` VALUES ('4', '报道专用章', '/photo/1401848968504.png', '1', 'shengadmin', '2014-06-04', 'shengadmin', '2014-06-04');
INSERT INTO `edu_sys_signet` VALUES ('5', '123', '/photo/1401874077994.jpg', '1', 'shengadmin', '2014-06-04', 'shengadmin', '2014-06-04');

-- ----------------------------
-- Table structure for `edu_target_by_year`
-- ----------------------------
DROP TABLE IF EXISTS `edu_target_by_year`;
CREATE TABLE `edu_target_by_year` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `year` varchar(4) DEFAULT NULL COMMENT '年度',
  `class_period` varchar(4) DEFAULT NULL COMMENT '学时',
  `class_score` varchar(4) DEFAULT NULL COMMENT '学分',
  `status` int(11) DEFAULT NULL,
  `province_id` int(11) DEFAULT NULL COMMENT '省ID',
  `province_name` varchar(30) DEFAULT NULL,
  `city_id` int(11) DEFAULT NULL COMMENT '市ID',
  `city_name` varchar(30) DEFAULT NULL,
  `district_id` int(11) DEFAULT NULL COMMENT '区ID',
  `district_name` varchar(30) DEFAULT NULL,
  `school_id` int(11) DEFAULT NULL,
  `school_name` varchar(100) DEFAULT NULL,
  `create_by` varchar(50) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `update_by` varchar(30) DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of edu_target_by_year
-- ----------------------------
INSERT INTO `edu_target_by_year` VALUES ('4', '2014', null, '4', '1', '1', '湖南省', null, '', null, '', null, '', null, '2014-05-22', 'shengadmin', '2014-06-05');

-- ----------------------------
-- Table structure for `edu_teacher_basic_info`
-- ----------------------------
DROP TABLE IF EXISTS `edu_teacher_basic_info`;
CREATE TABLE `edu_teacher_basic_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_id` int(11) DEFAULT NULL,
  `teacher_old_name` varchar(50) DEFAULT NULL COMMENT '曾用名',
  `teacher_name_spelling` varchar(50) DEFAULT NULL COMMENT '姓名全拼',
  `teacher_born_date` date DEFAULT NULL COMMENT '出生日期',
  `teacher_political_status` varchar(10) DEFAULT NULL COMMENT '政治面貌',
  `teacher_native_place` varchar(20) DEFAULT NULL COMMENT '籍贯',
  `teacher_nation` varchar(10) DEFAULT NULL COMMENT '民族',
  `teacher_phone_num` varchar(30) DEFAULT NULL COMMENT '手机号码',
  `teacher_call_num` varchar(30) DEFAULT NULL COMMENT '联系电话',
  `teacher_qq` int(11) DEFAULT NULL COMMENT 'QQ',
  `teacher_email` varchar(50) DEFAULT NULL COMMENT 'Email',
  `teacher_family_local` varchar(50) DEFAULT NULL COMMENT '家庭住址',
  `teacher_marital_status` int(2) DEFAULT NULL COMMENT '婚姻状况,1:已婚，0：未婚',
  `teacher_health_condition` varchar(50) DEFAULT NULL COMMENT '健康状况',
  `version` int(11) DEFAULT NULL,
  `teacher_create_by` varchar(20) DEFAULT NULL,
  `teacher_update_by` varchar(20) DEFAULT NULL,
  `teacher_create_date` timestamp NULL DEFAULT NULL,
  `teacher_update_date` timestamp NULL DEFAULT NULL,
  `status` int(5) DEFAULT NULL,
  `teacher_country` int(11) DEFAULT NULL COMMENT '国籍读取数据字典',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of edu_teacher_basic_info
-- ----------------------------
INSERT INTO `edu_teacher_basic_info` VALUES ('1', '5', null, null, null, '2', null, null, '13818812121', null, null, 'test1@173.com', null, null, null, '1', 'hnadmin', 'hnadmin', '2014-05-21 10:04:25', '2014-05-21 10:04:25', '1', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('2', '6', null, null, null, '2', null, null, '13818812122', null, null, 'test2@8718.com', null, null, null, '1', 'hnadmin', 'hnadmin', '2014-05-21 10:04:25', '2014-05-21 10:04:25', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('3', '7', null, null, null, '2', null, null, '13818812123', null, null, null, null, null, null, '1', 'hnadmin', 'hnadmin', '2014-05-21 10:04:25', '2014-05-21 10:04:25', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('4', '8', null, null, null, '2', null, null, '13818812124', null, null, null, null, null, null, '1', 'hnadmin', 'hnadmin', '2014-05-21 10:04:25', '2014-05-21 10:04:25', '1', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('5', '9', null, null, null, '2', null, null, '13818812125', null, null, null, null, null, null, '1', 'hnadmin', 'hnadmin', '2014-05-21 10:04:25', '2014-05-21 10:04:25', '1', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('6', '10', null, null, null, '2', null, null, '13818812126', null, null, null, null, null, null, '1', 'hnadmin', 'hnadmin', '2014-05-21 10:04:25', '2014-05-21 10:04:25', '1', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('7', '11', null, null, null, '1', null, null, '13818812127', null, null, null, null, null, null, '1', 'hnadmin', 'hnadmin', '2014-05-21 10:04:25', '2014-05-21 10:04:25', '1', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('8', '12', null, null, null, '1', null, null, '13818812128', null, null, 'asdf@192.com', null, null, null, '1', 'hnadmin', 'hnadmin', '2014-05-21 10:04:25', '2014-05-21 10:04:25', '1', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('9', '13', null, null, null, null, null, null, null, null, null, null, null, null, null, '1', 'hnadmin', 'hnadmin', '2014-05-21 10:24:46', '2014-05-21 10:24:46', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('10', '13', null, null, null, null, null, null, null, null, null, null, null, null, null, '2', 'hnadmin', 'hnadmin', '2014-05-21 10:24:46', '2014-05-21 11:04:23', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('11', '16', null, null, null, null, null, null, null, null, null, null, null, null, null, '1', 'hnadmin', 'hnadmin', '2014-05-23 15:58:30', '2014-05-23 15:58:30', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('12', '16', null, null, null, null, null, null, null, null, null, null, null, null, null, '2', 'hnadmin', 'hnadmin', '2014-05-23 15:58:30', '2014-05-23 16:17:24', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('13', '16', null, null, null, null, null, null, null, null, null, null, null, null, null, '3', 'hnadmin', 'hnadmin', '2014-05-23 15:58:30', '2014-05-23 16:20:48', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('14', '16', null, null, null, null, null, null, null, null, null, null, null, null, null, '4', 'hnadmin', 'hnadmin', '2014-05-23 15:58:30', '2014-05-23 16:23:15', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('15', '16', null, null, null, null, null, null, null, null, null, null, null, null, null, '5', 'hnadmin', 'hnadmin', '2014-05-23 15:58:30', '2014-05-23 16:31:44', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('16', '16', null, null, null, null, null, null, null, null, null, null, null, null, null, '6', 'hnadmin', 'hnadmin', '2014-05-23 15:58:30', '2014-05-23 16:34:02', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('17', '16', null, null, null, null, null, null, null, null, null, null, null, null, null, '7', 'hnadmin', 'hnadmin', '2014-05-23 15:58:30', '2014-05-23 16:35:48', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('18', '17', null, null, null, null, null, null, null, null, null, null, null, null, null, '1', 'hnadmin', 'hnadmin', '2014-05-23 16:50:07', '2014-05-23 16:50:07', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('19', '16', null, null, null, null, null, null, null, null, null, null, null, null, null, '8', 'hnadmin', 'hnadmin', '2014-05-23 15:58:30', '2014-05-23 17:17:49', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('20', '16', null, null, null, null, null, null, null, null, null, null, null, null, null, '9', 'hnadmin', 'hnadmin', '2014-05-23 15:58:30', '2014-05-23 17:20:30', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('21', '16', null, null, null, null, null, null, null, null, null, null, null, null, null, '10', 'hnadmin', 'hnadmin', '2014-05-23 15:58:30', '2014-05-23 17:21:05', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('22', '18', null, null, null, '2', null, null, '13918812121', null, null, 'test1@173.com', null, null, null, '1', 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-26 09:45:48', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('23', '19', null, null, null, '2', null, null, '13918812122', null, null, 'test2@8718.com', null, null, null, '1', 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-26 09:45:48', '1', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('24', '20', null, null, null, '2', null, null, '13918812123', null, null, null, null, null, null, '1', 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-26 09:45:48', '1', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('25', '21', '', '', '1977-05-05', '2', '', '', '13918812124', '', null, '', '', null, '', '1', 'shengadmin', 'shengadmin', '2014-05-29 00:00:00', '2014-05-29 00:00:00', '1', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('26', '22', null, null, null, '2', null, null, '13918812125', null, null, null, null, null, null, '1', 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-26 09:45:48', '1', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('27', '23', null, null, null, '2', null, null, '13918812126', null, null, null, null, null, null, '1', 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-26 09:45:48', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('28', '24', null, null, null, '4', null, null, '13918812127', null, null, null, null, null, null, '1', 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-26 09:45:48', '1', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('29', '25', null, null, null, '4', null, null, '13918812128', null, null, 'asdf@192.com', null, null, null, '1', 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-26 09:45:48', '1', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('30', '18', null, null, null, '2', null, null, '13918812121', null, null, 'test1@173.com', null, null, null, '2', 'hnadmin', 'laoshi21', '2014-05-26 09:45:48', '2014-05-26 10:08:50', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('31', '18', null, null, null, '2', null, null, '13918812121', null, null, 'test1@173.com', null, null, null, '3', 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-26 10:10:35', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('32', '18', null, null, null, '2', null, null, '13918812121', null, null, 'test1@173.com', null, null, null, '4', 'hnadmin', 'laoshi21', '2014-05-26 09:45:48', '2014-05-26 10:14:01', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('33', '26', '1', '', null, '', '', '', '', '', null, '', '', null, '', '1', 'hnadmin', 'hnadmin', '2014-05-26 00:00:00', '2014-05-26 00:00:00', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('34', '16', null, null, null, null, null, null, null, null, null, null, null, null, null, '11', 'hnadmin', 'hnadmin', '2014-05-23 15:58:30', '2014-05-26 10:30:27', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('35', '18', null, null, null, '2', null, null, '13918812121', null, null, 'test1@173.com', null, null, null, '5', 'hnadmin', 'laoshi21', '2014-05-26 09:45:48', '2014-05-26 15:23:48', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('36', '18', null, null, null, '2', null, null, '13918812121', null, null, 'test1@173.com', null, null, null, '6', 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-26 15:36:00', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('37', '18', null, null, null, '2', null, null, '13918812121', null, null, 'test1@173.com', null, null, null, '7', 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-27 14:43:34', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('38', '18', null, null, null, '2', null, null, '13918812121', null, null, 'test1@173.com', null, null, null, '8', 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-27 14:44:03', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('39', '23', '', '', '1989-05-04', '', '', '', '', '', null, '', '', null, '', '2', 'shengadmin', 'shengadmin', '2014-05-29 00:00:00', '2014-05-29 00:00:00', '1', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('41', '18', null, null, null, '2', null, null, '13918812121', null, null, 'test1@173.com', null, null, null, '9', 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-28 09:09:38', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('42', '22', null, null, null, '2', null, null, '13918812125', null, null, null, null, null, null, '2', 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-28 09:10:30', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('44', '23', null, null, null, '2', null, null, '13918812126', null, null, null, null, null, null, '3', 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-28 09:13:25', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('51', '13', null, null, null, null, null, null, null, null, null, null, null, null, null, '3', 'hnadmin', 'hnadmin', '2014-05-21 10:24:46', '2014-05-28 09:22:24', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('52', '13', null, null, null, null, null, null, null, null, null, null, null, null, null, '4', 'hnadmin', 'hnadmin', '2014-05-21 10:24:46', '2014-05-28 09:55:31', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('53', '13', null, null, null, null, null, null, null, null, null, null, null, null, null, '5', 'hnadmin', 'hnadmin', '2014-05-21 10:24:46', '2014-05-28 10:00:20', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('54', '13', null, null, null, null, null, null, null, null, null, null, null, null, null, '6', 'hnadmin', 'hnadmin', '2014-05-21 10:24:46', '2014-05-28 10:13:39', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('55', '13', null, null, null, null, null, null, null, null, null, null, null, null, null, '7', 'hnadmin', 'hnadmin', '2014-05-21 10:24:46', '2014-05-28 10:14:34', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('56', '13', null, null, null, null, null, null, null, null, null, null, null, null, null, '8', 'hnadmin', 'hnadmin', '2014-05-21 10:24:46', '2014-05-28 10:19:34', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('57', '13', null, null, null, null, null, null, null, null, null, null, null, null, null, '9', 'hnadmin', 'hnadmin', '2014-05-21 10:24:46', '2014-05-28 10:22:16', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('58', '13', null, null, null, null, null, null, null, null, null, null, null, null, null, '10', 'hnadmin', 'hnadmin', '2014-05-21 10:24:46', '2014-05-28 10:25:29', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('59', '13', null, null, null, null, null, null, null, null, null, null, null, null, null, '11', 'hnadmin', 'hnadmin', '2014-05-21 10:24:46', '2014-05-28 10:38:24', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('60', '6', null, null, null, '2', null, null, '13818812122', null, null, 'test2@8718.com', null, null, null, '2', 'hnadmin', 'hnadmin', '2014-05-21 10:04:25', '2014-05-28 10:53:16', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('61', '6', null, null, null, '2', null, null, '13818812122', null, null, 'test2@8718.com', null, null, null, '3', 'hnadmin', 'hnadmin', '2014-05-21 10:04:25', '2014-05-28 10:54:31', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('62', '6', null, null, null, '2', null, null, '13818812122', null, null, 'test2@8718.com', null, null, null, '4', 'hnadmin', 'hnadmin', '2014-05-21 10:04:25', '2014-05-28 10:55:13', '1', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('63', '7', null, null, null, '2', null, null, '13818812123', null, null, null, null, null, null, '2', 'hnadmin', 'hnadmin', '2014-05-21 10:04:25', '2014-05-28 16:20:48', '1', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('65', '18', '', '', '1979-05-03', '2', '', '', '13918812121', '', null, 'test1@173.com', '', '1', '', '10', 'shengadmin', 'shengadmin', '2014-05-29 00:00:00', '2014-05-29 00:00:00', '1', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('66', '35', '', '', '1993-05-01', '2', '', '', '', '', null, '', '', '0', '', '1', 'shengadmin', 'shengadmin', '2014-05-29 00:00:00', '2014-05-29 00:00:00', '1', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('67', '13', null, null, null, null, null, null, null, null, null, null, null, null, null, '12', 'hnadmin', 'shengadmin', '2014-05-21 10:24:46', '2014-05-29 16:01:02', '1', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('68', '36', null, null, null, null, null, null, null, null, null, null, null, null, null, '1', 'shengadmin', 'shengadmin', '2014-05-29 16:01:59', '2014-05-29 16:01:59', '1', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('69', '16', null, null, null, null, null, null, null, null, null, null, null, null, null, '12', 'hnadmin', 'shengadmin', '2014-05-23 15:58:30', '2014-05-29 16:39:28', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('70', '16', null, null, null, null, null, null, null, null, null, null, null, null, null, '13', 'hnadmin', 'shengadmin', '2014-05-23 15:58:30', '2014-05-29 16:40:16', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('71', '16', null, null, null, null, null, null, null, null, null, null, null, null, null, '14', 'hnadmin', 'shengadmin', '2014-05-23 15:58:30', '2014-05-29 16:41:20', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('72', '16', null, null, null, null, null, null, null, null, null, null, null, null, null, '15', 'hnadmin', 'shengadmin', '2014-05-23 15:58:30', '2014-05-29 16:42:01', '1', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('73', '38', '李欢', 'lihuan', '1989-06-06', '2', '山东', '汉', '13718182121', '61572881', '123456', 'lihuan@163.com', '北京市海淀区', '0', '良好', '1', 'shengadmin', 'shengadmin', '2014-06-04 00:00:00', '2014-06-04 00:00:00', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('74', '39', null, null, null, null, null, null, null, null, null, null, null, null, null, '1', 'shengadmin', 'shengadmin', '2014-06-04 13:57:02', '2014-06-04 13:57:02', '1', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('75', '26', '1', '', null, '', '', '', '', '', null, '', '', null, '', '2', 'hnadmin', 'shengadmin', '2014-05-26 00:00:00', '2014-06-04 14:03:15', '1', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('76', '17', null, null, null, null, null, null, null, null, null, null, null, null, null, '2', 'hnadmin', 'shengadmin', '2014-05-23 16:50:07', '2014-06-04 14:06:24', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('77', '17', null, null, null, null, null, null, null, null, null, null, null, null, null, '3', 'hnadmin', 'shengadmin', '2014-05-23 16:50:07', '2014-06-04 14:08:20', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('78', '17', null, null, null, null, null, null, null, null, null, null, null, null, null, '4', 'hnadmin', 'shengadmin', '2014-05-23 16:50:07', '2014-06-04 14:15:42', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('79', '17', null, null, null, null, null, null, null, null, null, null, null, null, null, '5', 'hnadmin', 'shengadmin', '2014-05-23 16:50:07', '2014-06-04 14:17:47', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('80', '17', null, null, null, null, null, null, null, null, null, null, null, null, null, '6', 'hnadmin', 'shengadmin', '2014-05-23 16:50:07', '2014-06-04 14:18:09', '1', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('81', '38', '李欢', 'lihuan', '1989-06-06', '2', '山东', '汉', '13718182121', '61572881', '123456', 'lihuan@163.com', '北京市海淀区', '0', '良好', '2', 'shengadmin', 'shengadmin', '2014-06-04 00:00:00', '2014-06-04 14:34:11', '1', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('82', '5', null, null, null, '2', null, null, '13818812121', null, null, 'test1@173.com', null, null, null, '2', 'hnadmin', 'teacher1', '2014-05-21 10:04:25', '2014-06-05 09:33:22', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('83', '40', '11', '11', null, '', '', '11', '', '', null, '', '', null, '', '1', 'xuexiaoadmin', 'xuexiaoadmin', '2014-06-06 00:00:00', '2014-06-06 00:00:00', '0', '1');
INSERT INTO `edu_teacher_basic_info` VALUES ('84', '40', '11', '11', null, '', '', '11', '', '', null, '', '', null, '', '2', 'xuexiaoadmin', 'xuexiaoadmin', '2014-06-06 00:00:00', '2014-06-06 17:27:44', '0', '1');
INSERT INTO `edu_teacher_basic_info` VALUES ('85', '40', '11', '11', null, '', '', '11', '', '', null, '', '', null, '', '2', 'xuexiaoadmin', 'xuexiaoadmin', '2014-06-06 00:00:00', '2014-06-06 17:27:44', '0', '1');
INSERT INTO `edu_teacher_basic_info` VALUES ('86', '40', '11', '11', null, '', '', '11', '', '', null, '', '', null, '', '3', 'xuexiaoadmin', 'xuexiaoadmin', '2014-06-06 00:00:00', '2014-06-06 17:31:26', '0', '1');
INSERT INTO `edu_teacher_basic_info` VALUES ('87', '40', '11', '11', null, '', '', '11', '', '', null, '', '', null, '', '4', 'xuexiaoadmin', 'xuexiaoadmin', '2014-06-06 00:00:00', '2014-06-06 17:32:33', '0', '1');
INSERT INTO `edu_teacher_basic_info` VALUES ('88', '40', '11', '11', null, '', '', '11', '', '', null, '', '', null, '', '5', 'xuexiaoadmin', 'xuexiaoadmin', '2014-06-06 00:00:00', '2014-06-06 17:38:31', '0', '1');
INSERT INTO `edu_teacher_basic_info` VALUES ('90', '38', '李欢', 'lihuan', '1989-06-06', '2', '山东', '汉', '13718182121', '61572881', '123456', 'lihuan@163.com', '北京市海淀区', '0', '良好', '3', 'shengadmin', 'teacher4', '2014-06-04 00:00:00', '2014-06-06 18:07:02', '0', null);
INSERT INTO `edu_teacher_basic_info` VALUES ('94', '40', '11', '11', null, '', '', '11', '', '', null, '', '', null, '', '6', 'xuexiaoadmin', 'shengadmin', '2014-06-06 00:00:00', '2014-06-07 10:12:13', '1', '1');

-- ----------------------------
-- Table structure for `edu_teacher_education`
-- ----------------------------
DROP TABLE IF EXISTS `edu_teacher_education`;
CREATE TABLE `edu_teacher_education` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_id` int(11) DEFAULT NULL,
  `education_experience_type` int(5) DEFAULT NULL,
  `education_experience` varchar(10) DEFAULT NULL COMMENT '学历',
  `education_degree_type` int(5) DEFAULT NULL,
  `education_degree` varchar(20) DEFAULT NULL COMMENT '获得学位',
  `education_graduation_time` date DEFAULT NULL COMMENT '毕业时间',
  `education_graduation_school` varchar(50) DEFAULT NULL COMMENT '毕业院校',
  `education_graduation_profession` varchar(50) DEFAULT NULL COMMENT '毕业专业',
  `sort` int(11) DEFAULT NULL COMMENT '待定排序，区分第一学历，第二学历....',
  `education_update_by` varchar(20) DEFAULT NULL,
  `education_create_by` varchar(20) DEFAULT NULL,
  `education_create_date` timestamp NULL DEFAULT NULL,
  `education_update_date` timestamp NULL DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `status` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `teacher_id` (`teacher_id`),
  KEY `experience_type` (`education_experience_type`)
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of edu_teacher_education
-- ----------------------------
INSERT INTO `edu_teacher_education` VALUES ('1', '5', '5', '本科', '1', '学士', '1998-03-09', '北理工', '教育学', '1', 'hnadmin', 'hnadmin', '2014-05-21 10:04:25', '2014-05-21 10:04:25', '1', '1');
INSERT INTO `edu_teacher_education` VALUES ('2', '6', null, null, null, null, null, '', '', '1', 'hnadmin', 'hnadmin', '2014-05-21 10:04:25', '2014-05-21 10:04:25', '1', '0');
INSERT INTO `edu_teacher_education` VALUES ('3', '7', null, null, null, null, null, '', '', '1', 'hnadmin', 'hnadmin', '2014-05-21 10:04:25', '2014-05-21 10:04:25', '1', '0');
INSERT INTO `edu_teacher_education` VALUES ('4', '8', null, null, null, null, null, '', '', '1', 'hnadmin', 'hnadmin', '2014-05-21 10:04:25', '2014-05-21 10:04:25', '1', '1');
INSERT INTO `edu_teacher_education` VALUES ('5', '9', null, null, null, null, null, '', '', '1', 'hnadmin', 'hnadmin', '2014-05-21 10:04:25', '2014-05-21 10:04:25', '1', '1');
INSERT INTO `edu_teacher_education` VALUES ('6', '10', null, null, null, null, null, '', '', '1', 'hnadmin', 'hnadmin', '2014-05-21 10:04:25', '2014-05-21 10:04:25', '1', '1');
INSERT INTO `edu_teacher_education` VALUES ('7', '11', null, null, null, null, null, '', '', '1', 'hnadmin', 'hnadmin', '2014-05-21 10:04:25', '2014-05-21 10:04:25', '1', '1');
INSERT INTO `edu_teacher_education` VALUES ('8', '12', '5', '本科', '1', '学士', null, '', '', '1', 'hnadmin', 'hnadmin', '2014-05-21 10:04:25', '2014-05-21 10:04:25', '1', '1');
INSERT INTO `edu_teacher_education` VALUES ('9', '13', null, null, null, null, null, null, null, '1', 'hnadmin', 'hnadmin', '2014-05-21 10:24:46', '2014-05-21 10:24:46', '1', '0');
INSERT INTO `edu_teacher_education` VALUES ('10', '13', null, null, null, null, null, null, null, '1', 'hnadmin', 'hnadmin', '2014-05-21 10:24:46', '2014-05-21 11:04:23', '2', '0');
INSERT INTO `edu_teacher_education` VALUES ('11', '16', null, null, null, null, null, null, null, '1', 'hnadmin', 'hnadmin', '2014-05-23 15:58:30', '2014-05-23 15:58:30', '1', '0');
INSERT INTO `edu_teacher_education` VALUES ('12', '16', null, null, null, null, null, null, null, '1', 'hnadmin', 'hnadmin', '2014-05-23 15:58:30', '2014-05-23 16:17:24', '2', '0');
INSERT INTO `edu_teacher_education` VALUES ('13', '16', null, null, null, null, null, null, null, '1', 'hnadmin', 'hnadmin', '2014-05-23 15:58:30', '2014-05-23 16:20:48', '3', '0');
INSERT INTO `edu_teacher_education` VALUES ('14', '16', null, null, null, null, null, null, null, '1', 'hnadmin', 'hnadmin', '2014-05-23 15:58:30', '2014-05-23 16:23:15', '4', '0');
INSERT INTO `edu_teacher_education` VALUES ('15', '16', null, null, null, null, null, null, null, '1', 'hnadmin', 'hnadmin', '2014-05-23 15:58:30', '2014-05-23 16:31:44', '5', '0');
INSERT INTO `edu_teacher_education` VALUES ('16', '16', null, null, null, null, null, null, null, '1', 'hnadmin', 'hnadmin', '2014-05-23 15:58:30', '2014-05-23 16:34:02', '6', '0');
INSERT INTO `edu_teacher_education` VALUES ('17', '16', null, null, null, null, null, null, null, '1', 'hnadmin', 'hnadmin', '2014-05-23 15:58:30', '2014-05-23 16:35:48', '7', '0');
INSERT INTO `edu_teacher_education` VALUES ('18', '17', null, null, null, null, null, null, null, '1', 'hnadmin', 'hnadmin', '2014-05-23 16:50:07', '2014-05-23 16:50:07', '1', '0');
INSERT INTO `edu_teacher_education` VALUES ('19', '16', null, null, null, null, null, null, null, '1', 'hnadmin', 'hnadmin', '2014-05-23 15:58:30', '2014-05-23 17:17:49', '8', '0');
INSERT INTO `edu_teacher_education` VALUES ('20', '16', null, null, null, null, null, null, null, '1', 'hnadmin', 'hnadmin', '2014-05-23 15:58:30', '2014-05-23 17:20:30', '9', '0');
INSERT INTO `edu_teacher_education` VALUES ('21', '16', null, null, null, null, null, null, null, '1', 'hnadmin', 'hnadmin', '2014-05-23 15:58:30', '2014-05-23 17:21:05', '10', '0');
INSERT INTO `edu_teacher_education` VALUES ('22', '18', '5', '本科', '1', '学士', '1998-03-09', '北理工', '教育学', '1', 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-26 09:45:48', '1', '0');
INSERT INTO `edu_teacher_education` VALUES ('23', '19', null, null, null, null, null, '', '', '1', 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-26 09:45:48', '1', '1');
INSERT INTO `edu_teacher_education` VALUES ('24', '20', null, null, null, null, null, '', '', '1', 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-26 09:45:48', '1', '1');
INSERT INTO `edu_teacher_education` VALUES ('25', '21', null, null, null, null, null, '', '', '1', 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-26 09:45:48', '1', '1');
INSERT INTO `edu_teacher_education` VALUES ('26', '22', null, null, null, null, null, '', '', '1', 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-26 09:45:48', '1', '1');
INSERT INTO `edu_teacher_education` VALUES ('27', '23', null, null, null, null, null, '', '', '1', 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-26 09:45:48', '1', '0');
INSERT INTO `edu_teacher_education` VALUES ('28', '24', null, null, null, null, null, '', '', '1', 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-26 09:45:48', '1', '1');
INSERT INTO `edu_teacher_education` VALUES ('29', '25', '5', '本科', '1', '学士', null, '', '', '1', 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-26 09:45:48', '1', '1');
INSERT INTO `edu_teacher_education` VALUES ('30', '18', '5', '本科', '1', '学士', '1998-03-09', '北理工', '教育学', '1', 'laoshi21', 'hnadmin', '2014-05-26 09:45:48', '2014-05-26 10:08:50', '2', '0');
INSERT INTO `edu_teacher_education` VALUES ('31', '18', '5', '本科', '1', '学士', '1998-03-09', '北理工', '教育学', '1', 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-26 10:10:35', '3', '0');
INSERT INTO `edu_teacher_education` VALUES ('32', '18', '5', '本科', '1', '学士', '1998-03-09', '北理工', '教育学', '1', 'laoshi21', 'hnadmin', '2014-05-26 09:45:48', '2014-05-26 10:14:01', '4', '0');
INSERT INTO `edu_teacher_education` VALUES ('34', '26', null, '请选择', null, '请选择', null, '1', '', '1', 'hnadmin', 'hnadmin', '2014-05-26 10:24:28', '2014-05-26 10:24:28', '1', '0');
INSERT INTO `edu_teacher_education` VALUES ('35', '16', null, null, null, null, null, null, null, '1', 'hnadmin', 'hnadmin', '2014-05-23 15:58:30', '2014-05-26 10:30:27', '11', '0');
INSERT INTO `edu_teacher_education` VALUES ('36', '18', '5', '本科', '1', '学士', '1998-03-09', '北理工', '教育学', '1', 'laoshi21', 'hnadmin', '2014-05-26 09:45:48', '2014-05-26 15:23:48', '5', '0');
INSERT INTO `edu_teacher_education` VALUES ('37', '18', '5', '本科', '1', '学士', '1998-03-09', '北理工', '教育学', '1', 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-26 15:36:00', '6', '0');
INSERT INTO `edu_teacher_education` VALUES ('38', '18', '5', '本科', '1', '学士', '1998-03-09', '北理工', '教育学', '1', 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-27 14:43:34', '7', '0');
INSERT INTO `edu_teacher_education` VALUES ('39', '18', '5', '本科', '1', '学士', '1998-03-09', '北理工', '教育学', '1', 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-27 14:44:03', '8', '0');
INSERT INTO `edu_teacher_education` VALUES ('40', '23', null, null, null, null, null, '', '', '1', 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-28 09:08:52', '2', '1');
INSERT INTO `edu_teacher_education` VALUES ('41', '23', null, null, null, null, null, '', '', '1', 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-28 09:08:52', '2', '1');
INSERT INTO `edu_teacher_education` VALUES ('42', '18', '5', '本科', '1', '学士', '1998-03-09', '北理工', '教育学', '1', 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-28 09:09:38', '9', '0');
INSERT INTO `edu_teacher_education` VALUES ('43', '22', null, null, null, null, null, '', '', '1', 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-28 09:10:30', '2', '0');
INSERT INTO `edu_teacher_education` VALUES ('44', '23', null, null, null, null, null, '', '', '1', 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-28 09:13:26', '3', '0');
INSERT INTO `edu_teacher_education` VALUES ('45', '23', null, null, null, null, null, '', '', '1', 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-28 09:13:26', '3', '0');
INSERT INTO `edu_teacher_education` VALUES ('51', '13', null, null, null, null, null, null, null, '1', 'hnadmin', 'hnadmin', '2014-05-21 10:24:46', '2014-05-28 09:22:24', '3', '0');
INSERT INTO `edu_teacher_education` VALUES ('52', '13', null, null, null, null, null, null, null, '1', 'hnadmin', 'hnadmin', '2014-05-21 10:24:46', '2014-05-28 09:55:31', '4', '0');
INSERT INTO `edu_teacher_education` VALUES ('53', '13', null, null, null, null, null, null, null, '1', 'hnadmin', 'hnadmin', '2014-05-21 10:24:46', '2014-05-28 10:00:20', '5', '0');
INSERT INTO `edu_teacher_education` VALUES ('54', '13', null, null, null, null, null, null, null, '1', 'hnadmin', 'hnadmin', '2014-05-21 10:24:46', '2014-05-28 10:13:39', '6', '0');
INSERT INTO `edu_teacher_education` VALUES ('55', '13', null, null, null, null, null, null, null, '1', 'hnadmin', 'hnadmin', '2014-05-21 10:24:46', '2014-05-28 10:14:34', '7', '0');
INSERT INTO `edu_teacher_education` VALUES ('56', '13', null, null, null, null, null, null, null, '1', 'hnadmin', 'hnadmin', '2014-05-21 10:24:46', '2014-05-28 10:19:34', '8', '0');
INSERT INTO `edu_teacher_education` VALUES ('57', '13', null, null, null, null, null, null, null, '1', 'hnadmin', 'hnadmin', '2014-05-21 10:24:46', '2014-05-28 10:22:16', '9', '0');
INSERT INTO `edu_teacher_education` VALUES ('58', '13', null, null, null, null, null, null, null, '1', 'hnadmin', 'hnadmin', '2014-05-21 10:24:46', '2014-05-28 10:25:29', '10', '0');
INSERT INTO `edu_teacher_education` VALUES ('59', '13', null, null, null, null, null, null, null, '1', 'hnadmin', 'hnadmin', '2014-05-21 10:24:46', '2014-05-28 10:38:24', '11', '0');
INSERT INTO `edu_teacher_education` VALUES ('60', '6', null, null, null, null, null, '', '', '1', 'hnadmin', 'hnadmin', '2014-05-21 10:04:25', '2014-05-28 10:53:16', '2', '0');
INSERT INTO `edu_teacher_education` VALUES ('61', '6', null, null, null, null, null, '', '', '1', 'hnadmin', 'hnadmin', '2014-05-21 10:04:25', '2014-05-28 10:54:31', '3', '0');
INSERT INTO `edu_teacher_education` VALUES ('62', '6', null, null, null, null, null, '', '', '1', 'hnadmin', 'hnadmin', '2014-05-21 10:04:25', '2014-05-28 10:55:13', '4', '1');
INSERT INTO `edu_teacher_education` VALUES ('63', '7', null, null, null, null, null, '', '', '1', 'hnadmin', 'hnadmin', '2014-05-21 10:04:25', '2014-05-28 16:20:48', '2', '1');
INSERT INTO `edu_teacher_education` VALUES ('65', '18', '5', '本科', '1', '学士', '1998-03-09', '北理工', '教育学', '1', 'shengadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-29 13:05:36', '10', '1');
INSERT INTO `edu_teacher_education` VALUES ('68', '35', '7', '本科', '5', '大学学士', '1970-01-01', '北理工', '', '1', 'shengadmin', 'shengadmin', '2014-05-29 15:14:26', '2014-05-29 15:14:26', '1', '1');
INSERT INTO `edu_teacher_education` VALUES ('69', '13', null, null, null, null, null, null, null, '1', 'shengadmin', 'hnadmin', '2014-05-21 10:24:46', '2014-05-29 16:01:02', '12', '1');
INSERT INTO `edu_teacher_education` VALUES ('70', '36', null, null, null, null, null, null, null, '1', 'shengadmin', 'shengadmin', '2014-05-29 16:01:59', '2014-05-29 16:01:59', '1', '1');
INSERT INTO `edu_teacher_education` VALUES ('71', '16', null, null, null, null, null, null, null, '1', 'shengadmin', 'hnadmin', '2014-05-23 15:58:30', '2014-05-29 16:39:28', '12', '0');
INSERT INTO `edu_teacher_education` VALUES ('72', '16', null, null, null, null, null, null, null, '1', 'shengadmin', 'hnadmin', '2014-05-23 15:58:30', '2014-05-29 16:40:17', '13', '0');
INSERT INTO `edu_teacher_education` VALUES ('73', '16', null, null, null, null, null, null, null, '1', 'shengadmin', 'hnadmin', '2014-05-23 15:58:30', '2014-05-29 16:41:20', '14', '0');
INSERT INTO `edu_teacher_education` VALUES ('74', '16', null, null, null, null, null, null, null, '1', 'shengadmin', 'hnadmin', '2014-05-23 15:58:30', '2014-05-29 16:42:01', '15', '1');
INSERT INTO `edu_teacher_education` VALUES ('76', '38', '9', '博士', '4', '博士', '2013-07-25', '北京理工大学', '教育心理学', '1', 'shengadmin', 'shengadmin', '2014-06-04 13:49:32', '2014-06-04 13:49:32', '1', '0');
INSERT INTO `edu_teacher_education` VALUES ('77', '39', null, null, null, null, null, null, null, '1', 'shengadmin', 'shengadmin', '2014-06-04 13:57:02', '2014-06-04 13:57:02', '1', '1');
INSERT INTO `edu_teacher_education` VALUES ('78', '26', null, '请选择', null, '请选择', null, '1', '', '1', 'shengadmin', 'hnadmin', '2014-05-26 10:24:28', '2014-06-04 14:03:15', '2', '1');
INSERT INTO `edu_teacher_education` VALUES ('79', '17', null, null, null, null, null, null, null, '1', 'shengadmin', 'hnadmin', '2014-05-23 16:50:07', '2014-06-04 14:06:24', '2', '0');
INSERT INTO `edu_teacher_education` VALUES ('80', '17', null, null, null, null, null, null, null, '1', 'shengadmin', 'hnadmin', '2014-05-23 16:50:07', '2014-06-04 14:08:20', '3', '0');
INSERT INTO `edu_teacher_education` VALUES ('81', '17', null, null, null, null, null, null, null, '1', 'shengadmin', 'hnadmin', '2014-05-23 16:50:07', '2014-06-04 14:15:42', '4', '0');
INSERT INTO `edu_teacher_education` VALUES ('82', '17', null, null, null, null, null, null, null, '1', 'shengadmin', 'hnadmin', '2014-05-23 16:50:07', '2014-06-04 14:17:47', '5', '0');
INSERT INTO `edu_teacher_education` VALUES ('83', '17', null, null, null, null, null, null, null, '1', 'shengadmin', 'hnadmin', '2014-05-23 16:50:07', '2014-06-04 14:18:09', '6', '1');
INSERT INTO `edu_teacher_education` VALUES ('84', '38', '9', '博士', '4', '博士', '2013-07-25', '北京理工大学', '教育心理学', '1', 'shengadmin', 'shengadmin', '2014-06-04 13:49:32', '2014-06-04 14:34:11', '2', '1');
INSERT INTO `edu_teacher_education` VALUES ('85', '5', '5', '本科', '1', '学士', '1998-03-09', '北理工', '教育学', '1', 'teacher1', 'hnadmin', '2014-05-21 10:04:25', '2014-06-05 09:33:22', '2', '0');
INSERT INTO `edu_teacher_education` VALUES ('87', '40', '6', '大专', '5', '大学学士', '2014-07-08', '11', '111', '1', 'xuexiaoadmin', 'xuexiaoadmin', '2014-06-06 17:16:04', '2014-06-06 17:16:04', '1', '0');
INSERT INTO `edu_teacher_education` VALUES ('88', '40', '6', '大专', '5', '大学学士', '2014-07-08', '11', '111', '1', 'xuexiaoadmin', 'xuexiaoadmin', '2014-06-06 17:16:04', '2014-06-06 17:27:44', '2', '0');
INSERT INTO `edu_teacher_education` VALUES ('89', '40', '6', '大专', '5', '大学学士', '2014-07-08', '11', '111', '1', 'xuexiaoadmin', 'xuexiaoadmin', '2014-06-06 17:16:04', '2014-06-06 17:27:44', '2', '0');
INSERT INTO `edu_teacher_education` VALUES ('90', '40', '6', '大专', '5', '大学学士', '2014-07-08', '11', '111', '1', 'xuexiaoadmin', 'xuexiaoadmin', '2014-06-06 17:16:04', '2014-06-06 17:31:26', '3', '0');
INSERT INTO `edu_teacher_education` VALUES ('91', '40', '6', '大专', '5', '大学学士', '2014-07-08', '11', '111', '1', 'xuexiaoadmin', 'xuexiaoadmin', '2014-06-06 17:16:04', '2014-06-06 17:32:33', '4', '0');
INSERT INTO `edu_teacher_education` VALUES ('92', '40', '6', '大专', '5', '大学学士', '2014-07-08', '11', '111', '1', 'xuexiaoadmin', 'xuexiaoadmin', '2014-06-06 17:16:04', '2014-06-06 17:38:54', '5', '0');
INSERT INTO `edu_teacher_education` VALUES ('94', '38', '9', '博士', '4', '博士', '2013-07-25', '北京理工大学', '教育心理学', '1', 'teacher4', 'shengadmin', '2014-06-04 13:49:32', '2014-06-06 18:07:02', '3', '0');
INSERT INTO `edu_teacher_education` VALUES ('98', '40', '6', '大专', '5', '大学学士', '2014-07-08', '11', '111', '1', 'shengadmin', 'xuexiaoadmin', '2014-06-06 17:16:04', '2014-06-07 10:12:13', '6', '1');

-- ----------------------------
-- Table structure for `edu_teacher_import_history`
-- ----------------------------
DROP TABLE IF EXISTS `edu_teacher_import_history`;
CREATE TABLE `edu_teacher_import_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_date` timestamp NULL DEFAULT NULL COMMENT '操作日期',
  `create_by` varchar(50) DEFAULT NULL COMMENT '操作人',
  `import_success_count` int(11) DEFAULT NULL COMMENT '导入成功数量',
  `imort_fail_count` int(11) DEFAULT NULL COMMENT '导入失败数量',
  `import_file_name` varchar(100) DEFAULT NULL COMMENT '导入文件名称',
  `import_fail_url` varchar(200) DEFAULT '导入失败文件下载路径',
  `import_serial` int(20) DEFAULT NULL COMMENT '导入流水号',
  `option_real_name` varchar(50) DEFAULT NULL COMMENT '操作时间',
  `option_year` int(11) DEFAULT NULL COMMENT '操作年度',
  `history_type` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='教师信息导入历史记录表';

-- ----------------------------
-- Records of edu_teacher_import_history
-- ----------------------------
INSERT INTO `edu_teacher_import_history` VALUES ('1', '2014-05-21 10:04:25', 'shengadmin', '8', '0', 'import_teacher0514.xlsx', '', null, '省管理员', '2014', 'retirees');
INSERT INTO `edu_teacher_import_history` VALUES ('2', '2014-05-26 09:45:48', 'shengadmin', '8', '0', 'import_teacher0514.xlsx', '', null, '省管理员', '2014', 'teacher');
INSERT INTO `edu_teacher_import_history` VALUES ('3', '2014-06-07 14:42:53', 'shengadmin', '5', '0', 'import_lituixiu.xlsx', '/1402123368047/toExl', null, '省管理员', '2014', 'retirees');

-- ----------------------------
-- Table structure for `edu_teacher_info_change_history`
-- ----------------------------
DROP TABLE IF EXISTS `edu_teacher_info_change_history`;
CREATE TABLE `edu_teacher_info_change_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_id` int(11) DEFAULT NULL,
  `operator_name` varchar(50) DEFAULT NULL,
  `audit_status` int(11) DEFAULT NULL COMMENT '审核状态（未审核，审核通过，审核不通过）',
  `change_type` int(11) DEFAULT NULL COMMENT '变更类型（信息变更，调动，离退休）',
  `last_audit_date` date DEFAULT NULL,
  `operator_date` date DEFAULT NULL,
  `old_version` int(11) DEFAULT NULL,
  `new_version` int(11) DEFAULT NULL,
  `audit_memo` text,
  `create_by` varchar(50) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `update_by` varchar(50) DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of edu_teacher_info_change_history
-- ----------------------------

-- ----------------------------
-- Table structure for `edu_teacher_job`
-- ----------------------------
DROP TABLE IF EXISTS `edu_teacher_job`;
CREATE TABLE `edu_teacher_job` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_id` int(11) DEFAULT NULL,
  `job_qualification` varchar(100) DEFAULT NULL,
  `job_qualification_type` varchar(50) DEFAULT NULL COMMENT '教师资格种类',
  `job_certificate_date` date DEFAULT NULL COMMENT '获教师资格证时间',
  `job_certificate_num` varchar(50) DEFAULT NULL COMMENT '教师资格证书号',
  `job_work_time` date DEFAULT NULL COMMENT '参加工作时间',
  `job_work_date` date DEFAULT NULL COMMENT '任教时间',
  `job_comment_position_type` int(11) DEFAULT NULL,
  `job_comment_position` varchar(50) DEFAULT NULL COMMENT '(评)教师职称',
  `job_recruitment_position_type` int(11) DEFAULT NULL,
  `job_recruitment_position` varchar(50) DEFAULT NULL COMMENT '(聘)教师职称',
  `job_comment_date` date DEFAULT NULL COMMENT '(评)职称时间',
  `job_recruitment_date` date DEFAULT NULL COMMENT '(聘)职称时间',
  `job_school_administration_office` varchar(30) DEFAULT NULL COMMENT '学校行政职务',
  `job_school_administration_office_type` int(11) DEFAULT NULL,
  `job_former_teaching_section` varchar(100) DEFAULT NULL COMMENT '当前任教学段',
  `job_former_teaching_section_type` varchar(100) DEFAULT NULL,
  `job_former_teaching_subject` varchar(100) DEFAULT NULL COMMENT '当前任教学科',
  `job_former_teaching_subject_type` varchar(100) DEFAULT NULL COMMENT '多个学科类别id 已逗号 分隔',
  `job_subject_leader` int(5) unsigned zerofill DEFAULT NULL COMMENT '学科带头人 1：是  0：否',
  `job_core_teacher` int(5) unsigned zerofill DEFAULT NULL COMMENT '骨干教师 1：是  0：否',
  `job_whether_teacher` int(11) unsigned zerofill DEFAULT NULL COMMENT '是否为班主任 1：是  0：否',
  `job_whether_grade_teacher` int(11) unsigned zerofill DEFAULT NULL COMMENT '是否为特级教师 1：是  0：否',
  `job_county_rural_teacher` int(11) unsigned zerofill DEFAULT NULL COMMENT '国培计划农村骨干教师 1：是  0：否',
  `job_private_school_teacher` int(11) unsigned zerofill DEFAULT NULL COMMENT '民办学校专职教师 1：是  0：否',
  `job_special_teacher` int(11) unsigned zerofill DEFAULT NULL COMMENT '特岗教师 1：是  0：否',
  `job_create_by` varchar(20) DEFAULT NULL,
  `job_update_by` varchar(20) DEFAULT NULL,
  `job_create_date` timestamp NULL DEFAULT NULL,
  `job_update_date` timestamp NULL DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `status` int(5) DEFAULT NULL COMMENT '1:有效 0:无效',
  `adjust_id` int(11) DEFAULT NULL,
  `adjust_name` varchar(50) DEFAULT NULL,
  `teacher_staff` int(11) DEFAULT NULL COMMENT '教师编制',
  `wxyj` varchar(100) DEFAULT NULL COMMENT '五险一金',
  `gwdj` int(11) DEFAULT NULL COMMENT '岗位等级',
  `gwlb` int(11) DEFAULT NULL COMMENT '岗位类别',
  `sfzb` int(11) DEFAULT NULL COMMENT '是否在编',
  `contract` int(11) DEFAULT NULL COMMENT '签订合同情况',
  `salary` varchar(50) DEFAULT NULL COMMENT '月平均工资',
  `jszgz` int(11) DEFAULT NULL COMMENT '教师资格证种类',
  `pthdj` int(11) DEFAULT NULL COMMENT '普通话等级',
  `cjqsny` varchar(50) DEFAULT NULL COMMENT '从教起始年月',
  `qrzsfzy` int(11) DEFAULT NULL COMMENT '是否是全日制 师范类专业毕业',
  `jsnpxqk` varchar(200) DEFAULT NULL COMMENT '近三年培训情况',
  `mfsfs` int(11) DEFAULT NULL COMMENT '是否是免费师范生',
  `jxjybh` varchar(100) DEFAULT NULL COMMENT '继续教育编号',
  `rych` varchar(100) DEFAULT NULL COMMENT '荣誉称号',
  `tgjs` int(11) DEFAULT NULL COMMENT '特岗教师类别 读取数据字典',
  PRIMARY KEY (`id`),
  KEY `teacher_id` (`teacher_id`),
  KEY `subject_type` (`job_former_teaching_subject_type`),
  KEY `section_type` (`job_former_teaching_section_type`),
  KEY `position_type` (`job_comment_position_type`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of edu_teacher_job
-- ----------------------------
INSERT INTO `edu_teacher_job` VALUES ('1', '5', null, null, null, '证书001', null, null, null, '一级教师', null, '一级教师', null, null, '校长', null, '小学', '2', '小学语文', '1', null, '00001', '00000000000', null, '00000000000', null, null, 'hnadmin', 'hnadmin', '2014-05-21 10:04:25', '2014-05-21 10:04:25', '1', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('2', '6', null, null, null, '证书002', null, null, null, '', null, '', null, null, '', null, '小学', '2', '小学语文', '1', null, null, null, null, null, null, null, 'hnadmin', 'hnadmin', '2014-05-21 10:04:25', '2014-05-21 10:04:25', '1', '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('3', '7', null, null, null, '证书003', null, null, null, '', null, '', null, null, '', null, '小学', '2', '小学语文', '1', null, null, null, null, null, null, null, 'hnadmin', 'hnadmin', '2014-05-21 10:04:25', '2014-05-21 10:04:25', '1', '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('4', '8', '请选择', '', null, '证书004', null, null, null, '请选择', null, '请选择', null, null, '', null, '初中', '3', '初中语文', '5', '00001', '00001', '00000000001', '00000000001', '00000000001', '00000000001', '00000000001', 'hnadmin', 'hnadmin', '2014-05-23 00:00:00', '2014-05-23 00:00:00', '1', '1', null, '请选择', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('5', '9', null, null, null, '证书005', null, null, null, '', null, '', null, null, '', null, '初中', '3', '初中数学', '6', null, null, null, null, null, null, null, 'hnadmin', 'hnadmin', '2014-05-21 10:04:25', '2014-05-21 10:04:25', '1', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('6', '10', '请选择', '', null, '证书006', null, null, null, '请选择', null, '请选择', null, null, '班主任', null, '小学', '2', '小学语文,小学数学', '1,2', '00000', '00001', '00000000001', '00000000000', '00000000001', '00000000000', '00000000000', 'hnadmin', 'hnadmin', '2014-05-21 00:00:00', '2014-05-21 00:00:00', '1', '1', null, '请选择', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('7', '11', null, null, null, '证书007', null, null, null, '', null, '', null, null, '', null, '小学', '2', '小学数学', '2', null, null, null, null, null, null, null, 'hnadmin', 'hnadmin', '2014-05-21 10:04:25', '2014-05-21 10:04:25', '1', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('8', '12', null, null, null, '证书008', null, null, null, '', null, '', null, null, '', null, '小学', '2', '初中数学', '6', null, null, null, null, null, null, null, 'hnadmin', 'hnadmin', '2014-05-21 10:04:25', '2014-05-21 10:04:25', '1', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('9', '13', '请选择', '', null, '', null, null, null, '请选择', null, '请选择', null, null, '', null, '小学', '2', '小学语文,小学数学', '1,2', '00000', '00000', '00000000000', '00000000000', '00000000000', '00000000000', '00000000000', 'hnadmin', 'hnadmin', '2014-05-21 00:00:00', '2014-05-21 00:00:00', '1', '0', null, '请选择', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('10', '13', '请选择', '', null, '', null, null, null, null, null, null, null, null, null, null, null, null, '小学语文,小学数学', '1,2', '00000', '00000', '00000000000', '00000000000', '00000000000', '00000000000', '00000000000', 'hnadmin', 'hnadmin', '2014-05-21 11:04:23', '2014-05-21 11:04:23', '2', '0', null, '请选择', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('11', '16', '请选择', '', null, '', null, null, null, '请选择', null, '请选择', null, null, '', null, '小学', '6', '小学语文', '8', '00000', '00000', '00000000000', '00000000000', '00000000000', '00000000000', '00000000000', 'hnadmin', 'hnadmin', '2014-05-23 00:00:00', '2014-05-23 00:00:00', '1', '0', null, '请选择', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('12', '16', '请选择', '', null, '', null, null, '2', '高级职称', '2', '高级职称', null, null, '普通教师', '1', null, null, '小学语文', '8', '00000', '00001', '00000000001', '00000000000', '00000000001', '00000000000', '00000000000', 'hnadmin', 'hnadmin', '2014-05-23 16:17:24', '2014-05-23 16:17:24', '2', '0', null, '请选择', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('13', '16', '请选择', '', null, '', null, null, null, '请选择', null, '请选择', null, null, '', null, '小学', '6', '小学语文', '8', '00000', '00000', '00000000000', '00000000000', '00000000000', '00000000000', '00000000000', 'hnadmin', 'hnadmin', '2014-05-23 00:00:00', '2014-05-23 16:20:48', '3', '0', null, '请选择', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('14', '16', '请选择', '', null, '', null, null, '2', '高级职称', '2', '高级职称', null, null, null, null, null, null, '小学语文', '8', '00000', '00001', '00000000000', '00000000000', '00000000000', '00000000000', '00000000000', 'hnadmin', 'hnadmin', '2014-05-23 16:23:15', '2014-05-23 16:23:15', '4', '0', null, '请选择', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('15', '16', '请选择', '', null, '', null, null, '2', '高级职称', '2', '高级职称', null, null, null, null, null, null, '小学语文', '8', '00000', '00001', '00000000000', '00000000000', '00000000000', '00000000000', '00000000000', 'hnadmin', 'hnadmin', '2014-05-23 16:31:44', '2014-05-23 16:31:44', '5', '0', '89', '事业编', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('16', '16', '请选择', '', null, '', null, null, '2', '高级职称', '2', '高级职称', null, null, null, null, null, null, '小学语文', '8', '00000', '00001', '00000000000', '00000000000', '00000000000', '00000000000', '00000000000', 'hnadmin', 'hnadmin', '2014-05-23 16:23:15', '2014-05-23 16:34:02', '6', '0', null, '请选择', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('17', '16', '请选择', '', null, '', null, null, '2', '高级职称', '2', '高级职称', null, null, null, null, null, null, '小学语文', '8', '00000', '00001', '00000000000', '00000000000', '00000000000', '00000000000', '00000000000', 'hnadmin', 'hnadmin', '2014-05-23 16:35:48', '2014-05-23 16:35:48', '7', '0', '89', '事业编', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('18', '17', '请选择', '', null, '', null, null, null, '请选择', null, '请选择', null, null, '', null, '小学', '6', '小学语文', '8', '00000', '00000', '00000000000', '00000000000', '00000000000', '00000000000', '00000000000', 'hnadmin', 'hnadmin', '2014-05-23 00:00:00', '2014-05-23 00:00:00', '1', '0', null, '请选择', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('19', '16', '请选择', '', null, '', null, null, '2', '高级职称', '2', '高级职称', null, null, null, null, null, null, '小学语文', '8', '00000', '00001', '00000000000', '00000000000', '00000000000', '00000000000', '00000000000', 'hnadmin', 'hnadmin', '2014-05-23 17:17:49', '2014-05-23 17:17:49', '8', '0', '89', '事业编', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('20', '16', '请选择', '', null, '', null, null, '2', '高级职称', '2', '高级职称', null, null, null, null, null, null, '小学语文', '8', '00000', '00001', '00000000000', '00000000000', '00000000000', '00000000000', '00000000000', 'hnadmin', 'hnadmin', '2014-05-23 16:35:48', '2014-05-23 17:20:30', '9', '0', '89', '事业编', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('21', '16', '请选择', '', null, '', null, null, '2', '高级职称', '2', '高级职称', null, null, null, null, null, null, '小学语文', '8', '00000', '00001', '00000000000', '00000000000', '00000000000', '00000000000', '00000000000', 'hnadmin', 'hnadmin', '2014-05-23 17:21:05', '2014-05-23 17:21:05', '10', '0', '89', '事业编', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('22', '18', null, null, null, '证书01', null, null, null, '一级教师', null, '一级教师', null, null, '校长', null, '小学', '6', '小学语文', '8', null, '00001', '00000000000', null, '00000000000', null, null, 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-26 09:45:48', '1', '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('23', '19', null, null, null, '证书02', null, null, null, '', null, '', null, null, '', null, '小学', '6', '小学语文', '8', null, null, null, null, null, null, null, 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-26 09:45:48', '1', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('24', '20', null, null, null, '证书03', null, null, null, '', null, '', null, null, '', null, '小学', '6', '小学语文', '8', null, null, null, null, null, null, null, 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-26 09:45:48', '1', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('25', '21', '请选择', '', null, '证书04', null, null, null, '请选择', null, '请选择', null, null, '请选择', null, '小学', '6', '小学音乐,小学语文', '4,8', '00000', '00000', '00000000000', '00000000000', '00000000000', '00000000000', '00000000000', 'shengadmin', 'shengadmin', '2014-06-05 00:00:00', '2014-06-05 00:00:00', '1', '1', null, '请选择', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('26', '22', null, null, null, '证书05', null, null, null, '', null, '', null, null, '', null, '初中', '3', '初中数学', '6', null, null, null, null, null, null, null, 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-26 09:45:48', '1', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('27', '23', null, null, null, '证书06', null, null, null, '', null, '', null, null, '班主任', null, '小学', '6', '小学语文', '8', null, '00001', '00000000001', null, '00000000001', null, null, 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-26 09:45:48', '1', '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('28', '24', null, null, null, '证书07', null, null, null, '', null, '', null, null, '', null, '小学', '6', '小学语文', '8', null, null, null, null, null, null, null, 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-26 09:45:48', '1', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('29', '25', null, null, null, '证书08', null, null, null, '', null, '', null, null, '', null, '小学', '6', '初中数学', '6', null, null, null, null, null, null, null, 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-26 09:45:48', '1', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('30', '18', '请选择', '', null, '证书01', null, null, null, '请选择', null, '请选择', null, null, '校长', null, '小学', '6', '小学美术,小学语文', '3,8', '00000', '00001', '00000000000', '00000000000', '00000000000', '00000000000', '00000000000', 'laoshi21', 'laoshi21', '2014-05-26 10:08:50', '2014-05-26 10:08:50', '2', '0', null, '请选择', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('31', '18', null, null, null, '证书01', null, null, null, '一级教师', null, '一级教师', null, null, '校长', null, '小学', '6', '小学语文', '8', null, '00001', '00000000000', null, '00000000000', null, null, 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-26 10:10:35', '3', '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('32', '18', '请选择', '', null, '证书01', null, null, '2', '二级教师', '2', '二级教师', null, null, '校长', null, '小学', '6', '小学语文', '8', '00000', '00001', '00000000000', '00000000000', '00000000000', '00000000000', '00000000000', 'laoshi21', 'laoshi21', '2014-05-26 10:14:01', '2014-05-26 10:14:01', '4', '0', null, '请选择', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('33', '26', '请选择', '', null, '1', null, null, null, '请选择', null, '请选择', null, null, '', null, '', null, '', '', '00000', '00000', '00000000000', '00000000000', '00000000000', '00000000000', '00000000000', 'hnadmin', 'hnadmin', '2014-05-26 00:00:00', '2014-05-26 00:00:00', '1', '0', null, '请选择', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('34', '16', '请选择', '', null, '', null, null, '2', '高级职称', '2', '高级职称', null, null, null, null, null, null, '小学语文', '8', '00000', '00001', '00000000000', '00000000000', '00000000000', '00000000000', '00000000000', 'hnadmin', 'hnadmin', '2014-05-26 10:30:27', '2014-05-26 10:30:27', '11', '0', '89', '事业编', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('35', '18', '请选择', '', null, '证书01', null, null, '2', '二级教师', '2', '二级教师', null, null, '校长', null, '小学', '6', '小学美术,小学语文', '3,8', '00000', '00001', '00000000000', '00000000000', '00000000000', '00000000000', '00000000000', 'laoshi21', 'laoshi21', '2014-05-26 00:00:00', '2014-05-26 00:00:00', '5', '0', '89', '事业编', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('36', '18', '请选择', '', null, '证书01', null, null, '2', '高级职称', '2', '高级职称', null, null, null, null, null, null, '小学美术,小学语文', '3,8', '00000', '00001', '00000000000', '00000000000', '00000000000', '00000000000', '00000000000', 'hnadmin', 'hnadmin', '2014-05-26 15:36:00', '2014-05-26 15:36:00', '6', '0', '89', '事业编', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('37', '18', '请选择', '', null, '证书01', null, null, '2', '高级职称', '2', '高级职称', null, null, null, null, null, null, '小学美术,小学语文', '3,8', '00000', '00001', '00000000000', '00000000000', '00000000000', '00000000000', '00000000000', 'hnadmin', 'hnadmin', '2014-05-27 14:43:34', '2014-05-27 14:43:34', '7', '0', '89', '事业编', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('38', '18', '请选择', '', null, '证书01', null, null, '2', '高级职称', '2', '高级职称', null, null, null, null, null, null, '小学美术,小学语文', '3,8', '00000', '00001', '00000000000', '00000000000', '00000000000', '00000000000', '00000000000', 'hnadmin', 'hnadmin', '2014-05-27 14:44:03', '2014-05-27 14:44:03', '8', '0', '90', '事业编1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('39', '23', null, null, null, '证书06', null, null, '2', '高级职称', '2', '高级职称', null, null, '普通教师', '1', null, null, '小学语文', '8', null, '00000', '00000000000', null, '00000000000', null, null, 'hnadmin', 'hnadmin', '2014-05-28 09:08:52', '2014-05-28 09:08:52', '2', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('40', '23', null, null, null, '证书06', null, null, '2', '高级职称', '2', '高级职称', null, null, '普通教师', '1', null, null, '小学语文', '8', null, '00000', '00000000000', null, '00000000000', null, null, 'hnadmin', 'hnadmin', '2014-05-28 09:08:53', '2014-05-28 09:08:53', '2', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('41', '18', '请选择', '', null, '证书01', null, null, '2', '高级职称', '2', '高级职称', null, null, null, null, null, null, '小学美术,小学语文', '3,8', '00000', '00001', '00000000001', '00000000000', '00000000001', '00000000000', '00000000000', 'hnadmin', 'hnadmin', '2014-05-28 09:09:38', '2014-05-28 09:09:38', '9', '0', '90', '事业编1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('42', '22', null, null, null, '证书05', null, null, '2', '高级职称', '2', '高级职称', null, null, '普通教师', '1', null, null, '初中数学,小学语文', '6,8', null, '00001', '00000000001', null, '00000000001', null, null, 'hnadmin', 'hnadmin', '2014-05-28 09:10:30', '2014-05-28 09:10:30', '2', '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('43', '23', null, null, null, '证书06', null, null, null, null, null, null, null, null, null, null, null, null, '小学语文', '8', null, '00001', '00000000001', null, '00000000001', null, null, 'hnadmin', 'hnadmin', '2014-05-28 09:13:26', '2014-05-28 09:13:26', '3', '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('44', '23', null, null, null, '证书06', null, null, null, null, null, null, null, null, null, null, null, null, '小学语文', '8', null, '00001', '00000000001', null, '00000000001', null, null, 'hnadmin', 'hnadmin', '2014-05-28 09:13:26', '2014-05-28 09:13:26', '3', '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('46', '13', '请选择', '', null, '', null, null, '2', '高级职称', '2', '高级职称', null, null, '普通教师', '1', null, null, '小学美术,小学语文', '3,8', '00000', '00001', '00000000001', '00000000000', '00000000000', '00000000000', '00000000000', 'hnadmin', 'hnadmin', '2014-05-28 09:22:24', '2014-05-28 09:22:24', '3', '0', null, '请选择', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('47', '13', '请选择', '', null, '', null, null, '2', '高级职称', '2', '高级职称', null, null, '普通教师', '1', null, null, '小学美术,小学语文', '3,8', '00000', '00001', '00000000001', '00000000000', '00000000000', '00000000000', '00000000000', 'hnadmin', 'hnadmin', '2014-05-28 09:55:31', '2014-05-28 09:55:31', '4', '0', null, '请选择', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('48', '13', '请选择', '', null, '', null, null, '2', '高级职称', '2', '高级职称', null, null, '普通教师', '1', null, null, '小学美术,小学语文', '3,8', '00000', '00001', '00000000001', '00000000000', '00000000000', '00000000000', '00000000000', 'hnadmin', 'hnadmin', '2014-05-28 10:00:20', '2014-05-28 10:00:20', '5', '0', null, '请选择', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('49', '13', '请选择', '', null, '', null, null, '2', '高级职称', '2', '高级职称', null, null, '普通教师', '1', null, null, '小学美术,小学语文', '3,8', '00000', '00001', '00000000001', '00000000000', '00000000000', '00000000000', '00000000000', 'hnadmin', 'hnadmin', '2014-05-28 10:13:39', '2014-05-28 10:13:39', '6', '0', null, '请选择', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('50', '13', '请选择', '', null, '', null, null, '2', '高级职称', '2', '高级职称', null, null, '普通教师', '1', null, null, '小学美术,小学语文', '3,8', '00000', '00001', '00000000001', '00000000000', '00000000000', '00000000000', '00000000000', 'hnadmin', 'hnadmin', '2014-05-28 10:14:34', '2014-05-28 10:14:34', '7', '0', null, '请选择', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('51', '13', '请选择', '', null, '', null, null, '2', '高级职称', '2', '高级职称', null, null, '普通教师', '1', null, null, '小学美术,小学语文', '3,8', '00000', '00001', '00000000001', '00000000000', '00000000000', '00000000000', '00000000000', 'hnadmin', 'hnadmin', '2014-05-28 10:19:34', '2014-05-28 10:19:34', '8', '0', null, '请选择', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('52', '13', '请选择', '', null, '', null, null, '2', '高级职称', '2', '高级职称', null, null, '普通教师', '1', null, null, '小学美术,小学语文', '3,8', '00000', '00001', '00000000001', '00000000000', '00000000000', '00000000000', '00000000000', 'hnadmin', 'hnadmin', '2014-05-28 10:22:16', '2014-05-28 10:22:16', '9', '0', null, '请选择', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('53', '13', '请选择', '', null, '', null, null, '2', '高级职称', '2', '高级职称', null, null, '普通教师', '1', null, null, '小学美术,小学语文', '3,8', '00000', '00001', '00000000001', '00000000000', '00000000000', '00000000000', '00000000000', 'hnadmin', 'hnadmin', '2014-05-28 10:25:29', '2014-05-28 10:25:29', '10', '0', null, '请选择', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('54', '13', '请选择', '', null, '', null, null, '2', '高级职称', '2', '高级职称', null, null, '普通教师', '1', null, null, '小学美术,小学语文', '3,8', '00000', '00001', '00000000001', '00000000000', '00000000000', '00000000000', '00000000000', 'hnadmin', 'hnadmin', '2014-05-28 10:38:24', '2014-05-28 10:38:24', '11', '0', null, '请选择', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('55', '6', null, null, null, '证书002', null, null, null, null, null, null, null, null, null, null, null, null, '', '', null, '00000', '00000000000', null, '00000000000', null, null, 'hnadmin', 'hnadmin', '2014-05-28 10:53:16', '2014-05-28 10:53:16', '2', '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('56', '6', null, null, null, '证书002', null, null, null, null, null, null, null, null, null, null, null, null, '', '', null, '00000', '00000000000', null, '00000000000', null, null, 'hnadmin', 'hnadmin', '2014-05-28 10:54:31', '2014-05-28 10:54:31', '3', '0', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('57', '6', null, null, null, '证书002', null, null, null, null, null, null, null, null, null, null, null, null, '', '', null, '00000', '00000000000', null, '00000000000', null, null, 'hnadmin', 'hnadmin', '2014-05-28 10:55:13', '2014-05-28 10:55:13', '4', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('58', '7', null, null, null, '证书003', null, null, null, null, null, null, null, null, null, null, null, null, '', '', null, '00000', '00000000000', null, '00000000000', null, null, 'hnadmin', 'hnadmin', '2014-05-28 16:20:48', '2014-05-28 16:20:48', '2', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('59', '18', '请选择', '', null, '证书01', '2004-05-01', '2004-05-01', '2', '高级职称', '2', '高级职称', '2004-05-01', '2004-05-01', '请选择', null, '小学', '6', '小学语文,小学数学', '8,9', '00000', '00001', '00000000000', '00000000000', '00000000000', '00000000000', '00000000000', 'shengadmin', 'shengadmin', '2014-06-04 00:00:00', '2014-06-04 00:00:00', '10', '1', '1', '事业编', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('60', '35', '湖南项目', '3', null, '', '2012-05-02', '2012-05-02', '2', '高级职称', '3', '中级职称', '2012-05-02', '2012-05-02', '请选择', null, '小学', '6', '小学音乐,小学语文', '4,8', '00001', '00001', '00000000001', '00000000001', '00000000001', '00000000001', '00000000001', 'shengadmin', 'shengadmin', '2014-06-04 00:00:00', '2014-06-04 00:00:00', '1', '1', '1', '事业编', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('61', '13', '请选择', '', null, '', null, null, '2', '高级职称', '2', '高级职称', null, null, '普通教师', '1', null, null, '小学美术,小学语文', '3,8', '00000', '00001', '00000000001', '00000000000', '00000000000', '00000000000', '00000000000', 'shengadmin', 'shengadmin', '2014-05-29 16:01:02', '2014-05-29 16:01:02', '12', '1', null, '请选择', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('62', '36', '请选择', '', null, '', null, null, null, '请选择', null, '请选择', null, null, '请选择', null, '小学', '6', '小学数学', '9', '00000', '00000', '00000000000', '00000000000', '00000000000', '00000000000', '00000000000', 'shengadmin', 'shengadmin', '2014-06-05 00:00:00', '2014-06-05 00:00:00', '1', '1', null, '请选择', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('63', '16', '请选择', '', null, '', null, null, '2', '高级职称', '2', '高级职称', null, null, null, null, null, null, '小学语文', '8', '00000', '00001', '00000000000', '00000000000', '00000000000', '00000000000', '00000000000', 'shengadmin', 'shengadmin', '2014-05-29 16:39:28', '2014-05-29 16:39:28', '12', '0', '89', '事业编', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('64', '16', '请选择', '', null, '', null, null, '2', '高级职称', '2', '高级职称', null, null, null, null, null, null, '小学语文', '8', '00000', '00001', '00000000000', '00000000000', '00000000000', '00000000000', '00000000000', 'shengadmin', 'shengadmin', '2014-05-29 16:40:17', '2014-05-29 16:40:17', '13', '0', '89', '事业编', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('65', '16', '请选择', '', null, '', null, null, '2', '高级职称', '2', '高级职称', null, null, null, null, null, null, '小学语文', '8', '00000', '00001', '00000000000', '00000000000', '00000000000', '00000000000', '00000000000', 'shengadmin', 'shengadmin', '2014-05-29 16:41:20', '2014-05-29 16:41:20', '14', '0', '89', '事业编', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('66', '16', '请选择', '', null, '', null, null, '2', '高级职称', '2', '高级职称', null, null, null, null, null, null, '小学语文', '8', '00000', '00001', '00000000000', '00000000000', '00000000000', '00000000000', '00000000000', 'shengadmin', 'shengadmin', '2014-05-29 16:42:01', '2014-05-29 16:42:01', '15', '1', '89', '事业编', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('67', '38', '教师资格种类1', '4', '2012-06-01', '资格1', '2012-06-06', '2013-06-06', '3', '中级职称', '2', '高级职称', '2013-12-31', '2014-03-04', '高级教师', '2', '小学', '6', '小学语文,小学数学', '8,9', '00001', '00001', '00000000001', '00000000001', '00000000001', '00000000001', '00000000001', 'shengadmin', 'shengadmin', '2014-06-04 00:00:00', '2014-06-04 00:00:00', '1', '0', '1', '事业编', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('68', '39', '请选择', '', null, '', null, null, '2', '高级职称', '2', '高级职称', null, null, '系主任', '6', '小学', '6', '小学语文,小学数学', '8,9', '00000', '00000', '00000000000', '00000000000', '00000000000', '00000000000', '00000000000', 'shengadmin', 'shengadmin', '2014-06-04 00:00:00', '2014-06-04 00:00:00', '1', '1', '1', '事业编', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('69', '26', '请选择', '', null, '1', null, null, '3', '中级职称', null, null, null, null, null, null, null, null, '小学语文', '8', '00000', '00000', '00000000000', '00000000000', '00000000000', '00000000000', '00000000000', 'shengadmin', 'shengadmin', '2014-06-04 14:03:15', '2014-06-04 14:03:15', '2', '1', null, '请选择', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('70', '17', '请选择', '', null, '', null, null, null, null, null, null, null, null, null, null, null, null, '小学语文', '8', '00000', '00000', '00000000000', '00000000000', '00000000000', '00000000000', '00000000000', 'shengadmin', 'shengadmin', '2014-06-04 14:06:24', '2014-06-04 14:06:24', '2', '0', null, '请选择', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('71', '17', '请选择', '', null, '', null, null, null, null, null, null, null, null, null, null, null, null, '小学语文', '8', '00000', '00000', '00000000000', '00000000000', '00000000000', '00000000000', '00000000000', 'shengadmin', 'shengadmin', '2014-06-04 14:08:20', '2014-06-04 14:08:20', '3', '0', null, '请选择', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('72', '17', '请选择', '', null, '', null, null, null, null, null, null, null, null, null, null, null, null, '小学语文', '8', '00000', '00000', '00000000000', '00000000000', '00000000000', '00000000000', '00000000000', 'shengadmin', 'shengadmin', '2014-06-04 14:15:42', '2014-06-04 14:15:42', '4', '0', '3', '编制外', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('73', '17', '请选择', '', null, '', null, null, null, null, null, null, null, null, null, null, null, null, '小学语文', '8', '00000', '00000', '00000000000', '00000000000', '00000000000', '00000000000', '00000000000', 'shengadmin', 'shengadmin', '2014-06-04 14:08:20', '2014-06-04 14:17:47', '5', '0', null, '请选择', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('74', '17', '请选择', '', null, '', null, null, null, '请选择', null, '请选择', null, null, '请选择', null, '小学', '6', '小学音乐,小学语文', '4,8', '00000', '00000', '00000000000', '00000000000', '00000000000', '00000000000', '00000000000', 'shengadmin', 'shengadmin', '2014-06-04 00:00:00', '2014-06-04 00:00:00', '6', '1', '1', '事业编', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('75', '38', '教师资格种类1', '4', '2012-06-01', '资格1', '2012-06-06', '2013-06-06', '3', '中级职称', '2', '高级职称', '2013-12-31', '2014-03-04', '高级教师', '2', '小学', '6', '小学美术,小学语文', '3,8', '00001', '00000', '00000000001', '00000000001', '00000000001', '00000000001', '00000000001', 'shengadmin', 'shengadmin', '2014-06-04 00:00:00', '2014-06-04 00:00:00', '2', '1', '1', '事业编', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('76', '5', '请选择', '', null, '证书001', null, null, null, '请选择', null, '请选择', null, null, '请选择', null, '小学', '6', '小学语文', '8', '00000', '00001', '00000000000', '00000000000', '00000000000', '00000000000', '00000000000', 'teacher1', 'teacher1', '2014-06-05 09:33:22', '2014-06-05 09:33:22', '2', '0', null, '请选择', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `edu_teacher_job` VALUES ('77', '40', '湖南项目', '3', '2014-06-11', '11', '2014-06-10', '2014-06-06', '3', '中级职称', '3', '中级职称', '2014-07-02', '2014-06-26', '系主任', '6', '初中', '3', '初中语文,初中物理', '5,7', '00000', '00000', '00000000000', '00000000000', '00000000000', '00000000000', '00000000000', 'xuexiaoadmin', 'xuexiaoadmin', '2014-06-06 00:00:00', '2014-06-06 00:00:00', '1', '0', '3', '编制外', null, '111', null, '1', '0', '1', '11', '1', '1', '11', '0', '111', '1', '11', '222', '1');
INSERT INTO `edu_teacher_job` VALUES ('78', '40', '湖南项目', '3', '2014-06-11', '11', '2014-06-10', '2014-06-06', '3', '中级职称', '3', '中级职称', '2014-07-02', '2014-06-26', '系主任', '6', '小学', '6', '小学数学', '9', '00000', '00000', '00000000000', '00000000000', '00000000000', '00000000000', '00000000000', 'xuexiaoadmin', 'xuexiaoadmin', '2014-06-06 17:27:44', '2014-06-06 17:27:44', '2', '0', '3', '编制外', null, '111', null, '1', '0', '1', '11', '1', '1', '11', '0', '111', '1', '11', '222', '1');
INSERT INTO `edu_teacher_job` VALUES ('80', '40', '湖南项目', '3', '2014-06-11', '11', '2014-06-10', '2014-06-06', '3', '中级职称', '3', '中级职称', '2014-07-02', '2014-06-26', '系主任', null, '初中', '3', '初中语文,初中物理', '5,7', '00000', '00000', '00000000000', '00000000000', '00000000000', '00000000000', '00000000000', 'xuexiaoadmin', 'xuexiaoadmin', '2014-06-06 00:00:00', '2014-06-06 17:31:26', '3', '0', '3', '编制外', null, '111', null, '1', '0', '1', '11', '1', '1', '11', '0', '111', '1', '11', '222', '1');
INSERT INTO `edu_teacher_job` VALUES ('81', '40', '湖南项目', '3', '2014-06-11', '11', '2014-06-10', '2014-06-06', '3', '中级职称', '3', '中级职称', '2014-07-02', '2014-06-26', '系主任', null, '初中', '3', '初中语文,初中物理', '5,7', '00000', '00000', '00000000000', '00000000000', '00000000000', '00000000000', '00000000000', 'xuexiaoadmin', 'xuexiaoadmin', '2014-06-06 00:00:00', '2014-06-06 17:32:33', '4', '0', '3', '编制外', null, '111', null, '1', '0', '1', '11', '1', '1', '11', '0', '111', '1', '11', '222', '1');
INSERT INTO `edu_teacher_job` VALUES ('82', '40', '湖南项目', '3', '2014-06-11', '11', '2014-06-10', '2014-06-06', '3', '中级职称', '3', '中级职称', '2014-07-02', '2014-06-26', null, null, '小学', '6', '小学语文,小学数学', '8,9', '00000', '00000', '00000000000', '00000000000', '00000000000', '00000000000', '00000000000', 'xuexiaoadmin', 'xuexiaoadmin', '2014-06-06 17:38:58', '2014-06-06 17:38:58', '5', '0', '3', '编制外', null, '111', null, '1', '0', '1', '11', '1', '1', '11', '0', '111', '1', '11', '222', '1');
INSERT INTO `edu_teacher_job` VALUES ('83', '38', '教师资格种类1', '4', '2012-06-01', '资格1', '2012-06-06', '2013-06-06', '3', '中级职称', '2', '高级职称', '2013-12-31', '2014-03-04', '高级教师', '2', '小学', '6', '小学美术,小学语文', '3,8', '00001', '00000', '00000000001', '00000000001', '00000000001', '00000000001', '00000000001', 'teacher4', 'teacher4', '2014-06-06 00:00:00', '2014-06-06 00:00:00', '3', '0', '1', '事业编', null, '', null, null, '0', null, '', null, null, '11', '0', '11', '1', '11', '111', '1');
INSERT INTO `edu_teacher_job` VALUES ('87', '40', '湖南项目', '3', '2014-06-11', '11', '2014-06-10', '2014-06-06', '3', '中级职称', '3', '中级职称', '2014-07-02', '2014-06-26', null, null, '小学', '6', '小学语文,小学数学', '8,9', '00000', '00000', '00000000000', '00000000000', '00000000000', '00000000000', '00000000000', 'shengadmin', 'shengadmin', '2014-06-07 10:12:13', '2014-06-07 10:12:13', '6', '1', '3', '编制外', null, '111', null, '1', '0', '1', '11', '1', '1', '11', '0', '111', '1', '11', '222', '1');

-- ----------------------------
-- Table structure for `edu_teacher_old_school`
-- ----------------------------
DROP TABLE IF EXISTS `edu_teacher_old_school`;
CREATE TABLE `edu_teacher_old_school` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_id` int(11) DEFAULT NULL,
  `old_school` varchar(50) DEFAULT NULL COMMENT '学校',
  `old_entry_time` date DEFAULT NULL COMMENT '入职时间',
  `old_turnover_time` date DEFAULT NULL COMMENT '离职时间',
  `create_by` varchar(50) DEFAULT NULL,
  `update_by` varchar(50) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of edu_teacher_old_school
-- ----------------------------

-- ----------------------------
-- Table structure for `edu_user`
-- ----------------------------
DROP TABLE IF EXISTS `edu_user`;
CREATE TABLE `edu_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_account` varchar(100) DEFAULT NULL COMMENT '登陆账号',
  `real_name` varchar(100) DEFAULT NULL COMMENT '真实姓名',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `id_number` varchar(50) DEFAULT NULL COMMENT '身份证号码',
  `mail` varchar(50) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `paswd_question_type` int(11) DEFAULT NULL COMMENT '密保问题选择',
  `paswd_answer` varchar(100) DEFAULT NULL COMMENT '密保回答\r\n            ',
  `password` varchar(100) DEFAULT NULL,
  `create_by` varchar(100) DEFAULT NULL,
  `update_by` varchar(100) DEFAULT NULL,
  `create_date` timestamp NULL DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT NULL,
  `status` int(11) DEFAULT NULL COMMENT '针对教师-信息审核状态 6 未审核 ， 7 审核不通过， 8 在职 ，各种离退操作:(31 退休、32死亡 、33离休、34离岗、35病休、36其他)， 0 删除、44禁用',
  `version` int(11) DEFAULT NULL COMMENT '针对教师，统一版本控制',
  `teacher_no` varchar(50) DEFAULT NULL,
  `gender` int(5) DEFAULT NULL,
  `user_image_url` varchar(500) DEFAULT NULL,
  `user_province_id` int(11) DEFAULT NULL COMMENT 'user所属省',
  `user_province_name` varchar(50) DEFAULT NULL,
  `user_city_id` int(11) DEFAULT NULL COMMENT 'user所属市',
  `user_city_name` varchar(50) DEFAULT NULL,
  `user_district_id` int(11) DEFAULT NULL COMMENT 'user所属区',
  `user_district_name` varchar(50) DEFAULT NULL,
  `school_id` int(11) DEFAULT NULL,
  `school_name` varchar(100) DEFAULT NULL,
  `user_address` varchar(100) DEFAULT NULL COMMENT 'user联系地址',
  `audit_name` varchar(100) DEFAULT NULL COMMENT '审核人',
  `audit_date` datetime DEFAULT NULL COMMENT '针对教师-审核日期',
  `memo` varchar(200) DEFAULT NULL COMMENT '教师信息审核意见',
  `subject_id` int(11) DEFAULT NULL COMMENT '学科ID 针对于专家帐号',
  `subject_name` varchar(11) DEFAULT NULL,
  `organization_id` int(20) DEFAULT NULL COMMENT '机构id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of edu_user
-- ----------------------------
INSERT INTO `edu_user` VALUES ('1', 'xitongadmin', '系统管理员', '0', '130182198910130914', '556677889@qq.com', '15122223222', '1', '系统管理员', '123', 'shengadmin', 'xitongadmin', '2014-04-11 10:59:32', '2014-04-14 16:23:31', '1', '1', '', '1', '', null, '', null, '', null, '', null, null, '', null, null, null, null, null, null);
INSERT INTO `edu_user` VALUES ('2', 'shengadmin', '省管理员', '1', '', '', '', null, null, '123', 'xitongadmin', 'hnadmin', '2014-05-21 09:28:57', '2014-05-29 09:52:55', '1', '1', null, '1', null, '1', '湖南省', null, null, null, null, null, null, '', null, null, null, null, null, null);
INSERT INTO `edu_user` VALUES ('3', 'jigouadmin1', '李俊', '6', '170189198504061819', '', '', null, null, '123', null, '李俊', '2014-05-21 09:37:54', '2014-05-29 09:55:41', '1', '3', '', null, null, '1', '湖南省', null, null, null, null, null, null, null, null, null, null, null, null, '1');
INSERT INTO `edu_user` VALUES ('4', 'hnssadmin1', '王丽', '7', '170198197605171819', 'hnssadmin1@163.com', '13617171111', '4', 'cute', '123', null, '王丽', '2014-05-21 09:39:57', '2014-05-29 13:30:49', '1', '1', '', null, null, '1', '湖南省', null, null, null, null, null, null, null, null, null, null, null, null, '3');
INSERT INTO `edu_user` VALUES ('5', 'teacher1', '李明', '5', '179101212188811111', 'test1@173.com', '13818812121', '0', null, '123', 'hnadmin', '李明', '2014-05-21 10:04:25', '2014-05-29 16:18:49', '8', '1', 'a001', '0', null, '1', '湖南省', '2', '长沙市', '4', '长沙市', '4', '芙蓉区小学', null, '省管理员', '2014-05-21 10:04:47', null, null, null, null);
INSERT INTO `edu_user` VALUES ('6', 'laoshi2', '高力', '5', '179101212188811112', 'test2@8718.com', '13818812122', null, null, '123', 'hnadmin', 'hnadmin', '2014-05-21 10:04:25', '2014-05-28 10:54:54', '8', '4', 'a002', '1', null, '1', '湖南省', '2', '长沙市', '5', '长沙市', '2', '天心区小学', null, '省管理员', '2014-05-21 10:04:47', null, null, null, null);
INSERT INTO `edu_user` VALUES ('7', 'laoshi3', '李长兴', '5', '179101212188811113', null, '13818812123', null, null, '123', 'hnadmin', 'hnadmin', '2014-05-21 10:04:25', '2014-05-23 16:55:07', '8', '2', 'a003', '0', null, '1', '湖南省', '2', '长沙市', '6', '长沙市', '8', '望城区实验小学', null, '省管理员', '2014-05-21 10:04:47', null, null, null, null);
INSERT INTO `edu_user` VALUES ('8', 'laoshi4', '潘钰莹', '5', '179101212188811114', null, '13818812124', null, null, '123', 'hnadmin', 'hnadmin', '2014-05-21 10:04:25', '2014-05-21 10:04:47', '8', '1', 'a004', '0', null, '1', '湖南省', '2', '长沙市', '7', '长沙市', '3', '雨花区初中', null, '省管理员', '2014-05-21 10:04:47', null, null, null, null);
INSERT INTO `edu_user` VALUES ('9', 'laoshi5', '杨伟峰', '5', '179101212188811115', null, '13818812125', null, null, '123', 'hnadmin', 'hnadmin', '2014-05-21 00:00:00', '2014-05-21 11:03:07', '8', '1', 'a005', '0', '/photo/1400641385147.jpg', '1', '湖南省', '3', '湘潭市', '8', '湘潭市', '1', '雨湖区初中', null, '省管理员', '2014-05-21 10:04:47', null, null, null, null);
INSERT INTO `edu_user` VALUES ('10', 'laoshi6', '李亚平', '5', '179101212188811116', null, '13818812126', null, null, '123', 'hnadmin', 'hnadmin', '2014-05-21 10:04:25', '2014-05-21 10:04:47', '8', '1', 'a006', '0', null, '1', '湖南省', '3', '湘潭市', '9', '湘潭市', '6', '岳塘区小学', null, '省管理员', '2014-05-21 10:04:47', null, null, null, null);
INSERT INTO `edu_user` VALUES ('11', 'laoshi7', '李韦伯', '5', '179101212188811117', null, '13818812127', null, null, '123', 'hnadmin', 'hnadmin', '2014-05-21 10:04:25', '2014-05-21 10:04:47', '8', '1', 'a007', '0', null, '1', '湖南省', '3', '湘潭市', '10', '湘潭市', '5', '湘乡市小学', null, '省管理员', '2014-05-21 10:04:47', null, null, null, null);
INSERT INTO `edu_user` VALUES ('12', 'laoshi8', '黄雷', '5', '179101212188811118', 'asdf@192.com', '13818812128', null, null, '123', 'hnadmin', 'hnadmin', '2014-05-21 10:04:25', '2014-05-23 17:03:59', '32', '1', 'a008', '0', null, '1', '湖南省', '3', '湘潭市', '11', '湘潭市', '7', '韶山初中', null, '省管理员', '2014-05-21 10:04:47', null, null, null, null);
INSERT INTO `edu_user` VALUES ('13', 'testh', '杨君', '5', '30042092019860210', null, null, null, null, '123', 'hnadmin', 'hnadmin', '2014-05-21 00:00:00', '2014-05-28 10:38:10', '8', '12', 'th110', '1', '/photo/1400641354976.png', '1', '湖南省', '2', '长沙市', '5', '天心区', '2', '天心区小学', null, null, null, null, null, null, null);
INSERT INTO `edu_user` VALUES ('14', 'hncpadmin2', '李丽', '6', '170189197601061718', '', '', null, null, '123', null, null, '2014-05-21 10:27:50', '2014-05-21 10:27:50', '1', '1', '', null, null, '1', '湖南省', null, null, null, null, null, null, null, null, null, null, null, null, '4');
INSERT INTO `edu_user` VALUES ('15', 'xuexiaoadmin', '刘萍', '4', '156171281821218881', 'liuping@163.com', '13819192121', '1', 'superman', '123', 'hnadmin', 'shengadmin', '2014-05-22 10:08:46', '2014-06-06 17:00:03', '1', '1', null, '1', null, '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', '', null, null, null, null, null, null);
INSERT INTO `edu_user` VALUES ('16', 'laoshi11', '王宁', '5', '178190191921218811', null, null, null, null, '123', 'hnadmin', 'shengadmin', '2014-05-23 15:58:30', '2014-05-29 16:41:40', '8', '15', '78', '1', '', '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', null, '省管理员', '2014-05-23 16:03:04', '通过', null, null, null);
INSERT INTO `edu_user` VALUES ('17', 'laoshi12', '李军', '5', '178191919191911111', null, null, null, null, '123', 'hnadmin', 'shengadmin', '2014-05-23 16:50:07', '2014-06-04 14:07:09', '8', '6', '78', '1', '/photo/1400835005174.png', '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', null, '省管理员', '2014-05-23 16:50:49', null, null, null, null);
INSERT INTO `edu_user` VALUES ('18', 'laoshi21', '李明一', '5', '179201212188811111', 'test1@173.com', '13918812121', null, null, '123', 'shengadmin', 'shengadmin', '2014-06-04 00:00:00', '2014-06-04 13:43:56', '8', '10', 'a001', '0', '/photo/1401860632646.png', '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', null, '省管理员', '2014-05-26 10:06:02', null, null, null, null);
INSERT INTO `edu_user` VALUES ('19', 'laoshi22', '高力景', '5', '179201212188811112', 'test2@8718.com', '13918812122', null, null, '123', 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-26 10:05:08', '7', '1', 'a002', '1', null, '1', '湖南省', '2', '长沙市', '5', '长沙市', '2', '天心区小学', null, '省管理员', '2014-05-26 10:05:08', null, null, null, null);
INSERT INTO `edu_user` VALUES ('20', 'laoshi23', '李科', '5', '179201212188811113', null, '13918812123', null, null, '123', 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-26 10:06:02', '8', '1', 'a003', '0', null, '1', '湖南省', '2', '长沙市', '6', '长沙市', '8', '望城区实验小学', null, '省管理员', '2014-05-26 10:06:02', null, null, null, null);
INSERT INTO `edu_user` VALUES ('21', 'laoshi24', '潘莹', '5', '179201212188811114', null, '13918812124', null, null, '123', 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-29 16:36:38', '8', '1', 'a004', '0', null, '1', '湖南省', '2', '长沙市', '7', '长沙市', '3', '雨花区初中', null, '省管理员', '2014-05-26 10:06:02', null, null, null, null);
INSERT INTO `edu_user` VALUES ('22', 'laoshi25', '杨峰', '5', '179201212188811115', null, '13918812125', null, null, '123', 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-26 10:06:02', '8', '1', 'a005', '0', null, '1', '湖南省', '3', '湘潭市', '8', '湘潭市', '1', '雨湖区初中', null, '省管理员', '2014-05-26 10:06:02', null, null, null, null);
INSERT INTO `edu_user` VALUES ('23', 'laoshi26', '李平', '5', '179201212188811116', null, '13918812126', null, null, '123', 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-29 14:12:57', '8', '2', 'a006', '0', null, '1', '湖南省', '3', '湘潭市', '9', '湘潭市', '6', '岳塘区小学', null, '省管理员', '2014-05-26 10:06:02', null, null, null, null);
INSERT INTO `edu_user` VALUES ('24', 'laoshi27', '李韦', '5', '179201212188811117', null, '13918812127', null, null, '123', 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-26 10:06:02', '8', '1', 'a007', '0', null, '1', '湖南省', '3', '湘潭市', '10', '湘潭市', '5', '湘乡市小学', null, '省管理员', '2014-05-26 10:06:02', null, null, null, null);
INSERT INTO `edu_user` VALUES ('25', 'teacher002', '黄雷磊', '5', '179201212188811118', 'asdf@192.com', '13918812128', null, null, '123', 'hnadmin', 'hnadmin', '2014-05-26 09:45:48', '2014-05-26 10:04:28', '7', '1', 'a008', '0', null, '1', '湖南省', '3', '湘潭市', '11', '湘潭市', '7', '韶山初中', null, '省管理员', '2014-05-26 10:04:28', null, null, null, null);
INSERT INTO `edu_user` VALUES ('26', 'denguo', 'dean测试', '5', '1', null, null, null, null, '123', 'hnadmin', 'hnadmin', '2014-05-26 10:24:18', '2014-05-26 10:25:05', '8', '2', '1', '1', '', '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', null, null, null, null, null, null, null);
INSERT INTO `edu_user` VALUES ('32', 'dishiadmin', ' 李宁', '2', ' ', '', '', null, null, '123', 'hnadmin', 'hnadmin', '2014-05-29 09:53:30', '2014-05-29 09:53:30', '1', '1', null, '1', null, '1', '湖南省', '2', '长沙市', null, null, null, null, '', null, null, null, null, null, null);
INSERT INTO `edu_user` VALUES ('33', 'quxianadmin', ' 王克忠', '3', ' ', '', '', null, null, '123', 'hnadmin', 'hnadmin', '2014-05-29 09:54:00', '2014-05-29 09:54:00', '1', '1', null, '1', null, '1', '湖南省', '2', '长沙市', '4', '芙蓉区', null, null, '', null, null, null, null, null, null);
INSERT INTO `edu_user` VALUES ('35', 'teacher2', '李宁波', '5', '190181761721217771', null, null, null, null, '123', 'shengadmin', 'shengadmin', '2014-05-29 00:00:00', '2014-06-05 09:34:24', '8', '1', '5', '1', '', '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', null, '省管理员', '2014-06-05 09:34:24', null, null, null, null);
INSERT INTO `edu_user` VALUES ('36', 'teacher3', '王鹏', '5', '178191212100001212', null, null, null, null, '123', 'shengadmin', 'shengadmin', '2014-05-29 16:01:59', '2014-06-05 15:19:26', '8', '1', '189', '0', '', '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', null, '省管理员', '2014-06-05 15:19:26', null, null, null, null);
INSERT INTO `edu_user` VALUES ('37', 'csadmin1', '李强', '2', '167189101019198211 ', '', '', null, null, '123', 'xitongadmin', 'xitongadmin', '2014-06-04 10:06:22', '2014-06-04 10:06:22', '1', '1', null, '1', null, '1', '湖南省', '2', '长沙市', null, null, null, null, '', null, null, null, null, null, null);
INSERT INTO `edu_user` VALUES ('38', 'teacher4', '李焕', '5', '178191021177771212', 'lihuan@163.com', '13718182121', null, null, '123', 'shengadmin', 'shengadmin', '2014-06-04 00:00:00', '2014-06-04 14:32:42', '8', '2', '编号24', '1', '/photo/1401860860883.png', '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', null, '省管理员', '2014-06-04 14:32:42', 'pass', null, null, null);
INSERT INTO `edu_user` VALUES ('39', 'teacher5', '柳宁', '5', '178191921212222345', null, null, null, null, '123', 'shengadmin', 'shengadmin', '2014-06-05 00:00:00', '2014-06-05 09:07:41', '8', '1', '编号22', '0', '', '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', null, '省管理员', '2014-06-05 09:07:41', null, null, null, null);
INSERT INTO `edu_user` VALUES ('40', 'dean', '邓果', '5', '123', null, null, null, null, '123', 'xuexiaoadmin', 'xuexiaoadmin', '2014-06-06 00:00:00', '2014-06-06 17:47:28', '8', '6', '1', '1', '/photo/1402046224492.jpg', '1', '湖南省', '2', '长沙市', '4', '芙蓉区', '4', '芙蓉区小学', null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `edu_user_forgotpassword`
-- ----------------------------
DROP TABLE IF EXISTS `edu_user_forgotpassword`;
CREATE TABLE `edu_user_forgotpassword` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `code` varchar(64) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_ip` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of edu_user_forgotpassword
-- ----------------------------

-- ----------------------------
-- Procedure structure for `sp_dict`
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_dict`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `sp_dict`(IN _dict1_type  VARCHAR(100), IN _dict2_type VARCHAR(100))
BEGIN
    SET SESSION group_concat_max_len = (7 * 1024);
 

    SET @sql = NULL;
    SELECT
      GROUP_CONCAT(DISTINCT
        CONCAT(
          'MAX(IF(`dict2_id` = ', `dict2_id`, ',num,0)) AS ', `dict2_name`)
      ) INTO @sql
    FROM edu_statistic_teacher where dict2_type =_dict2_type ;
    
 select @sql;
      
    SET @sql = CONCAT('SELECT dict1_id,  dict1_name, dict1_pid,', @sql, ' 
                      FROM    edu_statistic_teacher
                      WHERE type=1 and dict1_type = ''',_dict1_type,'''  GROUP   BY dict1_id');

 select @sql;

       
    PREPARE stmt FROM @sql;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
 END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `sp_region`
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_region`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `sp_region`(IN _type INT,IN _dict1_id INT,IN _dict1_type  VARCHAR(100), IN _dict2_type VARCHAR(100))
BEGIN
    SET SESSION group_concat_max_len = (7 * 1024);
 

    SET @sql = NULL;
    SELECT
      GROUP_CONCAT(DISTINCT
        CONCAT(
          'MAX(IF(`dict2_id` = ', `dict2_id`, ',num,0)) AS ', `dict2_name`)
      ) INTO @sql
    FROM edu_statistic_teacher where dict2_type =_dict2_type ;
    
 
    IF(_type =0) THEN  
             SET @sql = CONCAT('SELECT dict1_id,  dict1_name, dict1_pid,', @sql, ' 
                      FROM    edu_statistic_teacher
                      WHERE type=0 and dict1_id = ',_dict1_id,' or dict1_pid=',_dict1_id,
                      ' GROUP   BY dict1_id');
    ELSE
         SET @sql = CONCAT('SELECT dict1_id,  dict1_name, dict1_pid,', @sql, ' 
                      FROM    edu_statistic_teacher
                      WHERE type=1 and dict1_type = ''',_dict1_type,'''  GROUP   BY dict1_id');
    END IF;
        
    PREPARE stmt FROM @sql;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
 END
;;
DELIMITER ;

-- ----------------------------
-- Procedure structure for `sp_school`
-- ----------------------------
DROP PROCEDURE IF EXISTS `sp_school`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` PROCEDURE `sp_school`(IN area_id INT, IN _dict1_type VARCHAR(100))
BEGIN
    SET SESSION group_concat_max_len = (7 * 1024);
 

    SET @sql = NULL;
    SELECT
      GROUP_CONCAT(DISTINCT
        CONCAT(
          'MAX(IF(`dict1_id` = ', `dict1_id`, ',num,0)) AS ', `dict1_name`)
      ) INTO @sql
    FROM edu_statistic_school where dict1_type = _dict1_type ;
   
 
      
    SET @sql = CONCAT('SELECT area_id,  area_name, area_pid,', @sql, ' 
                      FROM    edu_statistic_school
                      WHERE   area_id = ',area_id,' or area_pid=',area_id,
                      ' GROUP   BY area_id');
 
       
    PREPARE stmt FROM @sql;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
 END
;;
DELIMITER ;
