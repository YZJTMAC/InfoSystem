# MySQL-Front 5.1  (Build 2.7)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;


# Host: 192.168.1.170:3307    Database: edu
# ------------------------------------------------------
# Server version 5.1.54-community

USE `edu`;

#
# Source for table edu_sys_function
#

#
# Dumping data for table edu_sys_function
#

INSERT INTO edu_sys_function(func_name,func_type,func_code,func_url,sort) VALUES ('培训总结(承培)',3,'project_044',NULL,2);
INSERT INTO edu_sys_function(func_name,func_type,func_code,func_url,sort) VALUES ('培训总结(实施)',3,'project_043',NULL,2);
INSERT INTO edu_sys_function(func_name,func_type,func_code,func_url,sort) VALUES ('培训总结(省)',3,'project_042',NULL,2);
update edu_sys_function set func_name='培训总结(教师)' where func_code='project_041' and func_type=3

/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;

#实施机构提交培训材料 liuyiyou 
#更新日期： 2014/11/27
INSERT INTO edu_sys_function(func_name,func_type,func_code,sort) values('提交培训材料',3,'project_051',4);


##通知函数：
#更新日期 2015/02/13
##将之前的通知修改为短消息
update edu_sys_function set func_name = '短消息' where func_code='person_005';

#通知
insert into edu_sys_function(func_name,func_type,func_code,sort) values('通知',3,'person_006',4);

##我的通知：
insert into edu_sys_function(func_name,func_type,func_code,sort) values('我的通知',3,'person_007',5);

