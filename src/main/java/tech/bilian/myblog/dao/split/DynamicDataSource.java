package tech.bilian.myblog.dao.split;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource{
    @Override
    protected Object determineCurrentLookupKey() {
        String result = DynamicDatasourceHolder.getDbType();
        if (result == null){
            return "master";
        }
        DynamicDatasourceHolder.clearDbType();
        return result;
    }
}
