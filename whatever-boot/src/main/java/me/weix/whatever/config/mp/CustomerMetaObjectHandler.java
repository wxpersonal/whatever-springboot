package me.weix.whatever.config.mp;


import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.Data;
import lombok.Getter;
import me.weix.whatever.common.model.UserInfo;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author : weixiang
 * create at:  2019-05-17
 * @description: 字段填充器
 */
@Component
public class CustomerMetaObjectHandler implements MetaObjectHandler {

    /**
     * 公共字段
     */
    private static final String DELETED    = "deleted";
    private static final String STATUS     = "status";
    private static final String CREATEBY   = "createBy";
    private static final String CREATETIME = "createTime";
    private static final String UPDATEBY   = "updateBy";
    private static final String UPDATETIME = "updateTime";

    @Override
    public void insertFill(MetaObject metaObject) {
        Object delFlag = getFieldValByName(DELETED, metaObject);
        // 删除标识 默认 0
        if (delFlag == null) {
            setFieldValByName(DELETED, 0, metaObject);
        }

        Object status = getFieldValByName(STATUS, metaObject);
        // 状态标识 默认 1 有效
        if (status == null) {
            setFieldValByName(STATUS, 1, metaObject);
        }
        // 创建时间 默认当前时间
        Object createTime = getFieldValByName(CREATETIME, metaObject);
        if (createTime == null) {
            setFieldValByName(CREATETIME, new Date(), metaObject);
        }
        // 创建人 当前登录人
        fillDefaultUser(metaObject, CREATEBY);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName(UPDATETIME, new Date(), metaObject);
        fillDefaultUser(metaObject, UPDATEBY);
    }

    private void fillDefaultUser(MetaObject metaObject, String updateby) {
        Object updateUser = getFieldValByName(updateby, metaObject);
        if (updateUser == null) {
            UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getSession().getAttribute("userInfo");
            setFieldValByName(updateby, userInfo.getUser().getId(), metaObject);
        }
    }

}
