/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50520
Source Host           : 127.0.0.1:3306
Source Database       : edu

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2014-06-05 18:48:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `edu_organization`
-- ----------------------------
DROP TABLE IF EXISTS `edu_organization`;
CREATE TABLE `edu_organization` (
  `organization_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `organization_name` varchar(20) DEFAULT NULL COMMENT '机构名称',
  `org_code` varchar(16) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of edu_organization
-- ----------------------------
INSERT INTO `edu_organization` VALUES ('1', '湖南承培机构1', null, '王磊', '18723748933', '北京市海淀区西土城1号', '1', '湖南省', null, null, null, null, '', 'hnadmin', '2014-05-21', null, null, '1', '1');
INSERT INTO `edu_organization` VALUES ('2', '湖南实施机构', null, '张明', '15899231987', '北京市海淀区北土城1号', '1', '湖南省', null, null, null, null, '', 'hnadmin', '2014-05-21', null, null, '0', '2');
INSERT INTO `edu_organization` VALUES ('3', '湖南实施机构', null, '张明', '1589932294', '北京市海淀区北土城45号', '1', '湖南省', null, null, null, null, '', 'hnadmin', '2014-05-21', null, null, '1', '2');
INSERT INTO `edu_organization` VALUES ('4', '湖南承培机构2', null, '李丽', '13516171811', '湖南省长沙市', '1', '湖南省', null, null, null, null, '', 'hnadmin', '2014-05-21', null, null, '1', '1');
