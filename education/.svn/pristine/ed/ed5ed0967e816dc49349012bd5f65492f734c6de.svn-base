/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50520
Source Host           : 127.0.0.1:3306
Source Database       : edu

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2014-07-11 11:12:38
*/

SET FOREIGN_KEY_CHECKS=0;

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
  `type` int(11) DEFAULT NULL COMMENT '证书类型(1:年度证书, 2: 项目证书, 3:学时证书)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of edu_diploma
-- ----------------------------

--update 2014-12-09
alter table edu_diploma add backgroundImg int(11) DEFAULT '-1' COMMENT '模板背景' ;

 

