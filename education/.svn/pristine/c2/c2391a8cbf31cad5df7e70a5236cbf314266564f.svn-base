
--##新增字段 是否修改过密码
ALTER TABLE `edu_user`
  ADD COLUMN `is_password` int(11) NULL DEFAULT 0 COMMENT '是否修改密码'; 

--##结项评价，新增字段
ALTER TABLE `edu_organization_project`
  ADD COLUMN `comment_content` varchar(255) NULL DEFAULT NULL COMMENT '结项评价内容';
ALTER TABLE `edu_organization_project`
  ADD COLUMN `comment` varchar(50) NULL DEFAULT NULL COMMENT '结项评价';