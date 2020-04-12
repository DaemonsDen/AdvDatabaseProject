package org.springframework.samples.hrtrack.employee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

@Controller
class EmployeeController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	private final EmployeeRepository employeeRepo;

	private final DependentRepository dependentRepo;

	// private final InsuranceRepository insuranceRepo;
	// private final RoleRepository roleRepo;

	public EmployeeController(EmployeeRepository empRepo, DependentRepository depRepo) {
		this.employeeRepo = empRepo;
		this.dependentRepo = depRepo;
	}

	@GetMapping("/employees.html")
	public String showEmployeeList(Map<String, Object> model) {
		Employees employees = new Employees();
		employees.getEmployeeList().addAll(this.employeeRepo.findAll());
		model.put("employees", employees);
		return "employees/employeeList";
	}

	@GetMapping({ "/employees" })
	public @ResponseBody Employees showResourcesEmployeeList() {
		Employees employees = new Employees();
		employees.getEmployeeList().addAll(this.employeeRepo.findAll());
		return employees;
	}

	@GetMapping("/employeeOverview.html")
	public String showEmployeeOverview(Map<String, Object> model) {
		Employees employees = new Employees();
		employees.getEmployeeList().addAll(this.employeeRepo.findAll());
		model.put("employees", employees);
		return "employees/employeeDetails";
	}

	@GetMapping("editEmployee/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
		Employee employee = employeeRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));
		model.addAttribute("employee", employee);
		return "employees/employeeDetails";
	}

	@PostMapping("updateEmployee/{id}")
	public String updateEmployee(@PathVariable("id") int id, @Valid Employee employee, BindingResult result, Model model) {
		if (result.hasErrors()) {
			employee.setId(id);
			return "employeeOverview";
		}

		employeeRepo.save(employee);
		//model.addAttribute("employee", employeeRepo.findAll());
		//return "redirect:employees";
		return "redirect:../employees.html";
	}

	@PostMapping("editEmployee")
	public String editEmployee(@Valid Employee employee, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "employeeOverview";
		}

		employeeRepo.save(employee);
		model.addAttribute("employee", employeeRepo.findAll());
		//return "redirect:employees";
		return "employees";
	}

	@PostMapping("employeeOverview/{id}")
	public String updateStudent(@PathVariable("id") int id, @Valid Employee employee, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			employee.setId(id);
			return "employeeOverview";
		}

		employeeRepo.save(employee);
		model.addAttribute("employee", employeeRepo.findAll());
		return "employees/employeeDetails";
	}

	@GetMapping("/addEmployee.html")
	public String addEmployee(@Valid Employee employee, BindingResult result, Model model) {
		logger.warn("A WARN Message");

		if (result.hasErrors()) {
			return "employees/addNewEmployee";
		}

		employeeRepo.save(employee);
		return "redirect:employees.html";
	}

	@PostMapping("/addNewEmployee")
	public String addTheNewEmployee(@Valid Employee employee, BindingResult result, Model model) {
		logger.warn("A WARN Message");

		if (result.hasErrors()) {
			return "employees/addNewEmployee";
		}

		employeeRepo.save(employee);
		// return "redirect:list";
		return "redirect:employees.html";
	}

	@GetMapping("/addDependent.html")
	public String showAddDependent(Map<String, Object> model) {
		Employees employees = new Employees();
		employees.getEmployeeList().addAll(this.employeeRepo.findAll());
		model.put("employees", employees);
		return "employees/addNewDependent";
	}

	@GetMapping("/employeeBenefitsOverview.html")
	public String showEmployeeBenefits(Map<String, Object> model) {
		Employees employees = new Employees();
		employees.getEmployeeList().addAll(this.employeeRepo.findAll());
		model.put("employees", employees);
		return "employees/employeeBenefits";
	}

	@GetMapping("editBenefits/{id}")
	public String showBenefitsForm(@PathVariable("id") int id, Model model) {
		Employee employee = employeeRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));
		model.addAttribute("employee", employee);
		return "employees/employeeDetails";
	}

}
