package com.itheima.reggie;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.jws.WebService;

@Slf4j
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})  //exclude = {DataSourceAutoConfiguration.class}  proxyTargetClass = true
@ServletComponentScan
@EnableTransactionManagement(proxyTargetClass = true)
@EnableCaching
public class ReggieApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReggieApplication.class);
        log.info("项目启动成功...");
    }






}
