package com.guxiang.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.guxiang.bean.Department;
import com.guxiang.bean.Employee;
import com.guxiang.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * EmployeeController
 *处理员工的增删改查
 *
 * @author guxiang
 * @date 2017/5/1
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    /**
     * 用于查询员工数据
     * @return
     */
   // @RequestMapping("/emps")
    public String getEmps(@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model){
        //使用pagehelper插件
        PageHelper.startPage(pn,5);

        List<Employee> emps = employeeService.getAll();

        //传入要连续显示的页数
        PageInfo page = new PageInfo(emps,5);
        model.addAttribute("pageInfo",page);
        return "list";
    }



    /**
     * 用于查询员工数据  使用json的方法
     * @return
     */

     @RequestMapping("/emps")
     @ResponseBody
    public List<Department> getEmpsWithJson(@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model){
        //使用pagehelper插件
        PageHelper.startPage(pn,5);

        List<Employee> emps = employeeService.getAll();

        //传入要连续显示的页数
        PageInfo page = new PageInfo(emps,5);

        List<Department> departments = new ArrayList<Department>();
         departments.add(new Department(1,"市场部"));
         departments.add(new Department(1,"市场部"));
         departments.add(new Department(1,"市场部"));
         departments.add(new Department(1,"市场部"));

        return departments;
    }
}
