package com.hankun.satokenlearn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author hankun
 * @Description TODO
 * @Date 2021/6/4
 * @Version 1.0
 */
@RestController
public class CommonController {

    @GetMapping("/active")
    public String activeTest(){
        return "ok";
    }

}
