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
