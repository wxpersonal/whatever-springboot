package me.weix.whatever.schedule.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2017/6/26.
 */
public class TestTask {

    /** 日志对象 */
    private Logger log = LoggerFactory.getLogger(TestTask.class);

    public void run() {

        if (log.isInfoEnabled()) {
            log.debug("--------------------test task-------------------");
        }
    }
}
