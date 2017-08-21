alter table edu_project_notrain add column `pid` int(11) DEFAULT NULL comment '省id';
 alter table edu_project_notrain add column `cid` int(11) DEFAULT NULL  comment '市id';
 alter table edu_project_notrain add column `did` int(11) DEFAULT NULL  comment '县id';
 alter table edu_project_notrain add column `sid` int(11) DEFAULT NULL  comment '校id';
 
 ALTER TABLE  `edu_project_comment`
  CHANGE COLUMN `teacher_class_period` `teacher_class_period` int(11) NULL DEFAULT 0 COMMENT '教师学时';
 
ALTER TABLE  `edu_project_comment`
  CHANGE COLUMN `teacher_class_score` `teacher_class_score` int(11) NULL DEFAULT 0 COMMENT '教师学分';
 
 
 
ALTER TABLE `edu_statistic_year`
  ADD COLUMN `project_count` int(11) NULL DEFAULT 0 AFTER `teacher_score`,
  ADD COLUMN `is_standard` int(11) NULL DEFAULT 1;
  
  
  
INSERT INTO `edu_sys_function` SET `func_name`='继教统计', `func_type`=3, `func_code`='furtheredu_900', `sort`=1;
INSERT INTO `edu_sys_function` SET `func_name`='继教统计', `func_type`=3, `func_code`='furtheredu_901';
INSERT INTO `edu_sys_function` SET `func_name`='学校统计', `func_type`=3, `func_code`='system_021';
INSERT INTO `edu_sys_function` SET `func_name`='教师信息统计', `func_type`=3, `func_code`='teacher_900';
INSERT INTO `edu_sys_function` SET `func_name`='按地区统计', `func_type`=3, `func_code`='teacher_901';
INSERT INTO `edu_sys_function` SET `func_name`='按学段统计', `func_type`=3, `func_code`='teacher_902';


##教师统计-按地区统计 
CREATE   PROCEDURE `sp_region`(IN _dict1_id INT, IN _dict2_type VARCHAR(100))
BEGIN
    SET SESSION group_concat_max_len = (7 * 1024);
 

    SET @sql = NULL;
    SELECT
      GROUP_CONCAT(DISTINCT
        CONCAT(
          'MAX(IF(`dict2_id` = ', `dict2_id`, ',num,0)) AS ', `dict2_name`)
      ) INTO @sql
    FROM edu_statistic_teacher where dict2_type =_dict2_type ;
    
 
      
    SET @sql = CONCAT('SELECT dict1_id,  dict1_name, dict1_pid,', @sql, ' 
                      FROM    edu_statistic_teacher
                      WHERE type=0 and dict1_id = ',_dict1_id,' or dict1_pid=',_dict1_id,
                      ' GROUP   BY dict1_id');

       
    PREPARE stmt FROM @sql;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
 END 
 
 
##教师统计-按学段统计 
CREATE   PROCEDURE `sp_dict`(IN _dict1_type  VARCHAR(100), IN _dict2_type VARCHAR(100))
BEGIN
    SET SESSION group_concat_max_len = (7 * 1024);
 

    SET @sql = NULL;
    SELECT
      GROUP_CONCAT(DISTINCT
        CONCAT(
          'MAX(IF(`dict2_id` = ', `dict2_id`, ',num,0)) AS ', `dict2_name`)
      ) INTO @sql
    FROM edu_statistic_teacher where dict2_type =_dict2_type ;
    
 
      
    SET @sql = CONCAT('SELECT dict1_id,  dict1_name, dict1_pid,', @sql, ' 
                      FROM    edu_statistic_teacher
                      WHERE type=1 and dict1_type = ''',_dict1_type,'''  GROUP   BY dict1_id');
 
       
    PREPARE stmt FROM @sql;
    EXECUTE stmt;
    DEALLOCATE PREPARE stmt;
 END 
 
 
##新的教师统计-按地区统计 
CREATE   PROCEDURE `sp_region`(IN _type INT,IN _dict1_id INT,IN _dict1_type  VARCHAR(100), IN _dict2_type VARCHAR(100))
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
 
 
##学校统计 
CREATE   PROCEDURE `sp_school`(IN area_id INT, IN _dict1_type VARCHAR(100))
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

 
UPDATE `edu_sys_function` SET `func_name`='项目总结报告（行政/实施）' WHERE `id`=85;



CREATE TABLE  `edu_project_process` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `project_id` int(11) NOT NULL DEFAULT 0 COMMENT '项目Id',
  `project_name` varchar(255) NULL DEFAULT NULL COMMENT '冗余项目名称',
  `title` varchar(255) NULL DEFAULT NULL COMMENT '标题',
  `content` varchar(1000) NULL DEFAULT NULL COMMENT '内容',
  `attatch` varchar(1000) NULL DEFAULT NULL COMMENT '附件',
  `create_date` datetime NULL DEFAULT NULL COMMENT '添加时间',
  `creator` int(11) NULL DEFAULT NULL COMMENT '创建人Id',
  PRIMARY KEY (`Id`)
) COMMENT='培训过程管理';

update  `edu_sys_function`  set func_code='project_045' ,func_name='培训项目过程管理(实施)' where id=82;
INSERT INTO `edu_sys_function` VALUES (130,'培训项目过程管理（行政）',3,'project_046',NULL,2);

