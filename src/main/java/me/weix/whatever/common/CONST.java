package me.weix.whatever.common;

/**
 * Created by Administrator on 2017/6/21.
 * 系统常亮
 */
public interface CONST {

    /**
     * 登录类型
     */
    interface LOGINTYPE {
        Integer EMAIN = 1;
        Integer MOBILE = 2;
    }

    /**
     * 系统通用状态
     * 0：无效，否……
     * 1：有效，是……
     */
    interface SYSTEMSTATUS {
        int NO = 0;
        int YES = 1;
    }

}
