package com.soumyadeep.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.soumyadeep.microservices.model.Employee;
import com.soumyadeep.microservices.source.EmployeeSource;

@RestController
@EnableBinding(EmployeeSource.class)
public class EmployeeController {
	
	@Autowired
	EmployeeSource employeeSource;
	
	@RequestMapping("/register")
	@ResponseBody
	public String orderFood(@RequestBody Employee employee) {
		
		employeeSource.employeeRegistration().send(MessageBuilder.withPayload(employee).build());
		System.out.println(employee.toString());
		return "Employee Registered";
	}
}
