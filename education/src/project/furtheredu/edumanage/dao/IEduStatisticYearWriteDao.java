package project.furtheredu.edumanage.dao;

import java.util.Map;




public interface IEduStatisticYearWriteDao {
	public Integer insertBySql(Map<String,String> map);
	public void deleteBySql(Map<String,String> map);
}
