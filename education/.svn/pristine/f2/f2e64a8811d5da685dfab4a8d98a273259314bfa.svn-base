package project.furtheredu.eduTarget.dao.impl;


import project.furtheredu.eduTarget.dao.IEduTagetWriteDao;
import project.furtheredu.eduTarget.pojo.EduTargetByYear;
import project.teacher.teachermanage.pojo.EduTeacherBasicInfo;
import framelib.dao.BaseDAOImpl;

public class EduTagetWriteDaoImpl extends BaseDAOImpl implements IEduTagetWriteDao {  
	
	@Override
	public Integer insertTagetInfo(EduTargetByYear target) throws Exception {
		Object obj = this.getSqlMapClientTemplate().insert("target_insert", target);
		if (obj != null) {
			return (Integer) obj;
		} else {
			return -1;
		}
	}
	
	@Override
	public Integer updateTarget(EduTargetByYear target) throws Exception {
		Object obj = this.getSqlMapClientTemplate().update("updateTarget", target);
		if (obj != null) {
			return 0;
		} else {
			return -1;
		}
	}
	
	@Override
	public Integer deleteTargetById(Integer id) throws Exception {
		Object obj = this.getSqlMapClientTemplate().delete("deleteTargetById", id);
		if (obj != null) {
			return 0;
		} else {
			return -1;
		}
	}
}