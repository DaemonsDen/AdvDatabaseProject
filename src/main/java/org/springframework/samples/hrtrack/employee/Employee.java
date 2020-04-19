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
@Table(name = "employees")
public class Employee extends BaseEntity {

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "health_insurance")
	private int healthInsurance;

	@Column(name = "dental_insurance")
	private int dentalInsurance;

	@Column(name = "vision_insurance")
	private int visionInsurance;

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

	public int getHealthInsurance() {
		return this.healthInsurance;
	}

	public void setHealthInsurance(int newType) {
		this.healthInsurance = newType;
	}

	public int getDentalInsurance() {
		return this.dentalInsurance;
	}

	public void setDentalInsurance(int newType) {
		this.dentalInsurance = newType;
	}

	public int getVisionInsurance() {
		return this.visionInsurance;
	}

	public void setVisionInsurance(int newType) {
		this.visionInsurance = newType;
	}

}
