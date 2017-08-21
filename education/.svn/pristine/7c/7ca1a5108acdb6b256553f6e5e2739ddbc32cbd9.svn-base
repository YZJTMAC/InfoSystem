package framelib.common;

import javax.jms.Queue;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.jms.core.JmsTemplate;

import framelib.utils.mail.MailSenderInfo;

/**
 * Title:Common Description:静态变量列表
 * 
 * @Create_by:Vince Yu
 * @Create_date:2012-5-5
 * @Last_Edit_By:
 * @Edit_Description
 * @version:178xf 1.0
 * 
 */
public class Common {
	// 全局静态配置
	public static BeanFactory factory;
	// 全局邮件配置
	public static MailSenderInfo EMAIL_SENDER_INFO;
	// 全局jmsTemplate
	public static JmsTemplate jmsTemplate;
	// 统一日志管理Queue
	public static Queue ptLogQueue;
	// session中前一页面URL存放地址
	public final static String REFERER_URL = "refererUrl";
	// 最大图片大小，单位为M
	public final static double PNN_IMAGE_MAX_SIZE = 5;
	// 用户头像上传配置KEY
	public final static String PNN_USER_AVATAR_CONFIG_KEY = "userAvatarUploadPath";
	// 用户头像上传配置KEY
	public final static String PNN_USER_AVATAR_SAVE_LARGE_CONFIG_KEY = "userAvatarSavePathLarge";
	// 用户头像上传配置KEY
	public final static String PNN_USER_AVATAR_SAVE_MID_CONFIG_KEY = "userAvatarSavePathMid";
	// 用户头像上传配置KEY
	public final static String PNN_USER_AVATAR_SAVE_SMALL_CONFIG_KEY = "userAvatarSavePathSmall";
	// 每页记录数
	public final static int PNN_USER_PAGE_LIMIT = 20;

	// 用户积分-用户登录
	public final static String USER_INTEGRAL_LOGIN = "login";

	// 后台用户登录session KEY
	public final static String USER_SESSION = "userinfo";

	/***** 验证码 ******/
	public final static String VALIDATE_CODE_KEY = "_validateCode";

	// 验证码类型--登录
	public static final String VALIDATE_CODE_TYPE_LOGIN = "login";

	/*************************** 用户登录返回状态标志 ***************************************/
	// 验证码为空
	public final static String VERYCODE_IS_NULL = "1";
	// 验证码错误
	public final static String VERYCODE_IS_ERROR = "login.return_2";
	// 系统异常
	public final static String SYSTEM_ERROR = "500";
	// 客户不存在
	public final static String CUSTOMER_IS_NULL = "login.return_3";
	// 密码错误
	public final static String PASSWORD_IS_ERROR = "login.return_4";
	// 邮箱未激活
	public final static String EMAIL_IS_NO_ACTIVITY = "5";
	// 账号未审核
	public final static String CUSTOMER_IS_NO_VERIFY = "login.return_6";
	// 账号被冻结
	public final static String CUSTOMER_IS_FORZEN = "login.return_7";
	// 后台添加用户并且是第一次登录系统，需要重置密码
	public final static String CUSTOMER_IS_FIRST_LOGIN = "8";
	// 企业用户,并且未完善信息
	public final static String CUSTOMER_UN_COMPLATE = "10";
	// 按照登录名,密码找到了用户
	public final static String CUSTOMER_IS_EXISTS = "9";
	// 登录成功
	public final static String LOGIN_SUCCESS = "0";

	// 登陆成功后的返回页面
	public final static String LOGIN_RETURN_URL = "returnUrl";
	// 在缓存中储存返回url的过期时间 单位：秒
	public final static int RETURN_URL_EXP = 10 * 60;

	// 0：邮箱已激活，1：邮箱未激活
	public final static int EMAIL_IS_ENABLE = 0;
	public final static int EMAIL_IS_NOT_ENABLE = 1;
	// 1:主客户,2:子客户
	public final static int MAIN_CUSTOMER = 1;
	public final static int CUSTOMER_CHILD = 2;

	// 非树节点类型
	public final static int IS_NOT_TREE_NODE = 5;
	// 状态成功标志
	public final static String SUCCESS_FLAG = "0"; // 成功
	public final static String ERROR_FLAG = "1"; // 失败

	/** 返回成功状态 */
	public final static int INT_SUCCESS_FLAG = 1; // 成功
	/** 返回失败状态 */
	public final static int INT_ERROR_FLAG = 0; // 失败

	public final static int GET_CUSTOMER_DEFAULT_PAGESIZE = 10; // 用户默认当前每页行数
	public final static int GET_CUSTOMER_DEFAULT_PAGENUM = 1; // 用户默认当前页数

	// 角色不能为空
	public final static String ROLE_NOT_NULL = "roleNotNull";

	public final static int DELETE_FLAG_ZERO = 0;// 有效

	public final static int DELETE_FLAG_ONE = 1; // 无效

	public final static String DEPARTMENTS_SEARCH = "departmentsSearch";// 机构搜索失败

	public final static String DELETE_DEPT_ERROR = "deleteDeptError";// 删除机构失败，被子机构或者用户所依赖

	public final static String SEARCH_PID_BY_ID = "searchPidById";// 根据ID查找父ID失败

	public final static boolean SYSTEM_TRUE = true;// true

	public final static boolean SYSTEM_FALSE = false; // false

