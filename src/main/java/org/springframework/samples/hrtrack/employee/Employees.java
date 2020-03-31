package org.springframework.samples.hrtrack.employee;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employees {

	private List<Employee> employees;

	@XmlElement
	public List<Employee> getEmployeeList() {
		if (employees == null) {
			employees = new ArrayList<>();
		}
		return employees;
	}

}
