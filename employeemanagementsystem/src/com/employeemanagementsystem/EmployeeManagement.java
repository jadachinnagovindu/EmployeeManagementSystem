package com.employeemanagementsystem;
import java.sql.ResultSet;
import java.util.Scanner;



public class EmployeeManagement {
	static Scanner sc=new Scanner(System.in);
	
	

	public static void main(String[] args) {
		while(true)
		{
			System.out.println("\n=========Employee Management System=======");
			System.out.println("1. Add Employee");
			System.out.println("2. Update Employee");
			System.out.println("3. Delete Employee");
			System.out.println("4. Search Employee");
			System.out.println("5. Display Employees");
			System.out.println("6. Exit");
			System.out.println("Enter your choice : ");
			
			int choice=sc.nextInt();
			
			switch(choice) 
			{
			case 1:
                addEmployee();
                break;

            case 2:
                updateEmployee();
                break;

            case 3:
                deleteEmployee();
                break;

            case 4:
                searchEmployee();
                break;

            case 5:
                displayEmployees();
                break;

            case 6:
                System.out.println("Thank you!");
                System.exit(0);

            default:
                System.out.println("Invalid choice!");
			}
		}
		
	}
	static void addEmployee() {
        System.out.println("Enter Employee Id");
        int id=sc.nextInt();
        System.out.println("Enter Employee Name");
        String name=sc.next();
        System.out.println("Enter Employee department");
        String department=sc.next();
        System.out.println("Enter Employee salary");
        double salary=sc.nextDouble();
        
        String sql="insert into employee VALUES (?,?,?,?)";
        try
        {
        	java.sql.Connection con=DBConnection.getConnection();
        	java.sql.PreparedStatement ps=con.prepareStatement(sql);
        	ps.setInt(1, id);
        	ps.setString(2, name);
        	ps.setString(3, department);
        	ps.setDouble(4, salary);
        	
        	ps.executeUpdate();
        	System.out.println("Employee Added Successfully");
        	con.close();
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        
    }

    static void updateEmployee() {
        System.out.println("Enter Employee Id to Upadte");
        int id=sc.nextInt();
        System.out.println("Enter New Name");
        String name=sc.next();
        System.out.println("Enter New Department");
        String department=sc.next();
        System.out.println("Enter new salary");
        double salary=sc.nextDouble();
        String sql="update employee set name=?, department=?, salary=? where id=?";
        
        try {
        	java.sql.Connection con=DBConnection.getConnection();
        	java.sql.PreparedStatement ps=con.prepareStatement(sql);
        	ps.setString(1, name);
        	ps.setString(2, department);
			ps.setDouble(3, salary);
        	ps.setInt(4, id);
        	
        	int rows=ps.executeUpdate();
        	if(rows>0)
        	{
        		System.out.println("Employee Updated Successfully..!");
        	}
        	else
        	{
        		System.out.println("Employees Not Found..!");
        	}
        	
        	con.close();
        	
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        
        
    }

    static void deleteEmployee() {
        System.out.println("Enter Employee Id to Delete");
       int id=sc.nextInt(); 
       String sql="delete from employee where id=?";
       try
       {
    	 java.sql.Connection con=DBConnection.getConnection(); 
    	 java.sql.PreparedStatement ps=con.prepareStatement(sql);
    	 ps.setInt(1, id);
    	 int rows=ps.executeUpdate();
    	 if(rows>0)
    	 {
    		 System.out.println("Employee Delete Successfully..!");
    	 }
    	 else
    	 {
    		 System.out.println("Employee Not Found..!");
    	 }
    	 
    	 con.close();
       }
       catch(Exception e)
       {
    	   e.printStackTrace();
       }
        
        
       
    }

    static void searchEmployee() {
        System.out.println("Enter Employee Id to Search");
        int id=sc.nextInt();
        String sql="select * from employee where id= ?";
        try {
        	java.sql.Connection con=DBConnection.getConnection();
        	java.sql.PreparedStatement ps=con.prepareStatement(sql);
        	ps.setInt(1, id);
        	java.sql.ResultSet rs=ps.executeQuery();
        	if(rs.next())
        	{
        		System.out.println("Employee Id :	"+rs.getInt("id"));
    			System.out.println("Name       :	"+rs.getString("name"));
    			System.out.println("Department :	"+rs.getString("department"));
    			System.out.println("Salary :	"+rs.getDouble("salary"));
        	}
        	else
        	{
        		System.out.println("Employee Not Found");
        	}
        	con.close();
        	
        }
        catch(Exception e)
        {
        	
        }
        
    }

    static void displayEmployees() {
    	
    	String sql="select * from employee";
    	
    	try {
    		java.sql.Connection con=DBConnection.getConnection();
        	java.sql.PreparedStatement ps=con.prepareStatement(sql);
        	ResultSet rs=ps.executeQuery();
    		
    		boolean found=false;
    		while(rs.next())
    		{
    			found=true;
    			System.out.println("Employee Id :	"+rs.getInt("id"));
    			System.out.println("Name       :	"+rs.getString("name"));
    			System.out.println("Department :	"+rs.getString("department"));
    			System.out.println("Salary :	"+rs.getDouble("salary"));
    			System.out.println("--------------------------");
    			
    		}
    		if(!found)
    		{
    			System.out.println("No Employee found");
    		}
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
       
    }

}
