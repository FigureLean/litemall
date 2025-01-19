package org.figure.litemall_back;

import cn.dev33.satoken.SaManager;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LitemallBackApplication {

    public static void main(String[] args) throws JsonProcessingException {
        SpringApplication.run(LitemallBackApplication.class, args);
        System.out.println("启动成功：sa-token配置如下：" + SaManager.getConfig());
    }

}
