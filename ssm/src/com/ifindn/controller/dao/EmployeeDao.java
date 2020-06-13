package com.ifindn.controller.dao;

import com.ifindn.controller.entity.Department;
import com.ifindn.controller.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Guo Yan
 * @date 2020/6/4-23:03
 */
@Repository
public class EmployeeDao {

    private static Map<Integer, Employee> employees = null;

    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<>();
        employees.put(1001,new Employee(1001,"E-AA","aa@163.com",1,new Department(101,"D-AA")));
        employees.put(1001,new Employee(1001,"E-BB","bb@163.com",1,new Department(101,"D-BB")));
        employees.put(1001,new Employee(1001,"E-CC","cc@163.com",0,new Department(101,"D-CC")));
        employees.put(1001,new Employee(1001,"E-DD","dd@163.com",0,new Department(101,"D-DD")));
        employees.put(1001,new Employee(1001,"E-EE","ee@163.com",1,new Department(101,"D-EE")));
    }

    private static Integer initId = 1006;

    public void save(Employee emp){
        if(emp.getId() == null){
            emp.setId(initId++);
        }
        emp.setDepartment(departmentDao.getDepartment(emp.getDepartment().getId()));
        employees.put(emp.getId(),emp);
    }

    public Collection<Employee> getAll(){
        return employees.values();
    }

    public Employee getEmp(Integer id){
        return employees.get(id);
    }

    public void  delete(Integer id){
        employees.remove(id);
    }



}
