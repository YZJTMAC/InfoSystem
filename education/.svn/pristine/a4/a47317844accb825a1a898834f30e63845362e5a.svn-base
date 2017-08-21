##将之前的通知修改为短消息
##func_code like '%person%'
update edu_sys_function set func_name = '短消息' where func_code='person_005';

#通知
insert into edu_sys_function(func_name,func_type,func_code,sort) values('通知',3,'person_006',4);

##我的通知：
insert into edu_sys_function(func_name,func_type,func_code,sort) values('我的通知',3,'person_007',5);

#通知建表语句

#通知表
CREATE TABLE `edu_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_by` varchar(255) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `send_user_id` int(11) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `content` text,
  `send_user_name` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `sendType` int(11) DEFAULT NULL,
  `noticeType` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8 COMMENT='通知表';


##通知地区关联表
CREATE TABLE `edu_notice_area` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `noticeId` int(11) DEFAULT NULL,
  `areaId` int(11) DEFAULT NULL,
  `schoolId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=240 DEFAULT CHARSET=utf8 COMMENT='通知_地区关联表';


##通知用户表
CREATE TABLE `edu_notice_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `noticeId` int(11) DEFAULT NULL,
  `noticeType` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `hasRead` int(1) DEFAULT NULL,
  `hasDelete` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8 COMMENT='通知_用户表';
