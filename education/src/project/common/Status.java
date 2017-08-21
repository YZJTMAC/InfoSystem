package project.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import project.system.pojo.SysDictionary;
import project.system.service.ISysService;

public class Status {
	public static final Logger log = Logger.getLogger(Common.class);
	public static ISysService sysService;
	public static  Map<String,String> STATUS  = new HashMap<String,String>();
	static{
		Status.STATUS  = initMap("status");
	}
		public static Map<String,String> initMap(String dicType) {
		Map<String,String> temp = new HashMap<String,String>();
		try {
			List<SysDictionary> d = sysService.queryDicByDicType(dicType);
			for (SysDictionary obj : d) {
				if(obj.getDictionaryId() == null) {
					log.error("Common 初始化异常 数据字典ID" + obj.getId() );
					continue;
				}
				temp.put(obj.getDictionaryId().toString(), obj.getDictionaryName());
			}
		} catch (Exception e) {
		e.printStackTrace();
			log.error("Common 初始化异常");
		}
		return temp;
	}
}
