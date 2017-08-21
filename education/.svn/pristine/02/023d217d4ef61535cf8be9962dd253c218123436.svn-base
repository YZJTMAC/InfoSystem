package statistic.task;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import project.edupm.projectmanage.dao.IEduProjectReadDAO;
import project.edupm.projectmanage.pojo.EduModel;
import project.furtheredu.eduTarget.pojo.EduTargetByYear;
import project.furtheredu.eduTarget.service.IEduTargetService;
import project.furtheredu.edumanage.service.IEduStatisticModelService;
import project.furtheredu.edumanage.service.IEduStatisticYearService;
import project.system.dao.ISysReadDAO;
import project.system.pojo.SysDictionary;
import project.system.service.ISysService;



public class StatisticsTask {
	@Autowired
	@Qualifier("eduStatisticModelService")
	IEduStatisticModelService eduStatisticModelService;
	@Autowired
	@Qualifier("eduStatisticYearService")
	IEduStatisticYearService eduStatisticYearService;
	@Autowired
	@Qualifier("eduProjectReadDAO")
	IEduProjectReadDAO eduProjectReadDAO;
	
	@Autowired
	@Qualifier("eduTargetService")
	IEduTargetService eduTargetService;
	
	@Autowired
	@Qualifier("sysService")
	ISysService sysService;
	@Autowired
	@Qualifier("sysReadDAO")
	ISysReadDAO sysReadDAO; 
	
