insert into edu_sys_function VALUES(952, '项目证书查询', 3, 'furtheredu_021', null, 5);

alter table edu_project_comment add period_certificate_code varchar(100) comment '学时证书编码' AFTER provinceMemo 

alter table edu_project_comment add project_certificate_code varchar(100) comment '项目证书编码' AFTER period_certificate_code 


INSERT into edu_sys_dictionary values(5421, 1, 'school_establish_type', '学校办别', 
            '公办', 'xb01', 1 );
INSERT into edu_sys_dictionary values(5431, 2, 'school_establish_type', '学校办别', 
            '民办', 'xb02', 1 );
            
ALTER TABLE `edu_school`
ADD COLUMN `school_establish_type_id`  int(5) NULL COMMENT '学校办别（1：公办、2：民办），查看数据字典' AFTER `school_code`,
ADD COLUMN `school_establish_type_name`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '学校办别（民办、公办）' AFTER `school_establish_type_id`;




CREATE PROCEDURE `sp_region`(IN _type INT,IN _dict1_id INT,IN _dict1_type  VARCHAR(100), IN _dict2_type VARCHAR(100))
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
                      WHERE type=0 and (dict1_id = ',_dict1_id,' or dict1_pid=',_dict1_id,')'
											' and dict2_type=''',	_dict2_type,
                      ''' GROUP   BY dict1_id');
    ELSE
         SET @sql = CONCAT('SELECT dict1_id,  dict1_name, dict1_pid,', @sql, ' 
                      FROM    edu_statistic_teacher
                      WHERE type=1 and dict2_type=''',_dict2_type,''' and dict1_type = ''',_dict1_type,'''  GROUP   BY dict1_id');
    END IF;

    

    PREPARE stmt FROM @sql;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
 END;


-- ----------------------------
-- Table structure for fjimport
-- ----------------------------
DROP TABLE IF EXISTS `fjimport`;
CREATE TABLE `fjimport` (
  `city_name` varchar(255) DEFAULT NULL,
  `district_name` varchar(255) DEFAULT NULL,
  `shangbao_num` int(11) DEFAULT NULL,
  `denglu_num` int(11) DEFAULT NULL,
  `canxunlv` float DEFAULT NULL,
  `youxiaoxuexi_num` int(11) DEFAULT NULL,
  `xuexilv` float DEFAULT NULL,
  `hege_num` int(11) DEFAULT NULL,
  `hegelv` float DEFAULT NULL,
  `fabuziyuan_num` int(11) DEFAULT NULL,
  `zuzhihuodong_num` int(11) DEFAULT NULL,
  `gongzuofang_num` int(11) DEFAULT NULL,
  `tijiaozuoye_num` int(11) DEFAULT NULL,
  `xiangmujianbao_num` int(11) DEFAULT NULL,
  UNIQUE KEY `key_fjimport` (`city_name`,`district_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT into edu_sys_function (id, func_name, func_type, func_code, func_url, sort)
 values(999, '能力提升数据导入', 3, 'system_099', null, 10);
 
ALTER TABLE `edu_project`
ADD COLUMN `print_xueshi_certificate`  int(1) NULL COMMENT '是否打印学时证书' AFTER `organization_id`,
ADD COLUMN `print_project_certificate`  int(1) NULL COMMENT '是否打印项目证书' AFTER `print_xueshi_certificate`;


ALTER TABLE `fjimport`
ADD COLUMN `school_name`  varchar(255) NULL AFTER `district_name`;

ALTER TABLE `fjimport`
DROP INDEX `key_fjimport` ,
ADD UNIQUE INDEX `key_fjimport` USING BTREE (`city_name`, `district_name`, `school_name`);

ALTER TABLE `fjimport`
MODIFY COLUMN `city_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地市' FIRST ,
MODIFY COLUMN `district_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '区县' AFTER `city_name`,
MODIFY COLUMN `school_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学校' AFTER `district_name`,
MODIFY COLUMN `shangbao_num`  int(11) NULL DEFAULT NULL COMMENT '上报人数' AFTER `school_name`,
MODIFY COLUMN `denglu_num`  int(11) NULL DEFAULT NULL COMMENT '登陆人数' AFTER `shangbao_num`,
MODIFY COLUMN `canxunlv`  float NULL DEFAULT NULL COMMENT '参训率' AFTER `denglu_num`,
MODIFY COLUMN `youxiaoxuexi_num`  int(11) NULL DEFAULT NULL COMMENT '有效学习人数' AFTER `canxunlv`,
MODIFY COLUMN `xuexilv`  float NULL DEFAULT NULL COMMENT '学习率' AFTER `youxiaoxuexi_num`,
MODIFY COLUMN `hege_num`  int(11) NULL DEFAULT NULL COMMENT '合格人数' AFTER `xuexilv`,
MODIFY COLUMN `hegelv`  float NULL DEFAULT NULL COMMENT '合格率' AFTER `hege_num`,
MODIFY COLUMN `fabuziyuan_num`  int(11) NULL DEFAULT NULL COMMENT '发布资源数' AFTER `hegelv`,
MODIFY COLUMN `zuzhihuodong_num`  int(11) NULL DEFAULT NULL COMMENT '组织活动数' AFTER `fabuziyuan_num`,
MODIFY COLUMN `gongzuofang_num`  int(11) NULL DEFAULT NULL COMMENT '工作坊数' AFTER `zuzhihuodong_num`,
MODIFY COLUMN `tijiaozuoye_num`  int(11) NULL DEFAULT NULL COMMENT '提交作业数' AFTER `gongzuofang_num`,
MODIFY COLUMN `xiangmujianbao_num`  int(11) NULL DEFAULT NULL COMMENT '项目简报数' AFTER `tijiaozuoye_num`;


ALTER TABLE `fjimport`
ADD COLUMN `create_time`  datetime NULL AFTER `xiangmujianbao_num`;

ALTER TABLE `fjimport`
DROP INDEX `key_fjimport`;

ALTER TABLE `fjimport`
ADD COLUMN `create_by`  varchar(255) NULL AFTER `create_time`;

/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : ttt

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2015-11-17 11:23:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for fjimport
-- ----------------------------
DROP TABLE IF EXISTS `fjimport`;
CREATE TABLE `fjimport` (
  `city_name` varchar(255) default NULL COMMENT '地市',
  `district_name` varchar(255) default NULL COMMENT '区县',
  `school_name` varchar(255) default NULL COMMENT '学校',
  `shangbao_num` int(11) default NULL COMMENT '上报人数',
  `denglu_num` int(11) default NULL COMMENT '登陆人数',
  `canxunlv` float default NULL COMMENT '参训率',
  `youxiaoxuexi_num` int(11) default NULL COMMENT '有效学习人数',
  `xuexilv` float default NULL COMMENT '学习率',
  `hege_num` int(11) default NULL COMMENT '合格人数',
  `hegelv` float default NULL COMMENT '合格率',
  `fabuziyuan_num` int(11) default NULL COMMENT '发布资源数',
  `zuzhihuodong_num` int(11) default NULL COMMENT '组织活动数',
  `gongzuofang_num` int(11) default NULL COMMENT '工作坊数',
  `tijiaozuoye_num` int(11) default NULL COMMENT '提交作业数',
  `xiangmujianbao_num` int(11) default NULL COMMENT '项目简报数',
  `create_time` datetime default NULL,
  `create_by` varchar(255) default NULL,
  `city_id` varchar(11) default NULL COMMENT '地市id',
  `district_id` varchar(11) default NULL COMMENT '区县id',
  `school_id` varchar(11) default NULL COMMENT '学校id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : ttt

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2015-11-17 11:23:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for fjimport_history
-- ----------------------------
DROP TABLE IF EXISTS `fjimport_history`;
CREATE TABLE `fjimport_history` (
  `id` int(11) NOT NULL auto_increment,
  `create_date` timestamp NULL default NULL COMMENT '操作日期',
  `create_by` varchar(50) default NULL COMMENT '操作人',
  `import_success_count` int(11) default NULL COMMENT '导入成功数量',
  `imort_fail_count` int(11) default NULL COMMENT '导入失败数量',
  `import_file_name` varchar(100) default NULL COMMENT '导入文件名称',
  `import_fail_url` varchar(200) default '导入失败文件下载路径',
  `import_serial` int(20) default NULL COMMENT '导入流水号',
  `option_real_name` varchar(50) default NULL COMMENT '操作时间',
  `option_year` int(11) default NULL COMMENT '操作年度',
  `history_type` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : ttt

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2015-11-19 14:52:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for fjimport
-- ----------------------------
DROP TABLE IF EXISTS `fjimport`;
CREATE TABLE `fjimport` (
  `city_name` varchar(255) default NULL COMMENT '地市',
  `district_name` varchar(255) default NULL COMMENT '区县',
  `school_name` varchar(255) default NULL COMMENT '学校',
  `shangbao_num` int(11) default NULL COMMENT '上报人数',
  `denglu_num` int(11) default NULL COMMENT '登陆人数',
  `canxunlv` float default NULL COMMENT '参训率',
  `youxiaoxuexi_num` int(11) default NULL COMMENT '有效学习人数',
  `xuexilv` float default NULL COMMENT '学习率',
  `hege_num` int(11) default NULL COMMENT '合格人数',
  `hegelv` float default NULL COMMENT '合格率',
  `fabuziyuan_num` int(11) default NULL COMMENT '发布资源数',
  `zuzhihuodong_num` int(11) default NULL COMMENT '组织活动数',
  `gongzuofang_num` int(11) default NULL COMMENT '工作坊数',
  `tijiaozuoye_num` int(11) default NULL COMMENT '提交作业数',
  `xiangmujianbao_num` int(11) default NULL COMMENT '项目简报数',
  `create_time` datetime default NULL,
  `create_by` varchar(255) default NULL,
  `city_id` varchar(11) default NULL COMMENT '地市id',
  `district_id` varchar(11) default NULL COMMENT '区县id',
  `school_id` varchar(11) default NULL COMMENT '学校id',
  `status` int(11) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 添加项目创建人id
ALTER TABLE `edu_project` ADD COLUMN `create_by_id` int(11) DEFAULT NULL COMMENT '创建培训项目人id' AFTER `create_by` ;
-- 添加入党时间
ALTER TABLE `edu_teacher_basic_info` ADD COLUMN `party_time` date DEFAULT NULL COMMENT '入党时间' AFTER `teacher_political_status` ;

-- 添加学科带头人,是否名校长培养对象,是否教学名师等字段
ALTER TABLE `edu_teacher_job` ADD COLUMN `job_subject_leader_name` varchar(255) DEFAULT NULL COMMENT '学科带头人' AFTER `job_subject_leader` ;
ALTER TABLE `edu_teacher_job` ADD COLUMN `eliteTraining` varchar(255) DEFAULT NULL COMMENT '是否名校长培养对象' AFTER `tgjs` ;
ALTER TABLE `edu_teacher_job` ADD COLUMN `eliteTrainingType` int(11) DEFAULT NULL COMMENT '' AFTER `eliteTraining` ;
ALTER TABLE `edu_teacher_job` ADD COLUMN `teachingMaster` varchar(255) DEFAULT NULL COMMENT '是否教学名师' AFTER `eliteTrainingType` ;
ALTER TABLE `edu_teacher_job` ADD COLUMN `teachingMasterType` int(11) DEFAULT NULL COMMENT '' AFTER `teachingMaster` ;
ALTER TABLE `edu_teacher_job` ADD COLUMN `postGrade` date DEFAULT NULL COMMENT '聘任岗位等级时间' AFTER `teachingMasterType` ;
ALTER TABLE `edu_teacher_job` ADD COLUMN `teachingTime` date DEFAULT NULL COMMENT '本校任教起始时间' AFTER `postGrade` ;
ALTER TABLE `edu_teacher_job` ADD COLUMN `jdfldw` varchar(255) DEFAULT NULL COMMENT '借调分流单位' AFTER `teachingTime` ;
ALTER TABLE `edu_teacher_job` ADD COLUMN `jdflTime` date DEFAULT NULL COMMENT '借调分流时间' AFTER `jdfldw` ;
ALTER TABLE `edu_teacher_job` ADD COLUMN `postBack` date DEFAULT NULL COMMENT '离岗待退时间' AFTER `jdflTime` ;

-- 数据库字段内容修改(在table--edu_sys_function中)
教师评价 teacher_903 改为: project_903 (显示在培训项目中)
培训成绩发布（省、市、区县管理员）改为: 培训成绩修改（省、市、区县管理员）project_028

-- 证书打印(edu_project_comment)
ALTER TABLE `edu_project_comment` ADD COLUMN `qrcode_url` varchar(255) DEFAULT NULL COMMENT '二维码保存路径' AFTER `project_certificate_code` ;
ALTER TABLE `edu_project_comment` ADD COLUMN `project_certificate_url` varchar(255) DEFAULT NULL COMMENT '二维码保存路径' AFTER `qrcode_url` ;
ALTER TABLE `edu_project_comment` ADD COLUMN `period_certificate_url` varchar(255) DEFAULT NULL COMMENT '二维码保存路径' AFTER `project_certificate_url` ;


ALTER TABLE `edu_diploma` ADD COLUMN `certificateCodeRight` int(11) DEFAULT NULL COMMENT '单位 像素' AFTER `qrcode` ;
ALTER TABLE `edu_diploma` ADD COLUMN `certificateCodeTop` int(11) DEFAULT NULL COMMENT '单位 像素' AFTER `certificateCodeRight` ;
ALTER TABLE `edu_diploma` ADD COLUMN `certificateCodeFontType` int(11) DEFAULT NULL COMMENT '证书编号字体样式类型' AFTER `certificateCodeTop` ;
ALTER TABLE `edu_diploma` ADD COLUMN `certificateCodeFontStyle` varchar(255) DEFAULT NULL COMMENT '证书编号字体样式' AFTER `certificateCodeFontType` ;
ALTER TABLE `edu_diploma` ADD COLUMN `certificateCodeFontSize` int(11) DEFAULT NULL COMMENT '证书编号字体大小' AFTER `certificateCodeFontStyle` ;
ALTER TABLE `edu_diploma` ADD COLUMN `teacherRight` int(11) DEFAULT NULL COMMENT '单位 像素' AFTER `certificateCodeFontSize` ;
ALTER TABLE `edu_diploma` ADD COLUMN `teacherTop` int(11) DEFAULT NULL COMMENT '单位 像素' AFTER `teacherRight` ;
ALTER TABLE `edu_diploma` ADD COLUMN `teacherFontType` int(11) DEFAULT NULL COMMENT '学员字体样式类型' AFTER `teacherTop` ;
ALTER TABLE `edu_diploma` ADD COLUMN `teacherFontStyle` varchar(255) DEFAULT NULL COMMENT '学员字体样式' AFTER `teacherFontType` ;
ALTER TABLE `edu_diploma` ADD COLUMN `teacherFontSize` int(11) DEFAULT NULL COMMENT '学员姓名字体大小' AFTER `teacherFontStyle` ;

ALTER TABLE `edu_diploma` ADD COLUMN `qrcodeUrl` varchar(255) DEFAULT NULL COMMENT '设置项目证书的二维码路径' AFTER `backgroundImg` ;  
ALTER TABLE `edu_diploma` ADD COLUMN `projectCertificateUrl` varchar(255) DEFAULT NULL COMMENT '设置项目证书的保存路径' AFTER `qrcodeUrl` ;  
ALTER TABLE `edu_diploma` ADD COLUMN `periodCertificateUrl` varchar(255) DEFAULT NULL COMMENT '设置学时证书的保存路径' AFTER `projectCertificateUrl` ;  

ALTER TABLE `edu_teacher_job` change `job_core_teacher` `job_core_teacher_type` int(11) DEFAULT NULL COMMENT '骨干教师类型' ;  
ALTER TABLE `edu_teacher_job` ADD COLUMN `job_core_teacher` int(11) DEFAULT NULL COMMENT '骨干教师' AFTER `job_core_teacher_type` ;
ALTER TABLE `edu_teacher_job` ADD COLUMN `remark` int(11) DEFAULT NULL COMMENT '备注' AFTER `postBack` ;

----------------------注意：此处sql更新必须按顺序执行----------------------
-- 项目处于审核通过或筹备中时  填充edu_organization_project表信息
INSERT INTO edu_organization_project 
(organization_id,project_id,training_home_address,training_address,class_subject_id,class_subject_name,plan_num,create_date,update_date,project_status,area_code,area_name,organization_name)
SELECT  p.organization_id as orgId,p.id as projectId,'http://' as trainingHomeAddress,'http://' as trainingAddress,t.subject_id as classSubjectId,t.subject_name as classSubjectName,p.plan_num as planNum,NOW(),NOW(),30,p.train_scope_id as areaCode,p.train_scope_name as areaName,o.organization_name as orgNamefrom edu_project p JOIN edu_project_train_target t ON p.id = t.project_id JOIN edu_organization o ON  o.organization_id= p.organization_id	where p.id in (SELECT id from edu_project where status in (21,30) and id not in (SELECT project_id from edu_organization_project))


-- 项目处于进行中/已结束/已关闭时  填充edu_organization_project表信息
INSERT INTO edu_organization_project 
(organization_id,project_id,training_home_address,training_address,class_subject_id,class_subject_name,plan_num,create_date,update_date,project_status,area_code,area_name,organization_name)
SELECT  p.organization_id as orgId,p.id as projectId,'http://' as trainingHomeAddress,'http://' as trainingAddress,t.subject_id as classSubjectId,t.subject_name as classSubjectName,p.plan_num as planNum,NOW(),NOW(),40,p.train_scope_id as areaCode,p.train_scope_name as areaName,o.organization_name as orgNamefrom edu_project p JOIN edu_project_train_target t ON p.id = t.project_id JOIN edu_organization o ON  o.organization_id= p.organization_id	where p.id in (SELECT id from edu_project where status in (40,50,60) and id not in (SELECT project_id from edu_organization_project))


-- 废弃edu_project审核通过状态21---->改为待启动状态30
update edu_project SET status=30 where status=21

-- 废弃edu_organization_project准备就绪状态31
update edu_organization_project SET project_status=30 where project_status=31

----------------------注意：此处sql更新必须按顺序执行----------------------

-- 完善organization_id字段
UPDATE edu_project_comment pc SET pc.organization_id=(SELECT organization_id from edu_project WHERE id=pc.project_id) WHERE pc.organization_id is null



ALTER TABLE edu_message DEFAULT charset=utf8;
ALTER TABLE edu_message ADD COLUMN message_type int(2) DEFAULT NULL COMMENT '消息类型  1=省级消息  2=市级消息  3=区级消息  4=校级消息' AFTER content;
ALTER TABLE edu_message ADD COLUMN file_name varchar(50) DEFAULT NULL COMMENT '附件名称';
ALTER TABLE edu_message CHANGE user_image_url file_url varchar(50) COMMENT '附件路径';

ALTER TABLE edu_message DROP COLUMN `status`, DROP COLUMN update_by, DROP COLUMN update_date, DROP COLUMN receive_user_id,DROP COLUMN receive_user_name;  

CREATE TABLE edu_message_users (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message_id` int(11) DEFAULT NULL COMMENT '消息id',
  `status` int(4) DEFAULT NULL COMMENT '0未读  1已读',
  `update_by` varchar(20) DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  `receive_user_id` int(11) DEFAULT NULL COMMENT '消息接收者',
  `receive_user_name` varchar(20) DEFAULT NULL COMMENT '接收者名称',
  PRIMARY KEY (`id`),
  KEY `index_message_id` (`message_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='通知用户关联表';


INSERT INTO `edu_sys_function` (`func_name`, `func_type`, `func_code`, `func_url`, `sort`) VALUES ('培训结果审核（省、市、区县管理员）', '3', 'project_052', NULL, NULL);

ALTER TABLE edu_project_comment MODIFY COLUMN teacher_train_status_id int(11) DEFAULT NULL COMMENT '培训状态: 0=不合格  1=合格  2=优秀  3=良好';
ALTER TABLE edu_project_comment MODIFY COLUMN teacher_train_status_name varchar(20) DEFAULT NULL COMMENT '老师培训状态(合格，不合格，优秀，良好)'; 

ALTER TABLE edu_model ADD COLUMN excellent_rule varchar(5) DEFAULT NULL COMMENT '优秀学员兑换规则';

-- 学分汇总信息
INSERT INTO `edu_sys_function` (`func_name`, `func_type`, `func_code`, `func_url`, `sort`) VALUES ('学分汇总（省、市、区县、校管理员）', '3', 'furtheredu_022',NULL, '2');
INSERT INTO `edu_sys_function` (`func_name`, `func_type`, `func_code`, `func_url`, `sort`) VALUES ('教师培训学分（教师）', '3', 'furtheredu_023', NULL, '2');

-- 福建能力提升学情信息统计表
ALTER TABLE fjstatistic RENAME TO edu_statistic_nlts;
-- 福建能力提升学情信息表
ALTER TABLE fjimport RENAME TO edu_teacher_nlts;
-- 培训详情导入历史表
ALTER TABLE fjimport_history RENAME TO edu_teacher_train_history;
-- 学分信息汇总表
CREATE TABLE `edu_teacher_train_score` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_id` int(11) DEFAULT NULL,
  `teacher_name` varchar(255) DEFAULT NULL,
  `school_id` int(11) DEFAULT NULL,
  `school_name` varchar(255) DEFAULT NULL,
  `id_number` varchar(255) DEFAULT NULL,
  `work_shop_num` varchar(11) DEFAULT NULL COMMENT '工作坊数',
  `course_work_num` varchar(11) DEFAULT NULL COMMENT '课程作业数',
  `train_activit_num` varchar(11) DEFAULT NULL COMMENT '研修活动数',
  `train_activit_join_num` varchar(11) DEFAULT NULL COMMENT '研修活动参与数',
  `practice_activit_num` varchar(11)  DEFAULT NULL COMMENT '实践研修活动数',
  `project_report_num` varchar(11) DEFAULT NULL COMMENT '项目简报数',
  `push_excellent` varchar(11) DEFAULT NULL COMMENT '推优状态',
  `push_comment` text DEFAULT NULL COMMENT '推优意见',
  `create_by_id` varchar(11) DEFAULT NULL,
  `update_by_id` varchar(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `update_date` datetime DEFAULT NULL,
  `status` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `teacher_index` (`teacher_id`) USING BTREE,
  KEY `status_index` (`status`) USING BTREE,
  KEY `create_date_index` (`create_date`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- 2017年4月25日 朱迪	调研问卷汇总 --还未上生产
	1，修改response-question中的answer字段
	update edu_response_question set answer=replace(answer,'|','')
	2，修改edu_question中的title中的空格
	update edu_question set title=replace(title,'	','')
	3，修改edu_question_option 中的content字段中的空格
	update edu_question_options set content=replace(content,'	','')
	4,添加问卷调查汇总菜单
	INSERT INTO `edu_sys_function` (`func_name`, `func_type`, `func_code`, `func_url`, `sort`) VALUES ('问卷调查汇总（省、市、区县、校管理员）', '3', 'project_053',NULL, NULL);
	5,添加索引
	ALTER TABLE `edu_user` ADD INDEX `login_acc` USING BTREE (`login_account`);

	
-- 2017年5月17日 朱迪	学分查询 + 学分借贷+打印年度证书
1，	DROP TABLE IF EXISTS `edu_lend_credit`;
CREATE TABLE `edu_lend_credit` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `lend_year` varchar(20) DEFAULT NULL,
  `train_form_id` int(11) DEFAULT NULL,
  `train_form_name` varchar(20) DEFAULT NULL,
  `lend_date` varchar(20) DEFAULT NULL,
  `lend_reason` varchar(255) DEFAULT NULL,
  `lend_credit` float(20,1) DEFAULT NULL,
  `lend_period` float(20,1) DEFAULT NULL,
  `lend_status` varchar(11) DEFAULT '0',
  `lend_command` varchar(155) DEFAULT NULL,
  `teacher_id` int(11) DEFAULT NULL,
  `audit_id` int(11) DEFAULT NULL,
  `audit_name` varchar(20) DEFAULT NULL,
  `audit_date` date DEFAULT NULL,
  `repay_date` date DEFAULT NULL,
  `repay_credit` float(20,1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;

2，
INSERT INTO `edu_sys_dictionary` (`dictionary_id`, `dictionary_type`, `dictionary_type_name`, `dictionary_name`, `dictionary_code`, `status`) VALUES ('1', 'leave_type', '休假类型', '病假', 'xilx01', '1');
INSERT INTO `edu_sys_dictionary` (`dictionary_id`, `dictionary_type`, `dictionary_type_name`, `dictionary_name`, `dictionary_code`, `status`) VALUES ('2', 'leave_type', '休假类型', '婚假', 'xjlx02', '1');
INSERT INTO `edu_sys_dictionary` (`dictionary_id`, `dictionary_type`, `dictionary_type_name`, `dictionary_name`, `dictionary_code`, `status`) VALUES ('3', 'leave_type', '休假类型', '产假', 'xjlx03', '1');
INSERT INTO `edu_sys_dictionary` (`dictionary_id`, `dictionary_type`, `dictionary_type_name`, `dictionary_name`, `dictionary_code`, `status`) VALUES ('4', 'leave_type', '休假类型', '其他', 'xjlx04', '1');
3，
INSERT INTO `edu_sys_function` ( `func_name`, `func_type`, `func_code`, `func_url`, `sort`) VALUES ( '继续教育证书设置（行政）', '3', 'furtheredu_024', NULL, '2');
INSERT INTO `edu_sys_function` ( `func_name`, `func_type`, `func_code`, `func_url`, `sort`) VALUES ( '继续教育证书打印（教师）', '3', 'furtheredu_025', NULL, '2');
INSERT INTO `edu_sys_function` ( `func_name`, `func_type`, `func_code`, `func_url`, `sort`) VALUES ( '学分查询（行政）', '3', 'furtheredu_026', NULL, '2');
INSERT INTO `edu_sys_function` ( `func_name`, `func_type`, `func_code`, `func_url`, `sort`) VALUES ( '学分借贷（教师）', '3', 'furtheredu_027', NULL, '2');
INSERT INTO `edu_sys_function` ( `func_name`, `func_type`, `func_code`, `func_url`, `sort`) VALUES ( '教师培训学分查询（教师）', '3', 'furtheredu_028', NULL, '2');
INSERT INTO `edu_sys_function` ( `func_name`, `func_type`, `func_code`, `func_url`, `sort`) VALUES ( '学分借贷审核（行政）', '3', 'furtheredu_029', NULL, '2');
4，
ALTER TABLE `edu_project_comment`
MODIFY COLUMN `teacher_class_score`  float(11,1) NULL DEFAULT 0 COMMENT '教师学分' AFTER `audit_memo`;
5，
ALTER TABLE `edu_diploma`
ADD COLUMN `start_date`  date NULL COMMENT '年度项目开始时间' AFTER `year`,
ADD COLUMN `end_date`  date NULL COMMENT '年度项目结束时间' AFTER `start_date`,
ADD COLUMN `need_credit`  float(11,1) NULL COMMENT '所需总学分' AFTER `end_date`,
ADD COLUMN `need_period`  float(11,1) NULL COMMENT '所需总学时' AFTER `need_credit`,
ADD COLUMN `need_credit1`  varchar(50) NULL COMMENT '所需学分（培训形式-学分）' AFTER `need_period`,
ADD COLUMN `need_period1`  varchar(50) NULL COMMENT '所需学时（培训形式-学时）' AFTER `need_credit1`


INSERT INTO`edu_sys_function` ( `func_name`, `func_type`, `func_code`, `func_url`, `sort`) VALUES ('学分借贷查询（校级）', '3', 'furtheredu_030', NULL, '2');

-- ===========================================


1，创建表`edu_indept_study` 

CREATE TABLE `edu_indept_study` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `train_form_id` varchar(11) DEFAULT NULL,
  `train_form_name` varchar(50) DEFAULT NULL,
  `is_credit` float(20,1) DEFAULT NULL,
  `is_annotation` varchar(155) DEFAULT NULL,
  `is_year` varchar(20) DEFAULT NULL,
  `is_study_type_id` varchar(11) DEFAULT NULL,
  `is_study_type_name` varchar(20) DEFAULT NULL,
  `teacher_id` varchar(11) DEFAULT NULL,
  `teacher_name` varchar(20) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `update_id` varchar(11) DEFAULT NULL,
  `update_name` varchar(20) DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  `comment` varchar(155) DEFAULT NULL,
  `status` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8;

2，修改edu_project

ALTER TABLE `edu_project`
ADD COLUMN `project_type`  varchar(11) NULL AFTER `id`;

3,向edu_project中添加特殊情况项目
INSERT INTO `edu_project` ( `project_type`, `project_no`, `project_name`, `year`, `start_date`, `end_date`, `project_scope_id`, `project_scope_name`, `project_property_id`, `project_property_name`, `train_scope_id`, `train_scope_name`, `train_type_id`, `train_type_name`, `class_period`, `class_score`, `memo`, `project_attchement`, `sign_up_way`, `status`, `create_by`, `create_by_id`, `create_by_area`, `create_date`, `update_by`, `update_date`, `plan_num`, `file_names`, `edu_model_type`, `is_score_published`, `view_score_rule`, `score_publish_rule`, `score_level_rule`, `has_stop_sign`, `pid`, `cid`, `did`, `organization_id`, `print_xueshi_certificate`, `print_project_certificate`) VALUES ( '1', '1', '本周期内退休教师', '2017', '2017-06-01', '2017-06-30', '6', '其它', '23', '其它', '1', '吉林省', '1', '网络研修', '999', '6', '', NULL, '1', '50', 'jladmin', '1', '1', '2017-06-19', 'jladmin', '2017-06-19', '999', NULL, '28', '0', NULL, '0', NULL, NULL, '1', NULL, NULL, NULL, '0', '0');
INSERT INTO `edu_project` ( `project_type`, `project_no`, `project_name`, `year`, `start_date`, `end_date`, `project_scope_id`, `project_scope_name`, `project_property_id`, `project_property_name`, `train_scope_id`, `train_scope_name`, `train_type_id`, `train_type_name`, `class_period`, `class_score`, `memo`, `project_attchement`, `sign_up_way`, `status`, `create_by`, `create_by_id`, `create_by_area`, `create_date`, `update_by`, `update_date`, `plan_num`, `file_names`, `edu_model_type`, `is_score_published`, `view_score_rule`, `score_publish_rule`, `score_level_rule`, `has_stop_sign`, `pid`, `cid`, `did`, `organization_id`, `print_xueshi_certificate`, `print_project_certificate`) VALUES ( '1', '2', '孕期教师', '2017', '2017-06-01', '2017-07-08', '6', '其它', '23', '其它', '1', '吉林省', '2', '集中研修', '999', '6', '', NULL, '1', '10', 'jladmin', '1', '1', '2017-06-19', 'jladmin', '2017-06-19', '999', NULL, '28', '0', NULL, '0', NULL, NULL, '1', NULL, NULL, NULL, '0', '0');
INSERT INTO `edu_project` ( `project_type`, `project_no`, `project_name`, `year`, `start_date`, `end_date`, `project_scope_id`, `project_scope_name`, `project_property_id`, `project_property_name`, `train_scope_id`, `train_scope_name`, `train_type_id`, `train_type_name`, `class_period`, `class_score`, `memo`, `project_attchement`, `sign_up_way`, `status`, `create_by`, `create_by_id`, `create_by_area`, `create_date`, `update_by`, `update_date`, `plan_num`, `file_names`, `edu_model_type`, `is_score_published`, `view_score_rule`, `score_publish_rule`, `score_level_rule`, `has_stop_sign`, `pid`, `cid`, `did`, `organization_id`, `print_xueshi_certificate`, `print_project_certificate`) VALUES ( '1', '3', '哺乳期教师', '2017', '2017-06-01', '2017-06-30', '6', '其它', '23', '其它', '1', '吉林省', '2', '集中研修', '999', '3', '', NULL, '1', '10', 'jladmin', '1', '1', '2017-06-19', 'jladmin', '2017-06-19', '999', NULL, '28', '0', NULL, '0', NULL, NULL, '1', NULL, NULL, NULL, '0', '0');
INSERT INTO `edu_project` ( `project_type`, `project_no`, `project_name`, `year`, `start_date`, `end_date`, `project_scope_id`, `project_scope_name`, `project_property_id`, `project_property_name`, `train_scope_id`, `train_scope_name`, `train_type_id`, `train_type_name`, `class_period`, `class_score`, `memo`, `project_attchement`, `sign_up_way`, `status`, `create_by`, `create_by_id`, `create_by_area`, `create_date`, `update_by`, `update_date`, `plan_num`, `file_names`, `edu_model_type`, `is_score_published`, `view_score_rule`, `score_publish_rule`, `score_level_rule`, `has_stop_sign`, `pid`, `cid`, `did`, `organization_id`, `print_xueshi_certificate`, `print_project_certificate`) VALUES ( '1', '4', '局直事业单位教师', '2017', '2017-06-01', '2017-07-07', '6', '其它', '23', '其它', '1', '吉林省', '4', '校本研修', '999', '8', '', NULL, '1', '10', 'jladmin', '1', '1', '2017-06-19', 'jladmin', '2017-06-19', '999', NULL, '28', '0', NULL, '0', NULL, NULL, '1', NULL, NULL, NULL, '0', '0');

4dictionary
INSERT INTO `edu_sys_dictionary` (`dictionary_id`, `dictionary_type`, `dictionary_type_name`, `dictionary_name`, `dictionary_code`, `status`) VALUES ('1', 'dependent_study', '自主研修', '援教支教', 'zy01', '1');
INSERT INTO `edu_sys_dictionary` (`dictionary_id`, `dictionary_type`, `dictionary_type_name`, `dictionary_name`, `dictionary_code`, `status`) VALUES ('2', 'dependent_study', '自主研修', '学历提高', 'zy02', '1');
INSERT INTO `edu_sys_dictionary` (`dictionary_id`, `dictionary_type`, `dictionary_type_name`, `dictionary_name`, `dictionary_code`, `status`) VALUES ('3', 'dependent_study', '自主研修', '论文评选', 'zy03', '1');
INSERT INTO `edu_sys_dictionary` (`dictionary_id`, `dictionary_type`, `dictionary_type_name`, `dictionary_name`, `dictionary_code`, `status`) VALUES ('4', 'dependent_study', '自主研修', '论文发表', 'zy04', '1');
INSERT INTO `edu_sys_dictionary` (`dictionary_id`, `dictionary_type`, `dictionary_type_name`, `dictionary_name`, `dictionary_code`, `status`) VALUES ('5', 'dependent_study', '自主研修', '教育科研', 'zy05', '1');
INSERT INTO `edu_sys_dictionary` (`dictionary_id`, `dictionary_type`, `dictionary_type_name`, `dictionary_name`, `dictionary_code`, `status`) VALUES ('6', 'dependent_study', '自主研修', '教学竞赛', 'zy06', '1');
INSERT INTO `edu_sys_dictionary` (`dictionary_id`, `dictionary_type`, `dictionary_type_name`, `dictionary_name`, `dictionary_code`, `status`) VALUES ('7', 'dependent_study', '自主研修', '培训专家', 'zy07', '1');
INSERT INTO `edu_sys_dictionary` (`dictionary_id`, `dictionary_type`, `dictionary_type_name`, `dictionary_name`, `dictionary_code`, `status`) VALUES ('8', 'dependent_study', '自主研修', '送培送教', 'zy08', '1');
INSERT INTO `edu_sys_dictionary` (`dictionary_id`, `dictionary_type`, `dictionary_type_name`, `dictionary_name`, `dictionary_code`, `status`) VALUES ('9', 'dependent_study', '自主研修', '指导教师', 'zy09', '1');
INSERT INTO `edu_sys_dictionary` (`dictionary_id`, `dictionary_type`, `dictionary_type_name`, `dictionary_name`, `dictionary_code`, `status`) VALUES ('10', 'dependent_study', '自主研修', '名师工作室', 'zy10', '1');
INSERT INTO `edu_sys_dictionary` (`dictionary_id`, `dictionary_type`, `dictionary_type_name`, `dictionary_name`, `dictionary_code`, `status`) VALUES ('1', 'status', '状态', '未审核', 'zt01', '1');
INSERT INTO `edu_sys_dictionary` (`dictionary_id`, `dictionary_type`, `dictionary_type_name`, `dictionary_name`, `dictionary_code`, `status`) VALUES ('2', 'status', '状态', '已通过', 'zt02', '1');
INSERT INTO `edu_sys_dictionary` (`dictionary_id`, `dictionary_type`, `dictionary_type_name`, `dictionary_name`, `dictionary_code`, `status`) VALUES ('3', 'status', '状态', '未通过', 'zt03', '1');
INSERT INTO `edu_sys_dictionary` (`dictionary_id`, `dictionary_type`, `dictionary_type_name`, `dictionary_name`, `dictionary_code`, `status`) VALUES ('1', 'special_case', '特殊情况', '退休', 'sc01', '1');
INSERT INTO `edu_sys_dictionary` (`dictionary_id`, `dictionary_type`, `dictionary_type_name`, `dictionary_name`, `dictionary_code`, `status`) VALUES ('2', 'special_case', '特殊情况', '孕期', 'sc02', '1');
INSERT INTO `edu_sys_dictionary` (`dictionary_id`, `dictionary_type`, `dictionary_type_name`, `dictionary_name`, `dictionary_code`, `status`) VALUES ('3', 'special_case', '特殊情况', '哺乳期', 'sc03', '1');
INSERT INTO `edu_sys_dictionary` (`dictionary_id`, `dictionary_type`, `dictionary_type_name`, `dictionary_name`, `dictionary_code`, `status`) VALUES ('4', 'special_case', '特殊情况', '局直事业单位', 'sc04', '1');
INSERT INTO `edu_sys_dictionary` (`dictionary_id`, `dictionary_type`, `dictionary_type_name`, `dictionary_name`, `dictionary_code`, `status`) VALUES ('0', 'examine_status', '培训审核状态', '未审核', 'es01', '1');
INSERT INTO `edu_sys_dictionary` (`dictionary_id`, `dictionary_type`, `dictionary_type_name`, `dictionary_name`, `dictionary_code`, `status`) VALUES ('1', 'examine_status', '培训审核状态', '通过', 'es02', '1');
INSERT INTO `edu_sys_dictionary` (`dictionary_id`, `dictionary_type`, `dictionary_type_name`, `dictionary_name`, `dictionary_code`, `status`) VALUES ('2', 'examine_status', '培训审核状态', '未通过', 'es03', '1');
INSERT INTO `edu_sys_dictionary` (`dictionary_id`, `dictionary_type`, `dictionary_type_name`, `dictionary_name`, `dictionary_code`, `status`) VALUES ('11', 'dependent_study', '自主研修', '学分专员', 'zy11', '1');

5function

INSERT INTO `edu_sys_function` ( `func_name`, `func_type`, `func_code`, `func_url`, `sort`) VALUES ('自主研修申请', '3', 'furtheredu_031', NULL, '2');
INSERT INTO `edu_sys_function` ( `func_name`, `func_type`, `func_code`, `func_url`, `sort`) VALUES ('自主研修审批', '3', 'furtheredu_032', NULL, '2');
INSERT INTO `edu_sys_function` ( `func_name`, `func_type`, `func_code`, `func_url`, `sort`) VALUES ('特殊申请', '3', 'furtheredu_033', '', '2');
INSERT INTO `edu_sys_function` ( `func_name`, `func_type`, `func_code`, `func_url`, `sort`) VALUES ('特殊申请审批', '3', 'furtheredu_034', '', '2');

6.edu_diploma

ALTER TABLE `edu_diploma`
DROP COLUMN `change_rate`,
DROP COLUMN `repay_rate`,
ADD COLUMN `repay_rate`  float(11,1) NULL AFTER `need_period`,
ADD COLUMN `change_rate`  varchar(50) NULL AFTER `repay_rate`;

ALTER TABLE `edu_project`
ADD COLUMN `exchange_rule`  float(11,1) NULL AFTER `print_project_certificate`,
ADD COLUMN `exchange_rule_excellent`  float(11,1) NULL AFTER `exchange_rule`;
1
ALTER TABLE `edu_project_comment`
MODIFY COLUMN `teacher_class_score`  float(11,2) NULL DEFAULT 0.0 COMMENT '教师学分' AFTER `audit_memo`;
2
ALTER TABLE `edu_project`
MODIFY COLUMN `exchange_rule`  float(11,2) NULL DEFAULT NULL AFTER `print_project_certificate`,
MODIFY COLUMN `exchange_rule_excellent`  float(11,2) NULL DEFAULT NULL AFTER `exchange_rule`;
3
ALTER TABLE `edu_project`
ADD COLUMN `exchange_way`  varchar(11) NULL COMMENT '1：学时兑换学分；2：学分兑换学时' AFTER `exchange_rule_excellent`;

-- ==========================================以上已更新========================================

CREATE TABLE `edu_comparison` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comparison_name` varchar(255) DEFAULT NULL,
  `comparison_type_id` varchar(255) DEFAULT NULL,
  `comparison_type_name` varchar(255) DEFAULT NULL,
  `comparison_plan_num` varchar(255) DEFAULT NULL,
  `comparison_year` varchar(255) DEFAULT NULL,
  `signup_start_date` date DEFAULT NULL,
  `signup_end_date` date DEFAULT NULL,
  `audit_start_date` date DEFAULT NULL,
  `audit_end_date` date DEFAULT NULL,
  `publish_date` date DEFAULT NULL,
  `memo` varchar(255) DEFAULT NULL,
  `schools` varchar(1500) DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `update_date` varchar(255) DEFAULT NULL,
  `create_level` varchar(10) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=utf8;

CREATE TABLE `edu_comparison_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `teacher_name` varchar(255) DEFAULT NULL,
  `id_number` varchar(255) DEFAULT NULL,
  `teacher_img` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `school_id` int(11) DEFAULT NULL,
  `school_name` varchar(255) DEFAULT NULL,
  `section_id` varchar(255) DEFAULT NULL,
  `section_name` varchar(255) DEFAULT NULL,
  `subject_id` varchar(255) DEFAULT NULL,
  `subject_name` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `comparison_id` varchar(255) DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  `expert_score` varchar(255) DEFAULT NULL,
  `average_score` varchar(255) DEFAULT NULL,
  `memo` varchar(255) DEFAULT NULL,
  `p_memo` varchar(255) DEFAULT NULL,
  `c_memo` varchar(255) DEFAULT NULL,
  `d_memo` varchar(255) DEFAULT NULL,
  `p_memo_date` date DEFAULT NULL,
  `c_memo_date` date DEFAULT NULL,
  `d_memo_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=242 DEFAULT CHARSET=utf8;

CREATE TABLE `edu_comparison_master` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comparison_id` varchar(255) DEFAULT NULL,
  `master_id` varchar(255) DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  `update_by` varchar(255) DEFAULT NULL,
  `update_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=270 DEFAULT CHARSET=utf8;

CREATE TABLE `edu_comparison_score` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comparison_id` varchar(255) DEFAULT NULL,
  `teacher_id` varchar(255) DEFAULT NULL,
  `master_id` varchar(255) DEFAULT NULL,
  `score` varchar(255) DEFAULT NULL,
  `is_pass` varchar(255) DEFAULT NULL,
  `memo` varchar(255) DEFAULT NULL,
  `create_by` varchar(255) DEFAULT NULL,
  `create_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

INSERT INTO `edu_sys_function` (`func_name`, `func_type`, `func_code`, `func_url`, `sort`) VALUES ('活动评比(一级菜单)', '1', 'comparison_001', NULL, '6');
INSERT INTO `edu_sys_function` (`func_name`, `func_type`, `func_code`, `func_url`, `sort`) VALUES ('活动评比管理(最高级别)', '3', 'comparison_111', NULL, '1');
INSERT INTO `edu_sys_function` (`func_name`, `func_type`, `func_code`, `func_url`, `sort`) VALUES ('活动评比报名(校级)', '3', 'comparison_112', NULL, '1');
INSERT INTO `edu_sys_function` (`func_name`, `func_type`, `func_code`, `func_url`, `sort`) VALUES ('活动评比评分(专家)', '3', 'comparison_113', NULL, '1');
INSERT INTO `edu_sys_function` (`func_name`, `func_type`, `func_code`, `func_url`, `sort`) VALUES ('活动评比(二级菜单)', '2', 'comparison_110', NULL, '1');
INSERT INTO `edu_sys_function` (`func_name`, `func_type`, `func_code`, `func_url`, `sort`) VALUES ('活动评比审核(行政)', '3', 'comparison_114', '', '1');

INSERT INTO `edu_sys_dictionary` ( `dictionary_id`, `dictionary_type`, `dictionary_type_name`, `dictionary_name`, `dictionary_code`, `status`) VALUES ('1', 'comparison_type', '评比活动', '评选优秀教师', 'pb01', '1');
INSERT INTO `edu_sys_dictionary` ( `dictionary_id`, `dictionary_type`, `dictionary_type_name`, `dictionary_name`, `dictionary_code`, `status`) VALUES ('2', 'comparison_type', '评比活动', '评选名师', 'pb02', '1');
INSERT INTO `edu_sys_dictionary` ( `dictionary_id`, `dictionary_type`, `dictionary_type_name`, `dictionary_name`, `dictionary_code`, `status`) VALUES ('3', 'comparison_type', '评比活动', '评选骨干教师', 'pb03', '1');
INSERT INTO `edu_sys_dictionary` ( `dictionary_id`, `dictionary_type`, `dictionary_type_name`, `dictionary_name`, `dictionary_code`, `status`) VALUES ('0', 'comparison_status', '评比活动状态', '未启动', 'status1', '1');
INSERT INTO `edu_sys_dictionary` ( `dictionary_id`, `dictionary_type`, `dictionary_type_name`, `dictionary_name`, `dictionary_code`, `status`) VALUES ('1', 'comparison_status', '评比活动状态', '已启动', 'status2', '1');
INSERT INTO `edu_sys_dictionary` ( `dictionary_id`, `dictionary_type`, `dictionary_type_name`, `dictionary_name`, `dictionary_code`, `status`) VALUES ('2', 'comparison_status', '评比活动状态', '已结束', 'status3', '1');
INSERT INTO `edu_sys_dictionary` ( `dictionary_id`, `dictionary_type`, `dictionary_type_name`, `dictionary_name`, `dictionary_code`, `status`) VALUES ('11', 'comparison_signup_status', '评比活动报名状态', '审核通过（区）', 'status1', '1');
INSERT INTO `edu_sys_dictionary` ( `dictionary_id`, `dictionary_type`, `dictionary_type_name`, `dictionary_name`, `dictionary_code`, `status`) VALUES ('12', 'comparison_signup_status', '评比活动报名状态', '审核通过（市）', 'status2', '1');
INSERT INTO `edu_sys_dictionary` ( `dictionary_id`, `dictionary_type`, `dictionary_type_name`, `dictionary_name`, `dictionary_code`, `status`) VALUES ('13', 'comparison_signup_status', '评比活动报名状态', '审核通过（省）', 'status3', '1');
INSERT INTO `edu_sys_dictionary` ( `dictionary_id`, `dictionary_type`, `dictionary_type_name`, `dictionary_name`, `dictionary_code`, `status`) VALUES ('1', 'comparison_signup_status', '评比活动报名状态', '未报名', 'status6', '1');
INSERT INTO `edu_sys_dictionary` ( `dictionary_id`, `dictionary_type`, `dictionary_type_name`, `dictionary_name`, `dictionary_code`, `status`) VALUES ('3', 'comparison_signup_status', '评比活动报名状态', '已报名未审核', 'status5', '1');
INSERT INTO `edu_sys_dictionary` ( `dictionary_id`, `dictionary_type`, `dictionary_type_name`, `dictionary_name`, `dictionary_code`, `status`) VALUES ('2', 'comparison_signup_status', '评比活动报名状态', '审核未通过', 'status4', '1');
INSERT INTO `edu_sys_dictionary` ( `dictionary_id`, `dictionary_type`, `dictionary_type_name`, `dictionary_name`, `dictionary_code`, `status`) VALUES ('3', 'comparison_status', '评比活动状态', '待评审', 'status4', '1');
INSERT INTO `edu_sys_dictionary` ( `dictionary_id`, `dictionary_type`, `dictionary_type_name`, `dictionary_name`, `dictionary_code`, `status`) VALUES ('4', 'comparison_status', '评比活动状态', '公布结果中', 'status5', '1');
INSERT INTO `edu_sys_dictionary` ( `dictionary_id`, `dictionary_type`, `dictionary_type_name`, `dictionary_name`, `dictionary_code`, `status`) VALUES ('4', 'comparison_signup_status', '评比活动报名状态', '评审中', 'status7', '1');
INSERT INTO `edu_sys_dictionary` ( `dictionary_id`, `dictionary_type`, `dictionary_type_name`, `dictionary_name`, `dictionary_code`, `status`) VALUES ('5', 'comparison_signup_status', '评比活动报名状态', '已评审', 'status8', '1');

INSERT INTO `edu_sys_role` (`id`, `role_name`, `status`, `create_by`, `update_by`, `create_date`, `remark`, `create_province_id`, `create_city_id`, `create_district_id`, `create_school_id`, `create_by_id`, `update_by_id`, `update_date`, `role_type`, `isSysRole`) VALUES ('41', '专家', '1', NULL, 'jladmin', '2017-07-13', '', NULL, NULL, NULL, NULL, '', 'jladmin', '2017-07-13', '10', '1');
