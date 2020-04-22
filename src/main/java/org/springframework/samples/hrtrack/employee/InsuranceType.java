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
@Table(name = "insurancetypes")
public class InsuranceType extends BaseEntity {

	@Column(name = "insurancetype")
	@NotEmpty
	private int insurancetype;

	@Column(name = "name")
	@NotEmpty
	private String name;

	public @NotEmpty int getInsurancetype() {
		return this.insurancetype;
	}

	public void setFirstName(int newInsurancetype) {
		this.insurancetype = newInsurancetype;
	}

	public String getName() {
		return this.name;
	}

	public void setFirstName(String newName) {
		this.name = newName;
	}

}