	public final static String SYSTEM_TRUE_STRING = "true"; // 字符串true

	public final static String SYSTEM_FALSE_STRING = "false"; // 字符串false

	public final static String CHARACTER_UTF_8 = "UTF-8"; // UTF-8字符编码

	public final static String CONTENT_TYPE_HTML = "text/html; charset=UTF-8"; // HTML内容类型

	public final static int REDIS_DATA_NUM = 100000;// 每10万个企业ID占用一台redis服务

	public final static int REDIS_LIST_SIZE = 100;// redis中每个key对应的集合总数为100

	// 统一日志MQ标示
	public final static String PTLOG_QUEUE_NAME = "ptLogQueue";
	// 统一日志生成目录
	public final static String LOG_FILEPATH = "d:/ptLog/";
	// 日志达到多少条再写入文件
	public final static int SAVE_LOG_LEN = 10;
	// 头像上传路径在项目目录下upload文件夹内
	public final static String FILE_UPLOAD_PATH = "upload/";
	public final static String DETAIL_HREF = "/businessInfo.htm?businessId=";

	public final static String FOWARD_HREF = "/foword.htm";

	public final static int BUSINESS_ENABLED = 4; // 企业状态为4是已经被关注的企业

	public final static int LISTINFO_SIZE_NULL = 0;// 获得的企业信息LIST为空

	public final static int BUSINESS_MOVEINFO_PAGESIZE = 4;// 企业动态信息页面大小

	public final static String BUSINESS_INFO_PAGEROWS = "10"; // 企业信息页面显示行数

	public final static String BUSINESS_INFO_PAGENUM = "1"; // 企业信息页数

	public final static String PAY_NORMAL_ORDER_RETURN_URL = "http://127.0.0.1:8080/178xf/payment/paymentReturn.htm"; // 普通订单回调页面

	public final static String PAY_RESOURCE_PREFIX = "config/resources/pay/"; // 支付接口资源文件前缀

	public final static String PAY_RESOURCE_SUFFIX = ".properties"; // 资源文件后缀

	/*--------------支付方式------------------*/
	public final static String PAY_WAY_99BILL = "99bill"; // 快钱
	public final static String PAY_WAY_YEEPAY = "yeepay"; // 易宝支付
	public final static String PAY_WAY_ALIPAY = "alipay"; // 支付宝
	public final static String PAY_WAY_TENPAY = "tenpay"; // 财付通
	public final static String PAY_WAY_SHENGPAY = "shengpay"; // 盛付通
	public final static String PAY_WAY_BAIFUBAO = "baifubao"; // 百付通
	public final static String PAY_WAY_LAKALA = "lakala"; // 拉卡拉
	public final static String PAY_WAY_PAYPAL = "paypal"; // paypal

	public final static String IS_HANDLE = "1"; // 是否进行过业务逻辑处理

	public final static String SYS_HOMEPAGE = "index";// 系统主页
	public final static String SYS_ERRPAGE = "error/servererror"; // 系统错误页
	public final static String SYS_ERROR_KEY = "errorMsg";// 错误页的错误信息的key

	public final static String PAGE_404 = "errors/404";

	/**
	 * web应用的访问根目录
	 */
	public final static String WEB_ROOT_PATH = "http://localhost:8080/baoogu/";

	public final static String SYMBOL_DOT = ".";// 点

	public final static int IMAGE_SIZE_MAX = 1024 * 1024;// 上传图片大小限制为1M
	/* 图片的类型 */
	public final static String IMAGE_TYPE_JPG = "jpg";//

	public final static String IMAGE_TYPE_PNG = "png";//

	public final static String IMAGE_TYPE_GIF = "gif";//

	public final static String IMAGE_TYPE_BMP = "bmp";//

	/* 返回json数据时的状态标志 */
	public final static String JSON_STATE_SUCCESS = "1";// 表示成功

	public final static String JSON_STATE_FAILURE = "0";// 表示失败

	/** 店铺流程 **/
	public static final String PROCESS_TYPE_SHOP = "5";
	/** 合同流程 **/
	public static final String PROCESS_TYPE_CONTRACT = "1";

	public static final String SYMBOL_UNDERLINE = "_";

	public static final String WORD_UNIT_NATION = "nation";// 国家 0
	public static final String WORD_UNIT_REGION = "region";// 大区 1
	public static final String WORD_UNIT_PROVINCE = "province";// 省,洲,直辖市 2
	public static final String WORD_UNIT_CITY = "city";// 市 3
	public static final String WORD_UNIT_AREA = "area";// 区,县 4
	public static final String WORD_UNIT_TOWN = "town";// 乡镇 5
	public static final String WORD_UNIT_VILLAGE = "village";// 村
	public static final String WORD_UNIT_SHOP = "shop_";// redis店铺key前缀


	public static final String REDIS_HASH_DICT = "dict";// redis中用于存放城市，分行，词典数据的hash的key

	public static final String SYMBOL_COMMA = ","; // 逗号
	public final static String SYSBOL_COLON = ":";// 冒号

	public final static String SYSBOL_REDUCE = "-";// -

	public final static String SYSBOL_SLASH = "/";// slash/



	public final static String PROMPT_ERROR_MESSAGE = "网络连接异常,请稍后再试!"; // 提示异常信息

	/* 产品详情访问路径 */
	public static final String PRODUCT_DETAIL_VISIT_SUFFIX = "/detail/details/item.htm?spm=";

	
}
