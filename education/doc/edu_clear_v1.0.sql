--
--	2015-01-29更新
--
truncate table edu_audit;
truncate table edu_diploma;
truncate table edu_file;
truncate table edu_jobtransfer_history;
truncate table edu_message;
truncate table edu_model;
truncate table edu_organization;
truncate table edu_organization_project;
truncate table edu_paper;
truncate table edu_project;
truncate table edu_project_allocate_by_area;
truncate table edu_project_audit;
truncate table edu_project_class;
truncate table edu_project_class_category;
truncate table edu_project_comment;
truncate table edu_project_count;
truncate table edu_project_notrain;
truncate table edu_project_notrain_comment;
truncate table edu_project_process;
truncate table edu_project_summary;
truncate table edu_project_train_target;
truncate table edu_question;
truncate table edu_question_options;
truncate table edu_relas_func_role;
truncate table edu_response;
truncate table edu_response_question;
truncate table edu_school;
truncate table edu_statistic_jijiao;
truncate table edu_statistic_model;
truncate table edu_statistic_school;
truncate table edu_statistic_teacher;
truncate table edu_statistic_year;
truncate table edu_sys_area;

truncate table edu_sys_platform_setup;
truncate table edu_sys_role;
truncate table edu_sys_setup;
truncate table edu_sys_signet;
truncate table edu_target_by_year;
truncate table edu_teacher_basic_info;
truncate table edu_teacher_education;
truncate table edu_teacher_import_history;
truncate table edu_teacher_info_change_history;
truncate table edu_teacher_job;
truncate table edu_teacher_old_school;

truncate table edu_user_forgotpassword;

delete  from edu_user where role_id !=0;

--下面字典表和菜菜单表不清楚.其它表全清空,只留一个系统管理员
-- edu_sys_dictionary;
-- edu_sys_function;