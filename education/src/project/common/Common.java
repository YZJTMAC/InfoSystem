
package project.common;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import project.system.pojo.SysDictionary;
import project.system.pojo.SysPlatformSetup;
import project.system.service.ISysService;

public class Common {
	public static final Logger log = Logger.getLogger(Common.class);
	
	public static ISysService sysService;
	
	public static Map<String, Object> sysCodeMap = new HashMap<String, Object>();
	
	// 系统平台设置
	public static Map<String, Object> SYS_PLATFORM_SETUP = new HashMap<String, Object>();
	
	//职称(聘 评)
	public static Map<String,String> PROJECT_DIM_PROFESSIONAL_TITLE = new HashMap<String,String>();
	
	//职位
	public static final Map<String,String> PROJECT_DIM_POSITION = new HashMap<String,String>();
	
	//教师编制
	public static  Map<String,String> TEACHER_STAFF = new HashMap<String,String>();
	
	//教师资格种类
	public static  Map<String,String> TEACHER_QUALIFICATION_TYPE = new HashMap<String,String>();
	
	//教师学校行政职务类型
	public static Map<String,String> TEACHER_OFFICE_TYPE = new HashMap<String,String>();
	
	//学位
	public static  Map<String,String> TEACHER_DIM_DEGREE_DEAN = new HashMap<String,String>();
	
	//学历
	public static Map<String,String> TEACHER_DIM_EDUCATION_BACKGROUND_DEAN = new HashMap<String,String>();
	
	//政治面貌 
	public static Map<String,String> TEACHER_DIM_EDUCATION_POLITICAL_STATUS = new HashMap<String,String>();
	
	//所在区划(学校)
	public static Map<String,String> AREA_TYPE = new HashMap<String,String>();
	
	//学校类型
	public static Map<String,String> SCHOOL_TYPE = new HashMap<String,String>();
	
	//学校办别
	public static Map<String,String> SCHOOL_ESTABLIST_TYPE = new HashMap<String,String>();
	
	//学校性质
	public static Map<String,String> SCHOOL_NATURE = new HashMap<String,String>();
	
	// 特岗教师类别
	public static  Map<String,String> TEACHER_DIM_TGJS = new HashMap<String,String>();
	
	// 免费师范生
	public static  Map<String,String> TEACHER_DIM_MFSFS = new HashMap<String,String>();
	
	// 普通话等级
	public static  Map<String,String> TEACHER_DIM_PTHDJ = new HashMap<String,String>();
	
	// 教师资格证种类
	public static  Map<String,String> TEACHER_DIM_JSZGZ  = new HashMap<String,String>();
	
	// 合同签订情况
	public static  Map<String,String> TEACHER_DIM_CONTRACT = new HashMap<String,String>();
	
	// 岗位类别
	public static  Map<String,String> TEACHER_DIM_GWLB = new HashMap<String,String>();
	
	// 岗位等级
	public static  Map<String,String> TEACHER_DIM_GWDJ = new HashMap<String,String>();

	// 国籍 
	public static  Map<String,String> TEACHER_DIM_COUNTRY = new HashMap<String,String>();
	// 结项评价维度
	public static  Map<String,String> COMMENT_DIM_COUNTRY = new HashMap<String,String>();
	
	// 名师培养对象
	public static  Map<String,String> TEACHER_DIM_MSPYDX = new HashMap<String,String>();
	
	// 教学名师
	public static  Map<String,String> TEACHER_DIM_JXMS = new HashMap<String,String>();
	
	// 学科带头人
	public static  Map<String,String> TEACHER_DIM_XKDTR = new HashMap<String,String>();
	
	// 骨干教师
	public static  Map<String,String> TEACHER_DIM_GGJS = new HashMap<String,String>();
	
	/**项目年份**/
	public static final List<String> YEARS = new ArrayList<String>(){
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		{
			add("2016");
			add("2015");
			add("2014");
			add("2013");
			add("2012");
			add("2011");
			add("2010");
			add("2009");
			add("2008");
			add("2007");
			add("2006");
		}
	};
	
