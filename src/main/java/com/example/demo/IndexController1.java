package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 胡文华 on 2019/7/18.
 */
@RestController
public class IndexController1 {
    @RequestMapping("/hello")
    public String index1() {
        return "huwenhua";
    }
}
