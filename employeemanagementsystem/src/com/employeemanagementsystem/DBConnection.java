package com.employeemanagementsystem;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    	static String url="jdbc:mysql://localhost:3306/employee_db";
		static String username="root";
		static String  password="root";
		
		public static Connection getConnection()
		{
		    Connection con = null;

		    try
		    {
		        Class.forName("com.mysql.cj.jdbc.Driver");

		        con = DriverManager.getConnection(url, username, password);

		        System.out.println("Database Connection Successfully..!");
		    }
		    catch(Exception e)
		    {
		        e.printStackTrace();
		    }

		    return con;
		}
		

	

}
