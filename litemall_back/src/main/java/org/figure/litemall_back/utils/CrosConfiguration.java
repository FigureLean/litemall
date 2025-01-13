package org.figure.litemall_back.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 功能：解决跨域问题
 * 作者：Figure
 * 日期：2023/10/26 20:35
 */
@Slf4j          //日志打印
@Configuration
public class CrosConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry){
//        log.info("跨域问题配置类设置成功...");
        registry.addMapping("/**")	//配置可以被跨域的路径，可以任意配置，可以具体到直接请求路径
                //允许所有的请求域名访问我们的跨域资源，可以固定单条或者多条内容
                .allowedOriginPatterns("*")
                //允许所有的请求方法访问该跨域资源服务器
                .allowedMethods("GET","HEAD","POST","PUT","DELETE","OPTIONS")
                //用于告知浏览器当withCredentials属性设置为true时，是否可以显示跨域请求返回的内容
                .allowCredentials(true)
                //资源过期时间
                .maxAge(3600)
                .allowedHeaders("*");
    }
}

