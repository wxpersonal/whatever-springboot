package me.weix.whatever.config.dataSource;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

public class DynamicDataSourceTransactionManager extends DataSourceTransactionManager {


    public DynamicDataSourceTransactionManager(DataSource dataSource) {
        super(dataSource);
    }
    /**
     * 清理本地线程的数据源
     * @param transaction
     */
    @Override
    protected void doCleanupAfterCompletion(Object transaction) {
        super.doCleanupAfterCompletion(transaction);
        DataSourceContextHolder.clearDataSource();
    }

}
