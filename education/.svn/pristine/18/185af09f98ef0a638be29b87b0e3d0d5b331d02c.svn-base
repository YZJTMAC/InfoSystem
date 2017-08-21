# MySQL-Front 5.0  (Build 1.0)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;


# Host: 192.168.1.170:3307    Database: edu
# ------------------------------------------------------
# Server version 5.1.54-community

CREATE DATABASE `education` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `education`;

#
# Table structure for table edu_audit
#

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
INSERT INTO `edu_audit` VALUES (70,330,13,'hnadmin','2014-05-15 10:26:59','地地道道的','hnadmin','hnadmin','2014-05-14 17:22:14','2014-05-15 10:26:59',1,2,2,100,'null',101,'null',105,'null',81,'望城区实验小学',100,'null',101,'null',105,'null',81,'望城区实验小学','大大大');
INSERT INTO `edu_audit` VALUES (71,330,11,NULL,NULL,NULL,'hnadmin','hnadmin','2014-05-14 17:22:14','2014-05-14 17:22:14',1,2,2,100,'null',101,'null',105,'null',81,'望城区实验小学',100,'null',101,'null',105,'null',81,'望城区实验小学','大大大');
INSERT INTO `edu_audit` VALUES (72,335,13,'hnadmin','2014-05-15 14:03:50','pass','hnadmin','hnadmin','2014-05-15 13:58:56','2014-05-15 14:03:50',1,2,2,100,'null',102,'null',110,'null',84,'韶山初中',100,'null',102,'null',110,'null',84,'韶山初中','改变相关信息');
INSERT INTO `edu_audit` VALUES (73,329,12,'hnadmin','2014-05-15 14:24:39','fail','hnadmin','hnadmin','2014-05-15 14:10:49','2014-05-15 14:24:39',1,2,2,100,'null',101,'null',104,'null',83,'天心区小学',100,'湖南省',101,'长沙市',103,'芙蓉区',82,'芙蓉区小学','修改小学');
INSERT INTO `edu_audit` VALUES (74,336,13,'hnadmin','2014-05-15 14:18:11','pass','hnadmin','hnadmin','2014-05-15 14:18:00','2014-05-15 14:18:11',1,2,2,100,'湖南省',101,'长沙市',104,'天心区',83,'天心区小学',100,'湖南省',101,'长沙市',104,'天心区',83,'天心区小学','学科学段修改');
INSERT INTO `edu_audit` VALUES (75,329,13,'hnadmin','2014-05-15 14:26:11','pass','hnadmin','hnadmin','2014-05-15 14:25:48','2014-05-15 14:26:11',3,4,2,100,'null',101,'null',104,'null',83,'天心区小学',100,'null',101,'null',104,'null',83,'天心区小学','修改学科');
INSERT INTO `edu_audit` VALUES (76,329,13,'hnadmin','2014-05-15 14:28:43','pass','hnadmin','hnadmin','2014-05-15 14:28:17','2014-05-15 14:28:43',4,5,2,100,'null',101,'null',104,'null',83,'天心区小学',100,'null',101,'null',104,'null',83,'天心区小学','modify');
INSERT INTO `edu_audit` VALUES (77,329,13,'hnadmin','2014-05-15 14:30:52','pass','hnadmin','hnadmin','2014-05-15 14:29:19','2014-05-15 14:30:52',5,6,2,100,'null',101,'null',104,'null',83,'天心区小学',100,'null',101,'null',104,'null',83,'天心区小学','学科');
INSERT INTO `edu_audit` VALUES (78,329,12,'hnadmin','2014-05-15 14:34:40','fail','hnadmin','hnadmin','2014-05-15 14:31:51','2014-05-15 14:34:40',NULL,NULL,35,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100,NULL,101,NULL,104,NULL,83,'天心区小学','高血压');
INSERT INTO `edu_audit` VALUES (79,335,13,'hnadmin','2014-05-15 14:45:50','','hnadmin','hnadmin','2014-05-15 14:36:42','2014-05-15 14:45:50',2,3,2,100,'null',102,'null',110,'null',84,'韶山初中',100,'null',102,'null',110,'null',84,'韶山初中','学科');
INSERT INTO `edu_audit` VALUES (80,329,13,'hnadmin','2014-05-15 14:44:43','pass','hnadmin','hnadmin','2014-05-15 14:44:00','2014-05-15 14:44:43',6,7,2,100,'null',101,'null',104,'null',83,'天心区小学',100,'null',101,'null',104,'null',83,'天心区小学','ddd');
INSERT INTO `edu_audit` VALUES (81,329,12,'hnadmin','2014-05-15 14:47:30','fail','hnadmin','hnadmin','2014-05-15 14:46:49','2014-05-15 14:47:30',7,8,2,100,'null',101,'null',104,'null',83,'天心区小学',100,'湖南省',102,'湘潭市',107,'雨湖区',79,'雨湖区初中','测试');
INSERT INTO `edu_audit` VALUES (82,329,13,'hnadmin','2014-05-15 14:50:26','是','hnadmin','hnadmin','2014-05-15 14:49:41','2014-05-15 14:50:26',NULL,NULL,34,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100,NULL,101,NULL,104,NULL,83,'天心区小学','离岗');
INSERT INTO `edu_audit` VALUES (83,328,13,'hnadmin','2014-05-15 15:42:08','pass','hnadmin','hnadmin','2014-05-15 15:41:27','2014-05-15 15:42:08',NULL,NULL,32,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100,NULL,101,NULL,103,NULL,82,'芙蓉区小学','等级');
INSERT INTO `edu_audit` VALUES (84,332,13,'hnadmin','2014-05-15 15:49:04','pass','hnadmin','hnadmin','2014-05-15 15:46:15','2014-05-15 15:49:04',NULL,NULL,33,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,100,NULL,102,NULL,107,NULL,79,'雨湖区初中','离休');
INSERT INTO `edu_audit` VALUES (85,332,13,'hnadmin','2014-05-15 15:52:20','pass','hnadmin','hnadmin','2014-05-15 15:51:55','2014-05-15 15:52:20',1,2,40,100,'null',102,'null',107,'null',79,'雨湖区初中',100,'null',102,'null',107,'null',79,'雨湖区初中','比较牛');
INSERT INTO `edu_audit` VALUES (86,332,13,'hnadmin','2014-05-15 16:10:59','pass','hnadmin','hnadmin','2014-05-15 16:10:41','2014-05-15 16:10:59',2,3,2,100,'null',102,'null',107,'null',79,'雨湖区初中',100,'湖南省',101,'长沙市',103,'芙蓉区',82,'芙蓉区小学','修改');
INSERT INTO `edu_audit` VALUES (87,332,13,'hnadmin','2014-05-15 16:15:17','pass','hnadmin','hnadmin','2014-05-15 16:13:40','2014-05-15 16:15:17',3,4,2,100,'null',102,'null',107,'null',79,'雨湖区初中',100,'null',102,'null',107,'null',79,'雨湖区初中','学科');
/*!40000 ALTER TABLE `edu_audit` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table edu_diploma
#

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
INSERT INTO `edu_diploma` VALUES (4,'证书模版',2014,1,'培训证书','{姓名}，您已经通过项目考核，','<p>\n\t中国教师教育网\n</p>\n<p>\n\t2014年8月10日\n</p>',10,10,10,10,NULL,'hnssadmin1','hnssadmin1','2014-05-15','2014-05-15',NULL,NULL);
INSERT INTO `edu_diploma` VALUES (5,'sss',NULL,0,'ss','sss','sss',15,15,60,200,NULL,'hnssadmin1','hnssadmin1','2014-05-15','2014-05-15',90,1);
/*!40000 ALTER TABLE `edu_diploma` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table edu_jobtransfer_history
#

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
/*!40000 ALTER TABLE `edu_jobtransfer_history` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table edu_message
#

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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1 ROW_FORMAT=COMPACT;
INSERT INTO `edu_message` VALUES (9,'年度继教考核未达到要求',3,'shengadmin','2014-05-13',NULL,NULL,302,81,'继教考核提醒','2014-05-13','shengadmin','王雷',NULL);
INSERT INTO `edu_message` VALUES (10,'年度继教考核未达到要求',3,'shengadmin','2014-05-13',NULL,NULL,293,81,'继教考核提醒','2014-05-13','shengadmin','王明',NULL);
INSERT INTO `edu_message` VALUES (11,'年度继教考核未达到要求',3,'hbXX0051','2014-05-14',NULL,NULL,294,290,'继教考核提醒','2014-05-14','hbXX0051','王力',NULL);
INSERT INTO `edu_message` VALUES (12,'年度继教考核未达到要求',3,'gsssadmin1','2014-05-16',NULL,NULL,388,356,'继教考核提醒','2014-05-16','gsssadmin1','王龙',NULL);
/*!40000 ALTER TABLE `edu_message` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table edu_model
#

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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
INSERT INTO `edu_model` VALUES (4,'14年国培计划','12','1','20','5','2014-05-01','2014-12-24','test','hbadmin','2014-05-13 15:26:30','hbadmin','2014-05-13 10:16:00','10');
INSERT INTO `edu_model` VALUES (5,'湖南省14年继教计划','67','1','60','20','2014-05-01','2014-12-17','阿斯顿','hnadmin','2014-05-14 16:30:55','hnadmin','2014-05-14 16:20:21','20');
INSERT INTO `edu_model` VALUES (6,'湖南省教师培训计划','No131','1','60','25','2014-05-14','2014-07-31','湖南省教师培训计划','hnadmin','2014-05-14 16:31:02','hnadmin','2014-05-14 16:22:00','30');
INSERT INTO `edu_model` VALUES (7,'test板块','xx','1','0','13','2014-05-15','2016-04-28','sfd','hnssadmin1','2014-05-15 16:24:28','hnssadmin1','2014-05-15 16:23:20','15');
INSERT INTO `edu_model` VALUES (8,'湖南计较14年计划','4','1',NULL,'6','2014-05-01','2014-12-25','','hnssadmin1','2014-05-15 16:46:00','hnssadmin1','2014-05-15 16:46:00',NULL);
INSERT INTO `edu_model` VALUES (9,'测试版块','123','1',NULL,'20','2014-05-01','2014-05-31','adadadad','hnadmin','2014-05-15 17:24:38','hnadmin','2014-05-15 17:24:38',NULL);
INSERT INTO `edu_model` VALUES (10,'实施机构项目','111','1','20','40','2014-05-01','2014-05-31','阿士大夫是否','gsssadmin1','2014-05-15 17:40:44','gsssadmin1','2014-05-15 17:32:11','30');
INSERT INTO `edu_model` VALUES (11,'14年国培继教信息','3','1',NULL,'5','2014-05-01','2014-11-19','','gsssadmin1','2014-05-15 17:58:54','gsssadmin1','2014-05-15 17:58:54',NULL);
INSERT INTO `edu_model` VALUES (12,'黑龙江国培2014年项目','516','1',NULL,'100','2014-05-01','2014-05-31','','shengadmin','2014-05-16 10:57:08','shengadmin','2014-05-16 10:57:08',NULL);
INSERT INTO `edu_model` VALUES (13,'福建板块一','xxx001','1',NULL,'13','2014-05-07','2014-06-07','sf','fjssadmin1','2014-05-16 11:05:55','fjssadmin1','2014-05-16 11:05:55',NULL);
/*!40000 ALTER TABLE `edu_model` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table edu_organization
#

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
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
INSERT INTO `edu_organization` VALUES (2,86,'果实网','果实网管理员','15111113111','黑龙江省哈尔滨市阿城区',1,'黑龙江省',2,'哈尔滨市',3,'阿城区','果实网','zxq','2014-04-11','zxq','2014-04-11',1,1);
INSERT INTO `edu_organization` VALUES (3,85,'教师网',' we2',' ww1111','黑龙江省哈尔滨市阿城区',1,'黑龙江省',2,'哈尔滨市',NULL,NULL,'','xitongadmin','2014-04-15',NULL,NULL,1,1);
INSERT INTO `edu_organization` VALUES (84,NULL,'湖北实施一','hb实施一','123456789','sdf',89,'湖北省',NULL,NULL,NULL,NULL,'sdf','hbadmin','2014-05-13',NULL,NULL,1,2);
INSERT INTO `edu_organization` VALUES (85,NULL,'湖北实施二','hb实施二','123','sdf',89,'湖北省',NULL,NULL,NULL,NULL,'sdf','hbadmin','2014-05-13',NULL,NULL,1,2);
INSERT INTO `edu_organization` VALUES (86,NULL,'湖北承培一','hb承培一','123','23',89,'湖北省',NULL,NULL,NULL,NULL,'1243\n','hbadmin','2014-05-13',NULL,NULL,1,1);
INSERT INTO `edu_organization` VALUES (87,NULL,'湖北承培二','hb承培二','123','123',89,'湖北省',NULL,NULL,NULL,NULL,'qwe','hbadmin','2014-05-13',NULL,NULL,1,1);
INSERT INTO `edu_organization` VALUES (88,NULL,'武汉实施一','11','111','12',89,'湖北省',90,'武汉市',NULL,NULL,'123\n','whadmin','2014-05-13',NULL,NULL,1,2);
INSERT INTO `edu_organization` VALUES (89,NULL,'武汉承培一','11','111','11',89,'湖北省',90,'武汉市',NULL,NULL,'11','whadmin','2014-05-13',NULL,NULL,1,1);
INSERT INTO `edu_organization` VALUES (93,NULL,'4','2','3','4',NULL,NULL,NULL,NULL,NULL,NULL,'5','whadmin','2014-05-13','whadmin','2014-05-13',1,1);
INSERT INTO `edu_organization` VALUES (94,NULL,'5','2','2','2',NULL,NULL,NULL,NULL,NULL,NULL,'2','whadmin','2014-05-13','whadmin','2014-05-13',1,1);
INSERT INTO `edu_organization` VALUES (95,NULL,'6','3','3','3',NULL,NULL,NULL,NULL,NULL,NULL,'3','whadmin','2014-05-13','whadmin','2014-05-13',1,1);
INSERT INTO `edu_organization` VALUES (96,NULL,'湖南省实施机构1','李军','189999','撒旦飞洒发送',100,'湖南省',NULL,NULL,NULL,NULL,'','hnadmin','2014-05-14',NULL,NULL,1,2);
INSERT INTO `edu_organization` VALUES (97,NULL,'湖南省实施机构二','王琴','1999222','湖南省',100,'湖南省',NULL,NULL,NULL,NULL,'','hnadmin','2014-05-14',NULL,NULL,1,2);
INSERT INTO `edu_organization` VALUES (98,NULL,'湖南省承培机构1','马化腾','112212','撒打发斯蒂芬',100,'湖南省',NULL,NULL,NULL,NULL,'','hnadmin','2014-05-14',NULL,NULL,1,1);
INSERT INTO `edu_organization` VALUES (99,NULL,'湖南省承培机构2','刘伟','11212','萨法撒旦飞洒',100,'湖南省',NULL,NULL,NULL,NULL,'','hnadmin','2014-05-14',NULL,NULL,1,1);
INSERT INTO `edu_organization` VALUES (100,NULL,'湖南省承培机构3','徐丽','13221222112','河南省',100,'湖南省',NULL,NULL,NULL,NULL,'测试','hnadmin','2014-05-14',NULL,NULL,1,1);
INSERT INTO `edu_organization` VALUES (101,NULL,'湖南省实施机构三','章瑶','1474747474','湖南省长沙市',100,'湖南省',NULL,NULL,NULL,NULL,'测试内容','hnadmin','2014-05-14',NULL,NULL,1,2);
INSERT INTO `edu_organization` VALUES (102,NULL,'湖南省承培机构4','张晓','13222222222','湖南省长沙市',100,'湖南省',NULL,NULL,NULL,NULL,'dddddd','hnadmin','2014-05-15',NULL,NULL,1,1);
INSERT INTO `edu_organization` VALUES (103,NULL,'甘肃实施机构1','李明','112121','阿拉司法局啊沙发',114,'甘肃省',NULL,NULL,NULL,NULL,'11','gsadmin','2014-05-15','gsadmin','2014-05-15',1,2);
INSERT INTO `edu_organization` VALUES (104,NULL,'甘肃实施机构2','李红','1212121111','啊萨芬大厦',114,'甘肃省',NULL,NULL,NULL,NULL,'22','gsadmin','2014-05-15','gsadmin','2014-05-15',1,2);
INSERT INTO `edu_organization` VALUES (105,NULL,'甘肃实施机构3','刘强','12121','撒旦法萨芬',114,'甘肃省',NULL,NULL,NULL,NULL,'','gsadmin','2014-05-15',NULL,NULL,0,2);
INSERT INTO `edu_organization` VALUES (106,NULL,'甘肃承培机构1','李红','阿斯顿飞','阿斯顿飞',114,'甘肃省',NULL,NULL,NULL,NULL,'','gsadmin','2014-05-15',NULL,NULL,1,1);
INSERT INTO `edu_organization` VALUES (107,NULL,'甘肃承培机构2','刘强东','333','撒旦飞洒',114,'甘肃省',NULL,NULL,NULL,NULL,'','gsadmin','2014-05-15',NULL,NULL,1,1);
INSERT INTO `edu_organization` VALUES (108,NULL,'福建实施一','实一','123','fa',125,'福建省',NULL,NULL,NULL,NULL,'fa','fj60011022','2014-05-16',NULL,NULL,1,2);
INSERT INTO `edu_organization` VALUES (109,NULL,'福建承培一','福承一','123','无',125,'福建省',NULL,NULL,NULL,NULL,'无','fj60011022','2014-05-16',NULL,NULL,1,1);
/*!40000 ALTER TABLE `edu_organization` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table edu_organization_project
#

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
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
INSERT INTO `edu_organization_project` VALUES (45,86,79,'http://www.baidu.com','http://www.baidu.com',40,25,NULL,'hbadmin','2014-05-13','hbadmin','2014-05-13','湖北承培一',NULL,NULL,'98','点军区');
INSERT INTO `edu_organization_project` VALUES (46,87,79,'http://www.baidu.com','http://www.baidu.com',40,25,NULL,'hbadmin','2014-05-13','hbadmin','2014-05-13','湖北承培二',NULL,NULL,'96','西陵区');
INSERT INTO `edu_organization_project` VALUES (47,86,80,'http://www.baidu.com','http://www.baidu.com',31,NULL,NULL,'hbadmin','2014-05-13','hbadmin','2014-05-13','湖北承培一',NULL,NULL,NULL,NULL);
INSERT INTO `edu_organization_project` VALUES (48,89,78,'http://www.baidu.com','http://www.baidu.com',40,40,NULL,'hbadmin','2014-05-13','hbadmin','2014-05-13','武汉承培一',NULL,NULL,NULL,NULL);
INSERT INTO `edu_organization_project` VALUES (49,86,78,'http://www.baidu.com','http://www.baidu.com',40,30,NULL,'hbadmin','2014-05-13','hbadmin','2014-05-13','湖北承培一',NULL,NULL,NULL,NULL);
INSERT INTO `edu_organization_project` VALUES (50,87,78,'http://www.baidu.com','http://www.baidu.com',40,30,NULL,'hbadmin','2014-05-13','hbadmin','2014-05-13','湖北承培二',NULL,NULL,NULL,NULL);
INSERT INTO `edu_organization_project` VALUES (51,86,77,'http://www.baidu.com','http://www.baidu.com',40,50,NULL,'hbadmin','2014-05-13','hbadmin','2014-05-13','湖北承培一',NULL,NULL,NULL,NULL);
INSERT INTO `edu_organization_project` VALUES (52,87,77,'http://www.baidu.com','http://www.baidu.com',40,50,NULL,'hbadmin','2014-05-13','hbadmin','2014-05-13','湖北承培二',NULL,NULL,NULL,NULL);
INSERT INTO `edu_organization_project` VALUES (53,98,83,'http://www.baidu.com','http://www.baidu.com',40,30,NULL,'hnssadmin1','2014-05-14','hnssadmin1','2014-05-14','湖南省承培机构1',NULL,NULL,'101','长沙市');
INSERT INTO `edu_organization_project` VALUES (54,99,83,'http://www.baidu.com','http://www.baidu.com',40,30,NULL,'hnssadmin1','2014-05-14','hnssadmin1','2014-05-14','湖南省承培机构2',NULL,NULL,'102','湘潭市');
INSERT INTO `edu_organization_project` VALUES (55,98,84,'http://www.baidu.com','http://www.baidu.com',40,50,NULL,'hnssadmin1','2014-05-14','hnssadmin1','2014-05-14','湖南省承培机构1',NULL,NULL,'101','长沙市');
INSERT INTO `edu_organization_project` VALUES (56,99,84,'http://www.baidu.com','http://www.baidu.com',40,50,NULL,'hnssadmin1','2014-05-14','hnssadmin1','2014-05-14','湖南省承培机构2',NULL,NULL,'102','湘潭市');
INSERT INTO `edu_organization_project` VALUES (57,98,82,'http://www.baidu.com','http://www.baidu.com',40,50,NULL,'hnssadmin1','2014-05-14','hnssadmin1','2014-05-14','湖南省承培机构1',NULL,NULL,'101','长沙市');
INSERT INTO `edu_organization_project` VALUES (58,99,82,'http://www.baidu.com','http://www.baidu.com',40,50,NULL,'hnssadmin1','2014-05-14','hnssadmin1','2014-05-14','湖南省承培机构2',NULL,NULL,'101','长沙市');
INSERT INTO `edu_organization_project` VALUES (59,98,85,'http://www.baidu.com','http://www.baidu.com',31,50,NULL,'hnssadmin1','2014-05-14','hnssadmin1','2014-05-14','湖南省承培机构1',NULL,NULL,'101','长沙市');
INSERT INTO `edu_organization_project` VALUES (60,99,85,NULL,NULL,30,50,NULL,'hnssadmin1','2014-05-14','hnssadmin1','2014-05-14','湖南省承培机构2',NULL,NULL,'102','湘潭市');
INSERT INTO `edu_organization_project` VALUES (61,99,88,NULL,NULL,30,100,NULL,'hnadmin','2014-05-15','hnadmin','2014-05-15','湖南省承培机构2','1,2,3','小学语文,小学数学,小学美术','104','天心区');
INSERT INTO `edu_organization_project` VALUES (62,99,89,NULL,NULL,30,100,NULL,'hnadmin','2014-05-15','hnadmin','2014-05-15','湖南省承培机构2','1','小学语文','104','天心区');
INSERT INTO `edu_organization_project` VALUES (63,100,89,NULL,NULL,30,100,NULL,'hnadmin','2014-05-15','hnadmin','2014-05-15','湖南省承培机构3','1','小学语文','104','天心区');
INSERT INTO `edu_organization_project` VALUES (64,98,90,NULL,NULL,30,50,NULL,'hnadmin','2014-05-15','hnadmin','2014-05-15','湖南省承培机构1','1','小学语文','104','湖南省');
INSERT INTO `edu_organization_project` VALUES (65,99,90,NULL,NULL,30,50,NULL,'hnadmin','2014-05-15','hnadmin','2014-05-15','湖南省承培机构2','1','小学语文','104','天心区');
INSERT INTO `edu_organization_project` VALUES (66,100,90,NULL,NULL,30,NULL,NULL,'hnadmin','2014-05-15','hnadmin','2014-05-15','湖南省承培机构3',NULL,NULL,NULL,NULL);
INSERT INTO `edu_organization_project` VALUES (67,98,91,NULL,NULL,30,NULL,NULL,'hnadmin','2014-05-15','hnadmin','2014-05-15','湖南省承培机构1',NULL,NULL,NULL,NULL);
INSERT INTO `edu_organization_project` VALUES (68,106,92,'http://www.baidu.com','http://www.baidu.com',31,200,NULL,'gsssadmin1','2014-05-15','gsssadmin1','2014-05-15','甘肃承培机构1','1,2','小学语文,小学数学','123','武山县');
INSERT INTO `edu_organization_project` VALUES (69,106,93,'http://www.baidu.com','http://www.baidu.com',40,100,NULL,'gsssadmin2','2014-05-15','gsssadmin2','2014-05-15','甘肃承培机构1','1','小学语文','114','甘肃省');
INSERT INTO `edu_organization_project` VALUES (70,106,94,'http://www.baidu.com','http://www.baidu.com',40,100,NULL,'gsssadmin1','2014-05-15','gsssadmin1','2014-05-15','甘肃承培机构1','1','小学语文','114','甘肃省');
INSERT INTO `edu_organization_project` VALUES (71,106,95,'http://www.baidu.com','http://www.badiu.com',40,10,NULL,'gsssadmin2','2014-05-15','gsssadmin2','2014-05-15','甘肃承培机构1','1','小学语文','114','甘肃省');
INSERT INTO `edu_organization_project` VALUES (72,106,96,'http://www.baidu.com','http://www.baidu.com',40,100,NULL,'gsssadmin2','2014-05-15','gsssadmin2','2014-05-15','甘肃承培机构1','1','小学语文','117','城关区');
/*!40000 ALTER TABLE `edu_organization_project` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table edu_paper
#

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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
INSERT INTO `edu_paper` VALUES (1,'2014-04-30','2014-04-22','2014-05-08','shishiadmin1',1,'sadfdsaf',3,'asdfasdfsadfasdfsad',14,1,1,1);
INSERT INTO `edu_paper` VALUES (2,'2014-05-08','2014-05-08','2014-05-31','shishiadmin1',0,'五月计划调查问卷',1,'调查问卷测试内容',34,1,1,1);
INSERT INTO `edu_paper` VALUES (3,'2014-05-09','2014-05-09','2014-05-31','shishiadmin1',0,'调查内容',0,'调查内容测试',20,1,1,1);
INSERT INTO `edu_paper` VALUES (4,'2014-05-12','2014-05-01','2014-12-24','shishiadmin1',1,'问卷1',1,'都得',67,1,1,1);
INSERT INTO `edu_paper` VALUES (5,'2014-05-12','2014-05-01','2014-12-24','shishiadmin1',0,'问卷2',0,'11',67,1,1,1);
INSERT INTO `edu_paper` VALUES (6,'2014-05-13','2014-05-01','2014-10-08','hbadmin',0,'问卷1',0,'111',78,1,1,1);
INSERT INTO `edu_paper` VALUES (7,'2014-05-14','2014-05-01','2014-12-18','hnssadmin1',0,'问卷1',1,'',85,1,1,1);
INSERT INTO `edu_paper` VALUES (8,'2014-05-15','2014-05-01','2014-06-01','hnadmin',0,'新增项目测试2的调查问卷',0,'ddddddddd',89,1,1,1);
INSERT INTO `edu_paper` VALUES (9,'2014-05-15','2014-05-01','2014-05-31','gsssadmin1',0,'新添加的项目调查问卷',0,'ddddddddd',92,1,1,1);
INSERT INTO `edu_paper` VALUES (10,'2014-05-15','2014-05-01','2014-11-20','gsssadmin1',3,'问卷1',1,'',96,1,1,1);
INSERT INTO `edu_paper` VALUES (11,'2014-05-16','2014-05-01','2014-05-31','gsssadmin1',0,'test调查',0,'多岁的',95,1,1,1);
/*!40000 ALTER TABLE `edu_paper` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table edu_project
#

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
INSERT INTO `edu_project` VALUES (76,'1','2014年小学教师培训【自由报名】',2014,'2014-05-01','2014-12-24',1,'国培项目',1,'教师培训','89','湖北省',1,'远程',20,NULL,'湖北省','1/1399947163784.jpg',2,0,'hbadmin','2014-05-13','hbadmin','2014-05-13',100,'中国职业技术教育学会平台banner.jpg',2,0,NULL,0,NULL,NULL);
INSERT INTO `edu_project` VALUES (77,'1','14年国培小学教师培训【自由报名】(湖北省)',2014,'2014-05-01','2014-12-24',2,'省级培训项目',1,'教师培训','89','湖北省',1,'远程',20,NULL,'湖北省','1/1399947441788.jpg',2,40,'hbadmin','2014-05-13','hbadmin','2014-05-13',100,'中国职业技术教育学会平台banner.jpg',4,0,NULL,0,NULL,1);
INSERT INTO `edu_project` VALUES (78,'2','14年国培项目小学骨干教师【组织报名】(武汉市)',2014,'2014-05-01','2014-12-25',1,'国培项目',1,'教师培训','90','武汉市',1,'远程',30,NULL,'武汉市',NULL,1,50,'hbadmin','2014-05-13','hbadmin','2014-05-13',100,NULL,4,1,'111',3,'50,60,75',NULL);
INSERT INTO `edu_project` VALUES (79,'3','14年国培小学校长项目【层级分配/报名】(宜昌市)',2014,'2014-05-01','2014-11-18',3,'市级培项目',1,'教师培训','91','宜昌市',1,'远程',30,NULL,'宜昌市',NULL,3,40,'hbadmin','2014-05-13','hbadmin','2014-05-13',50,NULL,4,0,NULL,0,NULL,NULL);
INSERT INTO `edu_project` VALUES (81,'PX0009','【省管理】【区项目】(汉阳区)',2014,'2014-04-27','2014-06-06',0,'',0,'','93','汉阳区',0,'',0,NULL,'',',PX0009/1400204744613.jpg',3,10,'hbadmin','2014-05-13','hbadmin','2014-05-13',100,',signet.jpg',4,0,NULL,0,NULL,NULL);
INSERT INTO `edu_project` VALUES (82,'33','14年湖南小学教师培训项目【自由报名】(长沙市)',2014,'2014-05-01','2014-11-19',1,'国培项目',1,'教师培训','101','长沙市',1,'远程',20,NULL,'111','33/1400050692613.jpg',2,40,'hnadmin','2014-05-14','hnadmin','2014-05-14',100,'中国职业技术教育学会平台banner.jpg',5,0,NULL,0,NULL,NULL);
INSERT INTO `edu_project` VALUES (83,'6','14年湖南小学校长项目【组织报名】(湖南省)',2014,'2014-05-01','2014-12-24',2,'省级培训项目',1,'教师培训','100','湖南省',1,'远程',30,NULL,'','',1,50,'hnadmin','2014-05-14','hnadmin','2014-05-14',60,'',5,1,'111',3,'60,70,80',NULL);
INSERT INTO `edu_project` VALUES (84,'7','14年湖南省骨干项目【层级分配/报名】(湖南省)',2014,'2014-05-01','2014-12-17',2,'省级培训项目',1,'教师培训','100','湖南省',1,'远程',30,NULL,'',NULL,3,30,'hnadmin','2014-05-14','hnadmin','2014-05-14',100,NULL,5,0,NULL,0,NULL,NULL);
INSERT INTO `edu_project` VALUES (85,'8','湖南14年项目【组织报名】(湖南省)',2014,'2014-05-01','2014-05-23',1,'国培项目',1,'教师培训','100','湖南省',1,'远程',20,NULL,'',NULL,1,30,'hnssadmin1','2014-05-14','hnssadmin1','2014-05-14',200,NULL,5,0,NULL,0,NULL,NULL);
INSERT INTO `edu_project` VALUES (86,'515','【省管理】【测试项目】【组织报名】(湖北省)',2014,'2014-05-01','2014-05-31',1,'国培项目',1,'教师培训','89','湖北省',1,'远程',100,NULL,'啊打发发傻傻地发生','',1,30,'hbadmin','2014-05-15','hbadmin','2014-05-15',1000,'',4,0,NULL,0,NULL,NULL);
INSERT INTO `edu_project` VALUES (87,'51501','测试项目【自由报名】(湖北省)',2014,'2014-05-01','2014-05-31',1,'国培项目',1,'教师培训','89','湖北省',1,'远程',0,NULL,'爱到发烧的',NULL,2,30,'hbadmin','2014-05-15','hbadmin','2014-05-15',100,NULL,4,0,NULL,0,NULL,NULL);
INSERT INTO `edu_project` VALUES (88,'0014','新增项目测试-天心区',2014,'2014-05-01','2014-07-01',1,'国培项目',1,'教师培训','104','天心区',1,'远程',60,NULL,'2饿未12',NULL,3,30,'hnadmin','2014-05-15','hnadmin','2014-05-15',100,NULL,5,0,NULL,0,NULL,NULL);
INSERT INTO `edu_project` VALUES (89,'0015','新增项目测试2-天心区',2014,'2014-05-01','2014-08-01',1,'国培项目',1,'教师培训','104','天心区',1,'远程',60,NULL,'撒网人味儿',NULL,3,30,'hnadmin','2014-05-15','hnadmin','2014-05-15',200,NULL,5,0,NULL,0,NULL,NULL);
INSERT INTO `edu_project` VALUES (90,'51502','湖南【组织报名】-湖南省',2014,'2014-05-01','2014-05-31',1,'国培项目',1,'教师培训','100','湖南省',1,'远程',10,NULL,'测试专用',NULL,1,30,'hnadmin','2014-05-15','hnadmin','2014-05-15',1000,NULL,5,0,NULL,0,NULL,NULL);
INSERT INTO `edu_project` VALUES (91,'10','湖南14年继教小学老师培训项目【层级分配/报名】-长沙市',2014,'2014-05-01','2014-11-13',1,'国培项目',1,'教师培训','101','长沙市',1,'远程',20,NULL,'湖南省长沙市','10/1400143730512.jpg',3,30,'hnssadmin1','2014-05-15','hnssadmin1','2014-05-15',100,'中国职业技术教育学会平台banner.jpg',5,0,NULL,0,NULL,NULL);
INSERT INTO `edu_project` VALUES (92,'1111','实施机构项目测试111-武山县',2014,'2014-05-01','2014-05-31',1,'国培项目',1,'教师培训','123','武山县',1,'远程',40,NULL,'',NULL,3,30,'gsssadmin1','2014-05-15','gsssadmin1','2014-05-15',300,NULL,10,0,NULL,0,NULL,NULL);
INSERT INTO `edu_project` VALUES (93,'51503','测试项目【组织报名】1-甘肃省',2014,'2014-05-01','2014-05-31',1,'国培项目',1,'教师培训','114','甘肃省',1,'远程',0,NULL,'测试组织报名','',1,40,'gsssadmin2','2014-05-15','gsssadmin2','2014-05-15',1000,'',10,0,NULL,0,NULL,NULL);
INSERT INTO `edu_project` VALUES (94,'11','14年国培小学教师项目【层级分配】-兰州市',2014,'2014-05-01','2014-11-19',1,'国培项目',1,'教师培训','115','兰州市',1,'远程',20,NULL,'兰州市','11/1400148001212.jpg',3,40,'gsssadmin1','2014-05-15','gsssadmin1','2014-05-15',100,'中国职业技术教育学会平台banner.jpg',11,0,NULL,0,NULL,NULL);
INSERT INTO `edu_project` VALUES (95,'51504','测试承陪机构项目-甘肃省',2014,'2014-05-01','2014-05-31',1,'国培项目',1,'教师培训','114','甘肃省',1,'远程',11,NULL,'阿迪斯蒂芬',NULL,1,50,'gsssadmin2','2014-05-15','gsssadmin2','2014-05-15',1000,NULL,10,1,'100',3,'70,80,90',NULL);
INSERT INTO `edu_project` VALUES (96,'515009','测试承陪机构2-城关区',2014,'2014-05-01','2014-05-31',1,'国培项目',1,'教师培训','117','城关区',1,'远程',11,NULL,'',NULL,1,50,'gsssadmin2','2014-05-15','gsssadmin2','2014-05-15',1000,NULL,10,1,'111',3,'70,80,90',NULL);
INSERT INTO `edu_project` VALUES (97,'44','湖南省管添加项目',2014,'2014-05-01','2014-11-19',1,'国培项目',1,'教师培训','100','湖南省',1,'远程',20,NULL,'',NULL,1,30,'hnadmin','2014-05-16','hnadmin','2014-05-16',100,NULL,6,0,NULL,0,NULL,NULL);
INSERT INTO `edu_project` VALUES (98,'51601','黑龙江省阿城区项目',2014,'2014-05-01','2014-05-31',1,'国培项目',1,'教师培训','3','阿城区',1,'远程',10,NULL,'',NULL,3,10,'shengadmin','2014-05-16','shengadmin','2014-05-16',0,NULL,12,0,NULL,0,NULL,NULL);
INSERT INTO `edu_project` VALUES (99,'334','大幅度',2014,'2014-05-01','2014-12-17',1,'国培项目',1,'教师培训','100','湖南省',1,'远程',20,NULL,'',NULL,1,10,'hnadmin','2014-05-16','hnadmin','2014-05-16',100,NULL,5,0,NULL,0,NULL,NULL);
INSERT INTO `edu_project` VALUES (100,'33334','asdfs',2014,'2014-05-01','2014-12-24',1,'国培项目',1,'教师培训','114','甘肃省',1,'远程',20,NULL,'',NULL,2,10,'gsssadmin1','2014-05-16','gsssadmin1','2014-05-16',200,NULL,11,0,NULL,0,NULL,NULL);
INSERT INTO `edu_project` VALUES (101,'51605','甘肃国培项目建立',2014,'2014-05-01','2014-05-31',1,'国培项目',0,'','117','城关区',0,'',10,NULL,'',NULL,3,30,'gsssadmin2','2014-05-16','gsssadmin2','2014-05-16',100,NULL,11,0,NULL,0,NULL,NULL);
/*!40000 ALTER TABLE `edu_project` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table edu_project_allocate_by_area
#

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
) ENGINE=InnoDB AUTO_INCREMENT=255 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
INSERT INTO `edu_project_allocate_by_area` VALUES (238,84,101,0,50,NULL,NULL,0);
INSERT INTO `edu_project_allocate_by_area` VALUES (239,84,102,0,50,NULL,NULL,0);
INSERT INTO `edu_project_allocate_by_area` VALUES (240,88,83,1,100,0,NULL,1);
INSERT INTO `edu_project_allocate_by_area` VALUES (241,89,83,1,100,0,NULL,1);
INSERT INTO `edu_project_allocate_by_area` VALUES (242,91,103,1,25,0,NULL,0);
INSERT INTO `edu_project_allocate_by_area` VALUES (243,91,104,1,25,0,NULL,0);
INSERT INTO `edu_project_allocate_by_area` VALUES (244,91,105,1,25,0,NULL,0);
INSERT INTO `edu_project_allocate_by_area` VALUES (245,91,106,1,25,NULL,NULL,0);
INSERT INTO `edu_project_allocate_by_area` VALUES (246,91,101,1,100,0,NULL,0);
INSERT INTO `edu_project_allocate_by_area` VALUES (247,91,81,1,0,0,NULL,1);
INSERT INTO `edu_project_allocate_by_area` VALUES (248,91,82,1,0,0,NULL,1);
INSERT INTO `edu_project_allocate_by_area` VALUES (249,91,86,1,0,0,NULL,1);
INSERT INTO `edu_project_allocate_by_area` VALUES (250,92,88,1,300,0,NULL,1);
INSERT INTO `edu_project_allocate_by_area` VALUES (251,94,117,0,25,NULL,NULL,0);
INSERT INTO `edu_project_allocate_by_area` VALUES (252,94,118,0,25,NULL,NULL,0);
INSERT INTO `edu_project_allocate_by_area` VALUES (253,94,119,0,25,NULL,NULL,0);
INSERT INTO `edu_project_allocate_by_area` VALUES (254,94,120,0,25,NULL,NULL,0);
/*!40000 ALTER TABLE `edu_project_allocate_by_area` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table edu_project_audit
#

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
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
INSERT INTO `edu_project_audit` VALUES (62,264,264,' 湖北管理员','2014-05-13 10:20:33',1,'pass',77,'2014-05-13 10:20:10','2014-05-13 10:20:33');
INSERT INTO `edu_project_audit` VALUES (63,264,264,' 湖北管理员','2014-05-13 10:20:27',1,'pass',78,'2014-05-13 10:20:13','2014-05-13 10:20:27');
INSERT INTO `edu_project_audit` VALUES (64,264,264,' 湖北管理员','2014-05-13 10:20:23',1,'pass',79,'2014-05-13 10:20:16','2014-05-13 10:20:23');
INSERT INTO `edu_project_audit` VALUES (65,264,264,' 湖北管理员','2014-05-13 10:54:10',1,'dd',80,'2014-05-13 10:54:00','2014-05-13 10:54:10');
INSERT INTO `edu_project_audit` VALUES (66,306,306,'李翠翠','2014-05-14 15:21:06',1,'pass',82,'2014-05-14 15:20:09','2014-05-14 15:21:06');
INSERT INTO `edu_project_audit` VALUES (67,306,306,'李翠翠','2014-05-14 15:21:28',0,'fail',83,'2014-05-14 15:20:12','2014-05-14 15:21:28');
INSERT INTO `edu_project_audit` VALUES (68,306,306,'李翠翠','2014-05-14 15:21:10',1,'pass',84,'2014-05-14 15:20:15','2014-05-14 15:21:10');
INSERT INTO `edu_project_audit` VALUES (69,306,306,'李翠翠','2014-05-14 15:22:00',1,'成功',83,'2014-05-14 15:21:47','2014-05-14 15:22:00');
INSERT INTO `edu_project_audit` VALUES (70,306,306,'李翠翠','2014-05-14 16:32:42',1,'pass',85,'2014-05-14 16:32:35','2014-05-14 16:32:42');
INSERT INTO `edu_project_audit` VALUES (71,264,264,' 湖北管理员','2014-05-15 15:46:44',0,'不同意',86,'2014-05-15 15:46:23','2014-05-15 15:46:44');
INSERT INTO `edu_project_audit` VALUES (72,264,264,' 湖北管理员','2014-05-15 15:47:14',1,'可以通过',86,'2014-05-15 15:47:05','2014-05-15 15:47:14');
INSERT INTO `edu_project_audit` VALUES (73,264,264,' 湖北管理员','2014-05-15 16:22:58',1,'统一',87,'2014-05-15 16:22:47','2014-05-15 16:22:58');
INSERT INTO `edu_project_audit` VALUES (74,305,305,' 李蕊','2014-05-15 16:24:03',1,'咨询费',88,'2014-05-15 16:23:50','2014-05-15 16:24:03');
INSERT INTO `edu_project_audit` VALUES (75,305,305,' 李蕊','2014-05-15 16:31:04',1,'淡定的',89,'2014-05-15 16:30:54','2014-05-15 16:31:04');
INSERT INTO `edu_project_audit` VALUES (76,305,305,' 李蕊','2014-05-15 16:40:15',1,'同意',90,'2014-05-15 16:40:01','2014-05-15 16:40:15');
INSERT INTO `edu_project_audit` VALUES (77,306,306,'李翠翠','2014-05-15 16:49:07',1,'pass',91,'2014-05-15 16:48:54','2014-05-15 16:49:07');
INSERT INTO `edu_project_audit` VALUES (78,356,356,'刘梅','2014-05-15 17:36:39',1,'啊啊啊',92,'2014-05-15 17:34:18','2014-05-15 17:36:39');
INSERT INTO `edu_project_audit` VALUES (79,357,357,'王明','2014-05-15 17:35:39',0,'不同意',93,'2014-05-15 17:35:19','2014-05-15 17:35:39');
INSERT INTO `edu_project_audit` VALUES (80,357,357,'王明','2014-05-15 17:36:38',1,'同意一下',93,'2014-05-15 17:36:28','2014-05-15 17:36:38');
INSERT INTO `edu_project_audit` VALUES (81,356,356,'刘梅','2014-05-15 18:00:17',0,'fail',94,'2014-05-15 18:00:04','2014-05-15 18:00:17');
INSERT INTO `edu_project_audit` VALUES (82,356,356,'刘梅','2014-05-15 18:00:43',1,'pass',94,'2014-05-15 18:00:34','2014-05-15 18:00:43');
INSERT INTO `edu_project_audit` VALUES (83,357,357,'王明','2014-05-15 19:03:30',1,'',95,'2014-05-15 19:03:23','2014-05-15 19:03:30');
INSERT INTO `edu_project_audit` VALUES (84,357,357,'王明','2014-05-15 19:12:28',1,'',96,'2014-05-15 19:12:21','2014-05-15 19:12:28');
INSERT INTO `edu_project_audit` VALUES (85,305,305,' 李蕊','2014-05-16 10:59:14',1,'',97,'2014-05-16 10:59:08','2014-05-16 10:59:14');
INSERT INTO `edu_project_audit` VALUES (86,357,357,'王明','2014-05-16 11:11:21',1,'',101,'2014-05-16 11:11:14','2014-05-16 11:11:21');
/*!40000 ALTER TABLE `edu_project_audit` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table edu_project_class
#

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
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
INSERT INTO `edu_project_class` VALUES (1,'小学数学模块一义务教育数学课程标准的设计、实施与修订（小学版）','\n\t\t\t\t\t\t\t\t选修\n\t\t\t\t\t\t\t',1,'http://course.teacheredu.cn/kb0016a/index.htm','',1,'jigouadmin1','jigouadmin1','2014-04-11','2014-04-11','小学数学',2,6,85);
INSERT INTO `edu_project_class` VALUES (2,'小学语文课程2模块一十年语文课程改革之路（小学版）','\n\t\t\t\t\t\t\t\t必修\n\t\t\t\t\t\t\t',0,'http://course.teacheredu.cn/kb0020a/index.htm','',1,'jigouadmin1',NULL,'2014-04-11','2014-04-11','小学语文',1,6,85);
INSERT INTO `edu_project_class` VALUES (3,'小学语文课程3模块二关于“阅读”的目标、教学及评价（小学版）','\n\t\t\t\t\t\t\t\t选修\n\t\t\t\t\t\t\t',1,'http://course.teacheredu.cn/kb0051a/index.htm','',1,'jigouadmin1',NULL,'2014-04-11','2014-04-11','小学语文',1,6,85);
INSERT INTO `edu_project_class` VALUES (4,'小学数学2模块二义务教育数学课程标准的理念与目标（小学版）','\n\t\t\t\t\t\t\t\t选修\n\t\t\t\t\t\t\t',1,'http://course.teacheredu.cn/kb0031a/index.htm','',1,'jigouadmin1',NULL,'2014-04-11','2014-04-11','小学数学',2,6,85);
INSERT INTO `edu_project_class` VALUES (5,'小学语文课程1义务教育课程标准修订和审议工作情况介绍','\n\t\t\t\t\t\t\t\t选修\n\t\t\t\t\t\t\t',1,'http://course.teacheredu.cn/kb0000a/index.htm','',1,'jigouadmin1',NULL,'2014-04-11','2014-04-11','小学语文',1,6,85);
INSERT INTO `edu_project_class` VALUES (19,'课程1','\n\t\t\t\t\t\t\t\t选修\n\t\t\t\t\t\t\t',1,'http://course.teacheredu.cn/jxll002a/html/index.htm','111',1,'jigouadmin3',NULL,'2014-05-08','2014-05-08','初中语文',5,6,151);
INSERT INTO `edu_project_class` VALUES (23,'小学培训项目','必修',0,'','小学培训项目测试。',1,'dishiadmin','dishiadmin','2014-05-11','2014-05-11','小学语文',1,2,82);
INSERT INTO `edu_project_class` VALUES (24,'小学数学培训','必修',0,'','小学数学培训项目测试',1,'quxianadmin',NULL,'2014-05-11','2014-05-11','小学语文',1,3,83);
INSERT INTO `edu_project_class` VALUES (25,'小学数学测试','必修',0,'','小学数学培训项目',1,'quxianadmin',NULL,'2014-05-11','2014-05-11','小学数学',2,3,83);
INSERT INTO `edu_project_class` VALUES (26,'小学语文培训','必修',0,'','语文培训项目',1,'quxianadmin','quxianadmin','2014-05-11','2014-05-11','小学语文',1,3,83);
INSERT INTO `edu_project_class` VALUES (27,'小学语文培训','\n\t\t\t\t\t\t\t\t选修\n\t\t\t\t\t\t\t',1,'','小学语文培训项目测试',1,'jigouadmin1','jigouadmin1','2014-05-11','2014-05-11','小学语文',1,6,86);
INSERT INTO `edu_project_class` VALUES (28,'小学语文','选修',1,'http://www.baidu.com','111dfassdfadsfa adfadfa',1,'jigouadmin1','jigouadmin1','2014-05-11','2014-05-11','小学语文',1,6,86);
/*!40000 ALTER TABLE `edu_project_class` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table edu_project_class_category
#

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
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
INSERT INTO `edu_project_class_category` VALUES (1,1,1,1,NULL,NULL,NULL,NULL);
INSERT INTO `edu_project_class_category` VALUES (2,1,2,1,NULL,NULL,NULL,NULL);
INSERT INTO `edu_project_class_category` VALUES (3,1,3,1,NULL,NULL,NULL,NULL);
INSERT INTO `edu_project_class_category` VALUES (4,1,4,1,NULL,NULL,NULL,NULL);
INSERT INTO `edu_project_class_category` VALUES (5,1,5,1,NULL,NULL,NULL,NULL);
INSERT INTO `edu_project_class_category` VALUES (19,43,19,1,NULL,NULL,NULL,NULL);
INSERT INTO `edu_project_class_category` VALUES (23,35,23,1,NULL,NULL,NULL,NULL);
INSERT INTO `edu_project_class_category` VALUES (24,4,24,1,NULL,NULL,NULL,NULL);
INSERT INTO `edu_project_class_category` VALUES (25,4,25,1,NULL,NULL,NULL,NULL);
INSERT INTO `edu_project_class_category` VALUES (26,59,26,1,NULL,NULL,NULL,NULL);
INSERT INTO `edu_project_class_category` VALUES (27,11,27,1,NULL,NULL,NULL,NULL);
INSERT INTO `edu_project_class_category` VALUES (28,16,28,1,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `edu_project_class_category` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table edu_project_comment
#

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
  `teacher_class_score` int(11) DEFAULT NULL COMMENT '教师学分',
  `teacher_class_period` int(11) DEFAULT NULL COMMENT '教师学时',
  `upload_date` varchar(20) DEFAULT NULL COMMENT '上传培训成绩时间',
  `version` int(11) DEFAULT NULL COMMENT '教师报名时的版本号',
  `type` int(11) DEFAULT NULL COMMENT '是否是补报名:0--正常报名，1--补报名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=119 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
INSERT INTO `edu_project_comment` VALUES (74,79,NULL,302,86,13,NULL,NULL,NULL,'jiaoshi10','2014-05-13','hbadmin','2014-05-13',11,NULL,'tongg',NULL,NULL,NULL,1,0);
INSERT INTO `edu_project_comment` VALUES (75,79,NULL,293,NULL,13,NULL,NULL,NULL,'hbadmin','2014-05-13','hbadmin','2014-05-13',11,NULL,'11',NULL,NULL,NULL,1,0);
INSERT INTO `edu_project_comment` VALUES (77,80,NULL,298,NULL,11,NULL,NULL,NULL,'hbadmin','2014-05-13','hbadmin','2014-05-13',11,NULL,NULL,NULL,NULL,NULL,1,0);
INSERT INTO `edu_project_comment` VALUES (78,80,NULL,299,NULL,11,NULL,NULL,NULL,'hbadmin','2014-05-13','hbadmin','2014-05-13',11,NULL,NULL,NULL,NULL,NULL,1,0);
INSERT INTO `edu_project_comment` VALUES (79,78,NULL,293,89,13,47,NULL,NULL,'jiaoshi1','2014-05-13','hbadmin','2014-05-13',11,NULL,NULL,NULL,21,NULL,1,0);
INSERT INTO `edu_project_comment` VALUES (80,78,NULL,294,86,13,67,NULL,NULL,'jiaoshi2','2014-05-13','hbadmin','2014-05-13',11,NULL,NULL,NULL,21,NULL,1,0);
INSERT INTO `edu_project_comment` VALUES (81,78,NULL,295,NULL,13,77,NULL,NULL,'hbadmin','2014-05-13','hbadmin','2014-05-13',11,NULL,NULL,NULL,21,NULL,1,0);
INSERT INTO `edu_project_comment` VALUES (82,77,NULL,293,86,13,NULL,NULL,NULL,'jiaoshi1','2014-05-13','hbadmin','2014-05-13',11,NULL,'pass',NULL,NULL,NULL,1,1);
INSERT INTO `edu_project_comment` VALUES (83,77,NULL,294,87,13,NULL,NULL,NULL,'jiaoshi2','2014-05-13','hbadmin','2014-05-13',11,NULL,'pass',NULL,NULL,NULL,1,1);
INSERT INTO `edu_project_comment` VALUES (84,78,NULL,304,89,13,77,NULL,NULL,'jiaoshi11','2014-05-13','hbadmin','2014-05-13',11,NULL,NULL,NULL,21,NULL,1,1);
INSERT INTO `edu_project_comment` VALUES (85,78,NULL,304,NULL,11,NULL,NULL,NULL,NULL,NULL,NULL,NULL,11,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_project_comment` VALUES (86,79,NULL,302,NULL,11,NULL,NULL,NULL,NULL,NULL,NULL,NULL,11,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_project_comment` VALUES (87,83,NULL,330,NULL,13,NULL,NULL,NULL,'hnssadmin1','2014-05-14','hnadmin','2014-05-14',13,'合格','pass',6,NULL,NULL,1,0);
INSERT INTO `edu_project_comment` VALUES (88,83,NULL,328,98,13,94,1,'优秀','laoshi1','2014-05-14','hncpadmin1','2014-05-14',13,'合格','pass',5,30,'2014年05月14日 16点57分',1,0);
INSERT INTO `edu_project_comment` VALUES (89,83,NULL,329,98,13,65,1,'中','laoshi2','2014-05-14','hncpadmin1','2014-05-14',11,NULL,'pass',NULL,30,'2014年05月14日 16点57分',1,0);
INSERT INTO `edu_project_comment` VALUES (90,83,NULL,336,NULL,13,NULL,NULL,NULL,'hnssadmin1','2014-05-14','hnadmin','2014-05-14',11,NULL,'pass',NULL,NULL,NULL,1,0);
INSERT INTO `edu_project_comment` VALUES (91,84,NULL,333,NULL,13,NULL,NULL,NULL,'hnadmin','2014-05-14','hnadmin','2014-05-14',11,NULL,'pass',NULL,NULL,NULL,1,0);
INSERT INTO `edu_project_comment` VALUES (92,82,NULL,328,98,13,NULL,NULL,NULL,'laoshi1','2014-05-14','hnadmin','2014-05-14',11,NULL,'pass',NULL,NULL,NULL,1,0);
INSERT INTO `edu_project_comment` VALUES (93,85,NULL,336,NULL,13,NULL,NULL,NULL,'hnssadmin1','2014-05-14','hnssadmin1','2014-05-14',11,NULL,'33',NULL,NULL,NULL,1,0);
INSERT INTO `edu_project_comment` VALUES (94,85,NULL,330,NULL,13,NULL,NULL,NULL,'hnssadmin1','2014-05-14','hnssadmin1','2014-05-14',11,NULL,'33',NULL,NULL,NULL,1,0);
INSERT INTO `edu_project_comment` VALUES (95,85,NULL,328,NULL,13,NULL,NULL,NULL,'hnssadmin1','2014-05-14','hnssadmin1','2014-05-14',11,NULL,'33',NULL,NULL,NULL,1,0);
INSERT INTO `edu_project_comment` VALUES (96,85,NULL,329,98,13,NULL,NULL,NULL,'laoshi2','2014-05-15','hnssadmin1','2014-05-14',11,NULL,'33',NULL,NULL,NULL,1,0);
INSERT INTO `edu_project_comment` VALUES (98,82,NULL,329,NULL,11,NULL,NULL,NULL,'laoshi2','2014-05-15','laoshi2','2014-05-15',11,NULL,NULL,NULL,NULL,NULL,9,1);
INSERT INTO `edu_project_comment` VALUES (99,84,NULL,329,NULL,11,NULL,NULL,NULL,'laoshi2','2014-05-15','laoshi2','2014-05-15',11,NULL,NULL,NULL,NULL,NULL,9,1);
INSERT INTO `edu_project_comment` VALUES (100,84,NULL,332,NULL,11,NULL,NULL,NULL,'laoshi5','2014-05-15','laoshi5','2014-05-15',11,NULL,NULL,NULL,NULL,NULL,4,1);
INSERT INTO `edu_project_comment` VALUES (101,89,NULL,353,NULL,13,NULL,NULL,NULL,'test2','2014-05-15','hnadmin','2014-05-15',11,NULL,'adadaddddd',NULL,NULL,NULL,1,0);
INSERT INTO `edu_project_comment` VALUES (102,90,NULL,353,NULL,13,NULL,NULL,NULL,'hnadmin','2014-05-15','hnadmin','2014-05-15',11,NULL,'通过了',NULL,NULL,NULL,1,0);
INSERT INTO `edu_project_comment` VALUES (103,93,NULL,381,NULL,13,NULL,NULL,NULL,'gsssadmin2','2014-05-15','gsssadmin2','2014-05-15',11,'待审核','',NULL,NULL,NULL,1,0);
INSERT INTO `edu_project_comment` VALUES (104,93,NULL,380,NULL,13,NULL,NULL,NULL,'gsssadmin2','2014-05-15','gsssadmin2','2014-05-15',11,'待审核','',NULL,NULL,NULL,1,0);
INSERT INTO `edu_project_comment` VALUES (105,93,NULL,382,NULL,13,NULL,NULL,NULL,'gsssadmin2','2014-05-15','gsssadmin2','2014-05-15',11,'待审核','',NULL,NULL,NULL,1,0);
INSERT INTO `edu_project_comment` VALUES (106,94,NULL,380,NULL,13,NULL,NULL,NULL,'gsssadmin1','2014-05-15','gsssadmin1','2014-05-15',11,'待审核','pass',NULL,NULL,NULL,1,0);
INSERT INTO `edu_project_comment` VALUES (107,94,NULL,381,NULL,13,NULL,NULL,NULL,'gsssadmin1','2014-05-15','gsssadmin1','2014-05-15',11,'待审核','pass',NULL,NULL,NULL,1,0);
INSERT INTO `edu_project_comment` VALUES (108,93,NULL,388,NULL,13,NULL,NULL,NULL,'gsssadmin2','2014-05-15','gsssadmin2','2014-05-15',11,'待审核','',NULL,NULL,NULL,1,1);
INSERT INTO `edu_project_comment` VALUES (109,95,NULL,381,NULL,13,NULL,NULL,NULL,'gsssadmin2','2014-05-15','gsssadmin2','2014-05-15',11,'待审核','',NULL,NULL,NULL,1,0);
INSERT INTO `edu_project_comment` VALUES (110,95,NULL,380,NULL,13,NULL,NULL,NULL,'gsssadmin2','2014-05-15','gsssadmin2','2014-05-15',11,'待审核','',NULL,NULL,NULL,1,0);
INSERT INTO `edu_project_comment` VALUES (111,95,NULL,382,NULL,13,NULL,NULL,NULL,'gsssadmin2','2014-05-15','gsssadmin2','2014-05-15',11,'待审核','',NULL,NULL,NULL,1,0);
INSERT INTO `edu_project_comment` VALUES (112,95,NULL,388,NULL,13,NULL,NULL,NULL,'gsssadmin2','2014-05-15','gsssadmin2','2014-05-15',11,'待审核','',NULL,NULL,NULL,1,0);
INSERT INTO `edu_project_comment` VALUES (113,96,5,380,106,13,95,1,'优秀','testone1','2014-05-15','gscpadmin1','2014-05-15',11,'待审核','',NULL,11,'2014年05月15日 19点21分',1,0);
INSERT INTO `edu_project_comment` VALUES (114,96,5,389,106,13,66,0,'不合格','jiaoshinew','2014-05-15','gsssadmin1','2014-05-15',11,'待审核','',NULL,11,NULL,1,1);
INSERT INTO `edu_project_comment` VALUES (115,96,5,390,NULL,13,78,1,'合格','gsadmin','2014-05-15','gsadmin','2014-05-15',11,'待审核','',NULL,11,NULL,1,1);
INSERT INTO `edu_project_comment` VALUES (116,96,5,391,106,13,NULL,NULL,NULL,'testone12','2014-05-15','gsssadmin1','2014-05-15',11,'待审核','',NULL,NULL,NULL,1,1);
INSERT INTO `edu_project_comment` VALUES (117,92,NULL,386,NULL,11,60,NULL,NULL,'testone7','2014-05-16','testone7','2014-05-16',11,'待审核',NULL,NULL,NULL,NULL,1,0);
INSERT INTO `edu_project_comment` VALUES (118,101,NULL,389,NULL,11,NULL,NULL,NULL,'gsssadmin2','2014-05-16','gsssadmin2','2014-05-16',11,'待审核',NULL,NULL,NULL,NULL,1,0);
/*!40000 ALTER TABLE `edu_project_comment` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table edu_project_count
#

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
/*!40000 ALTER TABLE `edu_project_count` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table edu_project_notrain
#

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
INSERT INTO `edu_project_notrain` VALUES (3,'5','校本培训项目',1,'校本培训项目',4,'14年国培计划','2014',4,NULL,NULL,'教师网','2014-05-01','2014-09-10',1,'教师培训',1,'远程','111',NULL,NULL,NULL,NULL);
INSERT INTO `edu_project_notrain` VALUES (4,'No132','湖南项目培训',1,'校本培训项目',5,'湖南省14年继教计划','2013',70,NULL,NULL,'湖南教师厅','2014-05-01','2014-07-01',0,'',0,'','湖南测试项目',NULL,NULL,NULL,NULL);
INSERT INTO `edu_project_notrain` VALUES (5,'xxx','test-一',1,'校本培训项目',5,'湖南省14年继教计划','2014',6,NULL,NULL,'sf','2014-05-15','2014-05-31',1,'教师培训',0,'','sdfs',NULL,NULL,NULL,NULL);
INSERT INTO `edu_project_notrain` VALUES (6,'1ss','非培训类项1',2,'非培训类项目',5,'湖南省14年继教计划','2014',4,NULL,'','sdf','2014-04-30','2014-05-31',0,'0',0,'0','sf',NULL,NULL,NULL,NULL);
INSERT INTO `edu_project_notrain` VALUES (7,'ddd','ccc5',2,'非培训类项目',5,'湖南省14年继教计划','2014',5,101,'长沙市','ss','2014-04-29','2014-05-31',0,'0',0,'0','',NULL,NULL,NULL,NULL);
INSERT INTO `edu_project_notrain` VALUES (8,'123456','五千年历史',1,'校本培训项目',10,'实施机构项目','2014',50,NULL,NULL,'甘肃省','2014-05-01','2014-05-31',1,'教师培训',1,'远程','项目测试',NULL,NULL,NULL,NULL);
INSERT INTO `edu_project_notrain` VALUES (9,'113','非培516-1',2,'非培训类项目',5,'湖南省14年继教计划','2014',3,102,'湘潭市','非培516-1','2014-05-16','2014-05-31',0,'0',0,'0','非培516-1',NULL,NULL,NULL,NULL);
INSERT INTO `edu_project_notrain` VALUES (10,'xxf','非培一',2,'非培训类项目',13,'福建板块一','2014',4,126,'福州市','非培一','2014-05-09','2014-05-31',0,'0',0,'0','sf',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `edu_project_notrain` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table edu_project_notrain_comment
#

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
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
INSERT INTO `edu_project_notrain_comment` VALUES (22,8,380,30,0,11,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_project_notrain_comment` VALUES (23,8,381,30,0,11,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_project_notrain_comment` VALUES (24,8,382,30,0,11,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_project_notrain_comment` VALUES (25,8,390,30,0,11,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_project_notrain_comment` VALUES (26,8,388,30,0,11,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_project_notrain_comment` VALUES (27,8,387,30,0,11,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `edu_project_notrain_comment` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table edu_project_summary
#

CREATE TABLE `edu_project_summary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL COMMENT '总结角色类型（0：实施机构，1：教师，2：承培机构,3:总结报告，）',
  `title` varchar(50) DEFAULT NULL COMMENT '总结标题',
  `content` text COMMENT '总结内容',
  `attchement_title` varchar(200) DEFAULT NULL COMMENT '附件标题',
  `attchement_url` varchar(255) DEFAULT NULL COMMENT '附件url',
  `create_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '提交时间',
  `create_by` int(11) DEFAULT NULL COMMENT '提交人ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
INSERT INTO `edu_project_summary` VALUES (3,78,1,'asdfsd','asdfdsasdfsd','1400059983875.jpg','uploadFile/summary/','2014-05-14 17:33:03',293);
INSERT INTO `edu_project_summary` VALUES (4,79,2,'dfsasdf','adsfdsf',NULL,NULL,'2014-05-14 18:28:17',268);
INSERT INTO `edu_project_summary` VALUES (5,83,1,'','',NULL,NULL,'2014-05-15 14:57:33',329);
INSERT INTO `edu_project_summary` VALUES (6,83,4,'提交提交2','tttttttttt','1400142961777.jpg','uploadFile/summary/','2014-05-16 09:24:12',357);
INSERT INTO `edu_project_summary` VALUES (7,96,1,'对项目的总结','阿斯顿发萨菲','1400154562849.jpg','uploadFile/summary/','2014-05-15 19:49:22',391);
INSERT INTO `edu_project_summary` VALUES (8,96,1,'我的总结','阿迪发送到发送到发送到发送到发送到发送到分阿打发第三方撒地方','1400154575038.jpg','uploadFile/summary/','2014-05-15 19:49:35',380);
INSERT INTO `edu_project_summary` VALUES (9,96,0,'我的总结1','我的总结1','1400158584333.png','uploadFile/summary/','2014-05-15 20:56:31',357);
INSERT INTO `edu_project_summary` VALUES (10,96,4,'培训总结','培训总结','1400205507835.jpg','uploadFile/summary/','2014-05-16 11:10:36',356);
/*!40000 ALTER TABLE `edu_project_summary` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table edu_project_train_target
#

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
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
INSERT INTO `edu_project_train_target` VALUES (75,76,NULL,NULL,NULL,0,'',0,'',0,'',NULL,'1','小学语文','','','1',NULL,'100');
INSERT INTO `edu_project_train_target` VALUES (76,77,NULL,NULL,NULL,0,'',0,'',0,'',NULL,'1','小学语文','','','1',NULL,'100');
INSERT INTO `edu_project_train_target` VALUES (77,78,NULL,NULL,NULL,0,'',0,'',0,'',NULL,'1','小学语文','','','0',NULL,'0');
INSERT INTO `edu_project_train_target` VALUES (78,79,NULL,NULL,NULL,0,'',0,'',0,'',NULL,'2','小学数学','','','0',NULL,'0');
INSERT INTO `edu_project_train_target` VALUES (79,80,NULL,NULL,NULL,0,'',0,'',0,'',NULL,'1,2,3,4','小学语文,小学数学,小学美术,小学音乐','','','0',NULL,'0');
INSERT INTO `edu_project_train_target` VALUES (80,81,NULL,'',NULL,0,'',0,'',0,'',NULL,'2','小学数学','','','0',NULL,'0');
INSERT INTO `edu_project_train_target` VALUES (81,82,NULL,'',NULL,0,'',0,'',0,'',NULL,'1','小学语文','','','1',NULL,'100');
INSERT INTO `edu_project_train_target` VALUES (82,83,NULL,'',NULL,0,'',0,'',0,'',NULL,'1','小学语文','','','0',NULL,'0');
INSERT INTO `edu_project_train_target` VALUES (83,84,NULL,NULL,NULL,0,'',0,'',0,'',NULL,'2','小学数学','','','0',NULL,'0');
INSERT INTO `edu_project_train_target` VALUES (84,85,NULL,NULL,NULL,0,'',0,'',0,'',NULL,'1','小学语文','','','0',NULL,'0');
INSERT INTO `edu_project_train_target` VALUES (85,86,NULL,'',NULL,0,'',0,'',0,'',NULL,'1','小学语文','','','0',NULL,'0');
INSERT INTO `edu_project_train_target` VALUES (86,87,NULL,NULL,NULL,0,'',0,'',0,'',NULL,'1','小学语文','','','0',NULL,'0');
INSERT INTO `edu_project_train_target` VALUES (87,88,NULL,NULL,NULL,0,'',1,'教师',1,'一级教师',NULL,'1,2,3','小学语文,小学数学,小学美术','','','0',NULL,'0');
INSERT INTO `edu_project_train_target` VALUES (88,89,NULL,NULL,NULL,3,'本科',1,'教师',1,'一级教师',NULL,'1','小学语文','','','0',NULL,'0');
INSERT INTO `edu_project_train_target` VALUES (89,90,NULL,NULL,NULL,0,'',0,'',0,'',NULL,'1','小学语文','','','0',NULL,'0');
INSERT INTO `edu_project_train_target` VALUES (90,91,NULL,NULL,NULL,0,'',0,'',0,'',NULL,'1','小学语文','','','1',NULL,'10');
INSERT INTO `edu_project_train_target` VALUES (91,92,NULL,NULL,NULL,3,'本科',1,'教师',1,'一级教师',NULL,'1,2','小学语文,小学数学','','','0',NULL,'0');
INSERT INTO `edu_project_train_target` VALUES (92,93,NULL,'',NULL,0,'',0,'',0,'',NULL,'1','小学语文','','','0',NULL,'0');
INSERT INTO `edu_project_train_target` VALUES (93,94,NULL,'',NULL,0,'',0,'',0,'',NULL,'1,2','小学语文,小学数学','','','0',NULL,'0');
INSERT INTO `edu_project_train_target` VALUES (94,95,NULL,NULL,NULL,0,'',0,'',0,'',NULL,'1','小学语文','','','0',NULL,'0');
INSERT INTO `edu_project_train_target` VALUES (95,96,NULL,NULL,NULL,0,'',0,'',0,'',NULL,'1','小学语文','','','0',NULL,'0');
INSERT INTO `edu_project_train_target` VALUES (96,97,NULL,NULL,NULL,0,'',0,'',0,'',NULL,'1','小学语文','','','0',NULL,'0');
INSERT INTO `edu_project_train_target` VALUES (97,98,NULL,NULL,NULL,1,'高中',0,'',0,'',NULL,'1','小学语文','','','0',NULL,'0');
INSERT INTO `edu_project_train_target` VALUES (98,99,NULL,NULL,NULL,0,'',0,'',0,'',NULL,'1','小学语文','','','0',NULL,'0');
INSERT INTO `edu_project_train_target` VALUES (99,100,NULL,NULL,NULL,0,'',0,'',0,'',NULL,'1','小学语文','','','0',NULL,'0');
INSERT INTO `edu_project_train_target` VALUES (100,101,NULL,NULL,NULL,0,'',0,'',0,'',NULL,'1','小学语文','','','0',NULL,'0');
/*!40000 ALTER TABLE `edu_project_train_target` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table edu_question
#

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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
INSERT INTO `edu_question` VALUES (10,'2014-05-14','hnssadmin1',2,1,'您对这次项目培训是否满意',7,'Y',1,'0');
INSERT INTO `edu_question` VALUES (11,'2014-05-15','gsssadmin1',2,1,'你对本次培训满意吗',10,'Y',2,'0');
INSERT INTO `edu_question` VALUES (12,'2014-05-15','gsssadmin1',3,1,'你对本次培训印象最深刻的是',10,'N',2,'0');
INSERT INTO `edu_question` VALUES (13,'2014-05-15','gsssadmin1',1,1,'你对平台的意见',10,'Y',2,'0');
INSERT INTO `edu_question` VALUES (14,'2014-05-15','gsssadmin1',0,1,'你对平台的老师的感觉是否是满意的___',10,'Y',2,'0');
/*!40000 ALTER TABLE `edu_question` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table edu_question_options
#

CREATE TABLE `edu_question_options` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_date` date DEFAULT NULL COMMENT '创建日期',
  `username` varchar(30) DEFAULT NULL COMMENT '创建者',
  `content` varchar(255) DEFAULT NULL COMMENT '选项内容',
  `rank` int(11) DEFAULT NULL COMMENT '顺序',
  `question_id` int(11) DEFAULT NULL COMMENT '问题id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
INSERT INTO `edu_question_options` VALUES (21,'2014-05-14','hnssadmin1','是',1,10);
INSERT INTO `edu_question_options` VALUES (22,'2014-05-14','hnssadmin1','否',1,10);
INSERT INTO `edu_question_options` VALUES (23,'2014-05-15','gsssadmin1','是',1,11);
INSERT INTO `edu_question_options` VALUES (24,'2014-05-15','gsssadmin1','否',1,11);
INSERT INTO `edu_question_options` VALUES (25,'2014-05-15','gsssadmin1','速度快',1,12);
INSERT INTO `edu_question_options` VALUES (26,'2014-05-15','gsssadmin1','培训内容丰富',1,12);
INSERT INTO `edu_question_options` VALUES (27,'2014-05-15','gsssadmin1','老师好',1,12);
INSERT INTO `edu_question_options` VALUES (28,'2014-05-15','gsssadmin1','  ',1,13);
INSERT INTO `edu_question_options` VALUES (29,'2014-05-15','gsssadmin1','  ',1,14);
/*!40000 ALTER TABLE `edu_question_options` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table edu_relas_func_role
#

CREATE TABLE `edu_relas_func_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `func_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3035 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
INSERT INTO `edu_relas_func_role` VALUES (235,8,10);
INSERT INTO `edu_relas_func_role` VALUES (236,8,1);
INSERT INTO `edu_relas_func_role` VALUES (237,8,2);
INSERT INTO `edu_relas_func_role` VALUES (238,8,7);
INSERT INTO `edu_relas_func_role` VALUES (239,8,8);
INSERT INTO `edu_relas_func_role` VALUES (240,8,70);
INSERT INTO `edu_relas_func_role` VALUES (241,8,71);
INSERT INTO `edu_relas_func_role` VALUES (242,8,72);
INSERT INTO `edu_relas_func_role` VALUES (243,8,73);
INSERT INTO `edu_relas_func_role` VALUES (244,8,74);
INSERT INTO `edu_relas_func_role` VALUES (245,8,75);
INSERT INTO `edu_relas_func_role` VALUES (246,8,76);
INSERT INTO `edu_relas_func_role` VALUES (247,8,77);
INSERT INTO `edu_relas_func_role` VALUES (248,8,78);
INSERT INTO `edu_relas_func_role` VALUES (249,8,79);
INSERT INTO `edu_relas_func_role` VALUES (250,8,4);
INSERT INTO `edu_relas_func_role` VALUES (251,8,6);
INSERT INTO `edu_relas_func_role` VALUES (547,20,9);
INSERT INTO `edu_relas_func_role` VALUES (548,20,10);
INSERT INTO `edu_relas_func_role` VALUES (549,20,30);
INSERT INTO `edu_relas_func_role` VALUES (550,20,31);
INSERT INTO `edu_relas_func_role` VALUES (551,20,32);
INSERT INTO `edu_relas_func_role` VALUES (552,20,33);
INSERT INTO `edu_relas_func_role` VALUES (553,20,34);
INSERT INTO `edu_relas_func_role` VALUES (554,20,40);
INSERT INTO `edu_relas_func_role` VALUES (555,20,42);
INSERT INTO `edu_relas_func_role` VALUES (556,20,1);
INSERT INTO `edu_relas_func_role` VALUES (557,20,2);
INSERT INTO `edu_relas_func_role` VALUES (558,20,45);
INSERT INTO `edu_relas_func_role` VALUES (559,20,46);
INSERT INTO `edu_relas_func_role` VALUES (560,20,66);
INSERT INTO `edu_relas_func_role` VALUES (561,20,7);
INSERT INTO `edu_relas_func_role` VALUES (562,20,8);
INSERT INTO `edu_relas_func_role` VALUES (563,20,14);
INSERT INTO `edu_relas_func_role` VALUES (564,20,15);
INSERT INTO `edu_relas_func_role` VALUES (565,20,22);
INSERT INTO `edu_relas_func_role` VALUES (566,20,23);
INSERT INTO `edu_relas_func_role` VALUES (567,20,24);
INSERT INTO `edu_relas_func_role` VALUES (568,20,13);
INSERT INTO `edu_relas_func_role` VALUES (569,20,29);
INSERT INTO `edu_relas_func_role` VALUES (570,20,26);
INSERT INTO `edu_relas_func_role` VALUES (571,20,27);
INSERT INTO `edu_relas_func_role` VALUES (572,20,28);
INSERT INTO `edu_relas_func_role` VALUES (573,20,35);
INSERT INTO `edu_relas_func_role` VALUES (574,20,71);
INSERT INTO `edu_relas_func_role` VALUES (575,20,75);
INSERT INTO `edu_relas_func_role` VALUES (576,20,76);
INSERT INTO `edu_relas_func_role` VALUES (577,20,80);
INSERT INTO `edu_relas_func_role` VALUES (578,20,86);
INSERT INTO `edu_relas_func_role` VALUES (579,20,87);
INSERT INTO `edu_relas_func_role` VALUES (580,20,88);
INSERT INTO `edu_relas_func_role` VALUES (581,20,17);
INSERT INTO `edu_relas_func_role` VALUES (582,20,3);
INSERT INTO `edu_relas_func_role` VALUES (583,20,4);
INSERT INTO `edu_relas_func_role` VALUES (584,20,11);
INSERT INTO `edu_relas_func_role` VALUES (585,20,44);
INSERT INTO `edu_relas_func_role` VALUES (586,20,47);
INSERT INTO `edu_relas_func_role` VALUES (587,20,55);
INSERT INTO `edu_relas_func_role` VALUES (588,20,53);
INSERT INTO `edu_relas_func_role` VALUES (589,20,50);
INSERT INTO `edu_relas_func_role` VALUES (590,20,52);
INSERT INTO `edu_relas_func_role` VALUES (591,20,60);
INSERT INTO `edu_relas_func_role` VALUES (592,20,59);
INSERT INTO `edu_relas_func_role` VALUES (593,20,58);
INSERT INTO `edu_relas_func_role` VALUES (594,20,5);
INSERT INTO `edu_relas_func_role` VALUES (595,20,6);
INSERT INTO `edu_relas_func_role` VALUES (596,20,69);
INSERT INTO `edu_relas_func_role` VALUES (597,20,36);
INSERT INTO `edu_relas_func_role` VALUES (598,20,43);
INSERT INTO `edu_relas_func_role` VALUES (599,20,63);
INSERT INTO `edu_relas_func_role` VALUES (600,20,64);
INSERT INTO `edu_relas_func_role` VALUES (601,20,65);
INSERT INTO `edu_relas_func_role` VALUES (602,20,67);
INSERT INTO `edu_relas_func_role` VALUES (603,20,68);
INSERT INTO `edu_relas_func_role` VALUES (836,10,10);
INSERT INTO `edu_relas_func_role` VALUES (837,10,2);
INSERT INTO `edu_relas_func_role` VALUES (838,10,8);
INSERT INTO `edu_relas_func_role` VALUES (839,10,70);
INSERT INTO `edu_relas_func_role` VALUES (840,10,71);
INSERT INTO `edu_relas_func_role` VALUES (841,10,72);
INSERT INTO `edu_relas_func_role` VALUES (842,10,73);
INSERT INTO `edu_relas_func_role` VALUES (843,10,74);
INSERT INTO `edu_relas_func_role` VALUES (844,10,75);
INSERT INTO `edu_relas_func_role` VALUES (845,10,76);
INSERT INTO `edu_relas_func_role` VALUES (846,10,77);
INSERT INTO `edu_relas_func_role` VALUES (847,10,78);
INSERT INTO `edu_relas_func_role` VALUES (848,10,79);
INSERT INTO `edu_relas_func_role` VALUES (849,10,80);
INSERT INTO `edu_relas_func_role` VALUES (850,10,81);
INSERT INTO `edu_relas_func_role` VALUES (851,10,85);
INSERT INTO `edu_relas_func_role` VALUES (852,10,86);
INSERT INTO `edu_relas_func_role` VALUES (853,10,87);
INSERT INTO `edu_relas_func_role` VALUES (854,10,88);
INSERT INTO `edu_relas_func_role` VALUES (855,10,4);
INSERT INTO `edu_relas_func_role` VALUES (856,10,6);
INSERT INTO `edu_relas_func_role` VALUES (1644,6,10);
INSERT INTO `edu_relas_func_role` VALUES (1645,6,111);
INSERT INTO `edu_relas_func_role` VALUES (1646,6,1);
INSERT INTO `edu_relas_func_role` VALUES (1647,6,2);
INSERT INTO `edu_relas_func_role` VALUES (1648,6,45);
INSERT INTO `edu_relas_func_role` VALUES (1649,6,46);
INSERT INTO `edu_relas_func_role` VALUES (1650,6,66);
INSERT INTO `edu_relas_func_role` VALUES (1651,6,7);
INSERT INTO `edu_relas_func_role` VALUES (1652,6,8);
INSERT INTO `edu_relas_func_role` VALUES (1653,6,80);
INSERT INTO `edu_relas_func_role` VALUES (1654,6,16);
INSERT INTO `edu_relas_func_role` VALUES (1655,6,17);
INSERT INTO `edu_relas_func_role` VALUES (1656,6,18);
INSERT INTO `edu_relas_func_role` VALUES (1657,6,19);
INSERT INTO `edu_relas_func_role` VALUES (1658,6,20);
INSERT INTO `edu_relas_func_role` VALUES (1659,6,21);
INSERT INTO `edu_relas_func_role` VALUES (1660,6,82);
INSERT INTO `edu_relas_func_role` VALUES (1661,6,83);
INSERT INTO `edu_relas_func_role` VALUES (1662,6,4);
INSERT INTO `edu_relas_func_role` VALUES (1663,6,6);
INSERT INTO `edu_relas_func_role` VALUES (2204,5,9);
INSERT INTO `edu_relas_func_role` VALUES (2205,5,10);
INSERT INTO `edu_relas_func_role` VALUES (2206,5,40);
INSERT INTO `edu_relas_func_role` VALUES (2207,5,42);
INSERT INTO `edu_relas_func_role` VALUES (2208,5,109);
INSERT INTO `edu_relas_func_role` VALUES (2209,5,111);
INSERT INTO `edu_relas_func_role` VALUES (2210,5,1);
INSERT INTO `edu_relas_func_role` VALUES (2211,5,2);
INSERT INTO `edu_relas_func_role` VALUES (2212,5,45);
INSERT INTO `edu_relas_func_role` VALUES (2213,5,46);
INSERT INTO `edu_relas_func_role` VALUES (2214,5,66);
INSERT INTO `edu_relas_func_role` VALUES (2215,5,7);
INSERT INTO `edu_relas_func_role` VALUES (2216,5,8);
INSERT INTO `edu_relas_func_role` VALUES (2217,5,26);
INSERT INTO `edu_relas_func_role` VALUES (2218,5,27);
INSERT INTO `edu_relas_func_role` VALUES (2219,5,28);
INSERT INTO `edu_relas_func_role` VALUES (2220,5,94);
INSERT INTO `edu_relas_func_role` VALUES (2221,5,110);
INSERT INTO `edu_relas_func_role` VALUES (2222,5,4);
INSERT INTO `edu_relas_func_role` VALUES (2223,5,5);
INSERT INTO `edu_relas_func_role` VALUES (2224,5,6);
INSERT INTO `edu_relas_func_role` VALUES (2225,5,25);
INSERT INTO `edu_relas_func_role` VALUES (2226,5,43);
INSERT INTO `edu_relas_func_role` VALUES (2227,5,93);
INSERT INTO `edu_relas_func_role` VALUES (2546,0,10);
INSERT INTO `edu_relas_func_role` VALUES (2547,0,111);
INSERT INTO `edu_relas_func_role` VALUES (2548,0,1);
INSERT INTO `edu_relas_func_role` VALUES (2549,0,2);
INSERT INTO `edu_relas_func_role` VALUES (2550,0,45);
INSERT INTO `edu_relas_func_role` VALUES (2551,0,46);
INSERT INTO `edu_relas_func_role` VALUES (2552,0,66);
INSERT INTO `edu_relas_func_role` VALUES (2553,0,8);
INSERT INTO `edu_relas_func_role` VALUES (2554,0,3);
INSERT INTO `edu_relas_func_role` VALUES (2555,0,4);
INSERT INTO `edu_relas_func_role` VALUES (2556,0,11);
INSERT INTO `edu_relas_func_role` VALUES (2557,0,44);
INSERT INTO `edu_relas_func_role` VALUES (2558,0,47);
INSERT INTO `edu_relas_func_role` VALUES (2559,0,55);
INSERT INTO `edu_relas_func_role` VALUES (2560,0,53);
INSERT INTO `edu_relas_func_role` VALUES (2561,0,54);
INSERT INTO `edu_relas_func_role` VALUES (2562,0,48);
INSERT INTO `edu_relas_func_role` VALUES (2563,0,49);
INSERT INTO `edu_relas_func_role` VALUES (2564,0,51);
INSERT INTO `edu_relas_func_role` VALUES (2565,0,52);
INSERT INTO `edu_relas_func_role` VALUES (2566,0,56);
INSERT INTO `edu_relas_func_role` VALUES (2567,0,60);
INSERT INTO `edu_relas_func_role` VALUES (2568,0,59);
INSERT INTO `edu_relas_func_role` VALUES (2569,0,61);
INSERT INTO `edu_relas_func_role` VALUES (2570,0,57);
INSERT INTO `edu_relas_func_role` VALUES (2571,0,58);
INSERT INTO `edu_relas_func_role` VALUES (2572,0,84);
INSERT INTO `edu_relas_func_role` VALUES (2573,0,6);
INSERT INTO `edu_relas_func_role` VALUES (2635,2,9);
INSERT INTO `edu_relas_func_role` VALUES (2636,2,10);
INSERT INTO `edu_relas_func_role` VALUES (2637,2,30);
INSERT INTO `edu_relas_func_role` VALUES (2638,2,31);
INSERT INTO `edu_relas_func_role` VALUES (2639,2,32);
INSERT INTO `edu_relas_func_role` VALUES (2640,2,33);
INSERT INTO `edu_relas_func_role` VALUES (2641,2,34);
INSERT INTO `edu_relas_func_role` VALUES (2642,2,40);
INSERT INTO `edu_relas_func_role` VALUES (2643,2,105);
INSERT INTO `edu_relas_func_role` VALUES (2644,2,106);
INSERT INTO `edu_relas_func_role` VALUES (2645,2,107);
INSERT INTO `edu_relas_func_role` VALUES (2646,2,108);
INSERT INTO `edu_relas_func_role` VALUES (2647,2,111);
INSERT INTO `edu_relas_func_role` VALUES (2648,2,1);
INSERT INTO `edu_relas_func_role` VALUES (2649,2,2);
INSERT INTO `edu_relas_func_role` VALUES (2650,2,45);
INSERT INTO `edu_relas_func_role` VALUES (2651,2,46);
INSERT INTO `edu_relas_func_role` VALUES (2652,2,7);
INSERT INTO `edu_relas_func_role` VALUES (2653,2,8);
INSERT INTO `edu_relas_func_role` VALUES (2654,2,70);
INSERT INTO `edu_relas_func_role` VALUES (2655,2,71);
INSERT INTO `edu_relas_func_role` VALUES (2656,2,72);
INSERT INTO `edu_relas_func_role` VALUES (2657,2,73);
INSERT INTO `edu_relas_func_role` VALUES (2658,2,74);
INSERT INTO `edu_relas_func_role` VALUES (2659,2,75);
INSERT INTO `edu_relas_func_role` VALUES (2660,2,76);
INSERT INTO `edu_relas_func_role` VALUES (2661,2,77);
INSERT INTO `edu_relas_func_role` VALUES (2662,2,78);
INSERT INTO `edu_relas_func_role` VALUES (2663,2,79);
INSERT INTO `edu_relas_func_role` VALUES (2664,2,80);
INSERT INTO `edu_relas_func_role` VALUES (2665,2,81);
INSERT INTO `edu_relas_func_role` VALUES (2666,2,85);
INSERT INTO `edu_relas_func_role` VALUES (2667,2,86);
INSERT INTO `edu_relas_func_role` VALUES (2668,2,87);
INSERT INTO `edu_relas_func_role` VALUES (2669,2,88);
INSERT INTO `edu_relas_func_role` VALUES (2670,2,3);
INSERT INTO `edu_relas_func_role` VALUES (2671,2,4);
INSERT INTO `edu_relas_func_role` VALUES (2672,2,11);
INSERT INTO `edu_relas_func_role` VALUES (2673,2,47);
INSERT INTO `edu_relas_func_role` VALUES (2674,2,55);
INSERT INTO `edu_relas_func_role` VALUES (2675,2,53);
INSERT INTO `edu_relas_func_role` VALUES (2676,2,54);
INSERT INTO `edu_relas_func_role` VALUES (2677,2,48);
INSERT INTO `edu_relas_func_role` VALUES (2678,2,49);
INSERT INTO `edu_relas_func_role` VALUES (2679,2,50);
INSERT INTO `edu_relas_func_role` VALUES (2680,2,51);
INSERT INTO `edu_relas_func_role` VALUES (2681,2,52);
INSERT INTO `edu_relas_func_role` VALUES (2682,2,56);
INSERT INTO `edu_relas_func_role` VALUES (2683,2,60);
INSERT INTO `edu_relas_func_role` VALUES (2684,2,59);
INSERT INTO `edu_relas_func_role` VALUES (2685,2,61);
INSERT INTO `edu_relas_func_role` VALUES (2686,2,57);
INSERT INTO `edu_relas_func_role` VALUES (2687,2,58);
INSERT INTO `edu_relas_func_role` VALUES (2688,2,84);
INSERT INTO `edu_relas_func_role` VALUES (2689,2,92);
INSERT INTO `edu_relas_func_role` VALUES (2690,2,5);
INSERT INTO `edu_relas_func_role` VALUES (2691,2,6);
INSERT INTO `edu_relas_func_role` VALUES (2692,2,69);
INSERT INTO `edu_relas_func_role` VALUES (2693,2,36);
INSERT INTO `edu_relas_func_role` VALUES (2694,2,39);
INSERT INTO `edu_relas_func_role` VALUES (2695,2,62);
INSERT INTO `edu_relas_func_role` VALUES (2696,2,63);
INSERT INTO `edu_relas_func_role` VALUES (2697,2,64);
INSERT INTO `edu_relas_func_role` VALUES (2698,2,65);
INSERT INTO `edu_relas_func_role` VALUES (2699,2,67);
INSERT INTO `edu_relas_func_role` VALUES (2700,2,68);
INSERT INTO `edu_relas_func_role` VALUES (2701,2,89);
INSERT INTO `edu_relas_func_role` VALUES (2702,2,90);
INSERT INTO `edu_relas_func_role` VALUES (2703,2,91);
INSERT INTO `edu_relas_func_role` VALUES (2704,2,95);
INSERT INTO `edu_relas_func_role` VALUES (2705,2,96);
INSERT INTO `edu_relas_func_role` VALUES (2706,2,97);
INSERT INTO `edu_relas_func_role` VALUES (2707,2,98);
INSERT INTO `edu_relas_func_role` VALUES (2708,2,99);
INSERT INTO `edu_relas_func_role` VALUES (2709,2,100);
INSERT INTO `edu_relas_func_role` VALUES (2710,2,101);
INSERT INTO `edu_relas_func_role` VALUES (2711,2,102);
INSERT INTO `edu_relas_func_role` VALUES (2712,2,103);
INSERT INTO `edu_relas_func_role` VALUES (2713,2,115);
INSERT INTO `edu_relas_func_role` VALUES (2714,3,9);
INSERT INTO `edu_relas_func_role` VALUES (2715,3,10);
INSERT INTO `edu_relas_func_role` VALUES (2716,3,30);
INSERT INTO `edu_relas_func_role` VALUES (2717,3,31);
INSERT INTO `edu_relas_func_role` VALUES (2718,3,32);
INSERT INTO `edu_relas_func_role` VALUES (2719,3,33);
INSERT INTO `edu_relas_func_role` VALUES (2720,3,34);
INSERT INTO `edu_relas_func_role` VALUES (2721,3,105);
INSERT INTO `edu_relas_func_role` VALUES (2722,3,106);
INSERT INTO `edu_relas_func_role` VALUES (2723,3,107);
INSERT INTO `edu_relas_func_role` VALUES (2724,3,108);
INSERT INTO `edu_relas_func_role` VALUES (2725,3,111);
INSERT INTO `edu_relas_func_role` VALUES (2726,3,112);
INSERT INTO `edu_relas_func_role` VALUES (2727,3,113);
INSERT INTO `edu_relas_func_role` VALUES (2728,3,114);
INSERT INTO `edu_relas_func_role` VALUES (2729,3,1);
INSERT INTO `edu_relas_func_role` VALUES (2730,3,2);
INSERT INTO `edu_relas_func_role` VALUES (2731,3,45);
INSERT INTO `edu_relas_func_role` VALUES (2732,3,46);
INSERT INTO `edu_relas_func_role` VALUES (2733,3,7);
INSERT INTO `edu_relas_func_role` VALUES (2734,3,8);
INSERT INTO `edu_relas_func_role` VALUES (2735,3,70);
INSERT INTO `edu_relas_func_role` VALUES (2736,3,71);
INSERT INTO `edu_relas_func_role` VALUES (2737,3,72);
INSERT INTO `edu_relas_func_role` VALUES (2738,3,73);
INSERT INTO `edu_relas_func_role` VALUES (2739,3,74);
INSERT INTO `edu_relas_func_role` VALUES (2740,3,75);
INSERT INTO `edu_relas_func_role` VALUES (2741,3,76);
INSERT INTO `edu_relas_func_role` VALUES (2742,3,77);
INSERT INTO `edu_relas_func_role` VALUES (2743,3,78);
INSERT INTO `edu_relas_func_role` VALUES (2744,3,79);
INSERT INTO `edu_relas_func_role` VALUES (2745,3,80);
INSERT INTO `edu_relas_func_role` VALUES (2746,3,81);
INSERT INTO `edu_relas_func_role` VALUES (2747,3,86);
INSERT INTO `edu_relas_func_role` VALUES (2748,3,87);
INSERT INTO `edu_relas_func_role` VALUES (2749,3,88);
INSERT INTO `edu_relas_func_role` VALUES (2750,3,3);
INSERT INTO `edu_relas_func_role` VALUES (2751,3,4);
INSERT INTO `edu_relas_func_role` VALUES (2752,3,5);
INSERT INTO `edu_relas_func_role` VALUES (2753,3,6);
INSERT INTO `edu_relas_func_role` VALUES (2754,3,69);
INSERT INTO `edu_relas_func_role` VALUES (2755,3,36);
INSERT INTO `edu_relas_func_role` VALUES (2756,3,39);
INSERT INTO `edu_relas_func_role` VALUES (2757,3,62);
INSERT INTO `edu_relas_func_role` VALUES (2758,3,63);
INSERT INTO `edu_relas_func_role` VALUES (2759,3,64);
INSERT INTO `edu_relas_func_role` VALUES (2760,3,65);
INSERT INTO `edu_relas_func_role` VALUES (2761,3,67);
INSERT INTO `edu_relas_func_role` VALUES (2762,3,68);
INSERT INTO `edu_relas_func_role` VALUES (2763,3,89);
INSERT INTO `edu_relas_func_role` VALUES (2764,3,90);
INSERT INTO `edu_relas_func_role` VALUES (2765,3,91);
INSERT INTO `edu_relas_func_role` VALUES (2766,3,95);
INSERT INTO `edu_relas_func_role` VALUES (2767,3,96);
INSERT INTO `edu_relas_func_role` VALUES (2768,3,97);
INSERT INTO `edu_relas_func_role` VALUES (2769,3,98);
INSERT INTO `edu_relas_func_role` VALUES (2770,3,99);
INSERT INTO `edu_relas_func_role` VALUES (2771,3,100);
INSERT INTO `edu_relas_func_role` VALUES (2772,3,101);
INSERT INTO `edu_relas_func_role` VALUES (2773,3,102);
INSERT INTO `edu_relas_func_role` VALUES (2774,3,103);
INSERT INTO `edu_relas_func_role` VALUES (2775,3,115);
INSERT INTO `edu_relas_func_role` VALUES (2776,4,9);
INSERT INTO `edu_relas_func_role` VALUES (2777,4,10);
INSERT INTO `edu_relas_func_role` VALUES (2778,4,30);
INSERT INTO `edu_relas_func_role` VALUES (2779,4,31);
INSERT INTO `edu_relas_func_role` VALUES (2780,4,33);
INSERT INTO `edu_relas_func_role` VALUES (2781,4,34);
INSERT INTO `edu_relas_func_role` VALUES (2782,4,104);
INSERT INTO `edu_relas_func_role` VALUES (2783,4,105);
INSERT INTO `edu_relas_func_role` VALUES (2784,4,106);
INSERT INTO `edu_relas_func_role` VALUES (2785,4,107);
INSERT INTO `edu_relas_func_role` VALUES (2786,4,108);
INSERT INTO `edu_relas_func_role` VALUES (2787,4,111);
INSERT INTO `edu_relas_func_role` VALUES (2788,4,114);
INSERT INTO `edu_relas_func_role` VALUES (2789,4,1);
INSERT INTO `edu_relas_func_role` VALUES (2790,4,2);
INSERT INTO `edu_relas_func_role` VALUES (2791,4,45);
INSERT INTO `edu_relas_func_role` VALUES (2792,4,46);
INSERT INTO `edu_relas_func_role` VALUES (2793,4,7);
INSERT INTO `edu_relas_func_role` VALUES (2794,4,8);
INSERT INTO `edu_relas_func_role` VALUES (2795,4,70);
INSERT INTO `edu_relas_func_role` VALUES (2796,4,71);
INSERT INTO `edu_relas_func_role` VALUES (2797,4,72);
INSERT INTO `edu_relas_func_role` VALUES (2798,4,73);
INSERT INTO `edu_relas_func_role` VALUES (2799,4,74);
INSERT INTO `edu_relas_func_role` VALUES (2800,4,75);
INSERT INTO `edu_relas_func_role` VALUES (2801,4,76);
INSERT INTO `edu_relas_func_role` VALUES (2802,4,77);
INSERT INTO `edu_relas_func_role` VALUES (2803,4,78);
INSERT INTO `edu_relas_func_role` VALUES (2804,4,79);
INSERT INTO `edu_relas_func_role` VALUES (2805,4,80);
INSERT INTO `edu_relas_func_role` VALUES (2806,4,81);
INSERT INTO `edu_relas_func_role` VALUES (2807,4,85);
INSERT INTO `edu_relas_func_role` VALUES (2808,4,86);
INSERT INTO `edu_relas_func_role` VALUES (2809,4,87);
INSERT INTO `edu_relas_func_role` VALUES (2810,4,88);
INSERT INTO `edu_relas_func_role` VALUES (2811,4,3);
INSERT INTO `edu_relas_func_role` VALUES (2812,4,4);
INSERT INTO `edu_relas_func_role` VALUES (2813,4,5);
INSERT INTO `edu_relas_func_role` VALUES (2814,4,6);
INSERT INTO `edu_relas_func_role` VALUES (2815,4,69);
INSERT INTO `edu_relas_func_role` VALUES (2816,4,36);
INSERT INTO `edu_relas_func_role` VALUES (2817,4,39);
INSERT INTO `edu_relas_func_role` VALUES (2818,4,62);
INSERT INTO `edu_relas_func_role` VALUES (2819,4,63);
INSERT INTO `edu_relas_func_role` VALUES (2820,4,64);
INSERT INTO `edu_relas_func_role` VALUES (2821,4,65);
INSERT INTO `edu_relas_func_role` VALUES (2822,4,67);
INSERT INTO `edu_relas_func_role` VALUES (2823,4,68);
INSERT INTO `edu_relas_func_role` VALUES (2824,4,89);
INSERT INTO `edu_relas_func_role` VALUES (2825,4,90);
INSERT INTO `edu_relas_func_role` VALUES (2826,4,91);
INSERT INTO `edu_relas_func_role` VALUES (2827,4,95);
INSERT INTO `edu_relas_func_role` VALUES (2828,4,96);
INSERT INTO `edu_relas_func_role` VALUES (2829,4,97);
INSERT INTO `edu_relas_func_role` VALUES (2830,4,98);
INSERT INTO `edu_relas_func_role` VALUES (2831,4,99);
INSERT INTO `edu_relas_func_role` VALUES (2832,4,100);
INSERT INTO `edu_relas_func_role` VALUES (2833,4,101);
INSERT INTO `edu_relas_func_role` VALUES (2834,4,102);
INSERT INTO `edu_relas_func_role` VALUES (2835,4,103);
INSERT INTO `edu_relas_func_role` VALUES (2836,4,115);
INSERT INTO `edu_relas_func_role` VALUES (2837,7,9);
INSERT INTO `edu_relas_func_role` VALUES (2838,7,10);
INSERT INTO `edu_relas_func_role` VALUES (2839,7,32);
INSERT INTO `edu_relas_func_role` VALUES (2840,7,33);
INSERT INTO `edu_relas_func_role` VALUES (2841,7,34);
INSERT INTO `edu_relas_func_role` VALUES (2842,7,40);
INSERT INTO `edu_relas_func_role` VALUES (2843,7,105);
INSERT INTO `edu_relas_func_role` VALUES (2844,7,106);
INSERT INTO `edu_relas_func_role` VALUES (2845,7,107);
INSERT INTO `edu_relas_func_role` VALUES (2846,7,108);
INSERT INTO `edu_relas_func_role` VALUES (2847,7,111);
INSERT INTO `edu_relas_func_role` VALUES (2848,7,112);
INSERT INTO `edu_relas_func_role` VALUES (2849,7,113);
INSERT INTO `edu_relas_func_role` VALUES (2850,7,114);
INSERT INTO `edu_relas_func_role` VALUES (2851,7,1);
INSERT INTO `edu_relas_func_role` VALUES (2852,7,2);
INSERT INTO `edu_relas_func_role` VALUES (2853,7,45);
INSERT INTO `edu_relas_func_role` VALUES (2854,7,46);
INSERT INTO `edu_relas_func_role` VALUES (2855,7,66);
INSERT INTO `edu_relas_func_role` VALUES (2856,7,7);
INSERT INTO `edu_relas_func_role` VALUES (2857,7,8);
INSERT INTO `edu_relas_func_role` VALUES (2858,7,70);
INSERT INTO `edu_relas_func_role` VALUES (2859,7,71);
INSERT INTO `edu_relas_func_role` VALUES (2860,7,72);
INSERT INTO `edu_relas_func_role` VALUES (2861,7,73);
INSERT INTO `edu_relas_func_role` VALUES (2862,7,74);
INSERT INTO `edu_relas_func_role` VALUES (2863,7,75);
INSERT INTO `edu_relas_func_role` VALUES (2864,7,76);
INSERT INTO `edu_relas_func_role` VALUES (2865,7,77);
INSERT INTO `edu_relas_func_role` VALUES (2866,7,78);
INSERT INTO `edu_relas_func_role` VALUES (2867,7,79);
INSERT INTO `edu_relas_func_role` VALUES (2868,7,80);
INSERT INTO `edu_relas_func_role` VALUES (2869,7,81);
INSERT INTO `edu_relas_func_role` VALUES (2870,7,85);
INSERT INTO `edu_relas_func_role` VALUES (2871,7,86);
INSERT INTO `edu_relas_func_role` VALUES (2872,7,87);
INSERT INTO `edu_relas_func_role` VALUES (2873,7,88);
INSERT INTO `edu_relas_func_role` VALUES (2874,7,4);
INSERT INTO `edu_relas_func_role` VALUES (2875,7,6);
INSERT INTO `edu_relas_func_role` VALUES (2956,1,9);
INSERT INTO `edu_relas_func_role` VALUES (2957,1,10);
INSERT INTO `edu_relas_func_role` VALUES (2958,1,30);
INSERT INTO `edu_relas_func_role` VALUES (2959,1,32);
INSERT INTO `edu_relas_func_role` VALUES (2960,1,33);
INSERT INTO `edu_relas_func_role` VALUES (2961,1,34);
INSERT INTO `edu_relas_func_role` VALUES (2962,1,105);
INSERT INTO `edu_relas_func_role` VALUES (2963,1,106);
INSERT INTO `edu_relas_func_role` VALUES (2964,1,107);
INSERT INTO `edu_relas_func_role` VALUES (2965,1,108);
INSERT INTO `edu_relas_func_role` VALUES (2966,1,111);
INSERT INTO `edu_relas_func_role` VALUES (2967,1,112);
INSERT INTO `edu_relas_func_role` VALUES (2968,1,113);
INSERT INTO `edu_relas_func_role` VALUES (2969,1,114);
INSERT INTO `edu_relas_func_role` VALUES (2970,1,1);
INSERT INTO `edu_relas_func_role` VALUES (2971,1,2);
INSERT INTO `edu_relas_func_role` VALUES (2972,1,45);
INSERT INTO `edu_relas_func_role` VALUES (2973,1,46);
INSERT INTO `edu_relas_func_role` VALUES (2974,1,66);
INSERT INTO `edu_relas_func_role` VALUES (2975,1,7);
INSERT INTO `edu_relas_func_role` VALUES (2976,1,8);
INSERT INTO `edu_relas_func_role` VALUES (2977,1,70);
INSERT INTO `edu_relas_func_role` VALUES (2978,1,71);
INSERT INTO `edu_relas_func_role` VALUES (2979,1,72);
INSERT INTO `edu_relas_func_role` VALUES (2980,1,73);
INSERT INTO `edu_relas_func_role` VALUES (2981,1,74);
INSERT INTO `edu_relas_func_role` VALUES (2982,1,75);
INSERT INTO `edu_relas_func_role` VALUES (2983,1,76);
INSERT INTO `edu_relas_func_role` VALUES (2984,1,77);
INSERT INTO `edu_relas_func_role` VALUES (2985,1,78);
INSERT INTO `edu_relas_func_role` VALUES (2986,1,79);
INSERT INTO `edu_relas_func_role` VALUES (2987,1,80);
INSERT INTO `edu_relas_func_role` VALUES (2988,1,81);
INSERT INTO `edu_relas_func_role` VALUES (2989,1,85);
INSERT INTO `edu_relas_func_role` VALUES (2990,1,86);
INSERT INTO `edu_relas_func_role` VALUES (2991,1,87);
INSERT INTO `edu_relas_func_role` VALUES (2992,1,88);
INSERT INTO `edu_relas_func_role` VALUES (2993,1,3);
INSERT INTO `edu_relas_func_role` VALUES (2994,1,4);
INSERT INTO `edu_relas_func_role` VALUES (2995,1,11);
INSERT INTO `edu_relas_func_role` VALUES (2996,1,47);
INSERT INTO `edu_relas_func_role` VALUES (2997,1,55);
INSERT INTO `edu_relas_func_role` VALUES (2998,1,53);
INSERT INTO `edu_relas_func_role` VALUES (2999,1,54);
INSERT INTO `edu_relas_func_role` VALUES (3000,1,49);
INSERT INTO `edu_relas_func_role` VALUES (3001,1,50);
INSERT INTO `edu_relas_func_role` VALUES (3002,1,51);
INSERT INTO `edu_relas_func_role` VALUES (3003,1,52);
INSERT INTO `edu_relas_func_role` VALUES (3004,1,56);
INSERT INTO `edu_relas_func_role` VALUES (3005,1,60);
INSERT INTO `edu_relas_func_role` VALUES (3006,1,59);
INSERT INTO `edu_relas_func_role` VALUES (3007,1,57);
INSERT INTO `edu_relas_func_role` VALUES (3008,1,58);
INSERT INTO `edu_relas_func_role` VALUES (3009,1,84);
INSERT INTO `edu_relas_func_role` VALUES (3010,1,92);
INSERT INTO `edu_relas_func_role` VALUES (3011,1,5);
INSERT INTO `edu_relas_func_role` VALUES (3012,1,6);
INSERT INTO `edu_relas_func_role` VALUES (3013,1,69);
INSERT INTO `edu_relas_func_role` VALUES (3014,1,36);
INSERT INTO `edu_relas_func_role` VALUES (3015,1,39);
INSERT INTO `edu_relas_func_role` VALUES (3016,1,62);
INSERT INTO `edu_relas_func_role` VALUES (3017,1,63);
INSERT INTO `edu_relas_func_role` VALUES (3018,1,64);
INSERT INTO `edu_relas_func_role` VALUES (3019,1,65);
INSERT INTO `edu_relas_func_role` VALUES (3020,1,67);
INSERT INTO `edu_relas_func_role` VALUES (3021,1,68);
INSERT INTO `edu_relas_func_role` VALUES (3022,1,89);
INSERT INTO `edu_relas_func_role` VALUES (3023,1,90);
INSERT INTO `edu_relas_func_role` VALUES (3024,1,91);
INSERT INTO `edu_relas_func_role` VALUES (3025,1,95);
INSERT INTO `edu_relas_func_role` VALUES (3026,1,96);
INSERT INTO `edu_relas_func_role` VALUES (3027,1,97);
INSERT INTO `edu_relas_func_role` VALUES (3028,1,98);
INSERT INTO `edu_relas_func_role` VALUES (3029,1,99);
INSERT INTO `edu_relas_func_role` VALUES (3030,1,100);
INSERT INTO `edu_relas_func_role` VALUES (3031,1,101);
INSERT INTO `edu_relas_func_role` VALUES (3032,1,102);
INSERT INTO `edu_relas_func_role` VALUES (3033,1,103);
INSERT INTO `edu_relas_func_role` VALUES (3034,1,115);
/*!40000 ALTER TABLE `edu_relas_func_role` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table edu_response
#

CREATE TABLE `edu_response` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `username` varchar(30) DEFAULT NULL COMMENT '创建者',
  `ipaddress` varchar(255) DEFAULT NULL COMMENT 'ip地址',
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `project_id` int(11) DEFAULT NULL COMMENT '项目id',
  `paper_id` int(11) DEFAULT NULL COMMENT '问卷id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
INSERT INTO `edu_response` VALUES (3,'2014-05-15','jiaoshinew','218.247.190.130','李赞',96,10);
INSERT INTO `edu_response` VALUES (4,'2014-05-15','testone1','218.247.190.130','杨明',96,10);
INSERT INTO `edu_response` VALUES (5,'2014-05-15','testone12','218.247.190.130','李恒',96,10);
/*!40000 ALTER TABLE `edu_response` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table edu_response_question
#

CREATE TABLE `edu_response_question` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `create_date` datetime DEFAULT NULL COMMENT '创建日期',
  `username` varchar(30) DEFAULT NULL COMMENT '创建者',
  `answer` varchar(2000) DEFAULT NULL COMMENT '回答;question_options_id; 多选用|分割',
  `response_id` int(11) DEFAULT NULL COMMENT '答卷id',
  `question_id` int(11) DEFAULT NULL COMMENT '问题id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
INSERT INTO `edu_response_question` VALUES (7,'2014-05-15','jiaoshinew','23',3,11);
INSERT INTO `edu_response_question` VALUES (8,'2014-05-15','jiaoshinew','25|26|27|',3,12);
INSERT INTO `edu_response_question` VALUES (9,'2014-05-15','jiaoshinew','rr',3,13);
INSERT INTO `edu_response_question` VALUES (10,'2014-05-15','jiaoshinew','ttt',3,14);
INSERT INTO `edu_response_question` VALUES (11,'2014-05-15','testone1','23',4,11);
INSERT INTO `edu_response_question` VALUES (12,'2014-05-15','testone1','25|',4,12);
INSERT INTO `edu_response_question` VALUES (13,'2014-05-15','testone1','阿打发第三方',4,13);
INSERT INTO `edu_response_question` VALUES (14,'2014-05-15','testone1','阿打发地方',4,14);
INSERT INTO `edu_response_question` VALUES (15,'2014-05-15','testone12','24',5,11);
INSERT INTO `edu_response_question` VALUES (16,'2014-05-15','testone12','25|26|27|',5,12);
INSERT INTO `edu_response_question` VALUES (17,'2014-05-15','testone12','11',5,13);
INSERT INTO `edu_response_question` VALUES (18,'2014-05-15','testone12','11',5,14);
/*!40000 ALTER TABLE `edu_response_question` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table edu_school
#

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
  PRIMARY KEY (`school_id`)
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
INSERT INTO `edu_school` VALUES (67,'江汉第一小学',1,'\n\t\t\t\t\t\t\t\t\t\t小学\n\t\t\t\t\t\t\t\t\t',89,'湖北省',90,'武汉市',92,'江汉区',' sdf',' sfd','asdf','','hbadmin','2014-05-13','xitongadmin','2014-05-13',0,1,'\n\t\t\t\t\t\t\t\t\t\t公办\n\t\t\t\t\t\t');
INSERT INTO `edu_school` VALUES (68,'江汉第一初中',2,'\n\t\t\t\t\t\t\t\t\t\t初中\n\t\t\t\t\t\t\t\t\t',89,'湖北省',90,'武汉市',92,'江汉区',' sdf',' sf','sdf','','hbadmin','2014-05-13','xitongadmin','2014-05-13',0,1,'\n\t\t\t\t\t\t\t\t\t\t公办\n\t\t\t\t\t\t');
INSERT INTO `edu_school` VALUES (69,'夷陵区初中',2,'初中',89,'湖北省',91,'宜昌市',99,'夷陵区','李俊','222','湖北省','22','xitongadmin','2014-05-13','xitongadmin','2014-05-13',1,0,'民办');
INSERT INTO `edu_school` VALUES (70,'西陵区初中',2,'初中',89,'湖北省',91,'宜昌市',96,'西陵区','李四','111','湖北省','22','xitongadmin','2014-05-13','xitongadmin','2014-05-13',1,1,'公办');
INSERT INTO `edu_school` VALUES (71,'青山区初中',2,'初中',89,'湖北省',90,'武汉市',95,'青山区','李四','1111','湖北省','1','xitongadmin','2014-05-13','xitongadmin','2014-05-13',1,0,'民办');
INSERT INTO `edu_school` VALUES (72,'武昌区实验小学',1,'小学',89,'湖北省',90,'武汉市',94,'武昌区','李四','1233','湖北省','33','xitongadmin','2014-05-13','xitongadmin','2014-05-13',1,1,'公办');
INSERT INTO `edu_school` VALUES (73,'点军区小学',1,'小学',89,'湖北省',91,'宜昌市',98,'点军区','李俊','111','湖北省','22','xitongadmin','2014-05-13','xitongadmin','2014-05-13',1,1,'公办');
INSERT INTO `edu_school` VALUES (74,'伍家岗小学',1,'小学',89,'湖北省',91,'宜昌市',97,'伍家岗区','李俊','22','湖北省','22','xitongadmin','2014-05-13','xitongadmin','2014-05-13',1,0,'民办');
INSERT INTO `edu_school` VALUES (75,'江汉区小学',1,'\n\t\t\t\t\t\t\t\t\t\t小学\n\t\t\t\t\t\t\t\t\t',89,'湖北省',90,'武汉市',92,'江汉区','张三','13211111111','湖北省','11','xitongadmin','2014-05-13','xitongadmin','2014-05-13',1,1,'\n\t\t\t\t\t\t\t\t\t\t公办\n\t\t\t\t\t\t');
INSERT INTO `edu_school` VALUES (76,'汉阳区小学',1,'小学',89,'湖北省',90,'武汉市',93,'汉阳区','张三','1232','湖北省','2','xitongadmin','2014-05-13','xitongadmin','2014-05-13',1,0,'民办');
INSERT INTO `edu_school` VALUES (77,'江汉第一高中 ',3,'\n\t\t\t\t\t\t\t\t\t\t高中\n\t\t\t\t\t\t\t\t\t',89,'湖北省',90,'武汉市',92,'江汉区',' sfd',' sdf','奔','','hbadmin','2014-05-13','hbadmin','2014-05-13',0,1,'\n\t\t\t\t\t\t\t\t\t\t公办\n\t\t\t\t\t\t');
INSERT INTO `edu_school` VALUES (78,'武汉市一小',1,'\n\t\t\t\t\t\t\t\t\t\t小学\n\t\t\t\t\t\t\t\t\t',89,'湖北省',90,'武汉市',92,'江汉区',' 李梅',' 17818','湖北省','111','hbadmin','2014-05-13','hbadmin','2014-05-13',1,0,'\n\t\t\t\t\t\t\t\t\t\t民办\n\t\t\t\t\t\t');
INSERT INTO `edu_school` VALUES (79,'雨湖区初中',2,'初中',100,'湖南省',102,'湘潭市',107,'雨湖区','李四','111','湖北省','22','xitongadmin','2014-05-14','xitongadmin','2014-05-14',1,1,'公办');
INSERT INTO `edu_school` VALUES (80,'湘乡市小学',1,'小学',100,'湖南省',102,'湘潭市',109,'湘乡市','李俊','111','湖北省','22','xitongadmin','2014-05-14','xitongadmin','2014-05-14',1,1,'公办');
INSERT INTO `edu_school` VALUES (81,'望城区实验小学',1,'小学',100,'湖南省',101,'长沙市',105,'望城区','李四','1233','湖北省','33','xitongadmin','2014-05-14','xitongadmin','2014-05-14',1,1,'公办');
INSERT INTO `edu_school` VALUES (82,'芙蓉区小学',1,'小学',100,'湖南省',101,'长沙市',103,'芙蓉区','张三','1232','湖北省','11','xitongadmin','2014-05-14','xitongadmin','2014-05-14',1,1,'公办');
INSERT INTO `edu_school` VALUES (83,'天心区小学',1,'小学',100,'湖南省',101,'长沙市',104,'天心区','张三','1232','湖北省','2','xitongadmin','2014-05-14','hnadmin','2014-05-15',0,0,'民办');
INSERT INTO `edu_school` VALUES (84,'韶山初中',2,'初中',100,'湖南省',102,'湘潭市',110,'韶山市','李俊','222','湖北省','22','xitongadmin','2014-05-14','xitongadmin','2014-05-14',1,0,'民办');
INSERT INTO `edu_school` VALUES (85,'岳塘区小学',1,'小学',100,'湖南省',102,'湘潭市',108,'岳塘区','李俊','22','湖北省','22','xitongadmin','2014-05-14','xitongadmin','2014-05-14',1,0,'民办');
INSERT INTO `edu_school` VALUES (86,'雨花区初中',2,'\n\t\t\t\t\t\t\t\t\t\t初中\n\t\t\t\t\t\t\t\t\t',100,'湖南省',101,'长沙市',106,'雨花区','李四','1111','湖南省长沙市','1','xitongadmin','2014-05-14','hnadmin','2014-05-15',1,0,'\n\t\t\t\t\t\t\t\t\t\t民办\n\t\t\t\t\t\t');
INSERT INTO `edu_school` VALUES (87,'江汉一小',1,'\n\t\t\t\t\t\t\t\t\t\t小学\n\t\t\t\t\t\t\t\t\t',89,'湖北省',90,'武汉市',92,'江汉区',' 校长','12322233322','阿达撒打发斯蒂芬','','xitongadmin','2014-05-15','xitongadmin','2014-05-15',1,0,'\n\t\t\t\t\t\t\t\t\t\t民办\n\t\t\t\t\t\t');
INSERT INTO `edu_school` VALUES (88,'武山县小学',1,'小学',114,'甘肃省',116,'天水市',123,'武山县','李俊','111','甘肃省','22','xitongadmin','2014-05-15','xitongadmin','2014-05-15',1,1,'公办');
INSERT INTO `edu_school` VALUES (89,'红古区初中',2,'初中',114,'甘肃省',115,'兰州市',120,'红古区','李四','1111','甘肃省','1','xitongadmin','2014-05-15','xitongadmin','2014-05-15',1,0,'民办');
INSERT INTO `edu_school` VALUES (90,'麦积区小学',1,'小学',114,'甘肃省',116,'天水市',122,'麦积区','李俊','22','甘肃省','22','xitongadmin','2014-05-15','xitongadmin','2014-05-15',1,0,'民办');
INSERT INTO `edu_school` VALUES (91,'秦州区小学',1,'小学',114,'甘肃省',116,'天水市',121,'秦州区','李四','111','甘肃省','22','xitongadmin','2014-05-15','xitongadmin','2014-05-15',1,1,'公办');
INSERT INTO `edu_school` VALUES (92,'城关区小学',1,'小学',114,'甘肃省',115,'兰州市',117,'城关区','张三','1232','甘肃省','11','xitongadmin','2014-05-15','xitongadmin','2014-05-15',1,1,'公办');
INSERT INTO `edu_school` VALUES (93,'秦安县初中',2,'初中',114,'甘肃省',116,'天水市',124,'秦安县','李俊','222','甘肃省','22','xitongadmin','2014-05-15','xitongadmin','2014-05-15',1,0,'民办');
INSERT INTO `edu_school` VALUES (94,'西固区小学',1,'小学',114,'甘肃省',115,'兰州市',118,'西固区','张三','1232','甘肃省','2','xitongadmin','2014-05-15','xitongadmin','2014-05-15',1,0,'民办');
INSERT INTO `edu_school` VALUES (95,'安宁区实验小学',1,'小学',114,'甘肃省',115,'兰州市',119,'安宁区','李四','1233','甘肃省','33','xitongadmin','2014-05-15','xitongadmin','2014-05-15',1,1,'公办');
INSERT INTO `edu_school` VALUES (96,'城关区二小',1,'\n\t\t\t\t\t\t\t\t\t\t小学\n\t\t\t\t\t\t\t\t\t',114,'甘肃省',115,'兰州市',117,'城关区',' 李克强',' 1111','阿斯顿发萨菲','','xitongadmin','2014-05-15','xitongadmin','2014-05-15',1,0,'\n\t\t\t\t\t\t\t\t\t\t民办\n\t\t\t\t\t\t');
INSERT INTO `edu_school` VALUES (97,'福州一区一小',1,'\n\t\t\t\t\t\t\t\t\t\t小学\n\t\t\t\t\t\t\t\t\t',125,'福建省',126,'福州市',128,'福州一区',' 张三','12345678','无','','xitongadmin','2014-05-16','xitongadmin','2014-05-16',1,1,'\n\t\t\t\t\t\t\t\t\t\t公办\n\t\t\t\t\t\t');
INSERT INTO `edu_school` VALUES (98,'福州二区一小',1,'\n\t\t\t\t\t\t\t\t\t\t小学\n\t\t\t\t\t\t\t\t\t',125,'福建省',126,'福州市',129,'福州二区',' 无','12345678','无','','xitongadmin','2014-05-16','xitongadmin','2014-05-16',1,1,'\n\t\t\t\t\t\t\t\t\t\t公办\n\t\t\t\t\t\t');
/*!40000 ALTER TABLE `edu_school` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table edu_statistic_model
#

CREATE TABLE `edu_statistic_model` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `model_id` int(11) DEFAULT NULL COMMENT '板块id',
  `model_name` varchar(100) DEFAULT NULL COMMENT '板块名称',
  `teacher_id` int(11) DEFAULT NULL COMMENT '教师ID',
  `teacher_name` varchar(100) DEFAULT NULL COMMENT '教师姓名',
  `teacher_score` float DEFAULT NULL COMMENT '总学分,汇总板块下所有项目的学分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37085 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
INSERT INTO `edu_statistic_model` VALUES (34545,7,'test板块',81,'黑龙江省的管理员1',0);
INSERT INTO `edu_statistic_model` VALUES (34546,7,'test板块',82,'哈尔滨市的管理员',0);
INSERT INTO `edu_statistic_model` VALUES (34547,7,'test板块',83,'阿城区的管理员',0);
INSERT INTO `edu_statistic_model` VALUES (34548,7,'test板块',84,'学校管理员',0);
INSERT INTO `edu_statistic_model` VALUES (34549,7,'test板块',85,'教师网管理员',0);
INSERT INTO `edu_statistic_model` VALUES (34550,7,'test板块',86,'果实网管理员',0);
INSERT INTO `edu_statistic_model` VALUES (34551,7,'test板块',87,'系统管理员',0);
INSERT INTO `edu_statistic_model` VALUES (34552,7,'test板块',264,' 湖北管理员',0);
INSERT INTO `edu_statistic_model` VALUES (34553,7,'test板块',265,'武汉admin',0);
INSERT INTO `edu_statistic_model` VALUES (34554,7,'test板块',266,'李念',0);
INSERT INTO `edu_statistic_model` VALUES (34555,7,'test板块',267,'王欢',0);
INSERT INTO `edu_statistic_model` VALUES (34556,7,'test板块',268,'湖北承培一',0);
INSERT INTO `edu_statistic_model` VALUES (34557,7,'test板块',269,'刘琦',0);
INSERT INTO `edu_statistic_model` VALUES (34558,7,'test板块',270,'马骁',0);
INSERT INTO `edu_statistic_model` VALUES (34559,7,'test板块',271,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34560,7,'test板块',272,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34561,7,'test板块',273,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34562,7,'test板块',274,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34563,7,'test板块',275,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34564,7,'test板块',276,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34565,7,'test板块',277,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34566,7,'test板块',278,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34567,7,'test板块',279,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34568,7,'test板块',280,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34569,7,'test板块',281,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34570,7,'test板块',282,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34571,7,'test板块',283,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34572,7,'test板块',284,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34573,7,'test板块',285,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34574,7,'test板块',286,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34575,7,'test板块',287,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34576,7,'test板块',288,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34577,7,'test板块',289,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34578,7,'test板块',290,'夷陵区初中管理员',0);
INSERT INTO `edu_statistic_model` VALUES (34579,7,'test板块',291,'武汉实施一',0);
INSERT INTO `edu_statistic_model` VALUES (34580,7,'test板块',292,'武汉承培一',0);
INSERT INTO `edu_statistic_model` VALUES (34581,7,'test板块',293,'王明',0);
INSERT INTO `edu_statistic_model` VALUES (34582,7,'test板块',294,'王力',0);
INSERT INTO `edu_statistic_model` VALUES (34583,7,'test板块',295,'赖长兴',0);
INSERT INTO `edu_statistic_model` VALUES (34584,7,'test板块',296,'杨钰莹',0);
INSERT INTO `edu_statistic_model` VALUES (34585,7,'test板块',297,'赖伟峰',0);
INSERT INTO `edu_statistic_model` VALUES (34586,7,'test板块',298,'李亚',0);
INSERT INTO `edu_statistic_model` VALUES (34587,7,'test板块',299,'李峰',0);
INSERT INTO `edu_statistic_model` VALUES (34588,7,'test板块',300,'黄欢',0);
INSERT INTO `edu_statistic_model` VALUES (34589,7,'test板块',301,'李梅',0);
INSERT INTO `edu_statistic_model` VALUES (34590,7,'test板块',302,'王雷',0);
INSERT INTO `edu_statistic_model` VALUES (34591,7,'test板块',303,'圆圆',0);
INSERT INTO `edu_statistic_model` VALUES (34592,7,'test板块',304,'木子',0);
INSERT INTO `edu_statistic_model` VALUES (34593,7,'test板块',305,' 李蕊',0);
INSERT INTO `edu_statistic_model` VALUES (34594,7,'test板块',306,'李翠翠',0);
INSERT INTO `edu_statistic_model` VALUES (34595,7,'test板块',307,'宋娟',0);
INSERT INTO `edu_statistic_model` VALUES (34596,7,'test板块',308,'王颖',0);
INSERT INTO `edu_statistic_model` VALUES (34597,7,'test板块',309,'刘伟',0);
INSERT INTO `edu_statistic_model` VALUES (34598,7,'test板块',310,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34599,7,'test板块',311,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34600,7,'test板块',312,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34601,7,'test板块',313,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34602,7,'test板块',314,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34603,7,'test板块',315,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34604,7,'test板块',316,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34605,7,'test板块',317,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34606,7,'test板块',318,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34607,7,'test板块',319,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34608,7,'test板块',320,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34609,7,'test板块',321,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34610,7,'test板块',322,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34611,7,'test板块',323,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34612,7,'test板块',324,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34613,7,'test板块',325,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34614,7,'test板块',326,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34615,7,'test板块',327,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34616,7,'test板块',328,'李明',0);
INSERT INTO `edu_statistic_model` VALUES (34617,7,'test板块',329,'高力',0);
INSERT INTO `edu_statistic_model` VALUES (34618,7,'test板块',330,'李长兴',0);
INSERT INTO `edu_statistic_model` VALUES (34619,7,'test板块',331,'潘钰莹',0);
INSERT INTO `edu_statistic_model` VALUES (34620,7,'test板块',332,'杨伟峰',0);
INSERT INTO `edu_statistic_model` VALUES (34621,7,'test板块',333,'李亚平',0);
INSERT INTO `edu_statistic_model` VALUES (34622,7,'test板块',334,'李韦伯',0);
INSERT INTO `edu_statistic_model` VALUES (34623,7,'test板块',335,'黄雷',0);
INSERT INTO `edu_statistic_model` VALUES (34624,7,'test板块',336,'李培',0);
INSERT INTO `edu_statistic_model` VALUES (34625,7,'test板块',354,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34626,7,'test板块',355,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34627,7,'test板块',356,'刘梅',0);
INSERT INTO `edu_statistic_model` VALUES (34628,7,'test板块',357,'王明',0);
INSERT INTO `edu_statistic_model` VALUES (34629,7,'test板块',358,'王磊',0);
INSERT INTO `edu_statistic_model` VALUES (34630,7,'test板块',359,'李群',0);
INSERT INTO `edu_statistic_model` VALUES (34631,7,'test板块',360,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34632,7,'test板块',361,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34633,7,'test板块',362,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34634,7,'test板块',363,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34635,7,'test板块',364,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34636,7,'test板块',365,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34637,7,'test板块',366,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34638,7,'test板块',367,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34639,7,'test板块',368,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34640,7,'test板块',369,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34641,7,'test板块',370,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34642,7,'test板块',371,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34643,7,'test板块',372,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34644,7,'test板块',373,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34645,7,'test板块',374,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34646,7,'test板块',375,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34647,7,'test板块',376,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34648,7,'test板块',377,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34649,7,'test板块',378,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34650,7,'test板块',379,'李玉',0);
INSERT INTO `edu_statistic_model` VALUES (34651,7,'test板块',380,'杨明',0);
INSERT INTO `edu_statistic_model` VALUES (34652,7,'test板块',381,'刘超',0);
INSERT INTO `edu_statistic_model` VALUES (34653,7,'test板块',382,'王兴',0);
INSERT INTO `edu_statistic_model` VALUES (34654,7,'test板块',383,'庞龙',0);
INSERT INTO `edu_statistic_model` VALUES (34655,7,'test板块',384,'杨离伟',0);
INSERT INTO `edu_statistic_model` VALUES (34656,7,'test板块',385,'小薛',0);
INSERT INTO `edu_statistic_model` VALUES (34657,7,'test板块',386,'刘燕',0);
INSERT INTO `edu_statistic_model` VALUES (34658,7,'test板块',387,'马丁',0);
INSERT INTO `edu_statistic_model` VALUES (34659,7,'test板块',388,'王龙',0);
INSERT INTO `edu_statistic_model` VALUES (34660,7,'test板块',389,'李赞',0);
INSERT INTO `edu_statistic_model` VALUES (34661,7,'test板块',390,'王五',0);
INSERT INTO `edu_statistic_model` VALUES (34662,7,'test板块',391,'李恒',0);
INSERT INTO `edu_statistic_model` VALUES (34663,7,'test板块',392,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34664,7,'test板块',393,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34665,7,'test板块',394,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34666,7,'test板块',395,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34667,7,'test板块',396,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34668,7,'test板块',397,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34669,7,'test板块',398,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34670,7,'test板块',399,'福建实施员',0);
INSERT INTO `edu_statistic_model` VALUES (34672,7,'test板块',81,'黑龙江省的管理员1',0);
INSERT INTO `edu_statistic_model` VALUES (34673,7,'test板块',82,'哈尔滨市的管理员',0);
INSERT INTO `edu_statistic_model` VALUES (34674,7,'test板块',83,'阿城区的管理员',0);
INSERT INTO `edu_statistic_model` VALUES (34675,7,'test板块',84,'学校管理员',0);
INSERT INTO `edu_statistic_model` VALUES (34676,7,'test板块',85,'教师网管理员',0);
INSERT INTO `edu_statistic_model` VALUES (34677,7,'test板块',86,'果实网管理员',0);
INSERT INTO `edu_statistic_model` VALUES (34678,7,'test板块',87,'系统管理员',0);
INSERT INTO `edu_statistic_model` VALUES (34679,7,'test板块',264,' 湖北管理员',0);
INSERT INTO `edu_statistic_model` VALUES (34680,7,'test板块',265,'武汉admin',0);
INSERT INTO `edu_statistic_model` VALUES (34681,7,'test板块',266,'李念',0);
INSERT INTO `edu_statistic_model` VALUES (34682,7,'test板块',267,'王欢',0);
INSERT INTO `edu_statistic_model` VALUES (34683,7,'test板块',268,'湖北承培一',0);
INSERT INTO `edu_statistic_model` VALUES (34684,7,'test板块',269,'刘琦',0);
INSERT INTO `edu_statistic_model` VALUES (34685,7,'test板块',270,'马骁',0);
INSERT INTO `edu_statistic_model` VALUES (34686,7,'test板块',271,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34687,7,'test板块',272,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34688,7,'test板块',273,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34689,7,'test板块',274,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34690,7,'test板块',275,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34691,7,'test板块',276,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34692,7,'test板块',277,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34693,7,'test板块',278,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34694,7,'test板块',279,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34695,7,'test板块',280,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34696,7,'test板块',281,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34697,7,'test板块',282,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34698,7,'test板块',283,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34699,7,'test板块',284,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34700,7,'test板块',285,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34701,7,'test板块',286,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34702,7,'test板块',287,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34703,7,'test板块',288,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34704,7,'test板块',289,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34705,7,'test板块',290,'夷陵区初中管理员',0);
INSERT INTO `edu_statistic_model` VALUES (34706,7,'test板块',291,'武汉实施一',0);
INSERT INTO `edu_statistic_model` VALUES (34707,7,'test板块',292,'武汉承培一',0);
INSERT INTO `edu_statistic_model` VALUES (34708,7,'test板块',293,'王明',0);
INSERT INTO `edu_statistic_model` VALUES (34709,7,'test板块',294,'王力',0);
INSERT INTO `edu_statistic_model` VALUES (34710,7,'test板块',295,'赖长兴',0);
INSERT INTO `edu_statistic_model` VALUES (34711,7,'test板块',296,'杨钰莹',0);
INSERT INTO `edu_statistic_model` VALUES (34712,7,'test板块',297,'赖伟峰',0);
INSERT INTO `edu_statistic_model` VALUES (34713,7,'test板块',298,'李亚',0);
INSERT INTO `edu_statistic_model` VALUES (34714,7,'test板块',299,'李峰',0);
INSERT INTO `edu_statistic_model` VALUES (34715,7,'test板块',300,'黄欢',0);
INSERT INTO `edu_statistic_model` VALUES (34716,7,'test板块',301,'李梅',0);
INSERT INTO `edu_statistic_model` VALUES (34717,7,'test板块',302,'王雷',0);
INSERT INTO `edu_statistic_model` VALUES (34718,7,'test板块',303,'圆圆',0);
INSERT INTO `edu_statistic_model` VALUES (34719,7,'test板块',304,'木子',0);
INSERT INTO `edu_statistic_model` VALUES (34720,7,'test板块',305,' 李蕊',0);
INSERT INTO `edu_statistic_model` VALUES (34721,7,'test板块',306,'李翠翠',0);
INSERT INTO `edu_statistic_model` VALUES (34722,7,'test板块',307,'宋娟',0);
INSERT INTO `edu_statistic_model` VALUES (34723,7,'test板块',308,'王颖',0);
INSERT INTO `edu_statistic_model` VALUES (34724,7,'test板块',309,'刘伟',0);
INSERT INTO `edu_statistic_model` VALUES (34725,7,'test板块',310,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34726,7,'test板块',311,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34727,7,'test板块',312,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34728,7,'test板块',313,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34729,7,'test板块',314,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34730,7,'test板块',315,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34731,7,'test板块',316,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34732,7,'test板块',317,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34733,7,'test板块',318,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34734,7,'test板块',319,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34735,7,'test板块',320,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34736,7,'test板块',321,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34737,7,'test板块',322,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34738,7,'test板块',323,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34739,7,'test板块',324,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34740,7,'test板块',325,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34741,7,'test板块',326,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34742,7,'test板块',327,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34743,7,'test板块',328,'李明',0);
INSERT INTO `edu_statistic_model` VALUES (34744,7,'test板块',329,'高力',0);
INSERT INTO `edu_statistic_model` VALUES (34745,7,'test板块',330,'李长兴',0);
INSERT INTO `edu_statistic_model` VALUES (34746,7,'test板块',331,'潘钰莹',0);
INSERT INTO `edu_statistic_model` VALUES (34747,7,'test板块',332,'杨伟峰',0);
INSERT INTO `edu_statistic_model` VALUES (34748,7,'test板块',333,'李亚平',0);
INSERT INTO `edu_statistic_model` VALUES (34749,7,'test板块',334,'李韦伯',0);
INSERT INTO `edu_statistic_model` VALUES (34750,7,'test板块',335,'黄雷',0);
INSERT INTO `edu_statistic_model` VALUES (34751,7,'test板块',336,'李培',0);
INSERT INTO `edu_statistic_model` VALUES (34752,7,'test板块',354,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34753,7,'test板块',355,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34754,7,'test板块',356,'刘梅',0);
INSERT INTO `edu_statistic_model` VALUES (34755,7,'test板块',357,'王明',0);
INSERT INTO `edu_statistic_model` VALUES (34756,7,'test板块',358,'王磊',0);
INSERT INTO `edu_statistic_model` VALUES (34757,7,'test板块',359,'李群',0);
INSERT INTO `edu_statistic_model` VALUES (34758,7,'test板块',360,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34759,7,'test板块',361,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34760,7,'test板块',362,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34761,7,'test板块',363,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34762,7,'test板块',364,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34763,7,'test板块',365,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34764,7,'test板块',366,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34765,7,'test板块',367,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34766,7,'test板块',368,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34767,7,'test板块',369,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34768,7,'test板块',370,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34769,7,'test板块',371,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34770,7,'test板块',372,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34771,7,'test板块',373,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34772,7,'test板块',374,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34773,7,'test板块',375,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34774,7,'test板块',376,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34775,7,'test板块',377,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34776,7,'test板块',378,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34777,7,'test板块',379,'李玉',0);
INSERT INTO `edu_statistic_model` VALUES (34778,7,'test板块',380,'杨明',0);
INSERT INTO `edu_statistic_model` VALUES (34779,7,'test板块',381,'刘超',0);
INSERT INTO `edu_statistic_model` VALUES (34780,7,'test板块',382,'王兴',0);
INSERT INTO `edu_statistic_model` VALUES (34781,7,'test板块',383,'庞龙',0);
INSERT INTO `edu_statistic_model` VALUES (34782,7,'test板块',384,'杨离伟',0);
INSERT INTO `edu_statistic_model` VALUES (34783,7,'test板块',385,'小薛',0);
INSERT INTO `edu_statistic_model` VALUES (34784,7,'test板块',386,'刘燕',0);
INSERT INTO `edu_statistic_model` VALUES (34785,7,'test板块',387,'马丁',0);
INSERT INTO `edu_statistic_model` VALUES (34786,7,'test板块',388,'王龙',0);
INSERT INTO `edu_statistic_model` VALUES (34787,7,'test板块',389,'李赞',0);
INSERT INTO `edu_statistic_model` VALUES (34788,7,'test板块',390,'王五',0);
INSERT INTO `edu_statistic_model` VALUES (34789,7,'test板块',391,'李恒',0);
INSERT INTO `edu_statistic_model` VALUES (34790,7,'test板块',392,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34791,7,'test板块',393,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34792,7,'test板块',394,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34793,7,'test板块',395,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34794,7,'test板块',396,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34795,7,'test板块',397,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34796,7,'test板块',398,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34797,7,'test板块',399,'福建实施员',0);
INSERT INTO `edu_statistic_model` VALUES (34926,8,'湖南计较14年计划',81,'黑龙江省的管理员1',0);
INSERT INTO `edu_statistic_model` VALUES (34927,8,'湖南计较14年计划',82,'哈尔滨市的管理员',0);
INSERT INTO `edu_statistic_model` VALUES (34928,8,'湖南计较14年计划',83,'阿城区的管理员',0);
INSERT INTO `edu_statistic_model` VALUES (34929,8,'湖南计较14年计划',84,'学校管理员',0);
INSERT INTO `edu_statistic_model` VALUES (34930,8,'湖南计较14年计划',85,'教师网管理员',0);
INSERT INTO `edu_statistic_model` VALUES (34931,8,'湖南计较14年计划',86,'果实网管理员',0);
INSERT INTO `edu_statistic_model` VALUES (34932,8,'湖南计较14年计划',87,'系统管理员',0);
INSERT INTO `edu_statistic_model` VALUES (34933,8,'湖南计较14年计划',264,' 湖北管理员',0);
INSERT INTO `edu_statistic_model` VALUES (34934,8,'湖南计较14年计划',265,'武汉admin',0);
INSERT INTO `edu_statistic_model` VALUES (34935,8,'湖南计较14年计划',266,'李念',0);
INSERT INTO `edu_statistic_model` VALUES (34936,8,'湖南计较14年计划',267,'王欢',0);
INSERT INTO `edu_statistic_model` VALUES (34937,8,'湖南计较14年计划',268,'湖北承培一',0);
INSERT INTO `edu_statistic_model` VALUES (34938,8,'湖南计较14年计划',269,'刘琦',0);
INSERT INTO `edu_statistic_model` VALUES (34939,8,'湖南计较14年计划',270,'马骁',0);
INSERT INTO `edu_statistic_model` VALUES (34940,8,'湖南计较14年计划',271,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34941,8,'湖南计较14年计划',272,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34942,8,'湖南计较14年计划',273,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34943,8,'湖南计较14年计划',274,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34944,8,'湖南计较14年计划',275,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34945,8,'湖南计较14年计划',276,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34946,8,'湖南计较14年计划',277,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34947,8,'湖南计较14年计划',278,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34948,8,'湖南计较14年计划',279,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34949,8,'湖南计较14年计划',280,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34950,8,'湖南计较14年计划',281,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34951,8,'湖南计较14年计划',282,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34952,8,'湖南计较14年计划',283,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34953,8,'湖南计较14年计划',284,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34954,8,'湖南计较14年计划',285,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34955,8,'湖南计较14年计划',286,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34956,8,'湖南计较14年计划',287,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34957,8,'湖南计较14年计划',288,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34958,8,'湖南计较14年计划',289,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34959,8,'湖南计较14年计划',290,'夷陵区初中管理员',0);
INSERT INTO `edu_statistic_model` VALUES (34960,8,'湖南计较14年计划',291,'武汉实施一',0);
INSERT INTO `edu_statistic_model` VALUES (34961,8,'湖南计较14年计划',292,'武汉承培一',0);
INSERT INTO `edu_statistic_model` VALUES (34962,8,'湖南计较14年计划',293,'王明',0);
INSERT INTO `edu_statistic_model` VALUES (34963,8,'湖南计较14年计划',294,'王力',0);
INSERT INTO `edu_statistic_model` VALUES (34964,8,'湖南计较14年计划',295,'赖长兴',0);
INSERT INTO `edu_statistic_model` VALUES (34965,8,'湖南计较14年计划',296,'杨钰莹',0);
INSERT INTO `edu_statistic_model` VALUES (34966,8,'湖南计较14年计划',297,'赖伟峰',0);
INSERT INTO `edu_statistic_model` VALUES (34967,8,'湖南计较14年计划',298,'李亚',0);
INSERT INTO `edu_statistic_model` VALUES (34968,8,'湖南计较14年计划',299,'李峰',0);
INSERT INTO `edu_statistic_model` VALUES (34969,8,'湖南计较14年计划',300,'黄欢',0);
INSERT INTO `edu_statistic_model` VALUES (34970,8,'湖南计较14年计划',301,'李梅',0);
INSERT INTO `edu_statistic_model` VALUES (34971,8,'湖南计较14年计划',302,'王雷',0);
INSERT INTO `edu_statistic_model` VALUES (34972,8,'湖南计较14年计划',303,'圆圆',0);
INSERT INTO `edu_statistic_model` VALUES (34973,8,'湖南计较14年计划',304,'木子',0);
INSERT INTO `edu_statistic_model` VALUES (34974,8,'湖南计较14年计划',305,' 李蕊',0);
INSERT INTO `edu_statistic_model` VALUES (34975,8,'湖南计较14年计划',306,'李翠翠',0);
INSERT INTO `edu_statistic_model` VALUES (34976,8,'湖南计较14年计划',307,'宋娟',0);
INSERT INTO `edu_statistic_model` VALUES (34977,8,'湖南计较14年计划',308,'王颖',0);
INSERT INTO `edu_statistic_model` VALUES (34978,8,'湖南计较14年计划',309,'刘伟',0);
INSERT INTO `edu_statistic_model` VALUES (34979,8,'湖南计较14年计划',310,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34980,8,'湖南计较14年计划',311,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34981,8,'湖南计较14年计划',312,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34982,8,'湖南计较14年计划',313,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34983,8,'湖南计较14年计划',314,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34984,8,'湖南计较14年计划',315,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34985,8,'湖南计较14年计划',316,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34986,8,'湖南计较14年计划',317,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34987,8,'湖南计较14年计划',318,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34988,8,'湖南计较14年计划',319,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34989,8,'湖南计较14年计划',320,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34990,8,'湖南计较14年计划',321,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34991,8,'湖南计较14年计划',322,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34992,8,'湖南计较14年计划',323,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34993,8,'湖南计较14年计划',324,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34994,8,'湖南计较14年计划',325,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34995,8,'湖南计较14年计划',326,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34996,8,'湖南计较14年计划',327,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (34997,8,'湖南计较14年计划',328,'李明',0);
INSERT INTO `edu_statistic_model` VALUES (34998,8,'湖南计较14年计划',329,'高力',0);
INSERT INTO `edu_statistic_model` VALUES (34999,8,'湖南计较14年计划',330,'李长兴',0);
INSERT INTO `edu_statistic_model` VALUES (35000,8,'湖南计较14年计划',331,'潘钰莹',0);
INSERT INTO `edu_statistic_model` VALUES (35001,8,'湖南计较14年计划',332,'杨伟峰',0);
INSERT INTO `edu_statistic_model` VALUES (35002,8,'湖南计较14年计划',333,'李亚平',0);
INSERT INTO `edu_statistic_model` VALUES (35003,8,'湖南计较14年计划',334,'李韦伯',0);
INSERT INTO `edu_statistic_model` VALUES (35004,8,'湖南计较14年计划',335,'黄雷',0);
INSERT INTO `edu_statistic_model` VALUES (35005,8,'湖南计较14年计划',336,'李培',0);
INSERT INTO `edu_statistic_model` VALUES (35006,8,'湖南计较14年计划',354,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35007,8,'湖南计较14年计划',355,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35008,8,'湖南计较14年计划',356,'刘梅',0);
INSERT INTO `edu_statistic_model` VALUES (35009,8,'湖南计较14年计划',357,'王明',0);
INSERT INTO `edu_statistic_model` VALUES (35010,8,'湖南计较14年计划',358,'王磊',0);
INSERT INTO `edu_statistic_model` VALUES (35011,8,'湖南计较14年计划',359,'李群',0);
INSERT INTO `edu_statistic_model` VALUES (35012,8,'湖南计较14年计划',360,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35013,8,'湖南计较14年计划',361,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35014,8,'湖南计较14年计划',362,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35015,8,'湖南计较14年计划',363,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35016,8,'湖南计较14年计划',364,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35017,8,'湖南计较14年计划',365,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35018,8,'湖南计较14年计划',366,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35019,8,'湖南计较14年计划',367,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35020,8,'湖南计较14年计划',368,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35021,8,'湖南计较14年计划',369,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35022,8,'湖南计较14年计划',370,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35023,8,'湖南计较14年计划',371,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35024,8,'湖南计较14年计划',372,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35025,8,'湖南计较14年计划',373,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35026,8,'湖南计较14年计划',374,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35027,8,'湖南计较14年计划',375,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35028,8,'湖南计较14年计划',376,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35029,8,'湖南计较14年计划',377,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35030,8,'湖南计较14年计划',378,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35031,8,'湖南计较14年计划',379,'李玉',0);
INSERT INTO `edu_statistic_model` VALUES (35032,8,'湖南计较14年计划',380,'杨明',0);
INSERT INTO `edu_statistic_model` VALUES (35033,8,'湖南计较14年计划',381,'刘超',0);
INSERT INTO `edu_statistic_model` VALUES (35034,8,'湖南计较14年计划',382,'王兴',0);
INSERT INTO `edu_statistic_model` VALUES (35035,8,'湖南计较14年计划',383,'庞龙',0);
INSERT INTO `edu_statistic_model` VALUES (35036,8,'湖南计较14年计划',384,'杨离伟',0);
INSERT INTO `edu_statistic_model` VALUES (35037,8,'湖南计较14年计划',385,'小薛',0);
INSERT INTO `edu_statistic_model` VALUES (35038,8,'湖南计较14年计划',386,'刘燕',0);
INSERT INTO `edu_statistic_model` VALUES (35039,8,'湖南计较14年计划',387,'马丁',0);
INSERT INTO `edu_statistic_model` VALUES (35040,8,'湖南计较14年计划',388,'王龙',0);
INSERT INTO `edu_statistic_model` VALUES (35041,8,'湖南计较14年计划',389,'李赞',0);
INSERT INTO `edu_statistic_model` VALUES (35042,8,'湖南计较14年计划',390,'王五',0);
INSERT INTO `edu_statistic_model` VALUES (35043,8,'湖南计较14年计划',391,'李恒',0);
INSERT INTO `edu_statistic_model` VALUES (35044,8,'湖南计较14年计划',392,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35045,8,'湖南计较14年计划',393,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35046,8,'湖南计较14年计划',394,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35047,8,'湖南计较14年计划',395,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35048,8,'湖南计较14年计划',396,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35049,8,'湖南计较14年计划',397,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35050,8,'湖南计较14年计划',398,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35051,8,'湖南计较14年计划',399,'福建实施员',0);
INSERT INTO `edu_statistic_model` VALUES (35180,4,'14年国培计划',81,'黑龙江省的管理员1',0);
INSERT INTO `edu_statistic_model` VALUES (35181,4,'14年国培计划',82,'哈尔滨市的管理员',0);
INSERT INTO `edu_statistic_model` VALUES (35182,4,'14年国培计划',83,'阿城区的管理员',0);
INSERT INTO `edu_statistic_model` VALUES (35183,4,'14年国培计划',84,'学校管理员',0);
INSERT INTO `edu_statistic_model` VALUES (35184,4,'14年国培计划',85,'教师网管理员',0);
INSERT INTO `edu_statistic_model` VALUES (35185,4,'14年国培计划',86,'果实网管理员',0);
INSERT INTO `edu_statistic_model` VALUES (35186,4,'14年国培计划',87,'系统管理员',0);
INSERT INTO `edu_statistic_model` VALUES (35187,4,'14年国培计划',264,' 湖北管理员',0);
INSERT INTO `edu_statistic_model` VALUES (35188,4,'14年国培计划',265,'武汉admin',0);
INSERT INTO `edu_statistic_model` VALUES (35189,4,'14年国培计划',266,'李念',0);
INSERT INTO `edu_statistic_model` VALUES (35190,4,'14年国培计划',267,'王欢',0);
INSERT INTO `edu_statistic_model` VALUES (35191,4,'14年国培计划',268,'湖北承培一',0);
INSERT INTO `edu_statistic_model` VALUES (35192,4,'14年国培计划',269,'刘琦',0);
INSERT INTO `edu_statistic_model` VALUES (35193,4,'14年国培计划',270,'马骁',0);
INSERT INTO `edu_statistic_model` VALUES (35194,4,'14年国培计划',271,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35195,4,'14年国培计划',272,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35196,4,'14年国培计划',273,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35197,4,'14年国培计划',274,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35198,4,'14年国培计划',275,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35199,4,'14年国培计划',276,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35200,4,'14年国培计划',277,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35201,4,'14年国培计划',278,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35202,4,'14年国培计划',279,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35203,4,'14年国培计划',280,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35204,4,'14年国培计划',281,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35205,4,'14年国培计划',282,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35206,4,'14年国培计划',283,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35207,4,'14年国培计划',284,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35208,4,'14年国培计划',285,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35209,4,'14年国培计划',286,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35210,4,'14年国培计划',287,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35211,4,'14年国培计划',288,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35212,4,'14年国培计划',289,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35213,4,'14年国培计划',290,'夷陵区初中管理员',0);
INSERT INTO `edu_statistic_model` VALUES (35214,4,'14年国培计划',291,'武汉实施一',0);
INSERT INTO `edu_statistic_model` VALUES (35215,4,'14年国培计划',292,'武汉承培一',0);
INSERT INTO `edu_statistic_model` VALUES (35216,4,'14年国培计划',293,'王明',0);
INSERT INTO `edu_statistic_model` VALUES (35217,4,'14年国培计划',294,'王力',0);
INSERT INTO `edu_statistic_model` VALUES (35218,4,'14年国培计划',295,'赖长兴',0);
INSERT INTO `edu_statistic_model` VALUES (35219,4,'14年国培计划',296,'杨钰莹',0);
INSERT INTO `edu_statistic_model` VALUES (35220,4,'14年国培计划',297,'赖伟峰',0);
INSERT INTO `edu_statistic_model` VALUES (35221,4,'14年国培计划',298,'李亚',0);
INSERT INTO `edu_statistic_model` VALUES (35222,4,'14年国培计划',299,'李峰',0);
INSERT INTO `edu_statistic_model` VALUES (35223,4,'14年国培计划',300,'黄欢',0);
INSERT INTO `edu_statistic_model` VALUES (35224,4,'14年国培计划',301,'李梅',0);
INSERT INTO `edu_statistic_model` VALUES (35225,4,'14年国培计划',302,'王雷',0);
INSERT INTO `edu_statistic_model` VALUES (35226,4,'14年国培计划',303,'圆圆',0);
INSERT INTO `edu_statistic_model` VALUES (35227,4,'14年国培计划',304,'木子',0);
INSERT INTO `edu_statistic_model` VALUES (35228,4,'14年国培计划',305,' 李蕊',0);
INSERT INTO `edu_statistic_model` VALUES (35229,4,'14年国培计划',306,'李翠翠',0);
INSERT INTO `edu_statistic_model` VALUES (35230,4,'14年国培计划',307,'宋娟',0);
INSERT INTO `edu_statistic_model` VALUES (35231,4,'14年国培计划',308,'王颖',0);
INSERT INTO `edu_statistic_model` VALUES (35232,4,'14年国培计划',309,'刘伟',0);
INSERT INTO `edu_statistic_model` VALUES (35233,4,'14年国培计划',310,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35234,4,'14年国培计划',311,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35235,4,'14年国培计划',312,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35236,4,'14年国培计划',313,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35237,4,'14年国培计划',314,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35238,4,'14年国培计划',315,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35239,4,'14年国培计划',316,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35240,4,'14年国培计划',317,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35241,4,'14年国培计划',318,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35242,4,'14年国培计划',319,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35243,4,'14年国培计划',320,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35244,4,'14年国培计划',321,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35245,4,'14年国培计划',322,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35246,4,'14年国培计划',323,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35247,4,'14年国培计划',324,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35248,4,'14年国培计划',325,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35249,4,'14年国培计划',326,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35250,4,'14年国培计划',327,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35251,4,'14年国培计划',328,'李明',0);
INSERT INTO `edu_statistic_model` VALUES (35252,4,'14年国培计划',329,'高力',0);
INSERT INTO `edu_statistic_model` VALUES (35253,4,'14年国培计划',330,'李长兴',0);
INSERT INTO `edu_statistic_model` VALUES (35254,4,'14年国培计划',331,'潘钰莹',0);
INSERT INTO `edu_statistic_model` VALUES (35255,4,'14年国培计划',332,'杨伟峰',0);
INSERT INTO `edu_statistic_model` VALUES (35256,4,'14年国培计划',333,'李亚平',0);
INSERT INTO `edu_statistic_model` VALUES (35257,4,'14年国培计划',334,'李韦伯',0);
INSERT INTO `edu_statistic_model` VALUES (35258,4,'14年国培计划',335,'黄雷',0);
INSERT INTO `edu_statistic_model` VALUES (35259,4,'14年国培计划',336,'李培',0);
INSERT INTO `edu_statistic_model` VALUES (35260,4,'14年国培计划',354,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35261,4,'14年国培计划',355,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35262,4,'14年国培计划',356,'刘梅',0);
INSERT INTO `edu_statistic_model` VALUES (35263,4,'14年国培计划',357,'王明',0);
INSERT INTO `edu_statistic_model` VALUES (35264,4,'14年国培计划',358,'王磊',0);
INSERT INTO `edu_statistic_model` VALUES (35265,4,'14年国培计划',359,'李群',0);
INSERT INTO `edu_statistic_model` VALUES (35266,4,'14年国培计划',360,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35267,4,'14年国培计划',361,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35268,4,'14年国培计划',362,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35269,4,'14年国培计划',363,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35270,4,'14年国培计划',364,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35271,4,'14年国培计划',365,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35272,4,'14年国培计划',366,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35273,4,'14年国培计划',367,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35274,4,'14年国培计划',368,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35275,4,'14年国培计划',369,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35276,4,'14年国培计划',370,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35277,4,'14年国培计划',371,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35278,4,'14年国培计划',372,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35279,4,'14年国培计划',373,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35280,4,'14年国培计划',374,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35281,4,'14年国培计划',375,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35282,4,'14年国培计划',376,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35283,4,'14年国培计划',377,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35284,4,'14年国培计划',378,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35285,4,'14年国培计划',379,'李玉',0);
INSERT INTO `edu_statistic_model` VALUES (35286,4,'14年国培计划',380,'杨明',0);
INSERT INTO `edu_statistic_model` VALUES (35287,4,'14年国培计划',381,'刘超',0);
INSERT INTO `edu_statistic_model` VALUES (35288,4,'14年国培计划',382,'王兴',0);
INSERT INTO `edu_statistic_model` VALUES (35289,4,'14年国培计划',383,'庞龙',0);
INSERT INTO `edu_statistic_model` VALUES (35290,4,'14年国培计划',384,'杨离伟',0);
INSERT INTO `edu_statistic_model` VALUES (35291,4,'14年国培计划',385,'小薛',0);
INSERT INTO `edu_statistic_model` VALUES (35292,4,'14年国培计划',386,'刘燕',0);
INSERT INTO `edu_statistic_model` VALUES (35293,4,'14年国培计划',387,'马丁',0);
INSERT INTO `edu_statistic_model` VALUES (35294,4,'14年国培计划',388,'王龙',0);
INSERT INTO `edu_statistic_model` VALUES (35295,4,'14年国培计划',389,'李赞',0);
INSERT INTO `edu_statistic_model` VALUES (35296,4,'14年国培计划',390,'王五',0);
INSERT INTO `edu_statistic_model` VALUES (35297,4,'14年国培计划',391,'李恒',0);
INSERT INTO `edu_statistic_model` VALUES (35298,4,'14年国培计划',392,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35299,4,'14年国培计划',393,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35300,4,'14年国培计划',394,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35301,4,'14年国培计划',395,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35302,4,'14年国培计划',396,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35303,4,'14年国培计划',397,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35304,4,'14年国培计划',398,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35305,4,'14年国培计划',399,'福建实施员',0);
INSERT INTO `edu_statistic_model` VALUES (35434,5,'湖南省14年继教计划',81,'黑龙江省的管理员1',0);
INSERT INTO `edu_statistic_model` VALUES (35435,5,'湖南省14年继教计划',82,'哈尔滨市的管理员',0);
INSERT INTO `edu_statistic_model` VALUES (35436,5,'湖南省14年继教计划',83,'阿城区的管理员',0);
INSERT INTO `edu_statistic_model` VALUES (35437,5,'湖南省14年继教计划',84,'学校管理员',0);
INSERT INTO `edu_statistic_model` VALUES (35438,5,'湖南省14年继教计划',85,'教师网管理员',0);
INSERT INTO `edu_statistic_model` VALUES (35439,5,'湖南省14年继教计划',86,'果实网管理员',0);
INSERT INTO `edu_statistic_model` VALUES (35440,5,'湖南省14年继教计划',87,'系统管理员',0);
INSERT INTO `edu_statistic_model` VALUES (35441,5,'湖南省14年继教计划',264,' 湖北管理员',0);
INSERT INTO `edu_statistic_model` VALUES (35442,5,'湖南省14年继教计划',265,'武汉admin',0);
INSERT INTO `edu_statistic_model` VALUES (35443,5,'湖南省14年继教计划',266,'李念',0);
INSERT INTO `edu_statistic_model` VALUES (35444,5,'湖南省14年继教计划',267,'王欢',0);
INSERT INTO `edu_statistic_model` VALUES (35445,5,'湖南省14年继教计划',268,'湖北承培一',0);
INSERT INTO `edu_statistic_model` VALUES (35446,5,'湖南省14年继教计划',269,'刘琦',0);
INSERT INTO `edu_statistic_model` VALUES (35447,5,'湖南省14年继教计划',270,'马骁',0);
INSERT INTO `edu_statistic_model` VALUES (35448,5,'湖南省14年继教计划',271,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35449,5,'湖南省14年继教计划',272,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35450,5,'湖南省14年继教计划',273,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35451,5,'湖南省14年继教计划',274,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35452,5,'湖南省14年继教计划',275,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35453,5,'湖南省14年继教计划',276,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35454,5,'湖南省14年继教计划',277,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35455,5,'湖南省14年继教计划',278,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35456,5,'湖南省14年继教计划',279,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35457,5,'湖南省14年继教计划',280,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35458,5,'湖南省14年继教计划',281,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35459,5,'湖南省14年继教计划',282,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35460,5,'湖南省14年继教计划',283,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35461,5,'湖南省14年继教计划',284,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35462,5,'湖南省14年继教计划',285,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35463,5,'湖南省14年继教计划',286,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35464,5,'湖南省14年继教计划',287,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35465,5,'湖南省14年继教计划',288,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35466,5,'湖南省14年继教计划',289,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35467,5,'湖南省14年继教计划',290,'夷陵区初中管理员',0);
INSERT INTO `edu_statistic_model` VALUES (35468,5,'湖南省14年继教计划',291,'武汉实施一',0);
INSERT INTO `edu_statistic_model` VALUES (35469,5,'湖南省14年继教计划',292,'武汉承培一',0);
INSERT INTO `edu_statistic_model` VALUES (35470,5,'湖南省14年继教计划',293,'王明',0);
INSERT INTO `edu_statistic_model` VALUES (35471,5,'湖南省14年继教计划',294,'王力',0);
INSERT INTO `edu_statistic_model` VALUES (35472,5,'湖南省14年继教计划',295,'赖长兴',0);
INSERT INTO `edu_statistic_model` VALUES (35473,5,'湖南省14年继教计划',296,'杨钰莹',0);
INSERT INTO `edu_statistic_model` VALUES (35474,5,'湖南省14年继教计划',297,'赖伟峰',0);
INSERT INTO `edu_statistic_model` VALUES (35475,5,'湖南省14年继教计划',298,'李亚',0);
INSERT INTO `edu_statistic_model` VALUES (35476,5,'湖南省14年继教计划',299,'李峰',0);
INSERT INTO `edu_statistic_model` VALUES (35477,5,'湖南省14年继教计划',300,'黄欢',0);
INSERT INTO `edu_statistic_model` VALUES (35478,5,'湖南省14年继教计划',301,'李梅',0);
INSERT INTO `edu_statistic_model` VALUES (35479,5,'湖南省14年继教计划',302,'王雷',0);
INSERT INTO `edu_statistic_model` VALUES (35480,5,'湖南省14年继教计划',303,'圆圆',0);
INSERT INTO `edu_statistic_model` VALUES (35481,5,'湖南省14年继教计划',304,'木子',0);
INSERT INTO `edu_statistic_model` VALUES (35482,5,'湖南省14年继教计划',305,' 李蕊',0);
INSERT INTO `edu_statistic_model` VALUES (35483,5,'湖南省14年继教计划',306,'李翠翠',0);
INSERT INTO `edu_statistic_model` VALUES (35484,5,'湖南省14年继教计划',307,'宋娟',0);
INSERT INTO `edu_statistic_model` VALUES (35485,5,'湖南省14年继教计划',308,'王颖',0);
INSERT INTO `edu_statistic_model` VALUES (35486,5,'湖南省14年继教计划',309,'刘伟',0);
INSERT INTO `edu_statistic_model` VALUES (35487,5,'湖南省14年继教计划',310,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35488,5,'湖南省14年继教计划',311,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35489,5,'湖南省14年继教计划',312,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35490,5,'湖南省14年继教计划',313,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35491,5,'湖南省14年继教计划',314,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35492,5,'湖南省14年继教计划',315,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35493,5,'湖南省14年继教计划',316,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35494,5,'湖南省14年继教计划',317,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35495,5,'湖南省14年继教计划',318,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35496,5,'湖南省14年继教计划',319,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35497,5,'湖南省14年继教计划',320,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35498,5,'湖南省14年继教计划',321,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35499,5,'湖南省14年继教计划',322,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35500,5,'湖南省14年继教计划',323,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35501,5,'湖南省14年继教计划',324,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35502,5,'湖南省14年继教计划',325,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35503,5,'湖南省14年继教计划',326,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35504,5,'湖南省14年继教计划',327,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35505,5,'湖南省14年继教计划',328,'李明',5);
INSERT INTO `edu_statistic_model` VALUES (35506,5,'湖南省14年继教计划',329,'高力',0);
INSERT INTO `edu_statistic_model` VALUES (35507,5,'湖南省14年继教计划',330,'李长兴',6);
INSERT INTO `edu_statistic_model` VALUES (35508,5,'湖南省14年继教计划',331,'潘钰莹',0);
INSERT INTO `edu_statistic_model` VALUES (35509,5,'湖南省14年继教计划',332,'杨伟峰',0);
INSERT INTO `edu_statistic_model` VALUES (35510,5,'湖南省14年继教计划',333,'李亚平',0);
INSERT INTO `edu_statistic_model` VALUES (35511,5,'湖南省14年继教计划',334,'李韦伯',0);
INSERT INTO `edu_statistic_model` VALUES (35512,5,'湖南省14年继教计划',335,'黄雷',0);
INSERT INTO `edu_statistic_model` VALUES (35513,5,'湖南省14年继教计划',336,'李培',0);
INSERT INTO `edu_statistic_model` VALUES (35514,5,'湖南省14年继教计划',354,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35515,5,'湖南省14年继教计划',355,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35516,5,'湖南省14年继教计划',356,'刘梅',0);
INSERT INTO `edu_statistic_model` VALUES (35517,5,'湖南省14年继教计划',357,'王明',0);
INSERT INTO `edu_statistic_model` VALUES (35518,5,'湖南省14年继教计划',358,'王磊',0);
INSERT INTO `edu_statistic_model` VALUES (35519,5,'湖南省14年继教计划',359,'李群',0);
INSERT INTO `edu_statistic_model` VALUES (35520,5,'湖南省14年继教计划',360,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35521,5,'湖南省14年继教计划',361,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35522,5,'湖南省14年继教计划',362,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35523,5,'湖南省14年继教计划',363,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35524,5,'湖南省14年继教计划',364,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35525,5,'湖南省14年继教计划',365,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35526,5,'湖南省14年继教计划',366,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35527,5,'湖南省14年继教计划',367,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35528,5,'湖南省14年继教计划',368,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35529,5,'湖南省14年继教计划',369,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35530,5,'湖南省14年继教计划',370,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35531,5,'湖南省14年继教计划',371,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35532,5,'湖南省14年继教计划',372,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35533,5,'湖南省14年继教计划',373,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35534,5,'湖南省14年继教计划',374,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35535,5,'湖南省14年继教计划',375,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35536,5,'湖南省14年继教计划',376,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35537,5,'湖南省14年继教计划',377,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35538,5,'湖南省14年继教计划',378,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35539,5,'湖南省14年继教计划',379,'李玉',0);
INSERT INTO `edu_statistic_model` VALUES (35540,5,'湖南省14年继教计划',380,'杨明',0);
INSERT INTO `edu_statistic_model` VALUES (35541,5,'湖南省14年继教计划',381,'刘超',0);
INSERT INTO `edu_statistic_model` VALUES (35542,5,'湖南省14年继教计划',382,'王兴',0);
INSERT INTO `edu_statistic_model` VALUES (35543,5,'湖南省14年继教计划',383,'庞龙',0);
INSERT INTO `edu_statistic_model` VALUES (35544,5,'湖南省14年继教计划',384,'杨离伟',0);
INSERT INTO `edu_statistic_model` VALUES (35545,5,'湖南省14年继教计划',385,'小薛',0);
INSERT INTO `edu_statistic_model` VALUES (35546,5,'湖南省14年继教计划',386,'刘燕',0);
INSERT INTO `edu_statistic_model` VALUES (35547,5,'湖南省14年继教计划',387,'马丁',0);
INSERT INTO `edu_statistic_model` VALUES (35548,5,'湖南省14年继教计划',388,'王龙',0);
INSERT INTO `edu_statistic_model` VALUES (35549,5,'湖南省14年继教计划',389,'李赞',0);
INSERT INTO `edu_statistic_model` VALUES (35550,5,'湖南省14年继教计划',390,'王五',0);
INSERT INTO `edu_statistic_model` VALUES (35551,5,'湖南省14年继教计划',391,'李恒',0);
INSERT INTO `edu_statistic_model` VALUES (35552,5,'湖南省14年继教计划',392,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35553,5,'湖南省14年继教计划',393,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35554,5,'湖南省14年继教计划',394,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35555,5,'湖南省14年继教计划',395,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35556,5,'湖南省14年继教计划',396,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35557,5,'湖南省14年继教计划',397,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35558,5,'湖南省14年继教计划',398,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35559,5,'湖南省14年继教计划',399,'福建实施员',0);
INSERT INTO `edu_statistic_model` VALUES (35688,11,'14年国培继教信息',81,'黑龙江省的管理员1',0);
INSERT INTO `edu_statistic_model` VALUES (35689,11,'14年国培继教信息',82,'哈尔滨市的管理员',0);
INSERT INTO `edu_statistic_model` VALUES (35690,11,'14年国培继教信息',83,'阿城区的管理员',0);
INSERT INTO `edu_statistic_model` VALUES (35691,11,'14年国培继教信息',84,'学校管理员',0);
INSERT INTO `edu_statistic_model` VALUES (35692,11,'14年国培继教信息',85,'教师网管理员',0);
INSERT INTO `edu_statistic_model` VALUES (35693,11,'14年国培继教信息',86,'果实网管理员',0);
INSERT INTO `edu_statistic_model` VALUES (35694,11,'14年国培继教信息',87,'系统管理员',0);
INSERT INTO `edu_statistic_model` VALUES (35695,11,'14年国培继教信息',264,' 湖北管理员',0);
INSERT INTO `edu_statistic_model` VALUES (35696,11,'14年国培继教信息',265,'武汉admin',0);
INSERT INTO `edu_statistic_model` VALUES (35697,11,'14年国培继教信息',266,'李念',0);
INSERT INTO `edu_statistic_model` VALUES (35698,11,'14年国培继教信息',267,'王欢',0);
INSERT INTO `edu_statistic_model` VALUES (35699,11,'14年国培继教信息',268,'湖北承培一',0);
INSERT INTO `edu_statistic_model` VALUES (35700,11,'14年国培继教信息',269,'刘琦',0);
INSERT INTO `edu_statistic_model` VALUES (35701,11,'14年国培继教信息',270,'马骁',0);
INSERT INTO `edu_statistic_model` VALUES (35702,11,'14年国培继教信息',271,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35703,11,'14年国培继教信息',272,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35704,11,'14年国培继教信息',273,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35705,11,'14年国培继教信息',274,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35706,11,'14年国培继教信息',275,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35707,11,'14年国培继教信息',276,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35708,11,'14年国培继教信息',277,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35709,11,'14年国培继教信息',278,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35710,11,'14年国培继教信息',279,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35711,11,'14年国培继教信息',280,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35712,11,'14年国培继教信息',281,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35713,11,'14年国培继教信息',282,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35714,11,'14年国培继教信息',283,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35715,11,'14年国培继教信息',284,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35716,11,'14年国培继教信息',285,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35717,11,'14年国培继教信息',286,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35718,11,'14年国培继教信息',287,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35719,11,'14年国培继教信息',288,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35720,11,'14年国培继教信息',289,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35721,11,'14年国培继教信息',290,'夷陵区初中管理员',0);
INSERT INTO `edu_statistic_model` VALUES (35722,11,'14年国培继教信息',291,'武汉实施一',0);
INSERT INTO `edu_statistic_model` VALUES (35723,11,'14年国培继教信息',292,'武汉承培一',0);
INSERT INTO `edu_statistic_model` VALUES (35724,11,'14年国培继教信息',293,'王明',0);
INSERT INTO `edu_statistic_model` VALUES (35725,11,'14年国培继教信息',294,'王力',0);
INSERT INTO `edu_statistic_model` VALUES (35726,11,'14年国培继教信息',295,'赖长兴',0);
INSERT INTO `edu_statistic_model` VALUES (35727,11,'14年国培继教信息',296,'杨钰莹',0);
INSERT INTO `edu_statistic_model` VALUES (35728,11,'14年国培继教信息',297,'赖伟峰',0);
INSERT INTO `edu_statistic_model` VALUES (35729,11,'14年国培继教信息',298,'李亚',0);
INSERT INTO `edu_statistic_model` VALUES (35730,11,'14年国培继教信息',299,'李峰',0);
INSERT INTO `edu_statistic_model` VALUES (35731,11,'14年国培继教信息',300,'黄欢',0);
INSERT INTO `edu_statistic_model` VALUES (35732,11,'14年国培继教信息',301,'李梅',0);
INSERT INTO `edu_statistic_model` VALUES (35733,11,'14年国培继教信息',302,'王雷',0);
INSERT INTO `edu_statistic_model` VALUES (35734,11,'14年国培继教信息',303,'圆圆',0);
INSERT INTO `edu_statistic_model` VALUES (35735,11,'14年国培继教信息',304,'木子',0);
INSERT INTO `edu_statistic_model` VALUES (35736,11,'14年国培继教信息',305,' 李蕊',0);
INSERT INTO `edu_statistic_model` VALUES (35737,11,'14年国培继教信息',306,'李翠翠',0);
INSERT INTO `edu_statistic_model` VALUES (35738,11,'14年国培继教信息',307,'宋娟',0);
INSERT INTO `edu_statistic_model` VALUES (35739,11,'14年国培继教信息',308,'王颖',0);
INSERT INTO `edu_statistic_model` VALUES (35740,11,'14年国培继教信息',309,'刘伟',0);
INSERT INTO `edu_statistic_model` VALUES (35741,11,'14年国培继教信息',310,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35742,11,'14年国培继教信息',311,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35743,11,'14年国培继教信息',312,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35744,11,'14年国培继教信息',313,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35745,11,'14年国培继教信息',314,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35746,11,'14年国培继教信息',315,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35747,11,'14年国培继教信息',316,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35748,11,'14年国培继教信息',317,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35749,11,'14年国培继教信息',318,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35750,11,'14年国培继教信息',319,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35751,11,'14年国培继教信息',320,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35752,11,'14年国培继教信息',321,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35753,11,'14年国培继教信息',322,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35754,11,'14年国培继教信息',323,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35755,11,'14年国培继教信息',324,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35756,11,'14年国培继教信息',325,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35757,11,'14年国培继教信息',326,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35758,11,'14年国培继教信息',327,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35759,11,'14年国培继教信息',328,'李明',0);
INSERT INTO `edu_statistic_model` VALUES (35760,11,'14年国培继教信息',329,'高力',0);
INSERT INTO `edu_statistic_model` VALUES (35761,11,'14年国培继教信息',330,'李长兴',0);
INSERT INTO `edu_statistic_model` VALUES (35762,11,'14年国培继教信息',331,'潘钰莹',0);
INSERT INTO `edu_statistic_model` VALUES (35763,11,'14年国培继教信息',332,'杨伟峰',0);
INSERT INTO `edu_statistic_model` VALUES (35764,11,'14年国培继教信息',333,'李亚平',0);
INSERT INTO `edu_statistic_model` VALUES (35765,11,'14年国培继教信息',334,'李韦伯',0);
INSERT INTO `edu_statistic_model` VALUES (35766,11,'14年国培继教信息',335,'黄雷',0);
INSERT INTO `edu_statistic_model` VALUES (35767,11,'14年国培继教信息',336,'李培',0);
INSERT INTO `edu_statistic_model` VALUES (35768,11,'14年国培继教信息',354,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35769,11,'14年国培继教信息',355,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35770,11,'14年国培继教信息',356,'刘梅',0);
INSERT INTO `edu_statistic_model` VALUES (35771,11,'14年国培继教信息',357,'王明',0);
INSERT INTO `edu_statistic_model` VALUES (35772,11,'14年国培继教信息',358,'王磊',0);
INSERT INTO `edu_statistic_model` VALUES (35773,11,'14年国培继教信息',359,'李群',0);
INSERT INTO `edu_statistic_model` VALUES (35774,11,'14年国培继教信息',360,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35775,11,'14年国培继教信息',361,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35776,11,'14年国培继教信息',362,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35777,11,'14年国培继教信息',363,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35778,11,'14年国培继教信息',364,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35779,11,'14年国培继教信息',365,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35780,11,'14年国培继教信息',366,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35781,11,'14年国培继教信息',367,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35782,11,'14年国培继教信息',368,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35783,11,'14年国培继教信息',369,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35784,11,'14年国培继教信息',370,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35785,11,'14年国培继教信息',371,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35786,11,'14年国培继教信息',372,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35787,11,'14年国培继教信息',373,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35788,11,'14年国培继教信息',374,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35789,11,'14年国培继教信息',375,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35790,11,'14年国培继教信息',376,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35791,11,'14年国培继教信息',377,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35792,11,'14年国培继教信息',378,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35793,11,'14年国培继教信息',379,'李玉',0);
INSERT INTO `edu_statistic_model` VALUES (35794,11,'14年国培继教信息',380,'杨明',0);
INSERT INTO `edu_statistic_model` VALUES (35795,11,'14年国培继教信息',381,'刘超',0);
INSERT INTO `edu_statistic_model` VALUES (35796,11,'14年国培继教信息',382,'王兴',0);
INSERT INTO `edu_statistic_model` VALUES (35797,11,'14年国培继教信息',383,'庞龙',0);
INSERT INTO `edu_statistic_model` VALUES (35798,11,'14年国培继教信息',384,'杨离伟',0);
INSERT INTO `edu_statistic_model` VALUES (35799,11,'14年国培继教信息',385,'小薛',0);
INSERT INTO `edu_statistic_model` VALUES (35800,11,'14年国培继教信息',386,'刘燕',0);
INSERT INTO `edu_statistic_model` VALUES (35801,11,'14年国培继教信息',387,'马丁',0);
INSERT INTO `edu_statistic_model` VALUES (35802,11,'14年国培继教信息',388,'王龙',0);
INSERT INTO `edu_statistic_model` VALUES (35803,11,'14年国培继教信息',389,'李赞',0);
INSERT INTO `edu_statistic_model` VALUES (35804,11,'14年国培继教信息',390,'王五',0);
INSERT INTO `edu_statistic_model` VALUES (35805,11,'14年国培继教信息',391,'李恒',0);
INSERT INTO `edu_statistic_model` VALUES (35806,11,'14年国培继教信息',392,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35807,11,'14年国培继教信息',393,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35808,11,'14年国培继教信息',394,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35809,11,'14年国培继教信息',395,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35810,11,'14年国培继教信息',396,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35811,11,'14年国培继教信息',397,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35812,11,'14年国培继教信息',398,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35813,11,'14年国培继教信息',399,'福建实施员',0);
INSERT INTO `edu_statistic_model` VALUES (35815,6,'湖南省教师培训计划',81,'黑龙江省的管理员1',0);
INSERT INTO `edu_statistic_model` VALUES (35816,6,'湖南省教师培训计划',82,'哈尔滨市的管理员',0);
INSERT INTO `edu_statistic_model` VALUES (35817,6,'湖南省教师培训计划',83,'阿城区的管理员',0);
INSERT INTO `edu_statistic_model` VALUES (35818,6,'湖南省教师培训计划',84,'学校管理员',0);
INSERT INTO `edu_statistic_model` VALUES (35819,6,'湖南省教师培训计划',85,'教师网管理员',0);
INSERT INTO `edu_statistic_model` VALUES (35820,6,'湖南省教师培训计划',86,'果实网管理员',0);
INSERT INTO `edu_statistic_model` VALUES (35821,6,'湖南省教师培训计划',87,'系统管理员',0);
INSERT INTO `edu_statistic_model` VALUES (35822,6,'湖南省教师培训计划',264,' 湖北管理员',0);
INSERT INTO `edu_statistic_model` VALUES (35823,6,'湖南省教师培训计划',265,'武汉admin',0);
INSERT INTO `edu_statistic_model` VALUES (35824,6,'湖南省教师培训计划',266,'李念',0);
INSERT INTO `edu_statistic_model` VALUES (35825,6,'湖南省教师培训计划',267,'王欢',0);
INSERT INTO `edu_statistic_model` VALUES (35826,6,'湖南省教师培训计划',268,'湖北承培一',0);
INSERT INTO `edu_statistic_model` VALUES (35827,6,'湖南省教师培训计划',269,'刘琦',0);
INSERT INTO `edu_statistic_model` VALUES (35828,6,'湖南省教师培训计划',270,'马骁',0);
INSERT INTO `edu_statistic_model` VALUES (35829,6,'湖南省教师培训计划',271,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35830,6,'湖南省教师培训计划',272,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35831,6,'湖南省教师培训计划',273,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35832,6,'湖南省教师培训计划',274,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35833,6,'湖南省教师培训计划',275,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35834,6,'湖南省教师培训计划',276,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35835,6,'湖南省教师培训计划',277,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35836,6,'湖南省教师培训计划',278,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35837,6,'湖南省教师培训计划',279,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35838,6,'湖南省教师培训计划',280,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35839,6,'湖南省教师培训计划',281,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35840,6,'湖南省教师培训计划',282,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35841,6,'湖南省教师培训计划',283,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35842,6,'湖南省教师培训计划',284,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35843,6,'湖南省教师培训计划',285,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35844,6,'湖南省教师培训计划',286,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35845,6,'湖南省教师培训计划',287,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35846,6,'湖南省教师培训计划',288,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35847,6,'湖南省教师培训计划',289,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35848,6,'湖南省教师培训计划',290,'夷陵区初中管理员',0);
INSERT INTO `edu_statistic_model` VALUES (35849,6,'湖南省教师培训计划',291,'武汉实施一',0);
INSERT INTO `edu_statistic_model` VALUES (35850,6,'湖南省教师培训计划',292,'武汉承培一',0);
INSERT INTO `edu_statistic_model` VALUES (35851,6,'湖南省教师培训计划',293,'王明',0);
INSERT INTO `edu_statistic_model` VALUES (35852,6,'湖南省教师培训计划',294,'王力',0);
INSERT INTO `edu_statistic_model` VALUES (35853,6,'湖南省教师培训计划',295,'赖长兴',0);
INSERT INTO `edu_statistic_model` VALUES (35854,6,'湖南省教师培训计划',296,'杨钰莹',0);
INSERT INTO `edu_statistic_model` VALUES (35855,6,'湖南省教师培训计划',297,'赖伟峰',0);
INSERT INTO `edu_statistic_model` VALUES (35856,6,'湖南省教师培训计划',298,'李亚',0);
INSERT INTO `edu_statistic_model` VALUES (35857,6,'湖南省教师培训计划',299,'李峰',0);
INSERT INTO `edu_statistic_model` VALUES (35858,6,'湖南省教师培训计划',300,'黄欢',0);
INSERT INTO `edu_statistic_model` VALUES (35859,6,'湖南省教师培训计划',301,'李梅',0);
INSERT INTO `edu_statistic_model` VALUES (35860,6,'湖南省教师培训计划',302,'王雷',0);
INSERT INTO `edu_statistic_model` VALUES (35861,6,'湖南省教师培训计划',303,'圆圆',0);
INSERT INTO `edu_statistic_model` VALUES (35862,6,'湖南省教师培训计划',304,'木子',0);
INSERT INTO `edu_statistic_model` VALUES (35863,6,'湖南省教师培训计划',305,' 李蕊',0);
INSERT INTO `edu_statistic_model` VALUES (35864,6,'湖南省教师培训计划',306,'李翠翠',0);
INSERT INTO `edu_statistic_model` VALUES (35865,6,'湖南省教师培训计划',307,'宋娟',0);
INSERT INTO `edu_statistic_model` VALUES (35866,6,'湖南省教师培训计划',308,'王颖',0);
INSERT INTO `edu_statistic_model` VALUES (35867,6,'湖南省教师培训计划',309,'刘伟',0);
INSERT INTO `edu_statistic_model` VALUES (35868,6,'湖南省教师培训计划',310,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35869,6,'湖南省教师培训计划',311,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35870,6,'湖南省教师培训计划',312,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35871,6,'湖南省教师培训计划',313,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35872,6,'湖南省教师培训计划',314,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35873,6,'湖南省教师培训计划',315,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35874,6,'湖南省教师培训计划',316,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35875,6,'湖南省教师培训计划',317,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35876,6,'湖南省教师培训计划',318,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35877,6,'湖南省教师培训计划',319,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35878,6,'湖南省教师培训计划',320,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35879,6,'湖南省教师培训计划',321,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35880,6,'湖南省教师培训计划',322,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35881,6,'湖南省教师培训计划',323,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35882,6,'湖南省教师培训计划',324,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35883,6,'湖南省教师培训计划',325,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35884,6,'湖南省教师培训计划',326,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35885,6,'湖南省教师培训计划',327,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35886,6,'湖南省教师培训计划',328,'李明',0);
INSERT INTO `edu_statistic_model` VALUES (35887,6,'湖南省教师培训计划',329,'高力',0);
INSERT INTO `edu_statistic_model` VALUES (35888,6,'湖南省教师培训计划',330,'李长兴',0);
INSERT INTO `edu_statistic_model` VALUES (35889,6,'湖南省教师培训计划',331,'潘钰莹',0);
INSERT INTO `edu_statistic_model` VALUES (35890,6,'湖南省教师培训计划',332,'杨伟峰',0);
INSERT INTO `edu_statistic_model` VALUES (35891,6,'湖南省教师培训计划',333,'李亚平',0);
INSERT INTO `edu_statistic_model` VALUES (35892,6,'湖南省教师培训计划',334,'李韦伯',0);
INSERT INTO `edu_statistic_model` VALUES (35893,6,'湖南省教师培训计划',335,'黄雷',0);
INSERT INTO `edu_statistic_model` VALUES (35894,6,'湖南省教师培训计划',336,'李培',0);
INSERT INTO `edu_statistic_model` VALUES (35895,6,'湖南省教师培训计划',354,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35896,6,'湖南省教师培训计划',355,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35897,6,'湖南省教师培训计划',356,'刘梅',0);
INSERT INTO `edu_statistic_model` VALUES (35898,6,'湖南省教师培训计划',357,'王明',0);
INSERT INTO `edu_statistic_model` VALUES (35899,6,'湖南省教师培训计划',358,'王磊',0);
INSERT INTO `edu_statistic_model` VALUES (35900,6,'湖南省教师培训计划',359,'李群',0);
INSERT INTO `edu_statistic_model` VALUES (35901,6,'湖南省教师培训计划',360,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35902,6,'湖南省教师培训计划',361,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35903,6,'湖南省教师培训计划',362,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35904,6,'湖南省教师培训计划',363,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35905,6,'湖南省教师培训计划',364,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35906,6,'湖南省教师培训计划',365,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35907,6,'湖南省教师培训计划',366,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35908,6,'湖南省教师培训计划',367,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35909,6,'湖南省教师培训计划',368,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35910,6,'湖南省教师培训计划',369,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35911,6,'湖南省教师培训计划',370,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35912,6,'湖南省教师培训计划',371,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35913,6,'湖南省教师培训计划',372,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35914,6,'湖南省教师培训计划',373,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35915,6,'湖南省教师培训计划',374,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35916,6,'湖南省教师培训计划',375,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35917,6,'湖南省教师培训计划',376,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35918,6,'湖南省教师培训计划',377,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35919,6,'湖南省教师培训计划',378,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35920,6,'湖南省教师培训计划',379,'李玉',0);
INSERT INTO `edu_statistic_model` VALUES (35921,6,'湖南省教师培训计划',380,'杨明',0);
INSERT INTO `edu_statistic_model` VALUES (35922,6,'湖南省教师培训计划',381,'刘超',0);
INSERT INTO `edu_statistic_model` VALUES (35923,6,'湖南省教师培训计划',382,'王兴',0);
INSERT INTO `edu_statistic_model` VALUES (35924,6,'湖南省教师培训计划',383,'庞龙',0);
INSERT INTO `edu_statistic_model` VALUES (35925,6,'湖南省教师培训计划',384,'杨离伟',0);
INSERT INTO `edu_statistic_model` VALUES (35926,6,'湖南省教师培训计划',385,'小薛',0);
INSERT INTO `edu_statistic_model` VALUES (35927,6,'湖南省教师培训计划',386,'刘燕',0);
INSERT INTO `edu_statistic_model` VALUES (35928,6,'湖南省教师培训计划',387,'马丁',0);
INSERT INTO `edu_statistic_model` VALUES (35929,6,'湖南省教师培训计划',388,'王龙',0);
INSERT INTO `edu_statistic_model` VALUES (35930,6,'湖南省教师培训计划',389,'李赞',0);
INSERT INTO `edu_statistic_model` VALUES (35931,6,'湖南省教师培训计划',390,'王五',0);
INSERT INTO `edu_statistic_model` VALUES (35932,6,'湖南省教师培训计划',391,'李恒',0);
INSERT INTO `edu_statistic_model` VALUES (35933,6,'湖南省教师培训计划',392,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35934,6,'湖南省教师培训计划',393,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35935,6,'湖南省教师培训计划',394,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35936,6,'湖南省教师培训计划',395,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35937,6,'湖南省教师培训计划',396,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35938,6,'湖南省教师培训计划',397,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35939,6,'湖南省教师培训计划',398,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35940,6,'湖南省教师培训计划',399,'福建实施员',0);
INSERT INTO `edu_statistic_model` VALUES (35942,6,'湖南省教师培训计划',81,'黑龙江省的管理员1',0);
INSERT INTO `edu_statistic_model` VALUES (35943,6,'湖南省教师培训计划',82,'哈尔滨市的管理员',0);
INSERT INTO `edu_statistic_model` VALUES (35944,6,'湖南省教师培训计划',83,'阿城区的管理员',0);
INSERT INTO `edu_statistic_model` VALUES (35945,6,'湖南省教师培训计划',84,'学校管理员',0);
INSERT INTO `edu_statistic_model` VALUES (35946,6,'湖南省教师培训计划',85,'教师网管理员',0);
INSERT INTO `edu_statistic_model` VALUES (35947,6,'湖南省教师培训计划',86,'果实网管理员',0);
INSERT INTO `edu_statistic_model` VALUES (35948,6,'湖南省教师培训计划',87,'系统管理员',0);
INSERT INTO `edu_statistic_model` VALUES (35949,6,'湖南省教师培训计划',264,' 湖北管理员',0);
INSERT INTO `edu_statistic_model` VALUES (35950,6,'湖南省教师培训计划',265,'武汉admin',0);
INSERT INTO `edu_statistic_model` VALUES (35951,6,'湖南省教师培训计划',266,'李念',0);
INSERT INTO `edu_statistic_model` VALUES (35952,6,'湖南省教师培训计划',267,'王欢',0);
INSERT INTO `edu_statistic_model` VALUES (35953,6,'湖南省教师培训计划',268,'湖北承培一',0);
INSERT INTO `edu_statistic_model` VALUES (35954,6,'湖南省教师培训计划',269,'刘琦',0);
INSERT INTO `edu_statistic_model` VALUES (35955,6,'湖南省教师培训计划',270,'马骁',0);
INSERT INTO `edu_statistic_model` VALUES (35956,6,'湖南省教师培训计划',271,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35957,6,'湖南省教师培训计划',272,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35958,6,'湖南省教师培训计划',273,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35959,6,'湖南省教师培训计划',274,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35960,6,'湖南省教师培训计划',275,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35961,6,'湖南省教师培训计划',276,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35962,6,'湖南省教师培训计划',277,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35963,6,'湖南省教师培训计划',278,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35964,6,'湖南省教师培训计划',279,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35965,6,'湖南省教师培训计划',280,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35966,6,'湖南省教师培训计划',281,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35967,6,'湖南省教师培训计划',282,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35968,6,'湖南省教师培训计划',283,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35969,6,'湖南省教师培训计划',284,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35970,6,'湖南省教师培训计划',285,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35971,6,'湖南省教师培训计划',286,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35972,6,'湖南省教师培训计划',287,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35973,6,'湖南省教师培训计划',288,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35974,6,'湖南省教师培训计划',289,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35975,6,'湖南省教师培训计划',290,'夷陵区初中管理员',0);
INSERT INTO `edu_statistic_model` VALUES (35976,6,'湖南省教师培训计划',291,'武汉实施一',0);
INSERT INTO `edu_statistic_model` VALUES (35977,6,'湖南省教师培训计划',292,'武汉承培一',0);
INSERT INTO `edu_statistic_model` VALUES (35978,6,'湖南省教师培训计划',293,'王明',0);
INSERT INTO `edu_statistic_model` VALUES (35979,6,'湖南省教师培训计划',294,'王力',0);
INSERT INTO `edu_statistic_model` VALUES (35980,6,'湖南省教师培训计划',295,'赖长兴',0);
INSERT INTO `edu_statistic_model` VALUES (35981,6,'湖南省教师培训计划',296,'杨钰莹',0);
INSERT INTO `edu_statistic_model` VALUES (35982,6,'湖南省教师培训计划',297,'赖伟峰',0);
INSERT INTO `edu_statistic_model` VALUES (35983,6,'湖南省教师培训计划',298,'李亚',0);
INSERT INTO `edu_statistic_model` VALUES (35984,6,'湖南省教师培训计划',299,'李峰',0);
INSERT INTO `edu_statistic_model` VALUES (35985,6,'湖南省教师培训计划',300,'黄欢',0);
INSERT INTO `edu_statistic_model` VALUES (35986,6,'湖南省教师培训计划',301,'李梅',0);
INSERT INTO `edu_statistic_model` VALUES (35987,6,'湖南省教师培训计划',302,'王雷',0);
INSERT INTO `edu_statistic_model` VALUES (35988,6,'湖南省教师培训计划',303,'圆圆',0);
INSERT INTO `edu_statistic_model` VALUES (35989,6,'湖南省教师培训计划',304,'木子',0);
INSERT INTO `edu_statistic_model` VALUES (35990,6,'湖南省教师培训计划',305,' 李蕊',0);
INSERT INTO `edu_statistic_model` VALUES (35991,6,'湖南省教师培训计划',306,'李翠翠',0);
INSERT INTO `edu_statistic_model` VALUES (35992,6,'湖南省教师培训计划',307,'宋娟',0);
INSERT INTO `edu_statistic_model` VALUES (35993,6,'湖南省教师培训计划',308,'王颖',0);
INSERT INTO `edu_statistic_model` VALUES (35994,6,'湖南省教师培训计划',309,'刘伟',0);
INSERT INTO `edu_statistic_model` VALUES (35995,6,'湖南省教师培训计划',310,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35996,6,'湖南省教师培训计划',311,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35997,6,'湖南省教师培训计划',312,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35998,6,'湖南省教师培训计划',313,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (35999,6,'湖南省教师培训计划',314,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36000,6,'湖南省教师培训计划',315,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36001,6,'湖南省教师培训计划',316,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36002,6,'湖南省教师培训计划',317,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36003,6,'湖南省教师培训计划',318,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36004,6,'湖南省教师培训计划',319,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36005,6,'湖南省教师培训计划',320,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36006,6,'湖南省教师培训计划',321,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36007,6,'湖南省教师培训计划',322,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36008,6,'湖南省教师培训计划',323,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36009,6,'湖南省教师培训计划',324,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36010,6,'湖南省教师培训计划',325,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36011,6,'湖南省教师培训计划',326,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36012,6,'湖南省教师培训计划',327,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36013,6,'湖南省教师培训计划',328,'李明',0);
INSERT INTO `edu_statistic_model` VALUES (36014,6,'湖南省教师培训计划',329,'高力',0);
INSERT INTO `edu_statistic_model` VALUES (36015,6,'湖南省教师培训计划',330,'李长兴',0);
INSERT INTO `edu_statistic_model` VALUES (36016,6,'湖南省教师培训计划',331,'潘钰莹',0);
INSERT INTO `edu_statistic_model` VALUES (36017,6,'湖南省教师培训计划',332,'杨伟峰',0);
INSERT INTO `edu_statistic_model` VALUES (36018,6,'湖南省教师培训计划',333,'李亚平',0);
INSERT INTO `edu_statistic_model` VALUES (36019,6,'湖南省教师培训计划',334,'李韦伯',0);
INSERT INTO `edu_statistic_model` VALUES (36020,6,'湖南省教师培训计划',335,'黄雷',0);
INSERT INTO `edu_statistic_model` VALUES (36021,6,'湖南省教师培训计划',336,'李培',0);
INSERT INTO `edu_statistic_model` VALUES (36022,6,'湖南省教师培训计划',354,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36023,6,'湖南省教师培训计划',355,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36024,6,'湖南省教师培训计划',356,'刘梅',0);
INSERT INTO `edu_statistic_model` VALUES (36025,6,'湖南省教师培训计划',357,'王明',0);
INSERT INTO `edu_statistic_model` VALUES (36026,6,'湖南省教师培训计划',358,'王磊',0);
INSERT INTO `edu_statistic_model` VALUES (36027,6,'湖南省教师培训计划',359,'李群',0);
INSERT INTO `edu_statistic_model` VALUES (36028,6,'湖南省教师培训计划',360,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36029,6,'湖南省教师培训计划',361,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36030,6,'湖南省教师培训计划',362,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36031,6,'湖南省教师培训计划',363,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36032,6,'湖南省教师培训计划',364,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36033,6,'湖南省教师培训计划',365,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36034,6,'湖南省教师培训计划',366,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36035,6,'湖南省教师培训计划',367,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36036,6,'湖南省教师培训计划',368,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36037,6,'湖南省教师培训计划',369,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36038,6,'湖南省教师培训计划',370,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36039,6,'湖南省教师培训计划',371,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36040,6,'湖南省教师培训计划',372,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36041,6,'湖南省教师培训计划',373,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36042,6,'湖南省教师培训计划',374,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36043,6,'湖南省教师培训计划',375,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36044,6,'湖南省教师培训计划',376,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36045,6,'湖南省教师培训计划',377,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36046,6,'湖南省教师培训计划',378,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36047,6,'湖南省教师培训计划',379,'李玉',0);
INSERT INTO `edu_statistic_model` VALUES (36048,6,'湖南省教师培训计划',380,'杨明',0);
INSERT INTO `edu_statistic_model` VALUES (36049,6,'湖南省教师培训计划',381,'刘超',0);
INSERT INTO `edu_statistic_model` VALUES (36050,6,'湖南省教师培训计划',382,'王兴',0);
INSERT INTO `edu_statistic_model` VALUES (36051,6,'湖南省教师培训计划',383,'庞龙',0);
INSERT INTO `edu_statistic_model` VALUES (36052,6,'湖南省教师培训计划',384,'杨离伟',0);
INSERT INTO `edu_statistic_model` VALUES (36053,6,'湖南省教师培训计划',385,'小薛',0);
INSERT INTO `edu_statistic_model` VALUES (36054,6,'湖南省教师培训计划',386,'刘燕',0);
INSERT INTO `edu_statistic_model` VALUES (36055,6,'湖南省教师培训计划',387,'马丁',0);
INSERT INTO `edu_statistic_model` VALUES (36056,6,'湖南省教师培训计划',388,'王龙',0);
INSERT INTO `edu_statistic_model` VALUES (36057,6,'湖南省教师培训计划',389,'李赞',0);
INSERT INTO `edu_statistic_model` VALUES (36058,6,'湖南省教师培训计划',390,'王五',0);
INSERT INTO `edu_statistic_model` VALUES (36059,6,'湖南省教师培训计划',391,'李恒',0);
INSERT INTO `edu_statistic_model` VALUES (36060,6,'湖南省教师培训计划',392,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36061,6,'湖南省教师培训计划',393,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36062,6,'湖南省教师培训计划',394,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36063,6,'湖南省教师培训计划',395,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36064,6,'湖南省教师培训计划',396,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36065,6,'湖南省教师培训计划',397,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36066,6,'湖南省教师培训计划',398,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36067,6,'湖南省教师培训计划',399,'福建实施员',0);
INSERT INTO `edu_statistic_model` VALUES (36196,13,'福建板块一',81,'黑龙江省的管理员1',0);
INSERT INTO `edu_statistic_model` VALUES (36197,13,'福建板块一',82,'哈尔滨市的管理员',0);
INSERT INTO `edu_statistic_model` VALUES (36198,13,'福建板块一',83,'阿城区的管理员',0);
INSERT INTO `edu_statistic_model` VALUES (36199,13,'福建板块一',84,'学校管理员',0);
INSERT INTO `edu_statistic_model` VALUES (36200,13,'福建板块一',85,'教师网管理员',0);
INSERT INTO `edu_statistic_model` VALUES (36201,13,'福建板块一',86,'果实网管理员',0);
INSERT INTO `edu_statistic_model` VALUES (36202,13,'福建板块一',87,'系统管理员',0);
INSERT INTO `edu_statistic_model` VALUES (36203,13,'福建板块一',264,' 湖北管理员',0);
INSERT INTO `edu_statistic_model` VALUES (36204,13,'福建板块一',265,'武汉admin',0);
INSERT INTO `edu_statistic_model` VALUES (36205,13,'福建板块一',266,'李念',0);
INSERT INTO `edu_statistic_model` VALUES (36206,13,'福建板块一',267,'王欢',0);
INSERT INTO `edu_statistic_model` VALUES (36207,13,'福建板块一',268,'湖北承培一',0);
INSERT INTO `edu_statistic_model` VALUES (36208,13,'福建板块一',269,'刘琦',0);
INSERT INTO `edu_statistic_model` VALUES (36209,13,'福建板块一',270,'马骁',0);
INSERT INTO `edu_statistic_model` VALUES (36210,13,'福建板块一',271,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36211,13,'福建板块一',272,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36212,13,'福建板块一',273,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36213,13,'福建板块一',274,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36214,13,'福建板块一',275,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36215,13,'福建板块一',276,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36216,13,'福建板块一',277,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36217,13,'福建板块一',278,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36218,13,'福建板块一',279,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36219,13,'福建板块一',280,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36220,13,'福建板块一',281,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36221,13,'福建板块一',282,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36222,13,'福建板块一',283,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36223,13,'福建板块一',284,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36224,13,'福建板块一',285,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36225,13,'福建板块一',286,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36226,13,'福建板块一',287,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36227,13,'福建板块一',288,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36228,13,'福建板块一',289,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36229,13,'福建板块一',290,'夷陵区初中管理员',0);
INSERT INTO `edu_statistic_model` VALUES (36230,13,'福建板块一',291,'武汉实施一',0);
INSERT INTO `edu_statistic_model` VALUES (36231,13,'福建板块一',292,'武汉承培一',0);
INSERT INTO `edu_statistic_model` VALUES (36232,13,'福建板块一',293,'王明',0);
INSERT INTO `edu_statistic_model` VALUES (36233,13,'福建板块一',294,'王力',0);
INSERT INTO `edu_statistic_model` VALUES (36234,13,'福建板块一',295,'赖长兴',0);
INSERT INTO `edu_statistic_model` VALUES (36235,13,'福建板块一',296,'杨钰莹',0);
INSERT INTO `edu_statistic_model` VALUES (36236,13,'福建板块一',297,'赖伟峰',0);
INSERT INTO `edu_statistic_model` VALUES (36237,13,'福建板块一',298,'李亚',0);
INSERT INTO `edu_statistic_model` VALUES (36238,13,'福建板块一',299,'李峰',0);
INSERT INTO `edu_statistic_model` VALUES (36239,13,'福建板块一',300,'黄欢',0);
INSERT INTO `edu_statistic_model` VALUES (36240,13,'福建板块一',301,'李梅',0);
INSERT INTO `edu_statistic_model` VALUES (36241,13,'福建板块一',302,'王雷',0);
INSERT INTO `edu_statistic_model` VALUES (36242,13,'福建板块一',303,'圆圆',0);
INSERT INTO `edu_statistic_model` VALUES (36243,13,'福建板块一',304,'木子',0);
INSERT INTO `edu_statistic_model` VALUES (36244,13,'福建板块一',305,' 李蕊',0);
INSERT INTO `edu_statistic_model` VALUES (36245,13,'福建板块一',306,'李翠翠',0);
INSERT INTO `edu_statistic_model` VALUES (36246,13,'福建板块一',307,'宋娟',0);
INSERT INTO `edu_statistic_model` VALUES (36247,13,'福建板块一',308,'王颖',0);
INSERT INTO `edu_statistic_model` VALUES (36248,13,'福建板块一',309,'刘伟',0);
INSERT INTO `edu_statistic_model` VALUES (36249,13,'福建板块一',310,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36250,13,'福建板块一',311,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36251,13,'福建板块一',312,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36252,13,'福建板块一',313,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36253,13,'福建板块一',314,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36254,13,'福建板块一',315,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36255,13,'福建板块一',316,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36256,13,'福建板块一',317,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36257,13,'福建板块一',318,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36258,13,'福建板块一',319,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36259,13,'福建板块一',320,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36260,13,'福建板块一',321,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36261,13,'福建板块一',322,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36262,13,'福建板块一',323,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36263,13,'福建板块一',324,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36264,13,'福建板块一',325,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36265,13,'福建板块一',326,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36266,13,'福建板块一',327,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36267,13,'福建板块一',328,'李明',0);
INSERT INTO `edu_statistic_model` VALUES (36268,13,'福建板块一',329,'高力',0);
INSERT INTO `edu_statistic_model` VALUES (36269,13,'福建板块一',330,'李长兴',0);
INSERT INTO `edu_statistic_model` VALUES (36270,13,'福建板块一',331,'潘钰莹',0);
INSERT INTO `edu_statistic_model` VALUES (36271,13,'福建板块一',332,'杨伟峰',0);
INSERT INTO `edu_statistic_model` VALUES (36272,13,'福建板块一',333,'李亚平',0);
INSERT INTO `edu_statistic_model` VALUES (36273,13,'福建板块一',334,'李韦伯',0);
INSERT INTO `edu_statistic_model` VALUES (36274,13,'福建板块一',335,'黄雷',0);
INSERT INTO `edu_statistic_model` VALUES (36275,13,'福建板块一',336,'李培',0);
INSERT INTO `edu_statistic_model` VALUES (36276,13,'福建板块一',354,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36277,13,'福建板块一',355,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36278,13,'福建板块一',356,'刘梅',0);
INSERT INTO `edu_statistic_model` VALUES (36279,13,'福建板块一',357,'王明',0);
INSERT INTO `edu_statistic_model` VALUES (36280,13,'福建板块一',358,'王磊',0);
INSERT INTO `edu_statistic_model` VALUES (36281,13,'福建板块一',359,'李群',0);
INSERT INTO `edu_statistic_model` VALUES (36282,13,'福建板块一',360,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36283,13,'福建板块一',361,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36284,13,'福建板块一',362,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36285,13,'福建板块一',363,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36286,13,'福建板块一',364,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36287,13,'福建板块一',365,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36288,13,'福建板块一',366,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36289,13,'福建板块一',367,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36290,13,'福建板块一',368,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36291,13,'福建板块一',369,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36292,13,'福建板块一',370,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36293,13,'福建板块一',371,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36294,13,'福建板块一',372,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36295,13,'福建板块一',373,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36296,13,'福建板块一',374,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36297,13,'福建板块一',375,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36298,13,'福建板块一',376,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36299,13,'福建板块一',377,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36300,13,'福建板块一',378,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36301,13,'福建板块一',379,'李玉',0);
INSERT INTO `edu_statistic_model` VALUES (36302,13,'福建板块一',380,'杨明',0);
INSERT INTO `edu_statistic_model` VALUES (36303,13,'福建板块一',381,'刘超',0);
INSERT INTO `edu_statistic_model` VALUES (36304,13,'福建板块一',382,'王兴',0);
INSERT INTO `edu_statistic_model` VALUES (36305,13,'福建板块一',383,'庞龙',0);
INSERT INTO `edu_statistic_model` VALUES (36306,13,'福建板块一',384,'杨离伟',0);
INSERT INTO `edu_statistic_model` VALUES (36307,13,'福建板块一',385,'小薛',0);
INSERT INTO `edu_statistic_model` VALUES (36308,13,'福建板块一',386,'刘燕',0);
INSERT INTO `edu_statistic_model` VALUES (36309,13,'福建板块一',387,'马丁',0);
INSERT INTO `edu_statistic_model` VALUES (36310,13,'福建板块一',388,'王龙',0);
INSERT INTO `edu_statistic_model` VALUES (36311,13,'福建板块一',389,'李赞',0);
INSERT INTO `edu_statistic_model` VALUES (36312,13,'福建板块一',390,'王五',0);
INSERT INTO `edu_statistic_model` VALUES (36313,13,'福建板块一',391,'李恒',0);
INSERT INTO `edu_statistic_model` VALUES (36314,13,'福建板块一',392,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36315,13,'福建板块一',393,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36316,13,'福建板块一',394,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36317,13,'福建板块一',395,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36318,13,'福建板块一',396,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36319,13,'福建板块一',397,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36320,13,'福建板块一',398,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36321,13,'福建板块一',399,'福建实施员',0);
INSERT INTO `edu_statistic_model` VALUES (36450,12,'黑龙江国培2014年项目',81,'黑龙江省的管理员1',0);
INSERT INTO `edu_statistic_model` VALUES (36451,12,'黑龙江国培2014年项目',82,'哈尔滨市的管理员',0);
INSERT INTO `edu_statistic_model` VALUES (36452,12,'黑龙江国培2014年项目',83,'阿城区的管理员',0);
INSERT INTO `edu_statistic_model` VALUES (36453,12,'黑龙江国培2014年项目',84,'学校管理员',0);
INSERT INTO `edu_statistic_model` VALUES (36454,12,'黑龙江国培2014年项目',85,'教师网管理员',0);
INSERT INTO `edu_statistic_model` VALUES (36455,12,'黑龙江国培2014年项目',86,'果实网管理员',0);
INSERT INTO `edu_statistic_model` VALUES (36456,12,'黑龙江国培2014年项目',87,'系统管理员',0);
INSERT INTO `edu_statistic_model` VALUES (36457,12,'黑龙江国培2014年项目',264,' 湖北管理员',0);
INSERT INTO `edu_statistic_model` VALUES (36458,12,'黑龙江国培2014年项目',265,'武汉admin',0);
INSERT INTO `edu_statistic_model` VALUES (36459,12,'黑龙江国培2014年项目',266,'李念',0);
INSERT INTO `edu_statistic_model` VALUES (36460,12,'黑龙江国培2014年项目',267,'王欢',0);
INSERT INTO `edu_statistic_model` VALUES (36461,12,'黑龙江国培2014年项目',268,'湖北承培一',0);
INSERT INTO `edu_statistic_model` VALUES (36462,12,'黑龙江国培2014年项目',269,'刘琦',0);
INSERT INTO `edu_statistic_model` VALUES (36463,12,'黑龙江国培2014年项目',270,'马骁',0);
INSERT INTO `edu_statistic_model` VALUES (36464,12,'黑龙江国培2014年项目',271,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36465,12,'黑龙江国培2014年项目',272,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36466,12,'黑龙江国培2014年项目',273,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36467,12,'黑龙江国培2014年项目',274,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36468,12,'黑龙江国培2014年项目',275,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36469,12,'黑龙江国培2014年项目',276,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36470,12,'黑龙江国培2014年项目',277,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36471,12,'黑龙江国培2014年项目',278,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36472,12,'黑龙江国培2014年项目',279,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36473,12,'黑龙江国培2014年项目',280,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36474,12,'黑龙江国培2014年项目',281,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36475,12,'黑龙江国培2014年项目',282,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36476,12,'黑龙江国培2014年项目',283,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36477,12,'黑龙江国培2014年项目',284,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36478,12,'黑龙江国培2014年项目',285,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36479,12,'黑龙江国培2014年项目',286,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36480,12,'黑龙江国培2014年项目',287,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36481,12,'黑龙江国培2014年项目',288,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36482,12,'黑龙江国培2014年项目',289,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36483,12,'黑龙江国培2014年项目',290,'夷陵区初中管理员',0);
INSERT INTO `edu_statistic_model` VALUES (36484,12,'黑龙江国培2014年项目',291,'武汉实施一',0);
INSERT INTO `edu_statistic_model` VALUES (36485,12,'黑龙江国培2014年项目',292,'武汉承培一',0);
INSERT INTO `edu_statistic_model` VALUES (36486,12,'黑龙江国培2014年项目',293,'王明',0);
INSERT INTO `edu_statistic_model` VALUES (36487,12,'黑龙江国培2014年项目',294,'王力',0);
INSERT INTO `edu_statistic_model` VALUES (36488,12,'黑龙江国培2014年项目',295,'赖长兴',0);
INSERT INTO `edu_statistic_model` VALUES (36489,12,'黑龙江国培2014年项目',296,'杨钰莹',0);
INSERT INTO `edu_statistic_model` VALUES (36490,12,'黑龙江国培2014年项目',297,'赖伟峰',0);
INSERT INTO `edu_statistic_model` VALUES (36491,12,'黑龙江国培2014年项目',298,'李亚',0);
INSERT INTO `edu_statistic_model` VALUES (36492,12,'黑龙江国培2014年项目',299,'李峰',0);
INSERT INTO `edu_statistic_model` VALUES (36493,12,'黑龙江国培2014年项目',300,'黄欢',0);
INSERT INTO `edu_statistic_model` VALUES (36494,12,'黑龙江国培2014年项目',301,'李梅',0);
INSERT INTO `edu_statistic_model` VALUES (36495,12,'黑龙江国培2014年项目',302,'王雷',0);
INSERT INTO `edu_statistic_model` VALUES (36496,12,'黑龙江国培2014年项目',303,'圆圆',0);
INSERT INTO `edu_statistic_model` VALUES (36497,12,'黑龙江国培2014年项目',304,'木子',0);
INSERT INTO `edu_statistic_model` VALUES (36498,12,'黑龙江国培2014年项目',305,' 李蕊',0);
INSERT INTO `edu_statistic_model` VALUES (36499,12,'黑龙江国培2014年项目',306,'李翠翠',0);
INSERT INTO `edu_statistic_model` VALUES (36500,12,'黑龙江国培2014年项目',307,'宋娟',0);
INSERT INTO `edu_statistic_model` VALUES (36501,12,'黑龙江国培2014年项目',308,'王颖',0);
INSERT INTO `edu_statistic_model` VALUES (36502,12,'黑龙江国培2014年项目',309,'刘伟',0);
INSERT INTO `edu_statistic_model` VALUES (36503,12,'黑龙江国培2014年项目',310,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36504,12,'黑龙江国培2014年项目',311,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36505,12,'黑龙江国培2014年项目',312,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36506,12,'黑龙江国培2014年项目',313,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36507,12,'黑龙江国培2014年项目',314,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36508,12,'黑龙江国培2014年项目',315,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36509,12,'黑龙江国培2014年项目',316,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36510,12,'黑龙江国培2014年项目',317,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36511,12,'黑龙江国培2014年项目',318,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36512,12,'黑龙江国培2014年项目',319,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36513,12,'黑龙江国培2014年项目',320,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36514,12,'黑龙江国培2014年项目',321,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36515,12,'黑龙江国培2014年项目',322,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36516,12,'黑龙江国培2014年项目',323,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36517,12,'黑龙江国培2014年项目',324,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36518,12,'黑龙江国培2014年项目',325,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36519,12,'黑龙江国培2014年项目',326,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36520,12,'黑龙江国培2014年项目',327,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36521,12,'黑龙江国培2014年项目',328,'李明',0);
INSERT INTO `edu_statistic_model` VALUES (36522,12,'黑龙江国培2014年项目',329,'高力',0);
INSERT INTO `edu_statistic_model` VALUES (36523,12,'黑龙江国培2014年项目',330,'李长兴',0);
INSERT INTO `edu_statistic_model` VALUES (36524,12,'黑龙江国培2014年项目',331,'潘钰莹',0);
INSERT INTO `edu_statistic_model` VALUES (36525,12,'黑龙江国培2014年项目',332,'杨伟峰',0);
INSERT INTO `edu_statistic_model` VALUES (36526,12,'黑龙江国培2014年项目',333,'李亚平',0);
INSERT INTO `edu_statistic_model` VALUES (36527,12,'黑龙江国培2014年项目',334,'李韦伯',0);
INSERT INTO `edu_statistic_model` VALUES (36528,12,'黑龙江国培2014年项目',335,'黄雷',0);
INSERT INTO `edu_statistic_model` VALUES (36529,12,'黑龙江国培2014年项目',336,'李培',0);
INSERT INTO `edu_statistic_model` VALUES (36530,12,'黑龙江国培2014年项目',354,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36531,12,'黑龙江国培2014年项目',355,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36532,12,'黑龙江国培2014年项目',356,'刘梅',0);
INSERT INTO `edu_statistic_model` VALUES (36533,12,'黑龙江国培2014年项目',357,'王明',0);
INSERT INTO `edu_statistic_model` VALUES (36534,12,'黑龙江国培2014年项目',358,'王磊',0);
INSERT INTO `edu_statistic_model` VALUES (36535,12,'黑龙江国培2014年项目',359,'李群',0);
INSERT INTO `edu_statistic_model` VALUES (36536,12,'黑龙江国培2014年项目',360,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36537,12,'黑龙江国培2014年项目',361,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36538,12,'黑龙江国培2014年项目',362,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36539,12,'黑龙江国培2014年项目',363,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36540,12,'黑龙江国培2014年项目',364,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36541,12,'黑龙江国培2014年项目',365,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36542,12,'黑龙江国培2014年项目',366,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36543,12,'黑龙江国培2014年项目',367,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36544,12,'黑龙江国培2014年项目',368,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36545,12,'黑龙江国培2014年项目',369,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36546,12,'黑龙江国培2014年项目',370,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36547,12,'黑龙江国培2014年项目',371,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36548,12,'黑龙江国培2014年项目',372,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36549,12,'黑龙江国培2014年项目',373,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36550,12,'黑龙江国培2014年项目',374,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36551,12,'黑龙江国培2014年项目',375,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36552,12,'黑龙江国培2014年项目',376,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36553,12,'黑龙江国培2014年项目',377,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36554,12,'黑龙江国培2014年项目',378,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36555,12,'黑龙江国培2014年项目',379,'李玉',0);
INSERT INTO `edu_statistic_model` VALUES (36556,12,'黑龙江国培2014年项目',380,'杨明',0);
INSERT INTO `edu_statistic_model` VALUES (36557,12,'黑龙江国培2014年项目',381,'刘超',0);
INSERT INTO `edu_statistic_model` VALUES (36558,12,'黑龙江国培2014年项目',382,'王兴',0);
INSERT INTO `edu_statistic_model` VALUES (36559,12,'黑龙江国培2014年项目',383,'庞龙',0);
INSERT INTO `edu_statistic_model` VALUES (36560,12,'黑龙江国培2014年项目',384,'杨离伟',0);
INSERT INTO `edu_statistic_model` VALUES (36561,12,'黑龙江国培2014年项目',385,'小薛',0);
INSERT INTO `edu_statistic_model` VALUES (36562,12,'黑龙江国培2014年项目',386,'刘燕',0);
INSERT INTO `edu_statistic_model` VALUES (36563,12,'黑龙江国培2014年项目',387,'马丁',0);
INSERT INTO `edu_statistic_model` VALUES (36564,12,'黑龙江国培2014年项目',388,'王龙',0);
INSERT INTO `edu_statistic_model` VALUES (36565,12,'黑龙江国培2014年项目',389,'李赞',0);
INSERT INTO `edu_statistic_model` VALUES (36566,12,'黑龙江国培2014年项目',390,'王五',0);
INSERT INTO `edu_statistic_model` VALUES (36567,12,'黑龙江国培2014年项目',391,'李恒',0);
INSERT INTO `edu_statistic_model` VALUES (36568,12,'黑龙江国培2014年项目',392,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36569,12,'黑龙江国培2014年项目',393,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36570,12,'黑龙江国培2014年项目',394,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36571,12,'黑龙江国培2014年项目',395,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36572,12,'黑龙江国培2014年项目',396,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36573,12,'黑龙江国培2014年项目',397,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36574,12,'黑龙江国培2014年项目',398,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36575,12,'黑龙江国培2014年项目',399,'福建实施员',0);
INSERT INTO `edu_statistic_model` VALUES (36577,9,'测试版块',81,'黑龙江省的管理员1',0);
INSERT INTO `edu_statistic_model` VALUES (36578,9,'测试版块',82,'哈尔滨市的管理员',0);
INSERT INTO `edu_statistic_model` VALUES (36579,9,'测试版块',83,'阿城区的管理员',0);
INSERT INTO `edu_statistic_model` VALUES (36580,9,'测试版块',84,'学校管理员',0);
INSERT INTO `edu_statistic_model` VALUES (36581,9,'测试版块',85,'教师网管理员',0);
INSERT INTO `edu_statistic_model` VALUES (36582,9,'测试版块',86,'果实网管理员',0);
INSERT INTO `edu_statistic_model` VALUES (36583,9,'测试版块',87,'系统管理员',0);
INSERT INTO `edu_statistic_model` VALUES (36584,9,'测试版块',264,' 湖北管理员',0);
INSERT INTO `edu_statistic_model` VALUES (36585,9,'测试版块',265,'武汉admin',0);
INSERT INTO `edu_statistic_model` VALUES (36586,9,'测试版块',266,'李念',0);
INSERT INTO `edu_statistic_model` VALUES (36587,9,'测试版块',267,'王欢',0);
INSERT INTO `edu_statistic_model` VALUES (36588,9,'测试版块',268,'湖北承培一',0);
INSERT INTO `edu_statistic_model` VALUES (36589,9,'测试版块',269,'刘琦',0);
INSERT INTO `edu_statistic_model` VALUES (36590,9,'测试版块',270,'马骁',0);
INSERT INTO `edu_statistic_model` VALUES (36591,9,'测试版块',271,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36592,9,'测试版块',272,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36593,9,'测试版块',273,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36594,9,'测试版块',274,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36595,9,'测试版块',275,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36596,9,'测试版块',276,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36597,9,'测试版块',277,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36598,9,'测试版块',278,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36599,9,'测试版块',279,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36600,9,'测试版块',280,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36601,9,'测试版块',281,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36602,9,'测试版块',282,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36603,9,'测试版块',283,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36604,9,'测试版块',284,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36605,9,'测试版块',285,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36606,9,'测试版块',286,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36607,9,'测试版块',287,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36608,9,'测试版块',288,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36609,9,'测试版块',289,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36610,9,'测试版块',290,'夷陵区初中管理员',0);
INSERT INTO `edu_statistic_model` VALUES (36611,9,'测试版块',291,'武汉实施一',0);
INSERT INTO `edu_statistic_model` VALUES (36612,9,'测试版块',292,'武汉承培一',0);
INSERT INTO `edu_statistic_model` VALUES (36613,9,'测试版块',293,'王明',0);
INSERT INTO `edu_statistic_model` VALUES (36614,9,'测试版块',294,'王力',0);
INSERT INTO `edu_statistic_model` VALUES (36615,9,'测试版块',295,'赖长兴',0);
INSERT INTO `edu_statistic_model` VALUES (36616,9,'测试版块',296,'杨钰莹',0);
INSERT INTO `edu_statistic_model` VALUES (36617,9,'测试版块',297,'赖伟峰',0);
INSERT INTO `edu_statistic_model` VALUES (36618,9,'测试版块',298,'李亚',0);
INSERT INTO `edu_statistic_model` VALUES (36619,9,'测试版块',299,'李峰',0);
INSERT INTO `edu_statistic_model` VALUES (36620,9,'测试版块',300,'黄欢',0);
INSERT INTO `edu_statistic_model` VALUES (36621,9,'测试版块',301,'李梅',0);
INSERT INTO `edu_statistic_model` VALUES (36622,9,'测试版块',302,'王雷',0);
INSERT INTO `edu_statistic_model` VALUES (36623,9,'测试版块',303,'圆圆',0);
INSERT INTO `edu_statistic_model` VALUES (36624,9,'测试版块',304,'木子',0);
INSERT INTO `edu_statistic_model` VALUES (36625,9,'测试版块',305,' 李蕊',0);
INSERT INTO `edu_statistic_model` VALUES (36626,9,'测试版块',306,'李翠翠',0);
INSERT INTO `edu_statistic_model` VALUES (36627,9,'测试版块',307,'宋娟',0);
INSERT INTO `edu_statistic_model` VALUES (36628,9,'测试版块',308,'王颖',0);
INSERT INTO `edu_statistic_model` VALUES (36629,9,'测试版块',309,'刘伟',0);
INSERT INTO `edu_statistic_model` VALUES (36630,9,'测试版块',310,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36631,9,'测试版块',311,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36632,9,'测试版块',312,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36633,9,'测试版块',313,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36634,9,'测试版块',314,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36635,9,'测试版块',315,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36636,9,'测试版块',316,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36637,9,'测试版块',317,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36638,9,'测试版块',318,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36639,9,'测试版块',319,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36640,9,'测试版块',320,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36641,9,'测试版块',321,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36642,9,'测试版块',322,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36643,9,'测试版块',323,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36644,9,'测试版块',324,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36645,9,'测试版块',325,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36646,9,'测试版块',326,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36647,9,'测试版块',327,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36648,9,'测试版块',328,'李明',0);
INSERT INTO `edu_statistic_model` VALUES (36649,9,'测试版块',329,'高力',0);
INSERT INTO `edu_statistic_model` VALUES (36650,9,'测试版块',330,'李长兴',0);
INSERT INTO `edu_statistic_model` VALUES (36651,9,'测试版块',331,'潘钰莹',0);
INSERT INTO `edu_statistic_model` VALUES (36652,9,'测试版块',332,'杨伟峰',0);
INSERT INTO `edu_statistic_model` VALUES (36653,9,'测试版块',333,'李亚平',0);
INSERT INTO `edu_statistic_model` VALUES (36654,9,'测试版块',334,'李韦伯',0);
INSERT INTO `edu_statistic_model` VALUES (36655,9,'测试版块',335,'黄雷',0);
INSERT INTO `edu_statistic_model` VALUES (36656,9,'测试版块',336,'李培',0);
INSERT INTO `edu_statistic_model` VALUES (36657,9,'测试版块',354,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36658,9,'测试版块',355,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36659,9,'测试版块',356,'刘梅',0);
INSERT INTO `edu_statistic_model` VALUES (36660,9,'测试版块',357,'王明',0);
INSERT INTO `edu_statistic_model` VALUES (36661,9,'测试版块',358,'王磊',0);
INSERT INTO `edu_statistic_model` VALUES (36662,9,'测试版块',359,'李群',0);
INSERT INTO `edu_statistic_model` VALUES (36663,9,'测试版块',360,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36664,9,'测试版块',361,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36665,9,'测试版块',362,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36666,9,'测试版块',363,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36667,9,'测试版块',364,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36668,9,'测试版块',365,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36669,9,'测试版块',366,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36670,9,'测试版块',367,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36671,9,'测试版块',368,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36672,9,'测试版块',369,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36673,9,'测试版块',370,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36674,9,'测试版块',371,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36675,9,'测试版块',372,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36676,9,'测试版块',373,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36677,9,'测试版块',374,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36678,9,'测试版块',375,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36679,9,'测试版块',376,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36680,9,'测试版块',377,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36681,9,'测试版块',378,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36682,9,'测试版块',379,'李玉',0);
INSERT INTO `edu_statistic_model` VALUES (36683,9,'测试版块',380,'杨明',0);
INSERT INTO `edu_statistic_model` VALUES (36684,9,'测试版块',381,'刘超',0);
INSERT INTO `edu_statistic_model` VALUES (36685,9,'测试版块',382,'王兴',0);
INSERT INTO `edu_statistic_model` VALUES (36686,9,'测试版块',383,'庞龙',0);
INSERT INTO `edu_statistic_model` VALUES (36687,9,'测试版块',384,'杨离伟',0);
INSERT INTO `edu_statistic_model` VALUES (36688,9,'测试版块',385,'小薛',0);
INSERT INTO `edu_statistic_model` VALUES (36689,9,'测试版块',386,'刘燕',0);
INSERT INTO `edu_statistic_model` VALUES (36690,9,'测试版块',387,'马丁',0);
INSERT INTO `edu_statistic_model` VALUES (36691,9,'测试版块',388,'王龙',0);
INSERT INTO `edu_statistic_model` VALUES (36692,9,'测试版块',389,'李赞',0);
INSERT INTO `edu_statistic_model` VALUES (36693,9,'测试版块',390,'王五',0);
INSERT INTO `edu_statistic_model` VALUES (36694,9,'测试版块',391,'李恒',0);
INSERT INTO `edu_statistic_model` VALUES (36695,9,'测试版块',392,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36696,9,'测试版块',393,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36697,9,'测试版块',394,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36698,9,'测试版块',395,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36699,9,'测试版块',396,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36700,9,'测试版块',397,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36701,9,'测试版块',398,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36702,9,'测试版块',399,'福建实施员',0);
INSERT INTO `edu_statistic_model` VALUES (36704,9,'测试版块',81,'黑龙江省的管理员1',0);
INSERT INTO `edu_statistic_model` VALUES (36705,9,'测试版块',82,'哈尔滨市的管理员',0);
INSERT INTO `edu_statistic_model` VALUES (36706,9,'测试版块',83,'阿城区的管理员',0);
INSERT INTO `edu_statistic_model` VALUES (36707,9,'测试版块',84,'学校管理员',0);
INSERT INTO `edu_statistic_model` VALUES (36708,9,'测试版块',85,'教师网管理员',0);
INSERT INTO `edu_statistic_model` VALUES (36709,9,'测试版块',86,'果实网管理员',0);
INSERT INTO `edu_statistic_model` VALUES (36710,9,'测试版块',87,'系统管理员',0);
INSERT INTO `edu_statistic_model` VALUES (36711,9,'测试版块',264,' 湖北管理员',0);
INSERT INTO `edu_statistic_model` VALUES (36712,9,'测试版块',265,'武汉admin',0);
INSERT INTO `edu_statistic_model` VALUES (36713,9,'测试版块',266,'李念',0);
INSERT INTO `edu_statistic_model` VALUES (36714,9,'测试版块',267,'王欢',0);
INSERT INTO `edu_statistic_model` VALUES (36715,9,'测试版块',268,'湖北承培一',0);
INSERT INTO `edu_statistic_model` VALUES (36716,9,'测试版块',269,'刘琦',0);
INSERT INTO `edu_statistic_model` VALUES (36717,9,'测试版块',270,'马骁',0);
INSERT INTO `edu_statistic_model` VALUES (36718,9,'测试版块',271,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36719,9,'测试版块',272,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36720,9,'测试版块',273,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36721,9,'测试版块',274,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36722,9,'测试版块',275,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36723,9,'测试版块',276,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36724,9,'测试版块',277,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36725,9,'测试版块',278,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36726,9,'测试版块',279,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36727,9,'测试版块',280,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36728,9,'测试版块',281,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36729,9,'测试版块',282,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36730,9,'测试版块',283,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36731,9,'测试版块',284,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36732,9,'测试版块',285,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36733,9,'测试版块',286,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36734,9,'测试版块',287,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36735,9,'测试版块',288,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36736,9,'测试版块',289,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36737,9,'测试版块',290,'夷陵区初中管理员',0);
INSERT INTO `edu_statistic_model` VALUES (36738,9,'测试版块',291,'武汉实施一',0);
INSERT INTO `edu_statistic_model` VALUES (36739,9,'测试版块',292,'武汉承培一',0);
INSERT INTO `edu_statistic_model` VALUES (36740,9,'测试版块',293,'王明',0);
INSERT INTO `edu_statistic_model` VALUES (36741,9,'测试版块',294,'王力',0);
INSERT INTO `edu_statistic_model` VALUES (36742,9,'测试版块',295,'赖长兴',0);
INSERT INTO `edu_statistic_model` VALUES (36743,9,'测试版块',296,'杨钰莹',0);
INSERT INTO `edu_statistic_model` VALUES (36744,9,'测试版块',297,'赖伟峰',0);
INSERT INTO `edu_statistic_model` VALUES (36745,9,'测试版块',298,'李亚',0);
INSERT INTO `edu_statistic_model` VALUES (36746,9,'测试版块',299,'李峰',0);
INSERT INTO `edu_statistic_model` VALUES (36747,9,'测试版块',300,'黄欢',0);
INSERT INTO `edu_statistic_model` VALUES (36748,9,'测试版块',301,'李梅',0);
INSERT INTO `edu_statistic_model` VALUES (36749,9,'测试版块',302,'王雷',0);
INSERT INTO `edu_statistic_model` VALUES (36750,9,'测试版块',303,'圆圆',0);
INSERT INTO `edu_statistic_model` VALUES (36751,9,'测试版块',304,'木子',0);
INSERT INTO `edu_statistic_model` VALUES (36752,9,'测试版块',305,' 李蕊',0);
INSERT INTO `edu_statistic_model` VALUES (36753,9,'测试版块',306,'李翠翠',0);
INSERT INTO `edu_statistic_model` VALUES (36754,9,'测试版块',307,'宋娟',0);
INSERT INTO `edu_statistic_model` VALUES (36755,9,'测试版块',308,'王颖',0);
INSERT INTO `edu_statistic_model` VALUES (36756,9,'测试版块',309,'刘伟',0);
INSERT INTO `edu_statistic_model` VALUES (36757,9,'测试版块',310,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36758,9,'测试版块',311,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36759,9,'测试版块',312,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36760,9,'测试版块',313,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36761,9,'测试版块',314,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36762,9,'测试版块',315,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36763,9,'测试版块',316,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36764,9,'测试版块',317,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36765,9,'测试版块',318,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36766,9,'测试版块',319,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36767,9,'测试版块',320,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36768,9,'测试版块',321,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36769,9,'测试版块',322,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36770,9,'测试版块',323,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36771,9,'测试版块',324,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36772,9,'测试版块',325,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36773,9,'测试版块',326,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36774,9,'测试版块',327,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36775,9,'测试版块',328,'李明',0);
INSERT INTO `edu_statistic_model` VALUES (36776,9,'测试版块',329,'高力',0);
INSERT INTO `edu_statistic_model` VALUES (36777,9,'测试版块',330,'李长兴',0);
INSERT INTO `edu_statistic_model` VALUES (36778,9,'测试版块',331,'潘钰莹',0);
INSERT INTO `edu_statistic_model` VALUES (36779,9,'测试版块',332,'杨伟峰',0);
INSERT INTO `edu_statistic_model` VALUES (36780,9,'测试版块',333,'李亚平',0);
INSERT INTO `edu_statistic_model` VALUES (36781,9,'测试版块',334,'李韦伯',0);
INSERT INTO `edu_statistic_model` VALUES (36782,9,'测试版块',335,'黄雷',0);
INSERT INTO `edu_statistic_model` VALUES (36783,9,'测试版块',336,'李培',0);
INSERT INTO `edu_statistic_model` VALUES (36784,9,'测试版块',354,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36785,9,'测试版块',355,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36786,9,'测试版块',356,'刘梅',0);
INSERT INTO `edu_statistic_model` VALUES (36787,9,'测试版块',357,'王明',0);
INSERT INTO `edu_statistic_model` VALUES (36788,9,'测试版块',358,'王磊',0);
INSERT INTO `edu_statistic_model` VALUES (36789,9,'测试版块',359,'李群',0);
INSERT INTO `edu_statistic_model` VALUES (36790,9,'测试版块',360,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36791,9,'测试版块',361,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36792,9,'测试版块',362,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36793,9,'测试版块',363,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36794,9,'测试版块',364,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36795,9,'测试版块',365,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36796,9,'测试版块',366,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36797,9,'测试版块',367,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36798,9,'测试版块',368,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36799,9,'测试版块',369,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36800,9,'测试版块',370,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36801,9,'测试版块',371,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36802,9,'测试版块',372,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36803,9,'测试版块',373,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36804,9,'测试版块',374,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36805,9,'测试版块',375,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36806,9,'测试版块',376,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36807,9,'测试版块',377,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36808,9,'测试版块',378,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36809,9,'测试版块',379,'李玉',0);
INSERT INTO `edu_statistic_model` VALUES (36810,9,'测试版块',380,'杨明',0);
INSERT INTO `edu_statistic_model` VALUES (36811,9,'测试版块',381,'刘超',0);
INSERT INTO `edu_statistic_model` VALUES (36812,9,'测试版块',382,'王兴',0);
INSERT INTO `edu_statistic_model` VALUES (36813,9,'测试版块',383,'庞龙',0);
INSERT INTO `edu_statistic_model` VALUES (36814,9,'测试版块',384,'杨离伟',0);
INSERT INTO `edu_statistic_model` VALUES (36815,9,'测试版块',385,'小薛',0);
INSERT INTO `edu_statistic_model` VALUES (36816,9,'测试版块',386,'刘燕',0);
INSERT INTO `edu_statistic_model` VALUES (36817,9,'测试版块',387,'马丁',0);
INSERT INTO `edu_statistic_model` VALUES (36818,9,'测试版块',388,'王龙',0);
INSERT INTO `edu_statistic_model` VALUES (36819,9,'测试版块',389,'李赞',0);
INSERT INTO `edu_statistic_model` VALUES (36820,9,'测试版块',390,'王五',0);
INSERT INTO `edu_statistic_model` VALUES (36821,9,'测试版块',391,'李恒',0);
INSERT INTO `edu_statistic_model` VALUES (36822,9,'测试版块',392,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36823,9,'测试版块',393,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36824,9,'测试版块',394,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36825,9,'测试版块',395,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36826,9,'测试版块',396,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36827,9,'测试版块',397,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36828,9,'测试版块',398,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36829,9,'测试版块',399,'福建实施员',0);
INSERT INTO `edu_statistic_model` VALUES (36958,10,'实施机构项目',81,'黑龙江省的管理员1',0);
INSERT INTO `edu_statistic_model` VALUES (36959,10,'实施机构项目',82,'哈尔滨市的管理员',0);
INSERT INTO `edu_statistic_model` VALUES (36960,10,'实施机构项目',83,'阿城区的管理员',0);
INSERT INTO `edu_statistic_model` VALUES (36961,10,'实施机构项目',84,'学校管理员',0);
INSERT INTO `edu_statistic_model` VALUES (36962,10,'实施机构项目',85,'教师网管理员',0);
INSERT INTO `edu_statistic_model` VALUES (36963,10,'实施机构项目',86,'果实网管理员',0);
INSERT INTO `edu_statistic_model` VALUES (36964,10,'实施机构项目',87,'系统管理员',0);
INSERT INTO `edu_statistic_model` VALUES (36965,10,'实施机构项目',264,' 湖北管理员',0);
INSERT INTO `edu_statistic_model` VALUES (36966,10,'实施机构项目',265,'武汉admin',0);
INSERT INTO `edu_statistic_model` VALUES (36967,10,'实施机构项目',266,'李念',0);
INSERT INTO `edu_statistic_model` VALUES (36968,10,'实施机构项目',267,'王欢',0);
INSERT INTO `edu_statistic_model` VALUES (36969,10,'实施机构项目',268,'湖北承培一',0);
INSERT INTO `edu_statistic_model` VALUES (36970,10,'实施机构项目',269,'刘琦',0);
INSERT INTO `edu_statistic_model` VALUES (36971,10,'实施机构项目',270,'马骁',0);
INSERT INTO `edu_statistic_model` VALUES (36972,10,'实施机构项目',271,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36973,10,'实施机构项目',272,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36974,10,'实施机构项目',273,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36975,10,'实施机构项目',274,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36976,10,'实施机构项目',275,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36977,10,'实施机构项目',276,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36978,10,'实施机构项目',277,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36979,10,'实施机构项目',278,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36980,10,'实施机构项目',279,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36981,10,'实施机构项目',280,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36982,10,'实施机构项目',281,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36983,10,'实施机构项目',282,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36984,10,'实施机构项目',283,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36985,10,'实施机构项目',284,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36986,10,'实施机构项目',285,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36987,10,'实施机构项目',286,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36988,10,'实施机构项目',287,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36989,10,'实施机构项目',288,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36990,10,'实施机构项目',289,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (36991,10,'实施机构项目',290,'夷陵区初中管理员',0);
INSERT INTO `edu_statistic_model` VALUES (36992,10,'实施机构项目',291,'武汉实施一',0);
INSERT INTO `edu_statistic_model` VALUES (36993,10,'实施机构项目',292,'武汉承培一',0);
INSERT INTO `edu_statistic_model` VALUES (36994,10,'实施机构项目',293,'王明',0);
INSERT INTO `edu_statistic_model` VALUES (36995,10,'实施机构项目',294,'王力',0);
INSERT INTO `edu_statistic_model` VALUES (36996,10,'实施机构项目',295,'赖长兴',0);
INSERT INTO `edu_statistic_model` VALUES (36997,10,'实施机构项目',296,'杨钰莹',0);
INSERT INTO `edu_statistic_model` VALUES (36998,10,'实施机构项目',297,'赖伟峰',0);
INSERT INTO `edu_statistic_model` VALUES (36999,10,'实施机构项目',298,'李亚',0);
INSERT INTO `edu_statistic_model` VALUES (37000,10,'实施机构项目',299,'李峰',0);
INSERT INTO `edu_statistic_model` VALUES (37001,10,'实施机构项目',300,'黄欢',0);
INSERT INTO `edu_statistic_model` VALUES (37002,10,'实施机构项目',301,'李梅',0);
INSERT INTO `edu_statistic_model` VALUES (37003,10,'实施机构项目',302,'王雷',0);
INSERT INTO `edu_statistic_model` VALUES (37004,10,'实施机构项目',303,'圆圆',0);
INSERT INTO `edu_statistic_model` VALUES (37005,10,'实施机构项目',304,'木子',0);
INSERT INTO `edu_statistic_model` VALUES (37006,10,'实施机构项目',305,' 李蕊',0);
INSERT INTO `edu_statistic_model` VALUES (37007,10,'实施机构项目',306,'李翠翠',0);
INSERT INTO `edu_statistic_model` VALUES (37008,10,'实施机构项目',307,'宋娟',0);
INSERT INTO `edu_statistic_model` VALUES (37009,10,'实施机构项目',308,'王颖',0);
INSERT INTO `edu_statistic_model` VALUES (37010,10,'实施机构项目',309,'刘伟',0);
INSERT INTO `edu_statistic_model` VALUES (37011,10,'实施机构项目',310,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (37012,10,'实施机构项目',311,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (37013,10,'实施机构项目',312,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (37014,10,'实施机构项目',313,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (37015,10,'实施机构项目',314,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (37016,10,'实施机构项目',315,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (37017,10,'实施机构项目',316,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (37018,10,'实施机构项目',317,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (37019,10,'实施机构项目',318,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (37020,10,'实施机构项目',319,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (37021,10,'实施机构项目',320,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (37022,10,'实施机构项目',321,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (37023,10,'实施机构项目',322,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (37024,10,'实施机构项目',323,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (37025,10,'实施机构项目',324,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (37026,10,'实施机构项目',325,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (37027,10,'实施机构项目',326,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (37028,10,'实施机构项目',327,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (37029,10,'实施机构项目',328,'李明',0);
INSERT INTO `edu_statistic_model` VALUES (37030,10,'实施机构项目',329,'高力',0);
INSERT INTO `edu_statistic_model` VALUES (37031,10,'实施机构项目',330,'李长兴',0);
INSERT INTO `edu_statistic_model` VALUES (37032,10,'实施机构项目',331,'潘钰莹',0);
INSERT INTO `edu_statistic_model` VALUES (37033,10,'实施机构项目',332,'杨伟峰',0);
INSERT INTO `edu_statistic_model` VALUES (37034,10,'实施机构项目',333,'李亚平',0);
INSERT INTO `edu_statistic_model` VALUES (37035,10,'实施机构项目',334,'李韦伯',0);
INSERT INTO `edu_statistic_model` VALUES (37036,10,'实施机构项目',335,'黄雷',0);
INSERT INTO `edu_statistic_model` VALUES (37037,10,'实施机构项目',336,'李培',0);
INSERT INTO `edu_statistic_model` VALUES (37038,10,'实施机构项目',354,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (37039,10,'实施机构项目',355,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (37040,10,'实施机构项目',356,'刘梅',0);
INSERT INTO `edu_statistic_model` VALUES (37041,10,'实施机构项目',357,'王明',0);
INSERT INTO `edu_statistic_model` VALUES (37042,10,'实施机构项目',358,'王磊',0);
INSERT INTO `edu_statistic_model` VALUES (37043,10,'实施机构项目',359,'李群',0);
INSERT INTO `edu_statistic_model` VALUES (37044,10,'实施机构项目',360,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (37045,10,'实施机构项目',361,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (37046,10,'实施机构项目',362,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (37047,10,'实施机构项目',363,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (37048,10,'实施机构项目',364,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (37049,10,'实施机构项目',365,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (37050,10,'实施机构项目',366,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (37051,10,'实施机构项目',367,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (37052,10,'实施机构项目',368,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (37053,10,'实施机构项目',369,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (37054,10,'实施机构项目',370,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (37055,10,'实施机构项目',371,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (37056,10,'实施机构项目',372,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (37057,10,'实施机构项目',373,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (37058,10,'实施机构项目',374,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (37059,10,'实施机构项目',375,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (37060,10,'实施机构项目',376,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (37061,10,'实施机构项目',377,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (37062,10,'实施机构项目',378,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (37063,10,'实施机构项目',379,'李玉',0);
INSERT INTO `edu_statistic_model` VALUES (37064,10,'实施机构项目',380,'杨明',0);
INSERT INTO `edu_statistic_model` VALUES (37065,10,'实施机构项目',381,'刘超',0);
INSERT INTO `edu_statistic_model` VALUES (37066,10,'实施机构项目',382,'王兴',0);
INSERT INTO `edu_statistic_model` VALUES (37067,10,'实施机构项目',383,'庞龙',0);
INSERT INTO `edu_statistic_model` VALUES (37068,10,'实施机构项目',384,'杨离伟',0);
INSERT INTO `edu_statistic_model` VALUES (37069,10,'实施机构项目',385,'小薛',0);
INSERT INTO `edu_statistic_model` VALUES (37070,10,'实施机构项目',386,'刘燕',0);
INSERT INTO `edu_statistic_model` VALUES (37071,10,'实施机构项目',387,'马丁',0);
INSERT INTO `edu_statistic_model` VALUES (37072,10,'实施机构项目',388,'王龙',0);
INSERT INTO `edu_statistic_model` VALUES (37073,10,'实施机构项目',389,'李赞',0);
INSERT INTO `edu_statistic_model` VALUES (37074,10,'实施机构项目',390,'王五',0);
INSERT INTO `edu_statistic_model` VALUES (37075,10,'实施机构项目',391,'李恒',0);
INSERT INTO `edu_statistic_model` VALUES (37076,10,'实施机构项目',392,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (37077,10,'实施机构项目',393,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (37078,10,'实施机构项目',394,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (37079,10,'实施机构项目',395,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (37080,10,'实施机构项目',396,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (37081,10,'实施机构项目',397,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (37082,10,'实施机构项目',398,'admin',0);
INSERT INTO `edu_statistic_model` VALUES (37083,10,'实施机构项目',399,'福建实施员',0);
/*!40000 ALTER TABLE `edu_statistic_model` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table edu_statistic_year
#

CREATE TABLE `edu_statistic_year` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `year` varchar(4) DEFAULT NULL COMMENT '年度',
  `teacher_id` int(11) DEFAULT NULL COMMENT '教师ID',
  `teacher_name` varchar(100) DEFAULT NULL COMMENT '教师姓名',
  `teacher_score` float DEFAULT NULL COMMENT '总学分,汇总年度下所有项目的学分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7748 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
INSERT INTO `edu_statistic_year` VALUES (7367,'2014',81,'黑龙江省的管理员1',0);
INSERT INTO `edu_statistic_year` VALUES (7368,'2014',82,'哈尔滨市的管理员',0);
INSERT INTO `edu_statistic_year` VALUES (7369,'2014',83,'阿城区的管理员',0);
INSERT INTO `edu_statistic_year` VALUES (7370,'2014',84,'学校管理员',0);
INSERT INTO `edu_statistic_year` VALUES (7371,'2014',85,'教师网管理员',0);
INSERT INTO `edu_statistic_year` VALUES (7372,'2014',86,'果实网管理员',0);
INSERT INTO `edu_statistic_year` VALUES (7373,'2014',87,'系统管理员',0);
INSERT INTO `edu_statistic_year` VALUES (7374,'2014',264,' 湖北管理员',0);
INSERT INTO `edu_statistic_year` VALUES (7375,'2014',265,'武汉admin',0);
INSERT INTO `edu_statistic_year` VALUES (7376,'2014',266,'李念',0);
INSERT INTO `edu_statistic_year` VALUES (7377,'2014',267,'王欢',0);
INSERT INTO `edu_statistic_year` VALUES (7378,'2014',268,'湖北承培一',0);
INSERT INTO `edu_statistic_year` VALUES (7379,'2014',269,'刘琦',0);
INSERT INTO `edu_statistic_year` VALUES (7380,'2014',270,'马骁',0);
INSERT INTO `edu_statistic_year` VALUES (7381,'2014',271,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7382,'2014',272,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7383,'2014',273,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7384,'2014',274,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7385,'2014',275,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7386,'2014',276,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7387,'2014',277,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7388,'2014',278,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7389,'2014',279,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7390,'2014',280,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7391,'2014',281,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7392,'2014',282,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7393,'2014',283,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7394,'2014',284,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7395,'2014',285,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7396,'2014',286,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7397,'2014',287,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7398,'2014',288,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7399,'2014',289,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7400,'2014',290,'夷陵区初中管理员',0);
INSERT INTO `edu_statistic_year` VALUES (7401,'2014',291,'武汉实施一',0);
INSERT INTO `edu_statistic_year` VALUES (7402,'2014',292,'武汉承培一',0);
INSERT INTO `edu_statistic_year` VALUES (7403,'2014',293,'王明',0);
INSERT INTO `edu_statistic_year` VALUES (7404,'2014',294,'王力',0);
INSERT INTO `edu_statistic_year` VALUES (7405,'2014',295,'赖长兴',0);
INSERT INTO `edu_statistic_year` VALUES (7406,'2014',296,'杨钰莹',0);
INSERT INTO `edu_statistic_year` VALUES (7407,'2014',297,'赖伟峰',0);
INSERT INTO `edu_statistic_year` VALUES (7408,'2014',298,'李亚',0);
INSERT INTO `edu_statistic_year` VALUES (7409,'2014',299,'李峰',0);
INSERT INTO `edu_statistic_year` VALUES (7410,'2014',300,'黄欢',0);
INSERT INTO `edu_statistic_year` VALUES (7411,'2014',301,'李梅',0);
INSERT INTO `edu_statistic_year` VALUES (7412,'2014',302,'王雷',0);
INSERT INTO `edu_statistic_year` VALUES (7413,'2014',303,'圆圆',0);
INSERT INTO `edu_statistic_year` VALUES (7414,'2014',304,'木子',0);
INSERT INTO `edu_statistic_year` VALUES (7415,'2014',305,' 李蕊',0);
INSERT INTO `edu_statistic_year` VALUES (7416,'2014',306,'李翠翠',0);
INSERT INTO `edu_statistic_year` VALUES (7417,'2014',307,'宋娟',0);
INSERT INTO `edu_statistic_year` VALUES (7418,'2014',308,'王颖',0);
INSERT INTO `edu_statistic_year` VALUES (7419,'2014',309,'刘伟',0);
INSERT INTO `edu_statistic_year` VALUES (7420,'2014',310,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7421,'2014',311,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7422,'2014',312,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7423,'2014',313,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7424,'2014',314,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7425,'2014',315,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7426,'2014',316,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7427,'2014',317,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7428,'2014',318,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7429,'2014',319,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7430,'2014',320,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7431,'2014',321,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7432,'2014',322,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7433,'2014',323,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7434,'2014',324,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7435,'2014',325,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7436,'2014',326,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7437,'2014',327,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7438,'2014',328,'李明',5);
INSERT INTO `edu_statistic_year` VALUES (7439,'2014',329,'高力',0);
INSERT INTO `edu_statistic_year` VALUES (7440,'2014',330,'李长兴',6);
INSERT INTO `edu_statistic_year` VALUES (7441,'2014',331,'潘钰莹',0);
INSERT INTO `edu_statistic_year` VALUES (7442,'2014',332,'杨伟峰',0);
INSERT INTO `edu_statistic_year` VALUES (7443,'2014',333,'李亚平',0);
INSERT INTO `edu_statistic_year` VALUES (7444,'2014',334,'李韦伯',0);
INSERT INTO `edu_statistic_year` VALUES (7445,'2014',335,'黄雷',0);
INSERT INTO `edu_statistic_year` VALUES (7446,'2014',336,'李培',0);
INSERT INTO `edu_statistic_year` VALUES (7447,'2014',354,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7448,'2014',355,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7449,'2014',356,'刘梅',0);
INSERT INTO `edu_statistic_year` VALUES (7450,'2014',357,'王明',0);
INSERT INTO `edu_statistic_year` VALUES (7451,'2014',358,'王磊',0);
INSERT INTO `edu_statistic_year` VALUES (7452,'2014',359,'李群',0);
INSERT INTO `edu_statistic_year` VALUES (7453,'2014',360,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7454,'2014',361,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7455,'2014',362,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7456,'2014',363,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7457,'2014',364,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7458,'2014',365,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7459,'2014',366,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7460,'2014',367,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7461,'2014',368,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7462,'2014',369,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7463,'2014',370,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7464,'2014',371,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7465,'2014',372,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7466,'2014',373,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7467,'2014',374,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7468,'2014',375,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7469,'2014',376,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7470,'2014',377,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7471,'2014',378,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7472,'2014',379,'李玉',0);
INSERT INTO `edu_statistic_year` VALUES (7473,'2014',380,'杨明',0);
INSERT INTO `edu_statistic_year` VALUES (7474,'2014',381,'刘超',0);
INSERT INTO `edu_statistic_year` VALUES (7475,'2014',382,'王兴',0);
INSERT INTO `edu_statistic_year` VALUES (7476,'2014',383,'庞龙',0);
INSERT INTO `edu_statistic_year` VALUES (7477,'2014',384,'杨离伟',0);
INSERT INTO `edu_statistic_year` VALUES (7478,'2014',385,'小薛',0);
INSERT INTO `edu_statistic_year` VALUES (7479,'2014',386,'刘燕',0);
INSERT INTO `edu_statistic_year` VALUES (7480,'2014',387,'马丁',0);
INSERT INTO `edu_statistic_year` VALUES (7481,'2014',388,'王龙',0);
INSERT INTO `edu_statistic_year` VALUES (7482,'2014',389,'李赞',0);
INSERT INTO `edu_statistic_year` VALUES (7483,'2014',390,'王五',0);
INSERT INTO `edu_statistic_year` VALUES (7484,'2014',391,'李恒',0);
INSERT INTO `edu_statistic_year` VALUES (7485,'2014',392,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7486,'2014',393,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7487,'2014',394,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7488,'2014',395,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7489,'2014',396,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7490,'2014',397,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7491,'2014',398,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7492,'2014',399,'福建实施员',0);
INSERT INTO `edu_statistic_year` VALUES (7621,'2013',81,'黑龙江省的管理员1',0);
INSERT INTO `edu_statistic_year` VALUES (7622,'2013',82,'哈尔滨市的管理员',0);
INSERT INTO `edu_statistic_year` VALUES (7623,'2013',83,'阿城区的管理员',0);
INSERT INTO `edu_statistic_year` VALUES (7624,'2013',84,'学校管理员',0);
INSERT INTO `edu_statistic_year` VALUES (7625,'2013',85,'教师网管理员',0);
INSERT INTO `edu_statistic_year` VALUES (7626,'2013',86,'果实网管理员',0);
INSERT INTO `edu_statistic_year` VALUES (7627,'2013',87,'系统管理员',0);
INSERT INTO `edu_statistic_year` VALUES (7628,'2013',264,' 湖北管理员',0);
INSERT INTO `edu_statistic_year` VALUES (7629,'2013',265,'武汉admin',0);
INSERT INTO `edu_statistic_year` VALUES (7630,'2013',266,'李念',0);
INSERT INTO `edu_statistic_year` VALUES (7631,'2013',267,'王欢',0);
INSERT INTO `edu_statistic_year` VALUES (7632,'2013',268,'湖北承培一',0);
INSERT INTO `edu_statistic_year` VALUES (7633,'2013',269,'刘琦',0);
INSERT INTO `edu_statistic_year` VALUES (7634,'2013',270,'马骁',0);
INSERT INTO `edu_statistic_year` VALUES (7635,'2013',271,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7636,'2013',272,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7637,'2013',273,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7638,'2013',274,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7639,'2013',275,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7640,'2013',276,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7641,'2013',277,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7642,'2013',278,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7643,'2013',279,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7644,'2013',280,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7645,'2013',281,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7646,'2013',282,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7647,'2013',283,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7648,'2013',284,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7649,'2013',285,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7650,'2013',286,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7651,'2013',287,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7652,'2013',288,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7653,'2013',289,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7654,'2013',290,'夷陵区初中管理员',0);
INSERT INTO `edu_statistic_year` VALUES (7655,'2013',291,'武汉实施一',0);
INSERT INTO `edu_statistic_year` VALUES (7656,'2013',292,'武汉承培一',0);
INSERT INTO `edu_statistic_year` VALUES (7657,'2013',293,'王明',0);
INSERT INTO `edu_statistic_year` VALUES (7658,'2013',294,'王力',0);
INSERT INTO `edu_statistic_year` VALUES (7659,'2013',295,'赖长兴',0);
INSERT INTO `edu_statistic_year` VALUES (7660,'2013',296,'杨钰莹',0);
INSERT INTO `edu_statistic_year` VALUES (7661,'2013',297,'赖伟峰',0);
INSERT INTO `edu_statistic_year` VALUES (7662,'2013',298,'李亚',0);
INSERT INTO `edu_statistic_year` VALUES (7663,'2013',299,'李峰',0);
INSERT INTO `edu_statistic_year` VALUES (7664,'2013',300,'黄欢',0);
INSERT INTO `edu_statistic_year` VALUES (7665,'2013',301,'李梅',0);
INSERT INTO `edu_statistic_year` VALUES (7666,'2013',302,'王雷',0);
INSERT INTO `edu_statistic_year` VALUES (7667,'2013',303,'圆圆',0);
INSERT INTO `edu_statistic_year` VALUES (7668,'2013',304,'木子',0);
INSERT INTO `edu_statistic_year` VALUES (7669,'2013',305,' 李蕊',0);
INSERT INTO `edu_statistic_year` VALUES (7670,'2013',306,'李翠翠',0);
INSERT INTO `edu_statistic_year` VALUES (7671,'2013',307,'宋娟',0);
INSERT INTO `edu_statistic_year` VALUES (7672,'2013',308,'王颖',0);
INSERT INTO `edu_statistic_year` VALUES (7673,'2013',309,'刘伟',0);
INSERT INTO `edu_statistic_year` VALUES (7674,'2013',310,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7675,'2013',311,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7676,'2013',312,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7677,'2013',313,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7678,'2013',314,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7679,'2013',315,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7680,'2013',316,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7681,'2013',317,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7682,'2013',318,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7683,'2013',319,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7684,'2013',320,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7685,'2013',321,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7686,'2013',322,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7687,'2013',323,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7688,'2013',324,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7689,'2013',325,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7690,'2013',326,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7691,'2013',327,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7692,'2013',328,'李明',0);
INSERT INTO `edu_statistic_year` VALUES (7693,'2013',329,'高力',0);
INSERT INTO `edu_statistic_year` VALUES (7694,'2013',330,'李长兴',0);
INSERT INTO `edu_statistic_year` VALUES (7695,'2013',331,'潘钰莹',0);
INSERT INTO `edu_statistic_year` VALUES (7696,'2013',332,'杨伟峰',0);
INSERT INTO `edu_statistic_year` VALUES (7697,'2013',333,'李亚平',0);
INSERT INTO `edu_statistic_year` VALUES (7698,'2013',334,'李韦伯',0);
INSERT INTO `edu_statistic_year` VALUES (7699,'2013',335,'黄雷',0);
INSERT INTO `edu_statistic_year` VALUES (7700,'2013',336,'李培',0);
INSERT INTO `edu_statistic_year` VALUES (7701,'2013',354,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7702,'2013',355,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7703,'2013',356,'刘梅',0);
INSERT INTO `edu_statistic_year` VALUES (7704,'2013',357,'王明',0);
INSERT INTO `edu_statistic_year` VALUES (7705,'2013',358,'王磊',0);
INSERT INTO `edu_statistic_year` VALUES (7706,'2013',359,'李群',0);
INSERT INTO `edu_statistic_year` VALUES (7707,'2013',360,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7708,'2013',361,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7709,'2013',362,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7710,'2013',363,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7711,'2013',364,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7712,'2013',365,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7713,'2013',366,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7714,'2013',367,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7715,'2013',368,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7716,'2013',369,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7717,'2013',370,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7718,'2013',371,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7719,'2013',372,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7720,'2013',373,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7721,'2013',374,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7722,'2013',375,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7723,'2013',376,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7724,'2013',377,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7725,'2013',378,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7726,'2013',379,'李玉',0);
INSERT INTO `edu_statistic_year` VALUES (7727,'2013',380,'杨明',0);
INSERT INTO `edu_statistic_year` VALUES (7728,'2013',381,'刘超',0);
INSERT INTO `edu_statistic_year` VALUES (7729,'2013',382,'王兴',0);
INSERT INTO `edu_statistic_year` VALUES (7730,'2013',383,'庞龙',0);
INSERT INTO `edu_statistic_year` VALUES (7731,'2013',384,'杨离伟',0);
INSERT INTO `edu_statistic_year` VALUES (7732,'2013',385,'小薛',0);
INSERT INTO `edu_statistic_year` VALUES (7733,'2013',386,'刘燕',0);
INSERT INTO `edu_statistic_year` VALUES (7734,'2013',387,'马丁',0);
INSERT INTO `edu_statistic_year` VALUES (7735,'2013',388,'王龙',0);
INSERT INTO `edu_statistic_year` VALUES (7736,'2013',389,'李赞',0);
INSERT INTO `edu_statistic_year` VALUES (7737,'2013',390,'王五',0);
INSERT INTO `edu_statistic_year` VALUES (7738,'2013',391,'李恒',0);
INSERT INTO `edu_statistic_year` VALUES (7739,'2013',392,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7740,'2013',393,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7741,'2013',394,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7742,'2013',395,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7743,'2013',396,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7744,'2013',397,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7745,'2013',398,'admin',0);
INSERT INTO `edu_statistic_year` VALUES (7746,'2013',399,'福建实施员',0);
/*!40000 ALTER TABLE `edu_statistic_year` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table edu_sys_area
#

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
) ENGINE=InnoDB AUTO_INCREMENT=130 DEFAULT CHARSET=utf8;
INSERT INTO `edu_sys_area` VALUES (1,'1','黑龙江省',1,'0','zhangsan','zhangsan','2014-05-09 14:25:37','2014-04-11 10:47:57','0','10010');
INSERT INTO `edu_sys_area` VALUES (2,'2','哈尔滨',1,'1','zhangsan','zhangsan','2014-04-26 11:57:14','2014-04-11 10:50:29','1','100101');
INSERT INTO `edu_sys_area` VALUES (3,'3','阿城区',1,'2','zhangsan','zhangsan','2014-04-26 11:57:16','2014-04-11 10:51:05','2','100200');
INSERT INTO `edu_sys_area` VALUES (4,'4','呼兰区',1,'2','zhangsan','zhangsan','2014-04-26 11:57:18','2014-04-11 11:03:26','2','100201');
INSERT INTO `edu_sys_area` VALUES (5,'5','齐齐哈尔',1,'1','zhangsan','zhangsan','2014-04-26 11:57:20','2014-04-11 11:03:26','1','100102');
INSERT INTO `edu_sys_area` VALUES (6,'6','泰来县',1,'5','zhangsan','zhangsan','2014-04-26 11:57:27','2014-04-11 11:03:26','2','100202');
INSERT INTO `edu_sys_area` VALUES (7,'7','拜泉县',1,'5','zhangsan','zhangsan','2014-04-26 11:57:28','2014-04-11 11:03:26','2','100203');
INSERT INTO `edu_sys_area` VALUES (8,'8','克山县',1,'5','zhangsan','zhangsan','2014-04-26 11:57:29','2014-04-11 11:03:26','2','100204');
INSERT INTO `edu_sys_area` VALUES (9,'9','牡丹江',1,'1','zhangsan','zhangsan','2014-04-26 11:57:31','2014-04-11 11:56:33','1','100103');
INSERT INTO `edu_sys_area` VALUES (11,'11','东宁县',1,'9','zhangsan','zhangsan','2014-04-26 11:57:36','2014-04-11 11:56:33','2','100205');
INSERT INTO `edu_sys_area` VALUES (12,'12','佳木斯',1,'1','zhangsan','zhangsan','2014-04-26 11:57:38','2014-04-11 11:56:33','1','100104');
INSERT INTO `edu_sys_area` VALUES (13,'13','同江市',1,'12','zhangsan','zhangsan','2014-04-26 11:58:00','2014-04-11 11:56:33','2','100206');
INSERT INTO `edu_sys_area` VALUES (39,'39','河北省',0,'0','xitongadmin','xitongadmin','2014-05-08 14:16:26','2014-05-07 09:13:22','0','200100');
INSERT INTO `edu_sys_area` VALUES (40,'40','石家庄',0,'39','xitongadmin','xitongadmin','2014-05-08 14:16:26','2014-05-07 09:13:40','1','20010001');
INSERT INTO `edu_sys_area` VALUES (41,'41','衡水市',0,'39','xitongadmin','xitongadmin','2014-05-08 14:16:26','2014-05-07 09:13:52','1','20010002');
INSERT INTO `edu_sys_area` VALUES (42,'42','桃城区',0,'41','xitongadmin','xitongadmin','2014-05-08 14:16:26','2014-05-07 09:14:55','2','2001000201');
INSERT INTO `edu_sys_area` VALUES (43,'43','枣强县',0,'41','xitongadmin','xitongadmin','2014-05-08 14:16:26','2014-05-07 09:15:07','2','2001000202');
INSERT INTO `edu_sys_area` VALUES (44,'44','桥东区',0,'40','xitongadmin','xitongadmin','2014-05-08 14:16:26','2014-05-07 09:15:51','2','2001000101');
INSERT INTO `edu_sys_area` VALUES (45,'45','桥西区',0,'40','xitongadmin','xitongadmin','2014-05-08 14:16:26','2014-05-07 09:16:08','2','2001000102');
INSERT INTO `edu_sys_area` VALUES (48,'48','河南省',0,'0','xitongadmin','xitongadmin','2014-05-08 14:50:27','2014-05-07 10:10:13','0','455000');
INSERT INTO `edu_sys_area` VALUES (49,'49','山东省',0,'0','xitongadmin','xitongadmin','2014-05-08 14:47:50','2014-05-07 10:11:56','0','250000');
INSERT INTO `edu_sys_area` VALUES (50,'50','潍坊市',1,'49',NULL,NULL,'2014-05-09 10:31:28','2014-05-08 14:45:15','1','190002');
INSERT INTO `edu_sys_area` VALUES (51,'51','潍城区',1,'50',NULL,NULL,'2014-05-08 14:45:15','2014-05-08 14:45:15','2','19000201');
INSERT INTO `edu_sys_area` VALUES (52,'52','坊子区',1,'50',NULL,NULL,'2014-05-08 14:45:15','2014-05-08 14:45:15','2','19000202');
INSERT INTO `edu_sys_area` VALUES (53,'53','奎文区',1,'50',NULL,NULL,'2014-05-08 14:45:16','2014-05-08 14:45:16','2','19000203');
INSERT INTO `edu_sys_area` VALUES (54,'54','诸城',1,'50',NULL,NULL,'2014-05-08 14:45:16','2014-05-08 14:45:16','2','19000204');
INSERT INTO `edu_sys_area` VALUES (55,'55','河北省',1,'0','xitongadmin','xitongadmin','2014-05-08 14:51:18','2014-05-08 14:51:18','0','100200');
INSERT INTO `edu_sys_area` VALUES (56,'56','石家庄',1,'55','xitongadmin','xitongadmin','2014-05-08 14:51:33','2014-05-08 14:51:33','1','10020001');
INSERT INTO `edu_sys_area` VALUES (57,'57','衡水市',1,'55','xitongadmin','xitongadmin','2014-05-08 14:51:43','2014-05-08 14:51:43','1','10020002');
INSERT INTO `edu_sys_area` VALUES (58,'58','桥东区',1,'56','xitongadmin','xitongadmin','2014-05-08 14:51:53','2014-05-08 14:51:53','2','1002000101');
INSERT INTO `edu_sys_area` VALUES (59,'59','桥西区',1,'56','xitongadmin','xitongadmin','2014-05-08 14:52:05','2014-05-08 14:52:05','2','1002000102');
INSERT INTO `edu_sys_area` VALUES (60,'60','桃城区',1,'57','xitongadmin','xitongadmin','2014-05-08 14:52:45','2014-05-08 14:52:45','2','1002000201');
INSERT INTO `edu_sys_area` VALUES (61,'61','枣强县',1,'57','xitongadmin','xitongadmin','2014-05-08 14:52:59','2014-05-08 14:52:59','2','1002000202');
INSERT INTO `edu_sys_area` VALUES (62,'62','北京省',1,'0','shengadmin','shengadmin','2014-05-08 16:06:57','2014-05-08 16:06:57','0','100000');
INSERT INTO `edu_sys_area` VALUES (63,'63','北京省',0,'0','shengadmin','shengadmin','2014-05-09 13:26:36','2014-05-09 13:26:33','0','100000');
INSERT INTO `edu_sys_area` VALUES (64,'64','七台河',1,'1','shengadmin','shengadmin','2014-05-09 14:11:26','2014-05-09 14:11:26','1','1000100');
INSERT INTO `edu_sys_area` VALUES (65,'65','内蒙古',0,'0','xitongadmin','xitongadmin','2014-05-09 15:40:05','2014-05-09 14:18:20','0','10040');
INSERT INTO `edu_sys_area` VALUES (66,'66','北京省',0,'0','xitongadmin','xitongadmin','2014-05-12 09:19:49','2014-05-09 15:39:56','0','100025');
INSERT INTO `edu_sys_area` VALUES (67,'67','江苏省',1,'0','xitongadmin','xitongadmin','2014-05-09 16:04:26','2014-05-09 16:04:26','0','1000021');
INSERT INTO `edu_sys_area` VALUES (68,'68','山东省',0,'0',NULL,NULL,'2014-05-13 09:35:55','2014-05-09 16:06:18','0','19001');
INSERT INTO `edu_sys_area` VALUES (69,'69','潍坊市',0,'68',NULL,NULL,'2014-05-13 09:35:55','2014-05-09 16:06:18','1','190002');
INSERT INTO `edu_sys_area` VALUES (70,'70','湖北省',0,'0',NULL,NULL,'2014-05-13 09:33:56','2014-05-09 16:09:51','0','29001');
INSERT INTO `edu_sys_area` VALUES (71,'71','武汉市',0,'70',NULL,NULL,'2014-05-13 09:33:46','2014-05-09 16:09:51','1','290002');
INSERT INTO `edu_sys_area` VALUES (72,'72','江汉',0,'71',NULL,NULL,'2014-05-13 09:33:31','2014-05-09 16:09:51','2','2900021');
INSERT INTO `edu_sys_area` VALUES (73,'73','汉阳',0,'71',NULL,NULL,'2014-05-13 09:33:33','2014-05-09 16:09:51','2','2900022');
INSERT INTO `edu_sys_area` VALUES (74,'74','武昌',0,'71',NULL,NULL,'2014-05-13 09:33:34','2014-05-09 16:09:51','2','2900023');
INSERT INTO `edu_sys_area` VALUES (75,'75','青山',0,'71',NULL,NULL,'2014-05-13 09:33:34','2014-05-09 16:09:51','2','2900024');
INSERT INTO `edu_sys_area` VALUES (76,'76','河南省',1,'0',NULL,NULL,'2014-05-11 09:04:33','2014-05-11 09:04:33','0','29010');
INSERT INTO `edu_sys_area` VALUES (77,'77','洛阳市',1,'76',NULL,NULL,'2014-05-11 09:04:33','2014-05-11 09:04:33','1','290102');
INSERT INTO `edu_sys_area` VALUES (78,'78','白马',1,'77',NULL,NULL,'2014-05-11 09:04:33','2014-05-11 09:04:33','2','2901021');
INSERT INTO `edu_sys_area` VALUES (79,'79','龙门',1,'77',NULL,NULL,'2014-05-11 09:04:33','2014-05-11 09:04:33','2','2901022');
INSERT INTO `edu_sys_area` VALUES (80,'80','关林',1,'77',NULL,NULL,'2014-05-11 09:04:33','2014-05-11 09:04:33','2','2901023');
INSERT INTO `edu_sys_area` VALUES (81,'81','龙潭',1,'77',NULL,NULL,'2014-05-11 09:04:33','2014-05-11 09:04:33','2','2901024');
INSERT INTO `edu_sys_area` VALUES (82,'82','河南省',0,'0','xitongadmin','xitongadmin','2014-05-11 10:03:57','2014-05-11 10:03:12','0','29010010');
INSERT INTO `edu_sys_area` VALUES (83,'83','洛阳市',0,'82','xitongadmin','xitongadmin','2014-05-11 10:03:52','2014-05-11 10:03:44','1','111');
INSERT INTO `edu_sys_area` VALUES (84,'84','浙江省',1,'0','xitongadmin','xitongadmin','2014-05-12 15:13:29','2014-05-12 15:13:29','0','30001');
INSERT INTO `edu_sys_area` VALUES (85,'85','杭州市',1,'84','xitongadmin','xitongadmin','2014-05-12 15:13:49','2014-05-12 15:13:49','1','30010');
INSERT INTO `edu_sys_area` VALUES (86,'86','北京市',0,'0','xitongadmin','xitongadmin','2014-05-13 09:35:39','2014-05-13 09:33:24','0','10010');
INSERT INTO `edu_sys_area` VALUES (87,'87','海淀区',0,'0','xitongadmin','xitongadmin','2014-05-13 09:35:42','2014-05-13 09:34:24','0','10010001');
INSERT INTO `edu_sys_area` VALUES (88,'88','昌平区',0,'0','xitongadmin','xitongadmin','2014-05-13 09:35:43','2014-05-13 09:34:40','0','10010002');
INSERT INTO `edu_sys_area` VALUES (89,'89','湖北省',1,'0',NULL,NULL,'2014-05-13 09:48:15','2014-05-13 09:48:15','0','29001');
INSERT INTO `edu_sys_area` VALUES (90,'90','武汉市',1,'89',NULL,NULL,'2014-05-13 09:48:15','2014-05-13 09:48:15','1','290001');
INSERT INTO `edu_sys_area` VALUES (91,'91','宜昌市',1,'89',NULL,NULL,'2014-05-13 09:48:15','2014-05-13 09:48:15','1','290002');
INSERT INTO `edu_sys_area` VALUES (92,'92','江汉区',1,'90',NULL,NULL,'2014-05-13 09:48:15','2014-05-13 09:48:15','2','2900011');
INSERT INTO `edu_sys_area` VALUES (93,'93','汉阳区',1,'90',NULL,NULL,'2014-05-13 09:48:15','2014-05-13 09:48:15','2','2900012');
INSERT INTO `edu_sys_area` VALUES (94,'94','武昌区',1,'90',NULL,NULL,'2014-05-13 09:48:15','2014-05-13 09:48:15','2','2900013');
INSERT INTO `edu_sys_area` VALUES (95,'95','青山区',1,'90',NULL,NULL,'2014-05-13 09:48:15','2014-05-13 09:48:15','2','2900014');
INSERT INTO `edu_sys_area` VALUES (96,'96','西陵区',1,'91',NULL,NULL,'2014-05-13 09:48:15','2014-05-13 09:48:15','2','2900021');
INSERT INTO `edu_sys_area` VALUES (97,'97','伍家岗区',1,'91',NULL,NULL,'2014-05-13 09:48:15','2014-05-13 09:48:15','2','2900022');
INSERT INTO `edu_sys_area` VALUES (98,'98','点军区',1,'91',NULL,NULL,'2014-05-13 09:48:15','2014-05-13 09:48:15','2','2900023');
INSERT INTO `edu_sys_area` VALUES (99,'99','夷陵区',1,'91',NULL,NULL,'2014-05-13 09:48:15','2014-05-13 09:48:15','2','2900024');
INSERT INTO `edu_sys_area` VALUES (100,'100','湖南省',1,'0',NULL,NULL,'2014-05-14 14:30:27','2014-05-14 14:30:27','0','39001');
INSERT INTO `edu_sys_area` VALUES (101,'101','长沙市',1,'100',NULL,NULL,'2014-05-14 14:30:27','2014-05-14 14:30:27','1','390001');
INSERT INTO `edu_sys_area` VALUES (102,'102','湘潭市',1,'100',NULL,NULL,'2014-05-14 14:30:27','2014-05-14 14:30:27','1','390002');
INSERT INTO `edu_sys_area` VALUES (103,'103','芙蓉区',1,'101',NULL,NULL,'2014-05-14 14:30:27','2014-05-14 14:30:27','2','3900011');
INSERT INTO `edu_sys_area` VALUES (104,'104','天心区',1,'101',NULL,NULL,'2014-05-14 14:30:27','2014-05-14 14:30:27','2','3900012');
INSERT INTO `edu_sys_area` VALUES (105,'105','望城区',1,'101',NULL,NULL,'2014-05-14 14:30:27','2014-05-14 14:30:27','2','3900013');
INSERT INTO `edu_sys_area` VALUES (106,'106','雨花区',1,'101',NULL,NULL,'2014-05-14 14:30:27','2014-05-14 14:30:27','2','3900014');
INSERT INTO `edu_sys_area` VALUES (107,'107','雨湖区',1,'102',NULL,NULL,'2014-05-14 14:30:27','2014-05-14 14:30:27','2','3900021');
INSERT INTO `edu_sys_area` VALUES (108,'108','岳塘区',1,'102',NULL,NULL,'2014-05-14 14:30:27','2014-05-14 14:30:27','2','3900022');
INSERT INTO `edu_sys_area` VALUES (109,'109','湘乡市',1,'102',NULL,NULL,'2014-05-14 14:30:27','2014-05-14 14:30:27','2','3900023');
INSERT INTO `edu_sys_area` VALUES (110,'110','韶山市',1,'102',NULL,NULL,'2014-05-14 14:30:27','2014-05-14 14:30:27','2','3900024');
INSERT INTO `edu_sys_area` VALUES (111,'111','海南省',1,'0','xitongadmin','xitongadmin','2014-05-15 17:17:03','2014-05-15 17:17:03','0','59001');
INSERT INTO `edu_sys_area` VALUES (112,'112','海口市',1,'111','xitongadmin','xitongadmin','2014-05-15 17:17:16','2014-05-15 17:17:16','1','5009001');
INSERT INTO `edu_sys_area` VALUES (113,'113','三亚市',1,'111','xitongadmin','xitongadmin','2014-05-15 17:17:59','2014-05-15 17:17:59','1','5009002');
INSERT INTO `edu_sys_area` VALUES (114,'114','甘肃省',1,'0',NULL,NULL,'2014-05-15 17:19:14','2014-05-15 17:19:14','0','49001');
INSERT INTO `edu_sys_area` VALUES (115,'115','兰州市',1,'114',NULL,NULL,'2014-05-15 17:19:14','2014-05-15 17:19:14','1','490001');
INSERT INTO `edu_sys_area` VALUES (116,'116','天水市',1,'114',NULL,NULL,'2014-05-15 17:19:14','2014-05-15 17:19:14','1','490002');
INSERT INTO `edu_sys_area` VALUES (117,'117','城关区',1,'115',NULL,NULL,'2014-05-15 17:19:14','2014-05-15 17:19:14','2','4900011');
INSERT INTO `edu_sys_area` VALUES (118,'118','西固区',1,'115',NULL,NULL,'2014-05-15 17:19:14','2014-05-15 17:19:14','2','4900012');
INSERT INTO `edu_sys_area` VALUES (119,'119','安宁区',1,'115',NULL,NULL,'2014-05-15 17:19:14','2014-05-15 17:19:14','2','4900013');
INSERT INTO `edu_sys_area` VALUES (120,'120','红古区',1,'115',NULL,NULL,'2014-05-15 17:19:14','2014-05-15 17:19:14','2','4900014');
INSERT INTO `edu_sys_area` VALUES (121,'121','秦州区',1,'116',NULL,NULL,'2014-05-15 17:19:14','2014-05-15 17:19:14','2','4900021');
INSERT INTO `edu_sys_area` VALUES (122,'122','麦积区',1,'116',NULL,NULL,'2014-05-15 17:19:14','2014-05-15 17:19:14','2','4900022');
INSERT INTO `edu_sys_area` VALUES (123,'123','武山县',1,'116',NULL,NULL,'2014-05-15 17:19:14','2014-05-15 17:19:14','2','4900023');
INSERT INTO `edu_sys_area` VALUES (124,'124','秦安县',1,'116',NULL,NULL,'2014-05-15 17:19:14','2014-05-15 17:19:14','2','4900024');
INSERT INTO `edu_sys_area` VALUES (125,'125','福建省',1,'0','xitongadmin','xitongadmin','2014-05-16 10:00:59','2014-05-16 10:00:59','0','6001');
INSERT INTO `edu_sys_area` VALUES (126,'126','福州市',1,'125','xitongadmin','xitongadmin','2014-05-16 10:01:14','2014-05-16 10:01:14','1','6002');
INSERT INTO `edu_sys_area` VALUES (127,'127','福清市',1,'125','xitongadmin','xitongadmin','2014-05-16 10:01:33','2014-05-16 10:01:33','1','6003');
INSERT INTO `edu_sys_area` VALUES (128,'128','福州一区',1,'126','xitongadmin','xitongadmin','2014-05-16 10:01:56','2014-05-16 10:01:56','2','6005');
INSERT INTO `edu_sys_area` VALUES (129,'129','福州二区',1,'126','xitongadmin','xitongadmin','2014-05-16 10:02:06','2014-05-16 10:02:06','2','6006');
/*!40000 ALTER TABLE `edu_sys_area` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table edu_sys_dictionary
#

CREATE TABLE `edu_sys_dictionary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dictionary_id` int(11) DEFAULT NULL COMMENT '字典id',
  `dictionary_type` varchar(100) DEFAULT NULL COMMENT '字典类型',
  `dictionary_type_name` varchar(100) DEFAULT NULL,
  `dictionary_name` varchar(100) DEFAULT NULL,
  `dictionary_code` varchar(100) DEFAULT NULL,
  `status` int(2) DEFAULT NULL COMMENT '1-有效，0-无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
INSERT INTO `edu_sys_dictionary` VALUES (1,1,'project_subject','学科','小学语文','xk01',1);
INSERT INTO `edu_sys_dictionary` VALUES (2,2,'project_subject','学科','小学数学','xk02',1);
INSERT INTO `edu_sys_dictionary` VALUES (4,1,'stduty_section','学段','幼儿园','xd01',1);
INSERT INTO `edu_sys_dictionary` VALUES (5,2,'stduty_section','学段','小学','xd02',0);
INSERT INTO `edu_sys_dictionary` VALUES (6,1,'project_status','项目状态','准备中','',1);
INSERT INTO `edu_sys_dictionary` VALUES (7,2,'project_status','项目状态','正在进行中','',1);
INSERT INTO `edu_sys_dictionary` VALUES (8,3,'project_status','项目状态','已结束','',1);
INSERT INTO `edu_sys_dictionary` VALUES (9,1,'project_score','项目评分','非常满意','',1);
INSERT INTO `edu_sys_dictionary` VALUES (10,2,'project_score','项目评分','满意','',1);
INSERT INTO `edu_sys_dictionary` VALUES (11,3,'project_score','项目评分','一般','',1);
INSERT INTO `edu_sys_dictionary` VALUES (12,4,'project_score','项目评分','不满意','',1);
INSERT INTO `edu_sys_dictionary` VALUES (13,5,'project_score','项目评分','非常不满意','',1);
INSERT INTO `edu_sys_dictionary` VALUES (14,3,'stduty_section','学段','初中','xd03',1);
INSERT INTO `edu_sys_dictionary` VALUES (15,4,'stduty_section','学段','高中','xd04',1);
INSERT INTO `edu_sys_dictionary` VALUES (17,1,'political_status','政治面貌','群众',NULL,1);
INSERT INTO `edu_sys_dictionary` VALUES (18,2,'political_status','政治面貌','党员',NULL,1);
INSERT INTO `edu_sys_dictionary` VALUES (20,3,'project_subject','学科','小学美术','xk03',1);
INSERT INTO `edu_sys_dictionary` VALUES (21,4,'project_subject','学科','小学音乐','xk04',1);
INSERT INTO `edu_sys_dictionary` VALUES (24,2,'change_type','信息变更类型','调动',NULL,1);
INSERT INTO `edu_sys_dictionary` VALUES (25,1,'change_type','信息变更类型','信息变更',NULL,1);
INSERT INTO `edu_sys_dictionary` VALUES (26,3,'change_type','信息变更类型','离退休',NULL,1);
INSERT INTO `edu_sys_dictionary` VALUES (27,5,'project_subject','学科','初中语文','xk05',1);
INSERT INTO `edu_sys_dictionary` VALUES (28,6,'project_subject','学科','初中数学','xk06',1);
INSERT INTO `edu_sys_dictionary` VALUES (29,1,'school_type','学校类型','小学',NULL,1);
INSERT INTO `edu_sys_dictionary` VALUES (48,1,'study_grade','年级','一年级','nl01',NULL);
INSERT INTO `edu_sys_dictionary` VALUES (49,1,'educational_user','学历','初中','xl01',NULL);
INSERT INTO `edu_sys_dictionary` VALUES (50,1,'academic_degree','学位','博士','xw01',NULL);
INSERT INTO `edu_sys_dictionary` VALUES (51,1,'teacher_seniority','教师资格种类','一级教师','jszg01',NULL);
INSERT INTO `edu_sys_dictionary` VALUES (52,1,'teacher_professional','教师职称','正高级教师','jszh01',NULL);
INSERT INTO `edu_sys_dictionary` VALUES (53,1,'project_scope','项目范围','国培项目','xm01',NULL);
INSERT INTO `edu_sys_dictionary` VALUES (54,1,'project_nature','项目性质','教师培训','xmxz01',NULL);
INSERT INTO `edu_sys_dictionary` VALUES (55,1,'Training type\r\nTraining type\r\nTraining type\r\ntraining_type','培训类型','远程','pxlx01',NULL);
INSERT INTO `edu_sys_dictionary` VALUES (56,1,'teacher_osition','教师职务',NULL,'jszw01',NULL);
INSERT INTO `edu_sys_dictionary` VALUES (59,1,'office_type','学校行政职务','普通教师','officetype001',1);
INSERT INTO `edu_sys_dictionary` VALUES (60,2,'office_type','学校行政职务','高级教师','officetype002',1);
INSERT INTO `edu_sys_dictionary` VALUES (61,2,'school_type','学校类型','初中',NULL,1);
INSERT INTO `edu_sys_dictionary` VALUES (62,3,'school_type','学校类型','高中',NULL,1);
INSERT INTO `edu_sys_dictionary` VALUES (63,4,'school_type','学校类型','职高',NULL,1);
INSERT INTO `edu_sys_dictionary` VALUES (64,5,'school_type','学校类型','幼儿园',NULL,1);
INSERT INTO `edu_sys_dictionary` VALUES (65,32,'change_type','信息变更类型','死亡',NULL,1);
INSERT INTO `edu_sys_dictionary` VALUES (66,31,'change_type','信息变更类型','退休',NULL,1);
INSERT INTO `edu_sys_dictionary` VALUES (67,33,'change_type','信息变更类型','离休',NULL,1);
INSERT INTO `edu_sys_dictionary` VALUES (68,34,'change_type','信息变更类型','离岗',NULL,1);
INSERT INTO `edu_sys_dictionary` VALUES (69,35,'change_type','信息变更类型','病休',NULL,1);
INSERT INTO `edu_sys_dictionary` VALUES (70,36,'change_type','信息变更类型','其他',NULL,1);
INSERT INTO `edu_sys_dictionary` VALUES (71,2,'project_scope','项目范围','省级项目','fw03',1);
INSERT INTO `edu_sys_dictionary` VALUES (72,2,'project_nature','项目性质','骨干教师培训','xz01',1);
INSERT INTO `edu_sys_dictionary` VALUES (73,2,'teacher_osition','教师职务','班导','zc01',1);
INSERT INTO `edu_sys_dictionary` VALUES (74,5,'stduty_section','学段','初中英语','xk10',1);
INSERT INTO `edu_sys_dictionary` VALUES (75,3,'teacher_osition','教师职务','语文老师','xk08',1);
INSERT INTO `edu_sys_dictionary` VALUES (76,2,'teacher_professional','教师职称','高级职称','zc01',1);
INSERT INTO `edu_sys_dictionary` VALUES (77,2,'teacher_seniority','教师资格种类','教师特级等级','zg01',0);
INSERT INTO `edu_sys_dictionary` VALUES (78,2,'study_grade','\n\t\t\t\t\t\t\t\t\t\t\t年级\n\t\t\t\t\t\t\t\t\t\t','小学美术','H010',1);
INSERT INTO `edu_sys_dictionary` VALUES (79,3,'project_scope','\n\t\t\t\t\t\t\t\t\t\t\t项目范围\n\t\t\t\t\t\t\t\t\t\t','准备中','K110',1);
INSERT INTO `edu_sys_dictionary` VALUES (80,6,'stduty_section','\n\t\t\t\t\t\t\t\t\t\t\t学段\n\t\t\t\t\t\t\t\t\t\t','小学','xx01',1);
INSERT INTO `edu_sys_dictionary` VALUES (81,3,'teacher_seniority','\n\t\t\t\t\t\t\t\t\t\t\t教师资格种类\n\t\t\t\t\t\t\t\t\t\t','湖南项目','hn007',1);
/*!40000 ALTER TABLE `edu_sys_dictionary` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table edu_sys_function
#

CREATE TABLE `edu_sys_function` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `func_name` varchar(100) DEFAULT NULL COMMENT '资源中文名称',
  `func_type` int(11) DEFAULT NULL COMMENT '资源类型： 1 频道 ； 2 模块；3 功能； 4 按钮',
  `func_code` varchar(50) NOT NULL,
  `func_url` varchar(100) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL COMMENT '排序字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=117 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
INSERT INTO `edu_sys_function` VALUES (1,'个人中心',1,'person_001','',1);
INSERT INTO `edu_sys_function` VALUES (2,'个人中心设置',2,'person_002','',1);
INSERT INTO `edu_sys_function` VALUES (3,'系统管理',1,'system_001',NULL,2);
INSERT INTO `edu_sys_function` VALUES (4,'系统管理',2,'system_002',NULL,2);
INSERT INTO `edu_sys_function` VALUES (5,'教师信息',1,'teacher_001',NULL,3);
INSERT INTO `edu_sys_function` VALUES (6,'教师信息',2,'teacher_002',NULL,3);
INSERT INTO `edu_sys_function` VALUES (7,'培训项目',1,'project_001',NULL,4);
INSERT INTO `edu_sys_function` VALUES (8,'培训项目管理 ',2,'project_002',NULL,4);
INSERT INTO `edu_sys_function` VALUES (9,'继教信息',1,'furtheredu_001',NULL,5);
INSERT INTO `edu_sys_function` VALUES (10,'继教信息',2,'furtheredu_002',NULL,5);
INSERT INTO `edu_sys_function` VALUES (11,'地区管理',3,'system_003',NULL,2);
INSERT INTO `edu_sys_function` VALUES (13,'项目管理',3,'project_008',NULL,2);
INSERT INTO `edu_sys_function` VALUES (14,'设置报名方式',3,'project_003',NULL,3);
INSERT INTO `edu_sys_function` VALUES (15,'培训机构任务分配',3,'project_004',NULL,4);
INSERT INTO `edu_sys_function` VALUES (16,'培训项目管理(承培机构)',3,'project_030','',1);
INSERT INTO `edu_sys_function` VALUES (17,'承培项目管理(承培机构)',3,'project_031','',2);
INSERT INTO `edu_sys_function` VALUES (18,'项目状态设置(承培机构)',3,'project_032','',3);
INSERT INTO `edu_sys_function` VALUES (19,'参训教师评价(承培机构)',3,'project_033','',4);
INSERT INTO `edu_sys_function` VALUES (20,'查看教师评价(承培机构)',3,'project_034','',5);
INSERT INTO `edu_sys_function` VALUES (21,'上传培训成绩(承培机构)',3,'project_035','',6);
INSERT INTO `edu_sys_function` VALUES (22,'课程设置',3,'project_005',NULL,5);
INSERT INTO `edu_sys_function` VALUES (23,'项目评价',3,'project_006',NULL,6);
INSERT INTO `edu_sys_function` VALUES (24,'项目汇总统计',3,'project_007',NULL,1);
INSERT INTO `edu_sys_function` VALUES (25,'我的教师信息(教师)',3,'teacher_003',NULL,1);
INSERT INTO `edu_sys_function` VALUES (26,'项目学习(教师)',3,'project_010',NULL,1);
INSERT INTO `edu_sys_function` VALUES (27,'加入培训项目(教师)',3,'project_011',NULL,1);
INSERT INTO `edu_sys_function` VALUES (28,'查看培训成绩(教师)',3,'project_012',NULL,1);
INSERT INTO `edu_sys_function` VALUES (29,'教师成绩查询',3,'project_009',NULL,9);
INSERT INTO `edu_sys_function` VALUES (30,'继教信息(管理)',3,'furtheredu_003',NULL,1);
INSERT INTO `edu_sys_function` VALUES (31,'继教信息管理(管理)',3,'furtheredu_004',NULL,2);
INSERT INTO `edu_sys_function` VALUES (32,'年度考核设置(管理)',3,'furtheredu_005',NULL,3);
INSERT INTO `edu_sys_function` VALUES (33,'教师年度考核查询(管理)',3,'furtheredu_006',NULL,4);
INSERT INTO `edu_sys_function` VALUES (34,'年度证书模版设置',3,'furtheredu_007',NULL,5);
INSERT INTO `edu_sys_function` VALUES (35,'教师报名审核',3,'project_013',NULL,1);
INSERT INTO `edu_sys_function` VALUES (36,'教师信息管理',3,'teacher_004',NULL,3);
INSERT INTO `edu_sys_function` VALUES (39,'教师信息导入',3,'teacher_005',NULL,2);
INSERT INTO `edu_sys_function` VALUES (40,'继教考核查询(教师)',3,'furtheredu_008',NULL,1);
INSERT INTO `edu_sys_function` VALUES (41,'课程设置(机构)',3,'project_036',NULL,7);
INSERT INTO `edu_sys_function` VALUES (42,'教师打印证书(教师)',3,'furtheredu_009',NULL,2);
INSERT INTO `edu_sys_function` VALUES (43,'信息变更记录(教师)',3,'teacher_006',NULL,1);
INSERT INTO `edu_sys_function` VALUES (44,'角色管理',3,'system_004',NULL,1);
INSERT INTO `edu_sys_function` VALUES (45,'个人信息',3,'person_003',NULL,1);
INSERT INTO `edu_sys_function` VALUES (46,'修改密码',3,'person_004',NULL,2);
INSERT INTO `edu_sys_function` VALUES (47,'学校管理',5,'system_005',NULL,2);
INSERT INTO `edu_sys_function` VALUES (48,'生成管理员帐号',3,'system_006',NULL,3);
INSERT INTO `edu_sys_function` VALUES (49,'管理员管理',3,'system_007',NULL,4);
INSERT INTO `edu_sys_function` VALUES (50,'培训实施机构管理',3,'system_008',NULL,5);
INSERT INTO `edu_sys_function` VALUES (51,'数据字典管理',3,'system_009',NULL,6);
INSERT INTO `edu_sys_function` VALUES (52,'功能设置',3,'system_010',NULL,7);
INSERT INTO `edu_sys_function` VALUES (53,'学校管理-详情',4,'system_005_select',NULL,1);
INSERT INTO `edu_sys_function` VALUES (54,'学校管理-编辑',4,'system_005_update',NULL,1);
INSERT INTO `edu_sys_function` VALUES (55,'学校管理-删除',4,'system_005_delete',NULL,1);
INSERT INTO `edu_sys_function` VALUES (56,'管理员管理',3,'system_011',NULL,1);
INSERT INTO `edu_sys_function` VALUES (57,'管理员管理-详情',4,'system_011_select',NULL,1);
INSERT INTO `edu_sys_function` VALUES (58,'管理员管理-编辑',4,'system_011_update',NULL,1);
INSERT INTO `edu_sys_function` VALUES (59,'管理员管理-删除',4,'system_011_delete',NULL,1);
INSERT INTO `edu_sys_function` VALUES (60,'管理员管理-增加',4,'system_011_add',NULL,1);
INSERT INTO `edu_sys_function` VALUES (61,'管理员管理-导出',4,'system_011_export',NULL,1);
INSERT INTO `edu_sys_function` VALUES (62,'调动管理',3,'teacher_007',NULL,1);
INSERT INTO `edu_sys_function` VALUES (63,'调动管理-新增',4,'teacher_007_add',NULL,1);
INSERT INTO `edu_sys_function` VALUES (64,'调动管理-详情',4,'teacher_007_select',NULL,1);
INSERT INTO `edu_sys_function` VALUES (65,'调动管理-审核',4,'teacher_007_through',NULL,1);
INSERT INTO `edu_sys_function` VALUES (66,'通知',3,'person_005',NULL,3);
INSERT INTO `edu_sys_function` VALUES (67,'信息变更审核',3,'teacher_008',NULL,8);
INSERT INTO `edu_sys_function` VALUES (68,'教师离退休管理',3,'teacher_009',NULL,9);
INSERT INTO `edu_sys_function` VALUES (69,'教师信息审核',3,'teacher_002_1',NULL,2);
INSERT INTO `edu_sys_function` VALUES (70,'继教信息板块设置',3,'project_014',NULL,1);
INSERT INTO `edu_sys_function` VALUES (71,'培训项目查询',3,'project_015',NULL,1);
INSERT INTO `edu_sys_function` VALUES (72,'培训项目申报',3,'project_016',NULL,1);
INSERT INTO `edu_sys_function` VALUES (73,'培训项目审核',3,'project_017',NULL,1);
INSERT INTO `edu_sys_function` VALUES (74,'培训名额分配',3,'project_018',NULL,1);
INSERT INTO `edu_sys_function` VALUES (75,'培训名额上报',3,'project_019',NULL,1);
INSERT INTO `edu_sys_function` VALUES (76,'承培机构任务分配',3,'project_020',NULL,1);
INSERT INTO `edu_sys_function` VALUES (77,'教师报名审核',3,'project_021',NULL,1);
INSERT INTO `edu_sys_function` VALUES (78,'培训项目启动',3,'project_022',NULL,1);
INSERT INTO `edu_sys_function` VALUES (79,'培训成绩导入',3,'project_023',NULL,1);
INSERT INTO `edu_sys_function` VALUES (80,'培训总结',3,'project_024',NULL,1);
INSERT INTO `edu_sys_function` VALUES (81,'项目评价',3,'project_025',NULL,1);
INSERT INTO `edu_sys_function` VALUES (82,'培训项目过程管理(承培机构)',3,'project_037',NULL,8);
INSERT INTO `edu_sys_function` VALUES (83,'培训总结(承培机构)',3,'project_038',NULL,9);
INSERT INTO `edu_sys_function` VALUES (84,'生成管理员帐号',3,'system_012',NULL,1);
INSERT INTO `edu_sys_function` VALUES (85,'提交项目总结报告',3,'project_026',NULL,1);
INSERT INTO `edu_sys_function` VALUES (86,'项目调查与评估',3,'project_027',NULL,1);
INSERT INTO `edu_sys_function` VALUES (87,'培训成绩发布',3,'project_028',NULL,1);
INSERT INTO `edu_sys_function` VALUES (88,'培训项目关闭',3,'project_029',NULL,1);
INSERT INTO `edu_sys_function` VALUES (89,'编制调整管理',3,'teacher_010',NULL,1);
INSERT INTO `edu_sys_function` VALUES (90,'编制调整管理-增加',4,'teacher_010_add',NULL,1);
INSERT INTO `edu_sys_function` VALUES (91,'编制调整管理-审核',4,'teacher_010_through',NULL,1);
INSERT INTO `edu_sys_function` VALUES (92,'承培机构管理',3,'system_013',NULL,8);
INSERT INTO `edu_sys_function` VALUES (93,'我的调动记录(教师)',3,'teacher_011',NULL,1);
INSERT INTO `edu_sys_function` VALUES (94,'项目调查(教师)',3,'project_040',NULL,1);
INSERT INTO `edu_sys_function` VALUES (95,'教师病休管理',3,'teacher_012',NULL,1);
INSERT INTO `edu_sys_function` VALUES (96,'教师离岗管理',3,'teacher_013',NULL,1);
INSERT INTO `edu_sys_function` VALUES (97,'教师死亡登记管理',3,'teacher_014',NULL,1);
INSERT INTO `edu_sys_function` VALUES (98,'教师返聘管理',3,'teacher_015',NULL,1);
INSERT INTO `edu_sys_function` VALUES (99,'教师病休审核',3,'teacher_016',NULL,1);
INSERT INTO `edu_sys_function` VALUES (100,'教师离岗审核',3,'teacher_017',NULL,1);
INSERT INTO `edu_sys_function` VALUES (101,'教师离退休审核',3,'teacher_018',NULL,1);
INSERT INTO `edu_sys_function` VALUES (102,'教师死亡登记审核',3,'teacher_019',NULL,1);
INSERT INTO `edu_sys_function` VALUES (103,'教师返聘审核',3,'teacher_020',NULL,1);
INSERT INTO `edu_sys_function` VALUES (104,'校本培训项目(管理)',3,'furtheredu_010',NULL,3);
INSERT INTO `edu_sys_function` VALUES (105,'非培训类项目(管理)',3,'furtheredu_011',NULL,3);
INSERT INTO `edu_sys_function` VALUES (106,'学分登记(管理)',3,'furtheredu_012',NULL,3);
INSERT INTO `edu_sys_function` VALUES (107,'学分审核(管理)',3,'furtheredu_013',NULL,3);
INSERT INTO `edu_sys_function` VALUES (108,'学分查询(管理)',3,'furtheredu_014',NULL,3);
INSERT INTO `edu_sys_function` VALUES (109,'项目证书打印(教师)',3,'furtheredu_015',NULL,3);
INSERT INTO `edu_sys_function` VALUES (110,'培训总结(教师)',3,'project_041',NULL,1);
INSERT INTO `edu_sys_function` VALUES (111,'继教证书',2,'furtheredu_016',NULL,1);
INSERT INTO `edu_sys_function` VALUES (112,'电子印章管理',3,'furtheredu_017',NULL,1);
INSERT INTO `edu_sys_function` VALUES (113,'项目证书设置',3,'furtheredu_018',NULL,1);
INSERT INTO `edu_sys_function` VALUES (114,'项目证书打印(实施/管理)',3,'furtheredu_019',NULL,1);
INSERT INTO `edu_sys_function` VALUES (115,'教师信息查询',3,'teacher_021',NULL,1);
INSERT INTO `edu_sys_function` VALUES (116,'学分兑换规则设置',3,'furtheredu_020',NULL,1);
/*!40000 ALTER TABLE `edu_sys_function` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table edu_sys_role
#

CREATE TABLE `edu_sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `create_by` varchar(100) DEFAULT NULL,
  `update_by` varchar(100) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
INSERT INTO `edu_sys_role` VALUES (0,'系统管理员',1,NULL,'xitongadmin',NULL,'');
INSERT INTO `edu_sys_role` VALUES (1,'省管理员',1,NULL,'xitongadmin',NULL,'');
INSERT INTO `edu_sys_role` VALUES (2,'市管理员',1,NULL,'xitongadmin',NULL,'');
INSERT INTO `edu_sys_role` VALUES (3,'区管理员',1,NULL,'xitongadmin',NULL,'');
INSERT INTO `edu_sys_role` VALUES (4,'校管理员',1,NULL,'xitongadmin',NULL,'');
INSERT INTO `edu_sys_role` VALUES (5,'教师',1,NULL,'xitongadmin',NULL,'');
INSERT INTO `edu_sys_role` VALUES (6,'承培机构管理员',1,NULL,'xitongadmin',NULL,'');
INSERT INTO `edu_sys_role` VALUES (7,'实施机构管理员 （省）',1,NULL,'xitongadmin',NULL,'');
INSERT INTO `edu_sys_role` VALUES (8,'实施机构管理员 （市）',1,NULL,'xitongadmin',NULL,'');
INSERT INTO `edu_sys_role` VALUES (9,'实施机构管理员 （区）',1,NULL,NULL,NULL,NULL);
INSERT INTO `edu_sys_role` VALUES (10,'实施机构管理员 （校）',1,NULL,'xitongadmin',NULL,'');
INSERT INTO `edu_sys_role` VALUES (20,'专家',1,NULL,'xitongadmin',NULL,'');
/*!40000 ALTER TABLE `edu_sys_role` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table edu_sys_setup
#

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
INSERT INTO `edu_sys_setup` VALUES (1,'1,2',1,1,1,1,NULL,NULL,NULL,NULL,'xitongadmin','2014-04-28 18:20:23','hnadmin','2014-05-15 17:19:42');
/*!40000 ALTER TABLE `edu_sys_setup` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table edu_sys_signet
#

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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
INSERT INTO `edu_sys_signet` VALUES (1,'sdf','/photo/1400145209374.jpg',0,'李翠翠','2014-05-15',' 湖北管理员','2014-05-16');
INSERT INTO `edu_sys_signet` VALUES (2,'sdf','/photo/1400205272358.jpg',1,' 湖北管理员','2014-05-16',' 湖北管理员','2014-05-16');
/*!40000 ALTER TABLE `edu_sys_signet` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table edu_target_by_year
#

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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
INSERT INTO `edu_target_by_year` VALUES (2,'2014','0','20',1,1,'黑龙江省',2,'哈尔滨',4,'呼兰区',26,'哈市呼兰区莲花中心校',NULL,'2014-05-11','quxianadmin','2014-05-11');
INSERT INTO `edu_target_by_year` VALUES (3,'2013','0','60',1,1,'黑龙江省',NULL,'',NULL,'',NULL,'','xuexiaoadmin','2014-05-11','xuexiaoadmin','2014-05-11');
INSERT INTO `edu_target_by_year` VALUES (4,'2013','0','2',1,1,'黑龙江省',2,'哈尔滨',3,'阿城区',23,'哈市阿城区玉泉中心小学','shishiadmin1','2014-05-12','shishiadmin1','2014-05-12');
INSERT INTO `edu_target_by_year` VALUES (6,'2014','0','3',1,89,'湖北省',NULL,'',NULL,'',NULL,'','hbadmin','2014-05-13','hbadmin','2014-05-13');
INSERT INTO `edu_target_by_year` VALUES (7,'2014','0','4',1,100,'湖南省',NULL,'',NULL,'',NULL,'','hnssadmin1','2014-05-15','hnssadmin1','2014-05-15');
INSERT INTO `edu_target_by_year` VALUES (8,'2014',NULL,'50',1,114,'甘肃省',115,'兰州市',117,'城关区',92,'城关区小学','gsssadmin1','2014-05-16','gsssadmin1','2014-05-16');
/*!40000 ALTER TABLE `edu_target_by_year` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table edu_teacher_basic_info
#

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=215 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
INSERT INTO `edu_teacher_basic_info` VALUES (149,293,NULL,NULL,NULL,'2',NULL,NULL,'17818812121',NULL,NULL,'test1@173.com',NULL,NULL,NULL,1,'hbadmin','hbadmin','2014-05-13 10:36:36','2014-05-13 10:36:36',1);
INSERT INTO `edu_teacher_basic_info` VALUES (150,294,NULL,NULL,NULL,'2',NULL,NULL,'17818812122',NULL,NULL,'test2@8718.com',NULL,NULL,NULL,1,'hbadmin','hbadmin','2014-05-13 10:36:36','2014-05-13 10:36:36',1);
INSERT INTO `edu_teacher_basic_info` VALUES (151,295,NULL,NULL,NULL,'2',NULL,NULL,'17818812123',NULL,NULL,NULL,NULL,NULL,NULL,1,'hbadmin','hbadmin','2014-05-13 10:36:36','2014-05-13 10:36:36',1);
INSERT INTO `edu_teacher_basic_info` VALUES (152,296,NULL,NULL,NULL,'2',NULL,NULL,'17818812124',NULL,NULL,NULL,NULL,NULL,NULL,1,'hbadmin','hbadmin','2014-05-13 10:36:36','2014-05-13 10:36:36',1);
INSERT INTO `edu_teacher_basic_info` VALUES (153,297,NULL,NULL,NULL,'2',NULL,NULL,'17818812125',NULL,NULL,NULL,NULL,NULL,NULL,1,'hbadmin','hbadmin','2014-05-13 10:36:36','2014-05-13 10:36:36',1);
INSERT INTO `edu_teacher_basic_info` VALUES (154,298,NULL,NULL,NULL,'2',NULL,NULL,'17818812126',NULL,NULL,NULL,NULL,NULL,NULL,1,'hbadmin','hbadmin','2014-05-13 10:36:36','2014-05-13 10:36:36',1);
INSERT INTO `edu_teacher_basic_info` VALUES (155,299,NULL,NULL,NULL,'1',NULL,NULL,'17818812127',NULL,NULL,NULL,NULL,NULL,NULL,1,'hbadmin','hbadmin','2014-05-13 10:36:36','2014-05-13 10:36:36',1);
INSERT INTO `edu_teacher_basic_info` VALUES (156,300,NULL,NULL,NULL,'1',NULL,NULL,'17818812128',NULL,NULL,'asdf@192.com',NULL,NULL,NULL,1,'hbadmin','hbadmin','2014-05-13 10:36:36','2014-05-13 10:36:36',1);
INSERT INTO `edu_teacher_basic_info` VALUES (157,301,NULL,NULL,NULL,'1',NULL,NULL,'17818812129',NULL,NULL,NULL,NULL,NULL,NULL,1,'hbadmin','hbadmin','2014-05-13 10:36:36','2014-05-13 10:36:36',1);
INSERT INTO `edu_teacher_basic_info` VALUES (158,302,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'hbadmin','hbadmin','2014-05-13 10:40:03','2014-05-13 10:40:03',1);
INSERT INTO `edu_teacher_basic_info` VALUES (159,303,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'dishiadmin','dishiadmin','2014-05-13 11:20:19','2014-05-13 11:20:19',1);
INSERT INTO `edu_teacher_basic_info` VALUES (160,304,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'hbadmin','hbadmin','2014-05-13 14:55:59','2014-05-13 14:55:59',1);
INSERT INTO `edu_teacher_basic_info` VALUES (161,328,NULL,NULL,NULL,'2',NULL,NULL,'13818812121',NULL,NULL,'test1@173.com',NULL,NULL,NULL,1,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-14 15:33:41',1);
INSERT INTO `edu_teacher_basic_info` VALUES (162,329,NULL,NULL,NULL,'2',NULL,NULL,'13818812122',NULL,NULL,'test2@8718.com',NULL,NULL,NULL,1,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-14 15:33:41',0);
INSERT INTO `edu_teacher_basic_info` VALUES (163,330,NULL,NULL,NULL,'2',NULL,NULL,'13818812123',NULL,NULL,NULL,NULL,NULL,NULL,1,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-14 15:33:41',0);
INSERT INTO `edu_teacher_basic_info` VALUES (164,331,NULL,NULL,NULL,'2',NULL,NULL,'13818812124',NULL,NULL,NULL,NULL,NULL,NULL,1,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-14 15:33:41',1);
INSERT INTO `edu_teacher_basic_info` VALUES (165,332,NULL,NULL,NULL,'2',NULL,NULL,'13818812125',NULL,NULL,NULL,NULL,NULL,NULL,1,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-14 15:33:41',0);
INSERT INTO `edu_teacher_basic_info` VALUES (166,333,NULL,NULL,NULL,'2',NULL,NULL,'13818812126',NULL,NULL,NULL,NULL,NULL,NULL,1,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-14 15:33:41',1);
INSERT INTO `edu_teacher_basic_info` VALUES (167,334,NULL,NULL,NULL,'1',NULL,NULL,'13818812127',NULL,NULL,NULL,NULL,NULL,NULL,1,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-14 15:33:41',1);
INSERT INTO `edu_teacher_basic_info` VALUES (168,335,NULL,NULL,NULL,'1',NULL,NULL,'13818812128',NULL,NULL,'asdf@192.com',NULL,NULL,NULL,1,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-14 15:33:41',0);
INSERT INTO `edu_teacher_basic_info` VALUES (169,336,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'hnadmin','hnadmin','2014-05-14 15:52:00','2014-05-14 15:52:00',0);
INSERT INTO `edu_teacher_basic_info` VALUES (170,330,NULL,NULL,NULL,'2',NULL,NULL,'13818812123',NULL,NULL,NULL,NULL,NULL,NULL,2,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-14 17:22:14',1);
INSERT INTO `edu_teacher_basic_info` VALUES (171,330,NULL,NULL,NULL,'2',NULL,NULL,'13818812123',NULL,NULL,NULL,NULL,NULL,NULL,2,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-14 17:22:14',1);
INSERT INTO `edu_teacher_basic_info` VALUES (172,335,NULL,NULL,NULL,'1',NULL,NULL,'13818812128',NULL,NULL,'asdf@192.com',NULL,NULL,NULL,2,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-15 13:58:56',0);
INSERT INTO `edu_teacher_basic_info` VALUES (173,329,NULL,NULL,NULL,'2',NULL,NULL,'13818812122',NULL,NULL,'test2@8718.com',NULL,NULL,NULL,2,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-15 14:10:49',0);
INSERT INTO `edu_teacher_basic_info` VALUES (174,336,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2,'hnadmin','hnadmin','2014-05-14 15:52:00','2014-05-15 14:18:00',1);
INSERT INTO `edu_teacher_basic_info` VALUES (175,329,NULL,NULL,NULL,'2',NULL,NULL,'13818812122',NULL,NULL,'test2@8718.com',NULL,NULL,NULL,3,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-15 14:24:39',0);
INSERT INTO `edu_teacher_basic_info` VALUES (176,329,NULL,NULL,NULL,'2',NULL,NULL,'13818812122',NULL,NULL,'test2@8718.com',NULL,NULL,NULL,4,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-15 14:25:48',0);
INSERT INTO `edu_teacher_basic_info` VALUES (177,329,NULL,NULL,NULL,'2',NULL,NULL,'13818812122',NULL,NULL,'test2@8718.com',NULL,NULL,NULL,5,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-15 14:28:17',0);
INSERT INTO `edu_teacher_basic_info` VALUES (178,329,NULL,NULL,NULL,'2',NULL,NULL,'13818812122',NULL,NULL,'test2@8718.com',NULL,NULL,NULL,6,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-15 14:29:19',0);
INSERT INTO `edu_teacher_basic_info` VALUES (179,335,NULL,NULL,NULL,'1',NULL,NULL,'13818812128',NULL,NULL,'asdf@192.com',NULL,NULL,NULL,3,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-15 14:36:42',1);
INSERT INTO `edu_teacher_basic_info` VALUES (180,329,NULL,NULL,NULL,'2',NULL,NULL,'13818812122',NULL,NULL,'test2@8718.com',NULL,NULL,NULL,7,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-15 14:44:00',0);
INSERT INTO `edu_teacher_basic_info` VALUES (181,329,NULL,NULL,NULL,'2',NULL,NULL,'13818812122',NULL,NULL,'test2@8718.com',NULL,NULL,NULL,8,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-15 14:46:49',0);
INSERT INTO `edu_teacher_basic_info` VALUES (183,332,NULL,NULL,NULL,'2',NULL,NULL,'13818812125',NULL,NULL,NULL,NULL,NULL,NULL,2,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-15 15:51:55',0);
INSERT INTO `edu_teacher_basic_info` VALUES (184,332,NULL,NULL,NULL,'2',NULL,NULL,'13818812125',NULL,NULL,NULL,NULL,NULL,NULL,3,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-15 16:10:41',0);
INSERT INTO `edu_teacher_basic_info` VALUES (185,332,NULL,NULL,NULL,'2',NULL,NULL,'13818812125',NULL,NULL,NULL,NULL,NULL,NULL,4,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-15 16:13:40',1);
INSERT INTO `edu_teacher_basic_info` VALUES (203,380,NULL,NULL,NULL,'2',NULL,NULL,'13818812121',NULL,NULL,'test1@173.com',NULL,NULL,NULL,1,'gsadmin','gsadmin','2014-05-15 17:42:26','2014-05-15 17:42:26',1);
INSERT INTO `edu_teacher_basic_info` VALUES (204,381,NULL,NULL,NULL,'2',NULL,NULL,'13818812122',NULL,NULL,'test2@8718.com',NULL,NULL,NULL,1,'gsadmin','gsadmin','2014-05-15 17:42:26','2014-05-15 17:42:26',1);
INSERT INTO `edu_teacher_basic_info` VALUES (205,382,NULL,NULL,NULL,'2',NULL,NULL,'13818812123',NULL,NULL,NULL,NULL,NULL,NULL,1,'gsadmin','gsadmin','2014-05-15 17:42:26','2014-05-15 17:42:26',1);
INSERT INTO `edu_teacher_basic_info` VALUES (206,383,NULL,NULL,NULL,'2',NULL,NULL,'13818812124',NULL,NULL,NULL,NULL,NULL,NULL,1,'gsadmin','gsadmin','2014-05-15 17:42:26','2014-05-15 17:42:26',1);
INSERT INTO `edu_teacher_basic_info` VALUES (207,384,NULL,NULL,NULL,'2',NULL,NULL,'13818812125',NULL,NULL,NULL,NULL,NULL,NULL,1,'gsadmin','gsadmin','2014-05-15 17:42:26','2014-05-15 17:42:26',1);
INSERT INTO `edu_teacher_basic_info` VALUES (208,385,NULL,NULL,NULL,'2',NULL,NULL,'13818812126',NULL,NULL,NULL,NULL,NULL,NULL,1,'gsadmin','gsadmin','2014-05-15 17:42:26','2014-05-15 17:42:26',1);
INSERT INTO `edu_teacher_basic_info` VALUES (209,386,NULL,NULL,NULL,'1',NULL,NULL,'13818812127',NULL,NULL,NULL,NULL,NULL,NULL,1,'gsadmin','gsadmin','2014-05-15 17:42:26','2014-05-15 17:42:26',1);
INSERT INTO `edu_teacher_basic_info` VALUES (210,387,NULL,NULL,NULL,'1',NULL,NULL,'13818812128',NULL,NULL,'asdf@192.com',NULL,NULL,NULL,1,'gsadmin','gsadmin','2014-05-15 17:42:26','2014-05-15 17:42:26',1);
INSERT INTO `edu_teacher_basic_info` VALUES (211,388,NULL,NULL,NULL,'2',NULL,NULL,'13818812129',NULL,NULL,NULL,NULL,NULL,NULL,1,'gsadmin','gsadmin','2014-05-15 18:07:58','2014-05-15 18:07:58',1);
INSERT INTO `edu_teacher_basic_info` VALUES (212,389,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'gsadmin','gsadmin','2014-05-15 19:17:09','2014-05-15 19:17:09',1);
INSERT INTO `edu_teacher_basic_info` VALUES (213,390,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'gsadmin','gsadmin','2014-05-15 19:25:25','2014-05-15 19:25:25',1);
INSERT INTO `edu_teacher_basic_info` VALUES (214,391,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'gsadmin','gsadmin','2014-05-15 19:34:58','2014-05-15 19:34:58',1);
/*!40000 ALTER TABLE `edu_teacher_basic_info` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table edu_teacher_education
#

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=228 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
INSERT INTO `edu_teacher_education` VALUES (162,293,5,'本科',1,'学士','1998-03-09','北理工','教育学',1,'hbadmin','hbadmin','2014-05-13 10:36:36','2014-05-13 10:36:36',1,1);
INSERT INTO `edu_teacher_education` VALUES (163,294,NULL,NULL,NULL,NULL,NULL,'','',1,'hbadmin','hbadmin','2014-05-13 10:36:36','2014-05-13 10:36:36',1,1);
INSERT INTO `edu_teacher_education` VALUES (164,295,NULL,NULL,NULL,NULL,NULL,'','',1,'hbadmin','hbadmin','2014-05-13 10:36:36','2014-05-13 10:36:36',1,1);
INSERT INTO `edu_teacher_education` VALUES (165,296,NULL,NULL,NULL,NULL,NULL,'','',1,'hbadmin','hbadmin','2014-05-13 10:36:36','2014-05-13 10:36:36',1,1);
INSERT INTO `edu_teacher_education` VALUES (166,297,NULL,NULL,NULL,NULL,NULL,'','',1,'hbadmin','hbadmin','2014-05-13 10:36:36','2014-05-13 10:36:36',1,1);
INSERT INTO `edu_teacher_education` VALUES (167,298,NULL,NULL,NULL,NULL,NULL,'','',1,'hbadmin','hbadmin','2014-05-13 10:36:36','2014-05-13 10:36:36',1,1);
INSERT INTO `edu_teacher_education` VALUES (168,299,NULL,NULL,NULL,NULL,NULL,'','',1,'hbadmin','hbadmin','2014-05-13 10:36:36','2014-05-13 10:36:36',1,1);
INSERT INTO `edu_teacher_education` VALUES (169,300,5,'本科',1,'学士',NULL,'','',1,'hbadmin','hbadmin','2014-05-13 10:36:36','2014-05-13 10:36:36',1,1);
INSERT INTO `edu_teacher_education` VALUES (170,301,NULL,NULL,NULL,NULL,NULL,'','',1,'hbadmin','hbadmin','2014-05-13 10:36:36','2014-05-13 10:36:36',1,1);
INSERT INTO `edu_teacher_education` VALUES (171,302,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'hbadmin','hbadmin','2014-05-13 10:40:03','2014-05-13 10:40:03',1,1);
INSERT INTO `edu_teacher_education` VALUES (172,303,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'dishiadmin','dishiadmin','2014-05-13 11:20:19','2014-05-13 11:20:19',1,1);
INSERT INTO `edu_teacher_education` VALUES (173,304,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'hbadmin','hbadmin','2014-05-13 14:55:59','2014-05-13 14:55:59',1,1);
INSERT INTO `edu_teacher_education` VALUES (174,328,5,'本科',1,'学士','1998-03-09','北理工','教育学',1,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-14 15:33:41',1,1);
INSERT INTO `edu_teacher_education` VALUES (175,329,NULL,NULL,NULL,NULL,NULL,'','',1,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-14 15:33:41',1,0);
INSERT INTO `edu_teacher_education` VALUES (176,330,NULL,NULL,NULL,NULL,NULL,'','',1,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-14 15:33:41',1,0);
INSERT INTO `edu_teacher_education` VALUES (177,331,NULL,NULL,NULL,NULL,NULL,'','',1,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-14 15:33:41',1,1);
INSERT INTO `edu_teacher_education` VALUES (178,332,NULL,NULL,NULL,NULL,NULL,'','',1,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-14 15:33:41',1,0);
INSERT INTO `edu_teacher_education` VALUES (179,333,NULL,NULL,NULL,NULL,NULL,'','',1,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-14 15:33:41',1,1);
INSERT INTO `edu_teacher_education` VALUES (180,334,NULL,NULL,NULL,NULL,NULL,'','',1,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-14 15:33:41',1,1);
INSERT INTO `edu_teacher_education` VALUES (181,335,5,'本科',1,'学士',NULL,'','',1,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-14 15:33:41',1,0);
INSERT INTO `edu_teacher_education` VALUES (182,336,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'hnadmin','hnadmin','2014-05-14 15:52:00','2014-05-14 15:52:00',1,0);
INSERT INTO `edu_teacher_education` VALUES (183,330,NULL,NULL,NULL,NULL,NULL,'','',1,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-14 17:22:14',2,1);
INSERT INTO `edu_teacher_education` VALUES (184,330,NULL,NULL,NULL,NULL,NULL,'','',1,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-14 17:22:14',2,1);
INSERT INTO `edu_teacher_education` VALUES (185,335,5,'本科',1,'学士',NULL,'','',1,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-15 13:58:56',2,0);
INSERT INTO `edu_teacher_education` VALUES (186,329,NULL,NULL,NULL,NULL,NULL,'','',1,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-15 14:10:49',2,0);
INSERT INTO `edu_teacher_education` VALUES (187,336,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'hnadmin','hnadmin','2014-05-14 15:52:00','2014-05-15 14:18:00',2,1);
INSERT INTO `edu_teacher_education` VALUES (188,329,NULL,NULL,NULL,NULL,NULL,'','',1,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-15 14:24:39',3,0);
INSERT INTO `edu_teacher_education` VALUES (189,329,NULL,NULL,NULL,NULL,NULL,'','',1,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-15 14:25:48',4,0);
INSERT INTO `edu_teacher_education` VALUES (190,329,NULL,NULL,NULL,NULL,NULL,'','',1,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-15 14:28:17',5,0);
INSERT INTO `edu_teacher_education` VALUES (191,329,NULL,NULL,NULL,NULL,NULL,'','',1,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-15 14:29:19',6,0);
INSERT INTO `edu_teacher_education` VALUES (192,335,5,'本科',1,'学士',NULL,'','',1,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-15 14:36:42',3,1);
INSERT INTO `edu_teacher_education` VALUES (193,329,NULL,NULL,NULL,NULL,NULL,'','',1,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-15 14:44:00',7,0);
INSERT INTO `edu_teacher_education` VALUES (194,329,NULL,NULL,NULL,NULL,NULL,'','',1,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-15 14:46:49',8,0);
INSERT INTO `edu_teacher_education` VALUES (195,329,NULL,NULL,NULL,NULL,NULL,'','',1,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-15 14:47:30',9,1);
INSERT INTO `edu_teacher_education` VALUES (196,332,NULL,NULL,NULL,NULL,NULL,'','',1,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-15 15:51:55',2,0);
INSERT INTO `edu_teacher_education` VALUES (197,332,NULL,NULL,NULL,NULL,NULL,'','',1,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-15 16:10:41',3,0);
INSERT INTO `edu_teacher_education` VALUES (198,332,NULL,NULL,NULL,NULL,NULL,'','',1,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-15 16:13:40',4,1);
INSERT INTO `edu_teacher_education` VALUES (216,380,5,'本科',1,'学士','1998-03-09','北理工','教育学',1,'gsadmin','gsadmin','2014-05-15 17:42:26','2014-05-15 17:42:26',1,1);
INSERT INTO `edu_teacher_education` VALUES (217,381,NULL,NULL,NULL,NULL,NULL,'','',1,'gsadmin','gsadmin','2014-05-15 17:42:26','2014-05-15 17:42:26',1,1);
INSERT INTO `edu_teacher_education` VALUES (218,382,NULL,NULL,NULL,NULL,NULL,'','',1,'gsadmin','gsadmin','2014-05-15 17:42:26','2014-05-15 17:42:26',1,1);
INSERT INTO `edu_teacher_education` VALUES (219,383,NULL,NULL,NULL,NULL,NULL,'','',1,'gsadmin','gsadmin','2014-05-15 17:42:26','2014-05-15 17:42:26',1,1);
INSERT INTO `edu_teacher_education` VALUES (220,384,NULL,NULL,NULL,NULL,NULL,'','',1,'gsadmin','gsadmin','2014-05-15 17:42:26','2014-05-15 17:42:26',1,1);
INSERT INTO `edu_teacher_education` VALUES (221,385,NULL,NULL,NULL,NULL,NULL,'','',1,'gsadmin','gsadmin','2014-05-15 17:42:26','2014-05-15 17:42:26',1,1);
INSERT INTO `edu_teacher_education` VALUES (222,386,NULL,NULL,NULL,NULL,NULL,'','',1,'gsadmin','gsadmin','2014-05-15 17:42:26','2014-05-15 17:42:26',1,1);
INSERT INTO `edu_teacher_education` VALUES (223,387,5,'本科',1,'学士',NULL,'','',1,'gsadmin','gsadmin','2014-05-15 17:42:26','2014-05-15 17:42:26',1,1);
INSERT INTO `edu_teacher_education` VALUES (224,388,NULL,NULL,NULL,NULL,NULL,'','',1,'gsadmin','gsadmin','2014-05-15 18:07:58','2014-05-15 18:07:58',1,1);
INSERT INTO `edu_teacher_education` VALUES (225,389,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'gsadmin','gsadmin','2014-05-15 19:17:09','2014-05-15 19:17:09',1,1);
INSERT INTO `edu_teacher_education` VALUES (226,390,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'gsadmin','gsadmin','2014-05-15 19:25:25','2014-05-15 19:25:25',1,1);
INSERT INTO `edu_teacher_education` VALUES (227,391,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,'gsadmin','gsadmin','2014-05-15 19:34:58','2014-05-15 19:34:58',1,1);
/*!40000 ALTER TABLE `edu_teacher_education` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table edu_teacher_import_history
#

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='教师信息导入历史记录表';
INSERT INTO `edu_teacher_import_history` VALUES (2,'2014-05-13 10:36:36','hbadmin',9,0,'import_teacher0513.xlsx','',NULL,' 湖北管理员',2014);
INSERT INTO `edu_teacher_import_history` VALUES (3,'2014-05-14 15:33:41','hnadmin',8,0,'import_teacher0514.xlsx','',NULL,' 李蕊',2014);
INSERT INTO `edu_teacher_import_history` VALUES (7,'2014-05-15 17:42:26','gsadmin',8,0,'副本import_teacher0515.xlsx','/1400146931713/toExl',NULL,'admin',2014);
INSERT INTO `edu_teacher_import_history` VALUES (8,'2014-05-15 18:07:58','gsadmin',1,4,'副本import_teacher0515.xlsx','/1400148449709/toExl',NULL,'admin',2014);
/*!40000 ALTER TABLE `edu_teacher_import_history` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table edu_teacher_info_change_history
#

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
/*!40000 ALTER TABLE `edu_teacher_info_change_history` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table edu_teacher_job
#

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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=168 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
INSERT INTO `edu_teacher_job` VALUES (102,293,NULL,NULL,NULL,'证书001',NULL,NULL,NULL,'一级教师',NULL,'一级教师',NULL,NULL,'校长',NULL,'小学','2','小学语文','1',NULL,1,0,NULL,0,NULL,NULL,'hbadmin','hbadmin','2014-05-13 10:36:36','2014-05-13 10:36:36',1,1,NULL,NULL);
INSERT INTO `edu_teacher_job` VALUES (103,294,NULL,NULL,NULL,'证书002',NULL,NULL,NULL,'',NULL,'',NULL,NULL,'',NULL,'小学','2','小学语文','1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'hbadmin','hbadmin','2014-05-13 10:36:36','2014-05-13 10:36:36',1,1,NULL,NULL);
INSERT INTO `edu_teacher_job` VALUES (104,295,NULL,NULL,NULL,'证书003',NULL,NULL,NULL,'',NULL,'',NULL,NULL,'',NULL,'小学','2','小学语文','1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'hbadmin','hbadmin','2014-05-13 10:36:36','2014-05-13 10:36:36',1,1,NULL,NULL);
INSERT INTO `edu_teacher_job` VALUES (105,296,NULL,NULL,NULL,'证书004',NULL,NULL,NULL,'',NULL,'',NULL,NULL,'',NULL,'小学','2','小学数学','2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'hbadmin','hbadmin','2014-05-13 10:36:36','2014-05-13 10:36:36',1,1,NULL,NULL);
INSERT INTO `edu_teacher_job` VALUES (106,297,NULL,NULL,NULL,'证书005',NULL,NULL,NULL,'',NULL,'',NULL,NULL,'',NULL,'小学','2','小学数学','2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'hbadmin','hbadmin','2014-05-13 10:36:36','2014-05-13 10:36:36',1,1,NULL,NULL);
INSERT INTO `edu_teacher_job` VALUES (107,298,NULL,NULL,NULL,'证书006',NULL,NULL,NULL,'',NULL,'',NULL,NULL,'班主任',NULL,'初中','3','初中语文','5',NULL,1,1,NULL,1,NULL,NULL,'hbadmin','hbadmin','2014-05-13 10:36:36','2014-05-13 10:36:36',1,1,NULL,NULL);
INSERT INTO `edu_teacher_job` VALUES (108,299,NULL,NULL,NULL,'证书007',NULL,NULL,NULL,'',NULL,'',NULL,NULL,'',NULL,'初中','3','初中数学','6',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'hbadmin','hbadmin','2014-05-13 10:36:36','2014-05-13 10:36:36',1,1,NULL,NULL);
INSERT INTO `edu_teacher_job` VALUES (109,300,NULL,NULL,NULL,'证书008',NULL,NULL,NULL,'',NULL,'',NULL,NULL,'',NULL,'小学','2','小学语文','1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'hbadmin','hbadmin','2014-05-13 10:36:36','2014-05-13 10:36:36',1,1,NULL,NULL);
INSERT INTO `edu_teacher_job` VALUES (110,301,NULL,NULL,NULL,'证书009',NULL,NULL,NULL,'',NULL,'',NULL,NULL,'',NULL,'小学','2','小学语文','1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'hbadmin','hbadmin','2014-05-13 10:36:36','2014-05-13 10:36:36',1,1,NULL,NULL);
INSERT INTO `edu_teacher_job` VALUES (111,302,'请选择','',NULL,'',NULL,NULL,NULL,'请选择',NULL,'请选择',NULL,NULL,'',NULL,'小学','2','小学数学','2',0,1,0,0,0,0,0,'hbadmin','hbadmin','2014-05-13','2014-05-13',1,1,NULL,NULL);
INSERT INTO `edu_teacher_job` VALUES (112,303,'请选择','',NULL,'',NULL,NULL,NULL,'请选择',NULL,'请选择',NULL,NULL,'',NULL,'小学','2','小学语文,小学数学,小学美术,小学音乐','1,2,3,4',0,0,0,0,0,0,0,'dishiadmin','dishiadmin','2014-05-13','2014-05-13',1,1,NULL,NULL);
INSERT INTO `edu_teacher_job` VALUES (113,304,'请选择','',NULL,'',NULL,NULL,NULL,'请选择',NULL,'请选择',NULL,NULL,'',NULL,'小学','2','小学语文','1',0,0,0,0,0,0,0,'hbadmin','hbadmin','2014-05-13','2014-05-13',1,1,NULL,NULL);
INSERT INTO `edu_teacher_job` VALUES (115,329,NULL,NULL,NULL,'证书002',NULL,NULL,NULL,'',NULL,'',NULL,NULL,'',NULL,'小学','2','小学语文','1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-14 15:33:41',1,0,NULL,NULL);
INSERT INTO `edu_teacher_job` VALUES (116,330,NULL,NULL,NULL,'证书003',NULL,NULL,NULL,'',NULL,'',NULL,NULL,'',NULL,'小学','2','小学语文','1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-14 15:33:41',1,0,NULL,NULL);
INSERT INTO `edu_teacher_job` VALUES (117,331,NULL,NULL,NULL,'证书004',NULL,NULL,NULL,'',NULL,'',NULL,NULL,'',NULL,'初中','3','初中语文','5',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-14 15:33:41',1,1,NULL,NULL);
INSERT INTO `edu_teacher_job` VALUES (118,332,NULL,NULL,NULL,'证书005',NULL,NULL,NULL,'',NULL,'',NULL,NULL,'',NULL,'初中','3','初中数学','6',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-14 15:33:41',1,0,NULL,NULL);
INSERT INTO `edu_teacher_job` VALUES (121,335,NULL,NULL,NULL,'证书008',NULL,NULL,NULL,'',NULL,'',NULL,NULL,'',NULL,'小学','2','初中数学','6',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-14 15:33:41',1,0,NULL,NULL);
INSERT INTO `edu_teacher_job` VALUES (122,336,'请选择','',NULL,'',NULL,NULL,NULL,'请选择',NULL,'请选择',NULL,NULL,'',NULL,'小学','2','小学语文','1',0,0,0,0,0,0,0,'hnadmin','hnadmin','2014-05-14','2014-05-14',1,0,NULL,NULL);
INSERT INTO `edu_teacher_job` VALUES (123,330,NULL,NULL,NULL,'证书003',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'小学语文,小学数学','1,2','小学语文,小学数学','1,2',NULL,0,0,NULL,0,NULL,NULL,'hnadmin','hnadmin','2014-05-14 17:22:14','2014-05-14 17:22:14',2,1,NULL,NULL);
INSERT INTO `edu_teacher_job` VALUES (124,330,NULL,NULL,NULL,'证书003',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'小学语文,小学数学','1,2','小学语文,小学数学','1,2',NULL,0,0,NULL,0,NULL,NULL,'hnadmin','hnadmin','2014-05-14 17:22:14','2014-05-14 17:22:14',2,1,NULL,NULL);
INSERT INTO `edu_teacher_job` VALUES (128,329,NULL,NULL,NULL,'证书002',NULL,NULL,NULL,'',NULL,'',NULL,NULL,'',NULL,'小学','2','小学语文','1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'hnadmin','hnadmin','2014-05-14 15:33:41','2014-05-15 14:24:39',3,0,NULL,NULL);
INSERT INTO `edu_teacher_job` VALUES (156,380,NULL,NULL,NULL,'证书001',NULL,NULL,NULL,'一级教师',NULL,'一级教师',NULL,NULL,'校长',NULL,'小学','2','小学语文','1',NULL,1,0,NULL,0,NULL,NULL,'gsadmin','gsadmin','2014-05-15 17:42:26','2014-05-15 17:42:26',1,1,NULL,NULL);
INSERT INTO `edu_teacher_job` VALUES (157,381,NULL,NULL,NULL,'证书002',NULL,NULL,NULL,'',NULL,'',NULL,NULL,'',NULL,'小学','2','小学语文','1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'gsadmin','gsadmin','2014-05-15 17:42:26','2014-05-15 17:42:26',1,1,NULL,NULL);
INSERT INTO `edu_teacher_job` VALUES (158,382,NULL,NULL,NULL,'证书003',NULL,NULL,NULL,'',NULL,'',NULL,NULL,'',NULL,'小学','2','小学语文','1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'gsadmin','gsadmin','2014-05-15 17:42:26','2014-05-15 17:42:26',1,1,NULL,NULL);
INSERT INTO `edu_teacher_job` VALUES (159,383,NULL,NULL,NULL,'证书004',NULL,NULL,NULL,'',NULL,'',NULL,NULL,'',NULL,'初中','3','初中语文','5',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'gsadmin','gsadmin','2014-05-15 17:42:26','2014-05-15 17:42:26',1,1,NULL,NULL);
INSERT INTO `edu_teacher_job` VALUES (160,384,NULL,NULL,NULL,'证书005',NULL,NULL,NULL,'',NULL,'',NULL,NULL,'',NULL,'小学','2','小学语文','1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'gsadmin','gsadmin','2014-05-15 17:42:26','2014-05-15 17:42:26',1,1,NULL,NULL);
INSERT INTO `edu_teacher_job` VALUES (161,385,NULL,NULL,NULL,'证书006',NULL,NULL,NULL,'',NULL,'',NULL,NULL,'班主任',NULL,'小学','2','小学语文','1',NULL,1,1,NULL,1,NULL,NULL,'gsadmin','gsadmin','2014-05-15 17:42:26','2014-05-15 17:42:26',1,1,NULL,NULL);
INSERT INTO `edu_teacher_job` VALUES (162,386,NULL,NULL,NULL,'证书007',NULL,NULL,NULL,'',NULL,'',NULL,NULL,'',NULL,'小学','2','小学数学','2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'gsadmin','gsadmin','2014-05-15 17:42:26','2014-05-15 17:42:26',1,1,NULL,NULL);
INSERT INTO `edu_teacher_job` VALUES (163,387,NULL,NULL,NULL,'证书008',NULL,NULL,NULL,'',NULL,'',NULL,NULL,'',NULL,'初中','3','初中语文','5',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'gsadmin','gsadmin','2014-05-15 17:42:26','2014-05-15 17:42:26',1,1,NULL,NULL);
INSERT INTO `edu_teacher_job` VALUES (164,388,NULL,NULL,NULL,'证书009',NULL,NULL,NULL,'',NULL,'',NULL,NULL,'',NULL,'小学','2','小学语文','1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'gsadmin','gsadmin','2014-05-15 18:07:58','2014-05-15 18:07:58',1,1,NULL,NULL);
INSERT INTO `edu_teacher_job` VALUES (165,389,'请选择','',NULL,'',NULL,NULL,NULL,'请选择',NULL,'请选择',NULL,NULL,'',NULL,'小学','2','小学语文','1',0,0,0,0,0,0,0,'gsadmin','gsadmin','2014-05-15','2014-05-15',1,1,NULL,NULL);
INSERT INTO `edu_teacher_job` VALUES (166,390,'请选择','',NULL,'',NULL,NULL,NULL,'请选择',NULL,'请选择',NULL,NULL,'',NULL,'小学','2','小学语文','1',0,0,0,0,0,0,0,'gsadmin','gsadmin','2014-05-15','2014-05-15',1,1,NULL,NULL);
INSERT INTO `edu_teacher_job` VALUES (167,391,'请选择','',NULL,'',NULL,NULL,NULL,'请选择',NULL,'请选择',NULL,NULL,'',NULL,'小学','2','小学语文','1',0,0,0,0,0,0,0,'gsadmin','gsadmin','2014-05-15','2014-05-15',1,1,NULL,NULL);
/*!40000 ALTER TABLE `edu_teacher_job` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table edu_teacher_old_school
#

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
/*!40000 ALTER TABLE `edu_teacher_old_school` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table edu_user
#

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
  `status` int(11) DEFAULT NULL COMMENT '针对教师-信息审核状态 6 未审核 ， 7 审核不通过， 8 在职 ，9 已离退休， 0 删除、44禁用',
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
) ENGINE=InnoDB AUTO_INCREMENT=400 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;
INSERT INTO `edu_user` VALUES (81,'shengadmin','黑龙江省的管理员1',1,'130182198910130919','617052553@qq.com','18511364296',1,'黑龙江省的管理员','123','shengadmin','黑龙江省的管理员','2014-04-11 10:59:32','2014-05-08 16:43:28',1,1,'',NULL,NULL,1,'黑龙江省',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (82,'dishiadmin','哈尔滨市的管理员',2,'130182198910050946','946893886@qq.com','18615277553',1,'哈尔滨市的管理员','123','shengadmin','哈尔滨市的管理员','2014-04-11 10:59:32','2014-05-12 09:34:29',1,1,NULL,NULL,NULL,1,'黑龙江省',2,'哈尔滨市',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (83,'quxianadmin','阿城区的管理员',3,'130182198910130910','123456789@qq.com','15169011358',1,'阿城区的管理员','123','shengadmin','shengadmin','2014-04-11 10:59:32','2014-04-11 10:59:39',1,1,'',NULL,'',1,'黑龙江省',2,'哈尔滨市',3,'阿城区',NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (84,'xuexiaoadmin','学校管理员',4,'130182198910130911','987654321@qq.com','15100800090',1,'学校管理员','123','shengadmin','shengadmin','2014-04-11 10:59:32','2014-04-11 10:59:39',1,1,'',NULL,'',1,'黑龙江省',2,'哈尔滨市',3,'阿城区',9,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (85,'jigouadmin2','教师网管理员',6,'130182198910130912','112233445@qq.com','15133455543',1,'教师网管理员','123','shengadmin','xitongadmin','2014-04-11 10:59:32','2014-04-14 16:20:19',1,1,'',NULL,'',1,'黑龙江省',NULL,'',NULL,'',NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,3);
INSERT INTO `edu_user` VALUES (86,'jigouadmin1','果实网管理员',6,'130182198910130913','111222333@qq.com','15111113111',1,'果实网管理员','123','shengadmin','果实网管理员','2014-04-11 10:59:32','2014-05-06 17:53:44',1,1,'',NULL,'',1,'黑龙江省',NULL,'',NULL,'',NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,2);
INSERT INTO `edu_user` VALUES (87,'xitongadmin','系统管理员',0,'130182198910130914','556677889@qq.com','15122223222',1,'系统管理员','123','shengadmin','xitongadmin','2014-04-11 10:59:32','2014-04-14 16:23:31',1,1,'',1,'',NULL,'',NULL,'',NULL,'',NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (264,'hbadmin',' 湖北管理员',1,' ','','',NULL,NULL,'123','xitongadmin','xitongadmin','2014-05-13 09:52:55','2014-05-13 09:52:55',1,1,NULL,1,NULL,89,'湖北省',NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (265,'whadmin','武汉admin',2,' ','','',NULL,NULL,'123','hbadmin','hbadmin','2014-05-13 09:58:44','2014-05-13 09:58:44',1,1,NULL,1,NULL,89,'湖北省',90,'武汉市',NULL,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (266,'hbjigouadmin1','李念',6,'178191218912128881','','',NULL,NULL,'111111',NULL,NULL,'2014-05-13 10:01:56','2014-05-13 10:01:56',1,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,86);
INSERT INTO `edu_user` VALUES (267,'hbcpadmin2','王欢',6,'167171217121712121','','',NULL,NULL,'111111',NULL,NULL,'2014-05-13 10:03:14','2014-05-13 10:03:14',1,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,87);
INSERT INTO `edu_user` VALUES (268,'hbcpadmin1','湖北承培一',6,'111111111111111111','','',NULL,NULL,'111111',NULL,NULL,'2014-05-13 10:03:38','2014-05-13 10:03:38',1,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,86);
INSERT INTO `edu_user` VALUES (269,'hbssadmin1','刘琦',7,'178191191921218881','','',NULL,NULL,'111111',NULL,NULL,'2014-05-13 10:04:08','2014-05-13 10:04:08',1,1,'',NULL,NULL,89,'湖北省',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,84);
INSERT INTO `edu_user` VALUES (270,'hbssadmin2','马骁',7,'167181821288812121','','',NULL,NULL,'111111',NULL,NULL,'2014-05-13 10:04:56','2014-05-13 10:04:56',1,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,85);
INSERT INTO `edu_user` VALUES (271,'xt1509','admin',0,NULL,NULL,NULL,NULL,NULL,'793087','hbadmin','hbadmin','2014-05-13 10:07:54','2014-05-13 10:07:54',1,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (272,'hb2900019657','admin',2,'','','',NULL,NULL,'111111','hbadmin','hbadmin','2014-05-13 10:10:09','2014-05-13 14:24:04',1,1,NULL,1,NULL,89,'湖北省',90,'武汉市',NULL,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (273,'hb29000119852','admin',3,NULL,NULL,NULL,NULL,NULL,'129735','hbadmin','hbadmin','2014-05-13 10:10:09','2014-05-13 10:10:09',1,1,NULL,NULL,NULL,89,'湖北省',90,'武汉市',92,'江汉区',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (274,'hbXX5922','admin',4,NULL,NULL,NULL,NULL,NULL,'962258','hbadmin','hbadmin','2014-05-13 10:10:09','2014-05-13 10:10:09',1,1,NULL,NULL,NULL,89,'湖北省',90,'武汉市',92,'江汉区',75,'江汉区小学',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (275,'hbXX4720','admin',4,NULL,NULL,NULL,NULL,NULL,'270020','hbadmin','hbadmin','2014-05-13 10:10:09','2014-05-13 10:10:09',1,1,NULL,NULL,NULL,89,'湖北省',90,'武汉市',92,'江汉区',78,'武汉市一小',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (276,'hb29000126479','admin',3,NULL,NULL,NULL,NULL,NULL,'894768','hbadmin','hbadmin','2014-05-13 10:10:09','2014-05-13 10:10:09',1,1,NULL,NULL,NULL,89,'湖北省',90,'武汉市',93,'汉阳区',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (277,'hbXX9052','admin',4,NULL,NULL,NULL,NULL,NULL,'359583','hbadmin','hbadmin','2014-05-13 10:10:09','2014-05-13 10:10:09',1,1,NULL,NULL,NULL,89,'湖北省',90,'武汉市',93,'汉阳区',76,'汉阳区小学',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (278,'hb29000139754','admin',3,NULL,NULL,NULL,NULL,NULL,'626919','hbadmin','hbadmin','2014-05-13 10:10:09','2014-05-13 10:10:09',1,1,NULL,NULL,NULL,89,'湖北省',90,'武汉市',94,'武昌区',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (279,'hbXX2417','admin',4,NULL,NULL,NULL,NULL,NULL,'584743','hbadmin','hbadmin','2014-05-13 10:10:09','2014-05-13 10:10:09',1,1,NULL,NULL,NULL,89,'湖北省',90,'武汉市',94,'武昌区',72,'武昌区实验小学',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (280,'hb29000144826','admin',3,NULL,NULL,NULL,NULL,NULL,'773019','hbadmin','hbadmin','2014-05-13 10:10:09','2014-05-13 10:10:09',1,1,NULL,NULL,NULL,89,'湖北省',90,'武汉市',95,'青山区',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (281,'hbXX4535','admin',4,NULL,NULL,NULL,NULL,NULL,'136132','hbadmin','hbadmin','2014-05-13 10:10:09','2014-05-13 10:10:09',1,1,NULL,NULL,NULL,89,'湖北省',90,'武汉市',95,'青山区',71,'青山区初中',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (282,'hb2900024880','admin',2,'','','',NULL,NULL,'111111','hbadmin','hbadmin','2014-05-13 10:10:09','2014-05-13 10:49:48',1,1,NULL,1,NULL,89,'湖北省',91,'宜昌市',NULL,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (283,'hb29000216170','admin',3,NULL,NULL,NULL,NULL,NULL,'195216','hbadmin','hbadmin','2014-05-13 10:10:09','2014-05-13 10:10:09',1,1,NULL,NULL,NULL,89,'湖北省',91,'宜昌市',96,'西陵区',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (284,'hbXX4100','admin',4,NULL,NULL,NULL,NULL,NULL,'291750','hbadmin','hbadmin','2014-05-13 10:10:09','2014-05-13 10:10:09',1,1,NULL,NULL,NULL,89,'湖北省',91,'宜昌市',96,'西陵区',70,'西陵区初中',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (285,'hb29000223123','admin',3,NULL,NULL,NULL,NULL,NULL,'580673','hbadmin','hbadmin','2014-05-13 10:10:09','2014-05-13 10:10:09',1,1,NULL,NULL,NULL,89,'湖北省',91,'宜昌市',97,'伍家岗区',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (286,'hbXX6555','admin',4,NULL,NULL,NULL,NULL,NULL,'938818','hbadmin','hbadmin','2014-05-13 10:10:09','2014-05-13 10:10:09',1,1,NULL,NULL,NULL,89,'湖北省',91,'宜昌市',97,'伍家岗区',74,'伍家岗小学',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (287,'hb29000231829','admin',3,NULL,NULL,NULL,NULL,NULL,'294960','hbadmin','hbadmin','2014-05-13 10:10:09','2014-05-13 10:10:09',1,1,NULL,NULL,NULL,89,'湖北省',91,'宜昌市',98,'点军区',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (288,'hbXX9679','admin',4,NULL,NULL,NULL,NULL,NULL,'169548','hbadmin','hbadmin','2014-05-13 10:10:09','2014-05-13 10:10:09',1,1,NULL,NULL,NULL,89,'湖北省',91,'宜昌市',98,'点军区',73,'点军区小学',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (289,'hb29000241034','admin',3,NULL,NULL,NULL,NULL,NULL,'630897','hbadmin','hbadmin','2014-05-13 10:10:09','2014-05-13 10:10:09',1,1,NULL,NULL,NULL,89,'湖北省',91,'宜昌市',99,'夷陵区',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (290,'hbXX0051','夷陵区初中管理员',4,'','','',NULL,NULL,'123','hbadmin','hbadmin','2014-05-13 10:10:09','2014-05-13 17:18:31',1,1,NULL,1,NULL,89,'湖北省',91,'宜昌市',99,'夷陵区',69,'夷陵区初中','',NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (291,'whssadmin1','武汉实施一',7,'211111111111111111','','',NULL,NULL,'111111',NULL,NULL,'2014-05-13 10:30:40','2014-05-13 10:30:40',1,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,88);
INSERT INTO `edu_user` VALUES (292,'whcpadmin1','武汉承培一',6,'123456789011111111','','',NULL,NULL,'111111',NULL,NULL,'2014-05-13 10:31:24','2014-05-13 10:31:24',1,1,'',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,89);
INSERT INTO `edu_user` VALUES (293,'jiaoshi1','王明',5,'189101212188811111','test1@173.com','17818812121',NULL,NULL,'123','hbadmin','hbadmin','2014-05-13 10:36:37','2014-05-13 10:38:06',8,1,'ab001',0,NULL,89,NULL,90,NULL,92,NULL,75,'江汉区小学',NULL,' 湖北管理员','2014-05-13 10:38:06','pass',NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (294,'jiaoshi2','王力',5,'189101212188811112','test2@8718.com','17818812122',NULL,NULL,'123','hbadmin','hbadmin','2014-05-13 10:36:37','2014-05-13 10:38:06',8,1,'ab002',1,NULL,89,NULL,90,NULL,92,NULL,78,'武汉市一小',NULL,' 湖北管理员','2014-05-13 10:38:06','pass',NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (295,'jiaoshi3','赖长兴',5,'189101212188811113',NULL,'17818812123',NULL,NULL,'123','hbadmin','hbadmin','2014-05-13 10:36:37','2014-05-13 10:38:06',8,1,'ab003',0,NULL,89,NULL,90,NULL,93,NULL,76,'汉阳区小学',NULL,' 湖北管理员','2014-05-13 10:38:06','pass',NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (296,'jiaoshi4','杨钰莹',5,'189101212188811114',NULL,'17818812124',NULL,NULL,'123','hbadmin','hbadmin','2014-05-13 10:36:37','2014-05-13 10:38:06',8,1,'ab004',0,NULL,89,NULL,90,NULL,93,NULL,76,'汉阳区小学',NULL,' 湖北管理员','2014-05-13 10:38:06','pass',NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (297,'jiaoshi5','赖伟峰',5,'189101212188811115',NULL,'17818812125',NULL,NULL,'123','hbadmin','hbadmin','2014-05-13 10:36:37','2014-05-13 10:38:06',8,1,'ab005',0,NULL,89,NULL,90,NULL,92,NULL,78,'武汉市一小',NULL,' 湖北管理员','2014-05-13 10:38:06','pass',NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (298,'jiaoshi6','李亚',5,'189101212188811116',NULL,'17818812126',NULL,NULL,'123','hbadmin','hbadmin','2014-05-13 10:36:37','2014-05-13 10:38:06',8,1,'ab006',0,NULL,89,NULL,91,NULL,96,NULL,70,'西陵区初中',NULL,' 湖北管理员','2014-05-13 10:38:06','pass',NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (299,'jiaoshi7','李峰',5,'189101212188811117',NULL,'17818812127',NULL,NULL,'123','hbadmin','hbadmin','2014-05-13 10:36:37','2014-05-13 10:38:06',8,1,'ab007',0,NULL,89,NULL,91,NULL,96,NULL,70,'西陵区初中',NULL,' 湖北管理员','2014-05-13 10:38:06','pass',NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (300,'jiaoshi8','黄欢',5,'189101212188811118','asdf@192.com','17818812128',NULL,NULL,'123','hbadmin','hbadmin','2014-05-13 10:36:37','2014-05-13 10:38:06',8,1,'ab008',0,NULL,89,NULL,91,NULL,97,NULL,74,'伍家岗小学',NULL,' 湖北管理员','2014-05-13 10:38:06','pass',NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (301,'jiaoshi9','李梅',5,'189101212188811119',NULL,'17818812129',NULL,NULL,'123','hbadmin','hbadmin','2014-05-13 10:36:37','2014-05-13 10:38:06',8,1,'ab009',1,NULL,89,NULL,91,NULL,97,NULL,74,'伍家岗小学',NULL,' 湖北管理员','2014-05-13 10:38:06','pass',NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (302,'jiaoshi10','王雷',5,'189101212199911221',NULL,NULL,NULL,NULL,'123','hbadmin','hbadmin','2014-05-13 10:40:03','2014-05-13 10:40:37',8,1,'45',1,'',89,'湖北省',91,'宜昌市',98,'点军区',73,'点军区小学',NULL,' 湖北管理员','2014-05-13 10:40:37','通过',NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (303,'test90','圆圆',5,'230987320913092038',NULL,NULL,NULL,NULL,'123','dishiadmin','dishiadmin','2014-05-13 11:20:19','2014-05-13 11:20:19',8,1,'90',1,'',1,'黑龙江省',2,'哈尔滨',3,'阿城区',3,'阿城区',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (304,'jiaoshi11','木子',5,'178191212199991212',NULL,NULL,NULL,NULL,'123','hbadmin','hbadmin','2014-05-13 14:55:59','2014-05-13 14:56:40',8,1,'678',0,'',89,'湖北省',90,'武汉市',92,'江汉区',78,'武汉市一小',NULL,' 湖北管理员','2014-05-13 14:56:40','pass',NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (305,'hnadmin',' 李蕊',1,' 178191212199992121','','',NULL,NULL,'123','xitongadmin','xitongadmin','2014-05-14 14:35:20','2014-05-14 14:35:20',1,1,NULL,0,NULL,100,'湖南省',NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (306,'hnssadmin1','李翠翠',7,'167177218181218881','','',NULL,NULL,'111111',NULL,NULL,'2014-05-14 14:40:19','2014-05-14 14:40:19',1,1,'',NULL,NULL,100,'湖南省',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,96);
INSERT INTO `edu_user` VALUES (307,'hnssadmin2','宋娟',7,'178181212188881212','','',NULL,NULL,'111111',NULL,NULL,'2014-05-14 14:40:52','2014-05-14 14:40:52',1,1,'',NULL,NULL,100,'湖南省',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,97);
INSERT INTO `edu_user` VALUES (308,'hncpadmin1','王颖',6,'176151521161612121','','',NULL,NULL,'111111',NULL,NULL,'2014-05-14 14:41:42','2014-05-14 14:41:42',1,1,'',NULL,NULL,100,'湖南省',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,98);
INSERT INTO `edu_user` VALUES (309,'hncpadmin2','刘伟',6,'189111919121219991','','',NULL,NULL,'111111',NULL,'hnadmin','2014-05-14 14:42:35','2014-05-14 16:24:48',1,2,'',NULL,NULL,100,'湖南省',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,99);
INSERT INTO `edu_user` VALUES (310,'hncs39000113782','admin',3,NULL,NULL,NULL,NULL,NULL,'491766','hnadmin','hnadmin','2014-05-14 14:43:35','2014-05-14 14:43:35',1,1,NULL,NULL,NULL,100,'湖南省',101,'长沙市',103,'芙蓉区',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (311,'hncsXX5403','admin',4,NULL,NULL,NULL,NULL,NULL,'373355','hnadmin','hnadmin','2014-05-14 14:43:35','2014-05-14 14:43:35',1,1,NULL,NULL,NULL,100,'湖南省',101,'长沙市',103,'芙蓉区',82,'芙蓉区小学',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (312,'hncs39000118888','admin',3,NULL,NULL,NULL,NULL,NULL,'739705','hnadmin','hnadmin','2014-05-14 14:43:35','2014-05-14 14:43:35',1,1,NULL,NULL,NULL,100,'湖南省',101,'长沙市',104,'天心区',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (313,'hncsXX4493','admin',4,NULL,NULL,NULL,NULL,NULL,'734025','hnadmin','hnadmin','2014-05-14 14:43:35','2014-05-14 14:43:35',1,1,NULL,NULL,NULL,100,'湖南省',101,'长沙市',104,'天心区',83,'天心区小学',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (314,'hncs39000117523','admin',3,NULL,NULL,NULL,NULL,NULL,'642843','hnadmin','hnadmin','2014-05-14 14:43:35','2014-05-14 14:43:35',1,1,NULL,NULL,NULL,100,'湖南省',101,'长沙市',105,'望城区',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (315,'hncsXX6592','admin',4,NULL,NULL,NULL,NULL,NULL,'032490','hnadmin','hnadmin','2014-05-14 14:43:35','2014-05-14 14:43:35',1,1,NULL,NULL,NULL,100,'湖南省',101,'长沙市',105,'望城区',81,'望城区实验小学',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (316,'hncs39000119152','admin',3,NULL,NULL,NULL,NULL,NULL,'534653','hnadmin','hnadmin','2014-05-14 14:43:35','2014-05-14 14:43:35',1,1,NULL,NULL,NULL,100,'湖南省',101,'长沙市',106,'雨花区',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (317,'hncsXX0652','admin',4,NULL,NULL,NULL,NULL,NULL,'167971','hnadmin','hnadmin','2014-05-14 14:43:35','2014-05-14 14:43:35',1,1,NULL,NULL,NULL,100,'湖南省',101,'长沙市',106,'雨花区',86,'雨花区初中',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (318,'hncs3900019030','admin',2,'','','',NULL,NULL,'111111','hnadmin','hnadmin','2014-05-14 14:46:40','2014-05-14 14:47:53',1,1,NULL,1,NULL,100,'湖南省',101,'长沙市',NULL,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (319,'hnxt3900020281','admin',2,NULL,NULL,NULL,NULL,NULL,'662272','hnadmin','hnadmin','2014-05-14 14:47:06','2014-05-14 14:47:06',1,1,NULL,NULL,NULL,100,'湖南省',102,'湘潭市',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (320,'hnxt39000218552','admin',3,NULL,NULL,NULL,NULL,NULL,'022319','hnadmin','hnadmin','2014-05-14 14:47:06','2014-05-14 14:47:06',1,1,NULL,NULL,NULL,100,'湖南省',102,'湘潭市',107,'雨湖区',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (321,'hnxtXX2894','admin',4,NULL,NULL,NULL,NULL,NULL,'703685','hnadmin','hnadmin','2014-05-14 14:47:06','2014-05-14 14:47:06',1,1,NULL,NULL,NULL,100,'湖南省',102,'湘潭市',107,'雨湖区',79,'雨湖区初中',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (322,'hnxt39000218886','admin',3,NULL,NULL,NULL,NULL,NULL,'992545','hnadmin','hnadmin','2014-05-14 14:47:06','2014-05-14 14:47:06',1,1,NULL,NULL,NULL,100,'湖南省',102,'湘潭市',108,'岳塘区',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (323,'hnxtXX3106','admin',4,NULL,NULL,NULL,NULL,NULL,'480375','hnadmin','hnadmin','2014-05-14 14:47:06','2014-05-14 14:47:06',1,1,NULL,NULL,NULL,100,'湖南省',102,'湘潭市',108,'岳塘区',85,'岳塘区小学',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (324,'hnxt39000217865','admin',3,NULL,NULL,NULL,NULL,NULL,'980970','hnadmin','hnadmin','2014-05-14 14:47:06','2014-05-14 14:47:06',1,1,NULL,NULL,NULL,100,'湖南省',102,'湘潭市',109,'湘乡市',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (325,'hnxtXX1846','admin',4,NULL,NULL,NULL,NULL,NULL,'851189','hnadmin','hnadmin','2014-05-14 14:47:06','2014-05-14 14:47:06',1,1,NULL,NULL,NULL,100,'湖南省',102,'湘潭市',109,'湘乡市',80,'湘乡市小学',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (326,'hnxt39000210028','admin',3,NULL,NULL,NULL,NULL,NULL,'945093','hnadmin','hnadmin','2014-05-14 14:47:06','2014-05-14 14:47:06',1,1,NULL,NULL,NULL,100,'湖南省',102,'湘潭市',110,'韶山市',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (327,'hnxtXX1183','admin',4,'','','',NULL,NULL,'479825','hnadmin','hnadmin','2014-05-14 14:47:06','2014-05-15 10:19:23',1,1,NULL,0,NULL,100,'湖南省',102,'湘潭市',110,'韶山市',84,'韶山初中','',NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (328,'laoshi1','李明',5,'179101212188811111',NULL,NULL,NULL,NULL,'123','hnadmin','hnadmin','2014-05-14','2014-05-15 15:42:08',9,1,'a001',0,'',100,NULL,101,NULL,103,NULL,82,'芙蓉区小学',NULL,' 李蕊','2014-05-14 15:34:02','pass',NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (329,'laoshi2','高力',5,'179101212188811112','','13478882121',0,NULL,'123','hnadmin','高力','2014-05-14','2014-05-15 14:55:30',9,9,'a002',1,'',100,NULL,101,NULL,104,NULL,83,'天心区小学',NULL,' 李蕊','2014-05-14 15:34:02','pass',NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (330,'laoshi3','李长兴',5,'179101212188811113',NULL,NULL,NULL,NULL,'123456','hnadmin','hnadmin','2014-05-14','2014-05-14 17:06:09',8,2,'a003',0,'/photo/1400058349163.jpg',100,NULL,101,NULL,105,NULL,81,'望城区实验小学',NULL,' 李蕊','2014-05-14 15:34:02','pass',NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (331,'laoshi4','潘钰莹',5,'179101212188811114',NULL,NULL,NULL,NULL,'123','hnadmin','hnadmin','2014-05-14','2014-05-14 16:55:15',8,1,'a004',0,'/photo/1400057669179.jpg',100,NULL,101,NULL,106,NULL,86,'雨花区初中',NULL,' 李蕊','2014-05-14 15:34:02','pass',NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (332,'laoshi5','杨伟峰',5,'179101212188811115',NULL,NULL,NULL,NULL,'123','hnadmin','hnadmin','2014-05-14','2014-05-15 15:49:04',8,4,'a005',0,'',100,'null',102,'null',107,'null',79,'雨湖区初中',NULL,' 李蕊','2014-05-14 15:34:02','pass',NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (333,'laoshi6','李亚平',5,'179101212188811116',NULL,NULL,NULL,NULL,'123','hnadmin','hnadmin','2014-05-14','2014-05-14 15:35:54',8,1,'a006',0,'',100,NULL,102,NULL,108,NULL,85,'岳塘区小学',NULL,' 李蕊','2014-05-14 15:34:02','pass',NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (334,'laoshi7','李韦伯',5,'179101212188811117',NULL,NULL,NULL,NULL,'123','hnadmin','hnadmin','2014-05-14','2014-05-14 15:36:49',8,1,'a007',0,'',100,NULL,102,NULL,109,NULL,80,'湘乡市小学',NULL,' 李蕊','2014-05-14 15:34:02','pass',NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (335,'laoshi8','黄雷',5,'179101212188811118',NULL,NULL,NULL,NULL,'123','hnadmin','hnadmin','2014-05-14','2014-05-14 15:36:17',8,3,'a008',0,'',100,NULL,102,NULL,110,NULL,84,'韶山初中',NULL,' 李蕊','2014-05-14 15:34:02','pass',NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (336,'laoshi9','李培',5,'234567190019191111',NULL,NULL,NULL,NULL,'123','hnadmin','hnadmin','2014-05-14','2014-05-14 16:54:10',8,2,'78',1,'/photo/1400057639458.jpg',100,'湖南省',101,'长沙市',104,'天心区',83,'天心区小学',NULL,' 李蕊','2014-05-14 15:52:21','pass',NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (354,'HIH1465','admin',20,NULL,NULL,NULL,NULL,NULL,'168095','hnadmin','hnadmin','2014-05-15 17:19:04','2014-05-15 17:19:04',1,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (355,'gsadmin','admin',1,'','','',NULL,NULL,'123','xitongadmin','xitongadmin','2014-05-15 17:23:56','2014-05-15 17:24:14',1,1,NULL,1,NULL,114,'甘肃省',NULL,NULL,NULL,NULL,NULL,NULL,'',NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (356,'gsssadmin1','刘梅',7,'123678121288881211','','',NULL,NULL,'111111',NULL,NULL,'2014-05-15 17:28:36','2014-05-15 17:28:36',1,1,'',NULL,NULL,114,'甘肃省',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,103);
INSERT INTO `edu_user` VALUES (357,'gsssadmin2','王明',7,'136171212177712121','','',1,'baba','111111',NULL,NULL,'2014-05-15 17:29:08','2014-05-16 09:25:15',1,1,'',NULL,NULL,114,'甘肃省',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,104);
INSERT INTO `edu_user` VALUES (358,'gscpadmin1','王磊',6,'189191322211119992','','',NULL,NULL,'111111',NULL,NULL,'2014-05-15 17:29:53','2014-05-15 17:29:53',1,1,'',NULL,NULL,114,'甘肃省',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,106);
INSERT INTO `edu_user` VALUES (359,'gscpadmin2','李群',6,'178191212199991211','','',NULL,NULL,'111111',NULL,NULL,'2014-05-15 17:31:20','2014-05-15 17:31:20',1,1,'',NULL,NULL,114,'甘肃省',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,106);
INSERT INTO `edu_user` VALUES (360,'gs4900016440','admin',2,NULL,NULL,NULL,NULL,NULL,'642181','gsadmin','gsadmin','2014-05-15 17:32:16','2014-05-15 17:32:16',1,1,NULL,NULL,NULL,114,'甘肃省',115,'兰州市',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (361,'gs49000111174','admin',3,NULL,NULL,NULL,NULL,NULL,'348962','gsadmin','gsadmin','2014-05-15 17:32:16','2014-05-15 17:32:16',1,1,NULL,NULL,NULL,114,'甘肃省',115,'兰州市',117,'城关区',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (362,'gsXX8138','admin',4,NULL,NULL,NULL,NULL,NULL,'955384','gsadmin','gsadmin','2014-05-15 17:32:16','2014-05-15 17:32:16',1,1,NULL,NULL,NULL,114,'甘肃省',115,'兰州市',117,'城关区',92,'城关区小学',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (363,'gsXX5971','admin',4,NULL,NULL,NULL,NULL,NULL,'740618','gsadmin','gsadmin','2014-05-15 17:32:16','2014-05-15 17:32:16',1,1,NULL,NULL,NULL,114,'甘肃省',115,'兰州市',117,'城关区',96,'城关区二小',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (364,'gs49000129876','admin',3,NULL,NULL,NULL,NULL,NULL,'698956','gsadmin','gsadmin','2014-05-15 17:32:16','2014-05-15 17:32:16',1,1,NULL,NULL,NULL,114,'甘肃省',115,'兰州市',118,'西固区',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (365,'gsXX1688','admin',4,NULL,NULL,NULL,NULL,NULL,'781624','gsadmin','gsadmin','2014-05-15 17:32:16','2014-05-15 17:32:16',1,1,NULL,NULL,NULL,114,'甘肃省',115,'兰州市',118,'西固区',94,'西固区小学',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (366,'gs49000133436','admin',3,NULL,NULL,NULL,NULL,NULL,'585509','gsadmin','gsadmin','2014-05-15 17:32:16','2014-05-15 17:32:16',1,1,NULL,NULL,NULL,114,'甘肃省',115,'兰州市',119,'安宁区',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (367,'gsXX4307','admin',4,NULL,NULL,NULL,NULL,NULL,'043006','gsadmin','gsadmin','2014-05-15 17:32:16','2014-05-15 17:32:16',1,1,NULL,NULL,NULL,114,'甘肃省',115,'兰州市',119,'安宁区',95,'安宁区实验小学',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (368,'gs49000146541','admin',3,NULL,NULL,NULL,NULL,NULL,'299876','gsadmin','gsadmin','2014-05-15 17:32:16','2014-05-15 17:32:16',1,1,NULL,NULL,NULL,114,'甘肃省',115,'兰州市',120,'红古区',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (369,'gsXX3972','admin',4,NULL,NULL,NULL,NULL,NULL,'806494','gsadmin','gsadmin','2014-05-15 17:32:16','2014-05-15 17:32:16',1,1,NULL,NULL,NULL,114,'甘肃省',115,'兰州市',120,'红古区',89,'红古区初中',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (370,'gs4900028086','admin',2,NULL,NULL,NULL,NULL,NULL,'866072','gsadmin','gsadmin','2014-05-15 17:32:16','2014-05-15 17:32:16',1,1,NULL,NULL,NULL,114,'甘肃省',116,'天水市',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (371,'gs49000219359','admin',3,NULL,NULL,NULL,NULL,NULL,'006558','gsadmin','gsadmin','2014-05-15 17:32:16','2014-05-15 17:32:16',1,1,NULL,NULL,NULL,114,'甘肃省',116,'天水市',121,'秦州区',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (372,'gsXX1526','admin',4,NULL,NULL,NULL,NULL,NULL,'658462','gsadmin','gsadmin','2014-05-15 17:32:16','2014-05-15 17:32:16',1,1,NULL,NULL,NULL,114,'甘肃省',116,'天水市',121,'秦州区',91,'秦州区小学',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (373,'gs49000228688','admin',3,NULL,NULL,NULL,NULL,NULL,'852904','gsadmin','gsadmin','2014-05-15 17:32:16','2014-05-15 17:32:16',1,1,NULL,NULL,NULL,114,'甘肃省',116,'天水市',122,'麦积区',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (374,'gsXX2205','admin',4,NULL,NULL,NULL,NULL,NULL,'900082','gsadmin','gsadmin','2014-05-15 17:32:16','2014-05-15 17:32:16',1,1,NULL,NULL,NULL,114,'甘肃省',116,'天水市',122,'麦积区',90,'麦积区小学',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (375,'gs49000233861','admin',3,NULL,NULL,NULL,NULL,NULL,'936626','gsadmin','gsadmin','2014-05-15 17:32:16','2014-05-15 17:32:16',1,1,NULL,NULL,NULL,114,'甘肃省',116,'天水市',123,'武山县',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (376,'gsXX8600','admin',4,NULL,NULL,NULL,NULL,NULL,'997463','gsadmin','gsadmin','2014-05-15 17:32:16','2014-05-15 17:32:16',1,1,NULL,NULL,NULL,114,'甘肃省',116,'天水市',123,'武山县',88,'武山县小学',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (377,'gs49000240988','admin',3,NULL,NULL,NULL,NULL,NULL,'198540','gsadmin','gsadmin','2014-05-15 17:32:16','2014-05-15 17:32:16',1,1,NULL,NULL,NULL,114,'甘肃省',116,'天水市',124,'秦安县',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (378,'gsXX9364','admin',4,NULL,NULL,NULL,NULL,NULL,'158965','gsadmin','gsadmin','2014-05-15 17:32:16','2014-05-15 17:32:16',1,1,NULL,NULL,NULL,114,'甘肃省',116,'天水市',124,'秦安县',93,'秦安县初中',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (379,'gscpadmin3','李玉',6,'189171616121216661','','',NULL,NULL,'111111',NULL,NULL,'2014-05-15 17:35:17','2014-05-15 17:35:17',1,1,'',NULL,NULL,114,'甘肃省',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,107);
INSERT INTO `edu_user` VALUES (380,'testone1','杨明',5,'179301212188811111','test1@173.com','13818812121',1,'superman','123','gsadmin','杨明','2014-05-15 17:42:26','2014-05-15 18:11:20',8,1,'te01',0,NULL,114,NULL,115,NULL,117,NULL,92,'城关区小学',NULL,'admin','2014-05-15 17:45:03','pass',NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (381,'testone2','刘超',5,'179301212188811112','test2@8718.com','13818812122',NULL,NULL,'123','gsadmin','gsadmin','2014-05-15 17:42:26','2014-05-15 17:45:14',8,1,'te02',1,NULL,114,NULL,115,NULL,118,NULL,94,'西固区小学',NULL,'admin','2014-05-15 17:45:14','pass',NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (382,'testone3','王兴',5,'179301212188811113',NULL,'13818812123',NULL,NULL,'123','gsadmin','gsadmin','2014-05-15 17:42:26','2014-05-15 17:45:14',8,1,'te03',0,NULL,114,NULL,115,NULL,119,NULL,95,'安宁区实验小学',NULL,'admin','2014-05-15 17:45:14','pass',NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (383,'testone4','庞龙',5,'179301212188811114',NULL,'13818812124',NULL,NULL,'123','gsadmin','gsadmin','2014-05-15 17:42:26','2014-05-15 17:45:14',8,1,'te04',0,NULL,114,NULL,115,NULL,120,NULL,89,'红古区初中',NULL,'admin','2014-05-15 17:45:14','pass',NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (384,'testone5','杨离伟',5,'179301212188811115',NULL,'13818812125',NULL,NULL,'123','gsadmin','gsadmin','2014-05-15 17:42:26','2014-05-15 17:45:14',8,1,'te05',0,NULL,114,NULL,116,NULL,121,NULL,91,'秦州区小学',NULL,'admin','2014-05-15 17:45:14','pass',NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (385,'testone6','小薛',5,'179301212188811116',NULL,'13818812126',NULL,NULL,'123','gsadmin','gsadmin','2014-05-15 17:42:26','2014-05-15 17:45:14',8,1,'te06',0,NULL,114,NULL,116,NULL,122,NULL,90,'麦积区小学',NULL,'admin','2014-05-15 17:45:14','pass',NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (386,'testone7','刘燕',5,'179301212188811117',NULL,'13818812127',NULL,NULL,'123','gsadmin','gsadmin','2014-05-15 17:42:26','2014-05-15 17:45:14',8,1,'te07',0,NULL,114,NULL,116,NULL,123,NULL,88,'武山县小学',NULL,'admin','2014-05-15 17:45:14','pass',NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (387,'testone8','马丁',5,'179301212188811118','asdf@192.com','13818812128',NULL,NULL,'123','gsadmin','gsadmin','2014-05-15 17:42:26','2014-05-15 17:45:14',8,1,'te08',0,NULL,114,NULL,116,NULL,124,NULL,93,'秦安县初中',NULL,'admin','2014-05-15 17:45:14','pass',NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (388,'testone9','王龙',5,'179301212188811110',NULL,'13818812129',NULL,NULL,'123','gsadmin','gsadmin','2014-05-15 18:07:59','2014-05-15 18:07:59',6,1,'te09',0,NULL,114,NULL,115,NULL,119,NULL,95,'安宁区实验小学',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (389,'jiaoshinew','李赞',5,'178190191921219991',NULL,NULL,NULL,NULL,'123','gsadmin','gsadmin','2014-05-15 19:17:09','2014-05-15 19:17:30',8,1,'78',1,'',114,'甘肃省',115,'兰州市',117,'城关区',92,'城关区小学',NULL,'admin','2014-05-15 19:17:30','12',NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (390,'testone10','王五',5,'179777223323232323',NULL,NULL,NULL,NULL,'123','gsadmin','gsadmin','2014-05-15','2014-05-15 19:26:55',8,1,'95',1,'',114,'甘肃省',115,'兰州市',117,'城关区',92,'城关区小学',NULL,'admin','2014-05-15 19:26:55',NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (391,'testone12','李恒',5,'178190191918182121',NULL,NULL,NULL,NULL,'123','gsadmin','gsadmin','2014-05-15 19:34:58','2014-05-15 19:35:19',8,1,'67',1,'',114,'甘肃省',115,'兰州市',117,'城关区',92,'城关区小学',NULL,'admin','2014-05-15 19:35:19',NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (392,'fj60011022','admin',1,NULL,NULL,NULL,NULL,NULL,'292527','xitongadmin','xitongadmin','2014-05-16 10:06:43','2014-05-16 10:06:43',1,1,NULL,NULL,NULL,125,'福建省',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (393,'fj60027747','admin',2,NULL,NULL,NULL,NULL,NULL,'547979','xitongadmin','xitongadmin','2014-05-16 10:06:43','2014-05-16 10:06:43',1,1,NULL,NULL,NULL,125,'福建省',126,'福州市',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (394,'fj60057227','admin',3,NULL,NULL,NULL,NULL,NULL,'682478','xitongadmin','xitongadmin','2014-05-16 10:06:43','2014-05-16 10:06:43',1,1,NULL,NULL,NULL,125,'福建省',126,'福州市',128,'福州一区',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (395,'fjXX7708','admin',4,NULL,NULL,NULL,NULL,NULL,'462154','xitongadmin','xitongadmin','2014-05-16 10:06:43','2014-05-16 10:06:43',1,1,NULL,NULL,NULL,125,'福建省',126,'福州市',128,'福州一区',97,'福州一区一小',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (396,'fj60063234','admin',3,NULL,NULL,NULL,NULL,NULL,'326951','xitongadmin','xitongadmin','2014-05-16 10:06:43','2014-05-16 10:06:43',1,1,NULL,NULL,NULL,125,'福建省',126,'福州市',129,'福州二区',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (397,'fjXX4020','admin',4,NULL,NULL,NULL,NULL,NULL,'491961','xitongadmin','xitongadmin','2014-05-16 10:06:43','2014-05-16 10:06:43',1,1,NULL,NULL,NULL,125,'福建省',126,'福州市',129,'福州二区',98,'福州二区一小',NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (398,'fj60035968','admin',2,NULL,NULL,NULL,NULL,NULL,'230671','xitongadmin','xitongadmin','2014-05-16 10:06:43','2014-05-16 10:06:43',1,1,NULL,NULL,NULL,125,'福建省',127,'福清市',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
INSERT INTO `edu_user` VALUES (399,'fjssadmin1','福建实施员',7,'123456789012345679','','',NULL,NULL,'111111',NULL,NULL,'2014-05-16 10:11:29','2014-05-16 10:11:29',1,1,'',NULL,NULL,125,'福建省',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,108);
/*!40000 ALTER TABLE `edu_user` ENABLE KEYS */;
UNLOCK TABLES;

#
# Table structure for table edu_user_forgotpassword
#

CREATE TABLE `edu_user_forgotpassword` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `code` varchar(64) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_ip` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `uid` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40000 ALTER TABLE `edu_user_forgotpassword` ENABLE KEYS */;
UNLOCK TABLES;

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
