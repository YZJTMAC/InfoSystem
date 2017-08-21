
/*字典表增加所在区划数据*/
INSERT into edu_sys_dictionary(dictionary_id,dictionary_type,dictionary_type_name,dictionary_name,dictionary_code,status) VALUES(1,'area_type','所在区划','城区','areaType1',1);

/*学校表增加所在区划字段*/
ALTER TABLE `edu_school` ADD COLUMN `area_type_id`  int(5) NULL DEFAULT NULL;
ALTER TABLE `edu_school` ADD COLUMN `area_type_name`  VARCHAR(20) NULL DEFAULT NULL;

ALTER TABLE  `edu_organization`  ADD COLUMN `org_code` varchar(16) NOT NULL DEFAULT '' AFTER `user_id`;