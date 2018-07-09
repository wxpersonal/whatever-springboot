package me.weix.whatever.config.dataSource;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.keygen.SelectKeyGenerator;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by IDEA
 * User: mashaohua
 * Date: 2016-08-10 11:09
 * Desc:
 */
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {
                MappedStatement.class, Object.class }),
        @Signature(type = Executor.class, method = "query", args = {
                MappedStatement.class, Object.class, RowBounds.class,
                ResultHandler.class }) })
public class DynamicDataSourcePlugin implements Interceptor {

    protected static final Logger logger = LoggerFactory.getLogger(DynamicDataSourcePlugin.class);

    private static final String REGEX = ".*insert\\u0020.*|.*delete\\u0020.*|.*update\\u0020.*";

    private static final Map<String, String> cacheMap = new ConcurrentHashMap<>();

    private static AtomicInteger count = new AtomicInteger(0);

    /**
     * 取读库个数
     */
    @Value("jdbc.readSize")
    private static int READ_DATASOURCE_SIZE;


    @Override
    public Object intercept(Invocation invocation) throws Throwable {

        boolean synchronizationActive = TransactionSynchronizationManager.isSynchronizationActive();
        if(!synchronizationActive) {
            Object[] objects = invocation.getArgs();
            MappedStatement ms = (MappedStatement) objects[0];

            String dataSourceName;
            if((dataSourceName = cacheMap.get(ms.getId())) == null) {
                //读方法
                if(ms.getSqlCommandType().equals(SqlCommandType.SELECT)) {
                    //!selectKey 为自增id查询主键(SELECT LAST_INSERT_ID() )方法，使用主库
                    if(ms.getId().contains(SelectKeyGenerator.SELECT_KEY_SUFFIX)) {
                        dataSourceName = DataSourceType.master.getName();
                    } else {
                        BoundSql boundSql = ms.getSqlSource().getBoundSql(objects[1]);
                        String sql = boundSql.getSql().toLowerCase(Locale.CHINA).replaceAll("[\\t\\n\\r]", " ");
                        if(sql.matches(REGEX)) {
                            dataSourceName = DataSourceType.master.getName();
                        } else {
                            /**
                             * 轮询读库
                             */
                            int i = count.getAndAdd(1) % READ_DATASOURCE_SIZE;
                            if(count.get() > 10000) {
                                count.set(0);
                            }
                            dataSourceName = DataSourceType.slave.getName() + i;
                        }
                    }
                }else{
                    dataSourceName = DataSourceType.master.getName();
                }

                logger.warn("设置方法[{}] use [{}] Strategy, SqlCommandType [{}]..", ms.getId(), dataSourceName, ms.getSqlCommandType().name());
                cacheMap.put(ms.getId(), dataSourceName);
            }
            DataSourceContextHolder.setDataSource(dataSourceName);
        }

        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof Executor) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {
        //
    }
}
