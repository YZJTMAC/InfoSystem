package project.furtheredu.edumanage.dao;

import java.util.Map;




public interface IEduStatisticModelWriteDao {
	public void insertBySql(Map<String,String> map);
	public void deleteBySql(Map<String,String> map);
}
