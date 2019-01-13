package com.soumyadeep.microservices.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface EmployeeSource {

	@Output("employeeRegistrationChannel")
	MessageChannel employeeRegistration();

}
