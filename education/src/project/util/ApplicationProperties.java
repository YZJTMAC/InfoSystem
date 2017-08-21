package project.util;

import java.util.Properties;

import org.apache.commons.lang.StringUtils;

/**
 * @author  
 * 
 */
public final class ApplicationProperties {
	private static final String resourceName = "/config/edu/edu.properties";
	private static Properties property = new Properties();
	
	static {
		ApplicationProperties.init();
	}
	
	/**
	 * 初始化
	 */
	public static void init() {
		ApplicationProperties.setProperty(PropertiesLoaderUtils.loadUrlProperties(resourceName));
	}

	/**
	 * @return Properties
	 */
	public static Properties getProperty() {
		//System.out.println(property.isEmpty());
		if (property == null || property.isEmpty() || property.size() == 0) {
			ApplicationProperties.init();
		}
		return property;
	}

	public static void setProperty(Properties property) {
		ApplicationProperties.property = property;
	}

	/**
	 * 获取属性值
	 * @param key
	 * @return String
	 */
	public static String getPropertyValue(String key) {
		if (StringUtils.isEmpty(key)) {
			return "";
		}
		return (String) ApplicationProperties.getProperty().get(key);
	}
	
	public static void main(String[] args) {
		System.out.print(getPropertyValue("dengguo"));
	}
}