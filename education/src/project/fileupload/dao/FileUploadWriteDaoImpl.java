package project.fileupload.dao;

import java.util.Map;

import framelib.dao.BaseDAOImpl;
import project.fileupload.pojo.FileUpload;

public class FileUploadWriteDaoImpl extends BaseDAOImpl implements
		FileUploadWriteDao {

	@Override
	public Integer insertFile(FileUpload file) {
		Object obj = executeInsert("insertFile", file);
		if (obj != null) {
			return (Integer) obj;
		} else {
			return -1;
		}
	}

	@Override
	public Integer deleteFileById(Integer id) {
		Integer obj  = executeUpdate("deleteFileById", id);
		if (obj != null) {
			return (Integer) obj;
		} else {
			return -1;
		}
	}

	@Override
	public Integer deleteFileByProjectId(Map<String, Object> condition) {
		Integer obj  = executeUpdate("deleteFileByProjectId", condition);
		if (obj != null) {
			return (Integer) obj;
		} else {
			return -1;
		}
	}

}
