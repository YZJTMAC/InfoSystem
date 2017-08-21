package framelib.dao;

import org.springframework.data.mongodb.core.MongoTemplate;

/**
 *Title:MongoBaseDAO
 *Description:mongo集成spring持久化数据的基类
 *@Create_by:songxianjia
 *@Create_date:2013-10-28
 *@Last_Edit_By:
 *@Edit_Description
 *@version:baoogu 1.0
 */

public class MongoBaseDAO {
    private MongoTemplate template;
    
    public void setTemplate(MongoTemplate template) {
        this.template = template;
    }
    
    public MongoTemplate getTemplate() {
        return template;
    }
    
}
