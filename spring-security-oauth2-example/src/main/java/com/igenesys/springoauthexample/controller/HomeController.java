package com.igenesys.springoauthexample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.igenesys.springoauthexample.model.BaseReturn;
import com.igenesys.springoauthexample.service.EmployeeDAO;

@Controller
public class HomeController {
    @Autowired
	EmployeeDAO empdao;
    
    @RequestMapping(value = "/user/", method = RequestMethod.GET)
    public @ResponseBody BaseReturn getEmployees(){
    	System.out.println("/user/ service called....");
    	return empdao.getEmployeeList();
    }
}
