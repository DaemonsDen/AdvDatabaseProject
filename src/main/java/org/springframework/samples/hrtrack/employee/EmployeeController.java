package org.springframework.samples.hrtrack.employee;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
class EmployeeController {

	private final EmployeeRepository employees;

	public EmployeeController(EmployeeRepository hrtrackService) {
		this.employees = hrtrackService;
	}

	@GetMapping("/employees.html")
	public String showEmployeeList(Map<String, Object> model) {
		Employees employees = new Employees();
		employees.getEmployeeList().addAll(this.employees.findAll());
		model.put("employees", employees);
		return "employees/employeeList";
	}

	@GetMapping({ "/employees" })
	public @ResponseBody Employees showResourcesEmployeeList() {
		Employees employees = new Employees();
		employees.getEmployeeList().addAll(this.employees.findAll());
		return employees;
	}

}
