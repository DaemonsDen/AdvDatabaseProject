package org.springframework.samples.hrtrack.employee;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Dependents {

	private List<Dependent> dependents;

	@XmlElement
	public List<Dependent> getDependentList() {
		if (dependents == null) {
			dependents = new ArrayList<>();
		}
		return dependents;
	}

}
