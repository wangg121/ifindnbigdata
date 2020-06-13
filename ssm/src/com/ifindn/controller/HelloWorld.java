package com.ifindn.controller;

import com.ifindn.controller.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * @author Guo Yan
 * @date 2020/6/3-17:27
 */

@Controller
@RequestMapping("/mvc")
public class HelloWorld {

    private static final String SUCCESS = "success";




    @RequestMapping("/testRedirect")
    public String testRedirect(){
        return "forward:/index";
    }

    @ModelAttribute
    public void getUser(@RequestParam(value = "flag",required = false) Integer id,Map<String,Object> map){
        System.out.println(id);
        if(id != null){
            User user = new User("zhangsan", "zhangsan2163.com", 12, "123");
            map.put("abc",user);
        }
    }

    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("mx") User user){
        System.out.println(user);
        return SUCCESS;
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map){
        System.out.println("-------------------------");
        System.out.println(map.getClass().getName());
        map.put("name", Arrays.asList("tom","jerry","mike"));
        return SUCCESS;
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView modelAndView = new ModelAndView(SUCCESS);
        modelAndView.addObject("time",new Date());
        return modelAndView;
    }


    @RequestMapping("/testrequestparam")
    public String testRequestParam(@RequestParam("city") String city){
        System.out.println("city " + city);
        return SUCCESS;
    }

    @RequestMapping(value = "/testparam/{name}",method = RequestMethod.GET)
    public String testParam(@PathVariable("name") String name){
        System.out.println("name " + name);
        return SUCCESS;
    }

    @RequestMapping("/hello")
    public String hello(){
        System.out.println("hello world");
        return "success";
    }

}
