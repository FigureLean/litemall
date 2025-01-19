package org.figure.litemall_back.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.figure.litemall_back.po.LitemallAdmain;

@Mapper
public interface LitemallAdmainMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LitemallAdmain record);

    LitemallAdmain selectByPrimaryKey(Integer id);

    List<LitemallAdmain> selectAll();

    int updateByPrimaryKey(LitemallAdmain record);

    LitemallAdmain selectByUsername(String username);
}