	/**问卷状态0未开启；1开启；2删除;3结束*/
	public static final int PAPER_STA_NOSTART = 0; 
	public static final int PAPER_STA_START = 1; 
	public static final int PAPER_STA_DELETE = 2; 
	public static final int PAPER_STA_END= 3; 
	
	/**问卷是否强制，0是；1否*/
	public static final int PAPER_FORCE_YES = 0; 
	public static final int PAPER_FORCE_NO = 1; 
	
	/**试题选项*/
	public static final int PAPER_Q_LIMIT = 100; 
	
	/**问题类型0填空；1问答；2单选；3多选*/
	public static final int PAPER_Q_FILL = 0; 
	public static final int PAPER_Q_ANSWER = 1; 
	public static final int PAPER_Q_RADIO = 2; 
	public static final int PAPER_Q_CHECKBOX= 3; 
	
	/**问卷状态0未开启；1删除;*/
	public static final int PAPER_Q_STA_YES = 0; 
	public static final int PAPER_Q_STA_DELETE = 1; 
	
	public static final int PNN_USER_PAGE_LIMIT = 10; 
	
	// 系统角色
	public static final Integer ROLE_TEACHER_5 = 5;
	public static final Integer ROLE_ORGANIZTION_SHISHI_SHENG = 7;
	public static final Integer ROLE_ORGANIZTION_SHISHI_SHI = 8;
	public static final Integer ROLE_ORGANIZTION_SHISHI_QU = 9;
	public static final Integer ROLE_ORGANIZTION_SHISHI_XIAO = 10;
	public static final Integer ROLE_ORGANIZTION_CHENGPEI = 6;
	//	教师状态-未审核
	public static final Integer TEACHER_STATUS_6 = 6;
	
	//	教师状态-审核不通过
	public static final Integer TEACHER_STATUS_7 = 7;
	
	
	
	//	教师状态-在职
	public static final Integer TEACHER_STATUS_8 = 8;

	//以下教师信息状态在edu_sys_dictionary中，可以通过select * from edu_sys_dictionary where dictionary_type ='change_type'得到
	
	//	教师状态-已离退休 
	public static final Integer TEACHER_STATUS_9 = 9;
	
	
	//教师退休
	public static final Integer TEACHER_STATUS_31 = 31;
	
	//教师死亡
	public static final Integer TEACHER_STATUS_32 = 32;
	
	//教师离休
	public static final Integer TEACHER_STATUS_33 = 33;
	
	//教师离岗
	public static final Integer TEACHER_STATUS_34 = 34;
	
	//教师病休
	public static final Integer TEACHER_STATUS_35 = 35;
	
	
	//  删除
	public static final Integer TEACHER_STATUS_0 = 0;
	
	// 公告状态 自动审核通过
	public static final Integer COMMON_AUDIT_AUTOPASS = 15;
	
	//  公共状态  待审
	public static final Integer COMMON_AUDIT_UNHANDL = 11;
	
	//  公共状态  审核中
	public static final Integer COMMON_AUDIT_HANDLING = 14;
	
	//  公共状态  未通过
	public static final Integer COMMON_AUDIT_UNPASS = 12;
	
	//  公共状态  通过
	public static final Integer COMMON_AUDIT_PASS = 13;
	
	public static final Integer COMMON_AUDIT_DELETE = 0;
	
	//数据有效
	public static final Integer DATA_VALID = 1;
	//数据无效（删除状态）
	public static final Integer DATA_NO_VALID = 0;
	
	//数据默认值
	public static final String DEFAULT_STR = "0";
	
	public static final Integer DEFAULT_VALUE = 0;
	
	
	// 信息变更审核状态
	public static final Integer CHANGE_TYPE_1 = 1;
	
	// 信息调动状态
	public static final Integer CHANGE_TYPE_2 = 2;
	
