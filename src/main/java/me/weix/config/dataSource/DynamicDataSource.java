package me.weix.config.dataSource;

import me.weix.config.common.CONST;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by wxper on 2017/6/25.
 */

public class DynamicDataSource extends AbstractRoutingDataSource {

    private static Log log = LogFactory.getLog(DynamicDataSource.class);
    private AtomicInteger count = new AtomicInteger(0);

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDataSource();
    }
}
