package org.springframework.samples.hrtrack.employee;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InsuranceTypes {

	private List<InsuranceType> types;

	@XmlElement
	public List<InsuranceType> getInsuranceTypesList() {
		if (types == null) {
			types = new ArrayList<>();
		}
		return types;
	}

}
