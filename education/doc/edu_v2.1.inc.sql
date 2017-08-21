
--##新增字段 实施机构id
ALTER TABLE `edu_project`
  ADD COLUMN `organization_id` int(11) NULL DEFAULT NULL COMMENT '实施机构Id (禁用承培机构时，在此指定实施机构id)'; 

--##新增字段，是否启用承陪机构
ALTER TABLE `edu_sys_setup`
  ADD COLUMN `enable_org` int(11) NULL DEFAULT '1' COMMENT '是否启用承陪机构 （1 启用 （默认）  0禁用）';

-- 新增 承培平台设功能
INSERT INTO `edu_sys_function` VALUES (131, '承培平台设置(实施)', 3, 'project_047', NULL, NULL);
INSERT INTO edu_sys_function(func_name,func_type,func_code,func_url,sort) VALUES ('培训项目申报',3,'project_048',NULL,2);


ALTER TABLE `edu`.`edu_user`
  ADD UNIQUE INDEX `idx_id_number` (`id_number`(50));