	public void saveModel()
	{
		//按模块统计
		Map<String,Object> map= new HashMap<String,Object>();
		try {
			map.put("startIndex", 0);
			map.put("endIndex", 200);
			List<EduModel> proList = eduProjectReadDAO.selectAllModelList(map);
			
			for(EduModel em : proList)
			{
				eduStatisticModelService.deleteBySql("delete from edu_statistic_model where model_id="+em.getId());
			}	
				String sql_temp="insert into edu_statistic_model (model_id,model_name,teacher_id,teacher_name,teacher_score)"
						+" select m.id as model_id,m.model_name as model_name,user.id as teacher_id,user.real_name,"
						+" (ifnull((select"
						+" sum(a.teacher_class_score)"
 						+" from edu_project_comment a"
 						+" left join edu_project b on a.project_id=b.id"
 						+" where b.edu_model_type=m.id and a.teacher_id=user.id),0)"
 						+" + "
 						+" ifnull((select"
						+" sum(a.audit_score)"
 						+" from edu_project_notrain_comment a"
 						+" left join edu_project_notrain b on a.project_id=b.id"
 						+" where b.model_id=m.id and a.teacher_id=user.id),0)) as teacher_score"
 						/*+" from edu_user user where user.role_id="+5;*/
						+" from edu_project_comment a "
						+" LEFT JOIN edu_project p ON p.id = a.project_id" 
						+" LEFT JOIN edu_project_notrain b on a.project_id=b.id"
						+" LEFT JOIN edu_model m ON m.id =p.edu_model_type" 
						+" LEFT JOIN edu_user user ON a.teacher_id = user.id GROUP BY a.teacher_id,m.id";
 						
				eduStatisticModelService.insertBySql(sql_temp);
			
			
			//年份统计
			List<Integer> yl = eduProjectReadDAO.selectGroupYear();
			int rowcount=0;
			for(Integer i:yl)
			{
				eduStatisticYearService.deleteBySql("delete from edu_statistic_year where year="+i);
				String sql="insert into edu_statistic_year (year,teacher_id,teacher_name,teacher_score,project_count)"
						+" select "+i+" as year,user.id as teacher_id,user.real_name,"
						+" (ifnull((select"
						+" sum(a.teacher_class_score)"
 						+" from edu_project_comment a"
 						+" left join edu_project b on a.project_id=b.id"
 						+" where b.year="+i+" and a.teacher_id=user.id and a.teacher_score_audit_status_id = 13),0)"
 						+" + "
 						+" ifnull((select"
						+" sum(a.audit_score)"
 						+" from edu_project_notrain_comment a"
 						+" left join edu_project_notrain b on a.project_id=b.id"
 						+" where b.year="+i+" and a.teacher_id=user.id and a.teacher_id=user.id and a.audit_status = 13),0)) as teacher_score," 
 						+"(ifnull((select count(a.id) from edu_project_comment a left join edu_project b on a.project_id=b.id where b.year="+i+" and a.teacher_id=user.id),0)"
 						+" + "
 						+" ifnull((select count(a.id) from edu_project_notrain_comment a left join edu_project_notrain b on a.project_id=b.id where b.year="+i+" and a.teacher_id=user.id),0)) as project_count"
 
 						/*+" from edu_user user where user.status=8 and user.role_id="+5;*/
 						+" from edu_project_comment a "
						+" LEFT JOIN edu_project p ON p.id = a.project_id"
						+" LEFT JOIN edu_project_notrain b on a.project_id=b.id"
						+" LEFT JOIN edu_model m ON m.id =p.edu_model_type"
						+" LEFT JOIN edu_user user ON a.teacher_id = user.id where 1 =1 and (b.year="+i+" or p.year="+i+")GROUP BY a.teacher_id" ;
 						
				rowcount = eduStatisticYearService.insertBySql(sql);
				Map<String, Object> paramMap=new HashMap<String, Object>();
				paramMap.put("queryYear", i);
				List<Object> objlist= eduTargetService.queryTagetListNoPage(paramMap);
				int pagesize= 500;
				int pageCount=rowcount%pagesize==0?rowcount/pagesize:rowcount/pagesize+1;
				for(int j=0;j<pageCount;j++)
				{
					String sql1 = "select a.teacher_id,a.teacher_score,b.user_province_id,b.user_city_id,b.user_district_id,b.school_id from edu_statistic_year a left join edu_user b on a.teacher_id = b.id where a.year="+i+" order by a.id asc limit "+j*pagesize+","+pagesize;
					List<Map<String,Object>> list = eduStatisticYearService.getStatisticYearBySql(sql1);
					//System.out.println(list.size());
					String updateuserids="0";
					for(Map<String,Object> m:list)
					{
						for(Object obj:objlist)
						{
							EduTargetByYear ty=(EduTargetByYear) obj;
							if(ty.getSchoolId()!=null && ty.getSchoolId().equals(m.get("school_id")) && Float.parseFloat(ty.getClassScore())>Float.parseFloat(m.get("teacher_score").toString()))
							{
								updateuserids+=","+m.get("teacher_id");
								break;
							}
							if(ty.getDistrictId()!=null && ty.getSchoolId()==null && ty.getDistrictId().equals(m.get("user_district_id")) && Float.parseFloat(ty.getClassScore())>Float.parseFloat(m.get("teacher_score").toString()))
							{
								updateuserids+=","+m.get("teacher_id");
								break;
							}
							if(ty.getCityId()!=null && ty.getDistrictId()==null && ty.getCityId().equals(m.get("user_city_id")) && Float.parseFloat(ty.getClassScore())>Float.parseFloat(m.get("teacher_score").toString()))
							{
								updateuserids+=","+m.get("teacher_id");
								break;
							}
							if(ty.getProvinceId()!=null && ty.getCityId()==null && ty.getProvinceId().equals(m.get("user_province_id")) && Float.parseFloat(ty.getClassScore())>Float.parseFloat(m.get("teacher_score").toString()))
							{
								updateuserids+=","+m.get("teacher_id");
								break;
							}
						}
					}
					if(!updateuserids.equals("0"))
					{
						String upsql = "update edu_statistic_year set is_standard=0 where year = " +i+ " and teacher_id in ("+updateuserids+") ";
						eduStatisticYearService.insertBySql(upsql);
					}
				}
			}
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void DictTask() throws Exception
	{
		
		//字典 -- 字典统计
		List<SysDictionary> xueliList = sysService.queryDicByDicType("educational_user");
		List<SysDictionary> xuekeList = sysService.queryDicByDicType("project_subject");
		List<SysDictionary> zhichengList = sysService.queryDicByDicType("teacher_professional");
		List<SysDictionary> xueduanList = sysService.queryDicByDicType("stduty_section");
		List<SysDictionary> schoolTypeList = sysService.queryDicByDicType("school_type");
		eduStatisticYearService.insertBySql("TRUNCATE edu_statistic_teacher");
		//学段统计
		String dicttypelist[]={"stduty_section"};
		//数据库计算年龄的sql
		String agesql = " and (year(now())-year(c.teacher_born_date)-1) + " + 
				"( DATE_FORMAT(NOW(), \'%m%d\') >=DATE_FORMAT(c.teacher_born_date, \'%m%d\') ) ";
		/*********************************************************************************************
		 *按学段统计 
		 ********************************************************************************************/
		
		for(int i=0;i<dicttypelist.length;i++)
		{
			//学段  -- 学历
			for(SysDictionary loopdict :xueliList)
			{
				String sql = "insert into edu_statistic_teacher (type,num,dict1_id,dict1_name,dict1_type,dict2_id,dict2_name,dict2_type)" +
						"select 1 as type," +
						"(select count(distinct u.id) from edu_user u " +
						"left join edu_teacher_job b on b.teacher_id=u.id and b.status=1 " +
						"left join edu_teacher_education c on u.id=c.teacher_id and c.status=1 " +
						"inner join (SELECT t.teacher_id,  max(t.sort) as sort from edu_teacher_education t where t.status=1 group by t.teacher_id) tm " 
						+" on c.teacher_id=tm.teacher_id and c.sort=tm.sort "+
						"where u.status!=0 and b.job_former_teaching_section_type = a.dictionary_id and c.education_experience_type="+loopdict.getDictionaryId()+" and u.role_id in (4,5)) as num," +
						"a.dictionary_id as dict1_id,a.dictionary_name as dict1_name ,a.dictionary_type as dict1_type ," +
						""+loopdict.getDictionaryId()+" as dict2_id,'"+loopdict.getDictionaryName()+"' as dict2_name,'"+loopdict.getDictionaryType()+"' as dict2_type " +
						"from edu_sys_dictionary a " +
						"where a.dictionary_type = '"+dicttypelist[i]+"' and a.status=1";
				eduStatisticYearService.insertBySql(sql);
			}
			
			//学段  --  学科 
//			for(SysDictionary loopdict :xuekeList)
//			{
//				String sql = "insert into edu_statistic_teacher (type,num,dict1_id,dict1_name,dict1_type,dict2_id,dict2_name,dict2_type)" +
//						"select 1 as type," +
//						"(select count(b.id) from edu_teacher_job b " +
//						" left join edu_user user on user.id=b.teacher_id " +
//						"where b.job_former_teaching_subject_type = a.dictionary_id and CONCAT(',',b.job_former_teaching_subject_type,',') like '%,"+loopdict.getDictionaryId()+",%' and user.role_id="+5+") as num," +
//						"a.dictionary_id as dict1_id,a.dictionary_name as dict1_name ,a.dictionary_type as dict1_type, " +
//						""+loopdict.getDictionaryId()+" as dict2_id,'"+loopdict.getDictionaryName()+"' as dict2_name,'"+loopdict.getDictionaryType()+"' as dict2_type " +
//						"from edu_sys_dictionary a " +
//						"where a.dictionary_type = '"+dicttypelist[i]+"' and a.status=1";
//				eduStatisticYearService.insertBySql(sql);
//			}
			
			//学段  --  职称
			
			//有职称的教师
			for(SysDictionary loopdict :zhichengList)
			{
				String sql = "insert into edu_statistic_teacher (type,num,dict1_id,dict1_name,dict1_type,dict2_id,dict2_name,dict2_type)" +
						"select 1 as type," +
						"(select count(distinct u.id) from edu_user u " +
						"left join edu_teacher_job b on u.id=b.teacher_id and b.status=1 " +
						"where u.status!=0 and b.job_former_teaching_section_type = a.dictionary_id and b.job_comment_position_type = "+loopdict.getDictionaryId()+" and u.role_id in (4,5)) as num," +
						"a.dictionary_id as dict1_id,a.dictionary_name as dict1_name ,a.dictionary_type as dict1_type, " +
						""+loopdict.getDictionaryId()+" as dict2_id,'"+loopdict.getDictionaryName()+"' as dict2_name,'"+loopdict.getDictionaryType()+"' as dict2_type " +
						"from edu_sys_dictionary a " +
						"where a.dictionary_type = '"+dicttypelist[i]+"' and a.status=1";
				eduStatisticYearService.insertBySql(sql);
			}
			
			//无职称的教师
			String nozcsql = "insert into edu_statistic_teacher (type,num,dict1_id,dict1_name,dict1_type,dict2_id,dict2_name,dict2_type)" +
					"select 1 as type," +
					"(select count(distinct u.id) from edu_user u " +
					"left join edu_teacher_job b on u.id=b.teacher_id and b.status=1 " +
					"where u.status!=0 and u.role_id in (4,5) and b.job_former_teaching_section_type = a.dictionary_id and b.job_comment_position_type is null) as num," +
					"a.dictionary_id as dict1_id,a.dictionary_name as dict1_name ,a.dictionary_type as dict1_type, " +
					"0 as dict2_id,'无教师职称' as dict2_name,'teacher_professional' as dict2_type " +
					"from edu_sys_dictionary a " +
					"where a.dictionary_type = '"+dicttypelist[i]+"' and a.status=1";
			eduStatisticYearService.insertBySql(nozcsql);
			
			//学段  -- 年龄段
			Integer agelist[]={0,1,2,3,4,5,6,7,8,9};
			//对应 0:24岁及以下	1:25-29岁 2:30-34岁 3:35-39岁 4:40-44岁 5:45-49岁	6:50-54岁 7:55-59岁 8:60岁及以上 9:其他
			for(int j=0;j<agelist.length;j++)
			{
				String datewhere="";
				Date date= new Date();
				//用这个方法获取年份时是从1900年开始计算的，因此当年份为2014时，得到的结果为114，所以如果要得到最终的年份，要再加上1900				
				int year = date.getYear() + 1900;
				switch(j){
				case 0:
				{
					//24岁及以下
//					int oldyear1=year-25;
//					String ds = DateUtil.dateToShortStr(date).replace(String.valueOf(year), String.valueOf(oldyear1));
//					datewhere=" > '"+ds+"'";
					datewhere= agesql + " between 0 and 24 ";
					break;
				}
				case 1:
				{
					//25-29岁 
//					int oldyear1=year-25;
//					int oldyear2 = year-30;
//					String oldds1 = DateUtil.dateToShortStr(date).replace(String.valueOf(year), String.valueOf(oldyear1));
//					String oldds2 = DateUtil.dateToShortStr(date).replace(String.valueOf(year), String.valueOf(oldyear2));
//					datewhere="between '"+oldds2+"' and '"+oldds1+"'";
					datewhere= agesql + " between 25 and 29 ";
					break;
				}
				case 2:
				{
					//30-34岁 
//					int oldyear1=year-30;
//					int oldyear2 = year-35;
//					String oldds1 = DateUtil.dateToShortStr(date).replace(String.valueOf(year), String.valueOf(oldyear1));
//					String oldds2 = DateUtil.dateToShortStr(date).replace(String.valueOf(year), String.valueOf(oldyear2));
//					datewhere="between '"+oldds2+"' and '"+oldds1+"'";
					datewhere= agesql + " between 30 and 34 ";
					break;
				}
				case 3:
				{
					//35-39岁 
//					int oldyear1=year-35;
//					int oldyear2 = year-40;
//					String oldds1 = DateUtil.dateToShortStr(date).replace(String.valueOf(year), String.valueOf(oldyear1));
//					String oldds2 = DateUtil.dateToShortStr(date).replace(String.valueOf(year), String.valueOf(oldyear2));
//					datewhere="between '"+oldds2+"' and '"+oldds1+"'";
					datewhere= agesql + " between 35 and 39 ";
					break;
				}
				case 4:
				{
					//4:40-44岁 
//					int oldyear1=year-40;
//					int oldyear2 = year-45;
//					String oldds1 = DateUtil.dateToShortStr(date).replace(String.valueOf(year), String.valueOf(oldyear1));
//					String oldds2 = DateUtil.dateToShortStr(date).replace(String.valueOf(year), String.valueOf(oldyear2));
//					datewhere="between '"+oldds2+"' and '"+oldds1+"'";
					datewhere= agesql + " between 40 and 44 ";
					break;
				}
				case 5:
				{
					//5:45-49岁
//					int oldyear1=year-45;
//					int oldyear2 = year-50;
//					String oldds1 = DateUtil.dateToShortStr(date).replace(String.valueOf(year), String.valueOf(oldyear1));
//					String oldds2 = DateUtil.dateToShortStr(date).replace(String.valueOf(year), String.valueOf(oldyear2));
//					datewhere="between '"+oldds2+"' and '"+oldds1+"'";
					datewhere= agesql + " between 45 and 49 ";
					break;
				}
				case 6:
				{
					//	6:50-54岁
//					int oldyear1=year-50;
//					int oldyear2 = year-55;
//					String oldds1 = DateUtil.dateToShortStr(date).replace(String.valueOf(year), String.valueOf(oldyear1));
//					String oldds2 = DateUtil.dateToShortStr(date).replace(String.valueOf(year), String.valueOf(oldyear2));
//					datewhere="between '"+oldds2+"' and '"+oldds1+"'";
					datewhere= agesql + " between 50 and 54 ";
					break;
				}
				case 7:
				{
					// 7:55-59岁
//					int oldyear1=year-55;
//					int oldyear2 = year-60;
//					String oldds1 = DateUtil.dateToShortStr(date).replace(String.valueOf(year), String.valueOf(oldyear1));
//					String oldds2 = DateUtil.dateToShortStr(date).replace(String.valueOf(year), String.valueOf(oldyear2));
//					datewhere="between '"+oldds2+"' and '"+oldds1+"'";
					datewhere= agesql + " between 55 and 59 ";
					break;
				}
				case 8:
				{
					 //8:60岁及以上
//					int oldyear1=year-61;
//					String ds = DateUtil.dateToShortStr(date).replace(String.valueOf(year), String.valueOf(oldyear1));
//					datewhere=" <= '"+ds+"'";
					datewhere= agesql + " between 60 and 200 ";
					break;
				}
				case 9:
				{
					// 9:其他
					//datewhere=" is null";
					datewhere= " and c.teacher_born_date is null ";
					break;
				}
				
				}
				String sql = "insert into edu_statistic_teacher (type,num,dict1_id,dict1_name,dict1_type,dict2_id,dict2_type,dict2_name)" +
						"select 1 as type," +
						"(select count(distinct u.id) from edu_user u " +
						"left join edu_teacher_basic_info c on u.id = c.teacher_id and c.status=1 " +
						"left join edu_teacher_job b on u.id=b.teacher_id and b.status=1 " +
						"where b.job_former_teaching_section_type = a.dictionary_id "+ datewhere +" and u.status!=0 and u.role_id in (4,5)) as num," +
						"a.dictionary_id as dict1_id,a.dictionary_name as dict1_name ,a.dictionary_type as dict1_type, " +
						""+agelist[j]+" as dict2_id,'age' as dict2_type ,'age"+agelist[j]+"' as dict2_name " +
						"from edu_sys_dictionary a " +
						"where a.dictionary_type = '"+dicttypelist[i]+"' and a.status=1";
				eduStatisticYearService.insertBySql(sql);
			}
		}
		
		/*********************************************************************************************
		 *按地区统计 
		 ********************************************************************************************/
		
		//地区  -- 字典
		//List<SysArea> areaList = sysReadDAO.selectAllAreas();
		
		//有职称
		for(SysDictionary loopdict :zhichengList)
		{
			String sql = "insert into edu_statistic_teacher (type,num,dict1_id,dict1_name,dict1_pid,dict2_type,dict2_id,dict2_name)"
					+" select "
					+" 0 as type,"
					+" (select count(distinct b.id) from edu_user b "
					+" left join edu_teacher_job c on b.id=c.teacher_id and c.status=1 "
					+" where b.status!=0 and b.role_id in (4,5) and c.job_comment_position_type = "+loopdict.getDictionaryId()+" and (b.user_province_id = a.id or b.user_city_id= a.id or b.user_district_id = a.id)) as num,"
					+" a.id as dict1_id ,a.name as dict1_name , a.up_lv_code as dict1_pid,'"+loopdict.getDictionaryType()+"' as dict2_type,"+loopdict.getDictionaryId()+" as dict2_id,'"+loopdict.getDictionaryName()+"' as dict2_name"
					+"  from edu_sys_area a where a.status=1";
			eduStatisticYearService.insertBySql(sql);
		}
		
		//无职称
		String sql1 = "insert into edu_statistic_teacher (type,num,dict1_id,dict1_name,dict1_pid,dict2_type,dict2_id,dict2_name)"
				+" select "
				+" 0 as type,"
				+" (select count(distinct b.id) from edu_user b "
				+" left join edu_teacher_job c on b.id=c.teacher_id and c.status=1 "
				+" where b.status!=0 and b.role_id in (4,5) and c.job_comment_position_type is null and (b.user_province_id = a.id or b.user_city_id= a.id or b.user_district_id = a.id)) as num,"
				+" a.id as dict1_id ,a.name as dict1_name , a.up_lv_code as dict1_pid, 'teacher_professional' as dict2_type, 0 as dict2_id,'无教师职称' as dict2_name"
				+"  from edu_sys_area a where a.status=1";
		eduStatisticYearService.insertBySql(sql1);
		
		//学历
		for(SysDictionary loopdict :xueliList)
		{
			String sql = "insert into edu_statistic_teacher (type,num,dict1_id,dict1_name,dict1_pid,dict2_type,dict2_id,dict2_name)"
					+" select "
					+" 0 as type,"
					+" (select count(distinct b.id) from edu_user b "
					+" left join edu_teacher_education c on b.id=c.teacher_id and c.status=1 " 
					+" inner join (SELECT t.teacher_id,  max(t.sort) as sort from edu_teacher_education t where t.status=1 group by t.teacher_id) tm " 
					+" on c.teacher_id=tm.teacher_id and c.sort=tm.sort "
					+" where b.status!=0 and b.role_id in (4,5) and c.education_experience_type="+loopdict.getDictionaryId()+" and (b.user_province_id = a.id or b.user_city_id= a.id or b.user_district_id = a.id)) as num,"
					+" a.id as dict1_id ,a.name as dict1_name , a.up_lv_code as dict1_pid,'"+loopdict.getDictionaryType()+"' as dict2_type,"+loopdict.getDictionaryId()+" as dict2_id,'"+loopdict.getDictionaryName()+"' as dict2_name"
					+"  from edu_sys_area a where a.status=1";
			eduStatisticYearService.insertBySql(sql);
		}
		
		
		for(SysDictionary loopdict :xuekeList)
		{
			String sql = "insert into edu_statistic_teacher (type,num,dict1_id,dict1_name,dict1_pid,dict2_type,dict2_id,dict2_name)"
					+" select "
					+" 0 as type,"
					+" (select count(b.id) from edu_user b "
					+" left join edu_teacher_job c on b.id=c.teacher_id"
					+" where b.role_id in (4,5) and CONCAT(',',c.job_former_teaching_subject_type,',') like '%,"+loopdict.getDictionaryId()+",%' and (b.user_province_id = a.id or b.user_city_id= a.id or b.user_district_id = a.id)"
					+" and c.status=1"
					+" ) as num,"
					+" a.id as dict1_id ,a.name as dict1_name , a.up_lv_code as dict1_pid,'"+loopdict.getDictionaryType()+"' as dict2_type,"+loopdict.getDictionaryId()+" as dict2_id,'"+loopdict.getDictionaryName()+"' as dict2_name"
					+"  from edu_sys_area a where a.status=1";
			eduStatisticYearService.insertBySql(sql);
		}
		Integer agelist[]={0,1,2,3,4,5,6,7,8,9};
		//对应 0:24岁及以下	1:25-29岁 2:30-34岁 3:35-39岁 4:40-44岁 5:45-49岁	6:50-54岁 7:55-59岁 8:60岁及以上 9:其他
		for(int j=0;j<agelist.length;j++)
		{
			String datewhere="";
			Date date= new Date();
			//用这个方法获取年份时是从1900年开始计算的，因此当年份为2009时，得到的结果为109，所以如果要得到最终的年份，要再加上1900
			//int year = date.getYear() + 1900;
			
			switch(j){
			case 0:
			{
				//24岁及以下
				//int oldyear1=year-25;
				//String ds = DateUtil.dateToShortStr(date).replace(String.valueOf(year), String.valueOf(oldyear1));
				datewhere= agesql + " between 0 and 24 ";
				break;
			}
			case 1:
			{
				
				
				//25-29岁 
//				int oldyear1=year-25;
//				int oldyear2 = year-29;
//				//String oldds1 = DateUtil.dateToShortStr(date).replace(String.valueOf(year), String.valueOf(oldyear1));
//				//String oldds2 = DateUtil.dateToShortStr(date).replace(String.valueOf(year), String.valueOf(oldyear2));
//				String oldds2 = "1985-6-25";
//				String oldds1 = "1990-6-24";
//				datewhere="between '"+oldds2+"' and '"+oldds1+"'";
				datewhere= agesql + " between 25 and 29 ";
				break;
			}
			case 2:
			{
				//30-34岁 
//				int oldyear1=year-30;
//				int oldyear2 = year-34;
//				String oldds1 = DateUtil.dateToShortStr(date).replace(String.valueOf(year), String.valueOf(oldyear1));
//				String oldds2 = DateUtil.dateToShortStr(date).replace(String.valueOf(year), String.valueOf(oldyear2));
//				datewhere="between '"+oldds2+"' and '"+oldds1+"'";
				datewhere= agesql + " between 30 and 34 ";
				break;
			}
			case 3:
			{
				//35-39岁 
//				int oldyear1=year-35;
//				int oldyear2 = year-39;
//				String oldds1 = DateUtil.dateToShortStr(date).replace(String.valueOf(year), String.valueOf(oldyear1));
//				String oldds2 = DateUtil.dateToShortStr(date).replace(String.valueOf(year), String.valueOf(oldyear2));
//				datewhere="between '"+oldds2+"' and '"+oldds1+"'";
				datewhere= agesql + " between 35 and 39 ";
				break;
			}
			case 4:
			{
				//4:40-44岁 
//				int oldyear1=year-40;
//				int oldyear2 = year-44;
//				String oldds1 = DateUtil.dateToShortStr(date).replace(String.valueOf(year), String.valueOf(oldyear1));
//				String oldds2 = DateUtil.dateToShortStr(date).replace(String.valueOf(year), String.valueOf(oldyear2));
//				datewhere="between '"+oldds2+"' and '"+oldds1+"'";
				datewhere= agesql + " between 40 and 44 ";
				break;
			}
			case 5:
			{
				//5:45-49岁
//				int oldyear1=year-45;
//				int oldyear2 = year-49;
//				String oldds1 = DateUtil.dateToShortStr(date).replace(String.valueOf(year), String.valueOf(oldyear1));
//				String oldds2 = DateUtil.dateToShortStr(date).replace(String.valueOf(year), String.valueOf(oldyear2));
//				datewhere="between '"+oldds2+"' and '"+oldds1+"'";
//				
				datewhere= agesql + " between 45 and 49 ";
				break;
			}
			case 6:
			{
				//	6:50-54岁
//				int oldyear1=year-50;
//				int oldyear2 = year-54;
//				String oldds1 = DateUtil.dateToShortStr(date).replace(String.valueOf(year), String.valueOf(oldyear1));
//				String oldds2 = DateUtil.dateToShortStr(date).replace(String.valueOf(year), String.valueOf(oldyear2));
//				datewhere="between '"+oldds2+"' and '"+oldds1+"'";
				datewhere= agesql + " between 50 and 54 ";
				break;
			}
			case 7:
			{
				// 7:55-59岁
//				int oldyear1=year-55;
//				int oldyear2 = year-59;
//				String oldds1 = DateUtil.dateToShortStr(date).replace(String.valueOf(year), String.valueOf(oldyear1));
//				String oldds2 = DateUtil.dateToShortStr(date).replace(String.valueOf(year), String.valueOf(oldyear2));
//				datewhere="between '"+oldds2+"' and '"+oldds1+"'";
				datewhere= agesql + " between 55 and 59 ";
				break;
			}
			case 8:
			{
				 //8:60岁及以上
//				int oldyear1=year-60;
//				String ds = DateUtil.dateToShortStr(date).replace(String.valueOf(year), String.valueOf(oldyear1));
//				datewhere=" <= '"+ds+"'";
				datewhere= agesql + " between 60 and 200 ";
				break;
			}
			case 9:
			{
				// 9:其他
				//datewhere=" is null";
				datewhere= " and c.teacher_born_date is null ";
				break;
			}
			
			}
			String sql = "insert into edu_statistic_teacher (type,num,dict1_id,dict1_name,dict1_pid,dict2_type,dict2_id,dict2_name)"
					+" select "
					+" 0 as type,"
					+" (select count(distinct b.id) from edu_user b "
					+" left join edu_teacher_basic_info c on b.id=c.teacher_id and c.status=1 "
					+" where b.status!=0 and b.role_id in (4,5) "+datewhere+" and (b.user_province_id = a.id or b.user_city_id= a.id or b.user_district_id = a.id)) as num,"
					+" a.id as dict1_id ,a.name as dict1_name , a.up_lv_code as dict1_pid,'age' as dict2_type,"+agelist[j]+" as dict2_id,'age"+agelist[j]+"' as dict2_name"
					+"  from edu_sys_area a where a.status=1";
			eduStatisticYearService.insertBySql(sql);
		}
		
		
		//教师： 分年度：地区*培训情况（年度培训人次、合格率）、地区*考核情况（教师人数、年度合格率）：
		eduStatisticYearService.insertBySql("TRUNCATE edu_statistic_jijiao");
		List<Integer> yl = eduProjectReadDAO.selectGroupYear();
		for(int i:yl)
		{
			String sql = "insert into edu_statistic_jijiao (year,area_id,area_name,area_pid,teacher_num,train_num,percent)" +
					"select "+i+" as year,a.id as area_id,a.name as area_name,a.up_lv_code as area_pid,"
					+" (select count(b.id) from edu_statistic_year b "
					+" left join edu_user c on c.id=b.teacher_id where b.year="+i+" and (c.user_province_id = a.id or c.user_city_id= a.id or c.user_district_id = a.id)) as teacher_num,"
					+" (select sum(b.project_count) from edu_statistic_year b "
					+" left join edu_user c on c.id=b.teacher_id where b.year="+i+" and (c.user_province_id = a.id or c.user_city_id= a.id or c.user_district_id = a.id)) as train_num,"
					+" ((select count(b.id) from edu_statistic_year b "
					+" left join edu_user c on c.id=b.teacher_id where b.year="+i+" and b.is_standard=1 and (c.user_province_id = a.id or c.user_city_id= a.id or c.user_district_id = a.id))/"
					+" (select count(b.id) from edu_statistic_year b "
					+" left join edu_user c on c.id=b.teacher_id where b.year="+i+" and (c.user_province_id = a.id or c.user_city_id= a.id or c.user_district_id = a.id))) as percent"

					+" from edu_sys_area a where status=1";
			eduStatisticYearService.insertBySql(sql);
		}
		
		//学校信息统计： 地区*学段：		
		eduStatisticYearService.insertBySql("TRUNCATE edu_statistic_school");
		//for(SysDictionary loopdict :xueduanList)
		for(SysDictionary loopdict :schoolTypeList)
		{
			String sql = "insert into edu_statistic_school (area_id,area_name,area_pid,dict1_type,dict1_id,dict1_name,num)"
					+" select "
					+" a.id as area_id,a.name as area_name,a.up_lv_code as area_pid,"
					+" '"+loopdict.getDictionaryType()+"' as dict1_type,"+loopdict.getDictionaryId()+" as dict1_id,'"+loopdict.getDictionaryName()+"' as dict1_name,"
					+" (select count(b.school_id) from edu_school b "
					+" left join edu_sys_dictionary c on c.dictionary_id = b.school_type_id "
					+" where c.dictionary_id="+loopdict.getDictionaryId()+" and c.dictionary_type='school_type' and (b.school_province_id = a.id or b.school_city_id= a.id or b.school_district_id = a.id)"
					+" ) as num"
					+" from edu_sys_area a where status=1";
			eduStatisticYearService.insertBySql(sql);
		}
	}
	
	/*福建能力提升数据统计*/
	public void fjnenglitisheng() throws Exception
	{
		eduStatisticYearService.insertBySql("TRUNCATE edu_statistic_nlts");
		//先统计地区的数据
		String earasql = "insert into edu_statistic_nlts (area_id,area_name,area_pid,shangbaoSum,dengluSum,canxunlvSum,youxiaoxuexiSum,"
	                 +"xuexilvSum,hegeSum,hegelvSum,kechengzuoyeSum,gongzuofangSum,yanxiuhuodongSum,yanxiuhuodongcanyuSum,shijianyanxiuSum,xiaomujianbaoSum,updateTime)"
				     +"SELECT a.id AS area_id,"
				     +"a. NAME AS area_name,"
				     +"a.up_lv_code AS area_pid,"
					 +"sum(b.shangbao_num) AS shangbaoSum,"
					 +"sum(b.denglu_num) AS dengluSum, "
					 +"round(sum(b.denglu_num) / sum(b.shangbao_num) * 100,2) AS canxunlvSum,"
					 +"sum(b.youxiaoxuexi_num) AS youxiaoxuexiSum," 
					 +"round(sum(b.youxiaoxuexi_num) / sum(b.denglu_num) * 100,2) AS xuexilvSum,"
					 +"sum(b.hege_num) AS hegeSum," 
					 +"round(sum(b.hege_num) / sum(b.youxiaoxuexi_num) * 100,2) AS hegelvSum,"
					 +"sum(b.kechengzuoye_num) AS kechengzuoyeSum,"
					 +"sum(b.gongzuofang_num) AS gongzuofangSum,"
					 +"sum(b.yanxiuhuodong_num) AS yanxiuhuodongSum,"
					 +"sum(b.yanxiuhuodongcanyu_num) AS yanxiuhuodongcanyuSum,"
					 +"sum(b.shijianyanxiuchengguo_num	) AS shijianyanxiuSum,"
					 +"sum(b.xiangmujianbao_num) AS xiaomujianbaoSum,"
					 +"now() "
					 +"FROM edu_sys_area a "
					 +"LEFT JOIN edu_teacher_nlts b ON 1 = 1 AND b. STATUS = 1 "
					 +"AND (a.id = b.city_id OR a.id = b.province_id OR a.id = district_id) "
					 +"WHERE a. STATUS = 1 AND a. CODE != 1163 AND a.up_lv_code != 1163 "
					 +"GROUP BY a.id"; 
		//统计学校的数据
		String schoolsql = "insert into edu_statistic_nlts (area_id,area_name,area_pid,shangbaoSum,dengluSum,canxunlvSum,youxiaoxuexiSum,"
				     +"xuexilvSum,hegeSum,hegelvSum,kechengzuoyeSum,gongzuofangSum,yanxiuhuodongSum,yanxiuhuodongcanyuSum,shijianyanxiuSum,xiaomujianbaoSum,updateTime)"
				     +"select f.school_id as area_id,f.school_name as area_name,f.district_id as area_pid,"
				     +"f.shangbao_num as shangbaoSum,"
				     +"f.denglu_num as dengluSum,"
                     +"round(f.denglu_num / f.shangbao_num*100,2) as canxunlvSum,"
                     +"f.youxiaoxuexi_num as youxiaoxuexiSum,"
                     +"round(f.youxiaoxuexi_num / f.denglu_num*100,2) as xuexilvSum,"
                     +"f.hege_num as hegeSum,"
                     +"round(f.hege_num / f.youxiaoxuexi_num*100,2) as hegelvSum,"
                     +"f.kechengzuoye_num as kechengzuoyeSum,"
                     +"f.gongzuofang_num as gongzuofangSum,"
                     +"f.yanxiuhuodong_num as yanxiuhuodongSum,"
                     +"f.yanxiuhuodongcanyu_num as yanxiuhuodongcanyuSum,"
                     +"f.shijianyanxiuchengguo_num as shijianyanxiuSum,"
                     +"f.xiangmujianbao_num as xiaomujianbaoSum,"
                     +" now() from edu_teacher_nlts f where f.status = 1";
		
		eduStatisticYearService.insertBySql(earasql);
		eduStatisticYearService.insertBySql(schoolsql);
	}
}
