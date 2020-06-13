package com.ifindn.controller;

import com.ifindn.controller.dao.EmployeeDao;
import com.ifindn.controller.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author Guo Yan
 * @date 2020/6/4-22:53
 */
@Controller
public class EmployeeHandler {

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value = "/testFormat",method = RequestMethod.POST)
    public String testFormat(Employee employee){
        System.out.println(employee);
        return "success";
    }

    @RequestMapping("/testconversion")
    public String testConservison(@RequestParam("employee") Employee employee){

        return "list";
    }

    @RequestMapping("/emps")
    public String getEmpsAll(Map<String,Object> map){

        map.put("employes",employeeDao.getAll());

        return "list";
    }

}