	// 编制调整状态
	public static final Integer CHANGE_TYPE_50 = 50;
	
	public static final Integer CHANGE_TYPE_31 = 31;
	
	public static final Integer CHANGE_TYPE_32 = 32;
	
	public static final Integer CHANGE_TYPE_33 = 33;
	
	public static final Integer CHANGE_TYPE_34 = 34;
	
	public static final Integer CHANGE_TYPE_35 = 35;
	
	public static final Integer CHANGE_TYPE_36 = 36;
	
	// 返聘操作
	public static final Integer CHANGE_TYPE_40 = 40;
	
	//消息状态:已读
	public static final Integer COMMON_MESSAGE_HAVA_READ = 1;
	//消息状态:未读
	public static final Integer COMMON_MESSAGE_NO_READ = 0;
	
	/**
	 * 校本和非校本类项目（继教）:1校本；2非校本
	 */
	public static final Integer NOTRAIN_TYPE_ONE=1;
	public static final Integer NOTRAIN_TYPE_TWO=2;
	
	//统计类型 0地区;1字典
	public static final Integer TEACHER_STATS_AREA = 0;
	public static final Integer TEACHER_STATS_DICT = 1;
	
	//能力提升培训项目统计起始时间
	public static final String START_YEAR = "2016";
	
	//按关键字统计能力提升数据
	public static final String EDU_MODEL_SEARCH_STR = "福建省中小学教师信息技术应用能力提升培训";
	
	//查询全部字典内容
	public static final Integer QUERY_DICTIONRAY_BY_ROLE = 1;
	
	//系统开始年限
	public static final Integer START_RELEASE_YEAR = 2014;

	
	public static Map<String,String> PROJECT_DIM_PROJECT_SCOPE = new HashMap<String,String>(){
		{
			put("1","国培项目");
			put("2","省级培训项目");
			put("3","地市级培训项目");
			put("4","区县级培训项目");
			put("5","校本培训项目");
			put("6","其他");
			
			
		}
	};
	
	public static List<String> AUTO_CREDIT_lEND = new ArrayList<String>(){//自动借贷地区
		{
			add("220403");//东丰县
		}
	};
	
	public static List<String> DIRECT_UNIT = new ArrayList<String>(){
		{
			add("113");//学校后勤管理中心
			add("57");//教师进修学校
			add("125");//教育局局机关
			add("91");//教育装备中心
			add("109");//校外教育指导中心
		}
	};
	
	//项目属性
	public static final Map<String,String> PROJECT_DIM_PROJECT_PROPERTY = new HashMap<String,String>(){
		{
			put("1","新教师培训");
			put("2","岗位培训");
			put("3","全员培训");
			put("4","骨干教师培训");
			put("5","校长培训");
			put("6","班主任培训");
			put("7","专题培训");
			put("8","高级研修");
			put("9","学前教师");
			put("10","置换脱产研修");
			put("11","短期集中培训");
			put("12","转岗教师培训");
			put("13","远程培训");
			put("14","其他");
			
			
		}
	};
	
	public static final Map<String,String> PROJECT_DIM_PROJECT_TRAIN_TYPE = new HashMap<String,String>(){
		{
			put("1","远程");
			put("2","面授");
			put("3","混合（集中面授+远程）");
		}
	};
	
	//学历
	public static final Map<String,String> PROJECT_DIM_EDUCATION_BACKGROUND = new HashMap<String,String>(){
		{
			put("1","高中");
			put("2","专科");
			put("3","本科");
			put("4","硕士");
			put("5","博士");
		}
	};
	
	public static final Map<String,String> TEACHER_STATUS = new HashMap<String,String>(){
		{
			put("8","在职");
			put("6","未审核");
//			put("7","审核不通过");
			put("9","已离退休");
		}
	};
	
	//年级
	public static final Map<String,String> PROJECT_DIM_GRADE = new HashMap<String,String>(){
		{
			put("1","大一");
			put("2","大二");
			put("3","大三");
			put("4","大四");
		}
	};
	
