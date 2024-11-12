package com.sakib.spring_ci_cd_docker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @GetMapping("devops")
    public String get(){
        return "Welcome to Spring boot and devOps Tutorial";
    }
}
