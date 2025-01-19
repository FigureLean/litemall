package org.figure.litemall_back.service;

import org.figure.litemall_back.mapper.LitemallAdmainMapper;
import org.figure.litemall_back.po.LitemallAdmain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LitemallAdmainService {

    @Autowired
    LitemallAdmainMapper litemallAdmainMapper ;


    //根据传入的用户名查找对应的用户
    public LitemallAdmain findLitemallAdmainByUsername(String username) {
        LitemallAdmain litemallAdmain = litemallAdmainMapper.selectByUsername(username);
        return litemallAdmain;
    }
}
