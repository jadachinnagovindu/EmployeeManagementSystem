package com.employeemanagementsystem;

public class Employee {
	int id;
	String name;
	String department;
	double salary;
	public Employee(int id,String name,String department,double salary)
	{
		this.id=id;
		this.name=name;
		this.department=department;
		this.salary=salary;
	}
	
	public void displayEmployee() {
        System.out.println("Employee ID : " + id);
        System.out.println("Name        : " + name);
        System.out.println("Department  : " + department);
        System.out.println("Salary      : " + salary);
        System.out.println("--------------------------");
    }




}
