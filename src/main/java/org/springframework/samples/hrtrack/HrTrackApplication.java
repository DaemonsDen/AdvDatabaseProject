
package org.springframework.samples.hrtrack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(proxyBeanMethods = false)
public class HrTrackApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrTrackApplication.class, args);
	}

}
