package me.weix.whatever.mapper;

import me.weix.whatever.pojo.SysFile;

public interface SysFileMapper {
    int deleteByPrimaryKey(String code);

    int insert(SysFile record);

    int insertSelective(SysFile record);

    SysFile selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(SysFile record);

    int updateByPrimaryKey(SysFile record);
}