	//项目状态
	public static final Map<String,Integer> PROJECT_DIM_PROJECT_STATUS = new HashMap<String,Integer>(){
		{
			put("准备中",1);
			put("正在进行中",2);
			put("已结束",3);
			put("创建中", 4);
		}
	};
	//第一学历
	public static final Map<String,Integer> TEACHER_DIM_EDUCATION_BACKGROUND = new HashMap<String,Integer>(){
		{
			put("未取得",1);
			put("高中",2);
			put("中专",3);
			put("大专", 4);
			put("本科", 5);
			put("硕士研究生", 6);
			put("博士研究生", 7);
			put("初中", 8);
		}
	};
	
	public static final Map<String,Integer> TEACHER_DIM_DEGREE = new HashMap<String,Integer>(){
		{
			put("学士",1);
			put("硕士",2);
			put("博士",3);
		}
	};
	
	/**
	 * 项目状态(2版)
	 */
	public static final Map<String, Integer> PROJECT_COMMON_STATUS = new HashMap<String, Integer>(){
		{
			put("待申报",10);// 新创建的项目触发
			put("未审批",20);// 申报后触发
//			put("审批通过",21);
			put("审批不通过",22);
//			put("筹备中",30);// 审批通过的项目点击[开始筹备项目]触发
			put("待启动",30);// 项目审核通过后触发
			put("进行中",40);// 项目启动触发
			put("已结束", 50);// 培训成绩发布, 公布成绩操作触发
			put("已关闭",60);// 项目关闭
		}
	};
	
	/**
	 * 学分借贷状态
	 */
	public static final Map<String, Integer> CREDIT_LEND_COMMON_STATUS = new HashMap<String, Integer>(){
		{
			put("未审批",0);
			put("审批通过",1);
			put("审批不通过",2);
			put("已偿还",3);
		}
	};
	
	/**
	 * 培训成绩公布规则
	 */
	public static final Map<String,Integer> SCORE_PUBLISH_RULE  = new HashMap<String,Integer>(){
		{
			put("直接公布分数",1);
			put("按是否合格公布",2);
			put("按四等级公布",3);
		}
	};
	/**
	 * 校本和非校本类项目（继教）
	 */
	public static final Map<String,Integer>  NOTRAIN_TYPE  = new HashMap<String,Integer>(){
		{
			put("校本培训项目",1);
			put("非培训类项目",2);
		}
	};
	
	/**
	 * 培训结果状态
	 */
	public static final Map<Integer,String>  TRAIN_STATUS  = new HashMap<Integer,String>(){
		{
			put(0, "不合格");
			put(1, "合格");
			put(2, "优秀");
			put(3, "良好");
		}
	};
	
	public static final Map<String, Integer> COMPARISON_STATUS = new HashMap<String, Integer>(){
		{
			put("未启动",0);// 
			put("已启动",1);// 
			put("关关闭",2);// 
		}
	};
	/**成绩合格*/
	public static final String SCORE_STATUS_PASS = "合格";
	/**成绩不合格*/
	public static final String SCORE_STATUS_NO_PASS = "不合格";
	
	/**前期暂定使用百分制 合格分数范围 60-100分,不合格分数为0-59*/
	public static final Integer SCORE_ZERO = 0;
	public static final Integer SCORE_PASS = 60;
	public static final Integer SCORE_TOP = 100;
		 
	/**
	 * 
	 * @author ben
	 * 学员查看成绩规则:
	 *	1.提交项目总结
	 * 	2.完成对承培机构评价
	 * 	3.完成项目调查与评估
	 *
	 */
	public enum VIEW_SCORE_RULE {
		
	    Rule_ONE("000"), //不限制学员查看成绩
	    Rule_TWO("001"),//1.提交总结
	    Rule_Three("010"),//2.提交评价
	    Rule_Four("011"),//完成2和3才能看成绩 
	    Rule_Five("100"),//3.提交调查问卷
	    Rule_Six("101"),//提交1和3
	    Rule_Seven("110"),//提交1和2
	    Rule_Eigth("111");//学员必须提交所有的三项才能查看成绩

