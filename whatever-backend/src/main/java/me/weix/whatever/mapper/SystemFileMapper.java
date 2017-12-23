package me.weix.whatever.mapper;

import me.weix.whatever.pojo.SystemFile;

public interface SystemFileMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemFile record);

    int insertSelective(SystemFile record);

    SystemFile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemFile record);

    int updateByPrimaryKey(SystemFile record);
}