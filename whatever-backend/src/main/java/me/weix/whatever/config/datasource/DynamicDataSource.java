package me.weix.whatever.config.datasource;

import com.google.common.base.Strings;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by wxper on 2017/6/25.
 */

public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        String dataSource = DataSourceContextHolder.getDataSource();
        if(Strings.isNullOrEmpty(dataSource)) {
            DataSourceContextHolder.setDataSource(DataSourceType.master.getName());
        }
        return DataSourceContextHolder.getDataSource();
    }
}
