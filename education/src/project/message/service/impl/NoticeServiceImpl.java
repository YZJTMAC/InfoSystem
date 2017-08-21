package project.message.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import framelib.utils.page.PageObject;
import framelib.utils.page.PageParser;

import project.edupm.projectmanage.pojo.EduProject;
import project.message.dao.INoticeReadDao;
import project.message.dao.INoticeWriteDao;
import project.message.pojo.EduNotice;
import project.message.pojo.EduNoticeFile;
import project.message.pojo.EduNoticeUser;
import project.message.service.INoticeService;

public class NoticeServiceImpl implements INoticeService {

	@Autowired
	@Qualifier("noticeWriteDao")
	private INoticeWriteDao noticeWriteDao;
	
	@Autowired
	@Qualifier("noticeReadDao")
	private INoticeReadDao noticeReadDao;
	
	
	@Override
	public int sendNotice(Map<String, Object> paramMap) throws Exception {
		return noticeWriteDao.insertNotice(paramMap);
	}


	@Override
	public PageObject noticeList(Map<String, Object> paramMap,int startIndex ,int pageSize)
			throws Exception {
		PageObject po = new PageObject();
		int count = noticeReadDao.selectNoticeCount(paramMap);
		po.setCount(count);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		paramMap.put("startIndex", po.getStartIndex());
		paramMap.put("endIndex", pageSize);
		List<EduNotice> proList = noticeReadDao.noticeList(paramMap);
//		List<String> readNoticeIds = noticeReadDao.readNoticeIds(paramMap);
//		for(EduNotice notice:proList){
//			for(String noticeId :readNoticeIds){
//				if(notice.getId().toString().equals(noticeId)){
//					notice.setRead(true);
//					break;
//				}
//			}
//		}
		po.setObjects(proList);
		return po;
	}
	@Override
	public  PageObject myNoticeList(Map<String, Object> paramMap,int startIndex ,int pageSize)
			throws Exception {
		PageObject po = new PageObject();
		int count = noticeReadDao.selectMyNoticeListCount(paramMap);
		po.setCount(count);
		PageParser.getPageObject(PageParser.getPageInfo(startIndex, pageSize, po.getCount()), po);
		paramMap.put("startIndex", po.getStartIndex());
		paramMap.put("endIndex", pageSize);
		po.setObjects(noticeReadDao.myNoticeList(paramMap));
		return po;
	}

	@Override
	public EduNotice noticeDetail(Integer id) {
		return noticeReadDao.selectById(id);
	}


	@Override
	public boolean addArea(Map<String, Object> paramMap) throws Exception {
		return noticeWriteDao.insertNoticeArea(paramMap);
	}


	@Override
	public boolean readNotice(Map<String, Object> paramMap) throws Exception {
		return noticeWriteDao.readNotice(paramMap);
	}


	@Override
	public Integer selectNoticeCount(Map<String, Object> paramMap)
			throws Exception {
		return noticeReadDao.selectNoticeCount(paramMap);
	}


	@Override
	public Integer readNoticeCount(Map<String, Object> paramMap) {
		return noticeReadDao.readNoticeCount(paramMap);
	}


	@Override
	public List<EduNoticeUser> getNoticeUser(Map<String, Object> paramMap) {
		return noticeReadDao.getNoticeUser(paramMap);
	}


	@Override
	public boolean deleteNotice(Map<String, Object> paramMap) {
		boolean result1 =  noticeWriteDao.deleteNotice(paramMap);
		boolean result2 = noticeWriteDao.deleteNoticeArea(paramMap);
		boolean result3 =  noticeWriteDao.deleteNoticeUser(paramMap);
		return  result1&&result2&&result3;
	}


	@Override
	public boolean noticeDeleteFromOther(Map<String, Object> paramMap) {
		return  noticeWriteDao.noticeDeleteFromOther(paramMap);
	}


	@Override
	public List<String> readNoticeIds(Map<String, Object> paramMap) {
		return noticeReadDao.readNoticeIds(paramMap);
	}


	@Override
	public boolean addNoticeFile(Map<String, Object> paramMap) throws Exception {
		// TODO Auto-generated method stub
		return noticeWriteDao.addNoticeFile(paramMap);
	}


	@Override
	public List<EduNoticeFile> selectNoticeFilesByNoticeId(Integer noticeId) {
		// TODO Auto-generated method stub
		return noticeReadDao.selectNoticeFilesByNoticeId(noticeId);
	}
	

}
