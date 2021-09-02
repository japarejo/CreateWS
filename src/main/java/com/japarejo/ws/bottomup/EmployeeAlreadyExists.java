package com.japarejo.ws.bottomup;

import com.sun.xml.ws.util.exception.JAXWSExceptionBase;

public class EmployeeAlreadyExists extends JAXWSExceptionBase {
	public EmployeeAlreadyExists() {
        super("EmplExists","This employee already exists");
    }

    public EmployeeAlreadyExists(String str) {
        super("EmplExists",str);
    }

	@Override
	protected String getDefaultResourceBundleName() {
		return "";
	}
}
