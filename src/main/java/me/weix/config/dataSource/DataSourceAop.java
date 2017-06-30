package me.weix.config.dataSource;

import me.weix.config.common.CONST;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.Before;

/**
 * Created by wxper on 2017/6/25.
 */
public class DataSourceAop {

    private static Log log = LogFactory.getLog(DataSourceAop.class);

    @Before("execution(* me.weix.whatever.service.*.dao..*.find*(..)) or execution(* com.ggj.encrypt.modules.*.dao..*.get*(..))")
    public void setReadDataSourceType() {
        DataSourceContextHolder.setDataSource(CONST.DATASOURCETYPE.READ);
        log.info("dataSource切换到：Read");
    }

    @Before("execution(* com.ggj.encrypt.modules.*.dao..*.insert*(..)) or execution(* com.ggj.encrypt.modules.*.dao..*.update*(..))")
    public void setWriteDataSourceType() {
        DataSourceContextHolder.setDataSource(CONST.DATASOURCETYPE.WRITE);
        log.info("dataSource切换到：write");
    }
}
