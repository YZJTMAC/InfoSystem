/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50520
Source Host           : 127.0.0.1:3306
Source Database       : edu

Target Server Type    : MYSQL
Target Server Version : 50520
File Encoding         : 65001

Date: 2014-05-27 17:29:01
*/

SET FOREIGN_KEY_CHECKS=0;

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
INSERT INTO `edu_sys_platform_setup` VALUES ('1', '1', '教师继续教育管理平台', '/photo/logo.png', '/photo/logininfo.png', '© 2012-2062 中国教师教育网 版权所有。保留所有权利。 京ICP备12024815号/京ICP证120554号', '400-200-800', 'xitongadmin', '2014-05-26 13:37:32', 'xitongadmin', '2014-05-27 17:12:46');
