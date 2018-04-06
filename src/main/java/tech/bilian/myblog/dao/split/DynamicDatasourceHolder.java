package tech.bilian.myblog.dao.split;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DynamicDatasourceHolder {
    private static Logger logger = LoggerFactory.getLogger(DynamicDatasourceHolder.class);

    private static ThreadLocal<String> contextHolder = new ThreadLocal<>();

    public static final String DB_MASTER = "master";

    public static final String DB_SLAVE = "slave";

    public static String getDbType(){
        String db = contextHolder.get();
        if(db == null){
            db = "master";
        }
        return db;
    }

    /**
     * 设置线程的DbType
     *
     * @param str
     */
    public static void setDbType(String str){
        logger.debug("所使用的数据源：" + str);
        contextHolder.set(str);
    }

    /**
     * 清理连接类型
     *
     */
    public static void clearDbType(){
        contextHolder.remove();
    }
}
