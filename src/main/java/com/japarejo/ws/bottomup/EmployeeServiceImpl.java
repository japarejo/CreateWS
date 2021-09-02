package com.japarejo.ws.bottomup;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.japarejo.ws.Employee;

@WebService(endpointInterface = "com.japarejo.ws.bottomup.EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {
     
    private EmployeeRepository employeeRepositoryImpl=new EmployeeRepository();

    
    public Employee getEmployee(Integer id) {
        return employeeRepositoryImpl.getEmployee(id);
    }

    
    public Employee updateEmployee(Employee emp) {
        return employeeRepositoryImpl.updateEmployee(emp.getId(), emp.getFirstName());
    }


    public boolean deleteEmployee(Integer id) {
        return employeeRepositoryImpl.deleteEmployee(id);
    }

    
    public Employee addEmployee(Employee emp) {
        return employeeRepositoryImpl.addEmployee(emp.getId(), emp.getFirstName());
    }

    
    public int countEmployees() {
        return employeeRepositoryImpl.count();
    }

    
    public List<Employee> getAllEmployees() {
        return employeeRepositoryImpl.getAllEmployees();
    }

}
