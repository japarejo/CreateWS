package com.japarejo.ws.bottomup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.japarejo.ws.Employee;

public class EmployeeRepository {
	Map<Integer, Employee> repo;
	Integer max;

	public EmployeeRepository() {
		repo = new HashMap<Integer, Employee>();
		max = 0;
		initializeRepo();
	}

	private void initializeRepo() {
		addEmployee(1, "japarejo");
		addEmployee(2, "Jack");
		addEmployee(3, "George");
	}

	public Employee getEmployee(int id) {
		return repo.get(id);
	}

	public Employee updateEmployee(int id, String name) {
		Employee e = getEmployee(id);
		if (e != null)
			e.setFirstName(name);
		return e;
	}

	public boolean deleteEmployee(int id) {
		boolean result = getEmployee(id) != null;
		repo.remove(id);
		return result;
	}

	public Employee addEmployee(int id, String name) {
		repo.put(id, new Employee(id, name));
		if (id > max)
			max = id;
		return getEmployee(id);
	}

	public List<Employee> getAllEmployees() {
		return new ArrayList<Employee>(repo.values());
	}

	public int count() {
		return repo.size();
	}

}
