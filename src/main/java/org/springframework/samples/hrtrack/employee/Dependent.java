package org.springframework.samples.hrtrack.employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.xml.bind.annotation.XmlElement;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.samples.hrtrack.model.BaseEntity;
import org.springframework.samples.hrtrack.model.Person;

@Entity
@Table(name = "employeedependents")
public class Dependent extends BaseEntity {

	@Column(name = "employee_num")
	@NotEmpty
	private int employeeNum;

	@Column(name = "first_name")
	@NotEmpty
	private String firstName;

	@Column(name = "last_name")
	@NotEmpty
	private String lastName;

	@Column(name = "DOB")
	@NotEmpty
	private String dateOfBirth;

	@Column(name = "SSN")
	@NotEmpty
	private String socialNum;

	/*
	 * public int getEmployeeId() { return this.employeeId; }
	 *
	 * public void setEmployeeId(int inEmployeeId) { this.employeeId = inEmployeeId; }
	 */

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
