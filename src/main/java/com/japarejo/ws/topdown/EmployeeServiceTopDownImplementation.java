package com.japarejo.ws.topdown;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.japarejo.ws.topdown.generated.EmployeeServiceTopDown;


@WebService(
		  name = "EmployeeServiceTopDown", 
		  endpointInterface = "com.japarejo.ws.topdown.generated.EmployeeServiceTopDown",
		  targetNamespace = "http://topdown.server.jaxws.baeldung.com/")
public class EmployeeServiceTopDownImplementation implements EmployeeServiceTopDown{

	@Override
	@WebMethod
	public int countEmployees() {		
		return 0;
	}

}
