package com.japarejo.ws.bottomup;

import com.sun.xml.ws.util.exception.JAXWSExceptionBase;

public class EmployeeNotFound extends JAXWSExceptionBase {
	public EmployeeNotFound() {
		super("EmpDontExits","The specified employee does not exist");
	}

	public EmployeeNotFound(String str) {
		super("EmpDontExits",str);
	}

	@Override
	protected String getDefaultResourceBundleName() {		
		return "";
	}
}
