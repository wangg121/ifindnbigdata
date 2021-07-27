package com.ifindn.boot.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ParamController {

    @GetMapping("/order/{pathId}/param")
    public Map<String,Object> param(@RequestParam("username") String name,
                                    @PathVariable("pathId")String path,
                                    @RequestHeader("headers") Map header,
                                    @RequestHeader("user-agent") String token,
                                    @CookieValue("Cookie_1") String cookie){

        Map<String,Object> map = new HashMap<>();

        map.put("username",name);
        map.put("pathId",path);
//        map.put("headers",header);
        map.put("token",token);
        map.put("cookie",cookie);

        return map;
    }
}