	    /**
	     * @param text
	     */
	    private VIEW_SCORE_RULE(final String text) {
	        this.text = text;
	    }

	    private final String text;

	    /* (non-Javadoc)
	     * @see java.lang.Enum#toString()
	     */
	    @Override
	    public String toString() {
	        return text;
	    }
	} 
	
	static {
		initBeans();
		initByHand();
	}
	
	/**
	 * 初始化bean对象
	 */
	public static void initBeans(){
		sysService = (ISysService)SpringFactory.getObject("sysService");
	}
	
	/**
	 * 读取数据字典配置
	 */
	public static void initByHand() {
		Common.TEACHER_DIM_EDUCATION_BACKGROUND_DEAN = initMap("educational_user");
		Common.TEACHER_DIM_EDUCATION_POLITICAL_STATUS = initMap("political_status");
		Common.TEACHER_DIM_DEGREE_DEAN = initMap("academic_degree");
		Common.TEACHER_STAFF = initMap("teacher_staff");
		Common.TEACHER_QUALIFICATION_TYPE = initMap("teacher_seniority");
		Common.PROJECT_DIM_PROFESSIONAL_TITLE = initMap("teacher_professional");
		Common.AREA_TYPE = initMap("area_type");
		Common.SCHOOL_TYPE = initMap("school_type");
		Common.SCHOOL_ESTABLIST_TYPE = initMap("school_establish_type");
		Common.SCHOOL_NATURE = initMap("school_nature");
		Common.TEACHER_OFFICE_TYPE = initMap("office_type");
		
		Common.TEACHER_DIM_TGJS = initMap("tgjs_type");
			
		// 免费师范生
		Common.TEACHER_DIM_MFSFS = initMap("mfsfs_type");
			
		// 普通话等级
		Common.TEACHER_DIM_PTHDJ = initMap("pthdj_type");
			
		// 教师资格证种类
		Common.TEACHER_DIM_JSZGZ  = initMap("jszgz_type");
		
		// 合同签订情况
		Common.TEACHER_DIM_CONTRACT = initMap("contract_type");
		
		// 岗位类别
		Common.TEACHER_DIM_GWLB = initMap("gwlb_type");
		
		// 岗位等级
		Common.TEACHER_DIM_GWDJ = initMap("gwdj_type");
		
		Common.TEACHER_DIM_COUNTRY = initMap("country_type");
		
		Common.COMMENT_DIM_COUNTRY = initMap("comment_type");
		
		//名师培养对象
		Common.TEACHER_DIM_MSPYDX = initMap("mspydx_type");
		//教学名师
		Common.TEACHER_DIM_JXMS = initMap("jxms_type");
		//学科带头人
		Common.TEACHER_DIM_XKDTR = initMap("xkdtr_type");
		//是否骨干教师
		Common.TEACHER_DIM_GGJS = initMap("ggjs_type");
		
		
		Common.SYS_PLATFORM_SETUP = initSysPlatformSetup();
		
		sysCodeMap.clear();
		Field[] fields = Common.class.getDeclaredFields();
		for (Field field : fields) {
			try {
				sysCodeMap.put(field.getName(), field.get(new Common()));
			} catch (Exception e) {
				e.printStackTrace();
			}  
		}
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
	
	
	public static Map<String, Object> initSysPlatformSetup(){
		Map<String, Object> result = new HashMap<String, Object>();
		SysPlatformSetup pojo = new SysPlatformSetup(); 
		try {
			pojo = sysService.selectSysPlatformSetup();
			result.put("sysPlatformSetup", pojo);
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Common中 SysPlatformSetup 初始化异常");
		}
		return result;
	}
	
	
	public static String getDefaultCertifacte(){
		StringBuffer s = new StringBuffer();
		s.append("<p align='center'><span style='color:#E53333;font-size:32px;'>{projectName}</span></p>");
		s.append("<p align='center'><span style='color:#E53333;line-height:1;font-family:SimSun;font-size:80px;'><strong>结业证书</strong></span></p>");
		s.append("<p align='right'><span style='font-family:Microsoft YaHei;font-size:16px;'>项目编号：</span><u><span style='font-family:Microsoft YaHei;font-size:16px;'>$FJ$</span></u> </p>");
		s.append("<span><span style='font-size:24px;'><span style='font-size:32px;'> " +
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><u><span style='font-size:32px;'>" +
				"&nbsp;{name} </span></u><span style='font-size:32px;'>同志，" +
				"于</span><u><span style='font-size:32px;'> " +
				"2014年11月31日 </span></u><span style='font-size:32px;'>" +
				"至</span><u><span style='font-size:32px;'> 2014年12月31 </span></u>" +
				"<span style='font-size:32px;'>日，参加</span><u>" +
				"<span style='font-size:32px;'>" +
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{projectName}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp </span></u><span style='font-size:32px;'>" +
				"项目，完成教学计划</span><u> </u><span style='font-size:32px;'>" +
				"门课程，累计</span><u><span style='font-size:32px;'> {period} " +
				"</span></u><span style='font-size:32px;'>" +
				"学时，经考核合格，准予结业，特发此证。</span></span></span>");
		s.append("<p align='right'><span style='font-size:24px;'><br></span></p>");
		s.append("<p align='right'><span style='font-size:24px;'><br></span></p>");
		s.append("<p align='right'><span style='font-size:24px;'>福建省教育厅</span></p>");
		s.append("<p align='right'><span style='font-size:24px;'>二〇一四年十二月十一日</span></p>");
		return s.toString();
	}
	public static String getDefaultPeriodCertifacte(){
		StringBuffer s = new StringBuffer();
		/*s.append("<p align='center'><span style='color:#E53333;font-size:32px;'>{projectName}</span></p>");
		s.append("<p align='center'><span style='color:#E53333;line-height:1;font-family:KaiTi_GB2312;font-size:80px;'><strong>结业证书</strong></span></p>");
		s.append("<p align='right'><span style='font-family:Microsoft YaHei;font-size:16px;'>项目编号：</span><u><span style='font-family:Microsoft YaHei;font-size:16px;'>YN{code}</span></u> </p>");
		s.append("<span><span style='font-size:24px;'><span style='font-size:32px;'> " +
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><u><span style='font-size:32px;'>" +
				"&nbsp;{name} </span></u><span style='font-size:32px;'>同志，" +
				"于</span><u><span style='font-size:32px;'> " +
				"2014年11月31日 </span></u><span style='font-size:32px;'>" +
				"至</span><u><span style='font-size:32px;'> 2014年12月31 </span></u>" +
				"<span style='font-size:32px;'>日，参加</span><u>" +
				"<span style='font-size:32px;'>" +
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{projectName}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
				"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp </span></u><span style='font-size:32px;'>" +
				"项目，完成教学计划</span><u> </u><span style='font-size:32px;'>" +
				"门课程，累计</span><u><span style='font-size:32px;'> {period} " +
				"</span></u><span style='font-size:32px;'>" +
				"学时，经考核合格，准予结业，特发此证。</span></span></span>");
		s.append("<p align='right'><span style='font-size:24px;'><br></span></p>");
		s.append("<p align='right'><span style='font-size:24px;'><br></span></p>");
		s.append("<p align='right'><span style='font-size:24px;'>福建省教育厅</span></p>");
		s.append("<p align='right'><span style='font-size:24px;'>二〇一四年十二月十一日</span></p>");*/
		
		s.append("<p align='center'>"+
				"	<span style='color:black;font-size:32px;'> "+
				"	<table style='border-collapse:collapse;' class='my-table' height='436' border='1' bordercolor='#000000' cellpadding='0' cellspacing='0' width='334'>"+
				"		<tbody>"+
				"			<tr>"+
				"				<td colspan='3' width='334'>"+
				"					<p style='text-align:center;text-indent:27.6pt;' class='MsoNormal'>"+
				"						<b><span style='font-family:黑体;font-size:18pt;'>继续教育证明</span></b><b><span style='font-family:宋体;font-size:10pt;'>&nbsp;</span></b> "+
				"					</p>"+
				"					<p style='text-align:left;text-indent:27.6pt;' class='MsoNormal' align='center'>"+
				"						<b><span style='font-family:宋体;font-size:10pt;'><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></span></b><b><span style='font-family:宋体;font-size:10pt;'>编号：<span>&nbsp;<u>$FJ$</u>&nbsp; </span></span></b><span style='font-family:宋体;font-size:12pt;'></span> "+
				"					</p>"+
				"					<p style='text-align:left;text-indent:27.6pt;margin-left:10.5pt;' class='MsoNormal'>"+
				"						<b><span style='line-height:200%;font-family:宋体;font-size:11pt;'>&nbsp;<u>{name}</u> </span></b><span style='line-height:200%;font-family:宋体;font-size:12pt;'>老师于<span><u>2015</u></span><u>年3</u><span></span><u>月</u><span><u>27</u></span><u>日</u>至<span><u>2015</u></span><u>年</u><span><u>3</u></span><u>月</u><span><u>27</u></span><u>日</u>参加<span><u>{projectName}</u></span>，现已结业，经考核合格，特发此证。 </span> "+
				"					</p>"+
				"				</td>"+
				"			</tr>"+
				"			<tr>"+
				"				<td>"+
				/*"					<p style='text-align:center;margin-left:2.35pt;' class='MsoNormal' align='center'>"+*/
				"						<div style='line-height:150%;font-family:宋体;font-size:12pt;text-align:center;width:134px;'><strong>培训内容</strong></div>"+
				/*"					</p>"+*/
				"				</td>"+
				"				<td>"+
				/*"					<p style='text-align:center;margin-left:2.35pt;' class='MsoNormal' align='center'>"+*/
				"						<div style='line-height:150%;font-family:宋体;font-size:12pt;text-align:center;width:100px;'><strong>学时</strong></div>"+
				/*"					</p>"+*/
				"				</td>"+
				"				<td>"+
				/*"					<p style='text-align:center;margin-left:2.35pt;' class='MsoNormal' align='center'>"+*/
				"						<div style='line-height:150%;font-family:宋体;font-size:12pt;text-align:center;width:100px;'><strong>成绩</strong></div>"+
				/*"					</p>"+*/
				"				</td>"+
				"			</tr>"+
				"			<tr>"+
				"				<td>"+
				/*"					<p style='text-align:center;margin-left:2.35pt;' class='MsoNormal' align='center'>"+*/
				"						<div style='line-height:150%;font-family:宋体;font-size:10pt;text-align:center;width:134px;'>霞浦县教师继续教育信息管理系统</div>"+
				/*"						<span style='line-height:200%;font-family:宋体;font-size:10pt;'>信息管理系统</span> "+*/
				/*"					</p>"+*/
				"				</td>"+
				"				<td>"+
				/*"					<p style='text-align:center;margin-left:2.35pt;' class='MsoNormal' align='center'>"+*/
				"						<div style='line-height:150%;font-family:宋体;font-size:10pt;text-align:center;width:100px;'>{period}</div>"+
				/*"					</p>"+*/
				"				</td>"+
				"				<td>"+
				/*"					<p style='text-align:center;margin-left:2.35pt;' class='MsoNormal' align='center'>"+*/
				"						<div style='line-height:150%;font-family:宋体;font-size:10pt;text-align:center;width:100px;'>合格</div>"+
				/*"					</p>"+*/
				"				</td>"+
				"			</tr>"+
				"			<tr>"+
				"				<td colspan='3' width='334'>"+
				"					<p style='text-align:center;' class='MsoNormal' align='center'>"+
				"						<b><span style='font-family:宋体;color:black;font-size:12pt;'>签证单位：</span></b><span style='font-family:宋体;font-size:12pt;'> <span></span></span> "+
				"					</p>"+
				"					<p style='text-align:center;' class='MsoNormal' align='center'>"+
				"						<b><span style='font-family:宋体;color:black;font-size:12pt;'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></b><b><span style='font-family:宋体;color:black;font-size:12pt;'>（盖章）</span></b><span style='font-family:宋体;font-size:12pt;'> <span></span></span> "+
				"					</p>"+
				"					<p style='text-align:right;text-indent:67.45pt;' class='MsoNormal' align='right'>"+
				"						<b><span style='font-family:宋体;color:black;font-size:12pt;'>&nbsp;2015</span></b><b><span style='font-family:宋体;font-size:12pt;'>年0<span>3</span>月<span>28</span></span></b><b><span style='font-family:宋体;font-size:10pt;'>日</span></b><span style='font-family:宋体;font-size:12pt;'>&nbsp;&nbsp;&nbsp;</span><b><span style='font-family:宋体;font-size:10pt;'>&nbsp; </span></b><span style='font-family:宋体;font-size:12pt;'></span> "+
				"					</p>"+
				"				</td>"+
				"			</tr>"+
				"		</tbody>"+
				"	</table>"+
				"<span style='font-family:SimSun;color:#000000;font-size:12px;'>请及时粘贴在本人继续教育证书上，遗失不补。</span><span style='font-family:SimSun;color:#000000;font-size:10px;'></span><br />"+
				"</span> "+
				"</p>");
		
		return s.toString();
		
		
		
		
	}
	
	
	public static String getYearCertifacte(){
		StringBuffer s = new StringBuffer();
		s.append("<p align='center'>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          "
				+"	<span style='color:#E53333;line-height:1;font-family:SimSun;font-size:80px;'><strong><span style='font-size:32px;'></span><br />                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          "
				+"</strong></span>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            "
				+"</p>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "
				+"<p align='center'>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          "
				+"	<span style='color:#E53333;line-height:1;font-family:SimSun;font-size:80px;'><strong>结业证书</strong></span>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             "
				+"</p>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "
				+"<p align='right'>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           "
				+"	<br />                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    "
				+"</p>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "
				+"<p align='right'>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           "
				+"	<br />                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    "
				+"</p>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "
				+"<p align='right'>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           "
				+"	<span><span style='font-size:16px;line-height:24px;'>项目编码： $FJ$</span></span>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "
				+"</p>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "
				+"<p>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         "
				+"	<br />                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    "
				+"</p>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "
				+"<p>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         "
				+"	<span><span style='font-size:24px;'><span style='font-size:32px;'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><u><span style='font-size:32px;'>&nbsp;{name} </span></u><span style='font-size:32px;'>同志，于<u>{startDate}</u></span><span style='font-size:32px;'>至</span><u><span style='font-size:32px;'>{endDate}</span></u><span style='font-size:32px;'>，参加<u>{title}</u></span><span style='font-size:32px;'>，累积完成</span><u><span style='font-size:32px;'> {period} </span></u><span style='font-size:32px;'>学时，<u>{credit}</u>学分的教学计划任务{creditLend}，经考核合格，准予结业，特发此证。</span></span></span> "
				+"</p>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "
				+"<p align='right'>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           "
				+"	<span style='font-size:24px;'><br />                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      "
				+"</span>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     "
				+"</p>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "
				+"<p align='right'>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           "
				+"	<span style='font-size:24px;'><br />                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      "
				+"</span>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     "
				+"</p>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "
				+"<p align='right'>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           "
				+"	<span style='font-size:24px;'>洮北区教育厅</span>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         "
				+"</p>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        "
				+"<p align='right'>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           "
				+"	<span style='font-size:24px;'>二〇一七年十二月十一日</span>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               "
				+"</p>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        ");
		
		return s.toString();
		
		
		
		
	}
}
