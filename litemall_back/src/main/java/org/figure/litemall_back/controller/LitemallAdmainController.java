package org.figure.litemall_back.controller;

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
@RequestMapping("/admain")
public class LitemallAdmainController {

    @Resource
    LitemallAdmainService litemallAdmainService;


    //test
    @PostMapping("/login")
    public Object findAll(@RequestParam String username,@RequestParam String password){
        if (username.equals("admin") && password.equals("123456")){
            return ResponseUtil.ok();
        }
        return ResponseUtil.fail();
    }
}
