package com.japarejo.ws;

public class Employee {

	private int id;
	private String firstName;

	public Employee() {
		this(0,"");
	}
	
	public Employee(int id, String firstName) {
		super();
		this.id = id;
		this.firstName = firstName;
	}

	public int getId() {
		return id;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}
