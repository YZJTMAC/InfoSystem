##通知地区关联表
CREATE TABLE `edu_notice_area` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `noticeId` int(11) DEFAULT NULL,
  `areaId` int(11) DEFAULT NULL,
  `schoolId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=240 DEFAULT CHARSET=utf8 COMMENT='通知_地区关联表';
