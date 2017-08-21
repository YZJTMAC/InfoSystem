/*
 * 11月7日
 * 
 */


alter table edu_sys_signet add role_id int unsigned ;
alter table edu_sys_signet add user_id int unsigned ;
alter table edu_sys_signet add user_province_id int unsigned ;
alter table edu_sys_signet add user_district_id int unsigned ;
alter table edu_sys_signet add user_city_id int unsigned ;
alter table edu_model add status int unsigned  default 1;
/*
 * 11月14日
 * 
 */
alter table edu_project_comment add province_examine int unsigned ;
alter table edu_project_comment add district_examine int unsigned ;
alter table edu_project_comment add city_examine int unsigned ;
alter table edu_project_comment add school_id int unsigned ;
alter table edu_project_comment add city_id int unsigned ;
alter table edu_project_comment add district_id int unsigned ;
alter table edu_project_comment add province_id int unsigned ;

update edu_user set teacher_no=id where teacher_no is null or teacher_no ='';

ALTER TABLE  `edu_user`  ADD unique key `idx_teacherno` (`teacher_no`);