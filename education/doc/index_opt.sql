 alter ignore table edu_project add unique index idx_proj_name (project_name);
 
 

ALTER TABLE  `edu_project_allocate_by_area`
  ADD INDEX `idx_pat_id` (`project_id`,`area_id`,`type`);


-- start 2014-11-07 zhaobichao 把edu_uer表中的teacher_no修改成unique key(唯一，不重复)
--教师编号唯一
update edu_user set teacher_no=id where teacher_no is null or teacher_no ='';

ALTER TABLE  `edu_user`  ADD unique key `idx_teacherno` (`teacher_no`);
--end