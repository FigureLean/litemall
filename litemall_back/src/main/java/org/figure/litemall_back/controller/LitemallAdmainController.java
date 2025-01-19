package org.figure.litemall_back.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import jakarta.annotation.Resource;
import org.figure.litemall_back.service.LitemallAdmainService;
import org.figure.litemall_back.utils.ResponseUtil;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/admin")
public class LitemallAdmainController {

    @Resource
    LitemallAdmainService litemallAdmainService;
    

    //测试接口
    @PostMapping("/login")
    public Object doLoginTest(@RequestParam String username) {
        if (username.equals("admin123")){
            StpUtil.login(username);
            SaTokenInfo saTokenInfo = StpUtil.getTokenInfo();
            return ResponseUtil.ok(saTokenInfo);
        }
        return ResponseUtil.badArgument();
    }


}
