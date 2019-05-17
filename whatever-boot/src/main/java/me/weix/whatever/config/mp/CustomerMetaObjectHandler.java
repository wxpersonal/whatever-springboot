package me.weix.whatever.config.mp;


import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author : weixiang
 * create at:  2019-05-17
 * @description: 字段填充器
 */
@Component
public class CustomerMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        Object delFlag = getFieldValByName(getDeleteFlagFieldName(), metaObject);
        if (delFlag == null) {
            setFieldValByName(getDeleteFlagFieldName(), getDefaultDelFlagValue(), metaObject);
        }

        Object createTime = getFieldValByName(getCreateTimeFieldName(), metaObject);
        if (createTime == null) {
            setFieldValByName(getCreateTimeFieldName(), new Date(), metaObject);
        }

        Object createUser = getFieldValByName(getCreateUserFieldName(), metaObject);
        if (createUser == null) {
            // todo 获取当前登录用户
            Object accountId = getUserUniqueId();
            setFieldValByName(getCreateUserFieldName(), accountId, metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        setFieldValByName(getUpdateTimeFieldName(), new Date(), metaObject);

        Object updateUser = getFieldValByName(getUpdateUserFieldName(), metaObject);
        if (updateUser == null) {

            // todo 获取当前登录用户
            Object accountId = getUserUniqueId();
            setFieldValByName(getUpdateUserFieldName(), accountId, metaObject);
        }
    }

    /**
     * 获取逻辑删除字段的名称（非数据库中字段名称）
     */
    protected String getDeleteFlagFieldName() {
        return "deleted";
    }

    /**
     * 获取逻辑删除字段的默认值
     */
    protected Object getDefaultDelFlagValue() {
        return "0";
    }

    /**
     * 获取创建时间字段的名称（非数据库中字段名称）
     */
    protected String getCreateTimeFieldName() {
        return "createTime";
    }

    /**
     * 获取创建用户字段的名称（非数据库中字段名称）
     */
    protected String getCreateUserFieldName() {
        return "createBy";
    }

    /**
     * 获取更新时间字段的名称（非数据库中字段名称）
     */
    protected String getUpdateTimeFieldName() {
        return "updateTime";
    }

    /**
     * 获取更新用户字段的名称（非数据库中字段名称）
     */
    protected String getUpdateUserFieldName() {
        return "updateBy";
    }

    /**
     * 获取用户唯一id（注意默认获取的用户唯一id为空，如果想填写则需要继承本类）
     */
    protected Object getUserUniqueId() {
        return "";
    }
}
