福建教师信息系统外网更新部署文档

1.数据库脚本更新
	执行sql文件夹中脚本，直接执行。
	
	
2.war包更新
	education.war

不要覆盖以下两个文件:
    \WEB-INF\classes\config\edu\edu.properties
    \WEB-INF\classes\config\spring\ibatisConfig.xml