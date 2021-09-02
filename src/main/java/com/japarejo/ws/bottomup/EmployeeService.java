package com.japarejo.ws.bottomup;


import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.japarejo.ws.Employee;

@WebService
public interface EmployeeService {
	
	@WebMethod
    public Employee getEmployee(Integer id);

    
    public Employee updateEmployee(Employee emp);

    
    public boolean deleteEmployee(Integer id);

    
    public Employee addEmployee(Employee emp);

    
    public int countEmployees();

    
    public List<Employee> getAllEmployees();
}
