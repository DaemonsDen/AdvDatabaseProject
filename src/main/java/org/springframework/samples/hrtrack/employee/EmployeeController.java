package org.springframework.samples.hrtrack.employee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

@Controller
class EmployeeController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	private final EmployeeRepository employeeRepo;

	private final DependentRepository dependentRepo;

	private final InsuranceTypeRepository insuranceTypeRepo;

	// private final InsuranceRepository insuranceRepo;
	// private final RoleRepository roleRepo;

	public EmployeeController(EmployeeRepository empRepo, DependentRepository depRepo,
			InsuranceTypeRepository insRepo) {
		this.employeeRepo = empRepo;
		this.dependentRepo = depRepo;
		this.insuranceTypeRepo = insRepo;
	}

	@ModelAttribute("insuranceTypes")
	public Collection<InsuranceType> populateInsuranceTypes() {
		return this.insuranceTypeRepo.findAll();
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
		Employee employee;
		if(id == 0)
		{
			employee = new Employee();
		}
		else
		{
			employee = employeeRepo.findById(id);
		}

		model.addAttribute("employee", employee);
		return "employees/employeeDetails";
	}
	
	@PostMapping("updateEmployee/")
	public String updateNewEmployee( @Valid Employee employee, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "employeeOverview";
		}

		employeeRepo.save(employee);
		// model.addAttribute("employee", employeeRepo.findAll());
		// return "redirect:employees";
		return "redirect:../employees.html";
	}

	@PostMapping("updateEmployee/{id}")
	public String updateEmployee(@PathVariable("id") int id, @Valid Employee employee, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			employee.setId(id);
			return "employeeOverview";
		}

		employeeRepo.save(employee);
		// model.addAttribute("employee", employeeRepo.findAll());
		// return "redirect:employees";
		return "redirect:../employees.html";
	}

	@PostMapping("editEmployee")
	public String editEmployee(@Valid Employee employee, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "employeeOverview";
		}

		employeeRepo.save(employee);
		model.addAttribute("employee", employeeRepo.findAll());
		// return "redirect:employees";
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
	public String showBenefitsForm(@PathVariable("id") int id, Map<String, Object> model) {
		InsuranceTypes HealthInsurances = new InsuranceTypes();
		HealthInsurances.getInsuranceTypesList().addAll(this.insuranceTypeRepo.findByInsurancetype(1));
		model.put("healthInsurance", HealthInsurances);

		InsuranceTypes DentalInsurances = new InsuranceTypes();
		DentalInsurances.getInsuranceTypesList().addAll(this.insuranceTypeRepo.findByInsurancetype(2));
		model.put("dentalInsurance", DentalInsurances);

		InsuranceTypes VisionInsurances = new InsuranceTypes();
		VisionInsurances.getInsuranceTypesList().addAll(this.insuranceTypeRepo.findByInsurancetype(3));
		model.put("visionInsurance", VisionInsurances);

		Employee emp = new Employee();
		emp = employeeRepo.findById(id);
		model.put("employee", emp);

		return "employees/employeeBenefits";
	}

	@GetMapping("dependentListOverview/{id}")
	public String showEmployeeDependents(@PathVariable("id") int id, Map<String, Object> model) {
		Dependents dependents = new Dependents();
		dependents.getDependentList().addAll(this.dependentRepo.findByEmployeeNum(id));
		model.put("dependents", dependents);

		return "employees/dependentList";
	}

	@PostMapping("employees/updateInsurance/{id}")
	public String updateEmployeeInsurance(@PathVariable("id") int id, @Valid Employee emp, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "employeeOverview";
		}

		Employee targetEmp = employeeRepo.findById(id);
		targetEmp.setHealthInsurance(emp.getHealthInsurance());

		employeeRepo.save(targetEmp);
		// model.addAttribute("employee", employeeRepo.findAll());
		// return "redirect:employees";
		return "redirect:../../employees.html";
	}

}
