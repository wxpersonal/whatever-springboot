package me.weix.whatever.config.dataSource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by wxper on 2017/6/25.
 */

public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        String dataSource = DataSourceContextHolder.getDataSource();
        if(StringUtils.isEmpty(dataSource)) {
            DataSourceContextHolder.setDataSource(DataSourceType.master.getName());
        }
        return DataSourceContextHolder.getDataSource();
    }
}
