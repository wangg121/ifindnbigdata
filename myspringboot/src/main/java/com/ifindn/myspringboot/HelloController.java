package com.ifindn.myspringboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Guo Yan
 * @date 2020/5/9-10:17
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello, this is a springboot project";
    }
}
