package project.fileupload.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import project.fileupload.pojo.FileUpload;
import framelib.dao.BaseDAOImpl;

public class FileUploadReadDaoImpl extends BaseDAOImpl implements
		FileUploadReadDao {

	@Override
	public List<FileUpload> getFileListByCondition(Map<String, Object> condition) {
		List<FileUpload> result = Collections.emptyList();
		result = queryForList("select_file_list", condition);
		return result;

	}

	public List<FileUpload> getOthersFileUploads(Map<String, Object> condition) {
		// TODO Auto-generated method stub
		List<FileUpload> result = Collections.emptyList();
		result = queryForList("select_others_file_list", condition);
		return result;
	}

}
