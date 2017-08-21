package project.message.dao.impl;

import java.util.Map;

import framelib.dao.BaseDAOImpl;
import project.message.dao.INoticeWriteDao;

public class NoticeWriteDaoImpl extends BaseDAOImpl implements INoticeWriteDao {

	@Override
	public int insertNotice(Map<String, Object> paramMap) throws Exception {
		Object obj = this.getSqlMapClientTemplate().insert("sendNotice",
				paramMap);
		if (obj != null) {
			return Integer.parseInt(obj.toString());
		}
		return -1;
	}

	@Override
	public boolean insertNoticeArea(Map<String, Object> paramMap)
			throws Exception {
		Object obj = this.getSqlMapClientTemplate().insert("sendNoticeArea",
				paramMap);
		if (obj == null)
			return true;
		return false;
	}

	@Override
	public boolean readNotice(Map<String, Object> paramMap) {
		Object obj = this.getSqlMapClientTemplate().insert("readNotice",
				paramMap);
		if (obj == null)
			return true;
		return false;
	}

	@Override
	public boolean deleteNotice(Map<String, Object> paramMap) {
		int line  = this.getSqlMapClientTemplate().delete("deleteNotice",
				paramMap);
		if(line>0)
			return true;
		return false;
	}

	@Override
	public boolean deleteNoticeUser(Map<String, Object> paramMap) {
		int line = this.getSqlMapClientTemplate().delete("deleteNoticeUser",
				paramMap);
		if(line>0)
			return true;
		return false;
	}

	@Override
	public boolean deleteNoticeArea(Map<String, Object> paramMap) {
		int line = this.getSqlMapClientTemplate().delete("deleteNoticeArea",
				paramMap);
		if(line>0)
			return true;
		return false;
	}

	@Override
	public boolean noticeDeleteFromOther(Map<String, Object> paramMap) {
		int line = this.getSqlMapClientTemplate().update("noticeDeleteFromOther",
				paramMap);
		if(line>0)
			return true;
		return false;
	}

	@Override
	public boolean addNoticeFile(Map<String, Object> paramMap) throws Exception {
		Object obj = this.getSqlMapClientTemplate().insert("addNoticeFile",
				paramMap);
		if (obj == null)
			return true;
		return false;
	}

}
