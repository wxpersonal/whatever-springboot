package me.weix.whatever.service.impl;

import me.weix.whatever.service.IBaseService;
import me.weix.whatever.common.util.ReflectUtil;
import me.weix.whatever.common.util.SpringContextUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;
import java.util.List;

/**
 * mapper:mapper
 * pojo:pojo
 */
public abstract class BaseServiceImpl<mapper, pojo> implements IBaseService<pojo> {

    private mapper mapper;

    private Logger log = LoggerFactory.getLogger(BaseServiceImpl.class);

    /**
     * 将在spring启动完成后统一调用
     */
    @Override
    public void initMapper() {
        this.mapper = SpringContextUtil.getBean(getMapperClass());
    }

    @Override
    public Integer insert(pojo pojo) {
        try {
            log.debug("====================>>>添加"+getPojoClass());
            Method insertSelective = mapper.getClass().getDeclaredMethod("insertSelective", pojo.getClass());
            Object result = insertSelective.invoke(mapper, pojo);
            return Integer.parseInt(String.valueOf(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public pojo getById(Integer id) {
        try {
            Method selectByPrimaryKey = mapper.getClass().getDeclaredMethod("selectByPrimaryKey",id.getClass());
            Object result = selectByPrimaryKey.invoke(mapper, id);
            log.debug("====================>>>根据id查询"+getPojoClass() );
            return (pojo) result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer update(pojo pojo) {
        try {
            log.debug("====================>>>更新"+getPojoClass() );
            Method selectByPrimaryKey = mapper.getClass().getDeclaredMethod("updateByPrimaryKeySelective",pojo.getClass());
            Object result = selectByPrimaryKey.invoke(mapper, pojo);
            return Integer.parseInt(String.valueOf(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    @Transactional
    public Integer delete(String ids) {
        try {
            log.debug("====================>>>删除"+getPojoClass() );
            Integer count = 0;
            Method deleteByPrimaryKey = mapper.getClass().getDeclaredMethod("deleteByPrimaryKey",ids.getClass());
            String[] idArr = StringUtils.split(ids, ",");
            for(String id : idArr) {
                Object result = deleteByPrimaryKey.invoke(mapper, Integer.parseInt(id));
                count += Integer.parseInt(String.valueOf(result));
            }
            return count;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<pojo> list() {
        return null;
    }

    /**
     * 获取类泛型class
     * getGenericSupperclass() 获取带有泛型的父类
     */
    @SuppressWarnings("unchecked")
    private Class<mapper> getMapperClass(){
        return (Class<mapper>) ReflectUtil.getClassGenricType(getClass(), 0);
    }

    @SuppressWarnings("unchecked")
    private Class<pojo> getPojoClass(){
        return (Class<pojo>) ReflectUtil.getClassGenricType(getClass(), 1);
    }

}
