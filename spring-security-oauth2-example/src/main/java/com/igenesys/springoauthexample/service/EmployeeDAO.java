package com.igenesys.springoauthexample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.igenesys.springoauthexample.model.BaseReturn;
import com.igenesys.springoauthexample.model.ResponseStatus;

@Repository
public class EmployeeDAO {

	@Autowired
    JdbcTemplate jdbcTemplate;
	
	public BaseReturn getEmployeeList(){
		 BaseReturn basereturn = null;
		 try {
			String sql = "select *from employee";
			 List result = jdbcTemplate.queryForList(sql);
			 ResponseStatus status = ResponseStatus.SUCCESS;
			 basereturn = new BaseReturn(status.name(), status.getValue(), result);
		} catch (Exception e) {
			ResponseStatus responseStatus = ResponseStatus.ERROR;
		    basereturn = new BaseReturn(responseStatus.name(),responseStatus.getValue());
		}
		 return basereturn;
	}
}
